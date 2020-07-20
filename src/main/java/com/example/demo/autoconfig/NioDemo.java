package com.example.demo.autoconfig;


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class NioDemo extends Hello {

  public NioDemo(String msg) {
    // super(msg);
    System.out.println("NioDemo");
  }

  public static void main(String[] args) throws IOException {
    NioDemo nioDemo = new NioDemo("asd");
    FileInputStream inputStream = new FileInputStream("D:\\lxk\\nio.txt");
    FileChannel channel = inputStream.getChannel();
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
    while (true) {
      int read = channel.read(byteBuffer);
      if (read == -1) {
        break;
      }
      byteBuffer.flip();
      String result = Charset.forName("utf-8").decode(byteBuffer).toString();
      System.out.println(result);
      byteBuffer.clear();
    }
    byte b = byteBuffer.get();
    String result = Charset.forName("utf-8").decode(byteBuffer).toString();
    System.out.println(result);

  }

}
