-- 가전 제품을 조회 
select * from product 
	where pr_pc_num = 
		(select pc_num from product_category where pc_name = '가전');
-- 제품명으로 TV를 검색하여 조회 
select * from product where pr_title like '%TV%';

-- abc회원이 구매확정한 목록을 조회 
-- buy 테이블 조회
select * from buy where bu_me_id='abc' and bu_state ='구매확정';
