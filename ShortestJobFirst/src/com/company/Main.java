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

            //Call shortest job first CPU scheduling algorithm method
            SjfAlgorithm();

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
    //A method to calculate the CPU SCHEDULING using Shortest Job First ALGORITHM
    static void SjfAlgorithm(){
        //Burst Time array, waiting time array, turn around time array
        int[] p = new int[20], burstTime = new int[20], waitTime = new int[20], turnTime = new int[20];
        //counter i and k , number of processes, temporary variable
        int i, k, noProcesses, temp;
        //average waiting time, average turnaround time
        float avgWaitTime, avgturnTime;

        //Create instance of a scanner class
        Scanner input = new Scanner(System.in);

        System.out.println("CPU SCHEDULING ALGORITHMS - SHORTEST JOB FIRST");
        //Prompt and accept number of processes value from the user
        System.out.println("\nEnter the number of processes -- ");
        noProcesses = input.nextInt();

        //Prompt and accept burst time for every process from the user
        for(i=0;i<noProcesses;i++)
        {
            p[i]=i;
            System.out.println("Enter Burst Time for Process -- " + i);
            burstTime[i] = input.nextInt();
        }

        //Sort all the process according to the arrival time.
        //Then select that process which has minimum arrival time and minimum Burst time.
        //After completion of process make a pool of process which after till the completion
        // of previous process and select that process among the pool which is having minimum Burst time.
        for(i=0;i<noProcesses;i++){
            for(k=i+1;k<noProcesses;k++) {
                if (burstTime[i] > burstTime[k]) {
                    temp = burstTime[i];
                    burstTime[i] = burstTime[k];
                    burstTime[k] = temp;
                    temp = p[i];
                    p[i] = p[k];
                    p[k] = temp;
                }
            }
        }
        avgWaitTime =(waitTime[0] =  0);
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

        //Burst time, Waiting time, turn around time
        System.out.println("PROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME\n");
        for(i=0;i<noProcesses;i++)
            System.out.println("\t" + p[i] + "\t\t\t" +burstTime[i] + "\t\t\t" + waitTime[i] +" \t\t\t\t" + turnTime[i]);
        //Display average waiting time
        System.out.println("\nAverage Waiting Time -- " + avgWaitTime/noProcesses);
        //Display average turn around time
        System.out.println("\nAverage Turnaround Time --"+ avgturnTime/noProcesses);


    }

}
