# Design Patterns

## 1. Introduction to Design Patterns

#### 1.1 What are Design Patterns

The goal of this documentation is to provide an overview of different strategies for designing reusable and extensible object-oriented software. Design patterns offer elegant solutions to recurring problems in software design by demonstrating how to organize classes and facilitate communication between them. This documentation will cover 23 design patterns presented in the book *Elements of Reusable Object-Oriented Software* by the Gang of Four. 

#### 1.2 Categories of Design Patterns

These patterns are categorized into three design categories: creational, structural, and behavioral. Creational patterns focus on various methods for creating objects, ensuring that the creation process is abstracted and simplified. Structural patterns address the relationships between objects, emphasizing how classes and objects can be composed to form larger structures. Behavioral patterns deal with the interactions and communications between objects, detailing how responsibilities can be assigned and managed among different objects.

#### 1.3 The Importance of Design Patterns

Understanding and applying design patterns helps in communicating with other software developers at a higher level of abstraction. It also enhances your ability to create more reusable, extensible, and maintainable software. These design patterns are recurring across different frameworks, so a solid understanding of them can be beneficial when learning new frameworks.

## 2. The Essentials

#### 2.1 Starting a New Java Project

###### 2.1.1 Project Structure

When starting a new project in Java, the first step is to create a new project template, such as for a command-line application. Within this template, you can create a base package in the `src` directory. This base package can contain one or more sub-packages, each acting as a container directory for one or more classes.

###### 2.1.2 Class Structure

The first line of code in any Java class must declare the package to which the class belongs:

```java
package com.example.myapp;
```

Following the package declaration, import statements are included to reuse functionalities from other classes:

```java
import java.util.List;
import java.util.ArrayList;
```

###### 2.1.3 Main Class

The core class in a Java package is typically the main class, which orchestrates the key aspects of the program from its main method. The `main` method is usually defined with a `public` access modifier so that it can be accessed from any other package. It is also `static`, allowing it to be called immediately without needing to instantiate the Main class. The return type is `void`, indicating that it does not return any specific data. The `main` method typically takes a single parameter, a string array named `args`:

```java
public class Main {
    public static void main(String[] args) {
        // Code goes here
    }
}
```

###### 2.1.4 Creating a New Class

In the base directory, you can initialize new classes. A class provides implementations for fields and methods, defining the attributes and behaviors of its instances. For each field and method, you must define the access modifier, the type, and the name. Methods also require parentheses to indicate their arguments. 

```java
package com.example.myapp;

public class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Method to display person's details
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
```

###### 2.1.5 Constructor Methods

Classes often include constructor methods, which are automatically invoked when creating an instance of the class. The constructor method must have the same name as the class itself and can be used to initialize fields:

```java
public class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Other methods...
}
```

###### 2.1.6 Instantiating and Using Class Instances

After defining a class, you can instantiate class instances, typically from the `main` method in the Main class. These instances allow you to access and manipulate the fields and methods defined within the class. To create an instance of a class, you use the `new` keyword followed by the class constructor. This process initializes the object and allows you to interact with its methods and fields.

```java
package com.example.myapp;

public class Main {
    public static void main(String[] args) {
        // Creating an instance of Person
        Person person = new Person("John Doe", 30);

        // Accessing fields and methods
        person.display(); // Output: Name: John Doe, Age: 30

        // Modifying fields using setters
        person.setName("Jane Doe");
        person.setAge(25);

        // Displaying updated details
        person.display(); // Output: Name: Jane Doe, Age: 25
    }
}
```

#### 2.2 Coupeling and Interfaces

###### 2.2.1 Coupeling

Coupling in object-oriented programming refers to the level of dependency between classes. High coupling means that a class relies heavily on another class, making the code more interdependent. When classes are tightly coupled, changes in one class can affect its dependent classes, requiring recompilation and redeployment, which complicates maintenance.

###### 2.2.2 What are Interfaces

To minimize coupling, use abstraction to hide implementation details and expose only necessary members. Interfaces are key to this process, as they serve as a contract for classes, specifying which methods must be implemented and what arguments those methods should accept. However, an interface does not provide any implementation details on how these methods should be executed. To adhere to an interface's contract, a class must use the `implements` keyword followed by the interface name right after the class name. This ensures that the class provides concrete implementations for all the methods declared in the interface.

```java
// Defining an Interface
public interface Animal {
    void makeSound();
    void eat(String food);
}

// Implementing the Interface
public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    @Override
    public void eat(String food) {
        System.out.println("Dog is eating: " + food);
    }
}
```

###### 2.2.3 Instantiating Interface Instances

Interfaces are used to create instances characterized by the methods prescribed in the interface definition. While you cannot instantiate an interface directly, you can instantiate a class that implements the interface.

```java
public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound();  // Output: Woof!
        myDog.eat("bone");  // Output: Dog is eating: bone
    }
}
```

###### 2.2.4 Dependency Injection

In larger projects, dependency injection frameworks are often used to manage and inject dependencies. This allows for greater flexibility and decouples the implementation details from the interface, making the system more modular and easier to maintain.

#### 2.3 Core Principles of Object-Oriented Programming

Object-Oriented Programming (OOP) involves four core principles: encapsulation, abstraction, inheritance, and polymorphism.

###### 2.3.1 Encapsulation

Encapsulation in OOP involves bundling the data and the methods that operate on that data into a single unit, or object. Instead of passing values around between various parts of a program, you encapsulate these values along with their associated methods within a single class instance. By defining a field as private, it becomes accessible only within the class it is declared in, ensuring that the field cannot be modified directly from outside the class. Setter methods provide controlled access to modify the field's values, typically including validation logic to ensure only acceptable values are assigned. Getter methods, or accessors, are used to retrieve the value of a particular field, maintaining the encapsulation principle by providing a controlled way to access the field's value.

```java
public class Person {
    private String name;

    // Setter method with validation
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    // Getter method
    public String getName() {
        return name;
    }
}
```

###### 2.3.2 Abstraction

Abstraction in OOP is a concept used to reduce complexity by hiding unnecessary details within classes. The main idea is to focus on what an object does rather than how it does it. By concealing the implementation details, a class is treated as a "black box," where the internal workings are hidden from the outside world. This allows developers to interact with the class through a simple and well-defined interface, promoting easier maintenance and understanding of the code. Public methods provide necessary functionalities while keeping the implementation details private, ensuring that these details do not impact other classes that do not require coupling between them.

```java
public abstract class Animal {
    // Abstract method
    public abstract void makeSound();

    // Concrete method
    public void eat() {
        System.out.println("This animal eats.");
    }
}

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}
```

###### 2.3.3 Inheritance

Inheritance is a fundamental concept in OOP that allows for code reuse by extending fields and methods from one class to another. This is achieved using the `extends` keyword, followed by the name of the class to inherit from. When a class extends another, it inherits all the fields and methods of the parent class, enabling code reuse and reducing redundancy.

```java
public class Animal {
    public void eat() {
        System.out.println("This animal eats.");
    }
}

public class Dog extends Animal {
    public void bark() {
        System.out.println("Woof!");
    }
}
```

###### 2.3.4 Polymorphism

Polymorphism in OOP refers to the ability of objects to take on multiple forms. This powerful concept allows methods to behave differently based on the object type they are acting upon, even if the methods share the same name. Polymorphism is mainly achieved through method overriding and method overloading. Abstract classes are used to create templates for other classes, representing abstract concepts that depend on concrete subclasses to function. These classes provide a common base with shared properties and methods, which concrete subclasses must implement and build upon, ensuring consistent behavior across related classes. To create an abstract class, use the `abstract` keyword before the class declaration, indicating that the class is incomplete and meant to be extended by other classes.

```java
public abstract class Shape {
    public abstract void draw();
}

public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

public class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}
```

#### 2.4 Unified Modeling Language (UML)

UML (Unified Modeling Language) is a visual language used to describe classes and their relationships. It's a useful tool for designing and understanding the structure of your code. 

###### 2.4.1 Class Representation

A class in UML is represented as a box divided into three sections: the top section contains the class name, the middle section lists the fields, and the bottom section displays the methods of the class. Fields and methods are represented by their names followed by a colon and their type. Method names are also followed by parentheses, which include parameters followed by a colon and their type. A plus sign (+) before a field or method name indicates that it is public, while a minus sign (-) indicates that it is private.

```plaintext
+------------------+
|    ClassName     |
+------------------+
| -fieldName: Type |
| +fieldName: Type |
+------------------+
| +methodName(param: Type): ReturnType |
| -methodName(param: Type): ReturnType |
+------------------+
```

###### 2.4.2 Relationships Representation

There are three main types of relationship depictions in UML:

1. Inheritance relationships are represented by a directed arrow between two classes. In this scenario, the first class (where the arrow starts) inherits from or extends the second class (where the arrow ends). The second class is often an abstract class or an interface in design patterns.

2. Composition relationships are depicted by a directed arrow with a diamond at the base between two classes. In this case, the first class (where the arrow starts) contains a field that references an instance of the second class (where the arrow ends).

3. Dependency relationships are shown by a directed dashed arrow between two classes. Here, the first class (where the arrow starts) includes a method with a parameter whose type is an instance of the second class (where the arrow ends).

## 3. Behavioral Design Patterns

#### 3.1 Memento Pattern

The Memento Design Pattern is particularly useful in scenarios where an application needs to provide a way to restore its previous state. This is commonly needed for implementing undo functionality in applications such as text editors, drawing programs, and games.

###### 3.1.1 Problem

The primary design problem that the Memento Pattern addresses is how to capture and restore an object's internal state without violating encapsulation. In other words, it allows an object's state to be saved externally in a way that the object itself does not have to expose its internal details to the outside world.

###### 3.1.2 Solution

The Memento Pattern solves this problem by introducing three key roles:

1. **Originator**: This is the object whose state needs to be saved and restored. It knows how to create a memento containing a snapshot of its current state and how to restore its state from the memento.

2. **Memento**: This is a value object that acts as a snapshot of the Originator's state. It is used to store the state and can be returned to the Originator to restore it. The Memento should be opaque and immutable to the Caretaker to prevent it from altering the state.

3. **Caretaker**: This is responsible for keeping track of the mementos. It knows when to save a memento and when to restore one, but it should not modify the mementos' contents. It maintains a history of the states (typically a stack).

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Memento%20patter.png)

#### 3.2 State Pattern

The State Design Pattern is particularly useful in scenarios where an object’s behavior needs to change based on its internal state. This pattern is ideal for applications where an object's state can change dynamically, influencing its behavior, such as user interfaces with different modes (e.g., a mouse in an image editor with different functionalities).

###### 3.2.1 Problem

The primary design problem that the State Pattern addresses is how to manage an object's behavior when it can be in different states without resorting to a complex and error-prone series of conditional statements. When an object's behavior is dependent on its state, using a series of `if-else` or `switch` statements can make the code hard to maintain and extend. The State Pattern aims to avoid these pitfalls by encapsulating the state-specific behavior within separate state objects.

###### 3.2.2 Solution

The State Pattern solves this problem by introducing three key roles:

1. **Context**: This is the object whose behavior changes depending on its current state. It maintains a reference to an instance of a `State` subclass that represents the current state and delegates state-specific behavior to this instance.

2. **State**: This is an abstract class or interface that defines the behavior that all concrete states must implement. It typically includes methods that correspond to the actions that can be performed based on the state.

3. **ConcreteState**: These are specific implementations of the `State` interface. Each `ConcreteState` class represents a distinct state and implements the behavior associated with that state. 

By encapsulating state-specific behavior within separate classes, the State Pattern allows for easier management of state transitions and promotes the addition of new states without modifying existing code. The `Context` class delegates tasks to the current `State`, which handles the appropriate actions. When the internal state changes, the `Context` simply switches to a different `ConcreteState` object, thereby changing its behavior.

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\State%20pattern.png)

#### 3.3 Iterator Pattern

The Iterator Design Pattern is particularly useful when you need to traverse a collection of items without exposing the underlying representation of that collection. This pattern is ideal for situations where you want to iterate over a set of elements in a consistent manner, regardless of how those elements are stored, such as traversing a browser history or iterating over a list of objects.

###### 3.3.1 Problem

The primary design problem that the Iterator Pattern addresses is how to provide a uniform way to access the elements of a collection without exposing its internal structure. When a collection's implementation details are hidden, it can be challenging to traverse or manipulate its elements directly. Without an iterator, you might need to write complex code that interacts with the collection's internal details or rely on exposing internal mechanisms, which can compromise encapsulation and make the code harder to maintain.

###### 3.3.2 Solution

The Iterator Pattern solves this problem by introducing two key roles:

1. **Iterator**: This is an interface or abstract class that defines methods for iterating over a collection. Key methods include:
   
   - `hasNext()`: Checks if there are more elements to iterate over.
   - `current()`: Returns the current element in the iteration.
   - `next()`: Advances to the next element and returns it.

2. **Aggregate (or Collection)**: This is the interface or abstract class that defines a method to create an iterator. It typically includes a method like `createIterator()` that returns an instance of an `Iterator`.

3. **ConcreteIterator**: This class implements the `Iterator` interface and provides the specific logic for iterating over the elements of a particular `Aggregate`. It keeps track of the current position within the collection.

4. **ConcreteAggregate (or ConcreteCollection)**: This class implements the `Aggregate` interface and provides an implementation for creating an iterator. It contains the actual collection of items and returns a new instance of `ConcreteIterator` for traversing the collection.

By separating the iteration logic from the collection itself, the Iterator Pattern allows for a clean and consistent way to access elements without exposing the collection's internal details. This separation promotes encapsulation and makes it easier to iterate over different types of collections. Additionally, this pattern supports multiple iterators over the same collection, which can be useful in various scenarios.

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Iterator%20pattern.png)

#### 3.4 Strategy Pattern

The Strategy Design Pattern is particularly useful in scenarios where you need to select an algorithm or behavior dynamically based on user input or other conditions. This pattern is ideal for situations where an object can perform various actions or operations, such as applying different filters or compression techniques to an image based on user preferences.

###### 3.4.1 Problem

The primary design problem that the Strategy Pattern addresses is how to manage and switch between different algorithms or behaviors without modifying the context class or the code that uses it. When an object needs to support multiple behaviors or strategies, embedding the logic for each behavior directly into the class can lead to a large and inflexible design. This approach can make it difficult to add new behaviors or to manage and extend existing ones. The Strategy Pattern aims to solve this by providing a way to define and encapsulate each behavior or algorithm in a separate class.

###### 3.4.2 Solution

The Strategy Pattern solves this problem by introducing three key roles:

1. **Context**: This is the class that needs to use a strategy for performing a specific operation. It maintains a reference to a `Strategy` object and delegates the operation to this strategy. For example, in an image storage system, the `ImageStorage` class would be the context that delegates the actual filtering and compression to the strategy objects.

2. **Strategy**: This is an interface or abstract class that defines the method(s) that concrete strategies must implement. This ensures that all strategies adhere to a common interface, allowing the context to interact with any strategy in a uniform way. For instance, the `Filter` and `Compressor` interfaces define methods that concrete filter and compression classes must implement.

3. **ConcreteStrategy**: These are specific implementations of the `Strategy` interface. Each `ConcreteStrategy` class implements a particular algorithm or behavior. For example, `JPEGCompression` and `PNGCompression` would be concrete implementations of the `Compressor` interface, while `BlackAndWhiteFilter` and `SepiaFilter` would be implementations of the `Filter` interface.

By defining each behavior or algorithm in a separate class, the Strategy Pattern allows for easy addition and modification of strategies without changing the `Context` class. The `Context` only needs to interact with the `Strategy` interface, which means new strategies can be introduced without altering existing code. This promotes flexibility and adherence to the open/closed principle, as the `Context` class remains closed for modification but open for extension with new strategies.

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Strategy%20pattern.png)

#### 3.5 Template Method Pattern

The Template Method Pattern is particularly useful when dealing with multiple classes that represent tasks performed on an object, where these tasks share a common structure but differ in specific details. This pattern is ideal for scenarios where you want to centralize shared logic and ensure that the common steps are consistently applied across various subclasses.

###### 3.5.1 Problem

The primary design problem that the Template Method Pattern addresses is how to define the skeleton of an algorithm in a superclass while allowing subclasses to provide specific implementations for some of the steps. When tasks share a common structure but differ in certain details, duplicating the shared logic in each subclass can lead to code duplication and increased maintenance overhead. The Template Method Pattern aims to solve this problem by centralizing the common logic in a single place and allowing subclasses to implement the specific behavior as needed.

###### 3.5.2 Solution

The Template Method Pattern solves this problem by introducing two key roles:

1. **AbstractClass**: This is the abstract parent class that defines the template method (`execute()`) outlining the steps of the algorithm. This method includes the common logic and calls one or more abstract or hook methods that subclasses must implement or can override. The abstract class ensures that the shared logic is centralized and reused.

2. **ConcreteClass**: These are subclasses that extend the `AbstractClass` and provide specific implementations for the abstract or hook methods. Each `ConcreteClass` focuses solely on the specific details of the task, relying on the `AbstractClass` to handle the common steps.

The `AbstractClass` includes an abstract method (`doExecute()`) that subclasses must implement, ensuring that each subclass can provide its specific behavior. Additionally, the `AbstractClass` can define hook methods with default implementations that subclasses can override if needed. By defining the template method (`execute()`) in the `AbstractClass`, the pattern ensures that the common steps are consistently applied, and only the specific behavior is implemented in the subclasses.

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Template%20pattern.png)

#### 3.6 Command Pattern

The Command Design Pattern is particularly useful in scenarios where you need to decouple the sender of a request from its receiver. This pattern is ideal for situations such as building graphical user interfaces (GUIs), where actions triggered by user inputs (like button clicks) need to be flexibly assigned and modified.

###### 3.6.1 Problem

The primary design problem that the Command Pattern addresses is how to encapsulate a request as an object, thereby allowing for parameterization of clients with queues, requests, and operations. When a request needs to be made, it is often useful to have a way to encapsulate the request itself, so it can be handled, stored, and passed around independently of the actual sender and receiver. Without this pattern, the sender and receiver can become tightly coupled, leading to code that is difficult to extend and maintain.

###### 3.6.2 Solution

The Command Pattern solves this problem by introducing four key roles:

1. **Command**: This is an interface or abstract class that defines the `execute()` method. All concrete commands implement this interface and provide specific implementations for the `execute()` method.

2. **ConcreteCommand**: These are implementations of the `Command` interface. Each `ConcreteCommand` class binds together a specific action on a receiver. It implements the `execute()` method to perform the action, often delegating the work to a receiver.

3. **Invoker**: This is the object that knows how to execute a command but doesn't know the specifics of the command's actions. It maintains a reference to a `Command` object and calls the `execute()` method on it.

4. **Receiver**: This is the object that performs the actual work when the command's `execute()` method is called. The `ConcreteCommand` calls methods on the receiver to carry out the request.

By decoupling the object that invokes the operation from the one that performs it, the Command Pattern promotes flexibility and extensibility. New commands can be added without altering the existing code, and commands can be parameterized with different receivers and operations, making it easy to extend and modify the system.

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Command%20pattern.png)

### 3.7 Observer Pattern

The Observer Design Pattern is particularly useful in scenarios where changes in the state of an object need to be communicated to and synchronized with multiple dependent objects. This pattern is ideal for applications where various components need to react to changes in a central data source, such as updating a user interface when the underlying data changes.

###### 3.7.1 Problem

The primary design problem that the Observer Pattern addresses is how to create a one-to-many dependency between objects so that when one object (the subject) changes its state, all its dependents (observers) are notified and updated automatically. Without this pattern, maintaining such dependencies would require tight coupling between the subject and its observers, making the system rigid and difficult to extend or modify.

###### 3.7.2 Solution

The Observer Pattern solves this problem by introducing three key roles:

1. **Subject**: This is the object that holds the state and controls the process of notifying observers about state changes. It provides methods to add, remove, and notify observers (`addObserver()`, `removeObserver()`, `notifyObservers()`).

2. **Observer**: This is an interface or abstract class that defines the update method (`update()`). All concrete observers implement this interface to receive updates from the subject.

3. **ConcreteObserver**: These are implementations of the `Observer` interface. Each concrete observer defines how it reacts to updates from the subject. When notified, it pulls the updated state from the subject and refreshes its own state accordingly.

By implementing the Observer Pattern, the subject and its observers become loosely coupled. The subject does not need to know the details of its observers, only that they implement the `Observer` interface. Observers can be added or removed dynamically, and the system remains flexible and easy to extend.

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Observer%20pattern.png)

#### 3.8 Mediator Pattern

The Mediator Design Pattern is particularly useful in scenarios where multiple objects need to communicate and collaborate but doing so directly would lead to a tangled and hard-to-maintain system. This pattern is ideal for applications like graphical user interfaces, where various components need to interact with each other frequently and in real-time.

###### 3.8.1 Problem

The primary design problem that the Mediator Pattern addresses is how to manage communication between multiple objects without having them refer to each other directly. Direct interaction between objects creates dependencies that make the system complex, difficult to understand, and challenging to maintain. As the number of objects grows, the problem exacerbates, leading to a "spaghetti code" scenario where changes in one object can have unforeseen effects on others.

###### 3.8.2 Solution

The Mediator Pattern solves this problem by introducing a mediator object that centralizes the communication logic among interacting objects. This mediator handles all communication, ensuring that objects don't need to know about each other directly. The pattern involves three key roles:

1. **Mediator**: This is an abstract class or interface that defines the communication methods. It includes a method, typically called `changed()`, which takes an object as a parameter. This method is used by the objects to notify the mediator of any changes.

2. **ConcreteMediator**: This class implements the Mediator interface. It encapsulates the interaction logic, coordinating the communication among the objects. It responds to the `changed()` notifications by handling the necessary interactions.

3. **Colleague**: These are the objects that need to communicate. Each colleague knows about the mediator but not about the other colleagues. They notify the mediator when their state changes, and the mediator handles the communication.

By using the Mediator Pattern, the system becomes more modular and maintainable. The interaction logic is centralized within the mediator, making it easier to manage and modify. Objects become simpler, focusing only on their primary responsibilities and delegating communication concerns to the mediator.

<img src="file:///D:/From%20zero%20to%20software%20developer/Design%20Patterns/Design%20Patterns%20Pictures/Mediator%20UML.drawio.png" title="" alt="" width="698">

### 3.9 Chain of Responsibility Pattern

The Chain of Responsibility Design Pattern is particularly useful in scenarios where a request needs to be processed by multiple handlers in a sequence, and where each handler can either process the request or pass it on to the next handler in the chain. This pattern is ideal for applications such as web servers handling HTTP requests, where different stages of processing (like authentication, logging, and compression) need to be applied in sequence.

###### 3.9.1 Problem

The primary design problem that the Chain of Responsibility Pattern addresses is how to process a request through a sequence of handlers without tightly coupling the request sender to the specific handlers. Without this pattern, the sender would need to be aware of the entire processing sequence, making the system rigid and difficult to maintain or extend.

###### 3.9.2 Solution

The Chain of Responsibility Pattern solves this problem by introducing a chain of handler objects. Each handler has a reference to the next handler in the chain and decides either to process the request or to pass it along to the next handler. The pattern involves three key roles:

1. **Handler**: This is an abstract class or interface that defines the method `handle(request)` and maintains a reference to the next handler in the chain. It includes a method `setNext(handler)` to set the next handler.

2. **ConcreteHandler**: These classes implement the `Handler` interface. Each concrete handler processes the request or passes it to the next handler in the chain.

3. **Client**: This is the initiator of the request. It holds a reference to the first handler in the chain and starts the request processing.

By using the Chain of Responsibility Pattern, each handler is responsible for a single aspect of request processing, adhering to the Single Responsibility Principle. The handlers are loosely coupled, making the system flexible and extensible. New handlers can be added without modifying existing code, and the order of handlers can be easily changed.



![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Chain%20of%20Resposbilities%20pattern.png)

### 3.10 Visitor Pattern

The Visitor Design Pattern is particularly useful in scenarios where an object structure needs to support various operations without changing the classes of the elements on which it operates. This pattern is ideal for applications like processing HTML documents, where different types of HTML nodes might require different operations such as highlighting or converting to plain text.

###### 3.10.1 Problem

The primary design problem that the Visitor Pattern addresses is how to add new operations to an existing object structure without modifying the structure itself. When new operations need to be added, modifying the object structure directly violates the open-closed principle. This leads to code that is hard to maintain and extend, as changes in operations require changes in multiple classes.

###### 3.10.2 Solution

The Visitor Pattern solves this problem by separating the operations from the object structure. It introduces a Visitor interface that defines a visit method for each type of element in the object structure. The pattern involves three key roles:

1. **Element**: This is an interface or abstract class that declares an `accept(Visitor)` method. All concrete elements in the object structure implement this method to accept a visitor object.

2. **ConcreteElement**: These are the classes that implement the Element interface. Each concrete element class implements the `accept(Visitor)` method to call the visitor's appropriate visit method.

3. **Visitor**: This is an interface that declares visit methods for each type of element. Each method is responsible for performing the operation on the specific element type.

4. **ConcreteVisitor**: These are the classes that implement the Visitor interface. Each concrete visitor class provides the implementation for the visit methods, encapsulating the logic for a specific operation.

By using the Visitor Pattern, new operations can be added by creating new visitor classes without altering the existing object structure. This promotes flexibility and adheres to the open-closed principle.

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Visitor%20pattern.png)
