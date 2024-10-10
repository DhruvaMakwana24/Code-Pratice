//deletion of node in linked list
//-of head
//-of last
//-of kth node
//to remove element
class Node{
    int data;
    Node next;

    Node(int data1 ,Node next1)
    {
        this.data = data1;
        this.next = next1;
    }

    Node (int data1)
    {
        this.data = data1;
    }
}
 

class operationll
{
    private static Node convert2ll(int[] arr)
    {
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1 ; i < arr.length ; i++)
        {
             Node temp = new Node(arr[i]);
             mover.next = temp;
             mover = mover.next;
        }
        return head;
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
    private static Node removeHead(Node head){
        if(head == null){
            return head;
        }
         head = head.next;
        return head;
    }
    private static Node removeTail(Node head){
        if(head ==null || head.next == null)
        {
            return null;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    private static Node removeAt(Node head, int index){
        if (head == null)
        {
            return null;
        }
        if (index == 1){
            return removeHead(head);
        }
        Node temp = head;
        Node prev = null;
        int count = 0;
        while(temp != null)
        {   
            count++;
            if(count == index)
            {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp =temp.next;
        }
        return(head);

    }
    private static Node removelement(Node head , int element){
         if (head == null)
         {
            return null;
         }
         if (head.data == element){
            head = head.next ;
            return head;
         }
         Node temp = head;
         Node prev = null;
         while (temp != null)
         {
            if (temp.data == element)
            {
               prev.next = prev.next.next;
               break;
            }
            prev = temp;
            temp = temp.next;
         }
         return head;
    }
    public static void main(String args[])
    {
        int[] arr ={2,5,6,8};
        Node head = convert2ll(arr);
        print(head);
        //head = removeHead(head);  eg for removing head
        //head = removeTail(head);  eg for removing tail 
        //head = removeAt(head,1);  eg for removing At kth node
        head = removelement(head,6);
        print(head);
    }
}
