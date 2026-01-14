INSERT INTO article(id, title, content) VALUES (1, title값, content값);
INSERT INTO article(id, title, content) VALUES (2, title값, content값);
...
→ 이렇게 하면 INSERT문을 통해 더미 데이터가 생성되어 들어감

데이터 수정을 위한 과정
@PostMapping(”/articles/update”)
public String update(ArticleForm form) {
    log.info(form.toString());
}

1. DTO를 Entity로 변환
Article articleEntity = form.toEntity();
log.info(articleEntity.toString());

2. 엔티티를 DB로 저장
3. DB에서 기존 데이터 가져옴
Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
→ Article(Entity)타입의 변수 = articleEntity(Article 타입의 DTO의 값들)의 id값, 아니면 null을 반환