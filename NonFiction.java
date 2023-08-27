import java.util.HashMap;

public class NonFiction extends Book{
    private String title;
    private String author;
    private long ISBN;
    private int quantity;
    public static HashMap<Long,NonFiction> nonficbookCollection = new HashMap<>();

    NonFiction(Book obj)
    {
        this.title=obj.getTitle();
        this.author=obj.getAuthor();
        this.ISBN=obj.getISBN();
        this.quantity=obj.getQuantity();
    }
    //Getter Methods for results
    public String getNonFicTitle(){return this.title;}
    public String getNonFicAuthor(){return this.author;}
    public long getNonFicISBN(){return this.ISBN;}
    public int getNonFicQuantity(){return this.quantity;}

    //Setter Methods for setting values to the private members
    public void setNonFicTitle(String title){this.title=title;}
    public void setNonFicAuthor(String author){this.author=author;}
    public void setNonFicISBN(long ISBN){this.ISBN=ISBN;}
    public void setNonFicQuantity(int quantity){this.quantity+=quantity;}

    public void addNonFicBook()
    {
        System.out.println("***************************");
        System.out.println("Non Fiction Book added Successfully...!");
        nonficbookCollection.put(this.getNonFicISBN(),this);
    }

    public static void printNonFicBooks()
    {
        if(nonficbookCollection.isEmpty())
        {
            System.out.println("***************************");
            System.out.println("Non-fiction Books Not available..!");
        }
        else{
                System.out.print("[ ");
                for(Long i:nonficbookCollection.keySet())
                    System.out.print(nonficbookCollection.get(i).getNonFicTitle()+"->("+nonficbookCollection.get(i).getNonFicQuantity()+"),");
                System.out.print("]");
        }
            
    }
}
