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
public class Client {
    
   public static void main(String[] args) {
       PaymentMethodAbstraction paymentMethod = null;
       
       //String paymentType = "za.ac.jpassion.solid.ocp.Cash"; //
       String paymentType = "za.ac.jpassion.solid.ocp.CreditCard"; //
       //String paymentType = "za.ac.jpassion.solid.ocp.Paypal"; //
       
       try {
           paymentMethod = (PaymentMethodAbstraction) Class.forName(paymentType).newInstance();
           paymentMethod.pay();
           
       } catch(Exception ex) {
           ex.printStackTrace();
           
       }
       
   
   }
    
}
