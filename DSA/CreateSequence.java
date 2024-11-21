/*Problem statement
Ninja is good at numbers. So today his friend gave him a task that required him to find out numbers made of 2 and 5 only less than a given limit.

Given an integer N, you need to print all numbers less than N which are having digits only 2 or 5 or both.

For example :
All numbers less than 30 with digits 2 and 5 are 2, 5, 22, 25.*/
import java.util.*;
public class Solution{
    public static void possibleval(int[] arr,long range,ArrayList<Long> list){
          Queue<Long> q = new LinkedList<>();
          for(int it:arr){
              if(it <= range)
              {
                q.add((long)it);
                list.add((long)it);
              }
          }
          while(!q.isEmpty())
          {
              long current = q.poll();
              for(int it: arr)
              {
                  long newnumber = current*10 + it;
                  if(newnumber <= range)
                  {
                      q.add(newnumber);
                      list.add(newnumber);
                  }
              }
          }
    }
    public static ArrayList<Long> createSequence(long n){
        // Write your code here.
        int[] arr ={2,5};
        ArrayList<Long> list= new ArrayList<>();
        possibleval(arr,n,list);
        return list;
        
    }
}
