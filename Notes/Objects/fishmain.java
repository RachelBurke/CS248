import java.io.*;

class fishmain
{
  public static void main(String [] args)
  {
    fish f,f2;
	f=new fish("Polly","Parrotfish","rainbow",6);
	System.out.println(f);
	
	f2=new fish("Ellie","Elasmosaur",
	  "blue",4);
	System.out.println(f2);
	
	System.out.println("Total fins="+
	  (f.getFins()+f2.getFins()));
	  
	f2.sharkAttack();
	System.out.println("Poor "+f2.getName()+"!");
	System.out.println(f2);
	
	System.out.println("Count="+fish.count);
  }
}