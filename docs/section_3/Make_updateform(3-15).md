<a href=”/articles/{{article.id}}/edit”>Edit</a>
→ article에 있는 id 페이지로 이동

mustache 문법과 다르게 Controller에서는 @GetMapping(”/articles/{id}/edit”);
→ 여기서는 {article.id}라고 쓰지 않는 이유는 해당 id에 있는 값들을 들고 와야하므로

public String edit(@PathVariable Long id, Model model) { … }
이런식으로 메소드를 짜는데 여기서 @PathVariable Long id 이것은 URL의 id값을 그대로 가져오기 떄문

{{#article}}

…

{{/article}}
→ 이렇게 쓰는 이유는 article이라는 모델에 등록된 article이라는 변수를 활용하기 위해서 였음 만약 이걸 사용하지 않는다면

<input type=”text” class=”from-control” name=”title” value=”{{article.title}}”>
<textarea class=”form-control” rows=”3” name=”content”>{{article.content}}</textarea> …
이런식으로 각각의 입력값을 넣는 곳에 {{}}를 사용해서 하나씩 다 적어넣어야함