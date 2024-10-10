// t(n) = N , s(n) = 1
// using same ll
import java.lang.*;
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;

    Node(int data1){
        this.data=data1;
        this.next = null;
    }

    Node (int data1, Node next1)
    {
        this.data = data1;
        this.next = next1;
    }

}
class reversell{
    private static Node create2ll(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1;i<arr.length;i++)
        {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = mover.next;
        }
        return head;
    }
    private static Node reversell(Node head){
        Node temp = head;
        Node prev = null;
        while (temp != null)
        {
            Node front = temp.next ; 
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    private static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        
    }
    public static void main(String[] args){
         int[] arr = {2,5,6,8};
         Node head = create2ll(arr);
         head = reversell(head);
         print(head);
    }
}