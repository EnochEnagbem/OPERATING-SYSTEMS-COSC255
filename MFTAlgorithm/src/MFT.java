import java.util.Scanner;

public class MFT {

    public static void main(String[]args){
        boolean flag = true;
        //used to get the char value to run the program again or not

        char runAgain;

        while(flag) {

            Scanner input = new Scanner(System.in);

            //Call the mft memory management technique method
            MFTtechnique();
            System.out.println("------------------------------------------");
            //Run again method
            runAgain();
            runAgain = input.next().charAt(0);
            //Check if the user want to run the program again
            if (runAgain == 'y') {
                flag = true;
            } else {
                flag = false;
            }
        }
    }
    //Prompt the user to run the program again or not
    static void runAgain(){
        System.out.println("DO YOU WANT TO RUN THE PROGRAM AGAIN(y/n)");
    }

    //A method to calculate memory management technique
    // using Multiprogramming with a Fixed number of Tasks algorithm
    static void MFTtechnique(){
        //Block size, available memory, number of blocks, external fragmentation,number of processes, internal fragmentation
        int blockSize,availableMemory, numOfBlocks ,exFrag , noProcesses,internalFrag=0;

        //An array that hold the number of memory require for every process
        int[] memoryReq = new int[10];

        //counters(i,p) use in a loop, option get the selected technique
        int i, p =0;

        //Create a scanner object
        Scanner input = new Scanner(System.in);


        //Prompt and accept memory available input from the user
        System.out.println("Memory Management Scheme - Multiprogramming with " +
                "a Fixed number of Tasks");
        System.out.println("Enter the total memory available (in Bytes)---");
        availableMemory = input.nextInt();

        //Prompt and accept block size input from the user
        System.out.println("Enter the block size (in Bytes)---");
        blockSize = input.nextInt();

        //Determine the number of blocks
        numOfBlocks = availableMemory / blockSize;

        //Calculate the value for the external fragmentation
        exFrag = availableMemory - numOfBlocks * blockSize;

        //Prompt and accept number of processes from the user
        System.out.println("Enter the number of processes");
        noProcesses= input.nextInt();

        //prompt and accept the memory require for each process
        for(i = 0; i < noProcesses; i++)
        {
            System.out.println("Enter memory require for process" + (i + 1) + " (in Bytes)---" );
            memoryReq[i]= input.nextInt();
        }

        //Print out the number of blocks available.
        System.out.println("Number of blocks available in memory -- " + numOfBlocks);


        System.out.print("\n\nPROCESS\tMEMORY REQUIRED\t ALLOCATED\tINTERNAL FRAGMENTATION");

        //A for loop that loops through
        //the number of processes and number of blocks
        //then check if a memory require is greater than
        //a block size and then calculate the internal
        //fragmentation
        for(i = 0; i < noProcesses &&  p < numOfBlocks; i++){
            System.out.print("\n " + (i + 1) + "\t\t\t" + memoryReq[i]);
            if(memoryReq[i] > blockSize) {
                System.out.println("\t\t\t\tNO\t\t\t\t\t---");
            } else {
                System.out.println("\t\t\t\tYES\t\t\t\t\t" + (blockSize- memoryReq[i]));
                internalFrag = internalFrag + blockSize - memoryReq[i];
                p++;
            }
        }
        //Check if i is more than the number of process and then display
        //If the memory is full and also the values of internal and
        //external fragmentation
        if(i < noProcesses) {
            System.out.println("\nMemory is Full, Remaining Processes cannot be accommodated");
            System.out.println("\n\nTotal Internal Fragmentation is " + internalFrag);
            System.out.println("\nTotal External Fragmentation is " + exFrag);
        }
    }
}
