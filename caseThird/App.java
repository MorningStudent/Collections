package caseThird;

public class App {
    public static void main(String[] args) {

        // Stock stock = new Stock(new Client("Ion Patrascanu", "+37369696696"));

        // stock.addItem(new Item<>(new Product(1001, "Samsung XXII", new Money(1000, Money.Currency.EUR)), 10));
        // stock.addItem(new Item<>(new Product(1002, "Samsung XXIII", new Money(1100, Money.Currency.EUR)), 10));
        // stock.addItem(new Item<>(new Product(1003, "Samsung XXIV", new Money(1200, Money.Currency.EUR)), 10));
        
        // System.out.println("Stock before removing an item by id: \n\n" + stock);
        // System.out.println();
    
        // stock.removeItemById(1002);

        // System.out.println("Stock after removing an item by id: \n\n" + stock);

        Cart cart = new Cart(new Client("Cristina Valcan", "+37369777222"));
        System.out.println(cart);
        System.out.println();

        cart.addItem(new Item<>(new Product(1001, "Samsung XXII", new Money(1000, Money.Currency.EUR)), 1));
        cart.addItem(new Item<>(new Product(1002, "Samsung XXIII", new Money(1100, Money.Currency.EUR)), 3));

        System.out.println(cart);
        System.out.println();

        Item<Product> firstItemInCart = cart.getItemById(1001); // We could initially, declare and initialize Item<Product> objects
                                                                   // to variables and only after that to add items to cart, then to remove
                                                                   // but, I think the ideea was to get a solution for the case when the
                                                                   // the objects were created anonymously.

        cart.removeItem(firstItemInCart); // or cart.removeItem(cart.getItemById(1002)); // the method getItemById --> returns an object,
                                                                                         // and because our objects are mutable, it
                                                                                         // returns the reference to the anonymous obj.
                                                                                         // I guess, it actually creates that reference
                                                                                         // to the anonym obj, since it doesn't have any
        System.out.println(cart);

        cart.decreaseItemQuantity(cart.getItemById(1002), 1);

        System.out.println();
        System.out.println(cart);
    }
}
