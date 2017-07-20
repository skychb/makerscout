
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
			var teamId = $('#team_id')[0].textContent;

			$.ajax({
				url : "/post/list/"+teamId,
				type : "GET",
				dataType : 'json',
				success : function(data) {
					console.log(data);
					for (var i = 0; i < data.length; i++) {
						var frame = "<tr><th>" + data[i].pid
								+ "</th><td><a href=\"/notice/" + data[i].pid
								+ "\">" + data[i].title + "</a></td><td>"
								+ data[i].author + "</td><td>" + dateConvert(data[i].timestamp)
								+ "</td></tr>";
						$('#post_table').prepend(frame);
					}
				}
			});

		});