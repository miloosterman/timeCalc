/******************************************************************************************************************* 
  * timeCalc.java 
  * Author: Milo Osterman
  * CIS 129 - Programming and Problem Solving I  
  * Pima Community College - Fall 2020 
  ******************************************************************************************************************  
  * This program asks the user for a number of seconds which they input, the program gives back days/hours/mins/secs. 
  ******************************************************************************************************************/ 

import java.util.*;
public class timeCalcMiloOsterman {
  //Declares the constants that will be used in program.
  public static final int SECONDS_IN_DAY = 86400;
  public static final int SECONDS_IN_HOUR = 3600;
  public static final int SECONDS_IN_MINUTE = 60;
  public static final int DEFAULT_QUANTITY = 0;
  static Scanner keyboard = new Scanner(System.in);
  
  public static void main (String args[]){
    //Declaration of all variables in program.
    int seconds;
    int numberOfDays;
    int remainingSecsFromDays;
    int numberOfHours;
    int remainingSecsFromHours;
    int numberOfMinutes;
    int remainingSecsFromMins;
    
    //Intro message.
    introDisplay();
    
    //Gets initial seconds value from user.
    seconds = getInteger("Enter any number of seconds. The program will convert them to days, hours, mins, and secs.");
    //Initializes program by first checking if the seconds are enough to be measured as a day.
    numberOfDays = initialCalcDays(seconds, SECONDS_IN_DAY);
    //Saves the remaining seconds if applicable from previous function
    remainingSecsFromDays = calcRemainingSeconds(seconds, SECONDS_IN_DAY, DEFAULT_QUANTITY);
    //Calculates how many hours fit into seconds.
    numberOfHours = calcDaysHoursMins(seconds, SECONDS_IN_HOUR, remainingSecsFromDays);
    //Saves new remaining seconds if applicable.
    remainingSecsFromHours = calcRemainingSeconds(seconds, SECONDS_IN_HOUR, remainingSecsFromDays);
    //Calculates how many minutes fit into seconds.
    numberOfMinutes = calcDaysHoursMins(seconds, SECONDS_IN_MINUTE, remainingSecsFromHours);
    //Saves remaining seconds.
    remainingSecsFromMins = calcRemainingSeconds(seconds, SECONDS_IN_MINUTE, remainingSecsFromHours);
    //Displays results of program to user.
    displayResults(seconds, numberOfDays, numberOfHours, numberOfMinutes, remainingSecsFromMins);
    //End message.
    endDisplay();
    
  }
  
  public static void introDisplay(){
    System.out.println("**********************************************");
    System.out.println("* Welcome to the Time Calculation Program    *");
    System.out.println("**********************************************");
  }
  
  public static int getInteger(String msg) { 
    System.out.println(msg); 
    if (!keyboard.hasNextInt()) {  // gets input from the user and asks if it is an integer 
      System.err.println("Error: Invalid number. Ending Program"); 
      System.exit(-1); 
    } 
    int newValue = keyboard.nextInt();  // gets an integer 
    return newValue; 
  }
  
  public static int initialCalcDays(int seconds, int QUANTITY){
    
    int quantityAmt = seconds / QUANTITY;
    return quantityAmt; 
    
  }
  
  
  public static int calcDaysHoursMins(int seconds, int QUANTITY, int remainingSecs){
    
    if (remainingSecs >= DEFAULT_QUANTITY) {
      int quantityAmt = remainingSecs / QUANTITY;
      return quantityAmt;
    }
    
    else{
      int quantityAmt = seconds / QUANTITY;
      return quantityAmt;
    }
    
    
    
    
  }
  
  public static int calcRemainingSeconds(int seconds, int QUANTITY, int remainingSecs){
    
    if (remainingSecs > DEFAULT_QUANTITY) {
      int quantityAmt = remainingSecs % QUANTITY;
      return quantityAmt;
    }
    
    else {
      int quantityAmt = seconds % QUANTITY;
      return quantityAmt;}
    
  }
  
  
  
  public static void displayResults(int initialSecs, int days, int hours, int minutes, int remainingSecs){
    
    System.out.println("The amount of seconds you input was: " + initialSecs + ".");
    System.out.println("--------------------------------------------------------------");
    System.out.print("This results in: " + days + " days, ");
    System.out.print(hours + " hours, ");
    System.out.print(minutes + " minutes, ");
    System.out.println("and " + remainingSecs + " seconds.");
    System.out.println("--------------------------------------------------------------");
    
  }
  
  public static void endDisplay(){
    System.out.println("End program. Thanks for using the Time Calculation Program!");
  }
  
  
}
