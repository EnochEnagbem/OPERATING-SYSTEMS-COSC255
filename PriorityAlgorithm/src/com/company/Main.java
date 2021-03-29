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

            //Call the priority CPU scheduling algorithm method
            PriorityAlgorithm();

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

    //A method to calculate CPU SCHEDULING PRIORITY ALGORITHM
    static void PriorityAlgorithm(){
        //
        int[] p = new int[20],burstTime = new int[20],priProcess = new int[20],
                waitTime = new int[20],turnTime = new int[20];
        //counter(i,k),number of processes
        int i, k, noProcesses, temp;
        //avg waiting time, avg turn around time
        float avgwaitTime, avgturnTime;

        //Create a Scanner class object
        Scanner input = new Scanner(System.in);

        System.out.println("CPU SCHEDULING ALGORITHMS - PRIORITY");

        //Prompt and accept user input for number of processes
        System.out.println("Enter the number of processes --- ");
        noProcesses  = input.nextInt();

        //Prompt and accept user input for burst time and priority of process
        for(i=0;i<noProcesses;i++)
        {
            p[i] = i;
            System.out.println("Enter the Burst Time & Priority of Process --- "+ (i + 1));
            burstTime[i] = input.nextInt();
            priProcess[i] = input.nextInt();
        }
        //Sort the processes, burst time and priority
        //according to the priority.
        for(i=0;i<noProcesses;i++) {
            for (k = i + 1; k < noProcesses; k++) {
                if (priProcess[i] > priProcess[k]) {
                    temp = p[i];
                    p[i] = p[k];
                    p[k] = temp;
                    temp = burstTime[i];
                    burstTime[i] = burstTime[k];
                    burstTime[k] = temp;
                    temp = priProcess[i];
                    priProcess[i] = priProcess[k];
                    priProcess[k] = temp;
                }
            }
        }
        //Assign 0 to waiting time
        avgwaitTime = waitTime[0] = 0;
        avgturnTime= turnTime[0] = burstTime[0];

        //Calculate waiting time, turn around time, average waiting time and average turnaround time
        for(i=1;i<noProcesses;i++)
        {
            waitTime[i] = waitTime[i-1] + burstTime[i-1];
            turnTime[i] = turnTime[i-1] + burstTime[i];
            avgwaitTime = avgwaitTime + waitTime[i];
            avgturnTime = avgturnTime + turnTime[i];
        }
        //Display the process, priority, burst time, waiting time and turn around time
        System.out.println("\nPROCESS\t\tPRIORITY\tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
        for(i=0;i<noProcesses;i++) {
            System.out.println(p[i] + "\t\t\t\t" + priProcess[i] + "\t\t\t" + burstTime[i] + "\t\t\t" + waitTime[i] + "\t\t\t\t" + turnTime[i]);
        }
        //Display avg waiting time and avg turn around time
        System.out.println("\nAverage Waiting Time is ---" + avgwaitTime/noProcesses);
        System.out.println("\nAverage Turnaround Time is ---" + avgturnTime/noProcesses);
    }

}
