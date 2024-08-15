# Part 2. Fundamentals of HTML

## 1. Introduction to HTML

#### 1.1 Introduction to HTML

HTML, or HyperText Markup Language, is the essential language for structuring web pages, making it a fundamental skill for developers, marketers, and designers. It organizes various types of content, such as text, images, and videos, allowing computers to correctly interpret and display them. HTML uses a markup language to structure raw text, while HyperText allows for linking between different pieces of content through hyperlinks.

#### 1.2 HTML Anatomy

HTML is made up of elements that structure a webpage and define its content. Each element consists of tags that enclose the content. An HTML element includes an opening tag, the content it contains, and a closing tag. The opening tag`<n>` starts the element, while the closing tag `</n>`, marked by a forward slash, ends it. These tags and the content they enclose form the building blocks of an HTML document.

#### 1.3 HTML Hierarchy

HTML is structured as a hierarchy, similar to a family tree, where elements nested inside others are considered "children" of those "parent" elements. This hierarchical relationship extends to multiple levels, such as grandchildren and beyond. Understanding this hierarchy is crucial because child elements can inherit behavior and styling from their parent elements, affecting how the content is displayed. Indentation is often used to improve readability by visually representing these nested relationships.

#### 1.4 Tag Attributes

Attributes in HTML are added to an element's opening tag to expand its functionality, providing additional information or altering its styling. An attribute consists of a name and a value. One frequently used attribute is `id`, which helps uniquely identify and differentiate elements, especially when the same element type appears multiple times on a page.

```html
<div id="identifier">
    ...
</div>
```

#### 1.4 Basic HTML Elements

The table provides an overview of some commonly used HTML elements:

| **HTML Element** | **General Syntax**                      | **Purpose**                                                             | **Common Attributes**                | **Attribute Purpose**                                      |
| ---------------- | --------------------------------------- | ----------------------------------------------------------------------- | ------------------------------------ | ---------------------------------------------------------- |
| `<body>`         | `<body>... </body>`                     | Contains the main content to be displayed on the screen                 | N/A                                  | N/A                                                        |
| `<h1> to <h6>`   | `<h1>...</h1>` to `<h6>...</h6>`        | Defines headings, with `<h1>` as the largest and `<h6>` as the smallest | N/A                                  | N/A                                                        |
| `<div>`          | `<div>...</div>`                        | Divides the page into sections, useful for grouping elements            | `id`, `class`                        | Uniquely identifies a section, groups elements for styling |
| `<p>`            | `<p>...</p>`                            | Contains a block of plain text                                          | `id`, `class`                        | Identifies or styles paragraphs                            |
| `<span>`         | `<span>...</span>`                      | Contains short inline text or other HTML elements                       | `id`, `class`                        | Targets specific inline content for styling                |
| `<em>`           | `<em>...</em>`                          | Emphasizes text (usually italicized)                                    | N/A                                  | N/A                                                        |
| `<strong>`       | `<strong>...</strong>`                  | Highlights important text (usually bolded)                              | N/A                                  | N/A                                                        |
| `<br>`           | `<br>`                                  | Inserts a line break                                                    | N/A                                  | N/A                                                        |
| `<ul>`           | `<ul> <li>...</li> </ul>`               | Creates an unordered (bulleted) list                                    | N/A                                  | N/A                                                        |
| `<ol>`           | `<ol> <li>...</li> </ol>`               | Creates an ordered (numbered) list                                      | N/A                                  | N/A                                                        |
| `<img>`          | `<img src="..." alt="..."/>`            | Embeds an image                                                         | `src`, `alt`, `width`, `height`      | Specifies image source, alternative text, size             |
| `<video>`        | `<video src="..." controls>...</video>` | Embeds a video with playback controls                                   | `src`, `controls`, `width`, `height` | Specifies video source, adds playback controls, size       |

## 2. Structure HTML Page

#### 2.1 Setting Up an HTML File

To correctly set up an HTML file, follow these key steps:

1. **Start with the Document Type Declaration**: The first line in your HTML document should be `<!DOCTYPE html>`. This tells the browser that you're using HTML5, the current standard.

2. **Include the `<html>` Tags**: After the `<!DOCTYPE html>` declaration, enclose your HTML content within opening and closing `<html>` tags.

3. **Add the `<head>` Element**: Inside the `<html>` tags, the `<head>` element comes first. It contains metadata about the webpage, such as the title, which is not directly displayed on the page.

4. **Specify the Page Title**: Inside the `<head>` element, use the `<title>` tag to set the title of the webpage, which will appear on the browser tab.

5. **Save with the Correct Extension**: Always save your HTML file with a `.html` extension to ensure it's recognized as an HTML document by browsers.

```html
<!DOCTYPE html>
<html>
    <head>
        <title>This is the headers' title</title>
    </head>

    <!-- html page body ... -->

</html>
```

#### 2.2 Adding Hyperlinks in HTML

Hyperlinks are a fundamental aspect of HTML, allowing users to navigate between web pages or sections of a website.

###### 2.2.1 Basic Hyperlinks

To create a basic link in HTML, use the anchor element `<a>`. The text of the link is placed between the opening and closing `<a>` tags, and the `href` attribute is used to specify the destination URL.

```html
<a href="https://www.wikipedia.org/">This Is A Link To Wikipedia</a>
```

###### 2.2.2 Opening Links in a New Tab

When linking to external websites, you may want the link to open in a new browser tab. This can be achieved using the `target` attribute with a value of `_blank`.

```html
<a href="https://www.wikipedia.org/" target="_blank">Open Wikipedia in a New Tab</a>
```

###### 2.2.3 Linking to Internal Pages

For multi-page websites, it's common to link to other pages within the same site. If the HTML files are stored in the same directory, you can use a relative path to create these links.

```html
<a href="./other_page.html">Contact</a>
```

###### 2.2.4 Turning Elements into Links

HTML allows any element, such as images or buttons, to be turned into a link by wrapping it in an `<a>` tag.

```html
<a href="https://www.wikipedia.org/">
    <img src="image.jpg" alt="Example Image">
</a>
```

###### 2.2.5 Linking to Sections within the Same Page

To create links that scroll to a specific section on the same page, use the `id` attribute on the target element and link to it with a `#` followed by the `id`.

```html
<a href="#section1">Go to Section 1</a>

<h2 id="section1">Section 1</h2>
```

#### 2.3 Using Whitespaces and Identation in HTML

To enhance HTML code readability, developers use **whitespace** and **indentation**. Whitespace, such as line breaks and spaces, helps organize code without affecting content display. For example, placing each element on a new line makes the code easier to read:

```html
<body>
    <p>Paragraph 1</p>
    <p>Paragraph 2</p>
</body>
```

Indentation, typically two spaces per level, visually represents nested elements and clarifies the structure. This formatting practice is crucial for keeping code manageable and understandable.

#### 2.4 Using Comments in HTML

HTML files support comments, which start with `<!--` and end with `-->`. Comments are not displayed in the browser and are used to annotate code for future reference. They help clarify the purpose of code sections and enable experimentation by temporarily "commenting out" code without deleting it. This practice aids in maintaining and revisiting code later.

#### 2.5 Handling and Validating HTML Errors

When coding in HTML, errors can occur, but unlike other programming languages, HTML is parsed permissively by browsers, meaning that even if there are syntax issues, the page will still display, though possibly not as intended. Browsers have built-in rules to handle incorrect markup, but for a clearer understanding of how your HTML is being rendered and to fix errors, using a DOM inspector integrated in the web browser is helpful. For larger or more complex HTML documents, it is best to use the [Markup Validation Service](https://validator.w3.org/) from the W3C. This tool validates HTML by analyzing the code and providing a report on any issues, helping ensure that your HTML is well-formed and compliant with web standards.

## 3. Tables

#### 3.1 Table Elements

The table summarizes the syntax and attributes related to creating and structuring tables in HTML.

| **HTML Element** | **Purpose**                                      | **Common Attributes** | **Attribute Purpose**                                                                       |
| ---------------- | ------------------------------------------------ | --------------------- | ------------------------------------------------------------------------------------------- |
| `<table>`        | Contains all the tabular data                    | None                  | N/A                                                                                         |
| `<tr>`           | Defines a row in the table                       | None                  | N/A                                                                                         |
| `<td>`           | Defines a cell within a table row                | `colspan`, `rowspan`  | `colspan`: Number of columns to span across <br> `rowspan`: Number of rows to span across   |
| `<th>`           | Defines a header cell (title) within a table row | `scope`               | `scope="col"`: Specifies header for a column <br> `scope="row"`: Specifies header for a row |
| `<thead>`        | Sections off the table’s header                  | None                  | N/A                                                                                         |
| `<tbody>`        | Sections off the body of the table               | None                  | N/A                                                                                         |
| `<tfoot>`        | Sections off the bottom part of the table        | None                  | N/A                                                                                         |

#### 3.2 Table Structure

Below is an example of an HTML table that uses all the elements described.

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

## 4. Semantic HTML

#### 4.1 The Importance of Semantic HTML

Semantic HTML involves using HTML elements that convey the meaning and structure of the content, rather than just focusing on presentation. Elements like `<header>`, `<article>`, and `<footer>` provide context, improving web accessibility by helping screen readers and browsers interpret the content better. This practice also enhances SEO by aiding search engines in indexing and prioritizing content, and it makes the code more readable and understandable for developers, leading to more organized and meaningful web pages.

#### 4.2 Semenantic Elements

###### 4.2.1 Header

The `<header>` element serves as a container for introductory content or navigational links, such as headings (`<h1>` to `<h6>`) and navigation menus. It is typically placed at the top of the `<body>` section or within specific sections like `<article>` or `<section>`. This element enhances the organization and accessibility of a webpage by grouping relevant introductory content together. 

```html
<header>
  <h1>Welcome to My Website</h1>
  <nav>
    <ul>
      <li><a href="#home">Home</a></li>
      <li><a href="#about">About</a></li>
      <li><a href="#contact">Contact</a></li>
    </ul>
  </nav>
</header>
```

###### 4.2.2 Nav

The `<nav>` element defines a section dedicated to navigational links, making it easier for users to find their way around the website. It is often used within the `<header>` element but can also appear independently in other sections of the document. The `<nav>` tag helps in organizing navigation links in a way that improves the structure and usability of the page.

```html
<nav>
  <ul>
    <li><a href="#home">Home</a></li>
    <li><a href="#services">Services</a></li>
    <li><a href="#contact">Contact</a></li>
  </ul>
</nav>
```

###### 4.2.3 Main

The `<main>` element is used to encapsulate the primary content of a webpage, distinguishing it from other parts like navigation and footer. It is placed directly within the `<body>` section and should only appear once per page. This element emphasizes the central content, making it easier for screen readers and search engines to understand the main focus of the page.

```html
<main>
  <h1>Main Content Area</h1>
  <p>This is where the core content of the page goes.</p>
</main>
```

###### 4.2.4 Footer

The `<footer>` element contains information typically found at the end of a page, such as copyright details, contact information, or links to related documents. It is usually positioned at the bottom of the `<body>` section, separate from the `<main>` element. The `<footer>` tag helps in structuring the page by grouping relevant end-of-page information together.

```html
<footer>
  <p>© 2024 My Website. All rights reserved.</p>
  <p><a href="#top">Back to top</a></p>
</footer>
```

###### 4.2.5 Section

The `<section>` element groups related content into thematic areas, such as chapters or sections of an article. It can be used within `<article>` or independently in the `<body>` section to organize content into logical blocks. This element improves the structure and readability of the document by segmenting it into meaningful parts.

```html
<section>
  <h2>Introduction</h2>
  <p>This section provides an overview of the topic.</p>
</section>
```

###### 4.2.6 Article

The `<article>` element is used for standalone content that could be distributed independently, such as news articles or blog posts. It is often used within the `<main>` element or as a standalone block to define self-contained pieces of content. The `<article>` tag enhances the document’s structure by defining distinct content blocks.

```html
<article>
  <h2>Breaking News</h2>
  <p>Details about the latest breaking news story.</p>
</article>
```

###### 4.2.7 Aside

The `<aside>` element offers supplementary content that complements but isn't crucial to the main content, such as sidebars or related links. It is commonly used alongside `<article>` or `<section>` to provide additional context or information. This element helps in organizing related, but secondary content that enhances the primary material.

```html
<aside>
  <h3>Related Articles</h3>
  <ul>
    <li><a href="#">Article 1</a></li>
    <li><a href="#">Article 2</a></li>
  </ul>
</aside>
```

###### 4.2.8 Figure and Figcaption

The `<figure>` element groups media content, such as images or diagrams, and includes the `<figcaption>` element for descriptive text. The `<figcaption>` element provides a caption or description for the media within the `<figure>`, ensuring that the media and its description stay together even if the layout changes. This semantic grouping improves accessibility and content clarity.

```html
<figure>
  <img src="example.jpg" alt="An example image">
  <figcaption>An example of a caption for the image.</figcaption>
</figure>
```

###### 4.2.9 Audio

The `<audio>` element embeds audio content into a webpage and includes the `controls` and `autoplay`attributes for built-in playback controls like play and mute. The `<source>` element within `<audio>` specifies the audio file's location and type, ensuring proper playback across different browsers. This setup facilitates seamless integration of audio content with user control options.

```html
<audio controls autoplay>
  <source src="audio/mp3" type="audio/mpeg">
  Your browser does not support the audio element.
</audio>
```

###### 4.2.9 Video

The `<video>` element embeds video content and supports attributes like `controls`, `autoplay`, and `loop` to manage playback options. The `controls` attribute provides built-in controls for video playback, while `autoplay` starts the video automatically, and `loop` makes the video replay continuously. This element is crucial for integrating video content with customizable playback options.

```html
<video controls autoplay loop>
  <source src="video.mp4" type="video/mp4">
  Your browser does not support the video element.
</video>
```

#### 4.3 Structure of Semantic Elements

Here is a schematic representation of a potential hierarchical organization for semantic elements in an HTML file:

```
<html>
  <head>
    <!-- Metadata, title, and links to stylesheets -->
  </head>
  <body>
    <header>
      <!-- Site header with navigation -->
    </header>

    <main>
      <section>
        <!-- Primary content section -->
        <article>
          <!-- Standalone content -->
        </article>
        <aside>
          <!-- Supplementary content -->
        </aside>
      </section>
      <section>
        <!-- Another section of primary content -->
      </section>
    </main>

    <footer>
      <!-- Site footer with additional information -->
    </footer>
  </body>
</html>
```

## 5. Looking for HTML Documentation

The [Mozilla Developer Network (MDN)](https://developer.mozilla.org/en-US/) is a comprehensive, open-source resource for web development documentation, including HTML, CSS, and JavaScript. Initially focused on browser documentation, MDN now covers a wide range of web technologies and is supported by major companies like Microsoft and Google. MDN provides detailed articles on definitions, attributes, usage, examples, accessibility, specifications, browser compatibility, and related topics.
