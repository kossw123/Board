<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-2.2.1.js" type="text/javascript"></script>
<title>Index Page</title>
<link href="<c:url value='resources/css/index.css'/>" rel="stylesheet">
</head>
<body>
<!-- 	<table class="type01">
		<tr>
			<th scope="row">입력자</th>
			<td><input type=text id="writer" value=""></td>
		</tr>
		<tr>
			<th scope="row">입력내용</th>
			<td><input type=text id="content" value=""></td>
		</tr>
		<tr>
			<th scope="row">title</th>
			<td><input type=text id="title" value=""></td>
		</tr>
	</table> -->
	<div id="Content"></div>
	<input type='BUTTON' value='Main' onclick="location.href='Main.page';">
	<input type='BUTTON' value='Update' onclick="location.href='Update.page';">        
</body>

<script>
	var Content = $("#Content");
	
 	$(function() {
		$.ajax({
			type : 'post',
			url : 'getBoardList.json',
			contentType : "application/json",
			dataType : 'json',
			data : JSON.stringify({}),
			success : function(data) {
				console.log(data);
				
				var div = $("<div></div>");
				var a = $("<a></a>");
				var items = data.result;
				
				for(var i=0;i<items.length;i++)
				{
					var item = items[i];
					
					var view = a.clone().append(	div.clone().append(item.title + ", " + item.content + item.seq)	).attr("href","Update.page?seq="+item.seq);
					
					Content.append(view);
					
				}
			}
		});
	})
</script>
</html>