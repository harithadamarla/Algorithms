package BloomInsuranceAgency;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class JosephesProblem {
	
//	public int josephes(int n, int k)
//	{
////		if(n==1)
////			return 1;
////		else
////			return (josephes(n-1,k)+k-1)%n+1;
//		int[] mantokill=new int[n + 1];
//		mantokill[0]=nextMan(0,k,n);
//		
//		for(int i=1;i<=n;i++)
//		{
//			mantokill[i]=nextMan(mantokill[i-1],k,n);
//			
//		}
//		
//		return nextMan(mantokill[n],k,n);
//			
//		
//	}
//
//	private int nextMan(int currentManToKill, int k, int n) {
//		// TODO Auto-generated method stub
//		return (currentManToKill+k)%n;
//	}
	
//	public int josephes(int n, int k)
//	{
//		int result=0; //for n=1
//		for(int i=2;i<=n;i++)
//		{
//			result=(k+result)%i;
//		}
//		return (result+1);
//	}
//	
//	
//	
//	public int josp2(int n, int k) {
//		int[] result= new int[n+1]; //for n=1
//		for(int i=2;i<=n;i++)
//		{
//			result[i]=(k+result[i-1])%i;
//		}
//		
//		return (result[n]+1);
//	}
	
	static List<Integer> josephus(int n)
	{
		int start=1, kill_step=2;
		
		if(n<1 ||kill_step<1 ||start <1)
			return null;
		List<Integer> list= new LinkedList<Integer>();
		for(int i=1;i<=n;i++)
		{
			list.add(i);
		}
		List<Integer> r=new LinkedList<Integer>();
		int i=(start-2)%n;
		for(int j=n;j>0;j--)
		{
			i=(i+kill_step)%n--;
			r.add(list.remove(i--));
		}
		
		
		return r;
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Enter the number of people");
//		Scanner s=new Scanner(System.in);
//		int n=s.nextInt();
//		s.nextLine();
//		System.out.println("Enter the killing index,for instance k-1 ppl are skipped");
//		int k=s.nextInt(); 
		
		
		JosephesProblem j=new JosephesProblem();
		
		List<Integer> r=new LinkedList<>();
		
		r=j.josephus(7);
		
		System.out.println(r.get(r.size()-2)+ ", "+r.get(r.size()-1));
		
		
		
//		System.out.println(j.josp2(n, k));

	}

}
