function MyConstructor(value) {
    this.value = value;
  
    // Regular method
    this.showValue = function() {
      console.log(this.value); // 'this' refers to the global object
    };
  }
  
  const obj1 = new MyConstructor("Hello");
  
  // Calling the method with 'this' bound to obj1
  obj1.showValue(); // Output: "Hello"
  
  // Using call() to change 'this' context
  const obj2 = { value: "World" };
  obj1.showValue.call(obj2); // Output: "World"