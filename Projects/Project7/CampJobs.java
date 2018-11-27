import java.io.*;
import java.util.*;

public class CampJobs{

    public static void help() {
        System.out.println("Command List:");
        System.out.println();
        System.out.println("H - Help: print a list of commands");
        System.out.println("E <name> <age> <sex> - Enroll a new camper");
        System.out.println("W <name> - Withdraw a camper");
        System.out.println("D <name> - Display the age and gender of a camper");
        System.out.println("A - Print the average age of the campers");
        System.out.println("L - List all campers names in alphabetical order");
        System.out.println("S - Print the number of boy and girl campers");
        System.out.println("P - List all campers names in preorder");
        System.out.println("Q - Quit");
        System.out.println();
    }

    public static void enroll(BST camp, Scanner file) {
        camp.insert(new Camper(file));
        System.out.println("New camper added.");
    }
    
    public static Camper camperSearch(BST camp, Scanner file){
        String search = file.next();
        Camper camper = new Camper(0, 'A', search);
        
        Camper lookup = (Camper)
        camp.lookup((Comparable) camper);
        
        if (lookup == null){
            System.out.println(lookup+" is not here.");
            return null;
        }
        else
            return lookup;
        
    }
    
    public static void withdraw (BST camp, Camper camper){
        camp.remove((Comparable) camper);
        System.out.println("Camper withdrawn.");
    }
    
    public static void display (Camper camper){
        System.out.println("Name: "+camper.name);
        System.out.println("Age: "+camper.age);
        System.out.println("Gender: "+camper.gender);
    }

    public static void average(BST camp) {
        camp.reset(BST.IN);
        
        double totalAge = 0;
        double count = 0;
        
        while(camp.hasNext()){
            totalAge += (double)getAge((Camper)camp.getNext());
            count++;
        }
        
        if(count > 0){
            double average = (double)totalAge/count;
            System.out.println("The average age is "+average+" years old.");
        }
        else
            System.out.println("Error: No campers.");
    }
    
    public static int getAge(Camper camper){
        return camper.age;
    }
    
    public static void alphabetize(BST camp) {
        camp.reset(BST.IN);
        
        ArrayList<String> alphalist = new ArrayList<String>();
        while (camp.hasNext()){
            alphalist.add(((Camper)(camp.getNext())).name);
        }
        
        Collections.sort(alphalist);
        
        System.out.println("Alphabetical List of Campers:");
        for(int i=0; i<alphalist.size(); i++)
            System.out.println(alphalist.get(i));
    }

    public static void genderCounts(BST camp) {
        int boyCount = 0;
        int girlCount = 0;
        
        camp.reset(BST.IN);
        
        while(camp.hasNext()){
            if((((Camper)(camp.getNext())).gender)=='M' ){
                boyCount++;
            }
            if((((Camper)(camp.getNext())).gender)=='F' ){
                girlCount++;
            }
        }
        
        System.out.println("Camper count:");
        System.out.println("Boys: "+boyCount);
        System.out.println("Girls: "+girlCount);
    }

    public static void preorder(BST camp) {
        camp.reset(BST.PRE);
        
        System.out.println("Preorder Traversal: ");
        while (camp.hasNext()){
            System.out.println(((Camper)(camp.getNext())).name);
        }
            
    }
    
    
}