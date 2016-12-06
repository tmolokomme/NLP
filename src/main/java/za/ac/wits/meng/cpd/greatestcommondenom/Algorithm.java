/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.wits.meng.cpd.greatestcommondenom;

/**
 *
 * @author f4728548
 */
public class Algorithm {
    
    public int while_eucledean(int num1, int num2) {
        
        while (num2 != 0) {
            int temp = num2;
            num2 = num1%num2;
            num1 = temp;            
        } 
        
        return num1;
    }
    
    public int eucledean(int num1, int num2) {
        //1. Base case
        if (num2 == 0 ) return num1; 
        
        //2. Recussive call (Tail/Head)
        return eucledean(num2, num1%num2);
        
    }
    
}
