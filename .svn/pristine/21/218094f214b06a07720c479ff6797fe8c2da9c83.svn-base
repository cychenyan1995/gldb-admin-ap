<template>
  <nav class="navbar-default navbar-static-side" role="navigation">
    <ul class="nav metismenu" id="side-menu" ref="menu">
      <li class="nav-header">
        <div class="dropdown profile-element"> <span>
                             </span>
          <a data-toggle="dropdown" class="dropdown-toggle" href="#">
              <span class="clear"> <span class="block m-t-xs">
                <strong class="font-bold">用 户</strong>
              </span>
                <span class="text-muted text-xs block">
                  huangzz <!-- b class="caret"></b-->
                </span>
              </span>
          </a>
          <ul class="dropdown-menu animated fadeInRight m-t-xs">
            <li><a href="#"> 退 出</a></li>
          </ul>
        </div>
        <div class="logo-element">
        </div>
      </li>
      <li v-for="(item) in menuList" :key="item.id" :level="item.level" :id="item.name" v-if="item.level==1" :class="{ active: item.active }">
        <router-link :to="{ name: item.name }" v-if="item.leaf==0">
          <i class="fa fa-cubes"></i>
          <span class="nav-label">{{item.lable}}</span>
          <span v-if="item.leaf==1" class="fa arrow"></span>
        </router-link>
        <a v-if="item.leaf==1" @click="collapse(item.name)">
          <i class="fa fa-folder"></i>
          <span class="nav-label">{{item.lable}}</span>
          <span class="fa arrow"></span>
        </a>

        <a v-if="item.leaf==2" @click="collapse(item.name)">
          <i class="fa fa-plane"></i>
          <span class="nav-label">{{item.lable}}</span>
          <span class="fa arrow"></span>
        </a>
        <a v-if="item.leaf==3" @click="collapse(item.name)">
          <i class="fa fa-navicon"></i>
          <span class="nav-label">{{item.lable}}</span>
          <span class="fa arrow"></span>
        </a>
        <a v-if="item.leaf==4" @click="collapse(item.name)">
          <i class="fa fa-server"></i>
          <span class="nav-label">{{item.lable}}</span>
          <span class="fa arrow"></span>
        </a>
        <a v-if="item.leaf==5" @click="collapse(item.name)">
          <i class="fa fa-cogs"></i>
          <span class="nav-label">{{item.lable}}</span>
          <span class="fa arrow"></span>
        </a>
        <ul v-if="item.leaf!==0" class="nav nav-second-level collapse" v-bind:class="{ in: !item.collapse }">
          <li v-for="(subItem) in menuList" :key="subItem.id" v-if="subItem.parentId === item.id" :level="subItem.level" :id="subItem.name" :class="{ active: subItem.active }">
            <router-link :to="{ name: subItem.name }">
              <i class="ng-binding"></i>
              <span class="nav-label">{{subItem.lable}}</span>
            </router-link>
          </li>
        </ul>
      </li>
    </ul>
  </nav>
</template>
<script>
import { mapState } from 'vuex';
export default {
  computed: mapState({
    menuList: state => state.common.menuListState
  }),
  methods: {
    activeRoute () {
      this.$store.dispatch('common/activeRoute', {router: this.$router});
    },
    collapse (routeName) {
      this.$store.dispatch('common/collapse', {name: routeName});
    }
  },
  mounted: function () {
    this.$store.dispatch('common/activeRoute', {router: this.$router});
    var path;
    if (typeof (this.$router.history.pending) !== 'undefined' && this.$router.history.pending !== null) {
      path = this.$router.history.pending.path;
    } else {
      path = this.$router.history.current.path;
    }
    var routerName = path.substring(1, path.lastIndexOf('/'));
    this.$store.dispatch('common/collapse', {name: routerName});
  },
  // 监听,当路由发生变化的时候执行
  watch: {
    $route (to, from) {
      // console.log(to.path);
      this.activeRoute();
    }
  }
};
</script>
