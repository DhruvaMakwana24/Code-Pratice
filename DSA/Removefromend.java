// remove the nth node from the end
// brute force t(n) = 2*length - N; s(n) = (1) by cnt approch where cnt = 0 and the reference will point to cnt-n 
// and   cnt-n -> next will be deleted
// optimal solution - T(n) = len s(n)=1

//using recursion
//Time Complexity: O(n)
//Space Complexity: O(n)
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
class Removefromend{
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
    private static Node removeNthFromEnd(Node head, int n) {
         Node fast = head;
         Node slow = head;
         for (int i = 0; i < n ; i++)
         {
            fast = fast.next;
         }
         if (fast == null){
            return head.next;
         }
         while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
         }
         Node deleteNode = slow.next;
         slow.next = slow.next.next;
         return head;
         
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
         head = removeNthFromEnd(head , 3);
         print(head);
    }
}
