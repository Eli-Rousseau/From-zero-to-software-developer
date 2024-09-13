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

## 6. Calling Backend Services

#### 6.1 Effect Hook

1. **Basic Purpose of `useEffect`**  
   The `useEffect` hook is used to perform side effects after a React component renders. React components are pure, meaning they should only focus on rendering UI, while side effects involve tasks like updating the DOM or fetching data. In this example, the hook updates the document title after each render:
   
   ```tsx
   useEffect(() => {
     document.title = "Page Loaded";
   });
   ```

2. **Running `useEffect` on Every Render**  
   By default, `useEffect` runs after every component render. This behavior is useful when you want the side effect to occur on each render, regardless of changes in any variables. In the following example, the hook logs a message after each render:
   
   ```tsx
   useEffect(() => {
     console.log("Component rendered");
   });
   ```

3. **Controlling Execution with the Dependency Array**  
   You can control when `useEffect` runs by passing a dependency array as the second argument. This array contains variables that the hook monitors, ensuring that the effect only runs when those values change. If the array is empty, the effect will run only once after the initial render, as seen in this example:
   
   ```tsx
   useEffect(() => {
     console.log("Component mounted");
   }, []);
   ```

4. **Dependency-Based Re-Runs**  
   The `useEffect` hook will re-run only when values in the dependency array change. This allows you to control when an effect is triggered, ensuring it only executes when necessary. In the example below, the effect logs a message only when the `count` state changes:
   
   ```tsx
   useEffect(() => {
     console.log(`Count updated: ${count}`);
   }, [count]);
   ```

5. **Cleanup Function**  
   The function passed to `useEffect` can return a cleanup function to undo or cancel the side effect when the component unmounts or when dependencies change. Cleanup functions help prevent memory leaks and ensure that the side effects do not persist unnecessarily. In this example, an interval is cleared when the component unmounts:
   
   ```tsx
   useEffect(() => {
     const timer = setInterval(() => {
       console.log("Interval running");
     }, 1000);
   
     return () => clearInterval(timer);
   }, []);
   ```

#### 6.2 Fetch and Mutate Data in a Backend Service With Axios

To send requests to a back end service, you can use a popular library called Axios. Start installing Axios with the command:

```bash
npm i axios
```

###### 6.2.1 Fetching Data with Axios

To fetch data from a backend service, the `axios.get()` method is used to send `GET` requests. The query method in axios return a promise, allowing you to chain `.then()` for successful responses and `.catch()` for error handling.

```tsx
import axios from "axios";
import { useState, useEffect } from "react";

// Define a generic interface to represent the data structure from the API response
interface Item {
  id: number;
  name: string;
}

// Declare state variables for storing data and errors
const [data, setData] = useState<Item[]>([]);
const [error, setError] = useState<string>("");

useEffect(() => {
  // Send a GET request using axios to fetch items
  axios
    .get<Item[]>("https://api.example.com/items")
    .then((response) => {
      // If the request is successful, update the state with the fetched data
      setData(response.data);
    })
    .catch((error) => {
      // If there's an error, update the error state with the error message
      setError(error.message);
    });
}, []);
```

###### 6.2.2 Dynamic Request Configuration

Axios allows for dynamic configuration of requests by passing an `AxiosRequestConfig` object. This helps set custom headers, query parameters, or other settings without hardcoding them into the request.

```typescript
import axios, { AxiosRequestConfig } from 'axios';

// Define a generic interface for the expected data structure from the API response
interface Item {
  id: number;
  name: string;
}

// Declare a configuration object using AxiosRequestConfig to allow dynamic request settings
const config: AxiosRequestConfig = {
  // Set custom headers, such as an Authorization token
  headers: {
    'Authorization': 'Bearer token',
  },
  // Define query parameters dynamically
  params: {
    userId: 123,
  },
};

// Send a GET request to fetch items, passing the configuration object
axios.get<Item[]>('https://api.example.com/items', config)
  .then(response => {
    // If the request is successful, log the fetched data to the console
    console.log(response.data);
  })
  .catch((error: Error) => {
    // If there's an error, log the error message to the console
    console.error(error.message);
  });
```

###### 6.2.3 Cleaning Up Requests with AbortController

When making requests within React components, it’s important to clean up requests if the component unmounts before the request completes. This can be done using `AbortController` and passing its signal to Axios.

```javascript
import axios, { CanceledError } from 'axios';
import { useState, useEffect } from 'react';

// Define a generic interface for the expected data structure from the API response
interface Item {
  id: number;
  name: string;
}

// Declare state variables for storing data and errors
const [data, setData] = useState<Item[]>([]);
const [error, setError] = useState<string>("");

useEffect(() => {
  // Create a new AbortController instance to control the request cancellation
  const controller = new AbortController();

  // Send a GET request with the AbortController's signal for potential cancellation
  axios
    .get<Item[]>('https://api.example.com/items', { signal: controller.signal })
    .then(response => {
      // If the request is successful, update the state with the fetched data
      setData(response.data);
    })
    .catch(error => {
      // If the error is due to request cancellation, log a message
      if (error instanceof CanceledError) {
        console.log('Request canceled');
      } else {
        // Otherwise, update the error state with the error message
        setError(error.message);
      }
    });

  // Cleanup function: abort the request if the component unmounts
  return () => controller.abort();
}, []);
```

###### 6.2.4 Displaying Loading Indicators

While waiting for data to load, it’s common to show a loading indicator. This can be achieved by maintaining a loading state, which toggles when the request starts and ends.

```javascript
import axios, { CanceledError } from 'axios';
import { useState, useEffect } from 'react';

// Define a generic interface for the expected data structure from the API response
interface Item {
  id: number;
  name: string;
}

// Declare state variables for storing data, errors, and loading status
const [data, setData] = useState<Item[]>([]);
const [error, setError] = useState<string>("");
const [loading, setLoading] = useState<boolean>(false);

useEffect(() => {
  // Create a new AbortController instance to control the request cancellation
  const controller = new AbortController();

  // Set loading to true before starting the request
  setLoading(true);

  // Send a GET request with the AbortController's signal for potential cancellation
  axios
    .get<Item[]>('https://api.example.com/items', { signal: controller.signal })
    .then(response => {
      // If the request is successful, update the state with the fetched data
      setData(response.data);
      // Set loading to false once data is received
      setLoading(false);
    })
    .catch(error => {
      // If the error is not due to request cancellation, update the error state
      if (error instanceof CanceledError) {
        setError(error.message);
      }
      // Set loading to false regardless of the error type
      setLoading(false);
    });

  // Cleanup function: abort the request if the component unmounts
  return () => controller.abort();
}, []);
```

###### 6.2.5 Mutating Data: Create, Update, and Delete

**Creating Data with `POST`**

To create new data on the server, use `axios.post()` with the URL and the data object.

```javascript
axios.post('https://api.example.com/items', { name: 'New Item' })
  .then(response => {
    console.log('Item created:', response.data);
  })
  .catch(error => {
    console.error('Error creating item:', error.message);
  });
```

**Updating Data with `PUT` or `PATCH`**

To replace an entire object, use `PUT`. To update specific fields, use `PATCH`.

```javascript
// Replace entire object
axios.put('https://api.example.com/items/1', { name: 'Updated Item' })
  .then(response => {
    console.log('Item updated:', response.data);
  })
  .catch(error => {
    console.error('Error updating item:', error.message);
  });

// Modify specific fields
axios.patch('https://api.example.com/items/1', { name: 'Updated Name' })
  .then(response => {
    console.log('Item patched:', response.data);
  })
  .catch(error => {
    console.error('Error patching item:', error.message);
  });
```

**Deleting Data with `DELETE`**

To delete data from the server, use `axios.delete()`.

```javascript
axios.delete('https://api.example.com/items/1')
  .then(() => {
    console.log('Item deleted');
  })
  .catch(error => {
    console.error('Error deleting item:', error.message);
  });
```

#### 6.3 React Query

###### 6.3.1 Introduction to React Query

React Query is a library for fetching, caching, and synchronizing data in React applications. It abstracts away the complexities of managing server state and provides a simpler, more efficient way to handle data-fetching and state management compared to traditional methods like Redux. With built-in features such as caching, automatic refetching, and optimistic updates, React Query can significantly enhance the performance and responsiveness of your application.

###### 6.3.2 Installing and Setting Up React Query

To get started with React Query, you first need to install it:

```bash
npm i @tanstack/react-query
```

Once installed, you need to set up a `QueryClient` and a `QueryClientProvider` to provide React Query's functionality to your entire application. Here’s how you can integrate it into your app:

1. **Create a Query Client**: This client is responsible for managing and caching your queries.
2. **Wrap Your Application**: Use `QueryClientProvider` to make the client available to all components.

Here’s an example of how you set it up:

```tsx
// file: main.tsx
import React from 'react';
import ReactDOM from 'react-dom';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import App from './App';

const queryClient = new QueryClient();

ReactDOM.render(
  <QueryClientProvider client={queryClient}>
    <App />
  </QueryClientProvider>,
  document.getElementById('root')
);
```

###### 6.3.3 Monitoring Queries with React Query DevTools

React Query offers its own DevTools for monitoring and debugging queries. To install, run `npm i @tanstack/react-query-devtools`. In your `main.tsx`, import `ReactQueryDevtools` from `@tanstack/react-query-devtools` and add it to your component tree, typically after the `App` component:

```typescript
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { ReactQueryDevtools } from "@tanstack/react-query-devtools";
import App from "./App";

const queryClient = new QueryClient();

ReactDOM.createRoot(document.getElementById("root") as HTMLElement).render(
  <QueryClientProvider client={queryClient}>
    <App />
    <ReactQueryDevtools initialIsOpen={false} />
  </QueryClientProvider>
);
```

Once the app is running, you’ll see a DevTools tab on the left side of the screen. Clicking it reveals query details, such as the query key, number of active observers, and last update time. You can refetch, invalidate, reset, or remove queries and inspect the associated data. The tool also provides a Query Explorer, showing properties like the cache duration making it easier to monitor the status and behavior of queries in real time.

###### 6.3.4 Fetching Data with React Query and Axios

React Query’s `useQuery` hook is used to fetch data from an API. The hook takes two primary arguments: `queryKey` and `queryFn`.

- **`queryKey`**: A unique identifier for the query that React Query uses to cache and manage the data.
- **`queryFn`**: A function that performs the actual data fetching, typically using Axios.

```tsx
import { useQuery } from "@tanstack/react-query";
import axios from "axios";

// Define the structure of the item to be fetched from the API
interface Item {
  id: number;
  name: string;
}

// Define the structure of the item in the response
interface ResponseItem {
  id: number;
  name: string;
}

// Function to fetch data from the API
const fetchData = () => {
  return axios
    .get<Item[]>("https://api.example.com/data")
    .then((response) => response.data);
};

// Use the useQuery hook to fetch data and manage its state
const { data, error, isLoading } = useQuery<Item, Error, ResponseItem>({
  queryKey: ["data"], // Unique key for the query, used for caching and invalidation
  queryFn: fetchData, // Function that fetches the data
});
```

###### 6.3.5 Handling Errors and Loading States

React Query provides mechanisms to handle errors and loading states effectively.

- **Error Handling**: If the `queryFn` fails, `useQuery` will populate the `error` object. You can use this to display an error message to the user.

- **Loading Indicator**: Use the `isLoading` property to show a loading spinner or message while the data is being fetched.

```tsx
// Deconstruct the returned object for error and loading state management
const { data, error, isLoading } = useQuery<Item, Error, ResponseItem>({
  queryKey: ['data'],
  queryFn: fetchData,
});

if (isLoading) return <div>Loading...</div>;
if (error) return <div>Error: {error.message}</div>;
```

###### 6.3.6 Mutating Data (Create, Update, Delete) with React Query

When managing server-side data (e.g., creating, deleting, or modifying) and synchronizing it with the UI, you can choose between two approaches:

- **Optimistic Approach**: Updates the UI immediately, assuming the server request will succeed. This makes the UI feel faster and more responsive, with server changes processed in the background.

- **Pessimistic Approach**: Waits for server confirmation before updating the UI, which can be slower but ensures data integrity by reflecting only confirmed changes.

Using the optimistic approach with Axios and React Query's `useMutation` hook allows for a more responsive user experience by instantly reflecting changes in the UI while managing server-side updates in the background.

1. **Set Up the Mutation Function**:
   Define the mutation function using Axios for making server requests. This function is passed to `useMutation` to handle data operations.
   
   ```js
   import axios from "axios";
   
   // Function to mutate data on the API
   const createData = (newData: Item) => {
     return axios
       .post("https://api.example.com/data", newData)
       .then((reponse) => reponse.data);
   };
   ```

2. **Configure the Mutation Hook**:
   Use `useMutation` to manage your data operations. Define `onMutate`, `onError`, and `onSuccess` callbacks to handle optimistic updates, errors, and success respectively.
   
   ```tsx
   import { useMutation, useQueryClient } from "@tanstack/react-query";
   import axios from "axios";
   
   // Define the structure of the item to be fetched from the API
   interface Item {
     id: number;
     name: string;
   }
   
   // Define the structure of the item in the response
   interface ResponseItem {
     id: number;
     name
   : string;
   }
   // Define the context of the previously cached data
   interface AddContext {
     previousData: ResponseItem[] | undefined;
   }
   
   // Function to mutate data on the API
   const createData = (newData: Item) => {
     return axios
       .post<ResponseItem>("https://api.example.com/data", newData)
       .then((response) => response.data); // Extract and return the response data
   };
   
   const queryClient = useQueryClient();
   
   // Use the useMutation hook to handle data creation
   const { mutate, isError } = useMutation<ResponseItem, Error, Item, AddContext>({
     mutationFn: createData, // Function to execute the mutation (posting new data)
     onMutate: (newData: Item) => {
       // Store the current data before mutation
       const previousData = queryClient.getQueryData<ResponseItem[]>(["data"]);
   
       // Optimistically update the cache to include the new item
       queryClient.setQueryData<ResponseItem[]>(["data"], (oldData) => [
         ...(oldData || []),
         { id: -1, name: newData.name }, // Use a placeholder item for optimistic UI
       ]);
   
       // Return context with previous data for rollback if needed
       return { previousData };
     },
     onError: (error, newData, context) => {
       if (!context) return;
   
       // Rollback to previous data if an error occurs
       queryClient.setQueryData<ResponseItem[]>(["data"], context.previousData);
     },
     onSuccess: (savedData, newData) => {
       // Update cache with the actual saved data after a successful mutation
       queryClient.setQueryData<ResponseItem[]>(["data"], (cachedData) =>
         cachedData?.map((data) => (data.id === -1 ? savedData : data))
       );
     },
   });
   ```

```
3. **Handle the Mutation in Your UI**:
Trigger the mutation through user actions, like form submissions. The mutation’s `mutate` method is used to initiate the request.

```jsx
const handleSubmit = (data) => {
  mutate(data);
};

return (
  <button onClick={() => handleSubmit({ name: 'New Item' })}>
    Add Item
  </button>
);
```

This structure ensures that your UI reflects changes immediately with optimistic updates, while still handling potential errors gracefully and keeping the data synchronized with the server.

###### 6.3.7 Customizing React Query Default Configurations

React Query allows you to customize the default settings for queries globally or locally with the following configurations.

| **Setting**              | **Default Value**      | **Description**                                                                                                   |
| ------------------------ | ---------------------- | ----------------------------------------------------------------------------------------------------------------- |
| **retry**                | 3                      | Number of times a failed query is retried.                                                                        |
| **cacheTime**            | 5 minutes (300,000 ms) | Time a query stays in the cache after it becomes inactive (no observers).                                         |
| **staleTime**            | 0                      | Time before data is considered stale. Automatically refreshed when the window is refocused or network reconnects. |
| **refetchOnWindowFocus** | true                   | Refetches the query when the window is refocused.                                                                 |
| **refetchOnReconnect**   | true                   | Refetches when the network reconnects.                                                                            |
| **refetchOnMount**       | true                   | Refetches when the component is mounted.                                                                          |

**Global Configuration**:

Set global defaults by configuring the `QueryClient`:

```tsx
const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      staleTime: 10000,  // Time before data is considered stale
      cacheTime: 600000, // Duration for caching inactive queries
      refetchOnWindowFocus: false, // Prevent refetching on window focus
    },
  },
});
```

**Local Configuration**:

You can override these defaults for specific queries by passing configuration options directly to `useQuery`:

```tsx
const { data } = useQuery({
  queryKey: ['data'],
  queryFn: fetchData,
  staleTime: 30000,  // Data is fresh for 30 seconds
  retry: 1,  // Retry once if the query fails
});
```

###### 6.3.8 Pagination with React Query

Pagination allows you to display data in chunks, enhancing performance and user experience. With React Query's `useQuery`, you can handle pagination by tracking the current page and fetching data accordingly. The `queryFn` function retrieves data based on the current page and page size, adjusting the request parameters to fetch the appropriate slice of data. The `keepPreviousData` option ensures a smooth user experience by retaining the previous page’s data while loading new data. Pagination buttons allow users to navigate through pages by updating the `page` state, which triggers data fetching for the new page.

```tsx
// Define the structure of the item to be fetched from the API
interface Item {
  id: number;
  name: string;
}

const [page, setPage] = useState(1);
const pageSize = 10;

const query = {
  page,
  pageSize,
};

const { data, error } = useQuery<Item[], Error>({
  queryKey: ['data', query],  // Include pagination in the queryKey
  queryFn: () => 
    axios.get('https://api.example.com/data', {
      params: {
        _start: (query.page - 1) * query.pageSize,  // Starting position
        _limit: query.pageSize                      // Number of items per page
      }
    }).then(response => response.data),
  keepPreviousData: true  // Prevents jumping inside the page
});

// Example pagination buttons
return (
  <>
    {data?.map(post => (
      <div key={post.id}>{post.title}</div>
    ))}
    <button onClick={() => setPage(page - 1)} disabled={page === 1}>
      Previous
    </button>
    <button onClick={() => setPage(page + 1)}>
      Next
    </button>
  </>
);
```

###### 6.3.9 Infinite Scrolling with React Query

Infinite scrolling dynamically loads more data as the user scrolls or interacts with the page, providing a seamless experience for browsing large datasets. Using React Query’s `useInfiniteQuery`, you can manage this by fetching data in pages and determining when to load additional pages. The `queryFn` function retrieves data with pagination parameters, while `getNextPageParam` calculates the next page to fetch based on the current data. The `fetchNextPage` function triggers the loading of more data, and `isFetchingNextPage` helps to manage loading states. This setup ensures continuous and efficient data loading, enhancing user interaction without manual page navigation.

```tsx
const pageSize = 10;

const query = {
  pageSize,
};

const { data, fetchNextPage, isFetchingNextPage } = useInfiniteQuery({
  queryKey: ['items', query],
  queryFn: ({ pageParam = 1 }) =>
    axios.get(`/api/items`, {
      params: { _start: (pageParam - 1) * pageSize, _limit: pageSize },
    }).then(response => response.data),
  getNextPageParam: (lastPage, allPages) =>
    lastPage.length > 0 ? allPages.length + 1 : undefined,
  keepPreviousData: true,
  initialPageParam: 1,
});
```

The `InfiniteScroll` component from the `react-infinite-scroll-component` library allows developers to easily implement infinite scrolling by automatically loading more data as the user scrolls down the page. It is commonly used in combination with the `useInfiniteQuery` hook from React Query to manage paginated data fetching. This component simplifies the process by handling the logic to detect when the user has scrolled to the bottom of the current list and then triggers the `fetchNextPage` function to load additional data. It also provides a smooth user experience by including a `loader` component while more data is being fetched.

To install the library, run the following command:

```bash
npm i react-infinite-scroll-component
```

Here is an example for implementing the infinite scrolling behaviour:

```tsx
const fetchedItemsCount = data?.pages.reduce((total, page) => total + page.length, 0) || 0;

return (
  <InfiniteScroll
    dataLength={fetchedItemsCount}
    hasMore={!!hasNextPage}
    next={() => fetchNextPage()}
    loader={<Spinner />}
  >
    {data?.pages.map((page, index) => (
      <React.Fragment key={index}>
        {page.map(item => (
          <div key={item.id}>{item.name}</div>
        ))}
      </React.Fragment>
    ))}
  </InfiniteScroll>
);
```

#### 6.4 Separating Query Concerns

In modern React development, applying the principle of separation of concerns is essential for building scalable, maintainable, and testable applications. This approach involves dividing the application into distinct layers—such as API Client, HTTP Services, Custom React Query Hooks, and React Components—each handling specific responsibilities. This separation enhances modularity and clarity, leading to a more organized codebase that simplifies maintenance, reduces duplication, and improves overall scalability.

###### 6.4.1 API Client

The API Client layer is responsible for handling HTTP requests to the backend. It acts as a central service for various HTTP operations (GET, POST, PATCH, DELETE) for any endpoint. By creating a generic service class, you manage different resources efficiently and avoid redundant code.

```typescript
import axios, { AxiosRequestConfig } from 'axios';

// Define a generic API client class
class ApiClient {
  private baseUrl: string;

  constructor(baseUrl: string) {
    this.baseUrl = baseUrl;
  }

  // Method to perform GET requests
  public get<T>(endpoint: string, config?: AxiosRequestConfig): Promise<T> {
    return axios.get<T>(`${this.baseUrl}/${endpoint}`, config).then(response => response.data);
  }

  // Method to perform POST requests
  public post<T>(endpoint: string, data: any, config?: AxiosRequestConfig): Promise<T> {
    return axios.post<T>(`${this.baseUrl}/${endpoint}`, data, config).then(response => response.data);
  }

  // Method to perform PATCH requests
  public patch<T>(endpoint: string, data: any, config?: AxiosRequestConfig): Promise<T> {
    return axios.patch<T>(`${this.baseUrl}/${endpoint}`, data, config).then(response => response.data);
  }

  // Method to perform DELETE requests
  public delete<T>(endpoint: string, config?: AxiosRequestConfig): Promise<T> {
    return axios.delete<T>(`${this.baseUrl}/${endpoint}`, config).then(response => response.data);
  }
}

export default ApiClient;
```

###### 6.4.2 HTTP Services

HTTP Services are instances of the API client dedicated to specific types of objects or resources. These services utilize the generic API client to perform operations on specific endpoints, providing a higher level of abstraction.

```typescript
// Define a service for handling item-specific requests
class ItemService extends ApiClient {
  constructor() {
    super('https://api.example.com/items');
  }

  // Method to fetch a single item
  public fetchItem(id: number): Promise<Item> {
    return this.get<Item>(`${id}`);
  }

  // Method to create a new item
  public createItem(data: Item): Promise<Item> {
    return this.post<Item>('', data);
  }

  // Method to update an existing item
  public updateItem(id: number, data: Partial<Item>): Promise<Item> {
    return this.patch<Item>(`${id}`, data);
  }

  // Method to delete an item
  public deleteItem(id: number): Promise<void> {
    return this.delete<void>(`${id}`);
  }
}

export default ItemService;
```

###### 6.4.3 Custom React Query Hooks

Custom React Query hooks are responsible for managing data fetching and caching. They use the HTTP services to perform operations and encapsulate API interactions and state management. Custom hooks should start with the `use` prefix, such as `useFetchData` or `useCreateItem`. This approach abstracts data fetching complexities away from UI components, promoting reuse and reducing redundancy.

```typescript
import { useQuery, useMutation } from '@tanstack/react-query';
import ItemService from './ItemService';

// Define a custom hook for fetching items
export const useFetchItems = () => {
  return useQuery(['items'], () => ItemService.fetchItem(1)); // Example for fetching item with id 1
};

// Define a custom hook for creating items
export const useCreateItem = () => {
  return useMutation((newItem: Item) => ItemService.createItem(newItem));
};

// Define a custom hook for updating items
export const useUpdateItem = () => {
  return useMutation(({ id, data }: { id: number; data: Partial<Item> }) => ItemService.updateItem(id, data));
};

// Define a custom hook for deleting items
export const useDeleteItem = () => {
  return useMutation((id: number) => ItemService.deleteItem(id));
};
```

###### 6.4.4 React Components

At the top layer are the React components, which use the custom hooks to fetch and update data. Components are focused on rendering the UI and handling user interactions, leveraging the hooks to manage data interactions.

```tsx
import React from 'react';
import { useFetchItems, useCreateItem, useUpdateItem, useDeleteItem } from './hooks';

const MyComponent = () => {
  const { data: items, isLoading, error } = useFetchItems();
  const createItem = useCreateItem();
  const updateItem = useUpdateItem();
  const deleteItem = useDeleteItem();

  // Implement the JSX for the React component
};

export default MyComponent;
```

## 8. Global State Management

#### 8.1 Reducers

#### 8.2 Context

#### 8.3 Providers

#### 8.4 Zustand

## 9. Routing
