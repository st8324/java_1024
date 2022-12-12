/* 
-- delete문
delete from 테이블명 where 조건절;
-- 조건절에는 일반적으로 기본키가 옴 
*/

-- 3번 카테고리인 문의를 제거하는 쿼리문 
delete from board_category where bc_num = 3;

select * from board_category;
