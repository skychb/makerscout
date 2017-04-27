$(document).ready(function(){
	$.ajax({
		url:"/post/list",
		type: "GET",
		dataType:'json',
		success:function(data){
			console.log(data);
			for(var i = 0 ; i < data.length;i++){
				var t = new Date(data[i].timestamp).toString();
				var list = t.split(" ");
				var final = "";
				final += list[1] + " ";
				final += list[2] + " ";
				final += list[4];
				var frame = "<tr><th>"+data[i].pid+"</th><td><a href=\"/post/"+data[i].pid+"\">"+data[i].title +"</a></td><td>"+data[i].author+"</td><td>"+final+"</td></tr>";
				$('#notice_table').prepend(frame);
			}
		}
	});
});