select * from employees;

select max(salary) from EMPLOYEES;

select * from EMPLOYEES
where SALARY=(select max(salary) from EMPLOYEES);

select * from EMPLOYEES
where SALARY = (select min(salary) from EMPLOYEES);

-- display second highest salary from employees table
select * from EMPLOYEES
where SALARY = (select max(salary) from EMPLOYEES
where salary < (select max(salary) from EMPLOYEES));

select * from EMPLOYEES
where SALARY > (select avg(salary) from EMPLOYEES);

select * from EMPLOYEES
where rownum < 5;

-- display who get first 5 highest salary
select * from (select * from EMPLOYEES order by SALARY desc)
where rownum < 6;


select * from EMPLOYEES
where SALARY = (select min(salary) from (select distinct salary from EMPLOYEES
order by SALARY desc )
where rownum < 5);