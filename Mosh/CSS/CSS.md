# CSS

## 1. Applying CSS Styles in HTML

#### 1.1 Embedded Stylesheets

Embedded stylesheets involve placing CSS directly within the HTML document, using the `<style>` element inside the `<head>` section. While this method allows for easy styling within the same file, it is not scalable for larger projects and can lead to cluttered code that mixes structure and styling.

```html
<head>
  <style>
    h1 {
      color: blue;
    }
  </style>
</head>
```

#### 1.2 External Stylesheets

External stylesheets are the preferred method for applying CSS. This approach involves linking to a separate CSS file using the `<link>` element within the `<head>` section. It promotes scalability, as the same stylesheet can be used across multiple HTML files, and it maintains a clear separation of content and design.

```html
<head>
  <link href="styles.css" rel="stylesheet">
</head>
```

In `styles.css`:

```css
h1 {
  color: blue;
}
```

#### 1.3 Inline Styles

Inline styles are applied directly to individual HTML elements via the `style` attribute. This method is not recommended for general use as it mixes content with design, making the code less maintainable and violating the separation of concerns.

```html
<h1 style="color: blue;">Welcome to My Website</h1>
```

#### 1.4 Consistent Styling Across Browsers

Different web browsers can render HTML elements with slight variations, leading to inconsistencies in how a webpage appears. To address these differences, developers can use a normalizing stylesheet like **Normalize.css**. This stylesheet provides default styles for HTML elements, ensuring they look consistent across all browsers, which simplifies the development process.

To implement Normalize.css, you can include the `normalize.css` file in your project folder and link it in the `<head>` section of your HTML document, before any custom CSS styles.

```html
<head>
  <link href="normalize.css" rel="stylesheet">
  <link href="styles.css" rel="stylesheet">
</head>
```

## 2. Selectors

#### 2.1 Basic Selectors

In CSS, selectors are used to target specific HTML elements to apply styles. There are several types of selectors that allow for precise control over which elements are styled, based on their type, ID, class, or attributes.

| **Selector**           | **Description**                                                                                                                            | **Syntax**                                                       |
| ---------------------- | ------------------------------------------------------------------------------------------------------------------------------------------ | ---------------------------------------------------------------- |
| **Type Selector**      | Targets all elements of a specific type, such as all `<p>` or `<h1>` elements.                                                             | `element {}`<br>`p { color: blue; }`                             |
| **ID Selector**        | Targets a specific element with a unique ID. IDs are unique to a single element per page and are prefixed with a `#`.                      | `#id {}`<br>`#header { background-color: green; }`               |
| **Class Selector**     | Targets one or more elements that share the same class attribute. Classes can be applied to multiple elements and are prefixed with a `.`. | `.class {}`<br>`.highlight { font-weight: bold; }`               |
| **Attribute Selector** | Targets elements that have a specific attribute or attribute value. The attribute is enclosed in square brackets.                          | `[attribute] {}`<br>`[type="text"] { border: 1px solid black; }` |

#### 2.2 Relational Selectors

Relational selectors in CSS are used to target HTML elements based on their relationship with other elements within the document structure. These selectors allow for more precise styling by defining relationships between elements, such as parent-child or sibling connections.

| **Selector**                  | **Description**                                                                                                              | **Syntax**              |
| ----------------------------- | ---------------------------------------------------------------------------------------------------------------------------- | ----------------------- |
| **Compound Selector**         | Target elements that match multiple simple selectors combined together.                                                      | `selector1selector2`    |
| **Descendant Selector**       | Selects elements that are descendants of a specified element, regardless of their direct or indirect relationship.           | `selector1 selector2`   |
| **Child Selector**            | Selects elements that are direct children of a specified parent element, using a greater-than sign (`>`).                    | `selector1 > selector2` |
| **Adjacent Sibling Selector** | Selects an element that is the immediate next sibling of a specified element, using a plus sign (`+`).                       | `selector1 + selector2` |
| **General Sibling Selector**  | Selects all elements that are siblings of a specified element, following it in the HTML structure, using a tilde sign (`~`). | `selector1 ~ selector2` |

Relational selectors can help create cleaner and more structured CSS by targeting elements based on their placement within the HTML hierarchy. However, they can be fragile if the HTML structure changes, and they may not be as performant as basic selectors. Therefore, it is often recommended to use ID or class selectors when possible for more robust and efficient styling.

#### 2.3 Pseudo-Class Selectors

Pseudo-class selectors in CSS are used to apply styles to elements based on their state or position in the document, without requiring any additional classes or IDs in the HTML. These selectors are particularly useful for styling elements based on user interaction, such as hovering or focusing, as well as for targeting specific elements within a parent container.

| **Pseudo-Class Selector** | **Description**                                                                        | **Syntax**               |
| ------------------------- | -------------------------------------------------------------------------------------- | ------------------------ |
| **`:first-child`**        | Targets the first child element of a specified parent.                                 | `:first-child`           |
| **`:first-of-type`**      | Applies styles to the first occurrence of a specified type of element within a parent. | `selector:first-of-type` |
| **`:last-child`**         | Targets the last child element of a specified parent.                                  | `:last-child`            |
| **`:last-of-type`**       | Applies styles to the last occurrence of a specified type of element within a parent.  | `selector:last-of-type`  |
| **`:visited`**            | Styles links that have already been visited by the user.                               | `a:visited`              |
| **`:link`**               | Styles links that have not yet been visited by the user.                               | `a:link`                 |
| **`:hover`**              | Applies styles when the user hovers the mouse over an element.                         | `selector:hover`         |
| **`:focus`**              | Applies styles when an element receives focus, typically via keyboard interaction.     | `selector:focus`         |

#### 2.4 Pseudo-Element Selectors

Pseudo-element selectors in CSS are used to style specific parts of an element, allowing for more granular control over the design. Unlike pseudo-class selectors, which apply styles based on an element's state, pseudo-element selectors target particular portions or insert content before or after elements.

| **Pseudo-Element Selector** | **Description**                                                                      | **Syntax**               |
| --------------------------- | ------------------------------------------------------------------------------------ | ------------------------ |
| **`::first-letter`**        | Styles the first letter of a text element.                                           | `selector::first-letter` |
| **`::first-line`**          | Styles the first line of a text element.                                             | `selector::first-line`   |
| **`::selection`**           | Styles the portion of text that has been highlighted by the user.                    | `selector::selection`    |
| **`::before`**              | Inserts content before the selected element. Often used with the `content` property. | `selector::before`       |
| **`::after`**               | Inserts content after the selected element. Often used with the `content` property.  | `selector::after`        |

#### 2.5 Selector Specificity

CSS selector specificity determines which styles are applied when multiple rules target the same element. The browser uses a specificity hierarchy to decide which rule takes precedence, with more specific selectors overriding less specific ones. The specificity ranking is as follows:

1. **ID Selectors** (`#id`) - Most specific, as an ID is unique to a single element.
2. **Class and Attribute Selectors** (`.class`, `[attribute]`) - Less specific than IDs but more specific than type selectors.
3. **Type Selectors** (`element`) - The least specific, affecting all instances of an element type.

When selectors of different specificities conflict, the browser applies the styles from the most specific selector. The `!important` declaration can override the specificity rule, forcing the rule to apply regardless of other competing rules. However, using `!important` is generally discouraged as it can make CSS harder to maintain. Instead, designers should focus on crafting more specific selectors by combining IDs, classes, or types to achieve the desired specificity.

## 3. CSS Inheritance

CSS properties can be inherited from parent elements, allowing for more efficient code by reducing redundancy. Inheritance is particularly useful for maintaining consistent styling across similar elements without needing to repeatedly define the same styles.

However, not all CSS properties are inheritable. Typography-related properties, like font size and color, are typically inherited, while others, such as layout-related properties (e.g., margin and padding), are not.

To override an inherited property, you can target the child element and assign the `initial` value to reset it to its default state, ignoring the parent’s styles. Conversely, if you want to ensure a property is inherited, even if it isn’t by default, you can use the `inherit` value to explicitly apply the parent’s style to the child element. This flexibility allows for precise control over the application of styles throughout your HTML document.

## 4. Styling Basics

#### 4.1 Colors

CSS provides several methods for specifying colors, each with its own syntax and use cases:

| **Method**       | **Description**                                      | **Syntax**           |
| ---------------- | ---------------------------------------------------- | -------------------- |
| **Named Colors** | Use predefined color names, such as "red" or "blue". | `color: name;`       |
| **RGB**          | Represents colors using red, green, and blue values. | `rgb(r, g, b)`       |
| **RGBA**         | Extends RGB with an alpha value for opacity.         | `rgba(r, g, b, a)`   |
| **HSL**          | Defines colors using hue, saturation, and lightness. | `hsl(h, s%, l%)`     |
| **HSLA**         | Extends HSL with an alpha value for opacity.         | `hsla(h, s%, l%, a)` |
| **Hexadecimal**  | Uses hexadecimal values to represent colors.         | `#RRGGBB`            |

#### 4.2 Gradients

Gradients in CSS are a type of image that create smooth transitions between colors. They can be applied using the `background` property with functions like `linear-gradient` or `radial-gradient`.

- **Linear Gradient**: Creates a gradient that transitions linearly between colors. By default, the gradient flows from top to bottom, but you can specify a direction using degrees (e.g., `0deg` for top, `90deg` for left). You can also define color stops using percentages to control where each color appears.
- **Radial Gradient**: Creates a gradient that radiates from a central point outward, transitioning between colors from the center.

For more advanced gradient configurations and visual tools, you can explore resources like [CSS Gradient Generator](https://cssgradient.io/).

#### 4.3 Borders

Borders in CSS are used to outline elements and can be customized in terms of thickness, style, color, and rounding. The `border` property provides a shorthand method for setting all border aspects at once, but individual properties allow for more specific control.

| **Property**      | **Description**                                              | **Syntax**                             |
| ----------------- | ------------------------------------------------------------ | -------------------------------------- |
| **border**        | Shorthand to set the thickness, style, and color of borders. | `border: width style color;`           |
| **border-width**  | Specifies the thickness of the border.                       | `border-width: top right bottom left;` |
| **border-style**  | Defines the style of the border (e.g., solid, dashed).       | `border-style: top right bottom left;` |
| **border-color**  | Sets the color of the border.                                | `border-color: top right bottom left;` |
| **border-radius** | Rounds the corners of the border.                            | `border-radius: radius;`               |

Borders can also be used creatively to create shapes and designs. For more examples and techniques on shapes, refer to resources such as [W3Schools CSS Shapes](https://www.w3schools.com/howto/howto_css_shapes.asp).

#### 4.4 Shadows

In CSS, shadows are applied to elements using the `box-shadow` property. This property allows you to create shadows with various effects by specifying several values: the horizontal and vertical distances of the shadow from the element, the blur radius, and the shadow color. Positive values move the shadow to the right and down, while negative values move it to the left and up. The blur radius controls the spread of the shadow, and the color can be customized, with the default being black.

```css
/* Syntax: box-shadow: horizontal-offset vertical-offset blur-radius color; */
.box {
    box-shadow: 10px 10px 5px rgba(0, 0, 0, 0.5); /* Example with a shadow 10px right, 10px down, 5px blur, and semi-transparent black color */
}
```

## 5. Layouts

#### 5.1 CSS Box Model

The CSS Box Model is a fundamental concept that defines how elements are displayed on a webpage. Each element is represented as a rectangular box consisting of four parts: content, padding, border, and margin. The content area is where text or images are displayed, and it is surrounded by padding, which adds space between the content and the border. The border encloses the padding, and the margin adds space outside the border, separating the element from adjacent elements. Proper understanding and manipulation of the box model allow for precise control over the layout and spacing of elements on a webpage.

| **Property** | **Description**                                                                | **Syntax**                        |
| ------------ | ------------------------------------------------------------------------------ | --------------------------------- |
| **padding**  | Adds space inside the element between the content and the border.              | `padding: top right bottom left;` |
| **margin**   | Adds space outside the element's border, separating it from adjacent elements. | `margin: top right bottom left;`  |
| **border**   | Defines the width, style, and color of the border around the element.          | `border: width style color;`      |

Understanding and correctly applying the padding and margin properties is crucial for consistent and clean layouts, as they affect the spacing inside and outside of elements differently.

#### 5.2 Sizing Elements

When sizing elements in CSS, it's important to understand how the box model affects the dimensions of an element. By default, the `width` and `height` properties apply only to the content area of an element, not accounting for padding, border, or margin. This can lead to unexpected increases in the total size of the element when padding and border are added.

To simplify size management, the `box-sizing` property can be set to `border-box`. This ensures that the specified `width` and `height` include the content, padding, and border, making it easier to control the element's total size. To apply this setting universally across all elements, including pseudo-elements, you can use the following CSS rule:

```css
*, 
*::before, 
*::after {
  box-sizing: border-box;
}
```

This ensures consistent sizing across all elements, accounting for padding and borders in the total dimensions.

#### 5.3 Display Property

HTML elements have different default `display` property values that affect their layout behavior:

- **block**: Displays the element on its own line, making it respect the `width` and `height` properties.
- **inline**: Keeps the element on the same line as surrounding elements, ignoring the `width` and `height` properties.
- **inline-block**: Keeps the element inline with surrounding content but allows it to respect the `width` and `height` properties.

Understanding and using these properties effectively can help achieve the desired layout and ensure that elements behave as expected in different contexts.

#### 5.4 Overflowing

When the content inside an element exceeds the dimensions of its parent container, overflow occurs. The `overflow` property in CSS allows you to control how this overflow is handled, ensuring that content is displayed or hidden according to your design needs. By default, overflow is visible, meaning that any content extending beyond the container is still shown. However, CSS offers several options to manage overflow more effectively.

| **Value**   | **Description**                                                                              | **Syntax**           |
| ----------- | -------------------------------------------------------------------------------------------- | -------------------- |
| **visible** | Default setting where overflow content is displayed outside the container.                   | `overflow: visible;` |
| **hidden**  | Hides any content that overflows outside the container, cutting it off.                      | `overflow: hidden;`  |
| **scroll**  | Adds scrollbars to the container, allowing users to scroll and see the overflowed content.   | `overflow: scroll;`  |
| **auto**    | Automatically adds scrollbars only when overflow occurs, otherwise, no scrollbars are shown. | `overflow: auto;`    |

#### 5.5 Measurement Units

CSS offers a variety of measurement units that can be broadly categorized into absolute and relative units. Absolute units, like pixels (`px`) and points (`pt`), provide fixed sizes that remain consistent regardless of screen size or resolution, making them less flexible and non-scalable. In contrast, relative units, such as percentages (`%`), viewport units (`vw`, `vh`), and font-relative units (`em`, `rem`), adjust based on the context, allowing for more responsive and scalable designs. The choice between absolute and relative units depends on the design requirements, with relative units generally preferred for creating adaptable layouts.

| **Unit** | **Type** | **Description**                                                    | **Advantages**                                 | **Syntax**           |
| -------- | -------- | ------------------------------------------------------------------ | ---------------------------------------------- | -------------------- |
| **px**   | Absolute | Represents pixels, a fixed unit.                                   | Consistent size across devices.                | `width: 100px;`      |
| **pt**   | Absolute | Represents points, commonly used in print.                         | Standard for print media.                      | `font-size: 12pt;`   |
| **%**    | Relative | Percentage relative to the parent element's size.                  | Responsive to container size changes.          | `width: 50%;`        |
| **vw**   | Relative | Relative to 1% of the viewport width.                              | Scales with the browser window width.          | `width: 10vw;`       |
| **vh**   | Relative | Relative to 1% of the viewport height.                             | Scales with the browser window height.         | `height: 50vh;`      |
| **em**   | Relative | Relative to the font size of the parent element.                   | Flexible for text and element sizing.          | `font-size: 2em;`    |
| **rem**  | Relative | Relative to the `<html>`root element's font size (default `16px`). | Consistent scaling across the entire document. | `font-size: 1.5rem;` |

#### 5.6 Positioning

###### 5.6.1 Positioning Elements

The `position` property in CSS allows you to control how and where HTML elements are positioned on the page. By default, elements are positioned statically, meaning they appear in the normal document flow. However, this property can be altered to change the element's behavior and placement:

| **Value**    | **Description**                                                                                   | **Syntax**            |
| ------------ | ------------------------------------------------------------------------------------------------- | --------------------- |
| **static**   | Default positioning, follows normal document flow.                                                | `position: static;`   |
| **relative** | Position relative to the element's normal position, moves using `top`, `right`, `bottom`, `left`. | `position: relative;` |
| **absolute** | Position relative to the nearest positioned ancestor, removed from the document flow.             | `position: absolute;` |
| **fixed**    | Position relative to the viewport, remains fixed during scrolling.                                | `position: fixed;`    |
| **sticky**   | Behaves like relative until a scroll threshold is reached, then acts like fixed.                  | `position: sticky;`   |

The `z-index` property can be used in conjunction with these positioning methods to control the stacking order of overlapping elements, with higher values bringing elements to the front.

###### 5.6.1 Floating Elements

The `float` property in CSS allows elements to be aligned to the left or right within their container. When an element is floated, it is removed from the normal document flow, which means other elements in the same container will wrap around it. However, this can lead to layout issues, such as collapsing parent containers.

To manage these issues, the `clear` property is used to prevent elements from wrapping around floated elements. This is particularly useful to ensure proper layout and prevent overlapping. A common technique to clear floats and maintain layout integrity is the "clearfix" method, which uses the `::after` pseudo-element to add a block element that clears the float.

```css
.clearfix::after {
    content: "";
    display: block;
    clear: both;
}
```

While floats can be powerful, they are often tricky to work with due to layout complications. As a result, more modern layout techniques, like Flexbox and Grid, are preferred in contemporary web design.

#### 5.7 Flex Box

###### 5.7.1 Introduction to Flexbox

The Flexible Box Layout, or Flexbox, is a CSS layout model that arranges elements in a single direction—either row or column. It simplifies the alignment, distribution, and spacing of items within a container. To start using Flexbox, the container's `display` property is set to `flex`. This changes how its child elements are laid out, allowing them to behave as flex items within the defined flex container.

###### 5.7.2 Flex Direction

The `flex-direction` property determines the primary axis direction within the flex container.

| **Value**        | **Description**                                         |
| ---------------- | ------------------------------------------------------- |
| `row`            | Aligns items in a horizontal row (default).             |
| `row-reverse`    | Aligns items in a horizontal row but in reverse order.  |
| `column`         | Aligns items in a vertical column.                      |
| `column-reverse` | Aligns items in a vertical column but in reverse order. |

###### 5.7.3 Main Axis and Cross Axis

In Flexbox, layout control revolves around two axes:

- **Main Axis:** Defined by the `flex-direction` property (row or column).
- **Cross Axis:** Perpendicular to the main axis, automatically managed by Flexbox.

###### 5.7.4 Justifying and Aligning Items

Flexbox offers powerful control over how items are aligned within their container using the `justify-content` and `align-items` properties:

- **`justify-content`:** Aligns items along the main axis (horizontal for `row`, vertical for `column`). This property helps distribute the space between items in various ways.

| **Value**       | **Description**                                             |
| --------------- | ----------------------------------------------------------- |
| `flex-start`    | Aligns items to the start of the container.                 |
| `flex-end`      | Aligns items to the end of the container.                   |
| `center`        | Centers items in the container.                             |
| `space-between` | Distributes items with space between them.                  |
| `space-around`  | Distributes items with space around them.                   |
| `space-evenly`  | Distributes items with equal space around and between them. |

- **`align-items`:** Aligns items along the cross axis. This property is useful for controlling how items stack vertically in a horizontal row or horizontally in a vertical column.

| **Value**    | **Description**                                  |
| ------------ | ------------------------------------------------ |
| `flex-start` | Aligns items to the start of the cross axis.     |
| `flex-end`   | Aligns items to the end of the cross axis.       |
| `center`     | Centers items along the cross axis.              |
| `stretch`    | Stretches items to fill the container (default). |
| `baseline`   | Aligns items along their baseline.               |

###### 5.7.4 Wrapping Flex Items

By default, Flexbox tries to fit all items in a single line, but the `flex-wrap` property allows items to wrap onto multiple lines.

| **Value**      | **Description**                                  |
| -------------- | ------------------------------------------------ |
| `nowrap`       | All items are kept on one line (default).        |
| `wrap`         | Items wrap onto multiple lines as needed.        |
| `wrap-reverse` | Items wrap onto multiple lines in reverse order. |

###### 5.7.5 Aligning Content on Multiple Lines

When items wrap onto multiple lines, the `align-content` property controls how the lines themselves are aligned along the cross axis.

| **Value**       | **Description**                                       |
| --------------- | ----------------------------------------------------- |
| `flex-start`    | Lines are packed toward the start of the cross axis.  |
| `flex-end`      | Lines are packed toward the end of the cross axis.    |
| `center`        | Lines are centered in the container.                  |
| `space-between` | Lines are evenly distributed with space between them. |
| `space-around`  | Lines are evenly distributed with space around them.  |
| `stretch`       | Lines stretch to fill the container.                  |

###### 5.7.6 Sizing Flex Items

Flexbox offers several properties to control the size and growth of individual flex items:

| **Property**  | **Description**                                         |
| ------------- | ------------------------------------------------------- |
| `flex-basis`  | Sets the initial size of the item.                      |
| `flex-grow`   | Defines the growth factor of the item.                  |
| `flex-shrink` | Defines the shrink factor of the item.                  |
| `flex`        | Shorthand for `flex-grow`, `flex-shrink`, `flex-basis`. |

###### 5.7.7 Controlling Individual Item Alignment

The `align-self` property allows individual flex items to override the alignment set by `align-items`.

| **Value**    | **Description**                                 |
| ------------ | ----------------------------------------------- |
| `flex-start` | Aligns the item to the start of the cross axis. |
| `flex-end`   | Aligns the item to the end of the cross axis.   |
| `center`     | Centers the item along the cross axis.          |
| `baseline`   | Aligns the item along its baseline.             |
| `stretch`    | Stretches the item to fill the container.       |

#### 5.8 Grid Layouts

###### 5.8.1 Defining a Grid Layout

Grid layouts in CSS allow you to organize elements into both rows and columns simultaneously. This makes grids particularly useful for structuring the entire layout of a webpage, such as headers, sidebars, content areas, and footers. 

- **Defining a Grid Container:** To create a grid, the container's `display` property is set to `grid`. Then, the `grid-template-rows` and `grid-template-columns` properties are used to specify the number and size of rows and columns.

- **Using the `repeat()` Function:** The `repeat()` function simplifies the creation of grids with repetitive rows or columns.

- **Shorthand Notation:** The `grid-template` shorthand allows you to define both rows and columns in a single line. 

- **Fraction Unit:** The `fr` (fraction) unit is unique to grids, enabling you to allocate a fraction of the available space to grid items.

| **Property**            | **Description**                                                 |
| ----------------------- | --------------------------------------------------------------- |
| `grid-template-rows`    | Defines the number and size of rows.                            |
| `grid-template-columns` | Defines the number and size of columns.                         |
| `grid-template`         | Shorthand for `grid-template-rows` and `grid-template-columns`. |

###### 5.8.2 Aligning Grid Items

Once a grid is established, the `justify-items` and `align-items` properties control the alignment of items within the grid cells.

| **Property**    | **Description**                                   |
| --------------- | ------------------------------------------------- |
| `justify-items` | Aligns items horizontally within their grid area. |
| `align-items`   | Aligns items vertically within their grid area.   |

###### 5.8.3 Aligning the Entire Grid

To align the entire grid within its container, use the `justify-content` and `align-content` properties. These properties control how the grid as a whole is positioned within the container.

| **Property**      | **Description**                                           |
| ----------------- | --------------------------------------------------------- |
| `justify-content` | Aligns the entire grid horizontally within the container. |
| `align-content`   | Aligns the entire grid vertically within the container.   |

###### 5.8.4 Adding Gaps Between Grid Items

To create space between the rows and columns of the grid, the `row-gap`, `column-gap`, and `gap` properties are used.

| **Property** | **Description**                                 |
| ------------ | ----------------------------------------------- |
| `row-gap`    | Sets the space between rows in the grid.        |
| `column-gap` | Sets the space between columns in the grid.     |
| `gap`        | Shorthand for setting both row and column gaps. |

###### 5.8.5 Positioning Grid Items

To place items within specific grid cells, use the `grid-row`, `grid-column`, and `grid-area` properties.

| **Property**  | **Description**                                               |
| ------------- | ------------------------------------------------------------- |
| `grid-row`    | Specifies the rows a grid item will occupy.                   |
| `grid-column` | Specifies the columns a grid item will occupy.                |
| `grid-area`   | Shorthand for specifying the row and column an item occupies. |

###### 5.8.6 Defining Named Grid Areas

CSS Grid allows you to create named grid areas, which can make your grid layout more semantic and easier to manage. Named areas are defined in the grid container using the `grid-template-areas` property, and individual grid items are then assigned to these areas using the `grid-area` property.

| **Property**          | **Description**                               |
| --------------------- | --------------------------------------------- |
| `grid-template-areas` | Defines named areas in the grid layout.       |
| `grid-area`           | Assigns a grid item to a specific named area. |

#### 5.9 Hiding Elements

In CSS, elements can be hidden using either the `display` or `visibility` properties, each with different effects:

- **`display: none;`** Completely removes the element from the document, making it invisible and eliminating the space it would have occupied.

- **`visibility: hidden;`** Makes the element invisible while still preserving the space it occupies in the layout. 

These properties are useful for controlling the visibility of elements without removing them entirely from the DOM, depending on the desired layout and user experience.

#### 5.10 Media Queries

Media queries are essential in CSS for building responsive websites that adapt to different devices, such as smartphones, tablets, and desktops. They allow you to apply different styles based on features like screen size, orientation, and resolution. The preferred approach is often "mobile-first" design, where the site is optimized for mobile devices first, and then enhanced for larger screens.

When developing responsive designs, you can use the web development tools in Microsoft Edge to simulate different devices. By toggling the device simulation mode, you can view and test your website as it would appear on various screen sizes, including smartphones and tablets.

To create a media query, use the `@media` rule followed by conditions like `min-width` or `max-width`. This allows you to introduce breakpoints where the design needs adjustment.

```css
/* Styles for screens wider than 768px (typically tablets and desktops) */
@media screen and (min-width: 768px) {
  body {
    font-size: 18px;
  }
}

/* Styles for screens wider than 1024px (desktops) */
@media screen and (min-width: 1024px) {
  body {
    font-size: 20px;
  }
}
```

## 6. Typography

#### 6.1 Styling Fonts

CSS provides several properties to style and customize fonts, allowing you to control the appearance of text on your webpage. These properties enable you to select specific fonts, adjust their size, weight, style, and color, ensuring your text matches the desired design and readability requirements.

| **Property**  | **Description**                                                                                                                                                                                                                                                                              | **Syntax**                          |
| ------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------- |
| `font-family` | Specifies the font for an element, with options to prioritize multiple fonts in a stack, ensuring fallback options if the primary font is unavailable. Fonts are categorized into `serif`, `sans-serif`, and `monospace`, with web-safe fonts often included for cross-device compatibility. | `font-family: "Arial", sans-serif;` |
| `font-weight` | Defines the boldness of text, with values ranging from 100 to 900.                                                                                                                                                                                                                           | `font-weight: bold;`                |
| `font-style`  | Applies styles like italic to text elements.                                                                                                                                                                                                                                                 | `font-style: italic;`               |
| `font-size`   | Sets the size of text using absolute or relative units, or keywords.                                                                                                                                                                                                                         | `font-size: 16px;`                  |
| `color`       | Sets the color of the text.                                                                                                                                                                                                                                                                  | `color: #333333;`                   |

#### 6.2 Custom Fonts

###### 6.2.1 Embedding Custom Fonts

In addition to web-safe fonts, custom fonts can be obtained from online sources like FontSquirrel, Fonts.com, and MyFonts.com. Custom fonts are available in various formats such as TTF, OTF, EOT, WOFF, and WOFF2, with WOFF and WOFF2 being preferred for web use due to their compression and efficiency. If you have a font in a heavier format like TTF, you can convert it to WOFF or WOFF2 using a web font generator like FontSquirrel. After converting and downloading the web font kit, you can include the fonts in your project. To use these web fonts, define a `@font-face` rule at the top of your stylesheet, specifying the font's name, file source, weight, and style. Once registered, the custom fonts can be used throughout your stylesheet.

```css
@font-face {
    font-family: 'CustomFont';
    src: url('fonts/CustomFont.woff2') format('woff2'),
         url('fonts/CustomFont.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

/* Applying the custom font */
body {
    font-family: 'CustomFont', sans-serif;
}
```

###### 6.2.2 Managing Flashes of Unstyled Text

When a website loads, if the embedded font isn't downloaded immediately, a web-safe fallback font might be displayed temporarily, causing a flash of unstyled text (FOUT). This can lead to layout shifts and a poor user experience. To control this behavior, the `font-display` property within the `@font-face` rule can be used with different values: 

- **auto**: The default behavior.
- **swap**: Displays the fallback font first and then swaps it with the custom font once it's loaded.
- **fallback**: Uses the custom font if it loads within a short window; otherwise, the fallback font remains.
- **block**: Hides the text until the custom font is loaded.
- **optional**: The custom font is used if available, but it's not essential for display.

###### 6.2.3 Using Font Services

Web font services, like Google Web Fonts, offer a wide range of fonts, some free and others requiring a subscription. These services simplify font usage by providing filters to help find the right font and guidelines to integrate them into your website. Typically, this involves adding a `<link>` element to your HTML to connect to the service's domain and referencing a stylesheet that includes the necessary `@font-face` rules, with the fonts being served directly from the service's servers.

#### 6.3 System Font Stack for Native Appearance

The system font stack allows a webpage to use the default fonts of the user's operating system, ensuring a native look and improving performance by eliminating the need for font downloads, thus preventing any flash of unstyled text (FOUT). However, the appearance may vary across different operating systems due to differences in default fonts. To implement the system font stack, you can specify a list of fonts that correspond to the default fonts across various operating systems.

```css
body {
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
}
```

#### 6.4 Text Sizing

When sizing text in CSS, it's advisable to use relative measurement units instead of absolute ones like pixels, as relative units provide better consistency across different devices. Preferred units include percentages (%), viewport units (vw, vh), and especially `em` and `rem`. `rem` is often favored because it bases the measurement on the root element's font size, typically 16px by default. A common practice is to set the `html` font size to 62.5%, equating to 10px, making it easier to calculate other font sizes. For visualizing font sizes across different typefaces, tools like [type-scale.com](https://typescale.com/) can be very helpful.

#### 6.5 Text Spacing

In CSS, spacing text elements effectively horizontally and vertically is key to improving readability and design. 

| **Property**     | Axis       | **Description**                                                                                                                                                                                               | **General Syntax**       |
| ---------------- | ---------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------ |
| `margin`         | Vertical   | Controls the vertical space between elements.                                                                                                                                                                 | `margin: value;`         |
| `line-height`    | Vertical   | Adjusts the space between lines of text; use unitless values for proportional scaling.                                                                                                                        | `line-height: value;`    |
| `letter-spacing` | Horizontal | Increases or decreases the spacing between letters.                                                                                                                                                           | `letter-spacing: value;` |
| `word-spacing`   | Horizontal | Increases or decreases the spacing between words.                                                                                                                                                             | `word-spacing: value;`   |
| `width`          | Horizontal | Sets the width of an element; can be used to control line length. Research suggests that an ideal line length is 50-70 characters, so setting the `width` to `50ch` characters can help achieve this balance. | `width: value;`          |

#### 6.6 Formatting Text

CSS offers several properties to format and enhance the presentation of text elements on a webpage.

| **Property**      | **Description**                                         | **General Syntax**           |
| ----------------- | ------------------------------------------------------- | ---------------------------- |
| `text-align`      | Controls the horizontal alignment of text.              | `text-align: left`           |
| `text-indent`     | Adds indentation to the first line of text.             | `text-indent: value;`        |
| `text-decoration` | Adds decoration like underline or line-through to text. | `text-decoration: underline` |
| `text-transform`  | Transforms text to uppercase, lowercase, or capitalize. | `text-transform: uppercase`  |
| `white-space`     | Controls text wrapping and whitespace handling.         | `white-space: nowrap`        |
| `column-count`    | Splits text into multiple columns.                      | `column-count: number;`      |
| `column-gap`      | Controls the space between columns.                     | `column-gap: value;`         |
| `column-rule`     | Adds a border between columns.                          | `column-rule: value;`        |

## 7. Images

#### 7.1 Images Types and Formats

In computing, images fall into two main categories:

- **Raster images** are composed of pixels and include formats like JPG, PNG, GIF, and WebP. They are commonly produced by cameras, scanners, or image-editing software. The quality and file size of raster images depend on their resolution, with higher resolutions leading to larger file sizes. While these images can support various color depths, transparency, and animations, it's important to balance quality and file size for web use.

- **Vector images** are created from mathematical equations using lines and curves, and are typically saved in SVG (Scalable Vector Graphics) format. Unlike raster images, vector images are resolution-independent, meaning they can be scaled to any size without losing sharpness, making them ideal for logos and icons.

#### 7.2 Background Images

To set a background for an element in CSS, various properties allow you to control the appearance and behavior of the background image.

| **Property**              | **Description**                                                                                                                         | **Syntax**                                  |
| ------------------------- | --------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------- |
| **background-image**      | Sets the background image of an element.                                                                                                | `background-image: url(image.jpg);`         |
| **background-repeat**     | Determines how the background image is repeated.                                                                                        | `background-repeat: no-repeat`              |
| **background-position**   | Sets the position of the background image.                                                                                              | `background-position: horizontal vertical;` |
| **background-size**       | Defines the size of the background image. The `cover` value ensures the entire container is filled while keeping the image proportions. | `background-size: width height`             |
| **background-attachment** | Controls the scrolling behavior of the background image.                                                                                | `background-attachment: fixed``             |

#### 7.3 CSS Sprites

To reduce server load and optimize image delivery on a webpage, CSS sprites combine multiple images into a single file. This technique minimizes the number of HTTP requests made to the server by consolidating various images—such as icons or logos—into one larger image. Using a tool like [CSS Sprite Tool](https://cssspritestool.com/), you can create a CSS sprite and generate a corresponding stylesheet with rules for displaying each image segment. By applying background properties to container elements in your HTML, you can effectively use the combined sprite image while keeping the number of server requests to a minimum. Note that CSS sprites are best suited for small images and may require recreation if new images need to be added. This approach helps to streamline resource loading and improve page performance.

#### 7.4 Data URLs

Data URLs are a technique used to reduce HTTP requests by embedding images directly within a document or stylesheet. By converting an image into a long string of characters using a Data URL generator, such as [CSS Portal’s Image to Data](https://www.cssportal.com/image-to-data/), you can include the image data directly in your HTML or CSS. This method eliminates the need for additional image file requests, as the data is embedded within the document itself. However, Data URLs often result in larger file sizes compared to the original images and can increase the complexity of your HTML. Additionally, this approach may lead to slower rendering on mobile devices due to the increased size and processing required.

#### 7.5 Clipping Images

To crop or clip parts of an image using CSS, you can utilize a CSS clip path generator like [Clippy](https://bennettfeely.com/clippy/). This interactive tool allows you to define various shapes and cut portions of an image visually. It generates the corresponding CSS property values needed to apply these shapes and crop the image accordingly. This method provides a straightforward way to customize image clipping without manually writing complex CSS code.

#### 7.6 Applying Filters

CSS enables the application of visual effects to images using the `filter` property. Filters can modify image appearance through various functions like `grayscale`, `blur`, `contrast`, `brightness`, and `saturate`. Each function accepts specific values to adjust the intensity of the effect. Multiple filters can be combined to create complex visual effects.

```css
/* Example of applying multiple filters to an image */
img {
  filter: grayscale(50%) blur(5px) contrast(120%) brightness(80%) saturate(150%);
}
```

#### 7.7 Supporting High-Density Screens

High-density screens, with a **device pixel ratio (DPR)** greater than one, require higher-resolution images to maintain sharpness. **Physical resolution** refers to the actual number of pixels on a device, while **logical resolution** is how the screen behaves, appearing as though it has fewer pixels. The DPR is the ratio of physical to logical pixels, and it determines how sharp images will appear on these screens. For example, a high DPR (like 2x or 3x) means that more physical pixels are used to display the same logical space, resulting in sharper images.

To accommodate this, you can create larger versions of raster images using editing tools like Photoshop and name them using a convention like `@2x` or `@3x` based on the DPR. These images can then be provided to the browser using the `srcset` attribute in the `<img>` element, ensuring that the correct image is displayed based on the screen's DPR. This ensures that images appear crisp and clear on high-density screens without compromising quality.

```html
<img src="image.jpg" 
     srcset="image.jpg 1x, image@2x.jpg 2x, image@3x.jpg 3x" 
     alt="Optimized Image">
```

This approach is recommended for key visuals that need to retain high quality on various screens. However, it’s essential to use this technique selectively, primarily for images where maintaining quality across different screens is crucial.

#### 7.8 Resolution Switching

Devices have varying screen resolutions, and serving the same image to all devices can lead to inefficient resizing, increasing the browser's workload and potentially slowing down performance. This issue, known as **resolution switching**, arises when the browser resizes a single image to fit different screen sizes. To optimize this, you can provide multiple versions of an image at different sizes (small, medium, large) and let the browser choose the most appropriate one based on the device's screen resolution and pixel ratio.

Using the `srcset` attribute in the `<img>` element allows you to specify different image versions with their respective widths. The browser will then select the best fit for the device. Additionally, the `sizes` attribute can be used to define how much of the viewport the image should occupy, based on screen size, similar to media queries.

```html
<img src="image.jpg"
     srcset="image.jpg 400w, image@2x.jpg 800w, image@3x.jpg 1200w"
     sizes="(max-width: 500px) 100vw, 50vw"
     alt="Responsive Image">
```

This method allows for efficient image delivery, enhancing performance across devices by reducing unnecessary resizing. Tools like the [Responsive Image Breakpoints Generator](https://www.responsivebreakpoints.com/) can help determine the optimal image sizes and breakpoints.

#### 7.9 Using Modern Image Formats

WebP is a modern raster image format that offers significantly smaller file sizes compared to traditional formats like JPEG and PNG, while maintaining similar or better quality. This reduction in size leads to faster loading times and improved website performance. To convert images to WebP, you can use image editing software, online tools like [CloudConvert](https://cloudconvert.com/jpg-to-webp), or command-line tools.

#### 7.10 Art Direction

Art direction allows you to display different versions of an image (e.g., zoomed-in or cropped) based on the screen size or device. This technique requires both the original and cropped images to be available in your project. By using the `<picture>` element and defining conditions with the `<source>` element's `media` attribute, you can serve the appropriate image based on the screen width.

```html
<picture>
  <source media="(max-width: 500px)" srcset="cropped-image.jpg" />
  <source media="(min-width: 501px)" srcset="uncropped-image.jpg" />
  <img src="uncropped-image.jpg" alt="Responsive Image">
</picture>
```

#### 7.11 Icon Fonts

Icon fonts are a versatile way to incorporate icons into your web design. Popular icon fonts include Font Awesome, Ionicons, and Material Design Icons. [Font Awesome](https://fontawesome.com/), for example, offers a free and subscription-based plan. After initializing a kit on Font Awesome, you receive a script tag to include in the `<head>` section of your HTML document. This enables access to their icon library.

To use an icon, find it in their catalog, and copy the provided HTML code. You can wrap the icon in a `<span>` element to apply custom CSS. You can control the icon's color, size, and other styling properties just like you would with regular text.

```html
<head>
  <script src="https://kit.fontawesome.com/yourkit.js" crossorigin="anonymous"></script>
</head>
<body>
  <span class="icon-container">
    <i class="fas fa-home"></i>
  </span>
</body>
```

To style the icon:

```css
.icon-container {
  color: #007bff;
  font-size: 24px;
}
```

## 8. Forms

#### 8.1 Build Forms

To create a basic form, start with the `<form>` element. Inside the form, you can add multiple input fields using the `<input>` element, each defined by a `type` attribute such as `"text"` for a text field. Labels for these inputs can be added using the `<label>` element, which is inline by default and can be linked to a specific input by setting the `for` attribute to match the input's `id`. Additionally, you can include a `<button>` element with `type="submit"` to create a submit button or `type="reset"` to create a reset button.

```html
<form>
  <label for="username">Username:</label>
  <input type="text" id="username" />

  <label for="password">Password:</label>
  <input type="password" id="password" />

  <button type="submit">Submit</button>
  <button type="reset">Reset</button>
</form>
```

This structure provides the foundation for creating interactive forms on your webpage.

#### 8.2 Style Forms and Frameworks

CSS offers a variety of properties to style form elements effectively. For input fields, consider using properties like `font-family`, `border`, `border-radius`, `outline`, `box-shadow`, and `transition` to enhance the appearance and interactivity. For buttons, properties such as `font-family`, `background-color`, `border`, `border-radius`, and `outline` are key to creating visually appealing designs. Additionally, applying styles to pseudo-class selectors like `:focus` and `:hover` can improve user experience.

Styling forms and buttons can be time-consuming, so using CSS frameworks like Bootstrap, Foundation, Semantic UI, UI Kit, Materialize, or Milligram can greatly increase efficiency. These frameworks provide pre-designed styles and components that can be easily integrated into your project by adding the necessary classes to your HTML elements.

Bootstrap is one of the most popular frameworks, offering comprehensive styles for forms and other components, though it may impact performance on slower connections due to its size. Alternatively, minimalistic frameworks like Milligram provide a lightweight option that maintains good performance without sacrificing modern design.

To use a framework like Milligram, you can include it via CDN in the `<head>` of your HTML file and start applying the provided styles by following the framework's documentation.

#### 8.3 Text Fields

Text fields are a fundamental input control element in forms, allowing users to enter and edit text. The `<input>` element with a `type="text"` attribute is used to create single-line text fields, while the `<textarea>` element is employed for multi-line text input. Both elements share a couple of key attributes:

| **Attribute** | **Description**                                                                                |
| ------------- | ---------------------------------------------------------------------------------------------- |
| `value`       | Prepopulates the text field with a default value that users can edit.                          |
| `placeholder` | Displays placeholder text inside the text field, which disappears once the user begins typing. |
| `required`    | Ensures that an input will be supplemented to the field.                                       |
| `readonly`    | Makes the text field uneditable; the user can view but not modify the content.                 |
| `disabled`    | Disables the text field entirely, preventing any interaction.                                  |
| `maxlength`   | Limits the maximum number of characters that can be entered in the text field.                 |
| `autofocus`   | Automatically focuses on the text field when the page loads, allowing immediate text input.    |

Unlike the `<input>` element, the `<textarea>` uses its inner text content to prepopulate the field rather than a `value` attribute.

The `<textarea>` element allows users to input multiple lines of text. To control its resizing, the CSS `resize` property can be used, with the default being resizable by users, and setting `resize: none;` to disable resizing.

In addition to the standard text input field, various other specialized input types can be used in forms to capture text in a more specific way:

| **Input Type** | **Description**                                                          |
| -------------- | ------------------------------------------------------------------------ |
| `text`         | Allows the user to freely enter text in the input field.                 |
| `number`       | Restricts input to numeric values only, facilitating numeric data entry. |
| `password`     | Masks the entered text to keep it confidential (e.g., for passwords).    |
| `date`         | Provides a date picker to enter a date value.                            |
| `datetime`     | Allows input of both date and time values.                               |
| `email`        | Validates and allows entry of a valid email address.                     |

#### 8.4 Data Lists

To provide users with a list of suggestions as they type in a text field, you can use the `<datalist>` element in your form. Inside the `<datalist>`, you can define multiple `<option>` elements representing the suggestions. To link the `<datalist>` with the text field, set the `list` attribute of the `<input>` element to the identifier (ID) of the `<datalist>`. Additionally, to prevent the browser's default autocomplete feature from interfering, set the `autocomplete` attribute of the `<input>` element to `off`.

```html
<form>
  <input type="text" list="input-list" autocomplete="off" />
  <datalist id="input-list">
    <option>first-input</option>
    <option>second-input</option>
    <option>third-input</option>
  </datalist>
</form>
```

#### 8.5 Drop-Down List

To display a dropdown list in forms, use the `<select>` element, which contains multiple `<option>` elements representing the choices available. The `selected` attribute can be applied to an `<option>` to make it the default selection. The `<select>` element also supports the `multiple` attribute, allowing users to select more than one option. If the dropdown has many options, you can organize them into categories using the `<optgroup>` element, which groups related options under a common label.

```html
<form>
  <select>
    <optgroup label="Number Category">
      <option>Option 1</option>
      <option>Option 2</option>
    </optgroup>
    <optgroup label="Letter Category">
      <option>Option A</option>
      <option>Option B</option>
    </optgroup>
  </select>
</form>
```

#### 8.6 Check Boxes

Checkboxes in forms are created using the `<input>` element with the `type` attribute set to `"checkbox"`. Each checkbox can be associated with a label using the `<label>` element, where the `for` attribute is matched to the `id` of the corresponding checkbox. To make a checkbox selected by default, include the `checked` attribute within the `<input>` element.

```html
<form>
  <input type="checkbox" id="box" checked>
  <label for="box">Check this box</label>
</form>
```

#### 8.7 Radio Buttons

Radio buttons allow users to select only one option from a group of choices in a form. This is achieved using the `<input>` element with the `type` attribute set to `"radio"`. To group radio buttons so that only one can be selected at a time, you must assign the same `name` attribute to each radio button in the group. Labels can be associated with each radio button using the `<label>` element, where the `for` attribute is set to match the `id` of the corresponding radio button. Additionally, you can use the `checked` attribute to preselect a radio button when the page loads.

```html
<form>
  <div>
    <input type="radio" id="option1" name="choices" checked>
    <label for="option1">Option 1</label>
  </div>

  <div>
    <input type="radio" id="option2" name="choices">
    <label for="option2">Option 2</label>
  </div>

  <div>
    <input type="radio" id="option3" name="choices">
    <label for="option3">Option 3</label>
  </div>
</form>
```

#### 8.8 Sliders

To allow users to select a numeric value within a specified range, you can use an `<input>` element with the `type` attribute set to `"range"`. This creates a slider control. You can customize the slider's range by specifying the `min` and `max` attributes, which define the minimum and maximum values the slider can handle. The `value` attribute sets the initial position of the slider.

```html
<form>
  <input type="range" min="0" max="100" value="50">
</form>
```

#### 8.9 File Inputs

To enable users to select files in a form, use an `<input>` element with the `type` attribute set to `"file"`. This input field opens a file explorer dialog, allowing users to choose files from their device. To allow multiple file selections, add the `multiple` attribute. To restrict the file types that can be selected, use the `accept` attribute to specify acceptable file formats.

```html
<form>
  <input type="file" multiple accept=".jpg, .png, .pdf">
</form>
```

#### 8.10 Grouping Input Fields

To group related input fields within a form, use the `<fieldset>` element. This element creates a container around the input fields and provides a visual grouping. Inside the `<fieldset>`, add a `<legend>` element to serve as a label or title for the grouped fields. This helps in organizing and categorizing form controls, improving both accessibility and user experience.

```html
<form>
  <fieldset>
    <legend>First Group</legend>
    <!-- Any number of related input fields-->
  </fieldset>

  <fieldset>
    <legend>Second Group</legend>
    <!-- Any number of related input fields-->
  </fieldset>
</form>
```

#### 8.11 Hidden Fields

Hidden fields are used in forms to include data that should not be visible or editable by the user but needs to be sent to the server when the form is submitted. This can include identifiers or other data required for processing but not meant to be displayed. To create a hidden field, use the `<input>` element with the `type` attribute set to "hidden". The `name` attribute assigns a unique identifier to the field, and the `value` attribute sets the data that will be submitted.

```html
<form action="/submit" method="post">
  <!-- Visible fields -->
  <label for="username">Username:</label>
  <input type="text" id="username" name="username">

  <!-- Hidden field -->
  <input type="hidden" name="userID" value="12345">

  <button type="submit">Submit</button>
</form>
```

#### 8.12 Submitting Forms

Forms can be submitted using either a `<button>` element of type "submit" or an `<input>` element of type "submit". The `<button>` element allows for more customization, such as including icons or other content within the button, whereas the `<input>` element does not support such customization. To specify where and how to send the form data, use the `action` and `method` attributes of the `<form>` element. The `action` attribute defines the URL to which the form data will be sent, while the `method` attribute determines how the data is transmitted—using "GET" to append data to the URL or "POST" to include data in the request body.

```html
<form action="/submit" method="post">
  <!-- Form fields here -->

  <!-- Submit button with icon -->
  <button type="submit">Submit</button>

  <!-- OR -->

  <!-- Submit input without icon -->
  <input type="submit" value="Submit">
</form>
```

## 9. Animations

#### 9.1 Transformations

CSS transformations allow you to manipulate elements in various ways directly within your stylesheet. Transformations can rotate, scale, skew, or translate elements, enhancing visual effects and layouts. Multiple transformations can be combined into a single `transform` property, and transformations can also be applied along the z-axis or rotated along the x or y-axis.

| Property           | Description                                                                                       | Syntax Example           |
| ------------------ | ------------------------------------------------------------------------------------------------- | ------------------------ |
| `rotate()`         | Rotates an element around its center point.                                                       | `rotate(45deg)`          |
| `scale()`          | Scales an element up or down in size.                                                             | `scale(1.5)`             |
| `skew()`           | Skews an element along the x and/or y axis.                                                       | `skew(20deg, 10deg)`     |
| `translate()`      | Moves an element horizontally and/or vertically.                                                  | `translate(50px, 100px)` |
| `perspective()`    | Defines the perspective from which an element is viewed.                                          | `perspective(500px)`     |
| `translateZ()`     | Moves an element horizontally along the z-axis. (Apply this in combination with `perspective()`.) | `translateX(100px)`      |
| `rotateX()`        | Rotates an element around the x-axis. (Apply this in combination with `perspective()`.)           | `rotateX(45deg)`         |
| `rotateY()`        | Rotates an element around the y-axis. (Apply this in combination with `perspective()`.)           | `rotateY(45deg)`         |
| `transform-origin` | Sets the origin point for transformations.                                                        | `transform-origin: 0 0`  |

#### 9.2 Transitions

The `transition` property in CSS allows you to create smooth animations for property changes applied to elements. By specifying the properties you want to animate, along with the duration and timing function, you can control how these changes unfold. The timing function dictates the pace of the transition—whether it progresses linearly, speeds up, or slows down. Additionally, you can set a delay to start the transition after a specified period. Transitions can also be applied to multiple properties, enabling a coordinated animation effect.

```css
selector {
  transition: property duration timing-function delay;
}
```

#### 9.3 Animations

CSS animations allow you to create complex animations for web elements by controlling their motion and timing. To define an animation, you use the `@keyframes` rule, where you assign a name to the animation and specify keyframes at different percentages of the animation's duration. Each keyframe defines a style at a specific point in time, allowing for smooth transitions between styles. Once the keyframes are set, you apply the animation to an element using the `animation-name` property, and you can control the duration, iteration count, and timing function with additional properties.

```css
/* Define the keyframes */
@keyframes slideIn {
  0% {
    transform: translateX(-100%);
  }
  50% {
    transform: translateX(50%);
  }
  100% {
    transform: translateX(0);
  }
}

/* Apply the animation to an element */
.box {
  animation-name: slideIn;
  animation-duration: 2s;
  animation-iteration-count: infinite;
}
```

| Property                    | Description                                                      |
| --------------------------- | ---------------------------------------------------------------- |
| `animation-name`            | Specifies the name of the `@keyframes` animation to apply.       |
| `animation-duration`        | Defines the length of time an animation should take to complete. |
| `animation-timing-function` | Sets the speed curve of the animation (e.g., linear, ease).      |
| `animation-iteration-count` | Specifies how many times the animation should repeat.            |

You can also explore online resources like [Animate.css](https://animate.style/), which offers a wide range of pre-built animations. To use these animations, simply include the provided stylesheet in the `<head>` section of your HTML document and apply the appropriate class to the elements you want to animate. This approach saves time and provides access to high-quality animations with minimal effort.

## 10. Writting Clean and Maintanable CSS Code

#### 10.1 Best Practices for Writing CSS Code

- **Follow Naming Conventions**:  
  Consistent naming conventions (like kebab case, camel case, or Pascal case) make your CSS more readable and maintainable. This consistency helps in quickly identifying and understanding the purpose of each class.

- **Create Logical Sections in Your Stylesheet**:  
  Organize your stylesheet into sections like basic styles, typography, forms, etc. This makes it easier to navigate and update specific areas of your code, improving maintainability.

- **Avoid Overly Specific Selectors**:  
  Using overly specific selectors can make your CSS difficult to maintain, as slight changes in HTML structure may break styles. Stick to simpler, more general selectors to ensure flexibility.

- **Minimize the Use of `!important`**:  
  Overusing `!important` can make your CSS harder to debug and override. Use it sparingly to maintain a clean and controllable style hierarchy.

- **Sort CSS Properties**:  
  Sorting CSS properties (e.g., alphabetically) within a rule helps to keep the code clean and consistent, making it easier to read and maintain.

- **Leverage Style Inheritance**:  
  Take advantage of CSS inheritance to avoid repetitive code. This practice reduces redundancy and ensures a more efficient and maintainable stylesheet.

- **Extract Repetitive Patterns**:  
  Identify and extract repetitive patterns into reusable classes or variables. This reduces code duplication and makes your CSS easier to update and manage.

#### 10.2 CSS Variables

CSS variables, also known as custom properties, are a powerful tool for reducing repetition and making your stylesheets more maintainable. By defining variables, you can centralize common values (such as colors, sizes, and fonts) and easily reuse them throughout your CSS code. This approach simplifies updates and ensures consistency across your styles.

To create CSS variables, use the `:root` pseudo-class selector, which represents the highest-level parent in your HTML document. Inside the `:root` selector, you can define your custom properties with a name and value. To reference these variables elsewhere in your stylesheet, use the `var()` function with the variable's name as the argument.

```css
:root {
  --primary-color: #3498db;
}

body {
  color: var(--primary-color);
}
```

#### 10.3 Object-Oriented CSS

Object-Oriented CSS (OOCSS) is a methodology aimed at making CSS more maintainable, scalable, and reusable by applying principles from object-oriented programming to styling. OOCSS is based on two main principles:

1. **Separate the Container from its Elements:** 
   This principle highlights the importance of keeping container (parent element or wrapper) styles separate from the styles of their contained elements (child elements), allowing for independent styling of elements regardless of their container. By doing so, you avoid redundancy and increase flexibility, enabling you to style an element like a button just once and reuse it across different containers without the need for redefinition. To implement this, define styles for containers and elements separately, using classes to ensure elements retain their appearance no matter which container they are placed in, such as styling a `.card` container and a `.button` element independently.
   
   ```css
   .card {
   padding: 20px;
   border: 1px solid #ccc;
   }
   
   .button {
   padding: 10px 20px;
   background-color: #3498db;
   color: #fff;
   }
   ```

2. **Separate Structure and Skin:**
   
   Structure refers to the layout and positioning of elements, while skin encompasses visual aspects like colors, borders, and backgrounds; this principle suggests keeping these two elements separate in CSS. By doing so, you can change the visual appearance (skin) of an element without altering its layout (structure), enhancing modularity and simplifying style maintenance and updates. To apply this, use separate classes for structure and skin, such as a class for button layout (`.btn-layout`) and another for its color scheme (`.btn-primary`), enabling flexible style combinations.
   
   ```css
   .btn-layout {
   display: inline-block;
   padding: 10px 20px;
   text-align: center;
   }
   
   .btn-primary {
   background-color: #3498db;
   color: #fff;
   }
   
   .btn-secondary {
   background-color: #e74c3c;
   color: #fff;
   }
   ```

#### 10.4 BEM Convention

The BEM (Block Element Modifier) naming convention is a methodology for organizing and naming CSS classes to make code more readable, maintainable, and scalable. In BEM, a webpage is conceptualized as a collection of blocks or modules, each of which may contain elements that can be modified. The naming structure is broken down into three parts:

1. **Block**: The standalone entity that represents a component or section of the page (e.g., `header`, `menu`).
2. **Element**: A part of the block that performs a specific function, represented by a double underscore (`__`) followed by the element's name (e.g., `menu__item`).
3. **Modifier**: A variation of a block or element, used to define a different state or style, represented by a double hyphen (`--`) followed by the modifier's name (e.g., `menu__item--active`).

BEM is important because it creates a clear and consistent naming structure that reduces conflicts, improves collaboration, and makes it easier to understand and maintain the code. By following BEM, developers can more easily locate and update specific components and ensure that styles are applied consistently across different parts of a project.

To apply BEM, identify the main blocks on your page, define the elements within those blocks, and use modifiers to represent variations or states. For example, in a navigation menu (`menu` block), individual items would be elements (`menu__item`), and an active item could have a modifier (`menu__item--active`).
