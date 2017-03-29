package model;

import java.util.ArrayList;

public class CharMatcher {

	private ArrayList<Character> _chars;
	
	/**
	 * Creates a Matcher object with a array of char to compare with
	 * 
	 * Lowercase: 	0-25
	 * Uppercase: 	26-51
	 * Numbers: 	52-61
	 */
	public CharMatcher () {
		String toList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		_chars = new ArrayList<Character>();
		for (int i=0; i<toList.length(); i+=1) {
			_chars.add(toList.charAt(i));
		}
	}

/**
 * Creates a map of the chars of the input String and returns the map as a int[][]  
 * 
 * @param entry The String entered as char[]
 * @return a int[2][length of the String] (0: if the char was mapped  1: map of char.
 * int[0][x]==0 : the char was mapped  ==1: the char wasn't ) 
 */
	public ArrayList<ArrayList<Integer>> match (ArrayList<Character> entry) {
		ArrayList<ArrayList<Integer>> retVal = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> key = new ArrayList<Integer>();
		ArrayList<Integer> map = new ArrayList<Integer>();
		retVal.add(key);
		retVal.add(map);
		int positionInIteration = 0;
		for (Character c : entry) {
			for (int i=0; i<_chars.size(); i+=i) {
				if (_chars.get(i).equals(c)) {
					key.add(0);
					map.add(i);
					positionInIteration += 1;
				}
			}
			if (c.equals(entry.get(positionInIteration))) {
				key.add(1);
				map.add(-1);
				positionInIteration += 1;
			}
		}
		return retVal;
	}

	public String restring (ArrayList<ArrayList<Integer>> entry, String s) {
		String restrung = "";
		for (int i=0; i<s.length(); i=i+2) {
			int x = entry.get(1).get(i);
			switch (entry.get(0).get(i)) {
				case 0: restrung = restrung + _chars.get(x);
						break;
				case 1: restrung = restrung + s.charAt(i);
						break;
			}
		}
		return restrung;
	}

}