# Projects

This folder contains all project files. Below are the project descriptions given by the professor.

## Project 1 - The Guessing Game
For this assignment, you are to write a program that plays the Guessing Game. Your program should first pick a random number between 1 and 100. Then the user guesses the number. Your program should say whether the guess is too high, too low, or correct. If the guess was correct, the program stops. Otherwise, the user gets to guess again.</br>
Your program must include at least one function/method to receive full credit.

## Project 2 - Exam Statistics Program
You are to write a program to compute statistics on a list of exam scores, the Exam Statistics Program (ESP). The input is the name of a text file that contains the number of scores followed by the list of scores. (See the example below.) You should then display the following information:
1. The number of scores
1. The minimum, maximum, and average scores
1. The number of As, Bs, Cs, Ds, and Fs, using a 90-80-70-60 scale.
For full credit, you must use at least one function/method, and you must use an array to store the list of exam scores.

## Project 3 - The Dating Game
You are to write a program that determines the day of the week for New Year's Day in the year 3000. To do this, you must create your own date class (MyDate) and use the given interface and main program.</br>
When the program is compiled and run, it should use your MyDate class to correctly predict the day of the week for January 1st, 3000.</br>
Note that we are using the integers 0-6 for the days of the week, with 0 representing Sunday, 1 for Monday, etc.

## Project 4 - Hunt the Wumpus
You are a mighty warrior, and armed with your trusty bow and 3 arrows, you enter The Caves in search of the mighty Wumpus. If you shoot the Wumpus, you are victorious and the masses will praise you, but if you stumble upon the Wumpus unawares, it will eat you! Also, beware of the webs of the giant poisonous spiders and the bottomless pits!
Your senses of smell and hearing will aid you on your quest, for the Wumpus does not bathe and can be smelled one room away. Also, the clicking mandibles of the poisonous spiders can be heard one room away, and the foul odor of a bottomless pit can be smelled one room away. </br>
For this project, you will implement a program that lets the user play Hunt The Wumpus!

## Project 5 - The La Food Restaraunt Program
The fancy new French restaurant La Food is very popular for its authentic cuisine and high prices. This restaurant does not take reservations. To help improve the efficiency of their operations, the Maitre De has hired you to write a program that simulates people waiting for tables. The goal is to determine the average amount of time people spend waiting for tables.</br>
Your program will read in a list of event descriptions from a text file, one description per line.
Arrival: A party has arrived to eat. Add them to the end of the list of waiting parties (a Queue) and tell them to wait at the bar (where strong drinks are served) until called. This event is described in the following format:</br>
`A t n name`</br>
Here t is the time of arrival (in minutes past opening time), n is the number of people in the party, and name is the name to call when the table is ready.</br>
Table: A table has become available; remove the party that has been waiting the longest from your list, and seat them. This event is described in the following form:</br>
`T t`</br>
Here t is the time the table became available (again, in minutes past opening time),
Quit: This is a sentinel event indicating the end of the input file. It has the following form:</br>
`Q`</br>
When the events in the file have been processed, compute and print the average waiting time per customer. If there are still people waiting for tables, print a summary of who is still waiting.

## Project 6 - Sorting Out Sorts
As a new and eager employee of BUSTInc (Butler University Software Technology Incorporated) you've been asked by your employer to implement a sorting algorithm for inclusion in a package for a lucrative client. However, your boss just wants you to implement one of the simple, quadratic sorting algorithms. To prove that this would be a big mistake, you've decided (on your own) to prove to your idiot boss that it's worth the extra effort to implement one of the O(n log n) sorting algorithms. For this project, you will implement and compare five sorting algorithms: bubble sort, insertion sort, selection sort, quicksort, and either mergesort or shellsort. Your main program will then do the following:

1. Ask the user for the size n of the list he/she wants to sort.
1. Create an array of size n and fill it with random integers between 1 and n. 
(Use the built-in Integer class, which implements the Comparable interface, to do this.) 
1. If n<=100, display the random array on the screen.
1. Run each of your sorts on this array. You must make a deep copy of the array before sorting it, or your second sort will have an easy time of it. Use the System.currentTimeMillis() function to determine the running time of each sort.
1. If n<=100, display the sorted arrays on the screen (they better be the same!).
1. Display the time each sort used to sort the array.
Once you have your program working, use it to plot a graph. Have the x axis represent n, and the y axis the running time. Use n=10000, 20000, ..., 100000. Plot all sorting algorithms on the same graph (use different colors or line styles). You may do this by hand (neatly, on graph paper) or you may use a spreadsheet program (like Excel or Google Sheets) or some other program to do this for you. (Will your boss be convinced?)

## Project 7 - Camp Posanivee
The director of Camp Posanivee is frustrated. Campers are enrolling and withdrawing from camp faster than her primitive filing system can handle, and she has turned to you. You have been offered free meals at the mess hall in return for a program that will help her keep track of who is enrolled for the two-week summer camp. </br>
Your program will use a binary search tree to maintain the set of campers enrolled in Camp Posanivee. Your program should not be case-sensitive. </br>
Your program will consist of a loop to process commands. The commands should come from a text file (say, "camp.txt"). The program quits when the command 'Q' is given. Below is a list of commands your program should support:</br>

| Command Line Input | Action Performed |
| --- | --- |
| H ( or Help) | print a list o f commands |
| E <name> <age> <sex> | Enroll a new camper (insert) |
|   W      <name>	        |   Withdraw a camper (delete)                     |
|   D      <name>	        |   Display the age and gender of a camper         |
|   A	                  |   Print the average age of the campers           |
|   L	                  |   List all campers names in alphabetical order   |
|   S	                  |   Print the number of boy and girl campers       |
|   P	                  |   List all campers names in preorder             |
|   Q	                  |   Quit                                           |

Here name is a string of at most 20 non-blank characters, age is an integer, and sex is either M or F. You may assume command arguments are separated by one or more spaces.
Be sure to echo the input, especially for commands that give no output (like E or W), and handle special cases in a clean way (for example, computing the average age of an empty tree should not crash your program).


## Project 8 - Jerry-Tac-Toe (Missing Code)

### Project Desctiption
You are to write an interactive Java program that plays Jerry-Tac-Toe with the user.</br>
Your program should play the user. The user should be allowed to choose whether to go first or second. Your program should draw the board on the screen and draw the moves graphically. You can have the user specify moves either by entering the numbers of the positions (with buttons or a textfield) or by using the mouse. When someone has won or all 9 places are filled, the game should stop and declare the outcome. The user should have the option to start a new game or quit. </br>
Please also note that, to receive full credit on this assignment, it is not necessary for your program to play well; it is sufficient for it to play legally.</br>

### Game Description
This game is similar to Tic-Tac-Toe. The players, X and O, take turns making moves, and the first to place three of their symbols in a row wins. If neither wins and all places are filled, the game is a draw.</br>
The difference between standard Tic-Tac-Toe and Jerry-Tac-Toe is that the board is different.</br>
![alt text](https://github.com/RachelBurke/CS248/blob/master/Projects/jtt.gif)</br>
Here you can get three in a row using 1-2-3, 1-5-9, 1-4-8, 2-4-7, and so forth. 2-5-8 is not a winning combination (there is no line), and neither is 2-4-8 (the line is not straight).</br>
