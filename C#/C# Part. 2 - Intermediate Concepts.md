# C#: Part. 2 - Intermediate Concepts

## 1. Classes

#### 1.1 What are Classes

A class in C# is a fundamental building block of a software application. Applications are typically composed of multiple classes, each responsible for a specific behavior or functionality. These classes work together to deliver the overall functionality of the application. Essentially, a class is a blueprint that defines a particular type, with specific responsibilities depending on the nature of the application and the layer in which the class resides. 

#### 1.2 Declaring a Class in C#

To declare a class in C#, you begin with an access modifier that controls the visibility of the class. Following the access modifier, you use the `class` keyword and then provide a class name using Pascal Case, where each word starts with an uppercase letter. Inside the class declaration, you define the fields and methods that make up the class. Fields represent the data that the class holds, while methods define the actions or behaviors that the class can perform.

```csharp
public class Person
{
    public string Name;
    public int Age;

    public void Introduce()
    {
        Console.WriteLine($"Hi, I'm {Name} and I'm {Age} years old.");
    }
}
```

#### 1.3 Class Instances

An object is a specific instance of a class that exists in memory, with its own values for the class's fields and the ability to perform actions defined by the class's methods. To create an object, you declare a variable of the class type, use the `new` keyword to allocate memory, and can optionally use the `var` keyword for type inference. Once instantiated, the object's members (fields and methods) can be accessed using dot notation.

```csharp
Person person1 = new Person();
person1.Name = "John";
person1.Age = 30;
person1.Introduce();  // Output: Hi, I'm John and I'm 30 years old.
```

#### 1.4 Instance Members vs. Static Members

In C# classes can have two type of members: 

1. **Instance members** are specific to a particular object, meaning they can only be accessed through an instance of the class. 
   
   ```csharp
   // Instance member
   obj.InstanceMethod();
   ```

2. **Static members**, however, belong to the class itself and can be accessed without creating an instance. Static members are useful for representing concepts that are singleton in nature, where only one instance should exist in memory. To declare a member as static, you include the `static` keyword after the access modifier. This keyword can be applied to both fields and methods, making them accessible at the class level rather than the instance level.
   
   ```csharp
   // Static member
   MyClass.StaticMethod();
   ```

#### 1.5 Constructors

###### 1.5.1 Declaring a Class Constructor

In C#, a constructor is a special method called when an instance of a class is created to initialize the class's fields and ensure the object is in a valid state. If no constructor is defined, C# provides a default parameterless constructor that sets fields to their default values (e.g., `0` for integers, `null` for reference types). However, if a custom constructor is defined, the default constructor is omitted unless explicitly declared. Constructors are named the same as the class and do not have a return type.

```csharp
public class MyClass
{
    private int Value;

    // Constructor
    public MyClass(int initialValue)
    {
        this.Value = initialValue; // Initialize the field
    }
}
```

The `this` keyword is frequently used within constructors to refer to the current instance of the class, distinguishing between class fields and constructor parameters with the same names.

###### 1.5.2 Constructor Overloading

Constructor overloading allows a class to have multiple constructors with different sets of parameters. This provides flexibility in how an object can be instantiated, accommodating various initialization scenarios. The C# compiler automatically selects the appropriate constructor based on the number and types of arguments provided.

```csharp
public class MyClass
{
    private int Value;
    private string Name;

    // Constructor 1
    public MyClass(int initialValue)
    {
        this.Value = initialValue;
    }

    // Constructor 2
    public MyClass(int initialValue, string name)
    {
        this.Value = initialValue;
        this.Name = name;
    }
}
```

###### 1.5.3 Constructor Chaining

A common technique in constructor overloading is constructor chaining, where one constructor calls another constructor within the same class. This is achieved using the `this()` keyword followed by the appropriate parameters. Constructor chaining helps to avoid code duplication and centralizes initialization logic.

```csharp
public class MyClass
{
    private int Value;
    private string Name;

    // Primary constructor
    public MyClass(int initialValue)
    {
        this.Value = initialValue;
    }

    // Secondary constructor with chaining
    public MyClass(int initialValue, string name) : this(initialValue)
    {
        this.Name = name;
    }
}
```

###### 1.5.4 Best Practices for Constructors

Constructors should only be used when it's essential for an object's initial state to be set up during creation. Overusing constructors or overloading them excessively can lead to code that is difficult to maintain and understand. It's important to strike a balance between flexibility and simplicity, ensuring that constructors are clear and purposeful in their design.

###### 1.5.5 Object Initializers

Object initializers in C# offer a streamlined approach to initializing an object by allowing you to set its fields directly after creation, bypassing the need for multiple constructors. This feature simplifies object initialization and reduces the need for different constructors for various initialization scenarios. By using object initializers, you can assign values to an object's fields using a straightforward syntax, making the code cleaner and more maintainable.

```csharp
// Define a class with some fields
public class Person
{
    public string Name { get; set; }
    public int Age { get; set; }
}

// Initialize an object using object initializers
Person person = new Person
{
    Name = "John Doe",
    Age = 30
};
```

###### 1.5.6 Initializing Mandatory Fields

In C#, there are various approaches to initializing mandatory fields that are crucial for an object's functionality. 

1. One common approach is to use a parameterless constructor to ensure that all fields are initialized within the class. This method guarantees that the fields will always be set when an object is created.
   
   ```csharp
   // Initialization in the constructor
   public class ExampleClass
   {
       private int MandatoryField;
   
       public ExampleClass()
       {
           MandatoryField = 10; // Initialization inside the constructor
       }
   }
   ```

2. An alternative method is to initialize fields at the point of declaration, assigning default values directly in their declarations. This approach eliminates the need for a constructor to set these values.
   
   ```csharp
   // Initialization at the point of declaration
   public class ExampleClass
   {
       private int MandatoryField = 10; // Initialization at the point of declaration
   }
   ```

#### 1.6 Methods

###### 1.6.1 Method Overloading

In C#, a method's signature is defined by its name and the number and types of its parameters. Method overloading allows multiple methods in the same class to share the same name but differ in their signatures. This feature increases code flexibility, making it easier for users to handle different inputs or argument counts without learning multiple method names. However, overloading should be used judiciously, only when it genuinely simplifies class usage.

```csharp
public class Person
{
    public string Name;

    public void SetName(string firstName)
    {
        this.Name = firstName;
    }

    // Overload of the method
    public void SetName(string firstName, string lastName)
    {
        this.Name = firstName + lastName;
    } 
}
```

###### 1.6.2 Params Modifier

The `params` modifier allows a method to accept a variable number of arguments. By placing the `params` keyword before the last parameter in a method declaration, you can enable the method to take any number of arguments of that parameter's type. This is especially useful when the exact number of inputs isn't known in advance.

```csharp
public void PrintNumbers(params int[] numbers)
{
    foreach (int number in numbers)
    {
        Console.WriteLine(number);
    }
}
```

###### 1.6.3 Out Modifier

The `out` modifier is used when a method needs to return multiple values. When a parameter is marked with `out`, it must be passed by reference, allowing the method to modify the argument's value and return it to the caller. Unlike the traditional return statement, which returns a single value, `out` parameters enable a method to return more than one value.

```csharp
public void Divide(int dividend, int divisor, out int quotient, out int remainder)
{
    quotient = dividend / divisor;
    remainder = dividend % divisor;
}
```

Using `out` parameters is often considered a code smell because they can complicate code readability and maintenance. This is due to the need for explicit declaration and handling of these parameters during method calls. A better alternative is to return a custom object that encapsulates all the necessary return values, providing a clearer and more organized approach.

#### 1.7 Fields

###### 1.7.1 Readonly Fields

In C#, the `readonly` access modifier can be applied to a field to ensure that it is assigned only once, either at the point of declaration or within a constructor of the class. This feature is particularly useful for maintaining the robustness and safety of an application by preventing the accidental reassignment of critical fields.

```csharp
public class ExampleClass
{
    public readonly int readonlyField = 10;

    public ExampleClass(int value)
    {
        readonlyField = value; // Field can be assigned within the constructor
    }

    public void UpdateField()
    {
        //readonlyField = 20; // This would cause a compilation error
    }
}  
```

#### 1.8


