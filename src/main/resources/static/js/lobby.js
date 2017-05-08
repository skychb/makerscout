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
var template_login = $('#news-template-login');
var template_post = $('#news-template-post');
var template_login_up = Handlebars.compile(template_login);
var template_post_up = Handlebars.compile(template_post);
function keyForSend(){
	if(event.keyCode == 13){
		send();
		$('#chat-input').val('');
	}
}

function connect() {
	var socket = new SockJS('/hello');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		var message = "Be careful little hands what you do";
		showGreeting(message);
		console.log('connected : ' + frame);
		stompClient.subscribe('/topic/greetings', function(greeting) {
			var now = new Date();
			showGreeting(JSON.parse(greeting.body).content+now.getHours()+":"+now.getMinutes());
			console.log('checked for show greeting.');
		});
	});
}

function send() {
	var id = $('.idForChat').text();
	var name = $('#chat-input').val();

	stompClient.send("/app/hello", {}, JSON.stringify({
		'name' : name,
		'id' : id
	}));

}

function showGreeting(message) {
	$('<li></li>').append(message).appendTo('#chat-box');
	console.log("showGreeting");
}

$(document).ready(
		function() {
			$.ajax({
				url : "/notice/list",
				type : "GET",
				dataType : 'json',
				success : function(data) {
					console.log(data);
					for (var i = 0; i < data.length; i++) {
						var t = new Date(data[i].timestamp).toString();
						var list = t.split(" ");
						var final = "";
						final += list[1] + " ";
						final += list[2] + " ";
						final += list[4];
						var frame = "<tr><th>" + data[i].pid
								+ "</th><td><a href=\"/notice/" + data[i].pid
								+ "\">" + data[i].title + "</a></td><td>"
								+ data[i].author + "</td><td>" + final
								+ "</td></tr>";
						$('#notice_table').prepend(frame);
					}
				}
			});

			$.ajax({
				url : "/share/list",
				type : "GET",
				dataType : 'json',
				success : function(data) {
					console.log(data);
					for (var i = 0; i < data.length; i++) {
						var t = new Date(data[i].timestamp).toString();
						var list = t.split(" ");
						var final = "";
						final += list[1] + " ";
						final += list[2] + " ";
						final += list[4];
						var frame = "<tr><th>" + data[i].pid
								+ "</th><td><a href=\"/share/" + data[i].pid
								+ "\">" + data[i].title + "</a></td><td>"
								+ data[i].author + "</td><td>" + final
								+ "</td></tr>";
						$('#notice_table').prepend(frame);
					}
				}
			});

			

			connect();
		});