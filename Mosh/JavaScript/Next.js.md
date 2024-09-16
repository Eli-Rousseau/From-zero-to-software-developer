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

#### 1.3 Key Project Structure in Next.js

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

```tsx

```
