/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.wits.meng.cpd.towerofhanoi;

/**
 *
 * @author f4728548
 */
public class Main {
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        algorithm.solveTowerOfHanoi(3, 'A', 'B', 'C');
    }
    
}
