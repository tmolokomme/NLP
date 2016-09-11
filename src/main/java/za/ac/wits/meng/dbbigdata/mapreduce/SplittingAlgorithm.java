/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.meng.dbbigdata.mapreduce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author F4728548
 */
public class SplittingAlgorithm {

    public static String FILE_DIR = "C:\\Drivers\\";

    public static File createFile(String outputFileName) {
        String filePath = FILE_DIR + outputFileName + ".txt";
        File file = new File(filePath);

        try (FileOutputStream fop = new FileOutputStream(file)) {
            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            // get the content in bytes
            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public void splitFile(String inputFile, int size) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String sCurrentLine;
            int prevRowCount = -1;
            File file;
            FileWriter fw;
            BufferedWriter bw = null;
            while ((sCurrentLine = br.readLine()) != null) {
                //System.out.println(sCurrentLine);
                String[] line;
                line = sCurrentLine.split(",");
                int rowNum = Integer.valueOf(line[0].trim());
                if (rowNum != prevRowCount) {
                    if (bw != null) {
                        bw.close();
                    }
                    file = createFile(String.valueOf(rowNum));
                    prevRowCount = rowNum;
                    fw = new FileWriter(file.getAbsoluteFile());
                    bw = new BufferedWriter(fw);
                }
                bw.write(sCurrentLine + "\n");
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        SplittingAlgorithm splitter = new SplittingAlgorithm();
        String inputFileA = "File_100_A.txt";
        String inputFilePathA = FILE_DIR + inputFileA;
        splitter.splitFile(inputFilePathA, 0);
        
        
    }

}
