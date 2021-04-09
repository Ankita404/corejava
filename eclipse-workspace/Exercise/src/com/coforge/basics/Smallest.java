package com.coforge.basics;

public class Smallest {
	static int Small(int []a,int total) {
	int temp;
	for(int i=0;i<total;i++)
	{
		for(int j=i+1;i<total;i++)
		{
			if (a[i]<a[j])
			{
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		
	}
return a[total-1];
}
public static void main(String args[]) {
	int a[]= {1,2,5,6,3,2};
	
	System.out.println("smallest:"+Small(a,6));
	
	}
}
