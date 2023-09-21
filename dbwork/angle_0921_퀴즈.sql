--����
-- ������:seq_food ����
-- ��������� �޴� ���̺� (���̺�� : food)
-- food_num ����(5) �⺻Ű, fname ���ڿ�(20) :�޴���, fprice ����(7) : ����
create SEQUENCE seq_food nocache;

create table food(
   food_num number(5) CONSTRAINT food_pk_foodnum primary key,
   fname varchar2(20),
   fprice number(7)
);

--sub ���̺��� : �� ���̺� (person)
-- person_num ����(5) �⺻Ű, food_num �ܺ�Ű ����(cascade ����)
-- person_name ���ڿ�(10) : ����
-- ������: bookingday : date Ÿ��
create table person(
   person_num number(5) CONSTRAINT person_pk_personnum primary key,
   food_num number(5),
   person_name varchar2(10),
   bookingday date
);

alter table person add constraint person_fk_foodnum FOREIGN key(food_num) REFERENCES food(food_num) on delete cascade;

--food �� 5���� �޴��� �������(���İ�Ƽ,������ ����..)
 insert into food values (seq_food.nextval,'���İ�Ƽ',10000);
 insert into food values (seq_food.nextval,'������',15000);
 insert into food values (seq_food.nextval,'����',20000);
 insert into food values (seq_food.nextval,'������',12000);
 insert into food values (seq_food.nextval,'ġŲ',30000);
 commit;
 
--�ֹ��� �������� �߰��غ���(���� �޴��� ������ �ֹ��ϱ⵵ ��..)
insert into person values (seq_food.nextval,1,'�質��',sysdate);
insert into person values (seq_food.nextval,1,'�̼���',sysdate);
insert into person values (seq_food.nextval,2,'��ҿ�',sysdate);
insert into person values (seq_food.nextval,3,'�����',sysdate);
insert into person values (seq_food.nextval,4,'�ֽ¹�',sysdate);
commit;

--��ȸ : ������(food_num),�ֹ��ڸ�,���ĸ�, ����,������ (���� �ѱ۷� �ֱ�)
select
   f.food_num �޴���ȣ,person_name �ֹ��ڸ�,fname �޴���,fprice ����,
   to_char(bookingday,'yyyy-mm-dd') ������
from food f,person p
where f.food_num=p.food_num;

-- �޴��� ���İ�Ƽ�� ������ �ֹ��� ���̺����� ���������� Ȯ��
delete from food where food_num=1;
insert into food values (seq_food.nextval,'���İ�Ƽ',10000);