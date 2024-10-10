
// reversing the ddl by one pass
class Node{
    int data;
    Node next;
    Node back;

    Node(int data1){
        this.data = data1;
        this.next = null;
        this.back = null;
    }
    Node(int data1 , Node next1 , Node back1)
    {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }
}
class reversedll{
    private static Node convertdll(int[] arr){
        Node head = new Node(arr[0]);
        Node prev= head;
        for(int i = 1 ; i < arr.length ; i++){
            Node temp = new Node(arr[i],null,prev);
            prev.next = temp;
            prev = temp;
            }
            return head;
    }
    private static Node reversedll(Node head){
        Node current = head;
        Node prev = null;
        while(current != null){
            prev = current.back;
            current.back = current.next;
            current.next = prev;
            current = current.back;
        }
        return prev.back;
        
    }
    private static Node print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        return head;

    }
    public static void main (String args[]){
           int[] arr = {2,5,6,8};
           Node head = convertdll(arr);
           //print(head);
           head = reversedll(head);
           print(head);
    }
}