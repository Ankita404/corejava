package com.coforge.basics;

public class SecondLargest {
	public static int Second(int[] a,int total) {
		int temp;
		for (int i=0;i<total;i++)
		{
			for(int j=i+1;j<total;j++)
			{
				if(a[i]>a[j])
				{
					temp = a[i];
					a[i]= a[j];
					a[j]=temp;
				}
			}
		}
	return a[total-2];
	}
	public static void main(String args[]) {
		int a[]= {1,2,5,6,3,2};
		int b[]= {44,66,77,48,64,89,79};
		System.out.println("largest:"+Second(a,6));
		System.out.println("largest:"+Second(b,7));
		}
	

}



