/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.jpassion.solid.ocp;

/**
 *
 * @author f4728548
 */
public class Paypal extends PaymentMethodAbstraction {

    public Paypal() {
        this.setPaymentScheme("Paypal");
    }
    
    @Override
    public void pay() {
        System.out.println("Paying through PAYPAL...");
    }
}
