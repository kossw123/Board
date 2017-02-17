<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-2.2.1.js" type="text/javascript"></script>
<title>Index Page</title>
</head>
<body>
 	<<link href="<c:url value='resources/css/index.css'/>" rel="stylesheet">
	<table class="type01">
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
	</table>
	<input type='BUTTON' value='Main' onclick="location.href='Main.page';">
	<input type='BUTTON' value='Update' onclick="location.href='Update.page';">        
</body>

<script>
 	$(function() {
			$.ajax({
				type : 'post',
				url : 'getBoardList.json',
				contentType : "application/json",
				dataType : 'json',
				data : JSON.stringify({}),
				success : function(data) {
					console.log(data);
					/* var boardData = data.result;
					var x = 0;
					for(var y = 0 ; y < boardData.length ; y++){
						//console.log();
						console.log("Log Start!!" + boardData[y].seq);
						console.log(boardData[y].title);
						console.log(boardData[y].content);
						console.log(boardData[y].id);
					} */
					$("#writer").val(data.result[data.result.length - 1].id);
					$("#content").val(data.result[data.result.length - 1].content);
					$("#title").val(data.result[data.result.length - 1].title);
				}
			});
	})
</script>
</html>