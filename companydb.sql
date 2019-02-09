   
INSERT INTO COMPANY_REVENUE(PK, REVENUE_MONTH, EXPENSE, MARGINS, REVENUE) VALUES
('1', 'Jan', 5000.0, 25000.0, 75000.0),
('2', 'Feb', 6000.0, 27000.0, 80000.0),
('3', 'Mar', 7000.0, 30000.0, 85000.0),
('4', 'Apr', 8000.0, 32000.0, 84000.0),
('5', 'May', 9000.0, 28000.0, 80000.0),
('6', 'Jun', 10000.0, 39000.0, 90000.0);

INSERT INTO EMPLOYEE_INFORMATION(PK, _NAME, AGE, OFFICE_LOCATION, POSITION, SALARY, START_DATE) VALUES
('1', 'mahnaz', 23, 'abadan', 'employee', 1000.0, DATE '2012-09-17'),
('2', 'ali', 21, 'tehran', 'employee', 1000.0, DATE '2015-09-17'),
('3', 'sepand', 27, 'esfahan', 'manager', 1700.0, DATE '2018-09-17');               

INSERT INTO ORDER_COLLECTION_STATUS(PK, NEW_ORDERS, RETURNED, REVENUE, SHIPPED) VALUES
('1', 10, 20, 3000.0, 15),
('2', 11, 22, 3500.0, 1),
('3', 0, 2, 1500.0, 5); 

INSERT INTO ORDER_RECIEVED(PK, DATE_RECEIVED, ORDER_RECEIVED) VALUES
('1', 'Mar 1', 100),
('2', 'Mar 2', 125),
('3', 'Mar 3', 180),
('4', 'Mar 4', 170),
('5', 'Mar 5', 160),
('6', 'Mar 6', 175),
('7', 'Mar 7', 400),
('8', 'Mar 8', 195),
('9', 'Mar 9', 190),
('10', 'Mar 10', 210),
('11', 'Mar 11', 120),
('12', 'Mar 12', 110),
('13', 'Mar 13', 100),
('14', 'Mar 14', 140),
('15', 'Mar 15', 170);             

INSERT INTO PRODUCT_CATEGORY(PK, BEST_CATEGORY, CATEGORY_NAME, PERCENTAGE) VALUES
('1', TRUE, 'Electronics', 30),
('2', TRUE, 'Phone/Ipad', 40),
('3', TRUE, 'Purses', 20),
('4', TRUE, 'Jwellery', 10);           
