import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class intersection {
    private static Node insertNode(Node head, int val) {
        if (head == null) {
            return new Node(val);
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
        return head;
    }

    private static Node findIntersection(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != temp2) {
            temp1 = (temp1 == null) ? head2 : temp1.next;
            temp2 = (temp2 == null) ? head1 : temp2.next;
        }
        return temp1;
    }

    public static void main(String[] args) {
        Node head1 = null;
        Node head2 = null;

        head1 = insertNode(head1, 1);
        head1 = insertNode(head1, 3);
        head1 = insertNode(head1, 1);
        head1 = insertNode(head1, 2);
        head1 = insertNode(head1, 4);
        Node intersectionNode = head1.next.next.next; 

        head2 = insertNode(head2, 1);
        head2.next = intersectionNode;

        Node result = findIntersection(head1, head2);
        if (result != null) {
            System.out.println("Intersection point data: " + result.data);
        } else {
            System.out.println("No intersection point.");
        }
    }
}
