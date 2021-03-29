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

            //Call round robin CPU scheduling algorithm method
            RoundRobinAlgorithm();

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

    //A method to calculate CPU SCHEDULING using ROUND ROBIN ALGORITHM
    static void RoundRobinAlgorithm(){
        //counters(i,j), number of processes, time slice, maximum
        int i,j,noProcesses,timeSlice,max;
        //Burst time, waiting time, turn around time
        int[] burstTime= new int [10],waitTime = new int [10],turnTime = new int[10],ct = new int[10];
        //Average waiting time, average turn around time
        float avgWaitTime=0,avgTurnTIme=0,temp=0;

        //Create a Scanner Object
        Scanner input = new Scanner(System.in);

        System.out.println("CPU SCHEDULING ALGORITHMS - ROUND ROBIN");

        //Prompt and accept user input for number of processes
        System.out.println("Enter the no of processes -- ");
        noProcesses = input.nextInt();

        //Prompt and accept user input for Burst time for all the processes
        for(i=0;i<noProcesses;i++)
        {
            System.out.println("\nEnter Burst Time for process-- "+ (i+1));
            burstTime[i] = input.nextInt();
            ct[i]=burstTime[i];
        }
        //Prompt and accept user input for size of time slice
        System.out.println("\nEnter the size of time slice -- ");
        timeSlice = input.nextInt();
        max=burstTime[0];

        //
        for(i=1; i<noProcesses; i++){
            if(max < burstTime[i])
                max=burstTime[i];
        }
        //
        for(j=0; j<(max/timeSlice)+1; j++) {
            for (i = 0; i < noProcesses; i++) {
                if (burstTime[i] != 0){
                    if (burstTime[i] <= timeSlice) {
                        turnTime[i] = (int)temp + burstTime[i];
                        temp = temp + burstTime[i];
                        burstTime[i] = 0;
                    } else {
                        burstTime[i] = burstTime[i] - timeSlice;
                        temp = temp + timeSlice;
                    }
                }}
        }
        //Calculate the waiting time, turnaround time, average waiting time and
        //average turnaround time for every process
        for(i=0;i<noProcesses;i++)
        {
            waitTime[i]=turnTime[i]-ct[i];
            avgTurnTIme+=turnTime[i];
            avgWaitTime+=waitTime[i];
        }

        //Display average turn around time
        System.out.println("\nThe Average Turnaround time is --" + avgTurnTIme/noProcesses);

        //Display average waiting time
        System.out.println("\nThe Average Waiting time is -- "+ avgWaitTime/noProcesses);

        //Display burst time, waiting time, turn around time
        System.out.println("PROCESS\t BURST TIME\t WAITING TIME\tTURNAROUND TIME");
        for(i=0;i<noProcesses;i++){
            System.out.println((i+1)+" \t\t\t" + ct[i] + "\t\t\t"+ waitTime[i] +"\t\t\t\t"+ turnTime[i]);
        }
    }
}
