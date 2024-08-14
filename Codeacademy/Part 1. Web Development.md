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
