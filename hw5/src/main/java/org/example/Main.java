package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        backup(new File("."), new File("./backUP"));
    }
    static void backup(File pathDirectory, File pathBackUPDir) throws IOException {
        File[] files = pathDirectory.listFiles();
        for (File file : files) {
            if (file.isDirectory() && !file.getName().equals("backUP")){
                File newDir =  new File(pathBackUPDir + "/" + file.getName() + "/");
                newDir.mkdir();
                System.out.println(file.getName());
            } else if (file.isFile()) {
                try(FileOutputStream fileOutputStream = new FileOutputStream(pathBackUPDir + "/" + file.getName())){
                    int c;
                    //reading
                    System.out.println(file.getName()+ " = file");
                    try(FileInputStream fileInputStream = new FileInputStream(file)){
                        while ((c = fileInputStream.read()) != -1) {
                            fileOutputStream.write(c);
                        }
                    }
                }
            }
        }
    }

}