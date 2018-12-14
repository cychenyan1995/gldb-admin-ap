import Vue from 'vue';

Vue.component('Blank', {
  mounted: function () {
    $('body').addClass('gray-bg');
  },
  destroy: function () {
    $('body').removeClass('gray-bg');
  },
  template: ' <div>{{this.props.children}}</div>'
})
