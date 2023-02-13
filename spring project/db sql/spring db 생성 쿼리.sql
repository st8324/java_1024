drop database if exists spring;

create database if not exists spring;

use spring;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(13)		NOT NULL,
	`me_pw`	varchar(255)	NOT NULL,
	`me_email`	varchar(50)	NOT NULL,
	`me_birthday`	date	NOT NULL,
	`me_authority`	int		NOT NULL default 0,
	`me_join_time`	datetime	NULL
);

DROP TABLE IF EXISTS `member_ok`;

CREATE TABLE `member_ok` (
	`mo_me_id`	varchar(13)	NOT NULL,
	`mo_num`	char(6)	NOT NULL,
	`mo_valid_time`	datetime NOT NULL
);

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
	`bo_num`	int auto_increment	NOT NULL primary key,
	`bo_title`	varchar(50)	NOT NULL,
	`bo_content`	longtext	NOT NULL,
	`bo_register_date`	datetime default now()	NOT NULL,
	`bo_update_date`	datetime	NULL,
	`bo_views`	int default 0	NOT NULL,
	`bo_up`	int default 0	NOT NULL,
	`bo_down`	int default 0	NOT NULL,
	`bo_ori_num`	int	NOT NULL,
	`bo_me_id`	varchar(13)	NOT NULL,
	`bo_bt_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
	`fi_num`	int auto_increment	NOT NULL primary key,
	`fi_ori_name`	varchar(50)	NOT NULL,
	`fi_name`	varchar(255)	NOT NULL,
	`fi_bo_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `board_type`;

CREATE TABLE `board_type` (
	`bt_num`	int auto_increment	NOT NULL primary key,
	`bt_type`	varchar(10)	NOT NULL,
	`bt_name`	varchar(50)	NOT NULL,
	`bt_r_autority`	int	NOT NULL default 0,
	`bt_w_autority`	int	NOT NULL default 1
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
	`co_num`	int auto_increment	NOT NULL primary key,
	`co_content`	longtext	NOT NULL,
	`co_register_date`	datetime	NOT NULL default now(),
	`co_update_date`	datetime	NULL,
	`co_ori_num`	int	NOT NULL,
	`co_me_id`	varchar(13)	NOT NULL,
	`co_bo_num`	int	NOT NULL
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `member_ok` ADD CONSTRAINT `PK_MEMBER_OK` PRIMARY KEY (
	`mo_me_id`
);

ALTER TABLE `member_ok` ADD CONSTRAINT `FK_member_TO_member_ok_1` FOREIGN KEY (
	`mo_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_board_TO_board_1` FOREIGN KEY (
	`bo_ori_num`
)
REFERENCES `board` (
	`bo_num`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_member_TO_board_1` FOREIGN KEY (
	`bo_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_board_type_TO_board_1` FOREIGN KEY (
	`bo_bt_num`
)
REFERENCES `board_type` (
	`bt_num`
);

ALTER TABLE `file` ADD CONSTRAINT `FK_board_TO_file_1` FOREIGN KEY (
	`fi_bo_num`
)
REFERENCES `board` (
	`bo_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_comment_TO_comment_1` FOREIGN KEY (
	`co_ori_num`
)
REFERENCES `comment` (
	`co_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_member_TO_comment_1` FOREIGN KEY (
	`co_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_board_TO_comment_1` FOREIGN KEY (
	`co_bo_num`
)
REFERENCES `board` (
	`bo_num`
);

