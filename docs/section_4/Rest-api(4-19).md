REST API : 서버에 있는 ‘물건(자원)’을 규칙적으로 요청하고 응답받는 방법
JSON : REST API의 기본 응답 포멧
{
"id": 1,
"username": "moon",
"email": "mjh090801abc@dgsw.hs.kr"
}

Response 상태 코드

| 코드 | 의미 | 언제 쓰나 |
| --- | --- | --- |
| 200 OK | 성공 | 조회, 수정 성공 |
| 201 Created | 생성됨 | POST로 새 자원 생성 |
| 204 No Content | 성공(응답 없음) | 삭제 성공 |
| 400 Bad Request | 요청 오류 | JSON 형식 오류 |
| 401 Unauthorized | 인증 안 됨 | 로그인 안 함 |
| 403 Forbidden | 권한 없음 | 접근 불가 |
| 404 Not Found | 없음 | 데이터 없음 |
| 500 Internal Server Error | 서버 오류 | 코드 문제 |

PUT
PUT /users/1
{
"username": "moon",
"email": "mjh090801abc@dgsw.hs.kr"
}
이 JSON 데이터의 상태를 완전히 바꿈 기존 데이터가 통제로 교체됨
만약 값이 없는 필드가 있으면 null이 되어 사라짐

PATCH
PATCH /users/1
{
"email": "[m](mailto:new@test.com)jh090801abc@dgsw.hs.kr"
}
새로 보낸 값만 바뀌고 나머지 필드의 값들은 유지