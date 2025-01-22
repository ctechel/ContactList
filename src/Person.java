
public class Person {
    // Instance Variables
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Constructor
    public Person(String first, String last, String number)
    {
        this.firstName = first;
        this.lastName = last;
        this.phoneNumber = number;
    }

    // Accessors and Mutators
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // toString() method
    public String toString()
    {
        return this.firstName + " " + this.lastName + " - " + this.phoneNumber;
    }
}
