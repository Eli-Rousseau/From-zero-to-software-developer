"use strict";
class Person {
    constructor(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    get fullName() {
        return `${this.firstName} ${this.lastName}`;
    }
}
let person = new Person("Eli", "Rousseau");
console.log(person.fullName);
//# sourceMappingURL=index.js.map