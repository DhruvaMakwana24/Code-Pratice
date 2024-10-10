// find how many rotations requires for the word to get the original string
import java.lang.*;
import java.util.*;
import java.io.*;

class Minimunrotation{
    public static int Minimunrotation(String str, int n)
    {
        int count = 0;
        Set<Character> charSet = new HashSet<>();
        if(palidrone(str))
        {
            for (char ch : str.toCharArray()) {
                charSet.add(ch);
            }
            count = charSet.size();
        }
        else{
            count = str.length();
        }
        return count;
    }
    public static boolean palidrone(String str){
        boolean flag = false;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == str.charAt(str.length()-i-1)){
                flag = true;
                }
        } 
        return flag;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        System.out.println(Minimunrotation(str, n));
    }
}
