/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author F4728548
 */
class MatrixStructure {
    public int row;
    public int column;
    public int value;
}

public class MatrixCalculator {

    /*
    static List<MatrixStructure> matixA = new ArrayList<>();
    static List<MatrixStructure> matixB = new ArrayList<>();
    static List<MatrixStructure> matixC = new ArrayList<>();
    */
    
    private static int[][] A ;//= {{1, 4, 6}, {2, 7, 5}};
    private static int[][] B ; //= {{1, 4, 6, 10}, {2, 7, 5, 3}, {9, 0, 11, 8}};

    /*void tryThis() {
         MatrixStructure combA = new MatrixStructure();
        combA.row = 0;
        combA.column = 0;
        combA.value = -3;
        matixA.add(combA);
        
        
         MatrixStructure combB = new MatrixStructure();
        combB.row = 0;
        combB.column = 0;
        combB.value = -3;
        matixB.add(combB);
        for (MatrixStructure itemA: matixA) {
            int sum = 0;
            for (MatrixStructure itemB: matixB) {
                int prod = itemA.row * itemB.column;
                sum += prod;
            }
            MatrixStructure combC = new MatrixStructure();
            combC.row = itemA.row;
            combC.column = itemA.column;
            combC.value = sum;
            //sum = 
        }
    } */
    
    public static void initializeArrays(String fileName, int matrixSize, int which) {
       //String dirname = "D:\\DevelopmentWork\\SCHOOL\\WITS\\";
        String dirname = "C:\\Drivers\\";            
        //BufferedReader br = null;
        String filePath = dirname + fileName; 
        //System.out.println("----->>>>>>>>>>>>>>>>>>>>>>>>>>>");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){    
            if (which == 1) {
                A = new int[matrixSize][matrixSize];
            } else {
                B = new int[matrixSize][matrixSize];
            }
            String sCurrentLine;
            //br = new BufferedReader(new FileReader(pathA)); //"C:\\testing.txt"));
            String[] line;
            while ((sCurrentLine = br.readLine()) != null) {
                //System.out.println(sCurrentLine);
                line = sCurrentLine.split(",");
                int rowNum = Integer.valueOf(line[0].trim());
                int colNum = Integer.valueOf(line[1].trim());
                int valNum = Integer.valueOf(line[2].trim());
                if (which == 1) {
                    A[rowNum][colNum] = valNum;
                } else {
                    B[rowNum][colNum] = valNum;
                }
            }
            //System.out.println("----->>>>>>>>>>>>>>>>>>>>>>>>>>>");
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    public static void _100Run() {
        String fileA = "File_100_A.txt";
        String fileB = "File_100_B.txt";
        int _100_matrix = 100;
        initializeArrays(fileA, _100_matrix, 1);
        initializeArrays(fileB, _100_matrix, 2);
    }
    
    public static void _1000Run() {
        String fileA = "File_1000_A.txt";
        String fileB = "File_1000_B.txt";
        int _1000_matrix = 1000;
        initializeArrays(fileA, _1000_matrix, 1);
        initializeArrays(fileB, _1000_matrix, 2);
    }
    
    public static void _2000Run() {
         String fileA = "File_2000_A.txt";
        String fileB = "File_2000_B.txt";
        int _2000_matrix = 2000;
        initializeArrays(fileA, _2000_matrix, 1);
        initializeArrays(fileB, _2000_matrix, 2);;
    }

    public static void main(String[] args) {

        //printProductMatrix(A);
        //printProductMatrix(B);
        //System.exit(-1);
        int matrix_num = 1;
        switch (matrix_num) {
            case 1:
                _100Run();
                break;
            case 2:
                _1000Run(); 
                break;
            default:
                _2000Run();
                break;   
        }
        int alenrow = A.length;
        int blencol = B[0].length;
        int[][] C = new int[alenrow][blencol];

        long calcStartTime = System.currentTimeMillis();
        int i = 0;
        System.out.println("A:" + alenrow + " | B:" + blencol);
        int alencol = A[0].length;
        while (i < alenrow) {
            int j = 0;
            while (j < blencol) {
                int sum = 0;
                int k = 0, product = 0;
                while (k < alencol) {
                    product = A[i][k] * B[k][j];
                    sum += product;
                    k++;
                }
                C[i][j] = sum;
                j++;
            }
            i++;
        }
        long calcEndTime = System.currentTimeMillis();
        System.out.println("C - " + C.length + "*" + C[0].length + ": Matrix Computation Time = " + (calcEndTime - calcStartTime) + "ms");
        printProductMatrix(C);

    }

    public static void printProductMatrix(int[][] C) {
        System.out.println("-------C SIZE: " + C.length + " x " + C[0].length + "  -------");
        System.out.print("---------PRODUCT MATRIX: C--------------\n");
        /*for (int i = 0; i < C.length; i++) {
         for (int j = 0; j < C[i].length; j++) {
                
         }
         } */
        for (int[] C1 : C) {
            System.out.print("[");
            for (int p : C1) {
                System.out.print(p + " ");
            }
            System.out.print("]\n");

        }

    }

}
