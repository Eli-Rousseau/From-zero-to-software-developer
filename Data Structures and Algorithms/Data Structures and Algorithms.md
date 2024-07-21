# Data Structures and Algorithms

## 1. The Big O Notation

#### 1.1 What is Big O

Big O notation is used to describe the performance of an algorithm, specifically in terms of its scalability and efficiency as the size of the dataset grows. This metric is crucial for understanding whether an algorithm can handle larger datasets effectively, rather than simply executing quickly on smaller ones. Additionally, the cost of certain operations can vary significantly based on the data structure employed, making it essential to consider both the algorithm and the data structure in tandem when evaluating performance.

Here are some of the most recurring runtimes observed in algorithmics:

- At O(1) runtime complexity indicates that an algorithm operates in constant time, meaning that the time required to execute the algorithm remains the same regardless of the input size. This does not imply that the algorithm completes in a single operation, but rather that the number of operations it performs does not vary with the size of the input.

- At O(n) runtime, the cost of an algorithm is directly proportional to the size of the input. This means that as the input size increases, the time required to execute the algorithm increases linearly.

- At O(n²) runtime, the cost of an algorithm grows quadratically with the size of the input. This means that if the input size doubles, the execution time increases by a factor of four. Such quadratic time complexity is typical for algorithms that involve nested loops, where each loop iterates over the input data.

- At O(log n) runtime, the cost of an algorithm increases logarithmically with the size of the input. This type of complexity is characterized by the algorithm reducing the problem size by half with each step, resulting in significantly improved performance compared to a linear algorithm. As a result, even as the input size grows substantially, the number of operations required grows much more slowly.

- At O(2ⁿ) runtime, the cost of an algorithm increases exponentially with the size of the input. This means that for each additional unit increase in input size, the execution time doubles, leading to extremely rapid growth in the number of operations required. Consequently, algorithms with exponential time complexity are not scalable and become impractical for even moderately large input sizes.

#### 1.2 Calculating Big O

When computing the Big O of an algorithm, we initially consider the runtime of each individual operation. However, we typically simplify this by focusing on the operation with the largest runtime, as it has the most significant impact on overall performance. In this simplification process, constant factors and lower-order terms are often disregarded. This approach helps in providing a clearer and more concise representation of the algorithm's efficiency, particularly when dealing with multiple operations or inputs with similar runtimes.

###### 1.2.1 Ignoring Constant Factors

Consider an algorithm with two operations:

1. A loop that runs `n` times.
2. A constant-time operation that runs 100 times.

The runtime can be expressed as:
`[ T(n) = 100 + n]`

When determining the Big O notation, we ignore the constant factor (100) because it does not significantly affect the scalability of the algorithm. Thus, the runtime simplifies to:
`[ T(n) = O(n)]`

###### 1.2.2 Dominant Term

Consider an algorithm with three components:

1. A nested loop that runs \( `n^2` ) times.
2. A loop that runs `n` times.
3. A constant-time operation.

The runtime can be expressed as:
`[ T(n) = n^2 + n + 1]`

When simplifying for Big O, the dominant term \( `n^2` ) has the greatest impact on performance as `n` grows. Therefore, we can drop the lower-order terms (`n` and `1`), resulting in:
`[ T(n) = O(n^2)]`

###### 1.2.3 Multiple Inputs

Consider an algorithm with two inputs, `n` and `m`:

1. A loop that runs `n` times.
2. A loop that runs `m` times.

The runtime can be expressed as:
`[ T(n, m) = n + m]`

When expressing the Big O notation, both `n` and `m` are included as they are of the same order. Thus, the runtime is:
`[ T(n, m) = O(n + m)]`

#### 1.3 Space Complexity

In an ideal scenario, we aim for algorithms that are both fast and scalable while consuming minimal memory. However, in practice, there is often a trade-off between time and space efficiency. Allocating more memory can sometimes enhance an algorithm's speed and scalability. Conversely, when available memory is limited, we must optimize the algorithm to operate within these constraints. This makes it essential to describe an algorithm's space requirements using Big O notation, which allows us to quantify and compare the memory usage of different algorithms. The Big O notation can be used to describe both the runtime and space complexity of algorithms.

## 2. Arrays

#### 2.1 Arrays in Algorithmics

###### 2.1.1 Arrays Data Structure

Arrays are fundamental data structures used to store lists of data sequentially. Their simplicity and efficiency make them a cornerstone in algorithmics. The items of an array are stored sequentially in the memory.

###### 2.1.2 Indexing Arrays

 Because items in arrays are stored sequentially in memory, accessing an item by its index is extremely fast. The memory address calculation is straightforward, resulting in a constant time complexity of O(1).

###### 2.1.3 Adding Items to an Array

In many programming languages, arrays are static, meaning their size is fixed upon declaration. If the exact size needed is not known in advance, one must estimate the size, potentially leading to errors if the array length is too large or too small. Extending an array to accommodate more items involves creating a new, larger array and copying all the elements from the original array, resulting in a runtime complexity of O(n). This copy operation will often ensure that the array doubles in size which will affect the memory storage for that array.

###### 2.1.4 Removing Items from an Array

Deleting items from an array involves finding the item's memory position and removing it. If the item is at the end of the array, this operation has a time complexity of O(1). However, if the item is at the beginning or middle, all subsequent items must be shifted to fill the gap, increasing the runtime complexity progressively. 

#### 2.2 Dynamic Arrays in Java

Java offers two implementations of dynamic arrays: `Vector` and `ArrayList`, both declared in the `java.util` package. These classes provide resizable arrays, which automatically adjust their capacity when they get full. 

###### 2.2.1 Vector vs. ArrayList

- **Vector**:
  
  - Grows by 100% when it gets full.
  - All methods are synchronized, meaning only a single thread can access a method at a time. This makes `Vector` suitable for multithreaded applications where multiple threads need to work with the collection.

- **ArrayList**:
  
  - Grows by 50% when it gets full.
  - Methods are not synchronized, making `ArrayList` more efficient for single-threaded applications but less suitable for concurrent modifications by multiple threads.

###### 2.2.2 Declaring and Using Dynamic Arrays

When declaring an `ArrayList` or `Vector`, you need to specify a generic parameter that is a wrapper class of a primitive type, indicating the type of items in the list. If no generic parameter is provided, the dynamic array can store different types of objects.

```java
ArrayList<Integer> arrayList = new ArrayList<>();
Vector<String> vector = new Vector<>();
```

###### 2.2.3 Useful Methods

Both `Vector` and `ArrayList` come with several useful methods for manipulating collections:

| Method          | Description                                                         |
| --------------- | ------------------------------------------------------------------- |
| `add()`         | Adds an element to the collection.                                  |
| `remove()`      | Removes the specified element from the collection.                  |
| `indexOf()`     | Returns the index of the first occurrence of the specified element. |
| `lastIndexOf()` | Returns the index of the last occurrence of the specified element.  |
| `contains()`    | Checks if the collection contains the specified element.            |
| `size()`        | Returns the number of elements in the collection.                   |
| `toArray()`     | Converts the collection to an array.                                |

## 3. Linked Lists

#### 3.1 Linked Lists in Algorithmics

###### 3.1.1 Linked List Data Stucture

Linked lists are the second most commonly used data structures after arrays. They address many issues associated with arrays and can be used to construct more complex data structures. Unlike arrays, linked lists can grow and shrink dynamically. A linked list is composed of a series of nodes, each containing two pieces of data: the value and the address of the next node. These nodes are connected sequentially, with the first node called the head and the last node called the tail. Each node points to the next node, which can be located anywhere in the memory space.

###### 3.1.2 Looking up Value in Linked List

When searching for a specific value in a linked list, one must traverse the list from the head to the tail. In the worst case, the desired value is at the end of the list, resulting in a time complexity of O(n). Similarly, accessing a value by its index also has a time complexity of O(n) because the nodes are not stored sequentially in memory.

###### 3.1.3 Adding Items to a Linked List

Insertion time complexity varies depending on the location. Adding a new node at the end of the list, given the address of the tail, has a time complexity of O(1). The same applies to inserting a node at the beginning of the list if the address of the head is known. However, inserting a node in the middle requires traversing the list to find the correct insertion point, increasing the time complexity to O(n).

###### 3.1.4 Removing Items from a Linked List

Deletion time complexity also depends on the node's position. Removing the first node involves changing the head to point to the second node and removing the link from the first node, achieving a time complexity of O(1). Deleting the last node requires traversing the entire list to update the second-to-last node's link to null, resulting in a time complexity of O(n). Similarly, removing a node in the middle involves traversing the list to update the link of the previous node to bypass the node being removed, also with a time complexity of O(n).

#### 3.2 Linked Lists in Java

###### 3.2.1 Declaring Linked Lists

To create a LinkedList in Java, you can use the `LinkedList` class from the `java.util` package. This class requires a generic parameter that specifies the type of items in the linked list, typically using wrapper classes for primitive types. If no generic parameter is provided, the linked list can store different types of objects. 

```java
LinkedList<Integer> arrayList = new LinkedList<>();
```

###### 3.2.2 Useful methods

The `LinkedList` class offers a variety of methods for manipulating the list:

Certainly! Here is a table summarizing the methods and functionalities of the `LinkedList` class in Java:

| **Method**      | **Description**                                                   |
| --------------- | ----------------------------------------------------------------- |
| `addFirst()`    | Adds an element to the beginning of the linked list.              |
| `addLast()`     | Adds an element to the end of the linked list.                    |
| `removeFirst()` | Removes and returns the first element from the linked list.       |
| `removeLast()`  | Removes and returns the last element from the linked list.        |
| `contains()`    | Checks if the linked list contains a specified element.           |
| `indexOf()`     | Returns the index of the first occurrence of a specified element. |
| `size()`        | Returns the number of elements in the linked list.                |
| `toArray()`     | Converts the linked list to an array.                             |

###### 3.2.3 Singly and Doubly LinkedList

There are two main types of linked lists: singly linked lists and doubly linked lists. In a singly linked list, each node contains a pointer to the next node, facilitating straightforward traversal from the head to the tail. In contrast, a doubly linked list includes pointers to both the previous and next nodes in each node. This bidirectional linking offers advantages, such as reducing the time complexity to O(1) for deleting the last node, as it eliminates the need to traverse the entire list. However, this comes at the cost of increased memory usage due to the additional pointers.

The `LinkedList` class in Java is an implementation of a doubly linked list. These doubly linked lists can also be circular, where the last node references the first node as its next node, creating a continuous loop.

## 4. Stacks

#### 4.1 Stacks in Algorithmics

Stacks are fundamental data structures in algorithmics. The best way to visualize a stack is by imagining a stack of books: you can build a pile by placing books one on top of the other, but you can only remove the top book without disturbing the rest. To access a book at the bottom, you must first remove all the books above it. This concept is known as the Last In, First Out (LIFO) principle. This LIFO nature of stacks makes them ideal for implementing features like undo operations, where the most recently added action is the first to be undone.

#### 4.2 Stacks in Java

###### 4.2.1 Declaring Stacks

Java provides its own `Stack` class in the `java.lang` package. This class requires a generic parameter to specify the type of items stored in the stack, typically using wrapper classes for primitive types. If no generic parameter is specified, the stack can store different types of objects.

```java
Stack<Integer> stack = new Stack<>();
```

###### 4.2.2 Useful Methods

In practice, a stack is often implemented as a wrapper around a static array, providing a different way of storing and accessing objects compared to regular arrays. The main operations on a stack include:

| Method      | Description                                                   |
| ----------- | ------------------------------------------------------------- |
| `push()`    | Adds an item to the top of the stack.                         |
| `pop()`     | Removes the item from the top of the stack.                   |
| `peek()`    | Returns the item at the top of the stack without removing it. |
| `isEmpty()` | Checks whether the stack is empty.                            |

All these operations on a stack typically run in O(1) time complexity, making them very efficient. However, stacks are not designed for lookup operations and are not suitable for storing lists where random access is required, such as a list of products.

## 5. Queues

#### 5.1 Queues in Algorithmics

Queues are data structures commonly used to process tasks in the order they are received. Unlike stacks, where the last item added is the first one removed (LIFO), queues operate on a first-in, first-out (FIFO) principle. This means that the first item added to the queue is also the first one to leave it. Queues are ideal for situations where maintaining the order of tasks or elements is crucial, such as in task scheduling, managing requests in a service, or handling asynchronous data processing.

#### 5.2 Queues in Java

###### 5.2.1 Declaring Queues

In Java, the `Queue` refers to an interface rather than a class. An interface represents a contract for the classes that implement `Queue` objects, providing method declarations without their implementations. These implementations are provided by the classes that adhere to the interface. Two important implementations of the `Queue` interface in Java are the `LinkedList` class and the `ArrayDeque` class, both found in the `java.util` package.

To create a queue in Java, you can use the `Queue` interface to initialize an object with an implementation like `ArrayDeque` from the `java.util` package. This interface requires a generic parameter that specifies the type of items in the queue, typically using wrapper classes for primitive types. If no generic parameter is provided, the queue can store different types of objects.

```java
Queue<Integer> queue = new ArrayDeque<>();
```

###### 5.2.2 Usefull Methods

In practice, a queue is often implemented as a wrapper around a static array, providing a different way of storing and accessing objects compared to regular arrays. The main operations include:

| Method      | Description                                                       |
| ----------- | ----------------------------------------------------------------- |
| `enqueue()` | Adds an item to the end of the queue                              |
| `dequeue()` | Removes an item from the front of the queue.                      |
| `peek()`    | Retrieves the item at the front of the queue without removing it. |
| `isEmpty()` | Checks whether the queue has any items.                           |
| `isFull()`  | Checks whether the queue is full.                                 |

All these operations on a queue typically run in O(1) time complexity, making them very efficient. However, queues are not designed for lookup operations and are not suitable for storing lists where random access is required, such as a list of products.

#### 5.3 Priority Queues

In priority queues, objects are processed based on their priority rather than the order in which they enter the queue. In Java, priority queues are implemented using the `PriorityQueue` class from the `java.util` package. This class requires a generic parameter to specify the type of items stored in the priority queue, often using wrapper classes for primitive types. If no generic parameter is specified, the priority queue can store different types of objects.

```java
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
```
