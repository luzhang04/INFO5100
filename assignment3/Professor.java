package Assignment3;

public class Professor {
    private String firstName;
    private String lastName;
    private int personalId;

    public static class Builder {
        private String firstName;
        private String lastName;
        private int personalId;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder setPersonalId(int personalId) {
            this.personalId = personalId;
            return this;
        }

        public Professor build() {
            // call the private constructor in the outer class
            return new Professor(firstName, lastName, personalId);
        }
    }

    public Professor(String firstName, String lastName, int personalId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalId = personalId;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
}

