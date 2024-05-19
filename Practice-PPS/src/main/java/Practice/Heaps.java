package Practice;

class Heap{
    int[] arr;
    int size;
    int capacity;

    public Heap(int capacity){
        this.capacity=capacity;
        this.size=0;
        this.arr=new int[capacity];
    }

    public int getParent(int i){
        return (i-1)/2;
    }

    public int getLeftChild(int i){
        return (2*i)+1;
    }

    public int getRightChild(int i){
        return (2*i)+2;
    }

    public void insert(int data){
        if(size==capacity){
            System.out.println("Heap is full");
            return;
        }
        size++;
        arr[size-1]=data;
        for(int i=size-1;i!=0 && arr[getParent(i)]>arr[i];){
            int temp=arr[i];
            arr[i]=arr[getParent(i)];
            arr[getParent(i)]=temp;
            i=getParent(i);
        }
    }

    public void minHeapify(int i){
        int left=getLeftChild(i);
        int right=getRightChild(i);
        int smallest=i;
        if(left<size && arr[left]<arr[i]){
            smallest=left;
        }
        if(right<size && arr[right]<arr[smallest]){
            smallest=right;
        }
        if(smallest!=i){
            int temp=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=temp;
            minHeapify(smallest);
        }
    }

    public int extractMin(){
        if(size==0){
            return Integer.MAX_VALUE;
        }
        if(size==1){
            size--;
            return arr[0];
        }
        int temp=arr[0];
        arr[0]=arr[size-1];
        size--;
        minHeapify(0);
        return temp;
    }

//    public void decreaseKey(int i, int new_val){
//        arr[i]=new_val;
//        while(i!=0 && arr[getParent(i)]>arr[i]){
//            int temp=arr[i];
//            arr[i]=arr[getParent(i)];
//            arr[getParent(i)]=temp;
//            i=getParent(i);
//        }
//    }

    public void deleteKey(int i){
        //decreaseKey(i, Integer.MIN_VALUE);
        //extractMin();
        if (i >= size) {
            System.out.println("Invalid index");
            return;
        }

        // Replace the key to be deleted with the last key
        arr[i] = arr[size - 1];
        size--;

        // Perform minHeapify operation from the index i
        minHeapify(i);
    }

    public void display(){
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public int[] HeapSort(){
        int[] sortedArray = new int[size];
        int n=size;
        // Build the heap
        for (int i = n/2 - 1; i >= 0; i--) {
            minHeapify(i);
        }
        // Extract elements from the heap in sorted order
        for (int i = 0; i < n; i++) {
            sortedArray[i] = extractMin();
        }
        return sortedArray;
    }
}


public class Heaps {
    public static void main(String[] args) {
        Heap heap= new Heap(24);
        heap.insert(20);
        heap.display();
        heap.insert(12);
        heap.display();
        heap.insert(35);
        heap.display();
        heap.insert(19);
        heap.display();
        heap.insert(7);
        heap.display();
        heap.insert(10);
        heap.display();
        heap.insert(15);
        heap.display();
        heap.insert(24);
        heap.display();
        heap.insert(16);
        heap.display();
        heap.insert(39);
        heap.display();
        heap.insert(5);
        heap.display();
        heap.insert(19);
        heap.display();
        heap.insert(11);
        heap.display();
        heap.insert(3);
        heap.display();
        heap.insert(27);
        heap.display();

        System.out.println("============================================");

        heap.extractMin();
        heap.display();
        heap.extractMin();
        heap.display();
        heap.extractMin();
        heap.display();
        heap.extractMin();
        heap.display();
        heap.extractMin();
        heap.display();
        heap.extractMin();
        heap.display();

        System.out.println("============================================");

        heap.insert(20);
        heap.display();
        heap.insert(12);
        heap.display();
        heap.insert(35);
        heap.display();
        heap.insert(19);
        heap.display();
        heap.insert(7);
        heap.display();
        heap.insert(10);
        heap.display();
        heap.insert(15);
        heap.display();
        heap.insert(24);
        heap.display();
        heap.insert(16);
        heap.display();
        heap.insert(39);
        heap.display();
        heap.insert(5);
        heap.display();
        heap.insert(19);
        heap.display();
        heap.insert(11);
        heap.display();
        heap.insert(3);
        heap.display();
        heap.insert(27);
        heap.display();
    }
}
