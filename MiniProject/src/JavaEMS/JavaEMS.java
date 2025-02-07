package JavaEMS;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.Department;
import DAO.Employee;
import Exceptions.DepartmentNotFound;
import Exceptions.EmployeeNotFoundException;

public class JavaEMS {
    static Scanner sc = new Scanner(System.in);

    public JavaEMS(){
        ArrayList<Department> depts = generateDeptList();
            System.out.println("+-------------------------------------------------------------------+");
            System.out.println("| List of Current Departments                                       |");
            System.out.println("+-------------------------------------------------------------------+");
        for(Department d:depts){
                System.out.println("| "+d.toString());
        }
        System.out.println("+-------------------------------------------------------------------+");

        System.out.println();
        emsMenu(depts);
    }

    /*
     * This program initializes a list of Departments
     */
    public static ArrayList<Department> generateDeptList(){
        ArrayList<Department> depts = new ArrayList<Department>();

        depts.add(new Department("Corporate","1-800-999-9999",1500000000));
        depts.add(new Department("Operations Management","1-800-888-8888",35000000));
        depts.add(new Department("Human Resources","1-800-777-7777",15000000));
        depts.add(new Department("Finance","1-800-567-1436",50000000));
        depts.add(new Department("Marketing","1-800-234-1543",1500000000));
        depts.add(new Department("Information Technology","1-800-456-7890",1500000000));

        return depts;
    }

    public static void emsMenu (List<Department> depts){       
        List<Employee> employees = new ArrayList<Employee>();

        String select;
        do{
            System.out.println("+-------------------------------------------------------+");
            System.out.println("| What would you like to do?                            |");
            System.out.println("+-------------------------------------------------------+");
            System.out.println("|   1) Find employee.                                   |");
            System.out.println("|   2) Add new employee.                                |");
            System.out.println("|   3) Update Existing Employee                         |");
            System.out.println("|   4) Remove Employee                                  |");
            System.out.println("|   5) List All Employees                               |");
            System.out.println("| Say '0' to end the program                            |");
            System.out.println("+-------------------------------------------------------+");
            select = sc.nextLine();

            switch(select){
                case "1":
                    getEmployee(employees);
                    break;
                case "2":
                    try {
                        Employee nEmp = addEmployee(depts);
                        employees.add(nEmp);
                    } catch (DepartmentNotFound e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    try {
                        updateEmployees(depts,employees);
                    } catch (EmployeeNotFoundException e) {
                        System.out.println(e.getMessage());
                    }catch(DepartmentNotFound e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4":
                    try {
                        deleteEmployees(employees);
                    } catch (EmployeeNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "5":
                    listEmployees(employees);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid Input Value");
                    break;
            }
        }while(!select.equals("0"));
    }

    public static void listEmployees(List<Employee> employees){
        System.out.println("+-------------------------------------------------------+");
        System.out.println("| List of Employees                                     |");
        System.out.println("+--------------------------------------------------------");
         for(Employee e:employees){
            System.out.println("| Employee ID: "+e.getID());
            System.out.println("| Employee Name: "+e.getFirstName()+" "+e.getLastName());
            System.out.println("| Department: "+(e.getDept()).getName());
            System.out.println("| Date of Employment: "+e.getEmpDate());
            System.out.println("+--------------------------------------------------------");
        }        
    }

    public static void getEmployee(List<Employee> elist){
        try{
            System.out.print("Input Employee's full name or ID: ");
            //long emp_id = sc.nextInt();
            String employee = sc.nextLine();
            Employee target = null;

            if(isIDNumber(employee)){
                            target = findEmployeeID(elist, Long.parseLong(employee));
                        }else{
                            target = findEmployeeName(elist, employee.split(" "));
                        }
            
                        //Employee target = findEmployee(elist, emp_id);
            
                        if (target ==null) {
                            throw new EmployeeNotFoundException(employee);
                        }
                        else{
                            System.out.println("+-------------------------------------------------------+");
                            System.out.println("| Employee Data                                         |");
                            System.out.println("+-------------------------------------------------------+");
                            System.out.println("| Employee ID: "+ target.getID());
                            System.out.println("| Employee Name: "+ target.getFirstName()+" "+target.getLastName()+"        |");
                            System.out.println("| Date of Employment: "+ target.getEmpDate());
                            System.out.println("| Department: "+ (target.getDept()).getName());
                            System.out.println("+-------------------------------------------------------+");
            
                        }
                    }catch(EmployeeNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                }
            

    public static Employee addEmployee(List<Department> depts) throws DepartmentNotFound{
        System.out.println("Enter Employee First Name: ");
        String first = sc.nextLine();

        System.out.println("Enter Employee Last Name: ");
        String last = sc.nextLine();

        System.out.print("Enter Date of Employment(MM-DD-YYYY): ");
        String dateStr = sc.nextLine();

        System.out.print("Enter Department Name: ");
        String dID = sc.nextLine();

        Department dept;

        if(dID.matches("[-+]?\\d*\\.?\\d+")){
            dept = findDeptID(depts, Long.parseLong(dID));
        }else{
            dept = findDeptName(depts, dID);
        }

        //Department dept = findDept(depts,dID);
            
        if(dept == null) {
            throw new DepartmentNotFound();
        }else{
            Employee newEmp = new Employee(first,last,dateStr,dept);
            System.out.println("New Employee added!");
            return newEmp;
        }
                            
    }

    public static void updateEmployees(List<Department> depts,List<Employee> elist) throws EmployeeNotFoundException, DepartmentNotFound{
        System.out.println("Enter the id or full name of the employee you want to update: ");
        //long findID = sc.nextInt();
        String findID = sc.nextLine();
        Employee updEmp = null;

        if(isIDNumber(findID)){
            updEmp = findEmployeeID(elist, Long.parseLong(findID));
        }else{
            updEmp = findEmployeeName(elist, findID.split(" "));
        }
        //Employee updEmp = findEmployee(elist, findID);
        if(updEmp==null){
            throw new EmployeeNotFoundException(0);
        }else{
            updateMenu(depts, updEmp);
            System.out.println("Employee updated!");
        }
        
        
    }

    public static void deleteEmployees(List<Employee> elist) throws EmployeeNotFoundException{
        System.out.println("Enter the id or full name of the employee you want to delete: ");
        //long findID = sc.nextInt();
        String findID = sc.nextLine();
        Employee removeEmp = null;

        if(isIDNumber(findID)){
            removeEmp = findEmployeeID(elist, Long.parseLong(findID));
        }else{
            removeEmp = findEmployeeName(elist, findID.split(" "));
        }
        //Employee removeEmp = findEmployee(elist, findID);
        if(removeEmp==null){
            throw new EmployeeNotFoundException(0);
        }else{
            elist.remove(removeEmp);
            System.out.println("Employee removed!");
        }
        
    }

    public static void updateMenu(List<Department> depts, Employee updEmp) throws DepartmentNotFound{
        String select = null;
        do{
            System.out.println("+-------------------------------------------------------+");
            System.out.printf("| What would you like to do with %s? |\n", updEmp.getFirstName()+" "+updEmp.getLastName());
            System.out.println("+-------------------------------------------------------+");
            System.out.println("| 1) Update First Name                                  |");
            System.out.println("| 2) Update Last Name.                                  |");
            System.out.println("| 3) Update Date of Employment                          |");
            System.out.println("| 4) Update Department                                  |");
            System.out.println("| Say '0' to exit update menu                           |");
            System.out.println("+-------------------------------------------------------+");
            select = sc.nextLine();

            switch (select) {
                case "1":
                    System.out.println("Input New First Name: ");
                    String newFirst = sc.nextLine();
                    updEmp.setFirstName(newFirst);
                    break;
                case "2":
                    System.out.println("Input New Last Name: ");
                    String newLast = sc.nextLine();
                    updEmp.setLastName(newLast);
                    break;
                case "3":
                    System.out.println("Input New Date of Employment (MM-DD-YYYY): ");
                    String newDate = sc.nextLine();
                    updEmp.setEmpDate(newDate);
                    break;   
                case "4":
                    System.out.println("Input New Department (by Name or ID): ");
                    String newDept = sc.nextLine();
                    Department d;

                    if(isIDNumber(newDept)){
                        d = findDeptID(depts, Long.parseLong(newDept));
                    }else{
                        d = findDeptName(depts, newDept);
                    }
                    //Department d = findDept(depts, newDept);
                    if(d==null){
                        throw new DepartmentNotFound();
                    }else{
                        updEmp.setDept(d);
                    }
                    break;         
                case "0":
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }while(!select.equals("0"));
    }

    private static boolean isIDNumber(String employee) {
        return employee.matches("[-+]?\\d*\\.?\\d+");
    }     

    /*
     *  These programs find the Department object either through ID number or Name
     */
    public static Department findDeptName(List<Department> depts,String dID){
        for(Department d:depts){
            if(d.getName().equalsIgnoreCase(dID)){
                return d;
            }
        }
        return null;
    }

    public static Department findDeptID(List<Department> depts,long dID){
        for(Department d:depts){
            if(d.getDepID() == dID){
                return d;
            }
        }
        return null;
    }

    /*
     *  These programs find the Department object either through ID number or Name
     */
    public static Employee findEmployeeID(List<Employee> elist, long emp_id){
        for(Employee ee:elist){
            if(ee.getID() == emp_id){
                return ee;
            }
        }
        return null;
    }
    
    public static Employee findEmployeeName(List<Employee> elist,String[] emp_id){
        for(Employee ee:elist){
            if(ee.getFirstName().equalsIgnoreCase(emp_id[0]) 
                && ee.getLastName().equalsIgnoreCase(emp_id[1])){
                return ee;
            }
        }
        return null;
    }

}
