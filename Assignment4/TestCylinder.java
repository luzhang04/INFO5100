package Assignment4;

public class TestCylinder {
    public static void main(String[] args) {

        Circle circle = new Circle();
        circle.setRadius(2.0);
        circle.setColor("yellow");
        System.out.println("This circle's radius is " + circle.getRadius() +
                ", color is " + circle.getColor() + ", base area is " + circle.getArea());

        Cylinder cylinder1 = new Cylinder();
        cylinder1.setHeight(1.0);
        cylinder1.setRadius(1.0);
        cylinder1.setColor("red");
        System.out.println("This cylinder1's radius is " + cylinder1.getRadius() + ", height is " +
                cylinder1.getHeight() + ", color is " + cylinder1.getColor() + ", base area is " +
                cylinder1.getArea() + ", volume is " + cylinder1.getVolume());


        Cylinder cylinder2 = new Cylinder(5.0, 2.0);
        cylinder2.setColor("red");
        System.out.println("This cylinder2's radius is " + cylinder2.getRadius() + ", height is " +
                cylinder2.getHeight() + ", color is " + cylinder2.getColor() + ", base area is " +
                cylinder2.getArea() + ", volume is " + cylinder2.getVolume());
    }
}
