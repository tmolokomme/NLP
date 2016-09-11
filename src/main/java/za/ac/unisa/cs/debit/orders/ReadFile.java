/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.unisa.cs.debit.orders;

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
public class ReadFile {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new FileReader("F:\\FMM243SPL_FMM243SPL_2016-04-30-04.09.52.807000.txt")))
		{
                    
                    //
                    File file = new File("F:\\111122AlmostFMM243SPL.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
                    
                    ///
                        int count = 1;
			String sCurrentLine;
                        //string startsWith = "[]{9}";
                        
                        //startsWith = "      2"
                        String prevLine = "";
                        boolean isFirst = false;
			while ((sCurrentLine = br.readLine()) != null) {  //&& count < 10
                                boolean isSecond = false;
                                if (count == 260) {
                                    System.out.print("");
                                }
                                isSecond = sCurrentLine.startsWith("         "); //Second line
                                String endTrans;
                                if (sCurrentLine.length() > 9) {
                                    endTrans = sCurrentLine.trim();
                                    if (isSecond) {
                                        isSecond = endTrans.matches("^(\\d+)(.*)");
                                    }
                                } else {
                                    isSecond = false;
                                }
                                
                                isFirst = prevLine.startsWith("         ");
                                //System.out.println("-----LINE---"  + count);
                                if (isSecond) { //&& isFirst
                                    //String toPrint = prevLine.re(" ", "\t");
                                    bw.write(sCurrentLine + prevLine + ";");
                                    bw.newLine();
                                    bw.flush();
                                    System.out.println(prevLine + ";" + sCurrentLine);
                                    isFirst = false;              
                                } else {
                                    String ragex1 = "^(\\s+)(\\d+)(.*)";
                                    String ragex = "^\\s{3,}\\d{3,}\\.";
                                    isFirst = sCurrentLine.matches(ragex1);
                                    if (isFirst) {
                                    } else {
//                                        bw.write(sCurrentLine);
//                                        bw.newLine();
//                                        bw.flush();
                                        System.out.println(sCurrentLine);
                                    }
                                }

                                //System.out.println("========END---"  + count);
                                count++;
                                prevLine = sCurrentLine;
                                /*if () {
                                } */
                                
			}
                        bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
}
