# C#

## 1. Introduction to C# and .NET Framework

#### 1.1 Building Applications in .NET Framework using C#

C# is a modern programming language developed by Microsoft, primarily used for building a wide range of applications. It is particularly powerful when used in conjunction with the .NET Framework, a comprehensive platform that simplifies the development and deployment of Windows-based applications. However, .NET is not limited to C#; it supports multiple languages, enabling developers to build applications using the language of their choice while still leveraging the capabilities of the framework.

#### 1.2 Overview of .NET Framework

The .NET Framework is comprised of two main components: CLR and Class Library.

###### 1.2.1 Common Language Runtime

The CLR is responsible for executing .NET programs. Unlike languages such as C or C++, where code is compiled into native machine code specific to the operating system and hardware, C# code is compiled into an intermediate language (IL) code. This IL code is platform-independent, meaning it can run on any machine that has a compatible CLR. The CLR then performs Just-In-Time (JIT) compilation, converting the IL code into native code at runtime, ensuring compatibility across different systems.

###### 1.2.2 Class Library

The .NET Class Library is a collection of reusable classes, interfaces, and value types that provide a wide array of functionalities, from file I/O to XML parsing, to network communication. This extensive library helps developers avoid writing code from scratch for common tasks, thereby speeding up the development process.

## 2. Building Applications with C#

#### 2.1 Application Architecture

The C# programmong language architecture defines three hierarchiecal levels:

1. When developing applications in C#, the basic building blocks are **classes**. A class is a container for data (attributes) and functions (methods) that define the behavior of an object. 

2. In real-world applications, a single program may consist of hundreds or even thousands of classes, each responsible for a specific piece of functionality. To manage this complexity, classes are organized into **namespaces**. A namespace serves as a container for related classes.

3. As the number of namespaces grows, they are further organized into **assemblies**. An assembly is a physical file on disk (either an executable `.exe` or a dynamically linked library `.dll`) that contains one or more namespaces. When you compile an application, the compiler generates one or more assemblies, depending on how you structure your code.

#### 2.2 Development Environment

The default development environment for C# is Microsoft Visual Studio. Developers can use the free Visual Studio Community Edition to build both free and commercial applications. Once Visual Studio is installed, you can start by creating a new project.

#### 2.3 Creating a New Project

One can create a C# project in Visual Studio in three steps:

1. **Selecting a Template**: Visual Studio offers a variety of templates to kickstart your project, such as desktop applications, web applications, mobile apps, or console applications. For beginners, a console application—an application without a graphical user interface—is a great starting point to learn the basics of C#.

2. **Project Configuration**: After selecting a template, you’ll need to name your project, choose a save location, and decide on a solution name. A solution in Visual Studio can contain multiple projects, but for simple applications, one solution with a single project is sufficient.

3. **Initial Setup**: Visual Studio will create a project based on the selected template and open the Solution Explorer and Code Editor. The Solution Explorer shows the structure of your solution, including the project and its dependencies. The `Program.cs` file is where you will write the code for your application.

#### 2.4 Writing and Running Code

###### 2.4.1 Basic Structure of a C# Program

A C# program starts with the `namespace` keyword, followed by the namespace name. This ensures that all classes within the file belong to that namespace. If you need to use a class from another namespace, you can import it using the `using` statement.

Inside the namespace, you will find a class named `Program`. Every C# console application contains a `Program` class with a `Main` method, which is the entry point of the application. When the program is run, execution begins with the `Main` method.

```csharp
using System;

namespace MyFirstApp
{
    class Program
    {
        static void Main(string[] args)
        {
            // Code execution starts here
            Console.WriteLine("Hello, World!");
        }
    }
}
```

In the example above:

- The `Main` method is `static`, meaning it belongs to the class itself rather than an instance of the class.
- The `Main` method takes a single parameter, `args`, which is an array of strings that can hold command-line arguments.
- The `Console.WriteLine()` method from the `System` namespace is used to output text to the console.
- Each statement in C# must end with a semicolon (`;`).

###### 2.4.2 Running the Program

Running this program will open a console window and display the message "Hello, World!". This simple example demonstrates the basic structure and execution flow of a C# application, and provides a foundation upon which more complex applications can be built.

## 3. Variables and Constants

#### 3.1 Variables

A variable is essentially a name assigned to a storage location in memory. 

###### 3.1.1 Declaring Variables

In C#, a variable is declared by specifying its data type followed by an identifier (the variable's name) and ending the statement with a semicolon. Optionally, you can assign an initial value to the variable at the time of declaration using the assignment operator (`=`). However, it is important to note that a variable must be initialized before it can be used, otherwise the compiler will generate an error.

```csharp
int number; // Declaration
number = 10; // Initialization

// or both in one line:
int anotherNumber = 20;
```

###### 3.1.2 Rules for Variable Identifiers

When naming variables in C#, certain rules must be followed:

- An identifier cannot start with a number.
- An identifier cannot contain spaces.
- An identifier cannot be a reserved keyword in C#.
- It is recommended to use meaningful names for variables to improve code readability.

#### 3.2 Constants

A constant is an immutable value, meaning it cannot change after being set. Constants are particularly useful when you have values that are known at compile time and will remain unchanged throughout the life of the application. Declaring values as constants adds safety to your code by preventing accidental modification.

###### 3.2.1 Declaring Constants

To declare a constant in C#, you use the `const` keyword, followed by the data type and then the identifier. Unlike variables, constants must be initialized at the time of declaration, as their values cannot be changed later.

```csharp
const double Pi = 3.14159;
```

#### 3.3 Naming Conventions

C# developers commonly use specific naming conventions to differentiate between different types of identifiers:

- **Camel Case**: In this convention, the first letter of the first word is lowercase, while the first letters of subsequent words are uppercase. Camel Case is typically used for naming local variables. Example: `localVariable`.

- **Pascal Case**: Here, the first letter of every word is uppercase. Pascal Case is often used for naming constants and other identifiers like class names. Example: `ConstantValue`.

#### 3.4 Primitive Data Types

C# supports a variety of primitive data types that map to corresponding types in the .NET Framework that happens at compilation time. Each primitive type has a specific size in bytes and a defined range of values it can hold.

| Category             | C# Type   | .NET Type | Bytes | Range                         |
| -------------------- | --------- | --------- | ----- | ----------------------------- |
| **Integral Numbers** |           |           |       |                               |
|                      | `byte`    | `Byte`    | 1     | 0 to 255                      |
|                      | `short`   | `Int16`   | 2     | -32,768 to 32,767             |
|                      | `int`     | `Int32`   | 4     | -2.1 × 10^9 to 2.1 × 10^9     |
|                      | `long`    | `Int64`   | 8     | -9.2 × 10^18 to 9.2 × 10^18   |
| **Real Numbers**     |           |           |       |                               |
|                      | `float`   | `Single`  | 4     | -3.4 × 10^38 to 3.4 × 10^38   |
|                      | `double`  | `Double`  | 8     | -1.7 × 10^308 to 1.7 × 10^308 |
|                      | `decimal` | `Decimal` | 16    | -7.9 × 10^28 to 7.9 × 10^28   |
| **Character**        | `char`    | `Char`    | 2     | Unicode characters            |
| **Boolean**          | `bool`    | `Boolean` | 1     | `true` / `false`              |

###### 3.4.1 Declaring Real Numbers

When dealing with real numbers in C#, it is crucial to append the appropriate suffix to the literal values: use `f` for `float` and `m` for `decimal`. If you omit these suffixes, the compiler will treat the number as a `double` by default.

```csharp
float temperature = 98.6f;
double height = 1.85;
decimal price = 19.99m;
```

###### 3.4.2 Simplifying Variable Declarations

In C#, the `var` keyword provides a convenient way to declare variables without explicitly specifying their data type. When you use `var`, the compiler automatically infers the variable's data type based on the value assigned to it. This feature can simplify code and reduce redundancy, especially in cases where the data type is clear from the context.

```csharp
var number = 10; // The compiler infers that 'number' is of type int
```

#### 3.5 Overflowing

Overflow occurs when a variable exceeds the maximum or minimum value that its data type can hold. When this happens, the value "wraps around" to the opposite boundary of the data type's range. For example, if an int variable exceeds its maximum value of 2,147,483,647, it will wrap around and start again from the minimum value of -2,147,483,648. 

By default, C# does not check for overflow during arithmetic operations, allowing overflow to occur silently. While this behavior might be acceptable in some scenarios, it can lead to unexpected results or bugs in your application.

#### 3.6 Scope

In C#, the scope of a variable or constant refers to the region of the code where it is accessible and can be used. The scope defines the boundaries within which the variable or constant has meaning and where the compiler recognizes its existence. Outside of this defined scope, the variable or constant is not accessible, and attempting to use it will result in a compilation error.

```csharp
{
    // The variable is accessible in this block
    char variable = 'a';
    {
        // The variable is accessible in this sub block
    }
}
// The variable is not accessible in this block
```

#### 3.7 Type Conversion

Type conversion in C# allows you to change a variable's data type to another. This can happen automatically or require explicit intervention, depending on the nature of the conversion.

###### 3.7.1 Implicit Type Conversion

Implicit type conversion, also known as implicit casting, occurs automatically when a smaller data type is converted to a larger data type. This type of conversion is handled by the C# compiler without any risk of data loss. For example, converting an `int` to a `double` happens implicitly because the `double` data type can easily accommodate the value of an `int`.

```csharp
int myInt = 10;
double myDouble = myInt; // Implicit conversion from int to double
```

###### 3.7.2 Explicit Type Conversion

Explicit type conversio, or explicit casting, is necessary when converting a larger data type to a smaller one. Since this conversion might lead to data loss (e.g., converting a `double` to an `int`), it requires the programmer to explicitly specify the conversion. This is done by placing the target data type in parentheses before the value being converted.

```csharp
double myDouble = 9.78;
int myInt = (int)myDouble; // Explicit conversion from double to int
```

###### 3.7.3 Conversion Between Non-Compatible Types

Sometimes, you may need to convert between data types that are not directly compatible. In such cases, simple casting won’t work, and you must use the `Convert` class provided by the `System` namespace. The `Convert` class offers various methods, such as `ToByte()`, `ToInt16()`, `ToInt32()`, and `ToInt64()`, to handle conversions between non-compatible types.

```csharp
string numberString = "123";
int number = Convert.ToInt32(numberString); // Converts string to int
```

## 4. Operators

#### 4.1 Arithmetic Operators

Arithmetic operators are used to perform mathematical operations such as addition, subtraction, multiplication, division, and finding the remainder. They also include increment and decrement operations, which increase or decrease a value by one.

| Operator | Description                                                  |
| -------- | ------------------------------------------------------------ |
| `+`      | Adds two operands.                                           |
| `-`      | Subtracts the second operand from the first.                 |
| `*`      | Multiplies two operands.                                     |
| `/`      | Divides the first operand by the second.                     |
| `%`      | Returns the remainder of a division operation.               |
| `++`     | Increments the value of the operand by one (prefix/postfix). |
| `--`     | Decrements the value of the operand by one (prefix/postfix). |

###### 4.1.1 Prefix and Postfix Increment/Decrement

The increment (`++`) and decrement (`--`) operators can be used in two ways: prefix and postfix. The prefix version (`++x`, `--x`) increments or decrements the value before using it in an expression, while the postfix version (`x++`, `x--`) uses the value first and then increments or decrements it.

###### 4.1.2 Operator Precedence

Operator precedence in C# determines the order in which arithmetic operations are performed when multiple operators are used in a single expression. For example, multiplication and division have higher precedence than addition and subtraction, so they are performed first.

You can manipulate operator precedence by using parentheses `()`. When you enclose an expression in parentheses, that expression is evaluated first, regardless of the operators' default precedence.

```csharp
int result = 5 + 3 * 2; // result : 11
int result = (5 + 3) * 2; // result : 16
```

#### 4.2 Comparison Operators

Comparison operators are used to compare two values. They return a boolean result (`true` or `false`) based on whether the comparison is true.

| Operator | Description                                                         |
| -------- | ------------------------------------------------------------------- |
| `==`     | Checks if two operands are equal.                                   |
| `!=`     | Checks if two operands are not equal.                               |
| `>`      | Checks if the first operand is greater than the second.             |
| `>=`     | Checks if the first operand is greater than or equal to the second. |
| `<`      | Checks if the first operand is less than the second.                |
| `<=`     | Checks if the first operand is less than or equal to the second.    |

#### 4.3 Assignment Operators

Assignment operators are used to assign values to variables. They include the basic assignment operator as well as compound operators that perform an operation and assign the result in one step.

| Operator | Description                                                               |
| -------- | ------------------------------------------------------------------------- |
| `=`      | Assigns the value on the right to the variable on the left.               |
| `+=`     | Adds the right operand to the left operand and assigns the result.        |
| `-=`     | Subtracts the right operand from the left operand and assigns the result. |
| `*=`     | Multiplies the left operand by the right operand and assigns the result.  |
| `/=`     | Divides the left operand by the right operand and assigns the result.     |

#### 4.4 Logical Operators

Logical operators are used to combine or invert boolean expressions. They are typically used in conditional statements to control the flow of a program.

| Operator | Description                                                                  |
| -------- | ---------------------------------------------------------------------------- |
| `&&`     | Returns `true` if both operands are true; otherwise, returns `false`.        |
| `\||`    | Returns `true` if one of both operands are true; otherwise, returns `false`. |
| `!`      | Inverts the boolean value of the operand.                                    |

## 5. Comments

Comments are pieces of text in the code that are ignored by the compiler and are used to enhance the readability and maintainability of the code. They serve as notes or explanations for developers, helping them understand the purpose or logic behind certain code sections.

#### 5.1 Single-Line Comments

Single-line comments are used to comment out a single line or part of a line of code. To create a single-line comment, you prefix the comment with a double slash (`//`). Everything after `//` on that line is treated as a comment and ignored by the compiler.

```csharp
int x = 10; // This is a single-line comment
```

#### 5.2 Multi-Line Comments

Multi-line comments are used for longer comments that span multiple lines. To create a multi-line comment, you start with a slash followed by an asterisk (`/*`) and end with an asterisk followed by a slash (`*/`). Everything between these symbols is treated as a comment.

```csharp
/* 
This is a multi-line comment.
It can span multiple lines.
*/
```

#### 5.3 Best Practices for Using Comments

While comments are useful for explaining code, they should be used sparingly and purposefully. The focus of comments should be on explaining the "why" and "how" of the code, including any constraints or decisions made during development, rather than describing what the code does. Well-written code should be self-explanatory, with comments providing additional context where necessary.

Overusing comments can lead to clutter and can become problematic if the code is updated but the comments are not. This is because comments are not maintained or checked by the compiler, so outdated comments can be misleading to other developers working on the code.
