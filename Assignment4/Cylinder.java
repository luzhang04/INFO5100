package Assignment4;

public class Cylinder extends Circle {
    double height;
    Cylinder() {
    }
    Cylinder(double height) {
        setHeight(height);
    }
    Cylinder(double height, double radius) {
        super(radius);
        setHeight(height);
    }
    Cylinder(double height, double radius, String color) {
        super(radius,color);
        setHeight(height);
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume() {
        return height * super.getArea();
    }
    @Override
    public double getArea() {
        return 2 * Math.PI * radius * (radius + height);
    }
}
