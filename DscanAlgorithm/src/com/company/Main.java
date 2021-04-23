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

            //Call the d-scan disk scheduling technique method
            DScanDisk();


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
    static //A method to calculate  d scan disk scheduling algorithm
    void DScanDisk(){
        //tracks
        int[] tracks = new int[20], d = new int[20],atr = new int[20];
        //position head, counters(i,j), total number of Tracks
        int posHead, i, j = 0, noTracks, temp, totalTracks, p, sum=0;

        //Create Scanner Object
        Scanner input = new Scanner(System.in);

        System.out.println("DISK SCHEDULING ALGORITHMS - DSCAN");
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
}
