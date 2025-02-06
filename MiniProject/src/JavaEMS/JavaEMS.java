package JavaEMS;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import DAO.Department;
import DAO.Employee;
import Exceptions.DepartmentNotFound;
import Exceptions.EmployeeNotFoundException;

public class JavaEMS {
    static Scanner sc = new Scanner(System.in);

    public JavaEMS(List<Department> depts){
        emsMenu(depts);
    }

    public static void emsMenu (List<Department> depts){       
        List<Employee> employees = new ArrayList<Employee>();

        int select;
        do{
            System.out.println("What would you like to do?");
            System.out.println("\t- 1) Find employee.");
            System.out.println("\t- 2) Add new employee.");
            System.out.println("\t- 3) Update Existing Employee");
            System.out.println("\t- 4) Remove Employee");
            System.out.println("\t- 5) List All Employees");
            System.out.println("\t- Say '0' to end the program");
            select = sc.nextInt();

            switch(select){
                case 1:
                    try{
                        System.out.print("Input employee ID: ");
                        int id = sc.nextInt();
                        Employee target = getEmployee(employees, id);
                        if (target ==null) {
                            throw new EmployeeNotFoundException(id);
                        }
                        else{
                            System.out.println("Employee ID: "+ target.getID());
                            System.out.println("Employee First Name: "+ target.getFirstName());
                            System.out.println("Employee Last Name: "+ target.getLastName());
                            System.out.println("Date of Employment: "+ target.getEmpDate());
                        }
                    }catch(EmployeeNotFoundException e){}
                    //System.out.println("Employee");
                    break;
                case 2: 
                    try {
                        Employee nEmp = addEmployee(depts);
                        employees.add(nEmp);
                    } catch (ParseException e) {
                
                    } catch (DepartmentNotFound e) {

                    }
                    System.out.println("New Employee added!");
                    break;
                case 3:
                    System.out.println("Employee updated!");
                    break;
                case 4:
                    System.out.println("Employee removed!");
                    break;
                case 5:
                    System.out.println("List of Employees");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid Input Value");
                    break;
            }
        }while(select != 0);
    }

    public static void listEmployees(List<Employee> e){

    }

    public static Employee getEmployee(List<Employee> elist, int emp_id){
        for(Employee ee:elist){
            if(ee.getID() == emp_id){
                return ee;
            }
        }

        return null;
        
    }

    public static Employee addEmployee(List<Department> depts) throws ParseException, DepartmentNotFound{
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);

        System.out.println("Enter Employee First Name: ");
        String first = sc.nextLine();

        System.out.println("Enter Employee Last Name: ");
        String last = sc.nextLine();

        System.out.print("Enter Date of Employment: ");
        String dateStr = sc.nextLine();
        Date date = df.parse(dateStr);

        System.out.print("Enter Department ID: ");
        long dID = sc.nextInt();
        Department dept = findDept(depts,dID);
            
        if(dept == null) {
            throw new DepartmentNotFound();
        }else{
            Employee newEmp = new Employee(first,last,date,dept);
            return newEmp;
        }
                            
    }

    public static void updateEmployees(){
        
    }
    public static void deleteEmployees(){
        
    }

    public static Department findDept(List<Department> depts,long dID){
        for(Department d:depts){
            if(d.getDepID() == dID){
                return d;
            }
        }
        return null;
    }

}
