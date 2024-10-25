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


