// implementing the tree DFS (preorder) traversal
//Root -> left -> right 
import java.lang.*;
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        this.left = this.right = null;
        }
}
class Preorder{
    // helps in the peroder traversing 
    static void preorder(Node root,List<Integer> arr){
        //basecase
        if(root == null){
            return;
        }
        arr.add(root.data);
        // traverses the leftside
        preorder(root.left,arr);
        //traverses the rightside
        preorder(root.right,arr);
    }
    public static List<Integer> preOrder(Node root){
        //helps to store the value in the arr while traverseing
        List<Integer> arr = new ArrayList<>();
        preorder(root,arr);
        // returns the resultant arr after the preorder traversing
        return arr;
        
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        
        System.out.println(preOrder(root));

    }
}