import java.util.Scanner;
class MyException extends Exception{
        String s;
        MyException(String s){
                this.s=s;
        }
        public String  getMessage()
        {
                return s;
        }
}

public class Library implements Borrowable{
        //Borrow Method is used to allot a book to user upon request
        public void borrow()
        {
           Scanner scan3= new Scanner(System.in);
           System.out.println("Available Books:");
           Book.displayBooks();
           System.out.println("Available Patrons:");
           Patron.displayPatrons();
           System.out.println("Enter Book ISBN:");
           Long book_isbn=scan3.nextLong();
           System.out.println("Enter Patron ID:");
           int patron_id=scan3.nextInt();
           int valid=0;
           if(Patron.patronCollection.containsKey(patron_id))
           {
                valid++;
                if(Book.bookCollection.containsKey(book_isbn))
                {
                        valid++;
                        if(Book.bookCollection.get(book_isbn).getQuantity()<=0)
                        {
                                System.out.println("***************************");
                                System.out.println("No Books available of this type");
                        }
                        else{
                                Patron.patronCollection.get(patron_id).borrowedBooks.add(book_isbn);
                                Book.bookCollection.get(book_isbn).setQuantity(-1);
                                System.out.println("***************************");
                                System.out.println("Book Borrowed Successfully..!");
                        }
                }
           }
           try{
                if(valid==0)
                {
                        throw new MyException("Trying to Borrow Book which isn't available..!");
                }
                else{
                        if(valid==1){
                                throw new MyException("Patron found but No Book with given ID.. ");
                        }
                }
           }
           catch(MyException e)
           {
                System.out.println("***************************");
                System.out.println(e.getMessage());
           }
        //    if(valid==0)
        //    {
        //         System.out.println("Patron Not Found");
        //    }
        //    else{
        //         if(valid==1){System.out.println("Patron found but No Book with given ID.. ");}
        //    }
        }

        public void returnBook()
        {
                Scanner re_book = new Scanner(System.in);
                System.out.println("Enter patron ID :");
                int patron_id=re_book.nextInt();
                System.out.println("Enter Book ISBN :");
                Long book_isbn=re_book.nextLong();
                int valid=0;
                if(Patron.patronCollection.containsKey(patron_id))
                {
                        valid++;
                        if(Book.bookCollection.containsKey(book_isbn))
                        {
                                valid++;
                                int index=Patron.patronCollection.get(patron_id).borrowedBooks.indexOf(book_isbn);
                                Book.bookCollection.get(book_isbn).setQuantity(1);
                                Patron.patronCollection.get(patron_id).borrowedBooks.remove(index);
                                System.out.println("***************************");
                                System.out.println("Book Returned Successfully...!");
                        }
                }
                if(valid==0)
                {
                        System.out.println("***************************");
                        System.out.println("Patron Not found");
                }
                else{
                        if(valid==1)
                        {
                                System.out.println("***************************");
                                System.out.println("Book Not Found");
                        }
                }

        }
}
