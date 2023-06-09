
select * from EMPLOYEES;
select * from DEPARTMENTS;

-- display all first_name and related department_name

select FIRST_NAME, DEPARTMENT_NAME from
EMPLOYEES e inner join DEPARTMENTS d
on e.DEPARTMENT_ID = d.department_id;

--display all first_name and department_name including the department without employee
select first_name, department_name from
EMPLOYEES e right join DEPARTMENTS d1
on e.DEPARTMENT_ID = d1.DEPARTMENT_ID
order by FIRST_NAME;

