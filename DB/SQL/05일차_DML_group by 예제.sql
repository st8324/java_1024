/* 
SELECT select_expr
	[FROM table_references]
	[WHERE where_condition]
	[GROUP BY {col_name | expr | position}]
	[HAVING where_condition]
	[ORDER BY {col_name | expr | position}]

group by 
- 같은 속성을 가지는 값으로 묶을 때 사용.
- 여러 속성을 같이 사용하여, 여러 속성이 같은 행들을 묶어서 사용. 
- 집계함수와 같이 사용 
*/
SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
-- 카테고리 별 등록된 제품 수 
select pr_pc_num as '카테고리번호',  count(pr_num) as '카테고리별 등록된 제품 수' 
	from product group by pr_pc_num;
-- 카테고리 별 등록된 제품 수가 최소 2개 이상인 카테고리번호들 
select pr_pc_num as 카테고리번호,  count(pr_num) as '카테고리별 등록된 제품 수' 
	from product 
    group by pr_pc_num
    -- having count(pr_num) >= 2;
    having `카테고리별 등록된 제품 수` >= 2;
    
create view product_view as select * from product;
select * from product_view;
drop view product_view;

-- 카테고리별 가장 비싼 제품의 가격을 조회 
select pr_pc_num as 카테고리번호, max(pr_price) as 가격  from product
	group by pr_pc_num;

-- 사용자별 총 구매 제품 개수를 조회 
select bu_me_id as 아이디, sum(bu_amount) as 구매개수 from buy
	group by bu_me_id;


