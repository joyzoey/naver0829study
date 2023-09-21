--퀴즈
-- 시퀀스:seq_food 생성
-- 레스토랑의 메뉴 테이블 (테이블명 : food)
-- food_num 숫자(5) 기본키, fname 문자열(20) :메뉴명, fprice 숫자(7) : 가격
create SEQUENCE seq_food nocache;

create table food(
   food_num number(5) CONSTRAINT food_pk_foodnum primary key,
   fname varchar2(20),
   fprice number(7)
);

--sub 테이블은 : 고객 테이블 (person)
-- person_num 숫자(5) 기본키, food_num 외부키 설정(cascade 설정)
-- person_name 문자열(10) : 고객명
-- 예약일: bookingday : date 타입
create table person(
   person_num number(5) CONSTRAINT person_pk_personnum primary key,
   food_num number(5),
   person_name varchar2(10),
   bookingday date
);

alter table person add constraint person_fk_foodnum FOREIGN key(food_num) REFERENCES food(food_num) on delete cascade;

--food 에 5개의 메뉴를 등록하자(스파게티,떡볶이 등등등..)
 insert into food values (seq_food.nextval,'스파게티',10000);
 insert into food values (seq_food.nextval,'떡볶이',15000);
 insert into food values (seq_food.nextval,'피자',20000);
 insert into food values (seq_food.nextval,'리조또',12000);
 insert into food values (seq_food.nextval,'치킨',30000);
 commit;
 
--주문한 고객정보를 추가해보자(같은 메뉴를 여러명 주문하기도 함..)
insert into person values (seq_food.nextval,1,'김나혜',sysdate);
insert into person values (seq_food.nextval,1,'이서연',sysdate);
insert into person values (seq_food.nextval,2,'김소연',sysdate);
insert into person values (seq_food.nextval,3,'김건훈',sysdate);
insert into person values (seq_food.nextval,4,'최승범',sysdate);
commit;

--조회 : 시퀀스(food_num),주문자명,음식명, 가격,예약일 (제목도 한글로 주기)
select
   f.food_num 메뉴번호,person_name 주문자명,fname 메뉴명,fprice 가격,
   to_char(bookingday,'yyyy-mm-dd') 예약일
from food f,person p
where f.food_num=p.food_num;

-- 메뉴중 스파게티를 삭제시 주문한 테이블에서도 지워지는지 확인
delete from food where food_num=1;
insert into food values (seq_food.nextval,'스파게티',10000);