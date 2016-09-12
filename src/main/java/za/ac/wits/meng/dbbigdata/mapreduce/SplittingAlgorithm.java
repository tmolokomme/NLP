/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.meng.dbbigdata.mapreduce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author F4728548
 */
public class SplittingAlgorithm {
    private String inputFolder = Util.ROOT_DIR;
    private String outputFolder = Util.ROOT_DIR + Util.SPLIT_OUT_MAP_IN;
    
    public int splitFile(String inputFile) { //, int splitSize
        int noOfFiles = 0;
        String inputFilePath = inputFolder + inputFile;
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
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
                    String outputFileName = outputFolder + String.valueOf(rowNum) + ".txt";
                    file = Util.createFile(outputFileName);
                    noOfFiles += 1;
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
        return noOfFiles;
    }
    
    /*public static void main(String[] args) {
        SplittingAlgorithm splitter = new SplittingAlgorithm();
        String inputFileA = "File_100_A.txt";
        String inputFilePathA = Util.ROOT_DIR + inputFileA;
        splitter.splitFile(inputFilePathA);
        
        
    } */

}
