public class Employee {

    private String ID;
    private String mFirstName;
    private String mLastName;
    private int mAge;
    private double mSalary;

    public Employee(String id, String firstName, String lastName, int age, double salary ){

        ID = id;
        mFirstName = firstName;
        mLastName = lastName;
        mAge = age;
        mSalary = salary;

    }

    public String toString(){
        return "<" + ID + ", " + mFirstName + ", " + mLastName + ", " + mAge + ", " + mSalary + ">";
    }

}
