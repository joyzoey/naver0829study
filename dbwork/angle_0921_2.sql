--PL-SQL�̶�?
--SQL �� ������ ����Ҹ� �߰��ؼ� ���α׷����� ���� PL-SQL �̶�� �Ѵ�
--����1
declare
    --���� �����ϴ� ����
    v_no number(4,1); --4�ڸ��� �Ҽ��� ���� 1�ڸ� ���� �ִ� ���� ����
begin
    --sql �����̳� pl-sql������ �ڵ��ϴ� ����(:=:����, =:��,����)
    v_no:=12.7;
    DBMS_Output.put_line(v_no);--���
end;
/
--����2 --�Ѹ��ۿ� ���ҷ����⶧���� , �� �Ѹ��� �����������
declare
    vname varchar2(20);
    vban varchar2(20);
begin
    select
        name,ban
        into vname,vban
    from student where num=6;
    DBMS_Output.put_line(vname||'���� '||vban||'�Դϴ�.');
end;
/
--����3person�� food���̺��� �����Ͽ� person_num�� 9�� ����� �̸�, �ֹ��� �޴��������
declare
    vname varchar2(20);
    vfood varchar2(20);
    vprice number(7);
begin
    select
        person_name,fname,fprice
        into vname, vfood, vprice
    from food f, person p 
    where f.food_num=p.food_num and person_num=9;
    DBMS_Output.put_line(vname||'���� '||vfood||'�� �ֹ��ϼ̰� '||vprice||'���� �����ؾ��մϴ�.');
end;
/
--����4 ��ǰ���� ������ ������ �� �ش� ��ǰ���� ���ݰ� ������ ���
declare
    vsangpum varchar2(20) := 'üũ����';
    vcolor varchar2(20);
    vprice number(7);
begin
    select
        sang_price, sang_color
        into vprice, vcolor
    from shop where sang_name=vsangpum;
    DBMS_Output.put_line('��ǰ��:'||vsangpum);
    DBMS_Output.put_line('��  ��:'||vcolor);
    DBMS_Output.put_line('��  ��:'||vprice);
end;
/
--����5
declare
    vsangpum varchar2(20) :='û����';
    vcolor varchar2(20);
    vprice number(7);
    vprice2 varchar2(20);
begin
    select sang_price,sang_color,ltrim(to_char(sang_price,'L999,999'))
    into vprice,vcolor,vprice2
    from shop where sang_name=vsangpum;
        
    DBMS_Output.put_line('��ǰ��:'||vsangpum);
    DBMS_Output.put_line('��  ��:'||vcolor);
    DBMS_Output.put_line('��  ��:'||vprice);
    DBMS_Output.put_line('��  ��:'||vprice2);
end;
/

/*
if  ���ǽ� then
    ����1;
else
    ����2;
end if;

���� if��
if  ���ǽ�1 then
    ����1;
elsif ����2 then  ->�̰� ��Ÿ�ƴ� elsif����
    ����2;
    ...
end if;

*/
--����5
--�⵵�� �´� �챸�ϱ�
--Ű����� �⵵ �Է¹��� ����
accept year prompt '�¾ �⵵�� �Է��ϼ���'
declare
    --v_year number(4) :=1998;--���� �����ٶ�
    v_year number(4) := '&year';--Ű����� �޾ƿö�
    v_mod number(2) := mod(v_year,12); --�⵵�� 12�� ���� ������
    v_ddi varchar2(10); --�� ������ ����
begin
    if v_mod=0 then v_ddi:='������';
    elsif v_mod=1 then v_ddi:='��';
    elsif v_mod=2 then v_ddi:='��';
    elsif v_mod=3 then v_ddi:='����';
    elsif v_mod=4 then v_ddi:='��';
    elsif v_mod=5 then v_ddi:='��';
    elsif v_mod=6 then v_ddi:='ȣ����';
    elsif v_mod=7 then v_ddi:='�䳢';
    elsif v_mod=8 then v_ddi:='��';
    elsif v_mod=9 then v_ddi:='��';
    elsif v_mod=10 then v_ddi:='��';
    elsif v_mod=11 then v_ddi:='��';
    end if;
    DBMS_Output.put_line(v_year||'����� '||v_ddi||'���Դϴ�');
end;
/
--���� 6 
--db �÷��� Ÿ���� �������� ���
accept iname prompt 'name?';
declare
    v_name student.name%TYPE :='&iname';
    v_height student.height%TYPE;
    v_java student.java%TYPE;
    v_spring student.spring%TYPE;
begin
    select height,java,spring
    into v_height,v_java,v_spring
    from student where name=v_name;
    DBMS_Output.put_line('��  ��  ��:'||v_name);
    DBMS_Output.put_line('�л���  Ű:'||v_height);
    DBMS_Output.put_line('�ڹ�  ����:'||v_java);
    DBMS_Output.put_line('����������:'||v_spring);
    DBMS_Output.put_line('��      ��:'||(v_java+v_spring));
    
end;
/
/*
    �ݺ��� : loop
    loop
        �����;
        exit when ����;
    end loop;
*/
--����7 1-10���� �ݺ��ؼ� ���
declare
    v_no number(2) := 0;
begin
    loop
        v_no := v_no+1;
        DBMS_Output.put_line('no='||v_no);
        exit when v_no=10; --10�� ��� �ݺ��� ����������
    end loop;
end;
/
--����8 ���� �Է��ϸ� �ش���� ����Ͻÿ�
accept dan prompt '�� ���� ����ϰ�ͳ���?';
declare
    dan number(2) := '&dan';
    v_no number(2) := 0;
begin
    DBMS_Output.put_line('**'||dan||'��**');
    loop
        v_no := v_no+1;
        DBMS_Output.put_line(dan||' x '||v_no||' = '||(dan*v_no));
        exit when v_no=9; --9�� ��� �ݺ��� ����������
    end loop;
end;
/
--����9 :����4���� Exception ó��
accept sangpum prompt 'sampum?';
declare
    vsangpum varchar2(20) := '&sangpum';
    vcolor varchar2(20);
    vprice number(7);
    vprice2 varchar2(20);
begin
    select sang_price,sang_color,ltrim(to_char(sang_price,'L999,999'))
    into vprice,vcolor,vprice2
    from shop where sang_name=vsangpum;
        
    DBMS_Output.put_line('��ǰ��:'||vsangpum);
    DBMS_Output.put_line('��  ��:'||vcolor);
    DBMS_Output.put_line('��  ��:'||vprice);
    DBMS_Output.put_line('��  ��:'||vprice2);
    
    --����� 2�� �̻��̰ų� ������ �����߻�
    --����Ŭ���� ����ó���ϴ� ���
    EXCEPTION
        when NO_DATA_FOUND then
            DBMS_Output.put_line('['||vsangpum||'] ��ǰ�� DB�� �����ϴ�.');
        when TOO_MANY_ROWS then
            DBMS_Output.put_line('['||vsangpum||'] ��ǰ�� DB�� �� �� �̻� �����մϴ�.');
        when others then
            DBMS_Output.put_line('['||vsangpum||'] ��ǰ�� ���� ���� �߻�');
end;
/
/*
    �ݺ���
    for ���� in [reverse]���۰�...������ loop
        �����;
    end loop;
*/
--���� 10-����8 ����, ������ ���� ���
accept v_dan prompt '�� ���� ����ϰ�ͳ���?';
declare
    v_dan number(2) := '&v_dan';
    v_idx number(1);
begin
    DBMS_Output.put_line('**'||v_dan||'��**');
    for v_idx in 1..9 loop
        DBMS_Output.put_line(v_dan||' x '||v_idx||' = '||(v_dan*v_idx));
    end loop;
end;
/

--���� 11���ڵ� ������ ������ ��������
declare
    v_num student.num%TYPE :=6;
    v_stu angel.student%rowtype;--���ڵ������ �о�� ���
begin
    select * into v_stu
    from student where num=v_num;
    
    DBMS_Output.put_line('�̸�:'||v_stu.name);
    DBMS_Output.put_line('Ű:'||v_stu.height);
    DBMS_Output.put_line('�ڹ�:'||v_stu.java);
    DBMS_Output.put_line('������:'||v_stu.spring);
    DBMS_Output.put_line('��:'||v_stu.ban);
    
end;
/
/*
    db�� ���� �����͸� ��ȸ�� ���
    cursor : sql���� �����Ҷ����� ����� �м��ǰ� ����Ǿ� ����� �����ϱ� ����
    Ư���� �޸� ������ ����ϴµ� �� ������ �����ϴ� ���� Ŀ���̴�.
    
    select������ ���� ������ ��ȸ�� ����ϴ� ��ü�̴�
    
    Ŀ�� �Ӽ�
    sql%rowcount :����� ���� ��ȯ
    sql%found :���� �ֱ��� sql���� �ϳ� �̻��� �࿡ ������ �� ��� true
    sql%isopen : �׻� false (�׻� close�� �ϱ� ������ �׻� false)
*/
--���� 12 
declare
    v_sno number(3) := 20;
    v_shop angel.shop%rowtype;
begin
    select * into v_shop
    from shop where sang_no=v_sno;
    
    DBMS_Output.put_line('��ǰ��:'||v_shop.sang_name);
    DBMS_Output.put_line('��ȸ�� ���హ��:'||sql%rowcount);
    
    --student�� java���� �����ϱ�
    update student set java=99;
    DBMS_Output.put_line('������ ���హ��:'||sql%rowcount);
end;
/
--���� 13 ���� ���ڵ� ��ȸ
declare
    Cursor s1
    is
    select * from shop;
begin
    DBMS_Output.put_line('��ǰ��ȣ  ��ǰ�� ����  ����');
    DBMS_Output.put_line('----------------------------');
    for s in s1 loop
        exit when s1%notfound; --���̻� �����Ͱ� ������ ����������
        DBMS_Output.put_line(s.sang_no||'   '||s.sang_name||'   '||s.sang_color||'   '||s.sang_price);
    end loop;
end;
/
--���� 14 
--��ǰ�� ,����,������ �Է��ϸ� shop db�� �߰��ϱ�
accept isang prompt 'sangpum?';
accept icolor prompt 'color?';
accept iprice prompt 'price?';
declare
    v_sang shop.sang_name%TYPE := '&isang';
    v_color shop.sang_color%TYPE := '&icolor';
    v_price shop.sang_price%TYPE := '&iprice';
begin
    insert into shop values (seq_shop.nextval,v_sang,v_price,v_color);
    commit;
    DBMS_Output.put_line('��ǰ������ �߰��߽��ϴ�.');
end;
/

-- today ���� : food ���̺�
/* 
    fname, fprice, no �Է¹޾Ƽ�
    no�� 1�̸� fname,fprice�� ������ �߰��� �ϰ�
    no�� 2�̸� food ��ü ������ ���
*/
accept v_fname prompt 'fname?';
accept v_fprice prompt 'fprice?';
accept v_no prompt 'no?';
declare
    v_fname food.fname%TYPE := '&v_fname';
    v_fprice food.fprice%TYPE := '&v_fprice';
    v_no number(2) := '&v_no';
    Cursor f1
    is
    select * from food;
begin
    if v_no=1 then
        insert into food values (seq_food.nextval,v_fname,v_fprice);
        commit;
        DBMS_Output.put_line('��ǰ������ �߰��߽��ϴ�.');
    elsif v_no=2 then
        DBMS_Output.put_line('�޴���ȣ    �޴���      ����');
        DBMS_Output.put_line('----------------------------');
        for f in f1 loop
        exit when f1%notfound; --���̻� �����Ͱ� ������ ����������
        DBMS_Output.put_line(f.food_num||'   '||f.fname||'   '||f.fprice);
        end loop;
    end if;
end;
/