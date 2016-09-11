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
public class Client {

    public static void main(String[] args) {
        Manager CEO = new Manager("Mike", "CEO", "FNB", 5000000);
        Manager headEcon = new Manager("Sizwe", "C Economics", "FNB Premium", 2000000);

        Employee econ1 = new Worker("Babalwa", "Exonomist", "FNB Premium", 800000);
        Employee econ2 = new Worker("Brown", "Exonomist", "FNB Premium", 850000);
        headEcon.add(econ1);
        headEcon.add(econ2);

        Manager headIT = new Manager("Peter", "CIO", "FNB Leanding", 1500000);

        Manager manProjects = new Manager("Phimzile", "Head of Projects", "FNB Leanding", 1500000);
        Employee proj1 = new Worker("Ntsakisi", "PM", "FNB Leanding", 600000);
        Employee proj2 = new Worker("Ntombi", "PA", "FNB Leanding", 350000);
        manProjects.add(proj1);
        manProjects.add(proj2);

        Manager manDev = new Manager("Disema", "Development Manager", "FNB Leanding", 1500000);
        Employee dev1 = new Worker("Allyn", "LN Developer", "FNB Leanding", 900000);
        Employee dev2 = new Worker("Keibone", "Java Developer", "FNB Leanding", 400000);
        manDev.add(proj1);
        manDev.add(proj2);

        Employee advisor = new Worker("Keibone", "Strategic Advisor", "FNB Leanding", 1200000);

        headIT.add(manProjects);
        headIT.add(manDev);
        headIT.add(advisor);

        CEO.add(headEcon);
        CEO.add(headIT);

        CEO.printTree();

    }

}
