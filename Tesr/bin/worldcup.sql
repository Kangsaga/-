DROP TABLE member cascade constraints;
DROP TABLE bigdatafc cascade constraints;
DROP TABLE japan cascade constraints;
DROP TABLE germany cascade constraints;
DROP TABLE argentina cascade constraints;
DROP TABLE england cascade constraints;
DROP TABLE france cascade constraints;
DROP TABLE smhrdfc cascade constraints;
DROP TABLE honor cascade constraints;
DROP SEQUENCE mem_id_seq;
drop sequence seq_mid;

CREATE TABLE member
(id varchar2(100),
pw varchar2(20),
nick varchar2(20),
constraint member_id_pk PRIMARY KEY(id),
constraint nickname_uk UNIQUE(nick));

CREATE TABLE bigdatafc
(member_id number(4),
name varchar2(100) not null,
status number(3) not null);

CREATE TABLE japan
(name varchar2(100) not null,
status number(3) not null);

CREATE TABLE germany
(name varchar2(100) not null,
status number(3) not null);

CREATE TABLE argentina
(name varchar2(100) not null,
status number(3) not null);

CREATE TABLE england
(name varchar2(100) not null,
status number(3) not null);

CREATE TABLE france
(name varchar2(100) not null,
status number(3) not null);

CREATE TABLE smhrdfc
(name varchar2(100) not null,
status number(3) not null);

create table honor
(ranking number(20),
nick varchar2(20));

CREATE SEQUENCE mem_id_seq
increment by 1
start with 1
maxvalue 9999;

create sequence seq_mid
	 increment by 1
	 start with 1;

INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'강범수',48);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'권우진',51);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'김동민',65);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'김지은',42);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'김태경',70);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'김혜정',20);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'김희태',70);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'문도연',20);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'박건하',56);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'박나영',46);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'박상민',56);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'박종면',38);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'서하라',39);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'양승호',15);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'이대현',47);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'이동윤',44);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'이승훈',55);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'임지원',54);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'장민서',59);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'장현도',54);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'정준선',45);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'최성규',75);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'최종인',57);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'최찬호',62);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'한국인',52);

INSERT INTO japan
VALUES('카가와 신지',68);
INSERT INTO japan
VALUES('오카자키 신지',57);
INSERT INTO japan
VALUES('미나미노 다쿠미',54);
INSERT INTO japan
VALUES('도미야스 다케히로',48);
INSERT INTO japan
VALUES('하세베 마코토',46);

INSERT INTO germany
VALUES('미하엘 발락',75);
INSERT INTO germany
VALUES('필립 람',74);
INSERT INTO germany
VALUES('마츠 후멜스',70);
INSERT INTO germany
VALUES('토마스 뮐러',66);
INSERT INTO germany
VALUES('토니 크로스',63);

INSERT INTO argentina
VALUES('리오넬 메시',81);
INSERT INTO argentina
VALUES('앙헬 디마리아',71);
INSERT INTO argentina
VALUES('라우타로 마르티네스',66);
INSERT INTO argentina
VALUES('세르히오 아구에로',66);
INSERT INTO argentina
VALUES('파울로 디발라',64);

INSERT INTO england
VALUES('데이비드 베컴',82);
INSERT INTO england
VALUES('웨인 루니',80);
INSERT INTO england
VALUES('풀 스콜스',79);
INSERT INTO england
VALUES('프랭크 램파트',78);
INSERT INTO england
VALUES('스티븐 훔바훔바',77);

INSERT INTO france
VALUES('지네딘 지단',82);
INSERT INTO france
VALUES('티에리 알리',81);
INSERT INTO france
VALUES('킬리안 음바페',80);
INSERT INTO france
VALUES('앙투안 그리즈만',79);
INSERT INTO france
VALUES('폴 포그바',79);

INSERT INTO smhrdfc
VALUES('박병관',96);
INSERT INTO smhrdfc
VALUES('채수민',93);
INSERT INTO smhrdfc
VALUES('김동원',91);
INSERT INTO smhrdfc
VALUES('임승환',90);
INSERT INTO smhrdfc
VALUES('이은비',90);


Select * from japan


