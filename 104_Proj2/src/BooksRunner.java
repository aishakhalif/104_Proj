/***************************************************************************
 * Aisha Khalif
 * 32381361
 * ICT 104: Principles of Computer Science
 * 31st March 2014
 * Assignment 2
 * Book Store Program
 * File: BooksRunner.java
 * Description: A program that will allow a bookstore owner to keep track of 
 *              and maintain all of the books that are in stock at his store.
 * 
 ****************************************************************************/

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class BooksRunner {

//declaring the array    
Books[] books;

//constructer to create array and determine it's size
public BooksRunner(){
    
    books = new Books[6];
    
}

public static void main(String[] args) throws Exception {
    BooksRunner bk = new BooksRunner();
    
    {
        System.out.println("Name: Aisha Khalif");
        System.out.println("Student ID: 32381361");
        System.out.println("Enrolment Mode: Internal");
        System.out.println("Tutor Name: Mr. Wayne Muller");
        System.out.println("Tutorial Day and Time: Monday at 4:30 - 5:30 PM");
        System.out.println("");
        
     }
    
    System.out.println("                                                     *** Welcome to the bookstore archive! ***                                                     ");
    System.out.println("");
    System.out.println("Please begin by entering the information of all your books. The store is currently empty.");
    
    
    bk.DisplayMenu();
    
        }

//displays the menu to the user which they can then chose from
    private void DisplayMenu() 
    {
                int menuChoice = 0;
                int count = 1;
                
          while(menuChoice != 12) {
                
                Scanner scan = new Scanner(System.in);
                System.out.println("");
                System.out.println("1. Enter the deails of your books");
                System.out.println("2. Output details of books in stock.");
                System.out.println("3. Output details of book via it's title");
                System.out.println("4. Output details of book via it's ISBN");
                System.out.println("5. Display most expensive book in stock");
                System.out.println("6. Display quantity of total books in stock");
                System.out.println("7. Display total cost of all books in stock");
                System.out.println("8. Update stock of a book via it's ISBN");
                System.out.println("9. Update price of book via it's title");
                System.out.println("10. Add details of new book to stock");
                System.out.println("11. Delete record of book from stock via it's ISBN");
                System.out.println("12. Quit the program");
                
                System.out.println();
                menuChoice = CheckIfInt(scan, "Enter the number of your choice: ");
               
                switch (menuChoice) {
                    
                case 1:
                PromptForBookDetails();
                break;
                case 2:
                OutputAllBookDetails();
                break;
                case 3:
                OutputDetailsViaTitle();
                break;
                case 4:
                OutputDetailsViaISBN();
                break;
                case 5:
                MostExpensiveBook();
                break;
                case 6:
                TotalStockQuanity();
                break;
                case 7:
                TotalStockPrice();
                break;
                case 8:
                UpdateStockViaISBN();
                break;
                case 9:
                UpdatePriceViaTitle();
                break;
                case 10:
                AddNewBook();
                break;
                case 11:
                DeleteExistingBook();
                break;
                case 12:
                System.exit(0);
                break;
        }
                } 
         
    }

    private void PromptForBookDetails() 
    {
     
        Scanner scan = new Scanner(System.in);
    
        for(int x =0; x < books.length; x++) 
        {
            System.out.println("");
            System.out.println("BOOK #" +(x+1));
            System.out.println("");
            String booktitle = CheckIfString(scan, "Enter Book's Title: ");
            String author = CheckIfString(scan, "Enter Book's Author: ");
            String publisher = CheckIfString(scan, "Enter Book's Publisher: ");
            String year = CheckIfString(scan, "Enter Book's Year of publication: ");
            String isbn = CheckIfString(scan, "Enter Book's ISBN:");
            double price = CheckIfDouble(scan, "Enter Book's Price: ");
            int stock = CheckIfInt(scan, "Enter Book's Stock: ");
            books[x] = new Books(booktitle, author, publisher, year, isbn, price, stock);
        
        }
    }

    private void OutputAllBookDetails() 
    {
    
    //If a book has been deleted, the deleted book will become null. Check for null before printing book to avoid crash.
        System.out.println("All books in stock are: "); 
        for (int i = 0; i < books.length; i++){
       
        if (books[i] != null) 
        {
           
           System.out.println(" ");
           System.out.println(books[i].getTitle() + " by " + books[i].getAuthor());
           System.out.println("Published by: " + books[i].getPublisher() + " in " + books[i].getYear());
           System.out.println("ISBN: " + books[i].getIsbn());
           System.out.println("Costs: $" + books[i].getPrice());
           System.out.println("Stock Available: " + books[i].getStock());
           
        }
        //Once the loop has finished and books are not found...
        else if (i == books.length - 1){
            System.out.println("There are currently no books in the system.");
        }
    }
}
       
    private void OutputDetailsViaTitle()
    {
        //get the users choice of book
        Scanner scan = new Scanner(System.in);
        String title = CheckIfString(scan, "Please enter the title of the book: ");
        System.out.println("");
            
        for (int i = 0; i < books.length; i++)
        {
            //print it's details if it is not a null, as a result of deletion
            if (books[i] != null && books[i].getTitle().equalsIgnoreCase(title)) 
            {
           
                System.out.println(" ");
                System.out.println(books[i].getTitle() + " by " + books[i].getAuthor());
                System.out.println("Published by: " + books[i].getPublisher() + " in " + books[i].getYear());
                System.out.println("ISBN: " + books[i].getIsbn());
                System.out.println("Costs: $" + books[i].getPrice());
                System.out.println("Stock Available: " + books[i].getStock());
                break;
            }
            //Once the loop has finished and books are not found...
            if (i == books.length - 1)
            {
                System.out.println("The book you have requested is not currently available.");
            }
        }
    
    }

    private void OutputDetailsViaISBN() 
    {
        //get the users choice of book
        Scanner scan = new Scanner(System.in);
        String isbnSearch = CheckIfString(scan, "Please enter the ISBN of the book: ");
        System.out.println("");
       
        for (int i = 0; i < books.length; i++) 
        {
            //print it's details if it is not a null, as a result of deletion
            if (books[i] != null && books[i].getIsbn().equalsIgnoreCase(isbnSearch)) {
           
                System.out.println(" ");
                System.out.println(books[i].getTitle() + " by " + books[i].getAuthor());
                System.out.println("Published by: " + books[i].getPublisher() + " in " + books[i].getYear());
                System.out.println("ISBN: " + books[i].getIsbn());
                System.out.println("Costs: $" + books[i].getPrice());
                System.out.println("Stock Available: " + books[i].getStock());
                break;
        }
        
            if (i == books.length - 1)
            {
                System.out.println("The book you have requested is not currently available.");
            }
        }
       
    }

    private void TotalStockQuanity() 
    {
        int totalStock = 0;
        
        for(int i = 0; i < books.length; i++)
        {
            if(books[i] == null) 
            {
                System.out.println();
            }
        //If no null elements are present, add all the available stock
            else
            {
             totalStock += books[i].getStock();
            }
        }
//print the total stock of all books in the bookstore   
System.out.println( "Total stock of books avalaible: " + totalStock );
    
  
} 

    private void TotalStockPrice() 
    {
        int totalPrice = 0;
        
        for(int i = 0; i < books.length; i++)
        {
            if(books[i] == null) 
            {
            System.out.println();
            }
            //If no null elements are present, add all the available prices x all stock so as to get the total monetary value
            else
            {
             totalPrice += (books[i].getPrice()*books[i].getStock());
            }
        }
//print the total price of all books in the bookstore      
System.out.println( "Total price of books avalaible: " + totalPrice );
    
    }
    
    private void MostExpensiveBook() 
    {
        double max = Integer.MIN_VALUE;
    
        for(int i = 0; i < books.length; i++) 
        {
            //check for a null element that resulted from deletion so as to avoid complications
            if(books[i] != null && books[i].getPrice() > max) 
            {
                max = books[i].getPrice();
                System.out.println("Most expensive book costs " + max);
                System.out.println(" ");
                System.out.println(books[i].getTitle() + " by " + books[i].getAuthor());
                System.out.println("Published by: " + books[i].getPublisher() + " in " + books[i].getYear());
                System.out.println("ISBN: " + books[i].getIsbn());
                System.out.println("Costs: $" + books[i].getPrice());
                System.out.println("Stock Available: " + books[i].getStock());
                break;
            }
            if (i == books.length - 1)
            {
            System.out.println("Your library is currently empty. Choose option 1 to add books");
            }
                    
    }

   
   
    }

    private void UpdateStockViaISBN()
    {
    
        Scanner scan = new Scanner(System.in);
        //getting the users choice of book
        String isbnSearch = CheckIfString(scan, "Please enter the ISBN of the book: ");
        //getting the new stock the user wishes to set
        int stockUpdate = CheckIfInt(scan, "Enter new stock quantity for the book: ");
    
    
        for (int i = 0; i < books.length; i++) 
        {
            //check for a null element that resulted from deletion so as to avoid complications
            if (books[i] != null && books[i].getIsbn().equalsIgnoreCase(isbnSearch))
            {
                books[i].updateStock(stockUpdate);
            
                System.out.println(" ");
                System.out.println(books[i].getTitle() + " by " + books[i].getAuthor());
                System.out.println("Published by: " + books[i].getPublisher() + " in " + books[i].getYear());
                System.out.println("ISBN: " + books[i].getIsbn());
                System.out.println("Costs: $" + books[i].getPrice());
                System.out.println("Stock Available: " + books[i].getStock());
                break;
            }
           //If end of array is reached and users choice of book is not found, print error message
           if (i == books.length - 1) 
            {
                System.out.println("The book you have requested to currently available.");
            }
           
        }
    
   
    }

    private void UpdatePriceViaTitle()
    {
        Scanner scan = new Scanner(System.in);
        //getting the users choice of book
        String title = CheckIfString(scan, "Enter the title of book: ");
        //getting the new stock the user wishes to set
        double priceUpdate = CheckIfDouble(scan, "Enter the new price of book: ");
    
    
        for (int i = 0; i < books.length; i++) 
        {
            //check for a null element that resulted from deletion so as to avoid complications
            if (books[i] != null && books[i].getTitle().equalsIgnoreCase(title))
            {
                books[i].updatePrice(priceUpdate);
           
                System.out.println("EDITED BOOK DETAILS: ");
                System.out.println(books[i].getTitle() + " by " + books[i].getAuthor());
                System.out.println("Published by: " + books[i].getPublisher() + " in " + books[i].getYear());
                System.out.println("ISBN: " + books[i].getIsbn());
                System.out.println("Costs: $" + books[i].getPrice());
                System.out.println("Stock Available: " + books[i].getStock());
                break;
            }
            //If end of array is reached and users choice of book is not found, print error message
            if (i == books.length - 1) 
            {
                System.out.println("The book you have requested to deleted is not currently available.");
            }
        }
    }

    private void AddNewBook() 
    {
        Scanner scan = new Scanner(System.in);
        //Adding a new book will increase array by one
        //Here Arrays.copyOf is used to copy the current array into a longer one everytime a new book is added
        Books[] newBooks = Arrays.copyOf(books, books.length + 1);
            
            //get the users input for the new book
            for(int i = newBooks.length - 1; i < newBooks.length; i++) 
            {
        
                System.out.println("BOOK #" +(i+1));
                String booktitle = CheckIfString(scan, "Enter Book's Title: ");
                String author = CheckIfString(scan, "Enter Book's Author: ");
                String publisher = CheckIfString(scan, "Enter Book's Publisher: ");
                String year = CheckIfString(scan, "Enter Book's Year of publication: ");
                String isbn = CheckIfString(scan, "Enter Book's ISBN:");
                double price = CheckIfDouble(scan, "Enter Book's Price: ");
                int stock = CheckIfInt(scan, "Enter Book's Stock: ");
                newBooks[i] = new Books(booktitle, author, publisher, year, isbn, price, stock);
        
            }
            //So that only the first list of books is not printed, reenstate the previous book array as the new, longer array. 
            books = Arrays.copyOf(newBooks,newBooks.length);
            
            //print all the book details, including the new one
            for(int i =0; i < newBooks.length; i++)
            {
        
                System.out.println(" ");
                System.out.println(newBooks[i].getTitle() + " by " + newBooks[i].getAuthor());
                System.out.println("Published by: " + newBooks[i].getPublisher() + " in " + newBooks[i].getYear());
                System.out.println("ISBN: " + newBooks[i].getIsbn());
                System.out.println("Costs: $" + newBooks[i].getPrice());
                System.out.println("Stock Available: " + newBooks[i].getStock());
            }
    }

    private void DeleteExistingBook()
    {
       
        Scanner scan = new Scanner(System.in);
        //get the users input for the book they wish to delete
        String isbnSearch = CheckIfString(scan, "Please enter the ISBN of the book you wish to delete: ");
        System.out.println("");
       
        boolean foundISBN = false;
        int currentLength = books.length;
       
        for (int i = 0; i < currentLength; i++) 
        {
            if (foundISBN == false) 
            {
                //Find the desired book is in the array and that it was not previously delted
                if (books[i] != null && books[i].getIsbn().equalsIgnoreCase(isbnSearch)) 
                {
                    foundISBN = true;
                }
            }
            //if book is found, 'delete' it by making it nul
            if (foundISBN == true) 
            {
                if (i < books.length - 1) 
                {
                    books[i] = books[i + 1];
                } 
                else 
                {
                    books[i] = null;
                    currentLength--;
                    System.out.println("The book you requested to delete has been deleted!");
                    break;
                }
            }
           //if end of the array is reached and the desired book is not found, print error message 
           if (i == currentLength - 1) 
           {
                System.out.println("The book you have requested to delete is not currently available.");
           }
        }
  
    }

    //A method to check if the users input for a string is correct where needed. If not, instead of crashing, program will prompt user again.
    private static int CheckIfInt(Scanner scanner, String PromptUser) 
    {
	
        if (scanner == null) 
        {
		throw new IllegalArgumentException("The scanner has not been initialized!");
	}

	Integer value = null;

	do {
		System.out.print(PromptUser);
		try {
			value = Integer.parseInt(scanner.nextLine());
                        
		} catch (InputMismatchException | NumberFormatException e) 
                {
			System.out.print("INCORRECT INPUT. TRY AGAIN. ");
		}
	} while (value == null);

	return value.intValue();
    }

    //A method to check if the users input for a double is correct where needed (Price). If not, instead of crashing, program will prompt user again.
    private static double CheckIfDouble(Scanner scanner, String PromptUser) 
    {
	
        if (scanner == null) 
        {
		throw new IllegalArgumentException("The scanner has not been initialized!");
	}

	Double value = null;

	do {
		System.out.print(PromptUser);
                
		try {
			value = Double.parseDouble(scanner.nextLine());
                        
		} catch (InputMismatchException | NumberFormatException e) 
                {
			System.out.print("INCORRECT INPUT. TRY AGAIN.");
		}
	} while (value == null);

	return value.doubleValue();
}

    //A method to check if the users input for an Int is correct where needed (Stock). If not, instead of crashing, program will prompt user again.
    private static String CheckIfString(Scanner scanner, String PromptUser) 
    {
	if (scanner == null) 
        {
		throw new IllegalArgumentException("Scanner must be initialized!");
	}

	String StrValue = null; 

	do {
		System.out.print(PromptUser);
		try {
			StrValue = scanner.nextLine();

			if (StrValue.trim().length() < 1) 
                        {
				StrValue = null;
				System.out.print("INCORRECT INPUT. TRY AGAIN. ");
			}
		} catch (Exception e) 
                {
		//at this point, nothing will be done.	
		}
	} while (StrValue == null);

	return StrValue;
}

}

