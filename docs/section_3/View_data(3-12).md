example code)
@GetMapping(”/{id}”) 
public Stirng show(@PathVarible Long id, Model model){

	Article articleEntity = articleRepository.findById(id).orElse(null);

	model.addAttribute("article", articleEntity);
	
	return "article/edit";
} 

@PathVariable : url 주소로부터 입력됨
→ Long 타입으로 Id를 받는데 @PathVariable 어노테이션이 있으므로 @GetMapping에 있던 URL의 id값을 그대로 받아옴

Article articleEntity = articleRepository.findById(id).orElse(null);
→ articleRepository에서 findById라는 메소드를 활용하여서 id를 찾음 + Article(Entity)타입의 articleEntity이라는 변수를 활용 + orElse를 활용항서 찾는 id가 없으면 null이 나오도록 구현

만약 어떠한 클래스에서 어떠한 변수를 만들어서 Model에 등록한 뒤 mustache에서 사용하려고 하면 Controller에서 return을 한 뒤에 사용할 수 있음.


mustache에서는 Model로 받은 변수를 활용하려면
{{#변수명}}
<tr>
    <th>{{id}}</th> → 이런식으로 Model에 등록된 변수를 활용할 수 있음
    ...
</tr>
{{/변수명}}

@NoArgsConstructor : 디폴트 생성자 (매개변수를 가지고 있지 않음)