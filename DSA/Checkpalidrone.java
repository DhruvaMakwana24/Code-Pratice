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
class Checkpalidrone{
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
    private static Node reverse(Node head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        Node newHead = reverse(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    private static boolean checkpalidrone(Node head){
       if (head.next == null || head.next.next == null){
         return true;
       }
       Node slow = head;
       Node fast = head;
       while(fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
       }
       Node newhead = reverse(slow.next);
       Node second =newhead;
       Node first = head;
       while(second != null){
        if (first != second){
              reverse(newhead);
              return false;
        }
        first = first.next;
        second = second.next;
       }
       reverse(newhead);
       return true;
    }
    private static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
        
    public static void main(String args[]){
        int[] arr1 = {1,2,2,1};
        int[] arr2 = {1,2,3,1,2};
        Node head1 =  create2ll(arr1);
        Node head2 = create2ll(arr2);
        boolean result1 = checkpalidrone(head1);
        boolean result2 = checkpalidrone(head2);
        System.out.println(result1);
        System.out.println(result2);

    }
}