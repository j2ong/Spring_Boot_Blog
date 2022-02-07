//J-Query 부분
let index = {
		init: function(){
			$("#btn-save").on("click", ()=>{//btn-save가 클릭되면              //functio(){} 대신 화살표 함수 -> this를 바인딩
				this.save();
			}); 
			$("#btn-login").on("click", ()=>{//btn-login가 클릭되면              //functio(){} 대신 화살표 함수 -> this를 바인딩
				this.login();
			}); 	
		},
		
		save: function(){
			//alert("회원가입 완료")
			let data = {
					username : $("#username").val(),
					password : $("#password").val(),
					email : $("#email").val()
			};
			
			// ajax호출시 default가 비동기 호출이다.
			$.ajax({
				type:"POST",
				url:"/api/user",								//호출시 데이터를 Post할 곳
				data:JSON.stringify(data),                   //data를 json 타입으로 변환하는 함수
				contentType:"application/json; charset=utf-8", //Body 데이터가 어떤 타입인지, post는 body를 가진다.
				dataType:"json" // 응답 타입이 Json이라면, javascript로 변환
					
			}).done(function(resp){ //응답이 결과가 정상이면
				alert("회원가입이 완료되었습니다.");
				location.href = "/";							//끝나고 돌아올 곳
				
			}).fail(function(error){ // 실패이면
				alert(JSON.stringify(error));
			}); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 Insert 요청!!
			},
			
			
			login: function(){
			//alert("회원가입 완료")
			let data = {
					username : $("#username").val(),
					password : $("#password").val(),
			};
			
			// ajax호출시 default가 비동기 호출이다.
			$.ajax({
				type:"POST",
				url:"/api/user/login",								//호출시 데이터를 Post할 곳 -> 컨트롤러
				data:JSON.stringify(data),                   //data를 json 타입으로 변환하는 함수
				contentType:"application/json; charset=utf-8", //Body 데이터가 어떤 타입인지, post는 body를 가진다.
				dataType:"json" // 응답 타입이 Json이라면, javascript로 변환
					
			}).done(function(resp){ //응답이 결과가 정상이면
				alert("로그인이 완료되었습니다.");
				location.href = "/";							//끝나고 돌아올 곳
				
			}).fail(function(error){ // 실패이면
				alert(JSON.stringify(error));
			}); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 Insert 요청!!
			}
}

index.init();





