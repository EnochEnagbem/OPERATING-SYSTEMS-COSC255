package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean flag = true;
        //used to get the char value to run the program again or not

        char runAgain;

        while(flag) {

            Scanner input = new Scanner(System.in);

            //Call the paging memory management technique method();
            Paging();
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

    //A method to calculate the memory management using paging algorithm
    static void Paging(){
        //The size of the memory, page size, number of pages, remaining pages, count control, number of process, physical address
        int memorySize, pageSize, numPages, noProcesses, remPages, i, logAddress, processNum, phyAddress, offset;
        //Array to hold number of pages require
        int[] numPagesReq = new int[10];
        int[][] fno = new int[10][20];

        //Create a scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("\n\tMemory Management Scheme - Paging");
        //Prompt and accept input for the memory size from the user
        System.out.print("\nEnter the memory size -- ");
        memorySize = input.nextInt();
        //Prompt and accept input for the page size from the user
        System.out.print("\nEnter the page size -- ");
        pageSize = input.nextInt();

        //Calculate the number of pages available
        numPages = memorySize / pageSize;

        //Display the number of pages available
        System.out.print("\nThe no. of pages available in memory are -- " + numPages + " ");
        //Prompt and accept input for the number of processes from the user
        System.out.print("\nEnter number of processes -- ");
        noProcesses = input.nextInt();
        //initialize the remaining pages with the number of pages available
        remPages = numPages;

        //A loop that accept input for the number of pages require for every process
        for(i = 1; i <= noProcesses; i++) {
            System.out.print("\nEnter no. of pages required for p[" + i + "]-- ");
            numPagesReq[i] = input.nextInt();
            //Check if the memory is full
            if(numPagesReq[i] > remPages) {
                System.out.print("\nMemory is Full");
                break;
            }
            //Calculate the remaining pages
            remPages = remPages - numPagesReq[i];
            //Prompt and accept input for the number of pages in every process
            System.out.print("\nEnter pagetable for p[" + i + "] --- ");
            for(int j = 0; j < numPagesReq[i]; j++) {
                fno[i][j] = input.nextInt();
            }
        }
        //Prompt and accept input for logical address, page number and offset
        System.out.print("\nEnter Logical Address to find Physical Address ");
        System.out.print("\nEnter page number and offset -- ");
        logAddress = input.nextInt();
        processNum = input.nextInt();
        offset = input.nextInt();

        //Calculate the Physical address
        if(logAddress > noProcesses || processNum >= numPagesReq[i] || offset >= pageSize) {
            System.out.print("\nInvalid Process or Page Number or offset");
        } else {
            phyAddress = fno[logAddress][processNum] * pageSize + offset;
            System.out.println("\nThe Physical Address is -- " + phyAddress);
        }
    }
}
