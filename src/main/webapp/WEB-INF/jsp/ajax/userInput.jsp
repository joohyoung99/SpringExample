<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userinput </title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

</head>
<body>

	<!-- <form method="post" action="/ajax/user/insert" id="userForm">-->
		<label>이름</label><input type="text" name="name" id="nameInput"><br>
		<label>생년월일</label><input type="text" name="birthday" id="birthInput"><br>
		<label>자기소개</label><br>
		<textarea rows="5" cols="30" name="introduce" id="introduceInput"></textarea><br>
		<label>이메일</label><input type="text" name="email" id="emailInput"><br>
		<button type="button" id="addBtn">추가</button>
	</form>
	
	
	<script>
		$(document).ready(function(){
			
			
			
			$("#addBtn").on("click", function(){
				
				let name = $("#nameInput").val();
				let birthday = $("#birthInput").val();
				let introduce = $("#introduceInput").val();
				let email = $("#emailInput").val();
				
				if(name == ""){
					alert("이름을 입력하세요");
					return false;
				}
				if(birthday == ""){
					alert("생년월일을 입력하세요");
					return false;
				}
				if(introduce = ""){
					alert("자기소개를 입력하세요");
					return false;
				}
				if(email == ""){
					alert("이메일을 입력하세요");
					return false;
				}
				$.ajax({
					//request를 위한 옵션
					type:"post",
					url:"/ajax/user/insert",
					data:{"name":name , "birthday":birthday, "introduce":introduce, "email":email},
					//response를 위한 옵션
					success:function(data){
						//alert(data);
						location.href="/ajax/user/list";
					},
					error:function(){
						
						alert("에러발생");
					}
					
					
					
				});
				
				
				
			});
			
			/*
			$("#userForm").on("submit", function(){
				
				let name = $("#nameInput").val();
				let birthday = $("#birthInput").val();
				let introduce = $("#introduceInput").val();
				let email = $("#emailInput").val();
				
				if(name == ""){
					alert("이름을 입력하세요");
					return false;
				}
				if(birthday == ""){
					alert("생년월일을 입력하세요");
					return false;
				}
				if(introduce = ""){
					alert("자기소개를 입력하세요");
					return false;
				}
				if(email == ""){
					alert("이메일을 입력하세요");
					return false;
				}
				
				
				
				
				
			});
			*/
			
			
		});
	
	
	
	</script>
	
</body>
</html>