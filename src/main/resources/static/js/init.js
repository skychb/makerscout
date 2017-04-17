(function($){
  $(function(){

    $('.button-collapse').sideNav();
    $('.parallax').parallax();
    $('.carousel').carousel();
    if($('#nav-mobile').css('display')== 'none'){
      $('.history-caption').removeClass('offset-s1');
    };
  }); // end of document ready
})(jQuery); // end of jQuery name space