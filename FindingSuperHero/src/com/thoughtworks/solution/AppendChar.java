package com.thoughtworks.solution;

public class AppendChar {
	String characterString = "";
	
	public AppendChar(AppendChar ch){
		this.characterString = ch.characterString;
	}
	
	public AppendChar(){
		
	}
	
	public void appendChar(char c){
		characterString = characterString + c;
		//System.out.println("Current Character ::"+character);
	}
	
	

}
