// deleting the middle element of stack 
import java.lang.*;
import java.util.*;
import java.util.Stack;
import java.io.*;
class Stack
{
    int size;
    int top;
    int[] arr;

    Stack(int size)
    {
        this.size = size;
        arr = new int[size];
        top = -1;
    }
    void push(int element){
        if (top - size < 1)
        {
            top++;
            arr[top] = element;
        }
        else
        {
            System.out.println("Stack is full");
        }
    }
    int pop()
    {
        if(top == -1)
        {
            System.out.println("Stack is empty");
            return -1;
        }
        else
        {
            int element = arr[top];
            top--;
            return element;
        }

    }
    int peek() {
        if (top == -1){
            System.out.println("Stack is empty");
        }
        else
        {
            return arr[top];
        }
        return -1;
     }
    boolean isEmpty()
    {
        if (top == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    void display()
    {
        for(int i = top; i >= 0; i--)
        {
            System.out.println(arr[i]);
        }
    }
}

class Deletemiddle{
    static private void deletemiddle(Stack s , int size)
    {
         int count = 0;
         solve (s,count,size);

    }
    static private void solve(Stack s , int count ,int size)
    {
        if (count == size/2)
        {
            s.pop();
            return;
        }
        int num = s.pop();
        solve(s,count+1,size);
        s.push(num);
    }
    // public static void main(String args[]) {
    //     // Stack s = new Stack(10);
    //     // s.push(1);
    //     // s.push(2);
    //     // s.push(3);
    //     // s.push(4);
    //     // s.push(5);
    //     // s.display();
    //     // System.out.println("delete the middle element");
    //     // deletemiddle(s,5);
    //     // s.display();
    //     Stack<Integer> s= new Stack<Integer>(5);
    //     s.push(1);
    //     s.push(2);
    //     s.push(3);
    //     s.push(4);
    //     s.push(5);
    //     for (int element : s) {
    //         System.out.println(element);
    //     }
    //      System.out.println("delete the middle element");
    // }
}