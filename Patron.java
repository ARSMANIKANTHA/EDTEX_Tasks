import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Patron{
    private String name;
    private int id;
    ArrayList<Long> borrowedBooks = new ArrayList<>();
    public static HashMap<Integer,Patron> patronCollection = new HashMap<>();
    //Default constructor
    Patron(){}

    //Get Methods for patron
    public String getName(){return this.name;}
    public int getId(){return this.id;}
    public ArrayList<Long> getBorrowedBooks(){return this.borrowedBooks;}

    //Set Methods for Patron
    public void setName(String name){this.name=name;}
    public void setId(int id){this.id=id;}

    //Patron Methods
    public void addPatron()
    {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter Patron Name :");
        this.setName(scan1.nextLine());
        System.out.println("Enter patron ID:");
        int actual_id=scan1.nextInt();
        if(patronCollection.containsKey(actual_id))
        {
            System.out.println("The Patron already exists!!!");
        }
        else{
            this.setId(actual_id);
            patronCollection.put(this.getId(),this);
        } 
    }

    public static void removePatron()
    {
        Scanner scan1 = new Scanner(System.in);
        int id,k=0;
        System.out.println("Enter Paton ID:");
        id=scan1.nextInt();
        for(int i:patronCollection.keySet()){
            if(i==id)
            {
                patronCollection.remove(i);
                k=k+1;
                break;
            }
        }
        if(k==0)
        {
            System.out.println("No Patron with Such ID");
        }
    }
    public static void displayPatrons()
    {
        System.out.println("List of Patrons:");
        System.out.print("[ ");
        for(int i:patronCollection.keySet())
        {
            System.out.print(patronCollection.get(i).getName()+"(ID:"+patronCollection.get(i).getId()+"),");
        }
        System.out.println("]");
    }
}
