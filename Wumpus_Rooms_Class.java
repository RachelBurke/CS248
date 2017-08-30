package wumpus;

import java.io.*;
import java.util.*;

/** @author Rachel Burke
A Class for the Star Wars Game */

public class Star_Wars_Rooms {
  // data fields
  int planet, adj1, adj2, adj3;
  String planet_description;
  String hazard = "safe";

  /** @param p the name of the current planet
	  @param one the first adjacent planet to the current planet
	  @param two the second adjacent planet to the current planet
	  @param three the third adjacent planet to the current planet
	  @param pd the current room description */
  public Star_Wars_Rooms(int p, int one, int two, int three, String pd) {
    planet=p; adj1=one; adj2=two; adj3=three; planet_description=pd;
  }

  /** @param w Scanner, opened to a text file */
  public Star_Wars_Rooms(Scanner w) {
    planet=w.nextInt();
	adj1=w.nextInt();
	adj2=w.nextInt();
	adj3=w.nextInt();
	planet_description=w.next() + w.nextLine();
  }

  /** @return a string representation of the galaxy */
  public String toString() {
	return planet+": adjacent rooms= "+adj1+" "+adj2+" "+adj3+
	       " Description= "+planet_description;
  }

  /** @return the adjacent planets */
  public String getAdjacent()
    {return adj1+", "+adj2+", and "+adj3+"."; }
  /** @return the planet description */
  public String getDescription()
     {return planet_description; }
  /** @return what hazard is on the planet */
  public String getHazard()
     {return hazard;}
  /** @param hazard the current hazard on the planet
       sets the new hazard*/
    public void setHazard(String hazard) {
        this.hazard = hazard;
    }
}
