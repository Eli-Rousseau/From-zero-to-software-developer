# Java

## 1. The Anatomy of Java Programs

Java programs are composed of various building blocks, with the smallest being functions. A function is a block of code that performs a specific task. Here's a closer look at how functions and classes are structured in Java, along with the conventions and keywords used.

#### 1.1 Defining Functions

###### 1.1 Basic Function Definition

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

## 4. Casting



## 5. Numbers, Strings, and Arrays

#### 5.1 Working with Strings

Strings in Java are reference types that are imported by default, so no import statement is needed. Strings are used to store sequences of characters and provide a rich set of methods for manipulating text.

###### 5.1.1 Defining String Variables

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

###### 5.1.2 String Concatenation

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

###### 5.1.3 String Methods

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

###### 5.1.4 Including Escape Characters in Strings

In Java, strings can include special characters known as escape characters. These characters allow you to include characters in a string that would otherwise be difficult or impossible to include, such as:

- Using Double Quotes Inside Strings: To include a double quote inside a string, you need to precede it with a backslash (`\`). 

- Using Backslashes Inside Strings: To include a backslash inside a string, you need to precede it with another backslash (`\\`).

- Newline and Tab Characters:
  
  - `\n` corresponds to a newline character, which moves the cursor to the next line.
  
  - `\t` corresponds to a tab character, which inserts a horizontal tab space.

#### 5.2 Working with Arrays

Arrays in Java are used to store a list of items of the same type. They provide a way to manage multiple values in a single variable, which can be accessed by their index.

###### 5.2.1 Defining Arrays

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

###### 5.2.2 Accessing Array Elements

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

###### 5.2.3 Useful Methods for Arrays

There are some useful methods that you can use on arrays, some of the methods require to import the `Arrays` class from the `java.util` package.

| Method              | Description                                                                                                                                                                                                                                                                          |
| ------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `myArray.length()`  | Retrieves the number of items in an array                                                                                                                                                                                                                                            |
| `Arrays.sort()`     | Sort the array.                                                                                                                                                                                                                                                                      |
| `Arrays.toString()` | In Java, you cannot simply print the array variable to see the elements of the array. Doing so will display the memory location of the array transformed as a string instead of the actual elements. To properly print the elements of an array, use the `Arrays.toString()` method. |



## 6. Read input


