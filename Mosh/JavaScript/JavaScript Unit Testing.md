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

When writing software, there are two main approaches: **code first** or **test first**. In the code-first approach, developers write the application code first and then add tests afterward to validate the functionality.

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


