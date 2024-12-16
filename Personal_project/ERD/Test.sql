SELECT * FROM authority ORDER BY authorityId DESC;

SELECT * FROM user;
SELECT * FROM chat_room;
SELECT * FROM chat_room_users;
SELECT * FROM message;
SELECT * FROM calendar;
SELECT * FROM department;
SHOW TABLES;

ALTER TABLE user DROP COLUMN role;

DROP TABLE user;
DROP TABLE chat_room;
DROP TABLE chat_room_users;
DROP TABLE message;
DROP TABLE calendar;
DROP TABLE department;

DROP TABLE IF EXISTS user;

DESCRIBE department;

SELECT DISTINCT department FROM user;
