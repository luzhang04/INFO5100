package Assignment6;

import java.util.Calendar;

public class Cat extends Pet implements Boardable {
    private String hairLength;
    private Calendar start = Calendar.getInstance();
    private Calendar end = Calendar.getInstance();


    public Cat(String name, String ownerName, String color, String hairLength) {
        super(name, ownerName, color);
        this.hairLength = hairLength;
    }
    public String getHairLength() {
        return hairLength;
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        start.set(year, month, day);
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        end.set(year, month, day);
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        if (month < 1 || month > 12 || day < 1 || day > 31 || year < 1000 || year > 9999 ) {
            System.out.println("False because of the Invalid date");
            return false;
        }
        Calendar date = Calendar.getInstance();
        date.set(year, month, day);
        if (date.equals(start) || date.equals(end)) {
            return true;
        }
        else if (date.after(start) && date.before(end)) {
            return true;
        }
        else {
            return false;
        }
        //return (date.before(end) && date.after(start) || date.equals(start) || date.equals(end));

    }
    public String toString() {
        return "CAT: \n" + super.toString()
                + "\n" + "Hair: " + getHairLength();
    }
}
