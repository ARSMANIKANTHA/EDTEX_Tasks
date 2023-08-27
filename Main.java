import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        int option;
        while(true){
            //Creating a Book Object                
            Book newBook = new Book();
            Patron newPatron = new Patron();
            Library lib= new Library();
            System.out.println("********************");
            System.out.println("1.Add a New Book \n2.Remove a Book\n3.Display Available Books\n4.Add a New Patron\n5.Remove a Patron\n6.Display Patrons\n7.Borrow Book\n8.Return Book\n9.PrintFicBooks\n10.PrintNonFicBooks\n11.Exit");
            System.out.println("Enter Your Option:");
            option=scan1.nextInt();
            switch(option)
            {
                case 1:
                System.out.println("Is it a fiction Book?(true or false) :");
                Boolean fiction=scan1.nextBoolean();
                       if(fiction)
                       {
                        newBook.addBook();
                        Fiction newFicBook = new Fiction(newBook);
                        newFicBook.addFicBook();
                        }
                       else
                       {
                        newBook.addBook();
                        NonFiction newnNonFicBook= new NonFiction(newBook);
                        newnNonFicBook.addNonFicBook();
                       }
                        break;
                case 2:Book.removeBook();
                        break;
                case 3:Book.displayBooks();
                        break;
                case 4:newPatron.addPatron();
                        break;
                case 5:Patron.removePatron();
                        break;
                case 6:Patron.displayPatrons();
                        break;
                case 7:lib.borrow();
                        break;
                case 8:lib.returnBook();
                        break;
                case 9:Fiction.printFicBooks();
                        break;
                case 10:NonFiction.printNonFicBooks();
                       break;
                case 11: System.exit(0);
                        break;
                default:System.out.println("Nothing....bye!!!");
            }
        }
    }
}
