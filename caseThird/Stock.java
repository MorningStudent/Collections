package caseThird;

public class Stock extends AItemRepository {
    private Client owner;

    public Stock(Client owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Stock [owner=" + owner + "]" + super.toString();
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }
    
}
