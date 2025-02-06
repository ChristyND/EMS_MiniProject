package DAO;

import java.util.Date;

public class Employee {
    long emp_id;
    String firstName, lastName;
    Date empDate;
    Department dept;

    public Employee (){

    }

    public Employee(String firstName, String lastName, Date empDate, Department dept) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.empDate = empDate;
        this.dept=dept;
        setNewID();
    }

    public Employee(long emp_id, String firstName, String lastName, Date empDate, Department dept) {
        this.emp_id = emp_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.empDate = empDate;
        this.dept=dept;
    }

    public long getID() {
        return emp_id;
    }

    public void setNewID() {
        long minNumber = 0;
        long maxNumber = 999999998;
        this.emp_id = minNumber + (long)(Math.random()*(maxNumber-minNumber) + 1);
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

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

    public Date getEmpDate() {
        return empDate;
    }

    public void setEmpDate(Date empDate) {
        this.empDate = empDate;
    }
}
