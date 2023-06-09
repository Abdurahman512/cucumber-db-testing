select * from EMPLOYEES;

create view EmployeesInfo as
select FIRST_NAME||' '||UPPER(LAST_NAME)||' makes '|| SALARY as employees_salary,
SALARY*12 as annual_salary from employees;

select * from employeesInfo;

drop view employeesinfo;

select * from employeesInfo;

