/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.jpassion.pattern.structure.composite;

/**
 *
 * @author f4728548
 */
public abstract class Employee {
    
    private int employeeNo;
    private String name;
    private String role;
    private String department;
    private int salary;

    public Employee(String name, String role, String dept, int salary) {
        employeeNo = new java.util.Random().nextInt(); //*10;
        this.name = name;
        this.role = role;
        this.department = dept;
        this.salary = salary;
    }
    
    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    

    public abstract void printTree();
    
}
