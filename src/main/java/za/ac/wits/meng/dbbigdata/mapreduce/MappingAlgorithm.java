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
public class MappingAlgorithm extends Thread {

    private static int[][] B;
    private int outputFileNo;
    private String matrixB_InputFileName;
    private int matrixBsize;

    private static String inputMapFolder = Util.ROOT_DIR + Util.SPLIT_OUT_MAP_IN;
    private static String outputMapFolder = Util.ROOT_DIR + Util.MAP_OUT_SHUFFLE_IN;

    public MappingAlgorithm(int outputFileNo, String matrixB_InputFileName, int matrixBsize) {
        this.matrixB_InputFileName = matrixB_InputFileName;
        this.matrixBsize = matrixBsize;
        this.outputFileNo = outputFileNo;
    }

    public void run() {
        //String fileB = "File_100_B.txt";
        initializeMatrix();
        map();
    }

    public void initializeMatrix() {
        String inputFilePath = Util.ROOT_DIR + matrixB_InputFileName;
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            B = new int[matrixBsize][matrixBsize];
            String sCurrentLine;
            //br = new BufferedReader(new FileReader(pathA)); //"C:\\testing.txt"));
            String[] line;
            while ((sCurrentLine = br.readLine()) != null) {
                //System.out.println(sCurrentLine);
                line = sCurrentLine.split(",");
                int rowNum = Integer.valueOf(line[0].trim());
                int colNum = Integer.valueOf(line[1].trim());
                int valNum = Integer.valueOf(line[2].trim());
                B[rowNum][colNum] = valNum;
            }
            //System.out.println("----->>>>>>>>>>>>>>>>>>>>>>>>>>>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void map() {
        String in_outFileName = outputFileNo + ".txt";
        try {
            int bColIdx = 0;
            File file;
            FileWriter fw;
            BufferedWriter bw = null;
            String outputFilePath = outputMapFolder + in_outFileName;
            file = Util.createFile(outputFilePath);
            //prevRowCount = rowNum;
            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            String inputMapFile = inputMapFolder + in_outFileName;

            boolean isFileCreatedAlready = false;
            while (!isFileCreatedAlready) {
                File f = new File(inputMapFile);
                if (f.exists()) {
                    isFileCreatedAlready = true;
                } else {
                    System.out.println("Thread: " + outputFileNo + " waiting for a file: " + inputMapFile);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ShufflingAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            while (bColIdx < B[0].length) {

                try (BufferedReader br = new BufferedReader(new FileReader(inputMapFile))) {
                    String sCurrentLine;
                    while ((sCurrentLine = br.readLine()) != null) {
                        //System.out.println(sCurrentLine);
                        String[] line;
                        line = sCurrentLine.split(",");
                        int aRowNum = Integer.valueOf(line[0].trim());
                        int aColNum = Integer.valueOf(line[1].trim());
                        int valNum = Integer.valueOf(line[2].trim());

                        int product = valNum * B[aColNum][bColIdx];
                        String outputLine = aRowNum + "," + bColIdx + "," + product + "\n";
                        bw.write(outputLine);
                        bw.flush();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                ++bColIdx;
            }
        } catch (IOException ex) {
            Logger.getLogger(MappingAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*public static void main(String[] args) {
        MappingAlgorithm mapping = new MappingAlgorithm(0, "File_100_B.txt", 100);
        int fileNum = 0;
        //+ fileNum + ".txt";
        //mapping.map(filePathA, fileNum);

    } */

}
