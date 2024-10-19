# TypeScript

## 1. Introduction to TypeScript

#### 1.1 What is TypeScript?

TypeScript is a programming language built on top of JavaScript, acting as a superset that adds extra features while maintaining compatibility with all JavaScript code. It introduces static typing, allowing developers to define variable types and catch errors during compilation, leading to more reliable and maintainable code. Additionally, it offers language features such as interfaces, enums, and generics for writing cleaner and more scalable code. Though it requires transpilation to run in browsers, TypeScript's tools and error prevention make it a superior choice for larger and more complex applications compared to plain JavaScript.

#### 1.2 Setting up a TypeScript Development Environment

To set up a TypeScript development environment using Visual Studio Code, follow these streamlined steps. This guide covers the installation of necessary tools, project configuration, useful extensions, and how to compile, run, and debug your TypeScript projects efficiently.

1. Install Node.js and npm:
   
   - Download Node.js from the [Node.js website](https://nodejs.org/) and choose the recommended version for your operating system. npm (Node Package Manager) will be installed automatically with Node.js.
   
   - Follow the installation instructions for your OS.
   
   - Open your terminal and verify the installation by running:  
     
     ```bash
     node -v   # Check Node.js version
     npm -v    # Check npm version
     ```

2. Install Visual Studio Code (VS Code):
   
   - Download VS Code from the [VS Code website](https://code.visualstudio.com/) and install it following the instructions for your operating system.

3. Install TypeScript:
   
   - Open the terminal and install TypeScript globally using npm:
     
     ```bash
     npm install -g typescript
     ```
   
   - Verify the TypeScript installation by checking the version:
     
     ```bash
     tsc -v
     ```

4. Configure a New TypeScript Project:
   
   - Local Configuration:
     
     - Open your terminal and create a new project directory by running:
       
       ```bash
       mkdir my-ts-project
       cd my-ts-project
       ```
     
     - Initialize a new npm project:
       
       ```bash
       npm init -y
       ```
     
     - Create a `tsconfig.json` file to configure TypeScript:
       
       ```bash
       tsc --init
       ```
     
     - Configure the `tsconfig.json` file for the comiler to preferences:
       
       | Configuration Option   | Description                                                                                             | Preferred Value |
       | ---------------------- | ------------------------------------------------------------------------------------------------------- | --------------- |
       | target                 | Specifies the JavaScript version to which TypeScript will be compiled.                                  | `es2016`        |
       | module                 | Defines the module system for the compiled JavaScript.                                                  | `commonjs`      |
       | rootDir                | Sets the directory for the source TypeScript files.                                                     | `./src`         |
       | outDir                 | Specifies the directory where the compiled JavaScript files will be output.                             | `./dist`        |
       | removeComments         | Removes comments from the compiled JavaScript files.                                                    | `true`          |
       | noEmitOnError          | Determines if JavaScript files should be generated when there are TypeScript errors.                    | `true`          |
       | noImplicitReturns      | Compiler prevents functions from returning `undefined` by default when no return statement is provided. | `true`          |
       | noImplicitOverride     | Compiler ensures that defines the method that have to be overwritten.                                   | `true`          |
       | experimentalDecorators | Enables the creation and usage of decorators.                                                           | `true`          |
       | moduleResolution       | Specify how TypeScript looks up a file from a given module specifier.                                   | `es2016`        |
     
     - Open the project in VS Code with:
       
       ```bash
       code .
       ```
     
     - Create a new TypeScript file (e.g., `index.ts`) and start coding.
   
   - Compile the TypeScript Code:
     
     - To compile your TypeScript files to JavaScript, run:
       
       ```bash
       tsc index.ts
       ```

5. Useful VS Code Extensions:
   
   - Install the following extensions to enhance your TypeScript development experience:
     
     - TypeScript Hero: Adds improved IntelliSense, import management, and code navigation for TypeScript.
     
     - Prettier - Code Formatter: Automatically formats your TypeScript code. Enable "Format On Save" for automatic formatting with every save.
     
     - ESLint: Lints your TypeScript code for consistency and to catch common errors.
     
     - Live Server: Runs a local development server with live reload functionality for web projects. Useful for running projects that include HTML and JavaScript output from TypeScript.

6. Running TypeScript File:
   
   - Running Locally:
     
     - After compiling your `.ts` files, run the generated JavaScript with:
       
       ```bash
       node dist/index.js
       ```
   
   - Running in the Browser:
     
     - Use the Live Server extension to open your `index.html` file (if you're building a web project) and have the browser refresh automatically as you update your TypeScript code.

#### 1.3 Debugging with VS Code's TypeScript extension

VS Code’s TypeScript extension provides powerful debugging tools to help identify and fix errors in your code. When debugging a TypeScript project for the first time, you can create a `launch.json` file by navigating to the Debug panel in VS Code. This file, stored in the `.vscode` folder, defines your debugging configuration and usually requires minimal modification after setup. Make sure to add a `preLaunchTask` in `launch.json` to ensure TypeScript is compiled before debugging:

```json
"preLaunchTask": "tsc: build - tsconfig.json"
```

Here are some key debugging tools available in the panel:

1. Breakpoints: Pause code execution at a specific line to examine the program's state at that moment.
2. Step Over: Execute the code line by line without entering functions, allowing you to observe where errors may arise.
3. Step Into: Dive into a function to inspect its internal execution more closely.
4. Step Out: Exit the current function and return to the calling code, helping you resume debugging at a higher level.
5. Variable Window: View the current values of variables during debugging to monitor the program’s state and detect anomalies.

These tools enhance the debugging process, making it easier to identify and resolve errors in TypeScript applications.

## 2. Working with Types in TypeScript

#### 2.1 Defining Types

In TypeScript, types are defined to ensure static type checking, improving code reliability and reducing errors. You can define types for variables, arrays, functions, and objects, providing better structure and predictability to your code.

###### 2.1.1 Variables

To define the type of a variable, add a colon (`:`) followed by the type after the variable name. If no type is declared, TypeScript will infer the type based on the assigned value.

```typescript
let age: number = 24;
let name = "Eli"; // inferred as string
```

###### 2.1.2 Arrays

TypeScript allows arrays to hold elements of a specific type by using square brackets (`[]`). If an array is declared without a type, it defaults to `any[]`, allowing any type of element.

```typescript
let numbers: number[] = [1, 2, 3];
let strings: string[] = []; // empty but constrained to strings
```

###### 2.1.3 Functions

Functions in TypeScript can have types for parameters and return values. It's good practice to explicitly declare these types for clarity and type safety.

```typescript
function add(a: number, b: number): number {
  return a + b;
}

function greet(name?: string): string {
  return name ? `Hello, ${name}` : "Hello!";
}
```

###### 2.1.4 Objects

Object types in TypeScript can be defined with specific key-value pairs. Optional properties are marked with a question mark (`?`), and `readonly` ensures immutability.

```typescript
let person: { name: string; age?: number; readonly id: string } = {
  name: "Eli",
  id: "1234"
};
```

#### 2.2 Other Types

In TypeScript, the `any` and `unknown` types allow for flexible typing, but they serve different purposes in maintaining type safety.

###### 2.2.1 Any Type

The `any` type lets a variable hold any kind of value, effectively disabling TypeScript’s type checking. This flexibility allows variables to change types throughout the code, but it compromises the benefits of static typing, potentially introducing errors. It's advisable to avoid using `any` when possible to maintain code reliability.

```typescript
let value: any;
value = "hello";
value = 42;  // No type errors
```

###### 2.2.2 Unknown Type

The `unknown` type is similar to `any` in that it can represent any value, but it enforces stricter type safety. Unlike `any`, TypeScript requires explicit type checks or assertions before you can interact with `unknown` values, making it a safer alternative.

```typescript
let data: unknown;
data = "hello";

// Type assertion required before use
if (typeof data === "string") {
  console.log(data.length); // Safe to access string properties
}
```

#### 2.3 Type Utilities

###### 2.3.1 Union Types

Union types allow a variable or function parameter to accept multiple types, providing flexibility while maintaining type safety. This is achieved by using the pipe (`|`) symbol between types.

```typescript
let value: string | number | boolean;
value = "example";  // valid
value = 42;         // valid
value = false;      // valid
```

###### 2.3.2 Literal Types

Literal types restrict variables to specific values, enhancing type safety. By combining literal types with union types, you can define variables that accept a set of predefined values.

```typescript
let option: "yes" | "no" | "maybe";
option = "yes";    // valid
option = "no";     // valid
```

###### 2.3.3 Intersection Types

Intersection types enable variables or parameters to satisfy multiple types simultaneously. This is done using the ampersand (`&`) symbol, ensuring the variable possesses properties from all specified types.

```typescript
type TypeA = { propA: string; };
type TypeB = { propB: number; };
type CombinedType = TypeA & TypeB;

let item: CombinedType = { propA: "text", propB: 100 };
```

###### 2.3.4 Type Aliases

Type aliases create custom types, centralizing structure for better reusability and maintainability. You can define an alias with the `type` keyword followed by a descriptive name.

```typescript
type AliasType = { key1: number; key2: string };
let example: AliasType = { key1: 10, key2: "value" };

type AnotherType = { field1: boolean; field2: string };
let anotherExample: AnotherType = { field1: true, field2: "text" };
```

###### 2.3.5 Enums

Enums define a collection of related constants, providing a structured approach to managing sets of values. Enums are declared using the `enum` keyword, allowing you to assign default or custom values.

```typescript
enum Status {
  Active,
  Inactive,
  Pending,
}
let currentStatus: Status = Status.Active; // numeric value 0

enum Directions {
  North = "N",
  South = "S",
  East = "E",
  West = "W",
}
let currentDirection: Directions = Directions.North; // "N"
```

###### 2.3.6 Optional Chaining Operator vs Non-Null Assertion

The optional chaining operator (`?.`) allows developers to safely access properties or methods of an object that may be `null` or `undefined`, returning `undefined` instead of throwing an error when the object is not present.

```typescript
let obj = { prop: { nestedProp: "value" } };
let nestedValue = obj.prop?.nestedProp; // nestedValue is "value"

let missingObj = null;
let result = missingObj?.field; // result is undefined
```

Conversely, the Non-Null Assertion Operator (`!`) asserts that a value is not `null` or `undefined`, effectively telling the TypeScript compiler to treat the value as definitely defined, which can prevent the need for additional null checks but may lead to runtime errors if misused.

```typescript
let element = { value: "content" };
let contentValue = element.value!; // Safe, assuming element is not null
```

###### 2.3.7 Nullish Coalescing Operator

The nullish coalescing operator (`??`) provides a default value when the expression evaluates to `null` or `undefined`, in contrast to the logical OR operator (`||`), which treats all falsy values as triggers for fallback:

```typescript
let data = null;
let fallbackData = data ?? "default"; // fallbackData is "default"

let num = 0;
let numFallback = num ?? 100; // numFallback is 0
```

###### 2.3.8 Type Assertion

Type Assertion enables developers to specify the type of a variable when the TypeScript compiler's inference is insufficient. This helps to inform the compiler of the expected type without performing any runtime validation:

```typescript
let anyValue: any = "Hello, World!";
let stringLength: number = (anyValue as string).length; // stringLength is 13
```

In TypeScript, the `typeof` and `instanceof` operators facilitate type assertions by providing runtime type checks. The `typeof` operator checks the type of a variable, allowing safe assertions for primitive types. Meanwhile, the `instanceof` operator verifies if an object belongs to a specific class, enabling safe access to class properties and methods. These checks enhance type safety by ensuring variables are treated correctly based on their actual types at runtime.

```typescript
// Asserting the type of a variable
const value: string;
if (typeof value === 'string') {
    // Some logic
}

// Asserting the class of a variable
const obj: MyClass;
if (obj instanceof MyClass) {
    // Some logic
}
```

## 3. Object-Oriented Programming

#### 3.1 Defining and Using Classes

In TypeScript, a class serves as a blueprint for creating objects, encapsulating properties and methods that define their behavior. You can define a class using the `class` keyword followed by a name in PascalCase. Inside the class, properties can be defined and initialized using a `constructor`, which sets the initial state of an instance. The `this` keyword refers to the current instance, enabling access to its members.

```typescript
class GenericClass {
    prop: string;

    constructor(initialValue: string) {
        this.prop = initialValue;
    }
}

let instance = new GenericClass("Initial Value");
console.log(instance.prop); // Output: "Initial Value"
```

#### 3.2 Access Modifiers

TypeScript supports three access modifiers: `public`, `private`, and `protected`. By default, class members are `public`, meaning they can be accessed from outside the class. The `private` modifier restricts access to members, allowing them to be used only within the class itself, thereby promoting encapsulation. The `protected` modifier allows access within the class and its subclasses, making it useful for inheritance scenarios.

```typescript
class AccessModifierExample {
    public publicProp: number;
    private privateProp: number;
    protected protectedProp: number;

    constructor() {
        this.publicProp = 1;
        this.privateProp = 2;
        this.protectedProp = 3;
    }
}

const example = new AccessModifierExample();
console.log(example.publicProp); // Accessible
// console.log(example.privateProp); // Not accessible
```

#### 3.3 Getters and Setters

Getters and setters provide a way to encapsulate property access and modification. Getters, defined with the `get` keyword, allow read access to properties, while setters, defined with the `set` keyword, enable controlled write access, making it possible to include validation or other logic during property updates.

```typescript
class PropertyControl {
    private _value: number;

    constructor(value: number) {
        this._value = value;
    }

    get value(): number {
        return this._value;
    }

    set value(newValue: number) {
        if (newValue < 0) {
            throw new Error("Value cannot be negative");
        }
        this._value = newValue;
    }
}

let controlled = new PropertyControl(10);
console.log(controlled.value); // Output: 10
controlled.value = 5;          // Works fine
// controlled.value = -1;      // Throws an error
```

#### 3.4. Static Methods

Static methods belong to the class itself rather than instances, allowing you to define utility functions that do not require object state. You can define static methods using the `static` keyword, making them accessible directly from the class.

```typescript
class StaticExample {
    static staticMethod() {
        return "Static method called";
    }
}

console.log(StaticExample.staticMethod()); // Output: "Static method called"
```

#### 3.5 Inheritance and Method Overriding

Inheritance allows a class (child) to inherit properties and methods from another class (parent), promoting code reuse. You use the `extends` keyword to create a subclass. To properly initialize these inherited properties, you can call the parent's constructor using the `super` keyword within the child's constructor. This ensures that any properties defined in the parent class are initialized before the child class adds its own properties or methods. In addition to inheriting methods, a child class can override the methods of its parent class, and the override keyword indicates that the method provides a new implementation of an inherited method.

```typescript
class ParentClass {
    protected message: string;

    constructor(msg: string) {
        this.message = msg;
    }

    greet() {
        return this.message;
    }
}

class ChildClass extends ParentClass {
    constructor() {
        // Call the parent constructor to initialize the inherited property
        super("Hello from Child");
    }

    override greet() {
        return super.greet() + " - Extended Greeting!";
    }
}

let child = new ChildClass();
console.log(child.greet()); // Output: "Hello from Child - Extended Greeting!"

```

#### 3.6 Abstract Classes

Abstract classes provide a way to define common properties and methods that must be implemented by subclasses while preventing direct instantiation of the abstract class itself. Abstract methods do not have implementations and must be overridden in derived classes.

```typescript
abstract class AbstractBase {
    abstract display(): string;

    commonMethod() {
        return "This is a common method.";
    }
}

class ConcreteClass extends AbstractBase {
    display(): string {
        return "Concrete class implementation.";
    }
}

let concrete = new ConcreteClass();
console.log(concrete.display()); // Output: "Concrete class implementation."
console.log(concrete.commonMethod()); // Output: "This is a common method."
```

#### 3.7 Interfaces and Polymorphism

Interfaces in TypeScript define a contract that implementing classes must follow, ensuring consistent method signatures while allowing for different implementations. This is key to achieving polymorphism, where multiple classes can share the same interface but provide their own specific behaviors. This flexibility allows developers to write more modular, scalable code by abstracting away the specifics of individual classes and focusing on common functionality.

Polymorphism ensures that, regardless of the object type, you can interact with them uniformly via the interface, while each class defines its own version of the methods. This reduces the need for complex conditionals and promotes cleaner code.

```typescript
interface Entity {
    performAction(): string;
}

class AlphaEntity implements Entity {
    performAction(): string {
        return "Alpha performing action";
    }
}

class BetaEntity implements Entity {
    performAction(): string {
        return "Beta performing action";
    }
}

// Array of different entity types, but treated uniformly
let entities: Entity[] = [new AlphaEntity(), new BetaEntity()];

// Polymorphism in action: Each entity behaves according to its specific implementation
entities.forEach(entity => console.log(entity.performAction()));
```

## 5. Generics

#### 5.1 Generic Classes

In TypeScript, generic classes allow you to create reusable and flexible class definitions that can work with different types, without needing to define a new class for each specific type. To define a generic class, you use angle brackets (`<>`) after the class name, specifying one or more generic type parameters, typically denoted by the letter `T` (a common convention for a single generic type). These type parameters can then be used throughout the class to define property types or method parameters.

When you create an instance of a generic class, you specify the actual type for `T`. This allows the class to handle different types while maintaining type safety.

```typescript
// Define a generic class with a type parameter T
class Box<T> {
    content: T;

    constructor(content: T) {
        this.content = content;
    }

    getContent(): T {
        return this.content;
    }
}

// Creating instances with different types
const numberBox = new Box<number>(123);
console.log(numberBox.getContent()); // Output: 123

const stringBox = new Box<string>("Hello, TypeScript!");
console.log(stringBox.getContent()); // Output: Hello, TypeScript!
```

#### 5.2 Generic Functions

Generic functions in TypeScript allow you to define flexible and reusable functions that can work with different types while maintaining type safety. To create a generic function, you add angle brackets (`<>`) right after the function name, followed by one or more type parameters (typically denoted by `T` for a single generic type). These type parameters can then be used within the function's parameters, return type, or within the function body.

When you call the generic function, you can specify the actual type for `T`, or let TypeScript infer it based on the arguments passed to the function. This allows the same function to work with different types without needing to duplicate code.

```typescript
// Generic function with type parameter T
function identity<T>(value: T): T {
    return value;
}

// Calling the generic function with different types
const numberIdentity = identity<number>(42);
console.log(numberIdentity); // Output: 42

const stringIdentity = identity<string>("Hello, TypeScript!");
console.log(stringIdentity); // Output: Hello, TypeScript!
```

#### 5.3 Generic Interfaces

Generic interfaces in TypeScript allow you to define flexible and reusable structures that can work with different types, making your code more adaptable. To create a generic interface, you use angle brackets (`<>`) after the interface name, followed by one or more type parameters (typically represented by `T` for a single type). These type parameters can then be used throughout the interface to define property or method types.

When implementing the interface or creating objects that follow its structure, you specify the actual type for the generic parameter. This allows the same interface to be used with different types, ensuring both flexibility and type safety.

```typescript
// Define a generic interface with type parameter T
interface Container<T> {
    content: T;
    getContent: () => T;
}

// Implementing the interface with different types
const numberContainer: Container<number> = {
    content: 42,
    getContent: () => numberContainer.content,
};

const stringContainer: Container<string> = {
    content: "Hello, TypeScript!",
    getContent: () => stringContainer.content,
};

console.log(numberContainer.getContent()); // Output: 42
console.log(stringContainer.getContent()); // Output: Hello, TypeScript!
```

#### 5.4 Generic Constraints

Generic constraints in TypeScript allow you to impose specific requirements on generic type parameters, ensuring that they adhere to a certain structure or type. This is useful when you want to limit the types that can be used with a generic type, ensuring that the generic functionality works only with types that meet specific criteria.

To apply a generic constraint, you use the `extends` keyword in the generic type parameter declaration. This constraint specifies that the generic type must satisfy certain conditions, such as having particular properties or implementing a specific interface. This helps enforce type safety and ensures that the operations within the generic function or class are valid for the constrained types.

```typescript
// Define a constraint interface
interface HasId {
    id: number;
}

// Define a generic function with a constraint
function printId<T extends HasId>(item: T): void {
    console.log(item.id);
}

// Valid usage with types that satisfy the constraint
const user = { id: 1, name: "Eli" };
printId(user); // Output: 1

const product = { id: 101, price: 29.99 };
printId(product); // Output: 101
```

#### 5.4 Extending Generic Classes

When extending a generic class in TypeScript, you have three primary approaches for handling the generic type parameter:

1. **Fix the Generic Type Parameter**: You can specify a concrete type for the generic parameter in the child class. This means that the child class will use this fixed type for all instances, rather than allowing it to vary.

2. **Restrict the Generic Type Parameter Using Constraints**: You can apply constraints to the generic type parameter in the child class. This involves using the `extends` keyword to enforce that the type must adhere to a certain structure or interface, ensuring that the generic functionality works only with types that meet specific criteria.

3. **Pass the Generic Type Parameter to the Child Class**: You can choose to pass the generic type parameter from the parent class to the child class, allowing the child class to remain generic and flexible.

```typescript
// Generic base class
class Box<T> {
    content: T;

    constructor(content: T) {
        this.content = content;
    }

    getContent(): T {
        return this.content;
    }
}

// 1. Fix the generic type parameter in the child class
class NumberBox extends Box<number> {
    constructor(content: number) {
        super(content);
    }
}

// 2. Restrict the generic type parameter using constraints
interface HasName {
    name: string;
}

class NameBox<T extends HasName> extends Box<T> {
    constructor(content: T) {
        super(content);
    }
}

// 3. Pass the generic type parameter to the child class
class GenericBox<T> extends Box<T> {
    constructor(content: T) {
        super(content);
    }
}

// Usage
const numberBox = new NumberBox(42);
console.log(numberBox.getContent()); // Output: 42

const nameBox = new NameBox({ name: "Eli" });
console.log(nameBox.getContent().name); // Output: Eli

const genericBox = new GenericBox("A generic content");
console.log(genericBox.getContent()); // Output: A generic content
```

#### 5.5 Type-Safe Object Key Access

The `keyof` operator in TypeScript is a powerful tool that returns a union of the keys in an object type. This is particularly useful when working with generic types where the structure of the object might not be known beforehand. By using `keyof`, you can safely access object properties based on their keys while maintaining type safety, avoiding the need to use `any` as the key type. This ensures that only valid keys of the object can be used.

```typescript
// Define a generic function that uses keyof to access object properties
function getValueByKey<T, K extends keyof T>(obj: T, key: K): T[K] {
    return obj[key];
}

// Define an object
const user = {
    id: 1,
    name: "Eli",
    age: 24,
};

// Use the function to get values by key
const userId = getValueByKey(user, "id"); // Type is number
const userName = getValueByKey(user, "name"); // Type is string
```

#### 5.6 Type Mapping

Type mapping in TypeScript allows you to transform or adjust existing types without repeating their structure. This technique is useful when you need to modify properties across an entire type, such as making all properties `readonly`, `optional`, or `nullable`. Instead of manually declaring a new type, type mapping automates this process by iterating over the keys of the original type and applying adjustments.

To implement type mapping, you can create a type alias using the `type` keyword. Inside the type alias, the `in keyof` operator is used to iterate over all the keys in the referenced type, similar to a loop. The value type can be defined using bracket notation, referencing the original type. You can even apply this to generic types, making the process highly reusable and flexible.

```typescript
// Original type
type User = {
    id: number;
    name: string;
    age: number;
};

// Type mapping to make all properties optional
type Optional<T> = {
    [K in keyof T]?: T[K];
};

// New type with optional properties
type OptionalUser = Optional<User>;

// Usage
const user: OptionalUser = {
    id: 1,  // Name and age are optional
};
```

Due to the usefulness of these certain mapped types, TypeScript included them as built-in features. You can find a comprehensive overview of these utility types at https://www.typescriptlang.org/docs/handbook/utility-types.html.

## 6. Decorators

#### 6.1 Introduction to Decorators

Decorators in TypeScript provide a way to modify or extend the behavior of classes, methods, or properties by applying special attributes to them. Essentially, decorators are functions that are executed at runtime, receiving the target class or class member they are applied to. This powerful feature allows developers to enhance or alter the functionality of classes without changing their core code, making the code more flexible and reusable.

#### 6.2 Class Decorators in TypeScript

A class decorator is a special type of decorator applied to an entire class, where the JavaScript engine calls the decorator function and passes the class constructor to it. This function can modify the class by adding new properties or methods, or by altering the behavior of existing ones. To create a class decorator, you define a function that accepts the class constructor as a parameter and interacts with the class prototype to extend or modify its functionality. It's important to note that when a class decorator is applied, the function is automatically invoked at runtime, even without instantiating the class, ensuring that the modifications are applied.

```typescript
// Class decorator function
function LogClass(constructor: Function) {

    // Add a new method to the class prototype
    constructor.prototype.logInfo = function() {
        console.log(`Instance of ${constructor.name} has been created.`);
    };
}

// Applying the class decorator
@LogClass
class User {
    constructor(public name: string) {}
}

// Create an instance of the class
const user = new User("Eli");

// Call the dynamically added method
(user as any).logInfo(); // Output: Instance of User has been created.
```

#### 6.3 Parametrized Decorators

A decorator factory in TypeScript is a special type of decorator that allows you to pass parameters, returning a function that can be applied to classes, methods, or properties. Unlike regular decorators, which are applied directly, a decorator factory enables parameterized decorators, letting you customize their behavior based on the provided parameters. When used with classes, the factory returns a function that modifies the class by accessing its constructor, allowing for dynamic modifications depending on the arguments passed to the decorator.

```typescript
// Class decorator factory that accepts a parameter
function Logger(prefix: string) {
    // The actual decorator function
    return function(constructor: Function) {
        console.log(`${prefix} - Class ${constructor.name} is being created.`);
    };
}

// Applying the class decorator with a custom prefix
@Logger("Info")
class User {
    constructor(public name: string) {}
}

const user = new User("Eli"); // Output: Info - Class User is being created.
```

#### 6.4 Composite Decorators

In TypeScript, you can apply multiple decorators to a class or its members, and the order in which they are applied is important. The decorators are evaluated from top to bottom but applied from bottom to top, meaning the decorator at the bottom wraps around the one above it. This allows for layered customization, where each decorator can build on or modify the effects of the previous one, influencing the overall behavior of the class or its members.

```typescript
function FirstDecorator(constructor: Function) {
    console.log('FirstDecorator applied');
    constructor.prototype.first = true;
}

function SecondDecorator(constructor: Function) {
    console.log('SecondDecorator applied');
    constructor.prototype.second = true;
}

@FirstDecorator     // Evaluated first, but applied second
@SecondDecorator    // Evaluated second, but applied first
class ExampleClass {
    constructor() {
        console.log('ExampleClass created');
    }
}

const example = new ExampleClass();
```

#### 6.5 Method Decorators

In TypeScript, method decorators allow you to modify or extend the behavior of methods within a class. Unlike class decorators, method decorators accept three parameters: the target object (of type `any`), the method name (of type `string`), and the method's property descriptor (of type `PropertyDescriptor`). These parameters let you directly interact with and modify the method's functionality. A common use of method decorators is to redefine the method by changing `descriptor.value`, which allows you to add custom logic before or after the method execution. It's important to use function expressions instead of arrow functions when calling the original method, as arrow functions do not have their own `this` context, which is required for proper method binding.

```typescript
function LogExecution(target: any, methodName: string, descriptor: PropertyDescriptor) {
    const originalMethod = descriptor.value;

    descriptor.value = function (...args: any[]) {
        console.log(`Calling ${methodName} with arguments: ${JSON.stringify(args)}`);
        const result = originalMethod.apply(this, args);  // Call the original method
        console.log(`Method ${methodName} returned: ${result}`);
        return result;
    };
}

class Calculator {
    @LogExecution
    add(a: number, b: number): number {
        return a + b;
    }
}

const calculator = new Calculator();
calculator.add(2, 3);
```

#### 6.6 Accessor Decorators

Accessor decorators in TypeScript are used to modify the behavior of getter and setter methods in a class. Like method decorators, they take three parameters: the target object (of type `any`), the accessor method's name (of type `string`), and the property descriptor (of type `PropertyDescriptor`). Accessor decorators allow you to inject custom logic when a property is accessed or modified by interacting with the `descriptor.get` or `descriptor.set` functions. This enables you to control or extend the functionality of getters and setters in a class.

```typescript
function LogAccessor(target: any, propertyName: string, descriptor: PropertyDescriptor) {
    const originalGet = descriptor.get;

    descriptor.get = function () {
        const value = originalGet?.apply(this);
        console.log(`Getting value of ${propertyName}: ${value}`);
        return value;
    };
}

class Person {
    private _age: number = 0;

    @LogAccessor
    get age(): number {
        return this._age;
    }

    set age(value: number) {
        this._age = value;
    }
}

const person = new Person();
person.age = 30;
console.log(person.age);
```

#### 6.7 Property Decorators

Property decorators in TypeScript allow you to customize and extend the behavior of class properties. They are applied directly to properties and take two parameters: the target object (of type `any`) and the property name (of type `string`). Inside the decorator, you can define a property descriptor to control how the property is accessed or modified. For instance, you can add custom logic for getting or setting the property value. The updated descriptor is then applied to the property using the `Object.defineProperty()` method, enabling enhanced functionality.

```typescript
function AddValidAge(target: any, propertyName: string) {
    let value: number | null = null; // Local variable to store the value

    Object.defineProperty(target, propertyName, {
        get: (): number | null => value,
        set: (age: number): void => {
            value = age > 0 ? age : null; // Apply validation before setting the value
        },
        enumerable: true,
        configurable: true
    });
}

class Person {
    @AddValidAge
    age: number | null = null; // Remove readonly to allow modification
}

const person = new Person();
person.age = 20;  // Valid assignment
console.log(person.age);  // Output: 20

person.age = -5;  // Invalid assignment, will be set to null
console.log(person.age);  // Output: null
```

## 7. Modules

#### 7.1 Importing and Exporting Modules

As projects grow in complexity, it becomes increasingly difficult to manage all the code within a single file. To address this, code is typically organized into separate files known as modules. Each module serves a specific purpose and contains related classes, functions, and other objects. By default, all objects within a module are private and inaccessible from outside the module unless explicitly exported. To make these objects available to other parts of the project, you need to use the `export` keyword before the object declaration.

```typescript
// user.ts
export class User {
    constructor(public name: string) {}
}

export function createUser(name: string): User {
    return new User(name);
}
```

In another file, you can import these exported objects using the `import` statement, specifying either the absolute or relative path to the module:

```typescript
// app.ts
import { User, createUser } from './user';

const newUser = createUser('Eli');
console.log(newUser.name);  // Output: Eli
```

This modular approach helps keep the codebase organized and manageable, allowing you to split functionality across different files and only import what you need.

#### 7.2 Modern JavaScript Module Systems

Originally, JavaScript lacked a standardized module system, leading to various techniques and formats for modularizing code. However, since the introduction of ES2015 (ES6), JavaScript has natively supported a standardized module system using `export` and `import` statements. This modern module format is widely adopted and supported by most web browsers and JavaScript runtime environments, making older module formats largely obsolete.

In TypeScript, the default behavior is to convert ES6 modules into the CommonJS module format when transpiling TypeScript code to JavaScript. However, this behavior can be customized by modifying the `module` setting in the `tsconfig.json` file.

#### 7.3 Default Exports

In JavaScript modules, when you want to export a single object from a module while keeping the rest of the module code private, you can use the `export default` statement. This approach simplifies the import process, as it eliminates the need for curly braces around the imported object.

```javascript
// user.js
class User {
    constructor(name) {
        this.name = name;
    }
}

export default User;
```

When importing this module, you don't need to use curly braces:

```javascript
// app.js
import User from './user';

const newUser = new User('Eli');
console.log(newUser.name);  // Output: Eli
```

#### 7.3 Wildcard Imports

When dealing with modules that export multiple objects, importing everything individually can become cumbersome. In such cases, you can use wildcard imports to bring all exported members into a single container object. To perform a wildcard import, use the `import * as` syntax followed by a chosen alias. This alias will act as the container object holding all the exported members from the module.

```javascript
// utils.js
export function add(a, b) {
    return a + b;
}

export function subtract(a, b) {
    return a - b;
}

export const PI = 3.14;
```

You can import all these exports into a single container object:

```javascript
// app.js
import * as utils from './utils';

console.log(utils.add(5, 3));       // Output: 8
console.log(utils.subtract(5, 3));  // Output: 2
console.log(utils.PI);             // Output: 3.14
```

#### 7.4 Re-exporting

Re-exporting is a technique used to aggregate multiple modules into a single module, allowing you to combine and export them collectively. This approach is particularly useful for creating a central module that consolidates various functionalities, making it easier for consumers to import from a single source rather than managing multiple import statements. To re-export from a module, you can use the `export` keyword in combination with `import`. 

Suppose you have multiple modules with various exports:

```javascript
// math.js
export function add(a, b) {
    return a + b;
}

export function subtract(a, b) {
    return a - b;
}

// constants.js
export const PI = 3.14;
export const E = 2.71;
```

You can create a central module that re-exports everything from these modules:

```javascript
// index.js
export * from './math';
export * from './constants';
```

Now, consumers of your module can import everything from a single source:

```javascript
// app.js
import { add, subtract, PI, E } from './index';

console.log(add(5, 3));      // Output: 8
console.log(subtract(5, 3)); // Output: 2
console.log(PI);            // Output: 3.14
console.log(E);             // Output: 2.71
```

## 8. Integration with JavaScript

#### 8.1 Including JavaScript Code in TypeScript Projects

When working on a TypeScript project, you may need to include and use JavaScript code alongside TypeScript files. To enable this, you need to adjust the `tsconfig.json` configuration file. Specifically, set the `"allowJs"` option to `true` to permit JavaScript files to be part of your TypeScript project. Additionally, ensure that the `"module"` setting is configured to use the CommonJS module system, which is typically used for module resolution in Node.js environments. With this configuration, you can import JavaScript modules into TypeScript files.

#### 8.2 Type Checking JavaScript Code

By default, TypeScript does not perform type checking on JavaScript code. To enable type checking for JavaScript files, you need to set the `"checkJs"` option to `true` in the `tsconfig.json` file. This allows TypeScript to apply type checking rules to JavaScript files, providing enhanced error detection and type safety.

If you encounter errors in your JavaScript code that you wish to ignore, you can suppress TypeScript checks by adding a `// @ts-nocheck` comment at the top of the file or above specific lines of code. This instructs the TypeScript compiler to skip type checking for the affected code.

#### 8.3 Defining JavaScript Types

To provide type information for JavaScript objects and functions, you can use JSDoc comments directly in your JavaScript files. JSDoc comments allow you to specify types for variables, parameters, and return values, which helps TypeScript understand and check the code correctly.

```javascript
/**
 * Adds two numbers.
 * @param {number} a - The first number.
 * @param {number} b - The second number.
 * @returns {number} - The sum of a and b.
 */
function add(a, b) {
  return a + b;
}
```

Alternatively, you can create a type definition file (`.d.ts` file) to provide type information without modifying the original JavaScript code. The type definition file should have the same name as the JavaScript file it describes, with a `.d.ts` extension. This file includes declarations for functions, variables, or methods with their types, but no implementation.

```typescript
// add.d.ts
export function add(a: number, b: number): number;
```

By exporting these declarations, the TypeScript compiler can infer the types and perform accurate type checking when importing the JavaScript module. Ensure that the type definition file describes all the features of the JavaScript module you want to use to ensure proper type checking.

#### 8.4 Integrating Third-Party JavaScript Libraries

When incorporating third-party JavaScript libraries into a TypeScript project, you may face challenges with type checking, as these libraries often lack JSDoc comments or TypeScript declaration files. To address this issue, you can use the DefinitelyTyped repository, which provides TypeScript declaration files for many popular JavaScript libraries. These declaration files define the types for the libraries, allowing TypeScript to perform type checking and provide IntelliSense.

To add type definitions for a specific library, you can install them as a development dependency using npm. For example, to install type definitions for a library named `lodash`, use the following command:

```bash
npm install --save-dev @types/lodash
```

This command downloads the declaration files from the DefinitelyTyped repository and saves them in your project's `node_modules` directory. Including these type definitions enables TypeScript to correctly check types and provide autocompletion when using the library. Some libraries may already include their own declaration files, which means you won't need to install them separately.
