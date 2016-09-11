/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.jpassion.pattern.structure.composite;

import java.util.ArrayList;

/**
 *
 * @author f4728548
 */
public class Worker extends Employee {
    
    public Worker(String name, String role, String dept, int salary) {
        super(name, role, dept, salary);
    }

    @Override
    public void printTree() {
        System.out.println("\t" + super.getName());
    }
    
    
    
}
