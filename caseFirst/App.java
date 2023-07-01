package caseFirst;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        
        List<AVictuals> items = new ArrayList<>();

        System.out.println("initial: " + items.size());

        items.add(new Food("Pizza Calzone", 120, 475));
        items.add(new Food("Salad Caesar", 90, 300));
        items.add(new Drinks("Long Island Ice Tea", 100, 500));

        System.out.println("after adding some itmes: " + items.size());
        System.out.println();

        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
        
        System.out.println();
        items.remove(0);
        System.out.println("After removing an item:\n");

        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
    }
}