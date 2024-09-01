# HTML

## 1. Fundamentals of Web Development

#### 1.1 Languages and Tools for Web Development

Websites consist of two main components: the front-end and the back-end. The front-end is the part users see and interact with in their browsers, involving all the visual and interactive elements of a site. In contrast, the back-end operates behind the scenes, managing data storage in databases and ensuring that the front-end functions smoothly.

Front-end developers primarily use three languages: HTML, CSS, and JavaScript. HTML (Hypertext Markup Language) structures the content of webpages, while CSS (Cascading Style Sheets) styles these elements, making them visually appealing. JavaScript adds interactivity, enabling dynamic user experiences.

To streamline the development process, front-end frameworks and libraries provide reusable code, which speeds up the creation of web applications and reduces repetitive tasks.

#### 1.2 How Web Browsers Access and Display Webpages

When you enter a URL (Uniform Resource Locator) in a web browser, it initiates a process based on the client-server model. The browser acts as the client, requesting resources from a server that stores and provides these resources, such as webpages, images, and videos. This exchange is governed by the HTTP (Hypertext Transfer Protocol), a language used for communication over the internet.

The server processes the request and sends back the required data, typically in the form of an HTML document. As the browser receives this document, it builds a Document Object Model (DOM), a structured representation of the page's content. The browser then retrieves any additional resources, such as images or fonts, often in parallel, and renders the complete webpage for display.

###### 1.2.1 Inspecting Client-Server Requests in Microsoft Edge

You can manually inspect the requests exchanged between a client and server using the Microsoft Edge browser's Developer Tools. By pressing **Ctrl + Shift + I** and navigating to the Network tab, you can view all the requests made when a webpage is loaded. This includes details like the HTTP method, resource type, resource name, host name, and language preferences, providing insight into the communication between the browser and the server.

#### 1.3 Setting Up a Simple HTML Project in VS Code

To start a new web project, follow these steps:

1. **Create a Project Folder**: Begin by creating a new project folder.

2. **Open a Code Editor**: Open your preferred code editor, such as Visual Studio Code (VS Code).

3. **Open the Project Folder**: Use the explorer in VS Code to open the project folder.

4. **Create the HTML File**: Inside the project folder, create a new file named `index.html`. This file typically represents the homepage of a website.

5. **Write the Basic HTML Structure**:
   
   - Start by declaring the document type to indicate that you are working with an HTML5 document:
   
   ```html
   <!DOCTYPE html>
   ```
   
   - Define the structure of the webpage using the `<html></html>` element. Most HTML elements require both an opening and a closing tag:
   
   ```html
   <html>
     <head lang="en">
       <title>Your Page Title</title>
     </head>
     <body>
       <!-- Content that appears on the page goes here -->
     </body>
   </html>
   ```

6. **Preview the Page**:
   
   - You can open the `index.html` file in a live development server. For example, you can use the *Live Server* plugin in VS Code to view your webpage in real time. The URL might look like this:
   
   ```
   http://127.0.0.1:5500/index.html
   ```
   
   - Here:
     - `127.0.0.1` is the IP address representing your local computer.
     - `5500` is the port number on which the web server is running.
     - `index.html` is the name of your HTML file.

7. **Formatting Your Code**: While browsers ignore white spaces and code formatting in HTML and CSS, consistent formatting is crucial for readability and maintenance. You can use the *Prettier* plugin in VS Code to automatically format your code in a consistent style.

#### 1.4 Inspecting the DOM in Microsoft Edge

When a browser receives an HTML document from a server, it constructs a Document Object Model (DOM), which is a structured representation of the webpage's content. To inspect and modify the DOM in Microsoft Edge, follow these steps:

1. **Open Developer Tools**: Press **Ctrl + Shift + I** to open the Developer Tools in Microsoft Edge.

2. **View the DOM**: Navigate to the **Elements** tab to see the DOM structure of the webpage.

3. **Inspect and Edit Styles**: Click on any element within the DOM to view its associated CSS styles in the Styles pane. This pane allows you to make real-time changes and immediately see how they affect the webpage.

By using these tools, you can effectively debug and refine the appearance and structure of your web pages.

#### 1.5 Validating HTML and CSS Code

When encountering issues with a webpage due to typos or errors in the code, validators can help identify and correct these problems. To check your HTML, use the [W3C Markup Validation Service](https://validator.w3.org/), which analyzes your code and provides warnings and error messages to aid in debugging. For CSS code validation, use the [W3C CSS Validator](https://jigsaw.w3.org/css-validator/), which performs a similar analysis to ensure your stylesheets are error-free.

#### 1.6 Workflow for Coding and Deploying a Website

This guide outlines a straightforward process for developing, optimizing, validating, building, and deploying a website, using popular tools and services.

1. **Component-First Styling**: Start by designing and styling individual UI components (like buttons, forms, etc.) in isolation, ensuring they are reusable and modular. Gradually move towards styling broader elements like layouts based on these components.

2. **SEO Optimization**: Modify the `<head>` section of your HTML to include SEO elements such as `<title>` and `<meta>` tags. Implement Open Graph protocol tags for better previews on social media. [Open Graph Protocol Documentation](https://ogp.me/)

3. **Validation**: Use online validation tools to check for HTML and CSS errors to ensure browser compatibility:
   
   - [W3C HTML Validator](https://validator.w3.org/)
   - [W3C CSS Validator](https://jigsaw.w3.org/css-validator/)

4. **Build Preparation**: Use a build tool like [Parcel](https://parceljs.org/) to optimize your website for production. This involves combining and minifying CSS/JS files, and optimizing images. Install Node.js, initialize the project with npm, and use Parcel to build the project and output optimized files to a `dist` directory.

5. **Version Control**: Push your project to [GitHub](https://github.com/), which many hosting services use for deployment.

6. **Deployment**: Use a service like [Netlify](https://www.netlify.com/) to deploy your website. Connect it to your GitHub repository, provide the build command, and specify the `dist` directory as the publish directory. Netlify will handle deployment and provide a URL for your website.

7. **Post-Deployment Optimization**: Analyze your website using tools like [Google PageSpeed Insights](https://pagespeed.web.dev/) to get recommendations on improving performance, accessibility, and overall quality.

## 2. HTML Structure, Hierarchy, and Attributes

#### 2.1 HTML Anatomy

HTML is composed of elements that structure a webpage and define its content. Each element includes an opening tag, the content it contains, and a closing tag. For example, the opening tag `<n>` begins an element, and the closing tag `</n>`, marked by a forward slash, ends it. These elements are the fundamental building blocks of an HTML document.

#### 2.2 HTML Hierarchy

HTML follows a hierarchical structure, similar to a family tree. Elements nested within others are considered "children" of those "parent" elements, creating a multi-level relationship. This hierarchy is important because child elements often inherit behavior and styling from their parent elements, influencing the webpage's appearance. Indentation is commonly used to represent these relationships, making the code more readable.

#### 2.3 Tag Attributes

HTML elements can have attributes added to their opening tags, which enhance functionality or styling. An attribute consists of a name and a value. For example, the `id` attribute uniquely identifies an element, which is particularly useful when the same element type appears multiple times on a page.

## 3. Basic HTML Elements

#### 3.1 The Head Section in an HTML Document

The `<head>` section of an HTML document contains metadata and other essential elements that provide information about the webpage, helping browsers and search engines understand how to process and display the content. This section does not directly affect the visible content on the page but plays a crucial role in defining how the page is rendered and interpreted.

| Element                                                                  | Description                                                                                         |
| ------------------------------------------------------------------------ | --------------------------------------------------------------------------------------------------- |
| `<title></title>`                                                        | Sets the title of the webpage, which appears in the browser tab and as the title in search results. |
| `<meta charset="UTF-8">`                                                 | Defines the character set for the webpage, enabling it to display almost all characters worldwide.  |
| `<meta name="viewport" content="width=device-width, initial-scale=1.0">` | Specifies the viewport settings to ensure the webpage is responsive and looks good on all devices.  |
| `<meta name="keywords" content="word1 word2">`                           | Provides keywords related to the webpage, aiding in search engine optimization (SEO).               |
| `<meta name="description" content="text">`                               | Offers a brief description of the webpage, which may appear in search engine results.               |
| `<link rel="stylesheet" href="styles.css">`                              | Links to an external CSS file, defining the styles for the webpage.                                 |
| `<script src="script.js"></script>`                                      | Links to an external JavaScript file, adding functionality to the webpage.                          |
| `<meta name="author" content="name">`                                    | Specifies the author of the webpage.                                                                |

#### 3.2 Text Elements in an HTML Document

In an HTML document, text elements are used to structure and format the content, helping to create a clear and readable layout. These elements define how text is displayed on a webpage, whether as paragraphs, headings, or emphasized content. Each text element has a specific purpose and contributes to the overall hierarchy and style of the page.

| Element             | Description                                                                                       |
| ------------------- | ------------------------------------------------------------------------------------------------- |
| `<p></p>`           | Defines a paragraph, used to display blocks of text in a standard format.                         |
| `<em></em>`         | Emphasis element that displays text in italics, indicating stress or importance.                  |
| `<strong></strong>` | Strong emphasis element that displays text in bold, signaling strong importance or urgency.       |
| `<h1></h1>`         | Heading element used to create a hierarchy; `<h1>` is the highest level, usually for main titles. |
| `<h2></h2>`         | Subheading element under `<h1>`, used for secondary titles or sections.                           |
| `<h3></h3>`         | Further subheading, typically used for subsections under `<h2>`.                                  |
| `<h4></h4>`         | Subheading used for smaller sections within `<h3>` headings.                                      |
| `<h5></h5>`         | Lower-level subheading, usually for finer detail within `<h4>` sections.                          |
| `<h6></h6>`         | The smallest heading element, often used for the least prominent headings in a document.          |

#### 3.3 HTML Entities

In HTML, certain characters like `<` and `>` are reserved for use in tags, so they require special notation to be displayed as text. These notations are called HTML entities. For example, the less-than sign `<` is written as `&lt;`, the greater-than sign `>` as `&gt;`, and a non-breaking space as `&nbsp;`. There are hundreds of HTML entities available for various symbols and characters, ensuring they are correctly rendered in web browsers. A complete list of these entities can be found [here](https://www.freeformatter.com/html-entities.html).

#### 3.4 Hyperlink Elements in HTML

In HTML, the `<a>` (anchor) element is used to create hyperlinks, allowing users to navigate between different resources on the web. The hyperlink can point to an absolute or relative URL, a specific section within the same webpage, or even initiate an email. The `<a>` element can be further customized using various attributes to define its behavior and provide additional functionality.

| Attribute  | Description                                                                        | Configuration Options                                                                                                        |
| ---------- | ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------- |
| `href`     | Specifies the destination URL of the hyperlink.                                    | Absolute URL (`https://example.com`), Relative URL (`./page.html`), Fragment (`#section`), Email (`mailto:user@example.com`) |
| `alt`      | Provides a description of the hyperlink, often used for accessibility purposes.    | A short, descriptive text (`"Link to homepage"`)                                                                             |
| `target`   | Determines where the linked document will open.                                    | `_blank` (opens in a new tab/window), `_self` (default, opens in the same tab)                                               |
| `download` | Instructs the browser to download the linked resource instead of navigating to it. | A filename can be specified (`download="file.pdf"`)                                                                          |

#### 3.5 Embedding Media Files in HTML

HTML provides specific elements to embed various media types, such as images, audio, and video, directly into a webpage. These elements allow seamless integration of multimedia content, enhancing the user experience with visual and auditory components. Each media element comes with attributes that define its behavior and functionality.

| Element                                                                                      | Description                                                                    | Key Attributes                                                                                                                              |
| -------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------- |
| `<img src="image.jpg" alt="description of image">`                                           | Used to embed an image in a webpage.                                           | `src` (URL of the image), `alt` (text description of the image for accessibility and fallback)                                              |
| `<video src="video.mp4" controls autoplay loop>Your browser does not support videos</video>` | Used to embed a video file. Includes a fallback text for unsupported browsers. | `src` (URL of the video), `controls` (displays video controls), `autoplay` (auto-plays video on load), `loop` (repeats video after it ends) |
| `<audio src="sound.mp3" controls autoplay loop></audio>`                                     | Used to embed an audio file in a webpage.                                      | `src` (URL of the audio), `controls` (displays audio controls), `autoplay` (auto-plays audio on load), `loop` (repeats audio after it ends) |

#### 3.6 Creating Lists in HTML

HTML offers various elements to create lists, allowing you to organize content in both ordered and unordered formats. Lists can be used to present items where the sequence matters or doesn't, and to define terms and their descriptions.

| Element     | Description                                                                                                         |
| ----------- | ------------------------------------------------------------------------------------------------------------------- |
| `<ul></ul>` | Creates an unordered list, where the order of items does not matter. Items are typically marked with bullet points. |
| `<ol></ol>` | Creates an ordered list, where the order of items is important. Items are usually numbered.                         |
| `<li></li>` | Represents an individual item within a list. Can be used within `<ul>`, `<ol>`, or `<dl>`.                          |
| `<dl></dl>` | Defines a description list, used for listing terms and their descriptions.                                          |
| `<dt></dt>` | Represents a term in a description list.                                                                            |
| `<dd></dd>` | Provides the description or definition for the term in a description list.                                          |

```html
<!-- Unordered List -->
<ul>
  <li>Item 1</li>
  <li>Item 2</li>
  <li>Item 3</li>
</ul>

<!-- Ordered List -->
<ol>
  <li>First item</li>
  <li>Second item</li>
  <li>Third item</li>
</ol>

<!-- Description List -->
<dl>
  <dt>HTML</dt>
  <dd>Hypertext Markup Language, the standard for creating web pages.</dd>
  <dt>CSS</dt>
  <dd>Cascading Style Sheets, used for styling HTML documents.</dd>
</dl>
```

#### 3.7 Creating Tables in HTML

HTML provides a set of elements specifically designed for displaying tabular data. These elements allow you to structure data in a grid format, making it easy to organize and present information in rows and columns.

| Element           | Description                                                                            |
| ----------------- | -------------------------------------------------------------------------------------- |
| `<table></table>` | Defines the entire table structure for presenting tabular data.                        |
| `<thead></thead>` | Defines the header section of the table, typically containing column headings.         |
| `<tbody></tbody>` | Defines the body section of the table, where the main data rows are placed.            |
| `<tfoot></tfoot>` | Defines the footer section of the table, often used for summary information or totals. |
| `<tr></tr>`       | Represents a row within the table, containing header or data cells.                    |
| `<td></td>`       | Defines a data cell within a row, containing the actual data.                          |
| `<th></th>`       | Defines a header cell within a row, usually bold and centered by default.              |
| `colspan`         | An attribute that allows a `<th>` or `<td>` element to span across multiple columns.   |
| `rowspan`         | An attribute that allows a `<th>` or `<td>` element to span across multiple rows.      |
| `scope`           | An attribute that defines whether a  `<th>` element is a `row` or `col` header cell.   |

```html
<!-- Start of the table -->
<table border="1">

    <!-- Table Header Section -->
    <thead>
        <tr>
            <th scope="col">Day</th>
            <th scope="col">Event</th>
            <th scope="col">Time</th>
        </tr>
    </thead>

    <!-- Table Body Section -->
    <tbody>
        <tr>
            <th scope="row">Monday</th>
            <td>Meeting with Team</td>
            <td>10:00 AM</td>
        </tr>
        <tr>
            <th scope="row">Tuesday</th>
            <!-- Cell spanning across 2 columns -->
            <td colspan="2">Workshop on HTML</td>
        </tr>
        <tr>
            <th scope="row">Wednesday</th>
            <td>Client Presentation</td>
            <!-- Cell spanning across 2 rows -->
            <td rowspan="2">2:00 PM</td>
        </tr>
        <tr>
            <th scope="row">Thursday</th>
            <td>Team Building Activity</td>
        </tr>
    </tbody>

    <!-- Table Footer Section -->
    <tfoot>
        <tr>
            <td colspan="3">All events are subject to change</td>
        </tr>
    </tfoot>

</table>
```

#### 3.8 Container Elements in HTML

Container elements in HTML are used to group and organize multiple HTML elements within a webpage. These containers help structure the content, making it easier to apply CSS styles and manage layout. By using container elements, developers can create organized and visually consistent web pages.

| Element         | Description                                                                                                                                                              | Default Display Behavior |
| --------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------ |
| `<div></div>`   | A generic container used to group block-level elements. It has no default visual appearance and ensures that the following elements start on a new line.                 | Block-level              |
| `<span></span>` | A generic container used for styling small sections of text or inline elements. It does not disrupt the flow of content and does not take up the full width of the page. | Inline                   |

#### 3.9 Semantic Container Elements in HTML

Semantic container elements in HTML are designed to provide meaningful structure to a webpage, enhancing its readability and accessibility. These elements help search engines and assistive technologies understand the content and its organization. Unlike generic containers, semantic elements convey specific roles and improve the semantic clarity of the HTML document.

| Element                     | Description                                                                                 | Notes                                              |
| --------------------------- | ------------------------------------------------------------------------------------------- | -------------------------------------------------- |
| `<article></article>`       | Represents a self-contained piece of content, such as a blog post or news article.          | Useful for independent content.                    |
| `<figure></figure>`         | Wraps embedded media, like images or videos, and associates them with captions.             | Works with `<figcaption>` to provide descriptions. |
| `<figcaption></figcaption>` | Provides a caption or description for the content inside a `<figure>`.                      | Optional element within `<figure>`.                |
| `<mark></mark>`             | Highlights text with a background color, typically yellow by default.                       | Useful for indicating relevance or importance.     |
| `<time></time>`             | Represents specific time or date information.                                               | Helps convey temporal data in a structured format. |
| `<header></header>`         | Defines the header section of a webpage or section.                                         | Should be used once per webpage or section.        |
| `<main></main>`             | Represents the main content area of a webpage, excluding headers, footers, and sidebars.    | Should be used once per webpage.                   |
| `<footer></footer>`         | Defines the footer section of a webpage or section.                                         | Should be used once per webpage or section.        |
| `<aside></aside>`           | Contains content that is tangentially related to the main content, such as sidebars or ads. | Often used for supplementary information.          |
| `<nav></nav>`               | Represents a navigation section with links to other parts of the website or related pages.  | Helps in organizing navigation menus.              |
| `<section></section>`       | Divides a webpage into thematic sections, often with headings.                              | Useful for grouping related content together.      |


