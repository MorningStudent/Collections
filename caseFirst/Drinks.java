package caseFirst;

public class Drinks extends AVictuals {
    private int volume;  //ml

    public Drinks(String name, int price, int volume) {
        super(name, price);
        setVolume(volume);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString().concat(", volume=" + volume + "]");
    }
    
}
