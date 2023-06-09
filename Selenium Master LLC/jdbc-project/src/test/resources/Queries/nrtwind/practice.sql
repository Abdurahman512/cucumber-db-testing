
select * from Employees;

-- 1.Give me List of male employees living in London ?
select * from employees
where TitleOfCourtesy ='Mr.' and City = 'London';

-- 2.Get me all employees information in following format with columnName ContactInfo
-- FirstName LastName can be reached at Extension
-- Nancy Davolio can be reached at 5467
select FirstName||' '||LastName||' can be reached at 'Extension as ContactInfo from Employees;

-- 3.Get me all the CustomerID in lowercase letter and renamed as ID from the customers table.
select * from customers;
SELECT lower(CustomerID) AS ID FROM Customers;

-- 4.Give me List of customers  in Germany,France,Argentina ?
select * from Customers
where "Country" in ('Germany','France','Argentina');

-- 5.Get me all the even numbers employeeID from employeesTable
select * from "Employees";
select * from "Employees"
where EmployeeID%2=0;

--MySQL / ORACLE / Postgresql
select * from Employees
where mod(EmployeeID,2)=0;

-- 6.Get me top10 OrderID,OrderDate,ShippedDate,CustomerID,Freight from the orders table sorted by Freight in descending order.
select * from "Orders";
select OrderID,OrderDate,ShippedDate,CustomerID,Freight from "Orders"
ORDER BY Freight DESC
LIMIT 10;

-- 7.Get me ten most expensive products
select ProductName,UnitPrice from "Products"
order by "UnitPrice" desc
limit 10;

-- 8.Get me all employees who know French
select * from "Employees";
/*
%   --> 0 or more letter
_   --> 1 letter

contains     '%French%'
endswith     '%French'
startswith   'French%'
*/
select * from "Employees"
where "Notes" like '%French%';

-- Group BY
-- 9.How many  customers  we have  in Germany,France,Argentina ?
select Country,count(*) from "Customers"
where "Country" in ('Germany','France','Argentina')
group by "Country";

-- 10.How many sales did each of my employees make ?
select "EmployeeID",count(*) from "Orders"
group by "EmployeeID";

-- 11.Which of our personnel make more than 75 sales ?

/*
 12.Transported to France by a cargo company called United Package
and the sales for which we paid more than 35 dollars for shipping were made by which personnel at what time?
 */
 select "Freight",CompanyName, ShipCountry from "Shippers" s
 inner join "Orders" o on s."ShipperID" = o.ShipVia
 inner join "Employees" e on e."EmployeeID"=o."EmployeeID"
where "ShipCountry" = 'France' and "Freight">35 and "CompanyName" = 'United Package';

