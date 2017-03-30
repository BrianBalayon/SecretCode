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

	private int mapChar (char compareTo) {
		for (int i=0; i<_chars.size(); i+=1) {
			if (_chars.get(i) == compareTo) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Creates a map of the chars of the input String and returns the map as a int[][]
	 *
	 * @param entry The String entered as char[]
	 * @return an ArrayList<ArrayList<Integer>>
	 *     0: ArrayList<Integer> of the key whether or not the character was mapped
	 *     1: ArrayList<Integer> of the character in _chars
	 */
	public ArrayList<Integer> match (ArrayList<Character> entry) {
		ArrayList<Integer> retVal = new ArrayList<Integer>();
		for (char c : entry) {
			retVal.add(mapChar(c));
		}
		return retVal;
	}

	/**
	 * Creates the String using the map and key of the input
	 *
	 * @param entry the key and map of the input String
	 * @param s the original String
	 * @return the translated String of concatenated characters
	 */
	public String restring (ArrayList<Integer> entry, String s) {
		String retVal = "";
		for (int i=0; i<s.length(); i+=1) {
			int x = entry.get(i);
			if (x == -1) {
				retVal += s.charAt(i);
			} else {
				retVal += _chars.get(x);
			}
		}
		return retVal;
	}

}