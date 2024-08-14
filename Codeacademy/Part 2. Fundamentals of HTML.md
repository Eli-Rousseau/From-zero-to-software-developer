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

## 4. Semantic HTML

## 5. Looking for HTML Documentation

The [Mozilla Developer Network (MDN)](https://developer.mozilla.org/en-US/) is a comprehensive, open-source resource for web development documentation, including HTML, CSS, and JavaScript. Initially focused on browser documentation, MDN now covers a wide range of web technologies and is supported by major companies like Microsoft and Google. MDN provides detailed articles on definitions, attributes, usage, examples, accessibility, specifications, browser compatibility, and related topics.
