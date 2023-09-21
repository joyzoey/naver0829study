--2023-09-21 DB정규화
--DB 정규화(Normalization)
--정규화란? 한마디로 db서버의 메모리를 낭비하지 않기 위해서
--어떤 테이블을 식별자를 가지는 여러개의 테이블로 나누는 과정을 정규화라 한다
--정규화된 데이타베이스는 중복이 최소화되도록 설계된 데이타베이스이다
--장점:메모리 절약, 구조화된 시스템으로 인해 관리 간편
--단점 : 조회비율이 매우 높은 시스템의 경우, 질의응답속도 늦어짐 (테이블간 조인 연산이 반복적으로 이뤄지기때문)

--student의 num을 외부키로 갖는 새로운 테이블 stuinfo 만들기
--외부키는 테이블 생성시 설정 가능, 나중에 설정 가능, 지금은 나중설정으로 진행

create table stuinfo (
    idx number(5) constraint stuinfo_pk_idx primary key,
    num number(5),
    addr varchar2(20),
    hp varchar2(20));

    
--student num을 외부키로 설정 ppt29p (이때주의:student의 num은 반드시 primary key여야만 한다)
alter table stuinfo add constraint stuinfo_fk_num foreign KEY(num) REFERENCES student(num);

--stuinfo에 데이터 추가
insert into stuinfo values (seq_stu.nextval, 9, '서울시 강남구','010-2323-4545');
--없는 번호인 9번으로 insert시 : 무결성제약조건-부모키가 없습니다.
--student 테이블이 부모테이블, 거기에 num9가 없기 때문에 오류 발생
insert into stuinfo values (seq_stu.nextval, 3, '동대문구','010-8250-0305');--김나혜
insert into stuinfo values (seq_stu.nextval, 6, '제주도','010-1230-1235');--모형난
insert into stuinfo values (seq_stu.nextval, 8, '부산','010-1234-1234'); --김소연

--stuinfo만 조회
select * from stuinfo;

--student만 조회
select* from student;

--개인정보가 등록된 학생에 한해서 모든 정보를 출력-inner join,equi join
select 
    stu.name,stu.java,stu.spring,stu.ban,info.addr,info.hp
from student stu,stuinfo info
where stu.num=info.num;

--컬럼명 앞에 무조건 어느 테이블 소속인지 붙였는데
--양쪽에 같은 컬럼이 없다면 생략해도 된다.
select 
    stu.num,name,java,spring,ban,addr,hp
from student stu,stuinfo info
where stu.num=info.num;

--개인정보가 등록되지 않은 학생들을 출력-outter join
--sub table dp(+)
select 
    stu.name,stu.java,stu.spring,stu.ban,info.addr,info.hp
from student stu,stuinfo info
where stu.num=info.num(+);

--위의 결과에 null인 학생만 출력
select 
    stu.name,stu.java,stu.spring,stu.ban,info.addr,info.hp
from student stu,stuinfo info
where stu.num=info.num(+) and info.addr is null;

--sub 테이블에 연결된 데이터가 있는데 부모테이블(student)의 해당 데이터를 삭제하고자 할 경우
delete from student where num=3;--오류 : 무결성 제약조건(ANGEL.STUINFO_FK_NUM)이 위배되었습니다- 자식 레코드가 발견되었습니다
delete from student where num=1;--지워짐, sub테이블에 데이타가 없기 때문

--student의 3번 데이터를 지워보자
delete from stuinfo where num=3;--자식 삭제후
delete from student where num=3;--부모 삭제가능

--부모 테이블 drop
drop table student;--오류:외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다

--자식 테이블 drop
drop table stuinfo;

-------------------------------------------------------------------------------------
--상품 정보를 담을 shop 테이블
--장바구니에 담을 cart 테이블
--시퀀스도 새로 하나 만들어보자
create SEQUENCE seq_shop start with 10 increment by 10 nocache;

--shop table 생성
create table shop (
    sang_no number(5) constraint shop_pk_no primary key,
    sang_name varchar2(100),
    sang_price number(7),
    sang_color varchar2(20)
);

--외부키로 연결된 cart테이블 생성
create table cart(
    cart_no number(5) constraint cart_pk_no primary key,
    sang_no number(5),
    cnt number(5),
    cartday date
);
--상품정보 저장을 위해 shop의 num을 외부키로 설정
--상품을 삭제하면 장바구니의 해당데이터가 자동으로 삭제되도록 on delete cascade 설정
alter table cart add constraint cart_fk_shopno FOREIGN key(sang_no) REFERENCES shop(sang_no) on DELETE CASCADE;

--model (ERD)확인
--5개 상품 등록
insert into shop values (seq_shop.nextval,'블라우스',23000,'yellow');
insert into shop values (seq_shop.nextval,'청바지',45000,'black');
insert into shop values (seq_shop.nextval,'브이넥티',11000,'white');
insert into shop values (seq_shop.nextval,'브이넥티',23000,'red');
insert into shop values (seq_shop.nextval,'체크자켓',13000,'gray');
commit;

--cart에 블라우스, 브이넥티(white),체크자켓 3개에 대해 추가--현재날짜로
insert into cart values (seq_shop.nextval,10,seq_shop.nextval,sysdate);
insert into cart values (seq_shop.nextval,30,seq_shop.nextval,sysdate);
insert into cart values (seq_shop.nextval,50,seq_shop.nextval,sysdate);--sysdate는 다 저장됨

--전체조회(outter join)
select
    sang_name, s.sang_no,sang_price,sang_color,cnt, to_char(cartday,'yyyy-mm-dd hh24:mi')cartday
from shop s, cart c
where s.sang_no=c.sang_no(+);

--카트에 담지 않은 상품만 조회(inner join)
select 
    sang_name, sang_price, sang_color
from shop, cart
where shop.sang_no=cart.sang_no(+) and cartday is null;

--cascade를 지정했으므로 cart에 담긴 상품도 삭제가 된다(이때 cart도 자동으로 지워짐)
delete from shop where sang_no=10;

--부모 테이블 drop시키기--불가능
drop table shop;--오류 :외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다

-- sub테이블 먼저 제거해야함
drop table cart;
drop table shop;

-- 시퀀스도 제거
drop SEQUENCE seq_shop;