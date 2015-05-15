/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbview;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

/**
 *
 * @author Juan Manuel
 */
public class Configuration {
    public static final ConsoleHandler consoleHandler = new ConsoleHandler();
    
    public Configuration() {
        consoleHandler.setLevel(Level.ALL);
    }
}
