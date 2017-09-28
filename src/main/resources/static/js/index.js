$(document)
		.ready(
				function() {

					Handlebars.registerHelper('getTime', function(timestamp) {
						var t = new Date(timestamp).toString();
						var list = t.split(" ");
						var final = "";
						final += list[1] + " ";
						final += list[2] + " ";
						final += list[4];
						return final;
					});

					Handlebars
							.registerHelper(
									'getImage',
									function(url) {
										// var pattern =
										// /"([^"]*)[.png|.jpg|.jpeg|.gif]"/g;
										// var result = pattern.exec(url);
										var arrList = url.split("\"");
										console.log(arrList);
										for (var i = 0; i < arrList.length; i++) {
											var value = arrList[i];
											console.log(value.substr(
													value.length - 8,
													value.length));
											if (value.substr(value.length - 8,
													value.length) == "img src=") {
												return arrList[i + 1];
											}
										}
										return "https://pbs.twimg.com/media/DHslv-iXgAIT7Q-.jpg";
									});

					Handlebars.registerHelper('deleteHtml', function(html1) {
						var pattern = /(<([^>]+)>)/ig;
						var result = html1.replace(pattern, "");
						if (result.length > 18) {
							return result.substring(0, 18) + "...";
						}
						return result;
					});

					var template = $('#post-template').html();
					var template_up = Handlebars.compile(template);
					var source = $('#list-template').html();
					var list_template = Handlebars.compile(source);
					var modalSource = $('#modal-template').html();
					var modal_template = Handlebars.compile(modalSource);
					jQuery.fn.extend({
						toggleText : function(a, b) {
							var isClicked = false;
							var that = this;
							this.click(function() {
								if (isClicked) {
									that.text(a);
									isClicked = false;
								} else {
									that.text(b);
									isClicked = true;
								}
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

					$('.numbering').each(
							function() {
								var $this = $(this), countTo = $this
										.attr('data-count');

								$({
									countNum : $this.text()
								}).animate({
									countNum : countTo
								}, {
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
						url : "/notice/list",
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

					$.ajax({
						url : "/team/list",
						type : "GET",
						dataType : 'json',
						success : function(data){
							data.forEach(function(item){
								var template = list_template(item);	
								if(item.id <= 3){
									$('#firstLine').append(template);
								} else if(item.id <= 6) {
									$('#secondLine').append(template);
								} else if(item.id <= 9) {
									$('#thirdLine').append(template);
								} else if(item.id <= 12) {
									$('#fourthLine').append(template);
								} else{
									$('#fifthLine').append(template);
								}
							});
						}
					});

					$.ajax({
						url : "/team/list",
						type : "GET",
						dataType : 'json',
						success : function(data){
							data.forEach(function(item){
								var template = modal_template(item);	
								$('body').prepend(template);
							});
							
						}
					});

					// FB.api(
					// 	"/997490530279736/likes",
					// 	function (response) {
					// 	  if (response && !response.error) {
					// 		console.log(response);
					// 	  }
					// 	}
					// );

					// $('#ready1').click(function(){
					// 	console.log("asdf");
					// 	$('#modal1').addClass("is-active");
					// });
					// for(var i = 1 ; i < 16 ; i++){
					// 	$('#'+i).click(function(){
					// 		$('#modal'+i).addClass("is-active");
					// 	})
					// };
				});
$(document).ajaxComplete(function(){
	$('#ready1').click(function(){
		$('#modal1').addClass("is-active");
	});
	$('#ready2').click(function(){
		$('#modal2').addClass("is-active");
	});
	$('#ready3').click(function(){
		$('#modal3').addClass("is-active");
	});
	$('#ready4').click(function(){
		$('#modal4').addClass("is-active");
	});
	$('#ready5').click(function(){
		$('#modal5').addClass("is-active");
	});
	$('#ready6').click(function(){
		$('#modal6').addClass("is-active");
	});
	$('#ready7').click(function(){
		$('#modal7').addClass("is-active");
	});
	$('#ready8').click(function(){
		$('#modal8').addClass("is-active");
	});
	$('#ready9').click(function(){
		$('#modal9').addClass("is-active");
	});
	$('#ready10').click(function(){
		$('#modal10').addClass("is-active");
	});
	$('#ready11').click(function(){
		$('#modal11').addClass("is-active");
	});
	$('#ready12').click(function(){
		$('#modal12').addClass("is-active");
	});
	$('#ready13').click(function(){
		$('#modal13').addClass("is-active");
	});
	$('#ready14').click(function(){
		$('#modal14').addClass("is-active");
	});
	$('#ready15').click(function(){
		$('#modal15').addClass("is-active");
	});
	$('.delete').click(function(){
		$('.modal').removeClass("is-active");
	})
})