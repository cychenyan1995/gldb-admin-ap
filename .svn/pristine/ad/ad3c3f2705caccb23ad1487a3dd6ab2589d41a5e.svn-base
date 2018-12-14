export default {
  deleteBreadcrumbStyle () {
    // 删除 Breadcrumb 自带的样式
    let section = $('.breadcrumbs__section a');

    if (section.length === 0) {
      // section = $('.breadcrumb .active');
      let menuGrap = $('nav[role="navigation"]').find('li[class="active"]');
      if (menuGrap.find('.nav-second-level') !== null) {
        let parendMenu = menuGrap.find('a')[0];
        if (parendMenu !== null && typeof (parendMenu) !== 'undefined') {
          // console.log(parendMenu.text);
          $('.crumbs').remove();
          $('.breadcrumb').empty();
          $('.breadcrumb').prepend('<li>主页</li>');
          $('.breadcrumb').append('<li class="active"><strong>' + parendMenu.text + '</strong></li>');
          let menu = menuGrap.find('.active');
          if (menu.length > 0) {
            $('.breadcrumb').append('<li class="active"><strong>' + menu.text() + '</strong></li>');
          }
        }
      }
    } else {
      $('.crumbs').remove();
      $('.breadcrumb').empty();
      $('.breadcrumb').prepend('<li>主页</li>');
      section.each(function (index) {
        // console.log($(this).text());
        $('.breadcrumb').append('<li class="active"><strong>' + $(this).text() + '</strong></li>');
      });
    }
  }
};
