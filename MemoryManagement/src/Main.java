import java.util.Scanner;

public class Main {

    public static void main(String[]args){

        //Create instance of the Memory management class
        MemoryMangement memory = new MemoryMangement();
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
            while (option < 1 || option > 6) {
                System.out.println("ERROR.OPTION MUST BE IN THE RANGE OF 1--6.CHOOSE AGAIN");
                selectOption();
                option = input.nextInt();//accept the select number
            }

            //If-else-if to check which technique selected and call the technique
            if (option == 1) {
                memory.MFTtechnique();//Call the mft memory management technique method
            }
            else if (option == 2) {
                memory.MVTtechnique();//Call the mvt memory management technique method
            }
            else if (option == 3) {
                memory.WorstFit();//Call the worst fit memory management technique method
            }
            else if (option == 4) {
                memory.BestFit();//Call the best fit memory management technique method
            }
            else if (option == 5) {
                memory.FirstFit();//Call the first fit memory management technique method
            }
            else{
                memory.Paging();//Call the paging memory management technique method
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
        System.out.println("SELECT MEMORY MANAGEMENT TECHNIQUE YOU WANT TO USE(1---6)");
        System.out.println("1.MFT TECHNIQUE");
        System.out.println("2.MVT TECHNIQUE");
        System.out.println("3.WORST FIT");
        System.out.println("4.BEST FIT");
        System.out.println("5.FIRST FIT");
        System.out.println("6.PAGING");
    }

    //Prompt the user to run the program again or not
    private static void runAgain(){
        System.out.println("DO YOU WANT TO RUN THE PROGRAM AGAIN(y/n)");
    }

}
