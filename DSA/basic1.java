
class Node{
    int data;
    Node next;

    Node(int data1,Node next1){
        this.data = data1;
        this.next = next1;

    }

    Node(int data1){
        this.data = data1;
        this.next = null;
    }
};
public class basic1{
    private static Node convert2ll(int[] arr)
    {
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1;i<arr.length;i++){
          Node temp = new Node(arr[i]);
          mover.next = temp;
          mover = mover.next;
        }
        return head;
    }
    public static int lengthofll(Node head)//function for counting length
    {
        int count = 0;
        Node temp = head;
        while(temp!=null){
            temp =temp.next;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {2,5,6,8};
        Node head = convert2ll(arr);
        //this is used for traversing the linked list 
        // Node temp = head;
        // while(temp!=null) {
        //     System.out.println(temp.data + " ");  
        //     temp = temp.next;
        // }
        int length=lengthofll(head);
        System.out.println(length);


    }

}