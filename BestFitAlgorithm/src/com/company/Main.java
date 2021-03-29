package com.company;

import java.util.Scanner;

public class Main {
    //Constant MAX variable
    private final static int MAX = 25;
    //bf array and ff array declare
    private static int[] bf = new int[MAX], ff = new int[MAX];
    public static void main(String[] args) {

            boolean flag = true;
            //used to get the char value to run the program again or not

            char runAgain;

            while(flag) {

                Scanner input = new Scanner(System.in);

                //Call the best fit memory management technique method();
                BestFit();
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
    //A method to calculate the memory management using best fit algorithm
    static void BestFit(){
        //Array to hold fragments, Array to hold block size, Array to hold file size
        int[] frag = new int[MAX], blockSize = new int[MAX], fileSize = new int[MAX];
        //counter use in a loop, number of blocks, number of files, temporary var,
        int i, numBlocks, numFiles, temp, lowest = 10_000;

        //Create a scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("\n\tMemory Management Scheme - Best Fit");
        //Prompt and accept input for the number of blocks
        System.out.print("\nEnter the number of blocks:");
        numBlocks = input.nextInt();

        //Prompt and accept input for the number of files
        System.out.print("Enter the number of files:");
        numFiles = input.nextInt();

        //Prompt and accept input for the number of block sizes for every block
        System.out.println("\nEnter the size of the blocks:-\n");
        for(i = 1; i <= numBlocks; i++) {
            System.out.print("Block " + i + ":");
            blockSize[i] = input.nextInt();
        }
        //Prompt and accept input for the number of file sizes for every file
        System.out.println("Enter the size of the files :-");
        for(i = 1; i <= numFiles; i++) {
            System.out.print("File " + i + ":");
            fileSize[i] = input.nextInt();
        }
        //Calculate the fragment using block size and file size
        for(i = 1; i <= numFiles; i++) {
            for(int j = 1; j <= numBlocks; j++) {
                if(bf[j] != 1) {
                    temp = blockSize[j] - fileSize[i];
                    if(temp >= 0) {
                        if(lowest > temp) {
                            ff[i] = j;
                            lowest = temp;
                        }
                    }
                }
            }
            frag[i] = lowest;
            bf[ff[i]] = 1;
            lowest = 10_000;
        }

        //Display the various output of the program
        System.out.print("\nFile No\tFile Size\tBlock No\tBlock Size\tFragment");
        for(i = 1; i <= numFiles && ff[i] != 0; i++) {
            System.out.println("\n" + i + "\t\t\t" + fileSize[i] + "\t\t\t" + ff[i] + "\t\t\t" + blockSize[ff[i]] + "\t\t\t" + frag[i]);
        }
    }
}
