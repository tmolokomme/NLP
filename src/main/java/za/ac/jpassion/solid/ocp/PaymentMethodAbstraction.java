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
public abstract class PaymentMethodAbstraction {
    
    String paymentScheme;

    public String getPaymentScheme() {
        return paymentScheme;
    }

    public void setPaymentScheme(String paymentScheme) {
        this.paymentScheme = paymentScheme;
    }
    
    
    public abstract void pay() ;
    
    
}
