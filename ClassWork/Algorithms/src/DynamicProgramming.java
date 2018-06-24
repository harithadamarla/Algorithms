//Question:Problem Statement

//Given  a  numbern,  find  the  number  of  different  ways  to  writenasa sum of 1, 3 and 4.  You only have to output the number of differ-ent  partitions  -notthe  actual  partitions  itself.   Run  your  programon5 integer inputsof  sizes≥105.   Provide  the  inputs  on  whichyou ran the program and the corresponding number of partitions foreach input.  Be careful with the initial conditions.  Following is a toyexample.Input:5Output: 6 partitions1.  1 + 1 + 1 + 1 + 12.  1 + 1 + 33.  1 + 3 + 14.  3 + 1 + 15.  4 + 16.  1 + 4


import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DynamicProgramming {
	
	static int n;
	 
	BigInteger table[]=new BigInteger[n+1];
	 
	 void initialize()
	 {
		 
		 
		 for (int i = 0; i <=n; i++)
		        table[i] = BigInteger.valueOf(-1);
		 
		 table[0]=BigInteger.valueOf(1);
			table[1]=BigInteger.valueOf(1);
	 }
	 
	BigInteger countWays(int n)
	 {
		
		if(n<0)
			return BigInteger.valueOf(0);
		
		
		for(int i=2;i<=n;i++)
		{
			if(table[i]!=BigInteger.valueOf(-1))
				break;
			if(table[i]==BigInteger.valueOf(-1))
				
			table[i]=countWays(i-1).add(countWays(i-3)).add(countWays(i-4));
			
			
		}
		return table[n];

		
		
	 }

	 // Driver Function to test above function
	 public static void main(String args[])
	 {
		
		 System.out.println("enter the value of n");
		 @SuppressWarnings("resource")
		 Scanner s=new Scanner(System.in);
		 n=s.nextInt();
		 
		 DynamicProgramming p=new DynamicProgramming();
		 p.initialize();
		 
		 BigInteger ways= p.countWays(n).mod(BigInteger.valueOf(100000));
		 
	
	     System.out.println(ways);
	 }

}
	
