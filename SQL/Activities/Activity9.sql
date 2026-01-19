-- Create the customers table
create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

-- Insert values into it
INSERT ALL
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001)
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001)
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002)
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002)
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006)
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003)
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007)
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005)
SELECT 1 FROM DUAL;



Select s.salesman_name, c.customer_name
from salesman s join customers c on s.salesman_id = c.salesman_id;


SELECT a.customer_name, a.city, a.grade, b.salesman_name AS "Salesman", b.salesman_city FROM customers a 
LEFT OUTER JOIN salesman b ON a.salesman_id=b.salesman_id WHERE a.grade<300 
ORDER BY a.customer_id;

Select a.customer_name, a.city, a.grade, b.salesman_name, b.salesman_city, b.commission
from customers a  LEFT OUTER JOIN salesman b 
ON a.salesman_id=b.salesman_id 
where commission >12;

Select a.customer_name, b.salesman_name,  b.commission, c.order_no, c.order_date, c.PURCHASE_AMOUNT
from customers a  inner JOIN salesman b 
ON a.salesman_id=b.salesman_id inner join orders c on c.customer_id = a.customer_id;

