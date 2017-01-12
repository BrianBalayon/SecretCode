package model;

import java.util.ArrayList;

public class CharLister {
	
	public CharLister () {
		//nice
	}
	
	public ArrayList<Character> breakdown(String s) {
		ArrayList<Character> characters = new ArrayList<Character>();
		for (int i=0; i<s.length();i=i+1){
			characters.add(s.charAt(i));
		}
		return characters;
	}
}
