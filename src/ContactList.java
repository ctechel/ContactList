// ContactList by Carter Techel
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    // Instance Variables
    private ArrayList<Person> contacts;

    // Constructor
    public ContactList()
    {
        contacts = new ArrayList<Person>();
    }

    // Accessors and Mutators
    public ArrayList<Person> getContacts()
    {
        return this.contacts;
    }

    public void addContact(Person p)
    {
        contacts.add(p);
    }

    // Prints all of the contacts in the ContactList
    public void printContacts()
    {
        for (Person contact : contacts)
        {
            System.out.println(contact.toString());
        }
    }

    // Uses bubble sort to sort items in the list
    public void sort(int sortBy){
        for (int i = 0; i < contacts.size() - 1; i++)
        {
            for (int j = 0; j < contacts.size() - 1; j++)
            {
                // If the second contact comes first switch the contacts otherwise leave them the same
                // Use helper method to help find which contact comes first
                if(compare(contacts.get(j), contacts.get(j + 1), sortBy) > 0)
                {
                    Person tempP = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, tempP);
                }
            }
        }
    }

    // Helper method for sort to compare which value is bigger or smaller
    public int compare(Person p1, Person p2, int sort)
    {
        // Sorts by first name
        if (sort == 0)
        {
            // Compare which string comes first alphabetically
            return p1.getFirstName().compareTo(p2.getFirstName());
        }
        // Sorts by last name
        else if (sort == 1)
        {
            // Compare which string comes first alphabetically
            return p1.getLastName().compareTo(p2.getLastName());
        }
        // Sorts by phone number
        else
        {
            // Compare which phone number comes first numerically
            return p1.getFirstName().compareTo(p2.getFirstName());
        }
    }

    // Search Methods
    // Find person in contact list with first name
    public Person searchByFirstName(String firstName)
    {
        // Will return person not index of person in the contact list
        for (Person contact: contacts)
        {
            if(contact.getFirstName().equals(firstName))
            {
                return contact;
            }
        }
        // If there is no one the same return null
        return null;
    }

    // Find person in contact list with last name
    public Person searchByLastName(String lastName)
    {
        // Will return person not index of person in the contact list
        for (Person contact: contacts)
        {
            if(contact.getLastName().equals(lastName))
            {
                return contact;
            }
        }
        // If there is no one the same return null
        return null;
    }

    // Find person in contact list with phone number
    public Person searchByPhoneNumber(String phoneNumber)
    {
        // Will return person not index of person in the contact list
        for (Person contact: contacts)
        {
            if(contact.getPhoneNumber().equals(phoneNumber))
            {
                return contact;
            }
        }
        // If there is no one the same return null
        return null;
    }

    // Prints only students in the contact list
    public void listStudents()
    {
        // For each contact in the contact list
        for (Person contact: contacts)
        {
            // If the contact is a student the print them otherwise don't
            if (contact instanceof Student)
            {
                System.out.println(contact.toString());
            }
        }
    }

    // Prints only workers in the contact list
    public void listWorkers()
    {
        // For each contact in the contact list
        for (Person contact: contacts)
        {
            // If the contact is a student the print them otherwise don't
            if (contact instanceof Worker)
            {
                System.out.println(contact.toString());
            }
        }
    }

    // Print start screen for Contact List
    public void run() {
        Scanner s1 = new Scanner(System.in);
        int number = 1;
        System.out.println("Welcome to your Contacts List");
        while (number != 0) {
            System.out.println("Please pick from the following menu options");
            System.out.println("\nMenu: \n1. Add Contact \n2. List All Contacts By First Name \n3. List All Contacts By " +
                    "Last Name \n4. List All Contacts By Phone Number \n5. List All Students \n6. Search By First Name " +
                    "\n7. Search By Last Name \n8. Search By Phone Number \n0. Exit");

            number = s1.nextInt();
            s1.nextLine();
            // If they choose to add a Person contact
            if (number == 1) {
                System.out.println("Is it a ... \n1. Person\n2. Student\n3. Worker");
                int choice = s1.nextInt();
                s1.nextLine();
                // Prompt the user for the persons attributes
                System.out.println("What is there first name?");
                String name = s1.nextLine();
                System.out.println("What is there last name?");
                String last = s1.nextLine();
                System.out.println("What is there phone number?");
                String num = s1.nextLine();
                // If they chose to add a Person
                if (choice == 0)
                {
                    contacts.add(new Person(name, last, num));
                }
                // If they chose to add a student
                else if (choice == 1)
                {
                    System.out.println("What is there grade?");
                    int grade = s1.nextInt();
                    s1.nextLine();
                    contacts.add(new Student(name, last, num, grade));
                }
                // If they chose to add a worker
                else
                {
                    System.out.println("What is there job?");
                    String job = s1.nextLine();
                    contacts.add(new Student(name, last, num, job));
                }
            }

            // List by first name
            if (number == 2) {
                sort(0);
                printContacts();
            }
            // List by last name
            if (number == 3) {
                sort(1);
                printContacts();
            }
            // List by phone number
            if (number == 4) {
                sort(2);
                printContacts();
            }
            // List all students
            if (number == 5) {
                listStudents();
            }
            // Search by first name
            if (number == 6) {
                System.out.println("Enter a name");
                String name = s1.nextLine();
                if (searchByFirstName(name) != null) {
                    System.out.println(searchByFirstName(name));
                } else {
                    System.out.println(name + " is not in the list");
                }
            }
            // Search by last name
            if (number == 7) {
                System.out.println("Enter a name");
                String name = s1.nextLine();
                if (searchByLastName(name) != null) {
                    System.out.println(searchByLastName(name));
                } else {
                    System.out.println(name + " is not in the list");
                }
                // Search by phone number
                if (number == 8) {
                    System.out.println("Enter a name");
                    String num = s1.nextLine();
                    if (searchByPhoneNumber(num) != null) {
                        System.out.println(searchByPhoneNumber(num));
                    } else {
                        System.out.println(num + " is not in the list");
                    }
                }
                System.out.println("Thank you for using the Contact List!");
            }
        }
    }
    public static void main(String[] args) {
        ContactList list = new ContactList();
        list.run();
    }
}
