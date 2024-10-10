//searching if element is present or not
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
public class basic2{
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
    public static int checkifpresent(Node head,int val)//searching if element is present or not
    {
        Node temp = head;
        while(temp!=null){
            if (temp.data == val)
            {
                return 1;
            }
            temp = temp.next;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = {2,5,6,8};
        Node head = convert2ll(arr);
    
        System.out.println(checkifpresent(head,6));
    }

}