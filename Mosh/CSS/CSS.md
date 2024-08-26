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

#### 5.7 Flex Box

#### 5.8 Grid Layouts

#### 5.9 Media Queries
