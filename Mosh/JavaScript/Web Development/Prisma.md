# Prisma

## 1. Setting Up Prisma

#### 1.1 Creating Project with Prisma

Learn how to create a new Node.js or TypeScript project from scratch by connecting Prisma ORM to your database and generating a Prisma Client for database access.

As a first step, create a project directory and navigate into it:

```bash
mkdir hello-prisma
cd hello-prisma
```

Next, initialize a TypeScript project and add the Prisma CLI as a development dependency to it:

```bash
npm init -y
npm i --save-dev prisma typescript ts-node @types/node 
```

This creates a `package.json` with an initial setup for your TypeScript app.

Next, initialize TypeScript:

```bash
npx tsc --init
```

You can now invoke the Prisma CLI by prefixing it with `npx`:

```bash
npx prisma
```

Next, set up your Prisma ORM project by creating your [Prisma Schema](https://www.prisma.io/docs/orm/prisma-schema) file with the following command:

```bash
npx prisma init
```

This command does two things:

- Creates a new directory called `prisma` that contains a file called `schema.prisma`, which contains the Prisma schema with your database connection variable and schema models
- Creates the `.env` file in the root directory of the project, which is used for defining environment variables (such as your database connection).

#### 1.2 Formatting Prisma Schema

To ensure your Prisma schema file is correctly formatted, you can use the Prisma CLI command:

```bash
npx prisma format
```

#### 1.3 Setting Up Prisma Generator and Datasource

In Prisma, the **generator** defines the type of code that will be generated, with `prisma-client-js` being the default client for interacting with your database. To configure this, you need to specify the generator in your `schema.prisma` file:

```prisma
generator client {
  provider = "prisma-client-js"
}
```

Additionally, you must configure the **datasource** to connect to your database. For a MySQL database, the setup looks like this:

```prisma
datasource db {
  provider = "mysql"
  url      = env("DATABASE_URL")
}
```

The `url` uses an environment variable `DATABASE_URL` to securely store and access the database connection string.

#### 1.4 Configuring Database Connection in Prisma

To connect your database in Prisma, set the `url` field in the datasource block of your `schema.prisma` file to reference your database connection URL. This URL is typically stored in the `.env` file for security and flexibility. Here's an example of how to configure it:

```env
# .env
DATABASE_URL="mysql://johndoe:randompassword@localhost:3306/mydb"
```

In your `schema.prisma` file, the `url` field will reference this environment variable:

```prisma
datasource db {
  provider = "mysql"
  url      = env("DATABASE_URL")
}
```

## 2. Creating Prisma Models

#### 2.1 Basic Structure of a Prisma Model

Prisma models represent the structure of your database tables in your application’s schema. These models are essential for interacting with the database, as they define the shape and relationships of the data. A Prisma model is defined within the `schema.prisma` file. Each model represents a table in your database, and the fields within the model correspond to the columns of the table.

Syntax Overview:

```prisma
model ModelName {
  fieldName FieldType @attributes
}
```

- `ModelName`: This is the name of the model and corresponds to the database table name.
- `fieldName`: This is the name of a column in the database.
- `FieldType`: Specifies the data type (e.g., `String`, `Int`, `Boolean`, etc.).
- `@attributes`: Optional metadata such as `@id`, `@unique`, or `@default`, which describe constraints, defaults, and relationships.

Example:

```prisma
model User {
  id        Int      @id @default(autoincrement())  // Primary key with auto-increment
  email     String   @unique                       // Unique constraint
  name      String?                               // Optional field (nullable)
  createdAt DateTime @default(now())               // Default to the current time
}
```

#### 2.2 Field Types and Scalar Types

Prisma provides a set of scalar types that map directly to the underlying database types. Below is a table of common Prisma scalar types and their corresponding database types.

| Prisma Type | Description                      | Example Values         |
| ----------- | -------------------------------- | ---------------------- |
| `Int`       | A 32-bit integer                 | `1`, `42`              |
| `Float`     | A floating-point number          | `3.14`, `-0.1`         |
| `String`    | A text field                     | `"Alice"`, `"abc"`     |
| `Boolean`   | A true/false value               | `true`, `false`        |
| `DateTime`  | A timestamp                      | `2024-10-02T10:30:00Z` |
| `Json`      | A field for storing JSON objects | `{"key": "value"}`     |

By default, fields are required, meaning they cannot contain `NULL` values in the database. However, you can make a field nullable by appending `?` to the field’s type.

```prisma
model Post {
  title   String
  content String?
}
```

#### 2.3 Adding Constraints and Defaults

Prisma allows you to add constraints like primary keys, unique fields, and default values.

###### 2.3.1 Primary Key (`@id`)

Every model must have a primary key. The `@id` attribute defines a field as the primary key.

```prisma
model User {
  id Int @id @default(autoincrement())
}
```

This example marks `id` as the primary key, and it auto-increments. One can also use `uuid` to create a more randomized identifier for the model instances:

```prisma
model User {
  id String @id @default(uuid())
}
```

###### 2.3.2 Unique Fields (`@unique`)

The `@unique` attribute ensures that the field’s values are unique across rows in the table.

```prisma
model User {
  email String @unique
}
```

This means no two users can share the same email address.

###### 2.3.3 Default Values (`@default`)

You can assign default values to fields using the `@default` attribute. This is useful for fields like timestamps or default statuses.

```prisma
model Task {
  id         Int      @id @default(autoincrement())
  title      String
  completed  Boolean  @default(false)
  createdAt  DateTime @default(now())
}
```

Here, the `completed` field defaults to `false`, and `createdAt` defaults to the current timestamp.

#### 2.4 Relationships Between Models

In many applications, models are related to one another. Prisma supports relationships between models through various field types and attributes.

###### 2.4.1 One-to-One Relationship

A one-to-one relationship is created when one record in a model is associated with one record in another model. This is implemented using references and the `@relation` attribute.

```prisma
model User {
  id     Int   @id @default(autoincrement())
  profile Profile?
}

model Profile {
  id     Int  @id @default(autoincrement())
  bio    String
  user   User @relation(fields: [userId], references: [id])
  userId Int
}
```

Here, each `User` can have one `Profile`, and each `Profile` belongs to one `User`.

###### 2.4.2 One-to-Many Relationship

In a one-to-many relationship, a record in one model can be associated with multiple records in another model. This is common in cases like a user having many posts.

```prisma
model User {
  id    Int    @id @default(autoincrement())
  name  String
  posts Post[] // A user can have many posts
}

model Post {
  id      Int   @id @default(autoincrement())
  title   String
  content String?
  user    User  @relation(fields: [userId], references: [id])
  userId  Int
}
```

In this example, the `User` model is related to multiple `Post` entries, and each `Post` belongs to one `User`.

###### 2.4.3 Many-to-Many Relationship

In many-to-many relationships, a record in one model can relate to many records in another model, and vice versa. This often involves creating a join table.

```prisma
model User {
  id     Int     @id @default(autoincrement())
  name   String
  groups Group[] @relation("UserGroups")
}

model Group {
  id     Int     @id @default(autoincrement())
  name   String
  users  User[]  @relation("UserGroups")
}
```

In this example, the `User` and `Group` models have a many-to-many relationship. The `@relation` attribute creates a join table behind the scenes to manage this relationship.

#### 2.5 Enums in Prisma Models

If you need to define a field that can only have a predefined set of values, Prisma supports enums. Enums ensure that the field’s values are restricted to a specific set of options.

Defining an Enum:

```prisma
enum Role {
  ADMIN
  USER
  GUEST
}
```

Using Enums in a Model:

```prisma
model User {
  id   Int   @id @default(autoincrement())
  name String
  role Role  @default(USER)
}
```

In this example, `role` is an enum field that can only be one of `ADMIN`, `USER`, or `GUEST`, and it defaults to `USER`.

#### 2.6 Applying Prisma Schema Changes to the Database

To migrate changes from your Prisma schema to the database, use the following command:

```bash
npx prisma migrate dev --name "First database migration"
```

This command creates a development-only migration, generating a migration file that reflects your schema changes. The migration file is stored as an SQL file in the `prisma/migrations` directory and is automatically applied to your database. Each migration file represents a versioned change, making it easy to track and manage schema updates.

## 3. Using the Prisma Client for Database Operations

#### 3.1 Connecting to the Database with Prisma Client

To use Prisma Client effectively, you first need to install it in your project and then initialize it in your code. This allows your application to interact with the database through the models defined in your Prisma schema.

###### 3.1.1 Installation

Start by installing Prisma Client with the following command:

```bash
npm install @prisma/client
```

This installation automatically generates the Prisma Client tailored to your schema by executing:

```bash
npx prisma generate
```

###### 3.1.2 Import and Initialization

Once installed, you can import and initialize Prisma Client in your TypeScript file as follows:

```typescript
import { PrismaClient } from '@prisma/client';

const prisma = new PrismaClient();
```

###### 3.1.3 Best Practices in Next.js Development

A common issue in Next.js development is receiving the warning:

```
warn(prisma-client) There are already 10 instances of Prisma Client actively running.
```

This warning arises because Next.js clears the Node.js cache on every reload, leading to multiple Prisma Client instances and exhausting database connections. To resolve this, instantiate a single Prisma Client instance and store it in the `globalThis` object to ensure reuse:

```typescript
// db.ts
import { PrismaClient } from '@prisma/client';

const prismaClientSingleton = () => {
  return new PrismaClient();
};

declare const globalThis: {
  prismaGlobal: ReturnType<typeof prismaClientSingleton>;
} & typeof global;

const prisma = globalThis.prismaGlobal ?? prismaClientSingleton();

export default prisma;

if (process.env.NODE_ENV !== 'production') globalThis.prismaGlobal = prisma;
```

This setup allows you to import the Prisma Client from `db.ts` while ensuring it is only initialized once in development, thus preventing excessive database connections.

###### 3.1.4 Using Prisma Client with Async/Await

Prisma Client queries return promises, so you'll typically use the `async/await` syntax to handle results. Here’s an example of how to fetch all users from the database:

```typescript
async function main() {
  const users = await prisma.user.findMany();
  console.log(users);
}

main()
  .catch((e) => console.error(e))
  .finally(async () => {
    await prisma.$disconnect();
  });
```

In this example, the call to `prisma.$disconnect()` ensures that the database connection is closed when the operations are complete, helping to manage resources effectively.

#### 3.2 Finding Records

The `find` methods allow you to retrieve records from the database. Prisma provides several ways to query data: `findMany`, `findUnique`, and `findFirst`.

###### 3.2.1 Find All Records (`findMany`)

This retrieves multiple records from a model. You can use filters, ordering, pagination, and relations.

```ts
const allUsers = await prisma.user.findMany();
```

Adding Filters:

```ts
const filteredUsers = await prisma.user.findMany({
  where: {
    email: {
      contains: '@example.com',
    },
  },
});
```

Pagination and Sorting:

```ts
const paginatedUsers = await prisma.user.findMany({
  skip: 5,
  take: 10,
  orderBy: {
    createdAt: 'desc',
  },
});
```

###### 3.2.2 Find a Unique Record (`findUnique`)

The `findUnique` method is used to find a record by its unique field (such as an ID or an email). If no record is found, it returns `null`.

```ts
const userById = await prisma.user.findUnique({
  where: {
    id: 1,
  },
});
```

###### 3.2.3 Find the First Matching Record (`findFirst`)

`findFirst` retrieves the first record that matches the filter conditions. This is useful when you don’t care about retrieving all matching records.

```ts
const firstUser = await prisma.user.findFirst({
  where: {
    isActive: true,
  },
});
```

#### 3.3 Creating Records

To create a new record in the database, you use the `create` method. This method expects the data for the new record to be passed in the `data` property.

Simple Record Creation:

```ts
const newUser = await prisma.user.create({
  data: {
    email: 'jane.doe@example.com',
    name: 'Jane Doe',
  },
});
```

Creating a Record with Relationships:

```ts
const newPost = await prisma.post.create({
  data: {
    title: 'New Post',
    content: 'This is a new post content',
    user: {
      connect: { id: 1 }, // Connect to an existing user
    },
  },
});
```

In this example, the post is associated with an existing user via the `connect` keyword.

#### 3.4 Updating Records

Updating records with Prisma involves specifying the record to update using a `where` condition and passing the updated data in the `data` field.

###### 3.4.1 Simple Update (`update`)

```ts
const updatedUser = await prisma.user.update({
  where: {
    id: 1,
  },
  data: {
    name: 'Updated Name',
  },
});
```

###### 3.4.2 Partial Updates

You can update specific fields without affecting the others. For example, to update only the `email` field:

```ts
const userEmailUpdate = await prisma.user.update({
  where: {
    id: 1,
  },
  data: {
    email: 'new.email@example.com',
  },
});
```

###### 3.4.3 Updating Nested Records

You can also update related records in one operation:

```ts
const updateUserWithPosts = await prisma.user.update({
  where: {
    id: 1,
  },
  data: {
    name: 'New Name',
    posts: {
      create: {
        title: 'A new post',
        content: 'New post content',
      },
    },
  },
});
```

This query updates the user’s name and creates a new post associated with the user.

#### 3.5 Deleting Records

The `delete` method removes records from the database. Like `update`, it uses a `where` clause to specify which record to delete.

###### 3.5.1 Simple Delete (`delete`)

```ts
const deletedUser = await prisma.user.delete({
  where: {
    id: 1,
  },
});
```

###### 3.5.2 Deleting Multiple Records (`deleteMany`)

To delete multiple records at once, use `deleteMany` with filter conditions.

```ts
const deletedInactiveUsers = await prisma.user.deleteMany({
  where: {
    isActive: false,
  },
});
```

This will delete all users who are not active.
