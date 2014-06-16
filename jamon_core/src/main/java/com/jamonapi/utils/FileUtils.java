package com.jamonapi.utils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

/** Reusable Utilities used for File manipulations such as reading a file as a String.  **/
public class FileUtils extends java.lang.Object {
    /**
     * Read text files contents in as a String.
     * 
     * <p>Sample Call:
     *  String contents=FileUtils.getFileContents("autoexec.bat");
     **/
    public static String getFileContents(String fileName)throws FileNotFoundException,IOException {
        Monitor mon=MonitorFactory.start("com.jamonapi.utils.FileUtils-getFileContents()");
        final int EOF=-1;
        StringBuffer fileContents = new StringBuffer();
        BufferedReader inputStream=null;

        // Loop through text file storing contents of the file in a string buffer and return the files
        // contents to the caller.
        try {

            inputStream   = new BufferedReader(new FileReader(fileName));
            int inputChar = inputStream.read();

            while (inputChar!=EOF) {
                fileContents.append((char) inputChar);
                inputChar = inputStream.read();
            }
        }
        finally {
            if (inputStream!=null) {
                inputStream.close();
            }
            mon.stop();
        }

        return fileContents.toString();

    }
}
