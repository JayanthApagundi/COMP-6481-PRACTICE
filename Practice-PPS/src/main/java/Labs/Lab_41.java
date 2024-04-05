package Labs;
import java.util.Scanner;

// Need to refactor
class Carpet implements Cloneable{
    private static int count=0;
    protected int tagNumber=0;
    protected double price;
    protected double weight;
    protected String countryOfProductions;
    protected int year;

    public Carpet(double price){
        this.price=price;
        count++;
        tagNumber=count;
        //System.out.println("We are in A");
    }

    public Carpet(Carpet obj){
        this.price=obj.price;
        //this.tagNumber = obj.tagNumber;
    }

    public void toString(Carpet obj){
        System.out.println(obj.price + " " + obj.tagNumber);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Carpet cloned=new Carpet(this);
        return cloned;
    }
}

class MachineMadeCarpet extends Carpet{

    public MachineMadeCarpet(double price, double weight){
        super(price);
        this.price=price;
        this.weight=weight;
    }

    public MachineMadeCarpet(Carpet obj){
        super(obj.price);
        this.price=obj.price;
        this.weight=obj.weight;
    }

    public void toString(Carpet obj){
        System.out.println(obj.price + " " +obj.weight + " "+ obj.tagNumber);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MachineMadeCarpet cloned=new MachineMadeCarpet(this);
        return cloned;
    }
}

class HandMadeCarpet extends Carpet{
    public HandMadeCarpet(double price, String countryOfProduction){
        super(price);
        this.price=price;
        this.countryOfProductions=countryOfProduction;
    }

    public HandMadeCarpet(Carpet obj){
        super(obj.price);
        this.price=obj.price;
        this.countryOfProductions=obj.countryOfProductions;
    }

    public void toString(Carpet obj){
        System.out.println(obj.price + " " +obj.countryOfProductions + " "+ obj.tagNumber);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        HandMadeCarpet cloned=new HandMadeCarpet(this);
        return cloned;
    }
}


class AntiqueCarpet extends Carpet{
    public AntiqueCarpet(double price,String countryOfProduction,int year){
        super(price);
        this.price=price;
        this.countryOfProductions=countryOfProduction;
        this.year=year;
    }

    public AntiqueCarpet(Carpet obj){
        super(obj.price);
        this.price=obj.price;
        this.countryOfProductions=obj.countryOfProductions;
        this.year=obj.year;
    }

    public void toString(Carpet obj){
        System.out.println(obj.price + " " +obj.countryOfProductions + " "+ obj.year+ " " + obj.tagNumber);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        AntiqueCarpet cloned=new AntiqueCarpet(this);
        return cloned;
    }
}

public class Lab_41 {

    public static Carpet[] duplicateStore(Carpet[] Original) throws CloneNotSupportedException {
        Carpet[] duplicate=new Carpet[Original.length];
        for(int i=0;i< Original.length;i++){
            duplicate[i]=(Carpet) Original[i].clone();
        }
        return duplicate;
    }


    public static void main(String[] args) throws CloneNotSupportedException {

        Scanner input=new Scanner(System.in);
        int inventorySize=input.nextInt();

        Carpet[] arrayOfCarpet=new Carpet[inventorySize];

        int noOfCarpet=input.nextInt();
        for(int i=0;i<noOfCarpet;i++){
            double price=input.nextDouble();
            int loc= input.nextInt();
            arrayOfCarpet[loc]=new Carpet(price);
        }

        int noMachineMadeCarpet=input.nextInt();
        for(int i=0;i<noMachineMadeCarpet;i++){
            double price=input.nextDouble();
            double weight=input.nextDouble();
            int loc= input.nextInt();
            arrayOfCarpet[loc]=new MachineMadeCarpet(price,weight);
        }

        int noHandMadeCarpet=input.nextInt();
        for(int i=0;i<noHandMadeCarpet;i++){
            double price=input.nextDouble();
            String countryOfProduction=input.next();
            int loc= input.nextInt();
            arrayOfCarpet[loc]=new HandMadeCarpet(price,countryOfProduction);
        }

        int noAntiqueCarpet=input.nextInt();
        for(int i=0;i<noAntiqueCarpet;i++){
            double price=input.nextDouble();
            String countryOfProduction=input.next();
            int year=input.nextInt();
            int loc= input.nextInt();
            arrayOfCarpet[loc]=new AntiqueCarpet(price,countryOfProduction,year);
        }

        for(int i=0;i<inventorySize;i++){
            arrayOfCarpet[i].toString(arrayOfCarpet[i]);
        }

        Carpet[] dupArrayOfCarpet = new Carpet[inventorySize];
        dupArrayOfCarpet=duplicateStore(arrayOfCarpet);

        for(int i=0;i<inventorySize;i++){
            dupArrayOfCarpet[i].toString(dupArrayOfCarpet[i]);
        }
    }
}