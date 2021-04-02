###  MULTIPROGRAMMING WITH A FIXED NUMBER OF TASKS
___

MFT (Multiprogramming with a Fixed number of Tasks) is one of the old memory management techniques in
which the memory is partitioned into fixed size partitions and each job is assigned to a partition. The memory
assigned to a partition does not change.

#### HOW IT WORKS
This program accept the following as inputs

- Total Memory available
- Block Size
- Number of Processes
- Memory Require for every Process

After accepting the input it then compute the following
-  Number of Blocks

    Which is `Total Memory Available / Block Size`
- External Fragmentation

    Which is `Total Memory available - Number of blocks * Block Size`

- Internal Fragmentation

    Which is `Block Size - Memory require for a particular Process`

After the computation, the program then display the following
- Total Internal Fragmentation
- Total External Fragmentation
- Memory Require for Every Process
- Allocation

##### RUN CODE
To run the this program. You should
copy the entire contents of any of the algorithm into a project in the IDE or Text Editor, and then run the Main.java in the folder.
___
