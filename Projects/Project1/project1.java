import java.io.*;
import java.util.*;

class project1
{
	//Insult Generator
	static String insultor(String insult){							
		//Generate insult number
		int insult_number;
		insult_number = (int)(1+5*Math.random());
		//Create Insult based on insult number and return the new insult
		if (insult_number == 1)
			return insult = "Hey loser you were wrong!";
		else if (insult_number == 2)
			return insult = "Man that was so off.";	
		else if (insult_number == 3)
			return insult = "Told you you couldn't guess it, loser!";
		else if (insult_number == 4)
			return insult = "Hey, you were like so close... NOT!";
		else
			return insult = "Guess what? YOU WERE W-R-O-N-G, WRONG!";
	}

	public static void main (String [] args)
	{	//Use to keep game going or to end the game	
		int game = 1;
		while (game == 1){
			//Welcome to the game and ask for guess
			System.out.print("Welcome to the Guessing Game! ");
			System.out.print("Pick a number between 1 and 100. I doubt you will guess it! ");
			System.out.print("Enter your guess: ");

			//Generate Random Number
			int number;
			number = (int)(1+100*Math.random());
			
			//Take in Human Guess
			int guess;
			Scanner kbd=new Scanner(System.in);
			guess=kbd.nextInt ();
			
			//Keep game going without displaying welcome
			while (game != 0){
				//Wrong guesses 
				if (number != guess){		
					//Check if number is too low and take in new guess				
					if (number > guess){
						//Preparing for insult generator & creating a string to pass through function
						String insult;
						insult = "Wrong";
						insult = insultor(insult);
						//Printing randomly generated insult and asking for new guess
						System.out.println(insult);
						System.out.print("YoLOW. Guess again. You still won't get it. ");
						System.out.print("Guess: ");
						guess=kbd.nextInt ();
					}	
					//Check if number is too high and take in new guess
					if (number < guess){
						//Preparing for insult generator & creating a string to pass through function
						String insult;
						insult = "Wrong";
						insult = insultor(insult);
						//Printing randomly generated insult and asking for new guess
						System.out.println(insult);
						System.out.print("You're high. Guess again. You still won't get it. ");
						System.out.print("Guess: ");
						guess=kbd.nextInt ();
					}	
				}
				//Congratulations and ask to continue playing
				if (number == guess){
					System.out.print("Amazing, you are correct! You are a mind reader! ");
					System.out.print("Care to try again? Enter 1 for yes and 0 for no. ");
					game=kbd.nextInt ();
				
					//Say bye and end game
					if (game == 0){
						System.out.print("Goodbye! ");
					}
					//Continue game, create new random number and take in new guess
					if (game == 1){
						number = (int)(1+100*Math.random());
						System.out.print("Great! I am sure you will not guess this time, though. Guess: ");
						guess=kbd.nextInt ();
					}
				}
			}
		}
	}
}
 