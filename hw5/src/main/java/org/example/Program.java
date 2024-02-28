package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Program {

    public static void main(String[] args) throws IOException {
        print(new File("."));
//        backup(new File("."), new File("./backUP"));

    }
        static void print(File file) throws IOException {
        File[] files = file.listFiles();
        String dirPath="./backUP";
            for (File file1 : files) {
                if (file1.isDirectory() && !file1.getName().equals("backUP") ){
                    File newDir = new File(dirPath + "/" + file1.getName() + "/");
                    newDir.mkdir();
                    System.out.println(file1.getName());
//                    dirPath = dirPath + "/" + file1.getName() + "/";
//                    print(new File(String.valueOf(file1)));
                }
            }
        }
}
