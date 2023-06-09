
--    NOTE
-- we are just displaying and nothing will change in DB

select first_name as given_name from employees;
select first_name from EMPLOYEES;

/*
String Function
     concat
     Java    +    first_name +" "+ last_name
     SQL     ||   first_name || ' ' || last_name
*/

-- display all employees firstname and lastname as fullname
select first_name||' '||last_name as full_name from EMPLOYEES;

select concat(first_name,last_name) as full_name from EMPLOYEES;

select email, concat(email,'@gmail.com')as full_email from EMPLOYEES;

select lower(email||'@gmail.com') from EMPLOYEES;

select first_name ||' '|| upper(last_name) as full_name from EMPLOYEES;

--length
select email,length(email||'gmail.com') as email_length from EMPLOYEES
order by email_length;

/*
Substring
   (columenName,  beginningIndex, numberOfChar)

   - if beginning index 0 , it is treated as 1
   - if beginning index negative, it will start from backward
   - if we dont specify number of char it will work till the end

*/

-- display initial from firstname and lastname
select substr(first_name,0,1)||'.'||substr(last_name,0,1)||'.' as initials from employees;




