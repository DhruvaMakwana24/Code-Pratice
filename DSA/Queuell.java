// Queue using the linked list
import java.lang.*;
import java.util.*;

class QueueNode{
    int data;
    QueueNode next;
    public QueueNode(int data){
        this.data=data;
        this.next=null;
        }
}
class Queue{
     QueueNode front,rear;
     public Queue(){
        front=rear=null;
        }
        public void enqueue(int data){
            QueueNode newNode=new QueueNode(data);
            if(front==null){
                front=newNode;
                rear=newNode;
                }
                else{
                    rear.next=newNode;
                    rear=newNode;
                    }
        }
        public int dequeue()
        {
            if(front==null)
            {
                System.out.println("Queue is empty");
                return -1;
            }
            else
            {
                int temp = front.data;
                front = front.next;
                return temp;
            }

        }
        public int top()
        {
            if(front == null)
            {
                System.out.println("Queue is empty");
                return -1;
            }
            else
            {
                return front.data;
            }
        }
        public void display() {
            QueueNode temp = front;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
                }
                System.out.println();
        }
}
class Queuell{
    public static void main(String[] args) 
    {
        Queue node = new Queue();
        node.enqueue(1);
        node.enqueue(2);
        node.enqueue(3);
        node.display();
        System.out.println("-----------");
        System.out.println(node.dequeue());
        System.out.println("-----------");
        node.display();


    }
}