package caseThird;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<Item<Product>> items;

    public Stock() {
        items = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Stock [products=" + items + "]";
    }

    public void addItem(Item<Product> product) {
        items.add(product);
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

    public void removeItemById(Integer id) {                                       //<---------HW2
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getValue().getId().intValue() == id.intValue()) {
                items.remove(items.get(i));
                break;
            }
        }
    }

}
