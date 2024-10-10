// implementing the traversal problem DFS - inorder
//left -> root -> right

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
class Inorder{
    // function for inoder traverse
    private static void inorder(Node root , List<Integer> arr)
    {
        if(root==null){
            return;
        }
        inorder(root.left,arr);// traverse all left side
        arr.add(root.data);
        inorder(root.right,arr);// traverse all the right side
    }
    private static List<Integer> inOrder(Node root)
    {
        List<Integer> arr = new ArrayList<>();
        inorder(root , arr);
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
        System.out.println(inOrder(root));
    }
}
