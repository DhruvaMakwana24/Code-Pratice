//implementing the stack using linkedlist
import java.lang.*;
import java.util.*;
class StackNode
{
     int data;
     StackNode next;
     StackNode(int data){
        this.data=data;
        this.next=null;
     }
}
class Stack
{
    StackNode top;
    int size;
     Stack(){
        top = null;
        size = 0;
     }
     public void push(int data){
        StackNode element = new StackNode(data);
        element.next = top;
        top = element;
        size++;
     }
     public int pop(){
        if(top==null)
        {
            System.out.println("Stack is empty");
            return -1;
        }
        else{
            int data = top.data;
            StackNode temp = top;
            top = top.next;
            size--;
            return data;
        }
    
     }
     public int stackSize(){
        return size;
     }
     public boolean stackIsEmpty()
     {
        if(size == 0)
        {
            return true;
        }
        return false;
     }
     public void display(){
        StackNode temp = top;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
     }

}

class Stackll{
    public static void main(String args[]){
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.display();
        System.out.println("Element popped " + s.pop());
        System.out.println("Stack size: " + s.stackSize());
        System.out.println("Stack is empty or not: " + s.stackIsEmpty());
    }
}