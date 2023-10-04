--2023-09-22 ���ν���
/*
:���ν����� Ư�� �۾��� �����ϴ� ������ ���� ���α׷�����
����Ÿ���̽��� ����Ǵ� ��ü�̴�
�ݺ��Ǵ� �ڵ尰�� ��� ���ν����� �����صξ��ٰ� ȣ���ؼ�
���ุ �ϸ� �ǹǷ� ���뼺�� ����

����
create :���λ���, ���� ���ν����� ���� ��� �����߻�
create or replace : ���� ����, �ٵ� ���� ���ν����� ������ �����.

create [or replace] procedure ���ν�����
    [�Ķ���� ��� ����ŸŸ��,...]
is
           ���� ����
begin
                    �ڵ�;
end;
/

ȣ�� : exec ���ν�����
                exec ���ν�����(��..)
                
*/

--����1 �ʰ��� ���ν��� ����
create or replace PROCEDURE mytest
is
begin
    DBMS_OUTPUT.PUT_LINE('ù ���ν����� ��������!');
end;
/
exec mytest;--mytest ���ν���ȣ��

--����2 ���ڸ� ���ڷ� ������ ������ ���
create or replace PROCEDURE gugu(dan number)
is
begin
    if dan<2 or dan>9 then
        DBMS_OUTPUT.PUT_LINE('�߸��� �����Դϴ�.2-9 ���̰� �䱸!');
    else
        DBMS_OUTPUT.PUT_LINE('***'||dan||'��***');
        for a in 1..9 loop
            DBMS_OUTPUT.PUT_LINE(dan||' x '||a||' = '||dan*a);
        end loop;
    end if;
end;
/
exec gugu(11);--�߸��� �����Դϴ� ��ȯ
exec gugu(8);--������ ��ȯ

--����3 ������ shop���̺� ������ �߰�
insert into shop values (seq_shop.nextval,'���̽����콺',23000,'white');
--�÷� Ÿ�� ���� ���� ����(shop)
alter table shop modify sang_color varchar2(30);
insert into shop values (seq_shop.nextval,'���̽�����',19000,'red');
insert into shop values (seq_shop.nextval,'üũ����',39000,'rainbow');
insert into shop values (seq_shop.nextval,'ĥ��û����',56000,'blue');
commit;

--����3 ��ǰ���� ���ڷ� ������ �� �ܾ ���Ե� ��� ��ǰ ���
create or replace PROCEDURE sangpum(sang varchar2)
is
    Cursor s1
    is
    select * from shop where sang_name like '%' || sang || '%';
    
    --�˻��� ��ǰ������ ���� ����
    v_cnt number(2);
begin
    select count(*) into v_cnt from shop where sang_name like '%' || sang || '%';
    if v_cnt=0 then
        DBMS_OUTPUT.PUT_LINE(sang || ' ��ǰ�� ��Ͽ� �����ϴ�.');
    else
        DBMS_OUTPUT.PUT_LINE(sang || '��ǰ ��ȸ�ϱ�, �� '||v_cnt||'�� ��ȸ');
        DBMS_OUTPUT.PUT_LINE(' ');
        DBMS_OUTPUT.PUT_LINE('��ǰ��ȣ      ��ǰ��     ����      ����');
        DBMS_OUTPUT.PUT_LINE('-----------------------------------------------------');
        for s in s1 loop
        DBMS_OUTPUT.PUT_LINE(s.sang_no|| '      '||s.sang_name||'       '||s.sang_price
        ||'      '||s.sang_color);
        exit when s1%notfound;
        end loop;
    end if;
end;
/
--����
exec sangpum('����');
exec sangpum('û����');
exec sangpum('�Ѻ�');

--����4
/*
    exec addupdate('���̽�����','black') : �ش� ��ǰ�� ������ �߰�
                                            �ش� ��ǰ�� ������ ���� ����
*/
create or replace PROCEDURE sangpum(sang varchar2, price number, color VARCHAR2)
is
    --�˻��� ��ǰ������ ���� ����
    v_cnt number(2);
begin
    select count(*) into v_cnt from shop where sang_name=sang;
    if v_cnt=0 then
        insert into shop values (seq_shop.nextval,price,color);
        DBMS_OUTPUT.PUT_LINE(sang || ' ��ǰ�� �߰��Ǿ����ϴ�.');
    else
        update shop set sang_price=price,sang_color=color where sang_name=sang;
        DBMS_OUTPUT.PUT_LINE(sang || ' ��ǰ�� �����Ͽ����ϴ�.');
    end if;
end;
/
exec addupdate('���̽�����',34000,'puple');
exec addupdate('�纹����',150000,'blue');