$(document).ready(function() {

  Handlebars.registerHelper('getTime', function (timestamp){
    var t = new Date(timestamp).toString();
    var list = t.split(" ");
    var final = "";
    final += list[1] + " ";
    final += list[2] + " ";
    final += list[4];
    return final;
  });

  Handlebars.registerHelper('getImage', function (url){
    // var pattern = /"([^"]*)[.png|.jpg|.jpeg|.gif]"/g;
    // var result = pattern.exec(url);
    var arrList = url.split("\"");
    console.log(arrList);
    for( var i = 0 ; i<arrList.length; i++){
      var value = arrList[i];
      console.log(value.substr(value.length-8, value.length));
      if(value.substr(value.length-8, value.length) == "img src="){
        return arrList[i+1];
      }
    }
    return "http://upload2.inven.co.kr/upload/2015/05/15/bbs/i13359164428.png";
    });

  Handlebars.registerHelper('deleteHtml', function(html1){
    var pattern = /(<([^>]+)>)/ig;
    var result = html1.replace(pattern, "");
    if(result.length > 18){
          return result.substring(0, 18) + "...";
    }
    return result;
  });
 
  var template = $('#post-template').html();
  var template_up = Handlebars.compile(template);

	jQuery.fn.extend({
        toggleText: function (a, b){
            var isClicked = false;
            var that = this;
            this.click(function (){
                if (isClicked) { that.text(a); isClicked = false; }
                else { that.text(b); isClicked = true; }
            });
            return this;
        }
    });

	var text = $("#clickForSlide").text();
	$(".hiding").css("display", "none");

	$('#clickForSlide').click(function() {
		$(".hiding").slideToggle("slow", function() {		
		});
	});

  $('#clickForSlide').toggleText("더보기", "접기");

  $('.numbering').each(function() {
				var $this = $(this), countTo = $this.attr('data-count');

				$({
					countNum : $this.text()
				}).animate({
					countNum : countTo
				},
				{
					duration : 2000,
					easing : 'linear',
					step : function() {
						$this.text(Math.floor(this.countNum));
					},
					complete : function() {
						$this.text(this.countNum);
						// alert('finished');
					}

				});

			});

      $.ajax({
				url : "/post/list",
				type : "GET",
				dataType : 'json',
				success : function(data) {
          var posts = {};
          posts["data"] = data;
          var templates = template_up(posts);
          console.log(posts);
					$('#postList').prepend(templates);
				}
			});
});