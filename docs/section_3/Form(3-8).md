폼(form) 데이터란 html 요소인 폼 태그에 담긴 데이터

게시판 같은 곳에서 사용한 것은 폼태그이다. 폼태그는 어디로 보낼지 어떻게 보낼지를 정하고 이렇게 적힌 대로 폼 데이터는 전송이되고 Controller는 이를 DTO라는 객체에 담음

폼 태그

<form class=”container” action=”” method=””>

…
<form>

action : 어디로 보낼지 (URL로 던짐), method : 어떻게 보낼지 (get, post로만 가능)

<input>, <textarea>와 같은 입력값을 넣는 곳에 DTO에 존재하는 필드명도 name=“”을 활용해서 넣어야함