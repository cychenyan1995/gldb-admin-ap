<template>
  <div class="row border-bottom">
    <nav class="navbar navbar-static-top white-bg" role="navigation">
      <div class="navbar-header">
        <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " @click="toggleNavigation" href="#"><i
          class="fa fa-bars"></i> </a>
      </div>
      <ul class="nav navbar-top-links navbar-right">
        <li>
          <a href="#">
            <i class="fa fa-sign-out"></i> 退 出
          </a>
        </li>
      </ul>
    </nav>
  </div>
</template>
<script>
import { smoothlyMenu } from '../../../components/layouts/Helpers';
export default {
  methods: {
    toggleNavigation (e) {
      e.preventDefault();
      $('body').toggleClass('mini-navbar');
      smoothlyMenu();
    }
  }
};
</script>
