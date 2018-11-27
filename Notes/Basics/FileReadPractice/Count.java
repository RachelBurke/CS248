import java.io.*;
import java.util.*;

class Count
{
  static int [] countLine(String line)
  {
    int [] counts=new int[26];
	for(int j=0; j<26; j++) counts[j]=0;
	
	for(int i=0; i<line.length(); i++)
	{
	  char c=line.charAt(i);
	  if(c>='a' && c<='z')
		counts[c-'a']++;
	  if(c>='A' && c<='Z')
	    counts[c-'A']++;
	}
	
	return counts;
  }
  
  public static void main(String [] args)
    throws IOException
  {
    String filename="count.txt";
	Scanner infile=new Scanner(
	  new FileReader(filename));
	  
	String line=infile.nextLine();
	
	int [] counts=countLine(line);
	
	for(int i=0; i<26; i++)
	{
	  System.out.println(
	    (char)('A'+i)  + " : " +counts[i]
	  );
	}
  }
}