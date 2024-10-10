//https://codeforces.com/contest/219/problem/A
//A. k-String
import java.util.*;

public class Solution {

    public static String modified_String(int k, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1); 
        }

        
        for (Integer frequency : map.values()) {
            if (frequency % k != 0) {
                return "-1"; 
            }
        } 

        
        StringBuilder substringBuilder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char character = entry.getKey();
            int count = entry.getValue();
            int numOfCharactersToAdd = count / k; 
            for (int i = 0; i < numOfCharactersToAdd; i++) {
                substringBuilder.append(character);
            }
        }

    
        String substring = substringBuilder.toString();
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            resultBuilder.append(substring);
        }

        return resultBuilder.toString(); 
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();
        sc.close();

        String result = modified_String(k, s);
        System.out.println(result);
    }
}
