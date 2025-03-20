# SPRING PLUS

## 프로젝트 개요
    https://github.com/f-api/spring-plus
위 프로젝트를 fork 해서 각 레벨별로 develop 을 진행했습니다.


## 기능 설명
해당 프로젝트는 일정 등록 프로젝트입니다.

회원 가입 및 로그인을 해야 사용을 하실 수 있습니다 (기본 인증방식은 JWT 입니다).

일정을 만들고 관리할 매니저를 추가를 할 수 있으며, 밑에 댓글을 추가를 하여 동참을 할 수 있습니다.

## 레벨별 요구사항 ( fork 전 브랜치 기준 )
- Lv.1 - 1. 코드 개선 퀴즈 - @Transactional의 이해
    - 할 일 저장 기능을 구현한 API(/todos)를 호출할 때, 아래와 같은 에러가 발생하고 있어요.
    - jakarta.servlet.ServletException: Request processing failed: org.springframework.orm.jpa.JpaSystemException: could not execute statement [Connection is read-only. Queries leading to data modification are not allowed] [insert into todos (contents,created_at,modified_at,title,user_id,weather) values (?,?,?,?,?,?)]
    - 에러가 발생하지 않고 정상적으로 할 일을 저장 할 수 있도록 코드를 수정해주세요.
- Lv.1 - 2. 코드 추가 퀴즈 - JWT의 이해
    - User의 정보에 nickname이 필요해졌어요.
        - User 테이블에 nickname 컬럼을 추가해주세요.
        - nickname은 중복 가능합니다.
    - 프론트엔드 개발자가 JWT에서 유저의 닉네임을 꺼내 화면에 보여주길 원하고 있어요.
- Lv.1 - 3. 코드 개선 퀴즈 -  JPA의 이해
    - 할 일 검색 시 `weather` 조건으로도 검색할 수 있어야해요.
        - `weather` 조건은 있을 수도 있고, 없을 수도 있어요!
- Lv.1 - 4. 테스트 코드 퀴즈 - 컨트롤러 테스트의 이해
    - 테스트 패키지 org.example.expert.domain.todo.controller의
      todo_단건_조회_시_todo가_존재하지_않아_예외가_발생한다() 테스트가 실패하고 있어요.
    - 테스트가 정상적으로 수행되어 통과할 수 있도록 테스트 코드를 수정해주세요.
- Lv.1 - 5. 코드 개선 퀴즈 - AOP의 이해
    - `UserAdminController` 클래스의 `changeUserRole()` 메소드가 실행 전 동작해야해요.
    - `AdminAccessLoggingAspect` 클래스에 있는 AOP가 개발 의도에 맞도록 코드를 수정해주세요.
- Lv.2 - 6. JPA Cascade
    - 할일을 새로 저장할 시, 할 일을 생성한 유저는 담당자로 자동 등록되어야 합니다.
    - JPA의 `cascade` 기능을 활용해 할 일을 생성한 유저가 담당자로 등록될 수 있게 해주세요.
- Lv.2 - 7. N + 1
    - `CommentController` 클래스의 `getComments()` API를 호출할 때 N+1 문제가 발생하고 있어요. N+1 문제란, 데이터베이스 쿼리 성능 저하를 일으키는 대표적인 문제 중 하나로, 특히 연관된 엔티티를 조회할 때 발생해요.
    - 해당 문제가 발생하지 않도록 코드를 수정해주세요.
- Lv.2 - 8. QueryDSL
    - JPQL로 작성된 `findByIdWithUser` 를 QueryDSL로 변경합니다.
    - 7번과 마찬가지로 N+1 문제가 발생하지 않도록 유의해 주세요!
- Lv.2 - 9. Spring Security
    - 기존 `Filter`와 `Argument Resolver`를 사용하던 코드들을 Spring Security로 변경해주세요.
        - 접근 권한 및 유저 권한 기능은 그대로 유지해주세요.
        - 권한은 Spring Security의 기능을 사용해주세요.
    - 토큰 기반 인증 방식은 유지할 거예요. JWT는 그대로 사용해주세요.
- Lv.3 - 10. QueryDSL 을 사용하여 검색 기능 만들기
    - 새로운 API로 만들어주세요.
    - 검색 조건은 다음과 같아요.
        - 검색 키워드로 일정의 제목을 검색할 수 있어요.
            - 제목은 부분적으로 일치해도 검색이 가능해요.
        - 일정의 생성일 범위로 검색할 수 있어요.
            - 일정을 생성일 최신순으로 정렬해주세요.
        - 담당자의 닉네임으로도 검색이 가능해요.
            - 닉네임은 부분적으로 일치해도 검색이 가능해요.
    - 다음의 내용을 포함해서 검색 결과를 반환해주세요.
        - 일정에 대한 모든 정보가 아닌, 제목만 넣어주세요.
        - 해당 일정의 담당자 수를 넣어주세요.
        - 해당 일정의 총 댓글 개수를 넣어주세요.
    - 검색 결과는 페이징 처리되어 반환되도록 합니다.
- Lv.3 - 11. Transaction 심화
    - 매니저 등록 요청을 기록하는 로그 테이블을 만들어주세요.
        - DB 테이블명: `log`
    - 매니저 등록과는 별개로 로그 테이블에는 항상 요청 로그가 남아야 해요.
        - 매니저 등록은 실패할 수 있지만, 로그는 반드시 저장되어야 합니다.
        - 로그 생성 시간은 반드시 필요합니다.
        - 그 외 로그에 들어가는 내용은 원하는 정보를 자유롭게 넣어주세요.