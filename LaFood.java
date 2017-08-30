package lafood;

/**
 * LaFood Main Program
 * @author Rachel Burke
 */

import java.io.*;

public class LaFood {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) 
            throws IOException 
    {
        //Opens Simulator for LaFood Main Program
        //Begins Simulation
        Simulator simulation = new Simulator();
        simulation.start();
        
    }
}
