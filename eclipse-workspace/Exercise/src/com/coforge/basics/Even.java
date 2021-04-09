package com.coforge.basics;

import java.util.Scanner;

public class Even {

	public static void main(String args[]) {
	int num1;
	{
		System.out.println("enter the number:");
		Scanner sc = new Scanner(System.in);
		num1 =sc.nextInt();
		if(num1%2==0)
		{
			System.out.println(num1+" is even");
		}
			else
				System.out.println(num1+" is odd");
			
		}
	}

	

}
