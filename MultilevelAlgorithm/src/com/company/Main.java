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

            //Call the multi+level CPU scheduling algorithm method
            MultiLevel();

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

    //A method to calculate  multi-level queue CPU scheduling algorithm
    static void MultiLevel(){
        //Processes, burst time, waiting time, turn around time
        int[] processes = new int[20],burstTime = new int[20], sysUser = new int[20], waitTime = new int[20],turnTime = new int[20];
        //counter(i and k), number of processes
        int i, k, noProcesses, temp;
        //Average waiting time, average turn around time
        float avgWaitTime, avgTurnTime;

        Scanner input = new Scanner(System.in);

        //Prompt and accept user input for number of processes
        System.out.println("CPU SCHEDULING ALGORITHMS - MULTI LEVEL QUEUE");
        System.out.print("Enter the number of processes --- ");
        noProcesses = input.nextInt();

        //Prompt and accept user input for bust time for all the processes
        for(i = 0; i < noProcesses; i++) {
            processes[i] = i;
            System.out.print("Enter the Burst Time of Process " + i + " --- ");
            burstTime[i] = input.nextInt();
            System.out.print("System/User Process (0/1) ? --- ");
            sysUser[i] = input.nextInt();
        }

        //
        for(i = 0; i < noProcesses; i++)
        {
            for( k = i + 1; k < noProcesses; k++)
            {
                if(sysUser[i] > sysUser[k])
                {
                    temp = processes[i];
                    processes[i] = processes[k];
                    processes[k] = temp;
                    temp = burstTime[i];
                    burstTime[i] = burstTime[k];
                    burstTime[k] = temp;
                    temp = sysUser[i];
                    sysUser[i] = sysUser[k];
                    sysUser[k] = temp;
                }
            }
        }

        //Assign 0 to waiting time and average waiting time
        avgWaitTime = (waitTime[0] = 0);
        //Assign 0 to waiting time and average waiting time
        avgTurnTime = (turnTime[0] = burstTime[0]);

        //Calculate waiting time, turn around time, avg waiting time, avg turn around time
        for(i = 1; i < noProcesses; i++) {
            waitTime[i] = waitTime[i - 1] + burstTime[i - 1];
            turnTime[i] = turnTime[i - 1] + burstTime[i];

            avgWaitTime = avgWaitTime + waitTime[i];
            avgTurnTime = avgTurnTime + turnTime[i];
        }

        System.out.print("\nPROCESS\t\t SYSTEM/USER PROCESS \tBURST TIME\tWAITING TIME\tTURNAROUND TIME");

        //Display The process, system/user process, burst time, waiting time, turn around time
        for(i = 0; i < noProcesses; i++) {
            System.out.print("\n" + processes[i] + " \t\t " + sysUser[i] + " \t\t " + burstTime[i] + " \t\t " + waitTime[i] + " \t\t " + turnTime[i] + " ");
        }
        System.out.printf("\nAverage Waiting Time is --- %f", avgWaitTime / noProcesses);
        System.out.printf("\nAverage Turnaround Time is --- %f", avgTurnTime / noProcesses);
    }
}
