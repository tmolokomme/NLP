/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.wits.meng.dbbigdata.mapreduce;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author F4728548
 */
public class Util {
    public static String SPLIT_OUT_MAP_IN = "SPLIT_MAP\\";
    public static String MAP_OUT_SHUFFLE_IN = "MAP_SUFFLE\\";

    public static String SHUFFLE_OUT_REDUCE_IN = "SHUFFLE_REDUCE\\";
    public static String REDUCE_OUT_RESULT_IN = "REDUCE_RESULT\\";

    public static String SHUFFLE_IN_FOLDER = "";

    public static String ROOT_DIR = "D:\\MAPREDUCE\\";

    public static String B_MATRIX_FOLDERA = "MatrixB\\";
    
     public static File createFile(String outputFilePath) {
        //String filePath = ROOT_DIR + outputFileName + ".txt";
        File file = new File(outputFilePath);

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
    
}
