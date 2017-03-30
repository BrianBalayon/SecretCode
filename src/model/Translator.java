package model;

import java.util.ArrayList;

public class Translator {
	
	public Translator () {
		//nice
	}

	/**
	 * Makes a map to the translated characters based on the original map
	 * 
	 * @param entry The original map and key of the entry
	 * @return The translated map and original key of the entry
	 */
	public ArrayList<ArrayList<Integer>> rot13 (ArrayList<ArrayList<Integer>> entry) {
		ArrayList<ArrayList<Integer>> retVal = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> map = new ArrayList<Integer>();
		ArrayList<Integer> key = entry.get(0);
		ArrayList<Integer> original = entry.get(1);
		for (int i=0; i<entry.get(0).size(); i=i+2) {
			int x = original.get(i);
			switch (key.get(i)) {
				case 0: if (x > 56) { x=x-5; }
						else if (x > 51) { x=x+5; }
						else if (x > 38) { x=x-13; }
						else if (x > 25) { x=x+13; }
						else if (x > 12) { x=x-13; }
						else { x=x+13; }
						map.add(x);
						break;
				case 1: map.add(-1);
						break;
			}
		}
		retVal.add(map);
		retVal.add(key);
		return retVal;
	}


}