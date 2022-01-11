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
VALUES(mem_id_seq.NEXTVAL,'������',48);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'�ǿ���',51);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'�赿��',65);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'������',42);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'���°�',70);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'������',20);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'������',70);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'������',20);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'�ڰ���',56);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'�ڳ���',46);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'�ڻ��',56);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'������',38);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'���϶�',39);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'���ȣ',15);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'�̴���',47);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'�̵���',44);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'�̽���',55);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'������',54);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'��μ�',59);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'������',54);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'���ؼ�',45);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'�ּ���',75);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'������',57);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'����ȣ',62);
INSERT INTO bigdatafc
VALUES(mem_id_seq.NEXTVAL,'�ѱ���',52);

INSERT INTO japan
VALUES('ī���� ����',68);
INSERT INTO japan
VALUES('��ī��Ű ����',57);
INSERT INTO japan
VALUES('�̳��̳� �����',54);
INSERT INTO japan
VALUES('���߽̾� ��������',48);
INSERT INTO japan
VALUES('�ϼ��� ������',46);

INSERT INTO germany
VALUES('���Ͽ� �߶�',75);
INSERT INTO germany
VALUES('�ʸ� ��',74);
INSERT INTO germany
VALUES('���� �ĸὺ',70);
INSERT INTO germany
VALUES('�丶�� ����',66);
INSERT INTO germany
VALUES('��� ũ�ν�',63);

INSERT INTO argentina
VALUES('������ �޽�',81);
INSERT INTO argentina
VALUES('���� �𸶸���',71);
INSERT INTO argentina
VALUES('���Ÿ�� ����Ƽ�׽�',66);
INSERT INTO argentina
VALUES('�������� �Ʊ�����',66);
INSERT INTO argentina
VALUES('�Ŀ�� ��߶�',64);

INSERT INTO england
VALUES('���̺�� ����',82);
INSERT INTO england
VALUES('���� ���',80);
INSERT INTO england
VALUES('Ǯ ���ݽ�',79);
INSERT INTO england
VALUES('����ũ ����Ʈ',78);
INSERT INTO england
VALUES('��Ƽ�� �ɹ��ɹ�',77);

INSERT INTO france
VALUES('���׵� ����',82);
INSERT INTO france
VALUES('Ƽ���� �˸�',81);
INSERT INTO france
VALUES('ų���� ������',80);
INSERT INTO france
VALUES('������ �׸��',79);
INSERT INTO france
VALUES('�� ���׹�',79);

INSERT INTO smhrdfc
VALUES('�ں���',96);
INSERT INTO smhrdfc
VALUES('ä����',93);
INSERT INTO smhrdfc
VALUES('�赿��',91);
INSERT INTO smhrdfc
VALUES('�ӽ�ȯ',90);
INSERT INTO smhrdfc
VALUES('������',90);


Select * from japan


