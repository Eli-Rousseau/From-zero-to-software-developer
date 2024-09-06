class Food {
    public price: number;

    constructor(price: number) {this.price = price}
}

class Pizza extends Food{
    public type: string;
    constructor(price: number, type: string) {
        super(price);
        this.type = type;
    }
}

const food: Pizza = new Pizza(20, 'fresh');