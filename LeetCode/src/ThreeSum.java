import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	
    	List<List<Integer>> list= new ArrayList<List<Integer>>();
    	
    	Arrays.sort(nums);
    	
        for(int i=0;i<nums.length;i++)
        {
        	for(int j=i+1;j<=nums.length-2;j++)
        	{
        		for(int k=j+1;k<nums.length;k++)
        		{
        			if((nums[i]+nums[j]+nums[k])==0)
        			{
        				List<Integer> l=new ArrayList<Integer>();
        				
        				l.add(nums[i]);
        				l.add(nums[j]);
        				l.add(nums[k]);
        				if(!list.contains(l))
        				list.add(l);
        				
        			}
        			
        		}
        	}
        }
        System.out.println(list);
        return list;
       
    }
}


public class ThreeSum {
	 
			public static void main(String[] args) {
				// TODO Auto-generated method stub
					
				
				Solution s=new Solution();
				int[] array = {-1,0,1,2,-1,-4};
				s.threeSum(array);
				
				
				
			}
	 }
	        
	        




