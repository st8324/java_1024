-- 2022년 1학기 컴퓨터 개론을 수강하는 학생들 명단을 조회 
select st_name as 학생이름 from course
	join lecture on co_le_num = le_num
    join student on co_st_num = st_num
    where le_term like '1' and le_name like '컴퓨터 개론' and le_year = 2022;

-- 2022년 1학기에 2022160001 학생이 수강한 과목명을 조회 
select le_name as 과목명 from course
	join lecture on co_le_num = le_num
    where co_st_num like '2022160001';