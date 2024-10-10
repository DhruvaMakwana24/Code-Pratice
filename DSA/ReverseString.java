//reverse the  string using collections
import java.lang.*;
import java.util.Stack;
import java.io.*;

class ReverseString{
    public static void main(String args[])
    {
        String st = "bhoot";
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<st.length();i++)
        {
            stack.push(st.charAt(i));
        }
        StringBuilder reversestring = new StringBuilder();

        while(!stack.isEmpty()){
            reversestring.append(stack.pop());
        }
        System.out.println(reversestring.toString());
    }
}
