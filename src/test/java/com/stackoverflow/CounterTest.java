package com.stackoverflow;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.lang.Boolean.TRUE;

public class CounterTest {

    @Test
    public void shouldStartCounterViaProcessBuilder() throws IOException
    {
        try {
            String classpath = System.getProperty("java.class.path");
            ProcessBuilder pb = new ProcessBuilder(new String[]{"java","-cp",classpath,"com.stackoverflow.Counter"});
            pb.redirectErrorStream(TRUE);
            Process process = pb.start();
            String label = "inputStream";
            System.out.println(">>>>printing from <" + label + ">");
            printInputStream(process.getInputStream());
            System.out.println("<<<<<end of stream <" + label + ">");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void printInputStream(InputStream in) {
        try {
            String line;
            int i = 0;
            BufferedReader input = new BufferedReader(new InputStreamReader(in));
            while ((line = input.readLine()) != null) {
                System.out.println(++i + " " + line);
            }
            input.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
