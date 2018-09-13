package demo.java.io;

import java.io.*;

public class demoIO {


    public static void demoStreamTokenizer() throws IOException {
        FileReader fileReader = new FileReader("demo_files/fileWith10Words");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StreamTokenizer streamTokenizer = new StreamTokenizer(bufferedReader);

        int t;
        int words = 0;
        while ((t = streamTokenizer.nextToken()) != StreamTokenizer.TT_EOF) {
            switch (t) {
                case StreamTokenizer.TT_WORD:
                    System.out.println(streamTokenizer.sval);
                    words++;
                    break;
            }
        }

        System.out.println("Num Words: " + words);
    }


    private static void demoFileWriter() throws IOException {
        FileWriter fileWriter = new FileWriter("demo_files/fileWriter");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("some text");
        bufferedWriter.flush();

        fileWriter.close();

        FileReader fileReader = new FileReader("demo_files/fileWriter");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String t;
        while ((t = bufferedReader.readLine()) != null) {
            System.out.println(t);
        }
    }


    public static void main(String[] args) throws IOException {
        demoStreamTokenizer();
        demoFileWriter();
    }
}
