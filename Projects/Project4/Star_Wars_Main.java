import java.io.*;
import java.util.*;

/**
 * A Class for the Star Wars Game Main
 * @author Rachel Burke
 */
public class Star_Wars_Main {

/**
 * @param args
 * @throws IOException 
 */
    public static void main(String[] args)
            throws IOException {
        /*
	Creating Star Wars Galaxy Layout
	Scans in the text file, 1st line is number of rooms
	Following lines are put into an array of size rooms
	Strings in the array -> Room Class
         */
        Scanner file = new Scanner(
                new FileReader("StarWarsText.txt"));
        int planets;
        planets = file.nextInt();

        Star_Wars_Rooms[] galaxy;
        galaxy = new Star_Wars_Rooms[planets];

        for (int i = 0; i < galaxy.length; i++) {
            galaxy[i] = new Star_Wars_Rooms(file);
        }
        //Placing Hazards in rooms
        int hazards_placed = 0;
        while (hazards_placed < 1) {
            int x = (int) (Math.random() * (planets - 1) + 1);

            if (galaxy[x].getHazard().equals("safe")) {
                galaxy[x].setHazard("death star target");
                hazards_placed++;
            }
        }

        while (hazards_placed < 2) {
            int x = (int) (Math.random() * (planets - 1) + 1);

            if (galaxy[x].getHazard().equals("safe")) {
                galaxy[x].setHazard("stormtroopers");
                hazards_placed++;
            }
        }

        while (hazards_placed < 3) {
            int x = (int) (Math.random() * (planets - 1) + 1);

            if (galaxy[x].getHazard().equals("safe")) {
                galaxy[x].setHazard("jabba");
                hazards_placed++;
            }
        }
        while (hazards_placed < 4) {
            int x = (int) (Math.random() * (planets - 1) + 1);

            if (galaxy[x].getHazard().equals("safe")) {
                galaxy[x].setHazard("shot refill");
                hazards_placed++;
            }
        }
        while (hazards_placed < 5) {
            int x = (int) (Math.random() * (planets - 1) + 1);

            if (galaxy[x].getHazard().equals("safe")) {
                galaxy[x].setHazard("transportation");
                hazards_placed++;
            }
        }

        //Uncomment to see out the galaxy layout
        //for(int i=0; i<galaxy.length; i++)
        //	System.out.println(galaxy[i]);
        
        //Beginning game
        System.out.println("Welcome to the Star Wars Mash-Up!");
        System.out.println("Thank you for agreeing to fight against the evil Jabba the Hutt."); // Jabba is the wumpus
        System.out.println("The galaxy has had enough of him and has decided it is time for Jabba to go.");
        System.out.println("Your job is to search the galaxy for Jabba, but BEWARE of the obstacles in your path:");
        System.out.println("The Death Star has been planning to destroy one of the planets."); //obstacle 1 - i.e. spiders
        System.out.println("There are stormtroopers patrolling one of the planets."); // obstacle 2 - i.e. pitfall
        System.out.println("You have been banned from one of the planets in the galaxy and the technology in your");
        System.out.println("spacecraft will transport you do a different planet if you try to enter the area."); // obstacle 3 - bats
        System.out.println("Your blaster is not up to the times and can only hold 3 shots."); // arrows -> blaster
        System.out.println("To refill you must travel to your base planet."); // refill room -> base planet
        System.out.println("The technology in your spacecraft only detects the three closest planets.");// explain why you can only go to three planets
        System.out.println("Sucks to have so many things against you, but maybe you can still kill Jabba.");
        System.out.println("Good Luck!");
        System.out.println("");

        //Player will be 1 when alive and 0 when dead
        int player = 1;

        //Scanner for player moves
        Scanner playerMove = new Scanner(System.in);
        String action;
        int planet;
        int blaster_shots = 3;
        int current_planet = 0;

        //Continues game while player is alive
        while (player == 1) {
            System.out.println();
            System.out.println("You are on planet " + getCurrent(current_planet) + ".");
            System.out.println("You have " + blaster_shots + " shots left.");
            System.out.println(galaxy[current_planet].getDescription());
            System.out.println("You can travel to the planets " + galaxy[current_planet].getAdjacent());
            getClues(galaxy, current_planet);
            action = nextAction(playerMove);
            planet = getPlanet(galaxy, playerMove, current_planet);

            if (action.equals("M") || action.equals("m")) {
                current_planet = (planet - 1);
                if (galaxy[current_planet].getHazard().equals("transportation")){
                    System.out.println("Oh no! You tried to travel to the planet you're banned from!");
                    current_planet = (int)(Math.random() * (planets - 1) + 1);
                    System.out.println("You are now travelling to planet "+(current_planet + 1)+".");
                }
                if (galaxy[current_planet].getHazard().equals("death star target")) {
                    System.out.println("The Death Star targeted the planet you were on and you died.");
                    player--;
                }
                if (galaxy[current_planet].getHazard().equals("stormtroopers")) {
                    System.out.println("Stormtroopers shot and killed you.");
                    player--;
                }
                if (galaxy[current_planet].getHazard().equals("jabba")) {
                    System.out.println("Oh no! You walked into Jabba's lair and he sent you into the Great Pit of Carkoon.");
                    System.out.println("and were killed by the sarlacc.");
                    player--;
                }
                if (galaxy[current_planet].getHazard().equals("shot refill")) {
                    blaster_shots = 3;
                    System.out.println("You went to base to get your blaster refilled. You now have " + blaster_shots + " shots.");
                }
            } 
            else if (action.equals("S") || action.equals("s")) {
                if (blaster_shots != 0) {
                    blaster_shots--;

                    if (galaxy[planet - 1].getHazard().equals("jabba")) {
                        System.out.println("You killed Jabba! Hurray!");
                        player--;
                    } else {
                        System.out.println("Your shot missed.");
                    }
                }
            }
        }
    }

    /**
     * @param planet takes in array position
     * @return the current room
     */
    public static int getCurrent(int planet) {
        return planet + 1;
    }

    /**
     * @param galaxy galaxy array made from Star_Wars_Rooms
     * @param playerMove the scanner
     * @param current_planet the current planet
     * @return planet returns the planet
     */
    private static int getPlanet(Star_Wars_Rooms[] galaxy, Scanner playerMove, int current_planet) {
        System.out.println("Which planet?");
        int planet = playerMove.nextInt();

        while (planet != galaxy[current_planet].adj1 && planet != galaxy[current_planet].adj2 && planet != galaxy[current_planet].adj3) {
            System.out.println("Your spacecraft cannot detect that planet. Which planet?");
            planet = playerMove.nextInt();
        }
        
        return planet;
    }
    
    /**
     * @param playerMove the scanner
     * @return action the player wishes to make
     */
    private static String nextAction(Scanner playerMove) {
        System.out.println("(M)ove or (S)hoot?");
        String action = playerMove.next();

        while (!(action.equals("M") || action.equals("m") || action.equals("S") || action.equals("s"))) {
            System.out.println("That is not an action option. (M)ove or (S)hoot?");
            action = playerMove.next();
        }
        return action;
    }
    
    /**
     * @param galaxy the galaxy array made by Star_Wars_Room
     * @param current_planet the current planet
     */
    private static void getClues(Star_Wars_Rooms[] galaxy, int current_planet) {
        if (galaxy[galaxy[current_planet].adj1 - 1].getHazard().equals("death star target")
                || galaxy[galaxy[current_planet].adj2 - 1].getHazard().equals("death star target")
                || galaxy[galaxy[current_planet].adj3 - 1].getHazard().equals("death star target")) {
            System.out.println("You saw some enemy spacecraft in the area on your way to planet " + (current_planet + 1) + ".");
        }
        if (galaxy[galaxy[current_planet].adj1 - 1].getHazard().equals("stormtroopers")
                || galaxy[galaxy[current_planet].adj2 - 1].getHazard().equals("stormtroopers")
                || galaxy[galaxy[current_planet].adj3 - 1].getHazard().equals("stormtroopers")) {
            System.out.println("You hear footsteps nearby.");
        }
        if (galaxy[galaxy[current_planet].adj1 - 1].getHazard().equals("jabba")
                || galaxy[galaxy[current_planet].adj2 - 1].getHazard().equals("jabba")
                || galaxy[galaxy[current_planet].adj3 - 1].getHazard().equals("jabba")) {
            System.out.println("You smell something nasty.  Jabba must be near here! ");
        }
    }
}
