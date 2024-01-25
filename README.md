#### ERD
![image](https://github.com/NayoungKim1212/project/assets/132897437/4a9a1192-405d-4034-8c9b-3c822a840362)

#### 테이블 정의서
- 테이블 이름 : 회원, 서비스 구독
- 회원 : auth, 서비스 구독 : Subscription
- 데이터 타입 : BIGINT
- 회원 이름 : Not null, unique, 비밀번호 : Not null 

#### 시스템 구성도

![image](https://github.com/NayoungKim1212/project/assets/132897437/98d65089-a2fa-4b71-8cb7-aa1661827ebb)

#### 기능 정의서

1. 사용자 관리
   
    1.1 User Entity(사용자 정보를 나타냄)
     - id(Long) : 사용자 고유 식별자
     - username(String) : 사용자 고유 이름
     - password(String) : 사용자 비밀번호 
   
   1.2 UserRepository(User 엔티티에 대한 데이터베이스 작업을 추상화하는 인터페이스)
    - 사용자 조회, 저장, 업데이트 등
    
   1.3  UserService(사용자 관련 비즈니스 로직을 처리)
   - 사용자 생성. 사용자 인증. 사용자 정보 업데이트
     
   1.4 UserController(HTTP 요청을 처리하고 사용자 관련 작업을 UserService에 전달)
   - 회원가입: UserRequestDto를 받아 새로운 사용자 생성
   - 로그인: LoginRequestDto를 받아 사용자 인증

3. 서비스 구독
   
   2.1 Subscription
     -  id (Long): 구독의 고유 식별자
      - users (Integer): 구독하는 사용자 수

     - serviceType (String): 구독 서비스의 종류 (Basic, Standard, Premium)
      - storage (Double): 할당된 스토리지 용량 (TB 단위)
     - duration (Integer): 구독 기간 (개월 단위)
    - companyName (String): 회사 이름
     - phoneNumber (String): 연락처
    - email (String): 이메일 주소
     - address (String): 주소

   2.2 SubscriptionMapper(MyBatis 매퍼 인터페이스)
   
   2.3 SubscriptionService(구독 관련 비즈니스 로직을 처리)
      - 구독 생성, 구독 정보 업데이트. 구독 상태 조회
        
   2.4 SubscriptionController(HTTP 요청을 처리하고 구독 관련 작업을 SubscriptionService에 전달)
     - 구독 신청: 필수 정보와 부가 정보를 받아 새로운 구독 생성
      - 구독 현황: 구독 상태 정보를 반환
      - 구독 기간 연장: 기존 구독에 대한 기간 연장 요청 처리

4. JwtUtil(JSON Web Token을 생성하고 검증하는 유틸리티)
    - 인증 토큰 생성, 토큰 유효성 검사
  
5. PasswordConfig(비밀번호 암호화 설정)
   - 비밀번호 암호화 및 검증
  
6.  MybatisConfig(MyBatis 설정을 관리)
    - 데이터베이스 연결 설정
   
