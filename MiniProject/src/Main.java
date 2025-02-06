
import java.util.ArrayList;
import java.util.Scanner;

import DAO.Department;
import JavaEMS.JavaEMS;

public class Main {
    static Scanner sc = new Scanner(System.in);
        public static void main(String[] args) throws Exception {
            ArrayList<Department> depts = new ArrayList<Department>();
            depts.add(new Department("Corporate","1-800-999-9999",1500000000));
            depts.add(new Department("Operations Management","1-800-888-8888",35000000));
            depts.add(new Department("Human Resources","1-800-777-7777",15000000));
            depts.add(new Department("Finance","1-800-567-1436",50000000));
            depts.add(new Department("Marketing","1-800-234-1543",1500000000));
            depts.add(new Department("Information Technology","1-800-456-7890",1500000000));

            System.out.println("List of Current Departments");
            for(Department d:depts){
                System.out.println(d.toString());
            }

            int input;

            do{
                System.out.println("Welcome to the Employee Management System");
                System.out.println("What do you plan to do?");
                System.out.println("1) (JAVA) Manual Employee Menu");
                System.out.println("2) Connect to MySQL Database");
                System.out.println("3) Run a file");
                System.out.println("0) Quit Application");
                input = sc.nextInt();

                switch (input) {
                    case 1:
                        JavaEMS jvEMS = new JavaEMS(depts);
                        break;
                    case 0:
                        return;
        
                    default:
                        System.out.println("Invalid Input.");
                        break;
                }
            }while(input != 0);

    }
}

