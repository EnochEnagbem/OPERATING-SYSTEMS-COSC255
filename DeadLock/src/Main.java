//      NAME                    ID
//Baiden-Amissah Ekow         220EI01000613
//Kumanyenu Enoch Enagbem     219CS010900006
//Tetteh Bortey Raphael       219IT02000231
import java.util.Scanner;

public class Main {

    public static void main(String[]args){

        DeadlockAlgorithms deadlock = new DeadlockAlgorithms();

        //Used to control a while loop
        boolean flag = true;
        //used to get the char value to run the program again or not
        char runAgain;
        //A while loop to run the program again
        while(flag) {

            //Create an instance of the Scanner Class
            Scanner input = new Scanner(System.in);

            //Used to get the selected algorithm to use
            int option;

            //Give option to the user to choose the algorithm to use
            selectOption();
            option = input.nextInt();

            //Check if the option selected by the user is either is within the range
            //If the option input is not int or out of range
            //keep asking the user until option within the range is chosen
            while (option < 1 || option > 4) {
                System.out.println("Error.Option must between the range of 1---4.CHOOSE THE AGAIN");
                selectOption();
                option = input.nextInt();
            }

            //If-else-if to check which technique selected and call the technique
            if (option == 1) {
                //Call the first-come-first-serve deadlock management technique method
                deadlock.fcfsDISKALGORITHM();
            }
            else if (option == 2) {
                //Call the Scan Disk deadlock management technique method
                deadlock.scanDisk();
            }
            else if(option == 3){
                //Call the C Scan Disk deadlock management technique method
                deadlock.CScanDisk();
            }
            else{
                //Call the Bankers deadlock management technique method
                deadlock.Bankers();
            }


            System.out.println("------------------------------------------");
            //Run again method
            runAgain();
            runAgain = input.next().charAt(0);
            //Check if the user want to run the program again
            if(runAgain == 'y') {
                flag = true;
            } else
                flag = false;

        }

    }
    //Prompt the user to select the algorithm to use
    private static void selectOption() {

        System.out.println("SELECT THE DEADLOCK ALGORITHM YOU WANT TO USE(12--15");
        System.out.println("1.FIRST-COME FIRST- SERVE DISK SCHEDULING ALGORITHM");
        System.out.println("2.SCAN DISK SCHEDULING ALGORITHM");
        System.out.println("3.C-SCAN DISK SCHEDULING ALGORITHM");
        System.out.println("4.BANKER'S ALGORITHM");
    }

    //Prompt the user to run the program again or not
    private static void runAgain(){
        System.out.println("DO YOU WANT TO RUN THE PROGRAM AGAIN(y/n)");
    }


}
