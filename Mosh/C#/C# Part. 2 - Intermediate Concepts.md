# C#: Part. 2 - Intermediate Concepts

## 1. Classes

#### 1.1 What are Classes

A class in C# is a fundamental building block of a software application. Applications are typically composed of multiple classes, each responsible for a specific behavior or functionality. These classes work together to deliver the overall functionality of the application. Essentially, a class is a blueprint that defines a particular type, with specific responsibilities depending on the nature of the application and the layer in which the class resides. 

#### 1.2 Declaring a Class in C#

To declare a class in C#, you begin with an access modifier that controls the visibility of the class. Following the access modifier, you use the `class` keyword and then provide a class name using Pascal Case, where each word starts with an uppercase letter. Inside the class declaration, you define the fields and methods that make up the class. Fields represent the data that the class holds, while methods define the actions or behaviors that the class can perform. In C#, the convention is to write field names with an underline followed by camelCase.

```csharp
public class Person
{
    public string _name;
    public int _age;

    public void Introduce()
    {
        Console.WriteLine($"Hi, I'm {_name} and I'm {_age} years old.");
    }
}
```

#### 1.3 Class Instances

An object is a specific instance of a class that exists in memory, with its own values for the class's fields and the ability to perform actions defined by the class's methods. To create an object, you declare a variable of the class type, use the `new` keyword to allocate memory, and can optionally use the `var` keyword for type inference. Once instantiated, the object's members (fields and methods) can be accessed using dot notation.

```csharp
Person person1 = new Person();
person1._name = "John";
person1._age = 30;
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
    public int _value;

    // Constructor
    public MyClass(int initialValue)
    {
        this._value = initialValue; // Initialize the field
    }
}
```

The `this` keyword is frequently used within constructors to refer to the current instance of the class, distinguishing between class fields and constructor parameters with the same names.

###### 1.5.2 Constructor Overloading

Constructor overloading allows a class to have multiple constructors with different sets of parameters. This provides flexibility in how an object can be instantiated, accommodating various initialization scenarios. The C# compiler automatically selects the appropriate constructor based on the number and types of arguments provided.

```csharp
public class MyClass
{
    private int _value;
    private string _name;

    // Constructor 1
    public MyClass(int initialValue)
    {
        this._value = initialValue;
    }

    // Constructor 2
    public MyClass(int initialValue, string name)
    {
        this._value = initialValue;
        this._name = name;
    }
}
```

###### 1.5.3 Constructor Chaining

A common technique in constructor overloading is constructor chaining, where one constructor calls another constructor within the same class. This is achieved using the `this()` keyword followed by the appropriate parameters. Constructor chaining helps to avoid code duplication and centralizes initialization logic.

```csharp
public class MyClass
{
    private int _value;
    private string _name;

    // Primary constructor
    public MyClass(int initialValue)
    {
        this._value = initialValue;
    }

    // Secondary constructor with chaining
    public MyClass(int initialValue, string name) : this(initialValue)
    {
        this._name = name;
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
    public string _name { get; set; }
    public int _age { get; set; }
}

// Initialize an object using object initializers
Person person = new Person
{
    _name = "John Doe",
    _age = 30
};
```

###### 1.5.6 Initializing Mandatory Fields

In C#, there are various approaches to initializing mandatory fields that are crucial for an object's functionality. 

1. One common approach is to use a parameterless constructor to ensure that all fields are initialized within the class. This method guarantees that the fields will always be set when an object is created.
   
   ```csharp
   // Initialization in the constructor
   public class ExampleClass
   {
       public int _mandatoryField;
   
       public ExampleClass()
       {
           _mandatoryField = 10; // Initialization inside the constructor
       }
   }
   ```

2. An alternative method is to initialize fields at the point of declaration, assigning default values directly in their declarations. This approach eliminates the need for a constructor to set these values.
   
   ```csharp
   // Initialization at the point of declaration
   public class ExampleClass
   {
       public int _mandatoryField = 10; // Initialization at the point of declaration
   }
   ```

#### 1.6 Methods

###### 1.6.1 Method Overloading

In C#, a method's signature is defined by its name and the number and types of its parameters. Method overloading allows multiple methods in the same class to share the same name but differ in their signatures. This feature increases code flexibility, making it easier for users to handle different inputs or argument counts without learning multiple method names. However, overloading should be used judiciously, only when it genuinely simplifies class usage.

```csharp
public class Person
{
    public string _name;

    public void SetName(string firstName)
    {
        this._name = firstName;
    }

    // Overload of the method
    public void SetName(string firstName, string lastName)
    {
        this._name = firstName + lastName;
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
    public readonly int _readonlyField = 10;

    public ExampleClass(int value)
    {
        _readonlyField = value; // Field can be assigned within the constructor
    }

    public void UpdateField()
    {
        //readonlyField = 20; // This would cause a compilation error
    }
}  
```

#### 1.8 Encapsultion

###### 1.8.1 Private Fields and Public Methods

Encapsulation in object-oriented programming is the practice of bundling data and methods within a class, while hiding the internal implementation details and exposing only what is necessary. In C#, encapsulation is implemented through access modifiers, typically by making class fields private to prevent external access and unintended modification. Controlled access to these fields is provided through public getter and setter methods, allowing for validation or transformation of data, thereby ensuring data integrity and consistent behavior within an application.

```csharp
public class Person
{
    // Private field
    private string _name;

    // Public setter method
    public void SetName(string name)
    {
        this._name = name;
    }

    // Public getter method
    public string GetName()
    {
        return _name;
    } 
}
```

###### 1.8.2 Properties

In C#, a property is a class member that simplifies access to private fields by encapsulating getter and setter methods. This approach reduces the need to write separate methods for each field, streamlining code. Typically, you define a property with a `public` access modifier, specify its type and name, and include `get` and `set` methods within the property block to retrieve and assign values to the field using the `value` keyword.

```csharp
public class Person
{
    private string _name;

    public string Name
    {
        get { return _name; }
        set { _name = value; }
    }
}
```

###### 1.8.3 Auto-Implemented Properties

To further simplify property declaration, C# offers auto-implemented properties. With auto-implemented properties, you only need to specify the `get` and `set` keywords, and the compiler automatically creates a private backing field for you. This eliminates the need for manually declaring a separate field.

```csharp
public class Person
{
    public string Name { get; set; }
}
```

In this example, the `Name` property is automatically backed by a private field, and you don't need to write additional code to manage it.

###### 1.8.4 Encapsulation with Properties

Both regular and auto-implemented properties support encapsulation. You can control the visibility of the `get` and `set` methods by specifying access modifiers. For instance, you might want a property to be read-only outside the class but writable within it. This can be achieved by making the setter private.

```csharp
public class Person
{
    public string Name { get; private set; }

    public Person(string name)
    {
        Name = name;
    }
}
```

###### 1.8.5 Indexers

In C#, an indexer allows you to treat an object like an array, making it simpler to access elements within a class that represents a collection or list of values. This is particularly useful for classes that implement collection semantics, enabling direct retrieval or assignment of values using a key or index, similar to how arrays or dictionaries work. Unlike defining a separate method like `GetItem()` for each key, an indexer uses the `this` keyword with square brackets and a parameter (typically a string or integer) to streamline data access and make your code more intuitive.

```csharp
public class SampleCollection
{
    private Dictionary<string, int> data = new Dictionary<string, int>();

    public int this[string key]
    {
        get { return data[key]; }
        set { data[key] = value; }
    }
}

var collection = new SampleCollection();
collection["exampleKey"] = 42;
int value = collection["exampleKey"];
```

## 2. Associations Between Classes

#### 2.1 Coupling

Coupling is a measure of how closely connected different classes and subsystems are within a software application. In tightly coupled systems, changes made to one class often necessitate modifications in related classes, leading to a cascade of recompilations and redeployments across the entire system. This interdependency can make the software difficult to maintain and evolve. In contrast, loosely coupled systems are more resilient to change; modifications in one class have minimal impact on others, making the application easier to maintain and extend. To manage coupling effectively, understanding the relationships between classes is crucial. Two primary types of relationships in object-oriented programming are inheritance and composition.

#### 2.2 Inheritance

Inheritance allows a class (child) to inherit code and behavior from another class (parent). This promotes code reuse and enables polymorphic behavior, where child classes can be treated as instances of their parent class. For example, a general parent class can encapsulate common behaviors that are shared across multiple child classes. In C#, inheritance is implemented by placing a colon after the child class name, followed by the parent class name.

```csharp
public class ParentClass 
{
    public void ParentMethod() 
    {
        Console.WriteLine("Method in ParentClass");
    }
}

public class ChildClass : ParentClass 
{
    public void ChildMethod() 
    {
        Console.WriteLine("Method in ChildClass");
    }
}
```

-Since all classes in C# implicitly inherit from the `Object` class, they inherit basic methods like `Equals()`, `GetHashCode()`, `GetType()`, and `ToString()`.

#### 2.3 Composition

Composition involves building classes that contain instances of other classes. This relationship promotes code reuse and flexibility while reducing coupling. By including instances of other classes as fields, a class can leverage their functionality without becoming tightly bound to their implementation.

```csharp
public class Engine 
{
    public void Start() 
    {
        Console.WriteLine("Engine started.");
    }
}

public class Car 
{
    private Engine _engine = new Engine();

    public void StartCar() 
    {
        _engine.Start();
    }
}
```

#### 2.4 Inheritance vs. Composition

Inheritance and composition are both strategies for code reuse, but they impact coupling differently. Inheritance can create tight coupling due to its hierarchical structure, making systems rigid and difficult to modify without widespread effects. Conversely, composition promotes loose coupling by allowing classes to use behavior from other classes without inheriting it, leading to more flexible and maintainable designs. While inheritance can be useful for shared behavior, it should be used cautiously, as excessive use can result in a brittle system. Composition is often a better choice for achieving the same benefits with reduced coupling.

## 3. Encapsulation

#### 3.1 The Black Box Concept

In object-oriented programming, the black box concept refers to the principle of encapsulation, where a class hides its internal workings and exposes only what is necessary for interaction. By limiting what is visible, this approach reduces the risk that changes in the internal implementation will adversely affect other classes that rely on the class.

#### 3.2 Access Modifiers

In C#, access modifiers are used to control the visibility and accessibility of class members. This ensures that the internal details of a class remain hidden or are exposed only as needed. Below is a table summarizing the different access modifiers in C#:

| **Access Modifier** | **Description**                                  | **Accessibility**                         |
| ------------------- | ------------------------------------------------ | ----------------------------------------- |
| `public`            | Accessible from anywhere.                        | Any class or component.                   |
| `private`           | Accessible only within the class.                | Strictly within the defining class.       |
| `protected`         | Accessible within the class and derived classes. | Shared with subclasses but not outside.   |
| `internal`          | Accessible only within the same assembly.        | Limited to the current project or module. |

Note: The `internal` modifier is typically used for classes rather than class members.

## 4. Constructor Inheritance

When working with inheritance in C#, understanding how constructors operate within class hierarchies is essential. During object instantiation from a derived class, the parent (or base) class constructors are executed first, ensuring that the base part of the object is properly initialized.

However, constructors are not automatically inherited by child classes. If a derived class requires specific initialization logic, you must explicitly define a constructor in the derived class. The `base` keyword in C# is used within the derived class constructor to call the parent class constructor and pass any necessary arguments.

```csharp
// Parent class
public class Animal
{
    public string Name { get; set; }

    // Constructor for the parent class
    public Animal(string name)
    {
        Name = name;
        Console.WriteLine("Animal constructor called.");
    }
}

// Derived class
public class Dog : Animal
{
    public string Breed { get; set; }

    // Constructor for the derived class
    public Dog(string name, string breed) : base(name)  // base keyword calls the parent constructor
    {
        Breed = breed;
        Console.WriteLine("Dog constructor called.");
    }
}
```

## 5. Type Conversion

In C#, type conversion between classes in an inheritance hierarchy is common, particularly with upcasting and downcasting.

#### 5.1 Upcasting

Upcasting refers to the conversion from a derived class to a base class instance. This conversion happens implicitly because a derived class inherently includes all the properties and methods of its base class, making it safe and straightforward.

```csharp
ChildClass child = new ChildClass();
ParentClass parent = child; // Implicit upcasting
```

#### 5.2 Downcasting

Downcasting, on the other hand, involves converting a base class to a derived class instance and requires explicit casting. Since this can lead to an `InvalidCastException` if the object does not belong to the derived class, you can use the `as` keyword to avoid exceptions. The `as` keyword returns `null` if the conversion is not possible.

```csharp
ParentClass parent = new ChildClass();
ChildClass child = parent as ChildClass;

if (child != null)
{
    // Successful downcasting
}
```

Alternatively, you can use the `is` keyword to check an object’s type before casting.

```csharp
if (parent is ChildClass)
{
    ChildClass child = (ChildClass)parent;
}
```

#### 5.3 Memory Representation and Member Access

Both upcasting and downcasting involve the same object in memory. The difference lies in the perspective: viewing the object as either a base class instance or a derived class instance. This difference impacts which class members (methods, properties, etc.) are accessible. Upcasting restricts access to base class members, while downcasting allows access to derived class members.

## 6. Polymorphism

Both method overriding and abstract classes are fundamental to implementing polymorphism in C#. Polymorphism allows objects of different classes to be treated as objects of a common base class, with each object responding differently to the same method call depending on its actual class type. This leads to more flexible and maintainable code, as new classes can be introduced without altering existing functionality.

#### 6.1 Method Overriding

Method overriding in C# allows a child class to modify the implementation of a method inherited from a parent class to suit its specific needs. The base class method is marked with the `virtual` keyword, signaling that it can be overridden. In the derived class, the `override` keyword is used to provide a new implementation; otherwise, the base class's default method is used.

```csharp
// Base class
public class Animal
{
    public virtual void Speak()
    {
        Console.WriteLine("Animal sound");
    }
}

// Derived class
public class Dog : Animal
{
    public override void Speak()
    {
        Console.WriteLine("Bark");
    }
}
```

#### 6.2 Abstract Classes and Methods

Abstract classes in C# provide a foundation of shared behavior while enforcing a specific design on derived classes. They can include fully implemented methods and abstract methods, which lack implementation and must be overridden in any non-abstract subclass. The `abstract` keyword marks a class or method as incomplete, requiring derived classes to implement any abstract methods using the `override` keyword. Abstract classes cannot be instantiated directly and must be inherited by a concrete class.

```csharp
// Base class
public abstract class Animal
{
    public abstract void Speak();
}

// Derived class
public class Dog : Animal
{
    public override void Speak()
    {
        Console.WriteLine("Bark");
    }
}
```

## 7. Interfaces

An interface in C# is a construct that defines a contract of methods, properties, events, or indexers that a class or struct must implement. Unlike classes, interfaces do not provide any implementation; they simply specify what members a class must implement. This is crucial for achieving loose coupling in software design, as it allows different classes to interact through a shared contract without depending on each other's internal details.

#### 7.1 Declaring an Interface

To declare an interface in C#, you use the `interface` keyword followed by the interface name, which typically starts with an uppercase "I" to distinguish it from classes. Inside the interface, you declare methods without any implementation. Here's an example:

```csharp
public interface IAnimal
{
    void Speak();
    void Move();
}

// Concrete class provides interface implemntation
public class Dog : IAnimal
{
    public void Speak()
    {
        Console.WriteLine("Bark!");
    }

    public void Move()
    {
        Console.WriteLine("The dog runs.");
    }
}
```

#### 7.2 Importance of Interfaces in Unit Testing

Interfaces play a significant role in unit testing by enabling the isolation of components. In unit testing, you test individual units of functionality, typically methods, to ensure they work correctly. However, methods often rely on other classes, making isolation difficult. By programming against interfaces rather than concrete classes, you can create mock or fake implementations of those interfaces to simulate the behavior of dependencies.

#### 7.3 Interfaces and Extensibility

Interfaces enhance the extensibility of applications by allowing you to change the behavior of a system without modifying its existing code. When you design against interfaces, you can later introduce new implementations that conform to these interfaces without altering the original codebase. This aligns with the Open/Closed Principle, which states that a system should be open for extension but closed for modification.

#### 7.4 Polymorphism Through Interfaces

Interfaces also facilitate polymorphism, allowing objects of different classes to be treated uniformly based on a shared interface. When multiple classes implement the same interface, they can be used interchangeably, enabling polymorphic behavior.

```csharp
IAnimal animal = new Dog();
animal.Speak();  // Output: Bark!

animal = new Cat();
animal.Speak();  // Output: Meow!
```
