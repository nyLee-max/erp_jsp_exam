select * from employee;
select * from department;
select * from title;

select EMP_NO ,EMP_NAME ,TNO ,MANAGER ,SALARY ,DNO ,HIREDATE from employee;

select EMP_NO ,EMP_NAME ,TNO ,MANAGER ,SALARY ,DNO ,HIREDATE from employee where EMP_NO = 1003;

insert into employee values(1004 ,'이나연' , 3 , 3427 , 6000000 , 2, '2020-08-25');



delete from employee where EMP_NO = 1004;



update employee set EMP_NAME='김상건' ,TNO=1 ,MANAGER=3427 ,SALARY=5000000 ,DNO=3 ,HIREDATE = '2020-08-25' where EMP_NO = 1004;


create or replace view vw_full_employee
as
select e.EMP_NO,
      e.EMP_NAME,
       t.TITLE_NO, 
       t.TITLE_NAME, 
       e.MANAGER, 
       m.EMP_NAME as manager_name,
       e.SALARY,
       d.DEPT_NO,
       d.DEPT_NAME,
       d.FLOOR,
       e.HIREDATE
from employee e join title t on e.TNO=t.TITLE_NO
left join employee m on e.MANAGER =m.EMP_NO 
join department d on e.DNO = d.DEPT_NO;

select EMP_NO ,EMP_NAME ,TITLE_NO ,TITLE_NAME ,MANAGER ,manager_name ,SALARY ,DEPT_NO ,DEPT_NAME ,FLOOR ,HIREDATE from vw_full_employee;