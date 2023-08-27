import java.util.HashMap;

public class Fiction extends Book {
    private String title;
    private String author;
    private long ISBN;
    private int quantity;
    public static HashMap<Long,Fiction> ficbookCollection = new HashMap<>();

    Fiction(Book obj)
    {
        this.title=obj.getTitle();
        this.author=obj.getAuthor();
        this.ISBN=obj.getISBN();
        this.quantity=obj.getQuantity();
    }
    //Getter Methods for results
    public String getFicTitle(){return this.title;}
    public String getFicAuthor(){return this.author;}
    public long getFicISBN(){return this.ISBN;}
    public int getFicQuantity(){return this.quantity;}

    //Setter Methods for setting values to the private members
    public void setFicTitle(String title){this.title=title;}
    public void setFicAuthor(String author){this.author=author;}
    public void setFicISBN(long ISBN){this.ISBN=ISBN;}
    public void setFicQuantity(int quantity){this.quantity+=quantity;}

    public void addFicBook()
    {
        ficbookCollection.put(this.getFicISBN(),this);
    }

    public static void printFicBooks()
    {
        if(ficbookCollection.keySet().isEmpty())
        {
            System.out.println("***************************");
            System.out.println("Fiction Books Not Available");
        }
        else{
            System.out.println("***************************");
            System.out.println("List of available fiction Books:");
            System.out.print("[ ");
            for(Long i:ficbookCollection.keySet())
                System.out.print(ficbookCollection.get(i).getFicTitle()+"->("+ficbookCollection.get(i).getFicQuantity()+"),");
            System.out.print("]");
        }
    }

    
}
