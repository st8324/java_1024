use small_jik;
-- null 체크는 is null 또는 is not null 
select * from member where me_name is not null;

-- 문자열에서 특수문자 표현 
select * from member where me_id like '%\_%';