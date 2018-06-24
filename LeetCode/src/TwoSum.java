import java.util.HashMap;
import java.util.Hashtable;

public class TwoSum {
	 public int[] TwoSum1(int[] nums, int target) {
//		  naive method
	        int a[]=new int[2];
//	        int flag=0;
//	        
//	        for(int i=0;i<nums.length;i++)
//	        {
//	            for(int j=i+1;j<nums.length;j++)
//	            {
//	                if(nums[i]+nums[j]==target)
//	                {
//	                 
//	                
//	                    a[0]=i;
//	                    a[1]=j;
//	                    return a;
//	                   
//	                }
//	            }
//	           
//	        }
//	        return a;
//	 
		 
	        //with time and space complexit O(n)
		 
		 HashMap<Integer, Integer> ht=new HashMap<Integer,Integer>();
//		 for(int i=0;i<nums.length;i++)
//			 ht.put(nums[i],i);
//		 
//		 for(int i=0;i<nums.length;i++)
//		 {
//			 if(ht.containsKey(target-nums[i])&&(ht.get(target-nums[i])!=i))
//			 {
//				 a[0]=i;
//				 a[1]=ht.get(target-nums[i]);
//				 return a;
//				
//				 
//			 }
//		 }
//		 return a;
//		 
//		 	
//	    }
		 
//		 with time complexity O(n)
//		 with space complexity O(1)
		 for(int i=0;i<nums.length;i++)
		 {
			 if(ht.containsKey(target-nums[i]))
			 {
				 a[0]=ht.get(target-nums[i]);
				 a[1]=i;
				 return a;
			 }
			 else
			 {
				 ht.put(nums[i], i);
			 }
		 }
		 return a;
	 }
	        
	        

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			TwoSum ts=new TwoSum();
			int result[]=new int[2];
			int nums[]= {2,5,5,11};
			int target=10;
			result=ts.TwoSum1(nums, target);
			System.out.println(result[0]+" "+result[1]);
	}

}
