import java.util.*;

/**
@author Jon and the 11am CS248 class
A class for representing fish
*/

public class fish implements Comparable
{
  // data fields
  String name;
  String species;
  String color;
  int fins;
  
  public static int count=0;
	
  // the constructor
  
  /**
  @param n the name of the fish
  @param s the species
  @param c the color 
  @param f the number of fins (>=0)
  */
  public fish(String n, String s, 
    String c, int f)
  {
    name=n; species=s; color=c; fins=f;
	count++;
  }
  
  /**
  @param f Scanner, opened to a text file
  */
  public fish(Scanner f)
  {
    name=f.next();
	species=f.next();
	color=f.next();
	fins=f.nextInt();
	count++;
  }
  
  // observers
  /**
  @return a string representation of the fish
  */
  public String toString()
  {
	return name+": species="+species+
	  " color="+color+" #fins="+fins;
  }
  /** @return the name of the fish */
  public String getName()
  { return name; }
  /** @return the species of the fish */
  public String getSpecies()
  { return species; }
  /** @return the color of the fish */
  public String getColor()
  { return color; }
  /** @return the no. of fins of the fish */
  public int getFins()
  { return fins; }
  
  // mutator!
  /** attacks the fish by removing a fin */
  public void sharkAttack()
  {
    if(fins>0)
	  fins--;
  }
  
  public int comparableTo(Object x)
  {
	if (x instanceof fish){
	 fish f=(fish)x;
	 if(fins<f.getFins()) return -1;
	 if(fins==f.getFins()) return 0;
	 return 1;
	}
	else {
	System.out.println("Error: not a fish!");
	return 0;	
	}
  }
  
  
  
}