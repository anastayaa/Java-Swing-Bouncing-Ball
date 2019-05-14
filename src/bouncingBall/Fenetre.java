package bouncingBall;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	
	Entete entete;
	Bas bas;
	ConteneurBall conteneurBall;
	
	EcouteurConteneurBall ecouteurConteneurBall;
	
	public Fenetre() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		/**
		 * Pour centrer la fenetre dans le screen
		 */
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		entete=new Entete();
		bas=new Bas();
		conteneurBall=new ConteneurBall();
		
		ecouteurConteneurBall=new EcouteurConteneurBall(entete, conteneurBall, bas);
		
		entete.getCircleMenuItem().addActionListener(ecouteurConteneurBall);
		entete.getRectangeMenuItem().addActionListener(ecouteurConteneurBall);
		entete.getDimLentMenuItem().addActionListener(ecouteurConteneurBall);
		entete.getDimMoyenMenuItem().addActionListener(ecouteurConteneurBall);
		entete.getDimRapideMenuItem().addActionListener(ecouteurConteneurBall);
		entete.getVitesseLenteMenuItem().addActionListener(ecouteurConteneurBall);
		entete.getVitesseMoyenMenuItem().addActionListener(ecouteurConteneurBall);
		entete.getVitesseRapideMenuItem().addActionListener(ecouteurConteneurBall);
		bas.getStartButton().addActionListener(ecouteurConteneurBall);
		bas.getStopButton().addActionListener(ecouteurConteneurBall);
		
		
		/**
		 * Le layout manager de la fenetre
		 */
		setLayout(new BorderLayout());
		add(entete, BorderLayout.NORTH);
		add(conteneurBall, BorderLayout.CENTER);
		add(bas, BorderLayout.SOUTH);
		
	    setVisible(true);
		
	}

}
