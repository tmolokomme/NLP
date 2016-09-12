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
public class ReduceAlgorithm {
    
    private String inputFolder = Util.ROOT_DIR + Util.SHUFFLE_OUT_REDUCE_IN;
    private String outputFolder = Util.ROOT_DIR ; //+ Util.REDUCE_OUT_RESULT_IN;
    

    public void reduce(String outputFileName, int size) {
        int idx = 0;

        File file;
        FileWriter fw;
        BufferedWriter bw = null;
        String outputPath = outputFolder + String.valueOf(outputFileName);
        try {
            file = Util.createFile(outputPath);
            //prevRowCount = rowNum;
            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);

            while (idx < size) {
                //Fetch
                String inputFile = inputFolder + idx + ".txt";
                try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
                    String sCurrentLine = "";
                    while ((sCurrentLine = br.readLine()) != null) {
                        if(!sCurrentLine.endsWith(("0")))
                        {
                            bw.write(sCurrentLine + "\n");
                            bw.flush();
                        }
                    }
                } catch (IOException e) {
                }
                idx++;
                //Write
            }
        } catch (IOException iox) {
        //} finally {
//            if (bw != null) {
//                bw.close();
//            }
        }
        System.out.println("reduce step completed successfully - final results in: " + outputFolder + String.valueOf(outputFileName));

    }
    
    /*public static void main(String[] args) {
        ReduceAlgorithm reduceAlg = new ReduceAlgorithm();
        //shuffleAlg.initializeMatrix(fileB, 100);
        //int fileNum  = 0;
        String outputFilename = "FinalResult";
        //String inputFile = SplittingAlgorithm.FILE_DIR + "V_1.txt";
        reduceAlg.reduce(outputFilename, 2);
    }*/

}
