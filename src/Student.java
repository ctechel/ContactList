public class Student extends Person{
    // Instance Variable
    private int grade;
    // Constructor
    public Student(String first, String last, String number, int grade)
    {
        super(first, last, number);
        this.grade = grade;
    }

    // Accessors and Mutators
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    // toString() method
    @Override
    public String toString()
    {
        return super.toString() + " Grade: " + this.grade;
    }
}
