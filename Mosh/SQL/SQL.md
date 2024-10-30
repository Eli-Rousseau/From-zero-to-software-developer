# SQL

## 1. Introduction to SQL

#### 1.1 Relational vs non-relational database

A database is an organized collection of data, managed by a software application called a Database Management System (DBMS), which allows users to query or modify the data. Databases can be relational, where data is stored in interrelated tables and accessed using Structured Query Language (SQL), or non-relational, which do not use tables and have their own query languages. Popular relational DBMSs include MySQL, SQL Server, and Oracle, with MySQL being a widely-used open-source option, while non-relational databases operate independently of SQL.

#### 1.2 Client-server architecture

In MySQL's client-server architecture, the MySQL server hosts the database and manages access to it, while the client is an application that sends requests, such as queries or commands, to the server. The client and server communicate over a network using the MySQL protocol. The server processes the client's requests, executes the necessary database operations, and returns the results back to the client. This architecture allows multiple clients to connect to and interact with the database simultaneously, with the server handling tasks like query execution, transaction management, and data storage.

#### 1.3 Installing MySQL

Steps for installing MySQL:

1. Open a web browser and navigate to the official MySQL website at [mysql.com](https://www.mysql.com/).
2. Download the MySQL Community Edition installer suitable for your operating system.
3. Run the downloaded installer and follow the on-screen instructions to complete the installation and configure MySQL.
4. Once installed, launch MySQL Workbench, a graphical interface for accessing and managing MySQL databases.
5. In MySQL Workbench, create a new connection to localhost on the default port 3306 to connect to the MySQL server.
6. After the connection is established, you will see a workspace with a navigation panel, query editor, and other SQL tools for managing databases.

#### 1.4 Starting a database in MySQL

###### 1.4.1 Creating a database

1. Open MySQL Workbench and connect to your MySQL server (usually localhost on port 3306).
2. In the top menu, click on the "Create a New Schema" button or right-click on the Schemas panel and select "Create Schema".
3. Enter a name for the database (schema) and click "Apply" to create it.
4. To create tables, right-click on the new database schema under the Schemas panel and select "Create Table".
5. Define the table name and specify the columns by entering the column names, data types, and constraints (such as primary keys or indexes).
6. Click "Apply", review the generated SQL statement, and click "Apply" again to execute and create the table.
7. Repeat the process to create additional tables if needed.

###### 1.4.2 Loading a database

1. Open MySQL Workbench and connect to your MySQL server.
2. In the top menu, click on File and select "Run SQL Script".
3. Browse for the SQL file you want to load and click Open.
4. In the "Open SQL Script" window, review the SQL file path and click "Start" to run the script.
5. MySQL Workbench will execute the SQL commands in the file, creating and populating the database according to the script.
6. Once complete, the new database and its tables will appear in the Schemas panel.

## 2. Retrieving data

#### 2.1 Query Fundamentals

###### 2.1.1 SHOW clause

The `SHOW` clause is used to display information about the MySQL server, databases, tables, or various settings. It helps retrieve metadata, like listing databases or showing table structures.

```sql
SHOW DATABASES;
SHOW TABLES;
SHOW COLUMNS FROM table_name;
```

###### 2.1.2 USE clause

The `USE` clause selects a specific database for all subsequent queries in a session. After using the `USE` statement, all operations apply to the chosen database.

```sql
USE database_name;
```

###### 2.1.3 SELECT clause

The `SELECT` clause retrieves data from a database, allowing you to specify columns, perform arithmetic, use aliases, filter duplicates with `DISTINCT`, and more. It's the most commonly used query for extracting information.

```sql
-- Single column
SELECT column_name FROM table_name;

-- Multiple columns
SELECT column1, column2 FROM table_name;

-- All columns
SELECT * FROM table_name;

-- Arithmetic operation
SELECT column1, column2, (column1 + column2) AS total FROM table_name;

-- Using alias
SELECT column_name AS alias_name FROM table_name;

-- Using DISTINCT
SELECT DISTINCT column_name FROM table_name;
```

###### 2.1.4 WHERE clause

The `WHERE` clause filters records in a query based on specified conditions using comparison, logical, and pattern-matching operators. It refines query results by applying rules on column values.

```sql
-- Comparison operators
SELECT * FROM table_name WHERE column1 = value AND column2 > value;

-- Logical operators
SELECT * FROM table_name WHERE column1 = value OR column2 != value AND column3 <= value;

-- IN operator
SELECT * FROM table_name WHERE column_name IN (value1, value2, value3);

-- BETWEEN operator
SELECT * FROM table_name WHERE column_name BETWEEN value1 AND value2;

-- LIKE operator
SELECT * FROM table_name WHERE column_name LIKE 'abc%';  -- Any characters after 'abc'
SELECT * FROM table_name WHERE column_name LIKE 'a_bc';  -- 'a', any single character, 'bc'

-- REGEXP operator
SELECT * FROM table_name WHERE column_name REGEXP '^start|end$';  -- Starts with 'start' or ends with 'end'
SELECT * FROM table_name WHERE column_name REGEXP '[a-z]';  -- Any lowercase letter

-- IS NULL operator
SELECT * FROM table_name WHERE column_name IS NULL;
```

###### 2.1.5 ORDER BY clause

The `ORDER BY` clause sorts the results of a query based on one or more columns, allowing for ascending (`ASC`) or descending (`DESC`) order. It helps organize data output for better readability and analysis.

```sql
-- Order by one column
SELECT * FROM table_name ORDER BY column1 ASC;

-- Order by multiple columns
SELECT * FROM table_name ORDER BY column1 DESC, column2 ASC;
```

###### 2.1.6 LIMIT clause

The `LIMIT` clause restricts the number of rows returned by a query, making it useful for pagination and performance optimization. It can be used with or without an offset to control which subset of results to display.

```sql
-- Limit the number of rows returned
SELECT * FROM table_name LIMIT 10;

-- Limit with an offset
SELECT * FROM table_name LIMIT 5 OFFSET 10;  -- Skip the first 10 rows and return the next 5
```

#### 2.2 Aggregating and grouping

###### 2.2.1 Aggregate functions

Aggregate functions in SQL perform calculations on multiple rows of data, returning a single result. Common functions include `MAX()` for the maximum value, `MIN()` for the minimum, `AVG()` for the average, `SUM()` for the total, and `COUNT()` for counting rows.

```sql
SELECT MAX(column1) AS max_value,
       MIN(column1) AS min_value,
       AVG(column2) AS average_value,
       SUM(column2) AS total_value,
       COUNT(*) AS total_count -- Counts the number of records
FROM table_name
WHERE condition
GROUP BY column3;
```

###### 2.2.2 GROUP BY clause

The `GROUP BY` clause in SQL organizes records into groups based on one or more columns, often paired with aggregate functions to summarize each group. It allows calculations like totals, averages, or counts within each group.

```sql
-- Grouping by one column
SELECT column1, COUNT(*) AS count, SUM(column2) AS total
FROM table_name
GROUP BY column1;

-- Grouping by multiple columns
SELECT column1, column2, AVG(column3) AS average, MAX(column4) AS max_value
FROM table_name
GROUP BY column1, column2;
```

###### 2.1.3 HAVING clause

The `HAVING` clause in SQL filters records after they’ve been grouped by the `GROUP BY` clause, allowing you to set conditions on aggregate results. While the `WHERE` clause filters rows before grouping, `HAVING` filters groups based on aggregate calculations.

```sql
-- Using WHERE to filter before grouping, and HAVING to filter after
SELECT column1, SUM(column2) AS total
FROM table_name
WHERE column3 = 'condition'   -- Filter rows before grouping
GROUP BY column1
HAVING total > 100;           -- Filter groups after aggregation
```

#### 2.3 Subquery operations

###### 2.3.1 Subqueries

Subqueries in SQL are nested queries within a main query that provide intermediate results. They allow complex filtering and calculations, returning either a single value or multiple values for use in the outer query. Subqueries can be used in various clauses, like `WHERE`, `SELECT`, and even `FROM`.

```sql
-- Subquery returning a single value
SELECT column1
FROM table_a
WHERE column2 = (SELECT MAX(column2) FROM table_b);

-- Subquery returning multiple values with IN
SELECT column1, column3
FROM table_a
WHERE column2 IN (SELECT column2 FROM table_b WHERE condition);
```

###### 2.3.2 Uncorrelated vs. correlated subqueries

In SQL, an uncorrelated subquery runs independently of the outer query and returns a fixed result, while a correlated subquery depends on each row of the outer query, running repeatedly for each row. Correlated subqueries refer to columns from the outer query, making them suitable for row-by-row comparisons.

```sql
-- Uncorrelated subquery: Independent of the outer query
SELECT column1
FROM table_a
WHERE column2 > (SELECT AVG(column2) FROM table_b);

-- Correlated subquery: Dependent on each row in the outer query
SELECT column1
FROM table_a AS a
WHERE column2 > (SELECT AVG(column2) FROM table_b AS b WHERE b.column3 = a.column3);
```

###### 2.3.3 ALL and ANY keywords

In SQL, the `ALL` and `ANY` keywords allow comparisons against multiple values returned by a subquery. `ALL` requires the condition to be true for all returned values, while `ANY` requires the condition to be true for at least one value in the subquery result.

```sql
-- Using ALL to compare against all values in a subquery
SELECT column1
FROM table_a
WHERE column2 > ALL (SELECT column2 FROM table_b WHERE condition);

-- Using ANY to compare against any value in a subquery
SELECT column1
FROM table_a
WHERE column2 < ANY (SELECT column2 FROM table_b WHERE condition);
```

###### 2.3.4 Exists operator

The `EXISTS` operator in SQL checks if a subquery returns any results, making it more efficient than `IN` when handling large datasets. Unlike `IN`, which retrieves and compares all values, `EXISTS` stops once it finds a matching row, improving performance.

```sql
-- Using EXISTS for better performance
SELECT column1
FROM table_a AS a
WHERE EXISTS (SELECT 1 FROM table_b AS b WHERE b.column2 = a.column2);

-- Using IN (less efficient with large result sets)
SELECT column1
FROM table_a
WHERE column2 IN (SELECT column2 FROM table_b);
```

#### 2.4 Essential SQL functions

###### 2.4.1 Numeric functions

Numeric functions in SQL perform calculations and formatting on numeric data, including rounding, truncation, and absolute values.

| **Function**     | **Description**                          | **Example**                  |
| ---------------- | ---------------------------------------- | ---------------------------- |
| `ROUND(x, d)`    | Rounds *x* to *d* decimal places         | `ROUND(3.1415, 2) → 3.14`    |
| `TRUNCATE(x, d)` | Truncates *x* to *d* decimal places      | `TRUNCATE(3.1415, 2) → 3.14` |
| `CEILING(x)`     | Rounds *x* up to the nearest integer     | `CEILING(3.2) → 4`           |
| `FLOOR(x)`       | Rounds *x* down to the nearest integer   | `FLOOR(3.8) → 3`             |
| `ABS(x)`         | Returns the absolute value of *x*        | `ABS(-5) → 5`                |
| `RAND()`         | Generates a random floating-point number | `RAND() → 0.6723`            |

###### 2.4.2 String functions

String functions in SQL enable effective text manipulation and analysis.

| **Function**                 | **Description**                          | **Example**                                     |
| ---------------------------- | ---------------------------------------- | ----------------------------------------------- |
| `LENGTH(str)`                | Returns the length of *str*              | `LENGTH('hello') → 5`                           |
| `UPPER(str)`                 | Converts *str* to uppercase              | `UPPER('hello') → 'HELLO'`                      |
| `LOWER(str)`                 | Converts *str* to lowercase              | `LOWER('HELLO') → 'hello'`                      |
| `LTRIM(str)`                 | Removes leading spaces from *str*        | `LTRIM('  text') → 'text'`                      |
| `RTRIM(str)`                 | Removes trailing spaces from *str*       | `RTRIM('text  ') → 'text'`                      |
| `TRIM(str)`                  | Removes both leading and trailing spaces | `TRIM(' text ') → 'text'`                       |
| `LEFT(str, n)`               | Returns the leftmost *n* characters      | `LEFT('example', 3) → 'exa'`                    |
| `RIGHT(str, n)`              | Returns the rightmost *n* characters     | `RIGHT('example', 2) → 'le'`                    |
| `SUBSTRING(str, start, len)` | Extracts substring from *str*            | `SUBSTRING('example', 2, 4) → 'xam'`            |
| `LOCATE(substr, str)`        | Finds position of *substr* in *str*      | `LOCATE('a', 'example') → 2`                    |
| `REPLACE(str, old, new)`     | Replaces *old* with *new* in *str*       | `REPLACE('example', 'a', 'o') → 'exomple'`      |
| `CONCAT(str1, str2, ...)`    | Concatenates strings                     | `CONCAT('Hello', ' ', 'World') → 'Hello World'` |

###### 2.4.3 Date/time formats and functions

In SQL, dates and times follow specific formats and can be customized for various needs. SQL stores date values as `YYYY-MM-DD` (year-month-day) and time values as `HH:MM:SS` (hour-minute-second). SQL interprets these formats for calculations, comparisons, and formatting. Date and time functions in SQL are essential for handling and formatting timestamps.

| **Function**                         | **Description**                     | **Example**                                             |
| ------------------------------------ | ----------------------------------- | ------------------------------------------------------- |
| `NOW()`                              | Current date and time               | `NOW() → '2023-10-25 10:32:00'`                         |
| `CURDATE()`                          | Current date                        | `CURDATE() → '2023-10-25'`                              |
| `CURTIME()`                          | Current time                        | `CURTIME() → '10:32:00'`                                |
| `YEAR(date)`                         | Year component of *date*            | `YEAR('2023-10-25') → 2023`                             |
| `MONTH(date)`                        | Month component of *date*           | `MONTH('2023-10-25') → 10`                              |
| `DAY(date)`                          | Day component of *date*             | `DAY('2023-10-25') → 25`                                |
| `HOUR(time)`                         | Hour from *time*                    | `HOUR('10:32:00') → 10`                                 |
| `MINUTE(time)`                       | Minute from *time*                  | `MINUTE('10:32:00') → 32`                               |
| `SECOND(time)`                       | Second from *time*                  | `SECOND('10:32:30') → 30`                               |
| `DAYNAME(date)`                      | Name of the day                     | `DAYNAME('2023-10-25') → 'Wednesday'`                   |
| `MONTHNAME(date)`                    | Name of the month                   | `MONTHNAME('2023-10-25') → 'October'`                   |
| `EXTRACT(part FROM date)`            | Extracts specified part             | `EXTRACT(YEAR FROM '2023-10-25') → 2023`                |
| `DATE_FORMAT(date, format)`          | Formats *date* in specified pattern | `DATE_FORMAT('2023-10-25', '%Y/%m/%d') → '2023/10/25'`  |
| `TIME(date)`                         | Returns the time part of *date*     | `TIME('2023-10-25 10:32:00') → '10:32:00'`              |
| `DATE_ADD(date, INTERVAL expr unit)` | Adds interval to date               | `DATE_ADD('2023-10-25', INTERVAL 5 DAY) → '2023-10-30'` |
| `DATE_SUB(date, INTERVAL expr unit)` | Subtracts interval from date        | `DATE_SUB('2023-10-25', INTERVAL 5 DAY) → '2023-10-20'` |
| `DATEDIFF(date1, date2)`             | Difference between two dates        | `DATEDIFF('2023-10-25', '2023-10-20') → 5`              |

###### 2.4.4 Handling nulls

In SQL, `IFNULL` and `COALESCE` functions help manage `NULL` values by returning alternative values when `NULL` is encountered. `IFNULL(expr1, expr2)` returns `expr2` if `expr1` is `NULL`; otherwise, it returns `expr1`. `COALESCE(expr1, expr2, ..., exprN)` returns the first non-`NULL` expression in the list, making it useful when dealing with multiple potential `NULL` values.

```sql
-- Using IFNULL to replace NULL values
SELECT IFNULL(column1, 'default_value') AS column_alias
FROM table_name;

-- Using COALESCE with multiple expressions
SELECT COALESCE(column1, column2, 'fallback_value') AS column_alias
FROM table_name;
```

###### 2.4.5 Conditional logic

The `IF` function and `CASE` operator in SQL are used to add conditional logic within queries. `IF(condition, true_result, false_result)` returns one value if the condition is met and another if not. The `CASE` operator allows for more complex conditions, checking multiple `WHEN ... THEN` statements, with an `ELSE` clause to specify a default result when no conditions match. 

```sql
-- Using IF function
SELECT IF(column1 > 10, 'High', 'Low') AS result_alias
FROM table_name;

-- Using CASE operator for multiple conditions
SELECT CASE 
           WHEN column1 > 100 THEN 'High'
           WHEN column1 > 50 THEN 'Medium'
           ELSE 'Low'
       END AS result_alias
FROM table_name;
```

## 3. Relationship operations

#### 3.1 Inner join operations

###### 3.1.1 Inner join

An `INNER JOIN` in SQL combines rows from two or more tables based on a related column, returning only those records with matching values in both tables. This is useful for querying related data efficiently.

```sql
SELECT a.column1, b.column2
FROM table_a AS a
INNER JOIN table_b AS b ON a.common_column = b.common_column;
```

The `USING` clause in SQL simplifies join operations when the join is based on a column with the same name in both tables.

```sql
SELECT a.column1, b.column2
FROM table_a AS a
INNER JOIN table_b AS b USING (common_column);
```

###### 3.1.2 Joining tables from different databases

In SQL, you can join tables from different databases by specifying the database names in the table references. This enables you to combine and query related data across separate databases, assuming the necessary permissions are granted.

```sql
SELECT a.column1, b.column2
FROM database_a.table_a AS a
JOIN database_b.table_b AS b ON a.common_column = b.common_column;
```

###### 3.1.3 Self join

A self join in SQL is a technique where a table is joined with itself to compare rows within the same table. This is useful for retrieving hierarchical data or finding relationships among records in a single dataset.

```sql
SELECT a.column1, b.column1
FROM table_name AS a
JOIN table_name AS b ON a.common_column = b.common_column
WHERE a.id != b.id;  -- To avoid matching the same row
```

###### 3.1.4 Joining multiple tables

In SQL, you can join three or more tables by using multiple `JOIN` clauses. Each join connects tables based on related columns, allowing you to retrieve combined data from all the tables involved.

```sql
SELECT a.column1, b.column2, c.column3
FROM table_a AS a
JOIN table_b AS b ON a.common_column = b.common_column
JOIN table_c AS c ON b.another_column = c.another_column;
```

###### 3.1.5 Compound join conditions

In SQL, a compound key consists of two or more columns that together uniquely identify each record in a table. When performing a join on tables with compound keys, all columns of the key must be combined in the join condition to ensure proper matching of related records.

```sql
SELECT a.column1, b.column2
FROM table_a AS a
JOIN table_b AS b 
ON a.column1 = b.column1 AND a.column2 = b.column2;
```

#### 3.2 Outer join operations

###### 3.2.1 Outer join

A `LEFT OUTER JOIN` returns all rows from the left table and matching rows from the right table, with unmatched rows from the right table appearing as NULL.

```sql
-- Left outer join
SELECT a.column1, b.column2
FROM table_a AS a
LEFT JOIN table_b AS b ON a.common_column = b.common_column;
```

A `RIGHT OUTER JOIN` does the opposite, returning all rows from the right table and matching rows from the left, filling unmatched rows from the left table with NULL.

```sql
-- Right outer join
SELECT a.column1, b.column2
FROM table_a AS a
RIGHT JOIN table_b AS b ON a.common_column = b.common_column;
```

The `USING` clause in SQL simplifies join operations when the join is based on a column with the same name in both tables.

```sql
SELECT a.column1, b.column2
FROM table_a AS a
LEFT JOIN table_b AS b USING (common_column);
```

###### 3.2.2 Joining multiple tables

To perform outer joins on three or more tables, you can chain multiple `OUTER JOIN` clauses, ensuring that each join connects two tables while keeping unmatched rows from one table as NULLs.

```sql
SELECT a.column1, b.column2, c.column3
FROM table_a AS a
LEFT JOIN table_b AS b ON a.common_column = b.common_column
LEFT JOIN table_c AS c ON b.another_column = c.another_column;
```

###### 3.2.3 Self outer join

A self outer join allows a table to be joined with itself, including rows without matches. This is typically done using a `LEFT OUTER JOIN`, where unmatched rows from the table are included as NULLs.

```sql
SELECT a.column1, b.column2
FROM table_name AS a
LEFT JOIN table_name AS b ON a.column = b.related_column;
```

#### 3.3 Cross join operations

A  `CROSS JOIN` in SQL returns the Cartesian product of two tables, meaning every row from the first table is paired with every row from the second table, without any specific join condition.

```sql
SELECT a.column1, b.column2
FROM table_a AS a
CROSS JOIN table_b AS b;
```

#### 3.4 Union operations

The `UNION` operator in SQL combines the results of two or more `SELECT` queries into a single result set, removing duplicates. To keep duplicates, `UNION ALL` is used.

```sql
SELECT column1 FROM table_a
UNION
SELECT column1 FROM table_b;

-- To include duplicates:
SELECT column1 FROM table_a
UNION ALL
SELECT column1 FROM table_b;
```

## 4. Altering table records

#### 4.1 Inserting records

In SQL, the `INSERT INTO` statement adds new records to a table. You can insert one or multiple rows, define specific columns, and use `DEFAULT` or `NULL` for specific values.

```sql
-- Inserting one row
INSERT INTO table_name (column1, column2, column3)
VALUES (value1, value2, DEFAULT);

-- Inserting multiple rows
INSERT INTO table_name (column1, column2, column3)
VALUES (value1, value2, NULL),
       (value3, value4, DEFAULT);
```

#### 4.2 Inserting hierarchical records

To insert hierarchical records in SQL between a parent and child table, you first insert a record into the parent table and use the `LAST_INSERT_ID()` function to retrieve the auto-generated ID of the parent. This ID is then used as a foreign key when inserting related records into the child table.

```sql
-- Insert into the parent table
INSERT INTO parent_table (parent_name)
VALUES ('Parent Record');

-- Retrieve the last inserted ID
SET @parent_id = LAST_INSERT_ID();

-- Insert into the child table using the retrieved parent ID
INSERT INTO child_table (child_name, parent_id)
VALUES ('Child Record 1', @parent_id),
       ('Child Record 2', @parent_id);
```

#### 4.3 Creating a table copy

To create a copy of a table in SQL, you can use the `CREATE TABLE AS` statement combined with a `SELECT` query. This method populates the new table with records from the original table, allowing you to modify the subquery to select specific data. However, note that this approach does not copy primary keys, constraints, or auto-increment properties from the original table.

```sql
CREATE TABLE copy_table AS 
SELECT * FROM original_table;

-- Customize the subquery to copy specific data
CREATE TABLE filtered_copy AS 
SELECT column1, column2 
FROM original_table 
WHERE condition;
```

#### 4.4 Updating records

To update a single or multiple records in SQL, you can use the `UPDATE` statement along with the `WHERE` clause to specify which records to modify. This allows you to change one or more columns with literal values or expressions. Note that in MySQL Workbench, safe update mode is enabled by default, preventing updates to multiple records unless this setting is disabled. To allow multiple record updates in MySQL Workbench, navigate to Preferences, disable safe updates under SQL Editor, and restart the connection instance.

```sql
-- Update a single record
UPDATE table_name
SET column1 = 'new_value'
WHERE condition;

-- Update multiple records
UPDATE table_name
SET column1 = column1 + 10, column2 = column2 * 2
WHERE condition;
```

#### 4.5 Updating records with subqueries

In SQL, you can use subqueries within an `UPDATE` statement to dynamically determine the values to set based on data from another table or the same table. This allows for more complex updates, where the new value depends on the result of a separate query.

```sql
-- Update with a subquery
UPDATE table_a
SET column1 = 'new_value'
WHERE column2 IN 
  (SELECT column3
   FROM table_b
   WHERE condition);
```

#### 4.6 Deleting records

In SQL, you can perform `DELETE` operations to remove records from a table based on specified conditions using the `WHERE` clause. This allows for the deletion of one or multiple records that meet certain criteria. To delete all records in a table, simply omit the `WHERE` clause.

```sql
-- Delete a single record
DELETE FROM table_name
WHERE condition;

-- Delete multiple records
DELETE FROM table_name
WHERE condition1 OR condition2;

-- Delete all records
DELETE FROM table_name;  -- Be cautious, as this removes all data
```

#### 4.7 Deleting records with subqueries

In SQL, you can use subqueries within a `DELETE` statement to specify which records to remove based on conditions that rely on data from another table or the same table. This allows for more targeted deletions where the criteria for removal are determined dynamically by the result of a subquery.

```sql
-- Delete records using a subquery
DELETE FROM table_a
WHERE column1 IN 
  (SELECT column2 
   FROM table_b 
   WHERE condition);
```

## 5. Views

#### 5.1 Creating and using views

A view in SQL is a virtual table that stores a saved SQL query, allowing for simplified and reusable query structures without duplicating data. Views are created with `CREATE VIEW` and can contain complex joins, filters, or calculations, making data retrieval easier. Views can be queried like regular tables but do not store data themselves, so they always reflect the current data from the underlying tables. In addition, views allow to add a layer of abstraction by acting as virtual tables, enabling users to interact with complex queries as if they were simple tables. This abstraction helps minimize the impact of changes when underlying tables are modified.

```sql
-- Creating a view to show specific columns and filtered data
CREATE VIEW view_name AS
SELECT column1, column2
FROM table_name
WHERE column3 > 100;

-- Using the view in a query
SELECT * FROM view_name;
```

#### 5.2 Modifying and dropping views

To update or delete views in SQL, `CREATE OR REPLACE VIEW` allows you to modify an existing view without needing to drop it first, while `DROP VIEW` removes a view entirely. This is useful for altering view definitions when table structures or filtering needs change. Typically, users save updated views using `CREATE OR REPLACE` to maintain consistency and avoid disrupting dependent queries.

```sql
-- Altering (replacing) an existing view
CREATE OR REPLACE VIEW view_name AS
SELECT column1, column2
FROM table_name
WHERE column3 < 50;

-- Dropping a view
DROP VIEW view_name;
```

#### 5.3 Updating records in views

In SQL, views can often be used to `INSERT`, `UPDATE`, or `DELETE` records, provided the view meets certain criteria (like including only one base table and no complex joins or aggregations). When allowed, modifying data through a view updates the underlying table directly. Not all views support data modification; check view compatibility before attempting updates.

```sql
-- Inserting into a view
INSERT INTO view_name (column1, column2)
VALUES ('value1', 'value2');

-- Updating records in a view
UPDATE view_name
SET column1 = 'new_value'
WHERE column2 = 'condition_value';

-- Deleting records through a view
DELETE FROM view_name
WHERE column1 = 'specific_value';
```

## 6. Stored procedures

#### 6.1 Creating and using stored procedures

A stored procedure is a set of SQL commands saved on the server to perform a specific task efficiently. It allows centralizing business logic and reduces redundant code. To ensure that an outdated procedure is removed before creating a new one, it’s common to include a `DROP PROCEDURE` statement before `CREATE PROCEDURE`. Adding `IF EXISTS` to the `DROP PROCEDURE` command prevents errors if the procedure doesn’t already exist, making it safer for cleanup and redefinition. 

When defining a procedure, it’s recommended to change the default delimiter (`;`) temporarily (e.g., to `$$`), so the procedure block doesn’t end prematurely. Here’s how to define one:

```sql
-- Dropping a procedure if it exists
DROP PROCEDURE IF EXISTS procedure_name;

-- Set delimiter to avoid early termination
DELIMITER $$ 

-- Create stored procedure
CREATE PROCEDURE procedure_name()
BEGIN
    SELECT * FROM table_name; -- Replace with desired SQL commands
END;
$$

-- Reset delimiter to default
DELIMITER ;
```

Once a stored procedure or function is created in SQL, it’s saved within the database’s schema and can be accessed and executed from any SQL query editor or session that has access to the database. This makes it possible to call the procedure or function from any query tab by simply using the `CALL` statement:

```sql
-- Call the stored procedure
CALL procedure_name();
```

#### 6.2 Parameters in stored procedures

Parameters in stored procedures allow for dynamic input, making the procedure adaptable to different data. Parameters are defined inside the `CREATE PROCEDURE` statement and can be used within the procedure body for filtering or calculations. To manage potential `NULL` values, the `IFNULL()` function can assign a default when needed.

```sql
-- Remove any existing version of the procedure
DROP PROCEDURE IF EXISTS procedure_name;

-- Creating a procedure with a parameter
DELIMITER $$
CREATE PROCEDURE procedure_name(param1 INT)
BEGIN
    SELECT * 
    FROM table_name 
    WHERE column_id = IFNULL(param1, 0); -- Handle NULL
END;
$$
DELIMITER ;
```

Parameters are supplied when calling the procedure, either in the same session or from any SQL query tab once stored.

```sql
-- Calling the stored procedure with a value
CALL procedure_name(1);
```

#### 6.3 Validating parameters in stored procedures

Stored procedures can incorporate parameter validation using `IF` statements to ensure input values meet specified conditions. To handle invalid parameters, the `SIGNAL SQLSTATE` command raises custom error messages, interrupting procedure execution when validation fails. Using an appropriate `SQLSTATE` code helps indicate the type of error. Reference for codes can be found in the [IBM Documentation](https://www.ibm.com/docs/en/db2-for-zos/13?topic=codes-sqlstate-values-common-error).

```sql
DROP PROCEDURE IF EXISTS procedure_name;

-- Creating a procedure with parameter validation
DELIMITER $$
CREATE PROCEDURE procedure_name(param1 INT)
BEGIN
    IF param1 IS NULL OR param1 < 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid parameter: param1 must be a non-negative number.';
    ELSE
        -- Procedure logic if validation passes
        SELECT * FROM table_name WHERE column_id = param1;
    END IF;
END;
$$
DELIMITER ;
```

Once stored in the database schema, this procedure can be called from any SQL query tab by referencing the procedure name and providing parameters:

```sql
-- Calling the procedure
CALL procedure_name(-5); -- Triggers the custom error due to validation failure
```

#### 6.4 Variables in stored procedures

In SQL, variables serve as temporary data storage during the execution of a stored procedure, allowing for intermediate calculations, conditional logic, and data manipulation. In stored procedures, variables are declared with the `DECLARE` statement. Values can be assigned to variables using `SET`, or data can be copied into variables using `SELECT ... INTO ...`.

```sql
DROP PROCEDURE IF EXISTS procedure_name;

DELIMITER $$
CREATE PROCEDURE procedure_name()
BEGIN
    DECLARE total INT; -- Declare a variable
    SET total = 0;     -- Assign an initial value
    SELECT COUNT(*) INTO total FROM example_table; -- Copy query result into the variable
END;
$$
DELIMITER ;
```

Once created in the database schema, this stored procedure can be invoked from any SQL query tab by simply calling it as shown below.

```sql
-- Calling the procedure
CALL procedure_name();
```

The `total` variable’s usage is internal to the procedure and doesn’t persist beyond its execution.

#### 6.5 Output parameters in stored procedures

In SQL, output parameters allow stored procedures to send results back to the caller. By defining parameters with the `OUT` keyword, procedures can assign values to these parameters, which are accessible after the procedure execution. This feature enables storage of results in session-level global variables, which can then be referenced throughout the session.

```sql
DROP PROCEDURE IF EXISTS procedure_name;

DELIMITER $$
CREATE PROCEDURE procedure_name(OUT output_param INT)
BEGIN
    SELECT COUNT(*) INTO output_param FROM example_table; -- Assign value to output parameter
END;
$$
DELIMITER ;
```

To execute this procedure, first declare a session variable to receive the output. Once created, the procedure can be called from any SQL tab within the same session.

```sql
SET @global_variable = 0;               -- Declare a session-level variable
CALL procedure_name(@global_variable);   -- Execute the procedure, storing output in the variable
SELECT @global_variable;                 -- Retrieve the stored output
```

#### 6.6 Functions

Functions in SQL are routines that return a single calculated value based on input parameters. Unlike stored procedures, functions cannot return multiple rows or columns. To ensure an existing function is replaced without errors, the `DROP FUNCTION IF EXISTS` command is often used before creating a function.

Functions may also include attributes like `DETERMINISTIC` (same input produces the same output), `READS SQL DATA` (indicates `SELECT` usage), and `MODIFIES SQL DATA` (for `INSERT`, `UPDATE`, or `DELETE` statements).

```sql
-- Dropping a procedure if it exists
DROP FUNCTION IF EXISTS function_name;

-- Set delimiter to avoid early termination
DELIMITER $$

-- Create function with input parameter
CREATE FUNCTION function_name(param INT)

-- Define the type of the return value
RETURNS INT

-- Define the function attributes
DETERMINISTIC
READS SQL DATA

-- Statements inside the function body
BEGIN
    RETURN param * 2;
END;
$$

-- Reset delimiter to default
DELIMITER ;
```

Once stored in the database schema, the function can be called from any SQL query tab.

```sql
-- Call the function 
SELECT function_name(5);
```

## 7. Triggers and events

#### 7.1 Creating triggers

In SQL, a trigger is a block of code that executes automatically before or after `INSERT`, `UPDATE`, or `DELETE` operations, often used to enforce data consistency. To redefine a trigger safely, use `DROP TRIGGER IF EXISTS` before `CREATE TRIGGER`. Temporarily changing the default delimiter (e.g., to `$$`) allows complex syntax within the trigger definition. It’s recommended to name triggers in this format: (1) table name, (2) timing (before/after), (3) action type (insert/update/delete). The `OLD` and `NEW` keywords can access modified records within the trigger, and `SHOW TRIGGERS` displays all triggers.

```sql
-- Drop existing trigger if present
DROP TRIGGER IF EXISTS table_name_before_insert;

-- Set custom delimiter for the trigger definition
DELIMITER $$

-- Creating the trigger
CREATE TRIGGER table_name_before_insert
BEFORE INSERT ON table_name
FOR EACH ROW

-- Trigger body
BEGIN
    IF NEW.column_id IS NULL THEN -- Call attribute on NEW record
        SET NEW.column_id = 0; -- Default value if column_id is NULL
    END IF;
END;
$$

-- Resetting delimiter back to default
DELIMITER ;
```

Once created, this trigger will run automatically on specified actions and can be called from any SQL query tab within the database schema. To display all the triggers in the current database one can use the command:

```sql
-- Display all triggers in the database
SHOW TRIGGERS;
```

Avoid triggering infinite loops by ensuring the trigger does not modify the table that initiates it.

#### 7.2 Creating events

An SQL event is a task (or block of SQL code) set to execute automatically based on a defined schedule, either once or at regular intervals. To use events in MySQL, the event scheduler must be enabled (`SET GLOBAL event_scheduler = ON;`). 

```sql
-- Enable the event scheduler
SET GLOBAL event_scheduler = ON;
```

Temporarily changing the delimiter (e.g., `$$`) allows complex SQL within the event. Define single or repeated executions with `AT 'YYYY-MM-DD'` for one-time events or `EVERY` for recurring schedules. Display events with `SHOW EVENTS;` and manage their status using `ALTER EVENT` statements.

```sql
-- Drop existing trigger if present
DROP EVENT IF EXISTS event_name;

-- Set custom delimiter for the event definition
DELIMITER $$

-- Create an event
CREATE EVENT IF NOT EXISTS event_name
ON SCHEDULE EVERY 1 MONTH -- Recurring event
DO
BEGIN
    INSERT INTO log_table (log_message) VALUES ('Event executed');
END;
$$

-- Resetting delimiter back to default
DELIMITER ;
```

To display all events that are programmed in the SQL database:

```sql
-- Show all events in the database
SHOW EVENTS;
```

You can also programme events to be temporarily disabled and later re-enabled:

```sql
-- Disable an event
ALTER EVENT event_name DISABLE;

-- Enable an event
ALTER EVENT event_name ENABLE;
```

This setup allows you to automatically schedule tasks for data updates, maintenance, and more, directly from any SQL editor.

## 8. Transactions and concurrency

#### 8.1 Creating transactions

A transaction is a sequence of SQL statements treated as a single, unbreakable unit of work. It ensures the database maintains a consistent state, with the transaction succeeding fully or rolling back if any part fails. Transactions exhibit ACID properties: *atomicity* (all or nothing), *consistency* (preserving database rules), *isolation* (transactions don’t interfere), and *durability* (changes are permanent once committed).

```sql
-- Start a transaction
START TRANSACTION;

-- Execute SQL statements
UPDATE table_name SET column_name = value WHERE condition;

-- Commit transaction if successful
COMMIT;

-- Rollback transaction if an error occurs
ROLLBACK;
```

#### 8.2 Concurrency and transaction isolation levels

###### 8.2.1 Concurrency

Concurrency in SQL involves multiple transactions accessing the database simultaneously, aiming for high performance but requiring isolation to avoid conflicts. This is crucial in multi-user systems where concurrent transactions may modify or read the same data, potentially causing issues like *lost updates*, *dirty reads*, *non-repeatable reads*, and *phantom reads*. SQL’s transaction isolation levels manage these problems by specifying how visible changes made by one transaction are to others. Each level balances concurrency, data consistency, and performance differently.

###### 8.2.2 Concurrency problems

1. Lost Updates: This occurs when two transactions update the same data simultaneously, resulting in one update overwriting the other. Using locks or higher isolation levels can prevent this.
2. Dirty Reads: A transaction reads data that another transaction is currently changing. If that other transaction rolls back, the initially read data becomes invalid. Setting a higher isolation level like READ COMMITTED avoids this issue.
3. Non-repeatable Reads: This happens when a transaction reads the same data twice but gets different results because another transaction has updated the data in between. Using the REPEATABLE READ isolation level ensures consistent results.
4. Phantom Reads: A transaction retrieves a set of rows, but another transaction inserts or deletes rows in the meantime, leading to inconsistent results. The SERIALIZABLE isolation level prevents this by ensuring that transactions are processed one at a time, but it can impact performance.

###### 8.2.3 Isolation levels

1. READ UNCOMMITTED  
   Allows reading uncommitted changes from other transactions. This level offers maximum concurrency but has no isolation, leading to *dirty reads*, *non-repeatable reads*, and *phantom reads*.  
   
   ```sql
   SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
   ```

2. READ COMMITTED  
   Ensures that a transaction only sees committed changes by other transactions, preventing dirty reads but allowing non-repeatable reads and phantom reads. This level is suitable when dirty reads are unacceptable but occasional inconsistencies are tolerable.  
   
   ```sql
   SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
   ```

3. REPEATABLE READ  
   MySQL's default level, preventing dirty reads and non-repeatable reads by locking read rows until the transaction completes. This means each read within the transaction remains consistent. Phantom reads, however, can still occur, which are avoided in most cases by row-level locking and gap-locking in MySQL’s InnoDB engine.
   
   ```sql
   SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;
   ```

4. SERIALIZABLE  
   Enforces full isolation by ensuring that each transaction executes sequentially, avoiding dirty reads, non-repeatable reads, and phantom reads. This level guarantees consistency but has a performance cost due to limited concurrency. Transactions can only be read or modified one at a time, making it appropriate for critical updates where maximum consistency is necessary.
   
   ```sql
   SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;
   ```

###### 8.2.4 Balancing concurrency errors and performance

Adjusting the transaction isolation level affects both concurrency and server performance, with higher levels like SERIALIZABLE ensuring data consistency but reducing concurrency and potentially leading to slower performance due to increased locking. Conversely, lower levels such as READ UNCOMMITTED enhance speed and concurrency but may result in data anomalies, making it crucial to balance performance needs with the risk of concurrency issues. The default REPEATABLE READ level is often recommended as it strikes a suitable balance for many applications, but adjustments may be necessary based on specific requirements.

###### 8.2.5 Working with isolation levels

To view the current isolation level:

```sql
SHOW VARIABLES LIKE 'transaction_isolation';
```

To set the isolation level for the session or globally:

```sql
-- Set isolation level for the current session
SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;

-- Set isolation level globally for all sessions
SET GLOBAL TRANSACTION ISOLATION LEVEL SERIALIZABLE;
```

###### 8.2.6 Deadlocks

Deadlocks occur in SQL when two or more transactions are each waiting for the other to release locks, leading to a situation where none can proceed. Although they aren't a major issue if infrequent, they can cause performance problems if they happen often. To mitigate deadlocks, developers should design transactions to be short and avoid circular lock dependencies by acquiring locks in a consistent order. Implementing error handling that allows for automatic retries when a deadlock is detected can also help maintain smooth operation.

## 9. Managing databases and tables

#### 9.1 Creating and dropping databases

In SQL, you can create a database if it doesn’t already exist using `CREATE DATABASE IF NOT EXISTS`, and similarly, drop a database only if it exists with `DROP DATABASE IF EXISTS`. This helps prevent errors when running scripts multiple times.

```sql
-- Create a database only if it doesn’t already exist
CREATE DATABASE IF NOT EXISTS sample_db;

-- Drop a database only if it exists
DROP DATABASE IF EXISTS sample_db;
```

#### 9.2 Data types

In SQL, data types specify the kind of data a column can hold. Here’s a summary of the most common types:

| Category      | Data Type                          | Description                                                     |
| ------------- | ---------------------------------- | --------------------------------------------------------------- |
| **String**    | `CHAR(x)`, `VARCHAR(x)`            | Fixed/variable-length strings (up to 64KB for VARCHAR).         |
|               | `TINYTEXT`, `TEXT`                 | Text fields (TINYTEXT up to 255B, TEXT up to 64KB).             |
|               | `MEDIUMTEXT`, `LONGTEXT`           | Large text fields (up to 16MB and 4GB, respectively).           |
| **Numeric**   | `TINYINT`, `SMALLINT`              | Small integers (-128 to 127 for TINYINT).                       |
|               | `MEDIUMINT`, `INT`, `BIGINT`       | Medium to large integers (-2B to 9Z).                           |
|               | `DECIMAL(p, s)`, `FLOAT`, `DOUBLE` | Precise decimal and floating-point numbers.                     |
| **Boolean**   | `BOOL`, `BOOLEAN`                  | Represents TRUE or FALSE (often as 1 or 0).                     |
| **Date/Time** | `DATE`, `TIME`                     | Date only or time only values.                                  |
|               | `DATETIME`, `TIMESTAMP`            | Combined date and time values.                                  |
| **Blob**      | `TINYBLOB`, `BLOB`                 | Binary data (up to 255B for TINYBLOB, 64KB for BLOB).           |
|               | `MEDIUMBLOB`, `LONGBLOB`           | Larger binary data (up to 16MB and 4GB, respectively).          |
| **JSON**      | `JSON`                             | Stores JSON objects as text, ideal for structured data storage. |

Large binary (BLOB) and text types can impact performance and are often better stored outside the database when they exceed moderate size.

#### 9.3 Keys

In SQL, keys are attributes or sets of attributes used to uniquely identify rows and establish relationships between tables, maintaining data integrity:

- Primary Keys: A primary key uniquely identifies each row, ensuring all records are distinct. It must be unique and non-null. When multiple columns combine to form a unique identifier, it's known as a composite primary key and is especially useful for many-to-many relationships.

- Foreign Keys: A foreign key links tables by referencing the primary key of another table, establishing relationships across tables and maintaining data consistency.

#### 9.4 Creating and dropping tables

In SQL, you can create a table if it doesn’t already exist using `CREATE TABLE IF NOT EXISTS`. Define columns with data types and apply constraints like `PRIMARY KEY`, `AUTO_INCREMENT`, `DEFAULT`, `NOT NULL`, and `UNIQUE` for more controlled data management. Dropping a table with `DROP TABLE IF EXISTS` allows safe removal.

```sql
-- Create a table only if it doesn’t already exist
CREATE TABLE IF NOT EXISTS sample_table (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE,
    age INT DEFAULT 18,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Drop a table only if it exists
DROP TABLE IF EXISTS sample_table;
```

#### 9.5 Altering table columns

In SQL, tables can be modified to add, update, or delete columns using the `ALTER TABLE` command. Common operations include:

- ADD: Introduces a new column to the table.
- MODIFY: Changes a column’s data type or constraints.
- DROP: Deletes an existing column.

```sql
-- Altering multiple columns from of a table
ALTER TABLE sample_table
    -- Add a new column
    ADD COLUMN new_column VARCHAR(50) AFTER first_column,
    -- Modify an existing column's data type or constraints
    MODIFY COLUMN new_column TEXT,
    -- Drop a column if no longer needed
    DROP COLUMN new_column;
```

#### 9.6 Constraints on foreign keys

SQL allows the application of constraints on foreign keys to manage dependent data behavior during `UPDATE` and `DELETE` operations:

- RESTRICT: Prevents deletion or update if related records exist in another table, maintaining strict data integrity.
- CASCADE: Automatically deletes or updates all related records in the foreign key table when the primary key row is removed or altered.
- SET NULL: Sets the foreign key value to NULL if the referenced primary key row is deleted or updated, useful when data references become optional.
- NO ACTION: Behaves similarly to `RESTRICT`, but the constraint is checked only after all other operations are completed, maintaining a less strict order.

#### 9.7 Creating relationships between tables

When creating a table, foreign keys define relationships between tables, referencing the primary key in another table. Typically, the foreign key name follows the format `fk_<table>_<referenced_table>`. Constraints like `ON DELETE` or `ON UPDATE` set behaviors when referenced rows are altered, commonly using `CASCADE` (propagate changes), `SET NULL`, `NO ACTION`, or `RESTRICT` (prevent deletion).

```sql
CREATE TABLE table_one (
    primary_key_column INT PRIMARY KEY,
    foreign_key_column INT,
    CONSTRAINT fk_table_one_table_two
        FOREIGN KEY (foreign_key_column) REFERENCES table_two(primary_key_column)
        ON DELETE NO ACTION 
        ON UPDATE CASCADE
);
```

#### 9.8 Modifying primary and foreign keys

To alter primary and foreign keys in SQL, you can add or remove these constraints using `ALTER TABLE`. Primary keys are modified directly on columns, while foreign keys use the `ADD CONSTRAINT` or `DROP CONSTRAINT` syntax. Adding foreign keys requires specifying the referenced table and actions upon update or delete.

```sql
-- Add primary key
ALTER TABLE table_one 
ADD PRIMARY KEY (primary_key_column);

-- Drop primary key
ALTER TABLE table_one 
DROP PRIMARY KEY;

-- Add foreign key
ALTER TABLE table_one 
ADD CONSTRAINT fk_table_one_table_two 
FOREIGN KEY (foreign_key_column) REFERENCES table_two (primary_key_column) 
ON DELETE NO ACTION 
ON UPDATE CASCADE;

-- Drop foreign key
ALTER TABLE table_one 
DROP FOREIGN KEY fk_table_one_table_two;
```

#### 9.9 Character sets

A character set in MySQL defines how characters are stored and represented, with `utf8` being the default that supports a wide range of universal characters using up to 3 bytes per character. In contrast, the `latin1` character set, optimized for Latin languages, uses only 1 byte per character. You can view all supported character sets with `SHOW CHARSET` and change the character set at both the database and table levels. Each character set is characterized by a collation that specifies how characters are sorted, and selecting an efficient character set can lead to significant memory savings.

```sql
ALTER DATABASE db_name CHARACTER SET latin1;
ALTER TABLE table_name CHARACTER SET latin1;
```

## 10. Designing databases

#### 10.1 Essential steps

Designing a database requires a structured approach to ensure data integrity, efficiency, and alignment with business needs. Here are the core steps with specific requirements for each:

1. Requirement Analysis  
   
   - Define what data the database will store, who will access it, and the main use cases.
   - Identify data security needs, performance expectations, and scalability requirements.

2. Conceptual Modeling  
   
   - Identify core entities and their high-level relationships without worrying about technical details.
   - Create an Entity-Relationship (ER) diagram or similar visual aid to map out major entities and their connections. 

3. Logical Modeling  
   
   - Define entities more precisely, detailing each attribute's data type, and specify relationships (one-to-one, one-to-many, many-to-many).
   - Identify constraints (e.g., unique fields, primary keys, foreign keys) and data validation rules.

4. Physical Modeling  
   
   - Translate the logical model into a schema for the chosen database system, focusing on optimizing performance.
   - Define indexing strategies, partitioning, and storage requirements, and establish a backup and recovery plan.

These steps provide a comprehensive guide to creating a scalable, efficient, and user-oriented database design. Tools like MySQL Workbench or ERD tools like draw.io can support this process.

#### 10.2 Database normalization

Normalization is the process of organizing database tables to reduce redundancy, improve data integrity, and simplify update operations. Commonly, the first three normal forms (1NF, 2NF, 3NF) are sufficient to achieve these goals:

- First Normal Form (1NF): Each cell must contain only a single value, with no repeated columns. This ensures atomicity by separating multi-valued attributes into linked tables.

- Second Normal Form (2NF): In addition to meeting 1NF, each table should describe one entity, and all columns should directly relate to that entity. Non-relevant columns should be moved to separate tables, linking them back to maintain relationships.

- Third Normal Form (3NF): Along with meeting 1NF and 2NF, no column should depend on another non-primary attribute. This avoids redundant information, keeping tables simple and reducing potential errors when data changes.

#### 10.3 Forward and reverse engineering

Forward Engineering is the process of creating a live database from a physical model, such as an ER diagram, in MySQL Workbench. By using the *Forward Engineer* option, users can select a connection, define export settings, and choose tables and other objects to convert the model into a database. Changes to the database should ideally be applied in the model to keep it consistent and shared among developers. The *Synchronize Model* feature can generate scripts to update the database with these changes.

Reverse Engineering allows users to generate a physical model directly from an existing database. By selecting the *Reverse Engineer* option and choosing a connection, the Workbench imports the schema as an ER diagram, giving a visual representation of the database’s structure.

## 11. Indexing for high performance

#### 11.1 Creating and dropping indexes

Queries are commands used to retrieve, insert, update, or delete data in a database. They can be optimized to improve performance, particularly by using indexes, which are special data structures that allow the database to quickly locate records without scanning the entire table. Indexes should be created for columns frequently used in search conditions, and they are particularly beneficial for performance-critical queries.

To create an index on a table column, you can use the following SQL command:

```sql
CREATE INDEX idx_column_name ON table_name (column_name);
```

To drop an index, the syntax is:

```sql
DROP INDEX idx_column_name ON table_name;
```

The `EXPLAIN` statement in SQL helps analyze query execution by displaying search types and record counts involved. A query with `type = ALL` indicates a full table scan, which can significantly slow down performance. Using indexes with `type = INDEX` is recommended to optimize these queries and reduce full scans.

```sql
EXPLAIN SELECT * FROM table_name WHERE column_name = 'value';
```

You can visualize the indexes on a table using the following command:

```sql
SHOW INDEX FROM table_name;
```

In SQL, a primary index is automatically created for the primary key of a table, ensuring unique identification of records, while a secondary index is any additional index created to improve search efficiency but does not enforce uniqueness. While indexes speed up data retrieval, they also require additional storage space and can slow down write operations, making it essential to design them based on query patterns rather than solely on table structure.

#### 11.2 Prefix indexes

When creating indexes on text columns (CHAR, VARCHAR, TEXT, BLOB), it's essential to manage disk space and performance by indexing only a portion of the data. Smaller indexes fit better in memory, leading to faster searches. When defining an index, specify the number of characters to include in parentheses; this is mandatory for TEXT and BLOB types and optional for CHAR and VARCHAR.

```sql
CREATE INDEX idx_sample ON sample_table (target_column(10));
```

An effective optimization technique involves analyzing the distinct values of substrings to determine the optimal character length for the index.

```sql
SELECT COUNT(DISTINCT target_column),
       COUNT(DISTINCT LEFT(target_column, 1)),
       COUNT(DISTINCT LEFT(target_column, 2)),  
       COUNT(DISTINCT LEFT(target_column, 3)),  
       COUNT(DISTINCT LEFT(target_column, 5)),  
       COUNT(DISTINCT LEFT(target_column, 10))
FROM table_name; 
```

#### 11.3 Full-text indexes

Full-text indexes optimize text searching in databases by allowing efficient searches over large amounts of text data. Use the `CREATE FULLTEXT INDEX` command on text columns to enable full-text search capabilities. The `MATCH()` function checks for relevance of the search terms within specified columns, while `AGAINST()` provides the search query. This can consist of one or more unordered words. Results are ranked based on relevance scores, with higher scores indicating more relevant matches. When using `IN BOOLEAN MODE`, you can refine searches with operators: `+` (must contain), `-` (must not contain), `*` (wildcard), and `"query"` (matching the exact query). 

```sql
CREATE FULLTEXT INDEX idx_fulltext ON sample_table (text_column);

-- REGULAR MODE
SELECT * FROM sample_table 
WHERE MATCH(text_column) AGAINST('search term');

-- BOOLEAN MODE
SELECT * FROM sample_table
WHERE MATCH(text_column) AGAINST('+search t*' IN BOOLEAN MODE);
```

#### 11.4 Composite indexes

Composite indexes in SQL are multi-column indexes that improve query performance when filtering across several columns. Unlike single-column indexes, composite indexes allow the SQL engine to utilize multiple columns in a search, thus optimizing retrieval. For efficient indexing, two principles are key: placing the most frequently queried columns at the start of the composite index and arranging columns with higher cardinality—those with more unique values—near the beginning. This arrangement improves selectivity, helping MySQL retrieve data with fewer scans.

```sql
-- Creating a composite index
CREATE INDEX idx_composite ON sample_table (columnA, columnB);
```

To verify which index MySQL used in a query, you can use the `EXPLAIN` statement, which displays query execution details, including which indexes are accessed and the number of rows scanned. If you want MySQL to use a specific index, you can use the `USE INDEX` clause to enforce the selection of a particular index.

```sql
-- Verifying index usage with EXPLAIN
EXPLAIN SELECT * FROM sample_table WHERE columnA = 'value' AND columnB = 'value';

-- Forcing MySQL to use a specific index in a query
SELECT * FROM sample_table USE INDEX (idx_composite) WHERE columnA = 'value' AND columnB = 'value';
```

#### 11.5 Sorting with Indexes in SQL

In SQL, indexes can optimize sorting operations when sorting columns match the order of an index. MySQL’s `EXPLAIN` statement shows sorting efficiency in the "Extra" column, with "using index" for optimized sorts or "using filesort" for less efficient sorts. For composite indexes, column sort order matters: consistent ascending or descending sorting on all columns will use the index, while mixed orders may require filesorts. You can also gauge query efficiency with `SHOW STATUS LIKE 'last_query_cost';`.

```sql
-- Create index for sorting optimization
CREATE INDEX idx_sort ON example_table (columnA, columnB);

-- Optimized sorting query
EXPLAIN SELECT * FROM example_table ORDER BY columnA ASC, columnB ASC;

-- Query cost evaluation
SHOW STATUS LIKE 'last_query_cost';
```

#### 11.6 Effective index design

Designing efficient indexes is essential to optimize query performance. Here’s a simple guide to creating effective indexes:

1. Prioritize WHERE and ORDER BY Columns: Start by indexing columns used in `WHERE` clauses to quickly filter search results, then add columns used in `ORDER BY` to prevent costly sort operations by leveraging indexes for efficient sorting.

2. Covering Indexes for SELECT: Avoid using `SELECT *` in queries. Instead, index only the specific columns you need to retrieve, and consider creating a covering index that includes these columns. This way, MySQL can retrieve data directly from the index, reducing load by avoiding access to the full table data.

3. Prefer Composite Indexes: Using composite indexes (multiple columns) is often better than multiple single-column indexes for frequently combined searches.

4. Remove Redundant and Unused Indexes: Eliminate duplicate or redundant indexes to avoid wasted space. For instance, an index on `(A, B)` makes an index on `A` alone redundant.

5. Optimize OR Conditions: If a slow query contains an `OR`, consider splitting it into multiple queries using `UNION`, each of which can then use separate indexes.

## 12. Database security

#### 12.1 User management and host access

MySQL enables secure user management by allowing custom user accounts with specific privileges. While the initial `root` user has unrestricted access, additional users can be created with limited permissions for applications or services (e.g., read/write only without structural modification rights). The `CREATE USER` command sets up users, specifying both username and host (location) from which they can connect.

The host component defines where the user can connect from, including:

- `localhost` for connections only from the local machine,
- an IP address (e.g., `192.168.0.1`) to restrict access to a specific network location,
- a domain or subdomain (e.g., `'web_user'@'sub.example.com'`) for managed access from specific web addresses,
- `%` for unrestricted access from any host (e.g., `'remote_user'@'%'`), though this is less secure.

```sql
-- Create a user with limited access from a specific host
CREATE USER 'app_user'@'localhost' IDENTIFIED BY 'secure_password';

-- View all user accounts and their hosts
SELECT User, Host FROM mysql.user;

-- Remove a user
DROP USER 'app_user'@'localhost';
```

To update a user’s password securely:

```sql
SET PASSWORD FOR 'app_user'@'localhost' = 'new_secure_password';
```

#### 12.2 Managing user privileges

Database privileges control the level of access users have, specifying allowed operations within MySQL. Privileges are granted using the `GRANT` command and can be tailored to individual tables or databases. For example, an application user may need limited permissions to perform `SELECT`, `INSERT`, `UPDATE`, `DELETE`, and `EXECUTE` on specific tables:

```sql
GRANT SELECT, INSERT, UPDATE, DELETE, EXECUTE 
ON database_name.table_name 
TO 'app_user'@'localhost';
```

Meanwhile, an admin may require full privileges across all databases and tables:

```sql
GRANT ALL PRIVILEGES 
ON *.* 
TO 'admin_user'@'localhost';
```

To check current privileges, use:

```sql
SHOW GRANTS FOR 'app_user'@'localhost';
```

Privileges can also be revoked when access needs change:

```sql
REVOKE SELECT, INSERT 
ON database_name.table_name 
FROM 'app_user'@'localhost';
```

Customizing user privileges based on roles helps secure sensitive data and protect database integrity.
