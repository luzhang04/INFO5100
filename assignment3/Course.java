
package Assignment3;


public class Course {
    String name;
    int numberOfStudent;
    Student[] students;

    public Course(String name) {
        this.name = name;
        students = new Student[10];
    }

    public Student[] getStudents() {
       return students;
    }

    public boolean isFull() {
        if (numberOfStudent == 10) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    //method registerStudent (Student student): if the course is not full, register a student in course.
    public void registerStudent(Student student) {
        if (! isFull()) {
            students[numberOfStudent] = student;
            numberOfStudent++;
        }
        else {
            throw new IllegalArgumentException(getName() + " cannot be registered because it is full");
        }
    }
}
