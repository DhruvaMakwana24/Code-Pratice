//execpt head any node can be deleted
import java.lang.*;
import java.util.*;
import java.io.*;

class Node
{

    int data;
    Node next;
    Node back;

    Node(int data1){
        this.data = data1;
        this.next = null;
        this.back = null;
    }

    Node(int data1,Node next1,Node back1) 
    {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }
}
 

class Inserthead
{

    private static Node convert2ddl(int[] arr)
    {
        Node head = new Node(arr[0]);
        Node prev = head;
        int i;
        for ( i=1;i<arr.length; i++){
            Node temp = new Node(arr[i],null,prev);
            prev.next = temp;
            prev = temp;
            }
            return head;
        }
    private static Node inserthead (Node head , int val)
    {
        Node newhead = new Node(val , head , null);
        head.back = newhead;
        return newhead;
    }
     private static void print(Node head)
     {
        while(head!= null)
        {
            System.out.print(head.data+ " ");
            head = head.next;
        } 
     }
    public static void main(String args[])
    {
         int[] arr = {2,5,6,8,10};
         Node head = convert2ddl(arr);
         head = inserthead(head , 1);
         print(head);
    }
}