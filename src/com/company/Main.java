package com.company;

import java.io.*;
import java.util.*;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) {


        Scanner sf = new Scanner(new File("/Users/tw073/IdeaProjects/twp-read-this-2018-twildasin/src/Imports.txt"));
        int maxIndx = -1; //-1 so when we increment below, first index is 0
        String text[] = new String[1000]; //to be safe, declare more than we need

        while(sf.hasNext( ))
        {
            maxIndx++;
            text[maxIndx] = sf.nextLine( ) ;
        }
//maxIndx is now the highest index of text[], -1 if no text lines
        sf.close( ); //We opened a file above so close it when finished.

        ///Users/tw073/IdeaProjects/twp-read-this-2018-twildasin/src/Imports.txt
        //page 130 in Blue Pelican
    }
}
