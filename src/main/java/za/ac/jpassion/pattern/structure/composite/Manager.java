/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.jpassion.pattern.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author f4728548
 */
public class Manager extends Employee {

    List<Employee> subordinates;
    
    
    public Manager(String name, String role, String dept, int salary) {
        super(name, role, dept, salary);
        subordinates = new ArrayList<>();
    }
    
    @Override
    public void printTree() {
        System.out.println(getName() + " " + getRole() + " " + getDepartment());
        getSubordinates().forEach(
                subordinate -> {
                    //System.out.print("\t");
                    subordinate.printTree();
                }
            );
    }
    
    public void add(Employee employee) {
        subordinates.add(employee);
    }
    
    public void remove(Employee employee) {
        subordinates.remove(employee);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }
    
    public void replace(Employee current, Employee replacement) {
        //this.subordinates.
    }
    
    
    
    
}
