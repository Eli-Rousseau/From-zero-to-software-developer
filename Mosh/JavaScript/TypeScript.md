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
   
   | Configuration Option | Description                                                                          | Default Value |
   | -------------------- | ------------------------------------------------------------------------------------ | ------------- |
   | **target**           | Specifies the JavaScript version to which TypeScript will be compiled.               | `es2016`      |
   | **module**           | Defines the module system for the compiled JavaScript.                               | `commonjs`    |
   | **rootDir**          | Sets the directory for the source TypeScript files.                                  | `./src`       |
   | **outDir**           | Specifies the directory where the compiled JavaScript files will be output.          | `./dist`      |
   | **removeComments**   | Removes comments from the compiled JavaScript files.                                 | `true`        |
   | **noEmitOnError**    | Determines if JavaScript files should be generated when there are TypeScript errors. | `true`        |

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

#### 2.3 Array

In JavaScript, arrays can hold elements of different types, offering dynamic flexibility but sacrificing type safety. TypeScript addresses this by allowing you to enforce that all elements in an array are of the same type using static type declarations. To define an array's element type in TypeScript, use the square bracket (`[]`) notation after the desired type. If the array is declared empty without a type specification, it defaults to `any[]`, allowing any type to be added. To avoid this, explicitly declare the array's type when initializing it.

```typescript
let array: number[] = [1, 2, 3, 4];
```

#### 2.4 Tuple

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


