select * from employees;
select * from COUNTRIES;
select first_name from EMPLOYEES;
select first_name, last_name, salary from EMPLOYEES;
select distinct first_name from EMPLOYEES;
select distinct department_id from EMPLOYEES;
select first_name from EMPLOYEES
where FIRST_NAME = 'Steven';
select FIRST_NAME, last_name, salary from EMPLOYEES
where FIRST_NAME = 'Peter';

select salary from EMPLOYEES
where FIRST_NAME = 'David' and last_name = 'Austin';
select * from EMPLOYEES
where SALARY > 5000;

select * from EMPLOYEES
where SALARY > 3000 and department_id = 10;

select * from EMPLOYEES
where SALARY >5000 and SALARY <= 8000;
select * from EMPLOYEES
where SALARY between 5000 and 8000;

select * from EMPLOYEES
where EMPLOYEE_ID between 100 and 120;


select * from EMPLOYEES
where JOB_ID in ('IT_PROG','MK_MAN');

select * from EMPLOYEES
order by SALARY desc;
select * from EMPLOYEES
where job_id = 'IT_PROG'
order by SALARY;

select * from EMPLOYEES
order by first_name, LAST_NAME desc ;

-- like  use it for partial search   %  _

select * from EMPLOYEES
where FIRST_NAME like  'A%';

select * from EMPLOYEES
where FIRST_NAME like 'A___';

select * from EMPLOYEES
where FIRST_NAME like '____m';
select * from EMPLOYEES
where FIRST_NAME like '%m';

select * from EMPLOYEES
where JOB_ID like '%IT%';

select * from  EMPLOYEES
where DEPARTMENT_ID is null;

select count(*) from EMPLOYEES
where JOB_ID in ('IT_PROG','SA_REP');
select count(*) from EMPLOYEES
where SALARY > 6000;

select round (avg(SALARY)) from EMPLOYEES;
select sum(salary) from EMPLOYEES;

select count(distinct job_id) from EMPLOYEES;
select job_id, avg(salary) from EMPLOYEES
group by job_id;

select first_name, count(*) from EMPLOYEES
group by FIRST_NAME
having count(*)>1;

select job_id, avg(SALARY), min(SALARY), max(SALARY), count(*) from EMPLOYEES
group by JOB_ID;

select DEPARTMENT_ID, sum(SALARY), count(*), max(SALARY), min(SALARY), round(avg(SALARY))
from EMPLOYEES
group by DEPARTMENT_ID
order by count(*) desc;

select DEPARTMENT_ID, sum(SALARY), count(*), max(SALARY), min(SALARY), round(avg(SALARY))
from EMPLOYEES
group by DEPARTMENT_ID
order by DEPARTMENT_ID;

select DEPARTMENT_ID, count(*) from EMPLOYEES
group by DEPARTMENT_ID
having count(*) > 5;

select first_name, count(*) from EMPLOYEES
group by FIRST_NAME
having count(*)>1
order by count(*);

select first_name||' '||last_name as full_name from EMPLOYEES;
select first_name, salary*12 as annual_salary from EMPLOYEES;
select concat(email,'@gmail.com') as full_email from employees;
select lower(email||'@gmail.com') as full_email from EMPLOYEES;
select first_name ||' '||upper(last_name) as full_name from EMPLOYEES;
select initcap(email) from EMPLOYEES;
select email, length(email||'@gmail.com') as length_email from EMPLOYEES
order by length_email desc ;
select substr(first_name,0,1)||'.'||substr(last_name,0,1)|| '.' as initials from EMPLOYEES;

select substr(first_name,-3) from EMPLOYEES;

select first_name||' '||last_name as name, salary from EMPLOYEES
where SALARY > 5000;

create view EmployeesInfo as
select first_name||' '||upper(last_name)||' makes '|| salary as employees_salary,
salary*12 as annual_salary from EMPLOYEES;

select employees_salary from EmployeesInfo;

drop view EmployeesInfo;
select * from EmployeesInfo;

select first_name, salary from EMPLOYEES
where SALARY = (select max(salary) from EMPLOYEES);

select max(salary) from EMPLOYEES
where SALARY < (select max(salary) from EMPLOYEES);

select * from EMPLOYEES
where SALARY > (select avg(salary) from EMPLOYEES);

select min(SALARY) from EMPLOYEES
where SALARY> (select min(SALARY) from EMPLOYEES
where SALARY> (select min(SALARY) from EMPLOYEES));

select * from EMPLOYEES
 where rownum <6
 order by SALARY desc ;

 select * from (select * from EMPLOYEES order by SALARY desc )
 where rownum <6;
 select distinct salary from EMPLOYEES
 order by SALARY desc ;

select min(SALARY) from ( select distinct salary from EMPLOYEES
 order by SALARY desc)
 where rownum < 6;

 -- 5th high SALARY
 select * from EMPLOYEES
 where SALARY = (select min(SALARY) from ( select distinct salary from EMPLOYEES
 order by SALARY desc)
 where rownum < 6);

select distinct salary from EMPLOYEES
order by SALARY desc;

select min(SALARY) from (select distinct salary from EMPLOYEES
order by SALARY desc)
where rownum < 6;

select * from EMPLOYEES
where SALARY = (select min(SALARY) from (select distinct salary from EMPLOYEES
order by SALARY desc)
where rownum < 3);

-- create table
create Table scrumteam(
empo_id Integer primary key,
first_name varchar(30) not null,
last_name varchar(20) not null,
age Integer
salary Integer
);

insert into scrumteam (empo_id,first_name, last_name,age, salary)
values (1,'Mike','Smith',34,65000);
insert into scrumtean(empo_id,first_name, last_name, age, salary)
values (2,'Nenna','Gosh',43,60000);

select * from ADDRESS;
select * from CUSTOMER;


select first_name, last_name, phone from CUSTOMER c join ADDRESS a
on a.address_id = c.address_id;

select first_name, last_name, phone, ADDRESS
from ADDRESS a full join CUSTOMER c
on a.ADDRESS_ID = c.ADDRESS_ID;

select first_name, department_name
from EMPLOYEES e
inner join DEPARTMENTS d
on e.DEPARTMENT_ID = d.DEPARTMENT_ID
order by FIRST_NAME;

select first_name, department_name from EMPLOYEES e
right join DEPARTMENTS d
on e.DEPARTMENT_ID = d.DEPARTMENT_ID
order by DEPARTMENT_NAME;

select DEPARTMENT_name, count(*) from DEPARTMENTS d
left join EMPLOYEES e
on d.DEPARTMENT_ID = e.DEPARTMENT_ID
group by DEPARTMENT_NAME;

select MANAGER_ID from EMPLOYEES
where FIRST_NAME = 'Neena';

select first_name from EMPLOYEES
where EMPLOYEE_ID = (select MANAGER_ID from EMPLOYEES
where FIRST_NAME = 'Neena');


select first_name, last_name, salary from EMPLOYEES;








