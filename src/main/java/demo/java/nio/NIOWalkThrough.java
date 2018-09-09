package demo.java.nio;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class NIOWalkThrough {

    public static void demoFileChannel() throws IOException {
        RandomAccessFile file = new RandomAccessFile("demo_files/someText", "rw");

        FileChannel fileChannel = file.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int bytesRead = fileChannel.read(byteBuffer);

        while(bytesRead != -1) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get()); //Char is 1 byte in java
            }

            byteBuffer.clear();
            bytesRead = fileChannel.read(byteBuffer);
        }

        file.close();
    }

    public static void main(String[] args) throws Exception {
        demoFileChannel();
    }
}
