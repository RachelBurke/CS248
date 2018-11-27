import java.io.*;
import java.util.*;

class rot13
{
	static char add13(char y)
	{
		if('a' <= y && y <= 'z') {
			if (y+13 > 'z')
				return (char)(y-13); //Cast
			
			else
				return (char) (y+13);
		}
		else if ('A' <= y && y <= 'Z'){
			if (y+13 > 'Z')
				return (char) (y-13);
			else
				return (char) (y+13);
		}
		else
			return y;
	}

	static String encrypt(String x)
	{
		//System.out.println(""+add13('H')+add13('i'));
		String  ciphertext="";
		for(int i = 0; i<x.length(); i++){
			ciphertext += add13(x.charAt(i));
		}
		
		return ciphertext; //"Hi";
	}


	 public static void main (String [] args)
	 {
		Scanner cin=new Scanner(System.in);
		
		String mess;
		System.out.print("What's your message? ");
		mess = cin.nextLine();
		
		mess = encrypt(mess);
		
		System.out.println(mess);
	 }
}