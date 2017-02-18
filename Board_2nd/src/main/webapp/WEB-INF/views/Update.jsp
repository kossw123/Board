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
				<th scope="row">작성자</th>
				<td id="re_writer"></td>
			</tr>
			<tr>
				<th scope="row">제목</th>
				<td><input type=text id="re_title" value="" target="writer"></td>
			</tr>
			<tr>
				<th scope="row">내용</th>
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
 	$("document").ready(function() {
 			
 			//var ano_p_id = $.find("#writer");
 			//$("#re_writer").append(ano_p_id);
 			//$("#re_writer").load("Index.page", "#write_id");
 			$("#re_writer").attr();
 			var param = {
	 				"seq" : "207"
		 		}
 			$.ajax({
 				type : 'post',
 				url : 'viewBoardItem.json',
 				contentType : "application/json",
 				dataType : 'json',
 				data : JSON.stringify(param),
 				success : function(data) {
 					console.log(data);
 				}
 			})
 			
 		$('#Update').click(function() {
 	 		var param = {
 	 				"id" : "admin",
 	 				"title" : $("#re_title").text(),
 	 				"content" : $("#re_content").text(),
 	 				"seq" : "207"
 	 		}
 			$.ajax({
 				type : 'post',
 				url : 'updateBoardList.json',
 				contentType : "application/json",
 				dataType : 'json',
 				data : JSON.stringify(param),
 				success : function(data) {
 					console.log(data);
 				}
 			});
 	});
 		
 		
 	});
	</script>