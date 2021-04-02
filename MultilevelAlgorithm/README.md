#### MULTILEVEL QUEUE CPU SCHEDULING ALGORITHM
___

A multi-level queue scheduling algorithm partitions the ready queue into several separate queues. The processes are permanently assigned to one queue, generally based on some property of the process, such as memory size, process priority, or process type. Each queue has its own scheduling algorithm.

### HOW IT WORKS
This program accept the following as inputs

- Number of Processes
- Burst Time for every process

After accepting the input it then compute the following
- Execution

    Which is `executing the processes based on some facts(memory size, process priority, or process type)`

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
To run this program. You should
copy the entire contents of  the folder into a project in the IDE or Text Editor, and then run the Main.java in the folder.
___
