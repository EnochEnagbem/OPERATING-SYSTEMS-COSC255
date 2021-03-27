import java.util.Scanner;

public class Main {

    public static void main(String[]args){

        //Create instance of the Memory management class
        CPUscheduling cpu = new CPUscheduling();
        //Used to control a while loop
        boolean flag = true;
        //used to get the char value to run the program again or not
        char runAgain;

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
            while (option < 1 || option > 5) {
                System.out.println("ERROR.OPTION MUST BE IN THE RANGE OF 1--6.CHOOSE AGAIN");
                selectOption();
                option = input.nextInt();//accept the select number
            }

            //If-else-if to check which technique selected and call the technique
            if (option == 1) {
                cpu.FcfsAlgorithm();//Call first-come-first-serve CPU scheduling algorithm method
            }
            else if (option == 2) {
                cpu.SjfAlgorithm();//Call shortest job first CPU scheduling algorithm method
            }
            else if (option == 3) {
                cpu.RoundRobinAlgorithm();//Call round robin CPU scheduling algorithm method
            }
            else if (option == 4) {
                cpu.PriorityAlgorithm();//Call priority CPU scheduling algorithm method
            }
            else{
                cpu.MultiLevel();//Call multilevel algorithm CPU scheduling algorithm method

            }


            System.out.println("------------------------------------------");
            //Run again method
            runAgain();
            runAgain = input.next().charAt(0);
            //Check if the user want to run the program again
            if(runAgain == 'y') {
                flag = true;
            } else {
                flag = false;
            }


        }

    }

    //Prompt the user to select the algorithm to use
    private static void selectOption() {
        System.out.println("SELECT THE CPU SCHEDULING ALGORITHM YOU WANT TO USE(1--5)");
        System.out.println("1.FIRST COME FIRST SERVE");
        System.out.println("2.SHORTEST JOB FIRST");
        System.out.println("3.ROUND ROBIN");
        System.out.println("4.PRIORITY");
        System.out.println("5.MULTI LEVEL");
    }

    //Prompt the user to run the program again or not
    private static void runAgain(){
        System.out.println("DO YOU WANT TO RUN THE PROGRAM AGAIN(y/n)");
    }

}
