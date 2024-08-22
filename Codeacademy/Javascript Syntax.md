# Javascript Syntax

## 1. Introduction to Javascript

#### 1.1 The Backbone of Modern Web Development

JavaScript, often called JS, has become a fundamental technology in web development, alongside HTML and CSS. It is essential for anyone pursuing a career in this field due to its flexibility, power, and consistent implementation across major web browsers. Originally created in just 10 days, JavaScript gained widespread adoption because it transformed web browsers into application platforms, enabling interactive features like scroll transitions and object movement. Its ease of integration with HTML and CSS, regular updates, and the availability of numerous frameworks and libraries make it indispensable for both front-end and back-end development, allowing developers to build complex applications efficiently.

#### 1.2 ES6 Release for Modern JavaScript Development

ES6, or ECMAScript 6, is the sixth edition of the ECMAScript standard that defines the architecture of JavaScript. Released in 2015, ES6 represents the most significant update to the language since its original release, introducing powerful features such as let and const keywords for variable declaration, arrow functions, classes, default parameter values, and promises for asynchronous operations. These enhancements have enabled developers to write more concise and efficient code, facilitate object-oriented programming, and ease the transition for programmers from other languages. ES6 remains highly relevant today, with widespread browser support and adoption in popular frameworks like React, solidifying its role in modern web development despite subsequent ECMAScript updates.

#### 1.3 Printing to the Console

In JavaScript, the `console` object provides built-in methods for developers to interact with the console, with `console.log()` being one of the most commonly used methods. This function allows developers to print, or log, outputs to the console, which is essential for debugging and monitoring code execution. For example, using `console.log("Hello World!");` will output "Hello World!" to the console. While JavaScript often runs correctly without semicolons, it's advisable to consistently end statements with a semicolon to avoid potential errors in more complex scenarios.

```javascript
console.log("Hello World!");
```

#### 1.4 Using Comments for Code Clarity

In JavaScript, comments are annotations within the code that the computer ignores during execution, serving solely to aid human readers. There are two types of comments: single-line comments, denoted by `//`, are used to comment out individual lines or add inline notes, while multi-line comments, enclosed by `/* */`, can span multiple lines or be used within a line to comment out specific parts of the code. Comments are essential for explaining code functionality, leaving instructions, or making notes for future developers.

```javascript
// Prints Hello World to the console
console.log("Hello World");  // Prints Hello World 

/*
This is all commented out
console.log("Hello ");
None of this is going to run!
console.log("World");
*/

console.log(/*IGNORED!*/ "Hello World");  // Still just prints Hello World
```

#### 1.5 DataTypes

Here’s a table that summarizes the data types in JavaScript:

| Data Type     | Description                                                                   | Possible Values            | Example                           |
| ------------- | ----------------------------------------------------------------------------- | -------------------------- | --------------------------------- |
| **Number**    | Represents any numeric value, including integers and floating-point numbers.  | -2^53 to 2^53-1 (8 bytes)  | `42`, `3.14`                      |
| **BigInt**    | Represents integers larger than the maximum safe integer for the Number type. | Larger than 2^53-1         | `12345678901234567890n`           |
| **String**    | Represents a sequence of characters (text).                                   | Any sequence of characters | `'Hello, World!'`, `"JavaScript"` |
| **Boolean**   | Represents a logical entity and can have two values.                          | `true`, `false`            | `true`, `false`                   |
| **Null**      | Represents the intentional absence of any value.                              | `null`                     | `null`                            |
| **Undefined** | Represents a variable that has been declared but not assigned a value.        | `undefined`                | `undefined`                       |
| **Symbol**    | Represents a unique identifier; used primarily in complex scenarios.          | Unique symbol value        | `Symbol('description')`           |
| **Object**    | Represents a collection of related data and functions (key-value pairs).      | Complex structures         | `{name: 'Alice', age: 25}`        |

The first 7 of those types are considered primitive data types. They are the most basic data types in the language. Objects are more complex.

#### 1.6 Arithmetic Operators

| Operator           | Symbol | Description                                           | Example  |
| ------------------ | ------ | ----------------------------------------------------- | -------- |
| **Addition**       | `+`    | Adds two numbers together.                            | `5 + 3`  |
| **Subtraction**    | `-`    | Subtracts the second number from the first number.    | `10 - 4` |
| **Multiplication** | `*`    | Multiplies two numbers.                               | `7 * 2`  |
| **Division**       | `/`    | Divides the first number by the second number.        | `20 / 4` |
| **Remainder**      | `%`    | Returns the remainder of the division of two numbers. | `10 % 3` |

#### 1.7 String Concatenation

In JavaScript, the `+` operator can be used not only for arithmetic but also for concatenating, or joining, two strings. When applied to strings, it appends the right string to the left, forming a single combined string.

```javascript
console.log("Hello, " + "world!"); // Outputs: "Hello, world!"
```

#### 1.8 Accessing Properties

In JavaScript, when a piece of data is introduced, it's stored as an instance of a specific data type, and each instance has access to properties inherited from that data type. For example, string instances have a `length` property that stores the number of characters in the string. You can access these properties using the dot operator (`.`) followed by the property name.

```javascript
console.log("Hello, world!".length); // Outputs: 13
```

#### 1.9 Using Methods

In JavaScript, methods are actions that can be performed on instances of data types. String instances, for example, have various methods available to manipulate or retrieve information from the string. To use a method, you append the instance with a dot (`.`), followed by the method name and parentheses.

```javascript
console.log("Hello, world!".toUpperCase()); // Outputs: "HELLO, WORLD!"
```

#### 1.10 Built-in JavaScript Objects

JavaScript offers several built-in objects that provide a range of functionalities beyond basic operations. These objects include useful methods for various tasks; for example, the `Math` object offers mathematical operations. Similarly, the `Date` object allows for date and time manipulation, and the `Array` object includes methods for handling collections of data. By using these built-in objects, developers can leverage a broad set of pre-defined functions to enhance their programming capabilities.

```javascript
console.log(Math.random());  // Outputs a random number between 0 and 1

let today = new Date();
console.log(today.toDateString());  // Outputs the current date in a readable format

let numbers = [1, 2, 3];
console.log(numbers.join(", "));  // Outputs: "1, 2, 3"
```

## 2. Variables

#### 2.1 Declaring Variables

In JavaScript, variables are containers that store values and use descriptive names to make code more readable. Before ES6, the `var` keyword was used for variable declaration, such as `var myName = 'Eli';`, which follows camel casing and uses the `=` operator to assign values. ES6 introduced `let` for variables that can be reassigned and `const` for constants that cannot be reassigned. Both `let` and `const` are declared similarly but `const` enforces immutability, raising a `TypeError` if reassignment is attempted.

```javascript
var myName = 'Eli';   // Using var to declare and assign a value
let age = 30;         // Using let for a variable that can be reassigned
const birthYear = 1993; // Using const for a constant value

age = 31;             // Reassigning a let variable
// birthYear = 1994;  // Uncommenting this line will cause a TypeError for const
```

In JavaScript, variables declared with `let` or `var` can be initialized without a value, resulting in the variable being automatically set to `undefined`. However, `const` variables must be assigned a value at the time of declaration; failing to do so will result in a `SyntaxError`.

#### 2.2 Naming Conventions

There are a few general rules for naming variables:

- Variable names cannot start with numbers.

- Variable names are case sensitive, so `myName` and `myname` would be different variables. It is bad practice to create two variables that have the same name using different cases.

- Variables are following the camelCase naming convention, which capitalizes the first letter of each word except the first one, with no spaces or underscores.

- Variable names cannot be the same as keywords used in JavaScript. 

#### 2.3 Mathematical Assignment Operators

Mathematical assignment operators in JavaScript allow for concise and efficient updates to a variable's value by performing an arithmetic operation and reassigning the result. Here is a table summarizing the mathematical assignment operators in JavaScript:

| **Operator** | **Description**                                                                       | **Example** |
| ------------ | ------------------------------------------------------------------------------------- | ----------- |
| **`+=`**     | Adds the right operand to the variable and assigns the result to the variable.        | `w += 5`    |
| **`-=`**     | Subtracts the right operand from the variable and assigns the result to the variable. | `w -= 3`    |
| **`*=`**     | Multiplies the variable by the right operand and assigns the result to the variable.  | `w *= 2`    |
| **`/=`**     | Divides the variable by the right operand and assigns the result to the variable.     | `w /= 4`    |
| **`++`**     | Increases the variable's value by 1.                                                  | `w++`       |
| **`--`**     | Decreases the variable's value by 1.                                                  | `w--`       |

#### 2.4 String Interpolation with Template Literals

In ES6 JavaScript, template literals allow for easier and more readable string interpolation by using backticks (\`) instead of quotes. Variables can be inserted directly into strings using placeholders within the template literal, enhancing code readability and making it clearer how the final string will be constructed.

```javascript
let name = 'Eli';
let age = 24;
let message = `Hello, my name is ${name} and I am ${age} years old.`;
console.log(message); // Outputs: Hello, my name is Eli and I am 24 years old.
```

#### 2.5 Check Data Types

In JavaScript, the `typeof` operator is useful for determining the data type of a variable's value. By applying `typeof` to a variable, it returns a string representing the type of the value, helping developers verify and manage data types in their code.

```javascript
let age = 25;
let name = 'Alice';
let isActive = true;

console.log(typeof age);     // Outputs: "number"
console.log(typeof name);    // Outputs: "string"
console.log(typeof isActive);// Outputs: "boolean"
```

## 3. Conditional Statements

#### 3.1 Comparison Operators

Comparison operators in JavaScript are used to compare values and return a boolean result of `true` or `false`. This table outlines the basic comparison operators used to evaluate conditions and compare values in JavaScript.

| **Operator** | **Description**                  | **Example** |
| ------------ | -------------------------------- | ----------- |
| **`<`**      | Less than                        | `5 < 10`    |
| **`>`**      | Greater than                     | `10 > 5`    |
| **`<=`**     | Less than or equal to            | `5 <= 5`    |
| **`>=`**     | Greater than or equal to         | `10 >= 5`   |
| **`===`**    | Equal to (strict comparison)     | `5 === 5`   |
| **`!==`**    | Not equal to (strict comparison) | `5 !== 10`  |

#### 3.2 Logical Operators

Logical operators in JavaScript enable more complex conditional logic by working with boolean values. This table outlines how each logical operator functions in boolean expressions and conditionals.

| **Operator** | **Description**                                                     | **Example**      |
| ------------ | ------------------------------------------------------------------- | ---------------- |
| `&&`         | Logical AND; true if both conditions are true                       | `true && false`  |
| `\||`        | Logical OR; true if at least one of both conditions evaluates true. | `true \|| false` |
| `!`          | Logical NOT; negates the boolean value                              | `!true`          |

#### 3.3 Conditional Statements

Conditional statements in JavaScript use `if`, `else if`, and `else` to execute code based on whether specific conditions are true or false. An `if` statement runs code if a condition is true, an `else` statement provides alternative code if the condition is false, and `else if` allows for additional conditions to be tested before reaching the `else` block.

```javascript
let temperature = 25;

if (temperature > 30) {
    console.log("It's hot outside.");
} else if (temperature > 20) {
    console.log("It's warm outside.");
} else {
    console.log("It's cool outside.");
}
// Output: "It's warm outside."
```

#### 3.4 Truthy and Falsy Values

In JavaScript, variables can be evaluated as either truthy or falsy in conditional statements. Truthy values are those that evaluate to true in a boolean context, while falsy values—including `0`, empty strings (`""` or `''`), `null`, `undefined`, and `NaN`—evaluate to false when checked in conditions.

```javascript
let myVariable = 'Hello';

if (myVariable) {
    console.log("Variable is truthy."); // This will run because 'Hello' is a truthy value.
} else {
    console.log("Variable is falsy.");
}

let anotherVariable = 0;

if (anotherVariable) {
    console.log("Another variable is truthy.");
} else {
    console.log("Another variable is falsy."); // This will run because 0 is a falsy value.
}
```

#### 3.5 Short-Circuit Evaluation with Logical Operators

Short-circuit evaluation in JavaScript occurs when logical operators, such as `||` (OR), are used to simplify conditional logic. When using `||`, JavaScript evaluates the left-hand operand first and, if it is truthy, it returns that value immediately without evaluating the right-hand operand. This allows for concise code where default values are assigned only if the initial value is falsy.

```javascript
let username = '';
let defaultName = username || 'Stranger';

console.log(defaultName); // Output: Stranger
```

In this example, `defaultName` is assigned `'Stranger'` because `username` is an empty string (falsy). The `||` operator short-circuits, skipping the right-hand operand and assigning `'Stranger'` directly.

#### 3.6 Ternary Operator

The ternary operator in JavaScript offers a concise way to perform conditional logic, serving as a shorthand for `if...else` statements. It consists of a condition followed by `?`, then two expressions separated by a `:`, where the first expression executes if the condition is true, and the second executes if the condition is false.

```javascript
let age = 18;
let status = age >= 18 ? 'Adult' : 'Minor';

console.log(status); // Output: Adult
```

#### 3.7 Switch Statements

A `switch` statement in JavaScript provides a more readable alternative to multiple `else if` conditions when handling multiple cases. It evaluates an expression and executes the code block corresponding to the matched `case` value. If no cases match, the `default` block executes. Each `case` must end with a `break` statement to prevent fall-through to subsequent cases, ensuring only the matched case executes.

```javascript
let fruit = 'apple';

switch (fruit) {
  case 'banana':
    console.log('Yellow fruit');
    break;
  case 'apple':
    console.log('Red or green fruit');
    break;
  case 'grape':
    console.log('Purple fruit');
    break;
  default:
    console.log('Unknown fruit');
    break;
}

// Output: Red or green fruit
```

## 4. Functions

#### 4.1 Function Declaration

In JavaScript, a function declaration creates a function and binds it to a name or identifier, but the code inside the function only executes when the function is called. A function declaration includes the `function` keyword, the function's name, and a block of code enclosed in curly braces `{ }` that defines the task to be performed. The function runs only when you call it by its name followed by parentheses.

```javascript
// Function declaration
function greet() {
  console.log('Hello, world!');
}

// Calling the function
greet(); // Output: Hello, world!
```

#### 4.2 Parameters and Default Values

In JavaScript, functions can accept inputs through parameters, which are placeholders for values (arguments) passed during a function call. The order of arguments must match the order of parameters. Additionally, default parameters allow functions to use predefined values if no argument or an undefined value is provided, ensuring the function operates correctly even without all expected inputs.

```javascript
function greet(name = 'Stranger') {
  console.log(`Hello, ${name}!`);
}

greet('Eli');  // Output: Hello, Eli!
greet();       // Output: Hello, Stranger!
```

#### 4.3 Returning Values

In JavaScript, the `return` statement is used within a function to pass back a value, effectively stopping the function's execution at that point. This allows functions to produce outputs that can be stored in variables for later use, making the function's results accessible outside its scope.

```javascript
function add(a, b) {
  return a + b;
}

let sum = add(5, 3);  // sum now holds the value 8
console.log(sum);     // Output: 8
```

#### 4.4 Function Expressions

A function expression allows you to define a function without a name, known as an anonymous function, and store it in a variable. This variable then acts as the identifier for the function. Function expressions are typically declared using the `const` keyword, and you can invoke the function by referencing the variable name followed by parentheses containing any arguments.

```javascript
const greet = function(name) {
  return `Hello, ${name}!`;
};

console.log(greet('Alice')); // Output: Hello, Alice!
```

#### 4.5 Arrow Function Syntax

Arrow functions in JavaScript provide a compact syntax for writing functions using the `=>` notation, which replaces the traditional `function` keyword. They can be further refined using concise body syntax, where functions with a single parameter can omit parentheses, and single-line functions can skip curly braces and the `return` keyword, leveraging implicit returns for a more streamlined approach.

```javascript
// Standard arrow function with multiple parameters
const multiply = (a, b) => {
  return a * b;
};

// Refactored arrow function with implicit return and parentheses (multiple parameters)
const multiply = (a, b) => a * b;

// Arrow function with a single parameter, without parentheses
const double = n => n * 2;

// Arrow function with no parameters requires parentheses
const greet = () => 'Hello, World!';

// Invoking the functions
console.log(multiply(4, 5)); // Output: 20
console.log(double(3));      // Output: 6
console.log(greet());        // Output: Hello, World!
```

## 5. Scope

#### 5.1 Understanding Scope

Scope in programming defines where variables are accessible. It determines whether a variable is available throughout the entire program or restricted to a specific block of code, such as within a function or conditional statement. Blocks, denoted by curly braces `{}`, manage variable scope by grouping statements.

1. **Global Scope**: Variables declared outside any function or block are accessible throughout the program.

2. **Block Scope**: Variables declared within a block (e.g., inside loops or conditionals) are only accessible within that block.

```javascript
// Global scope variable
let globalVar = 'I am global';

function exampleFunction() {
  // Block scope variable
  let localVar = 'I am local';
  console.log(globalVar); // Accessible
  console.log(localVar);  // Accessible
}

exampleFunction();

console.log(globalVar); // Accessible
console.log(localVar);  // Error: localVar is not defined
```

### 5.2 Global Scope and Scope Pollution

Global variables, declared in the global namespace, are accessible anywhere in the program. However, excessive use can lead to scope pollution, where the global namespace becomes cluttered, causing potential variable collisions and unpredictable behavior, making the code harder to manage.

```javascript
var globalVar = 'Global';

function testScope() {
    var globalVar = 'Local'; // Shadows the global variable
    console.log(globalVar);  // Logs: Local
}

testScope();
console.log(globalVar); // Logs: Global
```

### 5.3 Benefits of Block Scope

Using block scope limits variable visibility to specific blocks, reducing issues with global variables and scope pollution. This practice enhances code readability, modularity, and maintainability, ensuring variables are only present where needed and conserving memory.

```javascript
function calculate() {
    let result = 5;
    if (result > 0) {
        let message = 'Positive number';
        console.log(message); // Accessible here
    }
    console.log(result); // Accessible here
    console.log(message); // Error: message is not defined
}
```

## X. Web Development with JavaScript

#### X.1 Using JavaScript in the Web Browser Developer Console

JavaScript, alongside HTML and CSS, is a fundamental language in web development. While JS code is typically embedded in HTML using the `<script>` element, modern browsers offer a console through their developer tools for executing JS code directly. This console acts as a REPL (Read-Evaluate-Print-Loop), allowing developers to test and debug code by interacting with the page's DOM (Document Object Model) and logging output. It also displays messages logged by JS code and information on network requests and security errors.

To open the developer console, you usually right-click on a webpage and select "Inspect" or "Inspect Element," then navigate to the "Console" tab. On Windows, you can access it via the Settings and more (3-dot icon) > More tools > Developer tools, and then click on the Console tab. The console is valuable for running JS code both independently and in relation to the page content. It facilitates quick testing and temporary modifications, with changes disappearing upon a page refresh, which is ideal for testing without altering the actual code.

#### X.2 JavaScript Runtime Environments

A runtime is a system that translates code written in a high-level, human-readable programming language into machine code that a computer can execute. It will determine where the programs run and the global objects and functions it can access during execution. JavaScript traditionally runs in a **browser's runtime environment**, where it powers front-end applications with access to browser-specific features like the `window` object. However, with the creation of the **Node runtime environment** in 2009, JavaScript can now also be used for back-end development. Node enables JavaScript to run outside the browser, providing access to server-side features such as the file system, databases, and networks. These distinct environments define the differences between front-end and back-end JavaScript applications.

#### X.3 Setting Up Node.js and Starting a JavaScript Project

To set up the Node.js environment on your computer, start by visiting the Node.js website and downloading the "LTS" (Long Term Support) version. After downloading, follow the installation instructions provided. Once installed, open a terminal window and verify the installation by running the command `node -v`, which should display the installed Node version.

Next, set up your JavaScript project using Visual Studio Code (VS Code). First, open VS Code and navigate to your projects folder via the file manager or terminal. Open the project folder in VS Code by selecting it from the Explorer pane. To create a new JavaScript file, click the ‘New File’ icon next to your project folder name, and name your file with the `.js` extension.

You can now start coding in your new file. If the file has the correct `.js` extension and your code is error-free, VS Code will display appropriate syntax highlighting. To run your JavaScript program, use the terminal by entering the command `node filename.js`, where "filename.js" is the name of your file. You can run this command in either your system terminal or VS Code’s integrated terminal.
