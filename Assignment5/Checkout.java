package Assignment5;

import java.util.ArrayList;
import java.util.List;


public class Checkout {
    private List<DessertItem> list;

    public Checkout() {
        this.list = new ArrayList<>();

    }
    public int numberOfItems() {
        return list.size();
    }
    public void enterItem(DessertItem item) {
        list.add(item);
    }
    public void clear() {
        list.clear();
    }
    public int totalCost() {
        int totalCost = 0;
        for (int i = 0; i < list.size(); i++) {
            totalCost += list.get(i).getCost();
        }
        return totalCost;

    }
    public int totalTax() {

        return (int) Math.round(totalCost() * DessertShoppe.taxRate);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DessertShoppe ds = new DessertShoppe();

        sb.append(DessertShoppe.dessertShoppeName + "\n" + "--------------------\n" + "\n");

        int i = 0;
        while (i < list.size()) {
            if (list.get(i) instanceof Candy) {
                sb.append(((Candy) list.get(i)).getWeight() + " lbs. @ " +
                        ds.cents2dollarsAndCents(((Candy) list.get(i)).getPricePerPound()) + " /lb. " + "\n");
            }
            else if (list.get(i) instanceof Cookie) {
                sb.append(((Cookie) list.get(i)).getNumber() + " @ " +
                        ds.cents2dollarsAndCents(((Cookie) list.get(i)).getPricePerDozen()) + " /dz. " + "\n");
            }
            else if (list.get(i) instanceof Sundae) {
                sb.append(((Sundae) list.get(i)).topName + " Sundae with " + "\n");
            }
            sb.append(list.get(i).name + " " + ds.cents2dollarsAndCents(list.get(i).getCost()) + "\n");
            i++;
        }
        sb.append("Tax " + ds.cents2dollarsAndCents(totalTax()) + "\n" + "Total Cost " +
                ds.cents2dollarsAndCents(totalCost() + totalTax()) + "\n");

        return sb.toString();

    }
}
