데이터 삭제하는 과정

mustache
<a href=”articles/{{article.id}}/delete” class=”btn btn-danger”>Delete</a>
→ 이렇게 a태그에 삭제하기 위한 링크를 걸어둠

Controller
public String delete(@PathVariable Long id, RedirectAttributes rttr)
Article target = articleRepository.findById(id).orElse(null);
→ Article 타입의 target 변수에서 id를 찾고 없으면 null 반환

if (target != null) {
articleRepository.delete(target);
→ articleRepository에서 상속받은 CrudRepository의 메소드인 delete를 활용하여서 해당 target을 지움

rttr.addFlashAttribute(”msg”, “삭제완료”);
→ 일회성 메세지이므로 addFlashAttribute 사용
}

mustache
alert 메세지 출력
msg라는 데이터가 있으면 이 안에 있는 것을 출력
{{#msg}}
    <div class="alert alert-primary alert-dismissible">
    {{msg}}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">               </button>
    </div>
{{/msg}}

