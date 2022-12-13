/*
CRUD
- insert : 데이터를 DBMS에 추가 
- select : DBMS에 있는 데이터를 조회 
- update : DBMS에 있는 데이터를 수정 
- delete : DBMS에 있는 데이터를 삭제 

create table ... select
- 기존 테이블 검색 결과를 이용하여 새 테이블을 생성
- 제약 조건은 복사가 안됨(외래키와 같은) 
- 검색된 데이터들이 추가 됨 
*/
select * from board;
create table board2(
	select 
		bo_num as num, 
        bo_title as title, 
        bo_contents as contents,
        bo_reg_date as reg_date,
        bo_views as views,
        bo_me_id as writer 
	from board);
select * from board2;
