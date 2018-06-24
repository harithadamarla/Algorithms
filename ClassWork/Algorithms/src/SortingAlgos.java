
//package demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortingAlgos {
	
		private static void insertionsort(int[] arr) {
		
		int key,j;
		for(int i=1;i<arr.length;++i)
		{
			key=arr[i];
			j=i-1;
			while(j>=0 && arr[j]>key)
			{
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=key;
		}
		
	}


	private static void MergeSort1(int[] arr, int start, int end) {
		// TODO Auto-generated method stub

		if (start < end) // this condition helps to run the MergeSort only till
							// we are left with one element
		{
			int mid = (start + end) / 2;
			MergeSort1(arr, start, mid);
			MergeSort1(arr, mid + 1, end);
			Merge(arr, start, mid, end);
		}

	}
	
	private static int partition(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		int pivot=arr[end];
		int pindex=start-1;
		for(int j=start;j<=end-1;j++)
		{
			if(arr[j]<=pivot)
			{
				pindex++;
				int temp=arr[pindex];
				arr[pindex]=arr[j];
				arr[j]=temp;
				
			}
		}
		int temp=arr[pindex+1];
		arr[pindex+1]=arr[end];
		arr[end]=temp;
		
		return pindex+1;
	}
	
	private static void QuickSort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if(start<end) // whether to partition further or not : loop ends, once we are left with single element
		{
			int p=partition(arr,start,end);
			QuickSort(arr,start,p-1);
			QuickSort(arr,p+1,end);
		}
		
	}

	private static void Merge(int[] arr, int start, int mid, int end) {
		// TODO Auto-generated method stub
		int l = mid - start + 1;
		int r = end - mid;

		int leftsubarray[] = new int[l];
		int rightsubarray[] = new int[r];

		for (int i = 0; i < l; ++i)
			leftsubarray[i] = arr[start + i];

		for (int j = 0; j < r; ++j)
			rightsubarray[j] = arr[mid + 1 + j];

		int i = 0, j = 0;
		int k = start;

		while (i < l && j < r) {
			if (leftsubarray[i] <= rightsubarray[j]) {
				arr[k] = leftsubarray[i];
				k++;
				i++;
			} else {
				arr[k] = rightsubarray[j];
				k++;
				j++;
			}
		}

		while (i < l) {
			arr[k] = leftsubarray[i];
			i++;
			k++;
		}

		while (j < r) {
			arr[k] = rightsubarray[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		@SuppressWarnings("resource")

		Random r = new Random();
	
		for(int n=500;n<=10000;n=n+500)
		{
			
		
			File f = new File("input" + n + ".txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			for (int i = 0; i < n; i++) 
			{
				bw.write((int) new Integer(r.nextInt(n)) + "\n");

			}
			bw.flush();
			bw.close();

			@SuppressWarnings("resource")
			Scanner s1 = new Scanner(f);
			int arr[] = new int[n];
			int arr1[]= new int[n];
			int arr2[]= new int[n];
			for (int i = 0; i < n; i++) 
			{
				arr[i] = s1.nextInt();
				arr1[i]= arr[i];
				arr2[i]=arr[i];
			
			}
			long starttime,endtime;
			
			//for input in random order for mergesort
			int start = 0;
			int end = arr.length - 1;
			starttime = System.nanoTime();
			MergeSort1(arr, start, end);
			endtime =  System.nanoTime();
			System.out.println("MERGE RANDOM ORDER");
			System.out.println(n+"\t"+(endtime-starttime));
			
			//for input in random order for quicksort
			starttime = System.nanoTime();
			QuickSort(arr1,0,n-1);
			endtime =  System.nanoTime();
			System.out.println("QUICK RANDOM ORDER");
			System.out.println(n+"\t"+(endtime-starttime));
			
			//for input in random order for insertionsort
			 starttime=System.nanoTime();
			 insertionsort(arr2);
			 endtime=System.nanoTime();
			 System.out.println("INSERTION RANDOM ORDER");
			 System.out.println(n+"\t"+(endtime-starttime));
			
			//for input in Ascending order for mergesort
			Arrays.sort(arr);
			starttime=System.nanoTime();
			MergeSort1(arr, start, end);
			endtime = System.nanoTime();
			System.out.println("Merge ASCENDING ORDER");
			System.out.println(n+"\t"+(endtime-starttime));
			
			//for input in Ascending order for quicksort
			Arrays.sort(arr1);
			starttime=System.nanoTime();
			QuickSort(arr1,0,n-1);
			endtime =System.nanoTime();
			System.out.println("Quick ASCENDING ORDER");
			System.out.println(n+"\t"+(endtime-starttime));
			
			//for input in Ascending order for insertionsort
			Arrays.sort(arr2);
			starttime=System.nanoTime();
			insertionsort(arr2);
			endtime=System.nanoTime();
			System.out.println("Insertion ASCENDING ORDER");
			System.out.println(n+"\t"+(endtime-starttime));
			
			//for input in Descending order for mergesort
			sortdescending(n, arr);
			starttime=System.nanoTime();
			MergeSort1(arr, start, end);
			endtime =System.nanoTime();
			System.out.println("Merge DESCENDING ORDER");
			System.out.println(n+"\t"+(endtime-starttime));
			
			//for input in descending order for insertionsort
			sortdescending(n, arr2);
			starttime=System.nanoTime();
			insertionsort(arr2);
			endtime=System.nanoTime();
			System.out.println("INSERTION DESCENDING ORDER ");
			System.out.println(n+"\t"+(endtime-starttime));
			
			//for input in Descending order for QuickSort
			sortdescending(n, arr1);
			starttime=System.nanoTime();
			QuickSort(arr1,0,n-1);
			endtime = System.nanoTime();
			System.out.println("QUICK DESCENDING ORDER");
			System.out.println(n+"\t"+(endtime-starttime));
			
			Thread.sleep(3000);
		}

	}


	private static void sortdescending(int n, int[] arr2) {
		int temp;
		temp=0;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr2[i]<arr2[j])		
				{
					temp=arr2[i];
					arr2[i]=arr2[j];
					arr2[j]=temp;
				}
			}
		}
	}

	
}
