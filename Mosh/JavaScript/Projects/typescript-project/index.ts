// generics exercise
import Store from "./generics";

type Article = {
  name: string;
  price: number;
};

const articles: Article[] = [
  { name: "Lamp", price: 1.6 },
  { name: "Tissues", price: 0.55 },
  { name: "Chicken", price: 6.3 },
];

const myStore = new Store<Article>();
console.log(`My store counts ${myStore.getCount()} articles`);

articles.forEach((article) => myStore.addItem(article));
console.log(`My store counts ${myStore.getCount()} articles`);

console.log(`Fetch item: ${myStore.getItem(1).name}`);
console.log(`Removed item: ${myStore.removeItem(1).name}`);
console.log(`My store counts ${myStore.getCount()} articles`);

// decorator exercise
function logExecutionTime(
  target: any,
  functionName: string,
  descriptor: PropertyDescriptor
) {
  const originalMethod = descriptor.value;

    descriptor.value = function (...args: any[]) {
        console.log(`Executing ${functionName}...`);
        const start = performance.now();
        const result = originalMethod.apply(this, args);
        const end = performance.now();
        console.log(`${functionName} executed in ${(end - start).toFixed(2)}ms`);
        return result;
  };
}

class Action {
  @logExecutionTime
  action(): void {
    console.log("This is some text to fill in the space");
  }
}

const myActionClass = new Action();
myActionClass.action();
