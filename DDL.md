CREATE TABLE `pj_post` (
`post_idnum`	int(10)	NOT NULL	COMMENT '식별번호',
`title`	varchar(100)	NOT NULL	COMMENT '제목',
`writer`	varchar(14)	NOT NULL	COMMENT '작성자',
`content`	varchar(3000)	NOT NULL	COMMENT '내용',
`view_count`	int(7)	NOT NULL	COMMENT '조회수',
`created_date`	datetime	NULL	DEFAULT current_timestamp()	COMMENT '만든날짜',
`modified_date`	datetime	NULL	DEFAULT current_timestamp()	COMMENT '수정한 날짜',
`user_num`	int(10)	NOT NULL	COMMENT '사용자식별번호'
);

CREATE TABLE `user` (
`user_num`	int(10)	NOT NULL	COMMENT '사용자식별번호',
`user_name`	varchar(20)	NOT NULL	COMMENT '사용자 이름',
`user_sex`	tynyint(1)	NULL	COMMENT '성별',
`user_age_group`	int(1)	NOT NULL	COMMENT '연령대',
`user_id`	varchar(15)	NOT NULL	COMMENT '아이디',
`user_password`	varchar(15)	NOT NULL	COMMENT '비밀번호',
`nickname`	varchar(15)	NOT NULL	COMMENT '닉네임',
`height`	dec(4,1)	NULL	COMMENT '키',
`weight`	dec(4,1)	NULL	COMMENT '몸무게'
);

CREATE TABLE `reply` (
`rep_writer`	varchar(15)	NOT NULL	COMMENT '댓글작성자',
`rep_content`	varchar(2000)	NOT NULL	COMMENT '내용',
`rep_created_time`	datetime	NOT NULL	DEFAULT current_timestamp()	COMMENT '작성날짜',
`post_idnum`	int(10)	NOT NULL	COMMENT '식별번호',
`user_num`	int(10)	NOT NULL	COMMENT '사용자식별번호'
);

ALTER TABLE `pj_post` ADD CONSTRAINT `PK_PJ_POST` PRIMARY KEY (
`post_idnum`
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
`user_num`
);

