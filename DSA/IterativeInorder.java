// alternative for recursive inorder traversing using stack
// Time complexity : O(n)
// Space complexity : O(n)
import java.lang.*;
import java.util.*;
import java.io.*;

class TreeNode{
  int data;
  TreeNode left;
  TreeNode right;

  TreeNode()
  {
    data = 0;
    left = null;
    right = null;
  }
  TreeNode(int data)
  {
    this.data = data;
    left = null;
    right = null;
  }
  TreeNode(int data,TreeNode left,TreeNode right){
    this.data = data;
    this.left = left;
    this.right = right;
  }
}
class IterativeInorder{
    public static List<Integer> inorder(TreeNode root)
    {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while(true){
        // traverse and pushs the element to left till it reaches the null node
        if (current != null){
            stack.push(current);
            current = current.left;
        }
        else{
            // if current is null then pop the element from the stack and print it
            if(stack.isEmpty())
            {
                break;
            }
            current = stack.pop();
            result.add(current.data);
            // once all the left and root are pop it will traverse to right nodes
            current = current.right;
        }
        }
        return result;

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        List<Integer> result = inorder(root);
        System.out.println(result);
    }
}