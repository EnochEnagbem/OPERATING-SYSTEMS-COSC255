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

            //Call the first-come-first-serve disk technique method
            fcfsDISKALGORITHM();


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
    //A method to calculate  first come first serve disk scheduling algorithm
    static void fcfsDISKALGORITHM(){
        //Number of tracks traversed, different between tracks
        int[] tracksTrav = new int[20],diffTracks = new int[20];
        //number of tracks, counter, total tracks
        int noTracks, i, tot = 0;
        //Average header movement
        float avgheaderMov;

        //Create scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("DISK SCHEDULING ALGORITHMS - FIRST-COME-FIRST-SERVE");
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

    //Prompt the user to run the program again or not
    private static void runAgain(){
        System.out.println("DO YOU WANT TO RUN THE PROGRAM AGAIN(y/n)");
    }

}
