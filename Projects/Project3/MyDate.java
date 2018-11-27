/**
Class for calculating the day of the week based on an initial given date 
by the main program
@author Rachel Burke
*/
public class MyDate implements DateInterface

{	//Data Fields (variables for supplied information and arrays to 
	// store names of months and weeks)
	int month, day, year, wk_day;
	String month_name [] = {"January","February","March","April","May","June","July","August","September",
							"October","November","December"};
	String wk_day_name [] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	
/** 
@param m The Month
@param d The Day
@param y The Year
@param dow The Day of the Week
*/
	public void set(int m, int d, int y, int dow) {
		month = m; day = d; year = y; wk_day = dow;}

/** @return The Day */
	public int getDay() {
		return day;} 
		
/** @return The Day of the Week */
	public int getDow(){
		return wk_day;}
		
/** @return The Month */
	public int getMonth(){
		return month;}
		
/** @return The Year */
	public int getYear(){
		return year;}

/** 
Changes the date forward by one day and makes any necessary changes in weekday, month, 
and year
*/
	public void tomorrow(){
	//Weekday changer (0-6)
	 wk_day = (wk_day+1)%7;
	 //Months with 30 days day counter (1-30)
	if (month == 9 || month == 4 || month == 6 || month == 11)
		day = (day%30)+1;
	//February & Leap Year day counter (1-28/29)
	else if (month == 2){
			//Non-leap Years and Centurical Non-leap Years
			if ((year % 4 != 0) || 
			    (year % 4 == 0 && year % 100 == 0 && year % 400 != 0))
				day = (day%28)+1;
			else if ((year % 100 !=0 && year % 4 == 0) || 
					 (year % 400 == 0))
					day = (day%29)+1;
	}
	//Months with 31 days day counter (1-31)
	else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			day = (day%31)+1;
	 //Month Changer
	 if (day == 1)
		 month = (month%12)+1;
	 //Year Changer
	 if (month == 1 && day == 1)
		year = year + 1;
	}
	
/** @return A String Representation of the Date */
	public String toString(){
		return wk_day_name [wk_day]+ ", "+month_name [month-1]+ " " +day+ ", " +year;}
	
	//Extra Credit
	public void today(){

	}
/** 
Changes the date backward by one day and makes any necessary changes in weekday, month, 
and year
*/
	public void yesterday(){
		//Weekday changer (0-6)
		if (wk_day == 0)
			wk_day = 6;
		else
			wk_day--;
		//End of a month/year changer & day changer
		if (day == 1){
			if (month == 1){
				year--;
				month = 12;
				day = 31;
			}
			// Dealing February
			else if (month == 3){
				//Centurical Leap Year and Non-centurical leap years
				if ((year % 400 == 0) || 
					(year % 100 != 0 && year % 4 == 0)){
					month = 2;
					day = 29;
				}
				//Centurical Non-leap Years and Regular Non-leap years
				else if ((year % 100 == 0 && year % 400 != 0 && year % 4 == 0)||
						 (year % 4 != 0)){
					month = 2;
					day = 28;
				}
			}
			//Dealing with months with 31 days
			else if (month == 2 || month == 4 || month == 6 || month == 8 || month == 9 || month == 11){
				month--;
				day = 31;
			}
			//Dealing with months with 30 days
			else if (month == 5 || month == 7 || month == 10 || month == 12){
				month--;
				day = 30;		
			}
		} 
		else 
			day--;
	}
}