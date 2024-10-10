//inserting before the tail in ddl
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



class Insertk
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
    private static Node insertk (Node head ,int k ,int val)
    {
        if (k == 1){
            return inserthead(head,val);
        }
        Node temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            if (count == k){
                break;
            }
            temp = temp.next;
        }

        Node prev = temp.back;
        Node knode = new Node(val,temp,prev);
        if (prev != null) {
            prev.next = knode;
        } else {
            head = knode;
        }
        temp.back = knode;
        return head;
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
         head = insertk(head,5,1);
         print(head);
    }
}