# Python

## 1. Introduction

#### 1.1 What is python?

Python is a high-level, interpreted, and general-purpose programming language known for its simplicity, readability, and versatility. It was created by Guido van Rossum and first released in 1991. Python emphasizes code readability and follows a clean and easy-to-understand syntax, making it suitable for beginners as well as experienced developers.

#### 1.2 Python Implementation

Python is a language specification that defines the syntax and rules for writing Python code, with several implementations available to execute that code. The most popular implementation is CPython, written in C, but alternatives like Jython (in Java), IronPython (for .NET), and PyPy (focused on speed) also exist. These implementations combine elements of compiled and interpreted languages: Python code is first compiled into bytecode, a platform-independent, low-level representation, which is then executed by the Python Virtual Machine (PVM). The PVM interprets the bytecode and translates it into machine-specific instructions, offering the flexibility of an interpreted language with the benefits of intermediate compilation.

#### 1.3 Setting Up a Python Project

1. **Install Python**
- Download Python: Go to [python.org](http://python.org) and download the latest version of Python for your operating system.

- Verify Installation: After installation, open your terminal and type:
  
  ```bash
  python --version
  ```
  
  This should display the installed Python version. If it doesn’t, try `python3 --version` depending on your setup.

- Exit the Python Interpreter: If you enter the Python interpreter by typing `python`, you can exit by pressing `Ctrl+Z` followed by `Enter` on Windows, or `Ctrl+D` on macOS/Linux.
2. **Install a Code Editor or IDE**
- Visual Studio Code (VS Code) is highly recommended for Python development due to its robust features.
- Download VS Code from [code.visualstudio.com](https://code.visualstudio.com/) and install it.
3. **Set Up VS Code for Python**
- Install Python Extension: After installing VS Code, install the Python extension by Microsoft from the Extensions Marketplace.
- This extension provides features like linting, debugging, and autocompletion.
4. **Create a Python Project**
- Create a Project Folder: Open VS Code and create a folder for your project.
- Create a Python File: Inside the folder, create a new file with a `.py` extension, for example, `myscript.py`. You can do this by right-clicking in the Explorer tab on the left side of VS Code and selecting "New File."
5. **Write Python Code**
- Open the newly created `.py` file and write your Python code. For example:
  
  ```python
  print("Hello, World!")
  ```
6. **Run the Python File**
- Using the Terminal Open the terminal inside VS Code using `Ctrl+Shift+ù` (shortcut for opening the terminal) or by selecting *Terminal > New Terminal* from the top menu.

- Run the File: In the terminal, navigate to your project directory (if needed) and run your Python script using:
  
  ```bash
  python myscript.py
  ```
  
  If `python` doesn’t work, you may need to use `python3` depending on your installation.
7. **Optional: Install and Use Code Runner**
- Install Code Runner: If you want to run Python scripts more easily, install the Code Runner extension from the VS Code Extensions Marketplace.
- Run with Code Runner: After installing, you can run your Python file by simply pressing `Ctrl+Alt+N` without manually invoking Python in the terminal.
8. **Optional: Enable Linting and Debugging**
- Linting: The Python extension provides built-in linting (with tools like `Pylint`). This highlights potential issues such as syntax errors and code quality problems. You can enable it by configuring the extension's settings.
- Debugging: VS Code’s Python extension includes debugging tools that allow you to set breakpoints, step through code, and inspect variables. Click on the left margin to set breakpoints, then click the "Run and Debug" button (or press `F5`) to start debugging your script.
9. **Optional: Code Formatting and Testing**
- Auto Formatting: Tools like `autopep8` and `black` are supported in VS Code to format code automatically according to PEP 8 guidelines. You can enable these through the Python extension settings.
- Unit Testing: VS Code supports unit testing frameworks such as `unittest` and `pytest`. You can set up and run tests directly from the IDE.

#### 1.4 Debugging with VS Code's Python Extension

VS Code’s Python extension offers robust debugging tools to help identify and fix errors in your code. When debugging a Python project for the first time, you can create a `launch.json` file by going to the Debug panel in VS Code. This file, stored in the `.vscode` folder, defines your debugging configuration and rarely needs modification after setup.

Here are some key debugging tools available in the panel:

1. Breakpoints: Pause code execution at a specific line to examine the state of the program at that point.
2. Step Over: Execute the code line by line without stepping into functions, allowing you to observe where errors may occur.
3. Step Into: Dive into a function to inspect its internal execution in more detail.
4. Step Out: Exit the current function and return to the calling code, helping you resume debugging at a higher level.
5. Variable Window: View the current values of variables during debugging to monitor the program’s state and detect anomalies.

These tools collectively enhance the debugging process and make error detection more manageable.

## 2. Print output & variables

#### 2.1 Print function

###### 2.1.1 Print a single value

The `print()` function in Python is used to display output to the console or terminal. It takes one or more arguments, which can be strings, variables, or expressions, and prints its value as text.

```python
print('Hello world') # Output: Hello world
```

###### 2.1.2 Print multiple values

The `print()` function in Python allows to combine more then one value together as a single text.

```python
print('Hello', 'world') # Output: Hello world
```

###### 2.1.3 Custom separator

The `print()` functions accepts the `sep` parameter that defines which separator is used between the values, by default the separator is a simple white space.

```python
print('Hello', 'world', sep=', ') # Output: Hello, world
```

###### 2.1.4 End separator

The `print()` function accepts the `end` parameter that defines which separator is appended at the end of the printed output. By default, it is a newline character (`\n`), which moves the cursor to the next line after printing.

```python
print('Hello', 'world', end='\n') # Output: Hello
                                  #         world
```

#### 2.2 Variables

In Python, a variable is a symbolic name that represents a value stored in the computer's memory. It allows you to store and manipulate data, making your code more flexible and reusable. Variables act as placeholders for values of different data types, such as numbers, strings, or objects.

To declare a variable in Python, you simply choose a name for the variable and use the assignment operator (`=`) to assign a value to it. Here's an example:

```python
variable = 'value'
```

You can declare and assign values to multiple variables in a single line in Python.

```python
variable_1, variable_2 = 'value1', 'value2'
```

You can also assign the same value to multiple variables in a single line.

```python
variable_1, variable_2, variable_3 = 'value'
```

A good variable name is descriptive and meaningful, as it enhances code readability and makes it easier for other programmers to understand the purpose and functionality of the variable. By convention, variable names are written in lowercase, and if multiple words are used, they are separated by underscores (`_`), following the "snake_case" style.

#### 2.3 Primitive data types

###### 2.2.2 String

Strings (`str`) are used to represent a sequence of characters. Strings are commonly used to store text or any sequence of characters, such as words or sentences. They are enclosed between either single quotes (`'`) or double quotes (`"`). Both types of quotes can be used to define string literals. However, there is a difference in their usage and interchangeability.

The general rule is that you can use single quotes to create a string that contains double quotes, and vice versa, without any issues. For example:

```python
string1 = 'This is a "string" using single quotes.'
string2 = "This is another 'string' using double quotes."
```

However, if you want to use the same type of quotes within the string, you need to escape them by prefixing them with a backslash (`\`). For example:

```python
string3 = "This is a \"string\" with escaped double quotes."
string4 = 'This is another \'string\' with escaped single quotes.'
```

In Python, multi-line strings are used to represent strings that span across multiple lines. They are enclosed between triple quotes (`'''` or `"""`) to indicate the start and end of the string.

```python
string5 = '''
This is a multi-line
string in Python.
It can span across
multiple lines.
'''
```

###### 2.2.3 Numeric types

Numeric data types in Python are employed to represent various forms of numerical values. 

A first important numeric type are integers, which are used to represent whole numbers without any fractional components. 

```python
integer = 10
```

A second important numeric type are floating-points, which are employed when fractional parts are involved.

```python
floating_point = 3.14
```

###### 2.2.3 Boolean

The Boolean type (`bool`) represents two values: `True` and `False`. These are the only Boolean values and are used to represent truth values in logical operations and conditions.

```python
is_true = True
is_false= False
```

#### 2.4 Mutable vs. immutable objects

In Python, objects are classified as either mutable or immutable based on whether their state can be changed after creation. Mutable objects (like lists, dictionaries, and sets) can be modified in place. When copied or assigned to another variable, both references point to the same memory location, meaning changes to one reference affect the other. In contrast, immutable objects (such as numbers, strings, and tuples) cannot be altered after creation. Copying or assigning an immutable object results in a new object in memory, ensuring that modifications to one reference do not impact others.

## 3. Get user input

#### 3.1 Input function

The `input()` function in Python is used to prompt the user for input from the console or terminal. It allows the program to wait for user input and returns the entered value as a string. The value is then stored inside a new variable to be used in subsequent code.

```python
variable = input()
```

The `input()` function accepts the `prompt`parameter that is an optional string that is displayed as a prompt to the user before waiting for input.

```python
variable = input('Write the input:')
```

#### 3.2 Type function

The `input()` function in Python always returns the user's input as a string, regardless of the type of input entered by the user. This means that if the user enters a number, it will still be treated as a string unless you explicitly convert it to the desired data type.

In such cases, the `type()` function can be used to determine the data type of a value or variable. The `type()` function takes an object or value as an argument and returns its corresponding data type.

```python
age = input("Enter your age: ")
print(type(age)) # Output: <class 'str'>
```

#### 3.3 Converting types

In case one still wants to use the `input()` function to obtain an integer or floating-point value instead of a string, one can use type conversion that refers to the process of converting one data type to another. In Python, several built-in functions provide convenient ways to perform type conversions

###### 3.3.1 Convert into integer

The `int()` function is a built-in function used to convert a value to an integer data type. It can convert numeric strings or other compatible types to integers.

```python
age = input("Enter your age: ")
print(type(int(age))) # Output: <class 'int'>
```

###### 3.3.2 Convert into floating point

The `float()` function is a built-in function used to convert a value to a floating-point data type. It can convert numeric strings or other compatible types to floating-point numbers.

```python
number = input("Enter your number: ")
print(type(float(number))) # Output: <class 'float'>
```

###### 3.3.3 Convert into string

The `str()` function is a built-in function used to convert a value to a string data type. It can convert integers, floats, or other types to their string representations.

```python
number = 10
print(type(str(number))) # Output: <class 'str'>
```

###### 3.3.4 Convert into boolean

The `bool()` function evaluates values based on their "truthiness" or "falsiness," meaning it does not exclusively consider just the boolean values of `True` and `False`. In Python, the falsy values include `0`, `""` (an empty string), and `None`; all other values are considered truthy.

```python
truth_value = bool(0)           # Evaluates to False
truth_value_2 = bool("False")   # Evaluates to True
```

## 4. Comments in Python

#### 4.1 What are comments used for?

Comments in Python are lines of text that are ignored by the interpreter and are used to provide additional information or explanations within the code. They are helpful for documenting code, adding explanations, or temporarily disabling specific code blocks. Comments are not executed as part of the program and do not affect its functionality.

#### 4.2 Single line comments

To create a single-line comment, use the hash symbol `#` followed by the comment text. Anything after the `#` on the same line is considered a comment.

```python
# This is a single-line comment
```

In many popular Python editors and integrated development environments (IDEs), you can use the keyboard shortcut `Ctrl + /` (Windows/Linux) to comment or uncomment a selected block of code. This shortcut automatically inserts or removes the `#` symbol at the beginning of each line.

#### 4.3 Multi-line strings

Python does not have a built-in syntax for multi-line comments like some other programming languages. However, you can use multi-line strings (triple quotes) to achieve a similar effect. When multi-line strings are not assigned to a variable or used as a docstring, they are treated as comments.

```python
"""
This is a multi-line comment.
It can span multiple lines and can be used
to provide more detailed explanations or temporarily disable code.
"""
```

## 5. Operators

#### 5.1 Arithmetic operators

Arithmetic operators in Python are used to perform mathematical calculations on numeric values.

| Operators | Description                                         | Example  |
| --------- | --------------------------------------------------- | -------- |
| `+`       | Addition operator.                                  | `x + y`  |
| `-`       | Subtraction operator.                               | `x - y`  |
| `*`       | Multiplication operator.                            | `x * y`  |
| `**`      | Exponent operator.                                  | `x ** y` |
| `/`       | Division operator.                                  | `x / y`  |
| `//`      | Integer division operator (i.e. division quotient). | `x // y` |
| `%`       | Modulus operator (i.e. division remainder).         | `x % y`  |

#### 5.2 Operator precedence

Operator precedence in arithmetic operations determines the order in which operators are evaluated in an expression, and you can control it using parentheses to specify the desired calculation order. By enclosing parts of an expression in parentheses, you can ensure they are evaluated before other operations, overriding the default precedence rules. For example, in the expression `3 + 4 * 2`, the result is `11` because multiplication takes precedence over addition. However, `(3 + 4) * 2` ensures addition is performed first, resulting in `14`. Using parentheses allows you to precisely define the order of operations in expressions.

#### 5.3 Assignment and augmented operators

Assignment operators in Python are used to assign values to variables. They allow you to store and update values in variables conveniently.

| Operators | Description                         | Example  |
| --------- | ----------------------------------- | -------- |
| `=`       | Assignment operator.                | `x = y`  |
| `+=`      | Addition assignment operator.       | `x += y` |
| `-=`      | Subtraction assignment operator.    | `x -= y` |
| `*=`      | Multiplication assignment operator. | `x *= y` |
| `/=`      | Division assignment operator.       | `x /= y` |

#### 5.4 Comparison operators

Comparison operators are used in Python to compare values and determine the relationship between them. These operators return a Boolean value (`True` or `False`) based on the comparison result.

| Operators | Description                  | Example  |
| --------- | ---------------------------- | -------- |
| `<`       | Less than ...                | `x < y`  |
| `>`       | Greater than ...             | `x > y`  |
| `==`      | Equal to ...                 | `x == y` |
| `!=`      | Not equal to ...             | `x != y` |
| `<=`      | Less than or equal to ...    | `x <= y` |
| `>=`      | Greater than or equal to ... | `x >= y` |

By definition, integers and strings are not equivalent because they have a different type of value, even though they refer to the same number.

###### 5.4.1 Chaining comparison operators

Python allows you to chain comparison operators for more concise and readable expressions. Instead of writing multiple conditions separately, you can chain them together.

```python
# Chaining comparison operators
if a < x < b:
    print("x is between a and b")
```

This chaining improves readability while keeping the logic simple and efficient.

#### 5.5 Logical operators

Logical operators in Python are used to combine or modify Boolean values. They allow you to perform logical operations on conditions or expressions and return a Boolean value (`True` or `False`).

| Operators | Description                                                         | Example                     |
| --------- | ------------------------------------------------------------------- | --------------------------- |
| `and`     | `True` if both operands are true; otherwise `False`.                | `condition1 and condition2` |
| `or`      | `True` if at least one of the operands is true; otherwise `False`.  | `condition1 and condition2` |
| `not`     | `True` if the operand is false, and `False` if the operand is true. | `not condition`             |

#### 5.6 Membership operators

Membership operators in Python are used to test whether a value belongs to a sequence or a collection. They evaluate the membership of a value and return a Boolean value (`True` or `False`) based on the result.

| Operators | Description                                                                    | Example                 |
| --------- | ------------------------------------------------------------------------------ | ----------------------- |
| `in`      | `True` if a value is found in a sequence or collection; otherwise `False`.     | `value in seqeuence`    |
| `not in`  | `True` if a value is not found in a sequence or collection; otherwise `False`. | `value not in sequence` |

#### 5.7 Unpacking operator

The unpacking operator in Python (`*` for iterables like lists or strings and `**` for dictionaries) allows you to unpack the contents of these data structures. This is useful when you need to combine or expand collections.

For lists or strings, the `*` operator can be used to unpack and merge items:

```python
list1 = [1, 2, 3]
list2 = [4, 5]
combined_list = [*list1, *list2]
print(combined_list)  # Output: [1, 2, 3, 4, 5]
```

For dictionaries, the `**` operator unpacks key-value pairs and can merge dictionaries:

```python
dict1 = {'a': 1, 'b': 2}
dict2 = {'c': 3}
merged_dict = {**dict1, **dict2}
print(merged_dict)  # Output: {'a': 1, 'b': 2, 'c': 3}
```

The unpack operator simplifies combining, expanding, or passing collections into functions, offering flexible manipulation of iterable data structures.

## 6. if ... else statement

#### 6.1 if statement

The `if` statement allows you to specify a condition that is evaluated. If the condition is `True`, the block of code indented below the `if` statement is executed. If the condition is `False`, the block of code is skipped.

It has the following syntax:

```python
if condition:
    # Code to execute if the condition is true
```

#### 6.2 if-else statement

The `if-else` statement allows you to specify an alternative block of code to execute when the condition in the `if` statement is `False`. If the condition is `True`, the code inside the `if` block is executed. If the condition is `False`, the code inside the `else` block is executed.

It has the following syntax:

```python
if condition:
    # Code to execute if the condition is true
else:
    # Code to execute if the condition is false
```

#### 6.3 if-elif-else statement

The `if-elif-else` statement allows you to specify multiple conditions and corresponding code blocks. It provides a way to check multiple conditions sequentially and execute the first block of code whose condition is `True`. If none of the conditions are `True`, the code inside the `else` block is executed.

It has the following syntax:

```python
if condition1:
    # Code to execute if condition1 is true
elif condition2:
    # Code to execute if condition1 is false and condition2 is true
elif condition3:
    # Code to execute if condition1 is false and condition3 is true
...
else:
    # Code to execute if all previous conditions are false
```

#### 6.4 Ternary operator

The ternary operator in Python provides a shorthand way to write an `if-else` statement in a single line. This allows you to assign a value based on a condition in a concise manner.

It has the following syntax:

```python
result = first if condition else second
```

#### 6.5 Short-Circuit Evaluation

In Python, short-circuit evaluation refers to the behavior of the logical `and` and `or` operators where the evaluation of expressions stops as soon as the result is determined. 

For the `and` operator, if the first condition is `False`, Python doesn't evaluate the second condition, since the entire expression will be `False` regardless.

```python
if False and True:
    print("This won't be printed")
# The second condition is not evaluated because the first condition is False.
```

Similarly, for the `or` operator, if the first condition is `True`, the second condition is skipped, as the overall expression will be `True`.

```python
result = True or False  # The second condition is not evaluated because the first is True.
print(result)  # Output: True
```

Short-circuit evaluation helps optimize performance and can prevent errors such as division by zero or null references in conditional checks.

## 7. Looping

#### 7.1 while loop

A `while` loop is used to repeatedly execute a block of code as long as a specified condition remains `True`. It continues to execute the code until the condition becomes `False`.

```python
# Set an initial condition
while condition:
    # Code block to be executed while the condition is true
    # Make sure the condition can eventually become false
```

If the test condition of the loop is never `False`, the loops run infinitely until the memory runs out. This is known as the infinite loop.

#### 7.2 for loop

A `for` loop is used to iterate over a sequence or any iterable object. It executes a block of code for each item in the sequence. The loop variable takes on the value of each item in the sequence on each iteration.

```python
# Iterate over a sequence or iterable
for item in sequence:
    # Code block to be executed for each item
```

###### 7.2.1 Iterating over a sequence of numbers

The `range()` function in Python is a versatile tool used to create a sequence of numbers. It follows the syntax `range(start, stop, step)`, where the `start` parameter specifies the starting value of the sequence (defaulting to 0 if omitted), the `stop` parameter defines the exclusive upper limit of the sequence, and the optional `step` parameter determines the increment between numbers (defaulting to 1 if omitted). Here's an example that demonstrates the usage of the `range()` function in a `for` loop:

```python
for number in range(10):
    # Code block to be executed for each number
```

###### 7.2.2 Iterating over a sequence of items

In Python, `for` loops iterate over sequences like strings, lists, tuples, dictionaries, or sets. The loop variable takes on each item in the sequence: for strings, each character; for lists and tuples, each element; for dictionaries, each key; and for sets, each element. The loop executes a block of code for each item.

```python
for item in my_sequence:
    # Code block to be executed for each item
```

###### 7.2.3 Enumerating over a sequence of items

The `enumerate()` function in Python is used within `for` loops to iterate over a sequence of items while keeping track of the index of each item. By using `enumerate()` in a `for` loop, you can conveniently access both the index and value of each item, allowing you to perform operations specific to each item while maintaining knowledge of its position in the sequence. Here's an example that demonstrates the usage of the `enumerate()` function in a `for` loop:

```python
for index, item in enumerate(my_sequence):
    # Code block to be executed for each item
```

###### 7.2.4 Iterating over zipped sequence of items

The `zip` function in Python combines two or more iterables (e.g., lists, tuples) by pairing elements from each iterable into tuples. It returns an iterator of tuples, where the i-th tuple contains the i-th element from each input iterable. This is useful for iterating over multiple sequences in parallel.

```python
for item_1, item_2 in zip(collection_1, collection_2):
    # Code block to be executed for each item
```

#### 7.3 Loop control

Loop control in Python refers to the ability to alter the flow of a loop by controlling its execution. It allows you to change the default behavior of loops, such as prematurely exiting a loop, skipping iterations, or restarting the loop.

Python provides several loop control statements that allow you to have finer control over the loop execution:

1. The `break` statement is used to exit the current loop prematurely. When encountered, the loop immediately terminates, and the program continues with the next statement after the loop.

2. The `continue` statement is used to skip the remaining code in the current iteration and proceed to the next iteration of the loop. It effectively skips any statements below the `continue` statement within the loop block.

3. The `pass` statement is a placeholder statement that does nothing. It is often used as a placeholder when a statement is required but no action is needed.

#### 7.4 Comprehension

###### 7.4.1 List comprehension

List comprehension is a concise and powerful feature in Python that allows you to create new lists based on existing lists or other iterable objects. The basic syntax of list comprehension consists of square brackets `[]` enclosing an expression followed by a `for` clause.

```python
new_list = [expression for item in iterable]
```

An `if` statement can be included after the `for` clause to filter elements based on a condition. Only the elements that satisfy the condition will be included in the new list.

```python
new_list = [expression for item in iterable if condition]
```

An `if-else` statement can also be included within the expression part of the list comprehension. This allows you to conditionally transform or modify the elements in the new list based on a condition.

```python
new_list = [expression_if_true if condition else expression_if_false for item in iterable]
```

###### 7.4.2 Set comprehensions

Set comprehensions work similarly to list comprehensions but are used to create sets, which are unordered collections of unique elements. The syntax is almost the same as list comprehension, but instead of square brackets, you use curly braces `{}`.

```python
new_set = {expression for item in iterable}
```

You can also include an `if` statement to filter elements that meet a condition, just like in list comprehension.

```python
new_set = {item for item in iterable if condition}
```

###### 7.4.3 Dictionary comprehensions

Dictionary comprehensions allow you to create dictionaries in a concise way, where each key-value pair is generated based on some transformation of an existing iterable or sequence. You use curly braces `{}` with a colon `:` separating the key and value expressions.

```python
new_dict = {key_expression: value_expression for item in iterable}
```

Similar to lists and sets, you can filter the items using an `if` condition.

```python
new_dict = {key_expression: value_expression for item in iterable if condition}
```

## 8. Functions

#### 8.1 What are functions used for?

Functions in Python are reusable blocks of code that perform specific tasks. They encapsulate a series of instructions and can accept input arguments, perform computations or operations, and optionally return a result. Functions help in modularizing code, improving code organization, and promoting code reusability.

#### 8.2 Creating a function

To define a function in Python, you use the `def` keyword followed by the function name, parentheses, and a colon. Inside the function block, you write the code that defines the functionality of the function. The function definition alone does not execute the code inside the function; it only defines the function and its behavior. Once a function is created, one can call the function to start execution of the code in the function's body. To call a function, you simply use its name followed by parentheses outside of the function's body.

```python
# Function definition
def function_name():
    # Function body
    # Perform computations, manipulate data, etc.
    # ...

# Call the function
function_name()
```

#### 8.3 Function arguments

In Python, functions use parameters as placeholders in the function definition to define the expected inputs, while arguments are the actual values passed to the function when it is called. The arguments are matched to the corresponding parameters based on their order or keyword, allowing flexibility in passing values to the function.

```python
def function_name(parameter):
    # Function body
    # Perform computations, manipulate data, etc.
    # ...
function_name(argument)
```

There are different ways to pass arguments to a function:

###### 8.3.1 Positional arguments

Positional arguments are the arguments that are passed to a function in the order they are defined in the function's parameter list. The position of the argument determines which parameter it corresponds to. For example:

```python
def greet(name, message):
    print(message, name)

# Positional arguments: "Eli" maps to "name", "Hello" maps to "message"
greet("Eli", "Hello") 
```

###### 8.3.2 Keyword arguments

Keyword arguments are the arguments that are explicitly specified by their parameter name during the function call. By using keyword arguments, the order of the arguments becomes irrelevant, and they can be provided in any order. This provides more clarity and avoids confusion, especially when a function has multiple arguments. For example:

```python
def greet(name, message):
    print(message, name)

# Keyword arguments: explicitly specify the parameter names
greet(message="Hi", name="Eli")  
```

###### 8.3.3 Default arguments

Default arguments are the arguments that have a predefined default value assigned to them in the function definition. If an argument is not provided during the function call, the default value will be used. Default arguments allow flexibility by making certain arguments optional. For example:

```python
def greet(name, message="Hello"):
    print(message, name)

greet("Eli")  # Uses the default argument for "message"
greet("Mariam", "Hi")  # Overrides the default argument for "message"
```

###### 8.3.4 Functions with variable number of arguments

In Python, you can define functions that accept a variable number of arguments by using a parameter prefixed with an asterisk (`*`). This parameter, conventionally named `*args`, collects all additional positional arguments into a tuple, an iterable data structure. For example:

```python
def my_function(*args):
    # Function body
    # Perform computations, manipulate data, etc.
    # ...
```

###### 8.3.5 Functions with variable keyword arguments

In Python, functions can accept a variable number of keyword arguments by using a parameter prefixed with a double asterisk (`**`). This parameter, typically named `**kwargs`, collects all additional named arguments into a dictionary, where each key is the argument name, and each value is the corresponding value passed to the function.

```python
def my_function(**kwargs):
    # Function body
    # Perform computations, manipulate data, etc.
    # ...
```

#### 8.4 Return statement

The `return` statement is used to specify the value to be returned by a function. It allows the function to provide a result back to the caller. When the `return` statement is encountered, the function execution stops, and the specified value is returned.

```python
def function_name(parameters):
    # Function body
    # Perform computations, manipulate data, etc.
    # ...
    return 
variable = function_name(argument)
```

#### 8.5 Built-in functions

Built-in functions are functions provided by Python as part of its standard library. They are readily available and can be used without requiring any additional imports. They provide common functionalities that are frequently used in programming tasks.

Here are some recurring basic built-in functions in Python:

| Functions                             | Descriptions                                                                        |
| ------------------------------------- | ----------------------------------------------------------------------------------- |
| `print()`                             | Used to display output to the console or terminal.                                  |
| `input()`                             | Allows the user to enter input from the console or terminal.                        |
| `len()`                               | Returns the length (number of items) of an object such as a string, list, or tuple. |
| `type()`                              | Returns the type of an object.                                                      |
| `range()`                             | Generates a sequence of numbers within a specified range.                           |
| `str()`, `int()`, `float()`, `bool()` | Convert values to the corresponding data types. Useful for type conversions.        |
| `sorted()`                            | Returns a sorted list from the items of an iterable or a specified sequence.        |
| `max()`, `min()`                      | Returns the maximum or minimum value from a sequence or a set of arguments.         |
| `abs()`                               | Returns the absolute (positive) value of a number.                                  |
| `round()`                             | Rounds a number to a specified precision or to the nearest whole number.            |

#### 8.6 Local and global variables

In Python, global variables are variables defined outside any function and can be accessed from anywhere in the program, while local variables are confined to the specific function block where they are defined. The global scope allows global variables to be accessed throughout the program, but modifying them inside functions using the `global` keyword is generally discouraged as it can lead to code complexity and unexpected behavior. It is recommended to use function arguments and return values to achieve modularity and code reusability. However, there may be cases where global variables are necessary, and in such situations, it is important to document their use clearly to ensure understanding and maintainability.

#### 8.7 Lambda function

###### 8.7.1 What is a lambda function?

In Python, a lambda function is a way to create small, one-line functions without explicitly defining a function using the `def` keyword. Lambda functions are typically used for simple and concise operations where a full function definition is not necessary.

Here's the general syntax of a lambda function:

```python
lambda arguments: expression
```

###### 8.7.2 Function transformation

Lambda functions are often used in conjunction with higher-order functions like `map()` and `filter()`to transform one function into another form. These higher-order functions take a function as an argument and apply it to a sequence of elements. Lambda functions provide a concise way to define the logic for these transformations.

```python
numbers = [1, 2, 3, 4, 5]

# Map: Squaring each number
squared_numbers = list(map(lambda x: x**2, numbers))
print(squared_numbers)  # Output: [1, 4, 9, 16, 25]

# Filter: Selecting even numbers
even_numbers = list(filter(lambda x: x % 2 == 0, numbers))
print(even_numbers)  # Output: [2, 4]
```

###### 8.7.3 Sorting

Lambda functions are useful for custom sorting, where you want to specify a specific criterion to determine the sorting order. By using the `key` parameter in sorting functions like `sorted()`, you can provide a lambda function that defines the criteria for sorting.

```python
fruits = ['apple', 'banana', 'cherry', 'dragon fruit']
sorted_fruits = sorted(fruits, key=lambda x: len(x))
print(sorted_fruits)  # Output: ['apple', 'cherry', 'banana', 'dragon fruit']
```

###### 8.7.4 Aggregating collections

Lambda functions can be used to reduce a collection to a single value. The `reduce` function from the `functools` module applies a given function cumulatively to the elements of an iterable, resulting in a single output. This is particularly useful for operations like summing the elements of a collection.

```python
from functools import reduce

numbers = [1, 2, 3, 4, 5]
result = reduce(lambda x, y: x + y, numbers)
print(result)  # Output: 15
```

###### 8.7.5 Conditional expressions

Lambda functions can be used to define conditional expressions or inline if-else logic. They allow you to write simple if-else conditions directly in the lambda function.

```python
is_even = lambda x: True if x % 2 == 0 else False
print(is_even(4))  # Output: True
```

## 9. Lists

#### 9.1 What is a list?

In Python, a list is a built-in data structure that allows you to store and manipulate a collection of items. It is an ordered sequence of elements, where each element can be of any data type such as numbers, strings, or even other lists. Lists are mutable, meaning you can modify their elements after they are created.

#### 9.2 Declaring a list

To declare a list in Python, one use square braces `[]` and it follows the next syntax:

```python
list_name = [element1, element2, element3, ...]
```

Alternatively, you can use the built-in function `list()`, which is used to create a new list object or convert an iteratable object.

```python
list_name = list()
```

#### 9.3 List indexing

###### 9.3.1 Forward indexing

Forward indexing refers to accessing individual elements in a list by their position or index. In Python, list indices start from 0, so the first element in a list has an index of 0, the second element has an index of 1, and so on. List indexing refers to accessing individual elements in a list by their position or index. This is done by using square brackets `[]` with the index value to access a specific element in a list. For example, `my_list[0]` retrieves the first element, `my_list[1]` retrieves the second element, and so on.

###### 9.3.2 Reversed indexing

Reversed indexing allows you to access elements in a list from the end, starting with -1 for the last element. Reversed indices count backwards, so `-1` refers to the last element, `-2` refers to the second-to-last element, and so on. For example, `my_list[-1]` retrieves the last element, `my_list[-2]` retrieves the second last element, and so on.

#### 9.4 List slicing

Slicing is a technique that allows you to extract a portion or a slice of a list by specifying a range of indices. It is denoted using the colon `:` operator. The syntax for slicing is `my_list[start:stop:step]`, where `start` is the index to start from, `stop` is the index to stop before, and `step` is the number of indices to skip between elements. By default, `start` is 0, `stop` is the end of the list, and `step` is 1. Slicing returns a new list containing the selected elements. For example, `my_list[1:4]` retrieves a slice from the second to the fourth element, and `my_list[::-1]` reverses the list.

#### 9.5 List item assignment

List indexing allows you to access and modify individual elements of a list by referring to their positions or indices. You can change a specific item in a list by assigning a new value to the corresponding index. 

```python
my_list[0] = new_value
```

Slicing, on the other hand, allows you to select a portion or a range of elements from a list. To change multiple items in a list using slicing, you can assign a new sequence of values to the selected slice.

```python
my_list[start:stop] = [new_values]
```

#### 9.6 List unpacking

List unpacking in Python allows you to assign the elements of a list (or any iterable) to multiple variables in a single operation.

###### 9.6.1 Basic unpacking

You can unpack a list with the same number of variables as elements in the list:

```python
numbers = [1, 2, 3]
a, b, c = numbers
print(a, b, c)  # Output: 1 2 3
```

###### 9.6.2 Extended unpacking

Python also supports extended unpacking using the `*` operator to collect remaining elements into a separate list. This is particularly useful when the number of variables is less than the number of items in the list.

```python
numbers = [1, 2, 3, 4, 5]
a, *b = numbers
print(a)  # Output: 1
print(b)  # Output: [2, 3, 4, 5]

*a, b = numbers
print(a)  # Output: [1, 2, 3, 4]
print(b)  # Output: 5
```

###### 9.6.3 Unpacking in Function Arguments

You can also use list unpacking to pass multiple arguments to a function:

```python
def add(x, y, z):
    return x + y + z

values = [2, 4, 6]
result = add(*values)
print(result)  # Output: 12
```

#### 9.7 List methods

List methods are built-in functions in Python that can be called on a list object to perform various operations or manipulations on the list.

| Methods     | Description                                                       | Example                       |
| ----------- | ----------------------------------------------------------------- | ----------------------------- |
| `append()`  | Adds an element to the end of the list.                           | `list.append(element)`        |
| `insert()`  | Inserts an element at a specific position in the list.            | `list.insert(index, element)` |
| `remove()`  | Removes the first occurrence of a specific element from the list. | `list.remove(element)`        |
| `pop()`     | Removes and returns the last element from the list.               | `list.pop()`                  |
| `index()`   | Returns the index of the first occurrence of a specific element.  | `list.index(element)`         |
| `sort()`    | Sorts the list in ascending order.                                | `list.sort()`                 |
| `reverse()` | Reverses the order of elements in the list.                       | `list.reverse()`              |

## 10. Tuples

#### 10.1 What is a tuple?

In Python, a tuple is a built-in data structure that allows you to store and access an ordered sequence of elements. The key difference between a tuple and a list is that tuples are immutable, meaning their elements cannot be modified once created.

#### 10.2 Declaring a tuple

To declare a list in Python, one use round braces `()` and it follows the next syntax:

```python
tuple_name = (element1, element2, element3, ...)
```

Alternatively, you can use the built-in function `tuple()`, which is used to create a new tuple object or convert an iteratable object.

```python
tuple_name = tuple()
```

#### 10.3 Tuple indexing

Tuple indexing in Python allows you to access individual elements of a tuple by referring to their position or index. Similar to lists, tuples are zero-indexed, meaning the first element has an index of 0, the second element has an index of 1, and so on. 

#### 10.4 Tuple slicing

Tuple slicing, like list slicing, allows you to extract a portion or a subsequence of a tuple by specifying a range of indices. It involves providing a start index, an end index, and an optional step size. The resulting slice will include elements from the start index up to, but not including, the end index. The step size determines the interval between elements in the slice.

#### 10.5 Tuple item assignment

Unlike lists, tuples are immutable, which means their elements cannot be modified or reassigned after they are created. Therefore, tuple item assignment is not allowed. Once a tuple is created, its elements remain fixed and cannot be changed. This also ensures that built-in list methods do not apply to a tuple, as this can be modified.

## 11. Strings

#### 11.1 What is a string?

Strings (`str`) are used to represent a sequence of characters. Strings are commonly used to store text or any sequence of characters, such as words or sentences. They are enclosed between either single quotes (`'`) or double quotes (`"`). Both types of quotes can be used to define string literals.

#### 11.2 Declaring a string

The general rule is that you can use single quotes to create a string that contains double quotes, and vice versa, without any issues. For example:

```python
string_1 = 'This is a "string" using single quotes.'
string_2 = "This is another 'string' using double quotes."
```

However, if you want to use the same type of quotes within the string, you need to escape them by prefixing them with a backslash (`\`). For example:

```python
string_3 = "This is a \"string\" with escaped double quotes."
string_4 = 'This is another \'string\' with escaped single quotes.'
```

In Python, multi-line strings are used to represent strings that span across multiple lines. They are enclosed between triple quotes (`'''` or `"""`) to indicate the start and end of the string.

```python
string_5 = '''
This is a multi-line
string in Python.
It can span across
multiple lines.
'''
```

#### 11.3 String formatting

In Python, placeholders in string formatting are special symbols or sequences that act as placeholders for values that will be inserted into the string. They serve as markers indicating where the values should be placed within the string.

###### 11.3.1 Format method

In Python, we often use curly braces `{}` as placeholders in string formatting. These placeholders can be used together with the `format()` method. The `format()` method takes a set of arguments that are dynamically inserted into the corresponding placeholders.

```python
my_argument = "world"
formatted_string = "Hello {}!".format(my_argument)
```

The `format()` method in Python provides the ability to reserve a specific number of spaces and control alignment within the formatted string. By specifying the desired width inside the curly braces, you can reserve space for the value passed as an argument. For example, the value as argument can be left-aligned `{:<10s}`, right-aligned `{:>10s}`, or center-aligned `{:^10s}` within the reserved space of 10 characters.

```python
my_argument = "world"
formatted_string = "Hello {:^10s}!".format(my_argument)
```

###### 11.3.2 F-string

Another commonly used approach for string formatting is to utilize f-strings. By converting a string into an f-string, you can directly include the arguments inside the curly braces of the string literal.

```python
my_argument = "world"
formatted_string = f"Hello {my_argument}!"
```

###### 11.3.3 Percentage operator

In Python, the `%` operator can be used for string formatting and allows you to insert values into a string by using placeholders denoted by `%s`, `%d`, `%f`, and other format specifiers.

To include a formatted string within another string, you can utilize the `%s` placeholder in the string that requires formatting. The `%` operator can then be applied to format the first string and incorporate it into the target string.

```python
my_string = "string"
formatted_string = "The value of this strings is: %s" % (my_string)
```

To include a formatted integer within another string, you can utilize the `%d` placeholder in the string that requires formatting. The `%` operator can then be applied to format the integer and incorporate it into the target string.

```python
my_integer = 10
formatted_string = "This value of this integere is: %d" % (my_integer)
```

To include a formatted floating-point within another string, you can utilize the `%f` placeholder in the string that requires formatting. The `%` operator can then be applied to format the floating-point and incorporate it into the target string. This placeholder provides the option to specify the desired number of decimal places for floating-point values, such as `%.2f` for two decimal places.

```python
> my_floating_point = 3.14
> formatted_string = "This value of this floating point is: %f" % (my_floating_point)
```

#### 11.4 String indexing

###### 11.4.1 Forward indexing

Forward indexing in Python allows you to access individual characters of a string by referring to their position or index. Strings are zero-indexed, meaning the first character has an index of 0, the second character has an index of 1, and so on. You can use square brackets `[]` with the desired index to retrieve a specific character from a string.

###### 11.4.2 Reversed indexing

Reversed indexing is a feature that allows you to access characters from the end of the string by using negative indices. The last character has an index of -1, the second-to-last character has an index of -2, and so on. Reversed indices provide a convenient way to access characters in reverse order.

#### 11.5 String slicing

Slicing allows you to extract a substring or a portion of a string by specifying a range of indices. It involves providing a start index, an end index, and an optional step size. The resulting slice will include characters from the start index up to, but not including, the end index. The step size determines the interval between characters in the slice.

#### 11.6 String item assignment

In Python, strings are immutable, which means you cannot change the value of individual characters in a string. Once a string is created, you cannot directly assign a new value to a specific character within the string.

#### 11.7 String operations

###### 11.7.1 String concatenation

String concatenation refers to the process of combining or joining two or more strings together to create a new string. It is achieved using the `+` operator in between two input strings, resulting in a new string that contains the characters from both input strings. For example, `"Hello, " + "world!"` will yield the string `"Hello, world!"`, as the `+` operator concatenates the strings `"Hello, "` and `"world!"`.

###### 11.7.2 String repetition

String repetition involves creating a new string by repeating an existing string a certain number of times. This is done using the `*` operator preceding by a number followed and followed by an input string, you can repeat the input string that number of times. For instance, `"Hello" * 3` will produce the string `"HelloHelloHello"`, as the string `"Hello"` is repeated three times.

#### 11.8 String methods

String methods are built-in functions in Python that can be called on string objects to perform specific operations or manipulations on strings.

| Functions     | Description                                                                      | Example                    |
| ------------- | -------------------------------------------------------------------------------- | -------------------------- |
| `upper()`     | Converts a string to uppercase.                                                  | `string.upper()`           |
| `lower()`     | Converts a string to lowercase.                                                  | `string.lower()`           |
| `strip()`     | Removes leading and trailing whitespace from a string.                           | `string.strip()`           |
| `replace()`   | Replaces occurrences of a substring with another substring.                      | `string.replace(ss1, ss2)` |
| `find()`      | Searches for the first occurrence of a substring and returns its index.          | `string.find(ss)`          |
| `isnumeric()` | Check if a string contains only numeric characters.                              | `string.isnumeric()`       |
| `isalpha()`   | Checks if a string contains only alphabetical characters.                        | `string.isalpha()`         |
| `split()`     | Split a string into a list of sub-strings based on a specified delimiter.        | `string.split(delimiter)`  |
| `join()`      | Concatenate a list of strings into a single string, using a specified delimiter. | `delimiter.join(list)`     |

## 12. Sets

#### 12.1 What is a set?

In Python, a set is a built-in data structure that represents an unordered collection of unique elements. Sets are mutable, meaning you can add or remove elements from them, but they do not allow duplicate values. Conversely, items within a set must be immutable, such as strings, numbers, or tuples.

#### 12.2 Declaring a set

To declare a set in Python, one use curly braces `{}` and it follows the next syntax:

```python
set_name = {element1, element2, element3, ...}
```

Alternatively, you can use the built-in function `set()`, which is used to create a new set object or convert an iteratable object.

```python
set_name = set()
```

#### 12.3 Set methods

| Functions  | Description                                            | Example               |
| ---------- | ------------------------------------------------------ | --------------------- |
| `add()`    | Adds an element to the set.                            | `set.add(element)`    |
| `remove()` | Removes a specific element from the set.               | `set.remove(element)` |
| `pop()`    | Removes and returns an arbitrary element from the set. | `set.pop()`           |
| `clear()`  | Removes all elements from the set, making it empty.    | `set.clear()`         |

#### 12.4 Set operations

###### 12.5.1 Set union

The union of two sets is a new set that contains all the unique elements from both sets. It is represented using the `|` operator or the `union()` method.

```python
# Operator notation
set1 | set2

# Method notation 
set1.union(set2)
```

###### 12.5.2 Set intersection

The intersection of two sets is a new set that contains only the common elements between the sets. It is represented using the `&` operator or the `intersection()` method.

```python
# Operator notation
set1 & set2

# Method notation 
set1.intersection(set2)
```

###### 12.5.3 Set difference

The difference of two sets is a new set that contains only the elements that are present in a first set and absent in a second set. It is represented using the `-` operator or the `difference()` method.

```python
# Operator notation
set1 - set2

# Method notation
set1.difference(set2)
```

###### 12.5.4 Set symmetric difference

The difference of two sets is a new set that contains only the elements that are either in a first or second set but not both. It is represented using the `-` operator or the `difference()` method.

```python
# Operator notation
set1 ^ set2

# Method notation
set1.symmetric_difference(set2)
```

## 13. Dictionaries

#### 13.1 What is a dictionary?

In Python, a dictionary is a built-in data structure that stores a collection of key-value pairs. It is also known as an associative array or a hash map in other programming languages. Each key in a dictionary must be unique and of an immutable data type, such as strings, numbers, or tuples, and is used to access its corresponding value. On the other hand, dictionary values can be either mutable or immutable.

#### 13.2 How to declare a dictionary

To declare a list in Python, one use curly braces `{}` and and separate each key-value pair with a colon `:` by following the next syntax:

```python
dict_name = {'key1': 'value1', 'key2': 'value2', 'key3': 'value3'}
```

Alternatively, you can use the built-in function `dict()`, which is used to create a new set object.

```python
dict_name = dict(key1='value1', key2='value2', key3= 'value3')
```

#### 13.3 Dictionary indexing

Dictionaries allow indexing through keys instead of integer indices like sequences (e.g., strings, lists, and tuples). Each key in a dictionary is associated with a corresponding value. By using square brackets `[]` and providing the desired key, you can retrieve the associated value from the dictionary. For example, if `my_dict` is a dictionary where `'key1'` maps to `'value1'`, then `my_dict['key1']` returns the value `'value1'`. Dictionary indexing provides a convenient way to access specific values based on their corresponding keys within a dictionary.

#### 13.4 Dictionary key assignment

To assign a value to a specific key in a dictionary, you use square brackets `[]` and provide the key inside them. The value you want to assign to the key is then placed on the right side of the assignment operator. This can be used to form a new key-value pair or to modify an existing key-value pair.

```python
dict_name[new_key] = new_value
```

#### 13.5 Dictionary methods

Dictionary methods are built-in functions in Python that can be used to manipulate and perform operations on dictionaries.

| Methods     | Description                                                                              | Example          |
| ----------- | ---------------------------------------------------------------------------------------- | ---------------- |
| `get()`     | Returns the value associated with the specified key.                                     | `dict.get(key)`  |
| `keys()`    | Returns a view object that contains all the keys in the dictionary.                      | `dict.keys()`    |
| `values()`  | Returns a view object that contains all the values in the dictionary.                    | `dict.values()`  |
| `items()`   | Returns a view object that contains all the key-value pairs in the dictionary as tuples. | `dict.items()`   |
| `pop()`     | Removes and returns the value associated with the specified key.                         | `dict.pop(key)`  |
| `popitem()` | Removes and returns the last key-value pair from the dictionary as a tuple.              | `dict.popitem()` |
| `clear()`   | Removes all key-value pairs from the dictionary, making it empty.                        | `dict.clear()`   |

## 14. Other data structures

#### 14.1 Stacks

A stack is a data structure that follows the Last In, First Out (LIFO) principle, meaning the last element added is the first one removed. In Python, you can use a `list` to implement a stack like `stack = []` and perform common stack operations like adding (pushing) and removing (popping) elements.

| Operation | Method         | Description                              |
| --------- | -------------- | ---------------------------------------- |
| Push      | `append(item)` | Adds `item` to the top of the stack      |
| Pop       | `pop()`        | Removes and returns the top item         |
| Peek      | `stack[-1]`    | Returns the top item without removing it |

#### 14.2 Queues

A queue is a data structure that operates on the First In, First Out (FIFO) principle, where the first element added is the first one removed. To efficiently implement a queue in Python, the `deque` class from the `collections` module is preferred over a `list` for better performance in appending and popping elements.

```python
from collections import deque
queue = deque([])
```

| Operation | Method         | Description                         |
| --------- | -------------- | ----------------------------------- |
| Enqueue   | `append(item)` | Adds `item` to the end of the queue |
| Dequeue   | `popleft()`    | Removes and returns the first item  |

#### 14.3 Arrays

An array is a data structure used to store elements of the same type, and unlike Python's built-in `list`, arrays take up less memory and can offer faster performance, making them more efficient for handling large collections of data. To use arrays in Python, you must import the `array` module and create an array using the `array` class, which requires two key arguments: a typecode that defines the type of elements (e.g., `'i'` for integers or `'f'` for floating-point numbers), and a list of elements that conforms to the specified type. A complete list of typecodes is available in the [Python documentation](https://docs.python.org/3/library/array.html).

```python
import array

# Creating an integer array
arr = array.array('i', [1, 2, 3, 4, 5])
```

| Operation       | Method                | Description                                                  |
| --------------- | --------------------- | ------------------------------------------------------------ |
| Append          | `append(item)`        | Adds `item` to the end of the array                          |
| Insert          | `insert(index, item)` | Inserts `item` at the specified `index`                      |
| Remove          | `remove(item)`        | Removes the first occurrence of `item`                       |
| Pop             | `pop([index])`        | Removes and returns the element at `index` (last by default) |
| Access by Index | `arr[index]`          | Retrieves the element at the specified `index`               |

#### 14.4 Generators

When working with very large datasets or potentially infinite data, storing all values in memory is inefficient. Instead, Python provides generator objects, which are iterable and generate one value at a time as needed, keeping memory usage minimal. The size of a generator remains constant, regardless of the number of iterations. You can create generator objects using generator expressions, which are similar to list comprehensions but use parentheses `()` instead of square brackets `[]`.

```python
gen = (expression for item in iterable)
```

## 15. Exception handling

#### 15.1 What are exceptions?

There are two types of errors in Python: syntax errors and exceptions. Exceptions are events that occur during the execution of a program that disrupt the normal flow of the program. When an exceptional condition occurs, such as an error or an unexpected situation, an exception object is raised.

Python has a hierarchical structure of built-in exceptions, which can be explored in detail at [Python's official documentation](https://docs.python.org/3/library/exceptions.html). Some common exceptions include:

| Exception          | Cause of error                                |
| ------------------ | --------------------------------------------- |
| FileNotFoundError  | When a file that does not exist is accessed.  |
| IndexError         | When the index of a sequence is out of range. |
| FloatingPointError | When a floating point operation fails.        |
| ZeroDivisionError  | When dividing a number with 0.                |

#### 15.2 Exception handling

Exception handling in Python allows programs to manage errors gracefully, preventing abrupt terminations and enabling recovery from unexpected conditions. Python uses the `try`, `except`, and `finally` blocks to implement structured error handling. Code that might raise an exception is placed inside the `try` block. If an error occurs, the `except` block is triggered, where specific exceptions like `ZeroDivisionError`, `FileNotFoundError`, or `IndexError` can be handled. It is good practice to catch specific exceptions for precise error management. Optionally, the `finally` block can be used for cleanup actions, as it executes regardless of whether an exception occurred. Example of Exception Handling:

```python
try:
    result = 10 / 0  # Division by zero
except ZeroDivisionError as error:
    print("Cannot divide by zero")
    print(error) # Output: division by zero
finally:
    print("Cleanup operations")
```

#### 15.3 With statement

The `with` statement in Python is particularly valuable for exception handling when working with resources like files, network connections, or database cursors. It ensures that necessary cleanup actions, such as closing a file or releasing a lock, are performed automatically, even if an exception occurs during execution. It is typically used with objects that support the context management protocol, making explicit cleanup operations unnecessary. This makes the `with` statement a safer and cleaner alternative to manually handling resources in a `try-except-finally` block.

```python
try:
    with open('file.txt', 'r') as file:
        data = file.read()  # Code that may raise an exception
        # If an error occurs, the file will still be properly closed.
except FileNotFoundError:
    print("File not found")
```

#### 15.4 Raising exceptions

Defensive programming involves proactively addressing potential issues in code, including unwanted inputs. When encountering such inputs, one can raise specific exceptions to signal errors, which can then be handled through exception handling mechanisms. Example of Raising an Exception:

```python
def process_input(value):
    if value < 0:
        raise ValueError("Input cannot be negative")
    # Continue processing...
```

However, it's important to note that raising exceptions incurs a performance cost, making them less suitable for applications that prioritize scalability and efficiency. Instead, developers may opt for alternative approaches to handle unwanted inputs, such as using the `pass` keyword, which allows the program to ignore the error without raising an exception.

```python
def process_input(value):
    if value < 0:
        pass  # Ignore the negative input
    # Continue processing...
```

## 16. Object-oriented programming

#### 16.1 What is object-oriented programming?

Object-Oriented Programming (OOP) is a programming paradigm that structures code around objects, representing real-world concepts with properties and behaviors. It revolves around classes, which serve as blueprints defining the characteristics and actions of objects. OOP enhances code modularity and reusability, streamlines organization and maintenance, and aids in modeling intricate systems. Python and numerous other programming languages employ OOP to develop scalable and manageable software applications.

#### 16.2 Creating a class and instance

A class in Python is a blueprint for creating objects that encapsulate data and functionality, allowing for the organization and reuse of code. To create a class, you use the `class` keyword followed by the class name, which typically follows the PascalCase convention. Once a class is defined, you can create instances (or objects) of that class by calling it as if it were a function. Each instance will have its own unique state, and you can interact with it through its defined attributes and methods. 

```python
class Person:
    pass  # This class currently has no attributes or methods

# Creating an instance of the Person class
person = Person()
```

You can verify if an object is an instance of a specific class (or its subclass) using the built-in function `isinstance(object, class)`. This function checks whether the object is derived from the given class and returns `True` if it is, or `False` otherwise.

```python
isinstance(person, Person) # Output: True
```

#### 16.3 Class constructors

A class constructor method in Python, defined using the `__init__` method, is a special function that initializes an instance of a class when it is created. This method allows you to set up initial values for attributes and perform any necessary setup tasks. To create a constructor, you define the `__init__` method within your class, and it typically takes `self` as its first parameter, along with any other parameters you want to initialize the object with. When you create an instance of the class, the constructor is automatically called, allowing you to pass in arguments to initialize the object's state.

```python
class Person:
    def __init__(self, name, age):
        self.name = name  # Initialize the name attribute
        self.age = age    # Initialize the age attribute

# Creating an instance of the Dog class using the constructor
person = Person("Eli", 24)
```

#### 16.4 Class vs. instance attributes

In Python, attributes can be categorized as class attributes and instance attributes based on their scope and usage. 

- Class attributes: These attributes are defined within the class body and are shared among all instances of the class, meaning that any changes to a class attribute will reflect across all instances. 

- Instance attributes: These attributes are unique to each instance and are typically defined within the constructor method (`__init__`). They can be set or modified independently for each object created from the class.

```python
class Person:
    species = "Human"  # Class attribute shared by all instances

    def __init__(self, name, age):
        self.name = name  # Instance attribute unique to each person
        self.age = age    # Instance attribute unique to each person

# Creating instances of the Person class
person1 = Person("Eli", 24)
person2 = Person("Mariam", 22)

# Accessing class and instance attributes
print(person1.name)        # Output: Eli
print(person2.age)         # Output: 22
print(person1.species)     # Output: Human

# Changing the class attribute
Person.species = "Homo Sapiens"

print(person1.species)     # Output: Homo Sapiens
print(person2.species)     # Output: Homo Sapiens
```

#### 16.5 Class vs. instance methods

In Python, methods within a class can be categorized as class methods and instance methods, each serving different purposes and having distinct behaviors. 

- Instance methods: These methods operate on an instance of the class and can access and modify instance attributes. They take `self` as their first parameter, which refers to the specific instance calling the method.

- Class methods: These methods operate on the class itself rather than any particular instance. They are defined using the `@classmethod` decorator and take `cls` as their first parameter, which refers to the class. Class methods can access class attributes and are often used for factory methods or alternative constructors.

```python
class Person:
    species = "Human"  # Class attribute shared by all instances

    def __init__(self, name, age):
        self.name = name  # Instance attribute unique to each person
        self.age = age    # Instance attribute unique to each person

    def instance_method(self):
        # Accessing instance attributes
        return f"{self.name} is {self.age} years old."

    @classmethod
    def class_method(cls):
        # Accessing class attributes
        return f"All persons belong to the species: {cls.species}."

# Creating an instance of the Person class
person1 = Person("Eli", 24)

# Calling instance and class methods
print(person1.instance_method())  # Output: Eli is 24 years old.
print(Person.class_method())       # Output: All persons belong to the species: Human.
```

#### 16.6 Magic methods

Magic methods in Python are special methods that are defined with double underscores at the beginning and end of their names. These methods are automatically called by the Python interpreter based on specific operations performed on class instances, allowing developers to customize the behavior of their objects. Below is a concise summary of some commonly used magic methods:

| Magic Method                    | Description                                                                                 |
| ------------------------------- | ------------------------------------------------------------------------------------------- |
| `__init__`                      | Constructor method for initializing new objects.                                            |
| `__str__`                       | Defines behavior for the `str()` function, returning a string representation of the object. |
| `__getitem__(self, key)`        | Defines behavior for accessing an item using `self[key]`.                                   |
| `__setitem__(self, key, value)` | Defines behavior for assigning a value using `self[key] = value`.                           |
| `__len__`                       | Returns the length of the container, applicable to both mutable and immutable types.        |
| `__iter__`                      | Returns an iterator for the container, allowing it to be used in a loop.                    |
| `__eq__(self, other)`           | Defines behavior for the equality operator (`==`).                                          |
| `__ne__(self, other)`           | Defines behavior for the inequality operator (`!=`).                                        |
| `__lt__(self, other)`           | Defines behavior for the less-than operator (`<`).                                          |
| `__gt__(self, other)`           | Defines behavior for the greater-than operator (`>`).                                       |
| `__le__(self, other)`           | Defines behavior for the less-than-or-equal-to operator (`<=`).                             |
| `__ge__(self, other)`           | Defines behavior for the greater-than-or-equal-to operator (`>=`).                          |
| `__add__(self, other)`          | Implements addition using the `+` operator.                                                 |
| `__sub__(self, other)`          | Implements subtraction using the `-` operator.                                              |
| `__mul__(self, other)`          | Implements multiplication using the `*` operator.                                           |
| `__floordiv__(self, other)`     | Implements integer division using the `//` operator.                                        |
| `__div__(self, other)`          | Implements division using the `/` operator.                                                 |

There is a wide array of other magic methods available that enable various functionalities, all of which are documented in detail [here](https://rszalski.github.io/magicmethods/).

#### 16.7 Private class members

In Python, private class members are attributes and methods that are intended to be inaccessible from outside the class. This is achieved by prefixing the member name with double underscores (`__`), which triggers name mangling. This means that the Python interpreter changes the name of the member to include the class name, making it harder to access accidentally from outside the class. 

```python
class Person:
    def __init__(self, name, age):
        self.__name = name  # Private attribute
        self.__age = age    # Private attribute

    def get_name(self):
        return self.__name  # Public method to access the private attribute

    def get_age(self):
        return self.__age    # Public method to access the private attribute

# Creating an instance of the Person class
person = Person("Eli", 24)

# Accessing public methods
print(person.get_name())  # Output: Eli
print(person.get_age())   # Output: 24
```

#### 16.8 Class properties

In Python, class properties provide a way to define getter and setter methods for class attributes while allowing for a more concise and elegant syntax. By using the `@property` decorator, you can create a method that acts like an attribute, enabling you to access it without needing parentheses. This approach enhances encapsulation and allows for controlled access to class attributes.

```python
class Person:
    def __init__(self, name, age):
        self.__name = name  # Private attribute
        self._age = age    # Private attribute

    @property
    def name(self):
        """Getter for the name attribute."""
        return self.__name

    @name.setter
    def name(self, new_name):
        """Setter for the name attribute."""
        self.__name = new_name

    @property
    def age(self):
        """Getter for the age attribute."""
        return self.__age

    @age.setter
    def age(self, new_age):
        """Setter for the age attribute."""
        if new_age < 0:
            raise ValueError("Age cannot be negative.")
        self.__age = new_age
```

#### 16.9 Inheritance and composition

Inheritance is a fundamental concept in OOP that allows a child class to inherit attributes and methods from a parent class, promoting code reuse and hierarchical structuring. In Python, inheritance is achieved by defining a subclass that passes the parent class as a parameter. All classes implicitly inherit from the base `object` class, which provides essential features like the `__init__` method. Child classes can override methods from their parents, and the original methods can still be accessed using `super()`. Python also supports multiple inheritanc, where a class can inherit from more than one parent, though this introduces complexity if there are conflicts in method or attribute names. Python resolves this through the Method Resolution Order (MRO).

```python
class Parent:
    def speak(self):
        print("Parent speaks")

class Child(Parent):
    def speak(self):
        super().speak()  # Call the parent class method
        print("Child speaks")

child = Child()
child.speak()
```

Alternatively, composition is a design principle where a class contains instances of other classes, rather than inheriting from them. Composition is often favored over inheritance because it avoids the complexity of multi-level and multiple inheritance, leading to more flexible and modular designs. Objects composed of other classes can be reused and modified independently, offering better maintainability and adaptability.

```python
class Parent:
    def speak(self):
        print("Parent speaks")

class Child:
    def __init__(self, parent):
        self.parent = parent  # Composition: Child has a Parent
    
    def speak(self):
        self.parent.speak()  # Call the Parent's speak method
        print("Child speaks")

parent = Parent()
child = Child(parent)
child.speak()

```





## <u>17. Modules</u>

#### 17.1 What is a module?

Modules are files containing Python code that can be used to organize and reuse functionality. They can include functions, classes, and variables that can be accessed from other Python programs.

#### 17.2 Import modules

To use a module in your Python program, you can import it using the `import` statement. For example, to import the `math` module, you would write `import math`.

```python
> import math
> result = math.sqrt(4)
```

You can import a module with a different name using the `as` keyword. For example, `import math as m` allows you to refer to the `math` module as `m` in your code.

```python
> import math as m
> result = m.sqrt(4)
```

The `from...import` statement allows you to import specific functions, classes, or variables from a module directly into your code. For example, `from math import sqrt` imports only the `sqrt()` function from the `math` module, allowing you to use it without referencing the module name.

```python
> from math import sqrt
> result = sqrt(4)
```

#### 17.3 Listing methods and attributes in modules

To list all the methods and attributes available in a module, you can use the `dir()` function. It returns a list of valid names that can be accessed on the module. For example, `dir(math)` lists all the methods and attributes in the `math` module.

```python
> import math
> print(dir(math)))
```

#### 17.4 Installing an external module

The Python Standard Library comes with built-in modules that offer various functionalities and can be imported without additional installation. These modules cover tasks like file operations, mathematics, networking, and more. They are readily available upon installing Python. On the other hand, external or third-party modules are not part of the Standard Library and require separate installation before they can be imported and used in Python programs. These modules provide additional features beyond what the built-in modules offer.

#### 17.5 Create a custom module

You can create your own modules by creating a Python file with a `.py` extension. In this file, you can define functions, classes, or variables that can be imported and used in other programs. To use the custom module, you can place it in the same directory as your program and import it using the module's filename (without the `.py` extension). For example, if you have a module called `my_module.py`, you can import it using `import my_module`.

#### 17.6 Packages

###### 17.6.1 What is a package?

A package is essentially a directory that contains one or more Python module files (with the `.py` extension) and can also include sub-packages, which are additional directories containing their own modules or sub-packages. This hierarchical structure allows for a logical organization of code, making it easier to locate and maintain related functionality. By using packages, you can create a modular and scalable codebase. You can group related modules together based on their functionality or purpose, making it easier to reuse, distribute, and collaborate on code.

###### 17.6.2 Initialization of a package

Packages are denoted by the presence of a special file called `__init__.py` within the directory. This file can be empty or can contain initialization code that is executed when the package is imported. Moreover, each sub-package should also have its own `__init__.py` file.

###### 17.6.3 Using a package

To use modules from a package, you can import them using the dot notation. For example, if you have a package called `my_package` with a module called `my_module` inside it, you can import it like this: `import my_package.my_module`. You can then access the functionality within the module using dot notation, such as `my_package.my_module.my_function()`.

###### 17.6.4 Package manager

Certainly! `pip` is a package manager for Python that allows you to easily install, manage, and uninstall external packages or modules from the Python Package Index (PyPI) and other repositories. In most cases, `pip` is  included by default with your Python installation.

To install a package using `pip`, open a terminal or command prompt and run the following command:

```powershell
> pip install package_name
```

You can also install a specific version of a package by appending the version number after the package name, like this:

```powershell
> pip install package_name==version
```

To upgrade a package to the latest version, you can use the `--upgrade` flag when installing, like this: 

```powershell
> pip install --upgrade package_name
```

You can list all installed packages by running `pip list` in the terminal. This will display the names and versions of all the installed packages.

```powershell
> pip uninstall package_name
```

## <u>19. File handling</u>

#### 19.1 Opening a file

###### 19.1.1 Open syntax

To open a file, you can use the `open()` function. It takes two parameters: the file name (or path) and the mode in which you want to open the file (`"r"` for reading, `"w"` for writing, `"a"` for appending, and more). 

```python
> file = open("example.txt", "r")
```

This function returns a file object, which is referred to as a file handle. The file handle provides methods and attributes that allow you to interact with the opened file, such as reading data, writing data, and closing the file.

###### 19.1.2 With open syntax

The `with` statement in Python provides a convenient way to automatically handle resources, such as files, in a clean and exception-safe manner. When used with file handling, the `with open` syntax ensures that the file is properly closed, even if an exception occurs during the file operations.

Here's the syntax for using the `with open` statement:

```python
> with open(file_name, mode) as file: 
    # File operations
```

#### 19.2 Reading a file

After opening the file in the `"r"` mode, you can use the `read()` method of the file handle. It reads the contents of the file as a string. 

```python
> with open(file_name, "r") as file: 
    content = file.read()
```

An alternative is to use the `readlines()` function that causes a list to be formed in which each item represents one of the lines in order.

```python
 > with open(file_name, "r") as file: 
    content = file.readlines()
```

#### 19.3 Writing a file

After opening the file in the `"w"` or `"a"` mode, you can use the `write()` method of the file handle. It writes a string of data to the file. 

```python
> with open(file_name, "w") as file: 
    file.write("Hello, World!")
```

An alternative is to use the `writelines()` function that is used to write a list of lines to the file.

```python
> with open(file_name, "w") as file: 
    file.writelines(["Hello \n", "world!"])
```

#### 19.4 Closing a file

It is important to close the file handle after you finish working with the file. You can use the `close()` method of the file handle to close the file and release any system resources associated with it. For example, `file.close()` closes the file.

```python
> file.close()
```

## <u>20. Working with directories</u>

#### 20.1 The os module

The `os` module in Python provides a way to interact with the operating system, allowing you to perform various directory and file operations. It provides functions to manipulate paths, list directory contents, create and remove directories, and more.

#### 20.2 Display current working directory

To display the current working directory, you can use the `os.getcwd()` function. It returns a string representing the current working directory path.

```python
> import os
> os.getcwd()
```

#### 20.3 Changing current working directory

To change the current working directory, you can use the `os.chdir()` function. It takes a path as an argument and sets the current working directory to the specified path.

```python
> import os
> os.chdir('path/to/directory')
```

#### 20.4 Listing directory contents

The `os.listdir()` function is used to list the contents of a directory. It returns a list of file and directory names present in the specified directory. 

```python
> import os
> os.listdir('path/to/directory')
```

#### 20.5 Creating a directory

The `os.mkdir()` function is used to create a directory. It takes a path as an argument and creates a directory with the specified name. 

```python
> import os
> os.mkdir('path/to/new_directory')
```

#### 20.6 Removing a directory

To remove a directory, you can use the `os.rmdir()` function. It removes the directory specified by the path if it is empty.

```python
> import os
> os.rmdir('path/to/directory')
```

#### 20.7 Renaming a directory

To rename a directory in Python using the `os` module, you can use the `os.rename()` function.

```python
> import os
> os.rename("path/to/old_directory", "path/to/new_directory")
```

## <u>21. Interacting with the system </u>

#### 21.1 The sys module

The `sys` module is a built-in module in Python provides access to various system-specific parameters and functions.

#### 21.2 Accessing the command line arguments

The `sys.argv` is a system specific parameter that contains a list of the command-line arguments passed to the Python script. At index `0` the script name is stored, at index `1` the first argument, at index `2` the second argument, and so on.

```python
> import sys
> my_arguments = sys.argv 
```

#### 21.3 Writing on the output and error streams

The `sys.stdout` object represents the standard output stream, which is the default stream used for normal output. By using the `write()` function on `sys.stdout`, you can write a message or data directly to the standard output stream.

```python
> import sys
> sys.stdout.write('Hello, World!')
```

The `sys.stderr` object represents the standard error stream, which is typically used for error messages or any output that should be separated from the standard output. By using the `write()` function on `sys.stderr`, you can write an error message or data directly to the standard error stream.

```python
> import sys
> sys.stderr.write('Error: File not found.')
```

#### 21.4 Terminate a program

The `sys.exit()` is a system level function that is used to terminate the current program with an optional exit code. Exit codes can have different meanings, but generally, an exit code of zero (`0`) represents success or a successful execution. Non-zero exit codes (`1`, `2`, `3`, ...) indicate various types of errors or failures, with different codes representing different error conditions.

```python
> import sys
> sys.exit(0)
```

#### 21.5 Import a custom module

The `sys.path` is a list that contains the directories that the Python interpreter searches for modules. Modifying `sys.path` can be useful in scenarios where you have custom modules or packages located in non-standard locations. By adding the relevant directories to `sys.path`, you ensure that Python can find and import the modules or packages from those locations.

```python
> import sys

# Print the current sys.path
> print(sys.path)

# Add a directory to sys.path
> sys.path.append('/path/to/my_module')

# Print the modified sys.path
> print(sys.path)
```

## <u>22. Iterators</u>

#### 22.1 What is an iterator?

In Python, an iterator is an object that follows the iterator protocol, enabling iteration over elements in a sequence or collection. It provides a consistent approach to access and retrieve individual elements from a sequence without needing to access the entire sequence at once. To qualify as an iterator, an object must implement two methods: `__iter__()` and `__next__()`. 

Iterators offer the advantage of lazy evaluation, generating elements as they are needed, rather than upfront. This approach is valuable when dealing with extensive datasets or infinite sequences as it conserves memory by generating and processing elements incrementally.

#### 22.2 Creating an iterable object

In Python, an iterable object is an object that can be iterated over, meaning it can be looped through or traversed. An iterable object must implement the `__iter__()` method, which returns an iterator. 

```python
> my_iterator = my_object.__iter__()
```

A possible alternative notation is also to use the built-in `iter()` function.

```python
> my_iterator = iter(my_object)
```

#### 22.3 Iterating over elements

An iterator is an object that implements the `__next__()` method, which is responsible for returning the next element in the iteration. The `__next__()` method raises a `StopIteration` exception when there are no more elements to be returned.

```python
> first_element = my_iterator.__next__()
> second_element = my_iterator.__next__()
...
# Iterates over all elements, and raises StopIteration exception
```

A possible alternative notation is also to use the built-in `next()` function.

```python
> first_element = next(my_iterator)
> second_element = next(my_iterator)
...
# Iterates over all elements, and raises StopIteration exception
```

#### 22.4 Internal implementation of a for loop

In Python, for loops are internally implemented using a while loop and iterators. The for loop automatically iterates over an iterable object by repeatedly calling `next()` on the iterator until the `StopIteration` exception is raised.

```python
> while True:
    try:
        element = next(my_iterator)
    except StopIteration:
        break
```

#### 22.5 Creating a custom iterator

###### 22.5.1 Iterator defined by a class

To create a custom iterator in Python, you need to define a class that implements the iterator protocol, in which you have to make sure that the `__iter__()` method return the iterator object itself and the `__next__()` method retrieves the next element in the iteration. Here's an example:

```python
> class MyIterator:
    def __init__(self, data):
        self.data = data
        self.index = 0

    def __iter__(self):
        return self

    def __next__(self):
        if self.index >= len(self.data):
            raise StopIteration
        element = self.data[self.index]
        self.index += 1
        return element
```

In this example,  the `MyIterator` class initializes the iterator with data and an initial index of 0. The class becomes iterable by defining the `__iter__()` method, which returns the iterator object. The `__next__()` method retrieves the next element in the iteration. If the index has reached the end of the data, it raises a `StopIteration` exception to mark the end. Otherwise, it retrieves the element at the current index, increments the index, and returns the element.

Here's how you can use the custom iterator:

```python
> my_data = [1, 2, 3, 4, 5]
> my_iterator = MyIterator(my_data)
> for element in my_iterator:
    print(element)
```

In this example, `my_data` is a list containing some data. An instance of `MyIterator` is created, passing the data as an argument. The `for` loop iterates over the custom iterator, and each element is printed.

###### 22.5.2 Iterator defined by a function (generator)

In Python, a generator is a special type of iterator that is defined using a function rather than a class. It allows you to generate a sequence of values on-the-fly, using the `yield` keyword, and provides a convenient and concise way to create custom iterators. Here's an example:

```python
def my_generator():
    n = 0
    while True:
        yield n
        n += 1
```

In this example, the `my_generator()` function is defined as a generator. It initializes a variable `n` with a value of 0. Inside the `while` loop, the `yield` statement is used to yield the current value of `n`. When the generator is iterated over, it will yield the current value and then pause its execution, allowing the calling code to retrieve the value. After yielding the value, the `n` variable is incremented by 1, ensuring that the generator produces the next value in the sequence when it is iterated over again. By using an infinite `while` loop, the generator continues indefinitely, producing an infinite sequence of numbers.

To use the generator and iterate over its elements, you can do the following:

```python
> gen = my_generator()
> print(next(gen))  # Output: 1
> print(next(gen))  # Output: 2
> print(next(gen))  # Output: 3
```

In this code, the `my_generator()` function is called, and it returns a generator object `gen`. The `next()` function is then used to retrieve the next element from the generator in each successive call.

## <u>23. Date and time</u>

The `datetime` module in Python provides classes and functions for working with dates, times, and combinations of both. It offers various functionalities to perform date and time calculations, format dates and times, and extract specific components from date objects. 

#### 23.1 Date class

The `date()` class from the `datetime` module is used to manipulate data objects that contain attributes like year, month, and day.

###### 23.1.1 Creating a date object

To create a date object, you can use the `date()` class constructor from the `datetime` module. It takes the year, month, and day as arguments.

```python
> import datetime
> my_date = datetime.date(2023, 1, 31)
```

###### 23.1.2 Obtaining the current date

To obtain the current date, you can use the `date.today()` method. It returns a date object representing the current local date.

```python
> import datetime
> current_date = datetime.date.today()
```

###### 23.1.3 Accessing date attributes

To access the year, month, and day attributes of a date object, you can use the corresponding attributes: `year`, `month`, and `day`.

```python
> year = my_date.year
> month = my_date.month
> day = my_date.day
```

#### 23.2 Time class

The `time()` class from the `datetime` module is used to manipulate time objects that contain attributes like hours, minutes, seconds, and microseconds.

###### 23.2.1 Creating a time object

To create a time object, you can use the `time()` class constructor from the `datetime` module. It takes the hour, minute, second, and microsecond as arguments (all optional with default values of 0).

```python
> import datetime
> my_time = datetime.time(12, 30, 45)
```

###### 23.2.2 Accessing time attributes

To access the attributes of a time object, you can use the following attributes: `hour`, `minute`, `second`, and `microsecond`.

```python
> hour = my_time.hour
> minute = my_time.minute
> second = my_time.second
> microsecond = my_time.microsecond
```

#### 23.3 Datetime class

The `datetime()` class from the `datetime` module is used to manipulate objects that have both the attributes from a date object and time object.

###### 23.3.1 Creating a datetime object

To create a `datetime` object, you can use the `datetime()` class constructor from the `datetime` module. It takes the year, month, day, hour, minute, second, and microsecond as arguments (all optional with default values of 0).

```python
> import datetime
> my_datetime = datetime.datetime(2023, 1, 31, 12, 30, 45)
```

###### 23.3.2 Getting the current date and time

To obtain the current date and time, you can use the `datetime.datetime.now()` method. It returns the current local date and time as a `datetime` object.

```python
> import datetime
> current_datetime = datetime.datetime.now()
```

###### 23.3.3 Accessing date and time attributes

To access the attributes of a `datetime` object, you can use the following attributes: `date`, `year`, `month`, `day`, `time`, `hour`, `minute`, `second`, and `microsecond`.

```python
# Date attributes
> date = my_datetime.date
year = my_datetime.year
month = my_datetime.month
day = my_datetime.day

# Time attributes
> time = my_datetime.time
> hour = my_datetime.hour
> minute = my_datetime.minute
> second = my_datetime.second
> microsecond = my_datetime.microsecond
```

#### 23.4 Timedelta

A `timedelta` object in the `datetime` module represents the difference between two dates or times.

```python
> time_difference = datetime_object1 - datetime_object2
```

#### 23.5 Strings and dates

###### 23.5.1 Convert date into string

The `strftime()` method is used to format a `datetime` object into a string representation based on a specified format. It takes a format string as an argument and returns a formatted string representing the date and time.

The format string consists of various format codes that represent different components of the date and time. For example, `%Y` represents the four-digit year, `%m` represents the month, `%d` represents the day, `%H` represents the hour, `%M` represents the minute, `%S` represents the second, and so on.

Here's an example that demonstrates the usage of `strftime()`:

```python
> import datetime
> current_datetime = datetime.datetime.now()
> formatted_date = current_datetime.strftime("%Y-%m-%d %H:%M:%S")
> print("Formatted Date:", formatted_date)
```

###### 23.5.2 Convert string into date

The `strptime()` method is used to parse a string representing a date and time into a `datetime` object based on a specified format. It takes the string and the format string as arguments and returns a `datetime` object representing the parsed date and time.

The format string should match the format of the string being parsed, including the same format codes as used in `strftime()`. The method will extract the relevant components from the string and create a `datetime` object accordingly.

Here's an example that demonstrates the usage of `strptime()`:

```python
> import datetime
> date_string = "2023-01-31"
> parsed_date = datetime.datetime.strptime(date_string, "%Y-%m-%d")
> print("Parsed Date:", parsed_date)
```

## <u>24. Decorators</u>

#### 24.1 Closure

###### 24.1.1 What is a closure?

In Python, a closure is a function object that remembers values in its enclosing scope, even if they are no longer present in memory. It "closes over" the variables it references, encapsulating them within its own scope. This allows the function to access and manipulate those variables, even after the enclosing scope has finished executing. In simpler terms, a closure is a function that retains access to variables from its parent scope, even after that scope has completed execution. 

###### 24.1.2 Closure example

Here's an example to illustrate the concept of a closure:

```python
> def outer_function(x):
    def inner_function(y):
        return x + y
    return inner_function

> closure = outer_function(10)
> result = closure(5)
> print(result)  # Output: 15
```

In this example, we have a function called `outer_function` that takes a parameter `x`. Inside `outer_function`, there is another function called `inner_function` which takes a parameter `y` and returns the sum of `x` and `y`. When `outer_function` is called with a value of 10, it returns the `inner_function`, creating a closure. This closure retains a reference to the variable `x` from the outer function, even after `outer_function` has finished executing. Thus, when the closure is invoked with a value of 5, it adds the captured `x` value of 10 with `y` as 5, resulting in a sum of 15. The closure essentially "remembers" the value of `x` from its enclosing scope, allowing it to perform calculations using that value even when the original scope is no longer active.

#### 24.2 Decorator

###### 24.2.1 What is a decorator?

In Python, a decorator is a function or a class that takes in another function as input and that allows you to modify or enhance the behavior of a function or class without directly changing its source code. When the decorated function or class is called, the decorator function is invoked and can perform additional actions, such as adding functionality, modifying inputs or outputs, or handling exceptions. Decorators provide a convenient and reusable way to extend the behavior of functions or classes without modifying their core implementation, making code more modular and flexible.

###### 24.2.2 Importance of a closure

Closures play an important role in decorators as they enable decorators to maintain access to variables or functions defined in their enclosing scope. This allows decorators to capture and utilize additional context or state information when modifying the behavior of a decorated function. Closures provide the mechanism for decorators to retain and reference such captured values or functions, enabling them to enhance the functionality of the decorated code effectively.

###### 24.2.3 Decorator example

Here's an example to illustrate the implementation of a decorator using closures:

```python
> def decorator(func):
    def wrapper():
        print("Before function execution")
        func()
        print("After function execution")
    return wrapper

> def hello():
    print("Hello, world!")

> closure = decorator(hello)
> result = closure()
```

In this example, the `decorator` function takes another function as input and returns a closure that adds extra behavior before and after the execution of the original function. The `hello` function is defined separately and represents the function to be decorated. By calling the `decorator` function with `hello` as an argument, a closure named `closure` is created, which encapsulates the modified version of the `hello` function. Invoking `closure()` executes the decorated function, and the additional behavior specified in the decorator is applied. Overall, the code showcases how decorators can dynamically extend and modify the behavior of functions in Python without directly altering their source code.

###### 24.2.4 Decorator syntax

Python provides an alternative notation for decorators using the `@` symbol. Instead of placing the decorator directly above the function definition, you can explicitly apply the decorator.

```python
> def decorator(func):
    def wrapper():
        print("Before function execution")
        func()
        print("After function execution")
    return wrapper

> @decorator
> def hello():
    print("Hello, world!")

> hello()
```

By using the `@decorator` syntax, the `hello` function is automatically decorated with the behavior defined in the `decorator` function. The `decorator` function is called with `hello` as an argument, and the resulting closure is then assigned to `hello`. This means that when `hello()` is invoked, it executes the modified version of the function defined in the `wrapper` closure.

###### 24.2.5 Chaining decorators

In Python, decorators can be chained by applying multiple decorators to a single function in a specific order. This allows you to stack multiple decorators on top of each other, with each decorator modifying the behavior of the function. The order in which the decorators are applied determines the order in which they are executed.

Here's an example to illustrate how decorators can be chained:

```python
> def decorator1(func):
    def wrapper():
        print("Decorator 1: Before function execution")
        func()
        print("Decorator 1: After function execution")
    return wrapper

> def decorator2(func):
    def wrapper():
        print("Decorator 2: Before function execution")
        func()
        print("Decorator 2: After function execution")
    return wrapper

> @decorator1
> @decorator2
> def hello():
    print("Hello, world!")

> hello()
```

In this example, two decorators, `decorator1` and `decorator2`, are defined. Each decorator contributes its own functionality before and after the execution of the function. The `@decorator1` syntax is used to apply `decorator1` to the `hello` function, making `hello` the closure returned by `decorator1`. Subsequently, the `@decorator2` syntax is used to apply `decorator2` to the modified `hello` function. When `hello()` is called, the decorators execute in the order they were applied, resulting in their combined effects on the function.

Output:

```python
Decorator 1: Before function execution
Decorator 2: Before function execution
Hello, world!
Decorator 2: After function execution
Decorator 1: After function execution
```

As you can see, the decorators are executed from the top-down order in which they were applied. Each decorator adds its own behavior before and after the execution of the function, resulting in a stacked effect.