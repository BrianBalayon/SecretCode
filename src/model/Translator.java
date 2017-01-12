package model;

import java.util.ArrayList;

public class Translator {
	
	public Translator () {
		//nice
	}

	public ArrayList<Integer> rot13 (ArrayList<Integer> entry) {
		ArrayList<Integer> translated = new ArrayList<Integer>();
		for (int i=0; i<entry.size(); i=i+2) {
			int x = entry.get(i+1);
			switch (entry.get(i)) {
				case 0: translated.add(0);
						if (x > 56) { x=x-5; }
						else if (x > 51) { x=x+5; }
						else if (x > 38) { x=x-13; }
						else if (x > 25) { x=x+13; }
						else if (x > 12) { x=x-13; }
						else { x=x+13; }
						translated.add(x);
						break;
				case 1: translated.add(entry.get(i));
						translated.add(entry.get(i+1));
						break;
			}
		}
		return translated;
	}


}