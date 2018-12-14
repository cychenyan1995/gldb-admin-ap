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
      <li v-for="(item) in menuList" :key="item.id" :level="item.level" :id="item.name" v-if="item.level==1" @click="activeType(item.name,item.level,$event)">
        <router-link :to="{ name: item.name }" v-if="item.leaf==0">
          <i class="fa fa-cubes"></i>
          <span class="nav-label">{{item.lable}}</span>
          <span v-if="item.leaf==1" class="fa arrow"></span>
        </router-link>
        <a v-if="item.leaf==1" @click="activeType(item.name,item.level,$event)">
          <i class="fa fa-folder"></i>
          <span class="nav-label">{{item.lable}}</span>
          <span class="fa arrow"></span>
        </a>
        <ul v-if="item.leaf==1" class="nav nav-second-level collapse">
          <li v-for="(subItem) in menuList" :key="subItem.id" v-if="subItem.parentId === item.id" :level="subItem.level" :id="subItem.name" @click="activeType(item.name,item.level,$event)">
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
// import util from '../../../components/utils/Breadcrumb/breadcrumb.js';
export default {
  data () {
    return {
      menuList: [{id: 1, parentId: 0, level: 1, name: 'Console', lable: '控制视图', leaf: 0},
        {id: 2, parentId: 0, level: 1, name: 'Sample', lable: '简单视图', leaf: 0},
        {id: 3, parentId: 0, level: 1, name: 'Test', lable: '模拟例子', leaf: 1},
        {id: 4, parentId: 3, level: 2, name: 'Table', lable: '列表视图', leaf: 0},
        {id: 5, parentId: 3, level: 2, name: 'Chart', lable: '报表视图', leaf: 0}]
    };
  },
  computed: {

  },
  methods: {
    activeRoute (routeName, event) {
      var clickObj = $(event.currentTarget).find(routeName);
      $('#side-menu').find('li[level="1"]').each(function () {
        $(this).removeClass('active');
        if (typeof ($(this).find('ul')) !== 'undefined') {
          var subMenu = $(this).find('ul')[0];
          if (typeof (subMenu) !== 'undefined') {
            $(subMenu).removeClass('in');
          }
        }
      });

      $('#side-menu').find('li[level="2"]').each(function () {
        $(this).removeClass('active');
      });

      clickObj.prevObject.addClass('active');

      var subMenu = clickObj.prevObject.find('ul')[0];
      if (typeof (subMenu) !== 'undefined') {
        $(subMenu).addClass('in');
      } else {
        subMenu = clickObj.prevObject.find(routeName);
        if (typeof (subMenu) !== 'undefined') {
          subMenu.prevObject.addClass('active');
          subMenu.prevObject.parent().parent().addClass('active');
        }
      }
      // util.deleteBreadcrumbStyle();
    },
    collapse (routeName, event) {
      var clickObj = $(event.currentTarget).find(routeName);
      var subMenu = clickObj.prevObject.find('ul')[0];
      if (typeof (subMenu) !== 'undefined') {
        if ($(subMenu).hasClass('in')) {
          $(subMenu).removeClass('in');
        } else {
          $(subMenu).addClass('in');
        }
      }
    },
    activeType (name, level, event) {
      switch (level) {
        case 1:
          return this.$options.methods.activeRoute.bind(this)(name, event);
        case 2:
          return this.$options.methods.collapse.bind(name, event);
        default:
          break;
      }
    }
  },
  mounted: function () {
    // const display = this.$route.path.indexOf(routeName) > -1 ? 'active' : '';
    // 页面刷新的情况
    var url = window.location.pathname;
    var activeObj = $('a[href="' + url + '"]');
    // console.log(url);
    activeObj.parent().addClass('active');
    if (activeObj.parent().attr('level') === '2') {
      activeObj.parent().parent().addClass('in');
      activeObj.parent().parent().parent().addClass('active');
    }
    // util.deleteBreadcrumbStyle();
  }
};
</script>
