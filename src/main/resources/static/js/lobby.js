// var source = $('#entry-template').html();
// var template = Handlebars.compile(source);
var stompClient = null;

/*
 * <article class="media"> <div class="media-left"> <figure class="image
 * is-64x64"> <img src="http://bulma.io/images/placeholders/128x128.png"
 * alt="Image"> </figure> </div> <div class="media-content"> <div
 * class="content"> <p> <strong>{{name}}</strong> <small>{{time}}</small> <br>
 * {{contents}} </p> </div> </div> </article>
 */
//var template_login = $('#news-template-login').html();
//var template_post = $('#news-template-post').html();
//var template_login_up = Handlebars.compile(template_login);
//var template_post_up = Handlebars.compile(template_post);
var teamNumber = window.location.pathname.split('/')[2];

function keyForSend() {
	if (event.keyCode == 13) {
		send();
		$('#chat-input').val('');
	}
}


function showGreeting(message) {
	$('<li></li>').append(message).appendTo('#chat-box');
	console.log("showGreeting");
}

function dateConvert(date){
	var t = new Date(date).toString();
	var list = t.split(" ");
	var final = "";
	final += list[1] + " ";
	final += list[2] + " ";
	final += list[4] + " ";
	return final;
}

$(document).ready(
		function() {
			$.ajax({
				url : "/post/list/" + teamNumber,
				type : "GET",
				dataType : 'json',
				success : function(data) {
					console.log(data);
					for (var i = 0; i < data.length; i++) {
						var frame = "<tr><th>" + data[i].pid
								+ "</th><td><a href=\"/post/" + data[i].pid
								+ "\">" + data[i].title + "</a></td><td>"
								+ data[i].author + "</td><td>" + dateConvert(data[i].timestamp)
								+ "</td></tr>";
						if(data[i].author.substring(0,3) === '매니저'){
							$('#notice_table').prepend(frame);
						}else{
							$('#part_table').prepend(frame);
						}
					}
				}
			});
			
			$('#mentor_trig').click(function(){
				$('#mentor').show();
				$('#part').hide();
				$('#mentor_trig').addClass('is-active');
				$('#part_trig').removeClass('is-active');
			});
			
			$('#part_trig').click(function(){
				$('#mentor').hide();
				$('#part').show();
				$('#mentor_trig').removeClass('is-active');
				$('#part_trig').addClass('is-active');
			});

//			$.ajax({
//				url : "/share/list",
//				type : "GET",
//				dataType : 'json',
//				success : function(data) {
//					console.log(data);
//					for (var i = 0; i < data.length; i++) {
//						var frame = "<tr><th>" + data[i].pid
//								+ "</th><td><a href=\"/share/" + data[i].pid
//								+ "\">" + data[i].title + "</a></td><td>"
//								+ data[i].author + "</td><td>" + dateConvert(data[i].timestamp)
//								+ "</td></tr>";
//						$('#share_table').prepend(frame);
//					}
//				}
//			});

		});