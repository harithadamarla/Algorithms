//package demo;
//Problem Statement
//Sample input input1.txt
//You are given a set of jobs.  Each jobjhas a start timesjand finishtimefj.   It  also  has  a  weightvj.   Two  jobs  are  compatible,  if  theydo not overlap.  Goal is to find maximum weight subset of mutuallycompatible jobs.  Run your program on the two inputs provided (Youwill get partial credit for running it on only one of them).  You haveto output the maximum weight -notthe actual subset.  Following isa toy example.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class job {
	int start;
	int finish;
	int weight;

	job(int start, int finish, int weight) {
		this.start = start;
		this.finish = finish;
		this.weight = weight;

	}

}

class JobComparator implements Comparator<job> {
	public int compare(job a, job b) {
		return a.finish < b.finish ? -1 : a.finish == b.finish ? 0 : 1;
	}
}

public class jobScheduling {

	private static int findcompatible(job[] j, int i) {
		// // TODO Auto-generated method stub
		 for (int k = i - 1; k >= 0; k--) {
			 
			 if (j[k].finish <= j[i].start) {
				 return k;
			 }
		 }
		
		 return -1;

	}

	private static int findMaxWeight(job[] j, int n) {

		int solution[] = new int[n];
		solution[0] = j[0].weight;

		for (int i = 1; i < n; i++) {
			int inclProf = j[i].weight;
			int l = findcompatible(j, i);
			if (l != -1)
				inclProf = inclProf + solution[l];

			solution[i] = Math.max(inclProf, solution[i-1 ]);
		}
		int result = solution[n - 1];

		return result;

	}

	public static void main(String[] args) throws FileNotFoundException {
		
		// TODO Auto-generated method stub
		Scanner s0= new Scanner(System.in);
		System.out.println("Enter the name of the file");
		String filename=s0.nextLine();

		File file = new File(filename);

		//count the no. of lines in a given file,to initialize the array
		@SuppressWarnings("resource")
		Scanner s1 = new Scanner(file);
		int count=0;
		while (s1.hasNextLine()) {
			  count++;
			  s1.nextLine();
			}
		
		Scanner s2 = new Scanner(file);

		job j[] = new job[count];

		//read the values from the file, and construct an array
		for (int i = 0; i < j.length; i++) 
		{
			//System.out.println(1);
			j[i] = new job(s2.nextInt(), s2.nextInt(), s2.nextInt());

		}

		//sort the array, according to the finish time
		Arrays.sort(j, new JobComparator());

		int n = j.length;

		System.out.println(findMaxWeight(j, n));

	}

}
