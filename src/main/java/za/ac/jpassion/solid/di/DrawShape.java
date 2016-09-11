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
public class DrawShape {
    IShape shape;
    
    public DrawShape(IShape shape) {
        this.shape = shape;
    }
    
    public void drawShape() {
        this.shape.draw();
    }
   
}
