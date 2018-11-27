/*
 * @author Jon Sorenson and the CS248 11am Class
 */

public class Sorts
{
	private static void swap(
	  Comparable [] A, int x, int y)
	{
		Comparable tmp=A[x];
		A[x]=A[y];
		A[y]=tmp;
	}
	
	public static void bubble(Comparable [] A)
	{
		boolean weswapped=true;
		do
		{
			weswapped=false;
		  // one pass
		  for(int i=0; i+1<A.length; i++)
		  {
			  //if(A[i]>A[i+1])
			  if(A[i].compareTo(A[i+1])>0)
				{
					swap(A,i,i+1);
					weswapped=true;
				}
		  }
		}
		while(weswapped);
	}
	
	private static int findmax(Comparable [] A, int len)
	{
		int max=0;
		for(int i=1; i<len; i++)
			if(A[max].compareTo(A[i])<0)
				max=i;
		return max;
	}
	
	public static void selection(Comparable [] A)
	{
		for(int i=A.length; i>0; i--)
		{
			int maxpos=findmax(A,i);
			swap(A,i-1,maxpos);
		}
	}
	
	public static void insertion(Comparable [] A)
	{
		for(int toinsert=1; toinsert<A.length; toinsert++)
		{
			Comparable saved=A[toinsert];
			int i;
			for(i=toinsert-1; i>=0; i--)
			{
				if(A[i].compareTo(saved)>0)
					A[i+1]=A[i];
				else
				{
					A[i+1]=saved;
					break; // exits the loop
				}
			}
			if(i<0) // clean up
			  A[0]=saved;
		}
	}
	
	public static void insertion(
	  Comparable [] A, int offset, int gap)
	{
		for(int toinsert=gap+offset; 
		   toinsert<A.length; toinsert+=gap)
		{
			Comparable saved=A[toinsert];
			int i;
			for(i=toinsert-gap; i>=0; i-=gap)
			{
				if(A[i].compareTo(saved)>0)
					A[i+gap]=A[i];
				else
				{
					A[i+gap]=saved;
					break; // exits the loop
				}
			}
			if(i<0) // clean up
			  A[offset]=saved;
		}
		
		
	}
	
	public static void shell(Comparable [] A)
	{
		int gap=(int)(A.length/2.2);
		while(gap>1)
		{
			for(int offset=0; offset<gap; offset++)
				insertion(A,offset,gap);
			gap=(int)(gap/2.2);
		}
		insertion(A);
	}
	
	// Quicksort functions:
	
/*	private static void print(Object [] A,
	  int start, int stop)
	{
		for(int i=start; i<=stop; i++)
			System.out.print(A[i]+" ");
		System.out.println("");
	}
	*/
	private static int partition(
	  Comparable[] A, int start, int stop)
	{
		Comparable pivot=A[stop];
		int L=start-1;
		for(int R=start-1; R<stop-1; R++)
		{
			if(A[R+1].compareTo(pivot)<0)
			{
				swap(A,L+1,R+1);
				L++;
			}
		}
		swap(A,stop,L+1);
		return L+1;
	}
	
	private static void quickhelp(
	  Comparable [] A, int start, int stop)
	{
		// base cases
		if(stop<=start) return;
		if(stop==start+1) // n==2
		{
			if(A[start].compareTo(A[stop])>0)
				swap(A,start,stop);
			return;
		}
		// recursive case
		int pivotpos=partition(A,start,stop);
		quickhelp(A,start,pivotpos-1);
		quickhelp(A,pivotpos+1,stop);
	}
	
	public static void quick(Comparable [] A)
	{
		quickhelp(A,0,A.length-1);
	}
	
	// mergesort functions
	
	private static void dothemerge(
	  Comparable [] A, int start, int mid, int stop)
	{
		Comparable [] B=new Comparable[stop-start+1];
    int left=start;
		int right=mid+1;
		for(int i=0; i<B.length; i++)
    {
      // pull from the left if left is not
      // empty, and right is empty or bigger
			if(left<=mid && 
			    (right>stop || A[left].compareTo(A[right])<0))
			  B[i]=A[left++];
			else
				B[i]=A[right++];
		}
    for(int i=0; i<B.length; i++)
      A[start+i]=B[i];		
	}	
	
	private static void mhelp(Comparable [] A,
	  int start, int stop)
	{
		// base cases
		if(stop<=start) return;
		if(stop==start+1) // n==2
		{
			if(A[start].compareTo(A[stop])>0)
				swap(A,start,stop);
			return;
		}
		// recursive case
		int mid=(start+stop)/2;
		mhelp(A,start,mid);
		mhelp(A,mid+1,stop);
		dothemerge(A,start,mid,stop);
	}
	
	public static void merge(Comparable [] A)
	{
		mhelp(A,0,A.length-1);
	}
	
	
	
	
	
}
