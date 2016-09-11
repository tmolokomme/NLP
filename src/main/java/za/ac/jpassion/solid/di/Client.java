/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.jpassion.solid.di;

/**
 *
 * @author F4728548
 */
public class Client {
    public static void main(String[] args) {
        DrawShape ds = new DrawShape(new Circle());
        
        ds.drawShape();
    }
    
}
