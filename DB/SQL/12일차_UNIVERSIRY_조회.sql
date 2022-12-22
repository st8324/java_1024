-- 2022년 1학기 컴퓨터 개론을 수강하는 학생들 명단을 조회 
select st_name as 학생이름 from course
	join lecture on co_le_num = le_num
    join student on co_st_num = st_num
    where le_term like '1' and le_name like '컴퓨터 개론' and le_year = 2022;

-- 2022년 1학기에 2022160001 학생이 수강한 과목명을 조회 
select le_name as 과목명 from course
	join lecture on co_le_num = le_num
    where co_st_num like '2022160001';

-- 2022년 1학기 컴퓨터 개론을 수강하는 학생이름과 학점을 조회 
select st_name as 학생명, co_grade as 학점 from course 
	join student on st_num = co_st_num
    join lecture on le_num = co_le_num
    where le_name like '컴퓨터 개론' and le_year = 2022 and le_term like '1';
    
-- 컴퓨터 공학부 학생명단과 교수 명단을 함께 조회 
select pr_name as '이름', '교수' as 직위 from professor where pr_de_num = 160
union
select st_name as '이름', '학생' as 직위 from student join mojor on mo_st_num = st_num
	where mo_de_num = 160;

-- 2022160001학생의 성적을 조회 
select * from course where co_st_num = '2022160001';

-- 2022160001 학생의 2022년 1학기 평균 학점을 조회 
-- A : 4.5, B : 3.5, C : 2.5, D : 1.5, F:0
-- (4.5 * 3 + 1.5 * 3) / (3+3)=> 18/6 => 3.0
select sum(
case
	when co_grade = 'A' then 4.5
    when co_grade = 'B' then 3.5
    when co_grade = 'C' then 2.5
    when co_grade = 'D' then 1.5
    when co_grade = 'F' then 0
end * le_point
) / sum(le_point) as 평점 from course 
	join lecture on co_le_num = le_num
    where co_st_num = '2022160001' and le_year = 2022 and le_term = '1';
