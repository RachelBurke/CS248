/* Rachel Burke
   CS248 - Object Oriented Programming and Data Structures
   Project Prompt: You are to write a program to compute statistics on a list of exam scores, the Exam Statistics Program (ESP). 
   The input is the name of a text file that contains the number of scores followed by the list of scores. 
   You should then display the following information: 
           - The number of scores 
           - The minimum, maximum, and average scores 
           - The number of As, Bs, Cs, Ds, and Fs, using a 90-80-70-60 scale. 
   For 2 points of extra credit, compute the median score in addition to what the program already does. 
   To compute the median, sort the scores, and the score in the middle is the median. 
   If there are an even number of scores, average the two scores in the middle to obtain the median. 
   So, in the sample score list above, the median would be 83.0. 
*/
//Beginning Program:
import java.io.*;
import java.util.*;

class project2

{   //Defining Functions:
	//Fucntion to find minimum score
	static int minimum (int [] A, int score_total){
		//Setting the first score as the current min
		int min = A[0];
		//Searching hte rest of the array for a lower score
		//Change teh current min if a lower score is found
		for (int i = 1; i < score_total; i++) {
			if (min > A[i])
				min = A[i];
		}
		//Returning min
		return min;
	}
	
	//Function to find maximum score
	static	int maximum (int [] A, int score_total){
		//Setting first score as the current max
		int max = A[0];
		//Searching the rest of the array for a higher score
		// Change the current max if a higher score is found
		for (int i = 1; i < score_total; i++) {
			if (max < A[i])
				max = A[i];
		}
		//Returning max
		return max;
	}
	
	//Function to find the median score
	static double median (int [] A, int score_total){
		//Organizing the scores from least to greatest
		//Temp is a variable to temporarily score the current highest score
		int temp;
		for (int x = 0; x < (score_total-1); x++){
			for (int y = x+1; y < score_total; y++) {
				if (A[x] > A[y]) {
					//swap the variables correctly
					temp = A[x];
					A[x] = A[y];
					A[y] = temp;
				}
			}
		}
		if (score_total%2== 0){//There is not a exact middle score
			//Take the two ''middle'' scores and find average - middle score
			int score_1 = (score_total/2)-1;
			int score_2 = score_total/2;
			int med = (A[score_1]+A[score_2])/2;
			//Return median
			return med;
		}
		else { //There really is a middle score 
			//Dividing odd number would give number 1 less than middle number
			int score = (score_total/2)+1;
			//Picking the middle score
			int med = A[score];
			//Return median
			return med;
		}
	}
	
	//Function to find the average
	static double average(int [] A, int score_total) {
		double avg = 0;
		for (int i = 0; i < score_total; i++) {
			//Add up all scores in the array
			avg += A[i];
		}
		// Calculate average
		avg /= score_total;
		//Return average
		return avg;
	}
	
	//Main Program:
	public static void main(String [] args)
    throws IOException
  {
	//Welcoming into Program
	System.out.println("Welcome to the Exam Statistics Program! ");
	System.out.println(" ");
	System.out.print("Please enter the name of your data file: ");
	
	//Taking in file name
	Scanner cin=new Scanner(System.in);
	String name;
	name = cin.next();
	
	//Will use to take in file information
	Scanner infile;
		infile=new Scanner(
			new FileReader(name) );
			
	//Finding the Number of Scores - first number in the text file
	int score_total;
	score_total=infile.nextInt();
	
	//Creating an Array for the Scores
	int [] A;
	A=new int [score_total];
	//Inputing the Scores into the Array
	for (int i=0; i< score_total; i++){
		A[i] = infile.nextInt();
	}
	
	//Calling min, max, median, and average functions 
	//and setting the corresponding integer equal to the returned value
	int min = minimum(A, score_total);
	int max = maximum(A, score_total);
	double med = median(A, score_total);
	double avg = average(A, score_total);
	
	//Dividing Scores into Letter Grade Categories
	//Setting number of scores in specific category to 0 because no scores have been sorted into them yet
	int a=0;
	int b=0;
	int c=0;
	int d=0;
	int f=0;
	//Categorizing scores into letter grades, adding one to the category if it belongs there
	for (int i=0; i<score_total; i++){
		if (A[i] >= 90)
			a++;
		else if (A[i] >= 80)
			b++;
		else if (A[i] >= 70)
			c++;
		else if (A[i] >= 60)
			d++;
		else
			f++;
	}
	
	//Print Out Program Information
	System.out.println("Minimum score: " +min);
	System.out.println("Maximum score: " +max);
	System.out.println("Median score: " +med);
	System.out.println("Average score: " +avg);
	System.out.println(" ");
	System.out.println("Number of scores by letter grade: ");
	System.out.println("A: "+a);
	System.out.println("B: "+b);
	System.out.println("C: "+c);
	System.out.println("D: "+d);
	System.out.println("F: "+f);
	System.out.println("There are " +score_total+ " scores. ");
  }
}