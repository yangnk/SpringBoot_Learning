package com.yangnk.test3;

import org.springframework.util.DigestUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class Test {

    public static void main(String[] args) {


        int a = 5;
        int b = a << 1;
        int c = a >> 1;
        System.out.println("b = " + b);
        System.out.println("c = " + c);

//
//        String s = DigestUtils.md5DigestAsHex(("salt" + "password" + "salt").getBytes()).toUpperCase();
//        System.out.println("s = " + s);
//
//        String s1 = DigestUtils.md5DigestAsHex("abc".getBytes(StandardCharsets.UTF_8)).toUpperCase();
//        System.out.println("s1 = " + s1);


//        RandomAccessFile randomAccessFile = new RandomAccessFile("./test.dat", "rw");
//        try {
//            RandomAccessFile raf = new RandomAccessFile("/Users/yangnk/IdeaProjects/SpringBoot-Learning/SpringBootDemo/src/main/java/com/yangnk/test3/test.dat","rw");
//
//            raf.write(3123123);
//
//            byte[] bytes = new byte[1024];
//            raf.read(bytes);
//            System.out.println("read = " + bytes.toString());
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        String s = UUID.nameUUIDFromBytes("中科大先研院".getBytes()).toString();
//
//        System.out.println("s = " + s);
    }
}
