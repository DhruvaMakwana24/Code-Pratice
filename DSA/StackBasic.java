//using arr implementing stack
import java.util.*;
import java.io.*;

class Stack {
     int size;
     int top;
     int[] arr;

     Stack(int size)
     {
        this.size = size;
        arr = new int[size];
        top = -1;
     }
     void push(int val)
     {
        if (size - top > 1)
        {
            top++;
            arr[top] = val;
        }
        else 
        {
            System.out.println("Stack overflow");
        }
         
     }
     void pop(){
        if (top >= 0){
            top--;
        }
        else
        {
            System.out.println("Stack underflow");
        }
     }
     int  peek()
     {
        if (top >= 0)
        {
            return arr[top];
        }
        else{
            System.out.println("Stack underflow");
            return -1 ;

        }
     }
     boolean isEmpty()
     {
        return top == -1;
     }
     void display()
     {
        for (int i = 0; i <= top; i++)
        {
            System.out.println(arr[i]);
         }
    }


}
class StackBasic{
    public static void main(String[] args) {
          Stack s = new Stack(5);
          s.isEmpty();
          s.peek();
          s.push(5);
          s.push(4);
          s.push(3);
          s.push(2);
          s.push(1);
          System.out.println("this are the element present in stack ");
          s.display();
          System.out.println("this is the top element "+ s.peek());
          s.pop();
          System.out.println("this is the top after using pop operation "+s.peek());
          s.isEmpty();
          s.display();
    }

}