# JavaScript

## 1. Introduction to JavaScript

#### 1.1 Overview of JavaScript

JavaScript is a highly popular programming language initially designed to add dynamic features to webpages, but its uses have significantly expanded to include the development of web and mobile applications, real-time networking, command-line tools, and games. Originally executed only within web browsers with built-in JavaScript engines, the advent of Node.js allowed JavaScript to be run on the server side, facilitating backend development. The language follows the ECMAScript specification set by the ECMA organization, with major updates like ES2015 (ES6) enhancing its modern functionalities.

#### 1.2 JavaScript execution

JavaScript code begins as human-readable source code, which is then parsed by the JavaScript engine to create an Abstract Syntax Tree (AST) for structured representation. Following this, the AST is compiled into bytecode, a lower-level format that improves execution efficiency, utilizing Just-In-Time (JIT) compilation to optimize frequently executed code at runtime. After generating the bytecode, the engine executes the code within an execution context that manages variable scope and the call stack. This dual process of interpretation and compilation characterizes JavaScript as both an interpreted and compiled language.

#### 1.3 Setting up a JavaScript Development Environment

To set up a JavaScript development environment using Visual Studio Code, follow these streamlined steps. This guide covers the installation of necessary tools, project configuration, useful extensions, and how to run and debug your JavaScript projects efficiently.

1. Install Node.js:
   
   - Download Node.js from the [Node.js website](https://nodejs.org/) and choose the recommended version for your operating system.
   
   - Follow the installation instructions for your OS to install Node.js and npm (Node Package Manager).
   
   - Open your terminal and verify the installation by running:
     
     ```bash
     node -v   # Check Node.js version
     npm -v    # Check npm version
     ```

2. Install Visual Studio Code (VS Code):
   
   - Visit the [VS Code website](https://code.visualstudio.com/) to download the version for your operating system.
   - Follow the installation instructions specific to your OS.

3. Configure a New JavaScript Project:
   
   - Local Configuration:
     
     - Open your terminal and create a new project directory by navigating to your desired location and running:
       
       ```bash
       mkdir my-js-project
       cd my-js-project
       ```
     
     - Initialize a new npm project by running:
       
       ```bash
       npm init -y
       ```
     
     - Open the project in VS Code with:
       
       ```bash
       code .
       ```
     
     - Create a new JavaScript file (e.g., `index.js`) and start coding.
   
   - Browser Configuration:
     
     - Create an `index.html` file in your project directory with the following basic structure:
       
       ```html
       <!DOCTYPE html>
       <html lang="en">
       <head>
           <meta charset="UTF-8">
           <meta name="viewport" content="width=device-width, initial-scale=1.0">
           <title>My JavaScript Project</title>
       </head>
       <body>
           <script src="index.js"></script>
       </body>
       </html>
       ```

4. Useful VS Code extensions:
   
   - Install the following extensions to enhance your development experience:
     - JavaScript (ES6): Offers syntax highlighting, IntelliSense, and code navigation, simplifying the use of modern JavaScript features.
     - Prettier - Code Formatter: Automatically formats your code for consistency, keeping it clean and readable. Enable the "Format On Save" option to format your code with each save.
     - ESLint: A powerful linting tool that identifies and fixes coding standard issues and potential errors. Enable "Lint On Save" to check for errors automatically upon saving.
     - Live Server: Provides a local development server with live reload functionality, refreshing your browser whenever you save changes to HTML, CSS, or JavaScript files. Start it by right-clicking your `index.html` file and selecting "Open with Live Server."

5. Running your project:
   
   - Running Locally in the Terminal:
     
     - To execute your JavaScript file, use the terminal command:
       
       ```bash
       node index.js
       ```
   
   - Running in the Browser:
     
     - Right-click on `index.html` in VS Code and select “Open with Live Server” (if you have installed the Live Server extension).
     - Your default web browser will open, displaying the HTML page while executing the JavaScript in the background.

#### 1.4 Debugging with VS Code's JavaScript extension

VS Code’s JavaScript extension provides powerful debugging tools to help identify and fix errors in your code. When debugging a JavaScript project for the first time, you can create a `launch.json` file by navigating to the Debug panel in VS Code. This file, stored in the `.vscode` folder, defines your debugging configuration and usually requires minimal modification after setup.

Here are some key debugging tools available in the panel:

1. Breakpoints: Pause code execution at a specific line to examine the program's state at that moment.
2. Step Over: Execute the code line by line without entering functions, allowing you to observe where errors may arise.
3. Step Into: Dive into a function to inspect its internal execution more closely.
4. Step Out: Exit the current function and return to the calling code, helping you resume debugging at a higher level.
5. Variable Window: View the current values of variables during debugging to monitor the program’s state and detect anomalies.

These tools collectively enhance the debugging process, making error detection more manageable.

## 2. Variables

#### 2.1 Declaring variables and constants

In programming, variables are essential for temporarily storing data in a computer's memory. A variable acts as a named reference to a memory location, enabling easy access and modification of the stored data. To declare a variable in JavaScript, use the `let` keyword followed by the variable name, ending with a semicolon. If no value is assigned during declaration, the variable holds an `undefined` value. Values can be assigned using the `=` operator, and it’s important to choose meaningful names that describe the variable’s purpose while adhering to camelCase notation, where the first word is lowercase and subsequent words start with an uppercase letter.

```javascript
let userName = "Eli"; // Declaring a variable using 'let'
```

In cases where a variable's value should remain constant throughout the application, the `const` keyword is used instead of `let`. This ensures that the variable cannot be reassigned once it has been initialized. 

```javascript
const pi = 3.14; // Declaring a constant variable
```

#### 2.2 Code blocks and variable Scope

Code blocks in JavaScript, defined by curly braces `{}`, create a local scope where variables declared with `let` or `const` are accessible only within that block. This scoping behavior prevents variable name conflicts and helps manage memory more efficiently. In contrast, variables declared outside any code block are globally scoped, which can lead to unintended interactions and bugs in larger applications. Consequently, relying on global variables is generally discouraged as it increases the risk of name collisions, makes code harder to debug, and complicates maintenance. By using code blocks and local variables, developers can write cleaner, more modular code that minimizes unintended side effects.

## 3. Comments

Comments in JavaScript are used to add notes, explanations, or temporarily disable code without affecting program execution. They help make code more readable and maintainable. JavaScript supports two types of comments: single-line and multi-line.

#### 3.1 Single-line comment

Single-line comments begin with `//`:

```javascript
// This is a single-line comment
let x = 10; // Assigning value 10 to x
```

#### 3.2 Multi-line comment

Multi-line comments are enclosed within `/* */`:

```javascript
/* 
This is a multi-line comment.
It can span multiple lines.
*/
let y = 20;
```

## 4. Data Types

#### 4.1 Dynamic typing in JavaScript

JavaScript is a dynamically typed language, meaning that a variable's type can change at runtime, allowing it to store different types of values throughout its lifecycle. This flexibility enables developers to write more adaptable code. To check the current type of a variable, you can use the `typeof` operator, which returns a string that indicates the variable's type. For example:

```javascript
let data = "Hello, World!"; // Initially a string
console.log(typeof data); // Outputs: "string"

data = 42; // Now a number
console.log(typeof data); // Outputs: "number"

data = true; // Now a boolean
console.log(typeof data); // Outputs: "boolean"
```

#### 4.2 Primitive vs. reference types

In JavaScript, the key difference between primitive types and reference types lies in how they are stored and managed in memory. Primitive types are stored directly in the stack memory and are immutable, meaning their values cannot be changed. When a primitive value is assigned to a variable, a copy of that value is created. In contrast, reference types are stored in the heap memory, and variables hold a reference to the memory location where the actual data is stored. This means that when a reference type is assigned to a variable, only a reference (or pointer) to the original object is copied, allowing changes made to the object to be reflected across all references.

#### 4.3 Primitive data types

In JavaScript, primitive types are the most basic data types. Each primitive type represents a single value and is immutable, meaning they cannot be altered once created.

###### 4.3.1 String

A string represents text or a sequence of characters in JavaScript. Strings are enclosed in either single or double quotes.

```javascript
let greeting = "Hello, World!";
```

The `String()` function is used to convert a value into a string. Non-string values such as numbers or booleans can be easily converted.

```javascript
let num = 42;
let strNum = String(num); // "42"
```

Template literals in JavaScript, enclosed by backticks (`` ` ``), allow for multi-line strings and dynamic content insertion using `${}` placeholders, making string formatting more flexible and readable compared to traditional string literals.

```javascript
let word = "world";
let sentence = `Hello ${word}!`;
```

###### 4.3.2. Number

The number data type in JavaScript includes both integer and floating-point values. Unlike other languages, JavaScript only has one type for numeric values—there are no distinctions between integers and decimals.

```javascript
let pi = 3.14;
```

The `Number()` function converts a value to a number. If the conversion is not possible (e.g., with non-numeric strings), it returns `NaN`.

```javascript
let str = "123";
let num = Number(str); // 123
```

Additional functions like `parseInt()` and `parseFloat()` can convert strings to integers or floating-point numbers:

```javascript
let intVal = parseInt("123px"); // 123
let floatVal = parseFloat("123.45"); // 123.45
```

###### 4.3.3 Boolean

A boolean represents a logical entity with two possible values: `true` or `false`. Booleans are often used in conditional statements to control the flow of code.

```javascript
let isJavaScriptFun = true;
```

In JavaScript, certain values are considered truthy (evaluated as `true`) or falsy (evaluated as `false`). Falsy values include `0`, `""` (empty string), `null`, `undefined`, `NaN`, and `false`. Everything else is truthy.

The `Boolean()` function converts values to a boolean. 

```javascript
let truthyVal = Boolean(1); // true
let falsyVal = Boolean(0);  // false
```

###### 4.3.4 Undefined

The `undefined` value represents a variable that has been declared but not assigned any value. It is a primitive type used by JavaScript to indicate the absence of a defined value.

```javascript
let notAssigned;
console.log(notAssigned); // undefined
```

###### 4.3.5 Null

The `null` type represents the intentional absence of any object or value. It is often used to indicate that a variable should have no value or an object is missing.

```javascript
let emptyValue = null;
```

###### 4.3.6 Symbol

A `Symbol` is a unique and immutable value often used as object property keys to avoid naming conflicts. Each symbol is guaranteed to be unique, even if it has the same description.

```javascript
let symbol1 = Symbol("id");
let symbol2 = Symbol("id");
console.log(symbol1 === symbol2); // false
```

#### 4.4 Reference data types

In JavaScript, reference types are more complex data types that can hold collections of values and more complex entities. Unlike primitive types, reference types are mutable, meaning their properties or elements can be changed even after creation.

| **Reference Type** | **Description**                                                                                 |
| ------------------ | ----------------------------------------------------------------------------------------------- |
| Array              | Represents an ordered list of elements, which can be of any type.                               |
| Function           | Represents a block of code designed to perform a specific task and can be executed when called. |
| Object             | Represents a collection of key-value pairs, where values can be of any type.                    |

## 5. Arrays

#### 5.1 Creating and accessing array elements

In JavaScript, arrays store collections of elements (numbers, strings, objects, etc.) and are initialized using square brackets `[]`. Arrays are zero-indexed, meaning the first element is accessed with index `0`. The number of elements in an array can dynamically change.

```javascript
const fruits = ["apple", "banana", "cherry"];
console.log(fruits[0]); // "apple"
console.log(fruits.length); // 3
```

#### 5.2 Adding new elements

JavaScript provides several methods to add elements to an array, either at the end, the beginning, or at a specific index.

| Method      | Description                             |
| ----------- | --------------------------------------- |
| `push()`    | Adds elements to the end of the array   |
| `unshift()` | Adds elements to the start of the array |
| `splice()`  | Adds elements at a specified index      |

#### 5.3 Finding elements

You can find elements in arrays using different methods. These methods work on either primitive types or reference types (like objects).

| Method       | Description                                             | Applicable to   |
| ------------ | ------------------------------------------------------- | --------------- |
| `indexOf()`  | Returns index of the first occurrence (primitive)       | Primitive types |
| `includes()` | Checks if the element is present (returns true/false)   | Primitive types |
| `find()`     | Returns first element that meets a condition (callback) | Reference types |

#### 5.4 Removing elements

Several methods allow you to remove elements from arrays, depending on whether the element is at the start, end, or a specific index.

| Method     | Description                                   |
| ---------- | --------------------------------------------- |
| `pop()`    | Removes the last element of the array         |
| `shift()`  | Removes the first element of the array        |
| `splice()` | Removes elements starting at a specific index |

#### 5.5 Combining and slicing arrays

You can combine or extract portions of arrays using methods like `concat()` and `slice()`. The spread operator (`[...array1, ...array2]`) also allows easy array merging.

| Method     | Description                                             |
| ---------- | ------------------------------------------------------- |
| `concat()` | Combines two or more arrays into a new array            |
| `slice()`  | Extracts part of an array without altering the original |

#### 5.6 Join and split

JavaScript provides methods to convert arrays to strings and vice versa.

| Method    | Description                                          |
| --------- | ---------------------------------------------------- |
| `join()`  | Converts array elements into a single string         |
| `split()` | Converts a string into an array based on a separator |

#### 5.7 Sorting and reversing

Arrays can be sorted or reversed using the `sort()` and `reverse()` methods. Sorting can be customized for complex types using a comparison function.

| Method      | Description                                  |
| ----------- | -------------------------------------------- |
| `sort()`    | Sorts the array (default: lexicographically) |
| `reverse()` | Reverses the order of the array              |

#### 5.8 Array iteration methods

JavaScript provides several methods to iterate over arrays, either to transform data or evaluate conditions.

| Method       | Description                                                 |
| ------------ | ----------------------------------------------------------- |
| `.forEach()` | Executes a function for each element in the array           |
| `.every()`   | Tests if every element meets a condition                    |
| `.some()`    | Tests if at least one element meets a condition             |
| `.filter()`  | Returns a new array with elements that pass a condition     |
| `.map()`     | Creates a new array by transforming each element            |
| `.reduce()`  | Reduces the array to a single value by accumulating results |

Code example:

```javascript
items.forEach((item) => console.log(fruit)); // Logs each item
```

## 6. Functions

#### 6.1 Declaring functions

A function in JavaScript is a block of code that performs a task or returns a value. Functions are declared using the `function` keyword, followed by a name, parentheses for parameters, and curly braces for the function body. Input parameters are passed during function calls, and the `return` statement sends a value back to the caller.

```javascript
function functionName(parameters) {
  # Function body
  # Perform computations, manipulate data, etc.
  # ...
  return result;
}

let variable = function_name(argument)
```

#### 6.2 Function declarations vs. expressions

JavaScript functions can be declared or expressed:

- Function declarations are hoisted, meaning they can be called before they are defined.
  
  ```javascript
  function functionName(parameters) {
    # Function body
    # Perform computations, manipulate data, etc.
    # ...
    return result;
  }
  ```

- Function expressions assign a function to a variable. They are not hoisted and must be defined before they are called.
  
  ```javascript
  const myFunction = function(parameters) {
    # Function body
    # Perform computations, manipulate data, etc.
    # ...
    return result;
  }
  ```

#### 6.3 Arrow functions

Arrow functions provide a concise syntax for writing functions. They do not have their own `this` context and can be written in various ways.

```javascript
// Arrow function with multiple parameters
const myArrowFunction = (param1, param2) => {
  // Function body
  // Perform operations with param1 and param2
  return result;
};

// Arrow function with one parameter
const mySingleParamFunction = (param) => {
  // Function body
  // Perform operation with param
  return result;
};

// Arrow function with no parameters
const myNoParamFunction = () => {
  // Function body
  // Perform operation without parameters
  return result;
};

// Arrow function with implicit return
const myImplicitReturnFunction = (param1, param2) => param1 + param2;

// Arrow function using the rest operator
const myRestOperatorFunction = (...params) => {
  // Function body
  // Perform operation on params array
  return result;
};
```

#### 6.4 Variable arguments in functions

Functions can accept variable numbers of arguments using the `arguments` object or the rest operator (`...`), which captures arguments into an array.

```javascript
function variableArgs(...args) {
  console.log(args); // [ 'a', 'b', 'c' ]
}
variableArgs('a', 'b', 'c');
```

#### 6.5 Setting default parameters

JavaScript ES6 allows setting default parameter values, making functions more flexible. Default values are used when arguments are not provided during function calls.

```javascript
// Function declaration with default parameter
function myFunction(arg = "default value") {
  // Function body
  // Perform operations with arg, manipulate data, etc.
  console.log(`Performing action with ${arg}`);
}

// Function call without argument
myFunction(); // Output: Performing action with default value
```

## 7. Objects

#### 7.1 Creating and working with objects

JavaScript objects are collections of key-value pairs, where each key represents a property. You can create objects using `let` or `const` with curly braces. Properties can be accessed or modified using dot or bracket notation.

```javascript
// Creating an object
const myObject = {
  property1: "value1",
  property2: "value2",
  method: function() {
    // Method logic
  }
};

// Accessing properties
console.log(myObject.property1); // Output: "value1"
myObject.method(); // Invokes the method
```

#### 7.2 Dynamic behavior of objects

JavaScript objects are dynamic, allowing you to add or remove properties and methods at runtime. The `delete` operator can be used to remove properties.

```javascript
// Adding a new property
myObject.newProperty = "newValue";

// Removing a property
delete myObject.property2;
console.log(myObject); // Output: { property1: "value1", method: [Function], newProperty: "newValue" }
```

#### 7.3 Iterating over object properties

You can iterate over object properties using various methods. The `for...in` loop iterates through all enumerable properties, while `Object.keys()` can be used with a `for...of` loop.

```javascript
// Using for...in
for (let key in myObject) {
  console.log(`${key}: ${myObject[key]}`);
}

// Using for...of with Object.keys()
for (let key of Object.keys(myObject)) {
  console.log(`${key}: ${myObject[key]}`);
}
```

#### 7.4 Creating a copy of an object

A shallow copy of an object can be created using the spread operator (`...`). This copies properties but only references for nested objects.

```javascript
const myObjectCopy = { ...myObject };
console.log(myObjectCopy); // Output: { property1: "value1", method: [Function], newProperty: "newValue" }
```

Here’s a concise summary of the provided text on factory functions, constructor functions, and related concepts in JavaScript, structured into sections with code snippets where applicable:

#### 7.5 Factory functions

Factory functions create and return new object instances, allowing customization of object properties through parameters. They enable the creation of multiple objects with shared structures or behaviors.

```javascript
// Factory function example
function createObject(param1, param2) {
  return {
    prop1: param1,
    prop2: param2,
    method() {
      // Method logic
    }
  };
}

const obj1 = createObject("value1", "value2");
const obj2 = createObject("value3", "value4");
```

#### 7.6 Constructor functions

Constructor functions use the `this` keyword to define properties and methods for object instances. The `new` operator is required to instantiate objects, ensuring proper binding of `this`.

```javascript
// Constructor function example
function MyConstructor(param1, param2) {
  this.prop1 = param1;
  this.prop2 = param2;
  this.method = function() {
    // Method logic
  };
}

const myInstance = new MyConstructor("value1", "value2");
```

#### 7.7 Private members

Abstraction can be achieved in constructor functions by using local variables or constants as private members, accessed by methods within the object. This is enabled by JavaScript’s closure mechanism, allowing inner functions to retain access to their parent function's variables.

```javascript
function MyConstructor() {
  let privateVar = "I am private";

  this.publicMethod = function() {
    console.log(privateVar); // Accessing private variable
  };
}

const instance = new MyConstructor();
instance.publicMethod(); // Output: "I am private"
```

#### 7.8 Getters and setters

Getters and setters provide controlled access and modification of object properties. They encapsulate the internal state, enabling logic enforcement when properties are accessed or modified.

```javascript
function MyConstructor() {
  let internalValue;

  Object.defineProperty(this, 'value', {
    get() {
      return internalValue;
    },
    set(newValue) {
      internalValue = newValue; // Logic for setting the value
    }
  });
}

const instance = new MyConstructor();
instance.value = "new value"; // Using setter
console.log(instance.value); // Using getter: Output: "new value"
```

#### 7.9 Understanding the `this` keyword

The `this` keyword in JavaScript changes based on the context in which it is used. Inside object methods, `this` refers to the object that owns the method, allowing access to the object's properties. However, in nested functions within methods, `this` often points to the global object, which can result in unexpected behavior. To address this, methods like `call()` and `apply()` can be used to explicitly set the `this` context, enabling more predictable function execution.

```javascript
function MyConstructor(value) {
  this.value = value;

  // Regular method
  this.showValue = function() {
    console.log(this.value); // 'this' refers to current object
  };
}

const obj1 = new MyConstructor("Hello");

// Calling the method with 'this' bound to obj1
obj1.showValue(); // Output: "Hello"

// Using call() to change 'this' context
const obj2 = { value: "World" };
obj1.showValue.call(obj2); // Output: "World"
```

With the introduction of arrow functions in ES6, JavaScript gained a simpler way to handle `this`. Arrow functions do not have their own `this` context; instead, they inherit it from the surrounding lexical scope. This prevents common issues with `this` in nested functions, ensuring that the desired object context is preserved.

```javascript
function MyConstructorArrow(value) {
  this.value = value;

  // Arrow method
  this.showValue = () => {
    console.log(this.value); // 'this' refers to the object being created
  };
}

const obj3 = new MyConstructorArrow("Hello Arrow");

// Arrow function uses the constructor's 'this'
obj3.showValue(); // Output: "Hello Arrow"

// Even using call(), the 'this' context doesn't change
const obj4 = { value: "World Arrow" };
obj3.showValue.call(obj4); // Output: "Hello Arrow" (still refers to obj3)
```

#### 7.10 Learning about built-in objects

For detailed information about methods and properties of built-in objects like `String`, `Math`, and `Date`, the [MDN Web Docs](https://developer.mozilla.org/en-US/) is a valuable resource.

## 8. Operators

#### 8.1 Arithmetic operators

Arithmetic operators are symbols used to perform basic mathematical operations on numbers.

| **Operator** | **Description**                                   |
| ------------ | ------------------------------------------------- |
| `+`          | Adds two values                                   |
| `-`          | Subtracts the second value from the first         |
| `*`          | Multiplies two values                             |
| `/`          | Divides the first value by the second             |
| `%`          | Returns the remainder of division                 |
| `**`         | Raises the first value to the power of the second |
| `++`         | Increases a value by one                          |
| `--`         | Decreases a value by one                          |

#### 8.2 Assignment operators

Assignment operators are used to assign values to variables and can also perform arithmetic operations simultaneously. They combine the assignment of a value with an arithmetic operation to update the variable.

| **Operator** | **Description**                                                     |
| ------------ | ------------------------------------------------------------------- |
| `=`          | Assigns a value to a variable                                       |
| `+=`         | Adds a value to the variable and assigns the result                 |
| `-=`         | Subtracts a value from the variable and assigns the result          |
| `*=`         | Multiplies the variable by a value and assigns the result           |
| `/=`         | Divides the variable by a value and assigns the result              |
| `%=`         | Takes the modulus of the variable by a value and assigns the result |

#### 8.3 Comparison operators

Comparison operators are used to compare two values and determine their relationship, such as whether one value is greater than, less than, or equal to another. They return a boolean value based on the result of the comparison.

| **Operator** | **Description**                                                      |
| ------------ | -------------------------------------------------------------------- |
| `>`          | Checks if the left value is greater than the right value             |
| `>=`         | Checks if the left value is greater than or equal to the right value |
| `<`          | Checks if the left value is less than the right value                |
| `<=`         | Checks if the left value is less than or equal to the right value    |
| `===`        | Checks if two values are equal and of the same type                  |
| `!==`        | Checks if two values are not equal or not of the same type           |
| `==`         | Checks if both values are equal after type conversion                |

#### 8.4 Logical operators

Logical operators are used to combine or negate boolean values and expressions, allowing for more complex conditions in logical statements. They evaluate expressions to return a boolean result based on the logical relationships between operands.

| **Operator** | **Description**                                           |
| ------------ | --------------------------------------------------------- |
| `&&`         | Returns `true` if both operands are `true`                |
| ``           | Returns `true` if at least one of both operands is `true` |
| `!`          | Negates the boolean value of the operand                  |

#### 8.5 Spread operator

The spread operator (`...`) in JavaScript allows an iterable (like an array or object) to be expanded into individual elements. It is commonly used for tasks like copying or merging arrays, spreading elements in function arguments, and cloning or merging objects. The spread operator makes operations with arrays and objects more concise and efficient.

#### 8.6 Operator precedence

Operator precedence in arithmetic operations determines the order in which operators are evaluated in an expression, and you can control it using parentheses to specify the desired calculation order. By enclosing parts of an expression in parentheses, you can ensure they are evaluated before other operations, overriding the default precedence rules. For example, in the expression `3 + 4 * 2`, the result is `11` because multiplication takes precedence over addition. However, `(3 + 4) * 2` ensures addition is performed first, resulting in `14`. Using parentheses allows you to precisely define the order of operations in expressions.

## 9. Conditional statement

#### 9.1 If...else statements

The `if...else` statement is fundamental for making decisions in JavaScript. It executes different blocks of code based on whether a given condition is `true` or `false`. This structure allows you to create branching logic where various outcomes can occur based on different conditions.

```javascript
if (condition) {
  // Code executes if the condition is true
} else if (anotherCondition) {
  // Code executes if the second condition is true
} else {
  // Code executes if none of the conditions are true
}
```

#### 9.2 Ternary operator

The ternary operator provides a shorthand for `if...else` statements. It evaluates a condition and returns one of two values depending on whether the condition is `true` or `false`. It’s useful for simple conditional assignments or inline decisions.

```javascript
let result = condition ? valueIfTrue : valueIfFalse;
```

#### 9.3 Switch...case statements

The `switch...case` statement is useful for handling multiple conditions based on a single expression. It evaluates the expression and executes the code that matches the value of the expression. This is often a more readable alternative to using multiple `if...else` statements when checking a single variable against several values.

```javascript
switch (expression) {
  case value1:
    // Code executes if expression equals value1
    break;
  case value2:
    // Code executes if expression equals value2
    break;
  default:
    // Code executes if no case matches the expression
    break;
}
```

#### 9.4 Short-circuit evaluation

Short-circuit evaluation is a process in JavaScript where logical operators (`&&` and `||`) stop evaluating expressions as soon as the outcome is determined. For the `&&` (AND) operator, if the first condition is `false`, it immediately returns `false` without checking the second condition. Conversely, for the `||` (OR) operator, if the first condition is `true`, it returns `true` without evaluating the rest of the expression. This behavior optimizes code execution by avoiding unnecessary checks.

```javascript
let result = condition1 && condition2; // condition2 is only checked if condition1 is true
let anotherResult = condition1 || condition2; // condition2 is only checked if condition1 is false
```

## 10. Loops

Loops in JavaScript allow for executing a block of code multiple times, controlled by a condition. There are several types of loops, each with specific use cases depending on the scenario.

#### 10.1 For loop

A `for` loop runs a block of code a defined number of times, controlled by an initialization, a condition, and an iteration step. It is often used when the number of iterations is known in advance.

```javascript
for (initialization; condition; iteration) {
  // Code to be executed in each iteration
}
```

#### 10.2 While loop

The `while` loop continuously executes a block of code as long as the specified condition remains `true`. It checks the condition before each iteration, making it suitable for cases where the number of iterations is not predetermined.

```javascript
while (condition) {
  // Code to be executed while the condition is true
}
```

#### 10.3 Do...while loop

The `do...while` loop guarantees that the code block is executed at least once, even if the condition is initially `false`, as the condition is checked after the first iteration.

```javascript
do {
  // Code to be executed
} while (condition);
```

#### 10.4 Controling loop execution

The `break` keyword allows you to exit a loop before completing all iterations, while `continue` skips the current iteration and moves on to the next one. These keywords help manage the loop flow based on specific conditions.

```javascript
if (condition) break;   // Exit loop
if (anotherCondition) continue;   // Skip current iteration
```

## 11. Exception handling

#### 11.1 Exception handling

Exception handling in JavaScript allows you to manage errors gracefully without stopping the execution of the entire program. By using `try...catch` blocks, you can detect and handle exceptions (errors) that occur during code execution. The optional `finally` block can be included to execute code regardless of whether an error occurred or not. This is useful for cleanup operations, such as closing connections or freeing resources.

```javascript
try {
  // Code that may throw an error
} catch (error) {
  // Code to handle the error
} finally {
  // Code that will run regardless of an error (optional)
}
```

#### 11.2 Raising exceptions

In JavaScript, you can explicitly throw exceptions using the `throw` keyword. This allows you to raise custom errors or halt execution when certain conditions are not met.

```javascript
if (conditionFails) {
  throw new Error("Custom error message");
}
```

#### 11.3 Built-in errors

JavaScript provides several built-in error types for handling specific issues. Common ones include `RangeError` for numbers outside valid ranges, `ReferenceError` for accessing undefined references, `SyntaxError` for code with invalid syntax, and `TypeError` when variables or parameters are of the wrong type. These specialized errors help developers identify and address different problems effectively. For more details, refer to the [MDN documentation](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Error).

## 12. Asynchronous programming

#### 12.1 Synchronous code

JavaScript can execute code synchronously or asynchronously. In synchronous code, tasks are performed sequentially, meaning each line waits for the previous one to finish before executing. This can lead to delays if a task takes a long time to complete.

```javascript
// Synchronous execution
console.log('Start');
let result = computeSync(); // This line blocks execution until computeSync completes
console.log('End');
```

#### 12.2 Asynchronous code

Asynchronous code allows tasks to run in parallel or without blocking the main thread. This is useful for operations like fetching data, where you don't want the entire program to pause.

```javascript
console.log('Start');
setTimeout(() => console.log('Async task done'), 1000); // Executes after 1 second
console.log('End');
```

#### 12.3 Callbacks

Callbacks are functions provided as arguments to other functions, designed to be executed after a specific operation, often asynchronous, has completed. To allow you to handle the results of operationsin a flexible manner. However, extensive use of callbacks, particularly when nesting them to handle multiple asynchronous operations, can lead to "callback hell," making the code difficult to read and maintain. This occurs because deeply nested callbacks can create complex and indented structures that obscure the flow of the program.

```javascript
function asyncOperation(callback) {
  setTimeout(() => {
    callback('Result of async operation');
  }, 1000);
}

asyncOperation(result => {
  console.log(result); // Executes when the async operation completes
});
```

#### 12.4 Promises

###### 12.4.1 Creating a promise

A promise in JavaScript is an object that represents the eventual outcome of an asynchronous operation. It can exist in one of three states: pending (neither resolved nor rejected), fulfilled (the operation succeeded), or rejected (the operation failed). The `Promise` constructor is used to create a promise, and it accepts an executor function with two parameters: `resolve`, which is called when the operation succeeds, and `reject`, which is called when it fails.

```javascript
let myPromise = new Promise((resolve, reject) => {
  // Simulate an asynchronous task
  setTimeout(() => {
    let success = true; // Let's say the task succeeds

    if (success) {
      resolve("Task succeeded!");  // Call resolve on success
    } else {
      reject("Task failed!");      // Call reject on failure
    }
  }, 1000);  // Simulate a delay of 1 second
});
```

###### 12.4.2 Handling promises with async/await

When dealing with a promise, you often need to wait for it to resolve before acting on the result. The modern way to handle promises is to use the `async` and `await` keywords. To properly use `await`, the code must be inside an `async` function. You can wrap your promise handling in a `try...catch` block to manage both success and failure scenarios.

```javascript
async function handlePromise() {
  try {
    let result = await myPromise; // Waits for the promise to resolve
    console.log(result);          // Logs the result if fulfilled
  } catch (error) {
    console.error(error);         // Catches and logs any errors
  }
}
```

###### 12.4.3 Handling Promises with .then() and .catch()

Another common approach to handle the results of a promise is by using the `.then()` method for successful resolution and `.catch()` for handling errors. This method provides a cleaner syntax for managing asynchronous code.

```javascript
myPromise
  .then(result => console.log(result))    // If resolved, logs "Task succeeded!"
  .catch(error => console.log(error));    // If rejected, logs "Task failed!"
```

## 13. Object-oriented programming

#### 13.1 Prototypical inheritance

Prototypes are essential to JavaScript's inheritance model, enabling objects to inherit properties and methods directly from other objects through prototypical inheritance. Each object has a single prototype, serving as its parent, with all objects ultimately inheriting from the base object. This mechanism allows for multiple levels of inheritance and facilitates code reuse. Every function in JavaScript has a prototype, allowing objects created from a constructor to inherit from that function's prototype. The introduction of ES6 classes improved the syntax for managing inheritance, acting as syntactic sugar over the prototype-based system, yet a solid grasp of prototypical inheritance remains crucial, as classes are built on these foundational principles.

#### 13.2 Classes

Classes in JavaScript are introduced with the `class` keyword and allow you to create blueprints for objects. A class typically includes a `constructor` method for initializing object properties and additional methods for functionality. JavaScript classes are syntactic sugar over its prototype-based inheritance system, making the code more readable and easier to manage.

```javascript
class ExampleClass {
  constructor(data) {
    this.data = data;
  }

  display() {
    console.log(`Data: ${this.data}`);
  }
}

let obj = new ExampleClass('Sample');
obj.display();  // Output: Data: Sample
```

#### 13.3 Static methods

Static methods are class-level methods that cannot be called on instances of the class but can be called directly on the class itself. They are typically used for utility or helper functions that don’t require access to instance-specific data.

```javascript
class UtilityClass {
  static utilityMethod(x, y) {
    return x + y;
  }
}

console.log(UtilityClass.utilityMethod(2, 3));  // Output: 5
```

#### 13.4 Private properties and methods

Symbols can be used in JavaScript to create private properties and methods, as they are unique identifiers that are not accessible outside the class. This enables data encapsulation, hiding implementation details from users of the class.

```javascript
const privateKey = Symbol('privateKey');

class HiddenClass {
  constructor(value) {
    this[privateKey] = value;
  }

  // Private method using a symbol
  _privateMethod() {
    return this[privateKey];
  }

  publicMethod() {
    console.log(this._privateMethod());
  }
}

let instance = new HiddenClass('Secret');
instance.publicMethod();  // Output: Secret
console.log(instance.privateKey);  // Output: undefined
```

#### 13.5 Property getters and setters

Getters and setters in JavaScript allow controlled access to properties of a class. Getters retrieve the property values, while setters modify them. They are useful for adding validation or additional logic when accessing or setting class properties.

```javascript
class ManagedProperties {
  constructor(value) {
    this._value = value;
  }

  // Getter
  get value() {
    return this._value;
  }

  // Setter with validation
  set value(newValue) {
    if (newValue > 0) {
      this._value = newValue;
    } else {
      console.log("Value must be greater than zero.");
    }
  }
}

let instance = new ManagedProperties(10);
console.log(instance.value);  // Output: 10
instance.value = -5;          // Output: Value must be greater than zero.
instance.value = 20;
console.log(instance.value);  // Output: 20
```

#### 13.6 Inheritance and composition

In JavaScript, inheritance is achieved using the `extends` keyword, allowing one class to inherit properties and methods from another. The `super` keyword calls the parent class’s constructor or methods. Inheritance is useful for creating hierarchical relationships, allowing shared functionality between classes.

```javascript
class BaseClass {
  constructor(value) {
    this.baseValue = value;
  }

  showValue() {
    console.log(this.baseValue);
  }
}

class SubClass extends BaseClass {
  constructor(value) {
    super(value);
    this.subValue = value + 1;
  }

  // Overriding the parent method
  showValue() {
    super.showValue();  // Call parent method
    console.log(this.subValue);
  }
}

let obj = new SubClass(1);
obj.showValue();  // Output: 1, 2
```

While inheritance allows for hierarchical relationships between classes, composition is often preferred in object-oriented design. Composition involves building complex objects by combining simpler, smaller objects. Rather than inheriting behaviors, classes delegate responsibility to other objects. This approach promotes greater flexibility, avoids deep inheritance chains, and supports code reuse in a more modular way.

```javascript
class ComponentA {
  methodA() {
    console.log("Method from Component A");
  }
}

class ComponentB {
  methodB() {
    console.log("Method from Component B");
  }
}

class ComposedClass {
  constructor() {
    this.componentA = new ComponentA();
    this.componentB = new ComponentB();
  }

  execute() {
    this.componentA.methodA();
    this.componentB.methodB();
  }
}

let composed = new ComposedClass();
composed.execute();  // Output: Method from Component A, Method from Component B
```

## 14. Modules

#### 14.1 What are modules?

Modules in JavaScript allow you to break up your code into smaller, manageable files. Each module can export certain functions, objects, or variables and allow other parts of your application to import and use them. This separation of concerns makes code easier to maintain, test, and reuse. Modules also allow you to encapsulate code, hiding the internal logic while exposing only the parts that are needed by other modules.

#### 14.2 CommonJS modules

###### 14.2.1 Creating a CommonJS module

CommonJS is the module system traditionally used in Node.js. In CommonJS, each file is considered a module, and you can export functionality from a file using `module.exports`:

```javascript
// mathModule.js
const add = (a, b) => a + b;
const subtract = (a, b) => a - b;

module.exports = {
  add,
  subtract
};
```

###### 14.2.2 Importing a CommonJS module

To import a CommonJS module, use the `require` function:

```javascript
// main.js
const math = require('./mathModule');

console.log(math.add(5, 3));      // Output: 8
console.log(math.subtract(10, 6));  // Output: 4
```

#### 14.3 ES6 modules

###### 14.3.1 Named exports in ES6 modules

ES6 Modules (also known as ECMAScript Modules or ESM) are the modern standard for JavaScript modules. They are natively supported in browsers and Node.js (from version 12 and later). ES6 modules use `export` to expose functions, variables:

```javascript
// mathModule.js
export const add = (a, b) => a + b;
export const subtract = (a, b) => a - b;
```

To import specific exports, use the `import` keyword:

```javascript
// main.js
import { add, subtract } from './mathModule.js';

console.log(add(5, 3));         // Output: 8
console.log(subtract(10, 6));   // Output: 4
```

###### 14.3.2 Default exports in ES6 modules

ES6 modules also allow you to specify a default export, which is useful when a module exports a single main function or object. Default exports can be imported with any name.

```javascript
// utils.js
const logger = (message) => {
  console.log(`Log: ${message}`);
};

export default logger;
```

When importing a default export, you can give it any name:

```javascript
// main.js
import log from './utils.js';

log('Hello World');  // Output: Log: Hello World
```

###### 14.3.3 Importing All Exports

You can also import all of the exports from a module at once using `* as` syntax:

```javascript
// main.js
import * as math from './mathModule.js';

console.log(math.add(2, 3));       // Output: 5
console.log(math.subtract(7, 4));  // Output: 3
```

## 15. Tools for modern JavaScript development

#### 15.1 Essential tools

When developing web applications with modern JavaScript (ES6), it’s crucial to ensure compatibility across different browsers. Two essential tools for this are a transpiler and a bundler.

1. Transpiler: is a tool that converts modern ES6 JavaScript code into a version that all browsers can understand. Babel is the most commonly used transpiler for this purpose, enabling developers to write cutting-edge JavaScript while ensuring compatibility with older browsers.

2. Bundler: is a tool that consolidates multiple JavaScript files into a single file, known as a bundle. The most popular bundler is Webpack, which also optimizes the bundle by removing unnecessary whitespace, comments, and renaming variables for efficiency.

#### 15.2 Setting up Webpack and Babe

To use Webpack and Babel, you first need to install Node.js, which provides access to the npm (Node Package Manager). npm is used to install third-party libraries and tools, including Webpack and Babel.

Here's a step-by-step guide to setting up Webpack and Babel:

1. Install Webpack Globally: Open your terminal in the project directory and run:
   
   ```bash
   npm i -g webpack-cli
   ```
   
   This installs Webpack globally, making it accessible from any project.

2. Initialize Webpack: In your project folder, run:
   
   ```bash
   webpack-cli init
   ```
   
   This command creates a Webpack configuration file and sets up the environment.

3. Set Up npm: Run the following command to create a `package.json` file:
   
   ```bash
   npm init --yes
   ```
   
   Then, add a build script to the `package.json` file:
   
   ```json
   "scripts": {
     "build": "webpack -w"
   }
   ```
   
   This script will automate the bundling process whenever changes are detected.

4. Adjust Dependencies: Move all relevant packages to the `devDependencies` section in `package.json` to indicate they are only needed during development.

5. Build the Project: Run the following command to bundle your JavaScript files:
   
   ```bash
   npm run build
   ```
   
   Webpack, with the help of Babel, will transpile and bundle the code into a single JavaScript file located in the output directory. This bundled file can then be included in your HTML file via a `<script>` tag.
