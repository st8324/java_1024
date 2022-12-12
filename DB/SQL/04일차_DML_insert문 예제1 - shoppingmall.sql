use shoppingmall;

insert into shoppingmall.member(me_id, me_pw, me_name, me_birth, me_authority)
	values('abc', '123', '홍길동', '2000-01-01', 'MEMBER');
-- 전체 열명을 나열하지 않아 가능. 단, 생략한 열이 null 허용이거나 기본값이 존재해야 함 
insert into member(me_id, me_pw, me_name, me_birth)
	values('qwe', '123', '고길동', '2001-01-01');
-- 열 순서를 바꿔도 가능. 단, 열 순서에 맞게 값 순서를 잘 설정. 
insert into member(me_id, me_name, me_birth , me_pw)
	values('asd', '이순신', '2001-01-01' , '123');
-- 열을 전체 생략해도 가능. 단, 테이블 생성 시 추가했던 열 순으로 값들을 입력해야 함. 
insert into member 
	values('qwe123','qwe123', '홍씨', '2002-01-01','MEMBER'),
    ('zxc123','zxc123', '박씨', '2002-01-01','ADMIN');

select * from member;

insert into board_category(bc_name) values('공지'),('자유'),('문의');

insert into board(bo_title, bo_contents, bo_me_id, bo_bc_num)
	values('공지 제목1', '내용1', 'qwe', 1);
    
select * from board_category;

select * from board;