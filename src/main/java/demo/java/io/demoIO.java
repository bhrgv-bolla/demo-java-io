package demo.java.io;

import java.io.*;

public class demoIO {


    public static void demoStreamTokenizer() throws IOException {
        FileReader fileReader = new FileReader("demo_files/fileWith10Words");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StreamTokenizer streamTokenizer = new StreamTokenizer(bufferedReader);

        int t;
        int words = 0;
        while((t = streamTokenizer.nextToken()) != StreamTokenizer.TT_EOF) {
            switch(t) {
                case StreamTokenizer.TT_WORD:
                    System.out.println(streamTokenizer.sval);
                    words++;
                    break;
            }


        }

        System.out.println("Num Words: "+  words);
    }


    public static void main(String[] args) throws IOException {
        demoStreamTokenizer();
    }
}
