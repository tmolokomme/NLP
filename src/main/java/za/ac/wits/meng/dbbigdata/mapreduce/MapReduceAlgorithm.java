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
public class MapReduceAlgorithm {

    //private static SplittingAlgorithm splitter = new SplittingAlgorithm();
    private int _100Matrix = 100;
    private String _100FileA = "File_100_A.txt";
    private String _100FileB = "File_100_B.txt";
    private int _1000Matrix = 1000;
    private String _1000FileA = "File_1000_A.txt";
    private String _1000FileB = "File_1000_B.txt";
    private int _2000Matrix = 2000;
    private String _2000FileA = "File_2000_A.txt";
    private String _2000FileB = "File_2000_B.txt";
    private String _finalOutputFileName;
    private String _finalFileSufix = "_MatrixC.txt";
    
    private int _defaultSize ;
    private String _defaultFileA ;
    private String _defaultFileB;
    
    private void init() {
        
        int which = 2;
         switch (which) {
            case 1:
                _defaultSize = _100Matrix;
                _defaultFileA = _100FileA;
                _defaultFileB = _100FileB;
                
                break;
            case 2:
                 _defaultSize = _1000Matrix;
                _defaultFileA = _1000FileA;
                _defaultFileB = _1000FileB; 
                break;
            default:
                 _defaultSize = _2000Matrix;
                _defaultFileA = _2000FileA;
                _defaultFileB = _2000FileB; 
                break;   
        }
         _finalOutputFileName = _defaultSize +_finalFileSufix;
    
    }
    
    public void execute() {
        init();
        long calcStartTime = System.currentTimeMillis();
         //Split
        SplittingAlgorithm splitter = new SplittingAlgorithm();
        //String matrixBFileName = "File_100_B.txt";
        splitter.splitFile(_defaultFileA);
        
        //MAP
        for (int idx = 0; idx < _defaultSize; idx++) {
            new MappingAlgorithm(idx, _defaultFileB, _defaultSize).start();
            //mapping.map(); //fileNum
        }
        
        //SHUFFLE
//         ShufflingAlgorithm shuffleAlg = new ShufflingAlgorithm();
        String inputFilename;
        for (int idx = 0; idx < _defaultSize; idx++) {
        //String inputFile = U.FILE_DIR + "V_0.txt";
            inputFilename = idx + ".txt";
            new Thread(new ShufflingAlgorithm(inputFilename, idx)).start();
            //new ShufflingAlgorithm(inputFilename, idx).run();
//            shuffleAlg.shuffle(inputFilename, 0);
        }
        //Wait State
        //reduceWaiting();
        boolean allThreadsDone = false;
        String REDUCE_IN = Util.ROOT_DIR + Util.SHUFFLE_OUT_REDUCE_IN;
        while (!allThreadsDone) {
            //Read folder
            int allFiles = new File(REDUCE_IN).listFiles().length;
            if (allFiles == _defaultSize) {
                System.out.println("Main- REDUCE step - all '" + allFiles + "'files retrived: " + REDUCE_IN);
                allThreadsDone = true;
            } else {
                try {
                    System.out.println("Main- REDUCE step -: " + allFiles + " waiting all files in: " + REDUCE_IN);
                    Thread.sleep(1000);

                } catch (InterruptedException ex) {
                    Logger.getLogger(MapReduceAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        ReduceAlgorithm reduceAlg = new ReduceAlgorithm();
        reduceAlg.reduce(_finalOutputFileName, _defaultSize);
        long calcEndTime = System.currentTimeMillis();
        System.out.println("-----------------------------------");
        System.out.println("-------------RESULTS---------------");
        System.out.println("");
        System.out.println("C - " + _defaultSize + "*" + _defaultSize + ": Matrix Computation Time = " + (calcEndTime - calcStartTime) + "ms");
        System.out.println("-----------------------------------");
    }
    
   
    public static void main(String[] args) {
        new MapReduceAlgorithm().execute();
        
    }
    
    
    
    
}
