package caseThird;

public class Cart extends AItemRepository {
    private Client owner;
    private Money total;
    private AItemRepository stock;

    public Cart(Client owner, AItemRepository stock) {
        this.owner = owner;
        this.stock = stock;
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

    private Item<Product> getStockItem(Item<Product> item) {
        return stock.getItemById(item.getValue().getId());
    }

    private Integer getStockItemQuantity(Item<Product> item) {
        return getStockItem(item).getQuatity();
    }

    public void updateTotal() {
        Integer updatedAmount = 0;
        for (int i = 0; i < this.getItems().size(); i++) {
            updatedAmount += this.getItems().get(i).getValue().getPrice().getAmount() * this.getItems().get(i).getQuatity();
        }
        total.setAmount(updatedAmount);
    }

    @Override
    public void addItem(Item<Product> item) throws ItemStockQuantityLackException {
        if (getStockItemQuantity(item) < item.getQuatity()) {
            throw new ItemStockQuantityLackException("ERROR: The stock has less quantity than it's added in cart!");
        }
        super.addItem(item);
        getStockItem(item).setQuatity(getStockItem(item).getQuatity() - item.getQuatity());
        updateTotal();
    }    

    @Override
    public void removeItemById(Integer id) {
        Item<Product> item = getItemById(id);
        getStockItem(item).setQuatity(getStockItem(item).getQuatity() + item.getQuatity());
        super.removeItemById(id);
        updateTotal();
    }

    @Override
    public void removeItem(Item<Product> item) {
        getStockItem(item).setQuatity(getStockItem(item).getQuatity() + item.getQuatity());
        super.removeItem(item);
        updateTotal();
    }

    @Override
    public void increaseItemQuantity(Item<Product> item, Integer quantity) throws ItemStockQuantityLackException {
        if (getStockItemQuantity(item) < quantity) {
            throw new ItemStockQuantityLackException("ERROR: The stock has less quantity than it's intended to be increased in the cart!");
        }
        super.increaseItemQuantity(item, quantity);
        getStockItem(item).setQuatity(getStockItem(item).getQuatity() - quantity);
        updateTotal();
    }

    @Override
    public void decreaseItemQuantity(Item<Product> item, Integer quantity) {
        getStockItem(item).setQuatity(getStockItem(item).getQuatity() + quantity);
        super.decreaseItemQuantity(item, quantity);
        updateTotal();
    }

}

class ItemStockQuantityLackException extends Exception {
    public ItemStockQuantityLackException (String message) {
        super(message);
    }
}

