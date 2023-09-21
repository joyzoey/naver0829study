--2023-09-21 DB����ȭ
--DB ����ȭ(Normalization)
--����ȭ��? �Ѹ���� db������ �޸𸮸� �������� �ʱ� ���ؼ�
--� ���̺��� �ĺ��ڸ� ������ �������� ���̺�� ������ ������ ����ȭ�� �Ѵ�
--����ȭ�� ����Ÿ���̽��� �ߺ��� �ּ�ȭ�ǵ��� ����� ����Ÿ���̽��̴�
--����:�޸� ����, ����ȭ�� �ý������� ���� ���� ����
--���� : ��ȸ������ �ſ� ���� �ý����� ���, ��������ӵ� �ʾ��� (���̺� ���� ������ �ݺ������� �̷����⶧��)

--student�� num�� �ܺ�Ű�� ���� ���ο� ���̺� stuinfo �����
--�ܺ�Ű�� ���̺� ������ ���� ����, ���߿� ���� ����, ������ ���߼������� ����

create table stuinfo (
    idx number(5) constraint stuinfo_pk_idx primary key,
    num number(5),
    addr varchar2(20),
    hp varchar2(20));

    
--student num�� �ܺ�Ű�� ���� ppt29p (�̶�����:student�� num�� �ݵ�� primary key���߸� �Ѵ�)
alter table stuinfo add constraint stuinfo_fk_num foreign KEY(num) REFERENCES student(num);

--stuinfo�� ������ �߰�
insert into stuinfo values (seq_stu.nextval, 9, '����� ������','010-2323-4545');
--���� ��ȣ�� 9������ insert�� : ���Ἲ��������-�θ�Ű�� �����ϴ�.
--student ���̺��� �θ����̺�, �ű⿡ num9�� ���� ������ ���� �߻�
insert into stuinfo values (seq_stu.nextval, 3, '���빮��','010-8250-0305');--�質��
insert into stuinfo values (seq_stu.nextval, 6, '���ֵ�','010-1230-1235');--������
insert into stuinfo values (seq_stu.nextval, 8, '�λ�','010-1234-1234'); --��ҿ�

--stuinfo�� ��ȸ
select * from stuinfo;

--student�� ��ȸ
select* from student;

--���������� ��ϵ� �л��� ���ؼ� ��� ������ ���-inner join,equi join
select 
    stu.name,stu.java,stu.spring,stu.ban,info.addr,info.hp
from student stu,stuinfo info
where stu.num=info.num;

--�÷��� �տ� ������ ��� ���̺� �Ҽ����� �ٿ��µ�
--���ʿ� ���� �÷��� ���ٸ� �����ص� �ȴ�.
select 
    stu.num,name,java,spring,ban,addr,hp
from student stu,stuinfo info
where stu.num=info.num;

--���������� ��ϵ��� ���� �л����� ���-outter join
--sub table dp(+)
select 
    stu.name,stu.java,stu.spring,stu.ban,info.addr,info.hp
from student stu,stuinfo info
where stu.num=info.num(+);

--���� ����� null�� �л��� ���
select 
    stu.name,stu.java,stu.spring,stu.ban,info.addr,info.hp
from student stu,stuinfo info
where stu.num=info.num(+) and info.addr is null;

--sub ���̺� ����� �����Ͱ� �ִµ� �θ����̺�(student)�� �ش� �����͸� �����ϰ��� �� ���
delete from student where num=3;--���� : ���Ἲ ��������(ANGEL.STUINFO_FK_NUM)�� ����Ǿ����ϴ�- �ڽ� ���ڵ尡 �߰ߵǾ����ϴ�
delete from student where num=1;--������, sub���̺� ����Ÿ�� ���� ����

--student�� 3�� �����͸� ��������
delete from stuinfo where num=3;--�ڽ� ������
delete from student where num=3;--�θ� ��������

--�θ� ���̺� drop
drop table student;--����:�ܷ� Ű�� ���� �����Ǵ� ����/�⺻ Ű�� ���̺� �ֽ��ϴ�

--�ڽ� ���̺� drop
drop table stuinfo;

-------------------------------------------------------------------------------------
--��ǰ ������ ���� shop ���̺�
--��ٱ��Ͽ� ���� cart ���̺�
--�������� ���� �ϳ� ������
create SEQUENCE seq_shop start with 10 increment by 10 nocache;

--shop table ����
create table shop (
    sang_no number(5) constraint shop_pk_no primary key,
    sang_name varchar2(100),
    sang_price number(7),
    sang_color varchar2(20)
);

--�ܺ�Ű�� ����� cart���̺� ����
create table cart(
    cart_no number(5) constraint cart_pk_no primary key,
    sang_no number(5),
    cnt number(5),
    cartday date
);
--��ǰ���� ������ ���� shop�� num�� �ܺ�Ű�� ����
--��ǰ�� �����ϸ� ��ٱ����� �ش絥���Ͱ� �ڵ����� �����ǵ��� on delete cascade ����
alter table cart add constraint cart_fk_shopno FOREIGN key(sang_no) REFERENCES shop(sang_no) on DELETE CASCADE;

--model (ERD)Ȯ��
--5�� ��ǰ ���
insert into shop values (seq_shop.nextval,'���콺',23000,'yellow');
insert into shop values (seq_shop.nextval,'û����',45000,'black');
insert into shop values (seq_shop.nextval,'���̳�Ƽ',11000,'white');
insert into shop values (seq_shop.nextval,'���̳�Ƽ',23000,'red');
insert into shop values (seq_shop.nextval,'üũ����',13000,'gray');
commit;

--cart�� ���콺, ���̳�Ƽ(white),üũ���� 3���� ���� �߰�--���糯¥��
insert into cart values (seq_shop.nextval,10,seq_shop.nextval,sysdate);
insert into cart values (seq_shop.nextval,30,seq_shop.nextval,sysdate);
insert into cart values (seq_shop.nextval,50,seq_shop.nextval,sysdate);--sysdate�� �� �����

--��ü��ȸ(outter join)
select
    sang_name, s.sang_no,sang_price,sang_color,cnt, to_char(cartday,'yyyy-mm-dd hh24:mi')cartday
from shop s, cart c
where s.sang_no=c.sang_no(+);

--īƮ�� ���� ���� ��ǰ�� ��ȸ(inner join)
select 
    sang_name, sang_price, sang_color
from shop, cart
where shop.sang_no=cart.sang_no(+) and cartday is null;

--cascade�� ���������Ƿ� cart�� ��� ��ǰ�� ������ �ȴ�(�̶� cart�� �ڵ����� ������)
delete from shop where sang_no=10;

--�θ� ���̺� drop��Ű��--�Ұ���
drop table shop;--���� :�ܷ� Ű�� ���� �����Ǵ� ����/�⺻ Ű�� ���̺� �ֽ��ϴ�

-- sub���̺� ���� �����ؾ���
drop table cart;
drop table shop;

-- �������� ����
drop SEQUENCE seq_shop;