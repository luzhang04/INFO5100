package Assignment5;

public class Sundae extends IceCream {
    public String topName;
    public int topPrice;
    public Sundae(String name, int iceCreamPrice, String topName, int topPrice) {
        super(name, iceCreamPrice);
        this.topName = topName;
        this.topPrice = topPrice;
    }
    @Override
    public int getCost() {
        //System.out.println("sundae cost" + (iceCreamPrice + topPrice));
        return iceCreamPrice + topPrice;
    }
}
