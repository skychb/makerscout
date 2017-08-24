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
										return "http://upload2.inven.co.kr/upload/2015/05/15/bbs/i13359164428.png";
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

					var teamData = {
						teamData : [
						{"id" : 1, "teamName" : "EDM", "school" : "대전 하기중학교", "member" : "김준성, 한승연, 류태훈, 박지윤, 정주은"},
						{"id" : 2, "teamName" : "젤라토레", "school" : "유성여자고등학교", "member" : "전다은, 김유진, 정나영, 심예슬"},
						{"id" : 3, "teamName" : "MS", "school" : "서울로봇고등학교", "member" : "노신행, 임형섭, 이정민, 장현성, 최성호, 김지우"},
						{"id" : 4, "teamName" : "우연히", "school" : "불곡고등학교", "member" : "주기쁨, 김예담, 김민경, 염수연"},
						{"id" : 5, "teamName" : "보니따", "school" : "서울국제고등학교", "member" : "강혜수, 임서영, 김채현, 임선아"},
						{"id" : 6, "teamName" : "겜잘알", "school" : "석호중학교", "member" : "정성욱, 김시우, 김예준, 장승환, 박연서, 김승현"},
						{"id" : 7, "teamName" : "슬러시", "school" : "예봉중학교", "member" : "박지훈, 박홍준, 유주형, 박용준"},
						{"id" : 8, "teamName" : "공감 요정들", "school" : "경기모바일과학고등학교", "member" : "김요셉, 문요한, 김진우, 박승우, 정우성, 강이찬"},
						{"id" : 9, "teamName" : "YUM", "school" : "이천양정여자고등학교", "member" : "안선영, 장주희, 이수미, 정미영"},
						{"id" : 10, "teamName" : "정조, 암흑에 서다", "school" : "수성고등학교", "member" : "백어진, 김윤수, 최혁수, 홍성익"},
						{"id" : 11, "teamName" : "VISION", "school" : "고양외국어고등학교", "member" : "조은아, 김비, 김민서, 김서영, 유지원"}, 
						{"id" : 12, "teamName" : "베이커스", "school" : "불곡고등학교", "member" : "김현민, 이하준, 왕서윤, 전기주, 김자은, 손서연"},
						{"id" : 13, "teamName" : "UNIT:A-PES", "school" : "하남고등학교", "member" : "채현수, 이병현, 임인우, 박선우, 강주원"},
						{"id" : 14, "teamName" : "걸크러시", "school" : "홍천고등학교", "member" : "권예진, 송수빈, 신서영, 허지현, 부석진, 임은지"},
						{"id" : 15, "teamName" : "쿼터백s", "school" : "도장중학교", "member" : "김승수, 김범준, 박성우, 이준서, 김동민, 이정연"},
					]};
					var source = $('#list-template').html();
					var list_template = Handlebars.compile(source);
					var html = list_template(teamData);
					$('footer').append(html);
				});