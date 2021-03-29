package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Used to control a while loop
        boolean flag = true;
        //used to get the char value to run the program again or not
        char runAgain;

        while (flag) {

            //Create an instance of the Scanner Class
            Scanner input = new Scanner(System.in);

            //Call first-come-first-serve CPU scheduling algorithm method
            FcfsAlgorithm();

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

    //A method to calculate the CPU scheduling using First-Come-First Serve ALGORITHM
    static void FcfsAlgorithm(){
        //Burst Time array, waiting time array, turn around time array
        int[] burstTime = new int[20], waitTime = new int[20], turnTime = new int[20];
        //counter , number of processes
        int i, noProcesses;
        //average waiting time, average turnaround time
        float avgWaitTime, avgturnTime;

        //Create instance of the scanner class
        Scanner input = new Scanner(System.in);
        //Prompt and accept number of processes value from the user
        System.out.println("CPU SCHEDULING ALGORITHMS - FIRST COME FIRST SERVE");
        System.out.println("\nEnter the number of processes -- ");
        noProcesses = input.nextInt();//accept input for

        //Prompt and accept burst time for every process from the user
        for(i=0; i<noProcesses; i++)
        {
            System.out.println("\nEnter Burst Time for Process -- "+ i);
            burstTime[i] = input.nextInt();
        }
        //Assign 0 to average waiting time
        avgWaitTime = (waitTime[0] =  0);
        //Assign 0 to average turnaround time
        avgturnTime = (turnTime[0] = burstTime[0]);

        //Calculate the waiting time, turnaround time, average waiting time and
        //average turnaround time for every process
        for(i=1;i<noProcesses;i++)
        {
            waitTime[i] = waitTime[i-1] +burstTime[i-1];
            turnTime[i] = turnTime[i-1] +burstTime[i];
            avgWaitTime = avgWaitTime + waitTime[i];
            avgturnTime = avgturnTime + turnTime[i];
        }
        //Display the result for every process, burst time,waiting time and turnaround time
        System.out.println("PROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME\n");
        for(i=0;i<noProcesses;i++) {
            System.out.println("\t" +i + "\t\t\t"+ burstTime[i] + " \t\t\t"+ waitTime[i]+ "\t\t\t\t"+ turnTime[i]);
        }
        //Display the average waiting time
        System.out.println("\nAverage Waiting Time -- " + avgWaitTime / noProcesses);
        //Display the average turnaround time
        System.out.println("\nAverage Turnaround Time -- "+ avgturnTime / noProcesses);

    }
}
