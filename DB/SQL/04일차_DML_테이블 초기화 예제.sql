drop table test;
create table test(
	num int auto_increment primary key,
    name varchar(10)
);
insert into test(name) values('1'),('2'),('3'),('4'),('5');

delete from test;
-- 번호가 6번부터 시작 
insert into test(name) values('1'),('2'),('3'),('4'),('5');

truncate table test;
-- 번호가 1번부터 시작 
insert into test(name) values('1'),('2'),('3'),('4'),('5');

select * from test;

/*
- delete로 초기화 : 데이터만 삭제, 쓰던 공간은 그대로. AI로 증가된 숫자 초기화 안됨.
- truncate로 초기화 : 최초 테이블이 만들어졌던 상태로 돌림. 
    공간도 같이 삭제, AI로 증가된 숫자도 초기화
- drop으로 초기화 : 테이블을 삭제, 제약조건 포함하여 모두 삭제 
*/