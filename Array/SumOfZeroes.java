//Sum Of Zeroes
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static Integer coverageOfMatrix(ArrayList<ArrayList<Integer>> mat) {

		// Write your code here.
		int[] delrow = {-1,0,1,0};
		int[] delcol = {0,1,0,-1};
        int totalcoverage = 0;
		for(int i = 0 ; i < mat.size();i++)
		{
			for(int j = 0 ; j <mat.get(i).size();j++)
			{
				if(mat.get(i).get(j)==0)
				{
					int coverage = 0;
					for(int dir = 0 ; dir < 4;dir++)
					{
						int newrow = i + delrow[dir];
						int newcol = j + delcol[dir];
						if(newrow < mat.size() && newcol < mat.get(i).size() && newrow >= 0 && newcol >= 0 )
						{
							if(mat.get(newrow).get(newcol) == 1)
							{
								coverage++;
							}
						}

					}
					totalcoverage +=coverage;
				}
			}
		}

		Integer result = totalcoverage;
		return result;
	}
}
