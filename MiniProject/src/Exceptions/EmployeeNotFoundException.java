package Exceptions;

public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(long id){
        super("Employee "+ id + " cannot be found");
    }
    public EmployeeNotFoundException(String name){
        super("Employee "+ name + " cannot be found");
    }
}
