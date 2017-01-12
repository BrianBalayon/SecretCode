package user_interface;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import model.Model;

public class UI implements Runnable {

	Model _model;
	JFrame _frame;
	JTextField _textField;
	JTextPane _message;
	
	public UI () {
		_model = new Model(this);
	}
	
	@Override
	public void run () {
		//JFrame
		_frame = new JFrame("Sensitive Messages");
		//Entry Field
		JPanel entry = new JPanel();
		entry.setLayout(new GridLayout(1, 2));
		_textField = new JTextField("Type a message...");
		JButton button = new JButton("Translate");
		button.addActionListener(new TranslateActionListener(_model));
		entry.add(_textField);
		entry.add(button);
		//Return Field
		_message = new JTextPane();
		//Add to the JFrame
		_frame.getContentPane().setLayout(new GridLayout(2,1));
		_frame.add(_message);
		_frame.add(entry);
	

		//DO NOT TOUCH!
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.pack();
		_frame.setVisible(true);
	}
	
	public String getEntry () {
		String entry = _textField.getText();
		_textField.setText(null);
		return entry;
	}
	
	public void printOut (String s) {
		_message.setText(s);
	}
	
}
