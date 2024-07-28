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

## 3. Memento Pattern

The Memento Design Pattern is used for implementing undo mechanisms by capturing and restoring an object's state. Below you can see how the design pattern is laid out in UML.

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Memento%20pattern.png)

A notable aspect of the Memento Pattern is **the separation of responsibilities among classes**. The `Editor` class is dedicated to manipulating the content of an editor and creating `EditorState` instances that capture the current state of the editor. These state instances are then managed by the `History` class, which tracks changes over time and facilitates undoing operations by reverting to previous states. When an undo operation is required, a state instance from `History` is passed back to the `Editor` class to restore its previous state. This separation of concerns allows each class to focus on a specific responsibility, thereby enhancing code maintainability and clarity. The entire sequence of actions can be orchestrated from the main method in the `Main` class, ensuring a clean and organized implementation of the undo mechanism.

## 4. State Pattern

The State design pattern is a behavioral design pattern that allows an object to change its behavior when its internal state changes. This can be the case, for example, when selecting different mouse types in an image editor that allows the user to use a mouse to colour, select, or even resize an image. Depending on the state of the mouse the action one can perform with the mouse will be different. Below you can see how the design pattern is laid out in UML.

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\State%20pattern.png)

The State Pattern is notable for its use of polymorphism to represent different states of an object, such as the state of a mouse. By defining an abstract state class, each concrete state of the mouse can implement its own behavior. This approach ensures that each state handles its specific actions, making the system more modular and maintainable. When an instance of a particular state is created, it determines the behavior of the associated object, such as how a mouse interacts with an image. This design pattern eliminates the need for extensive if-else statements within the image class to check and adapt behavior based on state. Instead, the behavior is directly managed by the state instances. An image instance can be created within the main method of the Main class, and the appropriate mouse state can be assigned to it, dictating its behavior. This design pattern makes it easier **to extend for new mouse states by preventing class modification**, since modifications are based on the mouse state.

## 5. Iterator Design Pattern

The Iterator design pattern is particularly useful when you need to traverse a list of items declared in another class without concerning yourself with the internal implementation of that list. For example when iterating over a browser history. Below you can see how the design pattern is laid out in UML.

![](D:\From%20zero%20to%20software%20developer\Design%20Patterns\Design%20Patterns%20Pictures\Iterator%20pattern.png)

The Iterator Pattern is notable for its **separation of responsibilities between classes**. On one end, there is the `BrowserHistory` class, which manages the browser history, and on the other, there is the `Iterator` class, which enables iteration over an instance of `BrowserHistory`. The `Iterator` interface defines key methods such as `hasNext()`, which checks if there are more items, `current()`, which returns the current item, and `next()`, which advances to the next item in the list. This pattern ensures that the `Iterator` is defined as an interface to serve as a contract for different implementations of the iterator. This flexibility allows for iteration over various types of collections, whether they are lists, arrays, hash tables, or any other iterable objects. The iterator implementations can be declared as nested subclasses within the `BrowserHistory` object, giving them access to all private fields of the `BrowserHistory` instance. This approach ensures that any **changes made to the implementation will result in compilation errors only in the class where the implementation was altered**, without affecting other classes in the program.
