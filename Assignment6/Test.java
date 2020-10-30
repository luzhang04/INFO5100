package Assignment6;

public class Test {
    public static void main(String[] args) {
        Mreview mr = new Mreview("Kill Bill");
        mr.addRating(3);
        mr.addRating(4);
        mr.addRating(3);
        System.out.println(mr.toString());
        System.out.println(mr.avaRating());
        System.out.println("-----------");



        Pet pet = new Pet("Spot", "Mary", "Black and White");
        pet.setSex(0);
        System.out.println(pet.toString());
        System.out.println("-----------");

        Cat cat = new Cat("Tom", "Bob", "black", "short");
        cat.setSex(2);
        System.out.println(cat.toString());
        cat.setBoardStart(10,1,2020);
        cat.setBoardEnd(9, 1, 2021);
        System.out.println("Boarding is " + cat.boarding(12, 1, 2020));
        System.out.println("-----------");

        Dog dog = new Dog("Spot", "Susan", "white", "medium");
        dog.setSex(2);
        System.out.println(dog.toString());
        dog.setBoardStart(11, 1, 2020);
        dog.setBoardEnd(10, 1, 2021);
        System.out.println("Boarding is " + dog.boarding(10, 1, 2021));

    }
}
