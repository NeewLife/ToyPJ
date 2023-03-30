# 배구 동호회 게시판

[상세정보 및 기획](https://careful-manuscript-b51.notion.site/5afb7d33d5b5457bb55f1763c4a16a0a)


## 버전

- JAVA 17
- Spring Boot  3.0.4

## 실행방법

1. [DDL.md](http://DDL.md) 파일을 열어서 쿼리문을 실행하여 테이블을 생성한다.(MySQL 사용)
2. [application.properties](http://application.properties) 에서 DB 연결할 username, password 를 자신의 DB에 맞게 변경한다.
3. `ToyPjApplication` 실행

### DB 테이블(MySQL 사용)

- 테이블명 = “user”

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5a9b7b80-8693-4d31-8bcf-0d945af8923b/Untitled.png)

- 테이블명 = “pj_post”

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7d32704e-642d-4f5d-b8d9-13648305fb10/Untitled.png)

삭제를 진행할 경우 테이블에서 물리적으로 제거하기보다 delete_yn 컬럼값을 변경하여서 논리적인 삭제를 진행하였음

### - 로그인 페이지

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/9e1100b6-93fa-480a-a24c-b184cd52f1bf/Untitled.png)

- 로그인이 되어있지 않을 시에 강제로 로그인페이지를 호출
- 로그인이 되어있다면 임의로 이 URI 호출시 메인 페이지를 호출
- 회원가입 페이지로만 이동가능
- DB(MySQL)에 있는 데이터를 조회해서 아이디 비밀번호를 비교한 뒤 로그인

### - 회원가입 페이지

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/dc36ac7d-b67b-4851-935e-dd390fce3720/Untitled.png)

- 실명은 정규표현식을 통해 한글 작성만 가능
- 키, 몸무게는 정수로 변환해서 받음
- 비밀번호는`BCryptPasswordEncoder` 를 사용하였고 DB에는 암호화한 비밀번호로 입력됨

### - 메인화면(기능구상중)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/48bd16e1-ea36-4b8a-8645-c0ab59a540f8/Untitled.png)

- 로그인 성공 후 가장 먼저 나오는 페이지
- 현재 로그인 한 사람의 닉네임이 상단바에 노출됨

### - 게시판 페이지

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/70cba9b6-b273-4542-a631-7ff5f35d92ad/Untitled.png)

- 작성한 글 목록 중 삭제여부가 1(삭제됨)이 아닌 게시글들을 DB에서 조회하여 가져온다.

### - 상세 페이지

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2c86f44e-b531-4df7-abf6-4670457cc9f9/Untitled.png)

- 댓글 기능 추후 구현예정
- 글쓴이 == 로그인한 사용자 일 경우 수정, 삭제버튼 활성화

### - 글쓰기 페이지

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2060827f-39f2-4335-9e9c-3f06218c3d67/Untitled.png)

- 새로운 글을 쓸 경우의 페이지는 공백상태

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/70736fab-21e9-49d8-8b72-620d42e37179/Untitled.png)

- 기존 글 수정일 경우 제목 및 내용을 불러와서 수정가능

### - 마이페이지

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/95036bbf-4bd2-4ce5-8162-c5b2baf30154/Untitled.png)

- 내 정보수정 버튼을 누르면 연령대, 키, 몸무게 부분이 수정가능하게 활성화

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/33e688d2-606e-441e-8912-7da24abe696c/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4eaab78b-cb7e-4d29-8646-b15f4939ae26/Untitled.png)

- 회원탈퇴 버튼을 누를 시 alert 메세지를 띄우고 확인을 누르면 로그아웃과 동시에 논리적인 삭제를 진행한다.
