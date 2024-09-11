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

#### 1.6 React Developer Tool

React Developer Tools is a useful browser extension for inspecting and analyzing React applications. It adds the Component tool to the browser's development interface. The Components tool displays the hierarchy of React components on the webpage, representing the component tree used by React to create the actual DOM. By selecting a component, you can inspect its props, how it was rendered, and view the source file. Additionally, you can inspect both the rendered HTML elements and the React components themselves, making it easier to debug and analyze your app's structure and behavior.

```jsx
// Example component structure for inspection in React Developer Tools
function App() {
  return (
    <div>
      <Header title="Welcome!" />
      <Content />
    </div>
  );
}
```

#### 1.7 Building and Deploying a React App with Vercel

To build a React application locally, use the command `npm run build`, which compiles your project and outputs the result to the `dist` folder. Any compilation errors must be resolved before the build can succeed. For deployment, Vercel provides an easy-to-use service for hosting static sites. First, install the Vercel CLI with `npm i -g vercel`. After setting up, you can deploy your site by running the `vercel` command in your terminal. Once deployed, link your Vercel account to your GitHub repository, allowing Vercel to automatically pull the latest code, build, and deploy updates from your repository.

```bash
# Build React app locally
npm run build

# Install Vercel CLI globally
npm i -g vercel

# Deploy the React app to Vercel
vercel
```

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

#### 2.9 Passing Child Components

In React, some scenarios require passing child components or JSX elements from a parent component to a child. This can be done using the special `children` prop, which is available in all React components. The `children` prop is of type `ReactNode`, which needs to be imported from React. This allows the parent component to pass JSX elements as children to the child component, where they can be accessed and rendered.

```tsx
import { ReactNode } from 'react';

// Define a component that accepts children
interface ParentProps {
  children: ReactNode;
}

const ParentComponent({childeren}: ParentProps) {
  return <div>{children}</div>;
};

export default ParentComponent;
```

In the parent `App` component, you can pass JSX elements as children:

```tsx
import ParentComponent from './components/ParentComponent';

function App() {
  return (
    <ParentComponent>
      <h1>This is a child component</h1>
      <p>Passed from the parent.</p>
    </ParentComponent>
  );
}

export default App;
```

## 3. Styling Components

#### 3.1 Vanilla CSS

One common approach for styling React components is by using vanilla CSS. This method allows you to apply custom styles to your components easily. To start, create a CSS file in the same directory as your component and name it similarly, but with a `.css` extension. Then, import the CSS file into the component using an `import` statement. You can now write the CSS styles specific to the component in that file, ensuring that your styles are modular and easy to manage.

```tsx
// MyComponent.tsx
import './MyComponent.css';

function MyComponent() {
  return <div className="my-component">Hello, styled component!</div>;
}

export default MyComponent;
```

```css
/* MyComponent.css */
.my-component {
  color: blue;
  font-size: 20px;
}
```

#### 3.2 CSS Modules

When using vanilla CSS in React, you may encounter issues with class name collisions if different files use the same class names. CSS Modules solve this problem by scoping all class names locally to the component, allowing you to reuse class names across files without conflicts. To create a CSS module, simply name the file with the `.module.css` extension. The imported styles from a CSS module are treated as a JavaScript object, allowing you to access class names safely.

Here's how to use CSS modules:

1. Create a CSS module by naming your file `MyComponent.module.css`.
2. Import the module with `import styles from './MyComponent.module.css';`.
3. Use the styles object in your JSX by referencing the class names via the dot notation.

**Note:** Traditionally, CSS class names use hyphens (e.g., `my-class`), but in JavaScript, this isn't a valid property name. If you prefer to keep this naming convention in your CSS Modules, you can access the styles using bracket notation. Alternatively, you can switch to PascalCase for class names, allowing you to use the dot notation, which is more common in JavaScript.

```tsx
// MyComponent.tsx
import styles from './MyComponent.module.css';

function MyComponent() {
  return (
    <div className={styles.container}>
      <p className={styles['container-text']}>This is styled with CSS Modules!</p>
    </div>
  );
}

export default MyComponent;
```

```css
/* MyComponent.module.css */
.container {
  padding: 20px;
  background-color: lightgray;
}

.container-text {
  color: blue;
  font-size: 18px;
}
```

If you need to apply multiple classes to a JSX element, you can combine them using the `join()` method:

```tsx
<div className={[styles.container, styles.active].join(' ')}>
  Multiple classes applied
</div>
```

Using CSS Modules ensures that your styles remain scoped locally, avoiding conflicts with other CSS files.

#### 3.3 CSS-in-JS

CSS-in-JS is an approach where component styles are written directly in the JavaScript or TypeScript file alongside the component definition. This method provides benefits such as scoped styles (avoiding name conflicts), co-locating CSS and JS/TS for easier component management, and the ability to style components based on props or state. Popular libraries like Styled Components support this method.

To use Styled Components, follow these steps:

1. **Install the library** using the command:
   
   ```bash
   npm i styled-components
   ```
   
   For TypeScript projects, install the declaration file:
   
   ```bash
   npm i @types/styled-components
   ```

2. **Import the `styled` function** from the library:
   
   ```tsx
   import styled from 'styled-components';
   ```

3. **Create styled components** by defining variables using the `styled` function, which accesses JSX elements (e.g., `h1`, `p`, `div`) and applies styles using backticks.

```tsx
// MyComponent.tsx
import styled from 'styled-components';

const Heading = styled.h1`
  color: blue;
  font-size: 24px;
`;

const Paragraph = styled.p`
  color: gray;
  line-height: 1.5;
`;

function MyComponent() {
  return (
    <div>
      <Heading>Styled Heading</Heading>
      <Paragraph>This is a paragraph styled with CSS-in-JS.</Paragraph>
    </div>
  );
}

export default MyComponent;
```

This approach allows all styling and component logic to be grouped in a single file. While some argue that CSS-in-JS violates the separation of concerns principle, it actually aligns with the idea of modular design, as it encapsulates styling within the component, hiding complexity behind a clear interface. Separation of concerns doesn't necessarily require placing code in different files but focuses on keeping functionalities distinct and well-organized.

#### 3.4 Using CSS Libraries

Several popular UI libraries make it easier to build visually appealing and modern webpages. 

1. **Bootstrap** is widely used for styling components with its pre-built responsive design elements. 

2. **Material UI** implements Google's Material Design principles, providing a sleek and cohesive look. 

3. **Tailwind CSS** is a utility-first CSS framework, offering small, reusable utility classes that can be applied directly to elements instead of predefined component styles.

4. **Chakra UI** is a component library that simplifies the process of building accessible and customizable UI elements.

#### 3.5 Icon Libraries

To easily add icons to your React project, third-party libraries like **React Icons** offer a wide selection. Start by installing the library with the command:

```bash
npm i react-icons
```

On the [React Icons website](https://react-icons.github.io/react-icons/), you can search for icons. Each icon is identified by a unique code, with the first two letters representing its icon library. To use an icon, copy its identifier and add an import statement in your component file, specifying the correct library.

```tsx
import { FaCoffee } from 'react-icons/fa';  // Fa represents Font Awesome icons

function MyComponent() {
  return <FaCoffee size={30} color="brown" />;
}
```

Once imported, icons can be used and styled as JSX elements within your component functions.

## 4. Managing Component State

#### 4.1 Understanding State Hook

The `useState` hook allows you to add state to functional components in React. State updates in React are asynchronous, meaning changes aren't applied instantly but are batched and processed within a short time for performance optimization. Unlike local variables within functions, which are lost after execution, React stores state outside the component to preserve its value across renders. State hooks must be declared at the top level of a component to maintain a consistent order and avoid errors. This ensures the state remains persistent even after re-renders, with changes applied efficiently.

#### 4.2 Multiple State Structures

When handling multiple related state variables in a React component, you can group them into a single object using the `useState` hook. This allows you to manage related pieces of state together, like an object representing a person. However, it's recommended to keep the object structure flat to avoid complexity in state management.

```tsx
const [person, setPerson] = useState({
  firstName: '',
  lastName: ''
});
```

#### 4.3 Pure Functions

In React, component functions are expected to be pure, meaning they should consistently return the same output (JSX) for the same set of props. This approach optimizes performance, as React can skip re-rendering components whose props haven't changed. To maintain purity, avoid modifying any external objects or state during the render phase. Keep side effects and changes outside of the rendering logic, ensuring that the component function behaves predictably.

#### 4.4 React's StrictMode

React's `StrictMode` is a development tool used to identify potential issues in your application. Typically placed in the `main.tsx` file, wrapping the root `App` component, it has no impact on the actual user interface or functionality. Instead, `StrictMode` renders components twice (in development only) to detect problems like side effects in the render phase. The first render checks for issues, while the second updates the UI. This mechanism helps developers write safer, more efficient code, but has no effect in production environments.

#### 4.5 Updating State Objects

###### 4.5.1 Flat Structure

In React, state objects should be treated as immutable, similar to props. Directly modifying a state object can lead to unexpected behavior. Instead, when updating state, you should create a copy of the existing state, modify the copy, and then update the state with the new object. A common approach is using the spread operator (`...`) to clone the existing state while applying the updates. This ensures React can efficiently detect changes and re-render components as needed.

```tsx
const [person, setPerson] = useState({
  firstName: 'John',
  lastName: 'Doe'
});

// Correct way to update state
const updateLastName = () => {
  setPerson(prevPerson => ({
    ...prevPerson, 
    lastName: 'Smith'
  }));
};
```

###### 4.5.2 Nested Structure

When dealing with nested state objects in React, the spread operator creates a shallow copy, meaning that while the outer object is copied, any nested objects still reference the same memory as the original. This can lead to unintended side effects. To ensure a fully independent copy of the state object, you need to spread each nested object separately.

```tsx
const [user, setUser] = useState({
  name: {
    firstName: 'John',
    lastName: 'Doe',
  },
  address: {
    city: 'New York',
    zip: '10001',
  }
});

// Correct way to update nested state
const updateCity = () => {
  setUser(prevUser => ({
    ...prevUser,
    address: {
      ...prevUser.address,
      city: 'Los Angeles'
    }
  }));
};
```

This approach ensures that each level of the nested structure is updated independently, preventing shared memory references. To simplify state management, prefer flat object structures where possible.

#### 4.5 Updating State Arrays

When updating an array in React state, it’s important to always provide a new array to the state update function. To achieve this, you can use the spread operator to create a new array while copying the existing elements. You can also modify the array using methods like `filter` to remove elements or `map` to update specific items.

```tsx
const [items, setItems] = useState([1, 2, 3, 4]);

// Adding a new element
const addItem = () => {
  setItems(prevItems => [...prevItems, 5]);
};

// Removing an element
const removeItem = (itemToRemove) => {
  setItems(prevItems => prevItems.filter(item => item !== itemToRemove));
};

// Updating an element
const updateItem = (itemToUpdate) => {
  setItems(prevItems => prevItems.map(item => item === itemToUpdate ? item + 1 : item));
};
```

#### 4.6 Sharing State Between React Components

In some scenarios, such as in an online shop where the number of items in a shopping cart must sync with the items in a basket, state needs to be shared between components. To achieve this, the state should be lifted up to a common parent component. For example, the `App` component can manage the state of the item count and pass it down to both `Cart` and `Basket` components via props. This ensures the two components remain in sync with the same state.

## 5. Building Forms

#### 5.1 Handling Form Submissions

In React, you can manage form submissions by utilizing the `onSubmit` attribute of the form element. A form can include various elements like text fields, dropdowns, checkboxes, radio buttons, sliders, and file inputs, with a submit button to trigger submission. By default, submitting a form in HTML reloads the page and posts the data to the server. To prevent this behavior in React, you can use `event.preventDefault()` within the form's `onSubmit` handler. This method stops the default action, allowing you to handle form data directly in JavaScript.

```tsx
function MyForm() {
  const [inputValue, setInputValue] = useState('');

  const handleSubmit = (event: FormEvent) => {
    event.preventDefault();  // Prevents page reload
    console.log('Form submitted with value:', inputValue);
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Name:
        <input
          type="text"
          value={inputValue}
          onChange={(e) => setInputValue(e.target.value)}
        />
      </label>
      <button type="submit">Submit</button>
    </form>
  );
}

export default MyForm;
```

#### 5.2  Accessing Input Fields

The `useRef` hook in React is useful for referencing and interacting with DOM elements, such as input fields. To use `useRef`, first import it from React and initialize it with `null` as its initial value. This hook returns a reference object that can be used to access the DOM element. It is good practice to specify the type of the referenced element, such as `HTMLInputElement`, using TypeScript generics. You associate the reference object with an input field by setting the `ref` attribute on the input field element. You can then access the current value of the input field through the `current` property of the reference object. It's important to check that `current` is not `null` before accessing its properties.

```tsx
import React, { useRef, FormEvent } from 'react';

function MyForm() {
  const inputRef = useRef<HTMLInputElement>(null);  // Reference object

  const handleSubmit = (event: FormEvent) => {
    event.preventDefault();  // Prevents page reload
    if (inputRef.current) {  // Check if the input field is noy null
      console.log('Input field submitted with value:', inputRef.current.value);  // Access the input field value
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Name:
        <input
          type="text"
          ref={inputRef}  // Associate ref with the input element
        />
      </label>
      <button type="submit">Submit</button>
    </form>
  );
}

export default MyForm;
```

#### 5.3 Retrieving Input Change Events

In React, every input field triggers a change event (`onChange`) each time the user types a keystroke. This event can be used to update state variables, ensuring the UI remains in sync with the user's input. To handle this, the `onChange` attribute of the input element should pass the `event` parameter, allowing access to `event.target.value`. This value can then be used to update the corresponding state. For optimal synchronization between the input field and the component state, it's important to set the input's `value` attribute to the state variable.

```tsx
function ControlledInput() {
  const [inputValue, setInputValue] = useState('');

  const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
    setInputValue(event.target.value);
  };

  return (
    <form>
      <label>
        Name:
        <input
          type="text"
          value={inputValue}   // Sync input with state
          onChange={handleInputChange}  // Handle the change event
        />
      </label>
    </form>
  );
}

export default ControlledInput;
```

Keep in mind that handling frequent `onChange` events with each keystroke might affect performance, as compared to using the `useRef` hook, especially for large forms.

#### 5.4 Form Handling with React Hook Form

Managing complex forms with multiple input fields can quickly become tedious in React. React Hook Form simplifies this process by reducing the amount of code needed to handle form inputs. To use this library, you need to install it using the following command:

```bash
npm i react-hook-form
```

Below is a more detailed look at the two key functions, `register` and `handleSubmit`, and how they streamline form handling.

1. **`useForm` Hook**  
   The `useForm` hook is the core of React Hook Form. It returns several methods, two of which are `register` and `handleSubmit` that facilitate managing form inputs.
   
   ```tsx
   import { useForm, FieldValues } from 'react-hook-form';
   
   const { register, handleSubmit } = useForm();
   ```

2. **Define a `DataForm` Interface**  
   To ensure TypeScript understands the structure of your form data, it’s a good practice to define an interface that describes the shape of the form values. This allows React Hook Form to infer the correct types for the form inputs and the data returned by `handleSubmit`.
   
   Here's an example of how to define a `DataForm` interface and pass it as a generic type to the `useForm` hook:
   
   ```tsx
   interface DataForm {
     name: string;
     email: string;
     age: number;
   }
   
   const { register, handleSubmit } = useForm<DataForm>();
   ```
   
   By specifying `<DataForm>`, TypeScript will now infer that the form has a `name`, `email`, and `age` field, making the code more type-safe and easier to manage.

3. **`register` Method**  
   The `register` function is used to "register" form inputs with React Hook Form. It attaches important properties such as `onChange` and `value` to the form elements without you having to manually specify them. To apply it to an input field, use the spread operator `{...register('fieldName')}`.
   
   ```tsx
   <input {...register('name')} />
   <input {...register('email')} />
   <input type="number" {...register('age')} />
   ```
   
   This automatically binds the input field to the form's state, handling both value and change events under the hood. You don't need to write explicit `onChange` handlers or manage the state manually.

4. **`handleSubmit` Method**  
   The `handleSubmit` method wraps around your form's submit event, processing the data before it gets passed to the form submission handler. It ensures that the data passed to the submit handler is properly structured according to the `DataForm` interface.
   
   ```tsx
   const onSubmit = (data: DataForm) => {
     console.log(data); // Process form data
   };
   
   <form onSubmit={handleSubmit(onSubmit)}>
     {/* Form fields */}
   </form>
   ```
   
   The `onSubmit` function now receives `data` of type `DataForm`. React Hook Form handles the validation and state management for you, making form submissions simpler and more reliable.

#### 5.5 Validation with React Hook Form

In React Hook Form, you can easily apply validation rules to form inputs by passing a second argument to the `register` function. This argument is an object that holds standard HTML validation attributes like `required`, `minLength`, and `maxLength`. Additionally, you can handle validation errors using the `formState` object, which contains any errors that occur during validation.

Below is an example of how data validation would be managed with React Hook Form:

1. **Registering Input with Validation**  
   To add validation to an input field, pass an object with validation rules as the second argument to the `register` function:
   
   ```tsx
   <input {...register('name', { required: true, minLength: 2, maxLength: 50 })} />
   ```
   
   This input requires the `name` field to be filled and limits its length to a minimum of 2 and a maximum of 50 characters.

2. **Handling Validation Errors**  
   You can use the `formState.errors` object to handle any validation errors. By deconstructing `formState`, you can access the `errors` property and display appropriate error messages:
   
   ```tsx
   const { register, handleSubmit, formState: { errors } } = useForm();
   ```
   
   You can then check for specific error types in your JSX:
   
   ```tsx
   {errors.name?.type === "required" && <p>Name is required</p>}
   {errors.name?.type === "minLength" && <p>Name must be at least 2 characters</p>}
   {errors.name?.type === "maxLength" && <p>Name can be at lost 50 characters</p>}
   ```

#### 5.6 Schema-Based Validation with Zod

In React Hook Form, validation rules can sometimes clutter the JSX code. To organize validation rules more efficiently, you can use schema-based validation, where all rules are defined in a single place, called a schema. This can be achieved using libraries like Zod.

Below is an example on how the validation rules can be organized in a schema using Zod and integrating it with React Hook Form:

1. **Install Zod**  
   Start by installing Zod with the following command:
   
   ```bash
   npm i zod
   ```

2. **Define a Schema**  
   Import Zod and define a schema using `z.object()`. Each field in the form is represented as a key in the schema, with validation rules chained via Zod's API, like `min()`, `max()`, and more. Here's an example:
   
   ```tsx
   import { z } from 'zod';
   
   const schema = z.object({
     name: z.string().min(2, { message: 'Name must be at least 2 characters' }).max(50),
     email: z.string().email({ message: 'Invalid email address' }),
   });
   ```

3. **Install Zod Resolver**  
   To integrate Zod with React Hook Form, install the Zod resolver:
   
   ```bash
   npm i @hookform/resolvers
   ```

4. **Integrate with React Hook Form**  
   Import the `zodResolver` and pass the schema to the `useForm` hook through the `resolver` property.
   
   ```jsx
   import { useForm } from 'react-hook-form';
   import { zodResolver } from '@hookform/resolvers/zod';
   
   const { register, handleSubmit, formState: { errors } } = useForm({
     resolver: zodResolver(schema)
   });
   ```

5. **Infer the DataForm structure**  
   Use Zod's `infer` utility to automatically derive the type for your form data. This enables React Hook Form to accurately infer the types for the form fields and the data returned by `handleSubmit`.
   
   ```tsx
   type FormData = z.infer<typeof schema>;
   
   const { register, handleSubmit, formState: { errors } } = useForm<FormData>({
     resolver: zodResolver(schema)
   });
   ```

6. **Handling Errors**  
   Zod automatically generates error messages, but you can customize them through the schema. Access the error messages from `formState.errors`.
   
   ```tsx
   <form onSubmit={handleSubmit(onSubmit)}>
     <input {...register('name')} />
     {errors.name && <p>{errors.name.message}</p>}
   
     <input {...register('email')} />
     {errors.email && <p>{errors.email.message}</p>}
   
     <button type="submit">Submit</button>
   </form>
   ```

7. **Custom Error Messages**  
   You can customize messages for specific validation failures, or even provide an error message for invalid types:
   
   ```tsx
   const schema = z.object({
     name: z.string().min(2, { message: 'Name must have at least 2 characters' }),
     email: z.string().email({ invalid_type_error: 'Please enter a valid email' }),
   });
   ```

For a comprehensive overview of Zod and its capabilities, refer to the official documentation at [zod.dev](https://zod.dev/).

#### 5.7 Disabeling Submit Button

The `formState` object, available through destructuring from the `useForm` hook, includes an `isValid` property. This boolean value indicates whether the form passes all validation rules. It is especially useful for enabling or disabling the submit button based on the form's validity. To use it, simply destructure `formState` and access `isValid`.

```tsx
import { useForm } from 'react-hook-form';

function MyForm() {
  const { register, handleSubmit, formState: { isValid, errors } } = useForm({
    mode: 'onChange' // Ensures form validation runs on every change
  });

  const onSubmit = data => {
    console.log(data);
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <input {...register('name', { required: 'Name is required' })} />
      {errors.name && <p>{errors.name.message}</p>}

      <button type="submit" disabled={!isValid}>Submit</button>
    </form>
  );
}
```

## 6. Connecting to the Backend

#### 6.1 Understanding the Effect Hook

React component functions should be pure, meaning they return the same JSX for the same props and avoid changes during rendering. However, some tasks, like accessing local storage, making API calls, or manually modifying DOM elements, are considered side effects since they impact the component beyond rendering. Side effects make a component impure.

To handle side effects in React, the `useEffect` hook is used. It allows you to run specific logic after the component renders. This could include data fetching, DOM manipulation, or updating external resources. To use `useEffect`, import it from React, and place the side-effect logic inside the hook, ensuring it runs after the initial render. Like the state hook, `useEffect` should be called at the top level of the component.

```tsx
useEffect(() => {
  fetch('https://api.example.com/data')
    .then(res => res.json())
    .then(setData)
    .catch(console.error);
});
```

#### 6.2 Effect Hook Dependencies

By default, the `useEffect` hook runs after every component render, but sometimes you need more control over when it executes. To achieve this, the `useEffect` hook accepts a second optional argument—a dependency array. This array holds variables (such as props or state) that determine when the effect should run. If any of these values change, React re-executes the effect. When the dependency array is empty (`[]`), the effect runs only once after the initial render. If the second argument is omitted, the effect will run after every render, which may cause performance issues or excessive API calls.

```tsx
useEffect(() => {
  fetch('https://api.example.com/data')
    .then(res => res.json())
    .then(setData)
    .catch(console.error);
}, []);
```

#### 6.3 Effect Clean Up

The function passed to the `useEffect` hook can optionally return a cleanup function. This cleanup function is useful for undoing side effects, such as unsubscribing from services, canceling API requests, or disconnecting from WebSockets. The cleanup function is called when the component unmounts or before the effect re-runs due to changes in dependencies, ensuring that no side effects persist. See an example of a clean up function in `6.6 Cancelling HTTP Requests.`

#### 6.4 Fetching Data With HTTP Requests

To send requests to a server, you can use a popular library called Axios. Axios simplifies HTTP requests and supports features like automatic JSON parsing and handling responses. First, install Axios with:

```bash
npm i axios
```

In your component, import Axios. To make a server request, such as a `GET` request, place the call inside the `useEffect` hook to ensure it runs after the component renders. Axios’s `get()` method returns a promise, representing the eventual success or failure of the request. You can chain a `.then()` method to handle the response.

```tsx
const [users, setUsers] = useState<User[]>([]);

useEffect(() => {
  axios.get<User[]>('http://...')
    .then((response) => setUsers(response.data));
  }, []);
```

The `axios.get()` method sends an HTTP request from the client (browser) to a server, which responds with the requested resources like webpages, images, or videos, using the HTTP protocol for communication.

#### 6.5 Dynamic Request Configuration

When using Axios as your API client, you can pass an `AxiosRequestConfig` object as an optional parameter to dynamically configure API requests. This object, which is of type `AxiosRequestConfig`, allows you to specify configurations such as query parameters (`params`), headers (`headers`), or any other request settings based on the API provider's requirements. This approach avoids hardcoding these settings in the function itself, enabling more flexible API interactions.

The `requestConfig` object should be of type `AxiosRequestConfig`, allowing dynamic customization of the request.

```typescript
import { AxiosRequestConfig } from 'axios';

// Example API call using AxiosRequestConfig
apiClient.get<GetResponse<T>>(endpoint, { 
  signal: controller.signal, 
  ...requestConfig // Type: AxiosRequestConfig
});
```

This flexibility helps in fetching specific data or applying custom request settings like filtering or authentication headers.

#### 6.6 Handling Errors in HTTP Requests

When making an HTTP request, various issues can occur, such as losing connection to the server. To handle these potential errors, JavaScript promises offer a `catch` method, which can be chained to the `then()` method. The `catch` method accepts a callback function that executes when an error occurs during data fetching. The error object passed to this function contains a `message` property, which can be used to display meaningful error messages.

```javascript
const [users, setUsers] = useState<User[]>([]);
const [error, setError] = useState('');

useEffect(() => {
  axios.get<User[]>('http://...')
    .then((response) => setUsers(response.data))
    .catch((error) => setError(error.message));
  }, []);
```

#### 6.7 Cancelling HTTP Requests

When fetching data in an `effect` hook, it is a good practice to provide a cleanup function to cancel the request in case the component unmounts. To do this, declare a `controller` constant inside the `effect` hook and assign it a new instance of the built-in `AbortController` class, which allows aborting asynchronous operations. Pass the controller's signal to the `axios.get()` method as an optional argument. Finally, return `controller.abort()` in the effect hook for cleanup. Additionally, in the `axios.catch()` method, check if the error is an instance of `CanceledError` from the axios module to handle the request cancellation properly.

```javascript
useEffect(() => {
  const controller = new AbortController();

  axios.get<User[]>('http://...', {signal: controller.signal})
    .then((response) => setUsers(response.data))
    .catch((error) => {
      if (error instanceof CanceledError) return;
      setError(error.message);
    });

    return () => controller.abort();
  }, []);
```

#### 6.8 Displaying a Loading Indicator

To show a loading indicator while fetching data, you can use a state hook to manage the loading state. Set the loading state to `true` before calling `axios.get()`, and update it to `false` inside the callback functions of both `axios.then()` and `axios.catch()`, ensuring the loading state is updated after the request completes. The loading state can then be used to conditionally display a loader in the component.

```javascript
const [loading, setLoading] = useState(false);

useEffect(() => {
  const controller = new AbortController();
  
  setLoading(true);
  axios.get<User[]>('http://...', {signal: controller.signal})
    .then((response) => {
      setUsers(response.data);
      setLoading(false);
    })
    .catch((error) => {
      if (error instanceof CanceledError) return;
      setError(error.message);
      setLoading(false);
    });

    return () => controller.abort();
  }, []);
```

#### 6.9 Handling Data Synchronization in React

###### 6.9.1 Synchronization Approaches

When manipulating server-side data (e.g., deleting, creating, or modifying) and synchronizing it with user actions, you can follow two strategies: optimistic or pessimistic.

- **Optimistic Approach**: The user interface is updated immediately, assuming the server operation will succeed. The changes are sent to the server afterward. This approach makes the UI feel faster and more responsive.

- **Pessimistic Approach**: The UI waits for confirmation from the server before updating. This assumes the server call may fail, delaying the UI update until success is confirmed. While more cautious, this can slow down the user experience.

###### 6.9.2 Axios Synchronization Operations

1. **Deleting Data**: Use `axios.delete()` with the endpoint URL to delete data. Handle potential errors with `catch()`.
   
   ```javascript
   axios.delete('https://api.example.com/items/1')
     .then(() => {
       // Update UI after delete
     })
     .catch(error => {
       console.error('Error deleting item:', error);
     });
   ```

2. **Creating Data**: Use `axios.post()` to create new data. Pass the URL and data object, and handle success or errors with `then()` and `catch()`.
   
   ```javascript
   axios.post('https://api.example.com/items', { name: 'New Item' })
     .then(response => {
       // Update UI with new data
     })
     .catch(error => {
       console.error('Error creating item:', error);
     });
   ```

3. **Modifying Data**: Use `axios.put()` to replace an object or `axios.patch()` to modify specific properties. Handle errors with `catch()`.
   
   ```javascript
   // Replace entire object
   axios.put('https://api.example.com/items/1', { name: 'Updated Item' })
     .then(response => {
       // Update UI after modification
     })
     .catch(error => {
       console.error('Error updating item:', error);
     });
   
   // Modify specific fields
   axios.patch('https://api.example.com/items/1', { name: 'Updated Name' })
     .then(response => {
       // Update UI after partial modification
     })
     .catch(error => {
       console.error('Error patching item:', error);
     });
   ```

#### 6.10 Structuring API Calls in React: Best Practices for Maintainable Code

When integrating a backend with React using HTTP clients, following a few key practices can improve code structure and maintainability.

###### 6.10.1 Extracting Reusable API Clients

Create a dedicated service module to manage HTTP configurations and requests. Typically, a `services` folder is created, where a `api-client.ts` file stores the reusable API client configuration. Using `axios.create()`, you can define a base URL and any necessary headers (such as API keys) that apply to all requests. This API client can be imported into any component that needs to make HTTP requests, allowing for consistency and reusability across the app.

```typescript
import axios from 'axios';

const apiClient = axios.create({
  baseURL: 'https://api.example.com',
  headers: {
    Authorization: 'Bearer API_KEY'
  }
});

export default apiClient;
```

###### 6.10.2 Separation of Concerns

Keep HTTP request logic separate from the components. Instead of cluttering React components with data-fetching logic, move these operations into dedicated services, which can be reused throughout the app. This promotes better modularity and cleaner code, as components remain focused on rendering.

###### 6.10.3 Creating a Generic HTTP Service

Create a generic class that can handle various HTTP operations (GET, POST, PATCH, DELETE) for any endpoint. This class can be extended for specific resources, making it easy to manage different API entities while reducing redundant code.

```typescript
import apiClient from './api-client';

interface Entity {
  id: number;
}

class HttpService {
  endpoint: string;

  constructor(endpoint: string) {
    this.endpoint = endpoint;
  }

  getAll<T>() {
    const controller = new AbortController();
    const request = apiClient.get<T[]>(this.endpoint, { signal: controller.signal });
    return { request, cancel: () => controller.abort() };
  }

  delete(id: number) {
    return apiClient.delete(this.endpoint + '/' + id);
  }

  create<T>(entity: T) {
    return apiClient.post(this.endpoint, entity);
  }

  update<T extends Entity>(entity: T) {
    return apiClient.patch(this.endpoint + '/' + entity.id, entity);
  }
}

const create = (endpoint: string) => new HttpService(endpoint);
export default create;
```

###### 6.10.4 Custom Hooks for Reusability

Encapsulate the logic for synchronizing with the server inside custom hooks, which can be reused throughout the app. A custom hook should start with the `use` prefix and can be stored in a `hooks` folder.

```typescript
import { useEffect, useState } from 'react';
import create from './services/http-service';

function useData(endpoint: string) {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const { request, cancel } = create(endpoint).getAll();
    request.then(response => setData(response.data)).finally(() => setLoading(false));
    return cancel; // cleanup function to abort request
  }, [endpoint]);

  return { data, loading };
}
```
