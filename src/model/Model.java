package model;

import java.util.ArrayList;

import user_interface.UserInterface;

/**
 * The Model creates the Translator and CharMatcher
 * @author brian
 *
 */
public class Model {

	private UserInterface _ui;
	private ArrayList<String> _history;
	private Translator _trans;
	private CharMatcher _match;
	private int _historySize;
	
	public Model () {
		_history = new ArrayList<String>();
		_trans = new Translator();
		_match = new CharMatcher();
	}
	
	public void addObserver (UserInterface ui) {
		_ui = ui;
	}
	
	public void setHistorySize (int s) {
		_historySize = s;
	}
	
	public void code () {
		String entry = _ui.getEntry();
		if (entry.equals("")) { 
			addHistory("Please enter a valid input");
		}
		else {
			translate(entry);
		}
	}
	
	public void translate (String entry) {
		ArrayList<Character> entryList = new ArrayList<Character>();
		for (int i=0; i<entry.length(); i+=1) {
			entryList.add(entry.charAt(i));
		}
		ArrayList<ArrayList<Integer>> mappedChars = _match.match(entryList);
		ArrayList<ArrayList<Integer>> translated = _trans.rot13(mappedChars);
		String toPrint = _match.restring(translated, entry);
		addHistory(toPrint);
		_ui.update(_history);
	}
	
	public void addHistory (String s) {
		for (int i=_historySize; i>1; i-=1) {
			_history.set(i-1, _history.get(i-2));
		}
		_history.set(0, s);
	}
	
}
