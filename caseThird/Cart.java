package caseThird;

public class Cart extends AItemRepository {
    private Client owner;
    private Money total;

    public Cart(Client owner) {
        this.owner = owner;
        this.total = new Money(0, Money.Currency.EUR);
    }

    @Override
    public String toString() {
        return "Cart [owner=" + owner + ",\ntotal=" + total + "]" + super.toString();
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public void updateTotal() {                  // <--------- HW7*
        Integer updatedAmount = 0;
        for (int i = 0; i < this.getItems().size(); i++) {
            updatedAmount += this.getItems().get(i).getValue().getPrice().getAmount() * this.getItems().get(i).getQuatity();
        }
        total.setAmount(updatedAmount);
    }

    @Override
    public void addItem(Item<Product> item) {
        super.addItem(item);
        // total.setAmount(total.getAmount() + item.getValue().getPrice().getAmount() * item.getQuatity());
        updateTotal(); // <-----------optimization  HW7*
    }

    @Override
    public void removeItemById(Integer id) {
        super.removeItemById(id);
        // total.setAmount(total.getAmount() - getItemById(id).getValue().getPrice().getAmount() * getItemById(id).getQuatity());
        updateTotal(); // <-----------optimization  HW7*
    }

    @Override
    public void removeItem(Item<Product> item) {                          //<--------------HW5 2/2
        super.removeItem(item);
        // total.setAmount(total.getAmount() - item.getValue().getPrice().getAmount() * item.getQuatity());
        updateTotal(); // <-----------optimization  HW7*
    }

    @Override
    public void increaseItemQuantity(Item<Product> item, Integer quantity) {
        super.increaseItemQuantity(item, quantity);
        // total.setAmount(total.getAmount() + item.getValue().getPrice().getAmount() * quantity);
        updateTotal(); // <-----------optimization  HW7*
    }

    @Override
    public void decreaseItemQuantity(Item<Product> item, Integer quantity) {
        super.decreaseItemQuantity(item, quantity);
        // total.setAmount(total.getAmount() - item.getValue().getPrice().getAmount() * quantity);
        updateTotal(); // <-----------optimization  HW7*
    }

}
