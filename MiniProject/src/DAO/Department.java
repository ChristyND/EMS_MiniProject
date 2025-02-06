package DAO;

public class Department {
    long depID;
    String name;
    String phoneNumber;
    long budget;

    public Department() {
    }
    public Department(String name, String phoneNumber, long budget) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.budget = budget;
        setNewDepID();
    }

    public Department(long depID, String name, String phoneNumber, long budget) {
        this.depID=depID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.budget = budget;
    }

    public long getDepID() {
        return depID;
    }
    public void setNewDepID() {
        long minNumber = 1000;
        long maxNumber = 99999;
        this.depID = minNumber + (long)(Math.random() * (maxNumber-minNumber) + 1);    
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public long getBudget() {
        return budget;
    }
    public void setBudget(long budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Department [depID=" + depID + ", name=" + name + ", phoneNumber=" + phoneNumber + ", budget=" + budget
                + "]";
    }
    
}

