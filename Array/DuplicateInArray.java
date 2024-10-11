//Duplicate In Array
import java.util.*;

public class Solution {

	public static int findDuplicate(ArrayList<Integer> arr) {

		//    Write your code here.
		Map<Integer,Integer> map = new HashMap<>();
		for(Integer it : arr)
		{
			map.put(it,map.getOrDefault(it,0)+1);
		}
		for(Map.Entry<Integer,Integer> entry : map.entrySet())
		{
			if(entry.getValue() > 1)
			{
				return entry.getKey();
			}
		}
		return 0;
	}
}
