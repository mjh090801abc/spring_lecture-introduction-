GET
@GetMapping에서 데이터 전체를 반환할 때에는 메소드명 앞 List<Entity명> 이런식으로 List 형태로 묶어서 메소드를 생성해야함
단일 데이터는 URL을 “/api/articles/{id}” 이런식으로 적고, 메소드에서 파라미터를 @PathVariable를 활용하여 URL의 id값을 하나씩 가져올 수 있음

POST
@RequestBody : HTTP 요청의 body에 담긴 데이터를 JSON으로 반환하여서 데이터를 받게함
Article article = dto.toEntity();
→ dto에서 받은 데이터들을 Article 타입의 변수 article에 넣어서 save함

PATCH
@PatchMapping("/api/articles/{id}")
public ResponseEntity<Article> update(@PathVariable Long id,
@RequestBody ArticleForm dto) {
→ 여기서 ResponseEntity<T>를 사용한 이유는 수정을 할 때 만약 수정하려는 객체의 값이 비어있거나 해당 id가 없을 때 HTTP에 대한 응답 처리를 해야하는데 응답을 하기위해서 ResponseEntity를 사용하여서 200, 201, 400 등의 응답 코드를 보낼 수 있기 떄문임

정상적으로 수정이 되었을 떄의 코드도 반환
public void patch(Article article) {
    if (article.title != null) {
    this.title = article.title;
    }
    if (article.content != null) {
    this.content = article.content;
    }
}
→ Entity에서 먼저 PATCH의 기능을 만든 patch 메소드를 생성
메소드 생성뒤 articleRepository의 save 메소드를 활용하여서 저장할 변수에 저장한 뒤 응답 코드를 반환

DELETE
@DeleteMapping("/api/articles/{id}")
public ResponseEntity<Article> delete(@PathVariable Long id) { … }
→ @PathVariable를 통해 id를 가져옴 가져온 id를 활용하여서 변수에 저장한 뒤

if (target == null) {             
return ResponseEntity.*status*(HttpStatus.*BAD_REQUEST*).body(null);
}
→ target(id값을 받아온 변수)가 비어있다면 404에러를 출력하여서 잘못됨을 알림

삭제의 조건이 되면 삭제 코드를 활용하여서 삭제한 뒤 200 OK 응답 코드를 반환