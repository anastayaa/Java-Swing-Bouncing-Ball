package bouncingBall;

import java.awt.BorderLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Entete extends JPanel{
	
	JMenuBar menuBar;
	JMenu forme, vitesseRotation, vitesseDimentionnement;
	JMenuItem circleMenuItem, rectangeMenuItem, vitesseLenteMenuItem, vitesseMoyenMenuItem, vitesseRapideMenuItem,
	dimLentMenuItem, dimMoyenMenuItem, dimRapideMenuItem;
	
	public Entete() {

		/**
		 * Le layout manager de la fenetre
		 */
		this.setLayout(new BorderLayout());
		
		menuBar=new JMenuBar();
		
		forme=new JMenu("Form");
		vitesseRotation=new JMenu("Vitesse de rotaion");
		vitesseDimentionnement=new JMenu("Vitesse de dimensionnement");
		
		circleMenuItem=new JMenuItem("Circle");
		rectangeMenuItem=new JMenuItem("Rectangle");
		vitesseLenteMenuItem=new JMenuItem("Lente");
		vitesseMoyenMenuItem=new JMenuItem("Moyen");
		vitesseRapideMenuItem=new JMenuItem("Rapide");
		dimLentMenuItem=new JMenuItem("Lent");
		dimMoyenMenuItem=new JMenuItem("Moyen");
		dimRapideMenuItem=new JMenuItem("Rapide");
		
		forme.add(circleMenuItem);
		forme.add(rectangeMenuItem);
		
		vitesseRotation.add(vitesseLenteMenuItem);
		vitesseRotation.add(vitesseMoyenMenuItem);
		vitesseRotation.add(vitesseRapideMenuItem);
		
		vitesseDimentionnement.add(dimLentMenuItem);
		vitesseDimentionnement.add(dimMoyenMenuItem);
		vitesseDimentionnement.add(dimRapideMenuItem);
		
		menuBar.add(forme);
		menuBar.add(vitesseRotation);
		menuBar.add(vitesseDimentionnement);
	
		add(menuBar, BorderLayout.NORTH);
	}

	public JMenuItem getCircleMenuItem() {
		return circleMenuItem;
	}

	public JMenuItem getRectangeMenuItem() {
		return rectangeMenuItem;
	}

	public JMenu getVitesseRotation() {
		return vitesseRotation;
	}

	public void setVitesseRotation(JMenu vitesseRotation) {
		this.vitesseRotation = vitesseRotation;
	}

	public JMenuItem getVitesseLenteMenuItem() {
		return vitesseLenteMenuItem;
	}

	public JMenuItem getVitesseMoyenMenuItem() {
		return vitesseMoyenMenuItem;
	}

	public JMenuItem getVitesseRapideMenuItem() {
		return vitesseRapideMenuItem;
	}

	public JMenuItem getDimLentMenuItem() {
		return dimLentMenuItem;
	}

	public JMenuItem getDimMoyenMenuItem() {
		return dimMoyenMenuItem;
	}

	public JMenuItem getDimRapideMenuItem() {
		return dimRapideMenuItem;
	}

}
