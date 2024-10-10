//insersion 
//-of head node 
//-of last node
//-of kth node
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
public class operationll1{
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
    private static Node inserthead (Node head ,int val)
    {
        Node temp = new Node(val, head);
        return temp;
    }
    private static Node insertlast(Node head,int val){
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
            }
            Node newnode = new Node(val,null);
            temp.next = newnode;
            return head;
    }
    private static Node insertkth(Node head,int val,int k)
    {
        if (head == null){
           if (k == 1)
           {
              return(inserthead);
           }
            else {
                return head;
            }
        }
        if (k == 1)
        {
            return(inserthead);
        }
        int cnt = 0;
        Node temp = head;
        while(temp.next != null)
        {
            cnt++;
            if(cnt == k-1)
            {
                Node n = new Node(val,temp.next);
            }
            temp.next = n;
            temp = temp.next;
        }
    }
    private static void print(Node head)
    {
        Node temp = head;
        while (temp!= null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {2,5,6,8};
        Node head = convert2ll(arr);
        Node head1 = insertlast(head, 11);
        print(head1);
    }

}