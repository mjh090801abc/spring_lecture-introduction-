List<Article> articleEntityList = articleRepository.findAll();
→ 모든 Article을 가져옴 (만약 타입 불일치가 생길 시 articleRepository에서 상속 받은 CrudRepository의 메소드를 오버라이딩하여서 강제로 맞출 수 있음)

model.addAttribute(articleList, articleEntityList)
→ model로 articleEntityList를 articleList라는 변수에 담아서 저장

{{#articleList}}
…
{{/articleList}}

→ articleList에 들어있는 값을 활용