# JavaScript DOM Manipulation

## 1. Introduction

#### 1.1 What is the DOM?

A webpage is essentially an HTML document, which the browser loads and renders for the user. Behind the scenes, the browser builds a structure known as the Document Object Model (DOM). The DOM represents the HTML elements as a tree of objects that can be accessed and manipulated using JavaScript, allowing developers to dynamically modify content, styles, and structure of a webpage, thereby enhancing the user experience.

#### 1.2 Accessing and Navigating the DOM

In developer tools, the DOM is accessible via the "Elements" tab and appears similar to the source HTML code but reflects the current state of the document loaded in the browser. Each HTML element in the DOM is represented as a node, and each node has a set of properties, such as `childNodes`, `nodeName`, and `nodeType`. These properties allow for navigation and interaction with the document.

```javascript
// Example of accessing child nodes of an element
let parentElement = document.body;
let childNodes = parentElement.childNodes;
```

#### 1.3 Key DOM Nodes and Properties

At the top level of the DOM hierarchy is the document object, which provides access to key properties such as `document.documentElement` (the `<html>` element), `document.head` (the `<head>`), and `document.body` (the `<body>`). Elements in the DOM have a parent-child relationship, and the children of any element can be accessed using the `childNodes` property. Text nodes represent the white spaces between elements but do not appear as visible parts of the page.

```javascript
// Accessing specific nodes
let firstChild = document.body.firstChild;
let nextSibling = firstChild.nextSibling;
```

#### 1.4 Manipulating DOM Elements

DOM elements are represented as JavaScript objects, although they are not inherently part of JavaScript. These objects come with attributes and methods that can be used for modification. Common tasks include selecting elements, walking through nodes, and making changes to attributes or content using methods like `getElementById`, `querySelector`, and `innerHTML`.

```javascript
// Selecting an element and modifying it
let element = document.getElementById("myElement");
element.innerHTML = "New content!";
```

#### 1.5 Incorporating JavaScript into an HTML Project

There are three primary ways to include JavaScript in an HTML project:

1. Inline JavaScript  
   JavaScript can be written directly within HTML tags using the `onclick`, `onload`, or other event attributes. This is not a recommended practice for larger projects as it mixes logic with structure.
   
   ```html
   <button onclick="alert('Hello!')">Click Me</button>
   ```

2. Internal JavaScript  
   You can embed JavaScript directly inside the HTML document within the `<script>` tag. Script elements should be placed at the bottom of the HTML document to ensure all other elements are loaded before the script runs. This approach keeps JavaScript in one place within the HTML but still couples it to the document. 
   
   ```html
   <script>
     document.getElementById("myElement").innerHTML = "Updated content!";
   </script>
   ```

3. External JavaScript  
   The best practice for larger or modular projects is to place JavaScript in a separate `.js` file and link it to the HTML using the `<script>` tag with a `src` attribute. This keeps the code organized and allows for better reusability and maintenance.
   
   ```html
   <script src="app.js"></script>
   ```

Each method has its use cases, but using external JavaScript is generally preferred for maintainability and scalability in larger projects.

## 2. Modifying Element Values or Styles

To change the internal value or appearance of a DOM element, JavaScript provides the `value` and `style` properties. The `value` property is used to update the content of input elements, modifying their internal state and reflecting the new value on the page.

```javascript
document.getElementById("myInput").value = "New Value";
```

The `style` property allows for inline manipulation of CSS properties, such as `color`, `fontFamily`, or `fontWeight`, to directly modify the appearance of a DOM element.

```javascript
document.getElementById("myElement").style.color = "blue";
```

## 3. Accessing Elements in the DOM

#### 3.1 Traversing the DOM hierarchy

DOM elements can be accessed by traversing the hierarchy starting from `document.body` and navigating through properties like `childNodes`, `firstChild`, or `lastChild`. While possible, this method is tedious and error-prone, especially when the structure of the DOM changes.

```javascript
let firstChild = document.body.firstChild;
let lastChild = firstChild.lastChild;
```

#### 3.2 Using DOM Selection Methods

JavaScript provides more efficient methods to directly select elements based on their attributes:

1. getElementById: Selects a DOM element by its unique `id`.
   
   ```javascript
   let element = document.getElementById("header");
   ```

2. getElementsByTagName: Selects all elements by tag name and returns an HTMLCollection, which can be looped over.
   
   ```javascript
   let paragraphs = document.getElementsByTagName("p");
   for (let p of paragraphs) {
     console.log(p.textContent);
   }
   ```

3. getElementsByClassName: Selects all elements by class name, returning an HTMLCollection for iteration.
   
   ```javascript
   let items = document.getElementsByClassName("item");
   for (let item of items) {
     console.log(item.textContent);
   }
   ```

#### 3.3 Querying Elements Using CSS Selectors

JavaScript also supports more flexible selection through CSS selectors:

1. querySelector: Retrieves the first element matching a CSS selector.
   
   ```javascript
   let firstButton = document.querySelector(".button");
   ```

2. querySelectorAll: Retrieves all elements matching a CSS selector, returning a NodeList, which can also be iterated over.
   
   ```javascript
   let allButtons = document.querySelectorAll(".button");
   for (let button of allButtons) {
     console.log(button.textContent);
   }
   ```

These methods offer a structured and maintainable approach to accessing and manipulating DOM elements.

## 4. Creating and Adding Elements to the DOM

To dynamically manipulate the DOM, JavaScript provides several methods for creating and adding elements, allowing developers to modify a webpage even before it fully loads.

1. Creating Elements  
   The `document.createElement()` method is used to create new HTML elements, while `document.createTextNode()` adds text content to these elements.
   
   ```javascript
   let newDiv = document.createElement("div");
   let text = document.createTextNode("Hello World!");
   newDiv.appendChild(text);
   ```

2. Appending Elements  
   To add a newly created element to the DOM, the `appendChild()` method is called on a parent node. This appends the element as the last child of the parent.
   
   ```javascript
   document.body.appendChild(newDiv);
   ```

3. Inserting Elements Before Others  
   The `insertBefore()` method allows inserting an element before another specific child element within the same parent.
   
   ```javascript
   let referenceNode = document.getElementById("existingElement");
   document.body.insertBefore(newDiv, referenceNode);
   ```

4. Inserting Elements Adjacent to Others  
   The `insertAdjacentElement()` method inserts an element relative to an existing element at specific positions, such as `beforebegin`, `afterbegin`, `beforeend`, or `afterend`.
   
   ```javascript
   referenceNode.insertAdjacentElement("beforeend", newDiv);
   ```

## 5. Removing Elements from the DOM

JavaScript offers two primary methods for dynamically removing elements from the DOM, giving developers control over modifying the webpage structure.

1. Removing Elements Directly  
   The `remove()` method is called directly on the element to be removed. This is a simple and efficient way to delete a specific node from the DOM.
   
   ```javascript
   let element = document.getElementById("myElement");
   element.remove();
   ```

2. Removing Child Elements  
   The `removeChild()` method is called on a parent element, and the child element to be removed is passed as an argument. The removed element is returned, allowing it to be stored and reused if needed.
   
   ```javascript
   let parent = document.getElementById("parentElement");
   let child = document.getElementById("childElement");
   let removedChild = parent.removeChild(child); // Store the removed element
   ```

## 6. Modifying Element Styles with CSS Classes

While directly modifying the `style` attribute of an element using JavaScript is possible, a more efficient approach is to manipulate the element's CSS classes. This method avoids triggering unnecessary re-rendering of elements when individual styles change, ensuring better performance.

To manage CSS classes, the `classList` property provides several methods to add, remove, or toggle classes on an element.

1. Adding Classes  
   Use the `add()` method to apply one or more classes to an element.
   
   ```javascript
   document.getElementById("myElement").classList.add("highlight", "active");
   ```

2. Removing Classes  
   The `remove()` method removes one or more classes from an element.
   
   ```javascript
   document.getElementById("myElement").classList.remove("active");
   ```

3. Replacing Classes  
   The `replace()` method replaces one class with another.
   
   ```javascript
   document.getElementById("myElement").classList.replace("active", "inactive");
   ```

4. Toggling Classes  
   The `toggle()` method adds the class if it is not present or removes it if it is.
   
   ```javascript
   document.getElementById("myElement").classList.toggle("hidden");
   ```

## 7. Working with Element Attributes

JavaScript provides several methods to interact with the attributes of DOM elements, enabling developers to retrieve, modify, or remove attributes.

1. Getting Attribute Values  
   The `getAttribute()` method retrieves the value of a specified attribute from a DOM element. If the attribute does not exist, it returns `null`.
   
   ```javascript
   let value = document.getElementById("myElement").getAttribute("src");
   ```

2. Setting Attribute Values  
   The `setAttribute()` method assigns a value to a specified attribute, creating the attribute if it does not already exist.
   
   ```javascript
   document.getElementById("myElement").setAttribute("alt", "New description");
   ```

3. Removing Attributes  
   The `removeAttribute()` method removes a specified attribute from a DOM element.
   
   ```javascript
   document.getElementById("myElement").removeAttribute("alt");
   ```

These methods work with both standard HTML attributes and custom attributes, including those prefixed with `data-`, which indicate non-standard, custom attributes.

```javascript
// Working with custom attributes
let dataValue = document.getElementById("myElement").getAttribute("data-custom");
```

## 8. Handling Events in the DOM

Event handling in the DOM allows developers to respond to user actions such as clicks, scrolling, text selection, and more. JavaScript provides two main ways to handle these events:

#### 8.1 Setting Load Events with the `window` Object

The `window` object, part of the Browser Object Model (BOM), allows developers to manage events like when the entire webpage has loaded. One common approach is using the `onload` property to assign a function that executes when the HTML document fully loads.

```javascript
window.onload = function() {
  console.log("Page is fully loaded");
};
```

Alternatively, the `addEventListener()` method on the `window` object lets you listen for a variety of events such as `load`, `scroll`, or `resize`. This method allows you to pass both the event type and the function to be executed.

```javascript
window.addEventListener("load", function() {
  console.log("Page loaded via event listener");
});
```

Using `addEventListener()` provides flexibility and allows multiple event handlers for the same event without overwriting existing ones, making it a preferred method for event handling.

#### 8.2 Adding Event Listeners to DOM Elements

The `addEventListener()` method can also be used on individual DOM elements to handle specific events such as `click`, `mouseover`, or `input`. This ensures that when the event occurs on the target element, the corresponding function is executed.

```javascript
let button = document.getElementById("myButton");
button.addEventListener("click", function() {
  alert("Button clicked!");
});
```

#### 8.3 Event Delegation in the DOM

Event delegation is a technique that involves setting a single event listener on a parent element, such as the `document` object, to handle events for multiple child elements. This approach improves performance by reducing the number of individual event listeners needed across the webpage.

By attaching a single event listener to the `document` object (or another top-level element), the event is captured as it bubbles up through the DOM. When an event, like a `click`, occurs on a specific element, the event listener on the parent can determine which child element triggered the event.

The event's callback function receives an `event` object, which contains useful information such as:

- `clientX`, `clientY`: The coordinates of the click.
- `altKey`, `ctrlKey`: Boolean values indicating if modifier keys were pressed.
- `type`: The type of event (e.g., "click").
- `target`: The element that triggered the event.

```javascript
document.addEventListener("click", function(event) {
  // Check the element that was clicked
  if (event.target.id === "myButton") {
    alert("Button was clicked!");
  }

  // Alternatively, use event.target.matches() for a CSS selector
  if (event.target.matches(".list-item")) {
    console.log("A list item was clicked!");
  }
});
```

This method reduces the need for multiple event listeners on individual elements, optimizing browser performance. The `event.target` property identifies the clicked element, allowing developers to respond accordingly. Using `event.target.matches()`, you can also check if the target matches a specific CSS selector, further refining your event handling logic.
