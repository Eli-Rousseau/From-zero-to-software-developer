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

## 6. Hashtables

#### 6.1 Hash Tables in Algorithms

Hash tables, also known as dictionaries, provide extremely fast lookups and can significantly optimize many algorithms. Nearly all programming languages support hash tables under various names. In Java, they are called `HashMap`. The core concept of hash tables is to store key-value pairs. A hash table uses a hash function to determine the memory address where the value associated with a key is stored. Since the hash function is deterministic, the same input will always produce the same output, allowing for efficient storage and retrieval of objects with a time complexity of O(1).

###### 6.1.1 Hash Functions

Internally, a hash table uses a key to pass through a hash function, which determines the memory location where the associated value will be stored. These locations are mapped onto an array, another data structure that stores values sequentially in memory. Essentially, hash tables use a hash function to map a key to a specific index in an array. 

For example, a simple implementation for integer keys involves dividing the key by the length of the storage array and using the remainder (modulo) as the index to store the value. When the keys are strings, each character can first be converted to its numerical representation. These numbers are then summed to create a unique representation of the string key, and the modulo operation is applied to find the appropriate index in the array for storing the value.

###### 6.1.2 Collisions

When generating hash values with a hash function, it is possible for two distinct keys to produce the same hash value, resulting in a collision where their values would be stored at the same memory location. There are two main methods to handle collisions:

1. **Chaining**: Each cell in the storage array points to a linked list. When a collision occurs, the value is added to the linked list at the corresponding array index. This method involves appending the new value to the tail of the linked list.

2. **Open Addressing**: This method finds a different free slot in the storage array through probing. Various probing algorithms can be used to handle collisions:

###### 6.1.3 Probing Solutions

| Probing Method        | Description                                                                                                                   | Formula                                               | Pros                                                           | Cons                                                                                         |
| --------------------- | ----------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------- | -------------------------------------------------------------- | -------------------------------------------------------------------------------------------- |
| **Linear Probing**    | Start from the current slot and move to the next slot, checking each slot sequentially until an open slot is found.           | slot = (hash(key) + i) % array_size (i = 1 to n)      | Simple implementation.                                         | Prone to clustering, reducing performance.                                                   |
| **Quadratic Probing** | Generate locations that are more spread out by using a quadratic function to find the next slot, helping to avoid clustering. | slot = (hash(key) + i^2) % array_size (i = 1 to n)    | Reduces clustering compared to linear probing.                 | May result in infinite loops due to repeated slot checks.                                    |
| **Double Hashing**    | Use a second, independent hash function to calculate the step size, generating a new sequence of slots for each collision.    | index = (hash1 + i * hash2) % array_size (i = 1 to n) | Minimizes clustering and provides a more uniform distribution. | More complex implementation and may still encounter performance issues in certain scenarios. |

#### 6.2 Hash Tables in Java

###### 6.2.1 Declaring Hash Tables

In Java, the `Map` interface represents a contract for creating hash tables rather than a class. This interface provides method declarations without implementations, which are supplied by classes adhering to the interface. One crucial implementation of the `Map` interface in Java is the `HashMap` class, found in the `java.util` package. 

To create a hash map, you can use the `Map` interface and initialize an object with an implementation like `HashMap`. The `Map` interface requires two generic parameters to specify the types of keys and values, typically using wrapper classes for primitive types.

```java
Map<Integer, String> hashMap = new HashMap<>();
```

###### 6.2.2 Useful Methods

Internally, a hash table uses an array to store objects. The operations supported by hash tables include:

| Method     | Description                            |
| ---------- | -------------------------------------- |
| `put()`    | Inserts an item into the hash table.   |
| `get()`    | Retrieves an item from the hash table. |
| `remove()` | Removes an item from the hash table.   |

These operations run with a time complexity of O(1) because the hash function directly determines the memory location of the object, eliminating the need to iterate over an entire array of objects. Additionally:

| Method            | Description                                                                                                                                |
| ----------------- | ------------------------------------------------------------------------------------------------------------------------------------------ |
| `containsKey()`   | Checks if the hash table contains a specific key, also running in O(1) time as it uses the hash function to find the key's position.       |
| `containsValue()` | Checks if the hash table contains a specific value, running in O(n) time because it must traverse all the values stored in the hash table. |

###### 6.2.3 Iterating over Hash Tables

To iterate over the values of a `HashMap` in Java with a for-each loop, you can use the `entrySet()` or `keySet()` methods of the `HashMap` class. The `entrySet()` method allows access to key-value pairs and provides additional methods like `getValue()`, `getKey()`, and `setValue()`. These methods facilitate efficient traversal and manipulation of the key-value pairs stored in the hash map.

#### 6.3 Sets in Java

###### 6.3 Declaring Sets

Sets are similar data structures similar to hash tables that only contains keys and no values. They don't allow duplicate keys. In Java, the `Set` interface represents a contract for creating sets rather than a class. This interface provides method declarations without implementations, which are supplied by classes adhering to the interface. One crucial implementation of the `Set` interface in Java is the `HashSet` class, found in the `java.util` package.

To create a hash map, you can use the `Set` interface and initialize an object with an implementation like `HashSet`. The `Set` interface requires a generic parameters to specify the key type, typically using wrapper classes for primitive types.

```java
Set<Integer> set = new HashSet<>();
```

## 7. Binary Trees

#### 7.1 Binary Trees in Algorithmics

Arrays, LinkedLists, Stacks, Queues, and Hash Tables are all examples of linear data structures, which can be visualized as sequences of items arranged one after another. However, computer science also includes non-linear data structures, with one of the most common being trees. A tree is a data structure that organizes items hierarchically. These elements are referred to as nodes, and the connections between them are called edges. Each node contains a value, and the top node is known as the root. Nodes connected to the root or other nodes are called child nodes, and their connecting nodes are the parent nodes. Nodes without any children are referred to as leaves. Trees are particularly useful for representing hierarchical data.

In a binary tree, each parent node has up to two child nodes. A special type of binary tree is the binary search tree, where the left child node is always smaller than the parent node, and the right child node is always larger. Binary trees support several efficient operations:

| Methods    | Description                                                 |
| ---------- | ----------------------------------------------------------- |
| `lookup()` | This operation allows for quick value searches.             |
| `insert()` | This operation enables quick insertion of values.           |
| `delete()` | This operation allows for the efficient deletion of values. |

In all of these operations at each step half of the potential search items are discarded, resulting in a logarithmic time complexity of O(log n). These operations make binary trees more efficient than arrays and linked lists, particularly for dynamic data sets where frequent insertions, deletions, and lookups are required.

#### 7.2 Tree Traversal Strategies

Tree traversal strategies can be broadly categorized into two main types: breadth-first traversal and depth-first traversal.

###### 7.2.1 Breadth-First Traversal (Level Order Traversal)

In this strategy, all nodes at the same level are visited before moving on to nodes at the next level. Essentially, the tree is traversed level by level, starting from the root and moving downwards.

###### 7.2.2 Depth-First Traversal

This strategy involves exploring as far down a branch as possible before backtracking. Depth-first traversal is further divided into three types:

1. **Pre-order Traversal**: Root, Left, Right order.

2. **In-order Traversal**: Left, Root, Right order. This traversal method results in nodes being visited in ascending order.

3. **Post-order Traversal**: Left, Right, Root order.

###### 7.2.3 Recursion

Recursion is a powerful programming technique that allows for repetition without using explicit iteration. It involves a method calling itself within its own implementation to repeat a part of the program. A crucial aspect of recursion is the base condition, which ensures that the recursive calls eventually terminate. Without this base condition, the method would continue to call itself indefinitely, leading to a stack overflow error.

In Java, recursive calls are managed using a stack data structure. Each time a recursive method is invoked, a new frame is added to the stack to keep track of the current state of the method. When the base condition is met, the stack begins to unwind, and the program proceeds to resolve each recursive call in reverse order. Recursion is particularly useful for implementing algorithms, such as Depth-First Traversal in tree structures.

###### 7.2.4 Tree Height and Depth

The concepts of tree height and tree depth are fundamental in understanding tree data structures. 

- The depth of a node is defined by its distance from the root. The root node has a depth of 0, its direct children have a depth of 1, and this pattern continues down to the leaves.

- The height of a tree, on the other hand, is measured from the leaves up to the root. To determine the height of a node, one counts the longest path from that node down to a leaf. The height of the tree is the height of the root node. 

To find the height of a tree, one can use a Depth-First Traversal (DFS) strategy, which explores each branch of the tree as far as possible before backtracking, ensuring that the longest path from the root to a leaf is measured.

## 8. AVL Trees

#### 8.1 Balanced vs Unbalanced Trees

In a Binary Search Tree, most operations can run in logarithmic time complexity, but this efficiency is only maintained when the tree is balanced. A balanced tree is defined by the property that the difference in height between the left and right subtrees of any node is less than or equal to one. 

However, not all Binary Search Tree are balanced. In a right-skewed binary tree, most nodes have only a right child, leading to an unbalanced structure where the tree resembles a linked list leaning to the right. Similarly, in a left-skewed binary tree, most nodes have only a left child, creating a linked-list-like structure leaning to the left. These skewed trees do not function efficiently as BSTs, as they degrade to linear time complexity for operations, similar to linked lists.

#### 8.2 Self-Balancing Trees

To address this issue, AVL trees were introduced as the first self-balancing binary search trees. AVL trees automatically maintain balance after each insertion or deletion by ensuring that the height difference between the left and right subtrees of any node remains less than or equal to one. When an imbalance is detected, AVL trees use rotations to restore balance. 

###### 8.2.1 Rotations

There are four types of rotations used in AVL trees:

1. **Left (LL) Rotation**:
   
   - Used when the imbalance occurs at the right child node connected to the right subtree, creating a right-skewed tree.
   - The parent node is rotated to become the left subtree of the child node.

2. **Right (RR) Rotation**:
   
   - Used when the imbalance occurs at the left child node connected to the left subtree, creating a left-skewed tree.
   - The parent node is rotated to become the right subtree of the child node.

3. **Left-Right (LR) Rotation**:
   
   - Used when the imbalance occurs at the left child node connected to the right subtree.
   - First, a left rotation is performed on the left child node, creating a left-skewed tree, followed by a right rotation on the parent node.

4. **Right-Left (RL) Rotation**:
   
   - Used when the imbalance occurs at the right child node connected to the left subtree.
   - First, a right rotation is performed on the right child node, creating a right-skewed tree, followed by a left rotation on the parent node.

These rotations ensure that AVL trees remain balanced, maintaining the logarithmic time complexity for operations and optimizing the tree's performance.

## 9. Heap Trees

#### 9.1 The Heap Properties

A heap is a special type of binary tree characterized by two main properties. First, it is a complete tree, meaning every level of the tree, except possibly the last, is fully filled with nodes, and all nodes are as far left as possible. Second, it adheres to the heap property, where the value of each node is greater than or equal to the values of its child nodes. Depending on whether the root holds the largest or smallest value, we refer to the tree as a max heap or a min heap, respectively.

Heaps are particularly useful in sorting data, graph algorithms for finding the shortest path between nodes, and implementing priority queues.

#### 9.2 Operations on Heap Trees

To construct a heap, we start by populating the tree with values while ensuring compliance with the heap property. Beginning with the root value, child nodes are added. If a child node's value is larger than the parent node's, it violates the heap property, and the child value must be moved up, a process known as "bubbling up." The time complexity of bubbling up is O(log(n)) because it involves traversing part of the tree up to its height, requiring at most O(log(n)) comparisons.

Nodes can also be removed from a heap, typically starting with the root. The root is replaced by the last value in the tree, and if this new root value is smaller than its child nodes, it violates the heap property. To correct this, we perform "bubbling down," swapping the parent node with its largest child node until the heap property is restored. This process also has a time complexity of O(log(n)), as the value can traverse the tree's height.

Finding the maximum value in a heap is efficient, running in constant time O(1), since it is always located at the root of the tree.

#### 9.3 Creating Heap Trees

Compared to other binary search trees, heap trees offer a unique advantage in terms of memory storage. Instead of implementing recursive instances, heap trees can be efficiently stored as arrays. In this array representation, the root is stored at the first index. The indices of the left and right child nodes can be calculated using simple arithmetic: the left child of a parent at index *(i)* is located at *(2i + 1)*, and the right child is at *(2i + 2)*. Conversely, to find the parent of a node at index *(i)*, the formula *((i - 1) / 2)* is used. This array-based implementation significantly reduces memory overhead and simplifies the management of heap structures.

#### 9.4 Sorting items with Heap Trees

In a max heap tree, the largest number is always located at the root. When the root is removed from the heap, the next largest value moves up to take its place. By performing sequential removal operations on the max heap tree until it is empty, you can obtain a sorted array of the items stored in the tree in descending order. This process effectively sorts the elements by continually removing the maximum value and rebalancing the heap in a time complexity of O(log(n)).

### 10 Tries

#### 10. Autocompletion with Tries

Tries are a type of non-binary tree data structure where each node can have multiple child nodes. Tries are particularly useful for auto-completion tasks because they allow for the storage of millions of words and enable super-fast lookups. They efficiently identify words with the same prefix by structuring each node to potentially have up to 26 child nodes, corresponding to the letters of the alphabet. 

#### 10.2 Operations on Tries

The root node of a trie is typically null or an empty character, indicating the starting point for all different words, as no tree can have 26 distinct roots. This empty root allows any word to start from a unified starting point. When looking up a word in a trie, each index of the word corresponds to traversing a maximum of 26 nodes, resulting in a lookup time complexity of O(L), where L represents the length of the word. This is significantly more efficient compared to arrays, where the time complexity for lookup is O(n), with n being the number of elements in the array.

Inserting and deleting operations in a trie also involve traversing a branch corresponding to the word's length, both achieving a time complexity of O(L). This makes tries an effective data structure for tasks requiring quick and efficient word retrieval based on prefixes.

#### 10.3 Tries Traversal

There are two primary ways to traverse a trie: pre-order and post-order traversal. 

In pre-order traversal, each node is visited before its children. This method is particularly useful for inserting a word into a trie, as it allows you to establish the correct node structure from the root down to the leaves.

In post-order traversal, the process starts at the deepest nodes and moves sequentially back up the structure. This approach is beneficial for deleting a word from a trie, ensuring that nodes are only removed after their children have been processed.

## 11. Graphs

#### 11.1 Graphs Structure

Graphs are used to represent connected objects, making them ideal for depicting networks. By using a graph, one can visualize how objects are connected and assess the strength of these connections. Graphs, like trees, consist of nodes (or vertices) and edges. Mathematically, a tree is a type of graph without any cycles. Unlike trees, graphs do not have a root, and nodes can be connected to any other node without restrictions on the number of connections or edges a node can have. Nodes directly connected to each other are called adjacent or neighboring nodes. If the edges have directions, it is a directed graph; otherwise, it is an undirected graph. Connections between nodes can have weights representing the strength of a particular connection.

#### 11.2 Implementing Graphs

There are two main ways to implement graphs in code: using an adjacency matrix or an adjacency list.

###### 11.2.1 Adjacency Matrix

An adjacency matrix is a two-dimensional array where nodes are represented in both rows and columns, indicating the source and target nodes for directed connections. If two nodes are connected, their intersection is marked, typically with a 1 or a Boolean value. The space complexity of an adjacency matrix is \(O(v^2)\), where \(v\) is the number of vertices. 

- **Adding a Node**: Adding a node requires updating both rows and columns, resulting in a time complexity of \(O(v^2)\). Preallocating a large matrix can mitigate the need to copy data but wastes memory.
- **Removing a Node**: Removing a node involves copying connections to a smaller matrix, also with a time complexity of \(O(v^2)\).
- **Adding/Removing a Connection**: Changing the value of a connection is efficient, with a time complexity of \(O(1)\), by using a hash table to find indices.
- **Querying a Connection**: Similar to adding/removing a connection, querying a connection also takes \(O(1)\) time.
- **Finding Neighbors**: Finding all neighbors of a node requires iterating over each value in the array, with a time complexity of \(O(v)\).

###### 11.2.2 Adjacency List

An adjacency list uses an array of linked lists, where each array element represents a node and its linked list contains its adjacent nodes. Node identifiers are stored in a hash table for quick access. The space complexity is \(O(v + e)\), where \(e\) is the number of edges.

- **Adding a Node**: This operation has a time complexity of \(O(1)\).
- **Removing a Node**: Removing a node requires updating the adjacency list and all occurrences of the node in other lists, with a time complexity of \(O(v + e)\) or \worst-case (O(v^2)\) in dense graphs.
- **Adding an Edge**: Adding an edge involves checking for its existence and then adding it, with a worst-case time complexity of \(O(v)\) in dense graphs.
- **Removing an Edge**: Removing an edge also involves checking for its existence and removing it, with a worst-case time complexity of \(O(v)\) in dense graphs.
- **Finding an Edge**: Similar to adding/removing an edge, finding an edge takes \(O(v)\) time in the worst case.

###### 11.2.3 Choosing Between Adjacency Matrix and Adjacency List

When dealing with very dense graphs, both the adjacency matrix and adjacency list approaches approximate the same space complexity. However, the adjacency matrix tends to perform better in adding, removing, or querying edges due to its constant time complexities (\(O(1)\)). For less dense graphs, an adjacency list is preferable due to its lower space complexity and efficient handling of sparse connections.

#### 11.3 Traversal Strategies in Graphs

In tree algorithms, traversal strategies such as breadth-first and depth-first rely on the leaf and root structure inherent to trees. However, graphs do not have leaves or roots, allowing traversal to start from any node within a connected network. 

###### 11.3.1 Depth-First Traversal

The depth-first traversal algorithm can be initiated from any starting node in a graph. From the chosen node, the algorithm explores all its child nodes and recursively applies the same strategy to each of these child nodes. If a specific node is found to be a child of multiple parent nodes, there is no need to explore its child nodes again. This helps in avoiding redundant traversal and ensures efficient exploration of the graph.

###### 11.3.2 Breadth-First Traversal

The breadth-first traversal algorithm involves visiting a node and then all its neighbors before proceeding further. This can be implemented using a queue, where the neighbors of the currently visited node are added to the queue to be processed next. Like in depth-first traversal, if a specific node is found to be a child of multiple parent nodes, there is no need to explore its child nodes again. This ensures that each node is visited only once, maintaining efficiency and preventing redundancy.

###### 11.3.3 Topological Sorting Algorithm

Topological sorting algorithms are used to determine the correct order to process nodes in a graph, which is particularly useful in applications such as scheduling jobs to complete a project. It's important to note that these algorithms might produce different but equivalent results, as the order of some nodes may not depend on each other.  Topological sorting only works on graphs without cycles, known as directed acyclic graphs (DAGs). This ensures that the algorithm can start from a beginning node and end at a terminal node without encountering any cyclic connections.

To achieve topological sorting, a depth-first traversal strategy can be employed from the initail node. The terminal node is added to a stack structure once it is reached. The algorithm then backtracks, adding parent nodes to the stack in sequence.  Before adding the initial node to the stack, the algorithm ensures that all its child nodes have been processed. This can be done by traversing the graph from the initial node to the terminal node using depth-first traversal. The process is repeated until all nodes have been visited and added to the stack.

#### 11.4 Detecting Cycles in a Directed Graph

To detect a cycle in a directed graph, one can use three sets to track the nodes' states: the "all" set containing all nodes initially, the "visiting" set for nodes currently being explored, and the "visited" set for nodes fully explored. The process begins by placing all nodes in the "all" set and selecting a node to move to the "visiting" set. From there, the child nodes of this node are also moved to the "visiting" set, and this process continues recursively. When a node with no more child nodes to visit is reached, all nodes in the "visiting" set are moved to the "visited" set in a manner where the last visited node is the first moved. This process is repeated until all nodes are transferred from the "all" set to the "visiting" and then to the "visited" set. A cycle is detected if a node in the "visiting" set has a child node that is also in the "visiting" set, indicating a node is revisited before its exploration is complete, thus confirming the presence of a cycle.

## 12. Undirected Graphs

#### 12.1 Shortest Path Algorithm

Weighted graphs are characterized by weights assigned to their edges, often representing magnitudes such as distances. A common application of weighted graphs is finding the shortest path between two nodes. Dijkstra's Shortest Path Algorithm is a classical algorithm for this purpose. It involves generating an information table for a node, storing the distances from the node to itself and to all other nodes in the graph, initially set to unknown. The algorithm then compares the distances from the node being processed to its connected child nodes in the undirected graph. If a shorter distance is found, it updates the table and records the current node as the previous node. This table is only updated if the new distance is smaller than the previously recorded distance.

Based on the information table, the algorithm selects the node with the smallest distance as the new central node and updates the distances for its unvisited child nodes. This process repeats until all nodes have been visited. At the end, the information table allows reconstruction of the shortest path from any node to the start node using the recorded distances and node references. Dijkstra's algorithm is considered a greedy algorithm, as it finds an optimal solution by selecting the optimal choice at each step.

To implement Dijkstra's algorithm, one needs to use a breadth-first traversal strategy. This can be achieved using a queue, where child nodes are visited in the order they are added. However, since nodes must be visited based on the smallest distance recorded in the information table, a priority queue is more suitable than a regular queue for this purpose.

#### 12.2 Detecting Cycles in a Undirected Graph

To detect a cycle in an undirected graph, one needs to keep track of a set of visited nodes. This can be achieved using depth-first traversal starting from any node. As you traverse each child node, you must pass along the origin of the parent node to ensure you are not simply returning in the original direction. Each traversed node is added to the visited set. If, during this traversal, you encounter a node that is already in the visited set, a cycle is detected.

#### 12.3 Spanning Trees

In graph algorithms, a spanning tree is a subgraph of an undirected graph that includes all the nodes of the original graph, ensuring they remain connected, and is itself a tree. Essentially, a spanning tree connects all the vertices together without forming any cycles and uses the minimum number of edges, which is \(n - 1\), where \(n\) is the number of nodes. If there are fewer than \(n - 1\) edges, not all nodes are connected.

###### 12.3.1 Minimum Spanning Tree

A minimum spanning tree (MST) is a type of spanning tree where the total weights on the edges are minimized. Prim's algorithm is a classical method used to find an MST in a weighted undirected graph. The algorithm starts with an arbitrary node and selects the edge with the minimum weight to create the initial tree. Sequentially, it traverses the edge with the minimum weight that connects the tree to a node not yet included in the tree, extending the tree by adding the smallest connected edge. This greedy approach ensures that all nodes are visited, resulting in a minimum spanning tree. For the implementation, a priority queue can be used to keep track of the connected edges and their weights at each iteration of the algorithm.

## 13. Sorting Algorithms

Sorting algorithms are fundamental to computer science and are used to organize data in a specified order, typically in ascending or descending order. It is essential to have an understanding of how these algorithms work, how they are implemented and their time complexity.

#### 13.1 Bubble Sort

###### 13.1 Bubble Sorting Process

Bubble sort is the simplest of all sorting algorithms and is used to sort an array of numbers in increasing order. The algorithm works by repeatedly scanning the array from left to right and swapping adjacent items if they are out of order. This process is repeated multiple times until all the numbers are correctly ordered. After each full scan, the next largest number will be correctly placed at the end of the array, a process often referred to as "bubbling up." 

###### 13.1.2 Time complexity

In the best-case scenario, where the array is already sorted, bubble sort requires only a single pass over the array, giving it a time complexity of O(n). In the worst-case scenario, where the array is in reverse order, it requires n passes over the array, with n being the number of elements in the array. Each pass involves n comparisons, making the time complexity O(n^2) in the worst case.

#### 13.2 Selection Sort

###### 13.2.1 Select Sorting Process

Selection sort is a sorting algorithm used to arrange an array of numbers in ascending order. It works by repeatedly passing over the array, selecting the smallest item from the unsorted portion, and placing it at the front by swapping it with the item at that position. This process creates a sorted section at the front and an unsorted section at the back of the array. In each subsequent iteration, the next smallest item in the unsorted part is found and swapped into place next to the sorted section. This continues until the entire array is sorted.

###### 13.2.2 Time Complexity

Both the best-case and worst-case scenarios require n passes over the array, with n being the number of elements in the array. In each pass, finding the smallest value in the unsorted part requires n operations. Consequently, the time complexity of the selection sort algorithm is O(n^2) in both best and worst cases.

#### 13.3 Insertion Sort

###### 13.3.1 Insert Sorting Process

Insertion sort is a sorting algorithm used to arrange an array of numbers in ascending order. It works by iterating through the array, taking each new number, and inserting it into its correct position within an already sorted section of the array. To insert a new number, the algorithm scans the sorted part of the array to find the appropriate spot and shifts the larger numbers to the right to make space. During each iteration, a number from the unsorted part of the array is selected and inserted into the sorted part.

###### 13.3.2 Time Complexity

Reading the input array and selecting a new number requires n iterations, where n is the number of items in the array. If no items need to be shifted, the operation takes O(1) time; otherwise, in the worst case, shifting all items takes O(n) time. Consequently, the time complexity of the insertion sort algorithm is O(n) in the best case and O(n^2) in the worst case.

#### 13.4 Merge Sort

###### 13.4.1 Merge Sorting Process

Merge sort is a sorting algorithm used to arrange an array of numbers in ascending order. It follows the divide-and-conquer principle, which involves breaking down a list into smaller sublists, sorting these sublists, and then merging them back together to form a complete sorted list. 

The process begins by splitting the array in half, which requires additional space allocation in memory as the numbers from the original array are copied into new subarrays. These subarrays are recursively divided until each array consists of a single, indivisible number. During the backtracking phase of recursion, the arrays are merged in the correct order. This merging operation involves iterating over the items in both subarrays and adding the smallest number from either array to a new merged array. This process continues until all the numbers are sorted and merged back into a single array.

###### 13.4.2 Time and Space Complexity

The merge sort algorithm operates by recursively dividing the problem into smaller subproblems, each of which is solved and then combined to solve the larger problem. The dividing process resembles tree traversal, which has a time complexity of O(log(n)). The merging part requires iterating over all elements of the subarrays, taking O(n) operations. Therefore, the overall time complexity of merge sort is O(n log(n)). However, this efficiency comes at the cost of additional memory allocation, as splitting the array into subarrays requires the same space as the original array, resulting in a space complexity of O(n).

#### 13.5 Quick Sort

###### 13.5.1 Quick Sorting Process

Quick sort is a widely used sorting algorithm for arranging an array of numbers in ascending order. Unlike merge sort, it does not require additional space for subarrays, as it sorts the array in place. The process begins by selecting a pivot, which is often the last number of the array. The array is then rearranged so that all numbers smaller than the pivot are placed to its left, and all numbers larger are placed to its right, effectively positioning the pivot in its correct sorted location. 

###### 13.5.2 Time and Space Complexity

The partitioning of the array involves iterating through the array with a pointer marking the boundary between smaller and larger numbers. Each time a number smaller than the pivot is encountered, it is swapped to the left partition, moving the boundary forward. This partitioning takes O(n) operations. 

Quick sort then recursively applies the same process to the subarrays on the left and right of the pivot. Ideally, the pivot divides the array into two roughly equal halves, leading to a time complexity of O(log(n)) for the recursive steps. In the best-case scenario, this results in an overall time complexity of O(n log(n)). However, in the worst-case scenario, such as when the array is already sorted, the pivot ends up at one extreme of the array, resulting in a time complexity of O(n^2). 

###### 13.5.3 Merge vs Quick Sorting

Despite the potential for a worst-case scenario, quick sort is often preferred over merge sort because it generally performs better in practice and requires less memory. The algorithm does not need extra space for subarrays, although the recursive calls do use some stack space. Nonetheless, quick sort's in-place sorting and typical performance advantages make it a popular choice for many programming languages and frameworks.

#### 13.6 Counting Sort

###### 13.6.1 Counting Sorting Process

The sorting algorithms we've discussed so far are categorized as comparison sorting. However, there are other sorting algorithms that do not rely on comparisons but use basic arithmetic. One such algorithm is counting sort, which is used to arrange an array of numbers in ascending order. Counting sort assumes that the array contains numbers within a specific range, from 0 to k, where k largest value in the input array. The algorithm works by computing the frequencies of all the numbers from 0 to k in the array. These counts are stored in a separate array, which is constructed by scanning the input array. Once the counts array is populated, it is used to update the input array according to the number of counts for each value. 

###### 13.6.2 Time and Space Complexity

Populating the counts array requires scanning the entire input array, which takes O(n) operations, where n is the number of elements in the input array. Updating the input array based on the counts array takes O(k) operations. Thus, the time complexity of counting sort is O(n + k). 

Counting sort is more efficient than comparison-based algorithms, which typically run in O(n^2) or O(n log(n)), but this speed comes at the cost of increased memory usage. The space complexity of counting sort depends on the maximum value in the input array, as extra memory is required to store the counts array.

#### 13.7 Bucket Sort

###### 13.7.1 Bucket Sorting Process

Bucket sort is a sorting algorithm that distributes numbers into several buckets, sorts each bucket using another sorting algorithm, and then combines the sorted buckets. The process begins by declaring a new array containing linked lists, which represent the buckets. Numbers from the input array are added to the appropriate linked list (bucket) based on their value. This is often done by dividing each number by the total number of buckets and using the quotient as the index for the bucket array. Once all numbers are distributed, each bucket is sorted individually using another sorting algorithm. The sorted buckets are then merged back into the input array, ensuring that all elements are in order.

###### 13.7.2 Time and Space Complexity

The initial distribution of numbers into buckets involves scanning the input array, which takes O(n) operations. Iterating over the bucket arrays is an O(k) operation, where k is the number of buckets. The time complexity for sorting the buckets depends on the chosen sorting algorithm and can range from O(1) to O(n^2). Therefore, the best-case time complexity for bucket sort is O(n + k + 1), simplified to O(n), and the worst-case time complexity is O(n + k + n^2), simplified to O(n^2). 

Allocating more buckets can reduce the sorting time per bucket but increases the space complexity. Assuming an array of k buckets, the space complexity involves allocating an array of k items, with each item being a linked list. The total number of items across these linked lists equals the original number n of elements in the input array. Hence, the space complexity is O(n + k).

## 14. Searching Algorithms

#### 14.1 Linear Search

###### 14.1.1 Linear Search Process

Linear search is the simplest searching algorithm. It involves iterating over each item in an array and comparing it to the target search item. If a match is found, the index of that item is returned; if no match is found after examining all elements, the algorithm returns -1. 

###### 14.2.2 Time Complexity

The time complexity of linear search is O(n), as each element must be checked, making it straightforward but not the most efficient for large datasets.

#### 14.2 Binary Search

###### 14.2.1 Binary Search Process

Binary search is faster than linear search but only works on sorted arrays. The algorithm begins by examining the middle value of the array. By comparing the target search value to this middle value, the search scope can be reduced to either the left or right half of the array, depending on whether the target is smaller or larger. This process is repeated, each time halving the search window, until the target value is found or the window is empty. 

###### 14.2.2 Time and Space Complexity

This divide-and-conquer approach effectively breaks the problem into smaller subproblems, resembling a tree traversal, and operates with a time complexity of O(log(n)). 

There are two main ways to implement binary search: iteratively and recursively. The iterative approach has a space complexity of O(1) since it uses a constant amount of memory. In contrast, the recursive implementation requires additional memory for each recursive call, leading to a space complexity of O(log(n)).

#### 14.3 Ternary Search

###### 14.3.1 Ternary Search Process

Ternary search is an algorithm that only works on sorted arrays. It divides the input array into three equal parts by calculating the partition size as the array length divided by three. These partitions create three windows of the same size. The target value is then compared to the two middle values, determining which of the three partitions contains the target. This process is repeated recursively until the target value is found. 

###### 14.3.2 Time Complexity

The time complexity of ternary search is O(log3(n)). Despite this, ternary search is not necessarily more efficient than binary search, which has a time complexity of O(log2(n)). This is because ternary search involves more comparisons per iteration. In binary search, each step involves three comparisons (equal to, smaller than, and larger than the middle value). Ternary search, on the other hand, requires these comparisons for two middle points at each iteration, leading to more comparisons overall. Consequently, binary search is generally faster than ternary search for the same array size, as has been mathematically demonstrated.

#### 14.4 Jump Search

###### 14.4.1 Jump Search Process

Jump search is an algorithm designed for sorted arrays, where the array is divided into blocks. The algorithm works by comparing the last value of each block with the target value. If the target value is smaller, the algorithm moves to the next block. This process continues until a block is found where the last value is larger than the target value. At this point, a linear search is performed within the identified block to find the target value. The optimal block size for jump search is the square root of the total number of elements, n, in the input array. This means each block contains roughly the square root of n elements.

###### 14.4.2 Time Complexity

The time complexity of jump search involves two main steps: jumping between blocks and performing the linear search within a block. Both steps require approximately the square root of n operations. Therefore, the overall time complexity of jump search is O(√n).

#### 14.5 Exponential Search
