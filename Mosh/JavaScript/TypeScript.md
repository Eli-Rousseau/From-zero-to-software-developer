# TypeScript

## 1. Introduction to TypeScript

#### 1.1 Benefits of TypeScript

TypeScript is a programming language built on top of JavaScript, designed to address some of JavaScript's limitations. As a superset of JavaScript, every valid JavaScript code is also valid in TypeScript. TypeScript introduces several key features that make it an excellent choice for developing more maintainable and scalable applications. Its features help prevent common errors and improve the overall quality of the code.

1. **Static Typing**: TypeScript allows developers to define the types of variables, enabling type checking at compile time. This helps catch errors early in the development process, making the code more robust and reducing runtime errors.

2. **Enhanced Development Tools**: Code editors that support TypeScript provide additional features like code completion, automatic refactoring, and better navigation through the codebase, which significantly improves the developer experience.

3. **Additional Features**: TypeScript offers several language features that help write more concise and cleaner code, such as interfaces, enums, and generics, which are not available in plain JavaScript.

4. **Transpilation**: Since browsers do not natively understand TypeScript, the code needs to be transpiled into JavaScript before it can be executed. The TypeScript compiler handles this conversion, ensuring compatibility with all JavaScript environments.

#### 1.2 Setting Up TypeScript Development Environment

To start working with TypeScript, you need to set up the development environment, which involves installing Node.js, the TypeScript compiler, and configuring the project. Here's a step-by-step guide:

1. **Install Node.js and TypeScript Compiler**:
   
   - Begin by installing Node.js, which provides npm (Node Package Manager) to install tools like the TypeScript compiler.
   
   - Open a terminal and install the TypeScript compiler globally with:
     
     ```bash
     npm i -g typescript
     ```
   
   - Verify the installation by checking the TypeScript version:
     
     ```bash
     tsc -v
     ```

2. **Create and Compile TypeScript Files**:
   
   - Use a code editor like Visual Studio Code (VS Code) for writing TypeScript. 
   
   - In your project directory, create a TypeScript file with a `.ts` extension.
   
   - To compile the TypeScript file to JavaScript, run the following command in the terminal:
     
     ```bash
     tsc path/to/your/file.ts
     ```

#### 1.3 Configuring TypeScript Compiler

To manage how TypeScript compiles your code, you can create a configuration file:

1. **Generate `tsconfig.json`**:
   
   - In your project directory, generate a TypeScript configuration file using:
     
     ```bash
     tsc --init
     ```
   
   - This creates a `tsconfig.json` file, which allows you to customize the compilation process.

2. **Key Configuration Options**:
   
   | Configuration Option       | Description                                                                                             | Preferred Value |
   | -------------------------- | ------------------------------------------------------------------------------------------------------- | --------------- |
   | **target**                 | Specifies the JavaScript version to which TypeScript will be compiled.                                  | `es2016`        |
   | **module**                 | Defines the module system for the compiled JavaScript.                                                  | `commonjs`      |
   | **rootDir**                | Sets the directory for the source TypeScript files.                                                     | `./src`         |
   | **outDir**                 | Specifies the directory where the compiled JavaScript files will be output.                             | `./dist`        |
   | **removeComments**         | Removes comments from the compiled JavaScript files.                                                    | `true`          |
   | **noEmitOnError**          | Determines if JavaScript files should be generated when there are TypeScript errors.                    | `true`          |
   | **noUnusedParameters**     | Compiler will shout when function parameters are unused.                                                | `true`          |
   | **noImplicitReturns**      | Compiler prevents functions from returning `undefined` by default when no return statement is provided. | `true`          |
   | **noUnusedLocals**         | Compiler will shout when variables are not read.                                                        | `true`          |
   | **allowUnreachableCode**   | Compiler indicates the codes that is unreachable.                                                       | `false`         |
   | **noImplicitOverride**     | Compiler ensures that defines the method that have to be overwritten.                                   | `true`          |
   | **experimentalDecorators** | Enables the creation and usage of decorators.                                                           | `true`          |
   | **moduleResolution**       | Specify how TypeScript looks up a file from a given module specifier.                                   | `node`          |

#### 1.4 Debugging TypeScript

To debug TypeScript applications in VS Code, follow these steps:

1. **Enable Source Maps**:
   
   - In `tsconfig.json`, enable the `sourceMap` option to create source maps that map TypeScript code to the generated JavaScript code.

2. **Set Up Debugging in VS Code**:
   
   - Open the Debug panel in VS Code and create a `launch.json` file by selecting Node.js to tell VS Code how to launch and debug the program. 
   
   - Add a `preLaunchTask` in `launch.json` to ensure TypeScript is compiled before debugging:
     
     ```json
     "preLaunchTask": "tsc: build - tsconfig.json"
     ```

3. **Using the Debugger**:
   
   - Set breakpoints in your TypeScript code where you want to pause execution.
   - Use debugging tools like "Step Over", "Step Into", and "Step Out" to navigate through the code.
   - You can also add variables to the watch list to monitor their values during execution.

## 2. Built-In Types

#### 2.1 Defining Types

To statically define the type of a constant or variable, you can add a colon (`:`) followed by the type after the variable name. For certain primitive types, such as `number`, `string`, or `boolean`, if you declare a variable without a type, the TypeScript compiler can infer its type based on the assigned value.

```typescript
// Basic types with explicit declaration
let name: string = "Eli";  // string type

// Type inference without explicit declaration
let inferredName = "Mariam";  // TypeScript infers this as a string
```

#### 2.2 Any Type

TypeScript enhances JavaScript by introducing strict typing, but it also includes the `any` type, which provides flexibility by allowing a variable to hold any type of value. When a variable or constant is declared without a specific type or value, it is implicitly assigned the `any` type, which removes type-checking and allows the variable to change its type throughout the code.

```typescript
let variable; // Implicitly of type 'any'
```

Although this flexibility can be convenient, using `any` goes against TypeScript's core purpose of ensuring type safety during compile-time. It is generally advisable to avoid the `any` type to maintain robust, error-free code. When strict type safety is enforced, the risk of unintended bugs is significantly reduced.

#### 2.3 Unknown Type

In TypeScript, both `any` and `unknown` types are used to represent variables that can hold values of any type. However, they have distinct behaviors and uses. 

When a variable is declared with the `any` type, it bypasses TypeScript's type checking. This means that you can call any property or method on a variable of type `any` without causing compilation errors. While this provides flexibility, it also risks introducing runtime errors due to lack of type safety. 

The `unknown` type is similar to `any` in that it can represent any value, but with a key difference. TypeScript will enforce type checks when interacting with a variable of type `unknown`. This means you must perform some type checking or type assertion before accessing properties or calling methods on it.

```typescript
// Using the any type
let anyValue: any= "Hello, TypeScript!";
console.log(anyValue.length); // No error, length is accessed

// Using the unknown type
let unknownValue: unknown = "Hello, TypeScript!";
// console.log(unknownValue.length); // Error: Object is of type 'unknown'.
```

#### 2.3 Arrays

In JavaScript, arrays can hold elements of different types, offering dynamic flexibility but sacrificing type safety. TypeScript addresses this by allowing you to enforce that all elements in an array are of the same type using static type declarations. To define an array's element type in TypeScript, use the square bracket (`[]`) notation after the desired type. If the array is declared empty without a type specification, it defaults to `any[]`, allowing any type to be added. To avoid this, explicitly declare the array's type when initializing it.

```typescript
let array: number[] = [1, 2, 3, 4];
```

#### 2.4 Tuples

In TypeScript, a tuple is a fixed-length array where each element has a specific type. Tuples are commonly used when working with pairs of values, such as key-value pairs, but they can contain more than two elements. Each element in a tuple is statically typed, ensuring that values at specific positions adhere to predefined types. Although tuples can hold more than two elements, it's generally recommended to limit their size for better readability and comprehension. To declare a tuple, define the types for each index in the square bracket notation following the variable or constant declaration.

```typescript
let keyValuePair: [string, number] = ["age", 24];
```

#### 2.5 Enums

In TypeScript, an enum is a way to define a collection of related constants under a single reference, offering a more meaningful and structured approach to managing sets of values compared to individual constants or variables. Enums are defined using the `enum` keyword followed by the name of the enum in PascalCase (where each word starts with a capital letter). By default, enum members are assigned numeric values starting from 0 and incrementing by 1 for each subsequent member. However, you can explicitly set custom values for enum members using the assignment operator. Once an enum is defined, you can create variables or constants of that enum type and assign them one of the enum members. When logging an enum member, its numeric value will be displayed.

```typescript
// Defining an enum for Status Codes
enum StatusCode {
  Success = 200,
  NotFound = 404,
  InternalServerError = 500
}

// Assigning an enum value to a variable
let currentStatus: StatusCode = StatusCode.Success;

// Logging the value of the enum member
console.log(currentStatus);  // Output: 200
```

#### 2.6 Functions

In TypeScript, function parameters and return types can be statically declared to ensure type safety. While the return type of a function is automatically inferred by the compiler when a return statement is provided, it's generally considered good practice to explicitly annotate both parameter types and the return type. To annotate a return type, add a colon after the list of parameters, followed by the expected return type. Additionally, TypeScript allows you to make parameters optional by placing a question mark (`?`) before the parameter name, providing flexibility in function calls.

```typescript
// A function with annotated parameter types and return type
function greet(name: string, age?: number): string {
  if (age) {
    return `Hello, ${name}. You are ${age} years old.`;
  } else {
    return `Hello, ${name}.`;
  }
}

// Function calls
console.log(greet("Mariam"));  // Output: Hello, Mariam.
console.log(greet("Eli", 24)); // Output: Hello, Eli. You are 24 years old.
```

#### 2.7 Objects

In JavaScript, objects are dynamic, and their members can be added or removed during runtime. However, in TypeScript, object structure is more rigid, promoting better type safety and predictability. Objects in TypeScript can have their types explicitly defined, including key-value pairs and method signatures. To define an object type in TypeScript, use the colon `:` followed by curly braces `{}` to specify the types for each key. Optional keys can be defined by appending a question mark (`?`) to the key name, and the `readonly` modifier ensures that certain members are immutable after initialization. Additionally, you can declare argument types and return types for object methods to enhance type safety.

```typescript
// Define an object type with optional and readonly members
const person: { 
  name: string;
  age?: number;
  readonly id: number;
  greet: () => string;
} = {
  name: "Eli",
  id: 101,
  greet: function () {
    return `Hello, my name is ${this.name}.`;
  }
};
```

## 3. Utilities for Managing Types

#### 3.1 Type Aliases

In TypeScript, type aliases provide a way to create custom types. By defining an alias, you can centralize the structure of an object, making the code more reusable and maintainable. To create an alias, use the `type` keyword, followed by a descriptive name in PascalCase. You then define the shape of the object, including its properties, methods, and their respective types. This alias can be used anywhere in the program to ensure consistent type-checking for variables and constants.

```typescript
// Define a type alias for a 'Person' object
type Person = {
  name: string;
  age: number;
  greet: () => string;
};
```

#### 3.2 Union Types

Union types in TypeScript allow a variable or function parameter to accept more than one type, providing flexibility in handling different data types while maintaining type safety. To define a union type, use the pipe (`|`) symbol between the types, indicating that the variable or parameter can hold one of the specified types.

```typescript
// Declare a variable that can hold either number or string types
let id: number | string;
```

#### 3.3 Intersection Types

Intersection types in TypeScript allow a variable or function parameter to accept and combine multiple types at once. By using the ampersand `&` symbol between types, you define that a variable or argument must satisfy all the specified types simultaneously. This ensures that the variable or argument possesses the members and properties of all the involved types, enabling more precise and flexible type definitions in complex scenarios.

```typescript
// Define two separate types
type Person = {
  name: string;
  age: number;
};

type Employee = {
  employeeId: number;
  role: string;
};

// Create an intersection type combining Person and Employee
type PersonEmployee = Person & Employee;

// Example usage
const employee: PersonEmployee = {
  name: "John",
  age: 30,
  employeeId: 12345,
  role: "Software Engineer"
};
```

#### 3.4 Literal Types

Literal types in TypeScript allow you to restrict the values that can be assigned to a variable or constant to specific, exact values. Instead of using a general type like `number` or `string`, you can use literal types to ensure that a variable can only hold specific values. You can also combine multiple literal values using the union operator (`|`), which allows the variable to accept any one of the specified literals. Often, these literals are defined within a type alias to enhance readability and maintainability.

```typescript
// Define a type alias for possible statuses
type Status = "pending" | "in-progress" | "completed";
let status: Status = "pending";
```

#### 3.5 Handling `null` and `undefined` Types

TypeScript is designed to prevent common bugs associated with `null` and `undefined` values by enforcing strict type checking. By default, TypeScript restricts the use of `null` and `undefined` to avoid runtime errors. To allow variables or function parameters to accept these values, you must explicitly declare their types using union types.

```typescript
// Function that accepts a string or null
function greet(name: string | null): void {
  if (name === null) {
    console.log("Hello, guest!");
  } else {
    console.log(`Hello, ${name}!`);
  }
}

// Example usage
greet("Eli");   // Output: Hello, Eli!
greet(null);      // Output: Hello, guest!
```

#### 3.6 Handling Optional Chaining

When working with functions that return values with union types, such as `null` or `undefined`, it's important to ensure that you handle these cases properly to avoid runtime errors. TypeScript provides useful operators to simplify this type checking.

1. **Optional Chaining Operator** (`?.`) allows you to safely access properties or methods on an object that might be `null` or `undefined`. If the object is `null` or `undefined`, the expression returns `undefined` instead of throwing an error.
   
   ```typescript
   // Using optional chaining to safely access properties
   const userName = user?.name;
   ```

2. **Optional Element Access Operator** (`?.[]`) allows you to safely access elements in an array that might be `null` or `undefined`. This ensures that if the array is `null` or `undefined`, the expression returns `undefined` rather than causing an error.
   
   ```typescript
   // Using optional element access to safely acces the first element
   const firstNumber = numbers?.[0]; // Safely accesses the first element
   ```

3. **Optional Call Operator** (`?.()`) in TypeScript provides a way to safely invoke functions or methods that might not exist or might be `null` or `undefined`. This operator helps avoid runtime errors by ensuring that if the function or method is not defined, the invocation will safely return `undefined` rather than causing an exception.
   
   ```typescript
   callback?.()
   ```

#### 3.7 Nullish Coalescing Operator

In TypeScript, when dealing with `null` or `undefined` values, you often need to provide a fallback or default value. The **Nullish Coalescing Operator** (`??`) is specifically designed for this purpose. It allows you to set a default value when the preceding expression evaluates to `null` or `undefined`. Unlike the logical OR operator (`||`), which also considers other falsy values like `0`, `false`, or an empty string as conditions to apply the fallback, the nullish coalescing operator strictly checks for `null` or `undefined` only.

```typescript
// Using the nullish coalescing operator to provide a default value
const value = getValue() ?? "Default value";
```

#### 3.8 Type Assertion

Type assertion in TypeScript allows you to explicitly specify the type of an object when you have more information about the type than the TypeScript compiler can infer. This helps you to override TypeScript's type inference and ensure that an object is treated as a specific type. The type assertion does not perform any type conversion or validation; it merely informs the TypeScript compiler about the type of the object. To perform a type assertion, you use the `as` operator followed by the desired type.

```typescript
// Assume we have an object with an unknown type
const someValue: unknown = "Hello, TypeScript!";

// Assert that the type of someValue is string
const strValue: string = someValue as string;

console.log(strValue); // Output: Hello, TypeScript!
```

## 4. Object-Oriented Programming

#### 4.1 Defining and Using Classes

In TypeScript, a class acts as a blueprint for creating objects, specifying properties and methods for instances. To define a class, use the `class` keyword followed by a PascalCase name. Inside the class body, you define properties and methods. Properties are often initialized within the `constructor` function, which accepts arguments used to set the initial state of the object. The `this` keyword is used to reference the current instance within the class. The `constructor` function does not have a return type as it implicitly returns the instance of the class.

```typescript
class Person {
    name: string;
    age: number;

    constructor(name: string, age: number) {
        this.name = name;
        this.age = age;
    }

    greet() {
        return `Hello, my name is ${this.name} and I am ${this.age} years old.`;
    }
}
```

To create an instance of a class, use the `new` operator followed by the class name and the necessary arguments for initialization. Assigning this instance to a variable allows access to its properties and methods using the dot operator.

```typescript
// Creating an instance of Person
const person = new Person('Eli', 24);
console.log(person.greet()); // Output: Hello, my name is Eli and I am 24 years old.
```

For type checking, the `typeof` operator always returns the reference type `object` when used on a class instance. To determine if an object is an instance of a specific class, use the `instanceof` operator.

```typescript
// Type checking
console.log(typeof person); // Output: object
console.log(person instanceof Person); // Output: true
```

#### 4.2 Read-Only and Optional Properties

In TypeScript, property modifiers control how properties in a class can be accessed and modified. The `readonly` modifier makes a property immutable after it is initialized, meaning it can only be set within the class constructor and cannot be changed afterwards. This is useful for properties that should remain constant once an object is created.

The `optional` modifier, denoted by a question mark (`?`), makes a property optional. This means that the property does not need to be declared or initialized when creating an instance of the class. Optional properties are particularly useful when you want to provide flexibility in object creation.

```typescript
class Car {
    readonly make: string; // Can only be set in the constructor
    readonly model: string;
    optionalYear? number; // Can be omitted when creating an instance

    constructor(make: string, model: string, optionalYear?: number) {
        this.make = make;
        this.model = model;
        this.optionalYear = optionalYear;
    }

    displayInfo() {
        return `Car: ${this.make} ${this.model}${this.optionalYear ? ', Year: ' + this.optionalYear : ''}`;
    }
}

// Creating an instance of Car with optionalYear
const myCar = new Car('Toyota', 'Corolla', 2020);
console.log(myCar.displayInfo()); // Output: Car: Toyota Corolla, Year: 2020
```

#### 4.3 Access Modifiers

In TypeScript, class members can be controlled using three access modifiers: `public`, `private`, and `protected`. By default, class members are `public`, meaning they are accessible from outside the class. You can explicitly declare a member as `public` using the `public` keyword, though this is often redundant since public is the default.

The `private` modifier restricts access to a member so that it can only be accessed within the class itself. This encapsulation helps in hiding implementation details and protecting the internal state of the object. `private` properties are often prefixed with an underscore (`_`) by convention to indicate that they should not be accessed directly from outside the class.

The `protected` modifier allows access to a member within the class and its subclasses, but not from outside the class hierarchy. This is useful for scenarios where a member should be accessible to derived classes but remain hidden from other parts of the program.

```typescript
class Employee {
    public name: string; // Accessible from anywhere
    private salary: number; // Accessible only within Employee class
    protected department: string; // Accessible within Employee and sbclasses

    constructor(name: string, salary: number, department: string) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    // Method to display public information
    public displayInfo() {
        return `Employee: ${this.name}, Department: ${this.department}`;
    }

    // Private method to get salary
    private getSalary() {
        return this.salary;
    }
}

const emp = new Employee('Eli', 50_000, 'Informatics');
console.log(emp.displayInfo()); // Output: Employee: Eli, Department: Informatics
// console.log(emp.getSalary()); // Error: Property 'getSalary' is private and only accessible within class 'Employee'.
```

#### 4.4 Getters and Setters

In TypeScript, getters and setters are special methods in classes designed to control how properties are accessed and modified. They offer a way to encapsulate and manage property values, adding the ability to implement additional logic or validation.

- **Getters**: Defined with the `get` keyword, getters provide a way to access the value of a property as though it were a simple field. They are useful for returning computed values or encapsulating the retrieval process without exposing the underlying implementation.

- **Setters**: Defined with the `set` keyword, setters allow you to update the value of a property. They provide a controlled way to handle changes to the property, making it possible to include validation or other logic when a property value is modified.

```typescript
class User {
    private _age: number; // Private property

    constructor(age: number) {
        this._age = age;
    }

    // Getter for age
    public get age(): number {
        return this._age;
    }

    // Setter for age
    public set age(value: number) {
        if (value < 0) {
            throw new Error('Age cannot be negative.');
        }
        this._age = value;
    }
}

const user = new User(24);

console.log(user.age); // Output: 24

user.age = 25;
console.log(user.age); // Output: 25
```

#### 4.5 Index Signatures for Dynamic Properties

In TypeScript, index signatures allow you to dynamically add properties to an object instance while maintaining type safety. An index signature is defined by using square brackets with a generic name and its type in the class definition. This signature specifies the shape of properties that can be added dynamically, ensuring that the assigned properties conform to the specified type. After creating an instance of the class, new properties that match the index signature can be dynamically added to the object.

```typescript
class DynamicProperties {
    [key: string]: number; // Index signature allowing dynamic string keys with number values
}

const obj = new DynamicProperties();

// Adding properties dynamically
obj["property1"] = 42;
obj["property2"] = 100;

console.log(obj.property1); // Output: 42
console.log(obj.property2); // Output: 100
```

#### 4.6 Static Members

In TypeScript, static properties and methods belong to the class itself rather than to instances of the class. By using the `static` keyword, you can define members that are shared across all instances and can be accessed directly from the class without creating an object instance. Static properties and methods are useful for utility functions or constants that do not depend on instance-specific data.

Static methods are particularly valuable when you need functionality that does not rely on object-specific data but still logically belongs to the class. This allows you to invoke methods directly from the class itself, making the code more efficient when creating an instance isn't necessary.

```typescript
class MathUtils {
    // Static property
    static PI: number = 3.14159;

    // Static method for calculating the area of a circle
    static calculateArea(radius: number): number {
        return this.PI * radius * radius;
    }
}

// Accessing static property and method without creating an instance
console.log(MathUtils.PI); // Output: 3.14159
console.log(MathUtils.calculateArea(5)); // Output: 78.53975
```

#### 4.7 Inheritance

Inheritance is a mechanism in TypeScript that allows classes to share common properties and methods by reusing code from a base class. Instead of duplicating code across multiple classes that share similar functionality, inheritance enables you to define common features in a single parent class, which can then be extended by child classes.

To implement inheritance, you first create a parent class that contains shared properties and methods. Child classes use the `extends` keyword to inherit from the parent class. When extending a class, the child class can access the properties and methods of the parent class, ensuring code reuse. The `super` keyword is used in the child class to call the constructor of the parent class, ensuring that inherited properties are initialized correctly.

```typescript
// Parent class
class Animal {
    name: string;

    constructor(name: string) {
        this.name = name;
    }
}

// Child class inheriting from Animal
class Dog extends Animal {
    constructor(name: string) {
        super(name); // Call the parent class constructor
    }
}

const dog = new Dog('Buddy');
```

#### 4.8 Method Overriding

Method overriding is a concept in TypeScript where a child class provides a specific implementation of a method that it inherits from a parent class. This allows the child class to alter the behavior of the inherited method to suit its specific needs. To ensure that the compiler recognizes that a method is being overridden, the `override` keyword is used in the child class's method declaration.

```typescript
class Animal {
    makeSound(): void {
        console.log("Animal makes a sound.");
    }
}

class Dog extends Animal {
    // Overriding the makeSound method
    override makeSound(): void {
        console.log("Dog barks.");
    }
}

const animal = new Animal();
animal.makeSound(); // Output: Animal makes a sound.

const dog = new Dog();
dog.makeSound(); // Output: Dog barks.
```

#### 4.9 Polymorphism

Polymorphism is a key concept in OOP that allows the same method to behave differently based on the object it is invoked upon. This flexibility eliminates the need for long conditional statements like `if...else` or `switch...case` by allowing different objects to automatically use their own method implementations. In TypeScript, polymorphism is commonly implemented through method overriding, where child classes provide specific implementations of methods inherited from a parent class. 

Polymorphism allows multiple objects from different classes to share a common method signature but implement it in their own way, depending on their unique requirements. This technique enhances code flexibility, readability, and maintainability, making it easier to manage complex systems.

```typescript
class Animal {
    makeSound(): void {
        console.log("Animal makes a sound.");
    }
}

class Dog extends Animal {
    // Overriding the makeSound method
    override makeSound(): void {
        console.log("Dog barks.");
    }
}

class Cat extends Animal {
    // Overriding the makeSound method
    override makeSound(): void {
        console.log("Cat meows.");
    }
}

// Polymorphism in action
const animals: Animal[] = [new Dog(), new Cat()];

animals.forEach((animal) => {
    animal.makeSound(); // Each animal uses its own implementation of makeSound
});
```

#### 4.10 Abstract Classes

Abstract classes in TypeScript allow you to define common properties and methods that can be shared by multiple child classes, while leaving the implementation of certain methods to the child classes. An abstract class provides a template for other classes to inherit from but cannot be instantiated directly. It is used to represent a conceptual base from which other, more specific classes derive.

By using the `abstract` keyword, you define both the abstract class and its abstract methods. These methods do not have a direct implementation in the base class and must be overridden by the child classes. Abstract classes help enforce a structure while allowing flexibility in how specific functionality is implemented.

```typescript
// Abstract base class
abstract class Vehicle {
    abstract startEngine(): void; // Abstract method to be implemented by child classes

    stopEngine(): void {
        console.log("Engine stopped.");
    }
}

// Child class implementing abstract method
class Car extends Vehicle {
    override startEngine(): void {
        console.log("Car engine started.");
    }
}

// Abstract class cannot be instantiated
// const vehicle = new Vehicle(); // Error: Cannot create an instance of an abstract class

const car = new Car();
car.startEngine(); // Output: Car engine started.
car.stopEngine();  // Output: Engine stopped.
```

#### 4.11 Interfaces

In TypeScript, interfaces are used to define the structure, or "shape," of objects. They specify the properties and methods that any class implementing the interface must have. Interfaces serve as a contract that ensures any class inheriting from it will implement all the required members, promoting consistency across different implementations.

To create an interface, use the `interface` keyword followed by a name. Inside the interface, you declare properties and methods along with their types, but without providing any actual implementation. Classes that implement the interface must define the actual logic for the methods and ensure the required properties are present. The `implements` keyword is used by the class to inherit the structure of the interface.

```typescript
// Define an interface
interface Animal {
    name: string;
    makeSound(): void;
}

// Implement the interface in a class
class Dog implements Animal {
    name: string;

    constructor(name: string) {
        this.name = name;
    }

    makeSound(): void {
        console.log(`${this.name} barks.`);
    }
}

const dog = new Dog("Buddy");
dog.makeSound(); // Output: Buddy barks.
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
