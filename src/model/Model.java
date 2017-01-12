package model;

import java.util.ArrayList;
import user_interface.UI;

public class Model {

	UI _ui;
	String _entry;
	Translator _trans;
	Matcher _match;
	CharLister _lister;
	
	public Model (UI ui) {
		_ui = ui;
		_trans = new Translator();
		_match = new Matcher();
		_lister = new CharLister();
	}
	
	public void start () {
		String entry = _ui.getEntry();
		if (entry.equals("")) { 
			_ui.printOut("No entry detected");
		}
		else {
			_entry = entry; 
			translate(entry);
		}
	}
	
	public void translate (String entry) {
		ArrayList<Character> entryList = _lister.breakdown(entry);
		ArrayList<Integer> message = _match.match(entryList);
		message = _trans.rot13(message);
		String toPrint = _match.restring(message, _entry);
		_ui.printOut(toPrint);
	}
	
}
