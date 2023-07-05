package caseThird;

public class Item <T> {
    private T value;
    private Integer quatity;

    public Item(T value, Integer quatity) {
        this.value = value;
        this.quatity = quatity;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Integer getQuatity() {
        return quatity;
    }

    public void setQuatity(Integer quatity) {
        this.quatity = quatity;
    }

    @Override
    public String toString() {
        return "Item [value=" + value + ", quatity=" + quatity + "]";
    } 

}
