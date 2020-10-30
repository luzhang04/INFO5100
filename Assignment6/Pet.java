package Assignment6;

public class Pet {
    private String name, ownerName, color;
    protected int sexid;
    public static final int MALE = 0, FEMALE = 1, SPAYED = 2, NEUTERED = 3;

    public Pet(String name, String ownerName, String color) {
        this.name = name;
        this.ownerName = ownerName;
        this.color = color;
    }
    public String getPetName() {
        return name;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public String getColor() {
        return color;
    }
    public void setSex(int sexid) {
        this.sexid = sexid;
    }

    public String getSex() {
        if (sexid == MALE) {
            return "Male";
        }
        else if (sexid == FEMALE) {
            return "Female";
        }
        else if (sexid == SPAYED) {
            return "Spayed";
        }
        else if (sexid == NEUTERED) {
            return "Neutered";
        }
        else {
            return "UNKNOWN";
        }
    }
    public String toString() {
        return getPetName() + " owned by " + getOwnerName() + "\n"
                + "Color: " + getColor() + "\n" + "Sex: " + getSex();
    }

}
