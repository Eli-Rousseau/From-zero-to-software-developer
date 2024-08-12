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
