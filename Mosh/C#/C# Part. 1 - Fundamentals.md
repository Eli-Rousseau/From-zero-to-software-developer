# C#: Part. 1 - Fundamentals

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

###### 3.4.2 Character Encoding Standard

ASCII is a character encoding standard that represents text in computers and other devices that use text. Each character, including letters, digits, and symbols, is mapped to a unique decimal number ranging from 0 to 127. This allows characters to be easily converted (or cast) into their corresponding numerical values in programming, and vice versa. For example, the character `'A'` has an ASCII value of 65, so casting `'A'` to an integer in many programming languages would yield 65. This feature enables easy manipulation of characters in terms of their numeric representations.

###### 3.4.3 Simplifying Variable Declarations

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

| Operator | Description                                                           |
| -------- | --------------------------------------------------------------------- |
| `&&`     | Returns `true` if both operands are true; otherwise, returns `false`. |
| `\|      | `                                                                     |
| `!`      | Inverts the boolean value of the operand.                             |

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

## 6. Non-Primitive Data Types

#### 6.1 Classes

###### 6.1.1 Defining Classes

Classes are the fundamental building blocks of object-oriented programming in C#. They serve as blueprints for creating objects, which are instances of these classes. A class groups together related variables (known as fields) and functions (known as methods) into a single, cohesive unit. To define a class in C#, you need to specify an access modifier, use the `class` keyword, and provide a class name (also known as an identifier).

```csharp
public class Car
{
    // Fields
    private string make;
    private string model;

    // Method
    public void Drive()
    {
        Console.WriteLine("The car is driving.");
    }
}
```

###### 6.1.2 Creating an Object of a Class

An object is an instance of a class, meaning it is a concrete implementation of the class blueprint. To create an object in C#, you declare a variable of the class type, use the `new` keyword to allocate memory, and call the class's constructor. Once the object is created, you can access its fields and methods using the dot notation.

```csharp
Car myCar = new Car();
myCar.Drive();
```

###### 6.1.3 Static Fields and Methods

Static fields and methods belong to the class itself rather than to any specific instance. This means they can be accessed directly through the class name, without needing to create an instance. You use the `static` modifier to declare static members. Static members are useful when you want a single, shared instance of a variable or method across all instances of the class.

```csharp
public class Program
{
    public static void Main(string[] args)
    {
        Console.WriteLine("Hello, World!");
    }
}
```

In the example above, the `Main()` method is declared as `static` because it serves as the entry point of the application, and there should only be one such method. Since it is static, it can be called directly using the class name without creating an instance of the `Program` class.

#### 6.2 Structs

###### 6.2.1 Usage of Structs

Structs in C# are similar to classes in that they both serve as containers for related data (fields) and behavior (methods). However, while classes are typically more versatile and commonly used in most scenarios, structs can be more efficient when defining small, lightweight objects with only a few fields or methods. This efficiency becomes particularly valuable when you need to create a large number of such objects. For instance, structs are often used to represent geometric coordinates, colors, or small data aggregates like a point in 2D space.

```csharp
public struct Point
{
    public int X;
    public int Y;

    public void DisplayCoordinates()
    {
        Console.WriteLine($"X: {X}, Y: {Y}");
    }
}
```

#### 6.3 Arrays

###### 6.3.1 Declaring an Array

An array is a fundamental data structure in C# that allows you to store a collection of variables, all of the same type, in a single, organized structure. Declaring an array in C# is similar to declaring a variable of a primitive data type, with some key differences. When declaring an array, you must include square brackets `[]` after the data type to indicate that the variable will hold an array.

```csharp
int[] numbers = new int[5];
```

Behind the scenes, arrays in C# are objects. The syntax used to declare an array actually creates an instance of the `Array` class, which is part of the .NET framework. 

###### 6.3.2 Accessing Array Elements

To access or modify the elements of an array, you use the index inside square brackets `[]`. It's important to note that C# arrays are zero-indexed, meaning the first element is accessed with an index of `0`.

```csharp
int firstNumber = numbers[0]; // Accessing the first element
numbers[1] = 42; // Modifying the second element
```

###### 6.3.3 Array Initialization

C# also provides an object initialization syntax, which allows you to declare and initialize the array in a single step. This approach is more concise and eliminates the need to specify the array elements explicitly after declaration.

```csharp
int[] numbers = new int[5] { 1, 2, 3, 4, 5 };
```

#### 6.4 Strings

###### 6.4.1 String Literals

A string in C# is a sequence of characters enclosed within double quotes. It differs from a single character, which is enclosed in single quotes. One of the simplest ways to create a string in C# is by using a string literal. This involves defining a variable with the `string` type, followed by an identifier, an assignment operator, and the string value enclosed in double quotes.

```csharp
string greeting = "Hello, World!";
```

Although `string` appears to be a primitive data type, it is actually an alias for the `String` class in the `System` namespace. Therefore, whether you use `string` or `String`, you are creating an instance of the `String` class.

###### 6.4.2 Concatenation

Strings can also be created by concatenating multiple strings together using the `+` operator.

```csharp
string fullName = "Eli" + " " + "Rousseau";
```

###### 6.4.3 String Formatting

String formatting allows you to create a string by inserting values into placeholders within a format string. This is done using the `Format()` method of the `String` class.

```csharp
string formattedString = String.Format("My name is {0} and I am {1} years old.", "John", 30);
```

###### 6.4.4 Joining Strings

You can also create a string by joining elements of an array using the `Join()` method from the `String` class. The method takes a separator and the array elements to combine them into a single string.

```csharp
string[] words = { "apple", "banana", "cherry" };
string fruitList = String.Join(", ", words);
```

###### 6.4.5 Accessing Characters in a String

The individual characters in a string can be accessed using an index, similar to accessing elements in an array.

```csharp
char firstLetter = greeting[0]; // 'H'
```

###### 6.4.6 String Immutability

In C#, strings are immutable, meaning that once a string is created, it cannot be changed. If you attempt to modify a string, you will actually create a new string instance rather than altering the original one.

###### 6.4.7 Special Characters in Strings

C# provides several special characters that have specific meanings when used within strings.

| Char | Description           |
| ---- | --------------------- |
| `\n` | New line              |
| `\t` | Tab                   |
| `\\` | Backslash             |
| `\'` | Single quotation mark |
| `\"` | Double quotation mark |

###### 6.4.8 Verbatim Strings

When working with strings that contain many special characters, such as backslashes in file paths, you can use a verbatim string. A verbatim string is created by prefixing the string with the `@` symbol, which treats backslashes as normal characters and not escape sequences.

```csharp
string filePath = @"C:\Users\JohnDoe\Documents\file.txt";
```

###### 6.4.9 Useful String Methods

C# provides a rich set of methods for manipulating and working with strings. Below is a detailed description of some of the most commonly used string methods.

| **Category**                | **Method**                          | **Description**                                                                     |
| --------------------------- | ----------------------------------- | ----------------------------------------------------------------------------------- |
| **Formatting**              | `ToLower()`                         | Converts all characters in the string to lowercase.                                 |
|                             | `ToUpper()`                         | Converts all characters in the string to uppercase.                                 |
|                             | `Trim()`                            | Removes leading and trailing whitespace from the string.                            |
| **Searching**               | `IndexOf(string)`                   | Finds the index of the first occurrence of a specified substring.                   |
|                             | `LastIndexOf(string)`               | Finds the index of the last occurrence of a specified substring.                    |
| **Substring**               | `Substring(startIndex, length)`     | Extracts a substring starting at the specified index and with the specified length. |
| **Replacing**               | `Replace(old, new)`                 | Replaces all occurrences of a specified substring with another substring.           |
| **Null and Empty Checking** | `String.IsNullOrEmpty(string)`      | Checks if the string is either null or has a length of zero.                        |
|                             | `String.IsNullOrWhiteSpace(string)` | Checks if the string is null, empty, or consists only of white-space characters.    |
| **Splitting**               | `Split(pattern)`                    | Splits the string into an array of substrings based on the specified pattern.       |
| **Conversion**              | `Convert.ToInt32(string)`           | Converts a string to a 32-bit integer.                                              |
|                             | `ToString()`                        | Converts a number to its string representation.                                     |

#### 6.5 StringBuilder

###### 6.5.1 Advantges of StringBuilder

In C#, the `StringBuilder` class is a useful tool for efficiently handling extensive string manipulation. Unlike the `String` class, which is immutable, `StringBuilder` allows for the creation and modification of strings without generating new instances each time a change is made. This can significantly improve performance, especially in scenarios where numerous string modifications are necessary. However, one should realize that `StringBuilder` are not meant for searching type of operations, these might be more efficiently handled by the `String` class.

###### 6.5.2 Declaring a StringBuilder

 `StringBuilder` is a class from the `System.Text` namespace.  Here's how you can declare a `StringBuilder`:

```csharp
StringBuilder sb = new StringBuilder();
StringBuilder sb = new StringBuilder("Initial string"); // Can be initialized with a string
```

###### 6.5.3 Useful StringBuilder Methods

Here’s a table summarizing some of the most commonly used `StringBuilder` methods:

| Method         | Description                                                                      |
| -------------- | -------------------------------------------------------------------------------- |
| `Append()`     | Adds a string to the end of the `StringBuilder` instance.                        |
| `AppendLine()` | Adds a string followed by a newline character to the end of the `StringBuilder`. |
| `Insert()`     | Inserts a string at the specified index within the `StringBuilder`.              |
| `Remove()`     | Deletes a specified range of characters from the `StringBuilder`.                |
| `Replace()`    | Replaces all occurrences of a specified string or character.                     |
| `Clear()`      | Removes all content from the `StringBuilder` instance.                           |
| `ToString()`   | Converts the `StringBuilder` content to a regular string.                        |

#### 6.6 Enums

###### 6.6.1 Defining an Enum

An enum (short for "enumeration") is a special data type in C# that allows you to define a set of named constants. Enums are useful when you have a collection of related constants, such as days of the week, directions, or states in a process. To define an enum, start by specifying an access modifier, followed by the `enum` keyword and an identifier for the enum. Inside the enum block, list the name/value pairs that make up the enum.

```csharp
public enum DaysOfWeek
{
    Sunday,
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday
}
```

###### 6.6.2 Internal Representation

By default, the values in an enum are stored as integers, with the first value assigned `0` and each subsequent value incremented by one. However, you can change the underlying data type of the enum values by specifying it after the enum identifier.

```csharp
public enum DaysOfWeek : byte
{
    Sunday = 1,
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday
}
```

###### 6.6.3 Accessing Enum Values

You can access enum values using dot notation. Enums can also be used to declare variables of the enum type.

```csharp
DaysOfWeek today = DaysOfWeek.Monday;
```

To retrieve the numeric value associated with an enum name, you need to cast the enum value to its underlying data type.

```csharp
int numericValue = (int)DaysOfWeek.Monday; // Outputs 1
```

###### 6.6.4 Parsing Strings to Enum

If you have a string representation of an enum name, you can convert it to the corresponding enum name using the `Parse()` method from the `Enum` class in the `System` namespace. This requires specifying the enum type and the string value to be parsed. The returned object must then be cast to the enum type.

```csharp
DaysOfWeek day = (DaysOfWeek)Enum.Parse(typeof(DaysOfWeek), "Monday");
```

###### 6.6.5 Converting Values to Enum Names

Conversely, you can obtain the name of an enum based on its numeric value by casting the numeric value to the enum type.

```csharp
string dayName = ((DaysOfWeek)1).ToString(); // Outputs "Monday"
```

## 7. Value Types vs. Reference Types

#### 7.1 Implementation of Primitive and Non-Primitive Types

In C#, you can create new types using two main constructs: classes and structs. Both are powerful tools, but they differ significantly in how they are treated at runtime and how they manage memory.

- **Primitive Types**: All primitive types in C#, such as `int`, `float`, and `bool`, are implemented as structs. This means they are **value types**. Additionally, you can create custom value types by defining your own structs.

- **Non-Primitive Types**: Non-primitive types, like arrays and strings, are implemented as classes. You can also create custom classes. Unlike structs, classes are **reference types**, and this distinction plays a crucial role in their memory behavior.

#### 7.2 Memory Management

###### 7.2.1 Value Types (Structs)

In C#, structs are known as value types. When you create a variable that is a value type, the memory required for that variable is automatically allocated on the **stack**, a specific area of memory. The stack is efficient and fast because its allocation and deallocation are managed automatically. When a value type variable goes out of scope, the Common Language Runtime (CLR) immediately removes it from memory.

###### 7.2.2 Reference Types (Classes)

Classes, on the other hand, are reference types. When you create an instance of a class, memory for the object is allocated on the **heap**, a different area of memory designed for longer-lived objects. Unlike the stack, memory on the heap is managed through a process called **garbage collection**, handled by the CLR. The garbage collector periodically checks for objects that are no longer in use and removes them from the heap.

#### 7.3 Copying Value Types vs. Reference Types

###### 7.3.1 Copying Value Types

When you copy a value type variable, a new, independent copy of the value is created on the stack. As a result, changes made to one copy do not affect the other.

###### 7.3.2 Copying Reference Types

Copying a reference type variable does not create a new instance of the object. Instead, it creates a new reference to the same object in memory. Both variables point to the same memory address on the heap, so changes to one reference will affect the object seen by the other reference.

## 8. Control Flow

#### 8.1 Conditional Statements

###### 8.1.1 If / else Statements

If/else statements are used to execute code based on whether a specific condition is true or false. They allow you to control the flow of the program by providing alternative paths for different conditions.

```javascript
if (condition) {
    someStatement
} else if (anotherCondition) {
    anotherStatement
} else {
    yetAnotherStatement
}
```

###### 8.1.2 Switch / case Statements

Switch/case statements are used to simplify multiple if/else conditions by allowing a variable to be tested against a list of values, executing the corresponding block of code for the matching case. 

```javascript
switch(variable) {
    case value1:
        // code block for value1
        break;
    case value2:
        // code block for value2
        break;
    default:
        // code block if no cases match
        break;
}
```

###### 8.1.3 Conditional Operator

The conditional (ternary) operator is a shorthand for if/else statements, used to assign a value to a variable based on a condition. It is useful for making concise, inline decisions.

```javascript
var variable = (condition) ? valueIfConditionIsTrue : valueIfConditionIsFalse;
```

#### 8.2 Iteration Statements

###### 8.2.1 For Loops

For loops are used to execute a block of code a specific number of times, typically when you know in advance how many iterations are required. They are ideal for iterating through sequences with a known number of elements.

```csharp
for (var i = 0; i < number; i++) {
    // code to execute on each iteration
}
```

###### 8.2.2 Foreach Loops

Foreach loops are used to iterate through each element in a collection or array, executing a block of code for each element. They are useful when you need to access each item in a collection without needing to know the index.

```csharp
foreach (var element in elements) {
    // code to execute for each element
}
```

###### 8.2.3 While Loops

While loops are used to execute a block of code repeatedly as long as a specified condition remains true. They are useful when the number of iterations is not known beforehand and depends on the condition.

```csharp
while (i < number) {
    // code to execute while condition is true
    i++;
}
```

###### 8.2.4 Do-While Loops

Do-while loops are similar to while loops but guarantee that the block of code will be executed at least once, even if the condition is initially false. The condition is evaluated after the loop's body has been executed.

```csharp
do {
    // code to execute at least once
    i++;
} while (i < number);
```

###### 8.2.5 Break Statement

The `break` statement is used to exit a loop immediately, stopping any further iterations. It is typically used when a certain condition is met that requires the loop to terminate.

###### 8.2.6 Continue Statement

The `continue` statement is used to skip the current iteration and move directly to the next iteration of the loop. It is useful when you want to bypass certain parts of the loop's code based on a condition.

## 9. Arrays and Lists

#### 9.1 Arrays

An array is a data structure that allows you to store a fixed number of variables of a specific type. In C#, arrays come in two main types: single-dimensional and multi-dimensional arrays. Moreover, the multidimensional arrays in C# can be divided into two types: rectangular arrays and jagged arrays.

###### 9.1.1 Single-Dimensional Arrays

Single-dimensional arrays are the simplest form of arrays in C#. They represent a series of elements stored in a linear sequence. To declare a single-dimensional array, you specify the data type followed by square brackets `[]` and then the number of elements you wish to store within those brackets.

```csharp
int[] numbers = new int[5];  // Array with 5 elements of type int
```

Alternatively, you can use object initialization syntax to declare and initialize the array in one step:

```csharp
int[] numbers = new int [5] { 1, 2, 3, 4, 5 };  // Array with 5 elements initialized
```

###### 9.1.2 Rectangular Arrays

Rectangular arrays are arrays where each row has the same number of columns, forming a grid or matrix. To declare a rectangular array, you specify the size of each dimension within the square brackets.

```csharp
int[,] matrix = new int[3, 4];  // A 3x4 matrix (3 rows and 4 columns)
```

You can also use object initialization syntax:

```csharp
int[,] matrix = new int[3, 4] {
    { 1, 2, 3, 4 },
    { 5, 6, 7, 8 },
    { 9, 10, 11, 12 }
};
```

###### 9.1.3 Jagged Arrays

Jagged arrays are arrays of arrays, meaning each row can have a different number of columns. This makes them more flexible but also more complex to manage. They are particularly useful when working with data structures that do not fit neatly into a grid. To declare a jagged array, you first define the number of rows, and then each row is initialized separately:

```csharp
int[][] jaggedArray = new int[3][];  // Array with 3 rows
jaggedArray[0] = new int[4];  // First row with 4 columns
jaggedArray[1] = new int[2];  // Second row with 2 columns
jaggedArray[2] = new int[3];  // Third row with 3 columns
```

When working with multi-dimensional arrays, it's important to note that the .NET Common Language Runtime (CLR) is optimized for single-dimensional arrays. As a result, operations on single-dimensional arrays, even in complex structures like matrices, might be more efficient if implemented as jagged arrays rather than rectangular arrays.

###### 9.1.4 Array Properties and Methods

All arrays in C# are instances of the `Array` class in the `System` namespace. This class provides several useful properties and methods that help you manipulate arrays efficiently.

| **Property/Method**                | **Description**                                          |
| ---------------------------------- | -------------------------------------------------------- |
| `Array.Length(array)`              | Returns the total number of elements in the array.       |
| `Array.IndexOf(array, element)`    | Returns the index of the first occurrence of an element. |
| `Array.Clear(array, start, end)`   | Clears elements in a specified range of the array.       |
| `Array.Copy(source, dest, length)` | Copies a range of elements from one array to another.    |
| `Array.Sort(array)`                | Sorts the elements of the array in ascending order.      |
| `Array.Reverse(array)`             | Reverses the order of elements in the array.             |

#### 9.2 Lists

###### 9.2.1 Static vs Dynamic Collections

Arrays in C# are static data structures, meaning their size is fixed at the time of initialization. Once you declare an array, you cannot change its size. This can be limiting in situations where you do not know the number of elements in advance. To overcome the limitations of arrays, C# provides a dynamic data structure called a list. A list can grow or shrink as needed, making it ideal for scenarios where the number of elements is unknown at the outset. 

###### 9.2.2 Declaring a List

To declare a list, you use the `List` class followed by the data type in angle brackets. Lists are part of the `System.Collections.Generic` namespace and are implemented through the `List<T>` class, where `T` specifies the type of elements the list will store.

```csharp
using System.Collections.Generic;

List<int> numbers = new List<int>();  // Declares an empty list of integers
```

You can also use object initialization syntax to populate the list at the time of declaration:

```csharp
List<string> names = new List<string> { "Alice", "Bob", "Charlie" };
```

###### 9.2.3 List Properties and Methods

The `List<T>` class provides several useful methods that allow you to manipulate the elements within the list easily:

| **Method**                            | **Description**                                                   |
| ------------------------------------- | ----------------------------------------------------------------- |
| `Add(T item)`                         | Adds an element to the end of the list.                           |
| `AddRange(IEnumerable<T> collection)` | Adds a collection of elements to the list.                        |
| `Remove(T item)`                      | Removes the first occurrence of a specific element from the list. |
| `RemoveAt(int index)`                 | Removes the element at the specified index.                       |
| `IndexOf(T item)`                     | Returns the index of the first occurrence of a specific element.  |
| `Contains(T item)`                    | Checks if a specific element exists in the list.                  |
| `Count`                               | Gets the number of elements currently in the list.                |

## 10. Interacting with the Console

#### 10.1 Writing to the Console

The `Console.WriteLine()` method is used to output a message or a value to the console. It automatically appends a newline character at the end, so each call to `Console.WriteLine()` will start a new line in the console.

```csharp
Console.WriteLine("Hello, World!");
```

#### 10.2 Reading from the Console

The `Console.ReadLine()` method is used to read a line of input from the console. It pauses the program execution until the user inputs text and presses the Enter key, returning the input as a string.

```csharp
string input = Console.ReadLine();
```

## 11. Working with Random Numbers

The `Random` class in C# is used to generate random numbers and is part of the `System` namespace. To start using it, you first create an instance of the `Random` class. Once you have this instance, you can call various methods to generate random numbers. One of the most commonly used methods is `Next(int minValue, int maxValue)`, which generates a random integer that is greater than or equal to `minValue` and less than `maxValue`.

```csharp
Random random = new Random();
int randomNumber3 = random.Next(1, 11); // Generates a random number between 1 and 10
```

## 12. Working with Date and Time

#### 12.1 DateTime

###### 12.1.1 Declaring a DateTime

The `DateTime` class in C# is a structure defined within the `System` namespace, used to represent and work with dates and times. When creating an instance of `DateTime`, you can specify the year, month, day, hour, minute, and second as arguments.

```csharp
DateTime specificDate = new DateTime(2024, 8, 8, 14, 30, 0); // August 8, 2024, 14:30:00
```

###### 12.1.2 Current Date and Time

To initialize a `DateTime` instance with the current date and time, you can use the static properties `DateTime.Now` or `DateTime.Today`. `Now` provides the current date and time, while `Today` gives the current date with the time set to 00:00:00.

```csharp
DateTime now = DateTime.Now;
DateTime today = DateTime.Today;
```

###### 12.1.3 Accessing Date and Time Components

Once you have a `DateTime` instance, you can access individual components like the year, month, day, hour, minute, and second using properties.

```csharp
int year = now.Year;
int month = now.Month;
int day = now.Day;
int hour = now.Hour;
int minute = now.Minute;
int second = now.Second;
```

###### 12.1.4 Modifying DateTime Instances

Although `DateTime` instances are immutable (meaning they cannot be changed after creation), you can create modified copies using methods like `AddYears()`, `AddMonths()`, `AddDays()`, `AddHours()`, `AddMinutes()`, and `AddSeconds()`:

```csharp
DateTime nextYear = now.AddYears(1);
DateTime nextMonth = now.AddMonths(1);
DateTime nextDay = now.AddDays(1);
```

###### 12.1.5 Formatting DateTime as a String

`DateTime` instances can be converted into strings using various methods, each offering a different level of detail:

| **Method**            | **Description**                                                   |
| --------------------- | ----------------------------------------------------------------- |
| `ToLongDateString()`  | Returns the full date as a string.                                |
| `ToShortDateString()` | Returns the short date as a string.                               |
| `ToLongTimeString()`  | Returns the full time as a string.                                |
| `ToShortTimeString()` | Returns the short time as a string.                               |
| `ToString()`          | Returns the date and time as a string. Accepts format specifiers. |

#### 12.2 TimeSpan

###### 12.2.1 Declaring a TimeSpan

The `TimeSpan` class, also within the `System` namespace, represents a duration of time, such as the difference between two `DateTime` instances. You can create a `TimeSpan` by specifying days, hours, minutes, and seconds.

```csharp
TimeSpan duration = new TimeSpan(1, 2, 30, 0); // 1 day, 2 hours, 30 minutes
```

Alternatively, you can use static methods like `FromDays()`, `FromHours()`, `FromMinutes()`, and `FromSeconds()` to create a `TimeSpan`.

###### 12.2.2 Subtracting Dates

When you subtract one `DateTime` instance from another, the result is a `TimeSpan`:

```csharp
DateTime startDate = new DateTime(2024, 8, 8);
DateTime endDate = new DateTime(2024, 8, 10);
TimeSpan difference = endDate - startDate; // 2 days
```

###### 12.2.3 TimeSpan Properties and Methods

`TimeSpan` provides properties to access its components, both as whole units and total values:

| **Property**   | **Description**                                    |
| -------------- | -------------------------------------------------- |
| `Days`         | The whole number of days in the `TimeSpan`.        |
| `Hours`        | The whole number of hours in the `TimeSpan`.       |
| `Minutes`      | The whole number of minutes in the `TimeSpan`.     |
| `Seconds`      | The whole number of seconds in the `TimeSpan`.     |
| `TotalDays`    | The total number of days (including fractions).    |
| `TotalHours`   | The total number of hours (including fractions).   |
| `TotalMinutes` | The total number of minutes (including fractions). |
| `TotalSeconds` | The total number of seconds (including fractions). |

###### 12.2.4 Modifying TimeSpan Instances

You can also modify `TimeSpan` instances using the `Add()` or `Subtract()` methods, which take another `TimeSpan` as an argument.

```csharp
TimeSpan additionalTime = TimeSpan.FromHours(2);
TimeSpan newTimeSpan = duration.Add(additionalTime);
```

###### 12.2.5 Converting TimeSpan to String

Like `DateTime`, `TimeSpan` can be converted to a string using the `ToString()` method.

## 13 Working with Files, Directories, and Paths

In C#, dealing with files, directories, and paths is an essential part of many applications. The .NET framework provides several classes to help manage these tasks effectively. Below, we will explore these classes, how to use them, and compare their advantages and disadvantages.

#### 13.1 File Class

The `File` class provides static methods to perform various operations on files, such as creating, copying, deleting, moving, and opening files. Since the methods are static, you do not need to create an instance of the `File` class to use them.

###### 13.1.1 Declaration and Usage

```csharp
using System.IO;

// Example: Reading a file
string content = File.ReadAllText(@"C:\example\file.txt");

// Example: Writing to a file
File.WriteAllText(@"C:\example\file.txt", "Hello, World!");
```

###### 13.1.2 Useful Methods

| Method                                             | Description                                      |
| -------------------------------------------------- | ------------------------------------------------ |
| `ReadAllText(string path)`                         | Reads all text from a file.                      |
| `WriteAllText(string path, string contents)`       | Writes text to a file, overwriting if it exists. |
| `Copy(string sourceFileName, string destFileName)` | Copies a file to a new location.                 |
| `Delete(string path)`                              | Deletes the specified file.                      |
| `Exists(string path)`                              | Checks if the specified file exists.             |

#### 13.2 FileInfo Class

The `FileInfo` class provides instance methods for working with files, offering more control and potentially better performance when multiple operations are performed on the same file.

###### 13.2.1 Declaration and Usage

```csharp
using System.IO;

// Example: Creating a FileInfo instance
FileInfo fileInfo = new FileInfo(@"C:\example\file.txt");

// Example: Checking file existence
if (fileInfo.Exists)
{
    // Perform operations with fileInfo
}
```

###### 13.2.2 Useful Methods

| Method                        | Description                        |
| ----------------------------- | ---------------------------------- |
| `CopyTo(string destFileName)` | Copies the file to a new location. |
| `Delete()`                    | Deletes the file.                  |
| `MoveTo(string destFileName)` | Moves the file to a new location.  |
| `Create()`                    | Creates a new file.                |
| `OpenRead()`                  | Opens the file for reading.        |

#### 13.3 Directory Class

The `Directory` class provides static methods to perform various operations on directories, such as creating, deleting, moving, and checking the existence of directories.

###### 13.3.1 Declaration and Usage

```csharp
using System.IO;

// Example: Creating a directory
Directory.CreateDirectory(@"C:\example\newfolder");

// Example: Checking if a directory exists
bool exists = Directory.Exists(@"C:\example\newfolder");
```

###### 13.3.2 Useful Methods

| Method                                | Description                                      |
| ------------------------------------- | ------------------------------------------------ |
| `CreateDirectory(string path)`        | Creates a new directory.                         |
| `Delete(string path, bool recursive)` | Deletes a directory and its contents.            |
| `Exists(string path)`                 | Checks if the directory exists.                  |
| `GetFiles(string path)`               | Retrieves all files from the directory.          |
| `GetDirectories(string path)`         | Retrieves all subdirectories from the directory. |

### 13.4 DirectoryInfo Class

The `DirectoryInfo` class provides instance methods for working with directories, offering more control and efficiency when multiple operations are required on the same directory.

###### 13.4.1 Declaration and Usage

```csharp
using System.IO;

// Example: Creating a DirectoryInfo instance
DirectoryInfo dirInfo = new DirectoryInfo(@"C:\example\newfolder");

// Example: Checking directory existence
if (dirInfo.Exists)
{
    // Perform operations with dirInfo
}
```

###### 13.4.2 Useful Methods

| Method                       | Description                             |
| ---------------------------- | --------------------------------------- |
| `Create()`                   | Creates the directory.                  |
| `Delete(bool recursive)`     | Deletes the directory and its contents. |
| `GetFiles()`                 | Retrieves all files from the directory. |
| `GetDirectories()`           | Retrieves all subdirectories.           |
| `MoveTo(string destDirName)` | Moves the directory to a new location.  |

#### 13.5 Path Class

The `Path` class provides static methods to work with file and directory path strings, allowing you to perform operations like combining paths, extracting file extensions, and getting directory names.

###### 13.5.1 Declaration and Usage

```csharp
using System.IO;

// Example: Combining paths
string fullPath = Path.Combine(@"C:\example", "file.txt");

// Example: Getting file extension
string extension = Path.GetExtension(@"C:\example\file.txt");
```

###### 13.5.2 Useful Methods

| Method                           | Description                                   |
| -------------------------------- | --------------------------------------------- |
| `Combine(params string[] paths)` | Combines multiple strings into a single path. |
| `GetExtension(string path)`      | Returns the file extension.                   |
| `GetFileName(string path)`       | Returns the file name and extension.          |
| `GetDirectoryName(string path)`  | Returns the directory name from the path.     |
| `GetFullPath(string path)`       | Returns the absolute path for the given path. |

## 14. Debugging

#### 14.1 Importance and Process of Debugging

Debugging is a crucial aspect of software development in C#. It involves identifying and fixing bugs or unexpected behavior in the code. The process typically begins by setting breakpoints at strategic points in the application and running the code in debug mode. When execution reaches a breakpoint, the program pauses, allowing the developer to inspect variable values and flow control. This helps in pinpointing the exact location and cause of a problem. After making corrections, the application is run again to ensure that the issue is resolved.

#### 14.2 Main Debug Functionalities and Windows

C# provides several powerful debugging tools and windows in the integrated development environment (IDE):

- **Breakpoints**: These are markers placed in the code where execution will pause, allowing for inspection.
- **Step Over**: This command allows you to execute the next line of code without stepping into any method calls.
- **Step Into**: This command steps into a method call, allowing you to see the execution inside the method.
- **Step Out**: This command steps out of the current method, returning control to the calling method.

#### 14.3 Key Debug Windows

- **Watch Window**: Lets you track the values of specific variables throughout the execution of the program.
- **Call Stack Window**: Displays the sequence of method calls that led to the current point in the execution.
- **Autos Window**: Automatically shows variables that are likely to be of interest based on the current line of code.
- **Locals Window**: Automatically displays all variables within the current scope, providing an overview of the local state.

#### 14.4 Side Effects

Side effects in programming refer to unintended changes in the state of the program or the environment that occur when a function or method is executed. These can lead to unpredictable behavior and are generally avoided in well-structured code, especially during debugging.

#### 14.5 Defensive Programming

Defensive programming is a practice aimed at improving software reliability by anticipating and guarding against potential errors. It involves validating inputs to ensure they conform to expected formats or values, and raising exceptions when they do not. This approach helps prevent bugs and ensures that the program behaves correctly even in unexpected situations.
