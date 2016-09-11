/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.jpassion.solid.encapsulation;

/**
 *
 * @author F4728548
 */
public class SimpleToyFactory {
    
    public Toy createToy(String type) {
        Toy toy;
        switch (type) {
                case "car":
                    toy = new CarToy();
                    break;
                case "train":
                    toy = new TrainToy();
                    break;
                default:
                    toy = null;
        }
        return toy;
    }
    
}
