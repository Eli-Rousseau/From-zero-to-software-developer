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
