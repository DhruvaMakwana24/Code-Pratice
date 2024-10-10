// implementing the traversal DFS -postorder
// left -> right -> root

import java.lang.*;
import java.util.*;
import java.io.*;

class Node{
  int data;
  Node left, right;
  Node(int data){
    this.data = data;
    this.left = null;
    this.right = null;
    }
}
class Postorder{
    // function for inoder traverse
    private static void postorder(Node root , List<Integer> arr)
    {
        if(root==null){
            return;
        }
        postorder(root.left,arr);// traverse all left side
        postorder(root.right,arr);// traverse all the right side
        arr.add(root.data);
        
    }
    private static List<Integer> postOrder(Node root)
    {
        List<Integer> arr = new ArrayList<>();
        postorder(root , arr);
        return arr;
    }
    public static void main(String[] args) 
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        System.out.println(postOrder(root));
    }
}
