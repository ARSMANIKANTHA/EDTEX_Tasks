import java.util.HashMap;
import java.util.Scanner;

public class Book {
    //Instance variables for class Book(Such as Book Title,Author,ISBN,Quantity)
    private String title;
    private String author;
    private long ISBN;
    private int quantity;
    public static HashMap<Long,Book> bookCollection=new HashMap<>();

    Book(){}
    //Getter Methods for Getting Private Instance variables
    public String getTitle(){return this.title;}
    public String getAuthor(){return this.author;}
    public long getISBN(){return this.ISBN;}
    public int getQuantity(){return this.quantity;}

    //Setter Methods for setting values to the private Instance Vraibles
    public void setTitle(String title){this.title=title;}
    public void setAuthor(String author){this.author=author;}
    public void setISBN(long ISBN){this.ISBN=ISBN;}
    public void setQuantity(int quantity){this.quantity+=quantity;}

    //Book Methods
    //Add Book method is used to add Book to the Library with all necessary Fields
    public void addBook()
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Book Title:");
        this.setTitle(scan.nextLine());
        System.out.println("Enter Book Author Name");
        this.setAuthor(scan.nextLine());
        System.out.println("Enter Book ISBN Number");
        Long s=scan.nextLong();
        if(bookCollection.containsKey(s))
        {
            System.out.println("***************************");
            System.out.println("The Book already Exists..!");
        }
        else{
            this.setISBN(s);
            System.out.println("Enter Book Qunatity");
            int findqty=scan.nextInt();
            if(findqty<=0)
            {
                System.out.println("***************************");
                System.out.println("Unable to add!!...You should add atleast one book...");
            }
            else{
                this.setQuantity(findqty);
                bookCollection.put(this.getISBN(),this);
                System.out.println("***************************");
                System.out.println("Book Added Successfully...!");
            }
        }
    }

    //Remove Book method is used to remove a book using ISBN number
    public static void removeBook()
    {
        int abc=0;
       Scanner scan=new Scanner(System.in);
       System.out.println("Enter ISBN Number");
       long ISBN1= scan.nextLong();
       for(Long i:bookCollection.keySet())
       {
            if(i==ISBN1)
            {
                bookCollection.remove(i);
                Fiction.ficbookCollection.remove(i);
                NonFiction.nonficbookCollection.remove(i);
                System.out.println("Book removed successfully...!");
                abc++;
                break;
            }
       }
       if(abc==0)
       {
        System.out.println("***************************");
        System.out.println("No Book with Such ISBN number");
       }
    }

    //DisplayBook Method is used to print Availble Books to the user.
    public static void displayBooks()
    {
        System.out.println("***************************");
        System.out.println("List of Books :");
        System.out.print("[ ");
        for(Long i:bookCollection.keySet())
        {
            // System.out.println(i);
            System.out.print(bookCollection.get(i).getTitle()+"(ISBN:"+bookCollection.get(i).getISBN()+")->"+bookCollection.get(i).getQuantity()+",");
        }
        System.out.println("]");
    }    
}
