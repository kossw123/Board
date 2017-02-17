<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://code.jquery.com/jquery-2.2.1.js" type="text/javascript"></script>
	<title>Write Page</title>
</head>
<body>
	<link href="<c:url value='resources/css/write.css'/>" rel="stylesheet">
	<table class="type01">
		<tr>
			<th scope="row">작성자</th>
			<td><input type=text id="write_id" value=""></td>
		</tr>
		<tr>
			<th scope="row">제목</th>
			<td><input type=text id="title" value=""></td>
		</tr>
		<tr>
			<th scope="row">내용</th>
			<td><input type=text id="content" value=""></td>
		</tr>
		<tr>
			<th scope="row">등록</th>
			<td><a href="#" id="Sign">Sign</a></td>
		</tr>
		
		<input type='BUTTON' value='Main' onclick="location.href='Main.page';">    


	</table>
</body>

</html>
<script>
			$("document").ready(function() {
				var addEvent = function() {
					$("#Sign").on("click", function() {
						insertboard();
					});
				};
				
				var insertboard = function() {
					var param = {
							"id" : $("#write_id").val(),
							"title" : $("#title").val(),
							"content" : $("#content").val(),
							"seq" : $("#re_seq").val()
					};
					
					$.ajax({
						type : "POST",
						url : "writeBoardList.json",
						data : JSON.stringify(param),
						contentType : "application/json",
						dataType : "json",
						success : function(data) {
							console.log("성공");
							//var writeID = $("#write_id").val();
							//var contentID = $("#content_id").val();
							//$("#out").val(writeID);
							var url = "Index.page";
							$(location).attr('href',url);
							//$("#writer").val(data.id);
							//console.log(JSON.parse(data));
							
							//console.log(data);
							//console.log(data.result);
							//console.log(data.result.message);
						},
						error : function(xhr) {
							console.log(xhr);
						}
					});
				}
				addEvent();
			});
</script>