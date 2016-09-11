/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.wits.meng.dbbigdata.mapreduce;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author F4728548
 */
public class MapReduceAlgorithm {

   

    public static void main(String[] args) {
        //
        SplittingAlgorithm splitter = new SplittingAlgorithm();
        String inputFileA = "File_100_A.txt";
        //String inputFilePathA = Util.ROOT_DIR + inputFileA;
        splitter.splitFile(inputFileA, 0);
        
        //MAP
        MappingAlgorithm mapping = new MappingAlgorithm();
        int fileNum = 0;
        for (int idx = 0; idx < 10; idx++) {
            mapping.map(idx); //fileNum
        }
        
        
        //Suffle
         ShufflingAlgorithm shuffleAlg = new ShufflingAlgorithm();
        //shuffleAlg.initializeMatrix(fileB, 100);
        //int fileNum  = 0;
        String inputFilename = "0.txt";
        for (int idx = 0; idx < 10; idx++) {
        //String inputFile = U.FILE_DIR + "V_0.txt";
            inputFilename = idx + ".txt";
            shuffleAlg.shuffle(inputFilename, 0);
        }
        //Wait State
        reduceWaiting();
    }
    
    public static void reduceWaiting() {
        try {
            Thread.sleep(1000);
            //Reduce
            ReduceAlgorithm reduceAlg = new ReduceAlgorithm();
            //shuffleAlg.initializeMatrix(fileB, 100);
            //int fileNum  = 0;
            String outputFilename = "FinalResult.txt";
            //String inputFile = SplittingAlgorithm.FILE_DIR + "V_1.txt";
            reduceAlg.reduce(outputFilename, 10);
        } catch (InterruptedException ex) {
            Logger.getLogger(MapReduceAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
