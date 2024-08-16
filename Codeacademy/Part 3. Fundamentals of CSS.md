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

#### 3.1 The Box Model

The box model comprises the set of properties that define parts of an element that take up space on a web page. The model includes:

- **width and height**: The width and height of the content area.

- **padding**: The amount of space between the content area and the border.

- **border**: The thickness and style of the border surrounding the content area and padding.

- **margin**: The amount of space between the border and the outside edge of the element.

#### 3.2 Width and Height, Padding, Border, and Margin Properties

| **Type**                         | **Description**                                                                                                 | **Example Syntax**              |
| -------------------------------- | --------------------------------------------------------------------------------------------------------------- | ------------------------------- |
| **Width & Height**               | Specifies the dimensions of an element's content area in pixels or percentages.                                 | `width: 300px; height: 200px;`  |
| **Border**                       | Defines the line surrounding an element, with customizable width, style (`none`, `dotted`, `solid`), and color. | `border: 2px solid blue;`       |
| **Border-Radius**                | Rounds the corners of an element's border.                                                                      | `border-radius: 10px;`          |
| **Padding (Single Value)**       | Adds equal space on all sides between the content and the border.                                               | `padding: 20px;`                |
| **Padding (Shorthand 4 Values)** | Specifies padding for all four sides: top, right, bottom, and left, in clockwise order.                         | `padding: 10px 15px 20px 25px;` |
| **Padding (Shorthand 3 Values)** | Sets padding for top, right & left (equal), and bottom.                                                         | `padding: 10px 15px 20px;`      |
| **Padding (Shorthand 2 Values)** | Sets padding for top & bottom (equal), and right & left (equal).                                                | `padding: 10px 20px;`           |
| **Margin (Single Value)**        | Adds equal space on all sides outside the border, separating elements.                                          | `margin: 15px;`                 |
| **Margin (Shorthand 4 Values)**  | Specifies margin for all four sides: top, right, bottom, and left, in clockwise order.                          | `margin: 6px 10px 5px 12px;`    |
| **Margin (Shorthand 3 Values)**  | Sets margin for top, right & left (equal), and bottom.                                                          | `margin: 6px 10px 12px;`        |
| **Margin (Shorthand 2 Values)**  | Sets margin for top & bottom (equal), and right & left (equal).                                                 | `margin: 10px 15px;`            |

###### 3.2.1 Centering Elements

To center an element horizontally within its container using CSS, you can use the `margin: 0 auto;` property. This sets the top and bottom margins to 0 and automatically adjusts the left and right margins, centering the element. However, the element must have a defined width; otherwise, it will expand to the full width of its container, making centering impossible.

```css
div {
  width: 50%;
  margin: 0 auto;
}
```

###### 3.2.2 Marging Collapse

Padding adds space inside an element's border, while margin adds space outside it. A key difference is that vertical (top and bottom) margins collapse, meaning the larger margin sets the space between adjacent elements, while vertical padding does not collapse. Horizontal (left and right) margins, like padding, are always displayed and added together.

###### 3.2.3 Minimum and Maximum Height and Width

CSS offers properties that can limit the range in which the width and height can be sized.

| Property     | Description                            | Example Syntax       |
| ------------ | -------------------------------------- | -------------------- |
| `min-width`  | Sets the minimum width of an element.  | `min-width: 200px;`  |
| `max-width`  | Sets the maximum width of an element.  | `max-width: 800px;`  |
| `min-height` | Sets the minimum height of an element. | `min-height: 150px;` |
| `max-height` | Sets the maximum height of an element. | `max-height: 600px;` |

###### 3.2.4 Managing Overflow in the CSS Box Model

An element's total size consists of content, padding, border, and margin, which can sometimes cause it to exceed its parent container's dimensions. The `overflow` property manages this excess content by setting it to `hidden` (to hide the overflow), `scroll` (to add scrollbars), or `visible` (to display the overflow outside the element, which is the default).

```css
div {
  overflow: scroll;
}
```

#### 3.3 Resetting Browser Defaults

Browsers apply default styles through user agent stylesheets, which often set padding and margin values that can interfere with custom designs. Developers commonly reset these defaults using a universal selector (`*`) to ensure consistent styling across all HTML elements. The following code resets the default margin and padding values to 0, creating a clean slate for further styling:

```css
* {
  margin: 0;
  padding: 0;
}
```

#### 3.4 Controlling Element Visibility

The `visibility` property in CSS can hide or show elements on a webpage without removing their allocated space. It has three main values: `hidden` (hides the element but leaves space), `visible` (displays the element), and `collapse` (collapses an element, typically in tables). Unlike `display: none`, which removes an element entirely from the layout, `visibility: hidden` keeps the element's space intact but makes it invisible.

```css
.element {
  visibility: hidden; /* Hides the element but retains space */
}
```

#### 3.5 Changing the Box Model

In the default CSS box model (`content-box`), padding and border are added to an element's specified width and height, often causing unexpected increases in overall dimensions. For example, a box with a specified width of 300px, padding of 10px, and a 1px border results in a final width of 322px (300px + 10px padding on each side + 1px border on each side). This can complicate layout management and element sizing.

To address this, the `box-sizing` property can be set to `border-box`, which ensures that padding and border are included within the specified width and height, keeping the box dimensions fixed.

```css
* {
  box-sizing: border-box;
}

h1 {
  border: 1px dashed #4f768e;
  height: 150px;
  width: 200px;
  padding: 20px;
}
```

In the example above, the `h1` element maintains its specified width of 200px and height of 150px, with padding and borders contained within these dimensions. This makes the `border-box` model more predictable and easier to manage in complex layouts.

#### 3.6 Reset CSS Styling

To override default browser styles, developers often use a separate reset stylesheet to standardize CSS across different browsers. This approach involves writing new rules to replace or modify user agent styles, such as changing the `box-sizing` property to `border-box`. A well-known example of a reset stylesheet is available at [Eric Meyer’s CSS Reset](https://meyerweb.com/eric/tools/css/reset/). Implementing a reset stylesheet helps ensure consistent styling and simplifies development by neutralizing browser defaults.

## 4. Display and Positioning

#### 4.1 Flow of Elements

In HTML, elements are rendered by the browser from left to right and top to bottom, following their order in the document. This natural order is called the flow of elements. By default, block-level elements occupy the full width of their parent containers and prevent other elements from sharing the same horizontal space. CSS allows developers to modify this flow by adjusting the `position` property, which can take values like `static` (the default), `relative`, `absolute`, `fixed`, and `sticky`. If the default position is preferred, there's no need to explicitly set the `position` property.

#### 4.2 Positioning in CSS

###### 4.2.1 Controling Relative Positioning

Setting an element's `position` property to `relative` allows it to be positioned relative to its default location on the page. This can be adjusted using offset properties: `top`, `bottom`, `left`, and `right`. These offsets move the element away from its original position, with values specified in units like pixels, ems, or percentages.

```css
div {
  position: relative;
  top: 20px;
  left: 10px;
}
```

###### 4.2.2 Controlling Absolute Positioning

Setting an element's `position` property to `absolute` removes it from the normal document flow, causing other elements to ignore it. The element is positioned relative to its closest positioned (non-static) parent, and its position can be adjusted using `top`, `bottom`, `left`, and `right` offsets.

```css
div {
  position: absolute;
  top: 50px;
  right: 20px;
}
```

###### 4.2.3 Fixed Positioning

By setting an element's `position` property to `fixed`, the element is anchored to a specific position on the page, independent of user scrolling. The element's position can be further adjusted using `top`, `bottom`, `left`, and `right` offsets.

```css
header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
}
```

###### 4.2.4 Sticky Positioning

The `position: sticky` value allows an element to remain in the document flow as the user scrolls, but "sticks" to a specified position once a certain point is reached. This behavior is controlled using the offset properties `top`, `bottom`, `left`, and `right`.

```css
nav {
  position: sticky;
  top: 10px;
}
```

###### 4.2.5 Managing Overlapping Elements

When elements on a webpage overlap due to different position values, the `z-index` property determines the stacking order of these elements, controlling which elements appear in front or behind others. The `z-index` accepts integer values, where higher values bring elements closer to the foreground, and lower values push them further into the background.

```css
.box1 {
  position: absolute;
  z-index: 10;
}

.box2 {
  position: absolute;
  z-index: 5;
}
```

#### 4.3 Display

###### 4.3.1 Inline Display

HTML elements have a default `display` value that determines how they share horizontal space with other elements. Inline elements, like `<em>`, `<strong>`, and `<a>`, only occupy the space necessary for their content and don't force a new line. Unlike block elements, their height and width cannot be adjusted using CSS. The `display` property can be used to change any element, even those that are not inline by default, into an inline element.

```css
p {
  display: inline;
}
```

###### 4.3.2 Block Display

Block-level elements, such as headings (`<h1>` to `<h6>`), paragraphs (`<p>`), and divisions (`<div>`), do not display on the same line as surrounding content. By default, they fill the entire width of the page, although their width can be adjusted using CSS. These elements automatically take up their own line, preventing other content from appearing alongside them.

```css
div {
  width: 50%;
}
```

###### 4.3.3 Inline-Block Display

The `inline-block` value for the `display` property allows elements to appear next to each other like inline elements, while also enabling the specification of their width and height like block elements. This combination makes `inline-block` versatile for layout designs.

```css
span {
  display: inline-block;
  width: 100px;
  height: 50px;
}
```

###### 4.3.4 Float Property

The `float` property in CSS moves an element as far left or right as possible within its container, commonly used for wrapping text around images. The property can be set to `left` or `right`, and it works with both static and relative positioned elements. To ensure proper functionality, the floated element must have a specified width; otherwise, it will default to the full width of its container.

```css
img {
  float: right;
  width: 200px;
}
```

###### 4.3.5 Managing Floated Elements

When using the `float` property to position multiple elements, different heights can cause layout issues where elements overlap or "bump" into each other. The `clear` property helps manage these situations by controlling how elements interact with floated elements. It can be set to `left` to prevent touching floated elements on the left, `right` to avoid touching on the right, `both` to avoid touching on either side, or `none` to allow touching on either side.

```css
.clearfix {
  clear: both;
}
```
