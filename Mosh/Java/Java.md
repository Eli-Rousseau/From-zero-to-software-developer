# Java

## 1. The Anatomy of Java Programs

Java programs are composed of various building blocks, with the smallest being functions. A function is a block of code that performs a specific task. Here's a closer look at how functions and classes are structured in Java, along with the conventions and keywords used.

#### 1.1 Defining Functions

###### 1.1.1 Basic Function Definition

To define a function in Java, you start by specifying the return type. The return type indicates the kind of value the function will return, such as a number, a date, a time, etc. If a function does not return any value, it is defined with the keyword `void`. Following the return type is the function's name, which should be descriptive and meaningful. Next, you include a pair of parentheses where parameters, if any, are specified. The function body is enclosed in curly braces `{}`. The opening curly brace `{` appears on the same line as the function declaration, and the closing curly brace `}` is placed at the end of the function.

```java
void myFunction() {
    // Code goes here
}
```

###### 1.1.2 The Main Function

Every Java program must have at least one function named `main`, which serves as the entry point. This function resides within a class. A class acts as a container for one or more related functions, helping to organize the code. To define a class in Java, you use the `class` keyword followed by a class name and a pair of curly braces. The main class typically starts with the keyword `class Main`.

```java
class Main {
    void main() {
        // Entry point of the program
    }
}
```

###### 1.1.3 Methods and Access Modifiers

In Java, a method is a function that is part of a class. Both classes and methods should have an access modifier, which is a keyword that specifies if other functions and classes can access them. Common access modifiers include `public`, `private`, and others. Typically, the `public` access modifier is used, and it should be placed before the class and method declarations.

```java
public class MyClass {
    public void myPublicMethod() {
        // Accessible by other classes
    }

    private void myPrivateMethod() {
        // Only accessible within this class
    }
}
```

###### 1.1.4 Naming Conventions

Java has specific naming conventions for classes and methods to maintain consistency and readability:

- **Classes**: Follow the PascalNamingConvention, where the first letter of each word in the class name is uppercase.
  
  ```java
  public class MyClassName {
      // Class implementation
  }
  ```

- **Methods**: Follow the camelNamingConvention, where the first letter of the first word is lowercase, and the first letter of each subsequent word is uppercase.
  
  ```java
  public void myMethodName() {
      // Method implementation
  }
  ```

###### 1.1.5 Organizing Code in Java with Methods

In Java, the `Main` class contains the `main` method, which serves as the entry point for your program. While it's possible to write all your code within the `main` method, this approach is only suitable for very small programs. For larger programs, it's preferable to break down the code into smaller, reusable subpieces called methods. Methods help avoid code repetition and make your programs more modular and manageable.

Here is an example of a simple method:

```java
public class Main {

    public static void main(String[] args) {
        String message = greetUser("Eli", "Rousseau");
    }

    public static String greetUser(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName; 
    }
}
```

To create clean code, it is important to divide the code into manageable chunks, making them reusable in other programs. This approach enhances maintainability and makes the code easier to extend. Refactoring, which involves changing the structure of the code without altering its behavior, is essential for maintaining code quality. Ideally, methods should contain between 15 to 20 lines of code to keep them concise and focused.

#### 1.2 Creating a Java Program

###### 1.2.1 Java Package Statements and Code Structure

In Java, the `package` statement is used to specify the package to which a class belongs. A package in Java is a namespace that organizes classes and interfaces, making code management easier and preventing naming conflicts. Each statement in Java must be terminated by a semicolon (`;`).

Below is an example of the `Main` class with the `main` function, demonstrating the basic structure and usage of comments, field access, and method invocation in Java.

###### 1.2.2 Accessing Fields and Methods

In the `main` method, you can access the `out` field from the `System` class using the dot operator (`.`). This field is of type `PrintStream` and provides methods to output text to the console. One of these methods is `println`, which prints a line of text.

```java
System.out.println("Hello World");
```

Within the parentheses of the `println` method, you can write a message enclosed in double quotes. When the program is executed, this message will be displayed in the console.

**Code example:**

```java
package com.example.helloworld; // Package declaration

public class Main {
    public static void main(String[] args) {
        // This is a comment explaining the code
        System.out.println("Hello World"); // Print "Hello World" to the console
    }
}
```

In Java, a double slash (`//`) indicates a comment. Comments are used to explain code to other developers, making the code more understandable and maintainable.

#### 1.3 Running a Java Program

When you run a Java program, there are two primary steps: compilation and execution.

###### 1.3.1 Compilation Step

In the compilation step, Java uses the Java compiler (`javac`) to transform the Java source code into Java bytecode. This bytecode is stored in files with a `.class` extension. These compiled files are usually stored in the `out/production` directory of the main project. Java bytecode is platform-independent, meaning it can run on any operating system that has a Java Runtime Environment (JRE). The JRE consists of a Java Virtual Machine (JVM), which converts the bytecode into native code for the underlying operating system. This feature makes Java applications portable and platform-independent.

```sh
# Compile the Java source file into bytecode
javac Main.java

# The bytecode is saved as Main.class in the same directory
```

###### 1.3.2 Execution Step

To execute a Java program from the console, you need to follow two steps. First, use the `javac` command to compile the `Main.java` file into Java bytecode (`.class`). Next, use the `java` command to run the compiled `Main` bytecode file from the `src` directory.

```sh
# Step 1: Compile the Java source file
javac Main.java

# Step 2: Change working directory
cd Project/src

# Step 3: Run the compiled Java bytecode
java Main
```

When running the code from an Integrated Development Environment (IDE), these compilation and execution steps are handled automatically and remain hidden from the user. The IDE manages these processes, providing a streamlined workflow for developing, compiling, and executing Java programs.

## 2. Variables and Constants

#### 2.1 Declaring and Using Variables in Java

###### 2.2.1 Declaring a Variable

Variables are essential in Java for storing temporary data in computer memory. To declare a variable, you start by specifying its type, followed by the variable name, an assignment operator (`=`), and the value to be stored, ending with a semicolon. Variables can store different types of data, such as integers, floating-point numbers, characters, and more. Here is an example of how to declare an integer variable:

```java
int myNumber = 10;
```

The value stored in a variable can be changed (mutated) after its initial assignment:

```java
myNumber = 20;
```

###### 2.1.2 Declaring Multiple Variables

Although it is possible to declare more than one variable on a single line using a comma, it is not recommended for code readability. Here is an example:

```java
int num1 = 5, num2 = 10;
```

For better readability, it is recommended to declare each variable on a separate line:

```java
int num1 = 5;
int num2 = 10;
```

###### 2.1.3 Naming Conventions

Variable names in Java follow the camelNamingConvention. In this convention, the first letter of the first word is lowercase, and the first letter of each subsequent word is uppercase. Here are some examples:

```java
int myNumber = 10;
String myString = "Hello, World!";
double myDoubleValue = 5.99;
```

## 3. Primitive and Reference Types

In Java, data types are categorized into two main types: primitive types and reference types. Primitive types are used for storing simple values, while reference types are used for storing complex objects.

#### 3.1 Primitive Types

Java provides eight primitive types, each serving a specific purpose and having distinct characteristics. Here is a table summarizing the number of bytes each primitive type takes and the range of the numeric ones:

| Data Type | Bytes | Range             | Description                                    |
| --------- | ----- | ----------------- | ---------------------------------------------- |
| `byte`    | 1     | -128 to 127       | Stores small integers                          |
| `short`   | 2     | -32,768 to 32,767 | Stores larger integers than `byte`             |
| `int`     | 4     | -2^31 to 2^31-1   | Commonly used for storing integers             |
| `long`    | 8     | -2^63 to 2^63-1   | Stores very large integers                     |
| `float`   | 4     |                   | Stores single-precision floating-point numbers |
| `double`  | 8     |                   | Stores double-precision floating-point numbers |
| `char`    | 2     |                   | Stores a single 16-bit Unicode character       |
| `boolean` | 1     | `true` or `false` | Stores a value indicating true or false        |

Below is an example of how each primitive type is declared in Java:

```java
public class PrimitiveTypesExample {
    public static void main(String[] args) {
        byte myByte = 10;
        short myShort = 100;
        int myInt = 1000;
        long myLong = 10000L; // Ensures that Java treats number as long type
        float myFloat = 10.5F; // Ensures that Java treats number as float type
        double myDouble = 20.5;
        char myChar = 'A';
        boolean myBoolean = true;
    }
}
```

#### 3.2 Reference Types

When working with reference types, which include objects and instances of classes, you need to use the `new` keyword to allocate memory for these instances. This contrasts with primitive types, which do not require memory allocation in the same manner.

```java
// Primitive type
int myNumber = 10;

// Reference type
import java.util.Date;
Date myDate = new Date();
```

In Java, to use a class from a different package, you need to import it. This allows you to access and utilize classes and their functionalities that are organized in different packages.

###### 3.2.1 Accessing Methods with the Dot Operator

Instances of classes (reference types) can access methods and fields of the class using the dot operator (`.`). This allows you to interact with the object's properties and behaviors.

```java
public class MethodAccessExample {
    public static void main(String[] args) {
        Date currentDate = new Date();
        System.out.println(currentDate.getTime());
    }
}
```

#### 3.3 Understanding Primitive and Reference Types in Java

In Java, data types are classified into primitive types and reference types. Understanding how these types store values in memory and how they are copied is crucial for effective programming.

###### 3.3.1 Primitive Types

Primitive types store only their value directly in memory. This means that when a primitive type variable is assigned to another variable, the value is copied, resulting in two independent variables with the same value stored at different memory locations.

```java
public class PrimitiveExample {
    public static void main(String[] args) {
        int a = 10;
        int b = a; // Value of 'a' is copied to 'b'
        b = 20;    // Changing 'b' does not affect 'a'

        System.out.println("a: " + a); // Output: a: 10
        System.out.println("b: " + b); // Output: b: 20
    }
}
```

In this example, the value of `a` is copied to `b`. Changing `b` does not affect `a`, demonstrating their independence.

###### 3.3.2 Reference Types

Reference types, on the other hand, store both the value of the type and the memory address where the value is located. When assigning a reference type variable to another variable, the memory address (reference) is copied, not the actual value. Therefore, both variables refer to the same memory location, making them dependent on each other. Any changes made to the object through one variable will reflect when accessed through the other variable.

```java
import java.util.Date;

public class ReferenceExample {
    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = date1; // Reference of 'date1' is copied to 'date2'
        date2.setTime(1000000L); // Changing 'date2' affects 'date1'

        System.out.println("date1: " + date1); // Output: date1: Thu Jan 01 01:16:40 GMT 1970
        System.out.println("date2: " + date2); // Output: date2: Thu Jan 01 01:16:40 GMT 1970
    }
}
```

In this example, `date1` and `date2` both reference the same `Date` object. Modifying the object through `date2` also affects `date1`, as they share the same memory address.

## 4. Numbers, Strings, and Arrays

#### 4.1 Working with Strings

Strings in Java are reference types that are imported by default, so no import statement is needed. Strings are used to store sequences of characters and provide a rich set of methods for manipulating text.

###### 4.1.1 Defining String Variables

To define a string variable, you use the `String` keyword, followed by the variable name, the assignment operator, and the `new` keyword to allocate memory. However, Java allows a more concise way to declare a string variable by directly assigning a string literal without explicitly using the `new` keyword.

```java
public class StringExample {
    public static void main(String[] args) {
        // Using the new keyword
        String greeting1 = new String("Hello, World!");

        // More concise way
        String greeting2 = "Hello, World!";

        System.out.println(greeting1);
        System.out.println(greeting2);
    }
}
```

###### 4.1.2 String Concatenation

You can concatenate strings using the `+` operator. This allows you to join multiple strings together.

```java
public class StringConcatenationExample {
    public static void main(String[] args) {
        String part1 = "Hello, ";
        String part2 = "World!";
        String greeting = part1 + part2;

        System.out.println(greeting); // Output: Hello, World!
    }
}
```

###### 4.1.3 String Methods

Java's `String` class provides numerous methods for string manipulation. You can use the dot operator (`.`) on a string variable to access these methods.

| Method          | Description                                                                                     |
| --------------- | ----------------------------------------------------------------------------------------------- |
| `endsWith()`    | Checks if the string ends with a specified suffix.                                              |
| `startsWith()`  | Checks if the string starts with a specified prefix.                                            |
| `length()`      | Returns the length of the string.                                                               |
| `indexOf()`     | Returns the index of the first occurrence of a specified character or substring.                |
| `replace()`     | Replaces occurrences of a specified character or substring with another character or substring. |
| `toLowerCase()` | Converts all characters in the string to lowercase.                                             |
| `toUpperCase()` | Converts all characters in the string to uppercase.                                             |
| `trim()`        | Removes leading and trailing whitespace from the string.                                        |

###### 4.1.4 Including Escape Characters in Strings

In Java, strings can include special characters known as escape characters. These characters allow you to include characters in a string that would otherwise be difficult or impossible to include, such as:

- Using Double Quotes Inside Strings: To include a double quote inside a string, you need to precede it with a backslash (`\`). 

- Using Backslashes Inside Strings: To include a backslash inside a string, you need to precede it with another backslash (`\\`).

- Newline and Tab Characters:
  
  - `\n` corresponds to a newline character, which moves the cursor to the next line.
  
  - `\t` corresponds to a tab character, which inserts a horizontal tab space.

#### 4.2 Working with Arrays

Arrays in Java are used to store a list of items of the same type. They provide a way to manage multiple values in a single variable, which can be accessed by their index.

###### 4.2.1 Defining Arrays

To convert a type variable into an array of that type, the type is defined with square brackets, followed by the variable name, assignment operator, `new` keyword to allocate memory, and the type defined with square brackets again. The length of the array is specified between the square brackets.

```java
public class ArrayExample {
    public static void main(String[] args) {
        // Define an array of integers with a length of 5
        int[] myArray = new int[5];
    }
}
```

If the items are known ahead of time, you can initialize an array directly by defining the type with square brackets, followed by the variable name, assignment operator, and curly braces with the defined items inside.

```java
public class ArrayInitializationExample {
    public static void main(String[] args) {
        // Initialize an array with predefined values
        int[] myArray = {1, 2, 3, 4, 5};
    }
}
```

One fixed property of arrays in Java is their length, which is set at the time of creation and cannot be changed.

###### 4.2.2 Accessing Array Elements

You can index the items of an array using square brackets after the variable name and indicate the item's index. Arrays in Java are zero-indexed, meaning the first element is at index 0.

```java
public class ArrayAccessExample {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5};

        // Access and print the first element
        System.out.println("First element: " + myArray[0]); // Output: 1

        // Modify the third element
        myArray[2] = 10;

        // Print the modified array
        System.out.println("Modified third element: " + myArray[2]); // Output: 10
    }
}
```

###### 4.2.3 Useful Methods for Arrays

There are some useful methods that you can use on arrays, some of the methods require to import the `Arrays` class from the `java.util` package.

| Method              | Description                                                                                                                                                                                                                                                                          |
| ------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `myArray.length()`  | Retrieves the number of items in an array                                                                                                                                                                                                                                            |
| `Arrays.sort()`     | Sort the array.                                                                                                                                                                                                                                                                      |
| `Arrays.toString()` | In Java, you cannot simply print the array variable to see the elements of the array. Doing so will display the memory location of the array transformed as a string instead of the actual elements. To properly print the elements of an array, use the `Arrays.toString()` method. |

###### 4.2.4 Defining Multi-Dimensional Arrays

In Java, you can create and manipulate multi-dimensional arrays to represent data in a matrix-like structure. To declare a multi-dimensional array, define the type with a double pair of square brackets during the variable declaration. Then, use the `new` keyword to allocate memory and define the dimensions of rows and columns.

```java
public class MultiDimensionalArrayExample {
    public static void main(String[] args) {
        // Define a 2D array with 3 rows and 4 columns
        int[][] matrix = new int[3][4];
    }
}
```

If the items are known upfront, you can initialize a multi-dimensional array using nested curly braces.

```java
public class MultiDimensionalArrayInitializationExample {
    public static void main(String[] args) {
        // Initialize a 2D array with predefined values
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
    }
}
```

To access the elements of a multi-dimensional array, use the double pair of square brackets notation, specifying the row and column indices.

To print the items from a multi-dimensional array, use the `Arrays.deepToString()` method from the `java.util.Arrays` class.

#### 4.3 Constants

In Java, you can treat a variable as a constant by adding the `final` keyword before the type of the variable during its declaration. This ensures that the value assigned to the variable cannot be changed later on. By convention, constants' names are written entirely in uppercase letters to distinguish them from regular variables.

```java
public class ConstantsExample {
    public static void main(String[] args) {
        // Declare a constant
        final int MAX_USERS = 100;

        // Uncommenting the following line would cause a compilation error
        // MAX_USERS = 200;

        System.out.println("Maximum number of users: " + MAX_USERS); // Output: Maximum number of users: 100
    }
}
```

#### 4.4 Working with Numbers

###### 4.4.1 Basic Arithmetic Operations

In Java, arithmetic operations include addition (`+`), subtraction (`-`), multiplication (`*`), division (`/`), and modulus (`%`). Understanding how to perform these operations and handle different data types is fundamental for effective programming.

```java
public class ArithmeticOperationsExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        // Basic operations
        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        int quotient = a / b;
        int remainder = a % b;

        System.out.println("Sum: " + sum);         // Output: Sum: 15
        System.out.println("Difference: " + difference); // Output: Difference: 5
        System.out.println("Product: " + product); // Output: Product: 50
        System.out.println("Quotient: " + quotient); // Output: Quotient: 2
        System.out.println("Remainder: " + remainder); // Output: Remainder: 0
    }
}
```

###### 4.4.2 Increment and Augmented Assignment Operators

Java provides the increment or decrement operator (`++` or `--`) to increase or decrease the value of a variable by one and augmented assignment operators (e.g., `+=`, `-=`, `*=`, `/=`, `%=`) to combine arithmetic operations with assignment.

```java
public class IncrementAndAugmentedAssignmentExample {
    public static void main(String[] args) {
        int a = 10;

        // Increment operator
        a++;
        System.out.println("After increment: " + a); // Output: After increment: 11

        // Augmented assignment operators
        a += 5;
        System.out.println("After += 5: " + a); // Output: After += 5: 16

        a *= 2;
        System.out.println("After *= 2: " + a); // Output: After *= 2: 32
    }
}
```

###### 4.4.3 Operator Precedence and Parentheses

Different arithmetic operators have different precedence levels in Java, which can affect the result of computations if not properly ordered. To manipulate the order of operations, use parentheses to group expressions.

```java
public class OperatorPrecedenceExample {
    public static void main(String[] args) {
        int result1 = 10 + 5 * 2; // Without parentheses
        int result2 = (10 + 5) * 2; // With parentheses

        System.out.println("Without parentheses: " + result1); // Output: Without parentheses: 20
        System.out.println("With parentheses: " + result2); // Output: With parentheses: 30
    }
}
```

###### 4.4.4 Mathematical Operations

The `Math` class in the `java.lang` package provides a collection of methods for performing various mathematical operations in Java. Here are some useful methods from the `Math` class:

| Method          | Description                                                               |
| --------------- | ------------------------------------------------------------------------- |
| `Math.round()`  | Rounds a floating-point number to the nearest integer                     |
| `Math.ceil()`   | Rounds a floating-point number up to the nearest integer                  |
| `Math.floor()`  | Rounds a floating-point number down to the nearest integer                |
| `Math.max()`    | Returns the greater of two values                                         |
| `Math.min()`    | Returns the smaller of two values                                         |
| `Math.random()` | Returns a random double value between 0.0 (inclusive) and 1.0 (exclusive) |
| `Math.pow()`    | Return the first number to the power of the second number                 |

#### 4.5 Formatting Numbers

The `NumberFormat` class in the `java.text` package provides utilities to format numbers in Java according to different locales and styles. Since `NumberFormat` is an abstract class, you cannot directly instantiate it using the `new` keyword. Instead, you use static factory methods provided by the class, such as `getCurrencyInstance()`, `getNumberInstance()`, `getPercentInstance()`, etc. These methods return concrete instances of `NumberFormat` that you can use to format numbers based on your requirements. Once you have a `NumberFormat` instance, you can use its `format()` method to format numbers into strings according to the style and locale of the instance.

```java
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormattingExample {
    public static void main(String[] args) {
        double number = 12345.678;

        // Create a NumberFormat instance for currency formatting
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);

        // Format the number using the created instance
        String formattedCurrency = currencyFormat.format(number);

        System.out.println("Formatted currency: " + formattedCurrency); // Output: Formatted currency: $12,345.68
    }
}
```

## 5. Type Casting

Type casting in Java is the process of converting a variable from one data type to another. This is a common operation that can be performed implicitly or explicitly.

#### 5.1 Implicit Casting

Implicit casting, also known as widening conversion, occurs when a smaller data type is converted to a larger data type without the risk of data loss. This type of casting is handled automatically by the Java compiler.

```java
public class ImplicitCastingExample {
    public static void main(String[] args) {
        byte byteValue = 10;
        short shortValue = byteValue; // byte to short
        int intValue = shortValue;    // short to int
        long longValue = intValue;    // int to long
        float floatValue = longValue; // long to float
        double doubleValue = floatValue; // float to double

        System.out.println("Double value: " + doubleValue); // Output: Double value: 10.0
    }
}
```

#### 5.2 Explicit Casting

Explicit casting, also known as narrowing conversion, is required when converting a larger data type to a smaller data type. This type of casting can result in data loss, and thus it must be done explicitly by the programmer.

```java
public class ExplicitCastingExample {
    public static void main(String[] args) {
        double doubleValue = 10.99;
        float floatValue = (float) doubleValue; // double to float
        long longValue = (long) floatValue;     // float to long
        int intValue = (int) longValue;         // long to int
        short shortValue = (short) intValue;    // int to short
        byte byteValue = (byte) shortValue;     // short to byte

        System.out.println("Byte value: " + byteValue); // Output: Byte value: 10
    }
}
```

#### 5.3 Parsing Strings to Numbers

Java provides methods in the `java.lang.Integer` class and other wrapper classes to convert string literals to numbers. These methods parse a string representation of a number into its corresponding primitive type.

```java
public class ParsingExample {
    public static void main(String[] args) {
        String intString = "123";
        String shortString = "123";
        String byteString = "123";

        int intValue = Integer.parseInt(intString);
        short shortValue = Short.parseShort(shortString);
        byte byteValue = Byte.parseByte(byteString);

        System.out.println("Parsed int value: " + intValue);       // Output: Parsed int value: 123
        System.out.println("Parsed short value: " + shortValue);   // Output: Parsed short value: 123
        System.out.println("Parsed byte value: " + byteValue);     // Output: Parsed byte value: 123
    }
}
```

## 6. Read Input

In Java, you can read input from the user using the `Scanner` class from the `java.util` package. To start reading input from the terminal, you first need to create an instance of the `Scanner` class and associate it with the standard input stream (`System.in`). The `Scanner` class provides methods to read different types of data depending on what you expect from the user. Some commonly used methods include `nextLine()` for strings, `nextInt()` for integers, `nextDouble()` for floating-point numbers, and so on. These methods wait for user input and return the appropriate data type after parsing the input.

```java
import java.util.Scanner;

public class InputTypesExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read an integer from the user
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.println("Your age is: " + age);

        // Read a double from the user
        System.out.print("Enter your height (in meters): ");
        double height = scanner.nextDouble();
        System.out.println("Your height is: " + height + " meters");

        // Close the Scanner when done (optional but recommended)
        scanner.close();
    }
}
```

## 7. Comparison Operators

Comparison operators in Java are used to compare primitive values, resulting in a boolean expression. These operators evaluate relationships between two values and return `true` or `false` based on the outcome of the comparison. 

| Operator | Description              | Example  | Result                                                      |
| -------- | ------------------------ | -------- | ----------------------------------------------------------- |
| `==`     | Equal to                 | `a == b` | `true` if `a` is equal to `b`, else `false`                 |
| `!=`     | Not equal to             | `a != b` | `true` if `a` is not equal to `b`, else `false`             |
| `>`      | Greater than             | `a > b`  | `true` if `a` is greater than `b`, else `false`             |
| `<`      | Less than                | `a < b`  | `true` if `a` is less than `b`, else `false`                |
| `>=`     | Greater than or equal to | `a >= b` | `true` if `a` is greater than or equal to `b`, else `false` |
| `<=`     | Less than or equal to    | `a <= b` | `true` if `a` is less than or equal to `b`, else `false`    |

## 8. Logical Operators

Logical operators in Java are used to combine multiple boolean expressions. These operators allow you to build complex conditions that can control the flow of your program. The result of a logical operation is a boolean value: `true` or `false`.

| Operator | Description | Example              | Result                                            |
| -------- | ----------- | -------------------- | ------------------------------------------------- |
| `&&`     | Logical AND | `(a > b) && (a < c)` | `true` if both expressions are true, else `false` |
| `\|      | `           | Logical OR           | `(a > b) && (a < c)``                             |
| `!`      | Logical NOT | `!(a > b)`           | `true` if the expression is false, else `false`   |

## 9. Conditional Statements

In Java, `if`, `else if`, and `else` statements are used to execute different blocks of code based on certain conditions. These conditional statements allow your program to make decisions and perform different actions based on different inputs.

#### 9.1 if Statement

The `if` statement executes a block of code if its condition evaluates to `true`. 

```java
if (condition) {
    // Code to execute if condition is true
}
```

#### 9.2 else if Statement

The `else if` statement allows you to check multiple conditions sequentially. If the first condition is false, the program will check the next condition, and so on.

```java
if (condition1) {
    // Code to execute if condition1 is true
} else if (condition2) {
    // Code to execute if condition2 is true
}
```

#### 9.3 else Statement

The `else` statement executes a block of code if none of the previous conditions were true.

```java
if (condition) {
    // Code to execute if condition is true
} else {
    // Code to execute if condition is false
}
```

Curly braces `{}` are required when there are multiple statements within an `if`, `else if`, or `else` block. However, for a single statement, the braces can be omitted. It is generally a good practice to always use curly braces to improve readability and reduce errors.

#### 9.4 Variable Scope in Conditional Statements

When declaring a variable inside an `if`, `else if`, or `else` statement, the variable is only accessible within the curly braces of that specific statement block. This scope limitation means that the variable cannot be accessed outside of the block in which it was declared. To avoid this limitation, variables are often declared outside the conditional blocks and then assigned values within them.

```java
public class ScopeExample {
    public static void main(String[] args) {
        int number = 10;

        if (number > 5) {
            int greater = number;  // Variable 'greater' is only accessible within this block
            System.out.println("Number is greater than 5: " + greater);
        }

        // System.out.println(greater);  // This will cause a compilation error
    }
}
```

To ensure that a variable is accessible outside the conditional block, you should declare the variable before the conditional statement and then assign its value within the block.

```java
public class ScopeExample {
    public static void main(String[] args) {
        int number = 10;
        int result;  // Declare the variable outside the conditional blocks

        if (number > 5) {
            result = number;
            System.out.println("Number is greater than 5: " + result);
        } else {
            result = -1;
            System.out.println("Number is 5 or less: " + result);
        }

        // Variable 'result' is accessible here
        System.out.println("Final result: " + result);
    }
}
```

#### 9.5 Ternary Operator

In some cases, you can simplify an `if-else` statement by using a ternary operator. This allows you to initialize a variable based on a condition in a single line.

```java
public class TernaryExample {
    public static void main(String[] args) {
        int number = 10;

        // Simplify if-else statement using a ternary operator
        int result = (number > 5) ? number : -1;

        System.out.println("Result: " + result);
    }
}
```

In this example, the ternary operator `? :` is used to assign the value of `number` to `result` if `number` is greater than 5, otherwise, it assigns `-1` to `result`.

#### 9.6 Switch Statement

In Java, a `switch` statement is used to compare the value of an expression against a list of `case` values, executing the block of code associated with the matching `case`. The `switch` statement can make your code more readable and efficient when dealing with multiple possible values for a single variable. It also includes a `default` block that is executed if none of the `case` values match the expression.

```java
switch (expression) {
    case value1:
        // Code to execute if expression equals value1
        break;
    case value2:
        // Code to execute if expression equals value2
        break;
    // Add more cases as needed
    default:
        // Code to execute if no cases match
}
```

## 10. Loops

Java provides several looping constructs to execute a block of code multiple times based on certain conditions. The main types of loops are `for`, `for-each`, `while`, and `do-while`. Additionally, `break` and `continue` statements can be used to control the flow within these loops.

#### 10.1 for Loop

The `for` loop is used when you know in advance how many times you want to execute a statement or a block of statements.

**Syntax:**

```java
for (initialization; condition; update) {
    // Code to be executed
}
```

**Example:**

```java
public class ForLoopExample {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration: " + i);
        }
    }
}
```

#### 10.2 for-each Loop

The `for-each` loop, also known as the enhanced `for` loop, is used to iterate over arrays or collections.

**Syntax:**

```java
for (type variable : array) {
    // Code to be executed
}
```

**Example:**

```java
public class ForEachExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        for (int number : numbers) {
            System.out.println("Number: " + number);
        }
    }
}
```

#### 10.3 while Loop

The `while` loop is used to repeat a block of code as long as a specified condition is true. The condition is evaluated before the execution of the loop's body.

**Syntax:**

```java
while (condition) {
    // Code to be executed
}
```

**Example:**

```java
public class WhileLoopExample {
    public static void main(String[] args) {
        int i = 0;
        while (i < 5) {
            System.out.println("Iteration: " + i);
            i++;
        }
    }
}
```

#### 10.4 do-while Loop

The `do-while` loop is similar to the `while` loop, but it evaluates the condition after executing the loop's body, ensuring that the body is executed at least once.

**Syntax:**

```java
do {
    // Code to be executed
} while (condition);
```

**Example:**

```java
public class DoWhileLoopExample {
    public static void main(String[] args) {
        int i = 0;
        do {
            System.out.println("Iteration: " + i);
            i++;
        } while (i < 5);
    }
}
```

#### 10.5 Break and Continue Statements

The `break` statement is used to exit a loop prematurely, while the `continue` statement skips the current iteration and proceeds to the next iteration of the loop.

**Example:**

```java
public class BreakExample {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break;  // Exit the loop when i is 5
            }
            if (i == 3) {
                continue; // Skip the rest of the loop body when i is 3
            }
            System.out.println("Iteration: " + i);
        }
    }
}
```

## 11. Understanding Errors and Debugging

#### 11.1 Types of Errors

In Java, errors can be broadly categorized into two types:

1. **Compile-time errors**: Occur when the program fails to compile due to syntax or grammatical mistakes in the code. These errors are known as syntax errors. They are relatively easy to identify and resolve, especially with the help of modern IDEs, which highlight these errors as you write your code.

2. **Run-time errors**: Do not appear until the program is executed. These errors are more challenging to diagnose because they require examining the program's behavior during its execution. To find and fix run-time errors, developers often use a debugger, a tool that allows for detailed inspection of the code execution process.

#### 11.2 Debugging tools

Most IDEs come equipped with a variety of debugging tools that aid in the error identification process:

1. **Breakpoints**: By placing a breakpoint at a specific line of code, you can pause the execution at that point to examine the state of the program.
2. **Step-over Tool**: This tool lets you execute the code line by line, allowing you to see which line may be causing the error.
3. **Step-into Tool**: This tool allows you to dive into the execution of a method to investigate its inner workings.
4. **Step-out Tool**: This tool helps you exit the current method and return to the calling method, which is useful for resuming the investigation at a higher level.
5. **Variable Window**: During debugging, this window displays the current values of declared variables, providing insight into the state of the program.
6. **Watch Tool**: This feature allows you to monitor the value of a specific variable, making it easier to track changes over time.
7. **Call Stack Window**: This window provides an overview of all the methods that have been called up to the current execution point, helping you understand the flow of execution and how you arrived at a particular line.

## 12. Deploying Java Applications with JAR Files

To deploy Java applications for other users, packaging the code into a JAR (Java ARchive) file format is a common and effective method. A JAR file can be used by anyone with the Java Runtime Environment (JRE) installed. 

#### 12.1 Creating a JAR File in IntelliJ IDEA

To create a JAR file in IntelliJ IDEA, follow these steps:

1. **Open Project Structure Settings**: Go to the `File` menu and select `Project Structure`.
2. **Add Artifacts**: Navigate to the `Artifacts` section, which is an assembly of all project assets.
3. **Create JAR Artifact**: Add a new JAR artifact by including modules and dependencies required for your project.
4. **Build the Project**: Go to the `Build` menu and select `Build Artifacts`. This action will generate the JAR file.
5. **Locate the JAR File**: The JAR file will be available in the `out` directory of your project, under the `artifacts` folder.

#### 12.2 Running the JAR File

To execute the JAR file, follow these steps:

1. **Open Terminal**: Navigate to the folder where the JAR file is located.
2. **Run the JAR File**: Use the command `java -jar [name_of_jar_file].jar` in the terminal, replacing `[name_of_jar_file]` with the actual name of your JAR file.

By following these steps, you can package your Java application into a JAR file and distribute it to other users who can run it on any system with a JRE installed. This method ensures that your application is portable and easy to deploy.

## 13. Programming Paradigms in Computer Science

#### 13.1 Programming Paradigms

In computer science, there are various programming paradigms or styles, including procedural, event-driven, functional, logic, object-oriented, and aspect-oriented programming. Among these, functional and object-oriented paradigms are the most popular. A programming language can support one or more paradigms, depending on its design.

1. **Object-Oriented Programming (OOP):** Revolves around the concept of objects. Objects encapsulate data (state) and methods (behavior). This paradigm emphasizes bundling the data and methods that operate on the data within singular objects. Objects can interact with each other, making it easier to manage and reduce complexity in software systems. OOP facilitates code reuse, maintenance, and faster development.

2. **Functional Programming (FP)**: Treats data and behavior as fundamentally different entities and keeps them separate. This paradigm focuses on the use of functions, avoiding mutable data and side effects.

#### 13.2 Choosing the Right Paradigm

The choice between OOP and FP often depends on the specific problem being solved. Problem-solving in programming involves defining the problem, identifying and comparing different solutions, and selecting the best one given the context and constraints. No single paradigm is universally better for all problems; each has its strengths and ideal use cases. The key is to understand the nature of the problem and select the paradigm that best addresses it.

#### 13.3 Procedural Programming

Procedural programming involves implementing numerous methods with many parameters and declaring variables primarily within the `Main` class and the `main` method. This approach often neglects many of the features provided by object-oriented programming, resulting in saturated classes and methods. Such programs are difficult to maintain because small changes in one part of the program can create problems elsewhere. Additionally, procedural code is often characterized by a lack of reusability and is frequently referred to as "spaghetti code" due to its tangled and complex structure.

## 14. Classes

#### 14.1 Classes and Objects

A class in Java serves as a blueprint for creating objects. An object is an instance of a class, containing fields (variables) and methods (functions) that define its behavior. While all objects of a class share the same fields and methods, each object has its own state, stored separately in memory.

UML (Unified Modeling Language) is a visual language used to describe classes and their relationships. It's a useful tool for designing and understanding the structure of your code.

###### 14.1.1 Creating and Organizing Classes in Java

In Java, each class should be declared in a separate file to improve code clarity. This practice involves several steps and conventions to ensure the code is well-structured and maintainable:

1. **Create a New Class File:** Open the directory in which the `Main` file is saved and create a new class file inside that directory. Name the class file using Pascal naming convention, where each word starts with a capital letter.
   
   ```java
   // Person.java
   public class Person {
       // Fields and methods will be defined here
   }
   ```

2. **Define Access Modifiers:** Start by defining an access modifier, which determines if other classes can access the current class. The class keyword follows this, along with the class name and curly braces.
   
   ```java
   public class Person {
       // Class content goes here
   }
   ```

3. **Declare Fields:** To declare fields in a class, define the access modifier, the type, and the name of the field. You can also assign default values to fields using the assignment operator. Otherwise, fields will refer to a null object by default.
   
   ```java
   public class Person {
       private String name;
       private int age = 0; // Default value
   }
   ```

4. **Declare Methods:** To declare methods in a class, define the access modifier, the return type, and the name of the method. Inside parentheses, list the parameters of the method separated by commas. End with curly braces.
   
   ```java
   public class Person {
       private String name;
       private int age = 0; // Default value
   
       // Method to introduce the person
       public void introduce() {
           System.out.println("Hello, my name is " + this.name + " and I am " + this.age + " years old.");
       }
   }
   ```

5. **Using the `this` Keyword:**
   The `this` keyword references the current object's members (fields and methods) within a method. This is particularly useful when parameters of a method have the same name as the object's fields.
   
   ```java
   public class Person {
       private String name;
       private int age = 0; // Default value
   
       public void introduce() {
           System.out.println("Hello, my name is " + this.name + " and I am " + this.age + " years old.");
       }
   }
   ```

###### 14.1.2 Declaring and Using a Class

To illustrate, here is an example of declaring and using the `Person` class in a Java project:

1. **Create the `Person` Class:**
   
   ```java
   // Person.java
   public class Person {
       private String name;
       private int age  = 0; // Default value;
   
       public void introduce() {
           System.out.println("Hello, my name is " + this.name + " and I am " + this.age + " years old.");
       }
   }
   ```

2. **Use the `Person` Class in the `Main` Class:**
   
   ```java
   // Main.java
   public class Main {
       public static void main(String[] args) {
           var person = new Person("Alice", 30); // Use the var operator to refer to the class type
           person.introduce();
       }
   }
   ```

###### 14.1.3 Memory Management

Java manages memory in two areas: the heap and the stack. Objects are stored in the heap, while short-lived variables, primitive types, and references to objects are stored on the stack. Reference types store the address of the object rather than the object itself. Java's garbage collection automatically removes objects from the heap that no longer have references.

#### 14.2 Encapsulation

Encapsulation in Object-Oriented Programming (OOP) involves bundling the data and the methods that operate on that data into a single unit, or object. Instead of passing values around between various parts of a program, you encapsulate these values along with their associated methods within a single class instance.

```java
// Person.java
public class Person {
    // Fields
    private String name;
    private int age;

    // Method to display person details
    public void displayPerson() {
        System.out.println("Name: " + this.name + ", Age: " + this.age);
    }
}
```

In this example, the `Person` class encapsulates the `name` and `age` fields, along with methods that implement these variables.

#### 14.3 Getters & Setters

In Object-Oriented Programming, setters and getters are methods used to control access to the fields of a class. These methods are essential for implementing encapsulation, which helps in maintaining the integrity and security of the data within an object.

###### 14.3.1 Setters

Setters are used to validate and set the value of a particular field. By defining a field as private, it becomes accessible only within the class it is declared in. This restriction ensures that the field cannot be modified directly from outside the class. Instead, a setter method is provided to control how values are assigned to the field. This method typically includes validation logic to ensure that only acceptable values are assigned. If an invalid value is passed, an exception can be thrown to indicate the error. The `IllegalArgumentException` class is commonly used for this purpose.

```java
// Person.java
public class Person {
    // Private fields
    private String name;
    private int age;

    // Setter for name with validation
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    // Setter for age with validation
    public void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
        this.age = age;
    }

    // Method to display person details
    public void displayPerson() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
```

###### 14.3.2 Getters

Getters, also known as accessor methods, are used to retrieve the value of a particular field. They provide a controlled way to access the field's value, ensuring that the encapsulation principle is maintained. Getters simply return the value of the field without modifying it.

```java
// Getter for name
public String getName() {
    return name;
}

// Getter for age
public int getAge() {
    return age;
}
```

#### 14.4 Abstraction and Coupling

###### 14.4.1 Abstraction

Abstraction in Object-Oriented Programming (OOP) is a concept used to reduce complexity by hiding unnecessary details within classes. The main idea is to focus on what an object does rather than how it does it. By concealing the implementation details, a class is treated as a "black box," where the internal workings are hidden from the outside world. This allows developers to interact with the class through a simple and well-defined interface, promoting easier maintenance and understanding of the code.

To achieve abstraction, one can define public methods that provide necessary functionalities while keeping the implementation details private. Here's an example demonstrating abstraction:

```java
// BankAccount.java
public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Public method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Public method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // Public method to check the balance
    public double getBalance() {
        return balance;
    }

    // Private method to log transactions (implementation detail)
    private void logTransaction(String message) {
        // Log transaction details (hidden from outside)
        System.out.println("Transaction: " + message);
    }
}
```

In this example, the `BankAccount` class provides public methods to interact with the balance (deposit, withdraw, and getBalance) while keeping the `logTransaction` method private. The details of logging transactions are hidden from the outside world, demonstrating the principle of abstraction.

###### 14.4.2 Coupling

Coupling in OOP refers to the level of dependency between classes. High coupling means that a class relies heavily on another class, making the code more interdependent. This can lead to increased maintenance costs, as changes in one class might necessitate changes in another class that is heavily coupled to it.

To reduce coupling, it is essential to minimize dependencies between classes. One way to achieve this is by ensuring that each class has only the necessary methods and fields exposed publicly. Unnecessary methods should be removed or made private to avoid exposing too much detail and creating unnecessary dependencies.

```java
// PaymentProcessor.java
public class PaymentProcessor {
    private BankAccount bankAccount;

    public PaymentProcessor(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void processPayment(double amount) {
        bankAccount.withdraw(amount);
    }
}

// BankAccount.java
public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
```

In this example, the `PaymentProcessor` class is coupled to the `BankAccount` class because it relies on the `withdraw` method to process payments. To reduce coupling, the `PaymentProcessor` could interact with a more abstract interface, ensuring that changes in `BankAccount` have minimal impact on `PaymentProcessor`.

By focusing on abstraction and managing coupling, developers can create more maintainable, flexible, and robust applications. Abstraction helps in hiding unnecessary details, while proper coupling management ensures that classes remain as independent as possible, facilitating easier modifications and extensions.

#### 14.5 Constructors

###### 14.5.1 Defining a Constructor

Constructors are special class methods that are called when a new class object is created. They ensure that an object is initialized in a valid state. Unlike other methods, constructors do not have a return type, not even `void`. The name of the constructor must exactly match the name of the class.

Here is an example demonstrating how to define and use a constructor:

```java
// Person.java
public class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }
}
```

In the `Person` class, the constructor `Person(String name, int age)` initializes the `name` and `age` fields of the object. When a new `Person` object is created, this constructor ensures the object is in a valid state:

```java
public class Main {
    public static void main(String[] args) {
        // Creating a new Person object
        Person person = new Person("Alice", 30);

        // Accessing the object's fields
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}
```

###### 14.5.2 Default Constructor

If no constructor is explicitly defined, Java provides a default constructor that initializes the object with default values (e.g., `null` for objects, `0` for numeric types). However, once a constructor with parameters is defined, the default constructor is no longer provided automatically.

#### 14.6 Method Overloading

Method overloading in Java allows multiple methods in the same class to have the same name but different parameters. This can be achieved by varying the number of parameters, the type of parameters, or both. Overloading increases the flexibility of your code, enabling different ways to call the same method based on different input parameters.

```java
public class Calculator {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method to add two doubles
    public double add(double a, double b) {
        return a + b;
    }
}
```

While method overloading can be a powerful tool, overusing it can make your code difficult to maintain. Too many variations of a method with different parameters can lead to confusion and increase the complexity of the codebase.

#### 14.7 Instance and Static Members

In Object-Oriented Programming, classes can have two types of members: instance members and static members.

###### 14.7.1 Instance Members

Instance members are fields and methods that belong to individual instances (or objects) of a class. Each object created from the class has its own copy of these instance members. Instance members are accessed through the object reference.

```java
public class Car {
    // Instance member
    private String model;

    // Instance method
    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.setModel("Toyota");
        System.out.println(car1.getModel()); // Output: Toyota

        Car car2 = new Car();
        car2.setModel("Honda");
        System.out.println(car2.getModel()); // Output: Honda
    }
}
```

In this example, the `model` field and `setModel` method are instance members of the `Car` class. Each `Car` object has its own `model` field.

###### 14.7.2 Static Members

Static members belong to the class itself rather than any particular instance. They can be accessed directly through the class name. Static members can be both fields and methods. It's important to note that static methods can only access static fields and other static methods, not instance members.

```java
public class MathUtil {
    // Static field
    public static final double PI = 3.14159;

    // Static method
    public static int add(int a, int b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        // Accessing static members through the class name
        System.out.println("PI: " + MathUtil.PI); // Output: PI: 3.14159
        System.out.println("Sum: " + MathUtil.add(5, 10)); // Output: Sum: 15
    }
}
```

In the `MathUtil` class, `PI` and `add` are static members. They can be accessed without creating an instance of `MathUtil`.

###### 14.7.3 Main Method as a Static Member

The `main` method in Java is typically declared as static. This allows the Java Runtime Environment (JRE) to call the `main` method without creating an instance of the class. This is essential for the program to start execution.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

## 15. Inheritance and Polymorphism

#### 15.1 Inheritance in Java

Inheritance is a fundamental concept in Object-Oriented Programming (OOP) that allows for code reuse by extending fields and methods from one class to another. This is achieved using the `extends` keyword, followed by the name of the class to inherit from. When a class extends another, it inherits all the fields and methods of the parent class, enabling code reuse and reducing redundancy.

```java
// Parent class
public class Vehicle {
    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}

// Child class
public class Car extends Vehicle {
    private String model;

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.setBrand("Toyota");
        car.setModel("Corolla");
        System.out.println(car.getBrand() + " " + car.getModel()); // Output: Toyota Corolla
    }
}
```

In this example, the `Car` class extends the `Vehicle` class, inheriting its fields and methods. The `Car` class can then use the `getBrand` and `setBrand` methods defined in the `Vehicle` class.

###### 15.1.1 Avoiding Deep Inheritance Hierarchies

When designing class hierarchies in object-oriented programming, it's crucial to avoid creating excessively deep inheritance structures. Deep hierarchies can lead to significant maintenance challenges because changes made to a class at the top of the hierarchy may require modifications across all derived classes. This not only includes recompiling and redeploying the entire hierarchy but also affects any classes that depend on these hierarchies. Additionally, changes such as introducing new fields or methods in a base class might inadvertently affect subclasses in ways that are not intended or useful. This can lead to complications where inherited properties or behaviors don't make sense in the derived classes, thereby creating more maintenance overhead and potential for bugs. As a general guideline, try to limit inheritance hierarchies to one or two levels. 

###### 15.1.2 Multiple Inheritance

Java does not support multiple inheritance of classes, which is the ability for a class to inherit from more than one parent class. This restriction is in place primarily to avoid complications that can arise from multiple inheritance, such as the "diamond problem." The diamond problem occurs when a class inherits from two classes that both inherit from a common base class, leading to ambiguity in the inheritance hierarchy about which methods or properties should be inherited. By not supporting multiple inheritance, Java simplifies the class hierarchy and reduces potential conflicts and ambiguities

#### 15.2 The Object Class

The `Object` class in the `java.lang` package is the root of the class hierarchy in Java. Every class implicitly extends the `Object` class, which provides several methods that are common to all objects. Some of the most important methods in the `Object` class are:

| Method              | Description                                                                                                                                                           |
| ------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `toString()`        | Provides a string representation of the object, including the package name and a hexadecimal representation of the object's memory address, separated by an `@` sign. |
| `obj1.equals(obj2)` | Compares the memory addresses of two objects to determine if they are the same instance.                                                                              |
| `hashCode()`        | Returns an integer hash code representing the memory address of the object.                                                                                           |

#### 15.2 Constructors and Inheritance

In Java, constructors are special methods called when an object is instantiated. When dealing with inheritance, constructors play a crucial role in ensuring that the parent class's fields are properly initialized before the child class's fields. The `super` keyword is used within a child class's constructor to call the parent class's constructor. This ensures that the parent class's initialization code runs before the child class's initialization code.

```java
public class Vehicle {
    private String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}

public class Car extends Vehicle {
    private String model;

    public Car(String brand, String model) {
        super(brand); // Calls the constructor of the Vehicle class
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla");
        System.out.println(car.getBrand() + " " + car.getModel()); // Output: Toyota Corolla
    }
}
```

In this example, the `Vehicle` class has a constructor that initializes the `brand` field. The `Car` class extends `Vehicle` and adds a `model` field. The `Car` constructor calls the `Vehicle` constructor using `super(brand)` to ensure the `brand` field is initialized before initializing the `model` field.

#### 15.3 Access Modifiers

In Java, access modifiers define the visibility and accessibility of classes, methods, and fields within a program. There are four main types of access modifiers: `public`, `private`, `protected`, and default (no modifier).

1. The `public` access modifier makes class members accessible from any other class, regardless of the package they are in. This is useful for methods and fields that need to be accessed globally throughout the application.

2. The `private` access modifier restricts the access of class members to within the same class. Private members cannot be accessed or modified by any other class, including subclasses.

3. The `protected` access modifier allows class members to be accessible within the same package and by subclasses, even if they are in different packages. However, using `protected` can be confusing because it introduces complexities when classes are extended across packages. It is generally considered better practice to use `public` and `private` modifiers to avoid such confusion.

4. When no access modifier is specified, the class members have default (package-private) access. This means the members are accessible only within the same package. They are private to any classes outside the package but public within the package.

#### 15.4 Overriding Methods

Method overriding in Java is a feature that allows a subclass to provide a specific implementation for a method that is already defined in its parent class. This is useful when you want to change the behavior of an inherited method to suit the needs of the subclass. To override a method, you use the `@Override` annotation above the method in the subclass. This annotation helps to ensure that you are actually overriding a method from the parent class and not accidentally creating a new method.

```java
class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}
```

In this example the `Animal` class has a method called `sound`. The `Dog` class extends the `Animal` class and overrides the `sound` method. The `@Override` annotation ensures that the `sound` method in the `Dog` class is indeed overriding the method from the `Animal` class.

#### 15.5 Upcasting and Downcasting

###### 15.5.1 Upcasting

Upcasting in Java refers to the process of casting an object to one of its super types. This occurs automatically when you assign a subclass object to a superclass reference. Since the subclass inherits from the superclass, the compiler automatically performs the upcasting.

```java
class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog(); // Upcasting
        myDog.sound(); // Outputs: Dog barks
    }
}
```

In this example, the `Dog` object is upcast to an `Animal` reference. The `sound` method called on the `Animal` reference will still invoke the `Dog` class's overridden method.

###### 15.5.2 Downcasting

Downcasting is the process of casting a superclass reference back to a subclass reference. This is necessary when you need to access methods or fields that are specific to the subclass. However, downcasting requires an explicit cast and should be done with caution, as it can lead to a `ClassCastException` if the object is not actually an instance of the subclass.

```java
public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Dog(); // Upcasting
        Dog myDog = (Dog) myAnimal; // Downcasting
        myDog.sound(); // Outputs: Dog barks
    }
}
```

In this example, the `Animal` reference is downcast back to a `Dog` reference, allowing access to the `Dog` class's specific methods.

#### 15.5 Comparing Objects

In Java, reference type variables refer to the memory location where an object is stored, rather than the object itself. This distinction is crucial when comparing objects. If you compare two reference type variables using the `==` operator, you are comparing their memory addresses, not the actual data within the objects. To compare the data of the objects, it is common practice to override the `equals` and `hashCode` methods in the class definition.

By default, the `equals` method in the `Object` class compares the memory addresses of objects, leading to incorrect results when comparing the content of objects. To address this, you can override the `equals` method to compare the data fields of the objects. Similarly, the `hashCode` method should also be overridden to maintain the general contract for the `hashCode` method, which states that equal objects must have equal hash codes.

Here's an example of how to override these methods:

```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { // Compares the objects references
            return true;
        }
        if (!(obj instanceof Person)) { // Checks for subcasting issues
            return false;
        }
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name); // Compares the objects values
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
```

In this example, the `equals` method is overridden to compare the `name` and `age` fields of `Person` objects. The `hashCode` method is overridden to generate a hash code based on these fields.

#### 15.6 Polymorphisms

Polymorphism in Object-Oriented Programming refers to the ability of objects to take on multiple forms. This powerful concept allows methods to behave differently based on the object type they are acting upon, even if the methods share the same name. Polymorphism is mainly achieved through method overriding and method overloading (see earlier).

Polymorphism allows for more flexible and reusable code. For instance, you can write code that operates on the superclass type but works correctly with any subclass object. This makes the code easier to extend and maintain.

```java
public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Dog();
        myAnimal.makeSound();  // Outputs: Dog barks

        myAnimal = new Cat();
        myAnimal.makeSound();  // Outputs: Cat meows
    }
}
```

In this example, the `myAnimal` reference can point to any object that is a subclass of `Animal`, demonstrating polymorphic behavior by invoking the overridden `makeSound` method appropriate to the actual object type.

#### 15.7 Abstract Classes and Methods

Abstract classes are used when you want to create a class that should not be directly instantiated. Instead, they serve as templates for other classes, representing abstract concepts that depend on concrete subclasses to function. These classes provide a common base with shared properties and methods, which concrete subclasses must implement and build upon, ensuring consistent behavior across related classes.

###### 15.7.1 Defining Abstract Classes

To create an abstract class, use the `abstract` keyword before the class declaration. This indicates that the class is incomplete and meant to be extended by other classes. Abstract classes can contain both abstract methods, which have no implementation, and concrete methods, which have full implementations.

```java
public abstract class Animal {
    // Concrete method
    public void breathe() {
        System.out.println("Animal is breathing");
    }

    // Abstract method
    public abstract void makeSound();
}
```

###### 15.7.2 Implementing Abstract Methods

Abstract methods are defined using the `abstract` keyword in the abstract class. These methods do not have a body and must be implemented by subclasses. This ensures that subclasses provide specific behaviors for the abstract methods defined in the abstract class.

```java
public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}
```

Here, `Dog` and `Cat` are concrete subclasses of `Animal`, and both provide implementations for the `makeSound` method.

#### 15.8 Final Classes and Methods

In Java, final classes are used to prevent inheritance, meaning that no other class can extend or inherit from a final class. This restriction ensures that the class remains unchanged and cannot be modified by subclasses. Final classes are useful when you want to prevent the modification of certain classes and ensure that their implementation remains intact. To declare a final class, use the `final` keyword before the `class` keyword in the class declaration.

```java
public final class ImmutableClass {
    // Class members and methods
}
```

Similarly, final methods within a class are methods that cannot be overridden by subclasses. To declare a final method, use the `final` keyword before the method's return type.

```java
public class BaseClass {
    public final void show() {
        System.out.println("This method cannot be overridden.");
    }
}
```

## 16. Interfaces

#### 16.1 What are Interfaces

When classes are tightly coupled, changes in one class can affect its dependent classes, requiring recompilation and redeployment, which complicates maintenance. To minimize coupling, use abstraction to hide implementation details and expose only necessary members. Interfaces are key to this process, as they define method contracts without implementations, specifying what methods a class must implement. By programming against interfaces, classes interact through defined contracts, making the system more flexible and easier to extend. This approach enhances maintainability and scalability in complex applications.

#### 16.2 Using Interfaces in Java

To use an interface in Java, you must first declare it. This process resembles class declaration and includes the `public` access modifier, the `interface` keyword, and the name of the interface, followed by curly braces. Inside these braces, you declare the methods that need to be implemented, without providing the implementations themselves.

```java
public interface PaymentProcessor {
    void processPayment(double amount);
}
```

#### 16.3 Implementing an Interface

To use the interface in a class, you use the `implements` keyword followed by the interface name after the class name. Every class that implements an interface must provide implementations for all the methods declared by the interface. As a best practice, apply the `@Override` annotation above the methods declared by the interface. This ensures that if a method declaration is removed from the interface, the change will be detected during the compilation of the implementing class.

```java
public class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
```

#### 16.4 Dependency Injection

According to the interface concept, classes should not instantiate their dependencies. Instead, a class should only use its dependencies, which promotes the separation of concerns. This is achieved through dependency injection, where another class is responsible for creating and passing an object to the dependent class.

There are different types of dependency injection: constructor injection, setter injection, and method injection. For example, an object can be injected inside the constructor method of a class. Object instantiation and injection can be handled in the `main` method of the `Main` class. While the `main` method is suitable for a few dependencies, frameworks are often used to manage a large number of dependencies.

```java
public class PaymentService {
    private PaymentProcessor processor;

    public PaymentService(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void makePayment(double amount) {
        processor.processPayment(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor ccProcessor = new CreditCardProcessor();
        PaymentService service = new PaymentService(ccProcessor);
        service.makePayment(100.00);
    }
}
```

#### 16.5 Interface Segregation

Interface segregation involves dividing a large interface into smaller, more specific ones. This ensures that implementing classes are only required to implement the methods relevant to them. If needed, multiple smaller interfaces can be combined into a single general interface, which will inherit the methods of the smaller interfaces. Unlike classes, which can only extend a single other class, interfaces can extend multiple other interfaces.

```java
public interface OnlinePaymentProcessor extends PaymentProcessor {
    void processOnlinePayment(double amount);
}

public interface OfflinePaymentProcessor extends PaymentProcessor {
    void processOfflinePayment(double amount);
}
```
