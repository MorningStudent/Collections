package caseThird;

public class App {
    public static void main(String[] args) {

        Stock stock = new Stock();
        stock.addItem(new Item<>(new Product(1001, "Samsung XXII", new Money(1000, Money.Currency.EUR)), 10));
        stock.addItem(new Item<>(new Product(1002, "Samsung XXIII", new Money(1100, Money.Currency.EUR)), 10));
        stock.addItem(new Item<>(new Product(1003, "Samsung XXIV", new Money(1200, Money.Currency.EUR)), 10));
        
        System.out.println("Stock before removing an item by id: \n\n" + stock);
        System.out.println();
    
        stock.removeItemById(1002);

        System.out.println("Stock after removing an item by id: \n\n" + stock);
    }
}
