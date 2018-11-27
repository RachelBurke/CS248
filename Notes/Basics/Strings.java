import java.io.*;
import java.util.*;

class Strings
{
	static void afunction(String x){
		if (x.compareTo("Royalty")<0){
			System.out.println("Peasant.");
		}
		else{
			System.out.println("'s up."); // /" leaves quotes in string
		}
	}
	
	 public static void main (String [] args){
        System.out.println("What is your name?");
		
		Scanner cin=new Scanner(System.in);
		String name;
		name = cin.next();
		
		afunction(name);
	}
}