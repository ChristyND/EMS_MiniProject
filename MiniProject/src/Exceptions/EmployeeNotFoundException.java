package Exceptions;

public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(int empID){
        super("Employee "+ empID + "cannot be found");
    }
}
