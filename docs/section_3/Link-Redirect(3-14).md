link : 클라이언트가 직접 URL을 눌러 요청하는 것
redirect : 서버가 “이 URL 다시 요청해” 라고 해서 요청하는 것

<a href=”/articles”>Back</a>
→ Back이라는 link를 누르면 /articles라는 URL로 넘어감

Article saved = articleRepository.save(article);
return “redirect:/articles/” + saved.getId();

→ articleRepository의 save 메소드를 활용하여서 article을 저장한 변수인 saved의 Id를 가져와서 그 Id에 있는 데이터를 가져옴

상세페이지로 넘어가기 위해서 title에 링크를 걸어서 상세페이지로 넘어가게 하려고할 때
{{#articleList}}
<tr>
    <th>{{id}}<th>
    <td><a href=”/articles/{{id}}”>{{title}}</a></td>
    → 이런식으로 링크를 걸어서 해당 Id로 URL경로를 바꿔서 넘어가게 할 수 있음
    <td>{{content}}</td>
<tr>
{{/articlesList}}