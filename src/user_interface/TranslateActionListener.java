package user_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Model;

public class TranslateActionListener implements ActionListener {

	Model _model;
	
	public TranslateActionListener (Model m) {
		_model = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		_model.start();
	}

}
