import java.util.*;

public class Camper{
    int age;
    char gender;
    String name;
    
    public Camper(){
        age = 0;
        gender = 'A';
        name = "";
    }
    
    public Camper(int Age, char Gender, String Name){
        age = Age;
        gender = Gender;
        name = Name;
    }
    
    public Camper(Scanner file){
        name = file.next();
        age = file.nextInt();
        gender = file.next().charAt(0);
    }
  
    public int compareTo(Object camper){
        if (camper instanceof Camper){
            Camper camperCamper = (Camper)camper;
            return this.name.compareTo(camperCamper.name);
        }
        else
            System.out.println("Error: Not a Camper.");
        
        return 0;
    }
    
    public int getAge(){
        return age;
    }
    
    public char getGender(){
        return gender;
    }
    
    public String getName(){
        return name;
    }
    
    public String toString(){
        return ("Name: "+name+" Age: "+age+" Gender: "+gender);
    }
}

