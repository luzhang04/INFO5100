package Assignment5;

public class IceCream extends DessertItem {
    public int iceCreamPrice;
    public IceCream(String name, int iceCreamPrice) {
        this.name = name;
        this.iceCreamPrice = iceCreamPrice;

    }


    @Override
    public int getCost() {
        //System.out.println("icecream cost" + iceCreamPrice);
        return iceCreamPrice;
    }
}
