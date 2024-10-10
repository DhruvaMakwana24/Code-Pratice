// searhing the element present in Bst
import java.lang.*;
import java.util.*;
import java.io.*;

class TreeNode{
   int data;
   TreeNode left, right;
   public TreeNode(int data) 
   {
     this.data = data;
     left = null;
     right = null;
   }
   public TreeNode(int data , TreeNode left,TreeNode right)
   {
     this.data=data;
     this.left=left;
     this.right=right;
   }
}

class Search{
    public static TreeNode search(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        while(root != null && root.data != key){
            root = key < root.data  ? root.left : root.right;
        }
        return root;
    }
    public static void printtree(TreeNode root){
        if(root == null)
        {
            return;
        }
        printtree(root.left);
        System.out.print(root.data + " ");
        printtree(root.right);  
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);
        System.out.println("Tree elements are: ");
        printtree(root);
        System.out.println("\nSearching for 6 in the tree:");
        TreeNode result = search(root, 6);
        if(result != null)
        {
            System.out.println("Element found in the tree");
        }
          
    }
}