// implementing queue using array
//time complexity per operation O(n) = 1
//Space complexity O(n) = n
import java.lang.*;
import java.util.*;
import java.io.*;

class Queue{
    int start,end,size;
    int[] arr;
    int currentsize;
    Queue(int size){
        this.size=size;
        arr=new int[size];
        currentsize = 0;
        start=-1;
        end=-1;
    }
    void enqueue(int data){
        if(currentsize==size){
            System.out.println("Queue is full");
        }
        else if(end ==-1)
        {
            end = 0;
            start = 0;
        }
        else
         end = (end+1)%size;
         arr[end]=data;
         currentsize++;
    }
     int dequeue(){
        if(currentsize==0){
            System.out.println("Queue is empty");
            return -1;
        }
        int dequeue=arr[start];
        if(currentsize == 1)
        {
           start = -1;
           end = -1;
        }
        else {
            start = (start+1)%size;
            currentsize--;
        }
        return dequeue;
    }
    public void display(){
        if(currentsize== 0)
        {
            System.out.println("Queue is empty");
            return;

        }
        int count = 0;
        int i = start;
        while (count < currentsize) {
            System.out.println(arr[i]);
            i = (i + 1) % size;
            count++;
        }
    }
    public int top(){
        if(currentsize==0){
            System.out.println("Queue is empty");
        }
        else
        {
            return arr[start];
        }
        return -1;
    }
}
class Queuebasic{
    public static void main(String args[])
    {
       Queue q = new Queue(5);
       q.enqueue(1);
       q.enqueue(2);
       q.enqueue(3);
       q.enqueue(4);
       q.display();
       System.out.println("------------");
       int top = q.top();
       System.out.println(top);
       System.out.println("------------");
       int result = q.dequeue();
       System.out.println(result);
       System.out.println("------------");
       q.display();
    } 
}