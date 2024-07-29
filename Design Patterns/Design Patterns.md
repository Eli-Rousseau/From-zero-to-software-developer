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

1. Inheritance relationships are represented by a directed arrow between two classes, pointing to the class from which another class inherits or extends.

2. Composition relationships are represented by a directed arrow with a diamond at the base between two classes, pointing to the class from which the origin class is composed of. This indicates that one class contains a field that is an instance of another class.

3. Dependency relationships are represented by a directed dashed arrow between two classes, pointing to a reference of a class. This often occurs when a method parameter in one class refers to another class.

*In a UML relationship the arrow shows where the relationship comes from. The relationship from class 1 comes from class 2.*

## 3. Behavioral Design Patterns

#### 3.1 Memento Pattern

The Memento Design Pattern is used for implementing undo mechanisms by capturing and restoring an object's state. Below you can see how the design pattern is laid out in UML.

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Memento%20pattern.png)

A notable aspect of the Memento Pattern is **the separation of responsibilities among classes**. The `Editor` class is dedicated to manipulating the content of an editor and creating `EditorState` instances that capture the current state of the editor. These state instances are then managed by the `History` class, which tracks changes over time and facilitates undoing operations by reverting to previous states. When an undo operation is required, a state instance from `History` is passed back to the `Editor` class to restore its previous state. This separation of concerns allows each class to focus on a specific responsibility, thereby enhancing code maintainability and clarity. The entire sequence of actions can be orchestrated from the main method in the `Main` class, ensuring a clean and organized implementation of the undo mechanism.

#### 3.2 State Pattern

The State design pattern is a behavioral design pattern that allows an object to change its behavior when its internal state changes. This can be the case, for example, when selecting different mouse types in an image editor that allows the user to use a mouse to colour, select, or even resize an image. Depending on the state of the mouse the action one can perform with the mouse will be different. Below you can see how the design pattern is laid out in UML.

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\State%20pattern.png)

The State Pattern is notable for its use of polymorphism to represent different states of an object, such as the state of a mouse. By defining an abstract state class, each concrete state of the mouse can implement its own behavior. This approach ensures that each state handles its specific actions, making the system more modular and maintainable. When an instance of a particular state is created, it determines the behavior of the associated object, such as how a mouse interacts with an image. This design pattern eliminates the need for extensive if-else statements within the image class to check and adapt behavior based on state. Instead, the behavior is directly managed by the state instances. An image instance can be created within the main method of the Main class, and the appropriate mouse state can be assigned to it, dictating its behavior. This design pattern makes it easier **to extend for new mouse states by preventing class modification**, since modifications are based on the mouse state.

#### 3.3 Iterator Design Pattern

The Iterator design pattern is particularly useful when you need to traverse a list of items declared in another class without concerning yourself with the internal implementation of that list. For example when iterating over a browser history. Below you can see how the design pattern is laid out in UML.

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Iterator%20pattern.png)

The Iterator Pattern is notable for its **separation of responsibilities between classes**. On one end, there is the `BrowserHistory` class, which manages the browser history, and on the other, there is the `Iterator` class, which enables iteration over an instance of `BrowserHistory`. The `Iterator` interface defines key methods such as `hasNext()`, which checks if there are more items, `current()`, which returns the current item, and `next()`, which advances to the next item in the list. This pattern ensures that the `Iterator` is defined as an interface to serve as a contract for different implementations of the iterator. This flexibility allows for iteration over various types of collections, whether they are lists, arrays, hash tables, or any other iterable objects. The iterator implementations can be declared as nested subclasses within the `BrowserHistory` object, giving them access to all private fields of the `BrowserHistory` instance. This approach ensures that any **changes made to the implementation will result in compilation errors only in the class where the implementation was altered**, without affecting other classes in the program.

#### 3.4 Strategy Pattern

The Strategy design pattern is useful for handling different behaviors based on user input. For instance, in an image storage class, the user might need to specify the filter and compression strategy to be applied when storing an image. Below you can see how the design pattern is laid out in UML.

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Strategy%20pattern.png)

The Strategy design pattern promotes **the separation of responsibility** by delegating different behaviors to distinct classes. In an image storage system, the `ImageStorage` class is responsible for storing uploaded images, while separate `Compress` and `Filter` classes handle compression and filtering, respectively. By defining interfaces for each strategy, multiple implementations can be created. This allows **new strategies to be added without altering the existing codebase**. The `ImageStorage` class only needs a method to accept instances of the `Filter` and `Compressor` interfaces, which can then be supplemented from the main function in the Main class. Unlike the State design pattern, where an object maintains a single state represented by a subclass of its interface, the Strategy pattern uses different strategy objects to represent various behaviors, providing a robust mechanism for dynamic behavior selection.

#### 3.5 Template Pattern

The Template Method pattern is beneficial when dealing with instances of different classes that represent tasks performed on an object, where these tasks require the same logic for defining and processing the object in their constructor methods. This design pattern ensures that the common logic is centralized and reused, allowing each class to focus solely on their specific tasks without duplicating the shared logic. Below you can see how the design pattern is laid out in UML.

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Template%20pattern.png)

The Template Method design pattern uses an abstract parent class, often called Task, which implements a common `execute()` method. This method outlines the steps of that must be shared among all task subclasses, such as registering the task in an audit trail. The Task class defines an abstract `doExecute()` method, which is called within the non-abstract `execute()` method. Subclasses extending the Task class must implement `doExecute()`, providing the specific behavior for each task. Alternatively, `doExecute()` can have a default implementation, allowing subclasses to override it as needed. These default implementations are referred to as hooks. To ensure the `execute()` method handles the common logic and not the `doExecute()` implementation directly, `doExecute()` can be made protected to hide its implementation details. When operations need to be performed on the same object, the object can be passed from the subclass to the parent class using the `super` keyword in Java. This pattern ensures that subclasses focus on their specific tasks while **reusing the common logic defined in the parent class and allows to extend to new task subclasses.**

#### 3.6 Command Pattern

The Command design pattern aims to decouple commands from their concrete implementations. This is particularly useful in scenarios such as building a graphical user interface (GUI) framework, where the specific actions associated with button clicks are not known upfront. By using this pattern, the button interface is separated from its actual implementation, allowing the implementation to be delegated to the user. This enables the user to define the specific action to be executed when a button is clicked, promoting flexibility and extensibility in the design. Below you can see how the design pattern is laid out in UML.

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Command%20pattern.png)

The Command design pattern is notable for separating an instance from its action, enhancing flexibility and modularity. In this pattern, a button class receives a command instance, which follows the `execute()` contract defined by the `Command` interface. Each specific command instance provides its own implementation of the `execute()` method. But instead of directly providing an command implementation, this implmentation will be delegated to the service that uses the command instance by supplying a service instance that performs the specific action. This separation allows for **easy addition of new commands without altering the existing code**, promoting extensibility and maintaining a clean code structure.

###### 3.6.1 Composite Command

The Command design pattern also enables the implementation of a composite command, an independent class that implements the Command interface and can execute multiple commands in sequence. This is achieved by maintaining a history list of commands. When the composite command is called, it iterates over the list, executing each command in order. This approach allows for complex operations to be composed from simpler commands.

###### 3.6.2 Undoable Command Pattern

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Undoable%20command%20pattern.png)

The Command design pattern can be extended to support undoable commands, similar to the Memento design pattern. By introducing a `History` class that keeps track of all executed commands, each command instance can call the `execute()` method while being recorded in the history. An `UndoCommand` class, implementing the `Command` interface, can then use the `History` instance to retrieve and undo the last executed command via the unexecute() method. This extension adds the ability to reverse actions, enhancing flexibility and control over command execution.

#### 3.7 Observer Design Pattern

The Observer design pattern is utilized when changes in the state of an object need to be communicated to other dependent objects. For instance, when the value of a data source object changes, it might immediately affect other instances such as a spreadsheet or chart. In this pattern, the dependent objects, known as observers, are registered to receive updates from the subject (the object whose state changes). When the subject's state changes, it automatically notifies all registered observers, ensuring that they remain synchronized with the subject's current state. Below you can see how the design pattern is laid out in UML.

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Observer%20pattern.png)

When the state of an object changes, it can notify different dependent objects using the Observer design pattern. This pattern involves a mutable object extending three methods: addObserver(), removeObservers(), and notifyObserver(), which manage the registration and notification of observer instances. These methods can be inherited by the mutable class rather than being directly implemented within it. Each time the state of the object is altered, the notifyObservers() method is called to alert all registered observers. Subsequently, each observer can interact with the mutable object to retrieve the updated value and refresh its own state, a process known as pull-style interaction. This method allows the retrieval process to remain adaptable over time. The design pattern enables the notifier behavior of the mutable class to be extended flexibly, allowing any number of observer objects to be notified when changes occur in the data source values. This ensures a scalable and maintainable approach to handling dependencies and state changes in complex systems.

#### 3.8 Mediator Pattern

The Mediator Design Pattern is utilized when multiple instances need to collaborate, such as in a graphical user interface where various components must communicate their states in real-time for proper functionality. This pattern facilitates the exchange of state information between objects, allowing them to interact and coordinate without direct dependencies on each other. Instead, a mediator object handles the communication, promoting a more modular and maintainable system. Below you can see how the design pattern is laid out in UML.

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Mediator%20pattern.png)

In complex systems, particularly graphical user interfaces, the problem of numerous interactions between different objects can arise, complicating maintenance and scalability. The Mediator Design Pattern addresses this by creating an abstract class, known as a mediator, which facilitates communication among instances. Instead of objects interacting directly, they communicate through the mediator. Each object only needs to know about the mediator, not the other objects. The mediator features a changed() method, which takes an object as a parameter. When an object's state or behavior changes and needs to be communicated, this change is sent to the mediator via the changed() method. All interaction logic is encapsulated within the mediator instance. Instead of implementing this logic directly in the mediator, another class implements the mediator's abstract class contract. This setup allows for **the creation of different types of mediator instances with varying implementations** as needed, promoting flexibility and extensibility in the system.

###### 3.8.1 Enhancing the Mediator Pattern with the Observer Pattern

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Mediator&Observer%20pattern.png)

The classical Mediator Design Pattern can lead to a bulky changed method filled with numerous if-else statements to determine which controller has changed. This issue can be addressed by combining the Mediator Pattern with the Observer Pattern. In this enhanced approach, the mediator acts as an observer. Each time an instance changes, it notifies the mediator, eliminating the need for the instance to reference the mediator directly. This method simplifies the interaction logic, as the mediator automatically receives updates about state changes. To implement this, instances must include an attach() method, similar to the mutable object in the Observer Pattern, ensuring that changes in state trigger notifications to the mediator. In this design pattern, the term "event handlers" is frequently employed rather than "observers," as event handlers facilitate the management of specific instance states.
