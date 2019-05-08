package com.stackoverflow;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * to run from command line.
 * 1. goto directory
 * /Users/rstannard/dev/poc/java/processbuilder-poc/target/classes
 * 2. run the following command from the commandline
 * java -cp . com.stackoverflow.Counter
 */



public class Counter {

    private final int count;

    public Counter(int count){
        this.count = count;
        System.out.println("inside the constructor");
        process();
    }

//    public Counter(){
//        this.count = 10;
//        System.out.println("inside the default constructor");
//        process();
//    }

    public static void main(String [] args){
        new Counter(Integer.valueOf("10"));
    }

    private void process(){
        int i = 0;
        List<String> lines = new ArrayList();
        String line = "started.....";
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(line);
        lines.add(line);
        while (i < this.count) {
            line = "...processing count " + i;
            System.out.println(line);
            try {
                timestamp = new Timestamp(System.currentTimeMillis());
                System.out.println(timestamp);
                //return number of milliseconds since January 1, 1970, 00:00:00 GMT
                //System.out.println(timestamp.getTime());
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.print(">>>>>about to print stacktrace");
                e.printStackTrace();
            }
            i++;
            lines.add(line + " " + timestamp);
            if (i == 5){
                throw new RuntimeException("ooops some exception just been raised");
            }
        }
        line = "completed.....";
        System.out.println(line);
        lines.add(line);
        Path file = Paths.get("Counter.txt");
        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
