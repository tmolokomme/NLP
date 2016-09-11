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
public class NewGreetingAdaptor implements INewGreetingAdaptor {

    private IOldAdaptee adaptee;
    
    
    public NewGreetingAdaptor(IOldAdaptee adaptee) {
        this.adaptee = adaptee;
    }
    
    
    @Override
    public void sayHello(String arg1, String arg2, String arg3) {
        //System.out.println("");
        adaptee.sayHello(arg1);
    }
    
}
