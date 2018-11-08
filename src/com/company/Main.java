package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


        Scanner sf = new Scanner(new File("Imports.txt"));
        int maxIndx = -1;
        String text[] = new String [300];


        //Creates arrays for each factor (name, average, etc)
        String fname[] = new String [100];
        String lname[] = new String [100];
        int average[] = new int [100];
        int absences[] = new int [100];

        //Creates a new scanner for the loop
        Scanner sf2;

        //Removes first line that gives the titles "First name", "Last name", etc.
        sf.nextLine();

        //Stores every line in the text document (not the first line [see above]) in the array "text" and removes "%".
        while(sf.hasNext())
        {
            maxIndx++;
            text[maxIndx] = sf.useDelimiter("\\t").nextLine() + "\t";
            text[maxIndx] = text[maxIndx].replace("%", "");
        }

        //Stores each value as their proper variable in their array.
        for (int i = 0; i < maxIndx+1; i++)
        {
            sf2 = new Scanner(text[i]);
            sf2.useDelimiter("\\t");
            fname[i] = sf2.next();
            lname[i] = sf2.next();
            average[i] = Integer.parseInt(sf2.next());
            absences[i] = Integer.parseInt(sf2.next());

        }

        /*
        for (int a: absences)
        {
            System.out.println(a);
        }
        */

        //System.out.println(fname[0] + lname[1] + average[2] + absences[3]);

        //--------------------------------------------Separation----------------------------------------\\

        int numA = 0, numB = 0, numC = 0, numD = 0, numF = 0;
        for(int i = 0; i < fname.length; i++)
        {
            if(average[i] >= 90)
                numA++;
            else if(average[i] >= 80)
                numB++;
            else if(average[i] >= 70)
                numC++;
            else if(average[i] >= 60)
                numD++;
            else if(average[i] < 60 && average[i] > 0)
                numF++;
        }

        System.out.println("Class Grades:");
        System.out.println("A's - " + numA);
        System.out.println("B's - " + numB);
        System.out.println("C's - " + numC);
        System.out.println("D's - " + numD);
        System.out.println("F's - " + numF);



        //--------------------------------------------Separation----------------------------------------\\


        boolean cont = false;
        boolean nameNotFound = false;
        Scanner kbin = new Scanner(System.in);
        String first = "";
        String last = "";
        int placeInArray = -1;

        System.out.println("\nWelcome to the student sorter");

        while(cont == false)
        {
            do
            {
                System.out.println("\nPlease enter the first name of the student you want to find:");
                first = kbin.nextLine();
                System.out.println("Please enter the last name:");
                last = kbin.nextLine();
                System.out.println("Searching for student...");

                for(int i = 0; i < fname.length; i++)
                {
                    if (Objects.equals(fname[i], first) && (Objects.equals(lname[i], last)))
                    {
                        placeInArray = i;

                    }
                }

                if(placeInArray == -1)
                {
                    System.out.println("\nName not found, please try again");
                    nameNotFound = false;
                }

                else
                {
                    System.out.println("\nStudent: " + fname[placeInArray] + " " + lname[placeInArray]);
                    System.out.println("Average Grade: " + average[placeInArray] + "%");
                    System.out.println("Absences: " + absences[placeInArray]);
                    if(absences[placeInArray] >=5 && average[placeInArray] < 70)
                        System.out.println("**Warning: Student's absences may be hurting their grade**");
                    placeInArray = -1;
                }
            }while(nameNotFound = false);


            System.out.println("\nInput \"Exit\" to stop. Press enter to find another student");

            if (Objects.equals(kbin.nextLine().toLowerCase(), "exit"))
                cont = true;


        }


    }
}
