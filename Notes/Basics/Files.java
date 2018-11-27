import java.io.*;
import java.util.*;

class Files

{
	public static void main (String [] args)
		throws IOException
	{
		Scanner infile;
		infile=new Scanner(
			new FileReader("textfile.txt") );
			
			int x,y;
			x = infile.nextInt();
			y = infile.nextInt();
			System.out.println("Some integers: " +x+ " " +y);
			
			infile.nextLine(); //get past the line with 18
			String line = infile.nextLine();
			char c=infile.next().charAt(0);
			
			System.out.println("The line: " +line);
			System.out.println("First char, last line: " +c);		
	
	//now to write
	
	PrintWriter outfile=new PrintWriter(
		new FileWriter("textfile2.txt"));
		
		outfile.println("We are tired today.");
		outfile.println("It is too warm to think.");
		outfile.close();
		
	}
}