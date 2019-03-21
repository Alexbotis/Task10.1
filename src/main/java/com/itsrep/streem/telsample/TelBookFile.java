package com.itsrep.streem.telsample;

import java.io.File;
import java.io.IOException;

public class TelBookFile {



    public static void createNewFile( String fileName) throws IOException {

        //String fileName = "telbook.txt";
        String fullName = "";
        String dirName = System.getProperty("user.dir");
        fullName = dirName + File.separator + fileName;
        File file = new File(fullName);

        if (!file.exists()) {

            if (file.createNewFile())
                System.out.println("File created");
            else
                System.out.println("Something Wrong!");
            throw new IOException();


        }

    }



}
