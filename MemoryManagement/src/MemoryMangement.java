import java.util.Scanner;

class MemoryMangement {
    //Constant MAX variable
    private final static int MAX = 25;
    //bf array and ff array declare
    private static int[] bf = new int[MAX], ff = new int[MAX];

    //**************************************************
//MEMORY MANAGEMENT ALGORITHMS
//**************************************************
    //A method to calculate the memory management
    // using Multiprogramming with a Fixed number of Tasks algorithm
    void MFTtechnique(){
        //Block size, available memory, number of blocks, external fragmentation,number of processes, internal fragmentation
        int blockSize,availableMemory, numOfBlocks ,exFrag , noProcesses,internalFrag=0;

        //An array that hold the number of memory require for every process
        int[] memoryReq = new int[10];

        //counters(i,p) use in a loop, option get the selected technique
        int i, p =0;

        //Create a scanner object
        Scanner input = new Scanner(System.in);


        //Prompt and accept memory available input from the user
        System.out.println("Memory Management Scheme - Multiprogramming with " +
                "a Fixed number of Tasks");
        System.out.println("Enter the total memory available (in Bytes)---");
        availableMemory = input.nextInt();

        //Prompt and accept block size input from the user
        System.out.println("Enter the block size (in Bytes)---");
        blockSize = input.nextInt();

        //Determine the number of blocks
        numOfBlocks = availableMemory / blockSize;

        //Calculate the value for the external fragmentation
        exFrag = availableMemory - numOfBlocks * blockSize;

        //Prompt and accept number of processes from the user
        System.out.println("Enter the number of processes");
        noProcesses= input.nextInt();

        //prompt and accept the memory require for each process
        for(i = 0; i < noProcesses; i++)
        {
            System.out.println("Enter memory require for process" + (i + 1) + " (in Bytes)---" );
            memoryReq[i]= input.nextInt();
        }

        //Print out the number of blocks available.
        System.out.println("Number of blocks available in memory -- " + numOfBlocks);


        System.out.print("\n\nPROCESS\tMEMORY REQUIRED\t ALLOCATED\tINTERNAL FRAGMENTATION");

        //A for loop that loops through
        //the number of processes and number of blocks
        //then check if a memory require is greater than
        //a block size and then calculate the internal
        //fragmentation
        for(i = 0; i < noProcesses &&  p < numOfBlocks; i++){
            System.out.print("\n " + (i + 1) + "\t\t\t" + memoryReq[i]);
            if(memoryReq[i] > blockSize) {
                System.out.println("\t\t\t\tNO\t\t\t\t\t---");
            } else {
                System.out.println("\t\t\t\tYES\t\t\t\t\t" + (blockSize- memoryReq[i]));
                internalFrag = internalFrag + blockSize - memoryReq[i];
                p++;
            }
        }
        //Check if i is more than the number of process and then display
        //If the memory is full and also the values of internal and
        //external fragmentation
        if(i < noProcesses) {
            System.out.println("\nMemory is Full, Remaining Processes cannot be accommodated");
            System.out.println("\n\nTotal Internal Fragmentation is " + internalFrag);
            System.out.println("\nTotal External Fragmentation is " + exFrag);
        }
    }

    // using Multiprogramming with a Variable number of Tasks algorithm
    void MVTtechnique(){
        //An array that hold the number of memory require for every process
        int[] memoryReq = new int[10];
        //Memory available, temp is used to hold the memory available for calculation, n is a counter use in a loop
        int memoryAV, temp, n = 0;
        //use to ask the user if he/she want to continue adding the memory require
        char ch = 'y';

        //Create a scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("Memory Management Scheme - Multiprogramming with a" +
                " Variable number of Tasks algorithm");
        //Prompt and accept memory available input from the user
        System.out.println("Enter the total memory available (in Bytes)--");
        memoryAV = input.nextInt();
        temp = memoryAV;


        //A for loop that prompt and accept user input for memory require for every process
        for (int x = 0; ch == 'y'; x++, n++) {
            System.out.println("\nEnter memory require for process " + (x + 1) + "( in Bytes)");
            memoryReq[x] = input.nextInt();
            if (memoryReq[x] <= temp) {
                System.out.print("\nMemory is allocated for Process " + (x + 1) + " ");
                temp = temp - memoryReq[x];
            } else {
                System.out.print("\nMemory is Full");
                break;

            }
            System.out.print("\nDo you want to continue(y/n) -- ");
            ch = input.next().charAt(0);

        }
        //Display the total memory available
        System.out.print("\n\nTotal Memory Available -- " + memoryAV);

        System.out.print("\n\n\tPROCESS\t\t MEMORY ALLOCATED ");

        //A for loop that display the total memory allocated for every process and the value of external fragmentation
        for(int m = 0; m < n; m++) {
            System.out.print("\n \t\t" + (m + 1) + "\t\t\t" + memoryReq[m]);
        }
        //Display total memory allocated
        System.out.println("\n\nTotal Memory Allocated is " + (memoryAV - temp));
        //Display total external fragmentation
        System.out.println("\nTotal External Fragmentation is " + temp);


    }

    //A method to calculate the memory management using worst fit algorithm
    void WorstFit(){
        //Array to hold fragments
        int[] frag = new int[MAX], b = new int[MAX], f = new int[MAX];
        // Number of blocks, number of files,
        int numBlocks, numFiles, temp = 0;

        //Create a Scanner object
        Scanner input = new Scanner(System.in);

        System.out.print("\n\tMemory Management Scheme - Worst Fit");
        //Prompt and accept number of blocks value from the user
        System.out.print("\nEnter the number of blocks:");
        numBlocks = input.nextInt();

        //Prompt and accept number of files value from the user
        System.out.print("Enter the number of files:");
        numFiles = input.nextInt();

        //Prompt and accept number of block size values from the user
        System.out.println("\nEnter the size of the blocks:-");
        for(int i = 1; i <= numBlocks; i++) {
            System.out.print("Block " + i + ":");
            b[i] = input.nextInt();
        }
        //Prompt and accept number of files size values from the user
        System.out.println("Enter the size of the files :-");
        for(int i = 1; i <= numFiles; i++) {
            System.out.print("File " + i + ":");
            f[i] = input.nextInt();
        }
        //Calculate the fragment using block size and file size
        for(int i = 1; i <= numFiles; i++) {
            for(int j = 1; j <= numBlocks; j++) {
                if(bf[j] != 1) {
                    temp = b[j] - f[i];
                    if(temp >= 0) {
                        ff[i] = j;
                        break;
                    }
                }
            }
            frag[i] = temp;
            bf[ff[i]] = 1;
        }
        //Display the various output of the program
        System.out.print("File_no:\tFile_size:\tBlock_no:\tBlock_size:\tFragment");
        for(int i = 1; i <= numFiles; i++) {
            System.out.println("\n" + i + "\t\t\t" + f[i] + "\t\t\t" + ff[i] + "\t\t\t" + b[ff[i]] + "\t\t\t" + frag[i]);
        }

    }

    //A method to calculate the memory management using best fit algorithm
    void BestFit(){
        //Array to hold fragments, Array to hold block size, Array to hold file size
        int[] frag = new int[MAX], blockSize = new int[MAX], fileSize = new int[MAX];
        //counter use in a loop, number of blocks, number of files, temporary var,
        int i, numBlocks, numFiles, temp, lowest = 10_000;

        //Create a scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("\n\tMemory Management Scheme - Best Fit");
        //Prompt and accept input for the number of blocks
        System.out.print("\nEnter the number of blocks:");
        numBlocks = input.nextInt();

        //Prompt and accept input for the number of files
        System.out.print("Enter the number of files:");
        numFiles = input.nextInt();

        //Prompt and accept input for the number of block sizes for every block
        System.out.println("\nEnter the size of the blocks:-\n");
        for(i = 1; i <= numBlocks; i++) {
            System.out.print("Block " + i + ":");
            blockSize[i] = input.nextInt();
        }
        //Prompt and accept input for the number of file sizes for every file
        System.out.println("Enter the size of the files :-");
        for(i = 1; i <= numFiles; i++) {
            System.out.print("File " + i + ":");
            fileSize[i] = input.nextInt();
        }
        //Calculate the fragment using block size and file size
        for(i = 1; i <= numFiles; i++) {
            for(int j = 1; j <= numBlocks; j++) {
                if(bf[j] != 1) {
                    temp = blockSize[j] - fileSize[i];
                    if(temp >= 0) {
                        if(lowest > temp) {
                            ff[i] = j;
                            lowest = temp;
                        }
                    }
                }
            }
            frag[i] = lowest;
            bf[ff[i]] = 1;
            lowest = 10_000;
        }

        //Display the various output of the program
        System.out.print("\nFile No\tFile Size\tBlock No\tBlock Size\tFragment");
        for(i = 1; i <= numFiles && ff[i] != 0; i++) {
            System.out.println("\n" + i + "\t\t\t" + fileSize[i] + "\t\t\t" + ff[i] + "\t\t\t" + blockSize[ff[i]] + "\t\t\t" + frag[i]);
        }
    }

    //A method to calculate the memory management using first fit algorithm
    void FirstFit(){
        //Fragment array, block size, file size
        int[] frag = new int[MAX], blockSize = new int[MAX], fileSize = new int[MAX];
        //number of blocks, number of files, temporary variable,
        int numBlocks, numFiles, temp, highest = 0;

        //Create a scanner object
        Scanner input = new Scanner(System.in);

        System.out.print("\n\tMemory Management Scheme - First Fit");
        //Prompt and accept input for the number of blocks
        System.out.print("\nEnter the number of blocks:");
        numBlocks = input.nextInt();

        //Prompt and accept number of files value from the user
        System.out.print("Enter the number of files:");
        numFiles = input.nextInt();

        //Prompt and accept input for the number of block sizes for every block
        System.out.println("\nEnter the size of the blocks:-");
        for(int i = 1; i <= numBlocks; i++) {
            System.out.print("Block " + i + ":");
            blockSize[i] = input.nextInt();
        }
        //Prompt and accept input for the number of file sizes for every file
        System.out.println("Enter the size of the files :-");
        for(int i = 1; i <= numFiles; i++) {
            System.out.print("File " + i + ":");
            fileSize[i] = input.nextInt();
        }
        //Calculate the fragment using block size and file size
        for(int i = 1; i <= numFiles; i++) {
            for(int j = 1; j <= numBlocks; j++) {
                if(bf[j] != 1 /* if bf[j] is not allocated */) {
                    temp = blockSize[j] - fileSize[i];
                    if(temp >= 0) {
                        if(highest < temp) {
                            ff[i] = j;
                            highest = temp;
                        }
                    }
                }
            }
            frag[i] = highest;
            bf[ff[i]] = 1;
            highest = 0;
        }
        //Display the various output of the program
        System.out.print("\nFile_no:\tFile_size:\tBlock_no:\tBlock_size:\tFragment");
        for(int i = 1; i <= numFiles; i++) {
            System.out.println("\n" + i + "\t\t\t" + fileSize[i] + "\t\t\t" + ff[i] + "\t\t\t" + blockSize[ff[i]] + "\t\t\t" + frag[i]);
        }
    }

    //A method to calculate the memory management using paging algorithm
    void Paging(){
        //The size of the memory, page size, number of pages, remaining pages, count control, number of process, physical address
        int memorySize, pageSize, numPages, noProcesses, remPages, i, logAddress, processNum, phyAddress, offset;
        //Array to hold number of pages require
        int[] numPagesReq = new int[10];
        int[][] fno = new int[10][20];

        //Create a scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("\n\tMemory Management Scheme - Paging");
        //Prompt and accept input for the memory size from the user
        System.out.print("\nEnter the memory size -- ");
        memorySize = input.nextInt();
        //Prompt and accept input for the page size from the user
        System.out.print("\nEnter the page size -- ");
        pageSize = input.nextInt();

        //Calculate the number of pages available
        numPages = memorySize / pageSize;

        //Display the number of pages available
        System.out.print("\nThe no. of pages available in memory are -- " + numPages + " ");
        //Prompt and accept input for the number of processes from the user
        System.out.print("\nEnter number of processes -- ");
        noProcesses = input.nextInt();
        //initialize the remaining pages with the number of pages available
        remPages = numPages;

        //A loop that accept input for the number of pages require for every process
        for(i = 1; i <= noProcesses; i++) {
            System.out.print("\nEnter no. of pages required for p[" + i + "]-- ");
            numPagesReq[i] = input.nextInt();
            //Check if the memory is full
            if(numPagesReq[i] > remPages) {
                System.out.print("\nMemory is Full");
                break;
            }
            //Calculate the remaining pages
            remPages = remPages - numPagesReq[i];
            //Prompt and accept input for the number of pages in every process
            System.out.print("\nEnter pagetable for p[" + i + "] --- ");
            for(int j = 0; j < numPagesReq[i]; j++) {
                fno[i][j] = input.nextInt();
            }
        }
        //Prompt and accept input for logical address, page number and offset
        System.out.print("\nEnter Logical Address to find Physical Address ");
        System.out.print("\nEnter page number and offset -- ");
        logAddress = input.nextInt();
        processNum = input.nextInt();
        offset = input.nextInt();

        //Calculate the Physical address
        if(logAddress > noProcesses || processNum >= numPagesReq[i] || offset >= pageSize) {
            System.out.print("\nInvalid Process or Page Number or offset");
        } else {
            phyAddress = fno[logAddress][processNum] * pageSize + offset;
            System.out.println("\nThe Physical Address is -- " + phyAddress);
        }
    }
}
