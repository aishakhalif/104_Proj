/*
 * Aisha Khalif
 * 32381361
 * Assignment 1
 * QUESTION 2
 *              
 */

import java.util.Scanner;


public class people {
    
    static char answer;
    static char choice;
    static int regulars = 0;
    int percentage;
    

    public static void main(String[] args){
    
    people program = new people();
    
    {
        System.out.println("Name: Aisha Khalif");
        System.out.println("Student ID: 32381361");
        System.out.println("Enrolment Mode: Internal");
        System.out.println("Tutor Name: Mr. Wayne Muller");
        System.out.println("Tutorial Day and Time: Monday at 4:30 - 5:30 PM");
        System.out.println(" ");
        
     }
    
        
   do{
       do{
           
          regulars++;
           
           program.DataInput();
           
                   
           Scanner keyboard = new Scanner(System.in);       
           System.out.println("Do you want to enter another person's details?: ");
           answer = keyboard.nextLine().toLowerCase().charAt(0);
           
            } while(answer != 'n');
       
       program.printTable();
       
       Scanner keyboard = new Scanner(System.in); 
       System.out.println("\n\nDo you want to quit the program?: ");
       choice = keyboard.nextLine().toLowerCase().charAt(0);
       
   }while(choice != 'n');
 
    }
    
    public static int age;
    private char gender;
    private char yesNo;
    private boolean isRegular;
    
    public void DataInput()
    {
        
        getAge();
        getGender();
        regularViewer();
        assembleInfo();
        
    }
    
   Scanner input = new Scanner(System.in);
    
   public static int getAge()
{
  int age;//Read age from keyboard
  System.out.println("Please enter this persons age (1-120): ");
  Scanner keyboard = new Scanner(System.in);
  age = keyboard.nextInt();
  
  while(!validInput(age))
        {
            System.out.print("Age should be between 1 - 120. Try again: ");
            age = keyboard.nextInt();
            System.out.println();
        }
               
  return age;
}
       
 
   private void getGender()
   {
       System.out.print("Please enter this persons gender: ");
       char gender = input.nextLine().toLowerCase().charAt(0);
       
       
       this.gender = gender;
   }
   

private void regularViewer()
        
   {
        boolean isRegular;
        
        System.out.print("Please enter whether this person watches regularly (Y/N): ");
        char yesNo = input.nextLine().toLowerCase().charAt(0);
        
        if(yesNo == 'y'){
            
                   isRegular = true;
               }
                   else{
                          isRegular = false;
                        }
       
        this.yesNo = yesNo;
    } 
    
    
private void assembleInfo()
        
{
        
   int femalesUnder30 = 0;
   int femalesOver30 = 0;
   int malesUnder30 = 0;
   int malesOver30 = 0;
   int totalMales = 0;
   int totalFemales = 0;
   
   if(isRegular)
                    
                  {
                    if(gender == 'F')
                       totalFemales++;
                    
                    else
                       totalMales++;
                    
                    if(gender == 'F' && age >= 30)
                       femalesOver30++;
                    
                    if(gender == 'F' && age < 30)
                       femalesUnder30++;
                                                              
                    if(gender == 'M' && age >= 30)
                       malesOver30++;
                                                                       
                    if(gender == 'M' && age < 30)
                       malesUnder30++;
                  }
    }
    
    
public void printTable()
            
   {
       
   int femalesUnder30 = 0;
   int femalesOver30 = 0;
   int malesUnder30 = 0;
   int malesOver30 = 0;
   int totalMales = 0;
   int totalFemales = 0;
   int percentage;
   
   int totalUnder30 = getPercentage(femalesUnder30) + getPercentage(malesUnder30);
   int totalOver30 = getPercentage(femalesOver30) + getPercentage(malesOver30);
   int total = getPercentage(totalFemales) + getPercentage(totalMales);
                                   
   System.out.println ("--------------------------------------------------------------------------");            //can use for for print divider
   System.out.println("Gender           %Under30             %30 and Over         %Total");
   System.out.println ("--------------------------------------------------------------------------");
   System.out.print("\nFemale"  + "\t\t" + getPercentage(femalesUnder30)  +  "\t\t\t" +  getPercentage(femalesOver30)   + "\t\t" +  getPercentage(totalFemales));
   System.out.print("\nMale"  + "\t\t" + getPercentage(malesUnder30) + "\t\t\t" +  getPercentage(malesOver30)   + "\t\t" +  getPercentage(totalMales));
   System.out.print("\nTotal" + "\t\t" +   totalUnder30 + "\t\t\t" +  totalOver30 + "\t\t" +  total);
   
    }
    
    private static int getPercentage(int percentage)
{
        int regulars = 0;
        return percentage = Math.round((int)(percentage/regulars) * 100);
}
   
    
    private static boolean validInput (int value)
            
    {
        return ((value >= 1) & (value <= 120));
    } 
        
}