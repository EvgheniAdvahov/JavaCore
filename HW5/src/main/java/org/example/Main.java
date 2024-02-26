package org.example;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        backup(new File("."), new File("./backUP"));
    }
    static void backup(File pathDirectory, File pathBackUPDir) throws IOException {
        File[] files = pathDirectory.listFiles();
        System.out.println(files);
        for (File file : files) {
            if (file.isDirectory()){
               File newDir =  new File(String.valueOf(pathBackUPDir) + file);
               newDir.mkdir();
                System.out.println(file.getName());
            }
        }
    }
}