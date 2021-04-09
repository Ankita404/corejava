package com.coforge.exception;

import java.util.Scanner;


public class Registration {
	String name;
	String pass;

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("enter user name");
			String	name = sc.nextLine();
			System.out.println("enter password");
			String pass = sc.nextLine();
			boolean status = false;
			sc.close();
			try {
			Validate val = new Validate();
			boolean ss = val.CheckName(name);
	
			
			if(ss) {
				System.out.println("true");
			}
			else {
				System.out.println("false");
			}
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("system problem"+e.getMessage());
			}
			if (status) {
				System.out.println("you are registered successfully");
			}
			try {
				Validate val = new Validate();
				val.checkpass(pass);
			}catch(TooShort | TooLongException e) {
				System.out.println(e.getMessage());
			
			}
			
				
		
				
		// TODO Auto-generated method stub

	}

}
