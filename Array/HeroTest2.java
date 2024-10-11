 //The Hero Test-2
import java.util.* ;
import java.io.*; 
public class Solution {
	public static ArrayList<Integer> theOrder(int n, int k) {
		// Write your code here.
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> question = new ArrayList<>();
		for(int i = 1; i <= n ; i++)
		{
			question.add(i);
		}
		int i = 0 ;
		while(!question.isEmpty())
		{
			i = (i+k) % question.size();
			arr.add(question.get(i));
			question.remove(i);
			if(i == question.size())
			{
				i = 0;
			}
		}
		return arr;
	}
}

