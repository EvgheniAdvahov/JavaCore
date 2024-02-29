package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Program1 {

    public static void main(String[] args) throws IOException {
        print(new File("."), true, true);
    }

    static void print(File file, boolean isLast, boolean dirFlag) throws IOException {

        if (dirFlag)
            if (Files.exists(Path.of("./Backup"))) {
                System.out.println("BackUp folder already exist");
                dirFlag = false;
            } else {
                File backUpDir = new File("./backUP/");
                backUpDir.mkdir();
                dirFlag = false;
            }


        File[] myFiles = file.listFiles();

        if (file.getName().equals("backUP")) {
            return;
        }
        for (File myFile : myFiles) {
            if (myFile.isDirectory() && !myFile.getName().equals("backUP")) {
                File newDir = new File("./backUP/" + myFile.getParentFile() + "/" + myFile.getName());
                newDir.mkdir();
            }
            if (myFile.isFile()) {
                try (FileOutputStream fileOutputStream = new FileOutputStream("./backUP/" + myFile.getParentFile() + "/" + myFile.getName())) {
                    int c;
                    //reading
                    try (FileInputStream fileInputStream = new FileInputStream(myFile)) {
                        while ((c = fileInputStream.read()) != -1) {
                            fileOutputStream.write(c);
                        }
                    }
                }
            }
        }

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                subDirTotal++;
            }
        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                print(files[i], subDirTotal == ++subDirCounter, dirFlag);
            }
        }
    }
}
