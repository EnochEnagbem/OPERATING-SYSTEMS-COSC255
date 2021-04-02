#### FIRST FIT MEMORY MANAGEMENT TECHNIQUE  
___
In this technique, first job claims the first available memory with space more than or equal to it’s size. The operating system doesn’t search for appropriate partition but just allocate the job to the nearest memory partition available with sufficient size.
___

#### HOW IT WORKS
This program accept the following as inputs

- Number of Blocks
- Number of Files
- Size of every Block
- Size of every Files

After accepting the input it then compute the following
-  Fragmentation

    Which is `Block size - file size`
- Allocation

    Which is `assigning the file to the available block with space more than or equal to the file size`


After the computation, the program then display the following
- Block numbers
- Block sizes
- Files sizes
- File numbers
- Fragmentation for every block


##### RUN CODE
To run the this program. You should
copy the entire contents of  the folder into a project in the IDE or Text Editor, and then run the Main.java in the folder.
___
