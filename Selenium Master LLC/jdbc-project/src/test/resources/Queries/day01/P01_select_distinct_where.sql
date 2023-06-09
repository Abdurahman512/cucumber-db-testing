select * from employees;

-- display all information from countries table
select * from countries;

-- display first name from employees table
select first_name from EMPLOYEES;

select distinct first_name from EMPLOYEES;

-- display firstname, lastname and salary from employees table
select FIRST_NAME, LAST_NAME, SALARY from EMPLOYEES;

-- display different department_ids from employees table
select DEPARTMENT_ID from EMPLOYEES;
select distinct DEPARTMENT_ID from EMPLOYEES;

select * from EMPLOYEES
where FIRST_NAME = 'David';
--  > '' it is case SENSITIVE!!!

-- display firstname, lastname and salary where firstname is Peter from employees table
 select FIRST_NAME, LAST_NAME, SALARY from EMPLOYEES
 where FIRST_NAME='David' and LAST_NAME='Austin';

 -- display all info from employees who making more than 3000
 select * from EMPLOYEES
 where SALARY>3000;

 -- display all info from employees who making more than 3000 and department id is 10
select * from EMPLOYEES
where SALARY>3000 and DEPARTMENT_ID=10;

select * from EMPLOYEES
where SALARY between 5000 and 8000;

select * from EMPLOYEES
where JOB_ID = 'IT_PROG' or JOB_ID ='MK_MAN'or JOB_ID='SA_REP';

select * from EMPLOYEES
where JOB_ID in ('IT_PROG','MK_MAN','SA_REP');

select FIRST_NAME,LAST_NAME, JOB_ID from EMPLOYEES
where JOB_ID NOT in ('IT_PROG');

select * from EMPLOYEES
order by SALARY desc ;

select * from EMPLOYEES
order by FIRST_NAME desc ;

-- display all info from employees where job ids are IT_PROG and order them based on salary desc order
select * from EMPLOYEES
where JOB_ID in ('IT_PROG')
order by SALARY desc ;

-- display all info from employees and order them based firstname asc and based on lastname desc
select * from EMPLOYEES
order by FIRST_NAME asc , LAST_NAME desc;

--display all employees where firstname STARTWITH A and length of it 4 letter
select * from EMPLOYEES
where FIRST_NAME like 'A___';

select * from EMPLOYEES
where FIRST_NAME like '%a%';

select FIRST_NAME from EMPLOYEES
where FIRST_NAME like '_a%';

select count(*) from DEPARTMENTS;
select * from DEPARTMENTS;

select * from EMPLOYEES
where DEPARTMENT_ID is null ;

select count(*) from EMPLOYEES
where DEPARTMENT_ID is null ;

select count(distinct FIRST_NAME) from EMPLOYEES;

select count(*) from EMPLOYEES
where JOB_ID in ('IT_PROG','SA_REP');

select count(*) from EMPLOYEES
where SALARY>6000;

select FIRST_NAME, SALARY from EMPLOYEES
order by SALARY desc ;

select avg(salary) from EMPLOYEES
where JOB_ID in ('IT_PROG');

select count(distinct job_id) from EMPLOYEES

select JOB_ID ,avg(salary) from EMPLOYEES
group by JOB_ID;

select JOB_ID, avg(SALARY), min(SALARY), max(SALARY), sum(SALARY), count(*) from EMPLOYEES
group by JOB_ID;

select DEPARTMENT_ID, sum(salary), count(*), max(salary), min(salary),round(avg(salary)) from EMPLOYEES
where DEPARTMENT_ID is not null
group by DEPARTMENT_ID
order by avg(SALARY) desc ;

--display department ids where thire avg salary is more than 5k
select DEPARTMENT_ID, count(*), round(avg(SALARY)) from EMPLOYEES
where DEPARTMENT_ID is not null
group by DEPARTMENT_ID
having avg(salary) > 5000
order by DEPARTMENT_ID ;

--display the duplicated (more than one) firstnames from employees table
select FIRST_NAME, count(*) from EMPLOYEES
group by FIRST_NAME
having count(*)>1
order by count(*) desc ;

