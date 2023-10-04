--2023-09-22 프로시저
/*
:프로시저는 특정 작업을 수행하는 일종의 서브 프로그램으로
데이타베이스에 저장되는 객체이다
반복되는 코드같은 경우 프로시져에 저장해두었다가 호출해서
실행만 하면 되므로 재사용성이 높다

형식
create :새로생성, 기존 프로시저가 있을 경우 오류발생
create or replace : 새로 생성, 근데 기존 프로시저가 있으면 덮어쓴다.

create [or replace] procedure 프로시저명
    [파라미터 모드 데이타타입,...]
is
           변수 선언
begin
                    코드;
end;
/

호출 : exec 프로시저명
                exec 프로시저명(값..)
                
*/

--예제1 초간단 프로시저 생성
create or replace PROCEDURE mytest
is
begin
    DBMS_OUTPUT.PUT_LINE('첫 프로시저를 만들었어요!');
end;
/
exec mytest;--mytest 프로시저호출

--예제2 숫자를 인자로 보내면 구구단 출력
create or replace PROCEDURE gugu(dan number)
is
begin
    if dan<2 or dan>9 then
        DBMS_OUTPUT.PUT_LINE('잘못된 숫자입니다.2-9 사이값 요구!');
    else
        DBMS_OUTPUT.PUT_LINE('***'||dan||'단***');
        for a in 1..9 loop
            DBMS_OUTPUT.PUT_LINE(dan||' x '||a||' = '||dan*a);
        end loop;
    end if;
end;
/
exec gugu(11);--잘못된 숫자입니다 반환
exec gugu(8);--구구단 반환

--예제3 들어가기전 shop테이블 데이터 추가
insert into shop values (seq_shop.nextval,'레이스블라우스',23000,'white');
--컬럼 타입 길이 변경 연습(shop)
alter table shop modify sang_color varchar2(30);
insert into shop values (seq_shop.nextval,'레이스조끼',19000,'red');
insert into shop values (seq_shop.nextval,'체크조끼',39000,'rainbow');
insert into shop values (seq_shop.nextval,'칠부청바지',56000,'blue');
commit;

--예제3 상품명을 인자로 보내면 그 단어가 포함된 모든 상품 출력
create or replace PROCEDURE sangpum(sang varchar2)
is
    Cursor s1
    is
    select * from shop where sang_name like '%' || sang || '%';
    
    --검색된 상품갯수를 구할 변수
    v_cnt number(2);
begin
    select count(*) into v_cnt from shop where sang_name like '%' || sang || '%';
    if v_cnt=0 then
        DBMS_OUTPUT.PUT_LINE(sang || ' 상품은 목록에 없습니다.');
    else
        DBMS_OUTPUT.PUT_LINE(sang || '상품 조회하기, 총 '||v_cnt||'개 조회');
        DBMS_OUTPUT.PUT_LINE(' ');
        DBMS_OUTPUT.PUT_LINE('상품번호      상품명     가격      색상');
        DBMS_OUTPUT.PUT_LINE('-----------------------------------------------------');
        for s in s1 loop
        DBMS_OUTPUT.PUT_LINE(s.sang_no|| '      '||s.sang_name||'       '||s.sang_price
        ||'      '||s.sang_color);
        exit when s1%notfound;
        end loop;
    end if;
end;
/
--실행
exec sangpum('조끼');
exec sangpum('청바지');
exec sangpum('한복');

--예제4
/*
    exec addupdate('레이스조끼','black') : 해당 상품이 없으면 추가
                                            해당 상품이 있으면 색상 수정
*/
create or replace PROCEDURE sangpum(sang varchar2, price number, color VARCHAR2)
is
    --검색된 상품갯수를 구할 변수
    v_cnt number(2);
begin
    select count(*) into v_cnt from shop where sang_name=sang;
    if v_cnt=0 then
        insert into shop values (seq_shop.nextval,price,color);
        DBMS_OUTPUT.PUT_LINE(sang || ' 상품이 추가되었습니다.');
    else
        update shop set sang_price=price,sang_color=color where sang_name=sang;
        DBMS_OUTPUT.PUT_LINE(sang || ' 상품을 수정하였습니다.');
    end if;
end;
/
exec addupdate('레이스조끼',34000,'puple');
exec addupdate('양복정장',150000,'blue');