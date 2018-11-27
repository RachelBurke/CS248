import java.io.*;
import java.util.*;

class Arrays
{
	static void printarray(int [] x)
	{
		for (int i = 0; i<x.length; i++){
			System.out.print(x[i]+" ");
		}
		System.out.println(" ");
	}
	
	public static void main (String [] args)
	{
	if (args.length>0)
		System.out.println(args[0]);
	
	int [] A;
	A=new int [5];
	A[0] = 1; A[1]=1; A[2]=2; A[3]=3; A[4]=4;
	
	/*
	int [] A = {1,2,3,4,5}; lines 19-21
	*/
	
	printarray(A);
	
	//strange stuff
	int [] B;
	B=A;
	
	printarray(B);
	B[0] = 25;
	printarray(A);
	printarray(B);
	}
}