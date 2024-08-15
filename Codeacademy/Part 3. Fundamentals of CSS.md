# Part 3.Fundamentals of CSS

## 1. Introduction to CSS

#### 1.1 Importance of CSS for Web Development

HTML provides the basic structure of a webpage, but CSS (Cascading Style Sheets) is the language used by web developers to style and enhance the visual appearance of that content. CSS allows you to modify colors, fonts, images, and element positioning, transforming plain HTML into an appealing and well-designed webpage.

#### 1.2 CSS Architecture

CSS can adopts two different written styles that will have slight different archictures: ruleset or inline style.

###### 1.2.1 Ruleset Terms

A CSS ruleset consists of a "selector" that targets the HTML element to be styled, followed by a "declaration block" enclosed in curly braces. Inside the declaration block, each "declaration" pairs a "property," which specifies the visual characteristic to be modified, with a corresponding "value" that defines the desired change. For example, in the ruleset `p { color: blue; }`, the selector `p` targets all `<p>` elements, the property `color` specifies the text color, and the value `blue` defines the color applied to the text.

```css
p {
  color: blue;
}
```

###### 1.2.2 Inline Style Terms

An inline style applies CSS directly within an HTML element's opening tag using the "style" attribute. The style attribute contains one or more "declarations," each consisting of a "property" that specifies the visual characteristic to modify and a "value" that defines the desired change. For example, in `<p style="color: red;">`, the `style` attribute modifies the text color of the `<p>` element, with the property `color` set to the value `red`.

```html
<p style="color: red; font-size: 20px;">This text is red.</p>
```

If you’d like to add more than one style with inline styles, simply keep adding to the `style` attribute. Make sure to end the styles with a semicolon (`;`).

#### 1.3 Internal Stylesheet

An internal stylesheet allows you to write CSS code within the `<style>` element, which is placed inside the `<head>` section of an HTML document. This method centralizes your CSS, making it easier to manage styles for multiple elements compared to inline styles. For example, to change the text color of all `<p>` elements to green, you would add the following inside the `<head>`:

```html
<head>
  <style>
    p {
      color: green;
    }
  </style>
</head>
```

#### 1.4 External Stylesheet

To maintain clean and organized code, developers store HTML and CSS in separate files, with HTML files containing only HTML and CSS files using the `.css` extension. An external stylesheet allows for comprehensive styling without cluttering the HTML file. To apply the styles, the HTML file must link to the CSS file using the `<link>` element in the `<head>`, specifying the `href` attribute for the CSS file path and `rel` as "stylesheet." For example:

```html
<head>
  <link rel="stylesheet" href="styles.css">
</head>
```

## 2. Selectors and Visual Rules

#### 2.1 Selectors

###### 2.1.1 Type, Class, ID, and Attribute Selectors

Here's a summary table of the different CSS selectors:

| **Selector Type**        | **Explanation**                                                                                                                                       | **Example Syntax**                         |
| ------------------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------ |
| **Type**                 | Targets HTML elements by their tag name. This applies styles to all elements of a given type.                                                         | `p { color: blue; }`                       |
| **Universal**            | Targets all elements on a page, useful for applying global styles like resets or broad changes.                                                       | `* { border: 1px solid black; }`           |
| **Class**                | Targets elements with a specific `class` attribute, allowing the same style to be applied to multiple elements.                                       | `.highlight { background-color: yellow; }` |
| **ID**                   | Targets a single, unique element with a specific `id` attribute. IDs are unique and should only be used once per page.                                | `#header { font-size: 24px; color: red; }` |
| **Attribute**            | Targets elements based on the presence or value of an attribute. Useful for applying styles to elements with specific attributes or attribute values. | `[src] { color: magenta; }`                |
| **Attribute with Value** | Further refines the attribute selector to target elements whose attribute contains a specific value.                                                  | `img[src*='winter'] { height: 50px; }`     |

Here’s a reformulation of the different techniques applied to CSS selectors, presented in short sections with example code:

###### 2.1.2 Specificity

Specificity determines how the browser prioritizes different CSS rules. Start with the least specific selectors (type selectors), then move to classes, and finally IDs. Excessive use of IDs can make CSS difficult to manage because they are the most specific and hard to override. 

```css
/* Type selector */
p {
  font-size: 16px;
}

/* Class selector */
.text-large {
  font-size: 20px;
}

/* ID selector */
#intro {
  font-size: 24px;
}
```

###### 2.1.3 Multiple Classes

Multiple classes can be applied to a single HTML element to combine styles. This allows for flexible styling without needing unique classes for every style combination.

```html
<button class="btn primary">Click me</button>
```

```css
.btn {
  padding: 10px;
  border: none;
}

.primary {
  background-color: blue;
  color: white;
}
```

###### 2.1.4 Pseudo-Classes

Pseudo-classes style elements based on their state or user interactions. They are written with a colon (`:`) followed by the pseudo-class name, allowing for dynamic visual changes.

Here are some of the common pseudo classes:

| Pseudo-Class | Description                                                        |
| ------------ | ------------------------------------------------------------------ |
| `:focus`     | Applies to an element when it is focused.                          |
| `:visited`   | Applies to links that have been visited.                           |
| `:disabled`  | Applies to disabled form elements.                                 |
| `:active`    | Applies to an element while it is being activated (e.g., clicked). |
| `:hover`     | Applies to an element that is being hovered on by the mouse.       |

```css
/* Change the background color when hovering over a paragraph */
p:hover { 
    background-color: lime;
}
```

###### 2.1.5 Chaining Selectors

Chaining selectors allows you to target elements that match multiple selectors at the same time, making your CSS more specific.

```css
/* Style only <p> elements with the class 'highlight' */
p.highlight {
  color: blue;
  font-weight: bold;
}
```

###### 2.1.6 Descendant Combinator

The descendant combinator allows you to style elements that are nested within other elements. This is useful for applying styles to elements based on their hierarchical structure in the HTML.

```css
/* Style <li> elements within a <ul> with the class 'main-list' */
.main-list li {
  color: green;
}
```

###### 2.1.7 Multiple Selectors

Multiple selectors can be grouped together to apply the same styles to different elements, making the CSS more concise and easier to manage.

```css
/* Apply the same color to both <h1> and <h2> elements */
h1, h2 {
  color: red;
}
```

#### 2.2 Visual Roles

###### 2.2.1 Text Properties

This table provides a clear and concise overview of how to use each CSS property to control text appearance on a web page.

| **Property**  | **Description**                                                                                                   | **Example Syntax**    |
| ------------- | ----------------------------------------------------------------------------------------------------------------- | --------------------- |
| `font-family` | Specifies the typeface or font family used to display text. Enclose multi-word font names in quotes.              | `font-family: Arial;` |
| `font-size`   | Adjusts the size of text to highlight or differentiate content.                                                   | `font-size: 16px;`    |
| `font-weight` | Controls the boldness or thickness of text. `bold` makes text bold, while `normal` returns it to standard weight. | `font-weight: bold;`  |
| `text-align`  | Aligns text within its parent element. Options include `left`, `center`, `right`, and `justify`.                  | `text-align: center;` |

###### 2.2.2 Color Properties

This table includes properties for setting text color, background color, and transparency effects.

| **Property**       | **Description**                                                                          | **Example Syntax**          |
| ------------------ | ---------------------------------------------------------------------------------------- | --------------------------- |
| `color`            | Styles the foreground color of an element.                                               | `color: blue;`              |
| `background-color` | Styles the background color of an element.                                               | `background-color: yellow;` |
| `opacity`          | Controls the transparency of an element, from 0 (fully transparent) to 1 (fully opaque). | `opacity: 0.5;`             |

###### 2.2.3 Background Image

CSS allows you to set an element's background to an image using the `background-image` property, where you specify the image's URL.

```css
element {
  background-image: url('images/background.jpg');
}
```

###### 2.2.4 Force Style Declaration

The `!important` rule in CSS forces a style to override all other declarations, regardless of their specificity, and should be used sparingly due to its high priority and difficulty to override.

```css
element {
  color: red !important;
}
```

## 3. The Box Model

## 4. Display and Positioning
