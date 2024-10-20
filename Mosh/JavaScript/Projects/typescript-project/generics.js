"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Store {
    constructor() {
        this.items = [];
    }
    addItem(newItem) {
        this.items.push(newItem);
    }
    removeItem(index) {
        const removedItem = this.getItem(index);
        this.items.splice(index, 1);
        return removedItem;
    }
    getItem(index) {
        return this.items[index];
    }
    getCount() {
        return this.items.length;
    }
}
exports.default = Store;
