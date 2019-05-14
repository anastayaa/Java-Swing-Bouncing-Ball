package bouncingBall;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Bas extends JPanel{
	
	private JButton startButton, stopButton;
	public Bas() {

		startButton=new JButton("Start");
		stopButton=new JButton("Stop");
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		add(startButton);
		add(stopButton);
		
	}
	
	public JButton getStartButton() {
		return startButton;
	}
	public JButton getStopButton() {
		return stopButton;
	}

}
