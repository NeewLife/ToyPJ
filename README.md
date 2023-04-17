# 로컬에서 사용하려면 'develop' 브랜치로 사용

# 배구 동호회 게시판

[프로젝트 사이트](http://34.64.207.213:8081/post/login)

[상세정보 및 기획](https://careful-manuscript-b51.notion.site/5afb7d33d5b5457bb55f1763c4a16a0a)


## 버전

- JAVA 17
- Spring Boot  3.0.4


### DB 테이블(MySQL 사용)

- 테이블명 = “user”

![Untitled](https://user-images.githubusercontent.com/107593357/228719227-c8eadd50-7ba6-4265-896d-44445bc9bba5.png)

- 테이블명 = “pj_post”

![Untitled 1](https://user-images.githubusercontent.com/107593357/228719283-a05d2880-dec8-47eb-b2f2-ba65a8c4d84f.png)

삭제를 진행할 경우 테이블에서 물리적으로 제거하기보다 delete_yn 컬럼값을 변경하여서 논리적인 삭제를 진행하였음

### - 로그인 페이지

![Untitled 2](https://user-images.githubusercontent.com/107593357/228719321-4969f610-a6e7-449e-b246-6469dd72b6f9.png)

- 로그인이 되어있지 않을 시에 강제로 로그인페이지를 호출
- 로그인이 되어있다면 임의로 이 URI 호출시 메인 페이지를 호출
- 회원가입 페이지로만 이동가능
- DB(MySQL)에 있는 데이터를 조회해서 아이디 비밀번호를 비교한 뒤 로그인

### - 회원가입 페이지

![Untitled 3](https://user-images.githubusercontent.com/107593357/228719361-5f53ba9e-b98f-4b5f-befe-7cdab64cea69.png)

- 실명은 정규표현식을 통해 한글 작성만 가능
- 키, 몸무게는 정수로 변환해서 받음
- 비밀번호는`BCryptPasswordEncoder` 를 사용하였고 DB에는 암호화한 비밀번호로 입력됨

### - 메인화면(기능구상중)

![Untitled 4](https://user-images.githubusercontent.com/107593357/228719365-7a39ad84-c5c7-4e38-acc0-4222fab68c89.png)

- 로그인 성공 후 가장 먼저 나오는 페이지
- 현재 로그인 한 사람의 닉네임이 상단바에 노출됨

### - 게시판 페이지

![Untitled 5](https://user-images.githubusercontent.com/107593357/228719372-435f6ecd-2e20-4863-ae06-0424711868d0.png)

- 작성한 글 목록 중 삭제여부가 1(삭제됨)이 아닌 게시글들을 DB에서 조회하여 가져온다.

### - 상세 페이지

![Untitled 6](https://user-images.githubusercontent.com/107593357/228719379-3e35cc12-bf35-4e7d-bb64-c89ad407c583.png)

- 댓글 기능 추후 구현예정
- 글쓴이 == 로그인한 사용자 일 경우 수정, 삭제버튼 활성화

### - 글쓰기 페이지

![Untitled 7](https://user-images.githubusercontent.com/107593357/228719382-832546e5-e895-486b-9385-66129677a0d3.png)

- 새로운 글을 쓸 경우의 페이지는 공백상태

![Untitled 8](https://user-images.githubusercontent.com/107593357/228719519-1eb7b53c-a337-4e57-b601-d3e87f715861.png)

- 기존 글 수정일 경우 제목 및 내용을 불러와서 수정가능

### - 마이페이지

![Untitled 9](https://user-images.githubusercontent.com/107593357/228719580-fbd47808-bc46-4d52-af36-804b6d547724.png)

- 내 정보수정 버튼을 누르면 연령대, 키, 몸무게 부분이 수정가능하게 활성화

![Untitled 10](https://user-images.githubusercontent.com/107593357/228719591-9cbb19e6-cd9c-4263-a839-b1cf5281fbf6.png)

![Untitled 11](https://user-images.githubusercontent.com/107593357/228719602-10b00584-ee77-4a00-aa80-9732bc8a141d.png)

- 회원탈퇴 버튼을 누를 시 alert 메세지를 띄우고 확인을 누르면 로그아웃과 동시에 논리적인 삭제를 진행한다.
