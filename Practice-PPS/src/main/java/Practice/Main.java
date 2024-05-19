package Practice;

abstract class Animal{
    public boolean getIsMammal(){
        return true;
    }
    public boolean getIsCarnivorous(){
        return false;
    }
    public abstract String getGreeting();
}

class Dog extends Animal{
    public Dog(){

    }
    public String getGreeting(){
        return "Woof";
    }
}

class cow extends Animal{
    public cow(){

    }
    public String getGreeting(){
        return "Moo";
    }
}

class Duck extends Animal{
    public Duck(){

    }
    public String getGreeting(){
        return "Quack";
    }
}

public class Main {
    public static void main(String[] args) {

    }
}