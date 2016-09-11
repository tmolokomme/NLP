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
public class MappingAlgorithm {
    
    private static int[][] B ;
    
    public static void initializeMatrix(String fileName, int matrixSize) {
       //String dirname = "D:\\DevelopmentWork\\SCHOOL\\WITS\\";
        String dirname = "C:\\Drivers\\";            
        //BufferedReader br = null;
        String filePath = dirname + fileName; 
        //System.out.println("----->>>>>>>>>>>>>>>>>>>>>>>>>>>");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){    
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
                
    public void map(String inputFileMatrixA, String matrixBFileXXX) {
         try (BufferedReader br = new BufferedReader(new FileReader(inputFileMatrixA))) {
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
                int colNum = Integer.valueOf(line[1].trim());
                int valNum = Integer.valueOf(line[2].trim());
                
                if (rowNum != prevRowCount) {
                    if (bw != null) {
                        bw.close();
                    }
                    file = SplittingAlgorithm.createFile(String.valueOf("M_C_0"+ 1));
                    prevRowCount = rowNum;
                    fw = new FileWriter(file.getAbsoluteFile());
                    bw = new BufferedWriter(fw);
                }
               
                //
                int product = valNum * B[colNum][1];
                String outputLine = rowNum + ","  + colNum + ","+ product + "\n";
                bw.write(outputLine);
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        MappingAlgorithm mapping = new MappingAlgorithm();
        String fileB = "File_100_B.txt";
        mapping.initializeMatrix(fileB, 100);
        String filePathA = SplittingAlgorithm.FILE_DIR + "0.txt";
        mapping.map(filePathA, "");
    
    }
    
    
}
