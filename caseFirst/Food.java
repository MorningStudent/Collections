package caseFirst;

public class Food extends AVictuals{
    private int weight;  //grams

    public Food(String name, int price, int weight) {
        super(name, price);
        setWeight(weight);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString().concat(", weight=" + weight + "]");
    }
    
}
