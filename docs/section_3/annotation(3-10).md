@Entity : DB가 해당 객체를 인식가능
@Id : 대표값을 지정
@GeneratedValue : Id 자동 생성 어노테이션
@Column : DB에서 관리하는 테이블이라는 단위에 연결되게 만들어주는 것
@Autowired : 스프링 부트가 미리 만들어놓은 객체를 가져다가 장동으로 연결

Repository에서 다른 Repository를 상속 받을 때
클래스명 extends CrudRepository<관리 대상 Entity, id의 타입>