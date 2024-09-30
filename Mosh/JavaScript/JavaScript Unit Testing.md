# JavaScript Unit Testing

## 1. Introduction

#### 1.1 The Importance of Unit Testing

Unit testing is a method of automated testing where code is written to test individual components of the application to ensure they function as expected. This process eliminates the need for manual procedural testing by allowing automated tools, called test runners, to execute tests and provide results, typically displayed as green check marks for success or red crosses for failures. Unit testing enables the execution of hundreds or thousands of tests in seconds, making it far more efficient than manual testing.

Automated testing divides the codebase into two types: production code and test code, both of which are run after any code changes to detect errors early in development. This not only improves code quality and refactoring confidence but also acts as documentation on how functions should behave. 

However, a balance is required. Testing every line of code can be costly, especially in fast-evolving projects where requirements change frequently, leading to broken tests. In such cases, the focus should be on pragmatism. New projects may require less extensive testing, while stable projects with well-defined requirements can benefit from comprehensive test coverage, particularly for critical modules. Ultimately, unit testing is an investment in maintaining code quality.

#### 1.2 Types of Automated Testing

In automated testing, there are three main types of tests:

1. **Unit Tests**: These focus on verifying individual components, such as functions or classes, in isolation. Unit tests are ideal for catching bugs early in development and are the fastest to execute, offering quick feedback.

2. **Integration Tests**: These assess how different parts of an application work together, checking for issues such as data flow, communication, and compatibility problems that arise when combining components.

3. **End-to-End Tests**: These simulate real user interactions with the entire system, ensuring the application functions as a whole. While they provide the highest confidence in the application's overall functionality, they are slower to run.

A common recommendation is to write more unit tests than integration tests, and more integration tests than end-to-end tests. However, the exact balance depends on the nature of the application. Unit tests are fast but offer limited assurance that the full system will work correctly. End-to-end tests, though slow, offer the most confidence in the application's final behavior.

#### 1.3 Testing Framework

A testing framework offers a comprehensive set of tools to help developers write and execute tests efficiently. These frameworks typically include a **test runner** for executing tests, **assertion libraries** to validate whether the code behaves as expected, and **mocking tools** to simulate modules and create different test scenarios. Additionally, they often feature **test coverage tools** to measure how much of the code is covered by tests, ensuring more thorough testing. These integrated tools streamline the testing process and enhance the overall quality of the application.

#### 1.4 Setting up Vitest

Vitest is a modern testing framework designed specifically for JavaScript, with built-in support for ESM, TypeScript, and JSX, making it ideal for React projects. To use Vitest, install it as a development dependency by running the following command:

```bash
npm install -D vitest
```

After installation, configure the **package.json** file by adding a test script under the `"scripts"` object:

```json
{
  "scripts": {
    "test": "vitest"
  }
}
```

Now, running `npm test` will execute your tests using Vitest, making it simple to integrate automated testing into your project.

```bash
npm test  # Runs all Vitest tests
```

#### 1.5 Writing Unit Tests With Vitest

To write unit tests with Vitest, begin by creating a **tests** folder in the root of your project. Vitest recognizes files with a `.test.js` suffix. Inside a test file, you can import Vitest functions like `describe`, `test`, `it`, and `expect`.

A typical test suite is created using the `describe` function, which groups related tests. It accepts two arguments: a string describing the test suite (often the unit being tested) and a function that contains the test cases. The `test` or `it` functions are used to define individual test cases, which also take two arguments—a descriptive name for the test and a function to be executed by the test runner.

Tests should follow the **AAA pattern**:

1. **Arrange**: Set up the test environment.
2. **Act**: Perform the action being tested.
3. **Assert**: Use the `expect` function to check if the outcome matches the expectation, with chainable matchers like `toBe`, `toBeCalled`, `toBeDefined`, and others.

After writing your tests, run `npm test` to validate them.

```javascript
// Example unit test with Vitest

import { describe, it, expect } from 'vitest';
import { add } from '../src/math';

describe('add function', () => {
  it('should add two numbers correctly', () => {
    // Arrange
    const a = 2;
    const b = 3;

    // Act
    const result = add(a, b);

    // Assert
    expect(result).toBe(5);  // Check if result is as expected
  });
});
```

Run the tests using:

```bash
npm test  # Executes all test cases with Vitest
```

#### 1.6 Code First vs. Test-Driven Development

In **code-first development**, the application code is written before the tests. Once the code is functional, the process involves writing tests to validate the behavior of specific parts of the code. After writing a test, it's common practice to intentionally break the part of the code being tested to ensure that the test is properly synchronized with the code and catches the issue.

In **Test-Driven Development (TDD)**, the process is reversed: tests are written first, and then the application code is created to make the tests pass. TDD follows a structured three-step cycle:

1. Write a failing test.
2. Write just enough code to pass the test.
3. Refactor the code if needed.

This approach ensures that the code is 100% covered by tests and helps avoid over-engineering, as developers write only the necessary code to meet the requirements of the tests.

#### 1.7 Terminal Shortcuts and UI

When running tests in Vitest via the terminal, several useful shortcuts are available. Press `h` for help to see options such as `a` to rerun all tests, `f` to rerun only failed tests, and `p` to filter tests by name, among others.

Vitest also offers a UI, especially useful for testing React applications as it allows visualization of the DOM structure during testing. To enable the UI, update the **package.json** file by adding a new script under the `"scripts"` object:

```json
{
  "scripts": {
    "test:ui": "vitest --ui"
  }
}
```

To launch the Vitest UI, run the following command in the terminal:

```bash
npm run test:ui
```

This opens the Vitest UI in the browser, displaying all test files, individual unit tests, and their validation states, providing an intuitive way to monitor and manage tests.

#### 1.8 Measuring Code Coverage with Vitest

To ensure your production code is adequately tested, it's important to measure how much of the code is covered by tests. In Vitest, you can enable code coverage by adding the following script to the **package.json** file:

```json
{
  "scripts": {
    "coverage": "vitest run --coverage"
  }
}
```

You can run the coverage tool with the command:

```bash
npm run coverage
```

This generates a **coverage** folder in your project, which includes an `index.html` file. Opening this file in a browser provides detailed metrics on test coverage, highlighting which parts of your code are covered by tests and which are not. To prevent this folder from being included in version control, add it to your `.gitignore` file.

```bash
# Add to .gitignore to exclude coverage folder
coverage/
```

This helps you identify untested areas in your codebase, ensuring better test coverage and more reliable software.

## 2. Core Unit Testing Techniques

#### 2.1 Characteristics of Good Unit Tests

Not all unit tests contribute equally to software quality. Poorly written tests can be more harmful than having no tests at all, as they can create obstacles during development. Good unit tests are **maintainable**, **robust**, and **trustworthy**.

- **Maintainable**: A good test is concise (ideally under 10 lines), with clear variable names and proper formatting. Each test should focus on a single behavior and have a descriptive name.

- **Robust**: A robust test is resilient to changes in code. It should test the behavior of the code, not its implementation. Avoid tight assertions like specific error messages or text outputs, which are prone to change.

- **Trustworthy**: A trustworthy test validates the correct behavior under all conditions, including edge cases and boundary conditions. Tests should be deterministic—free from dependence on random data, global state, or the current date and time.

#### 2.2 Vitest Matchers

Vitest provides a variety of matchers to assert different conditions when testing your code. These matchers are used in specific scenarios such as equality checks, truthiness, numerical comparisons, string matching, object/array checks, and handling exceptions. Here’s a summary of the key matchers and their usage:

| **Matcher**                  | **Use Case**                                     |
| ---------------------------- | ------------------------------------------------ |
| **toBe**                     | For comparing primitive values (strict equality) |
| **toEqual**                  | For comparing reference values (objects, arrays) |
| **toBeTruthy**               | For checking if a value is truthy                |
| **toBeFalsy**                | For checking if a value is falsy                 |
| **toBeNull**                 | For checking if a value is `null`                |
| **toBeUndefined**            | For checking if a value is `undefined`           |
| **toBeDefined**              | For checking if a value is defined               |
| **toBeGreaterThan**          | For comparing numbers (greater than)             |
| **toBeGreaterThanOrEqualTo** | For comparing numbers (greater than or equal to) |
| **toBeLessThan**             | For comparing numbers (less than)                |
| **toBeLessThanOrEqualTo**    | For comparing numbers (less than or equal to)    |
| **toBeCloseTo**              | For comparing floating point numbers             |
| **toMatch**                  | For matching strings against regular expressions |
| **toMatchObject**            | For partial matching of object properties        |
| **toHaveProperty**           | For checking if an object has a property         |
| **toContain**                | For checking if an array contains an element     |
| **toHaveLength**             | For checking the length of arrays/strings        |
| **toThrowError**             | For checking if a function throws an error       |

#### 2.3 Positive vs. Negative Testing

**Positive testing** verifies that an application behaves correctly under expected conditions, using valid inputs and standard scenarios. It ensures that the application produces the desired results when everything works as intended.

**Negative testing**, on the other hand, focuses on how the application handles unexpected or incorrect inputs, such as invalid data, empty fields, or edge cases. This approach helps identify how robust the application is when faced with errors or unusual inputs.

Both testing types are crucial for creating resilient software, as they complement each other in validating the stability and reliability of an application.

```javascript
// Example: Positive and Negative Testing in Vitest

import { describe, it, expect } from 'vitest';
import { divide } from '../src/math';

describe('divide function', () => {
  // Positive Test: Valid input
  it('should correctly divide two positive numbers', () => {
    const result = divide(10, 2);
    expect(result).toBe(5);  // Expected output: 5
  });

  // Negative Test: Division by zero
  it('should throw an error when dividing by zero', () => {
    expect(() => divide(10, 0)).toThrowError('Cannot divide by zero');
  });
});
```

#### 2.4 Boundary Testing: Ensuring Reliability at Input Extremes

**Boundary testing** is a technique used to validate the behavior of software at the limits or edges of input values. By focusing on extreme or boundary conditions—such as minimum, maximum, and just-beyond-the-limit inputs—this testing method ensures the software handles these edge cases correctly.

```javascript
// Example: Boundary Testing in Vitest

import { describe, it, expect } from 'vitest';
import { isValidAge } from '../src/validation';

describe('isValidAge function', () => {
  // Test ages outside the boundaries
  it ('should return a falsy value outside the boundary', {
    expect(isValidAge(17)).toBeFalsy();
    expect(isValidAge(101)).toBeFalsy();
  });

  // Test ages right at the boundaries
  it ('should return a true value at the boundaries', {
    expect(isValidAge(18)).toBeTruthy();
    expect(isValidAge(100)).toBeTruthy();
  });

  // Test age inside the boundaries
  it ('should return a true value inside the boundaries', {
    expect(isValidAge(56)).toBeTruthy();
  });
});
```

#### 2.5 Defensive Programming

**Defensive programming** is a practice where input is validated to ensure it meets the desired type and format. If the input is invalid, the program should handle the error gracefully, often by throwing an error or returning an appropriate response. This technique is crucial for functions that handle user-provided input, as it helps prevent errors caused by invalid data.

In **unit testing**, it's also important to verify that defensive programming logic works as expected, ensuring that invalid inputs are properly handled. However, defensive programming is typically only needed in functions exposed to the user, as inner functions generally receive valid input and do not require such checks.

```javascript
// Example: Defensive Programming with Input Validation in Vitest

import { describe, it, expect } from 'vitest';
import { processUserInput } from '../src/user';

describe('processUserInput function', () => {
  // Test defensive programming:
  // The 'toMatch' method is used to check if the returned message 
  // contains 'invalid', ignoring case sensitivity.
  it('should throw an error for non-string input', () => {
    expect(processUserInput(123)).toMatch(/invalid/i);
  });
});
```

#### 2.6 Parameterized Tests

**Parameterized tests** (also known as **data-driven tests**) allow the same test to be run multiple times with different sets of input data. Instead of writing separate test cases for each input scenario, a single test can be executed repeatedly with various input values, making testing more efficient and reducing code duplication.

In Vitest, this is achieved using the `each` method on the `it` function. By passing an array of objects with desired properties (such as input values and expected results), the test runs for each set of data. You can also include dynamic values in the test name using placeholders with a dollar sign (`$`), which makes it easy to track each test case.

```javascript
// Example: Parameterized Tests in Vitest

import { describe, it, expect } from 'vitest';
import { calculateDiscount } from '../src/pricing';

describe('calculateDiscount function', () => {
  // Parameterized test using `it.each`
  it.each([
    { price: 100, discount: 0.1, expected: 90 },  // 10% discount
    { price: 50, discount: 0.2, expected: 40 },   // 20% discount
    { price: 200, discount: 0.5, expected: 100 }, // 50% discount
  ])('should apply a discount of $discount to a price of $price', ({ price, discount, expected }) => {
    const result = calculateDiscount(price, discount);
    expect(result).toBe(expected);  // Check that the calculated result matches the expected value
  });
});
```

#### 2.7 Testing Asynchronous Code

When testing asynchronous code, such as functions that return promises, it is best practice to use **async/await** in your test functions. This ensures that the test waits for the promise to resolve before making assertions. Additionally, wrapping asynchronous code in a **try-catch** block allows proper handling of rejected promises, ensuring that the test can appropriately deal with errors.

```javascript
// Example: Testing Asynchronous Code in Vitest

import { describe, it, expect } from 'vitest';
import { fetchData } from '../src/api';

describe('fetchData function', () => {
  // Test an asynchronous function using async/await
  it('should return data when the promise resolves', async () => {
    try {
      const result = await fetchData();
      expect(result).toEqual({ id: 1, name: 'Test' }); // Check the fetched data
    } 
    // Test handling promise rejection
    catch (error) {
      expect(error).toMatch(/failed to fetch/i); // Verify error message
    }
  });
});
```

#### 2.8 Setup and Teardown

In testing, it's important to ensure a consistent environment before tests run and to clean up resources after tests complete. This can include tasks like opening and closing database connections or setting up and tearing down temporary data. In Vitest, you can manage this process using the `beforeEach`, `beforeAll`, `afterEach`, and `afterAll` hooks. These functions allow you to execute setup and cleanup code at different stages of the test lifecycle.

- **`beforeEach`**: Runs before each test in the suite.
- **`beforeAll`**: Runs once before all tests in the suite.
- **`afterEach`**: Runs after each test in the suite.
- **`afterAll`**: Runs once after all tests in the suite.

```javascript
// Example: Setup and Teardown in Vitest

import { describe, it, expect, beforeAll, afterAll } from 'vitest';
import { connectToDatabase, closeDatabase, fetchData } from '../src/db';

describe('Database Tests', () => {
  // Setup: Establish a database connection before all tests
  beforeAll(async () => {
    await connectToDatabase();
  });

  // Teardown: Close the database connection after all tests
  afterAll(async () => {
    await closeDatabase();
  });

  // Test case: Fetch data from the database
  it('should fetch data successfully', async () => {
    const data = await fetchData();
    expect(data).toEqual({ id: 1, name: 'Test User' });
  });
});
```

## 3. Breacking Dependencies With Mocks

#### 3.1 Understanding Mocks for Breaking Dependencies

A **mock function** imitates the behavior of a real function, allowing units to be tested in isolation by decoupling dependencies. For example, if function \( A \) relies on function \( B \), you can replace \( B \) with a mock to test \( A \) without depending on \( B \)’s actual implementation. While mocks are valuable for breaking dependencies and focusing tests on specific units, they can introduce risks if the original implementation of the mocked function changes, as the mock may not reflect those updates, leading to inaccurate tests. Therefore, mocks should be used sparingly, primarily for external dependencies like services or APIs, and not overused, as this can make tests overly dependent on implementation details and fragile.

#### 3.2 Creating and Using Mock Functions

In Vitest, the `vi` object is used to create and manage mock functions. Here’s how you can do it step by step:

- **Creating the Mock Function**:  
  To create a mock function, use the `vi.fn()` method, which generates a mock function that defaults to returning `undefined`.
  
  ```javascript
  // Create a mock function
  const myMockFunction = vi.fn();
  ```

- **Customizing the Mock Function's Behavior**:  
  You can customize the behavior of the mock function using various methods:
  
  - **Return a specific value**: Use `mockReturnValue()` to set a fixed return value.
    
    ```javascript
    // Set the mock to return a specific value
    myMockFunction.mockReturnValue(42);
    ```
  
  - **Simulate a promise**: Use `mockResolvedValue()` to make the mock function return a promise that resolves to a specified value.
    
    ```javascript
    // Set the mock to return a promise
    myMockFunction.mockResolvedValue('Success');
    ```
  
  - **Define custom logic**: Use `mockImplementation()` to provide custom behavior for the mock function.
    
    ```javascript
    // Define a custom implementation for the mock function
    myMockFunction.mockImplementation((arg) => `Processed ${arg}`);
    ```

- **Making Assertions**:  
  Vitest offers several matchers to assert the behavior of your mock functions:
  
  - **Check if the mock was called**: Use `toHaveBeenCalled()`.
    
    ```javascript
    expect(myMockFunction).toHaveBeenCalled();
    ```
  
  - **Check if the mock was called with specific arguments**: Use `toHaveBeenCalledWith()`.
    
    ```javascript
    expect(myMockFunction).toHaveBeenCalledWith('inputValue');
    ```
  
  - **Verify the mock was called exactly once**: Use `toHaveBeenCalledOnce()`.
    
    ```javascript
    expect(myMockFunction).toHaveBeenCalledOnce();
    ```

#### 3.3 Mocking Modules

In Vitest, you can use the `vi.mock()` method to mock a specific module by passing the module's path. When this function is executed, Vitest automatically replaces all exported functions of the specified module with mock functions. By default, these mock functions do not have any behavior, so you'll need to define their behavior within your test.

To customize the behavior of a mock function, you can use the `vi.mocked()` method and pass a reference of the function as an argument. This allows you to access the specific unit and modify its behavior or make assertions as previously discussed. Mocking modules helps facilitate unit tests by replacing real dependencies with mock functions.

```javascript
// file: math.js
export const add = (a, b) => a + b;
export const subtract = (a, b) => a - b;

// file: calculator.js
import { add, subtract } from './math';

export const calculateSum = (a, b) => add(a, b);
export const calculateDifference = (a, b) => subtract(a, b);

// file: calculator.test.js
import { describe, it, expect, vi } from 'vitest';
import { calculateSum, calculateDifference } from './calculator';
import * as math from './math'; // Import the module to mock

// Mock the math module
vi.mock('./math');

describe('Calculator Tests', () => {
  it('should return the sum of two numbers', () => {
    // Set up mock for the add function
    vi.mocked(math.add).mockReturnValue(5); // Mock implementation

    const result = calculateSum(2, 3);
    expect(result).toBe(5); // Assert the result
    expect(math.add).toHaveBeenCalledWith(2, 3); // Assert it was called with correct arguments
  });

  it('should return the difference of two numbers', () => {
    // Set up mock for the subtract function
    vi.mocked(math.subtract).mockReturnValue(1); // Mock implementation

    const result = calculateDifference(3, 2);
    expect(result).toBe(1); // Assert the result
    expect(math.subtract).toHaveBeenCalledWith(3, 2); // Assert it was called with correct arguments
  });
});
```

#### 3.4 Interaction Testing with Mock Functions

Interaction testing focuses on verifying how different units or functions interact with each other. Mock functions play a key role in this process by allowing you to simulate and control these interactions. In Vitest, mock functions serve two main purposes: they help retrieve specific return values during testing, and they enable you to test whether functions were called, how often they were invoked, and with what arguments.

```javascript
// file: userService.js
export const fetchUser = (id) => {
  // Simulates fetching user data
  return { id, name: 'Eli' };
};

// file: userController.js
import { fetchUser } from './userService';

export const getUserDetails = (id) => {
  const user = fetchUser(id);
  return `${user.name} (ID: ${user.id})`;
};

// file: userController.test.js
import { describe, it, expect, vi } from 'vitest';
import { getUserDetails } from './userController';
import * as userService from './userService';

// Mock the fetchUser function
vi.mock('./userService');

describe('getUserDetails', () => {
  it('should call fetchUser and return user details', () => {
    // Set up mock for fetchUser
    vi.mocked(userService.fetchUser).mockReturnValue({ id: 1, name: 'Eli' });

    const result = getUserDetails(1);

    // Assert fetchUser was called with correct argument
    expect(userService.fetchUser).toHaveBeenCalledWith(1);

    // Assert the correct details are returned
    expect(result).toBe('Eli (ID: 1)');
  });
});
```

#### 3.5 Partial Mocking

Partial mocking allows you to mock only specific functions in a module while leaving others unchanged, which is useful when certain functions, such as input validators or constants, should retain their original implementation during testing. To achieve partial mocking in Vitest, you can use the `vi.mock()` method with a custom implementation that selectively overrides the desired functions.

To do this, call `vi.mock()` with two arguments. The first argument is the path to the module, while the second is an asynchronous function that receives the `importOriginal` method. This method imports the original module, and from there, you can selectively mock specific functions. Using the spread operator, you can retain the functions that don't need to be mocked, ensuring that only the necessary parts of the module are replaced with mock functions. This approach provides flexibility in testing without altering the behavior of valid dependencies that don't need mocking.

```javascript
// file: mathUtils.js
export const add = (a, b) => a + b;
export const multiply = (a, b) => a * b;
export const isPositive = (n) => n > 0;

// file: math.test.js
import { describe, it, expect, vi } from 'vitest';
import * as mathUtils from './mathUtils';

// Partially mock the module
vi.mock('./mathUtils', async (importOriginal) => {
  const originalModule = await importOriginal();

  return {
    ...originalModule, // Retain all original exports
    multiply: vi.fn().mockReturnValue(10), // Mock only the `multiply` function
  };
});

describe('mathUtils partial mocking', () => {
  it('should mock multiply but keep add and isPositive unchanged', () => {
    // Test the mocked multiply function
    expect(mathUtils.multiply(2, 3)).toBe(10);

    // Test the original add function
    expect(mathUtils.add(2, 3)).toBe(5);

    // Test the original isPositive function
    expect(mathUtils.isPositive(-1)).toBe(false);
  });
});
```

#### 3.6 Spying on Functions

Spying allows you to observe and track the behavior of functions during test execution, collecting information about function calls, arguments, and results. In Vitest, you can create a spy using the `vi.spyOn()` method, which enables you to monitor how a particular function or method behaves without altering its implementation.

To create a spy, call `vi.spyOn()` with two arguments: the first is the object containing the method you want to spy on, and the second is a string representing the name of the method to monitor. Once a spy is set up, you can access information like the return value of the function using `spy.mock.results[0].value`. This is particularly useful in partial mocking, where you need to verify that the spied function is being called correctly, for example, by using assertions such as `toHaveBeenCalledWith()`.

```javascript
// Example of spying on a method
const userService = {
  getUser: (id) => ({ id, name: 'Eli' })
};

// Create a spy on the getUser method
const spy = vi.spyOn(userService, 'getUser');

// Call the method
userService.getUser(1);

// Check the return value of the first call
console.log(spy.mock.results[0].value);  // Output: { id: 1, name: 'Eli' }

// Assert that the method was called with specific arguments
expect(spy).toHaveBeenCalledWith(1);
```

#### 3.7 Clearing, Resetting, and Restoring Mocks

When using mock functions in Vitest, it's important to clear them between tests to avoid unintended side effects caused by lingering information, such as the number of times a mock function was called. Mock objects accumulate data across tests, which can lead to inaccurate test results if not properly cleared. To ensure a clean state for each test, use the `mockClear()` method to clear individual mock functions.

```javascript
beforeEach(() => {
  vi.mocked(originalFunction).mockClear();
});
```

Alternatively, to clear all mocks at once in a test suite, use:

```javascript
beforeEach(() => {
  vi.clearAllMocks();
});
```

By incorporating these practices, you ensure that your mock functions are reset between tests, helping maintain reliable and accurate test results.

#### 3.7 Mocking System Time

For tests to be trustworthy, they must be deterministic—producing the same result every time they run. To achieve this, tests should not depend on random data, current date/time, or global state. When testing functions that rely on the current date or time, it's important to mock the system date to simulate consistent scenarios.

Vitest provides the `vi.setSystemTime()` method, which allows you to set a mock date and time. You can pass a date string, such as `"2024-01-01 12:00"`, to this method, ensuring that any functions relying on the system time will use this mock value. This guarantees that tests involving date/time dependencies will always run under the same conditions.

```javascript
import { describe, it, expect, vi } from 'vitest';

describe('Date-dependent function', () => {
  beforeAll(() => {
    // Mock the system time to a specific date
    vi.setSystemTime(new Date('2024-01-01 12:00'));
  });

  it('should return correct result for the mocked date', () => {
    const result = myDateFunction(); // function using current date
    expect(result).toBe('Expected result for 2024-01-01 12:00');
  });

  afterAll(() => {
    // Restore original system time
    vi.useRealTimers();
  });
});
```

By mocking the system time, you ensure consistent and reliable tests that aren't affected by real-time changes.

## 4. Improving Code Quality With Static Analysis Tools

Static analysis tools examine source code without executing it, identifying potential issues early in the development process. These tools help enforce coding standards and best practices, enhancing code quality and ensuring consistency across the team.

#### 4.1 Formatting Code With Prettier

**Prettier** is  a widely-used code formatter that supports multiple programming languages. Prettier enforces a uniform code style, making code more readable and minimizing formatting-related discussions during code reviews. To integrate Prettier into your project, install it as a development dependency:

```bash
npm i -D prettier
```

Next, configure Prettier in your `package.json` by adding a script under the `scripts` section:

```json
"scripts": {
  "format": "prettier . --write"
}
```

Now, you can format your entire project by running:

```bash
npm run format
```

For further customization, create a `.prettierrc.json` file to define specific formatting rules. Additionally, editors like VS Code offer a Prettier extension, enabling features like **Format on Save**, which automatically formats your code each time you save a file.

```json
{
  "singleQuote": true,
  "trailingComma": "es5",
  "tabWidth": 2
}
```

#### 4.2 Listing Code With ESLint

**ESLint** is a popular tool for ensuring code quality in JavaScript. It helps catch common mistakes early, enforces coding standards, and improves consistency and readability across projects. To add ESLint to a project, you can initialize it with the following command:

```bash
npm init @eslint/config@latest
```

During installation, ESLint will prompt you to configure various options, such as:

- **Checking for Syntax, Problems, and Style**: Choose whether ESLint should only check syntax, identify problems, or enforce code style.
- **Module Type**: Specify whether you're using **JavaScript Modules (ESM)** or **CommonJS**.
- **Framework**: Indicate if your project uses a framework like **React** or **Vue**.
- **TypeScript**: Specify whether the project includes TypeScript.
- **Environment**: Choose between **Node.js** or **browser** for the project runtime.
- **Style Guide**: Select or customize a coding style guide.
- **Configuration File Format**: Choose JSON, JavaScript, or YAML for ESLint configuration.
- **Package Manager**: Choose between **npm** or **yarn** for managing dependencies.

After completing the setup, ESLint will install and generate a `.eslintrc.json` file in your project, which you can modify to customize ESLint's rules.

To lint your code, run:

```bash
npx eslint .
```

This will display any coding issues found. To automatically fix them, run:

```bash
npx eslint . --fix
```

For convenience, you can add this command to your `package.json` scripts:

```json
"scripts": {
  "lint": "eslint . --fix"
}
```

Now, you can simply run:

```bash
npm run lint
```

Additionally, in code editors like **VS Code**, you can install the ESLint extension, which highlights errors directly in your code files, improving real-time feedback and workflow. This makes it easier to maintain clean, error-free code throughout development.

#### 4.3 Catching Type Errors With TypeScript

**TypeScript** is a statically-typed superset of JavaScript, designed to catch type-related issues at compile time. By explicitly defining types for variables, function parameters, and return values, TypeScript improves code quality, documentation, and makes refactoring easier. Its use leads to a stronger codebase with fewer runtime errors.

To get started with TypeScript, install it as a development dependency using the following command:

```bash
npm i -D typescript
```

Once installed, initialize a TypeScript configuration file by running:

```bash
npx tsc --init
```

This will generate a `tsconfig.json` file, where you can configure various options for TypeScript’s type checking and compilation behavior. TypeScript files should use the `.ts` extension.

In TypeScript, you should explicitly define types for variables, constants, function parameters, and return types, although TypeScript can infer types in many cases. If a type is missing or incorrect, TypeScript will flag it in the code editor, making it easier to catch potential errors early. For example:

```typescript
let name: string = 'Alice';
let age: number = 30;

function greet(name: string): string {
  return `Hello, ${name}`;
}
```

This type safety reduces the need for runtime type checks, making unit testing simpler. Before running TypeScript code, it must be compiled into JavaScript. You can add a script to your `package.json` file to compile TypeScript code:

```json
"scripts": {
  "check-types": "tsc"
}
```

Now, running `npm run check-types` will compile your TypeScript code into JavaScript, ensuring all type-related issues are resolved beforehand.

#### 4.4 Configuring ESLint to Work with TypeScript

When compiling TypeScript to JavaScript, the generated JavaScript files can raise ESLint errors. Since these files are machine-generated, it's unnecessary to lint them. Instead, linting should focus on your original TypeScript code. To avoid linting the compiled JavaScript files, you can configure TypeScript to output these files to a separate directory and instruct ESLint to ignore them.

In the `tsconfig.json` file, set the `outDir` option to move compiled files to a specific directory, such as `./dist`:

```json
{
  "compilerOptions": {
    "outDir": "./dist"
  }
}
```

Next, in your ESLint configuration file (`.eslintrc.json`), instruct ESLint to ignore the compiled files by using the `ignorePatterns` property:

```json
{
  "ignorePatterns": ["dist/**"]
}
```

By default, ESLint doesn't check TypeScript files, so you'll need to install the necessary ESLint and TypeScript plugins. Run the following command to install the required packages:

```bash
npm install --save-dev eslint @eslint/js @types/eslint__js typescript typescript-eslint
```

After installing these dependencies, create an ESLint configuration file (`eslint.config.mjs`) in the root of your project. Populate it with the following code to enable TypeScript linting:

```javascript
// eslint.config.mjs
// @ts-check

import eslint from '@eslint/js';
import tseslint from 'typescript-eslint';

export default tseslint.config(
  eslint.configs.recommended,
  ...tseslint.configs.recommended
);
```

This configuration ensures that when running ESLint, it will check your TypeScript code without generating errors for the compiled JavaScript files.

#### 4.5 Automating Code Quality Checks With Husky

# 

Husky is a popular tool that automates Git hooks, helping enforce code quality and styling guidelines during the Git workflow. By integrating Husky, you can automate tasks like code formatting and linting before code is committed to your repository.

To install Husky, run the following command:

```bash
npm install --save-dev husky
```

This creates a `.husky` folder in your project. Inside this folder, you'll find a `pre-commit` file, a shell script that runs before every commit. To ensure only staged files are formatted and linted, you'll need to install `lint-staged` as an additional dependency:

```bash
npm install --save-dev lint-staged
```

In the `pre-commit` file, add the following script to run `lint-staged`:

```bash
#!/user/bin/env sh
. "$(dirname -- "$0")/_/husky.sh"

npx lint-staged
```

This ensures that the pre-commit hook triggers `lint-staged` to check only the files that are staged for commit, rather than the entire project.

Next, create a `.lintstagedrc.json` file to define how to handle staged files. For JavaScript and TypeScript files, the following configuration runs Prettier and ESLint:

```json
{
  "*.+(js|ts)": [
    "prettier --write",
    "eslint"
  ]
}
```

With this setup, whenever you commit code with Git, only the staged files will be automatically formatted and linted. This ensures consistent code quality while minimizing unnecessary checks across the entire project.

#### 4.6 Automating Unit Tests with Husky Pre-Push Hook

Husky can also be used to automatically run unit tests before each Git push, ensuring that only tested code is pushed to the repository. To set this up, you can add a pre-push hook that triggers the test command.

Use the following command to add a pre-push script:

```bash
npx husky add .husky/pre-push "npm test"
```

This will create a `pre-push` script inside the `.husky` folder, which executes the unit tests using the `npm test` command (which can be configured to run your Vitest tests). If the tests fail, the push operation will be aborted, preventing untested or failing code from being pushed.
