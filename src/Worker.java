public class Worker extends Person{
    // Instance Variables
    private String job;
    // Constructor
    public Worker(String first, String last, String number, String job)
    {
        super(first, last, number);
        this.job = job;
    }
    // Accessors and Mutators
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    // toString() method
    @Override
    public String toString()
    {
        return super.toString() + " Job: " + this.job;
    }
}
