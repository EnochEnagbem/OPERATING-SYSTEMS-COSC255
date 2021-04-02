#### PRIORITY CPU SCHEDULING ALGORITHMS
___
Priority CPU scheduling is one of the most common scheduling algorithms. Each process is assigned a priority. Process with the highest priority is to be executed first and so on. Processes with the same priority are executed on first come first served basis.

### HOW IT WORKS
This program accept the following as inputs

- Number of Processes
- Burst Time & Priority for every Process

After accepting the input it then compute the following
- Execution Order

    Which is `executing the processes from the one having the highest priority`

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
