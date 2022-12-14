-- abc회원이 반집업 맨투맨(1번제품) 빨강을 2개 장바구니에 담았다. 이때 실행되어야 하는 쿼리를 작성하세요.
-- select/insert/update/delete
-- 주소록/장바구니/메인카/서브카/회원/주문/주문리/제품/제품옵/
insert into basket(ba_amount, ba_me_id, ba_po_num)
	values(2, 'abc', 1);
-- select 2,'abc', po_num from product_option where po_pr_num = 1 and po_title = '빨강';

-- abc회원이 장바구니에 담긴 모든 제품을 구매. 이때 실행되어야 하는 쿼리를 작성하세요. 
-- 적립 포인트는 제품 금액의 10%. 사용 포인트는 X. 배송지는 집 
-- 주문 내역에 데이터 추가 
insert into 
	`order`(or_total_price, or_price, or_use_point, or_add_point, or_me_id, or_ab_num)
    values(17000*2, 17000*2, 0, 17000*2/10, 'abc', 1);
--   select pr_price*2, pr_price*2, 0, floor(pr_price*2/10), 'abc', 1 
-- 		from product where pr_num = 1; 
-- 주문 리스트에 데이터 추가 
insert into order_list(ol_amount, ol_price, ol_po_num, ol_or_num)
	values(2, 17000, 1, 1);
-- 제품 옵션에 제고를 변경 
UPDATE product_option 
SET 
    po_amount = po_amount - 2
WHERE
    po_num = 1;


