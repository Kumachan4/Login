# Login
ログイン
eng002の登録
C：\ XAMPP \ MySQL \ BIN \ mysql -u root -p -h localhost

CREATE DATABASE eng002 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use eng002 ;

CREATE TABLE user_master (
 id CHAR(255) not null primary key, 
 name TEXT,
 pass TEXT,
 mail TEXT,
 tel  TEXT,
 rights INT
);

INSERT INTO user_master (id, name, pass, mail, tel, rights) VALUES  ('db_user','db_user_name','db_user','db_user@gmail.com','070-1234-5678',1);
INSERT INTO user_master (id, name, pass, mail, tel,rights ) VALUES ('user1','name1','pas001','mail01@gmail.com','070-2468-1357',0 );
INSERT INTO user_master (id, name, pass, mail, tel,rights ) VALUES ('user2','name2','pas002','mail02@gmail.com','070-1234-1234',1 );
INSERT INTO user_master (id, name, pass, mail, tel,rights ) VALUES ('user3','name3','pas003','mail01@gmail.com','070-1111-2222',1 );
INSERT INTO user_master (id, name, pass, mail, tel,rights ) VALUES ('user4','name4','pas004','mail04@gmail.com','070-3333-4444',1 );
INSERT INTO user_master (id, name, pass, mail, tel,rights ) VALUES ('user5','name5','pas005','mail05@gmail.com','070-5555-6789',1 );

SELECT * FROM user_master ;

INSERT INTO user_master (id, name, pass, mail, tel,rights ) VALUES ('user6','name6','pas000','mail06@gmail.com','070-6666-6789',1 );

UPDATE
 user_master
SET
 pass = 'pas006'
WHERE
 id = 'user6' ;
