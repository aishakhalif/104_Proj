/*
 * Aisha Khalif
 * 32381361
 * Assignment 1
 * QUESTION 3
 *
 */

import java.util.Scanner;

public class time
{
 
    public static void main(String[] args) {
        
        //studentInfo()
          
    {
        System.out.println("Name: Aisha Khalif");
        System.out.println("Student ID: 32381361");
        System.out.println("Enrolment Mode: Internal");
        System.out.println("Tutor Name: Mr. Wayne Muller");
        System.out.println("Tutorial Day and Time: Monday at 4:30 - 5:30 PM");
        System.out.println(" ");
        
     }
        
        char choice;
        String entryOne;
        String firstString, secondString;
        
        time timeOne = new time ();
        time timeTwo = new time ();
        time difference = new time();
        
        Scanner input = new Scanner(System.in);
        
        do
            
        {
           firstString = timeOne.getEntryOne();
           secondString = timeTwo.getEntryOne();
           
           int hourOne = extractHours(firstString);
           int hourTwo = extractHours(secondString);
           
           int minuteOne = extractMinutes(firstString);
           int minuteTwo = extractMinutes(secondString);
           
           String amPm1 = extractamPM(firstString);
           String amPm2 = extractamPM(secondString);
           
           if(amPm1.equals("p") && hourOne < 12)                       
            {
               hourOne = hourOne + 12;
            }
            
            if(amPm2.equals("p") && hourTwo < 12)
            {
                hourTwo = hourTwo + 12;
            }
            
            int diffrence = getTimeDifference(hourOne, hourTwo, minuteOne, minuteTwo);
            System.out.println("Time difference is " + diffrence + " minutes");
            
            
            System.out.println("Do you wish to continue? Y/N: ");
            choice = input.nextLine().toUpperCase().charAt(0);
            
            
    }while(choice != 'N');
    
    }
    
     
    String getEntryOne()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the time as (hh:mm am/pm): ");
        String entryOne = keyboard.nextLine();
        
        return entryOne;
    }
    
    String in;
    
    //breakes the inputted time into substrings and turns the hour from 
    private static int extractHours(String in)
    {
         
       
        int colon = in.indexOf(':');
        String hoursIn = in.substring(0, colon);
        int hours = Integer.parseInt(hoursIn);
        
        return hours;
    }
    
    
    private static int extractMinutes(String in)
    {
       
        int colon = in.indexOf(':');
        String minutesIn = in.substring(colon+1, colon+3);
        int minutes = Integer.parseInt(minutesIn);
        
        return minutes;
    }
    
    private static String extractamPM(String in)
    {
        String amPM = in.substring(in.length()-2, in.length()-1);
        amPM.toLowerCase();
        return amPM;
    }
    
     private static int getTimeDifference(int hourOne,  int hourTwo, int minuteOne, int minuteTwo)
    {
        int minutes = 0; 
        int hours = 0; 
        int result = 0; 
        
       //This IF statement will convert the hours into the 24 hour time, in order to make the calculation easier 
        if(minuteOne > 0){
            minutes = 60 - minuteOne;
            hourOne++;
             }
       
       //Subtract the two hours        
        hours = hourTwo - hourOne;
                
       //Add it to the second minutes entered by the user        
        minutes += minuteTwo;
       
       //converts the final time to minutes
        result = minutes + (hours * 60);
      
       //Final minutes are returned.
        return result;
       
         
         }

     
    }
