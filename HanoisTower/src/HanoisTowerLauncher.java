//Jackson D. Poyner
//11-24-23
//This is a tower of hanoi program which is used in order to demonstrate how recursion can be used algorithmically.

import java.util.InputMismatchException;
import java.util.Scanner;

public class HanoisTowerLauncher {

    public static void main(String[] args) {
        System.out.println("Hello welcome to the Tower of Hanoi program, Before we get started you need to answer some\n"
                + "basic questions.");
        System.out.println("First we need to get some information about the columns.");
        //This section is being used in order to collect data for the program to function.
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("What would you like to name the first column?"); //Column 1 name
            String Column1 = scan.nextLine();
            System.out.println("What would you like to name the second column?"); //Column 2 name
            String Column2 = scan.nextLine();
            System.out.println("What would you like to name the third column?"); //Column 3 name
            String Column3 = scan.nextLine();
            //Catching case where user doesn't input a string.
            if (Column1 == "" || Column2 == "" || Column3 == "") {
                System.out.println("Please enter a real name for your columns.");
                continue;
            }
            while (true) {
                scan = new Scanner(System.in);
                System.out.println("The last question is how many discs will there be? (Number greater than 0)"); //Number of discs
                int Discs = 0;
                try {
                    Discs = scan.nextInt();
                } catch (InputMismatchException e) { //Catching an error where the user inputs a non integer
                    System.out.println("Please input any real number greater than 0.");
                    continue;
                }
                tower(Discs, Column1, Column3, Column2);
                break;
            }
            break;
        }

    }

    //This method will serve as our puzzle cracker and will be used to solve the tower of hanoi recursively.
    private static void tower(int n, String originColumn, String destinationColumn, String transitionColumn) {
        //Base Case
        if (n == 1) {
            System.out.println("Move disk " + n + " from " + originColumn + " to " + destinationColumn);
            return;
        }

        /*Recursive Algorithm:
         * The program will begin checking and moving discs to the center column in order from biggest to smallest
         * Then it will take the bottom disc on the first column and move it to the last column
         * From here the program will rinse and repeat moving the "stack" of discs from one column to the next until
         * We reach the base case with one disc which will be moved directly to the last column and will end the program.
         */
        tower(n - 1, originColumn, transitionColumn, destinationColumn); //function is calling itself "Recursion"
        System.out.println("Move disk " + n + " from " + originColumn + " to " + destinationColumn);
        tower(n - 1, transitionColumn, destinationColumn, originColumn); //function is calling itself "Recursion"
    }
}