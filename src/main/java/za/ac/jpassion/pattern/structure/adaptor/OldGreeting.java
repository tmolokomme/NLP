/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.jpassion.pattern.structure.adaptor;

/**
 *
 * @author f4728548
 */
public class OldGreeting implements IOldAdaptee {

    @Override
    public void sayHello(String arg1) {
        System.out.println("Hello: '" + arg1 + "'");
    }
    
}
