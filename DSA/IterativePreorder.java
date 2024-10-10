// implementing the preorder traversal using the stack
// time complexity: O(N);
// space complexity: O(N);
// root -> left -> right

import java.lang.*;
import java.util.*;
import java.io.*;

class TreeNode{
   int data;
   TreeNode left;
   TreeNode right;
   
   TreeNode(){
      data = 0;
      left = right = null; 
   }
   TreeNode(int data){
    this.data = data;
    left = right = null;
   }
   TreeNode(int data, TreeNode left, TreeNode right){
    this.data = data;
    this.left = left;
    this.right = right;
   }
}
// created different class for the perorder function
class Preorder{
    // returns the list as the return value
  public List<Integer> preorder(TreeNode root){
    // to store the perorder traversal data
    List<Integer> result = new ArrayList<Integer>();
    if(root == null){
        return result;
    }
    // to store the traversed value into stack
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while(!stack.isEmpty()){
        TreeNode temp = stack.pop();// stores the top i.e root
         result.add(temp.data);// adds the data to result list
         // push the node if they are childern of the temp
        if(temp.right != null)
        {
            stack.push(temp.right);
        }
        if(temp.left != null)
        {
            stack.push(temp.left);
        }  
    }
    return result;
  }
}
class IterativePreorder{
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        Preorder p = new Preorder();
        List<Integer> result = p.preorder(root);
        System.out.println(result);
    }
}