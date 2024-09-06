# React

## 1. Starting With React

#### 1.1 What is React?

React is a popular JavaScript library developed by Facebook in 2011 for creating dynamic and interactive user interfaces. It simplifies front-end development by breaking down web pages into small, reusable components, making it easier to build and maintain large-scale applications. Instead of directly interacting with the Document Object Model (DOM), React abstracts the complexity by efficiently managing DOM updates behind the scenes. This component-based structure allows developers to write modular and well-organized code, improving reusability and maintainability. 

#### 1.2 Setting Up a React Development Environment with Vite

To set up a React development environment, ensure that Node.js is installed. There are two common ways to create a React app: using Create React App (CRA), a tool developed by the React team, or Vite, a modern build tool.

To create a React app with Vite, follow these steps:

1. Run the following command in the terminal to start a Vite project:
   
   ```bash
   npm create vite
   ```

2. You’ll be prompted to enter a project name, choose a framework (select React), and specify whether to use TypeScript or JavaScript.

3. After the setup, Vite will provide steps to install dependencies and run the development server:
   
   ```bash
   cd react-app
   npm install
   npm run dev
   ```

This will launch a development server at `http://localhost:5173/`.

Within the project, you’ll find several important files and directories:

- **`node_modules/`**: Contains third-party libraries, including React.
- **`public/`**: Holds public assets like images and fonts.
- **`src/`**: Contains the source code for the application.
- **`index.html`**: A basic HTML template with a `<div>` element as the application’s container and a `<script>` element referencing `/src/main.tsx` as the entry point.
- **`package.json`**: Stores project details like the project name, version, scripts, and dependencies.
- **`tsconfig.json`**: Contains TypeScript compiler settings.
- **`vite.config.ts`**: The configuration file for Vite.

#### 1.3 Creating React Components with JSX

To create a React component, right-click the `src` folder and add a file with the `.tsx` extension. There are two common approaches to building React components: using a JavaScript class or a function. Function components are preferred for their simplicity and conciseness. The function name should follow PascalCase (each word starts with a capital letter), and the component’s UI can be defined using JSX (JavaScript XML), which allows HTML-like syntax within JavaScript.

```tsx
// MyComponent.tsx
function MyComponent() {
  return <h1>Hello, World!</h1>;
}

export default MyComponent;
```

To use this component, export it as a default object. Next, open the `App.tsx` file in the `src` folder, delete its existing content, and create a new function component named `App`. Inside this component, import the newly created component and use it by including the component’s tag within the `App` function:

```tsx
// App.tsx
import React from 'react';
import MyComponent from './MyComponent';

function App() {
  return (
    <div>
      <MyComponent />
    </div>
  );
}

export default App;
```

Vite automatically monitors any changes made to the project and updates the development server accordingly, as long as the server is active.

JSX simplifies defining dynamic user interfaces by allowing HTML and JavaScript to coexist. It enables developers to insert JavaScript expressions using curly braces `{}` within the JSX code, which makes it easy to create interactive and dynamic content. For example:

```tsx
function DynamicComponent() {
  const message = "Dynamic Content!";
  return <p>{message}</p>;
}
```

#### 1.4 How React Works

In React, the application structure consists of a tree of components, with the `App` component as the root and child components like `MyComponent`. When the application starts, React constructs a JavaScript data structure called the **virtual DOM**, a lightweight in-memory representation of the actual DOM. Each node in this virtual DOM corresponds to a component and its properties.

When a component's state changes, React updates the corresponding node in the virtual DOM and then compares it to the previous version to identify the necessary updates in the real DOM. This process is optimized and managed by another library, `react-dom`, which ensures efficient updates to the actual DOM.

In the `index.html` file, a `<div>` with the ID `root` acts as the container for the entire React application. The `src/main.tsx` file uses `ReactDOM` to render the component tree into this `root` element:

```tsx
// main.tsx
import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';

ReactDOM.render(<App />, document.getElementById('root'));
```

Although `react-dom` is used to render React components in web applications, React can also be rendered on other platforms, such as mobile apps using React Nativ, making it platform-agnostic and suitable for building apps across web, mobile, and desktop environments.

#### 1.5 Difference with Frameworks

Unlike frameworks such as Angular and Vue, which provide a comprehensive set of tools and guidelines for building applications, React is a JavaScript library focused specifically on creating dynamic and interactive user interfaces. A library offers specific functionality, while a framework defines the structure and workflow of an entire application.

While React handles UI components, it doesn't include features like routing, HTTP requests, state management, validation, animations, or internationalization. However, React's flexibility is its strength—developers can choose whichever tools or libraries they prefer for these tasks, as React is unopinionated and allows for customized development solutions.

## 2. Building Components

#### 2.1 Create Styled Components in a React

To create styled components in a React project, follow these steps:

1. **Organize Your Component Files**
   
   By convention, React components are organized inside the `src` folder under a `components` directory. For example:
   
   ```bash
   src/
     components/
       MyComponent.tsx
     App.tsx
   ```

2. **Create a React Component**
   
   In the `components` folder, create a new file named after the component you want to create, e.g., `MyComponent.tsx`. Define the component using a functional component pattern and return the JSX that describes the UI:
   
   ```tsx
   // MyComponent.tsx
   function MyComponent() {
     return (
       <div className="my-component">
         <h1>Welcome to My Component</h1>
       </div>
     );
   }
   
   export default MyComponent;
   ```
   
   **Note:** Use `className` instead of `class` to define CSS classes in JSX, as `class` is a reserved keyword in JavaScript.

3. **Export and Import the Component**
   
   Export your component using a `default` export, then import it inside `App.tsx`. Use it by rendering the component inside the `App` function:
   
   ```tsx
   // App.tsx
   import MyComponent from './components/MyComponent';
   
   function App() {
     return (
       <div>
         <MyComponent />
       </div>
     );
   }
   
   export default App;
   ```

4. **Add CSS Styling**
   
   You can either create your own custom CSS or use a framework like Bootstrap.
   
   - **Creating Custom CSS**
     
     1. Inside the `src` folder, create a `css` directory for your styles:
        
        ```bash
        src/
          css/
            styles.css
        ```
     
     2. In `styles.css`, add your custom styles:
        
        ```css
        .my-component {
          text-align: center;
          color: blue;
        }
        ```
     
     3. Import the CSS file inside `main.tsx` (or `App.tsx`):
        
        ```tsx
        // main.tsx (or App.tsx)
        import './css/styles.css';
        ```
   
   - **Using Bootstrap**
     
     1. Install Bootstrap via npm:
        
        ```bash
        npm install bootstrap
        ```
     
     2. Import Bootstrap’s CSS in `main.tsx` (or `App.tsx`):
        
        ```tsx
        // main.tsx (or App.tsx)
        import 'bootstrap/dist/css/bootstrap.css';
        ```
     
     3. Use Bootstrap classes in your component:
        
        ```tsx
        // MyComponent.tsx
        function MyComponent() {
          return (
            <div className="container">
              <h1 className="text-primary">Welcome to My Component</h1>
            </div>
          );
        }
        ```

5. **Use Bootstrap Documentation**
   
   If using Bootstrap, refer to the [Bootstrap documentation](https://getbootstrap.com/docs/5.3/getting-started/introduction/) for detailed guidelines on how to style your elements using pre-built classes. 

#### 2.2 Fragments

In React, a component cannot return more than one root element, meaning you can't return multiple sibling elements directly from a function. To solve this, you can use React Fragments, which allow you to group multiple elements without adding extra nodes to the DOM. To use fragments, import `Fragment` from React and wrap the JSX code inside it.

```tsx
import React, { Fragment } from 'react';

function MyComponent() {
  return (
    <Fragment>
      <h1>Header</h1>
      <p>This is a paragraph.</p>
    </Fragment>
  );
}

export default MyComponent;
```

Alternatively, a shorter syntax uses empty `<>` and `</>` tags.

```tsx
function MyComponent() {
  return (
    <>
      <h1>Header</h1>
      <p>This is a paragraph.</p>
    </>
  );
}

export default MyComponent;
```

#### 2.3 Inserting JavScript Expressions in React Components

JSX simplifies building dynamic user interfaces by allowing HTML and JavaScript to coexist within React components. Developers can insert JavaScript expressions directly into JSX by using curly braces `{}`, enabling interactive and dynamic content. For example, you can easily display variables or call functions inside JSX:

```tsx
function MyComponent() {
  const name = "Eli";
  return <h1>Hello, {name}!</h1>;
}
```

###### 2.3.1 Adding Key Identifiers

When rendering lists or similar elements, such as tables or forms, React requires a `key` property for each root element. The `key` helps React identify and track changes efficiently, ensuring the DOM updates correctly. Here's an example with a list:

```tsx
function MyListComponent() {
  const items = ['Apple', 'Banana', 'Orange'];
  return (
    <ul>
      {items.map((item, index) => (
        <li key={index}>{item}</li>
      ))}
    </ul>
  );
}
```

The `key` property ensures that React can keep track of individual elements and handle updates efficiently.

#### 2.4 Conditional Rendering

JSX allows the insertion of conditionals within a component to dynamically control which elements are rendered. A common pattern is `{condition && output}`, where the output is displayed only if the condition is true. If the condition is false, the expression returns `null`, meaning nothing is rendered.

```tsx
function MyComponent({ isLoggedIn }) {
  return (
    <div>
      {isLoggedIn && <h1>Welcome back!</h1>}
    </div>
  );
}
```

#### 2.5 Click Events

In React, every root element can have an `onClick` property, allowing you to execute actions when the element is clicked. React provides access to an event object, which is of type `SyntheticBaseEvent`. This event object includes properties like `clientX`, `clientY`, `type`, `target`, and many more, providing information about the click event.

To handle `onClick` events, it's common to define separate handler functions inside the component. These functions typically follow the naming convention of starting with "handle," such as `handleClick`. If you need to access the event object in the function, specify its type as `MouseEvent` from React.

```tsx
import { MouseEvent } from 'react';

function MyComponent() {
  const handleClick = (event: MouseEvent) => {
    console.log(`Button clicked at (${event.clientX}, ${event.clientY})`);
  };

  return (
    <button onClick={handleClick}>
      Click Me
    </button>
  );
}

export default MyComponent;
```

#### 2.6 States

In React, to manage variables that change in response to user actions, such as clicking a button, you can use the `useState` hook. This built-in function, which needs to be imported from React, allows you to define state variables and update them over time. The `useState` hook returns an array with two elements: the current state value and a function to update that state.

Here's how it works:

1. Call `useState` with a default value, and it will return a state variable and an updater function.
2. Use the updater function to modify the state, which will automatically trigger a re-render of the component.
3. The state variable and updater function are typically deconstructed for easier use.

```tsx
import { useState } from 'react';

function Counter() {
  // Initialize the state variable 'count' with a default value of 0
  const [count, setCount] = useState(0);

  // Function to handle the button click and update the state
  const handleClick = () => {
    setCount(count + 1);
  };

  return (
    <div>
      <p>Current count: {count}</p>
      <button onClick={handleClick}>Increment</button>
    </div>
  );
}

export default Counter;
```

#### 2.7 Props

Props are inputs passed to React components, similar to function arguments. They allow data to be passed from a parent component to a child component. To define the structure and types of the props, you can create an interface that describes the shape of the props object. This ensures type safety and clarity.

Once the props are defined, they must be passed to the component when it's called in a parent component like `App`.

```tsx
// Define the props interface
interface MyComponentProps {
  title: string;
  count: number;
}

function MyComponent({ title, count }: MyComponentProps) {
  return (
    <div>
      <h1>{title}</h1>
      <p>Count: {count}</p>
    </div>
  );
};

export default MyComponent;
```

In the parent `App` component, you pass the props:

```tsx
Import MyComponent from './components/MyComponent';

function App() {
  return (
    <div>
      <MyComponent title="My Title" count={10} />
    </div>
  );
}

export default App;
```

Here, the `MyComponent` receives `title` and `count` as props, ensuring that the component behaves dynamically based on the provided data.

#### 2.8 Passing Handler Functions Using Props

In React, when an action, such as selecting an item, occurs in a child component, the parent component should be responsible for defining the logic related to that action. To achieve this, you can pass a handler function from the parent component to the child component via props. This handler function, typically prefixed with "on" (e.g., `onSelection`), allows the child component to notify the parent when the action occurs.

Here's how you can implement this pattern:

1. Define the handler function in the parent component.
2. Pass it as a prop to the child component.
3. Call the handler from the child component when the event occurs.

```tsx
// Define the props interface for the child component
interface ChildProps {
  onSelection: (item: string) => void;
}

const ChildComponent( {onSelection} : ChildProps) {
  const handleSelect = () => {
    onSelection('Selected Item');
  };

  return <button onClick={handleSelect}>Select Item</button>;
};

export default ChildComponent;
```

In the parent `App` component:

```tsx
import ChildComponent from './components/ChildComponent';

function App() {
  const handleSelection = (item: string) => {
    console.log(`Parent received: ${item}`);
  };

  return (
    <div>
      <ChildComponent onSelection={handleSelection} />
    </div>
  );
}

export default App;
```
