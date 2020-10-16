package Assignment5;

public abstract class DessertItem {
    public String name;

    public DessertItem() {
    }

    public DessertItem(String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    public abstract int getCost();
}
