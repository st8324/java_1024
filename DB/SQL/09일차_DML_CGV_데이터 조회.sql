-- 아바타-물의 길에 출연한 감독 및 배우들을 조회하는 쿼리
select mo_title as 영화제목, mp_name as 영화인, mc_role as 역할 from movie_person 
	join movie_casting on mc_mp_num = mp_num
    join movie on mo_num = mc_mo_num
	where mo_title like '아바타-물의 길';

-- 제임스 카메론의 참여 영화 리스트를 조회하는 쿼리 
select mo_title as 영화제목, mc_role as 역할 from movie_person 
	join movie_casting on mc_mp_num = mp_num
    join movie on mo_num = mc_mo_num
    where mp_name like '제임스 카메론';
    
-- 아바타 누적 관객 수를 조회하는 쿼리 
select sum(ti_amount) as '아바타 누적관객수' from ticketing
	join screen_schedule on ti_ss_num = ss_num
    join movie on ss_mo_num = mo_num
    where now() >= ss_date and mo_title like '아바타-물의 길';

-- 누적 관색 수가 1명 이상인 영화를 조회하는 쿼리 
select mo_title as 영화제목, sum(ti_amount) as '누적관객수' from ticketing
	join screen_schedule on ti_ss_num = ss_num
    join movie on ss_mo_num = mo_num
    where now() >= ss_date 
    group by mo_num
    having `누적관객수` >= 1;

-- abc회원이 예매한 올빼미 상영좌석을 조회(관이름과 좌석번호 조회)
select se_name as 'abc회원이 예매한 영화 올빼미 좌석' from ticketing 
	join screen_schedule on ss_num = ti_ss_num
    join movie on mo_num = ss_mo_num
    join ticketing_seat on ts_ti_num = ti_num
    join seat on ts_se_num = se_num
    where mo_title like '올빼미' and ti_me_id like 'abc';

-- 올빼미 12월 20일 13:50 상영에 예매 가능한 좌석을 조회 
-- screen_schedule, moview, ticketing, ticketing_seat, seat
select mo_title as 영화제목, se_name as 좌석명, 
	case 
		when ts_num is null
        then 'O'
        else 'X'
	end as 가능여부
from 
(select * from screen_schedule where ss_date = '2022-12-20' and ss_time = '13:50') as ss
	join (select * from movie where mo_title like '올빼미') as mo 
		on ss_mo_num = mo_num
	join cinema 
		on ss_ci_num = ci_num
    join seat
		on se_ci_num = ci_num
	left join ticketing
		on ti_ss_num = ss_num
	left join ticketing_seat
		on ts_se_num = se_num;

-- screen_schedule에 영화 제목 속성을 추가하면 movie 테이블과 join을 하지 않아도 됨. 단, 데이터는 중복 
-- ticekting_seat에 좌석 이름을 추가하면 좌석명을 알기 위해 seat 테이블과 join하지 않아도 됨.

-- 영화별 누적 관객 수를 조회 
 select mo_title as 영화제목, ifnull(sum(ti_amount), 0) as 관객수 from movie 
	left join (select * from screen_schedule where ss_date <= now() ) as ss
		on ss_mo_num = mo_num
    left join ticketing on ti_ss_num = ss_num
    group by mo_num;

-- 영화 순위(누적별 관객 수)를 조회 
 select mo_title as 영화제목, ifnull(sum(ti_amount), 0) as 관객수 from movie 
	left join (select * from screen_schedule where ss_date <= now() ) as ss
		on ss_mo_num = mo_num
    left join ticketing on ti_ss_num = ss_num
    group by mo_num
    order by 관객수 desc;
    


-- 'abc' 회원이 본 영화 목록 개수 
select count(distinct ss_mo_num) from ticketing
	join screen_schedule on ss_num = ti_ss_num
    where ss_date < now();
