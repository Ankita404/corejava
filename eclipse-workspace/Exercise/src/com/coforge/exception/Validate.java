package com.coforge.exception;

public class Validate {
	String[] names = {"ankita","anshika","archita"};

	public boolean CheckName(String name) throws Exception{
		for(String val:names) {
			if(val.equals(name)) {
				throw new Exception("exception");
			};
		}
		return true;
	}

void checkpass(String pass)throws TooShort,TooLongException{
	if(pass.length()<5) {
		throw new TooShort("password is too short");
	}
	else {
		throw new TooLongException("password is too long");
	}
}
}