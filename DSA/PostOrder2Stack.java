// alternative for recursive postorder traversing using  2 stack
// Time complexity : O(n)
// Space complexity : O(2n)
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
class PostOrder2Stack{
    public static List<Integer> postorder(TreeNode root)
    {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        if(root == null)
        {
            return result;
        }
        stack1.push(root);
        while(!stack1.isEmpty()){
            root = stack1.pop();
            stack2.push(root);
            if(root.left != null){
                stack1.push(root.left);
            }
            if(root.right != null){
                stack1.push(root.right);
            }
        }
        while(!stack2.isEmpty())
        {
            result.add(stack2.pop().data);
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
        List<Integer> result = postorder(root);
        System.out.println(result);
    }
}