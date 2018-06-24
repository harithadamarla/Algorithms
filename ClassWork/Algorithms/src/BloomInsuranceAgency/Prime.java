package BloomInsuranceAgency;
import java.util.Scanner;

public class Prime {

	boolean isPrime(int n)
	{
		
		for(int i=2;i<=n/2;i++)
		{
			if(n%i==0)
				return false;
		}
		return true;
				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prime p=new Prime();
		System.out.println("Enter a number");
		Scanner s=new Scanner(System.in);
		System.out.println(p.isPrime(s.nextInt()));

	}

}
