-- 회원 등록 
INSERT INTO `small_jik`.`member` (`me_id`, `me_pw`, `me_name`, `me_authority`, `me_point`) 
	VALUES ('abc', 'abc', 'ABC마트', 'MEMBER', '0');
INSERT INTO `small_jik`.`member` (`me_id`, `me_pw`, `me_name`, `me_birth`, `me_authority`, `me_point`) 
	VALUES ('qwe', 'qwe', '홍길동', '2000-01-01', 'MEMBER', '0');
INSERT INTO `small_jik`.`member` (`me_id`, `me_pw`, `me_name`, `me_authority`) 
	VALUES ('admin', 'admin', '관리자', 'ADMIN');
INSERT INTO `small_jik`.`member` (`me_id`, `me_pw`, `me_name`, `me_birth`, `me_authority`, `me_point`) 
	VALUES ('hi', 'hi', '고길동', '2002-12-12', 'MEMBER', '0');

/* 
카테고리 등록
- 의류 
	- 여성
	- 남성
	- 아동 
	- 남녀공용 
- 식품 
	- 과일
	- 채소
    - 과자 
    - 쌀/잡곡 
- 가전 
	- TV 
    - 냉장고
    - 에어컨 
- 스포츠
	- 수영
    - 골프
    - 자전거 
- 문구 
	- 사무용품
    - 미술용품 
*/
insert into main_category(mc_name) values('의류'),('식품'),('가전'),('스포츠'),('문구');
insert into sub_category(sc_name, sc_mc_num) 
	select '여성', mc_num from main_category where mc_name = '의류';
insert into sub_category(sc_name, sc_mc_num) 
	select '남성', mc_num from main_category where mc_name = '의류';
insert into sub_category(sc_name, sc_mc_num) 
	select '아동', mc_num from main_category where mc_name = '의류';
insert into sub_category(sc_name, sc_mc_num) 
	select '남녀공용', mc_num from main_category where mc_name = '의류';

insert into sub_category(sc_name, sc_mc_num) 
	select '과일', mc_num from main_category where mc_name = '식품';
insert into sub_category(sc_name, sc_mc_num) 
	select '채소', mc_num from main_category where mc_name = '식품';
insert into sub_category(sc_name, sc_mc_num) 
	select '과자', mc_num from main_category where mc_name = '식품';
insert into sub_category(sc_name, sc_mc_num) 
	select '쌀/잡곡', mc_num from main_category where mc_name = '식품';

insert into sub_category(sc_name, sc_mc_num) 
	select 'TV', mc_num from main_category where mc_name = '가전';
insert into sub_category(sc_name, sc_mc_num) 
	select '냉장고', mc_num from main_category where mc_name = '가전';
insert into sub_category(sc_name, sc_mc_num) 
	select '에어컨', mc_num from main_category where mc_name = '가전';

insert into sub_category(sc_name, sc_mc_num) 
	select '수영', mc_num from main_category where mc_name = '스포츠';
insert into sub_category(sc_name, sc_mc_num) 
	select '골프', mc_num from main_category where mc_name = '스포츠';
insert into sub_category(sc_name, sc_mc_num) 
	select '자전거', mc_num from main_category where mc_name = '스포츠';

insert into sub_category(sc_name, sc_mc_num) 
	select '사무용품', mc_num from main_category where mc_name = '문구';
insert into sub_category(sc_name, sc_mc_num) 
	select '미술용품', mc_num from main_category where mc_name = '문구';

select * from sub_category;

/* 
abc : 	집, 서울시 강남, 12345
		회사, 서울시 강북, 23456
hi	: 	집, 경기도 안산, 45678
		회사, 서울시 강북, 23456
qwe : 	집, 충북 청주, 32145
		처가, 서울시 강남, 12345
*/
insert into address_book(ab_name, ab_address, ab_post_num, ab_me_id)
	values('집', '서울시 강남', '12345','abc'),
    ('회사', '서울시 강북', '23456','abc'),
    ('집', '경기도 안산', '45678','hi'),
    ('회사', '서울시 강북', '23456','hi'),
    ('집', '충북 청주', '32145','qwe'),
    ('처가', '서울시 강남', '12345','qwe');

/* 
- 의류 - 여성, 반집업 맨투맨, 세컨그라운드 여성용 반집업 맨투맴, 10, 17000
	- 빨강, 노랑, 흰색
- 의류 - 여성, 세미 크롭 맨투맨, 바블링브룩 여성용 세미 크롭 맨투맨,  10, 19900
	- S, M, L 
- 의류 - 남성, 긴판 카라티, 빅사이즈클럽 긴팔 카라티,  20, 24900
	- 흰색 S, 흰색 M, 흰색 L, 남색 S, 남색 M, 남색 L 
- 의류 - 남성, 7부 브이넥 티셔츠, 해리슨 남성용 브이넥 7부 티셔츠,  20, 24900
	- XS, S, M, L, XL
- 의류 - 남녀공용, 기모 조거팬츠, 우드피카 기모 조거팬츠,  5, 24800
	- 24인치, 26인치, 28인치, 30인치, 32인치 
- 의류 - 남녀공용, 슬롭 스키니, 블랙 기모 슬림 스키니,  100, 51840 
	- 60cm, 64cm, 68cm, 72cm
옵션 수량은 전부 5개 
*/
insert into product(pr_title, pr_contents, pr_amount, pr_price, pr_sc_num)
	values('반집업 맨투맨', '세컨그라운드 여성용 반집업 맨투맴', 10, 17000, 1),
    ('세미 크롭 맨투맨', '바블링브룩 여성용 세미 크롭 맨투맨',  10, 19900, 1),
    ('긴팔 카라티', '빅사이즈클럽 긴팔 카라티',  20, 24900,2),
    ('7부 브이넥 티셔츠', '해리슨 남성용 브이넥 7부 티셔츠',  20, 24900,2),
    ('기모 조거팬츠', '우드피카 기모 조거팬츠',  5, 24800,4),
    ('슬롭 스키니', '블랙 기모 슬림 스키니',  100, 51840,4);
insert into product_option(po_title, po_amount, po_pr_num)
	values('빨강', 5, 1), ('노랑', 5, 1), ('흰색', 5, 1), 
    ('S', 5, 2), ('M', 5, 2), ('L', 5, 2),
    ('흰색 S', 5, 3), ('흰색 M', 5, 3), ('흰색 L', 5, 3),
    ('남색 S', 5, 3), ('남색 M', 5, 3), ('남색 L', 5, 3),
    ('XS', 5, 4), ('S', 5, 4), ('M', 5, 4), ('L', 5, 4),('XL', 5, 4),
    ('24인치', 5, 5), ('26인치', 5, 5), ('28인치', 5, 5), ('30인치', 5, 5),('32인치', 5, 5),
    ('60cm', 5, 6), ('64cm', 5, 6), ('68cm', 5, 6), ('72', 5, 6);
select * from product_option;