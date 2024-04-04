import java.util.Scanner;

// Normal Tree
class BinaryTree{
    class Node{
        int value;
        Node left;
        Node right;

        public Node(int v){
            value=v;
            left=null;
            right=null;
        }
    }

    Node root;
    public BinaryTree(){
        root=null;
    }

    public void populate(Scanner scanner){
        System.out.println("Enter the root node");
        int v=scanner.nextInt();
        root =new Node(v);
        populate(scanner, root);
    }

    public void populate(Scanner scanner, Node node){
        System.out.println("Do you want to enter left of "+ node.value);
        boolean left=scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of left node");
            int v=scanner.nextInt();
            node.left=new Node(v);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter right of "+ node.value);
        boolean right=scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of right node");
            int v=scanner.nextInt();
            node.right=new Node(v);
            populate(scanner, node.right);
        }
    }

    public void display(){
        display(root,0);
    }

    public void display(Node node, int level){
        if(node==null){
            return;
        }

        display(node.right,level+1);
        if(level!=0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|--->"+node.value);
        } else{
            System.out.println(node.value);
        }
        display(node.left,level+1);
    }

}

public class BinTree {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        BinaryTree tree=new BinaryTree();
        tree.populate(scanner);
        tree.display();
    }
}