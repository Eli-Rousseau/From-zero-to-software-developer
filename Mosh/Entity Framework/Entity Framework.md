# Entity Framework

## 1. Introduction to Entity Framework

#### 1.1 Creating an Persistence Framwork

To access a database in an application, a persistence framework is essential for loading and saving objects to and from the database. Developers can either create their own persistence frameworks using plain ADO.NET classes such as `SqlConnection`, `SqlCommand`, and `SqlDataReader`, or they can leverage an existing framework. Building a custom persistence framework from scratch is labor-intensive, involving the creation of stored procedures, the use of ADO.NET, and the manual mapping of database tables and records to domain objects. This is where Entity Framework (EF) excels, as it automates much of this work, significantly simplifying the process.

#### 1.2 Entity Framework Approaches

Entity Framework provides three primary approaches to building a domain model:

1. **Database First**: Start by designing the database tables and use Entity Framework to generate domain classes based on the existing database schema.

2. **Code First**: Begin by creating the domain classes in your code and use Entity Framework to generate the corresponding database tables based on these classes.

3. **Model First**: Develop a UML diagram to model classes and their associations. Entity Framework uses this diagram to generate both the domain classes and the database schema. This approach is less commonly used in real-world scenarios.

The Code First approach in Entity Framework is particularly advantageous for managing database versioning, as it allows developers to easily bring the database to any desired version with a single command. This simplifies the maintenance of different application versions, eliminating the need for manual versioning or costly third-party tools like Redgate Source Control. The message would be to prioritze this approach when possible.

## 2. Database First Workflow


