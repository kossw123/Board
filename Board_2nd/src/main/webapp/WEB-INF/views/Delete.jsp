<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://code.jquery.com/jquery-2.2.1.js" type="text/javascript"></script>
	<title>Delete Page</title>

</head>
	<body>
		<link href="<c:url value='resources/css/update.css'/>" rel="stylesheet">
		<table class="type01">
			<tr>
				<th scope="row">삭제할 SEQ</th>
				<td><input type=text id="delete_seq" value=""></td>
			<tr>
				<th scope="row">삭제</th>
				<td><a href="#" id="Delete">Update</a></td>
			</tr>
		</table>
	</body>
</html>

 	<script>
 		$("document").ready(function() {
			var addEvent = function() {
				$("#Delete").on("click", function() {
					insertboard();
				});
			};
	
			var insertboard = function() {
				var param = {
					"seq" : $("#re_seq").val()
				};
	
				$.ajax({
					type : "POST",
					url : "updateBoardList.json",
					data : JSON.stringify(param),
					contentType : "application/json",
					dataType : "json",
					success : function(data) {
						console.log(data);
					},
					error : function(xhr) {
						console.log(xhr);
					}
				});
			}
			addEvent();
		});
	</script>