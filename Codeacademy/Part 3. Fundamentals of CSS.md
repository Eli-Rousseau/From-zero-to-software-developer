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

## 5. Colors

CSS offers various ways to specify colors, including named colors like blue and limegreen, and numeric systems such as RGB and HSL. Named colors use English words, while RGB and HSL provide more precise control by describing colors through numeric values for red, green, blue, hue, saturation, and lightness. This flexibility allows for a broad range of color options in web design.

#### 5.1 Foreground and Background

In CSS, color influences various design elements, primarily styled using the `color` property for an element's text and foreground, and the `background-color` property for its background. These properties enable precise control over the visual presentation of web elements.

```css
h1 {
  color: white; /* Sets the text color to white */
  background-color: black; /* Sets the background color to black */
}
```

#### 5.2 Hex and RGB

Colors in web design can be specified using two primary syntaxes: hexadecimal and RGB. The hexadecimal color system uses a hash character (#) followed by six alphanumeric characters in a hexadecimal format (`0-9A-F`). These characters define the intensity of red, green, and blue colors. For instance, black is represented as `#000000`, and white is represented as `#FFFFFF`. Each pair of characters or single character (in the three-character format) corresponds to a value for one of the color components.

```css
.container {
    background-color: #FF5733;
}
```

In contrast, the RGB color system specifies colors using decimal numbers ranging from 0 to 255 for each color component. The format is `rgb(red, green, blue)`, where each number represents the intensity of red, green, and blue respectively. For example, black in RGB format is `rgb(0, 0, 0)`, and white is `rgb(255, 255, 255)`. 

```css
.container {
    background-color: rgb(255, 87, 51);
}
```

Both systems allow for a total of 16,777,216 possible colors, as each of the three color components can have 256 different values.

#### 5.3 HSL Color System

The HSL (Hue, Saturation, Lightness) color system in CSS is a powerful method for defining colors, where hue specifies the color angle on a wheel (0-360 degrees), saturation controls the color's intensity (0-100%), and lightness adjusts the color's brightness (0-100%). This system allows for precise color adjustments by varying these three parameters.

```css
p {
  color: hsl(120, 100%, 50%); /* Sets the text color to a pure green */
  background-color: hsl(240, 100%, 50%); /* Sets the background color to a pure blue */
}
```

#### 5.4 Opacity

In CSS, you can adjust color transparency using the `hsla` and `rgba` functions, where the additional alpha (opacity) value controls the transparency level. For `hsla`, the alpha value ranges from 0 (fully transparent) to 1 (fully opaque), and it is added as the fourth parameter after the hue, saturation, and lightness values. Similarly, `rgba` extends the RGB color system with an alpha value for transparency.

```css
.container1 {
  background-color: hsla(120, 100%, 50%, 0.5); /* Semi-transparent green */
}

.container2 {
  color: rgba(255, 0, 0, 0.3); /* Semi-transparent red text */
}
```

## 6. Typography

#### 6.1 Font Selection and Font Stacks

To change an element's font in CSS, the `font-family` property is used. When specifying multi-word typefaces like 'Times New Roman,' enclose the name in quotation marks to ensure proper recognition. Web-safe fonts, which display consistently across different browsers and operating systems, serve as reliable fallback options when your preferred font isn't available. A collection of fonts listed in order of preference is known as a font stack. Font stacks often include both serif fonts, which have decorative details on the ends of letters, and sans-serif fonts, which lack these details. The keywords `serif` and `sans-serif` can be added at the end of a font stack as a final fallback.

```css
p {
  font-family: 'Times New Roman', Georgia, serif;
}
```

###### 6.1.1 Web Fonts

Web fonts offer limitless options for customizing your website's typography, allowing you to choose from a variety of fonts hosted online or by using downloadable font files. Free services like Google Fonts and Adobe Fonts provide easy access to fonts through a `<link>` element in your HTML. For paid fonts, you can host the files yourself and use the `@font-face` rule in your CSS. Google Fonts simplifies the process by generating a `<link>` element for the selected font, which you add to your HTML's `<head>` section before using the font in your CSS.

```html
<head>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap" rel="stylesheet">
</head>

<style>
  body {
    font-family: 'Roboto', sans-serif;
  }
</style>
```

The `@font-face` rule in CSS allows you to embed custom fonts directly into your stylesheet without needing a `<link>` element in your HTML. This method supports various font file formats like OTF, TTF, WOFF, and WOFF2, ensuring compatibility across different browsers. By defining a `@font-face` ruleset, you specify the font's name using the `font-family` property and provide the font files' relative paths using the `src` property. The browser will attempt to load the font in the order specified, starting with the most progressive format. Once defined, you can apply the custom font using the `font-family` property in your CSS.

```css
@font-face {
  font-family: 'MyParagraphFont';
  src: url('fonts/Roboto.woff2') format('woff2'),
       url('fonts/Roboto.woff') format('woff'),
       url('fonts/Roboto.ttf') format('truetype');
}

p {
  font-family: 'MyParagraphFont', sans-serif;
}
```

#### 6.2 Text Boldness

The `font-weight` property in CSS determines the boldness or thinness of text and can be set using either keywords or numerical values. Common keyword values include `normal` (default), `bold`, `lighter` (lighter than the parent element's weight), and `bolder` (bolder than the parent element's weight). Numerical values range from 1 (lightest) to 1000 (boldest), typically used in increments of 100. A value of 400 corresponds to `normal`, while 700 equals `bold`. However, not all fonts support numeric weights or every increment.

```css
h1 {
  font-weight: 700; /* Equivalent to 'bold' */
}

p {
  font-weight: lighter;
}
```

#### 6.3 Italics

The `font-style` property in CSS allows you to italicize text by setting its value to `italic`. The default value is `normal`, which displays text without any italics.

```css
em {
  font-style: italic;
}
```

#### 6.4 Text Case

The `text-transform` property in CSS allows you to change the case of text. Setting it to `uppercase` converts all text to uppercase, while `lowercase` formats all text in lowercase, regardless of the original case used in the HTML code.

```css
h1 {
  text-transform: uppercase;
}

p {
  text-transform: lowercase;
}
```

#### 6.5 Text Styling

###### 6.5.1 Character Spacing

The `letter-spacing` property in CSS sets the horizontal spacing between characters in an element, which can improve readability for certain fonts or styles. This property accepts length values in units like pixels (`px`) or ems (`em`).

```css
h1 {
  letter-spacing: 2px;
}
```

###### 6.5.2 Word Spacing

The `word-spacing` property in CSS controls the space between words in an element. Although not commonly adjusted, increasing word spacing can enhance readability, especially in bold or large text. It accepts length values such as pixels (`px`) or ems (`em`).

```css
h2 {
  word-spacing: 0.2em;
}
```

###### 6.5.3 Line Height

The `line-height` property in CSS sets the height of each line of text within an element. It can be defined using a unitless number, which scales with the font size, or with fixed length values like pixels (`px`), percentages (`%`), or ems (`em`). Unitless values are often preferred for responsiveness. Changing the font size will automatically readjust the line height.

```css
p {
  line-height: 1.5; /* Unitless for responsive design */
}
```

###### 6.5.4 Aligning Text

The `text-align` property in CSS aligns text within its parent element. Common values include `left`, `right`, `center`, and `justify`, each controlling the horizontal alignment of text within the container.

```css
h1 {
  text-align: center;
}
```

## 7. Link and Buttons

#### 7.1 Links

Signifiers are visual indicators that guide users on how to interact with elements in a user interface (UI). In the context of web pages, signifiers are crucial for helping users identify interactive elements like links, buttons, and other clickable items. Default styles provided by browsers, such as blue underlined links, act as familiar signifiers that make it easy for users to understand what elements are clickable. These signifiers are essential for maintaining a consistent and intuitive user experience, helping users navigate web pages effectively.

###### 7.1.1 Signifiers for Clickable Links

| **Signifier**             | **Description**                                                                   | **CSS Example**                                                   |
| ------------------------- | --------------------------------------------------------------------------------- | ----------------------------------------------------------------- |
| **Default Link**          | Links are styled with blue text and underlined to indicate they are clickable.    | `a { color: blue; text-decoration: underline; }`                  |
| **Visited Link**          | Links that have been visited are often styled with purple text.                   | `a:visited { color: purple; }`                                    |
| **Hover State**           | Changes to the link appearance when a user hovers over it, often changing color.  | `a:hover { color: orange; }`                                      |
| **Active (Clicked) Link** | Links that are clicked but not yet followed often change color, typically to red. | `a:active { color: red; }`                                        |
| **Cursor Change**         | The cursor changes to a pointing hand when hovering over a clickable element.     | `a { cursor: pointer; }`                                          |
| **Tooltip on Hover**      | Additional information can be provided via the `title` attribute, shown on hover. | `<a href="#" title="More info">Hover over me</a>`                 |
| **Consistent Styling**    | Maintain consistent signifiers across all link states to ensure user recognition. | `a, a:visited, a:hover, a:active { text-decoration: underline; }` |
| **Pseudo-Class Order**    | Proper ordering of pseudo-classes ensures correct visual feedback on links.       | `a:link, a:visited, a:hover, a:active { ... }`                    |

###### 7.1.2 Browser Default Link Signifiers

The signifiers mentioned—such as the default blue underlined links, purple for visited links, and red for active links—are typically set by default in web browsers. These default styles are part of the browser's "user agent stylesheet," which is a set of CSS rules that the browser automatically applies to all HTML elements to ensure basic readability and functionality, even if no custom styles are provided by the website's designer.

#### 7.2 Buttons

###### 7.2.1 Default Button

In HTML, `<button>` elements have default styles, such as borders and background colors, that give them a recognizable button-like appearance. A button element can then be created using the `<button>` tag in HTML.

```html
<button>Click me</button>
```

###### 7.2.2 Skeuomorphic Button

Skeuomorphic button design mimics the look and feel of real-life buttons by creating a raised appearance when unpressed and a pressed appearance when clicked. This can be achieved using CSS, which is preferred over image files due to better performance, scalability, and consistency. CSS3 allows for creating 2-D and 3-D effects that can effectively model button interactions. By using CSS pseudo-classes like `:hover` and `:active`, you can enhance the button's interactivity, providing visual feedback that simulates pressing a physical button.

```css
button {
  padding: 5px;
  border: 1px solid black;
  border-radius: 5px;
  text-decoration: none;
  box-shadow: 0px 5px;
}

button:hover {
  cursor: pointer;
}

button:active {
  margin-top: 5px;
  color: black;
  box-shadow: 0px 0px;
}
```

In this implementation example, the button has a basic raised appearance due to the `box-shadow`, and when clicked, it simulates being pressed by moving down and removing the shadow.

###### 7.2.3 Flat Button

Flat design features 2-D elements with minimal depth, relying on shape and other visual cues to indicate clickability. Commonly, flat design buttons are simple rectangles, rounded rectangles, or circles, which users instinctively recognize as interactive. Given the lack of traditional 3-D signifiers, these buttons must be visually distinct from other elements and paired with clear, descriptive text to avoid confusion. In CSS, flat design buttons are often styled with minimal borders and background color changes to indicate interaction.

```css
button {
  border: solid 1px black;
}

button:hover {
  background-color: grey;
}

button:active {
  color: white;
}
```

This example shows a basic flat design button with a border and a color change in background color and text color when hovered and clicked, respectively.

## 8. Breadcrumbs Navigation

#### 8.1 Primary vs. Secondary Navigation

###### 8.1.1 Primary Navigation

The primary navigation system contains the most crucial links and buttons that should be accessible on every page of a website. This ensures that users can easily find the most important sections regardless of where they are on the site.

###### 8.1.2 Secondary Navigation

Secondary navigation, often referred to as breadcrumb navigation, provides a clickable trail that shows users the path they took to reach the current page. This type of navigation helps users understand the overall structure of the site and their current location within it. The term "breadcrumbs" originates from the story of Hansel and Gretel, where the children drop breadcrumbs to find their way back.

#### 8.2 Types of Breadcrumbs

There are three main types of breadcrumbs:

1. Location-Based Breadcrumbs These breadcrumbs reflect the user's current location within the website's navigation structure. For example, a breadcrumb trail in a shopping website might show: "Shopping > Fashion > Shoes."

2. Attribute-Based Breadcrumbs: based on the attributes of the page or product being viewed. In an online store, this might include attributes like "Flats" and "Brown" for a specific pair of shoes.

3. Path-Based Breadcrumbs: Path-based breadcrumbs reflect the unique journey a user has taken through the site. For instance, a trail might show: "Home > About > Registration." This type is less common and should only be used when there is a compelling reason.

#### 8.3 Considerations when using Breadcrumbs

Breadcrumb navigation helps users who land on a site through direct links or search results by providing a clear sense of their location within the site and enabling easy backward navigation. While useful as a secondary navigation tool, breadcrumbs are most beneficial for larger, complex websites that require additional structure; they are less necessary for smaller sites or when the primary navigation already covers the site's content.

#### 8.4 Design and Implementation of Breadcrumbs

###### 8.4.1 Breadcrumb Layout and Symbols

Breadcrumbs are typically displayed as a horizontal unordered list (`<ul>`), taking up minimal space. Users expect them to be located in the header, left-aligned, and placed below any primary navigation. Commonly, breadcrumbs are separated by symbols like “>” or “/”.

###### 8.4.2 Simple Implementation

To style breadcrumbs in CSS, you can start by ensuring that list items are displayed inline:

```css
.breadcrumb > li {
  display: inline;
}
```

Next, to separate breadcrumbs with a symbol (e.g., “>”), use the following CSS:

```css
.breadcrumb li+li::before {
  padding: 10px;
  content: ">";
}
```

Here, the `+` symbol acts as an adjacent sibling combinator, selecting list items that are next to each other, while `::before` is a pseudo-element used to insert the symbol before the selected element.

## 9. Flexbox

#### 9.1 Introduction to Flexbox Layout

The Flexible Box Layout, or flexbox, is a CSS tool that simplifies the positioning of elements on a webpage. It involves two key components: flex containers and flex items. A flex container is any element with its display property set to `flex` or `inline-flex`, and all direct children of this container become flex items. Flexbox provides various properties to control the behavior and alignment of these flex items within their container.

#### 9.2 Creating Flex Containers

###### 9.2.1 Block Flex Containers

Any HTML element can be transformed into a flex container by setting its display property to `flex`, making it an effective tool for creating responsive designs. Flex containers allow their child elements, known as flex items, to adjust their size and position dynamically based on the size and positioning of the container, ensuring adaptability across different screen sizes. When an element is set to `display: flex;`, it remains a block-level element, preventing other elements from appearing on the same line.

```css
.container {
  display: flex;
}
```

###### 9.2.2 Inline Flex Containers

To create flex containers that behave as inline elements, you can use the `inline-flex` value for the `display` property. Unlike block-level flex containers, which stretch across the full width of the page, inline-flex containers allow div elements to align next to each other on the same line, provided the page is wide enough. This approach is useful when you want to maintain inline behavior while still leveraging the flexibility of flexbox for layout.

```css
.container {
  display: inline-flex;
}
```

#### 9.3 Horizontal Alignment

The `justify-content` property in CSS controls the alignment of flex items along the main axis (left to right). It has several values that determine how space is distributed between and around flex items within a container.

| **Value**       | **Description**                                                                                   |
| --------------- | ------------------------------------------------------------------------------------------------- |
| `flex-start`    | Items are aligned at the start (left) of the container, with no extra space.                      |
| `flex-end`      | Items are aligned at the end (right) of the container, with no extra space.                       |
| `center`        | Items are centered in the container, with no extra space before, between, or after.               |
| `space-around`  | Items have equal space around them, resulting in double space between items.                      |
| `space-between` | Items have equal space between them, with no extra space before the first or after the last item. |

#### 9.4 Vertical Alignment

The `align-items` property in CSS controls the vertical alignment of flex items within a flex container. It allows for spacing items along the cross axis (top to bottom) and offers five key values to position items in various ways.

| **Value**    | **Description**                                                    |
| ------------ | ------------------------------------------------------------------ |
| `flex-start` | Aligns all items at the top of the parent container.               |
| `flex-end`   | Aligns all items at the bottom of the parent container.            |
| `center`     | Aligns items in the vertical center of the parent container.       |
| `baseline`   | Aligns items based on the baseline of their content.               |
| `stretch`    | Stretches items to fill the container's height (default behavior). |

`min-height`, `max-height`, `min-width`, and `max-width` are properties that ensure an element is at least a certain size or at most a certain size.

#### 9.5 Controlling Flex Item Growth

The `flex-grow` property in CSS controls how flex items expand to fill extra space in a flex container. While flex items naturally shrink when the container is too small, they do not grow to fill available space by default. The `flex-grow` property allows you to specify how flex items should grow relative to each other when there is extra space, with higher values making items grow proportionally more.

```css
.container {
  display: flex;
}

.item {
  flex-grow: 1; /* All items will grow equally to fill available space */
}

.item-large {
  flex-grow: 2; /* This item will grow twice as much as others */
}
```

#### 9.6 Controlling Flex Item Shrinkage

The `flex-shrink` property in CSS determines how flex items will shrink relative to each other when the flex container is too small. By default, `flex-shrink` is set to 1, causing items to shrink as needed. Unlike shrinking, flex items do not grow by default since `flex-grow` defaults to 0, requiring explicit declaration to enable growth.

```css
.container {
  display: flex;
}

.item {
  flex-shrink: 1; /* Items will shrink proportionally if needed */
}

.item-no-shrink {
  flex-shrink: 0; /* This item will not shrink when space is tight */
}
```

#### 9.7 Defining Item Width

The `flex-basis` property in CSS sets the initial width of a flex item before any stretching or shrinking occurs. It defines the base size of the item, which flex-grow and flex-shrink then modify based on available space in the flex container.

```css
.container {
  display: flex;
}

.item {
  flex-basis: 200px; /* Sets the initial width of the item to 200px */
}
```

The shorthand `flex` property provides a convenient way for specifying how elements stretch and shrink, while simplifying the CSS required. The `flex` property allows you to declare `flex-grow`, `flex-shrink`, and `flex-basis` all in one line.

```css
.container {
  display: flex;
}

.item {
  flex: 1 2 200px; /* grow shrink base-width */
}
```

#### 9.8 Flex Item Wrapping

The `flex-wrap` property controls whether flex items should wrap onto multiple lines or stay on a single line. The property has three values:

| Value          | Description                                                        |
| -------------- | ------------------------------------------------------------------ |
| `wrap`         | Items will move to the next line if they don't fit in one row.     |
| `wrap-reverse` | Items will wrap to the next line, but rows are ordered in reverse. |
| `nowrap`       | Items will remain on one line, preventing any wrapping.            |

#### 9.9 Multiple Axis Alignment

The `align-content` property in flexbox controls the vertical spacing of multiple rows within a flex container. It adjusts the positioning and distribution of rows relative to the container's vertical space, with options to align them at the top, bottom, center, or evenly spaced.

| Value           | Description                                                                                      |
| --------------- | ------------------------------------------------------------------------------------------------ |
| `flex-start`    | Positions all rows at the top of the container with no extra space between them.                 |
| `flex-end`      | Positions all rows at the bottom of the container with no extra space between them.              |
| `center`        | Centers all rows within the container with no extra space between them.                          |
| `space-between` | Distributes rows evenly from top to bottom, with no space above the first or below the last row. |
| `space-around`  | Distributes rows evenly with equal space above, below, and between each row.                     |
| `stretch`       | Rows stretch to fill the container's height, default behavior if no height is specified.         |

#### 9.10 Changing Flex Direction

The `flex-direction` property defines the direction of flex items along the main axis of a flex container, which can be horizontal or vertical. By adjusting this property, you can change how items are ordered and positioned within the container, either from left to right, right to left, top to bottom, or bottom to top.

| Value            | Description                                                     |
| ---------------- | --------------------------------------------------------------- |
| `row`            | Items are positioned horizontally from left to right (default). |
| `row-reverse`    | Items are positioned horizontally from right to left.           |
| `column`         | Items are positioned vertically from top to bottom.             |
| `column-reverse` | Items are positioned vertically from bottom to top.             |

The shorthand `flex-flow` property is used to declare both the `flex-wrap` and `flex-direction` properties in one line.

```css
.container {
    display: flex;
    flex-flow: column wrap;
}
```

#### 9.11 Nesting Flex Containers

Flex containers can be nested within one another, allowing for complex layouts where each container's flex properties control the positioning of both its direct children and any nested flex items. This hierarchical approach enables precise control over layout and alignment at multiple levels within a design.

```css
/* Parent flex container */
.parent-container {
  display: flex;
  justify-content: center; /* Aligns nested containers horizontally */
  align-items: center;     /* Aligns nested containers vertically */
}

/* Nested flex container */
.child-container {
  display: flex;
  flex-direction: column; /* Stacks items vertically */
  justify-content: space-around; /* Distributes space around items */
  align-items: flex-start; /* Aligns items to the start of the cross axis */
}
```

## 10. Grid

#### 10.1 Introduction to Grid Layout

###### 10.1.1 The Role of Grids in Web Design

Grids consist of intersecting lines that help designers align elements and maintain consistency in their designs. The most common type used in web design is the **column grid**, which divides a page into vertical units, guiding the precise layout of content.

###### 10.1.2 Key Components of a Grid

In web design, a grid consists of three key components: columns, gutters, and margins. Columns are vertical sections that divide the page, typically into 12 or 16 segments, depending on the design and screen size. Gutters are the spaces between columns that prevent content from overlapping, while margins are the spaces on the left and right edges that keep content from touching the edges of the browser window.

###### 10.1.3 Organizing Content with Grid Columns, Rows, and Gutters

Grid columns are vertical containers used to organize content on a webpage, either by grouping related items (dependent columns) or separating unrelated elements like sidebars (independent columns). Content can span multiple columns, allowing flexibility in layout. Rows, the horizontal lines in a grid, group content by height, while gutters—the spaces between columns—provide natural separation between elements both horizontally and vertically. The size of gutters should visually separate columns but be thinner than the columns themselves, with vertical and horizontal gutters varying in size based on design needs.

#### 10.2 Managing Grid Layout

###### 10.2.1 Declaring a Grid

CSS Grid is a powerful tool for creating two-dimensional layouts, allowing designers to align and position elements across rows and columns. A grid layout is established by designating an HTML element as a grid container using the `display: grid` or `display: inline-grid` properties. By default, grids start with a single column, but you can define multiple rows and columns using the `grid-template-columns` and `grid-template-rows` properties. Additionally, the shorthand property `grid-template` can be used to simplify row and column definitions.

```css
/* Grid container setup */
.grid-container {
  display: grid;
  grid-template-columns: 50% 50%; /* Two columns, each taking 50% of the width */
  grid-template-rows: 100px 200px; /* Two rows with specific heights */
}

/* Shorthand example */
.grid-container {
  display: grid;
  grid-template: 100px 200px / 50% 50%; /* Defines rows and columns in one line */
}
```

This code creates a grid container with two rows and two columns, using both individual and shorthand property declarations.

###### 10.2.2 Relative Sizing

CSS Grid introduces the `fr` unit, a relative sizing unit designed specifically for grid layouts. The `fr` unit allows developers to allocate space in terms of fractions of the grid's total width or height, making it easier to create responsive designs. Unlike traditional responsive units like percentages, `em`, or `rem`, the `fr` unit efficiently divides available space among grid columns or rows based on specified ratios.

```css
.grid-container {
  display: grid;
  grid-template-columns: 1fr 2fr; /* First column takes 1/3, second takes 2/3 of the total width */
  grid-template-rows: 1fr 3fr;    /* First row takes 1/4, second takes 3/4 of the total height */
}
```

###### 10.2.3 Repeating Grid Layouts

In CSS Grid, the `repeat()` function allows developers to efficiently define grid rows or columns by repeating a specified pattern multiple times. This function is especially useful when combined with the `fr` unit for responsive layouts. The `repeat()` function can also accept multiple values as its second parameter, enabling the creation of complex grid structures with minimal code.

```css
.grid-container {
  display: grid;
  grid-template-columns: repeat(3, 1fr); /* Creates 3 equal-width columns */
  grid-template-rows: repeat(2, 100px 200px); /* Creates 4 rows: alternating 100px and 200px height */
}
```

###### 10.2.4 Limiting Size of Grid Items

The `minmax()` function in CSS Grid allows developers to create responsive grids that adjust based on the browser size, preventing rows or columns from becoming too large or too small. By setting a minimum and maximum size, `minmax()` ensures that grid elements maintain a balanced layout regardless of the screen size.

```css
.grid-container {
  display: grid;
  grid-template-columns: repeat(3, minmax(100px, 1fr)); /* Creates 3 columns with a minimum width of 100px and maximum width that expands proportionally */
}
```

###### 10.2.5 Spacing Grid Items

In CSS Grid, the `row-gap` and `column-gap` properties add space between rows and columns, respectively, without affecting the outer edges of the grid. The shorthand property `gap` simplifies this by allowing you to set both row and column gaps simultaneously.**

```css
.grid-container {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  row-gap: 20px;       /* Adds 20px space between rows */
  column-gap: 15px;    /* Adds 15px space between columns */
  /* or use the shorthand */
  gap: 20px 15px;      /* Adds 20px between rows and 15px between columns */
}
```

#### 10.3 Spanning Grid Items Across Grid

###### 10.3.1 Spanning Across Multiple Rows

In CSS Grid, the `grid-row-start` and `grid-row-end` properties allow a single grid item to span multiple rows by specifying the starting and ending grid lines. These lines are numbered based on the grid's rows, starting at 1. The shorthand `grid-row` property can be used to combine `grid-row-start` and `grid-row-end`, with the starting row placed before the slash and the ending row after.

```css
.grid-item {
  grid-row: 2 / 5; /* Start at row 2 and end at row 4 */
}
```

###### 10.3.2 Spanning Across Multiple Columns

In CSS Grid, the `grid-column-start` and `grid-column-end` properties allow a grid item to span multiple columns by specifying the starting and ending grid lines. These grid lines are numbered sequentially based on the grid's columns, starting at 1. The shorthand `grid-column` property can be used to combine `grid-column-start` and `grid-column-end`, with the starting column before the slash and the ending column after.

```css
.grid-item {
  grid-column: 2 / 4; /* Start at column 2 and end at column 3 */
}
```

###### 10.3.3 Span Keyword

The `span` keyword in CSS Grid allows for more accurate sizing of grid items by specifying the number of rows or columns an item should span, rather than relying on specific grid line numbers. This approach helps avoid off-by-one errors when calculating the ending grid line, making it easier to control how many grid tracks an item occupies.

```css
.grid-item {
  grid-column: 2 / span 2; /* Spans 2 columns starting from column index 2 */
  grid-row: 1 / span 3;    /* Spans 3 rows starting from row index 1 */
}
```

###### 10.3.4 Spanning Across Multiple Rows and Columns

The `grid-area` property in CSS Grid allows for further shorthand by combining the starting and ending positions of both rows and columns into a single property. It takes four values separated by slashes, specifying `grid-row-start`, `grid-column-start`, `grid-row-end`, and `grid-column-end` in that order, making it easier to define the placement of grid items within the grid.

```css
.grid-item {
  grid-area: 1 / 2 / span 3 / 4; /* Starts at row 1, column 2, ends at row 5, column 4 */
}
```

#### 10.4 Naming Grid Areas

The `grid-template-areas` property in CSS Grid allows you to define named areas within a grid container, which can then be referenced by properties such as `grid-row-start`, `grid-row-end`, `grid-column-start`, `grid-column-end`, and `grid-area` to position grid items. This property is applied directly to the grid container to enhance layout organization and readability.

```css
.container {
  display: grid;
  grid-template-areas:
    "header header"
    "sidebar content"
    "footer footer";
  grid-template: repeat(3, 1fr) / repeat(2, 1fr) 
}

.header {
  grid-area: header;
}

.sidebar {
  grid-area: sidebar;
}

.content {
  grid-area: content;
}

.footer {
  grid-area: footer;
}
```

#### 10.5 Overlapping Elements

CSS Grid Layout allows for easy overlapping of elements by using the `grid-area` property, which sets the starting and ending positions for both rows and columns of grid items. For managing the stacking order of overlapping elements, the `z-index` property can be utilized to control which elements appear on top.

```css
.container {
  display: grid;
  grid-template-areas:
    "header header"
    "content sidebar"
    "footer footer";
  position: relative;
}

.header {
  grid-area: header;
}

.sidebar {
  grid-area: sidebar;
  z-index: 1; /* Sidebar will appear on top of content */
}

.content {
  grid-area: content;
  z-index: 0; /* Content will appear beneath sidebar */
}

.footer {
  grid-area: footer;
}
```

#### 10.6 Grid Alignment

| **Property**      | **Description**                                                                                 | **Values**                                                                                                                                                                                                                                                                                                                     |
| ----------------- | ----------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `justify-items`   | Positions grid items along the inline (row) axis.                                               | `start` - Aligns items to the left.<br>`end` - Aligns items to the right.<br>`center` - Centers items.<br>`stretch` - Stretches items to fill the grid area.                                                                                                                                                                   |
| `justify-content` | Positions the entire grid within its container along the row axis.                              | `start` - Aligns grid to the left.<br>`end` - Aligns grid to the right.<br>`center` - Centers grid horizontally.<br>`stretch` - Stretches grid to fill container.<br>`space-around` - Equal space around each item.<br>`space-between` - Equal space between items.<br>`space-evenly` - Equal space between items and at ends. |
| `align-items`     | Positions grid items along the block (column) axis.                                             | `start` - Aligns items to the top.<br>`end` - Aligns items to the bottom.<br>`center` - Centers items.<br>`stretch` - Stretches items to fill the grid area.                                                                                                                                                                   |
| `align-content`   | Positions the rows within the grid container along the column axis.                             | `start` - Aligns grid to the top.<br>`end` - Aligns grid to the bottom.<br>`center` - Centers grid vertically.<br>`stretch` - Stretches grid to fill container.<br>`space-around` - Equal space around each row.<br>`space-between` - Equal space between rows.<br>`space-evenly` - Equal space between rows and at ends.      |
| `justify-self`    | Specifies how an individual item is positioned along the row axis, overriding `justify-items`.  | `start` - Aligns item to the left.<br>`end` - Aligns item to the right.<br>`center` - Centers item.<br>`stretch` - Stretches item to fill its grid area.                                                                                                                                                                       |
| `align-self`      | Specifies how an individual item is positioned along the column axis, overriding `align-items`. | `start` - Aligns item to the top.<br>`end` - Aligns item to the bottom.<br>`center` - Centers item.<br>`stretch` - Stretches item to fill its grid area.                                                                                                                                                                       |

#### 10.7 Implicit Grid

In scenarios where the quantity of grid items is uncertain, such as in online shopping results, CSS Grid's implicit grid takes over, automatically adding rows or columns as needed to accommodate additional content. The `grid-auto-rows` and `grid-auto-columns` properties allow you to define the size of these automatically added tracks, while `grid-auto-flow` controls whether new items fill rows first or columns first. The `dense` option in `grid-auto-flow` ensures that any gaps in the grid are filled efficiently by smaller elements.

```css
.container {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-auto-rows: 150px; /* Sets height for new rows */
  grid-auto-flow: row dense; /* Fills rows first, then fills gaps with smaller items */
}

.item {
  /* Additional styles for grid items */
}
```

## 11. Responsive Design

#### 11.1 Introduction to Responsive Design and Spacing

###### 11.1.1 Responsive Design

When designing web content, responsive design is essential for adapting layouts to different screen sizes, ensuring content remains accessible and visually appealing across devices. Responsive grids adjust the number of columns based on screen size, preventing content from becoming cramped and allowing design elements to have sufficient space. This approach maximizes content visibility and enhances the user experience.

###### 11.1.2 Spacing

Whitespace, or negative space, plays a crucial role in creating balanced web layouts by enhancing usability and prioritizing content. There are two types of whitespace:

1. Passive Whitespace (or micro whitespace) refers to the small, often unnoticed spaces between elements in a design, like the spacing between letters, lines of text, or padding around images. It's usually not intentionally added but comes naturally with the use of fonts or design tools.

2. Active Whitespace (or macro whitespace) is the space that is deliberately added by the designer to structure the content and guide the user’s experience on the page. It’s used strategically to create separation between different sections of content, making the page easier to navigate.

Proper use of both types of whitespace helps create more visually appealing and user-friendly designs.

#### 11.2 Relative Measurements

###### 11.2.1 Font Sizes

Relative measurements in CSS, such as `em` and `rem`, offer flexibility over hard-coded pixel values, allowing web layouts to adapt seamlessly to different screen sizes. The `em` unit is based on the font size of its parent element, while the `rem` unit is based on the root element, typically the `<html>` tag. This ensures that content scales consistently across various devices, maintaining the website's proportions.
