package Assignment3;

public class Test {
    public static void main(String args[]) {
        Course course = new Course("INFO5100");
        Student AA = new Student("AA", 11);
        Student BB = new Student("BB", 22);
        Student CC = new Student("CC", 33);
        Student DD = new Student("DD", 44);
        Student EE = new Student("EE", 55);
        Student FF = new Student("FF", 66);
        Student GG = new Student("GG", 77);
        Student HH = new Student("HH", 88);
        Student II = new Student("II", 99);
        Student JJ = new Student("JJ", 00);
        course.registerStudent(AA);
        course.registerStudent(BB);
        course.registerStudent(CC);
        course.registerStudent(DD);
        course.registerStudent(EE);
        course.registerStudent(FF);
        course.registerStudent(GG);
        course.registerStudent(HH);
        course.registerStudent(II);
        course.registerStudent(JJ);
        for (int i = 0; i < course.getNumberOfStudent(); i++) {
            System.out.println("Student " + course.getStudents()[i].getName() + " whose ID is " +
                    course.getStudents()[i].getId() + " registers the course INFO5100.");
        }
        System.out.println(course.isFull());



        // Using builder pattern
        Professor professor = new Professor.Builder("Siva", "Dosapati").setPersonalId(001).build();
    }
}
