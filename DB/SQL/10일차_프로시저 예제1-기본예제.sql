/*
DROP PROCEDURE IF EXISTS procedure_name; -- 이미 프로시저가 정의 되어 있다면 삭제 
DELIMITER // -- //대신 다른 문자로 대체 가능 
CREATE PROCEDURE procedure_name 
([ 
    [ IN | OUT ] parameter_name 
    { parameter_type | ARRAY OF parameter_type }, ... 
]) 
[ DECLARE variable_declaration;...[;] ] 
BEGIN 
    procedure_body_statement;...[;] 
END // 
DELIMITER ;
*/

DROP PROCEDURE IF EXISTS TEST1;
DELIMITER //
CREATE PROCEDURE TEST1()
BEGIN
	SHOW DATABASES;
END //
DELIMITER ;

CALL TEST1();


DROP PROCEDURE IF EXISTS TEST2;
DELIMITER //
CREATE PROCEDURE TEST2(
	IN NUM INT,
    OUT OUT_NUM INT
)
BEGIN
	SELECT NUM;
    SET OUT_NUM = NUM;
END //
DELIMITER ;

SET @T_NUM = 0;
CALL TEST2(2, @T_NUM);
SELECT @T_NUM;
