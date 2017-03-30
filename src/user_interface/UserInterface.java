package user_interface;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import model.Model;
import user_interface.action_listener.*;

public class UserInterface implements Runnable {

	private Model _model;
	private JFrame _frame;
	private JPanel _entryBar;
	private JTextField _inputField;
	private ArrayList<JTextPane> _messages;
	private int _historySize;
	
	public UserInterface () {
		_model = new Model();
		_model.addObserver(this);
		_historySize = 3;
		_model.setHistorySize(_historySize);
	}
	
	@Override
	public void run () {
		//JFrame
		_frame = new JFrame("Sensitive Messages");
		_frame.setLayout(new GridLayout(_historySize+1, 1));
		
		//Input Area
		_entryBar = new JPanel();
		_entryBar.setLayout(new GridLayout(1,2));
		_inputField = new JTextField("Type a message...");
		JButton startButton = new JButton("Translate");
		startButton.addActionListener(new TranslateActionListener(_model));
		_entryBar.add(_inputField);
		_entryBar.add(startButton);
		
		//Message History
		_messages = new ArrayList<JTextPane>();
		for (int i=0; i<_historySize; i+=1) {
			_messages.add(new JTextPane());
			_frame.add(_messages.get(i));
		}
		
		//Add components
		_frame.add(_entryBar);

		//DO NOT TOUCH!
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.pack();
		_frame.setVisible(true);
	}
	
	/**
	 * Gets the user input
	 *
	 * @return the text in _inputField
	 */
	public String getEntry () {
		String entry = _inputField.getText();
		_inputField.setText(null);
		return entry;
	}
	
	/**
	 * Sets the text in the history to the JTextPanes
	 * 
	 * @param history an ArrayList of String containing the history
	 */
	public void update (ArrayList<String> history) {
		for (int i=0; i<_historySize; i+=1){
			String text = history.get(i);
			JTextPane view = _messages.get(i);
			view.setText(text);
		}
	}
	
}
