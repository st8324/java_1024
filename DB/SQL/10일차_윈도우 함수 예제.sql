use shoppingmall;
/* 
순위 함수 : row_number(), dense_rank(), rank(), ntitle()
- row_number() : 
  - 같은 값이 있을 때 등수가 서로 다름 
- dense_rank() : 
  - 같은 값이 있을 때 등수가 같음
  - 같은 값이 있는 행 다음 등수는 같은 값이 있는 등수 + 1
- rank()
  - 같은 값이 있을 때 등수가 같음
  - 같은 값이 있는 행 다음 등수는 같은 값이 있는 등수 + 같은 값이 있는 개수
- ntile(n)
  - 등수를 총 n등까지 분할 
*/
select 
	row_number() over(order by pr_amount desc) as 보유량순위,
    pr_title as 제품명,
    pr_amount as 보유량
from product;
select 
	row_number() over(order by pr_price desc) as 가격순위,
    pr_title as 제품명,
    pr_price as 제품가격
from product;
select 
	dense_rank() over(order by pr_price desc) as 가격순위,
    pr_title as 제품명,
    pr_price as 제품가격
from product;
select 
	rank() over(order by pr_price desc) as 가격순위,
    pr_title as 제품명,
    pr_price as 제품가격
from product;

select 
	ntile(3) over(order by pr_price desc) as 가격순위,
    pr_title as 제품명,
    pr_price as 제품가격
from product;
/* 
- lead(속성) : 속성의 다음 값을 가져옴
- lead(속성, n, x) : 속성의 다음 n개의 값을 가져오고 없으면 x로 대체 
- lag(속성) : 속성의 이전 값을 가져옴
- lag(속성, n, x) : 속성의 이전 n개의 값을 가져오고 없으면 x로 대체 
- first_value(속성) : 속성의 첫번째 값
- cume_dist() : 백분율 
*/
select *,  lead(pr_title) over(ORDER BY pr_num asc) as 다음행값 from product;
select 
	row_number() over(order by pr_price desc)
	pr_title,pr_price,  
    pr_price - lead(pr_price,1,pr_price) over(ORDER BY pr_price desc) as 가격차이 
from product;
select 
	row_number() over(order by pr_price desc)
	pr_title,pr_price,  
    pr_price - lag(pr_price,1,pr_price) over(ORDER BY pr_price desc) as 가격차이 
from product;
select 
	row_number() over(order by pr_price desc)
	pr_title,pr_price,  
    pr_price - first_value(pr_price) over(ORDER BY pr_price desc) as 가격차이 
from product;
select 
	row_number() over(order by pr_price desc)
	pr_title,pr_price,  
    cume_dist() over(ORDER BY pr_price desc)*100 as 백문율
from product;

select pr_pc_num as 분류번호, avg(pr_price) as 평균가격 
	from product
	group by(pr_pc_num);
with product_avg(분류번호, 평균가격)
	as
	(select pr_pc_num, avg(pr_price) from product group by(pr_pc_num))
select * from product_avg order by 분류번호 asc;