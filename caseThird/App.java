package caseThird;
import com.github.javafaker.Faker;


public class App {
    public static void main(String[] args) throws ItemStockQuantityLackException {

        Faker faker = new Faker();

        Stock stock = new Stock();

        Product product1 = new Product(faker.number().numberBetween(1, 2000), faker.commerce().productName(), new Money(1000, Money.Currency.EUR));
        Product product2 = new Product(faker.number().numberBetween(1, 2000), faker.commerce().productName(), new Money(1100, Money.Currency.EUR));
        Product product3 = new Product(faker.number().numberBetween(1, 2000), faker.commerce().productName(), new Money(1200, Money.Currency.EUR));

        stock.addItem(new Item<>(product1, 10));
        stock.addItem(new Item<>(product2, 10));
        stock.addItem(new Item<>(product3, 10));
        
        Cart cart = new Cart(new Client(faker.name().fullName(), faker.phoneNumber().cellPhone()), stock);


        cart.addItem(new Item<>(product1, 3));
        cart.addItem(new Item<>(product3, 6));

        System.out.println(stock);
        System.out.println();
        System.out.println(cart);

        cart.increaseItemQuantity(cart.getItemByProduct(product1), 2);
        System.out.println();

        System.out.println(stock);
        System.out.println();
        System.out.println(cart);

    }
}
