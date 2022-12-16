drop database if exists cgv;

create database if not exists cgv;

use cgv;

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
	`mo_num`	int auto_increment	NOT NULL primary key,
	`mo_title`	varchar(50)	NULL,
	`mo_contents`	longtext	NULL,
	`mo_age`	varchar(10)	NULL,
	`mo_run`	int	NULL,
	`mo_opening_date`	date	NULL,
	`mo_state`	varchar(10)	NULL
);

DROP TABLE IF EXISTS `movie_person`;

CREATE TABLE `movie_person` (
	`mp_num`	int auto_increment	NOT NULL primary key,
	`mp_name`	varchar(50)	NULL,
	`mp_birth`	date	NULL,
	`mp_contry`	varchar(50)	NULL
);

DROP TABLE IF EXISTS `movie_casting`;

CREATE TABLE `movie_casting` (
	`mc_num`	int auto_increment	NOT NULL primary key,
	`mc_mp_num`	int	NOT NULL,
	`mc_mo_num`	int	NOT NULL,
	`mc_role`	varchar(10)	NULL
);

DROP TABLE IF EXISTS `genre`;

CREATE TABLE `genre` (
	`ge_name`	varchar(10)	NOT NULL primary key
);

DROP TABLE IF EXISTS `movie_genre`;

CREATE TABLE `movie_genre` (
	`mg_num`	int auto_increment	NOT NULL primary key,
	`mg_ge_name`	varchar(10)	NOT NULL,
	`mg_mo_num`	int NOT NULL
);

DROP TABLE IF EXISTS `trailer`;

CREATE TABLE `trailer` (
	`tr_num`	int auto_increment	NOT NULL primary key,
	`tr_title`	varchar(50)	NULL,
	`tr_file_name`	varchar(100)	NULL,
	`tr_mo_num`	int NOT NULL
);

DROP TABLE IF EXISTS `stillcut`;

CREATE TABLE `stillcut` (
	`st_num`	int auto_increment	NOT NULL primary key,
	`st_file_name`	varchar(100)	NULL,
	`st_mo_num`	int NOT NULL
);

DROP TABLE IF EXISTS `region`;

CREATE TABLE `region` (
	`re_name`	varchar(10)	NOT NULL primary key
);

DROP TABLE IF EXISTS `theater`;

CREATE TABLE `theater` (
	`th_num`	int auto_increment	NOT NULL primary key,
	`th_name`	varchar(20)	NULL,
	`th_lot_address`	varchar(50)	NULL,
	`th_address`	varchar(50)	NULL,
	`th_trans_info`	longtext	NULL,
	`th_parking_info`	longtext	NULL,
	`th_number`	varchar(10)	NULL,
	`th_total_cinema`	int	NULL,
	`th_total_seat`	int	NULL,
	`th_re_name`	varchar(10)	NOT NULL
);

DROP TABLE IF EXISTS `cinema`;

CREATE TABLE `cinema` (
	`ci_num`	int auto_increment	NOT NULL primary key,
	`ci_name`	varchar(50)	NULL,
	`ci_seat_count`	int	NULL,
	`ci_type`	varchar(20)	NULL,
	`ci_th_num`	int NOT NULL
);

DROP TABLE IF EXISTS `seat`;

CREATE TABLE `seat` (
	`se_num`	int auto_increment	NOT NULL primary key,
	`se_name`	varchar(10)	NULL,
	`se_state`	varchar(10)	NULL,
	`se_ci_num`	int NOT NULL,
	`se_price`	int	NULL
);

DROP TABLE IF EXISTS `screen_schedule`;

CREATE TABLE `screen_schedule` (
	`ss_num`	int auto_increment	NOT NULL primary key,
	`ss_date`	date	NULL,
	`ss_time`	time	NULL,
	`ss_total_seat`	int	NULL,
	`ss_possible_seat`	int	NULL,
	`ss_mo_num`	int	NOT NULL,
	`ss_ci_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(20)	NOT NULL primary key,
	`me_pw`	varchar(50)	NULL,
	`me_movie_count`	int	NULL
);

DROP TABLE IF EXISTS `ticketing`;

CREATE TABLE `ticketing` (
	`ti_num`	int auto_increment	NOT NULL primary key,
	`ti_amount`	int	NULL,
	`ti_me_id`	varchar(20)	NOT NULL,
	`ti_ss_num`	int	NOT NULL,
	`ti_total_price`	int	NULL
);

DROP TABLE IF EXISTS `ticketing_seat`;

CREATE TABLE `ticketing_seat` (
	`ts_num`	int auto_increment	NOT NULL primary key,
	`ts_ti_num`	int NOT NULL,
	`ts_se_num`	int NOT NULL
);

ALTER TABLE `movie_casting` ADD CONSTRAINT `FK_movie_person_TO_movie_casting_1` FOREIGN KEY (
	`mc_mp_num`
)
REFERENCES `movie_person` (
	`mp_num`
);

ALTER TABLE `movie_casting` ADD CONSTRAINT `FK_movie_TO_movie_casting_1` FOREIGN KEY (
	`mc_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_genre_TO_movie_genre_1` FOREIGN KEY (
	`mg_ge_name`
)
REFERENCES `genre` (
	`ge_name`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_movie_TO_movie_genre_1` FOREIGN KEY (
	`mg_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `trailer` ADD CONSTRAINT `FK_movie_TO_trailer_1` FOREIGN KEY (
	`tr_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `stillcut` ADD CONSTRAINT `FK_movie_TO_stillcut_1` FOREIGN KEY (
	`st_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `theater` ADD CONSTRAINT `FK_region_TO_theater_1` FOREIGN KEY (
	`th_re_name`
)
REFERENCES `region` (
	`re_name`
);

ALTER TABLE `cinema` ADD CONSTRAINT `FK_theater_TO_cinema_1` FOREIGN KEY (
	`ci_th_num`
)
REFERENCES `theater` (
	`th_num`
);

ALTER TABLE `seat` ADD CONSTRAINT `FK_cinema_TO_seat_1` FOREIGN KEY (
	`se_ci_num`
)
REFERENCES `cinema` (
	`ci_num`
);

ALTER TABLE `screen_schedule` ADD CONSTRAINT `FK_movie_TO_screen_schedule_1` FOREIGN KEY (
	`ss_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `screen_schedule` ADD CONSTRAINT `FK_cinema_TO_screen_schedule_1` FOREIGN KEY (
	`ss_ci_num`
)
REFERENCES `cinema` (
	`ci_num`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_member_TO_ticketing_1` FOREIGN KEY (
	`ti_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_screen_schedule_TO_ticketing_1` FOREIGN KEY (
	`ti_ss_num`
)
REFERENCES `screen_schedule` (
	`ss_num`
);

ALTER TABLE `ticketing_seat` ADD CONSTRAINT `FK_ticketing_TO_ticketing_seat_1` FOREIGN KEY (
	`ti_num`
)
REFERENCES `ticketing` (
	`ti_num`
);

ALTER TABLE `ticketing_seat` ADD CONSTRAINT `FK_seat_TO_ticketing_seat_1` FOREIGN KEY (
	`se_num`
)
REFERENCES `seat` (
	`se_num`
);

