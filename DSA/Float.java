////find the ceiling value for the given element float element <= element
import java.lang.*;
import java.util.*;
import java.io.*;

class TreeNode{
    int data;
    TreeNode left,right;
    TreeNode(int data)
    {
        this.data = data;
        right=left= null;
    }
}
class Float{
    public static int findFloat(TreeNode root,int key)
    {
        int floatval = -1;
        if(root == null)
        {
            return floatval;
        }
        while(root != null)
        {
            if(root.data == key)
            {
                floatval = key;
                return floatval;
            } 
            if(key > root.data)
            {
                floatval = root.data;
                root = root.right;
            }
            else{
                root=root.left;
            }

        }
        return floatval;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);
        int result =findFloat(root,8);
        System.out.println("The float value of given element is "+result);
    }

}