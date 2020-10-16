package Assignment5;

import java.text.NumberFormat;
import java.text.DecimalFormat;


public class DessertShoppe {
    public static final String dessertShoppeName = "M & M Dessert Shoppe";
    public static final double taxRate = 0.065;
    public static final int maxSizeItemName = 20;
    public static final int maxWidth = 30;
    public static final NumberFormat numberFormat = new DecimalFormat(".00");



    public String cents2dollarsAndCents(int cents) {
        return numberFormat.format(cents/100.0);
    }
}
