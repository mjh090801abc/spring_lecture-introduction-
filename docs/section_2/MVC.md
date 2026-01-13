mvc 패턴 : 화면, 처리, 데이터 분야를 각 담당자별로 나누는 기법

Controller는 클라이언트로부터 요청을 받고, View는 최종 페이지를 만들며 Model은 최종 페이지에 쓰일 데이터들을 View에 전달 (따로 분리하기 위해서)

Model : 데이터를 관리
View Templates : 화면을 담당 (이 강의에서 mustache라는 뷰 템플릿 엔진을 활용)
Controller : 처리 과정을 담당

@Controller : 컨트롤러 선언
return “”; : 응답 페이지 설정
@GetMapping(”/”) : URL 요청 연결 (괄호 안에 접속할 URL 주소를 넣어야함)
public String 메소드명(Model model) : 데이터를 받아오기 위해 model을 받아옴
model.addAttribute(”attributeName”, “attributeValue”) : 모델은 통한 변수 등록

{{username}} : mustache에서 어떤 것을 변수화
{{>layouts/header}}

content...

{{>layouts/footer}}
→ 다른 파일들을 변수화하여서 가져옴