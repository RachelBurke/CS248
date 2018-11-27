import java.io.*;
import java.util.*;

class FishMain2
{
	public static Comparable max(Comparable [] list)
	{
      Comparable maxsofar = list[0];
	  for (int i = 1; i<list.length; i++)
	  {
		  if (list[i].comparableTo(maxsofar)>0)
			  maxsofar=list[i];
	  }
	  return maxsofar;
	}
	
  public static void main(String [] args)
    throws IOException
  {
    Scanner file=new Scanner(
	  new FileReader("fishfile.txt"));
	int n;
	n=file.nextInt();
	
	fish [] school;
	school=new fish[n];
	
	for(int i=0; i<school.length; i++)
	{
	  school[i]=new fish(file);
	}
	
	System.out.println(max(school));
	
	for(int i=0; i<school.length; i++)
	  System.out.println(school[i]);
  
    school[(int)(school.length*Math.random())]
	  .sharkAttack();
	  
	for(int i=0; i<school.length; i++)
	  System.out.println(school[i]);
	
	System.out.println("Count="+fish.count);
  }
}