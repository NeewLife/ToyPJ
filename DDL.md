CREATE TABLE `pj_post` (
	`post_id`	int(10) auto_increment	NOT NULL	COMMENT '식별번호',
	`title`	varchar(100)	NOT NULL	COMMENT '제목',
	`writer`	varchar(14)	NOT NULL	COMMENT '작성자',
	`content`	varchar(3000)	NOT NULL	COMMENT '내용',
	`view_count`	int(7)	NOT NULL	COMMENT '조회수',
	`created_date`	datetime	NULL	DEFAULT current_timestamp()	COMMENT '만든날짜',
	`modified_date`	datetime	NULL	DEFAULT current_timestamp()	COMMENT '수정한 날짜',
	`delete_yn`	tinyint(1)	NULL	DEFAULT 0	COMMENT '삭제여부',
	`notice_yn`	tinyint(1)	NULL	DEFAULT 0	COMMENT '공지글 여부',
	`id`	int(10)	NOT NULL	COMMENT '사용자식별번호',
	primary key (`post_id`)
);

CREATE TABLE `user` (
	`id`	int(10) auto_increment	NOT NULL	COMMENT '사용자식별번호',
	`name`	varchar(20)	NOT NULL	COMMENT '사용자 이름',
	`sex`	varchar(6)	NULL	COMMENT '성별',
	`age_group`	int(10)	NOT NULL	COMMENT '연령대',
	`user_id`	varchar(15)	NOT NULL	COMMENT '아이디',
	`password`	varchar(100)	NOT NULL	COMMENT '비밀번호',
	`nickname`	varchar(15)	NOT NULL	COMMENT '닉네임',
	`height`	int(10)	NULL	COMMENT '키',
	`weight`	int(10)	NULL	COMMENT '몸무게',
	`delete_yn`	tinyint(1)		NULL	DEFAULT 0	COMMENT '유저 삭제 여부',
	`roles`		varchar(10)		DEFAULT 'USER'		COMMENT '권한',
	primary key (`id`)
);

CREATE TABLE `reply` (
	`rep_writer`	varchar(15)	NOT NULL	COMMENT '댓글작성자',
	`rep_content`	varchar(2000)	NOT NULL	COMMENT '내용',
	`rep_created_time`	datetime	NOT NULL	DEFAULT current_timestamp()	COMMENT '작성날짜',
	`post_id`	int(10)	NOT NULL	COMMENT '식별번호',
	`rep_id`	int(10)	NOT NULL	AUTO_INCREMENT	PRIMARY KEY	COMMENT '댓글식별번호',
	`rep_delete_yn`	tinyint(1)	NOT NULL	DEFAULT 0	COMMENT '댓글삭제여부'
);
