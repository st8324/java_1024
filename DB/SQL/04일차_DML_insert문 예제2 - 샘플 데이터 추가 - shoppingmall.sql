use shoppingmall;
-- 제품 카테고리에 가전, 의류, 식품, 취미용품, 애견용품을 추가하는 쿼리를 작성하세요. 
insert into product_category(pc_name) 
	values('가전'),('의류'),('식품'),('취미용품'),('애견용품');

select * from product_category;

-- 가전, 50인치 TV, 50인치 TV 팜, 10대, 10000원
-- 가전, 100인치 TV, 100인치 TV 팜, 20대, 100000원
-- 가전, 무풍 에어컨, 무풍 에어컨 팜, 30대, 200000원
-- 의류, 셔츠, 겨울용 셔츠 팜, 15개, 1000원
-- 식품, 스테이크, 부드러운 스테이크 팜, 40개, 2000원 
-- 취미용품, 등산화, 안전환 등산화, 5개, 5000원
-- 애견용품, 개껌, 오래가는 개껌, 3개, 10000원 
insert into product(pr_title, pr_contents, pr_amount, pr_price, pr_pc_num)
	values('50인치 TV', '50인치 TV 팜',10, 10000,1),
    ('100인치 TV', '100인치 TV 팜', 20, 100000, 1),
    ('무풍 에어컨', '무풍 에어컨 vka', 30, 200000, 1),
    ('셔츠','겨울용 셔츠 팜', 15, 1000, 2),
    ('스테이크', '부드러운 스테이크 팜', 40, 2000, 3),
    ('등산화', '안전한 등산화', 5, 5000, 4),
    ('개껌', '오래가는 개껌', 3, 10000, 5);

select * from product;
-- abc 회원이 50인치 TV 1대를 구매 함. 주소는 서울시 강남, 우편번호는 12345
-- 이 때 실행되야 하는 쿼리를 작성하세요. 
-- buy 테이블 - insert문
-- product 테이블 - update문 
insert into 
	buy(bu_num, bu_state, bu_amount, bu_address, bu_post_num, bu_me_id, bu_pr_num)
	values('abc1', '결재완료', 1, '서울시 강남', '12345', 'abc', 1);
select * from buy;  
update product
	set
		pr_amount = pr_amount - 1
	where pr_num = 1;
    
select * from product;

/* 
- insert values문 : 추가하는 값들을 모두 알고 있는 경우 
insert into 테이블명 values();
- insert select문 : 일부 값들이 검색을 통해 가져와야 하는 경우 
insert into 테이블명 select ...
*/
-- 식품, 음료수, 콜라, 100개, 1000원
insert into product(pr_title, pr_contents, pr_amount, pr_price, pr_pc_num)
	select '음료수', '콜라', 100, 1000, pc_num from product_category
		where pc_name = '식품';
select * from product;
    