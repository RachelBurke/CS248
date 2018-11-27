
import java.io.*;
import java.util.*;


public class CampMain
{
    public static void main (String [] args) 
        throws FileNotFoundException{
             //Creating Binary Search Tree
            BST camp = new BST();
            System.out.println("Welcome to Camp Posanivee!");
            readIn(camp);
            System.out.println();
            System.out.println("Command: Q");
            System.out.println("End of Program,");
            System.out.println("Bring plenty of calomine!");
	}
    
    public static void readIn(BST camp) 
        throws FileNotFoundException{
            Scanner file = new Scanner(new FileReader("camp.txt"));
            char command;
            Camper camper = new Camper();
        
           command = file.next().charAt(0);
           while (command != 'Q'){
               System.out.println();
                switch (command) {
                    case 'H':
                        System.out.println("Command: H");
                        CampJobs.help();
                        break;
                    case 'E':
                        System.out.println("Command: E");
                        CampJobs.enroll(camp, file);
                        break;
                    case 'W':
                        System.out.println("Command: W");
                        camper = CampJobs.camperSearch(camp, file);
                        CampJobs.withdraw(camp, camper);
                        break;
                    case 'D':
                        System.out.println("Command: D");
                        camper = CampJobs.camperSearch(camp, file);
                        CampJobs.display(camper);
                        break;
                    case 'A':
                        System.out.println("Command: A");
                        CampJobs.average(camp);
                        break;
                    case 'L':
                        System.out.println("Command: L");
                        CampJobs.alphabetize(camp);
                        break;
                    case 'S':
                        System.out.println("Command: S");
                        CampJobs.genderCounts(camp);
                        break;
                    case 'P':
                        System.out.println("Command: P");
                        CampJobs.preorder(camp);
                        break;
                    default:
                        break;
                }
               
               command = file.next().charAt(0);
            }
        }
}