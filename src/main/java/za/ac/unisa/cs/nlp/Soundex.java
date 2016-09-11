/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.unisa.cs.nlp;

/**
 *
 * @author F4728548
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Soundex {
	 
	  public static final String regexRemovals = "[aehiouwy]";
	  public static final String chars =  "bfpv|cgjkqsxz|dt|l|mn|r";
	  public static final String numRep = "1111|22222222|33|4|55|6";
	  	 
	  public static String soundex(String arg) {
		  
		    String param = arg.toLowerCase();
		 
			  if (param == null || param.length() <= 0)
				  throw new RuntimeException("A valid paramater is required....");
			
			  Pattern pattern = Pattern.compile("[A-Za-z]");
			  StringBuilder soundex = new StringBuilder();
		   
			 soundex.append(arg.charAt(0));
			 
			 int idx = 1;
		    char currentChar; 
		    char previousChar = ' ';
		    char prevNo = '?';
	 
		    // Main loop: find up to 4 chars that map.
		    while (idx < param.length() && soundex.length() < 4) {
		 
		      // Check to see if the given character is alphabetic.
		      // Text is already converted to uppercase. Algorithm
		      // only handles ASCII letters, do NOT use Character.isLetter()!
		      // Also, skip double letters.
		    	
		    	//Matcher matcher = 
		    	currentChar = param.charAt(idx);
				 if (currentChar != ',' && currentChar != ' ' && currentChar != ';' && currentChar != ';') {
					 boolean isValidChar = pattern.matcher(Character.toString(currentChar)).matches();
				    	
				      if (isValidChar && currentChar != previousChar) { //currentChar >='A' && currentChar <='Z'
				    	  previousChar = currentChar;
				      }
				      boolean isRemove = regexRemovals.contains(Character.toString(currentChar));
				        if (idx > 0) {
				        		        	
				          if (!isRemove) { //m != '0'
				        	  int charPos = chars.indexOf(currentChar);
				        	  if (charPos > 0) {
					        	////System.out.println("PSO: " + charPos +  "|||| cchar: " + currentChar + "  || prev: " + previousChar);
						          char m = numRep.charAt(charPos); //MAP[currentChar -'A'];
						          if (m != prevNo) {
						        	  soundex.append(m);
						          }
						          prevNo = m;
				        	  }
				          }
				        }
				 }
				 idx++;
		    }
		    if (soundex.length() == 0)
		      return null;
		    int sdxLen = soundex.length();
		   // System.out.println("soundex.length(): " + soundex.length());
		    for (int cnt = sdxLen; cnt < 4; cnt++) {
		    	soundex.append('0');
		    }
		    return soundex.toString();
	  }
	  
	  
	  public static void main(String[] args) { 
	    
	    //--------------------
	    String inputFileName = "D:\\DevelopmentWork\\Unisa\\2014\\NaturalLanguageProcessing\\soundexInput.txt";
	    if (args != null) {
	    	if (args.length > 0) {
	    		inputFileName = args[0];
		    }
	    }
	    
	    if (inputFileName ==null || "".equals(inputFileName)) {
	    	inputFileName = "soundexInput.txt";
	    }
	    BufferedReader br = null;         
	    String sCurrentLine;         
	    try        {             
	    	br = new BufferedReader(new FileReader(inputFileName));      
	    	while ((sCurrentLine = br.readLine()) != null)             
	    	{                 
	    		System.out.println(soundex(sCurrentLine) + " >> " + sCurrentLine);
	    	}         
	    	         
	    } catch (IOException e)         
	    {             
	    	e.printStackTrace();         
	    }         
	    finally        
	    {             
	    	try           
	    	{                
	    		if (br != null)                 
	    			br.close();             
	    	} catch (IOException ex)      
	    	{                 
	    		ex.printStackTrace();            
	    	}         
	    } 
	  }
	}

