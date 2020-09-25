import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee {
    String name;
    int age;
    Gender gender;
    double salary;// salary per month

    // Constructor. Please set all the data in constructor.
    public Employee(String name, int age, Gender gender, double salary) {
        setName(name);
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    // Getter for `name`. Return the current `name` data
    public String getName() {
        return name;
    }

    // Setter for `name`. Set `name` data
    public void setName(String name) {
        this.name = name;
    }
    public void raiseSalary(double byPercent) {
        salary = byPercent * salary * 0.01;
        System.out.println(salary);
    }
}

enum Gender {
    MALE,
    FEMALE;
}

public class Assignment2_1 {

// Assignment

    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
    public double socialSecurityTax(Employee employee) {
        double tax = 0.0;
        if (employee.salary <= 8900) {
            tax = 0.062 * employee.salary;
        } else if (employee.salary > 8900) {
            tax = 0.062 * 106800;
        }
        return tax;
    }
    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    public double insuranceCoverage(Employee employee) {
        double insurancecoverage;
        if (employee.age < 35) {
            insurancecoverage = 0.03 * employee.salary;
        } else if (35 <= employee.age && employee.age <= 50) {
            insurancecoverage = 0.04 * employee.salary;
        } else if (50 < employee.age && employee.age < 60) {
            insurancecoverage = 0.05 * employee.salary;
        } else {
            insurancecoverage = 0.06 * employee.salary;
        }
        return insurancecoverage;
    }
    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public void sortSalary(Employee e1, Employee e2, Employee e3) {
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.sort(Comparator.comparingDouble(a -> a.salary));
        for (Employee employee : employeeList) {
            System.out.print(employee.getName() + " ");
        }
        System.out.println();
    }

    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public void tripleSalary(Employee employee) {
        employee.raiseSalary(300);
    }

    //Extra credit

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
     write your understanding here.
     Because Java is pass by value.
     The method does not change the object references that are stored in the variables a and b.
     In swap method, the x and y parameters are initialized with the copies of these references.
     The method then proceeds to swap these copies.
     But when the method ends, the parameter variables x and y are abandoned.
     The original variables a and b still refer to the same objects as they did before the method call.
    */
    public static void main(String[] args) {
        Assignment2_1 ass2_1 = new Assignment2_1();
        Employee e1 = new Employee("Jenny", 20, Gender.FEMALE, 2000.1);
        Employee e2 = new Employee("John", 50, Gender.MALE, 2000);
        Employee e3 = new Employee("Jina", 70, Gender.FEMALE, 7000);

        System.out.println(ass2_1.socialSecurityTax(e1));
        System.out.println(ass2_1.insuranceCoverage(e1));
        ass2_1.sortSalary(e1, e2, e3);
        ass2_1.tripleSalary(e1);



        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
        Employee b = new Employee("John", 30, Gender.MALE, 2500);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }
}
