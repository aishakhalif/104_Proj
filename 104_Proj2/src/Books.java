/***************************************************************************
 * Aisha Khalif
 * 32381361
 * ICT 104: Principles of Computer Science
 * 31st March 2014
 * Assignment 2
 * Book Store Program
 * File: Books.java
 * Description: A program that will allow a bookstore owner to keep track of 
 *              and maintain all of the books that are in stock at his store.
 * 
 ****************************************************************************/

class Books {
        private String title;
        private String author;
        private String publisher;
        private String year;
        private String isbn;
        private double price;
        private int stock;
        
       public Books(String t, String a, String p, String y, String i, double pr, int s) {
            title = t;
            author = a;
            publisher = p;
            year = y;
            isbn = i;
            price = pr;
            stock = s;
   
        }



        public String getTitle() {
                return title;
        }
        
        private void setTitle(String title) {
            
            this.title = title;
        }

        public  String getAuthor() {
                return author;
        }
        
        private void setAuthor (String author) {
            
            this.author = author;
        }

        public  String getIsbn() {
                return isbn;
        }
        
        private void setIsbn(String isbn) {
            
            this.isbn = isbn;
        }

        public  String getPublisher() {
                return publisher;
        }
        
        private void setPublisher (String publisher) {
            
            this.publisher = publisher;
        }

        public  String getYear() {
                return year;
        }
        
        private void setYear(String year) {
            
            this.year = year;
        }

        public double getPrice() {
                return price;
        }
        
        void setPrice(double price) {
            
            this.price = price;
        }
        
        void updatePrice (double price) {
            
            this.price = price;
        }
        
        int getStock() {
            return stock;
        }
        
        void setStock(int stock) {
            
            this.stock = stock;
        }
        
        void updateStock (int stock) {
            
            this.stock = stock;
            
        }

    
}


