import java.util.Scanner;

class DeadlockAlgorithms {


    //***************************************
//DEADLOCK ALGORITHMS
//***************************************
    //A method to calculate  first come first serve disk algorithm
    void fcfsDISKALGORITHM(){
        //Number of tracks traversed, different between tracks
        int[] tracksTrav = new int[20],diffTracks = new int[20];
        //number of tracks, counter, total tracks
        int noTracks, i, tot = 0;
        //Average header movement
        float avgheaderMov;

        //Create scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("DISK SCHEDULING ALGORITHMS - FCFS DISK ALGORITHM");
        //Prompt and accept number of tracks input from the user
        System.out.println("enter the no.of tracks");
        noTracks = input.nextInt();

        //Prompt and accept number of tracks to be traversed input from the user
        System.out.println("enter the tracks to be traversed");
        for(i=2; i<noTracks+2; i++){
            tracksTrav[i] = input.nextInt();
        }
        //Calculate the difference between tracks
        for(i=1;i<noTracks+1; i++)
        {
            diffTracks[i]=tracksTrav[i+1]-tracksTrav[i];
            if(diffTracks[i]<0)
                diffTracks[i]=diffTracks[i]*(-1);
        }

        //Stores the total number of tracks
        for(i=1;i<noTracks+1;i++)
        {
            tot += diffTracks[i];
        }
        //Calculate the average header movement
        avgheaderMov=(float)tot/noTracks;

        //Display the  tracks traversed and the difference between tracks
        System.out.println("Tracks traversed\tDifference between tracks\n");
        for(i=1;i<noTracks+1;i++){
            System.out.println(tracksTrav[i] +"\t\t\t\n"+ diffTracks[i]);
        }
        //Display the average header movements
        System.out.println("\nAverage header movements: "+ avgheaderMov);
    }

    //A method to calculate  scan disk algorithm
    void scanDisk(){
        //Tracks, direction
        int[] tracks = new int[20], d = new int[20], atr = new int[20];
        //position head, counter, number of tracks, temp
        int posHead, i, j = 0, noTracks, temp, k = 0,p, sum=0;

        //Create Scanner Object
        Scanner input = new Scanner(System.in);

        System.out.println("DISK SCHEDULING ALGORITHMS - SCAN DISK ALGORITHM");
        //Prompt and accept input for the number of tracks to be traversed
        System.out.println("enter the no of tracks to be traversed");
        noTracks = input.nextInt();

        //Prompt and accept input for the position head
        System.out.println("enter the position of head");
        posHead = input.nextInt();

        //Assign  0 to the first index in tracks
        tracks[0]=0;
        //Assign the first position head to the second index in tracks
        tracks[1]=posHead;

        //Prompt and accept input tracks input from the user
        System.out.println("enter the tracks");
        for(i=2; i<noTracks+2; i++)
            tracks[i] = input.nextInt();

        //
        for(i=0; i<noTracks +2; i++)
        {
            for(j=0; j<(noTracks+2)-i-1 ;j++)
            {
                if(tracks[j]>tracks[j+1])
                {
                    temp=tracks[j];
                    tracks[j]=tracks[j+1];
                    tracks[j+1]=temp;
                }
            }
        }
        //
        for(i=0; i<noTracks+2;i++)
        {
            if (tracks[i] == posHead)
            {
                j = i;
                k = i;
            }
        }
        p=0;

        //
        while(tracks[j]!=0)
        {
            atr[p]=tracks[j];
            j--;
            p++;
        }
        atr[p]=tracks[j];
        //
        for(p=k+1;p<noTracks+2;p++,k++)
            atr[p]=tracks[k+1];

        //
        for(j=0;j<noTracks+1;j++)
        {
            if(atr[j]>atr[j+1])
                d[j]=atr[j]-atr[j+1];
            else
                d[j]=atr[j+1]-atr[j];
            sum+=d[j];
        }
        //Display the average header movements
        System.out.println("\nAverage header movements: "+ (float)sum/noTracks);

    }

    //A method to calculate  d scan disk algorithm
    void CScanDisk(){
        //tracks
        int[] tracks = new int[20], d = new int[20],atr = new int[20];
        //position head, counters(i,j), total number of Tracks
        int posHead, i, j = 0, noTracks, temp, totalTracks, p, sum=0;

        //Create Scanner Object
        Scanner input = new Scanner(System.in);

        System.out.println("DISK SCHEDULING ALGORITHMS - C SCAN DISK ALGORITHM");
        //Prompt and accept user input for number of tracks to be traversed
        System.out.println("enter the no of tracks to be traversed");
        noTracks = input.nextInt();

        //Prompt and accept user input for position of head
        System.out.println("enter the position of head");
        posHead = input.nextInt();

        tracks[0]=0;
        tracks[1]=posHead;

        //Prompt and accept user input for total tracks
        System.out.println("enter total tracks");
        totalTracks = input.nextInt();
        tracks[2]=totalTracks-1;

        //Prompt and accept user input for tracks
        System.out.println("enter the tracks");
        for(i=3; i<=noTracks+2; i++) {
            tracks[i] = input.nextInt();
        }

        //
        for(i=0;i <=noTracks+2; i++) {
            for (j = 0; j <= (noTracks + 2) - i - 1; j++) {
                if (tracks[j] > tracks[j + 1]) {
                    temp = tracks[j];
                    tracks[j] = tracks[j + 1];
                    tracks[j + 1] = temp;
                }
            }
        }
        //
        for(i=0; i<=noTracks+2; i++) {
            if (tracks[i] == posHead)
            {
                j = i;
            }
            break;
        }
        p=0;
        //
        while(tracks[j]!=totalTracks-1)
        {
            atr[p]=tracks[j];
            j++;
            p++;
        }
        atr[p]=tracks[j];
        p++;
        i=0;

        //
        while(p!=(noTracks+3) && tracks[i]!= tracks[posHead])
        {
            atr[p]=tracks[i];
            i++;
            p++;
        }
        //
        for(j=0;j<noTracks+2;j++)
        {
            if(atr[j]>atr[j+1])
                d[j]=atr[j]-atr[j+1];
            else
                d[j]=atr[j+1]-atr[j];
            sum+=d[j];

        }
        //Display total header movements
        System.out.println("total header movements " + sum);
        //Display average
        System.out.println("Average is " + (float)sum/noTracks);

    }

    //A method to calculate bankers algorithm
    void Bankers() {
        //number of resources, resources type number
        int numProcess,resType;

        Scanner input = new Scanner(System.in);//Create instance of the Scanner class

        System.out.println("BANKER'S ALGORITHMS");
        //Prompt and accept input for number of processes
        System.out.print("Enter the number of processes: ");
        numProcess = input.nextInt();

        //Prompt and accept input for resource type number
        System.out.print("Enter the resource type number: ");
        resType = input.nextInt();

        int available[] = new int[resType];//Available resources
        int max[][] = new int[numProcess][resType];//Maximum number of resources
        //Resources allocated for every process
        int allocation[][] = new int[numProcess][resType];
        //Number of resources needed to complete every process
        int need[][] = new int[numProcess][resType];

        String sequence = "";


        //Prompt and accept input for the number of resources available
        // at the start of the processing
        for (int i = 0; i < resType; i++) {
            System.out.print("Number Of Available Resource " + (i+1) + ":");
            available[i] = input.nextInt();
        }

        //Prompt and accept allocated resources for every process
        for(int i = 0; i < numProcess; i++)
        {
            for(int j = 0; j < resType; j++)
            {
                System.out.print("Allocation R " + (i+1) + " for P " + (j+1) + ":");
                allocation[i][j] = input.nextInt();

            }
        }

        //Prompt and accept the maximum resources allocated for every process
        for(int i = 0; i < numProcess; i++)
        {
            for(int j = 0; j < resType; j++)
            {

                System.out.print("MAX R " + (i+1) + " for P " + (j+1) + ":");
                max[i][j] = input.nextInt();

                //Calculate the resources needed to reach every process maximum value
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }

        //Assign the available resources to the work array
        int work[] = available;
        //a finish boolean array to check which processes were executed
        boolean finish[] = new boolean[numProcess];

        //Set all the processes not done to be false
        for(int i = 0; i < numProcess; i++)
        {
            finish[i] = false;
        }


        boolean check = true;

        //Check if every process have been executed


            check = false;

            for(int i = 0; i < numProcess; i++)
            {
                if(!finish[i])
                {
                    int j;
                    //Check if the available resources is less than required
                    for(j = 0; j < resType; j++)

                    {
                        if(need[i][j] > work[j])
                        {
                            break;
                        }
                    }
                    //If every process executes successfully
                    //Arrange the processes in the order than they executed
                    if(j == resType)
                    {
                        for(j=0; j < resType; j++)
                        {
                            work[j] = work[j] + allocation[i][j];
                        }
                        finish[i] = true;
                        check = true;
                        sequence += i + ", ";
                    }
                }
            }
            int i;
            //If a process does not finish executing we break out of the loop
            //Deadlock occurs
            for(i = 0; i < numProcess; i++)
            {
                if(!finish[i])
                    break;
            }

            //Check if all the processes executes and then
            //Display them in the order than they executes
            if(i==numProcess)
            {
                System.out.print("SAFE And Sequence is: "+ sequence);
            }
            else
            {
                System.out.println("DEAD LOCK");
            }



    }

}


