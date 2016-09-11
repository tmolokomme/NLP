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
public class MappingAlgorithm {

    private static int[][] B;
    
    private static String inputMapFolder = Util.ROOT_DIR + Util.SPLIT_OUT_MAP_IN;
    private static String outputMapFolder = Util.ROOT_DIR + Util.MAP_OUT_SHUFFLE_IN;
    
    public static void initializeMatrix(String matrixB_InputFileName, int matrixSize) {
        String inputFilePath = Util.ROOT_DIR + Util.B_MATRIX_FOLDERA + matrixB_InputFileName;
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            B = new int[matrixSize][matrixSize];
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

    public void map(int fileNo) {
        String fileB = "File_100_B.txt";
        String matrixAFileName = fileNo + ".txt";
        initializeMatrix(fileB, 100);
        try {
            int bColIdx = 0;
            File file;
            FileWriter fw;
            BufferedWriter bw = null;               
            String outputFilePath = outputMapFolder + matrixAFileName;
            file = Util.createFile(outputFilePath);
            //prevRowCount = rowNum;
            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            String inputMapFile = inputMapFolder + matrixAFileName;         
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

    public static void main(String[] args) {
        MappingAlgorithm mapping = new MappingAlgorithm();
        int fileNum  = 0;
         //+ fileNum + ".txt";
        //mapping.map(filePathA, fileNum);

    }

}
