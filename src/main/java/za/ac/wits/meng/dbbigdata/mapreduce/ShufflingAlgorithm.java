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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author F4728548
 */
public class ShufflingAlgorithm implements Runnable {
    private String inputFolder = Util.ROOT_DIR + Util.MAP_OUT_SHUFFLE_IN;
    private String outputFolder = Util.ROOT_DIR + Util.SHUFFLE_OUT_REDUCE_IN;

    private String inputFile;
    private int fileNumA;
    
    public ShufflingAlgorithm(String inputFile, int fileNumA) {
        this.inputFile = inputFile;
        this.fileNumA = fileNumA;
    }
        
    @Override
    public void run() { 
        shuffle(inputFile, fileNumA);
    }
     
    private void shuffle(String inputFile, int fileNumA) {
        String inputPath = inputFolder + inputFile;
        boolean isFileCreatedAlready = false;
        while(!isFileCreatedAlready) {
            File f = new File(inputPath);
            if(f.exists()) { 
                isFileCreatedAlready = true;
            } else {
                System.out.println("Thread: " + fileNumA + " waiting for a file: " + inputFile);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ShufflingAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {

            int previousCol = 0;
            String sCurrentLine = "";
            int _matrixSum = 0;
            //
            File file;
            FileWriter fw;
            BufferedWriter bw = null;
            String outputPath = outputFolder + inputFile; //String.valueOf(fileNum) + ".txt";
            file = Util.createFile(outputPath);
            //prevRowCount = rowNum;
            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            boolean isEOF = false;
            String outputLine = "";
            int aRowNum = 0;
            int valNum = 0;
            while (!isEOF) {
                if ((sCurrentLine = br.readLine()) != null) {
                    String[] line;
                    line = sCurrentLine.split(",");
                    aRowNum = Integer.valueOf(line[0].trim());
                    int aColNum = Integer.valueOf(line[1].trim());
                    valNum = Integer.valueOf(line[2].trim());

                    if (previousCol != aColNum) {
                        //write into a file
                        outputLine = aRowNum + "," + previousCol + "," + _matrixSum + "\n";
                        bw.write(outputLine);
                        bw.flush();

                        _matrixSum = valNum;
                        previousCol = aColNum;
                    } else {
                        _matrixSum += valNum;
                    }
                } else {
                    _matrixSum += valNum;
                    outputLine = aRowNum + "," + previousCol + "," + _matrixSum + "\n";
                    bw.write(outputLine);
                    bw.flush();                    
                    isEOF = true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*public static void main(String[] args) {
//        ShufflingAlgorithm shuffleAlg = new ShufflingAlgorithm();
        //shuffleAlg.initializeMatrix(fileB, 100);
        //int fileNum  = 0;
        String outputFilename = "SV0";
        String inputFile = "0.txt"; //SplittingAlgorithm.FILE_DIR + 
        new ShufflingAlgorithm(inputFile, 0).run();
//        shuffleAlg.shuffle(inputFile, 0);
    }*/
}
