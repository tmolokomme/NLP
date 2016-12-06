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
public class Main {
    
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        System.out.println(algorithm.eucledean(30, 100));
        System.out.println(algorithm.while_eucledean(100, 30));
        
    }
    
}
