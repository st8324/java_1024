use shoppingmall;

-- 제품명에 TV가 들어가는 제품들을 조회
select * from product where pr_title like '%TV%';
set @a = 'TV';
select @a;
select * from product where pr_title like '%@a%';
select * from product where pr_title like concat('%', @a,'%');

select format(1000000, 0);
-- 파일명이 주어졌을 때 확장자를 추출하는 예제 
select right('test.txt', 3);

-- adddate, subdate
select adddate(now(), interval 1 day);
select adddate(now(), interval 1 week);
select adddate(now(), interval 1 month);
select adddate(now(), interval 1 year);
select subdate(now(), interval 1 year);