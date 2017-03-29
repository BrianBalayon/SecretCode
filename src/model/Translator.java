package model;

import java.util.ArrayList;

public class Translator {
	
	public Translator () {
		//nice
	}

	/**
	 * Makes a map
	 * 
	 * @param entry 
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> rot13 (ArrayList<ArrayList<Integer>> entry) {
		ArrayList<ArrayList<Integer>> retVal = new ArrayList<ArrayList<Integer>>();
		retVal.add(entry.get(0));
		ArrayList<Integer> map = new ArrayList<Integer>();
		for (int i=0; i<entry.get(0).size(); i=i+2) {
			int x = entry.get(1).get(i);
			switch (entry.get(0).get(i)) {
				case 0: if (x > 56) { x=x-5; }
						else if (x > 51) { x=x+5; }
						else if (x > 38) { x=x-13; }
						else if (x > 25) { x=x+13; }
						else if (x > 12) { x=x-13; }
						else { x=x+13; }
						map.add(x);
						break;
				case 1: map.add(-1);;
						break;
			}
		}
		return retVal;
	}


}