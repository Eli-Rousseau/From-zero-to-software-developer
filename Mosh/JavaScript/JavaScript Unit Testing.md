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

#### 3.1 Creating and Using Mock Functions

A **mock function** simulates the behavior of a real function and is essential for testing a unit in isolation. For instance, if you have a function \( A \) that depends on another function \( B \), you can decouple them during testing by replacing \( B \) with a controllable mock function. This allows you to test \( A \) without relying on the actual implementation of \( B \).

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

#### 3.2 Mocking Modules

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

#### 3.3 Interaction Testing with Mock Functions

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


