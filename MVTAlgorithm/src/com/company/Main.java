package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[]args){
        boolean flag = true;
        //used to get the char value to run the program again or not

        char runAgain;

        while(flag) {

            Scanner input = new Scanner(System.in);

            //Call the mvt memory management technique method
            MVTtechnique();
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
    // using Multiprogramming with a Variable number of Tasks algorithm
    static void MVTtechnique(){
        //An array that hold the number of memory require for every process
        int[] memoryReq = new int[10];
        //Memory available, temp is used to hold the memory available for calculation, n is a counter use in a loop
        int memoryAV, temp, n = 0;
        //use to ask the user if he/she want to continue adding the memory require
        char ch = 'y';

        //Create a scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("Memory Management Scheme - Multiprogramming with a" +
                " Variable number of Tasks algorithm");
        //Prompt and accept memory available input from the user
        System.out.println("Enter the total memory available (in Bytes)--");
        memoryAV = input.nextInt();
        temp = memoryAV;


        //A for loop that prompt and accept user input for memory require for every process
        for (int x = 0; ch == 'y'; x++, n++) {
            System.out.println("\nEnter memory require for process " + (x + 1) + "( in Bytes)");
            memoryReq[x] = input.nextInt();
            if (memoryReq[x] <= temp) {
                System.out.print("\nMemory is allocated for Process " + (x + 1) + " ");
                temp = temp - memoryReq[x];
            } else {
                System.out.print("\nMemory is Full");
                break;

            }
            System.out.print("\nDo you want to continue(y/n) -- ");
            ch = input.next().charAt(0);

        }
        //Display the total memory available
        System.out.print("\n\nTotal Memory Available -- " + memoryAV);

        System.out.print("\n\n\tPROCESS\t\t MEMORY ALLOCATED ");

        //A for loop that display the total memory allocated for every process and the value of external fragmentation
        for(int m = 0; m < n; m++) {
            System.out.print("\n \t\t" + (m + 1) + "\t\t\t" + memoryReq[m]);
        }
        //Display total memory allocated
        System.out.println("\n\nTotal Memory Allocated is " + (memoryAV - temp));
        //Display total external fragmentation
        System.out.println("\nTotal External Fragmentation is " + temp);


    }
}
