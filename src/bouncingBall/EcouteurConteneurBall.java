package bouncingBall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurConteneurBall implements ActionListener{
	
	Entete entete;
	ConteneurBall conteneurBall;
	Bas bas;
	
	public EcouteurConteneurBall(Entete entete, ConteneurBall conteneurBall, Bas bas) {
		this.entete=entete;
		this.conteneurBall=conteneurBall;
		this.bas=bas;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/**
		 * Start Stop button
		 */
		if(e.getSource().equals(bas.getStartButton())) {
			if(!conteneurBall.getTimer().isRunning()) {
				conteneurBall.getTimer().start();
			}	
		}
		else if(e.getSource().equals(bas.getStopButton())) {
			if(conteneurBall.getTimer().isRunning()) {
				conteneurBall.getTimer().stop();
			}
		}
		
		/**
		 * Pour changer la forme
		 */
		if(e.getSource().equals(entete.getCircleMenuItem())) {
			conteneurBall.isCircle=true;
			conteneurBall.isRectangle=false;
		}
		else if(e.getSource().equals(entete.getRectangeMenuItem())) {
			conteneurBall.isRectangle=true;
			conteneurBall.isCircle=false;
		}
		
		/**
		 * Pour changer la vitesse de redimentionnement
		 */
		if(e.getSource().equals(entete.getDimLentMenuItem())) {
			conteneurBall.VITESSEREDIMENTIONNEMENT=2;
		}
		else if(e.getSource().equals(entete.getDimMoyenMenuItem())) {
			conteneurBall.VITESSEREDIMENTIONNEMENT=5;
		}
		else if(e.getSource().equals(entete.getDimRapideMenuItem())) {
			conteneurBall.VITESSEREDIMENTIONNEMENT=8;
		}
		
		/**
		 * Pour changer la vitesse de rotation
		 */
		if(e.getSource().equals(entete.getVitesseLenteMenuItem())) {
			conteneurBall.VITESSEROTATION=5;
		}
		else if(e.getSource().equals(entete.getVitesseMoyenMenuItem())) {
			conteneurBall.VITESSEROTATION=10;
		}
		else if(e.getSource().equals(entete.getVitesseRapideMenuItem())) {
			conteneurBall.VITESSEROTATION=20;
		}
	}

}
