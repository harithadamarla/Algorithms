package BloomInsuranceAgency;

import java.util.Scanner;

public class fitWords {
	
	public void organize(int a, String s)
	{
		int flag=0;
		for(int i=0;i<s.length();i++)
		{
//			if(i%a==0)
//			{
//				System.out.println();
//				
//			}
//			System.out.print(s.charAt(i));
			
			
			if(i%a==0 && i!=0)
			{
				System.out.println();
				s=s.substring(i).trim();
				i=0;

			}
			System.out.print(s.charAt(i));
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		fitWords f=new fitWords();
//		System.out.println("Enter a number");
//		Scanner s=new Scanner(System.in);
//		int n=s.nextInt();
//		s.nextLine();
//		System.out.println("Enter text");
//		String line=s.nextLine();
//		f.organize(n, line);
		
		fitWords f=new fitWords();
		int i=Integer.parseInt("15");
		String s="The quick brown fox jumped over the lazy dog";
		f.organize(i, s);
		

	}

}
