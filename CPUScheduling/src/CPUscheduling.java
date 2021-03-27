import java.util.Scanner;

class CPUscheduling {
    //**************************************************
//CPU SCHEDULING ALGORITHMS
//**************************************************
    //A method to calculate the CPU scheduling using First-Come-First Serve ALGORITHM
    void FcfsAlgorithm(){
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
    //A method to calculate the CPU SCHEDULING using Short Job First ALGORITHM
    void SjfAlgorithm(){
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
    //A method to calculate CPU SCHEDULING using ROUND ROBIN ALGORITHM
    void RoundRobinAlgorithm(){
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
    //A method to calculate CPU SCHEDULING PRIORITY ALGORITHM
    void PriorityAlgorithm(){
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
    //A method to calculate  multi-level queue CPU scheduling algorithm
    void MultiLevel(){
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
