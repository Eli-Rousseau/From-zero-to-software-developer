# JavaScript

## 1. Introduction to JavaScript

#### 1.1 The Evolution and Versatility of JavaScript

JavaScript is one of the most widely used programming languages, initially created to add dynamic features to webpages. Over time, its application has expanded significantly, now enabling the development of full-fledged web and mobile apps, real-time networking applications, command-line tools, and even games. Originally, JavaScript code could only be executed within web browsers, each equipped with a JavaScript engine. However, with the introduction of Node.js—a C++ program incorporating Chrome's open-source JavaScript engine—developers can now run JavaScript outside of browsers, allowing for backend development. JavaScript adheres to the ECMAScript specification, a set of standards defined by the ECMA organization, with significant updates such as ES2015 (ES6) shaping the language's modern capabilities.

#### 1.2 Setting Up a JavaScript Development Environment

To run JavaScript code, it's essential to first set up a development environment, starting with a code editor like Visual Studio Code. Installing Node.js, a JavaScript engine, is also recommended as it allows for running JavaScript outside of a browser and managing third-party libraries. 

In HTML documents, JavaScript can be included using `<script>` elements, which should ideally be placed at the end of the body section to ensure the code runs after the webpage content is fully loaded. Although JavaScript can be written directly within HTML, it's better practice to separate concerns by placing JavaScript code in separate `.js` files and linking them using the `src` attribute in the script element. Additionally, JavaScript code can be executed outside of HTML files using Node.js, which allows code execution directly from a terminal.

## 2. Variables

#### 2.1 Declaring and Initializing Variables

In programming, variables are used to temporarily store data in a computer's memory. A variable represents a memory location that is given a specific name, allowing data at that location to be accessed or modified later. In JavaScript, prior to ES6, the `var` keyword was commonly used to declare variables. However, since ES6, it is considered best practice to use the `let` keyword for variable declaration. A variable can be declared using `let` followed by the variable name, and it is typically ended with a semicolon. By default, if no value is assigned, the variable holds an `undefined` value. To assign a value, use the `=` operator after the variable name.

```javascript
// Declaring a variable without assigning a value
let myVariable; // myVariable is undefined

// Declaring and assigning a value to the variable
let myVariable = 10; // myVariable now holds the value 10
```

#### 2.2 Rules for Naming Variables

Here are common rules for naming variables:

- Cannot be a reserved keyword (e.g., `let`, `function`, `if`).
- Should be meaningful to describe the purpose or content of the variable.
- Cannot start with a number.
- Cannot contain spaces or hyphens.
- Names are case-sensitive (`myVariable` and `myvariable` are different).
- Follow camelCase notation: the first word is lowercase, and subsequent words start with an uppercase letter (e.g., `myVariableName`).

#### 2.3 Constants

In JavaScript, some variables are intended to remain constant throughout the application, meaning their values should not change once assigned. To declare such variables, the `const` keyword is used instead of `let`. Attempting to reassign a value to a `const` variable will result in an error, ensuring the value remains unchanged.

```javascript
// Declaring a constant variable
const myConstant = 100;

// Attempting to reassign will cause an error
myConstant = 200; // Error: Assignment to constant variable
```

#### 2.4 Variable Scope

In JavaScript, the scope of a variable or constant defines the context in which it is accessible within a program. Variables declared with `let` or `const` are block-scoped, meaning they are only accessible within the block (e.g., a loop, function, or conditional) where they are defined. This is known as local scope.

On the other hand, variables declared outside of any block have a global scope, making them accessible throughout the entire program. However, defining global variables is generally considered bad practice because they can inadvertently override local variables, leading to unpredictable behavior in your code. By keeping variables as local as possible, you minimize potential conflicts and maintain better control over the program's state.

## 3. Data Types

#### 3.1 Primitive Data Types

In JavaScript, the values that can be stored in variables are classified into types. These types determine the kind of data a variable can hold. JavaScript has two main categories of types: primitive types and reference types. Primitive types are the most basic data types and include:

| **Primitive Type** | **Description**                                                       | **Example Values**        |
| ------------------ | --------------------------------------------------------------------- | ------------------------- |
| **String**         | Represents text or a sequence of characters.                          | `"Hello, World!"`, `"42"` |
| **Number**         | Represents numeric values, including integers and floats.             | `42`, `3.14`              |
| **Boolean**        | Represents a logical entity with two possible values.                 | `true`, `false`           |
| **undefined**      | Indicates that a variable has been declared but not assigned a value. | `undefined`               |
| **null**           | Represents the intentional absence of any object value.               | `null`                    |
| **Symbol**         | Represents a unique identifier, often used for object properties.     | `Symbol('id')`            |

#### 3.2 Dynamic Typing

JavaScript is a dynamically typed language, which means that the type of a variable can change during runtime. This flexibility allows a variable to hold different types of values at different times. You can check the type of a variable using the `typeof` operator, which returns a string indicating the type of the variable's current value.

```javascript
// Example of dynamic typing
let myVariable = 42;          // Initially a Number
console.log(typeof myVariable); // Output: "number"

myVariable = "Hello, World!"; // Now a String
console.log(typeof myVariable); // Output: "string"
```

#### 3.3 Reference Data Types

In JavaScript, reference types are used to store collections of data and more complex entities. Unlike primitive types, reference types do not hold the actual value directly but rather a reference to the location in memory where the data is stored. The primary reference types in JavaScript are `Object`, `Array`, and `Function`.

| **Reference Type** | **Description**                                                                                 | **Example Values**                           |
| ------------------ | ----------------------------------------------------------------------------------------------- | -------------------------------------------- |
| **Object**         | Represents a collection of key-value pairs, where values can be of any type.                    | `{ name: "Alice", age: 25 }`                 |
| **Array**          | Represents an ordered list of elements, which can be of any type.                               | `[1, 2, 3]`, `["apple", "banana", "cherry"]` |
| **Function**       | Represents a block of code designed to perform a specific task and can be executed when called. | `function greet() { return "Hello"; }`       |

###### 2.6.1 Functions

A function in JavaScript is a block of code designed to perform a specific task or calculate a value. To declare a function, use the `function` keyword followed by the function's name, parentheses for parameters, and curly braces to enclose the function's logic. Functions can accept input through parameters, which are specified in the function definition and passed as arguments when calling the function. The `return` keyword is used to send a value back to the caller after execution.

```javascript
// Declaring a function
function addNumbers(a, b) {
  return a + b; // Returning the sum of a and b
}

// Calling the function with arguments
const result = addNumbers(5, 3); // result is 8
console.log(result); // Output: 8
```

## 4. Operators

#### 4.1 Arithmetic Operators

Arithmetic operators are symbols used to perform basic mathematical operations on numbers. They allow for calculations such as addition, subtraction, multiplication, and more.

| **Operator** | **Description**                                                   |
| ------------ | ----------------------------------------------------------------- |
| `+`          | Addition: Adds two values                                         |
| `-`          | Subtraction: Subtracts the second value from the first            |
| `*`          | Multiplication: Multiplies two values                             |
| `/`          | Division: Divides the first value by the second                   |
| `%`          | Modulus: Returns the remainder of division                        |
| `**`         | Exponentiation: Raises the first value to the power of the second |
| `++`         | Increment: Increases a value by one                               |
| `--`         | Decrement: Decreases a value by one                               |

#### 4.2 Assignment Operators

Assignment operators are used to assign values to variables and can also perform arithmetic operations simultaneously. They combine the assignment of a value with an arithmetic operation to update the variable.

| **Operator** | **Description**                                                                         |
| ------------ | --------------------------------------------------------------------------------------- |
| `=`          | Assignment: Assigns a value to a variable                                               |
| `+=`         | Addition Assignment: Adds a value to the variable and assigns the result                |
| `-=`         | Subtraction Assignment: Subtracts a value from the variable and assigns the result      |
| `*=`         | Multiplication Assignment: Multiplies the variable by a value and assigns the result    |
| `/=`         | Division Assignment: Divides the variable by a value and assigns the result             |
| `%=`         | Modulus Assignment: Takes the modulus of the variable by a value and assigns the result |

#### 4.3 Comparison Operators

Comparison operators are used to compare two values and determine their relationship, such as whether one value is greater than, less than, or equal to another. They return a boolean value (`true` or `false`) based on the result of the comparison.

| **Operator** | **Description**                                                                                |
| ------------ | ---------------------------------------------------------------------------------------------- |
| `>`          | Greater than: Checks if the left value is greater than the right value                         |
| `>=`         | Greater than or equal to: Checks if the left value is greater than or equal to the right value |
| `<`          | Less than: Checks if the left value is less than the right value                               |
| `<=`         | Less than or equal to: Checks if the left value is less than or equal to the right value       |
| `===`        | Strict equality: Checks if two values are equal and of the same type                           |
| `!==`        | Strict inequality: Checks if two values are not equal or not of the same type                  |
| `==`         | Loose equality: Checks if both values are equal after type conversion                          |

#### 4.4 Logical Operators

Logical operators are used to combine or negate boolean values and expressions, allowing for more complex conditions in logical statements. They evaluate expressions to return a boolean result based on the logical relationships between operands.

| **Operator** | **Description**                                         |
| ------------ | ------------------------------------------------------- |
| `&&`         | Logical AND: Returns `true` if both operands are `true` |
| `\|          | `                                                       |
| `!`          | Logical NOT: Negates the boolean value of the operand   |

###### 4.4.1 Truthy/Falsy Values

In JavaScript, logical operators can be used with non-boolean values as well, and the result of a logical expression depends on the operands' values. When operands are not boolean, they are evaluated as either "truthy" or "falsy." Falsy values include `undefined`, `null`, `0`, `false`, `''` (empty string), and `NaN`. These values are treated as false in logical expressions. Any value that is not falsy is considered truthy. The result of a logical expression will be the actual value of the operand rather than a strict boolean `true` or `false`. For example, the logical OR (`||`) operator can be used for short-circuit evaluation to provide default values.

```javascript
// Example of truthy and falsy values
const value1 = 0 || 'default';  // 0 is falsy, so 'default' is returned
const value2 = 'hello' || 'default'; // 'hello' is truthy, so 'hello' is returned

console.log(value1); // Output: 'default'
console.log(value2); // Output: 'hello'
```

#### 4.5 Operator Precedence

In JavaScript, operator precedence determines the order in which operators are evaluated in complex expressions. Higher-precedence operators are evaluated before lower-precedence ones. To control the evaluation order explicitly, you can use parentheses to group parts of an expression, ensuring that operations within parentheses are performed first, regardless of the default precedence rules.

```javascript
// Example of operator precedence and parentheses
const result = 5 + 3 * 2;      // Without parentheses, multiplication is evaluated first
console.log(result); // Output: 11

const adjustedResult = (5 + 3) * 2; // Parentheses ensure addition is evaluated before multiplication
console.log(adjustedResult); // Output: 16
```

## 5. Control Flow

#### 5.1 Conditional Statements

###### 5.1.1 If...else

`if...else` conditional statements are used to execute different blocks of code based on whether a specified condition evaluates to `true` or `false`. They allow for branching logic in a program, enabling different outcomes based on various conditions.

```javascript
if (condition) {
  // Execute code if first condition is true
} else if (anotherCondition) {
  // Execute code if second condition is true
} else {
  // Execute code if one of the condition is true
}
```

###### 5.1.2 Ternary Operators

The ternary operator is a shorthand way to perform a conditional check and choose between two values based on the result. It takes the form `condition ? valueIfTrue : valueIfFalse`, where the `condition` is evaluated, and if it's `true`, `valueIfTrue` is returned; otherwise, `valueIfFalse` is returned.

###### 5.1.3 Switch...case

`switch...case` conditional statements are used to select one of many code blocks to execute based on the value of an expression. This approach is useful for handling multiple conditions that are based on the same variable.

```javascript
switch (variable) {
  case value1:
    // Execute code if first condition is true
    break;
  case value2:
    // Execute code if second condition is true
    break;
  case value3:
    // Execute code if third condition is true
    break;
  default:
    // Execute code if none of the condition is true
    break;
}
```

#### 5.2 Loops

###### 5.2.1 For

A `for` loop in JavaScript is used to repeatedly execute a block of code a specific number of times, based on a loop control variable. It consists of an initialization, a condition, and an iteration expression, which together control the loop's execution.

```javascript
for (initialization; condition; iteration) {
  // Code to be executed
}
```

###### 5.2.2 While

A `while` loop in JavaScript repeatedly executes a block of code as long as a specified condition evaluates to `true`. The condition is checked before each iteration, and if it becomes `false`, the loop terminates.

```javascript
while (condition) {
  // Code to be executed
}
```

###### 5.2.3 Do...while

A `do...while` loop in JavaScript executes a block of code once before checking a condition, and then repeatedly executes the block as long as the condition remains `true`. This guarantees that the code block will run at least once, regardless of the condition.

```javascript
do {
  // Code to be executed
} while (condition);
```

###### 5.2.4 For...in

A `for...in` loop in JavaScript is used to iterate over the enumerable properties of an object, allowing access to each key and its corresponding value. To access the values, you use bracket notation with the property keys.

```javascript
for (const key in object) {
  // Code to be executed
  const value = object[key];
}
```

###### 5.2.5 For...of

A `for...of` loop in JavaScript is used to iterate over the elements of an iterable object, such as an array, allowing direct access to each element. It simplifies the process of iterating through arrays compared to traditional `for` loops.

```javascript
for (const element of iterable) {
  // Code to be executed
}
```

###### 5.2.6 Break and Continue Keywords

In JavaScript, the `break` keyword is used to exit a loop prematurely, stopping further iterations and continuing execution with the code following the loop. The `continue` keyword skips the remaining code in the current iteration of the loop and proceeds with the next iteration. These keywords help control the flow of execution within loops based on specific conditions.

## 6. Objects

#### 6.1 Creating and Working with Objects

In JavaScript, an object is a collection of key-value pairs, where each key (property) represents a characteristic of the object. You can create an object using the `let` or `const` keyword, followed by the object name, and define its properties within curly braces. The property values can be of any data type, including other objects, arrays, or functions. When a function is part of an object, it is referred to as a method, which is a key concept in object-oriented programming (OOP). Properties of an object can be accessed or modified using either dot notation or bracket notation.

```javascript
// Example of creating an object and accessing its properties
const car = {
  make: 'Toyota',
  model: 'Camry',
  year: 2021,
  start: function() {
    console.log('Car started');
  }
};

// Accessing properties
console.log(car.make); // Dot notation: Output - 'Toyota'
console.log(car['model']); // Bracket notation: Output - 'Camry'

// Calling a method
car.start(); // Output - 'Car started'
```

#### 6.2 Factory Functions

Factory functions in JavaScript are used to create and return new object instances. They are particularly useful for producing multiple objects that share the same structure or behavior. By passing parameters to a factory function, you can customize the properties of the created objects. JavaScript also provides a concise syntax for defining properties when the parameter name matches the object property name, as well as for defining methods without using the `function` keyword.

```javascript
// Example of a factory function
function createCar(make, model, year) {
  return {
    make,         // Concise property syntax (make: make)
    model,        // Concise property syntax (model: model)
    year,         // Concise property syntax (year: year)
    start() {     // Method shorthand (start: function() {...})
      console.log('Car started');
    }
  };
}

// Creating an object using the factory function
const myCar = createCar('Toyota', 'Camry', 2021);

console.log(myCar.make); // Output: 'Toyota'
myCar.start();           // Output: 'Car started'
```

#### 6.3 Constructor Functions

Constructor functions in JavaScript are a way to create objects by defining their properties and methods using the `this` keyword, which refers to the instance being created. When using a constructor function, the `new` operator is required to instantiate the object. The `new` keyword ensures that an empty object is created, `this` is bound to that object, and the object is returned from the constructor function. Unlike factory functions, which use camelCase, constructor functions should follow PascalCase notation.

```javascript
// Example of a constructor function
function Car(make, model, year) {
  this.make = make;
  this.model = model;
  this.year = year;
  this.start = function() {
    console.log('Car started');
  };
}

// Creating an object using the constructor function
const myCar = new Car('Toyota', 'Camry', 2021);

console.log(myCar.make); // Output: 'Toyota'
myCar.start();           // Output: 'Car started'
```

#### 6.4 Dynamic Behavior of Objects

In JavaScript, objects are dynamic, allowing you to add new properties and methods even after the object has been created. Additionally, you can remove properties or methods from an object using the `delete` operator, providing flexibility to modify the object's structure as needed during runtime.

```javascript
// Creating an object
const car = {
  make: 'Toyota',
  model: 'Camry',
  year: 2021
};

// Adding a new property
car.color = 'red';
console.log(car.color); // Output: 'red'

// Adding a new method
car.start = function() {
  console.log('Car started');
};
car.start(); // Output: 'Car started'

// Deleting a property
delete car.year;
console.log(car.year); // Output: undefined
```

#### 6.5 Constructor Property in Objects

In JavaScript, every object has a `constructor` property that references the function used to create the object. This property points to the function that constructed the instance, whether it's a custom constructor function or a built-in one. When objects are created using literal syntax, JavaScript internally uses built-in constructor functions like `Object()`, `String()`, `Number()`, or `Boolean()`. Although these built-in constructors exist, developers typically use literal syntax (e.g., `""` for strings, `0` for numbers) rather than invoking the constructors directly.

```javascript
// Object literal syntax
let literalObject = {name: "Eli", age: 24};
console.log(literalObject); // Output: ƒ Object() { [native code] }

// Built-in Object constructor function
let constObject = new Object({name: "Eli", age: 24});
```

#### 6.6 Functions as Objects

In JavaScript, functions are treated as first-class objects, meaning they not only perform actions but also possess properties and methods. Key properties include `name`, which holds the function's name, and `length`, which indicates the number of parameters the function expects. Functions also have a `constructor` property that references the buit-in `Function` constructor used to create them. Additionally, methods like `call()` and `apply()` allow for invoking functions with a specified `this` context and arguments, providing flexibility in how functions are executed.

#### 6.7 Primitive vs Reference Types

In JavaScript, primitive and reference types differ in how they are stored and assigned in memory. 

- **Primitive Types**: When you assign a primitive type (such as a string, number, or boolean) to a variable, the actual value is stored directly in the memory associated with that variable. Each variable holding a primitive type has its own independent copy of the value. This means that if you copy a primitive value from one variable to another, the two variables hold separate, independent values.

- **Reference Types**: Reference types (such as objects, arrays, and functions) work differently. When you assign a reference type to a variable, you're not assigning the actual data, but rather a reference or address pointing to the data in memory. Multiple variables can reference the same object in memory, meaning that changes made through one variable are reflected in all variables pointing to that object. This also means that copying a reference type variable copies the reference, not the actual object.

#### 6.8 Iterating Over Object Properties

In JavaScript, there are multiple ways to iterate over the key-value pairs of an object. The `for...in` loop is a straightforward method that iterates over all enumerable properties of an object, with each iteration providing access to a property key. Alternatively, you can use the `for...of` loop in combination with `Object.keys()` to iterate over the keys of an object. Additionally, the `in` operator can be used to check if a specific key exists in an object.

```javascript
const person = { name: 'Alice', age: 25, city: 'New York' };

// Using for...in loop
for (let key in person) {
  console.log(key, person[key]); // Output: 'name Alice', 'age 25', 'city New York'
}

// Using for...of loop with Object.keys()
for (let key of Object.keys(person)) {
  console.log(key, person[key]); // Output: 'name Alice', 'age 25', 'city New York'
}

// Checking for a key using the in operator
console.log('age' in person); // Output: true
```

#### 6.9 Creating a Copy of an Object

In JavaScript, you can create a shallow copy of an object by using the spread operator (`...`). This operator allows you to copy all the properties of an existing object into a new object. The spread operator copies the property values, but if these values are themselves reference types (like objects or arrays), only the references are copied, not the actual nested objects.

```javascript
// Original object
const original = { name: 'Alice', age: 25, city: 'New York' };

// Creating a copy using the spread operator
const copy = { ...original };

console.log(copy); // Output: { name: 'Alice', age: 25, city: 'New York' }

// Modifying the copy
copy.age = 30;

console.log(original.age); // Output: 25 (original remains unchanged)
console.log(copy.age);     // Output: 30 (copy is independent of the original)
```

#### 6.10 Private Properties and Methods

In JavaScript, abstraction can be achieved by making properties and methods private within a constructor function. Instead of using the `this` keyword, which would expose properties and methods as part of the object’s public interface, you can define them as local variables or constants within the constructor. These private members can still be accessed by other methods within the object due to JavaScript’s **closure mechanism**. Closures allow an inner function to access variables from its parent function, preserving the state of these variables even after the parent function has completed execution. This distinction between scope and closure is vital: while scope is temporary and reinitializes with each function call, closure retains the state of variables across multiple invocations.

```javascript
function User(name, password) {
    // Private properties
    const _name = name;
    const _password = password;

    // Public method
    this.getName = function() {
        return _name;
    };

    // Private method
    function validatePassword(input) {
        return input === _password;
    }

    // Public method
    this.login = function(inputPassword) {
        return validatePassword(inputPassword) ? "Login succesfull" : "Invalid password";
    };
}

const user = new User("Eli", "secret123");
console.log(user.getName()); // Outputs: Eli
console.log(user.login("secret123")); // Outputs: Login successful!
console.log(user._password); // Undefined, private property is not accessible
```

#### 6.11 Setters and Getters

In JavaScript, getters and setters are special methods that provide controlled access and modification of object properties. Getters allow you to retrieve or access the value of a property, while setters allow you to change or mutate that value. These methods are essential for encapsulating and protecting the internal state of an object, enabling you to enforce specific logic when properties are accessed or modified.

To define a getter or setter in a constructor function, you can use the `Object.defineProperty()` method. This method takes three arguments: the object on which the property is being defined, the name of the property, and an object specifying the `get` and/or `set` methods. By using getters and setters, you can manage the behavior of private properties while still allowing them to be accessed or modified in a controlled way.

```javascript
function Person(name) {
    // Private property
    let _name = name;

    // Getter and Setter for the 'name' property
    Object.defineProperty(this, 'name', {
        get: function() {
            return _name;
        },
        set: function(newName) {
            if (newName.length <= 0)
                throw new Error("Name cannot be empty.");
            _name = newName;
        }
    });
}

const person = new Person("Eli");
console.log(person.name);  // Outputs: Eli
person.name = "";  // Error: Name cannot be empty.
```

#### 6.12 Garbage Collector

JavaScript automatically handles memory management through a process called garbage collection. This built-in mechanism identifies variables and constants that are no longer in use by the program and deallocates the memory they occupy. Garbage collection runs in the background, freeing developers from the need to manually manage memory, allowing them to focus on writing code without worrying about potential memory leaks.

#### 6.13 Learning about Built-in Objects

For detailed information on methods and properties from built-in functions like `String`, `Math`, `Date`, and many more, the [MDN Web Docs](https://developer.mozilla.org/en-US/) is a valuable resource.

#### 6.14 Template Literals for String Formatting

Template literals in JavaScript, denoted by backticks (`` ` ``), offer a powerful way to create and format strings. Unlike traditional string literals, template literals allow for multi-line strings and the inclusion of expressions within the string using placeholders (`${}`), making string formatting more flexible and readable. This feature is especially useful for including dynamic content and maintaining proper formatting in your strings.

```javascript
// Example of a template literal
const name = "Eli";
const message = `Hello, ${name}!
Welcome to the world of JavaScript.`;

console.log(message);
// Output: 
// Hello, Eli!
// Welcome to the world of JavaScript.
```

## 7. Arrays

#### 7.1 Creating and Accessing Array Elements

In JavaScript, arrays are used to store collections of elements, which can include objects, numbers, strings, and more. An array is initialized by declaring a variable with the `let` or `const` keyword, followed by assigning the array using square brackets `[]`, with elements separated by commas. Arrays use a zero-based index to determine the position of each element, allowing access through index values within square brackets. Both the length and type of elements in an array are dynamic, meaning they can change during runtime.

Arrays are technically objects, meaning they possess properties and methods accessible through dot or bracket notation. For example, the `length` property of an array returns the number of elements it contains.

```javascript
// Initializing an array
const fruits = ["apple", "banana", "cherry"];

// Accessing elements by index
console.log(fruits[0]); // Output: "apple"

// Accessing the length property
console.log(fruits.length); // Output: 3
```

#### 7.2 Adding New Elements

In JavaScript, there are several methods available for adding elements to an array. 

| Method      | Description                                                                                  |
| ----------- | -------------------------------------------------------------------------------------------- |
| `push()`    | Adds one or more elements to the end of an array.                                            |
| `unshift()` | Adds one or more elements to the start of an array, shifting existing elements to the right. |
| `splice()`  | Adds one or more elements at a specified index within the array.                             |

#### 7.3 Finding Elements

JavaScript provides various methods to find elements in an array, whether they are primitive or reference types. These methods allow for efficient searching and retrieval of elements based on specific criteria.

| Method          | Description                                                                                                                    | Usage for |
| --------------- | ------------------------------------------------------------------------------------------------------------------------------ | --------- |
| `indexOf()`     | Returns the index of the first occurrence of a primitive type in the array. If not found, returns `-1`.                        | Primitive |
| `lastIndexOf()` | Returns the index of the last occurrence of a primitive type in the array. If not found, returns `-1`.                         | Primitive |
| `includes()`    | Checks if a primitive type is present in the array, returning `true` or `false`.                                               | Primitive |
| `find()`        | Takes a callback function and returns the first element that satisfies the provided testing function (predicate).              | Reference |
| `findIndex()`   | Takes a callback function and returns the index of the first element that satisfies the provided testing function (predicate). | Reference |

#### 7.4 Removing Elements

In JavaScript, you can remove elements from an array using several methods, each serving different purposes depending on the position of the element you want to remove.

| **Method** | **Description**                                         |
| ---------- | ------------------------------------------------------- |
| `pop()`    | Removes and returns the last element of the array.      |
| `shift()`  | Removes and returns the first element of the array.     |
| `splice()` | Removes one or more elements starting at a given index. |

#### 7.5 Combining and Slicing

In JavaScript, arrays can be combined or split using specific methods designed for these purposes.

| **Method** | **Description**                                                                  |
| ---------- | -------------------------------------------------------------------------------- |
| `concat()` | Combines two or more arrays into a new array without altering the originals.     |
| `slice()`  | Extracts a portion of an array into a new array, without modifying the original. |

The spread operator (`...`) in JavaScript is a powerful tool for combining multiple arrays into a single array. It allows you to easily access and merge all the elements from different arrays.

```javascript
const first = [1, 2, 3];
const second = [4, 5, 6];
const combined = [...first, ...second];

console.log(combined); // Output: [1, 2, 3, 4, 5, 6]
```

#### 7.6 Join and Split

JavaScript provides methods to convert arrays to strings and vice versa.

| Method    | Description                                                                                               |
| --------- | --------------------------------------------------------------------------------------------------------- |
| `join()`  | Combines all elements of an array into a single string, using a specified separator between each element. |
| `split()` | Splits a string into an array of substrings based on a specified separator.                               |

#### 7.7 Sorting and Reversing

JavaScript provides methods to sort and reverse the order of array elements. When dealing with arrays of primitive types, these methods can be used directly. For arrays containing objects (reference types), a callback function should be provided to the `sort()` method to define the sorting logic.

| Method      | Description                                                                                                         |
| ----------- | ------------------------------------------------------------------------------------------------------------------- |
| `sort()`    | Sorts the elements of an array in place. For reference types, a callback function is needed to determine the order. |
| `reverse()` | Reverses the order of elements in an array in place.                                                                |

#### 7.8 Array Iteration Methods

###### 7.8.1 Iterating Over Arrays with `.forEach()`

The `.forEach()` method is a fundamental array iteration tool in JavaScript. It executes a provided callback function once for each element in an array. The current element is passed as a parameter to the callback, allowing you to perform operations on each element. This method does not return a new array or modify the original array, making it ideal for scenarios where side effects, like logging or updating external variables, are desired.

###### 7.8.2 Testing All Elements with `.every()`

The `.every()` method checks whether all elements in an array satisfy a condition specified by a callback function. If every element passes the test, `.every()` returns `true`; otherwise, it returns `false`. This method is useful for validating that all elements in an array meet a specific requirement, such as being of a certain type or value.

###### 7.8.3 Checking for Any Matching Element with `.some()`

The `.some()` method evaluates whether at least one element in an array meets a condition set by a callback function. If any element satisfies the condition, `.some()` returns `true`; if none do, it returns `false`. This method is helpful for quickly checking if an array contains elements that match a specific criterion without processing the entire array.

###### 7.8.4 Filtering Elements with `.filter()`

The `.filter()` method creates a new array containing only the elements that meet a condition defined by a callback function. The callback should return `true` for elements to be included in the new array and `false` for those to be excluded. This method is essential for extracting subsets of data from an array based on specific criteria.

###### 7.8.5 Transforming Elements with `.map()`

The `.map()` method is used to generate a new array by applying a callback function to each element of the original array. Unlike `.forEach()`, which simply executes the function, `.map()` returns an array of transformed elements. This method is perfect for scenarios where you need to create a modified version of an array, such as converting all elements to a different format or type.

###### 7.8.6 Accumulating Values with `.reduce()`

The `.reduce()` method processes an array by applying a callback function that accumulates a single output value from the array’s elements. The callback takes two arguments: an accumulator, which holds the accumulated result, and the current element. This method is powerful for tasks like summing numbers, concatenating strings, or merging array elements into a single result. It can also be initialized with an optional initial value for the accumulator.

## 8. Functions

#### 8.1 Declaring Functions

A function in JavaScript is a block of code designed to perform a specific task or calculate a value. To declare a function, use the `function` keyword followed by the function's name, parentheses for parameters, and curly braces to enclose the function's logic. Functions can accept input through parameters, which are specified in the function definition and passed as arguments when calling the function. The `return` keyword is used to send a value back to the caller after execution.

```javascript
// Declaring a function
function addNumbers(a, b) {
  return a + b; // Returning the sum of a and b
}

// Calling the function with arguments
const result = addNumbers(5, 3); // result is 8
console.log(result); // Output: 8
```

#### 8.2 Function Declarations vs. Function Expressions

In JavaScript, functions can be defined in two primary ways: 

1. A **function declaration** involves simply writing the `function` keyword followed by the function name and its body. This approach allows the function to be hoisted, meaning it can be invoked before it is actually defined in the code.
   
   ```javascript
   addNumbers(1, 2) // Call can be placed before declaration
   
   function addNumbers(a, b) {
     return a + b;
   }
   ```

2. A **function expression** involves assigning a function to a variable. This function can be anonymous, meaning it doesn’t have a name, and is invoked using the variable it’s assigned to. Unlike function declarations, function expressions are not hoisted, so they must be defined before they are called. This distinction between function declarations and expressions is crucial for understanding how JavaScript handles function execution and variable scope.
   
   ```javascript
   let addNumbers = function(a, b) {
       return a + b;
   };
   ```
   
   addNumbers(1, 2) // Call must be placed after expression 

```
#### 8.3 Arrow Functions

Arrow functions in JavaScript are a more concise way to write functions, introduced in ES6. Unlike regular functions, arrow functions do not have their own `this` context. Arrow functions can be written in various ways depending on the number of parameters and the complexity of the function body.

```javascript
// Regular Function
function add(a, b) {
 return a + b;
}

// Arrow Function with Multiple Parameters
const addArrow = (a, b) => {
 return a + b;
};

// Arrow Function with One Parameter
const square = x => {
 return x * x;
};

// Arrow Function with No Parameters
const greet = () => {
 return 'Hello World';
};

// Arrow Function with Single Line of Code in Body
const multiply = (a, b) => a * b;
```

#### 8.4 Variable Arguments in Functions

In JavaScript, every function has access to a special object called `arguments`, which holds key-value pairs representing the index and value of each argument passed to the function. This can be particularly useful when designing functions that need to handle an unknown number of arguments.

```javascript
function variableArgs() {
    console.log(arguments);
}

variableArgs('a', 'b', 'c'); // Output: { '0': 'a', '1': 'b', '2': 'c' }
```

For more flexibility with varying numbers of arguments, JavaScript provides the **rest operator** (`...`). By including the rest operator followed by a name like `args` in a function's parameter list, you can capture all the arguments passed to the function as an array. This makes it easier to work with functions that need to handle a variable number of inputs.

```javascript
function variableArgs(...args) {
    console.log(args);
}

variableArgs('a', 'b', 'c');Output: //  [ 'a', 'b', 'c' ]
```

#### 8.5 Setting Default Parameters

In JavaScript ES6, you can set default values for function parameters. This means that if no arguments are provided when the function is called, the default values will be used. Default parameters are particularly useful for making functions more flexible and preventing errors when not all arguments are supplied. It is a best practice to place default parameters at the end of the function's parameter list to avoid any confusion with positional arguments.

```javascript
// Function with default parameters
function greet(name = "Guest", greeting = "Hello") {
    console.log(`${greeting}, ${name}!`);
}

// Function calls with different arguments
greet();                      // Output: "Hello, Guest!"
greet("Eli");               // Output: "Hello, Eli!"
greet("Eli", "Good morning"); // Output: "Good morning, Eli!"
```

#### 8.6 Getters and Setters

In JavaScript, getters and setters are special types of functions within objects that allow controlled access and modification of object properties. 

- **Getters** are used to retrieve or access the value of an object's property. By prefixing a method with the `get` keyword, you create a getter method, which allows you to access the property as if it were a regular variable.

- **Setters** are used to change or mutate the value of an object's property. By prefixing a method with the `set` keyword, you create a setter method, which requires a parameter to update the property value.

```javascript
// Object with getter and setter methods
const person = {
    firstName: "Eli",
    lastName: "Rousseau",

    // Getter for fullName
    get fullName() {
        return `${this.firstName} ${this.lastName}`;
    },

    // Setter for fullName
    set fullName(name) {
        const parts = name.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }
};

// Accessing the fullName using the getter
console.log(person.fullName); // Output: "Eli Rousseau"

// Updating the fullName using the setter
person.fullName = "Jane Smith";

// Checking the updated values
console.log(person.firstName); // Output: "Eli"
console.log(person.lastName);  // Output: "Rousseau"
```

#### 8.7 Error Handling

Error handling is a defensive programming technique used to ensure that a program can gracefully manage unexpected situations, such as incorrect input or uninitialized variables. When an error is detected, an exception can be thrown, effectively halting normal program execution and allowing the error to be handled in a controlled manner.

In JavaScript, you can throw an error using the `Error()` constructor, which creates a new error object. This object can include a custom message that describes the error. To handle these exceptions, you use a `try...catch` block. The `try` block contains the code that might throw an exception, while the `catch` block contains the code that will execute if an exception is thrown, allowing you to handle the error gracefully—such as by displaying an error message to the user.

```javascript
// Function to demonstrate error handling
function divide(a, b) {
    try {
        // Check if the denominator is zero
        if (b === 0) {
            // Throw an error if division by zero is attempted
            throw new Error("Cannot divide by zero.");
        } else {
            return a / b;
        }
    } catch (error) {
        // Handle the error by logging it
        console.error("Error caught: " + error.message);
    }
}

// Example usage
const result = divide(10, 0); // This will throw and catch an error
```

#### 8.8 Understanding the `this` Keyword

###### 8.8.1 Scope

The `this` keyword in JavaScript is context-dependent and can refer to different objects depending on where and how it is used:

- **Global Context:** When used outside of any object, `this` refers to the global object. In a browser environment, this global object is the `Window` object, while in a Node.js environment, it is an empty global object.

- **Constructor Functions:** When using `this` inside a constructor function (invoked with the `new` keyword), it refers to the new, empty object being created by the constructor.

- **Object Methods:** Within a method of an object, `this` refers to the object that owns the method. This allows methods to access and manipulate the properties of their object.

###### 8.8.2 Inheritance

When `this` is used within a regular function nested inside an object method, it often refers to the global object rather than the object itself, which can lead to unexpected behavior. 

```javascript
const person = {
    name: 'Eli',
    greet: function() {
        const innerFunction = function() {
            console.log(`Hello, my name is ${this.name}`)
        };
        innerFunction();
    }
};

person.greet(); // Outputs: Hello, my name is undefined
```

However, arrow functions, introduced in ES6, do not have their own `this` context; instead, they inherit `this` from their enclosing lexical scope. This feature makes ensures that arrow functions will avoid issues related to the `this` keyword in nested functions.

```javascript
const person = {
    name: 'Eli',
    greet: function() {
        const innerFunction = () => {
            console.log(`Hello, my name is ${this.name}`);
        };
        innerFunction();
    }
};

person.greet(); // Outputs: Hello, my name is Eli
```

## 9. Object-Oriented Programming

#### 9.1 Introduction to Object-Oriented Programming

Object-Oriented Programming (OOP) is a programming paradigm that focuses on the use of objects rather than functions to structure software. It is widely supported by many programming languages, including JavaScript, and forms the basis for numerous frameworks. In OOP, related functions and data are combined into units called objects. This approach is organized around four core concepts:

1. **Encapsulation** involves grouping related properties and methods into single units, or objects. This leads to functions with fewer parameters, making them easier to use and maintain.

2. **Abstraction** simplifies the interface of an object by hiding its implementation details. By concealing certain properties and methods that are only relevant internally, abstraction makes the interface simpler and reduces the impact of changes to the object’s internal structure.

3. **Inheritance** allows objects to inherit properties and methods from other objects, preventing the duplication of code.

4. **Polymorphism** enables the same method to behave differently depending on the object it is acting upon. This technique helps eliminate long conditional statements (like if...else or switch...case) and allows for more flexible and dynamic code.

#### 9.2 Prototype

###### 9.2.1 Prototypical Inheritance

Inheritance in JavaScript allows objects to inherit properties and methods from other objects, facilitating code reuse and the sharing of functionality among different types of objects. Unlike classical inheritance in languages with classes, JavaScript uses prototypical inheritance, where objects inherit directly from other objects.

In this model, a derived (or child) object inherits from a base (or parent) object, which serves as its prototype. JavaScript objects can inherit from a single prototype, and by default, every object ultimately inherits from the base or root object, which provides common methods like `toString()` or `__proto__`. Note that the base object in JavaScript is the only object without a prototype, and it serves as the main prototype shared by all other objects in JavaScript. When accessing a property or method, JavaScript first looks for it on the object itself. If it's not found, the search continues up the prototype chain until the base object is reached, a process known as prototypical inheritance. This system ensures that objects can share common behavior while allowing for efficient code reuse.

In JavaScript, objects created by the same constructor function share the same prototype. For example, when you create an array, it inherits from the array prototype, which itself inherits from the object base prototype. This hierarchical structure, where an object inherits properties and methods from multiple levels of prototypes, is known as multilevel inheritance.

###### 9.2.2 Property Descriptors

In JavaScript, properties within constructor functions have descriptors that control their behavior. The key descriptors are:

- `writable`: Determines if a property's value can be changed (true by default).
- `enumerable`: Controls whether a property will appear during object iteration (true by default).
- `configurable`: Allows the property to be deleted or modified (true by default).

These descriptors can be modified using the `Object.defineProperty()` method during the constructor declaration. To check the current state of these descriptors, you can use the `Object.getOwnPropertyDescriptor()` method. Modifying these descriptors provides greater control over the properties and their behavior in objects.

###### 9.2.3 Constructor Prototypes

In JavaScript, every function is an object and thus has a prototype. The correct way to retrieve the prototype of an object is by using the `Object.getPrototypeOf()` method. For constructor functions, their prototypes can be accessed directly via the constructor's `prototype` property. This property returns the prototype that is shared by all objects created from that constructor, ensuring that they inherit common properties and methods. This mechanism is fundamental to JavaScript's inheritance model.

```javascript
function Circle() {
    // Implementation of constructor members
}

let myCircle = new Circle();
console.log(Circle.prototype === Object.getPrototypeOf(myCircle)); // Output: true
```

###### 9.2.4 Instance and Prototype Members

When a member is shared among many objects created from a single constructor, it can lead to inefficient memory use if each object holds its own copy. To address this, you can move the shared member to the constructor's prototype. This approach ensures that only one reference to the member exists in memory. In JavaScript, this can be achieved by defining the member on the constructor's `prototype`, making it accessible to all instances through prototypical inheritance. This separation between instance members and prototype members not only conserves memory but also allows for modifications and overrides of prototype properties.

```javascript
function Circle() {
    // Instance members
    this.draw = function() {};
}

// Prototype members
Circle.prototype.toString = function() {};
```

While JavaScript allows dynamic modification of constructor prototypes, it is advisable to avoid altering built-in objects. Modifying these prototypes can lead to conflicts with libraries or frameworks that rely on the original behavior of these objects, potentially causing functionality issues or breaking code. As a general best practice, avoid changing objects you do not own to maintain code stability and compatibility.

Defining members on the prototype rather than within the constructor function should be approached as an optimization practice, not a standard method. This approach can expose implementation details that were previously hidden, potentially violating the principle of abstraction. Such exposure may necessitate the creation of setters and getters to manage prototype members, which could compromise encapsulation. Therefore, moving members to the prototype is generally advised only when dealing with a large number of objects sharing the same member, as it can improve memory efficiency. For most cases, maintaining encapsulation by defining members within the constructor is preferred.

###### 9.2.5 Implementing Prototypical Inheritance

In JavaScript, the `Object.create()` method allows you to create a new object with a specified prototype object. By passing a prototype as an argument, `Object.create()` returns an object that inherits properties and methods from that prototype. This technique is particularly useful when implementing prototypical inheritance, enabling one constructor to inherit from another.

For example, consider two constructors, `Shape` and `Circle`. To allow `Circle` objects to inherit from `Shape`, you can set `Circle`'s prototype to an object created by `Object.create()` using `Shape.prototype` as the argument. This effectively sets up an inheritance chain where `Circle` inherits the properties and methods defined in `Shape`.

```javascript
function Shape() {
    // Initialize the shape implementation
}

function Circle() {
    // Initialize the circle implementation
}

// Establish prototypical inheritance
Circle.prototype = Object.create(Shape.prototype);
```

###### 9.2.6 Resetting the Constructor Property After Prototypical Inheritance

When you change the prototype of a constructor function to enable inheritance, the `constructor` property of that function will also change to the constructor of the inherited object. This can be inconvenient if you need to use the original constructor for creating instances dynamically. As a best practice, after resetting the prototype using `Object.create()`, you should also explicitly reset the `constructor` property of the constructor function. This ensures that instances created from the constructor will correctly reference the original constructor, maintaining consistency and allowing for dynamic object creation.

```javascript
function Shape() {
    // Initialize the shape implementation
}

function Circle() {
    // Initialize the circle implementation
}

// Establish prototypical inheritance
Circle.prototype = Object.create(Shape.prototype);

// Reset the constructor property
Circle.prototype.constructor = Circle;
```

###### 9.2.7 Reusable Function

In JavaScript, when implementing prototypical inheritance between multiple parent and child constructors, it’s common practice to use a generic function to handle the inheritance setup. This function ensures that the child constructor properly inherits from the parent constructor, while also resetting the prototype and constructor references correctly. 

```javascript
function extend(Child, Parent) {
    Child.prototype = Object.create(Parent.prototype);
    Child.prototype.constructor = Child;
}
```

###### 9.2.8 Initialization of Inherited Prototype Properties

When inheriting from a prototype object, it is sometimes necessary for the child object to pass arguments to the parent prototype to properly initialize its properties. To achieve this, the `call` method is used inside the child object's constructor. The `call` method allows you to invoke the parent constructor with a specific `this` context and pass any required arguments. This ensures that the prototype properties are correctly initialized within the child object, allowing for proper inheritance and functionality.

```javascript
function Shape(arg1, arg2) {
    // Initialize the shape with arguments
    this.arg1 = arg1;
    this.arg2 = arg2;
}

function Circle(arg1, arg2, arg3) {
    // Call the Shape constructor with Circle's context and arguments
    Shape.call(this, arg1, arg2);

    // Additional initialization for Circle
    this.arg3 = arg3;
}
```

###### 9.2.9 Method Overriding and Polymorphism

Method overriding in JavaScript allows a child constructor to provide a specific implementation of a method that is already defined in its prototype or parent constructor. This technique is essential for implementing polymorphism, a core concept in OOP. Polymorphism enables different objects that inherit from the same prototype to define their own unique implementations of methods, ensuring that each object behaves according to its specific needs.

When overriding a method, it's crucial to ensure that the new implementation in the child constructor is defined after setting up the prototypical inheritance. If the method is defined before inheritance is established, it will be overridden by the parent prototype's implementation, negating the customization.

Polymorphism plays a significant role in simplifying code, particularly by avoiding long conditional statements like `if...else` or `switch...case` that check an object's type. Instead, each object automatically uses its own method implementation, streamlining the code and enhancing maintainability.

```javascript
function Shape() {
    // Default implementation
}

Shape.prototype.draw = function() {
    console.log("Drawing a shape");
};

function Circle() {
    // Circle initialization
}

// Setting up inheritance
Circle.prototype = Object.create(Shape.prototype);
Circle.prototype.constructor = Circle;

// Method overriding
Circle.prototype.draw = function() {
    console.log("Drawing a circle");
};

let shape = new Shape();
let circle = new Circle();

shape.draw();  // Output: Drawing a shape
circle.draw(); // Output: Drawing a circle
```

###### 9.2.10 Mixins

In JavaScript, ES6 introduced the `Object.assign()` method, which facilitates the transfer of properties (or members) from one or more source objects to a target object. This method is particularly useful for implementing composition by allowing different behaviors or functionalities to be mixed into a single object, a pattern known as "Mixins."

To apply `Object.assign()` for creating mixins, you first define a target object—often a constructor's prototype—and then pass one or more source objects as arguments. These source objects contain the methods and properties that should be added to the target object, thereby extending its functionality.

When dealing with multiple source objects, it's common practice to encapsulate this process in a function called `mixin`. The `mixin` function takes the target object as its first parameter, followed by any number of source objects. To accommodate an unknown number of source objects, the rest operator (`...`) is used.

```javascript
function mixin(target, ...sources) {
    Object.assign(target, ...sources);
}

const canEat = {
    eat: function() {
        console.log("Eating");
    }
};

const canWalk = {
    walk: function() {
        console.log("Walking");
    }
};

const canSwim = {
    swim: function() {
        console.log("Swimming");
    }
};

function Person() {}

// Applying mixins to the Person prototype
mixin(Person.prototype, canEat, canWalk, canSwim);

let person = new Person();
person.eat();  // Output: Eating
person.walk(); // Output: Walking
person.swim(); // Output: Swimming
```

#### 9.3 Classes

###### 9.3.1 ES6 Classes

In ES6, JavaScript introduced classes as a modern way to create objects and implement inheritance, offering a more streamlined syntax compared to traditional prototype-based methods. Despite their class-like appearance, ES6 classes are essentially syntactic sugar built upon JavaScript's existing prototypical inheritance model. Therefore, a solid understanding of prototypical inheritance is beneficial before diving into ES6 classes.

To define a class in ES6, you use the `class` keyword followed by the class name. Inside the class body, you can specify properties and methods. The `constructor` method is a special method used to initialize the properties of the class when an instance is created. After the `constructor`, additional methods can be defined. Note that methods defined within the class body are automatically added to the prototype of the instances created from the class. If you need methods that are not shared among instances and should be unique to each object, you would need to define them inside the `constructor`.

```javascript
class Animal {
    constructor(name) {
        this.name = name;
    }

    speak() {
        console.log(`${this.name} makes a noise.`);
    }
}
```
