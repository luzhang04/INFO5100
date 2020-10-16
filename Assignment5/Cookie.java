package Assignment5;

public class Cookie extends DessertItem {
    private int number;
    private int pricePerDozen;

    public Cookie(String name, int number, int pricePerDozen) {
        this.name = name;
        this.pricePerDozen = pricePerDozen;
        this.number = number;

    }

    public int getNumber() {
        return number;
    }

    public int getPricePerDozen() {
        return pricePerDozen;
    }

    public String getCookieName() {
        return name;
    }

    @Override
    public int getCost() {
        //System.out.println("cookie cost" + ((int)Math.round(number * pricePerDozen  / 12)));
        return (int)Math.round(number * pricePerDozen  / 12);
    }
}
