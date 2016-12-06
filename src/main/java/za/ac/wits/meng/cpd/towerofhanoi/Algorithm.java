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
public class Algorithm {
    
    public void solveTowerOfHanoi(int plateNum, char towerFrom, char towerMiddle, char towerTo) {
        if (plateNum == 1) {
            System.out.println("Plate: " + plateNum + " From: " + towerFrom + " To: " + towerTo);
            return;
        }
        
        solveTowerOfHanoi(plateNum-1, towerFrom, towerTo, towerMiddle);
        System.out.println("Plate: " + plateNum + " From: " + towerFrom + " To: " + towerTo);
        solveTowerOfHanoi(plateNum-1, towerMiddle, towerFrom, towerTo);
        
        
        
    }
    
}
