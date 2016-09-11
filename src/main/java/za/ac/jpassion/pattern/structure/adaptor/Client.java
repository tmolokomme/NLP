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
public class Client {
    
    public static void main(String[] args) {
         INewGreetingAdaptor adaptor = new NewGreetingAdaptor(new OldGreeting());
         adaptor.sayHello("1", "2", "3");
         
        
    }
    
}
