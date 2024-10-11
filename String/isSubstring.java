 //Check If One String Is A Rotation Of Another String
public class Solution {
    
    public static int isCyclicRotation(String p, String q)  {
           
           if(p.length() != q.length())
           {
               return 0;
           }
           if(p.equals(q))
           {
               return 1;
           }

           String concatedString = p + p;
           return concatedString.contains(q) ? 1:0;
    }
}
