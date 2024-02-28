package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Program1 {

    public static void main(String[] args) throws IOException {
        print(new File("."), "", true);
    }

    static void print(File file, String indent, boolean isLast) throws IOException {
        File[] myFiles = file.listFiles();

        System.out.println(file.getName());
        System.out.println("++++++++++++++++++++++++++");
        for (File myFile : myFiles) {
            if(myFile.isDirectory() && !myFile.getName().equals("backUP")){
                File newDir = new File("./backUP/"+ myFile.getParentFile() + "/" + myFile.getName());
                newDir.mkdir();
//                System.out.println(myFile.getParentFile());
            } else if (myFile.isFile()) {
//                Path newFilePath = Paths.get("./backUP/"+ myFile.getParentFile() + "/" + myFile.getName());
//                Files.createFile(newFilePath);
            }
            System.out.println(myFile.getName());
        }
        System.out.println("==========================");

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory())
            {

                subDirTotal++;
            }
        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory())
            {


                print(files[i], indent, subDirTotal == ++subDirCounter);
            }
        }

    }

}
