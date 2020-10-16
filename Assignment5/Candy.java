package Assignment5;

public class Candy extends DessertItem {
    private double weight;
    private int pricePerPound;

    public Candy(String name, double weight, int pricePerPound) {
        this.name = name;
        this.weight = weight;
        this.pricePerPound = pricePerPound;

    }

    public double getWeight() {
        return weight;
    }

    public int getPricePerPound() {
        return pricePerPound;
    }

    public String getCandyName() {
        return name;
    }

    @Override
    public int getCost() {
        //System.out.println("candy cost" + (int)Math.round(weight * pricePerPound));
        return (int)Math.round(weight * pricePerPound);

    }
}
