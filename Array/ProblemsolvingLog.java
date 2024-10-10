//https://codeforces.com/contest/1914/problem/A
//A. Problemsolving Log
import java.lang.*;
import java.util.*;
import java.io.*;

public class Solution{
    public static int count_solved(String solved)
    {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : solved.toCharArray())
        {
               map.put(ch, map.getOrDefault(ch, 0) + 1); 
        }
        char ch = 'A';
        int asci = (int) ch;
        int cnt = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            int count = entry.getValue();
            char character = entry.getKey();
            int timer = (int) character - asci + 1;
            if(timer <= count)
            {
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0)
        {
            int length = sc.nextInt();
            String solved = sc.next();
            int total_solved = count_solved(solved);
            System.out.println(total_solved);
            t--;
        }
        sc.close();
    }
}