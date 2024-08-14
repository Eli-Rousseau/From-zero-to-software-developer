# C#: Part. 3- Advanced Concepts

## 1. Generics

In some scenarios, you may need to create data types that can handle various types of data, whether they are value types (like `int`, `float`, etc.) or reference types (like objects). A common example is collection data types, where creating a separate class for each specific data type would be inefficient and time-consuming. To address this, C# introduces generics as a powerful feature that allows you to define classes, methods, and interfaces with placeholders for the data types they will operate on.

#### 1.1 Declaring Generic Types

Generics in C# are declared using angle brackets (`<>`) next to the class or method name. Inside these brackets, a type parameter, typically represented by the letter `T`, serves as a placeholder for the actual type that will be specified when the generic type or method is used.

```csharp
public class GenericBox<T>
{
    private T item; // Field type definition

    public void Add(T newItem) // Method parameter type definition
    {
        item = newItem;
    }

    public T GetItem() // Method return type definition
    {
        return item;
    }
}


// Specify the item type during instantiation
GenericBox<int> intBox = new GenericBox<int>();
intBox.Add(123);

GenericBox<string> stringBox = new GenericBox<string>();
stringBox.Add("Hello, Generics!");
```

#### 1.2 Generic Methods

Generics can also be applied to methods. You define a generic method by placing the type parameter inside angle brackets between the method name and its parentheses. 

```csharp
public T Swap<T>(T first, T second)
{
    T temp = first;
    first = second;
    second = temp;
    return first;
}
```

#### 1.3 Multiple Generic Types

Sometimes, a class or method may need to handle more than one type. You can declare multiple type parameters by separating them with commas inside the angle brackets.

```csharp
public class Pair<T1, T2>
{
    public T1 First { get; set; }
    public T2 Second { get; set; }

    public Pair(T1 first, T2 second)
    {
        First = first;
        Second = second;
    }
}
```

#### 1.4 Adding Constraints to Generics

C# allows you to add constraints to generics, specifying that the type used must meet certain criteria. This is done using the `where` keyword followed by the constraint. Common constraints include requiring that the type be a class, a struct (value type), an interface, a specific base class, or have a parameterless constructor (`new()`).

```csharp
public class Repository<T> where T : class
{
    // T must be a reference type (class)
}

public class NumberContainer<T> where T : struct
{
    // T must be a value type (struct)
}

public class Factory<T> where T : new()
{
    // T must have a parameterless constructor
}
```

#### 1.5 Practical Use of Generic Types

In practice, you may not need to create generic types frequently, as many are already provided by the .NET Framework, especially in the `System.Collections.Generic` namespace. This namespace includes commonly used generic collection types such as `List<T>`, `Dictionary<TKey, TValue>`, and `Queue<T>`, which are optimized for various data storage and retrieval scenarios.

## 2. Delegates

In C#, delegate is an object that stores references to one or more methods with a matching signature, allowing these methods to be invoked with the provided arguments when the delegate is called.. Think of a delegate as a pointer or reference to a function, which allows you to pass methods as parameters and design more flexible and extensible applications. Delegates are particularly useful when designing frameworks or applications that need to accommodate future changes without requiring recompilation or redeployment.

#### 2.1 Declaring and Using Delegates

To declare a delegate in C#, you start by specifying the access modifier, followed by the `delegate` keyword, and then the signature of the method the delegate will reference. This signature includes the return type, the delegate's identifier, and its parameters. Unlike methods, delegates do not include a code block; they only describe the method signature. In this example, `MathOperation` is a delegate that can point to any method that takes two integers as parameters and returns an integer.

```csharp
public delegate int MathOperation(int a, int b);
```

When you create an instance of a delegate, you can assign it to a method that matches its signature:

```csharp
MathOperation addition = Add;
```

You can also chain multiple methods to a delegate instance using the `+=` operator, which allows multiple methods to be called in sequence:

```csharp
addition += Subtract;
```

This approach ensures that new methods can be added to the delegate without altering the existing code, thereby enhancing the application’s extensibility.

#### 2.2 Built-in Delegates

Instead of creating custom delegates, you can leverage built-in delegates provided by .NET: `Action` and `Func`. These generic delegates offer flexibility and reduce the need for custom delegate definitions.

- **`Action<T>`**: Represents a method that takes one or more parameters but does not return a value (`void`).
- **`Func<T, TResult>`**: Represents a method that takes one or more parameters and returns a value by using the out modifier.

For example, to create a delegate for a method that takes two integers and returns an integer, you can use `Func<int, int, int>`:

```csharp
Func<int, int, int> operation = Add;
```

Alternatively, to define a delegate for a method that takes two integers and returns nothing, you would use `Action<int, int>`:

```csharp
Action<int, int> logOperation = Log;
```

#### 2.3 Using Delegeates in Event-Driven Patterns

Events in C# facilitate communication between objects by allowing one object (the publisher) to notify others (subscribers) when events occur, promoting loosely coupled designs. This approach enhances application flexibility and extensibility, making it easier to introduce new subscribers to the publisher without extensive changes or redeployment. In this model, publishers send notifications, and subscribers respond based on a predefined contract, typically defined by a shared method signature.

To implement events in C#, there are several key steps involved:

###### 2.3.1 Define a Delegate

The first step is to define a delegate in the publisher class. A delegate specifies the signature of the method that the subscribers must implement to receive notifications. In .NET, the delegate typically has two parameters:

- The first parameter is of type `object` and represents the event sender (i.e., the publisher).
- The second parameter is of type `EventArgs` (or a derived class) and contains any additional data that the subscribers might need.

```csharp
// Defining a delegate
public delegate void MyEventHandler(object sender, EventArgs e);
```

Instead of defining a custom delegate, you can use the generic `EventHandler<>` provided by .NET, which simplifies event handling.

###### 2.3.2 Define the Event

Next, define an event in the publisher class using the `event` keyword. This event is based on the delegate defined earlier and serves as the communication channel between the publisher and its subscribers.

```csharp
// Defining an event based on the delegate
public event MyEventHandler MyEvent;
```

Alternatively, you can directly use the `EventHandler<>` delegate:

```csharp
// Using the generic EventHandler
public event EventHandler<MyEventArgs> MyEvent;
```

###### 2.3.3 Raising the Event

To notify subscribers when an event occurs, the publisher needs a method that raises the event. This method typically follows a naming convention starting with `On` followed by the event name (e.g., `OnMyEvent`). It checks if there are any subscribers by verifying that the event is not `null`, and then calls the event, passing in the necessary parameters.

```csharp
// Raising the event
protected virtual void OnMyEvent(EventArgs e)
{
    if (MyEvent != null)
        MyEvent(this, new EventArgsDerivedClass())
}
```

The derived class must implement the `EventArgs` interface and include fields or properties to store the data that will be sent from the publisher to the subscriber class. If no additional arguments are required, you can use `EventArgs.Empty`.

###### 2.3.4 Implementing Subscriber Methods

Each subscriber must implement the method defined by the delegate’s signature to respond to the event. These methods are added to the event in the client code using the `+=` operator.

```csharp
// Subscribing to an event
myPublisher.MyEvent += mySubsriber.MyEventHandlerMethod;

public void MyEventHandlerMethod(object sender, EventArgs e)
{
    // Handle the event
}
```

## 3. Lambda Expressions

Lambda expressions in C# are a concise way to write anonymous methods, which are methods that do not have a name, access modifier, or a return statement. They are primarily used to simplify code, making it more readable and expressive by reducing the need of method definitions.

#### 3.1 Lambda Expression Syntax

The basic syntax of a lambda expression is:

```csharp
args => expression
```

Here, `=>` is known as the lambda operator. The `args` represent the parameters passed to the lambda expression, and the `expression` represents the code that is executed. For example, a lambda expression that adds two numbers can be written as:

```csharp
(int x, int y) => x + y
```

If no parameters are needed, you can use an empty set of parentheses:

```csharp
() => Console.WriteLine("Hello, World!")
```

For multiple parameters, the syntax is similar:

```csharp
(arg1, arg2, arg3) => expression
```

#### 3.2 Assigning Lambda Expressions to a Delegate

Lambda expressions can be assigned to delegates, which act as pointers to methods. This allows the lambda expression to be passed around and invoked as needed.

```csharp
Func<int, int, int> add = (x, y) => x + y;
Console.WriteLine(add(5, 3)); // Output: 8
```

#### 3.3 Using Lambda Expressions for Collection Operations

Lambda expressions are particularly useful when working with collections, such as lists, for operations like mapping, filtering, or reducing elements.

###### 3.3.1 Filtering a List with a Lambda Expression

One common use of lambda expressions is filtering elements in a list. This can be done using methods like `FindAll`, which takes a predicate (a function that returns a boolean) as an argument. You can pass a lambda expression directly to this method.

```csharp
List<int> numbers = new List<int> { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

// Find all even numbers using a lambda expression
List<int> evenNumbers = numbers.FindAll(x => x % 2 == 0);
```

## 4. Extension Methods

Extension methods in C# provide a way to add new functionality to an existing class without modifying its source code or creating a derived class. This feature is particularly useful when working with classes that are sealed (marked with the `sealed` keyword), meaning they cannot be inherited from. By using extension methods, you can introduce new methods to such classes, enhancing their capabilities without altering their original structure.

#### 4.1 Declaring an Extension Method

To create an extension method in C#, define a static class named with the class you wish to extend followed by "Extensions." Inside this class, declare a static method where the first parameter begins with the `this` keyword, followed by the type you want to extend. Extension methods are accessible only if the class containing them is within the current scope or if the appropriate namespace is imported.

```csharp
public static class StringExtensions
{
    public static string FindKthWordInString(this string input, int k)
    {
        return input.Split(' ')[k - 1];
    }
}
```

#### 4.2 Best Practices

Extension methods are useful but come with limitations. If a class later introduces an instance method with the same signature as your extension method, the instance method will override your extension, potentially causing unexpected behavior. Therefore, it's best to use extension methods sparingly and only when you need to add functionality to a class that you cannot directly modify.

## 5. LINQ

Language Integrated Query (LINQ) is a powerful feature in C# that enables developers to query and manipulate data in a consistent manner across different data sources. LINQ can be used to query various data types, including:

1. LINQ to Objects: Querying in-memory collections like arrays or lists.
2. LINQ to Entities: Querying databases through Entity Framework.
3. LINQ to XML: Querying XML data.
4. LINQ to Data Sets: Querying ADO.NET Data Sets.

#### 5.1 LINQ Extension Methods

LINQ provides a set of extension methods that can be used with enumerable objects (collections) to perform various operations such as filtering, ordering, and transforming data. Some of the most commonly used LINQ extension methods include:

| **Method**          | **Description**                                                                                           | **Example Usage**                                            |
| ------------------- | --------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------ |
| `Where()`           | Filters a collection based on a condition.                                                                | `collection.Where(item => item.Property == value)`           |
| `Single()`          | Returns a single element that matches a condition; throws an exception if zero or more than one is found. | `collection.Single(item => item.Property == value)`          |
| `SingleOrDefault()` | Similar to `Single()`, but returns a default value if no match is found, avoiding an exception.           | `collection.SingleOrDefault(item => item.Property == value)` |
| `First()`           | Returns the first element that matches a condition.                                                       | `collection.First(item => item.Property == value)`           |
| `FirstOrDefault()`  | Similar to `First()`, but returns a default value (e.g., `null`) if no match is found.                    | `collection.FirstOrDefault(item => item.Property == value)`  |
| `Last()`            | Returns the last element that matches a condition.                                                        | `collection.Last(item => item.Property == value)`            |
| `LastOrDefault()`   | Similar to `Last()`, but returns a default value if no match is found.                                    | `collection.LastOrDefault(item => item.Property == value)`   |
| `OrderBy()`         | Sorts the elements in a collection based on a key.                                                        | `collection.OrderBy(item => item.Property)`                  |
| `Select()`          | Projects each element of a collection into a new form, often used for transformations.                    | `collection.Select(item => new { item.Prop1, item.Prop2 })`  |
| `Skip()`            | Skips a specified number of elements in a collection.                                                     | `collection.Skip(2)`                                         |
| `Take()`            | Takes a specified number of elements from a collection.                                                   | `collection.Take(3)`                                         |
| `Count()`           | Counts the number of elements in a collection.                                                            | `collection.Count()`                                         |
| `Max()`             | Returns the maximum value in a collection.                                                                | `collection.Max(item => item.Property)`                      |
| `Min()`             | Returns the minimum value in a collection.                                                                | `collection.Min(item => item.Property)`                      |
| `Sum()`             | Calculates the sum of numeric values in a collection.                                                     | `collection.Sum(item => item.Property)`                      |

#### 5.2 LINQ Query Operators

In addition to extension methods, LINQ also provides a query syntax that is similar to SQL, making it easy to work with collections. The basic structure of a LINQ query is as follows:

```csharp
var result = from element in collection
             where element.Property == value
             order by element.Property
             select element.Property;
```

## 6. Nullable Types

In C#, value types (such as `int`, `bool`, `float`, etc.) cannot hold `null` values by default. However, there are scenarios where you may need a value type to represent a `null` value, such as when dealing with databases or optional data fields. To accommodate this, C# provides nullable types.

#### 6.1 Creating Nullable Types

A nullable type can be defined in two ways:

1. Explicitly using `Nullable<T>`:
   
   ```csharp
   Nullable<int> nullableInt = null;
   ```

2. Using shorthand notation with a question mark (`?`):
   
   ```csharp
   int? nullableInt = null;
   ```

In both cases, the value type `int` is made nullable, allowing it to hold either a valid integer or a `null` value.

#### 6.2 Key Members of Nullable Types

Nullable types have three important members that help manage and interact with nullable values:

| **Member**                | **Description**                                                                                            |
| ------------------------- | ---------------------------------------------------------------------------------------------------------- |
| **`GetValueOrDefault()`** | Returns the value if initialized; otherwise, returns the default value for the type.                       |
| **`HasValue`**            | Returns a boolean indicating whether the nullable object contains a value (`true`) or is `null` (`false`). |
| **`Value`**               | Returns the actual value if set; throws an `InvalidOperationException` if the value is `null`.             |

#### 6.3 Null Coalescing Operator

C# also provides the Null Coalescing Operator (`??`), which is used to simplify the handling of nullable types. This operator allows you to specify a default value that will be used if the nullable type is `null`. 

```csharp
int? number = null;
int result = number ?? -1; // Using the Null Coalescing Operator
int result = (number != null) ? number : -1; // Using the Ternary Operator
```

In this example, if `number` has a value, that value will be assigned to `result`. If `number` is `null`, the value on the right side of the `??` operator (`-1` in this case) is assigned to `result`.

## 7. Static vs Dynamic Types

#### 7.1 Statically and Dynamically-Typed Languages

Programming languages are often categorized into two main types:

1. Statically-Typed Languages:. In these languages, the types of members—such as fields, properties, parameters, variables, and method return types—are determined at compile time. The primary advantage of static typing is that it provides early feedback during the development process, catching type-related errors before the code is executed. Examples include C# and Java.

2. Dynamically-Typed Languages: Here, the types of members are resolved at runtime. This approach offers greater flexibility and allows for faster coding, as the programmer doesn’t need to specify types explicitly. Languages like Ruby, JavaScript, and Python fall into this category.

#### 7.2 Dynamic Typing in C#

C# originally began as a statically-typed language, but with .NET 4, dynamic typing was introduced to enhance interoperability with COM objects and dynamic languages, simplifying tasks like writing code for Microsoft Office applications. Previously, developers relied on reflection to inspect type metadata and access methods, which could be complex. With dynamic typing, however, an object passed as `dynamic` allows method invocation at runtime without needing reflection, as the type is resolved dynamically.

In .NET 4, Microsoft introduced the Dynamic Language Runtime (DLR), which sits on top of the Common Language Runtime (CLR). The DLR provides dynamic language capabilities to C#, enabling developers to define variables that can hold different types of data, something that is not possible with static typing. When you declare a variable using the `dynamic` keyword, the compiler treats it as a dynamic type, and any expression involving this variable is also treated as dynamic.

#### 7.3 Example of Dynamic Typing in C#

Here is a simple example demonstrating how dynamic typing works in C#:

```csharp
dynamic dynVar = "Hello, World!";
Console.WriteLine(dynVar.GetType()); // Outputs: System.String

dynVar = 123;
Console.WriteLine(dynVar.GetType()); // Outputs: System.Int32

dynVar = new List<int> { 1, 2, 3 };
Console.WriteLine(dynVar.Count); // Outputs: 3
```

In this example, the `dynVar` variable is initially assigned a string, then an integer, and finally a list of integers. The type of `dynVar` is determined at runtime, showcasing the flexibility of dynamic typing.

#### 7.4 Advantages and Disadvantages of Dynamic Types

One of the main benefits of dynamic types is the implicit conversion between dynamic and static types. If a dynamic object’s runtime type is implicitly convertible to the target static type, there’s no need for explicit casting. This makes dynamic types versatile and powerful.

However, there are also drawbacks to using dynamic types. The primary disadvantage is that they require more extensive unit testing to ensure that the application functions correctly, as type-related errors are not caught until runtime.

## 8. Exception Handling

In C#, exception handling is a critical mechanism used to manage unexpected or exceptional situations that arise during runtime. An exception is essentially an error message that occurs while a program is running, providing details about the type of error and a brief description. This message also includes a stack trace, which is a reverse-order sequence of method calls leading up to the error, helping developers pinpoint the exact location and cause of the issue.

#### 8.1 Using Try-Catch Blocks

In C#, exceptions are handled using `try-catch` blocks. Code that might cause an exception is placed in the `try` block, while the `catch` block handles any exceptions that occur. In the `catch` block, developers can either recover from the error to prevent a crash or rethrow it for further handling. Displaying a custom error message instead of crashing improves user experience. Typically, the `catch` block includes the base `Exception` type, which is the parent of all .NET exceptions, allowing access to detailed exception information. Multiple `catch` blocks can be used to handle exceptions, arranged from the most specific to the most general type.

```csharp
try 
{
    // Code that might throw an exception
}
catch (SpecificException ex) 
{
    // Handle specific exception
}
catch (Exception ex) 
{
    // Handle any other exception
}
```

#### 8.2 Finally Block and Resource Management

C# also provides a `finally` block, which is particularly useful when working with unmanaged resources—resources not managed by the CLR and not subject to garbage collection, such as file handles, database connections, and network connections. The `finally` block ensures that cleanup code, such as releasing these resources, is always executed, regardless of whether an exception is thrown. In .NET, classes that manage such resources are expected to implement the `IDisposable` interface, which defines a `Dispose()` method for cleanup. The `finally` block is typically used to call the `Dispose()` method on instances of these classes.

```csharp
try 
{
    // Code that might throw an exception
}
catch (Exception ex) 
{
    // Handle the exception
}
finally 
{
    // Cleanup code, such as disposing of resources
    resource.Dispose();
}
```

C# also offers the `using` statement as a more concise alternative to the `finally` block for resource management. When you use the `using` statement, it automatically calls the `Dispose()` method on the resource when the block is exited, whether due to normal execution or an exception.

```csharp
using (var resource = new Resource())
{
    // Use the resource
}  // Dispose() is called automatically here
```

#### 8.3 Custom Exceptions

In some cases, low-level errors may occur that you do not want to expose to higher levels of the application. In such situations, creating custom exceptions can be beneficial. To create a custom exception, define a new public class that derives from the `Exception` class. This custom exception class should include a constructor method that typically accepts two parameters: a `string` for the error message and an `Exception` object for the inner exception. 

```csharp
public class CustomException : Exception
{
    public CustomException(string message, Exception innerException)
        : base(message, innerException)
    {
    }
}
```

The `InnerException` property is particularly useful for tracking the underlying low-level exceptions that caused the higher-level exception.

## 9. Synchronous Programming

#### 9.1 Synchronous vs. Asynchronous Programming

In a synchronous program execution model, the program runs sequentially, executing each line of code one after the other. When a function is called, the program halts its execution until the function completes and returns its result, only then proceeding to the next line of code.

Conversely, in an asynchronous program execution model, when an asynchronous function is called, the program continues executing the subsequent lines of code without waiting for the function to complete. A callback function is provided to handle the result once the asynchronous operation finishes. This model enhances the responsiveness of applications, allowing tasks like media playback or data loading to occur without freezing the user interface. Asynchronous programming is particularly useful in scenarios such as web access, file handling, database interactions, and image processing.

#### 9.2 Async/Await

To implement asynchronous programming in C#, you define a method with the `async` modifier and set its return type to `Task` to represent the asynchronous operation's state. If the method does not return a value, use a non-generic `Task`; if it returns a value, use `Task<T>`, where `T` is the return type. The method name should conventionally end with "Async." Inside this asynchronous method, you replace blocking operations with their asynchronous equivalents, which, following recent .NET updates, often end with "Async." You must use the `await` keyword with these methods, which pauses the method's execution and allows the rest of the program to continue running. The runtime then periodically resumes the asynchronous operation until it completes, making `await` crucial when subsequent code depends on the asynchronous result.

```csharp
public async Task<int> FetchDataAsync()
{
    // Simulates a time-consuming operation
    await Task.Delay(3000);

    // Returns a value after the operation completes
    return 1;
}

public async Task MainMethodAsync()
{
    Console.WriteLine("Fetching data...");

    // Initiates FetchDataAsync without blocking the execution of MainMethodAsync
    var resultTask = FetchDataAsync();

    // Executes other code while FetchDataAsync runs
    Console.WriteLines("The data is Fetching ...");

    // Awaits the completion of FetchDataAsync and retrieves the result
    var result = await resultTask;

    // This line executes after FetchDataAsync completes and result is available
    Console.WriteLine($"Data fetched: {result}");
}


```

In this example, `FetchDataAsync` is an asynchronous method that simulates a delay and then returns a result. The `MainMethodAsync` method calls `FetchDataAsync`, using `await` to ensure that the program only continues once the data is fetched.
