package model;

import java.util.ArrayList;

public class Matcher {

	ArrayList<Character> _characters;
	
	public Matcher () {
		_characters = new ArrayList<Character>();
		//Lowercase: 0-25
		//Uppercase: 26-51
		//Numbers: 52-61
		String toList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		for (int i=0; i<toList.length();i=i+1){
			_characters.add(toList.charAt(i));
		}
	}

	public ArrayList<Integer> match (ArrayList<Character> entry) {
		ArrayList<Integer> matched = new ArrayList<Integer>();
		int previousSize;
		for (int i=0; i<entry.size();i=i+1) {
			previousSize = matched.size();
			Character c = entry.get(i);
			for (int x=0; x<_characters.size();x=x+1) {
				if (c.equals(_characters.get(x))) { 
					matched.add(0);
					matched.add(x); 
				}
			}
			if (matched.size() == previousSize) {
					matched.add(1);
					matched.add(i);
			}
		}
		return matched;
	}

	public String restring (ArrayList<Integer> c, String s) {
		String restrung = "";
		for (int i=0; i<c.size(); i=i+2) {
			int x = c.get(i+1);
			switch (c.get(i)) {
				case 0: restrung = restrung + _characters.get(x);
						break;
				case 1: restrung = restrung + s.charAt(x);
						break;
			}
		}
		return restrung;
	}

}