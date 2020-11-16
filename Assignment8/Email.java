package Assignment8;

import java.util.Random;
import java.util.Scanner;

public class Email {

    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";
    private String firstName, lastName;
    private String department;
    private static final int SALES = 1, DEVELOPMENT = 2, ACCOUNTING = 3, NONE = 0;

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Ask for the department
    private String SetDepartment() {
        System.out.println("New Worker:" + getName() + ". Department Codes: \n" +
                "1 for Sales\n" +
                "2 for Development\n" +
                "3 for Accounting\n" +
                "0 for none\n" +
                "Enter department code: \n");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        if ( num == NONE) {
            department = "none";
        } else if ( num == SALES) {
            department = "sales";
        } else if ( num == DEVELOPMENT) {
            department = "dev";
        } else if ( num == ACCOUNTING) {
            department = "acc";
        } else {
            System.out.println("Invalid input");
        }
        return department;
    }

    // Generate a random password
    private String randomPassword(int length) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(s.length());
            sb.append(s.charAt(num));
        }
        return sb.toString();
    }

    private void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }
    public String getName() {
        return firstName + " " + lastName;
    }
    public String getPassword() {
        return randomPassword(defaultPasswordLength);
    }
    public String getEmail() {
        return firstName + "." + lastName + "@" + department + "." + companySuffix;
    }
    public String getDepartment() {
        return SetDepartment();
    }
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String showInfo() {

        return "DISPLAY NAME: " + getName() + "\n" +
                "DEPARTMENT: " + getDepartment() + "\n" +
                "COMPANY EMAIL: " + getEmail() + "\n" +
                "PASSWORD: " + getPassword() + "\n" +
                "MAILBOX CAPACITY: " + getMailboxCapacity() + "mb";
    }

}
