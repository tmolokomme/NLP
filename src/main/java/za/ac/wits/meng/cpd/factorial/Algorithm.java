/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.wits.meng.cpd.factorial;

/**
 *
 * @author f4728548
 */
public class Algorithm {
    
    public int calc_factorial(int num ) {
        //1. base case
        if (num == 1) return 1; 
        
        //2. recursion
        return num * calc_factorial(num-1);
    }
    
}
