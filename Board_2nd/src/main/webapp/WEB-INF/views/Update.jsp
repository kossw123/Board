<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://code.jquery.com/jquery-2.2.1.js" type="text/javascript"></script>
	<title>Update Page</title>
</head>
	<body>
		<link href="<c:url value='resources/css/update.css'/>" rel="stylesheet">
		<table class="type01">
			<tr>
				<th scope="row">갱신할 SEQ</th>
				<td><input type=text id="re_seq" value=""></td>
			</tr>
			<tr>
				<th scope="row">검색된 SEQ</th>
				<td><input type=text id="search_seq" value=""></td>
			</tr>
			<tr>
				<th scope="row">갱신할 작성자</th>
				<td><input type=text id="re_writer" value=""></td>
			</tr>
			<tr>
				<th scope="row">갱신할 내용</th>
				<td><input type=text id="re_content" value=""></td>
			</tr>
			<tr>
				<th scope="row">갱신</th>
				<td><a href="#" id="Update">Update</a></td>
			</tr>
		</table>
		
		<input type='BUTTON' value='Main' onclick="location.href='Main.page';">
	</body>
</html>
 	<script>
 	$('#Update').click(function() {
 		var param = {
 				"id" : "admin",
 				"title" : "title",
 				"content" : "test",
 				"seq" : "123"
 		}
		$.ajax({
			type : 'post',
			url : 'updateBoardList.json',
			contentType : "application/json",
			dataType : 'json',
			data : JSON.stringify(param),
			success : function(data) {
				console.log(data);
				console.log(data.message);
				//var load_seq = $("re_seq").val();
			}
		});
});
	</script>