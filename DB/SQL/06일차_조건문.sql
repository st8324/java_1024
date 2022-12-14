/* 
- 조건문
decode(속성, 값, 같으면, 다르면) : 오라클 
if(조건식, 참, 거짓) : mysql 
case
	when 조건식
    then 값 
    when 조건식 
    then 값 
    else 값
end
*/
select pr_title, if(pr_price < 20000, '가격 쌈', '비쌈') as '가격' from product;
select pr_title, 
	if(pr_price < 20000, '가격 쌈', if(pr_price < 30000, '적당', '비쌈')) as '가격' 
    from product;
select pr_title,
	case
		when pr_price < 20000
        then '가격 쌈'
        when pr_price < 30000
        then '적당'
        else '비쌈'
	end as 가격
    from product;
