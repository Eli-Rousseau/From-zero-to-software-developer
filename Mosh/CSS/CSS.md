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

#### 7.2 Background Images

#### 7.3 CSS Sprites

#### 7.4 Data URLs

#### 7.5 Clipping Images

#### 7.6 Applying Filters

#### 7.7 Supporting High-Density Screens

#### 7.8 Resolution Switching

#### 7.9 Using Modern Image Formats

#### 7.10 Art Direction

#### 7.11 Scalable Vector Graphics
