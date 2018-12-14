<template>
  <div class="row breadcrumbbar">
    <div class="col-lg-12">
      <ol class="breadcrumb">
        <li v-for="(item,index) in breadList" :key="item.id" separator="/" :to="{ path: item.path }" v-if="index==0">{{item.name}}</li>
        <li class="active" v-for="(item,index) in breadList" :key="item.id" separator="/" :to="{ path: item.path }" v-if="index>0">
          <strong>
            {{item.name}}
          </strong>
        </li>
      </ol>
    </div>
  </div>
</template>

<script>
export default {
  created () {
    this.getBreadcrumb();
  },
  data () {
    return {
      breadList: [] // 路由集合
    };
  },
  methods: {
    setParentTitle (breadNumber) {
      if (breadNumber === 2) {
        var routes = this.$router.options.routes;
        for (var index = 0; index < routes.length; index++) {
          var router = routes[index];
          var children = router.children;
          if (typeof (children) !== 'undefined') {
            for (var i = 0; i < children.length; i++) {
              var path = router.path + '/' + children[i].path;
              if (this.$route.fullPath === path) {
              // console.log(path);
              // 设置父路由
                this.$options.methods.pushBread.bind(this)(router, null);
              }
            }
          }
        }
      }
    },
    pushBread (router, breadNumber) {
      var newBread = {name: router.meta.title, path: router.path};
      // 获取breadList数组
      var breadList = this.$store.getters['common/breadListState'];

      if (breadNumber === null) {
        breadList.splice(1, 1, newBread);
      } else if (breadNumber >= 1) {
        breadList.splice(breadNumber, breadList.length - breadNumber, newBread);
      }

      breadList = JSON.stringify(breadList);
      this.$store.commit('common/breadListMutations', breadList);
      this.breadList = this.$store.getters['common/breadListState'];
    },
    getBreadcrumb () {
      // 默认为1
      var breadNumber = typeof (this.$route.meta.breadNumber) !== 'undefined' ? this.$route.meta.breadNumber : 0;

      // 设置父级别Bread
      this.$options.methods.setParentTitle.bind(this)(breadNumber);

      // 当前页面的Bread
      this.$options.methods.pushBread.bind(this)(this.$route, breadNumber);
    }
  },
  watch: {
    // "$route": "getBreadcrumb"
    $route () {
      this.getBreadcrumb();
    }
  }
};
</script>
