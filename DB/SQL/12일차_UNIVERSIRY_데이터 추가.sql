-- 160, '컴퓨터 공학부', 'KH교육원 1관 1층', '02-123-4567'
-- 123, '기계 공학부', 'KH교육원 1관 2층', '02-123-4568'
-- 135, '전자 공학부', 'KH교육원 2관 3층', '02-123-1234'
insert into department 
values(160, '컴퓨터 공학부', 'KH교육원 1관 1층', '02-123-4567',null),
(123, '기계 공학부', 'KH교육원 1관 2층', '02-123-4568',null),
(135, '전자 공학부', 'KH교육원 2관 3층', '02-123-1234',null);

-- 컴퓨터 공학부에 2022년 홍길동 교수님이 오셨다. 이 때 홍길동 교수님의 정보를 추가하는 작업을 해보세요.
-- 이 때, 교수님 학번은 2022 160 001이 할당 되어야 함. 
-- 교수 정보를 추가하기 위한 프로시저(입학년도, 이름, 학부명, 교수직위, 전화번호)
DROP PROCEDURE IF EXISTS insert_professor;
DELIMITER //
CREATE PROCEDURE insert_professor(
	in _year int,
    in _name varchar(20),
    in _dep varchar(20),
    in _state varchar(10),
    in _tel varchar(13)
)
BEGIN
	declare _dep_num int;
    declare _professor_count int default 0;
    declare _professor_num char(10);
    
    -- _dep_num에 검색 결과인 160이 들어가도록 쿼리를 작성 
    set _dep_num = (select de_num from department where de_name like _dep);
    if _dep_num is not null then
		set _professor_count = 
			(select count(*) + 1 from professor where pr_num like concat(_year,_dep_num,'%'));
        set _professor_num = concat(_year, _dep_num, lpad(_professor_count,3,'0'));
        insert into professor values(_professor_num, _name, _state, _dep_num, _tel);
    end if;
END //
DELIMITER ;
CALL insert_professor(2022, '홍길동', '컴퓨터 공학부', null, null);
CALL insert_professor(2022, '임꺽정', '컴퓨터 공학부', '정교수', '010-1234-5678');

-- 학생 정보 추가를 위한 프로시저(신입생 추가)
-- 2022년에 고길동 학생이 컴퓨터 공학부에 입학하였다. 지도 교수님은 같은 과 홍길동 교수님. 
-- 같은 과에 같은 이름을 가지는 교수가 없다고 가정 
DROP PROCEDURE IF EXISTS insert_student;
DELIMITER //
CREATE PROCEDURE insert_student(
	in _year int,
    in _name varchar(20),
    in _dep varchar(20),
    in _professor_name varchar(20)
)
BEGIN
	declare _dep_num int;
    declare _student_count int default 0;
    declare _student_num char(10);
    declare _professor_num int;
    
    -- _dep_num에 검색 결과인 160이 들어가도록 쿼리를 작성 
    set _dep_num = (select de_num from department where de_name like _dep);
    if _dep_num is not null then
		set _student_count = 
			(select count(*) + 1 from student where st_num like concat(_year,_dep_num,'%'));
        set _student_num = concat(_year, _dep_num, lpad(_student_count,3,'0'));
		set _professor_num = 
			(select pr_num from professor 
				where substring(pr_num,5,3) like _dep_num and pr_name like _professor_name);
        if _professor_num is not null then 
			insert into student 
				values(_student_num, _name, 1, '재학', _professor_num);
			insert into mojor(mo_st_num, mo_de_num) values(_student_num, _dep_num);
        end if;
    end if;
END //
DELIMITER ;
call insert_student(2022, '고길동','컴퓨터 공학부', '홍길동');

-- '컴퓨터 개론', '월1,2', 3, 1, 2022, 1, '2022160001'
-- '자바', '화1,2,3,4', 3, 1, 2022, 1, '2022160002'
insert into lecture 
values(null, '컴퓨터 개론', '월1,2', 3, 1, 2022, 1, '2022160001'),
(null, '자바', '화1,2,3,4', 3, 1, 2022, 1, '2022160002');

call insert_student(2022, '나길동','컴퓨터 공학부', '임꺽정');

-- 고길동 학생이 2022년 1학기 컴퓨터 개론과 2022년 1학기 자바를 수강 
-- 나길동 학생이 2022년 1학기 자바를 수강 

insert into course(co_st_num, co_le_num)
	select '2022160001', le_num from lecture 
		where le_name like '컴퓨터 개론' and le_term like 1 and le_year = 2022;
insert into course(co_st_num, co_le_num)
	select '2022160001', le_num from lecture 
		where le_name like '자바' and le_term like 1 and le_year = 2022;
insert into course(co_st_num, co_le_num)
	select '2022160002', le_num from lecture 
		where le_name like '자바' and le_term like 1 and le_year = 2022;



