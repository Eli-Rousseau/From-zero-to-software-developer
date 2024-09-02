const person = {
    name: 'Eli',
    greet: function() {
        const innerFunction = function() {
            console.log(`Hello, my name is ${this.name}`)
        };
        innerFunction();
    }
};

person.greet(); // Outputs: Hello, my name is undefined


const person = {
    name: 'Eli',
    greet: function() {
        const innerFunction = () => {
            console.log(`Hello, my name is ${this.name}`);
        };
        innerFunction();
    }
};

person.greet(); // Outputs: Hello, my name is Eli