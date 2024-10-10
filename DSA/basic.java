//intialisation and coverting array into linked list
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
public class basic{
    private static Node convert2ll(int[] arr)//converting the array to linklist
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
    public static void main(String[] args) {
        int[] arr = {2,5,6,8};
        Node y= new Node(arr[3]);
        System.out.println(y.data);
        convert2ll(arr);
    }

}