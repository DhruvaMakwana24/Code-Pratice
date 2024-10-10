//rotate linked list by k
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
class Rotatell{
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

    private static Node rotate(Node head, int k){
        if(head == null || head.next == null || k == 0)
        {
            return head;
        }
        int length= 1 ;
        Node temp = head;
        while (temp.next != null)
        {
           length++;
           temp = temp.next;
        }
        if (k % length == 0){
            return head;
        }
        k = k % length;
        temp.next = head;
        Node newtail = findthenode(head, length-k);
        head = newtail.next;
        newtail.next = null;
        return head;
    }
    private static Node findthenode(Node head , int n)
    {
        Node temp = head;
        int cnt = 1;
        while(temp != null)
        {
            if (cnt == n)
            {
                return temp;
            }
            cnt++;
            temp = temp.next;
        }
        return temp;
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
         head = rotate(head,2);

         print(head);
    }
}