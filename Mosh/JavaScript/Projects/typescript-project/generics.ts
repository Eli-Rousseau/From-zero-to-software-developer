class Store<T> {
    private items: T[] = [];

    public addItem(newItem: T): void {
        this.items.push(newItem);
    }

    public removeItem(index: number): T {
        const removedItem = this.getItem(index)
        this.items.splice(index, 1);
        return removedItem;
    }

    public getItem(index: number): T {
        return this.items[index];
    }

    public getCount(): number {
        return this.items.length;
    }
}

export default Store;