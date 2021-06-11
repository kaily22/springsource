select rownum, bno, title from spring_board;

select rownum, bno, title from spring_board where rownum <=10;

insert into spring_board(bno,title,content,writer) 
(select seq_board.nextval,title,content,writer from spring_board);

select count(*) from spring_board;

--�ֽű� 10�� ����
select rownum,bno,title,writer
from(select bno,title,writer from spring_board where bno>0 order by bno desc)
where rownum <= 10;

--����ڰ� 1 ������=> �ֽű� 10�� 170~161��
select *
from(select rownum rn,bno,title,writer 
      from (select bno,title,writer from spring_board where bno>0 order by bno desc)
      where rownum <= 10)
where rn > 0;
--2 => �� ���� �ֽű� 160~151
select *
from(select rownum rn,bno,title,writer 
      from (select bno,title,writer from spring_board where bno>0 order by bno desc)
      where rownum <= 20)
where rn > 10;

--����Ŭ ��Ʈ �̿��ϱ�
select *
from(select /*+INDEX_DESC(spring_board pk_spring_board)*/
            rownum rn,bno,title,writer 
      from spring_board
      where rownum<=10)
where rn > 0;

--2������
select *
from(select /*+INDEX_DESC(spring_board pk_spring_board)*/
            rownum rn,bno,title,writer 
      from spring_board
      where rownum<=20)
where rn > 10;