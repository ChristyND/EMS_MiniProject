
import java.util.ArrayList;
import java.util.Scanner;

import JavaEMS.JavaEMS;

public class Main {
    static Scanner sc = new Scanner(System.in);
        public static void main(String[] args) throws Exception {
            int input;

            do{
                System.out.println("+-------------------------------------------------------+");
                System.out.println("|       Welcome to the Employee Management System       |");
                System.out.println("+-------------------------------------------------------+");
                System.out.println("| What do you plan to do?                               |");
                System.out.println("+-------------------------------------------------------+");
                System.out.println("|   1) (JAVA) Manual Employee Menu                      |");
                System.out.println("|   2) Connect to MySQL Database                        |");
                System.out.println("|   3) Run a file                                       |");
                System.out.println("|   0) Quit Application                                 |");
                System.out.println("+-------------------------------------------------------+");
                input = sc.nextInt();

                switch (input) {
                    case 1:
                        JavaEMS jvEMS = new JavaEMS();
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

