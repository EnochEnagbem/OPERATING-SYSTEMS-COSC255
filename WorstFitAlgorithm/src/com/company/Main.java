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

            //Call the worst fit memory management technique method
            WorstFit();
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
    //to calculate the memory management using worst fit algorithm
    static void WorstFit(){
        //Array to hold fragments
        int[] frag = new int[MAX], b = new int[MAX], f = new int[MAX];
        // Number of blocks, number of files,
        int numBlocks, numFiles, temp = 0;

        //Create a Scanner object
        Scanner input = new Scanner(System.in);

        System.out.print("\n\tMemory Management Scheme - Worst Fit");
        //Prompt and accept number of blocks value from the user
        System.out.print("\nEnter the number of blocks:");
        numBlocks = input.nextInt();

        //Prompt and accept number of files value from the user
        System.out.print("Enter the number of files:");
        numFiles = input.nextInt();

        //Prompt and accept number of block size values from the user
        System.out.println("\nEnter the size of the blocks:-");
        for(int i = 1; i <= numBlocks; i++) {
            System.out.print("Block " + i + ":");
            b[i] = input.nextInt();
        }
        //Prompt and accept number of files size values from the user
        System.out.println("Enter the size of the files :-");
        for(int i = 1; i <= numFiles; i++) {
            System.out.print("File " + i + ":");
            f[i] = input.nextInt();
        }
        //Calculate the fragment using block size and file size
        for(int i = 1; i <= numFiles; i++) {
            for(int j = 1; j <= numBlocks; j++) {
                if(bf[j] != 1) {
                    temp = b[j] - f[i];
                    if(temp >= 0) {
                        ff[i] = j;
                        break;
                    }
                }
            }
            frag[i] = temp;
            bf[ff[i]] = 1;
        }
        //Display the various output of the program
        System.out.print("File_no:\tFile_size:\tBlock_no:\tBlock_size:\tFragment");
        for(int i = 1; i <= numFiles; i++) {
            System.out.println("\n" + i + "\t\t\t" + f[i] + "\t\t\t" + ff[i] + "\t\t\t" + b[ff[i]] + "\t\t\t" + frag[i]);
        }

    }

}
