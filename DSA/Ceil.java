//find the ceiling value for the given element ceil element >= element
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
class Ceil{
    public static int findCeil(TreeNode root , int key)
    {
        int ceil = -1;
        if(root == null){
            return ceil;
        }
        while(root!= null)
        {
            if (root.data == key)
            {
                ceil = key;
                return ceil;
            }
            if (root.data < key)
            {
                root = root.right;
            }
            else{
                ceil= root.data;
                root = root.left;
            }
        }
        return ceil;
    }
    public static void main(String args[])
    {
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
        int result = findCeil(root,8);
        System.out.println("ceil value of given key is "+result);
    }
}