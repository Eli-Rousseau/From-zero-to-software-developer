# Part 1. Web Development

## 1. Overview of the Internet

#### 1.1 Internet and World Wide Web

The **internet** is a global network of connected computing devices that allows for the exchange of information across vast distances. While the internet serves as the underlying infrastructure, the **World Wide Web (WWW)** is a system of interlinked websites and web resources that are accessible through web browsers. The web provides a user-friendly interface for browsing and interacting with content online, transforming the internet into a more accessible and interactive environment.

#### 1.2 Browsers and Servers

###### 1.2.1 The Client-Server Model

Data exchange on the internet commonly follows the **client-server model**. In this model, the **client** is the user's device or application (such as a web browser) that requests data. The **server** is the system that processes these requests and sends the required data back to the client. This model is foundational to how information is accessed and shared on the internet, with servers delivering content to clients on demand.

###### 1.2.2 Browsers and Servers Communication

When you enter a web address in a browser like Chrome, Firefox, Safari, or Edge, the browser sends a request to a server that hosts the website's files. This server, a powerful computer designed for data storage and retrieval, processes the request and returns the required files to the browser using the HTTP protocol. The browser then displays the files, allowing the website to appear on your screen. HTTP enables this communication through various request methods, such as GET, POST, PUT, and DELETE, each serving different purposes in data transfer.

###### 1.2.3 Status Code

When a server responds to a client, the server specifies a status code as a part of the response. Status codes indicate whether or not the HTTP request was successfully completed and if there was an error, they contain some information about the type of error that happened. The status code helps the browser know how to handle the data that was sent back with the response.

#### 1.3 Loading Webpages

When loading a webpage, your device sends multiple simultaneous requests to retrieve the various files that make up the site, such as HTML, CSS, JavaScript, images, and videos. Once the server processes the initial request, it sends back the HTML file, which the browser uses to identify and request additional resources like stylesheets for design and scripts for interactivity. These requests are typically made in parallel, allowing the browser to display the page as quickly as possible, often within a second, depending on connection speed and file sizes.

#### 1.4 The Evolution from Static Websites to Web 2.0

Early static websites were simple, offering limited interactivity and requiring full page reloads for any changes. However, advances in internet speed and web technologies in the early 2000s led to the emergence of "Web 2.0" applications. These dynamic websites allowed for real-time content updates without reloading the page, and emphasized user-generated content and social sharing. Key innovations, such as the jQuery framework and database-connected web frameworks like Spring, Django, and Ruby-on-Rails, were crucial in enabling these more interactive and responsive web experiences.

#### 1.5 The Impact of Mobile Trafic on Internet Usage and Web Development

The proliferation of smartphones has shifted internet usage, with mobile traffic now comprising over half of all web traffic. This shift has driven the evolution of web development practices, particularly through responsive web design, which adapts website layouts to different screen sizes using CSS enhancements like media queries. Additionally, mobile applications have altered internet browsing habits, as users increasingly engage with specific apps rather than browsing through mobile web browsers.

## 2. Languages for Web Development

#### 2.1 HTML Languge

###### 2.1.1 Markup Language

HTML, or Hypertext Markup Language, forms the structural backbone of all web pages by organizing content such as text, images, and videos. It’s an accessible starting point for learning to code, allowing users to create basic websites and view their progress directly in a browser. HTML employs tags, which are annotations in angle brackets, to define and structure different elements on a page, effectively separating content from its presentation and providing clear instructions about the type of content contained.

###### 2.1.2 HTML Element Syntax

An HTML element is a fundamental unit in an HTML document, composed of an opening tag, content, and a closing tag. For example, a paragraph element (`<p>`) starts with the opening tag `<p>`, includes the content (e.g., “Hello World!”), and ends with the closing tag `</p>`. The opening tag defines the start of the element and is enclosed in angle brackets, while the closing tag, which includes a forward slash, signifies the end of the element. The content is the text or media placed between these tags.

###### 2.1.3 Hypertext

Hypertext refers to text that links to other text, allowing users to navigate between interconnected documents. Unlike traditional linear reading, hypertext enables users to click on links and explore various pages based on their interests, creating a dynamic and personalized browsing experience. The fundamental structure of the web remains a network of hyperlinked documents.

###### 2.1.4 Hyperlink Attribute

In HTML, attributes provide additional details about elements using a name and value pair, formatted as `name="value"`. The `href` attribute, used with anchor tags (`<a>`), specifies the URL that a link directs to. By setting the `href` attribute, you define both the visible text of the link and the destination URL for user navigation.

```html
<a href=/link/to/file.html> Click here to access a new HTML file</a>
```

#### 2.2 CSS Language

CSS (Cascading Style Sheets) is the language used to style HTML content, including colors, fonts, positioning, and layout. It separates style from content, following the computer science principle of separation of concerns to make large codebases more manageable. CSS uses selectors to target specific HTML elements and apply visual rules for their presentation. To implement CSS on a website, the HTML `<link>` element is used to connect the HTML file with the CSS file, enabling the browser to apply the defined styles.

#### 2.3 JavaScript Language

###### 2.3.1 Dynamic Language

JavaScript is essential for adding interactive and dynamic features to websites beyond static content. It enables functionalities such as popup ads, animated graphics, interactive audio and video, and location-based maps. JavaScript's key capability is its responsiveness to browser events, which are triggered by various user actions like clicking buttons, pressing keys, or resizing windows, allowing real-time interaction and enhanced user experiences.

###### 2.3.2 Functions and Events

In JavaScript, functions and events are fundamental building blocks. Functions enable code reuse by allowing developers to define a block of code that can be executed multiple times. Events allow JavaScript to respond to user actions, such as hovering over an element or resizing a window. Together, functions and events facilitate interactive web experiences: events trigger functions, which in turn execute specific actions, creating dynamic and engaging websites.

#### 2.4 SQL Language

SQL (Structured Query Language) is used to query and analyze data stored in tables, which are organized into rows and columns. SQL allows users to write queries to retrieve, modify, and manage data. Web developers and software engineers utilize SQL to build applications that can efficiently handle data storage and manipulation.

## 3. What is Programming?

Programming is the process of creating a set of instructions for a computer to execute, much like following a recipe. It involves thinking up the steps (programming) and then translating them into a language the computer can understand (coding). Over time, programming has evolved from using simple punch cards to advanced coding languages and interfaces. This skill enables us to effectively communicate with computers, turning them into powerful tools that enhance various aspects of our lives, from work to daily interactions. Learning to code can be challenging, but it empowers us to build and innovate in countless ways.

## 4. Setting up a Project

#### 4.1 Development Environment

Text editors, or code editors, assist developers in writing and managing code by offering features such as syntax highlighting, automatic indentation, customizable color schemes, and plug-ins for error detection. They are crucial tools in a developer’s toolkit. Integrated Development Environments (IDEs) provide additional functionalities like project templates, code compilation, and debugging all within a single interface. While not a full-fledged IDE, Visual Studio Code is a widely-used text editor that provides many IDE-like features, often through extensions. It is well-regarded for being free, open-source, and supported by a strong community and Microsoft.

#### 4.2 Starting a Project

Here is a brief overview of the main steps to start a web development project:

1. Create a Development Folder: Navigate to your file manager or terminal and create a new folder for your new web development project.

2. Open Code Editor: Launch the code edtitor and navigating to the projects directory inside the integrated system explorer of the code editor.

3. Add a File: In the projects' directory add a new file. By convention the homepage of a file is named `index.html`.

4. Begin Coding: Add a boilerplate HTML code to `index.html` like here below. Inside the body content you can start writing the HTML code displayed to the screenSave your file often to prevent losing unsaved work.
   
   ```html
   <html>
     <head>
       <title>Hello World</title>
     </head>
     <body>
       <h1>Hello World</h1>
     </body>
   </html>
   ```

5. View Your HTML File in the Browser:  Navigate to your `index.html` file using your file manager or terminal. Double-click or open the file to view it in your default web browser.

#### 4.3 Browser Development Tool

Chrome DevTools is an essential browser-based toolset for web developers, enabling them to inspect, debug, and prototype changes to a website’s code directly within the browser. To access DevTools, users can right-click on a webpage and select "Inspect" or use a keyboard shortcut. Within DevTools, the "Elements" tab allows users to view and examine the HTML and CSS of a webpage. By selecting elements on the page, developers can see and modify the corresponding code.

###### 4.3.1 Document Object Model

Modifications are made to the DOM (Document Object Model), which is the browser's live interpretation of the website's source code. It is important to note that changes made in the DOM are temporary and do not alter the actual source code. This distinction underscores the DOM's role as a dynamic representation of the code, allowing for immediate experimentation and prototyping. This capability of quickly testing and visualizing changes directly in the browser helps streamline development processes and refine web design efficiently.

#### 4.4 Web Hosting

Hosting involves making your application accessible online by placing it on servers maintained by hosting providers, allowing others to access your app without needing to use your personal computer. Hosting providers manage the infrastructure, enabling users to rent server space without handling technical complexities.

###### 4.4.1 Categories of Hosting

| **Category of Hosting**                | **Description**                                                                                       | **Key Points**                                                                 | **Ideal For**                                  |
| -------------------------------------- | ----------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------ | ---------------------------------------------- |
| **Website Builders**                   | Platforms like Wix and Squarespace allow users to create websites easily without coding.              | - Manages hosting, databases, emails, servers. <br> - No coding required.      | Non-developers, quick website setup            |
| **Shared Web Hosting**                 | Multiple users share the resources of a single server.                                                | - Cost-effective. <br> - Shared resources can affect performance.              | Small to medium-sized websites                 |
| **Dedicated Web Hosting**              | Renting an entire server solely dedicated to your application.                                        | - Better performance and security. <br> - More expensive.                      | High-traffic websites, resource-intensive apps |
| **Cloud Hosting**                      | Run applications in the cloud using a vast network of data centers and computing resources.           | - Scalable and flexible. <br> - Suitable for varying resource needs.           | Scalable applications, resource-varied apps    |
| **Infrastructure as a Service (IaaS)** | Provides access to raw infrastructure (servers, storage, networks) with full control over management. | - User manages everything including OS and application setups.                 | Experienced developers needing control         |
| **Platform as a Service (PaaS)**       | Cloud provider manages servers; user manages only the application.                                    | - Simplifies deployment (e.g., deploy a Node.js app without managing servers). | Developers wanting easy deployment             |
| **Functions as a Service (FaaS)**      | Users provide specific functions; cloud provider handles execution and runtime management.            | - Highly managed service. <br> - Cloud provider manages everything else.       | Event-driven functions, microservices          |

###### 4.4.2 Hosting with GitHub Pages

GitHub is a platform for version control and collaborative coding, where users store and manage their code in online repositories. GitHub Pages is a feature that allows users to host websites directly from these repositories by connecting them to a unique URL. Here's a concise guide to creating a GitHub Page:

1. Log in to GitHub, create a new repository, and name it `username.github.io`, replacing `username` with your GitHub username.

2. Ensure the repository is public and related to your project, then upload your website’s HTML, CSS, and other necessary files.

3. Commit the changes by writing a commit message that describes the updates, typically starting with a verb.

4. Go to the repository settings, navigate to the "GitHub Pages" section, and select the branch where your files are located.

5. GitHub will generate a URL for your site, usually in the format `username.github.io/repository-name`.

6. After processing, your website will be live at the provided URL, ready to be shared and viewed online.

#### 4.5 Domain Name

Computers use numerical IP addresses to communicate, while humans rely on easier-to-remember domain names. A domain name acts as a user-friendly representation of an IP address, essential for setting up a website or email but not the actual site or email itself. Instead, it directs users to the correct online location. Common domain extensions include .com, .org, and .edu, along with country-specific codes like .fr (France) and .cn (China). To avoid typing errors, it's best to keep domain names short and memorable. Unlike web hosting, which stores website content, a domain name simply points to that content.

###### 4.5.1 Domain Name System

The Domain Name System (DNS) translates domain names into IP addresses. When a domain name is typed into a browser, the computer first checks its cache. If the address isn't there, the request moves up through various servers—the resolver, root server, TLD server, and finally the name server—to find the correct IP address. The DNS process involves several levels, starting with the root server, which directs queries to the appropriate top-level domain (TLD) server. The TLD server, in turn, directs the query to the name server, which knows the exact IP address of the domain.

#### 4.6 Wireframes vs Prototypes

###### 4.6.1 Wireframes

Wireframes, or "skeletons," are low-fidelity, static representations of a product's layout, used to communicate structure, content, and functionality in the early stages of design. Resembling architectural blueprints, they use simple shapes, placeholders, and a grayscale palette to outline the basic design without detailed visuals. Wireframes serve as a foundational tool, allowing design teams to plan and test core ideas before adding visual details, thereby reducing the risk of rework. However, they are limited in user testing and can't convey complex interactions, making them ideal for early-stage planning but less effective for illustrating dynamic design elements.

###### 4.6.2 Prototypes

Prototypes are interactive, middle to high-fidelity representations of a product, simulating user interface interactions to explore and refine ideas. Unlike static wireframes, prototypes allow designers and users to experience the flow and usability of an app or website, making them essential for testing and validating design concepts. Prototypes can range from simple, low-fidelity click-throughs to complex, high-fidelity models that closely resemble the final product. They are invaluable for pitching ideas, understanding user needs, and refining usability, though they are not suitable for documentation. Prototyping helps teams identify potential issues early, ensuring a more user-centered final product.

#### 4.7 Turning a Design into a Functional Website

Transforming a website design or idea into a fully functional site involves structuring content on a grid, similar to architectural blueprints. The process starts by organizing sections like the header, navigation, main banner, and footer using HTML and CSS. Key HTML5 tags such as `<header>`, `<nav>`, `<main>`, `<section>`, and `<footer>` help define the layout, while a style guide ensures design consistency. Visual hierarchy, continuity, and clean, organized code are crucial throughout the process. As you gather content and refine your site, be open to experimenting and making adjustments for a cohesive final design.
