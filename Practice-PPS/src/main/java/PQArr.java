// PQ using an Array

class ArrPriQue{
    int[] array;
    int size;
    final int DEFAULT_SIZE=10;

    public ArrPriQue(){
        array=new int[DEFAULT_SIZE];
        size=0;
    }

    public ArrPriQue(int s){
        size=s;
        array=new int[size];
        size=0;
    }

    public void resize(){
        int[] newArr=new int[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArr[i]=array[i];
        }
        array=newArr;
        //System.out.println(array.length);
    }
    public void insert(int v){
        if(size==array.length){
            resize();
        }
        int index=size;
        while (index>0 && v<array[index-1]){
            array[index]=array[index-1];
            index--;
        }
        array[index]=v;
        size++;
    }

    public int remove(){
        if(isEmpty()){
            System.out.println("PQ is empty !!!");
            return -1;
        }
        int remove=array[0];
        for (int i = 1; i < size; i++) {
            array[i-1]=array[i];
        }
        size--;
        return remove;
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }

    public void display(){
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println(" ");
    }

    public int size(){
        return size;
    }

}

public class PQArr {
    public static void main(String[] args) {

        ArrPriQue PriQue=new ArrPriQue(5);
        PriQue.insert(300);
        PriQue.insert(10);
        PriQue.insert(34);
        PriQue.insert(56);
        PriQue.insert(45);
        PriQue.insert(89);
        PriQue.insert(47);
        PriQue.insert(95);
        PriQue.insert(43);
        PriQue.insert(12);
        PriQue.insert(17);
        PriQue.insert(19);
        PriQue.insert(200);
        PriQue.display();
        System.out.println(PriQue.remove());
        System.out.println(PriQue.remove());
        System.out.println(PriQue.size());
        PriQue.display();
        System.out.println(PriQue.size());

        //check for commit

    }
}