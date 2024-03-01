package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task1LessonVariant {

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
            Task1MyVariant.copyFile(myFile);
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
