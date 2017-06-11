/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.text.iolib.poc;
import java.time.Month;
import org.beryx.textio.*;
/**
 *
 * @author f4728548
 */
public class ReadMe {
    //https://github.com/beryx/text-io

    public static void main(String[] args) {
        TextIO textIO = TextIoFactory.getTextIO();

        String user = textIO.newStringInputReader()
                .withDefaultValue("admin")
                .read("Username");

        String password = textIO.newStringInputReader()
                .withMinLength(6)
                .withInputMasking(true)
                .read("Password");

        int age = textIO.newIntInputReader()
                .withMinVal(13)
                .read("Age");

        Month month = textIO.newEnumInputReader(Month.class)
                .read("What month were you born in?");

        TextTerminal terminal = textIO.getTextTerminal();
        terminal.printf("\nUser %s is %d years old, was born in %s and has the password %s.\n",
                user, age, month, password);
    
    }

}
