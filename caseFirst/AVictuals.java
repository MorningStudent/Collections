package caseFirst;

public abstract class AVictuals {
    private String name;
    private int price;

    protected AVictuals(String name, int price) {
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[name=" + name + ", price=" + price;
    }

    
    
}
