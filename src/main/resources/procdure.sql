DROP PROCEDURE IF EXISTS insert_boards;

-- 프로시저 생성
CREATE PROCEDURE insert_boards()
BEGIN
    DECLARE i INT DEFAULT 1;

    -- 1000건의 데이터 삽입
    WHILE i <= 1000 DO
            INSERT INTO boards (title, userid, contents)
                VALUES ('', 'abc123', '');
            INSERT INTO boards (title, userid, contents)
                VALUES ('', '987xyz', '');
            INSERT INTO boards (title, userid, contents)
                VALUES ('', '냐옹냐옹', '');
            SET i = i + 1;
        END WHILE;
END;

-- 프로시저 호출
CALL insert_boards();