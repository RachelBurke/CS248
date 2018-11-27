import java.io.*;

/**
  Driver class for The Dating Game programming assignment.
  @author Jon Sorenson/Rachel Burke
*/
public class Year3000
{
  public static void main(String [] args) throws IOException
  {
    DateInterface d = new MyDate();
    d.set(1,25,2015,0);  // sets the date to Sunday, January 25th, 2015
    while(d.getYear()<3000)
    {
      d.tomorrow();
      // un-comment the next line to help with debugging
      // System.out.println(d);
    }
    // at this point, d represents January 1, 3000
    System.out.println(d);
	
	d.set(12,31,1799,2);  // sets the date to Tuesday, December 31st, 1799
	while(d.getYear()<1800)
    {
      d.tomorrow();
      // un-comment the next line to help with debugging
      //System.out.println(d);
    }
	// at this point, d represents January 1, 1800
	System.out.println(d);
	   
	d.set(1,25,2015,0);  // sets the date to Sunday, January 25th, 2015
	while(d.getYear()>1799)
    {
      d.yesterday();
      // un-comment the next line to help with debugging
      //System.out.println(d);
    }
	//at this point, d represents December 31,1799
	System.out.println(d);
  }
}