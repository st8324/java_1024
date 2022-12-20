set @num = 10; -- @num에 10을 저장 
select @num := 20; -- @num에 20을 저장한 후, 출력 
select @num;
select @@sql_mode; -- 시스템변수(글로벌변수) sql_mode를 조회 

show variables; -- 시스템변수들을 조회 

-- 실수 1.23을 정수 1로 변환 
select cast(1.23 as signed integer);
select convert(1.23 , signed integer);