/*
 * Aisha Khalif
 * 32381361
 * Assignment 1
 * QUESTION 1
 *
 */

import java.util.Scanner;


public class loan {
public static void main(String[] args){
    
    loan program = new loan();

  //studentInfo()
          
    {
        System.out.println("Name: Aisha Khalif");
        System.out.println("Student ID: 32381361");
        System.out.println("Enrolment Mode: Internal");
        System.out.println("Tutor Name: Mr. Wayne Muller");
        System.out.println("Tutorial Day and Time: Monday at 4:30 - 5:30 PM");
        
     }
    
    do
        {
            program.Input();
            program.printTable();
            
        }while(quitProgram() != true);

        
}
    private double loan;
    private int duration;
    private float upperInterestRate;
    private float lowerInterestRate;
    
    
        Scanner input = new Scanner(System.in);
        
        public void Input()
    {
        inputLoanAmount();
        inputLoanDuration();
        inputInterestRange();
    }

        //Amount of loan taken
        private void inputLoanAmount()
                
      {
        double loan = 0.0;
        System.out.print("\nEnter the loan amount: ");
        loan = input.nextDouble();
        
        while(!validInput(loan))
        {
            System.out.print("You cannot enter 0 or negative numbers. Try again: ");
            loan = input.nextInt();
            System.out.println();
        }
        
        this.loan = loan;
      } 

        //Number of years
        private void inputLoanDuration()
                
      {
          
        int duration = 0;
        System.out.print("Enter the number of years: ");
        duration = input.nextInt();
        
        while(!validInput(duration))
        {
            System.out.print("You cannot enter 0 or negative numbers. Try again: ");
            duration = input.nextInt();
            System.out.println();
        }
        
        this.duration = duration;
        
      }
        //Annual interest rate
       private void inputInterestRange()
               
    {

        
        //Read in the lower interest rate range
        System.out.print("Enter the lower interest rate: ");
        
        Scanner keyboard = new Scanner(System.in);
        this.lowerInterestRate = keyboard.nextFloat();
   
        
        //Read in the upper interest range rate
        System.out.print("Enter the upper interest rate: ");
        this.upperInterestRate = keyboard.nextFloat();
      
              
    }
       
       private float getMonthlyPayment(float interest)
    {
        float monthlyPayment = 0.0f;
        //monthlyPayment = (float)((loan * interest) / (1.0 - (1.0 / Math.pow((1.0 + interest), (duration * 12)))));
        monthlyPayment = (float) ((float)(loan * interest) / (1.0 - 1.0 / Math.pow(1.0 + interest, duration *12)));
        return monthlyPayment;
    }
    
    //Calculates and returns the Total payment
    private float getTotalPayment(float monthlyPayment)
            
    {
        return monthlyPayment * duration * 12;
    }
    
    public void printTable()
    {
       float monthlyPayment = 0.0f;
       float totalPayment = 0.0f;
        
        System.out.println("\nLoan Amount: " + loan);
        System.out.println("Number of years: " + duration);
        
        //TABLE HEADER
        System.out.println("Interest\t Monthly Payment\t Total Payment\t");
        
        
        
        //ROWS OF DATA
        for(float i = lowerInterestRate; i <= upperInterestRate; i += 0.25)
        {
            //MONTHLY AND TOTAL PAYMENTS CALCULATION
            monthlyPayment = Math.round(getMonthlyPayment((i / (12 * 100))));
            totalPayment = Math.round(getTotalPayment(monthlyPayment));            
            
            //FILL TABLE WITH CORRECT DATA
            System.out.printf("%.2f", i);
            System.out.printf("%25f", (monthlyPayment));
            System.out.printf("%25f\n", (totalPayment));
        }
    }
    
    private boolean validInput (double value)
    {
        return (value > 0);
    }
    
        //QUITTING
        private static boolean quitProgram()
    {
        String getChoice;
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nDo you want to quit this program? (yes/no): ");
        
        getChoice = keyboard.nextLine();
        System.out.println();
        
        if(getChoice.equals("no")){
            return false;
        }
        else{
            return true;
        }
    }
        
     



}

        
