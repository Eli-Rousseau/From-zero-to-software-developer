// Define symbols for private properties and methods
const _privateProperty = Symbol();
const _privateMethod = Symbol();

class MyClass {
  constructor(value) {
    // Using the symbol as a key for a private property
    this[_privateProperty] = value;
  }

  // Using the symbol as a key for a private method
  [_privateMethod]() {
    console.log('This is a private method');
  }

  // Public method to interact with private property
  publicMethod() {
    console.log(`Private Property Value: ${this[_privateProperty]}`);
    this[_privateMethod](); // Calling the private method
  }
}

const instance = new MyClass('Hello, World!');
instance.publicMethod(); // Works, accesses the private property and method

instance[_privateProperty]; // Undefined, cannot access the private property
instance[_privateMethod](); // Error: instance[_privateMethod] is not a function