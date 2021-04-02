#### ROUND ROBIN CPU SCHEDULING ALGORITHMS
___
In Round-robin scheduling, each ready task runs turn by turn only in a cyclic queue for a limited time slice

### HOW IT WORKS
This program accept the following as inputs

- Number of Processes
- Size of time slice
- Burst Time for every process

After accepting the input it then compute the following
- Sorting

    Which is `arranging the processes starting from which execute first using time slice`

-  Waiting Time

    Which is `Previous waiting time + Previous burst time`
- Turnaround Time

    Which is `Previous turnaround time + Burst time`
- Average Waiting time

    Which is `total of waiting time / number of processes`

- Average Turnaround Time

    Which is `total of burst time / number of processes`



After the computation, the program then display the following
- Process Number(In order of execution)
- Every Process Burst Time
- Every Process Waiting Time
- Every Process Turnaround Time
- Average Burst Time
- Average Turnaround Time


##### RUN CODE
To run the this program. You should
copy the entire contents of  the folder into a project in the IDE or Text Editor, and then run the Main.java in the folder.
___
