# Next.js

## 1. Fundamentals of Next.js

#### 1.1 What is Next.js

Next.js is a comprehensive framework built on top of React that simplifies the development of fast, search-engine-friendly web applications. While React is a library for building dynamic UIs, Next.js provides a complete solution by including routing, server-side rendering, and static site generation, among other features. 

Next.js includes its own routing system, eliminating the need for external libraries like React Router. It also comes with a built-in compiler to transform and optimize JavaScript code, a command-line interface for managing projects, and a Node.js runtime to support full-stack development. This allows developers to write both front-end and back-end code within a single project, with back-end code running on the Node.js server and front-end code running in the browser.

One of Next.js's key features is server-side rendering, which enables rendering React components on the server, improving performance and SEO. Another key feature is static site generation, where certain pages or components are pre-rendered during the build process to serve content instantly, further speeding up applications. These features make Next.js an ideal choice for building fast, scalable, and SEO-friendly applications.

#### 1.2 Creating a Next.js project

To start a Next.js project, you'll need to install **Node.js** and a code editor like **Visual Studio Code (VS Code)**. In VS Code, certain extensions can improve the development experience:

- **ES7 React/Redux/React-Native snippets**: Generates React components quickly.
- **JavaScript and TypeScript Nightly**: Provides nightly builds of TypeScript for IntelliSense.
- **Tailwind CSS IntelliSense**: Offers autocomplete, syntax highlighting, and linting for Tailwind CSS.

Once these tools are set up, follow these steps to create a Next.js project:

1. Open a terminal and run the following command to generate a new Next.js project:

```bash
npx create-next-app@latest
```

2. During setup, you’ll be asked about project details, such as:
   
   - Project name
   - Whether to use **TypeScript** and **Tailwind CSS**
   - Whether to use the **src directory** (it's recommended to skip this for basic Next.js projects)
   - Whether to use the **App Router** for routing

3. Once dependencies are installed, navigate to the project folder and start the development server:

```bash
cd your-project-name
npm run dev
```

#### 1.3 Project Structure in Next.js

After creating the project, several key files and folders are generated:

- **App Router (`app/`)**: This folder acts as the routing system for your project, replacing the need for external routing libraries like React Router. It typically includes:
  
  - `layout.tsx`: Defines a layout that wraps around all pages.
  - `page.tsx`: Represents the home page of the application.
  - `global.css`: Global styles for the application.
  - `favicon.ico`: Default icon for the project.

- **Public Folder (`public/`)**: Stores public assets like images, accessible by the browser.

- **Configuration Files** (found in the root of the project):
  
  - `.eslintrc.js`: Configuration for ESLint, used for linting JavaScript/TypeScript.
  - `next.config.js`: Next.js configuration file.
  - `postcss.config.js`: Configuration for PostCSS.
  - `tailwind.config.js`: Tailwind CSS configuration.

By running the development server (`npm run dev`), you can view your Next.js project at `http://localhost:3000`. This basic setup provides everything needed to start building a fast, scalable web application.

#### 1.4 Routing in Next.js

In Next.js, routing is managed based on the file system. To define a route like `/users`, you create a folder named `users` in the `app` directory and add a `page.tsx` file inside. This `page.tsx` file must export a React component, which will be rendered when a user visits `/users`. Importantly, only the `page.tsx` file in a folder is publicly accessible, and other files in that folder won’t be served directly. You can also create nested folders and add a corresponding `page.tsx` file to define additional routes.

For optimal navigation between pages, Next.js provides a `Link` component, which prevents the browser from reloading all resources on every page change. This is more efficient than using standard anchor tags (`<a>`), which cause full page reloads.

```tsx
// Example: app/users/page.tsx
import React from 'react';

const UsersPage = () => {
  return <h1>Welcome to the Users Page</h1>;
};

export default UsersPage;
```

```tsx
// Example: Using Next.js Link for navigation
import Link from 'next/link';

const HomePage = () => {
  return (
    <div>
      <h1>Home Page</h1>
      <Link href="/users">Go to Users</Link>
    </div>
  );
};

export default HomePage;
```

#### 1.5 Client and Server Components

In Next.js, components can be rendered either on the client or on the server side:

- Client-Side Rendering (*CSR*) ensures that all components are bundled and sent to the client, which can lead to larger bundles and higher memory usage as the app grows. Additionally, search engine bots struggle to index content rendered with CSR because they can't execute JavaScript, and sensitive data may be exposed to the client.

- Server-Side Rendering (*SSR*) addresses these issues by rendering content on the server and sending only the necessary HTML to the client. This reduces the memory load on the client and ensures that search engine bots can index the content. Sensitive data also remains on the server. However, SSR limits interactivity—server-side components cannot access browser APIs, manage state, or respond to browser events.

In real-world applications, a combination of SSR and CSR is often used. In Next.js, components in the `app` directory are server-side by default, but you can mark specific components for client-side rendering using the `"use client"` directive at the top of the file. This allows Next.js to include the component in the client-side bundle and ensures any dependencies are also client-rendered.

```tsx
// Example: Client-side component
'use client'; // Enables client-side rendering

import { useState } from 'react';

const ClientComponent = () => {
  const [count, setCount] = useState(0);

  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>Increment</button>
    </div>
  );
};

export default ClientComponent;
```

By rendering most components on the server and opting for client-side rendering only when necessary, applications can maintain speed, SEO-friendliness, and interactivity.

#### 1.6 Data Fetching

In Next.js, data can be fetched either on the client or the server. For client-side data fetching, the `useState` hook is used to declare a state variable, and the `useEffect` hook to fetch data from the backend and store it in that state. Tools like React Query help manage this process by adding caching and state management capabilities. However, client-side fetching leads to issues such as larger bundles, higher memory usage, data being hidden from search engines, and potential security concerns. It also requires an additional round trip to the backend after the initial page load.

To overcome these limitations, it's often better to fetch data server-side in server components. Therefore, whenever possible, data fetching should be done on the server side.

```tsx
// Example: Client-side data fetching
import { useState, useEffect } from 'react';

const ClientDataComponent = () => {
  const [data, setData] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      const response = await fetch('/api/data');
      const result = await response.json();
      setData(result);
    };
    fetchData();
  }, []);

  return <div>{data ? <p>Data: {data}</p> : <p>Loading...</p>}</div>;
};

export default ClientDataComponent;
```

```tsx
// Example: Server-side data fetching (recommended)
export default async function ServerDataComponent() {
  const response = await fetch('https://api.example.com/data');
  const data = await response.json();

  return <div>Data: {data}</div>;
}
```

#### 1.7 Caching

Server-side data fetching in Next.js offers an additional advantage: built-in caching. Data can be retrieved from three sources—memory, the file system, and the network—listed in decreasing order of speed. Next.js uses a file-system-based cache to store fetched data automatically, optimizing performance. 

To configure caching behavior, you can pass a second parameter to the `fetch` function. The `cache` property can be set to `'no-store'` to disable caching, while the `next` property with a `revalidate` option allows the data to be re-fetched at specified intervals. Note that Next.js caching is only available when using the `fetch` method, and doesn't apply to third-party libraries like Axios.

```tsx
// Example: Fetching with cache configuration
export default async function ServerComponent() {
  const response = await fetch('https://api.example.com/data', {
    cache: 'no-store', // Disable caching
  });
  const data = await response.json();

  return <div>Data: {data}</div>;
}
```

```tsx
// Example: Fetching with revalidation
export default async function ServerComponent() {
  const response = await fetch('https://api.example.com/data', {
    next: { revalidate: 60 }, // Revalidate data every 60 seconds
  });
  const data = await response.json();

  return <div>Data: {data}</div>;
}
```

By leveraging Next.js's built-in caching, you can optimize data fetching performance while maintaining control over how often the data is refreshed.

#### 1.8 Static and Dynamic Rendering

Next.js supports **static rendering**, where components or pages with static data are pre-rendered at build time. During the production build, Next.js generates the HTML for these components once, and subsequently, whenever the component is needed, its content is retrieved from the cache (file-system-based), eliminating the need to re-render it.

In contrast, **dynamic rendering** happens at request time, ensuring that components are rendered with up-to-date data. This distinction is crucial when fetching data from a backend. If caching is enabled during static rendering, the data fetched at build time will be treated as static, meaning it won't change until the next build, which is ideal for content that doesn't need frequent updates. When deciding between static and dynamic rendering in Next.js, it's essential to consider your use case. If you prefer to dynamically render fetched data, you must disable caching to ensure fresh data is retrieved on each request (see above)

## 2. Styling

#### 2.1 Global Styles

In the `app` folder of a Next.js project, the `global.css` file contains styles that apply globally across the entire application. At the top of this file, you'll find three directives importing base styles from **Tailwind CSS**. The global stylesheet typically includes:

1. A `:root` selector, where custom CSS properties (variables) are defined.
2. A media query for dark mode, which adjusts the custom properties in the `:root` for dark theme settings.
3. A `body` selector for applying global styles to the application.

The `global.css` should only be used for truly global styles to prevent the file from becoming bloated and hard to maintain. Avoid styling individual classes directly here; instead, use component-level styles for that purpose. By keeping `global.css` focused on universal styles, you can maintain a clean, scalable stylesheet without overwhelming the project with unnecessary complexity.

#### 2.2 CSS Modules

CSS Modules in Next.js provide a way to scope CSS styles to specific components or pages, helping to prevent style clashes across the application. To create a CSS module, name the file after the component it styles and add the `.module.css` suffix. Within this module, define the classes specific to the component.

In the component file, import the CSS module as `styles`, and apply the styles by setting the `className` of JSX elements to the corresponding class names from the module. 

**Note:** CSS class names traditionally use hyphens (e.g., `my-class`), but in JavaScript, hyphenated names aren't valid property names. To maintain this convention, use bracket notation (`styles['my-class']`). Alternatively, switch to PascalCase class names, allowing you to use dot notation (`styles.MyClass`).

```css
/* Example: Button.module.css */
.button {
  background-color: #3490dc;
  color: white;
  padding: 10px;
  border-radius: 5px;
}
```

```jsx
// Example: Button.tsx
import styles from './Button.module.css';

const Button = () => {
  return <button className={styles.button}>Click me</button>;
};

export default Button;
```

By using CSS Modules, styles remain scoped to individual components, making your styles more maintainable and preventing unintended style conflicts.

#### 2.3 Tailwind CSS

Tailwind CSS is a popular utility-first CSS framework that allows developers to style applications using pre-defined utility classes. In a Next.js project, Tailwind can be easily integrated during the initial configuration. Once set up, Tailwind classes are available for use by applying them to the `className` attribute of JSX elements.

One of the key benefits of Tailwind is that during the build process, it automatically removes any unused styles, ensuring the final CSS bundle only contains the utility classes actually used in the markup. This results in optimized and lightweight CSS files.

```tsx
// Example: Button component with Tailwind
const Button = () => {
  return (
    <button className="bg-blue-500 text-white py-2 px-4 rounded">
      Click me
    </button>
  );
};

export default Button;
```

This approach provides a highly efficient and maintainable way to style applications, as Tailwind handles both utility-based styling and the removal of unused CSS.

#### 2.4 Daisy UI

**daisyUI** is a popular component library built on top of Tailwind CSS that provides pre-styled, ready-to-use components. To integrate daisyUI into your Next.js project, start by installing the package using the command:

```bash
npm install -D daisyui@latest
```

Next, add daisyUI to your `tailwind.config.js` file to enable its components:

```js
// tailwind.config.js
module.exports = {
  //...
  plugins: [require('daisyui')],
};
```

Once installed, you can refer to the [daisyUI documentation](https://daisyui.com/) to discover the available utility classes and components for styling your elements.

daisyUI also supports **themes** for easy color customization. To use a theme, configure it in your `tailwind.config.js` file:

```js
// tailwind.config.js
module.exports = {
  //...
  daisyui: {
    themes: ['light', 'dark', 'cupcake'], // Add theme names here
  },
};
```

In your root `layout.tsx` file, activate a theme by setting the `data-theme` attribute on the `<html>` tag:

```tsx
// layout.tsx
export default function RootLayout({ children }) {
  return (
    <html data-theme="cupcake">
      <body>{children}</body>
    </html>
  );
}
```

By integrating daisyUI, you can quickly style your application using its pre-built components, and easily switch between different themes for color customization.

## 3. Routing and Navigation

#### 3.1 File-System Based Routing

Next.js uses a built-in routing system that is based on the file system. In the `app` folder, you create folders that represent segments of the application. To make a route publicly accessible, each segment folder must contain a `page.tsx` file, which serves as the entry point for that route. This `page.tsx` file must export a React component, which will be rendered when a user visits the route location. Other files in the folder will not be directly accessible. This approach to routing keeps components and related files organized by co-locating them within the same folder rather than scattering them in a global `components` directory.

#### 3.2 Creating Dynamic Routes

In Next.js, dynamic routes allow you to create routes with parameters. To set up a dynamic route, create a folder with a name inside square brackets, representing the route parameter (e.g., `[id]`). Inside this folder, create the `page.tsx` file.

To access the route parameter, define a `Props` interface that includes a `params` property, which holds an object containing the route parameters. The component can then use these `params` to render dynamic content based on the route.

```tsx
// Example: /app/[id]/page.tsx
interface Props {
  params: {
    id: string;
  };
}

const DynamicPage = ({ params }: Props) => {
  return <div>Dynamic Route ID: {params.id}</div>;
};

export default DynamicPage;
```

In this example, visiting `/app/123` would display "Dynamic Route ID: 123". This approach allows you to easily create routes with dynamic segments in Next.js.

#### 3.3 Multiple Route Parameters

In Next.js, you can handle routes with a varying number of parameters using a catch-all route. To do this, create a folder with a name inside square brackets, prefixed by three dots (e.g., `[...id]`). This allows for multiple parameters within a single route. If the parameters should be optional, wrap the name in double square brackets (e.g., `[[...id]]`).

To access these parameters, define a `Props` interface that includes a `params` property, which is now an array of strings. The component can then use this array to handle dynamic content based on the number of route segments.

```tsx
// Example: /app/[...id]/page.tsx
interface Props {
  params: {
    id: string[];
  };
}

const CatchAllRoute = ({ params }: Props) => {
  return <div>Route Parameters: {params.id.join(', ')}</div>;
};

export default CatchAllRoute;
```

In this example, visiting `/app/123/456` would display "Route Parameters: 123, 456". By using this approach, you can handle dynamic routes with multiple or optional parameters in a flexible way.

#### 3.4 Accessing Query String Parameters in Next.js

In Next.js, you can access query string parameters by defining a `Props` interface that includes a `searchParams` property, which stores an object containing the query parameters. These parameters can then be used to render dynamic content based on the query values.

To navigate to a route with query parameters, use the `Link` component, setting the `href` to a URL with query strings (e.g., `/list?query=value`). Unlike standard React applications that use client-side state, this approach leverages server-side handling of query parameters, allowing state to be passed and managed on the server.

```tsx
// Example: /app/list/page.tsx
interface Props {
  searchParams: {
    query?: string;
  };
}

const ListPage = ({ searchParams }: Props) => {
  return <div>Search Query: {searchParams.query}</div>;
};

export default ListPage;
```

```tsx
// Example of linking to the route with query params
import Link from 'next/link';

const HomePage = () => {
  return <Link href="/app/list?query=example">Go to List with Query</Link>;
};

export default HomePage;
```

This approach allows for handling query string parameters on the server, offering more flexibility compared to client-side state management.

#### 3.5 Layouts

In Next.js, `layout.tsx` files are special files recognized by the router system to define shared UI elements across multiple pages. The root `layout.tsx` file provides a common layout for the entire application. However, to create a custom layout for a specific route, you can add a `layout.tsx` file inside the corresponding route folder. 

Each `layout.tsx` file should export a React component that includes `children` of type `ReactNode`, allowing you to define shared UI elements for all pages within that route.

```tsx
// Example: /app/dashboard/layout.tsx
import { ReactNode } from 'react';

interface LayoutProps {
  children: ReactNode;
}

const DashboardLayout = ({ children }: LayoutProps) => {
  return (
    <div>
      <nav>Dashboard Navigation</nav>
      <main>{children}</main>
    </div>
  );
};

export default DashboardLayout;
```

In this example, the `DashboardLayout` component provides a custom layout with navigation that will be applied to all pages within the `/dashboard` route. By utilizing custom layouts, you can create consistent UI structures across different sections of your Next.js app.

#### 3.6 Page Navigation

Next.js enhances navigation performance using the `Link` component, which prevents full page reloads during navigation. Instead of reloading all resources, `Link` only fetches the content of the target page. It also pre-fetches links visible in the viewport to improve performance and caches pages on the client. This means that if a page is visited multiple times, it is retrieved from the client cache rather than making repeated requests to the backend.

```tsx
// Example: Using the Link component for navigation
import Link from 'next/link';

const Navigation = () => {
  return (
    <nav>
      <Link href="/about">About</Link>
      <Link href="/contact">Contact</Link>
    </nav>
  );
};

export default Navigation;
```

By leveraging the `Link` component, Next.js ensures smoother and faster page transitions, enhancing the overall user experience.

#### 3.7 Programmatic Navigation

In Next.js, programmatic navigation allows you to redirect users to a new page in response to actions like clicking a button or submitting a form. To achieve this, convert the component into a client component by including event handlers like `onClick` or `onSubmit`. Use the `useRouter` hook from `next/navigation` inside the event handler to perform the navigation. The hook returns a `router` object, and you can use the `push()` method to navigate to the target page.

```tsx
"use client"; // Convert to a client component

import { useRouter } from 'next/navigation';

const NavigateButton = () => {
  const router = useRouter();

  const handleClick = () => {
    router.push('/target-page'); // Navigate to target page
  };

  return <button onClick={handleClick}>Go to Target Page</button>;
};

export default NavigateButton;
```

#### 3.8 Showing Loading States

React 18 introduces the `Suspense` feature, which allows you to display a fallback UI while a component is being rendered. You can wrap a component inside a `Suspense` component and specify a `fallback` prop that determines what to display during the loading phase. This approach supports streaming, where the initial UI is shown to the client while waiting for additional data without terminating the request-response lifecycle.

```tsx
// Using Suspense in React 18
import React, { Suspense } from 'react';

const LazyComponent = React.lazy(() => import('./LazyComponent'));

const MyComponent = () => (
  <Suspense fallback={<div>Loading...</div>}>
    <LazyComponent />
  </Suspense>
);

export default MyComponent;
```

In Next.js, you can also achieve a similar behavior by including a `loading.tsx` file inside a route folder. This file is recognized by Next.js and automatically displays the loading component when a page is being rendered.

```tsx
// Example of loading.tsx in Next.js
const Loading = () => <div>Loading page...</div>;

export default Loading;
```

#### 3.9 Error and Not-Found Pages

Next.js provides default error pages, but you can customize them to improve the user experience. To handle missing pages, create a `not-found.tsx` file in the `app` folder. This file is recognized by Next.js and will display a custom "not found" page when a user navigates to a non-existent route. You can also create a separate `not-found.tsx` file inside specific route folders to tailor the error page for particular routes. Additionally, you can programmatically trigger the `notFound()` function to display this page when a condition is not met in your code.

```tsx
// Example: Custom Not Found Page (not-found.tsx)
const NotFound = () => (
  <div>
    <h1>404 - Page Not Found</h1>
    <p>Sorry, the page you are looking for does not exist.</p>
  </div>
);

export default NotFound;
```

For runtime errors that occur during rendering, Next.js shows a default error page in production mode. You can override this behavior by creating an `error.tsx` file in the `app` folder. This component handles runtime errors, and you can log errors using services like Sentry or provide users with a "Retry" option using the `reset` function. Each route can also have its own `error.tsx` for more granular control.

```tsx
// Example: Custom Error Page (error.tsx)
"use client"; // Ensure this runs on the client side

interface ErrorPageProps {
  error: Error;
  reset: () => void;
}

const ErrorPage = ({ error, reset }: ErrorPageProps) => (
  <div>
    <h1>Application Error</h1>
    <p>{error.message}</p>
    <button onClick={reset}>Retry</button>
  </div>
);

export default ErrorPage;
```

## 4. Building APIs

#### 4.1 Creating API Routes

###### 4.1.1 API Routes for Multiple Objects

In Next.js, you can create API routes within the `app` folder by adding an `api` directory. Inside this directory, create a `route.tsx` file, which is recognized by the Next.js routing system for handling HTTP requests. Note that when you define a `route.tsx` file, you cannot have a `page.tsx` file in the same folder.

To create an API route that handles `GET` requests and returns a collection of objects, export a `GET` function from `route.tsx`. This function takes a `NextRequest` object as input and responds with `NextResponse.json()`, where you can return an array of objects in JSON format. This approach allows you to set up API endpoints that can be used to fetch data, such as a list of objects.

```tsx
// Example: api/route.tsx
import { NextResponse } from "next/server";

export async function GET(request: Request) {
  const data = [
    { id: 1, name: "Object 1" },
    { id: 2, name: "Object 2" },
    { id: 3, name: "Object 3" },
  ];

  return NextResponse.json(data);
}
```

###### 4.1.2 API Routes for Single Objects

To create an API endpoint for fetching a single object by its `id`, you need to set up a dynamic route. Inside the `api` folder, create a subfolder named `[id]` to represent the dynamic part of the route. Inside this folder, create a `route.tsx` file, which will handle the request for fetching a specific object.

In the `route.tsx` file, export a `GET` function that accepts two parameters: the `request` (of type `NextRequest`) and `params` (from the route, holding the `id`). The `GET` function should return a single object using `NextResponse.json()`.

```tsx
// api/[id]/route.tsx
import { NextResponse } from "next/server";

interface Props {
  params: { id: string };
}

export async function GET(request: Request, { params }: Props) {
  const { id } = params;

  // Example data fetching
  const data = { id, name: `Object ${id}` };

  return NextResponse.json(data);
}
```

#### 4.2 Create an Object

To handle POST requests and create an object in Next.js, you need to define a `POST` function in the `route.tsx` file. This function is asynchronous and accepts a `request` parameter of type `NextRequest`. 

First, read the body of the request using `request.json()`, which returns a promise, so you need to `await` the response. Once the data is received, you can validate the object. If the data is valid, return it using `NextResponse.json()`. If the validation fails, return an appropriate error response.

```tsx
// api/route.tsx
import { NextResponse } from 'next/server';

export async function POST(request: Request) {
  const data = await request.json();

  // Example validation (ensure 'name' property exists)
  if (!data.name) {
    return NextResponse.json(
      { error: 'Invalid data: Name is required' },
      { status: 400 }
    );
  }

  // Return the created object as a response
  return NextResponse.json({ message: 'Object created', data });
}
```

#### 4.3 Updating an Object

To update an object, you can either use the `PUT` or `PATCH` HTTP methods. In the `route.tsx` file at a dynamic route location (e.g., `/api/[id]`), export a function named `PUT` or `PATCH`, depending on whether you want to fully replace the object (`PUT`) or partially update some of its properties (`PATCH`).

The function will receive the request (`NextRequest`) and the route parameters (e.g., `id`). First, validate the request body, returning a 400 error if invalid. Then, fetch the object (e.g., a user) by its ID. If the object doesn’t exist, return a 404 error. Otherwise, update the object and return the updated data.

```tsx
// api/[id]/route.tsx
import { NextResponse } from 'next/server';

export async function PATCH(request: Request, { params }: { params: { id: string } }) {
  const data = await request.json();

  // Example validation (ensure 'name' is provided)
  if (!data.name) {
    return NextResponse.json(
      { error: 'Invalid data: Name is required' },
      { status: 400 }
    );
  }

    // Fetch and update user logic here (e.g., check if user exists)
    const user = await findUserById(params.id); // Fetch user logic
    if (!user) {
      return NextResponse.json(
        { error: 'User not found' },
        { status: 404 }
      );
    }

    // Update user logic (e.g., update properties)
    const updatedUser = { ...user, ...data }; // Simulate update

    return NextResponse.json({ message: 'User updated', updatedUser });
}
```

#### 4.4 Deleting an Object

To delete an object, such as a user, create and export a `DELETE` request in the `route.tsx` file located at a dynamic route (e.g., `/api/[id]`). The `DELETE` function receives a `NextRequest` and route parameters, like `id`. First, fetch the object from the backend. If it doesn't exist, return a 404 error. If found, delete the object and return a 200 success response indicating the deletion was successful.

```tsx
// api/[id]/route.tsx
import { NextResponse } from 'next/server';

export async function DELETE(request: Request, { params }: { params: { id: string } }) {
  // Fetch the user by ID
  const user = await findUserById(params.id); // Replace with actual fetch logic

  // If the user doesn't exist, return 404
  if (!user) {
    return NextResponse.json(
      { error: 'User not found' },
      { status: 404 }
    );
  }

  // Delete the user
  await deleteUser(params.id); // Replace with actual deletion logic

  return NextResponse.json({ message: 'User deleted successfully' }, { status: 200 });
}
```

#### 4.5 Validating API Requests with Zod

When validating API request bodies, using a library like Zod can simplify the process. To get started, install Zod with `npm i zod`. In your `api` folder, create a `schema.ts` file where you can define and export the validation schema.

Import Zod using `import { z } from 'zod'`. Define the schema by calling `z.object()` and passing in the expected structure of the request object. You can chain validation methods like `min()` or `max()` to enforce rules. Export the schema from the module.

```ts
// schema.ts
import { z } from 'zod';

const userSchema = z.object({
  name: z.string().min(2, "Name must be at least 2 characters"),
  email: z.string().email("Invalid email address"),
  age: z.number().min(18, "Must be at least 18 years old")
});

export default userSchema;
```

In the `route.tsx` file, import the schema and validate the incoming request data by calling `safeParse()`. This method returns a result that indicates success or failure. If the validation fails, use `result.error.errors` to access detailed error messages.

```ts
// api/route.tsx
import { NextResponse } from 'next/server';
import userSchema from './schema';

export async function POST(request: Request) {
  const body = await request.json();

  const result = userSchema.safeParse(body);

  if (!result.success) {
    return NextResponse.json(
      ,
      { status: 400 }
    );
  }

  // Proceed with creating the user if validation is successful
  return NextResponse.json({ message: "User created successfully" });
}
```

## 5. Database Integration With Prisma

#### 5.1 Setting Up MySQL With Prisma in a Next.js Project

To begin working with MySQL in a Next.js project, start by installing MySQL Community Server and setting it up using the installation wizard. Additionally, you can install MySQL Workbench, a graphical tool for managing MySQL databases.

For database interactions, Prisma is a popular Object-Relational Mapper (ORM) that simplifies database operations like querying, creating, updating, or deleting data. To integrate Prisma, install its extension in Visual Studio Code and then install Prisma in your project using:

```bash
npm i prisma
```

Prisma's command-line interface (CLI) can be accessed via `npx`. Initialize Prisma with:

```bash
npx prisma init
```

This will create a `prisma` folder with a `schema.prisma` file and an `.env` file for environment variables, including your MySQL connection details. To set up Prisma for MySQL, configure the `schema.prisma` as follows:

```prisma
// schema.prisma
generator client {
  provider = "prisma-client-js"
}

datasource db {
  provider = "mysql"
  url      = env("DATABASE_URL")
}
```

In the `.env` file, add your MySQL connection string:

```env
// .env
DATABASE_URL="mysql://user:password@localhost:3306/databasename"
```

Ensure that sensitive files like `.env` are not committed to version control by including them in `.gitignore`.

```bash
# .gitignore
.env
```

With this setup, you're ready to work with MySQL using Prisma in your Node.js project.

#### 5.2 Defining Application Models

In Prisma, models represent the entities of your application's domain. To define a model, add it to the `schema.prisma` file using the `model` keyword followed by the entity name in PascalCase (each word capitalized). 

A model consists of fields that represent the properties of the entity. Each field has a name, a data type (e.g., `Int`, `BigInt`, `String`, `Boolean`), and may include attributes like `@id` (for unique identifiers), `@default(value)` (for setting default values), `@default(autoincrement())` (for auto-incrementing values), and `@unique` (for ensuring field uniqueness).

Here’s an example of how to define a model:

```prisma
model User {
  id        Int      @id @default(autoincrement())
  name      String
  email     String   @unique
  createdAt DateTime @default(now())
}
```

To ensure your code is properly formatted, run:

```bash
npx prisma format
```

For more details about Prisma models and handling relationships in relational databases, refer to the official [Prisma documentation](https://www.prisma.io/docs/orm/prisma-schema/data-model/models).

#### 5.3 Creating Migrations

After defining or modifying Prisma models, you need to create migrations to keep the database schema in sync with these models. To do this, run the following command in the terminal:

```bash
npx prisma migrate dev
```

This will prompt you to name the migration, creating a folder inside the `prisma/migrations` directory with a descriptive SQL file. This file contains the SQL commands required to update the database according to your Prisma models. It's important to provide clear, descriptive names for each migration to document the applied changes.

This migration process ensures that the database schema remains in sync with your Prisma models. You can connect to your database using MySQL Workbench via the connection URL (e.g., `databasename@localhost`) to view the schema. You'll notice a `_prisma_migrations` table, which Prisma uses to track the applied migrations, along with other tables representing your models.

```sql
-- Example SQL instructions found in migration file
CREATE TABLE User (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  email VARCHAR(255) UNIQUE
);
```

#### 5.4 Creating and Managing a Prisma Client

To work with a database using Prisma, you need to create a Prisma client. Start by creating a `client.ts` file inside the `prisma` folder. Inside this file, import `PrismaClient` from `@prisma/client` and instantiate it. This instance allows access to the models defined in your Prisma schema, and you can use it to perform operations like retrieving, creating, updating, or deleting records.

To ensure that the Prisma client is used consistently throughout your Next.js application, export this instance from the `client.ts` file. In development mode, however, Next.js's Fast Refresh can lead to multiple instances of the Prisma client being created, resulting in an error due to exceeding the client limit. To prevent this, use a global namespace to store a single instance of the Prisma client, which avoids re-creating it after every refresh.

```typescript
// prisma/client.ts
import { PrismaClient } from '@prisma/client';

// Function to create a new PrismaClient instance
const prismaClientSingleton = () => {
  return new PrismaClient();
};

// Declare global scope to store the singleton instance
declare const globalThis: {
  prismaGlobal: ReturnType<typeof prismaClientSingleton>;
} & typeof global;

// Use existing instance if available, otherwise create a new one
const prisma = globalThis.prismaGlobal ?? prismaClientSingleton();

// Export the Prisma client for use throughout the application
export default prisma;

// In development, store the instance globally to avoid re-creating it
if (process.env.NODE_ENV !== 'production') globalThis.prismaGlobal = prisma;
```

This setup ensures that Prisma operates efficiently by preventing multiple client instances during development while maintaining a single, reusable client across the application.

#### 5.5 Fetching Data from the Database

To retrieve data from a database using Prisma, first import the Prisma client from the `prisma` folder. To get multiple records from a table, you can call the `findMany()` method on the model, optionally passing an object to filter the results. This method returns a promise that you can `await`. If you need to retrieve a single, unique record, use the `findUnique()` method, providing a `where` condition to specify the criteria for fetching the record.

Example:

```typescript
import prisma from '../prisma/client';

// Fetch multiple records with optional filtering
const users = await prisma.user.findMany({
  where: { active: true },
});

// Fetch a unique record by its identifier
const user = await prisma.user.findUnique({
  where: { id: 1 },
});
```

#### 5.6 Creating Data in a Database

To insert data into a database using Prisma, first import the Prisma client from the `prisma` folder. Use the `create()` method on the model to create a new record. Pass an object containing the `data` property, where you manually specify the attributes for the new instance. This ensures that only authorized attributes are included, preventing users from submitting unauthorized fields. The `create()` method returns the newly created record.

```typescript
import prisma from '../prisma/client';

// Create a new record
const newUser = await prisma.user.create({
  data: {
    name: 'John Doe',
    email: 'john@example.com',
    active: true,
  },
});

// newUser now contains the newly created user instance
```

#### 5.7 Updating Data in a Database

To update a record in a database using Prisma, first import the Prisma client from the `prisma` folder. Use the `update()` method on the model, passing an object with two properties: `where`, which specifies the record to update (e.g., using a unique identifier), and `data`, which contains the fields to be updated. This approach ensures that only authorized fields are modified, preventing users from changing unauthorized attributes. The `update()` method returns the updated record.

```typescript
import prisma from '../prisma/client';

// Update a record
const updatedUser = await prisma.user.update({
  where: { id: 1 },  // Identify the record to update
  data: {
    name: 'Eli',  // Fields to update
    active: false,
  },
});

// updatedUser now contains the updated user instance
```

#### 5.8 Deleting Data in a Database

To delete a record from a database using Prisma, start by importing the Prisma client from the `prisma` folder. Then, use the `delete()` method on the model, passing an object with the `where` property to specify the record to be deleted, such as by its unique identifier. This will remove the specified record from the table.

```typescript
import prisma from '../prisma/client';

// Delete a record
const deletedUser = await prisma.user.delete({
  where: { id: 1 },  // Identify the record to delete
});

// deletedUser contains the details of the removed record
```

## 6. Uploading Files

#### 6.1 Uploading Files to Cloudinary

To handle file uploads in a Next.js application, a cloud platform like Cloudinary is an ideal solution due to its seamless integration. Cloudinary allows easy file storage and retrieval, making it simple to work with in a Next.js project.

Steps for Setup:

1. **Sign Up for Cloudinary:** 
   First, register on [Cloudinary's platform](https://cloudinary.com/), which provides a free tier with limited resources. Set up separate environments for development and production if needed.

2. **Install Cloudinary:**
   In your Next.js project, install the Cloudinary package using:
   
   ```bash
   npm i cloudinary
   ```

3. **Configure Environment Variables:**
   Add your Cloudinary cloud name to your environment variables in `.env.local` or `.env`:
   
   ```env
   NEXT_PUBLIC_CLOUDINARY_CLOUD_NAME="<Your Cloud Environment Name>"
   ```

4. **Using the Cloudinary Upload Widget:**
   Import `CldUploadWidget` from `next-cloudinary` into your React component. This component can be used to trigger the Cloudinary upload widget.
   
   ```tsx
   "use client";
   import { CldUploadWidget } from 'next-cloudinary';
   
   const MyUploadComponent = () => {
     const handleUpload = (widget) => {
       widget.open(); // Opens the Cloudinary widget
     };
   
     return (
       <CldUploadWidget uploadPreset="<Your Upload Preset>">
         {({ open }) => (
           <button onClick={open}>Upload Files</button> // Trigger upload on button click
         )}
       </CldUploadWidget>
     );
   };
   
   export default MyUploadComponent;
   ```
   
   In addition to CldUploadWidget, [Next Cloudinary](https://next-cloudinary.dev/installation) offers other components for uploading files to Cloudinary in a Next.js application.

5. **Configuring Upload Preset:**
   
   - Go to the Cloudinary management console.
   - Navigate to "Settings" > "Upload" > "Upload Presets."
   - Create a new upload preset with an unsigned signing mode and optionally, specify a folder for uploads.

6. **File Management:**
   After upload, the files can be viewed in the Cloudinary Media Library under the specified preset or folder.

With these steps, Cloudinary provides a straightforward method for handling user file uploads in a Next.js app.

#### 6.2 Handling File Upload Events

The `CldUploadWidget` component from next-cloudinary provides an `onUpload` prop, which triggers each time a file is uploaded. You can pass a handler function to this prop, with parameters like `result` and `widget`. The `result` object contains metadata about the uploaded file, such as its unique identifier (`public_id`) and URL (`secure_url`). Using this metadata, you can display the uploaded file in your app.

For instance, to show an uploaded image, import the `CldImage` component from `next-cloudinary` and provide the `public_id` as the `src` prop, allowing you to render images stored in Cloudinary.

```tsx
import { CldUploadWidget, CldImage } from 'next-cloudinary';
import { useState } from 'react';

const UploadComponent = () => {
  const [imageId, setImageId] = useState(null);

  return (
    <>
      <CldUploadWidget
        uploadPreset="your-upload-preset"
        onUpload={(result, widget) => {
          setImageId(result.info.public_id);  // Capture the uploaded image's ID
        }}
      >
        {({ open }) => <button onClick={open}>Upload Image</button>}
      </CldUploadWidget>

      {imageId && (
        <CldImage src={imageId} alt="Uploaded image" width="300" height="300" />
      )}
    </>
  );
};

export default UploadComponent;
```

#### 6.3 Customizing Cloudinary Upload Widgets via GUI

Cloudinary offers a visual interface at [Cloudinary Docs](https://demo.cloudinary.com/uw/#/) that allows you to fully customize upload widgets through a user-friendly GUI. You can tailor various aspects such as upload sources, theme settings, fonts, and enable features like cropping or uploading multiple files. The page provides code snippets that reflect your customizations, making it easy to integrate personalized widgets into your Next.js project or other applications.

## 7. Authentification With NextAuth.js

#### 7.1 Setting Up NextAuth.js for Authentication

NextAuth.js is a popular authentication library for Next.js applications. To get started, first install the library using:

```bash
npm i next-auth
```

Next, set up an API route handler by creating a `route.ts` file inside a "catch-all" folder structure at `/app/api/auth/[...nextauth]/route.ts`. In this file, import `NextAuth` from `next-auth` and create a handler function that configures authentication options.

```typescript
import NextAuth from "next-auth";

const handler = NextAuth({
  // Add your authentication options here
});

export { handler as GET, handler as POST };
```

This setup automatically handles both GET and POST requests for `/auth` routes, enabling authentication flow in your application.

In your `.env` file, include necessary environment variables such as:

```bash
NEXTAUTH_URL=http://localhost:3000
NEXTAUTH_SECRET=your-random-secret
```

You can generate a secure secret using `openssl rand -base64 32` for encryption and signing purposes.

#### 7.2 Configuring Google OAuth with NextAuth.js

NextAuth.js supports various authentication providers like Google, GitHub, Facebook, and more, allowing users to sign in using external services. For example, to integrate Google OAuth, first, go to the [Google Cloud Platform](https://console.developers.google.com/apis/credentials) and create a project. After configuring the project:

1. **Set up the OAuth consent screen**: Define whether the users are internal or external. Fill in details such as the app name, support email, privacy policy URL, and more.
2. **Configure OAuth credentials**: Go to the Credentials tab, create OAuth 2.0 credentials, and select the application type as "Web Application." Specify the Authorized JavaScript origins (e.g., `http://localhost:3000`) and Redirect URI (e.g., `http://localhost:3000/api/auth/callback/google`).
3. After creating the credentials, you will receive a Client ID and Client Secret.

Add the following values to your `.env` file:

```bash
GOOGLE_CLIENT_ID=your-google-client-id
GOOGLE_CLIENT_SECRET=your-google-client-secret
```

Now, set up Google as a provider in your `NextAuth` configuration:

```typescript
// /app/api/auth/[...nextauth]/route.ts
import NextAuth from "next-auth";
import GoogleProvider from "next-auth/providers/google";

const handler = NextAuth({
  providers: [
    GoogleProvider({
      clientId: process.env.GOOGLE_CLIENT_ID!,
      clientSecret: process.env.GOOGLE_CLIENT_SECRET!,
    }),
  ],
});

export { handler as GET, handler as POST };
```

This setup enables users to sign in via Google, redirecting them to Google for authentication and back to your app. You can trigger this with a link to `/api/auth/signin`.

#### 7.3 Understanding Authentification Sessions

When a user logs into your application using NextAuth.js, it creates an authentication session that is typically represented by a JSON Web Token (JWT). This token is used to maintain the user's session across requests. You can view these tokens in the browser’s DevTools by navigating to the Application panel and checking under the Cookies section. The session token is stored as a long string, which is actually an encoded JSON object using the base64 algorithm.

This JWT contains key user data, such as the user's name, email, profile picture, and metadata like the issued at (`iat`) and expiration time (`exp`). Each time the client makes a request, this token is sent to the server for user identification.

The server decodes the JWT to retrieve and verify this information, enabling secure and stateless communication between the client and the server.

```typescript
// Example structure of decoded JWT:
{
  name: "John Doe",
  email: "john.doe@example.com",
  picture: "https://example.com/avatar.jpg",
  sub: "user_id",
  iat: 1675815469,  // issued at
  exp: 1675819069   // expiration time
}
```

NextAuth.js takes care of encoding, decoding, and managing the JWT to ensure that user sessions are handled securely across requests.

#### 7.4 Accessing Authentication Session

###### 7.4.1 Client-Side

To manage authentication sessions on the client side with NextAuth.js, create an `AuthProvider` component. First, inside the `app` folder, add a new `auth` directory and create a `Provider.tsx` file. Define the `AuthProvider` component to wrap around the app's child components, using the `SessionProvider` from `next-auth/react`. This ensures session data is available throughout the app. Don’t forget to mark the component as a client-side component using `"use client"` at the top of the file.

```typescript
// AuthProvider.tsx
"use client";

import { SessionProvider } from "next-auth/react";

export default function AuthProvider({ children }) {
  return <SessionProvider>{children}</SessionProvider>;
}
```

Next, update your root `layout.tsx` file to wrap the entire app in the `AuthProvider`. This will allow session data to flow through the React context to all child components. You can now access session data anywhere in the app.

```typescript
// Usage in layout.tsx
import AuthProvider from "./auth/Provider";

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body>
        <AuthProvider>
          {children}
        </AuthProvider>
      </body>
    </html>
  );
}
```

To use session data, the `useSession` hook from `next-auth/react` can be leveraged. It returns the session status (`authenticated`, `loading`, or `unauthenticated`) and session data (such as user details). This can help conditionally render components based on the user’s authentication state.

```typescript
"use client";

import { useSession } from "next-auth/react";

export default function UserProfile() {
  // Destructure the status and session from the useSession hook
  const { data: session, status } = useSession();

  // Handle the loading state
  if (status === "loading") {
    return <p>Loading...</p>;
  }

  // Handle the unauthenticated state
  if (status === "unauthenticated") {
    return <p>You are not logged in. Please sign in to view your profile.</p>;
  }

  // Handle the authenticated state
  return (
    <div>
      <h1>Welcome, {session?.user?.name}!</h1>
      <p>Email: {session?.user?.email}</p>
      <img src={session?.user?.image ?? "/default-avatar.png"} alt="User Avatar" />
    </div>
  );
}
```

###### 7.4.2 Server-Side

To access authentication sessions on the server side in a Next.js app, you can use the `getServerSession()` function from NextAuth.js. Ensure that the configuration object used to initialize NextAuth is exported from your route handler file (`app/api/auth/[...nextauth]/route.ts`). This will allow the same configuration to be used in other parts of your app.

```typescript
import NextAuth from "next-auth";
import GoogleProvider from "next-auth/providers/google";

export const authOptions = {
  providers: [
    GoogleProvider({
      clientId: process.env.GOOGLE_CLIENT_ID!,
      clientSecret: process.env.GOOGLE_CLIENT_SECRET!,
    }),
  ],
};

const handler = NextAuth(authOptions);
export { handler as GET, handler as POST };
```

In any server-side component (e.g., `app/page.tsx`), you can retrieve the current session by calling `getServerSession()` and passing the `authOptions` from your route handler.

```typescript
import { getServerSession } from "next-auth";
import { authOptions } from "../api/auth/[...nextauth]/route";

export default async function HomePage() {
  // Fetch the session
  const session = await getServerSession(authOptions);

  return (
    <div>
      {session ? (
        <p>Welcome, {session.user?.name}</p>
      ) : (
        <p>Please sign in to access this page.</p>
      )}
    </div>
  );
}
```

This setup ensures that server-side components and API routes can both access the current session. The `getServerSession()` function returns a promise that resolves with the session data, allowing you to easily determine if a user is authenticated and access user information on the server.

#### 7.5 Signing Out with NextAuth.js

In a Next.js application using NextAuth.js, you can allow users to sign out by using the NextAuth-provided sign-out page. To implement this, simply add a `Link` component that directs users to `/api/auth/signout`. This route will trigger NextAuth’s built-in sign-out process, ensuring that the user’s session is properly terminated.

```tsx
import Link from 'next/link';

export default function SignOutLink() {
  return (
    <div>
      <Link href="/api/auth/signout">
        <button>Sign Out</button>
      </Link>
    </div>
  );
}
```

By clicking the "Sign Out" button, the user will be navigated to the sign-out page, which finalizes the sign-out process and ends the authentication session.

#### 7.6 Protect Routes

In Next.js, a middleware function can be used to run code before a request is completed. In a project using NextAuth.js, middleware can check whether a user has a session before accessing protected routes. To set this up, create a `middleware.ts` file in the root of the project, and import the middleware function from `next-auth/middleware`. This middleware will run on every request by default, but you can restrict it to specific routes using a matcher.

The matcher allows you to specify which paths the middleware should apply to, protecting sensitive routes. Dynamic placeholders like `*`, `+`, or `?` can be used for flexible path matching. If a user tries to access a protected route without an active session, NextAuth will automatically redirect them to the sign-in page.

```typescript
// middleware.ts
import { withAuth } from 'next-auth/middleware';

export default withAuth({
  pages: {
    signIn: '/auth/signin', // Redirects to the sign-in page if the user is not authenticated
  },
});

export const config = {
  matcher: ['/dashboard*', '/profile*'], // Apply middleware only on these paths
};
```

#### 7.7 Database Adapters

To store users and their associated data in a database when using NextAuth.js, you can leverage adapters like the Prisma Adapter, which handles persisting session, account, and user data. First, install the required dependencies in your project:

```bash
npm i @next-auth/prisma-adapter
npm i prisma
```

Then, initialize the Prisma adapter in your authentication configuration file located at `/app/api/auth/[...nextauth]/route.ts`:

```typescript
import NextAuth from "next-auth";
import { PrismaAdapter } from "@next-auth/prisma-adapter";
import { prisma } from "@/prisma/client";

export const authOptions = NextAuth({
  adapter: PrismaAdapter(prisma), // Integrates Prisma with NextAuth
  providers: [], // Add providers here (e.g., Google, GitHub)
});
```

You'll also need to add models to the Prisma schema to store user accounts, sessions, and verification tokens. Example schema:

```prisma
model Account {
  id                 String  @id @default(cuid())
  userId             String  @map("user_id")
  provider           String
  providerAccountId  String  @map("provider_account_id")
  refresh_token      String? @db.Text
  access_token       String? @db.Text
  user User @relation(fields: [userId], references: [id], onDelete: Cascade)
  @@unique([provider, providerAccountId])
  @@map("accounts")
}

model Session {
  id           String   @id @default(cuid())
  sessionToken String   @unique @map("session_token")
  userId       String   @map("user_id")
  expires      DateTime
  user         User     @relation(fields: [userId], references: [id], onDelete: Cascade)
  @@map("sessions")
}

model User {
  id                String    @id @default(cuid())
  email             String?   @unique
  hashedPassword     String?
  name              String?
  accounts          Account[]
  sessions          Session[]
  @@map("users")
}

model VerificationToken {
  identifier String
  token      String
  expires    DateTime
  @@unique([identifier, token])
  @@map("verificationtokens")
}
```

After defining the models, run a Prisma migration to create the necessary tables:

```bash
npx prisma migrate dev
```

This will create the tables Account, Session, User, and VerificationToken. If you're using OAuth providers (e.g., Google), the session strategy will default to JWT. To change this behavior and make it compatible with OAuth, you need to configure your `authOptions` like this:

```typescript
export const authOptions: NextAuthOptions = {
  session: {
    strategy: 'jwt', // Use JSON Web Tokens
  },
  // Add Prisma adapter and providers here
};
```

Now, users and their data will be stored in your database, and sessions will be managed efficiently using Prisma.

#### 7.8 Custom Authentication

###### 7.8.1 Configuring Credential Provider

In addition to OAuth providers, NextAuth.js offers a Credential Provider, which allows manual handling of user authentication based on custom logic. To integrate it, start by importing the `CredentialsProvider` from `next-auth/providers/credentials` and add it to the array of providers during the NextAuth initialization.

A typical `CredentialsProvider` setup includes defining fields such as `email` and `password` inside the `credentials` property. The `authorize` method, an asynchronous function, validates the credentials by checking if both fields are provided and then compares the provided password with the stored hashed password (e.g., using bcrypt).

Here's an example setup:

```typescript
import NextAuth from "next-auth";
import CredentialsProvider from "next-auth/providers/credentials";
import { prisma } from "@/prisma/client";
import bcrypt from "bcrypt";

export const authOptions = NextAuth({
  providers: [
    CredentialsProvider({
      name: "Credentials",
      credentials: {
        email: { label: "Email", type: "email", placeholder: "you@example.com" },
        password: { label: "Password", type: "password", placeholder: "Password" }
      },
      async authorize(credentials, req) {
        // Check if both email and password are provided
        if (!credentials?.email || !credentials?.password) return null;

        // Retrieve user from the database
        const user = await prisma.user.findUnique({
          where: { email: credentials.email },
        });

        // Return null if user is not found
        if (!user) return null;

        // Compare provided password with hashed password in database
        const isValidPassword = await bcrypt.compare(credentials.password, user.hashedPassword);

        // Return user object if valid, otherwise return null
        return (isValidPassword) ? user : null;
      }
    })
  ],
});
```

To install bcrypt for password hashing and comparison, run the following commands:

```bash
npm i bcrypt
npm i -D @types/bcrypt
```

This setup allows manual user validation, offering flexibility when integrating custom databases or authentication methods. The `authorize` method ensures that only valid users are authenticated by comparing the provided password with the hashed password stored in the database.

###### 7.8.2 User Registration

To enable user registration when using the Credential Provider in NextAuth.js, you can create an API endpoint that will handle user account creation. This endpoint can be accessed by a client-side form component.

Start by creating a register folder inside the `/app/api` directory, and add a `route.ts` file. In this file, define a `POST` function to handle the registration process. This function should:

1. **Parse and validate the request body**: Use `request.json()` to parse the incoming data and validate it using the Zod library. Zod's `z.object()` allows you to define schema validation rules for fields like email and password. Then, use `schema.safeParse()` to check if the request meets the validation criteria.

2. **Check if the user already exists**: Utilize Prisma's `findUnique()` method to check if a user with the same email is already present in the database. If the user exists, return an error response.

3. **Hash the password**: If the user doesn't exist, hash the password using bcrypt's `hash()` method to securely store it in the database.

4. **Create the new user**: Call Prisma's `create()` method to insert the new user with the hashed password into the database.

5. **Return a response**: Return a JSON response with the newly created user's details or an error message if the operation fails.

Here’s an example code structure for the registration API:

```typescript
import { NextRequest, NextResponse } from 'next/server';
import { prisma } from '@/prisma/client';
import bcrypt from 'bcrypt';
import { z } from 'zod';

// Define schema validation
const userSchema = z.object({
  email: z.string().email(),
  password: z.string().min(8),
});

export async function POST(request: NextRequest) {
  const body = await request.json();

  // Validate request body using Zod
  const validation = userSchema.safeParse(body);
  if (!validation.success) {
    return NextResponse.json({ error: validation.error }, { status: 400 });
  }

  const { email, password } = body;

  // Check if user already exists
  const existingUser = await prisma.user.findUnique({
    where: { email },
  });

  if (existingUser) {
    return NextResponse.json({ error: 'User already exists' }, { status: 400 });
  }

  // Hash password
  const hashedPassword = await bcrypt.hash(password, 10);

  // Create new user
  const newUser = await prisma.user.create({
    data: {
      email,
      password: hashedPassword,
    },
  });

  return NextResponse.json(newUser);
}
```

With this setup, you can securely register new users in your Next.js application by processing form submissions and saving user details to your database.

## 8. Sending Emails

#### 8.1 Setting Up React Email

React Email is a widely-used library for creating responsive email templates in Next.js applications. To integrate it, begin by installing the required packages with the following command:

```bash
npm install react-email @react-email/components
```

Next, add a script to your `package.json` for previewing email templates. This command launches a local server where you can preview the emails you build:

```json
"scripts": {
  "preview-email": "email dev -p 3030"
}
```

#### 8.2 Creating Email Templates

Now, create an `emails` folder at the root of your project to store the React components that will represent your email templates. Inside this folder, you can design your email templates using components provided by the React Email library such as `Html`, `Body`, `Container`, `Text`, `Link`, and `Preview`. These components help structure your email in a way that ensures proper rendering across different email clients.

Here’s an example of a basic email template using these components:

```typescript
import { Html, Body, Container, Text, Link, Preview } from "@react-email/components";

export default function WelcomeEmail() {
  return (
    <Html>
      <Preview>Welcome to Our Platform</Preview>
      <Body>
        <Container>
          <Text>Hello,</Text>
          <Text>Welcome to our platform! We're excited to have you.</Text>
          <Link href="https://yourwebsite.com">Click here to get started!</Link>
        </Container>
      </Body>
    </Html>
  );
}
```

#### 8.3 Previewing Email Templates

The React Email library includes a built-in tool to preview email templates during development. To launch this environment, run the following command:

```bash
npm run preview-email
```

This command will start a local server on `http://localhost:3030`, where you can preview and interact with all the templates stored in your `emails` folder. You can also send test emails directly to a recipient through this interface.

However, running the preview tool generates thousands of temporary files within the `.react-email/` folder in your Next.js project, which are solely for development purposes and should not be tracked by version control. To avoid this, add the following entry to your `.gitignore` file:

```
.react-email/
```

This ensures that your repository remains clean, and only relevant project files are tracked.

#### 8.4 Styling Email Components

In React Email, there are two main strategies for styling components within email templates:

1. **Inline CSS Styling:**
   One approach is to write CSS directly within the `EmailTemplate.tsx` file. You can declare a variable for styles using the `CSSProperties` type imported from React. These styles are then applied to elements through the `style` prop.
   
   ```tsx
   import React, { CSSProperties } from 'react';
   
   const textStyle: CSSProperties = {
     color: 'blue',
     fontSize: '16px',
   };
   
   const EmailTemplate = () => (
     <Container>
       <Text style={textStyle}>Hello, this is a styled text!</Text>
     </div>
   );
   ```

2. **Tailwind CSS Styling:**
   Another option is to use Tailwind CSS for styling. Start by importing the `Tailwind` component from `@react-email/components`. You can then wrap your elements with the `Tailwind` component and apply Tailwind classes via the `className` property.
   
   ```tsx
   import { Tailwind } from '@react-email/components';
   
   const EmailTemplate = () => (
     <Tailwind>
       <Container className="bg-blue-500 text-white p-4">
         <Text className="text-lg">Hello, this is a Tailwind styled text!</Text>
       </Container>
     </Tailwind>
   );
   ```

#### 8.4 Sending Emails

To send emails using React Email, you'll need to integrate it with an email sending service such as Resend. Resend offers various pricing plans, including a free plan that allows sending up to 3,000 emails per month. First, sign up for Resend and obtain your unique API key. 

In your Next.js project, store the API key in the `.env` file as follows:

```env
RESEND_API_KEY=your_resend_api_key
```

Next, install the Resend package:

```bash
npm i resend
```

In your business logic (e.g., when submitting a form), import Resend, create an instance using the `RESEND_API_KEY`, and call the `emails.send()` method. This method requires a payload object that includes the sender’s email, recipient email, subject, and the React email template.

```typescript
import Resend from 'resend';
import { EmailTemplate } from '@/emails/EmailTemplate';

const resend = new Resend(process.env.RESEND_API_KEY);

async function sendEmail() {
  await resend.emails.send({
    from: 'sender@example.com',
    to: 'recipient@example.com',
    subject: 'Welcome to Our Service',
    react: <EmailTemplate />,
  });
}
```

Ensure the sender’s email is verified in the Domains section of your Resend account for successful delivery. This setup allows you to send dynamic emails from your Next.js application.

## 9. Optimizations in Next.js

#### 9.1 Optimizing Images

The `Image` component in Next.js (imported from `next/image`) offers significant performance improvements over the standard HTML image element by automatically compressing and resizing images based on the user's viewport. It should be preferred for handling images, especially since it reduces load times and bandwidth usage.

The component accepts several props, such as:

- **`src`**: This can be a statically imported image or a URL for remote images.
- **`alt`**: Provides a description for the image.

For remote images (like those stored on cloud services), it's crucial to define valid domains in the `next.config.js` file. This ensures that only trusted sources are allowed to serve images, enhancing security.

```javascript
const nextConfig = {
  images: {
    remotePatterns: [
      {
        protocol: 'https',
        hostname: 'example.com',
        pathname: '/account123/**',
      },
    ],
  },
};
```

When using the `Image` component on remote images, always specify image dimensions using the `width` and `height` props for fixed-sized images. For responsive images, the `fill` prop is recommended. To maintain aspect ratios, use `object-cover` or `object-contain` from Tailwind CSS, applied via the `className` prop. You can also manage image responsiveness by using the `sizes` prop, which accepts relative units and media queries.

Other key features include:

- **`quality`**: Controls the image quality (default is 75).
- **`priority`**: For images above the fold, set this to prioritize their loading, as the component uses lazy loading by default.

When using `fill`, ensure that the parent container has a non-static position (e.g., `relative`, `absolute`, or `fixed`) and proper sizing.

Example usage:

```tsx
import Image from 'next/image';
import exampleImage from '@/public/example.jpg';

export default function MyComponent() {
  return (
    <div className="relative w-full h-64">
      <Image
        src={exampleImage}
        alt="An example image"
        fill
        className="object-cover"
        priority
      />
    </div>
  );
}
```

#### 9.2 Adding Third-Party Scripts

Incorporating third-party services often requires adding external scripts to your pages. In Next.js, rather than directly using HTML's `<script>` tag, it is better to use the **`Script`** component from `next/script`, which offers better control and optimization for loading these scripts.

To include a script on specific pages, you can add the `Script` component within individual pages or layouts. For example, to load the script across all pages, you should include it in the `root layout.tsx` file. For inline scripts, you can avoid errors by enclosing long scripts in braces and backticks, which allows the `Script` component to parse them correctly.

The `Script` component offers various loading strategies for more efficient rendering:

- **`beforeInteractive`**: Loads the script before any client-side code is executed, useful for critical scripts.
- **`afterInteractive`** (default): Loads the script once the page becomes interactive.
- **`lazyOnLoad`**: Delays the script until after all other resources are fetched, perfect for low-priority or background scripts.

When dealing with multiple third-party scripts, it may be preferable to store them in a separate component for cleaner code management.

Example usage:

```tsx
import Script from 'next/script';

export default function MyPage() {
  return (
    <>
      <h1>My Page</h1>
      <Script 
        id="third-party-script" 
        strategy="lazyOnLoad"
      >
        {`console.log('Third-party script loaded');`}
      </Script>
    </>
  );
}
```

#### 9.3 Using Custom Fonts

To use Google Fonts in a Next.js application, you can easily import them using the `next/font/google` library. For example, importing the Roboto font can be done by calling the font function and passing an options object that specifies font properties such as `subsets` and `weight`. The returned font object can then be applied to elements by setting the `className` attribute to `roboto.className`.

```tsx
import { Roboto } from 'next/font/google';

const roboto = Roboto({
  subsets: ['latin'],
  weight: '400',
});

export default function MyComponent() {
  return <div className={roboto.className}>Hello World!</div>;
}
```

For non-Google custom fonts, use the `localFont` function imported from `next/font/local` . This function allows you to load fonts from local files by passing an options object, including the `src` property for the font file location and a `variable` for naming the font (e.g., `--font-poppins`). To use the font in Tailwind CSS, you can extend the `fontFamily` in the `tailwind.config.ts` file. Reference the font using `var(--font-poppins)` in your CSS, and apply it to elements with the `className` attribute like `font-poppins`.

```tsx
import localFont from 'next/font/local';

const poppins = localFont({
  src: './fonts/Poppins-Regular.ttf',
  variable: '--font-poppins',
});

export default function MyComponent() {
  return <div className="font-poppins">Hello World!</div>;
}

// tailwind.config.ts
module.exports = {
  theme: {
    extend: {
      fontFamily: {
        poppins: ['var(--font-poppins)'],
      },
    },
  },
};
```

#### 9.4 Search Engine Optimization

In Next.js, improving Search Engine Opitimization (SEO) is straightforward using the `metadata` object. In the root `layout.tsx` file, you can export this object with properties like `title` and `description`. Next.js will automatically insert these into the HTML head, allowing search engines to index the content effectively. These meta tags help define each page’s purpose, making them more search engine-friendly. Additionally, `metadata` can include other properties like `openGraph` to optimize for social sharing. When adding metadata in `layout.tsx`, it applies globally across all pages, but it can be overridden by more specific `metadata` settings in individual `page.tsx` or layout files.

```tsx
export const metadata = {
  title: 'My Website',
  description: 'This is a great website.',
  openGraph: {
    title: 'My Website',
    description: 'Check out this awesome site!',
    url: 'https://mywebsite.com',
    type: 'website',
  },
};
```

For dynamic pages (like those with route parameters or query strings), metadata can be generated dynamically by exporting an `async generateMetadata` function, allowing you to fetch data from an API and return a metadata object based on the content.

```tsx
export async function generateMetadata() {
  const data = await fetchDataFromAPI();
  return {
    title: data.pageTitle,
    description: data.pageDescription,
  };
}
```

#### 9.5 Lazy Loading

Lazy loading is a performance optimization strategy where components or third-party libraries are loaded only when needed, rather than upfront during page load. In Next.js, all statically imported components are loaded with the initial page load by default. To enable lazy loading, the `dynamic` function from `next/dynamic` is used. 

To lazily load a component, use the `dynamic` function, passing it an import statement for the component. You can also include an optional second argument, an object with properties like `loading`, which displays a loader during the component load, and `ssr: false` to disable server-side rendering for that component.

```tsx
import dynamic from 'next/dynamic';

const LazyComponent = dynamic(() => import('./HeavyComponent'), {
  loading: () => <p>Loading...</p>,
  ssr: false, // Disables server-side rendering for this component
});

export default function Page() {
  return <LazyComponent />;
}
```

Lazy loading is ideal for large, resource-heavy components that may slow down the initial load. However, for smaller components, lazy loading may slightly increase the component size and degrade performance.

You can also lazily load third-party libraries by dynamically importing them using `import()`. This technique ensures the library is loaded only when it is needed, not during the initial page load:

```tsx
export default function Page() {
  async function loadLibrary() {
    const { someLibraryFunction } = await import('some-library');
    someLibraryFunction();
  }

  return <button onClick={loadLibrary}>Load Library</button>;
}
```

This technique ensures efficient resource usage and can significantly improve load times by reducing the amount of initial JavaScript loaded.

## 10. Building and Deploying a Next.js Application

To locally build a Next.js application, run the command `npm run build`, which compiles the project and outputs the production-ready files to the `dist` folder. Any build errors must be fixed for the process to succeed.

For deployment, Vercel is a popular platform for hosting Next.js applications. It integrates easily with GitHub repositories, enabling automated deployments when code is pushed to GitHub. To deploy, you will synchronize your repository with Vercel and configure settings such as the project name, framework (Next.js), build command, and output directory.

Additionally, you must set up environment variables for production, like database URLs or cloud service credentials. These production values should be distinct from development values to enhance security, ensuring your production environment is protected even if the development environment is compromised.

Once set up, Vercel automates the process: it pulls the latest code from your GitHub repository, builds the application, and deploys it whenever updates are pushed.
