
--회원가입
create table sp_user(
 userid varchar2(50),
 email varchar2(100) not null,
 enabled char(1) default '1',
 password varchar2(100) not null
);

alter table sp_user add constraint sp_user_pk primary key(userid);

--회원에 대한 권한 정보
create table sp_user_authority(
  userid varchar2(50) not null,
  authority varchar2(50) not null
);

alter table sp_user_authority add constraint sp_user_authority_fk foreign key(userid)
references sp_user(userid);


insert into sp_user (userid, email, password) values('1','user@test.com','1111');

insert into SP_USER_AUTHORITY (userid, authority) values('1','ROLE_USER');
insert into SP_USER_AUTHORITY (userid, authority) values('1','ROLE_ADMIN');

--1번 회원에 대한 회원정보와 권한 정보를 조회
select u.userid, email, password, enabled, authority
from sp_user u join sp_user_authority a on u.userid = a.userid
where u.userid='1';

select * from sp_user;

select * from sp_user_authority;



--remember me 테이블 생성
create table persistent_logins (
  username varchar(64) not null,
  series varchar(64) not null,
  token varchar(64) not null,
  last_used timestamp not null
);

select * From persistent_logins;

