// implementing two stack using one arr 
import java.lang.*;
import java.util.*;
class TwoStack{
    int size;
    int top1;
    int top2;
    int[] arr;
    TwoStack (int size)
    {
        this.size = size;
        arr = new int[size];
        top1 = -1;
        top2 = size;
    }
    void push1(int element)
    {
        if((top2 - top1)> 1)
        {
            top1++;
            arr[top1] = element;
        }
        else {
            System.out.println("Stack overflow");
        }
    }
    void push2(int element)
    {
        if((top2 - top1)> 1)
        {
            top2--;
            arr[top2] = element;
        }
        else {
            System.out.println("Stack overflow");
        }
    }
    int pop1()
    {
        if (top1 > -1 )
        {
            int result1 = arr[top1];
            top1--;
            return result1;
        }
        else
        {
            System.out.println("Stack underflow");
            return -1;
        }
        
    }
    int pop2(){
        if (top2 < size )
        {
            int result2 = arr[top2];
            top2++;
            return result2;
        }
        else
        {
            System.out.println("Stack underflow");
            return -1;
        }
        
    }
    void display1(){
        for(int i = 0; i <= top1; i++){
            System.out.println(arr[i]);
        }

    }
    void display2(){
        for(int i = size-1; i >= top2; i--)
        {
            System.out.println(arr[i]);
        }
    }
}
class practice{
    public static void main(String args[])
    {
        TwoStack t = new TwoStack(6);
        t.push1(1);
        t.push1(2);
        t.push2(6);
        t.push2(7);
        System.out.println("Stack1");
        t.display1();
        System.out.println("Stack2");
        t.display2();
        System.out.println(t.pop1());
        System.out.println(t.pop2());

    }
}