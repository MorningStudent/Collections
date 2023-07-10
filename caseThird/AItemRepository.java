package caseThird;

import java.util.ArrayList;
import java.util.List;

public abstract class AItemRepository {
    private List<Item<Product>> items;

    public AItemRepository() {
        items = new ArrayList<>();
    }

    public List<Item<Product>> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "\n[products=" + items + "]";
    }

    public void addItem(Item<Product> item) throws ItemStockQuantityLackException {
        items.add(item);
    }
    
    public Item<Product> getItemById(Integer id) {
        Item<Product> item = null;
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getValue().getId().intValue() == id.intValue()) {
                item = items.get(i);
                break;
            }
        }
        return item;
    }

    public Item<Product> getItemByProduct(Product product) {
        return getItemById(product.getId());
    }

    public void removeItemById(Integer id) {                                       
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getValue().getId().intValue() == id.intValue()) {
                items.remove(items.get(i));
                break;
            }
        }
    }

    public void removeItem(Item<Product> item) {
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getValue().equals(item.getValue())) {
                items.remove(items.get(i));
                break;
            }
        }
    }

    public void increaseItemQuantity(Item<Product> item, Integer quantity) throws ItemStockQuantityLackException {
        if(quantity > 0) {
            for (int i = 0; i < items.size(); i++) {
                if(items.get(i).getValue().equals(item.getValue())) {
                    items.get(i).setQuatity(items.get(i).getQuatity() + quantity);
                    break;
                }
            }
        } else {                                                                              
            System.err.println("Quantity that increases must be >= 1 !!!");
        }
    }

    public void decreaseItemQuantity(Item<Product> item, Integer quantity) {

        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getValue().equals(item.getValue())) {
                if(quantity.intValue() < items.get(i).getQuatity().intValue()) {
                    items.get(i).setQuatity(items.get(i).getQuatity() - quantity);
                    break;
                } else if(quantity.intValue() >= items.get(i).getQuatity().intValue()) {
                    removeItem(item);
                    break;
                } else {
                    System.err.println("Decrease Quantity ERROR !!!");
                    break;
                }
            }
        }
    }

}
