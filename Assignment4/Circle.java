package Assignment4;

public class Circle {
    double radius;
    String color;
    Circle() {
    }
    Circle(double radius) {
        setRadius(radius);
    }
    Circle(double radius, String color) {
        setRadius(radius);
        setColor(color);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
