<template>
  <div id="wrapper">
    <Progress/>
    <SideBar/>
    <div id="page-wrapper" v-bind:class="wrapperClass">
      <div class="header">
        <Header/>
        <Breadcrumb/>
      </div>
      <div id="content" class="row">
        <el-container>
          <el-main>
            <router-view/>
          </el-main>
        </el-container>
      </div>
      <Footer/>
    </div>
  </div>
</template>
<script>
import Progress from './Progress';
import SideBar from './SiderBar';
import Header from './Header';
import Breadcrumb from './Breadcrumb';
import Footer from './Footer';
import {correctHeight, detectBody} from '../../../components/layouts/Helpers';

export default {
  computed: {
    wrapperClass: function () {
      // let wrapperClass = 'gray-bg ' + this.props.history.location.pathname;
      return 'gray-bg';
    }
  },
  mounted: function () {
    // Run correctHeight function on load and resize window event
    $(window).bind('load resize', function () {
      correctHeight();
      detectBody();
    });

    // Correct height of wrapper after metisMenu animation.
    $('.metismenu a').click(() => {
      setTimeout(() => {
        correctHeight();
      }, 300);
    });
  },
  components: {
    Progress: Progress,
    SideBar: SideBar,
    Header: Header,
    Breadcrumb: Breadcrumb,
    Footer: Footer
  }
};
</script>
