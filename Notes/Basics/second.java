import java.io.*;
import java.util.*;
class second

// Comments are like this
/* multi
   line
   comments!
 */
 
 {
	 public static void main (String [] args)
	 {
		 int x;
		 double y;
		 char c;
		 
		 int age;
		 Scanner kbd=new Scanner(System.in);
		 
		 System.out.print("How old are you? ");
		 age=kbd.nextInt ();
		 
		 if (age<=30)
			 System.out.println("You are young!");
		 else
			 System.out.println("You are old!");
		 for(int level=1; level<=330; level++)
		 {
			 System.out.println(
			 "You reached level " +level+
			 "on Candy Crush!  Awesome!");
		 }
	 }
 }