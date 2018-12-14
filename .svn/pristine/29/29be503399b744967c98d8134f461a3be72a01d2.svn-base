<template>
  <nav class="navbar-default navbar-static-side" role="navigation">
    <ul class="nav metismenu" id="side-menu" ref="menu">
      <li class="nav-header">
        <div class="dropdown profile-element"> <span>
                             </span>
          <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs">
                                <strong class="font-bold">用 户</strong>
                             </span> <span class="text-muted text-xs block">huangzz<b
                              class="caret"></b></span> </span> </a>
          <ul class="dropdown-menu animated fadeInRight m-t-xs">
            <li><a href="#"> 退 出</a></li>
          </ul>
        </div>
        <div class="logo-element">
        </div>
      </li>
      <li level="1" id="Console" @click="activeRoute('Console',$event)">
        <router-link :to="{ name: 'Console' }">
          <i class="fa fa-cubes"></i>
          <span class="nav-label">控制视图</span>
          <span class="fa arrow"></span>
        </router-link>

      </li>
      <li level="1" id="Sample" @click="activeRoute('Sample',$event)">
        <router-link :to="{ name: 'Sample' }">
          <i class="fa fa-th-large"></i>
          <span class="nav-label">简单视图</span>
          <span class="fa arrow"></span>
        </router-link>
      </li>
      <li level="1" id="Test" @click="collapse('Test',$event)">
        <a>
          <i class="fa fa-folder"></i>
          <span class="nav-label">模拟例子</span>
          <span class="fa arrow"></span>
        </a>
        <ul class="nav nav-second-level collapse">
          <li level="2" id="Table" @click="activeRoute('Table',$event)">
            <router-link :to="{ name: 'Table' }">
              <i class="ng-binding"></i> <span
              class="nav-label">列表视图</span>
            </router-link>
          </li>
          <li level="2" id="Chart" @click="activeRoute('Chart',$event)">
            <router-link :to="{ name: 'Chart' }">
              <i class="ng-binding"></i>
              <span class="nav-label">报表视图</span>
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
