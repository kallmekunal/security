package com.kunal.examples.sensetiveinfo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExposeSensetiveInfo {

    public static void main(String args[]) {
        BufferedReader reader = null;
        String directory  = "C:\\Users\\t0305426\\kunal\\DIY\\logical\\logical-programs\\src\\com\\kunal\\practice\\file\\";
        String filePath = "testfile.txt";
        try {
            reader = new BufferedReader(new FileReader(directory + filePath));
        } catch (Exception e) {
            System.out.println("Specified file "+ filePath + "Does not exist");
        }

        List<String> lines = new ArrayList<>();
        String line = null;
        while (true) {
            try {
                if (!((line = reader.readLine()) != null))
                    break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            lines.add(line);
        }
        lines.stream().forEach( e -> System.out.println(e));
    }

}
