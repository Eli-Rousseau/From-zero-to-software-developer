"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const generics_1 = __importDefault(require("./generics"));
const articles = [
    { name: "Lamp", price: 1.6 },
    { name: "Tissues", price: 0.55 },
    { name: "Chicken", price: 6.3 },
];
const myStore = new generics_1.default();
console.log(`My store counts ${myStore.getCount()} articles`);
articles.forEach((article) => myStore.addItem(article));
console.log(`My store counts ${myStore.getCount()} articles`);
console.log(`Fetch item: ${myStore.getItem(1).name}`);
console.log(`Removed item: ${myStore.removeItem(1).name}`);
console.log(`My store counts ${myStore.getCount()} articles`);
function logExecutionTime(target, functionName, descriptor) {
    const originalMethod = descriptor.value;
    descriptor.value = function (...args) {
        console.log(`Executing ${functionName}...`);
        const start = performance.now();
        const result = originalMethod.apply(this, args);
        const end = performance.now();
        console.log(`${functionName} executed in ${(end - start).toFixed(2)}ms`);
        return result;
    };
}
class Action {
    action() {
        console.log("This is some text to fill in the space");
    }
}
__decorate([
    logExecutionTime
], Action.prototype, "action", null);
const myActionClass = new Action();
myActionClass.action();
