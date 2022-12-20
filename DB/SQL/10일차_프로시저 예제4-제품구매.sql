use shoppingmall;

-- 제품번호, 수량, 배송지, 우편주소, 아이디가 주어지면 제품을 구매하는 프로시저를 작성하세요. 
DROP PROCEDURE IF EXISTS 프로시저명;
DELIMITER //
CREATE PROCEDURE 프로시저명(
	in _num int,
    in _amount int,
    in _address varchar(50),
    in _post_num varchar(10),
    in _id varchar(15)
)
BEGIN
	declare _pr_amount int default 0;
    set _pr_amount = (select pr_amount from product where pr_num = _num);
	if  _pr_amount >= _amount	then
		insert into buy(bu_num, bu_amount, bu_address, bu_post_num, bu_me_id, bu_pr_num)
			values(concat(_id,right(now(),10)),_amount, _address, _post_num, _id, _num);
		
		update product set pr_amount = pr_amount - _amount where pr_num = _num;
    end if;
END //
DELIMITER ;
CALL 프로시저명(1, 5, '서울시 강남', '12345', 'asd');