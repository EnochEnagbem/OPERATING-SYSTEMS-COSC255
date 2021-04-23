package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Used to control a while loop
        boolean flag = true;
        //used to get the char value to run the program again or not
        char runAgain;
        //A while loop to run the program again
        while(flag) {

            //Create an instance of the Scanner Class
            Scanner input = new Scanner(System.in);

            //Call the scan disk scheduling technique method
            scanDisk();


            System.out.println("------------------------------------------");
            //Run again method
            runAgain();
            runAgain = input.next().charAt(0);
            //Check if the user want to run the program again
            if(runAgain == 'y') {
                flag = true;
            } else
                flag = false;

        }
    }

    //Prompt the user to run the program again or not
    private static void runAgain(){
        System.out.println("DO YOU WANT TO RUN THE PROGRAM AGAIN(y/n)");
    }
    //A method to calculate  scan scheduling disk algorithm
    static void scanDisk(){
        //Tracks, direction
        int[] tracks = new int[20], d = new int[20], atr = new int[20];
        //position head, counter, number of tracks, temp
        int posHead, i, j = 0, noTracks, temp, k = 0,p, sum=0;

        //Create Scanner Object
        Scanner input = new Scanner(System.in);

        System.out.println("DISK SCHEDULING ALGORITHMS - SCAN");
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
        for(i=0; i<noTracks+2; i++)
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

}
