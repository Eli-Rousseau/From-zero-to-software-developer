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
       | module                 | Defines the module system for the compiled JavaScript.                                                  | `CommonJS`      |
       | rootDir                | Sets the directory for the source TypeScript files.                                                     | `./src`         |
       | outDir                 | Specifies the directory where the compiled JavaScript files will be output.                             | `./dist`        |
       | removeComments         | Removes comments from the compiled JavaScript files.                                                    | `true`          |
       | noEmitOnError          | Determines if JavaScript files should be generated when there are TypeScript errors.                    | `true`          |
       | noImplicitReturns      | Compiler prevents functions from returning `undefined` by default when no return statement is provided. | `true`          |
       | noImplicitOverride     | Compiler ensures that defines the method that have to be overwritten.                                   | `true`          |
       | experimentalDecorators | Enables the creation and usage of decorators.                                                           | `true`          |
     
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

## 3. Generics

#### 3.1 Generic Classes

Generic classes in TypeScript allow you to create flexible, reusable class definitions that can work with different types without redefining the class for each type. You define a generic class by adding type parameters (e.g., `T`) in angle brackets (`<>`) after the class name. These parameters can be used to specify property or method types inside the class, making the class adaptable to multiple types while maintaining type safety.

```typescript
class Container<T> {
    value: T;
    constructor(value: T) {
        this.value = value;
    }
    getValue(): T {
        return this.value;
    }
}
```

#### 3.2 Generic Functions

Generic functions enable you to write flexible and reusable functions that can handle various types. You define a generic function by adding type parameters (e.g., `T`) after the function name in angle brackets (`<>`). The type can be used for function parameters, return types, or within the body. When calling the function, the type can be specified or inferred automatically by TypeScript.

```typescript
function identity<T>(value: T): T {
    return value;
}
```

#### 3.3 Generic Interfaces

Generic interfaces allow you to define adaptable, type-safe structures that can work with different types. You define a generic interface by adding type parameters (e.g., `T`) after the interface name. These parameters can be used throughout the interface to define properties or methods, and actual types can be specified when implementing the interface or creating objects from it.

```typescript
interface Pair<T, U> {
    first: T;
    second: U;
    combine(): [T, U];
}
```

#### 3.4 Generic Constraints

Generic constraints in TypeScript enable you to restrict the types used in a generic type parameter. This is done using the `extends` keyword to ensure the type adheres to certain conditions (e.g., having specific properties or extending a class). Constraints help maintain type safety and prevent improper use of generics by limiting the range of acceptable types.

```typescript
function getLength<T extends { length: number }>(item: T): number {
    return item.length;
}
```

## 4. Decorators

#### 4.1 Introduction to Decorators

Decorators in TypeScript are special functions that modify or extend the behavior of classes, methods, or properties by applying attributes at runtime. They enhance or alter functionality without changing the core code, increasing flexibility and reusability.

```typescript
function SimpleDecorator(constructor: Function) {
    console.log("Class decorator applied!");
}
```

#### 4.2 Class Decorators

Class decorators are applied to an entire class and are used to modify or extend class behavior. They take the class constructor as a parameter and can add or modify properties or methods. Class decorators are invoked automatically at runtime.

```typescript
function LogClass(constructor: Function) {
    constructor.prototype.addedProperty = "New property";
}
@LogClass
class ExampleClass {}
```

#### 4.3 Method Decorators

Method decorators are used to extend or modify the behavior of class methods. They take three parameters: the target object, the method name, and the method’s property descriptor, allowing modifications to the method's behavior or logic.

```typescript
function LogMethod(target: any, methodName: string, descriptor: PropertyDescriptor) {
    const original = descriptor.value;
    descriptor.value = function(...args: any[]) {
        console.log(`Method ${methodName} called with args: ${args}`);
        return original.apply(this, args);
    };
}
class Example {
    @LogMethod
    someMethod(arg: string) {
        console.log(arg);
    }
}
```

#### 4.4 Accessor Decorators

Accessor decorators modify the behavior of getters and setters. Like method decorators, they receive the target, the accessor name, and the property descriptor, allowing custom logic to be injected when a property is accessed or modified.

```typescript
function LogAccessor(target: any, name: string, descriptor: PropertyDescriptor) {
    const originalGet = descriptor.get;
    descriptor.get = function() {
        console.log(`Accessing ${name}`);
        return originalGet?.call(this);
    };
}
class Example {
    private _value: string = "test";

    @LogAccessor
    get value() {
        return this._value;
    }
}
```

#### 4.5 Property Decorators

Property decorators customize class properties. They receive the target object and the property name. Using a property descriptor, they can modify how the property is accessed or set, providing more control over property behavior.

```typescript
function LogProperty(target: any, propertyName: string) {
    let value = target[propertyName];
    Object.defineProperty(target, propertyName, {
        get: () => {
            console.log(`Getting property ${propertyName}`);
            return value;
        },
        set: (newValue) => {
            console.log(`Setting property ${propertyName} to ${newValue}`);
            value = newValue;
        }
    });
}
class Example {
    @LogProperty
    myProperty: string = "initial";
}
```

#### 4.6 Decorator Factories

Decorator factories allow you to create parameterized decorators. They are functions that return a decorator, enabling customization of class, method, or property behavior based on the provided parameters.

```typescript
function LogWithParams(message: string) {
    return function(target: any, propertyKey: string) {
        console.log(`${message}: Decorating ${propertyKey}`);
    };
}
class Example {
    @LogWithParams("Custom Log")
    myMethod() {}
}
```

## 5. Integration with JavaScript

#### 5.1 Allowing JavaScript in TypeScript Projects

In TypeScript projects, you can integrate JavaScript code by modifying the `tsconfig.json` file. Setting `"allowJs": true` allows the inclusion of JavaScript files in your project, and the `"module": "commonjs"` configuration ensures compatibility with the CommonJS module system. This enables seamless imports of JavaScript modules in TypeScript.

```json
{
  "compilerOptions": {
    "allowJs": true,
    "module": "commonjs"
  }
}
```

#### 5.2 Enabling Type Checking for JavaScript

By default, TypeScript doesn't check for type errors in JavaScript files. However, you can enforce type checking on JavaScript by setting `"checkJs": true` in the `tsconfig.json` file. This enhances error detection and type safety in integrated JavaScript code.

```json
{
  "compilerOptions": {
    "checkJs": true
  }
}
```

#### 5.3 Suppressing Type Checking in JavaScript

If you want to bypass TypeScript's type checking for certain JavaScript files or lines of code, you can add `// @ts-nocheck` at the top of the file or `// @ts-ignore` above specific lines. This instructs TypeScript to skip checking the specified code.

```javascript
// @ts-nocheck
function exampleFunction() {
    return "This will not be checked by TypeScript";
}
```

#### 5.4 Using JSDoc for Type Information

JSDoc comments can be used in JavaScript files to provide type information for variables, parameters, and return values. This helps TypeScript infer types and enhances code checking without converting JavaScript to TypeScript.

```javascript
/**
 * @param {number} x
 * @param {number} y
 * @returns {number}
 */
function add(x, y) {
    return x + y;
}
```

#### 5.5 Creating Type Definition Files

You can provide type information for JavaScript files without modifying them by creating a type definition file (`.d.ts`). This file describes the types used in the corresponding JavaScript file, enabling TypeScript to perform type checking when importing the module.

```typescript
// example.d.ts
declare function multiply(a: number, b: number): number;
```

#### 5.6 Adding Type Definitions for Third-Party Libraries

For third-party JavaScript libraries that lack type definitions, you can install them from the DefinitelyTyped repository via npm. This allows TypeScript to perform type checking and provide autocompletion for external libraries.

```bash
npm install --save-dev @types/lodash
```

## 6. Object-Oriented Programming

#### 6.1 Defining and Using Classes

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

#### 6.2 Access Modifiers

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

#### 6.3 Getters and Setters

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

#### 6.4. Static Methods

Static methods belong to the class itself rather than instances, allowing you to define utility functions that do not require object state. You can define static methods using the `static` keyword, making them accessible directly from the class.

```typescript
class StaticExample {
    static staticMethod() {
        return "Static method called";
    }
}

console.log(StaticExample.staticMethod()); // Output: "Static method called"
```

#### 6.5 Inheritance and Method Overriding

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

#### 6.6 Abstract Classes

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

#### 6.7 Interfaces and Polymorphism

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
