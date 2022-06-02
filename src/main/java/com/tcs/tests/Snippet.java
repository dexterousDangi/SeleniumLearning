package com.tcs.tests;

public class Snippet {
	public static void main(String[] args) {
		
	
	String str = "$dfkashdf1,21,414.56";
	          str = str.replaceAll("[^\\d.]", "");
	System.out.println(str);
	double rand=(Math.random()*30);
	System.out.println(rand);
}

}