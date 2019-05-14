package bouncingBall;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ConteneurBall extends JPanel implements ActionListener{
	
	/*
	 * Le thread Timer
	 */
	private Timer timer;
	
	Ball bigBall, smallBall;
	Rectangle rectangle;
	Graphics2D g2d;
	

	double MAXHEIGHT, MAXWIDTH;
	/**
	 * Valeur initiales:
	 * La longueur minimale et la largeur minimale
	 */
	double MINHEIGHT=80, MINWIDTH=80;
	/**
	 * vitesse de redimentionnement
	 */
	double VITESSEREDIMENTIONNEMENT=5;
	/*
	 * vitesse de rotation
	 */
	double VITESSEROTATION=10;
	
	boolean increment=true;
	
	boolean isCircle=true, isRectangle=false;
	
	int alpha=0;
	
	public ConteneurBall() {
		/**
		 * init
		 */
		bigBall=new Ball(80, 80, 20, 20, 20);
		smallBall=new Ball(230, 130, 20, 20, 20);
		rectangle=new Rectangle(60, 60);
		
		timer=new Timer(10, this);
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		
		g2d=(Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		/**
		 * L'arriere plan en noir(le noir est par defaut)
		 */
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		//ball=new Ellipse2D.Double(getWidth()/2 - w/2, getHeight()/2 - h/2, w, h);
		//smallBall=new Ellipse2D.Double(x, y, ws, hs);
		
    	//rectangle=new Rectangle2D.Double(getWidth()/2 - w/2, getHeight()/2 - h/2, w, h);
		
		if(isCircle) {
			circle(g2d);
		}
		else if(isRectangle) {
			rectangle(g2d, rectangle, Color.BLUE);
		}
	}
	
	public void update() {
		
		MAXHEIGHT=getHeight();
		MAXWIDTH=getWidth();
		
		if(isCircle) {
			/**
			 * Animation de la grande balle
			 */
			if(bigBall.y>=MAXHEIGHT || bigBall.x>=MAXWIDTH) {
				increment=false;
			}
			else if(bigBall.y<=MINHEIGHT || bigBall.x<=MINWIDTH) {
				increment=true;
			}
			
			if(increment) {
				bigBall.x=bigBall.x+VITESSEREDIMENTIONNEMENT;
				bigBall.y=bigBall.y+VITESSEREDIMENTIONNEMENT;
			}
			else if(!increment) {
				bigBall.x=bigBall.x-VITESSEREDIMENTIONNEMENT;
				bigBall.y=bigBall.y-VITESSEREDIMENTIONNEMENT;
			}
			
			/**
			 * Animation de la petite balle
			 */
			alpha+=VITESSEROTATION;
			double rads = (alpha * Math.PI) / 180F;
			smallBall.x = (int) ((this.getWidth() / 2 - smallBall.radius / 2 ) + Math.round((smallBall.radius + 20) * Math.cos(rads)));
			smallBall.y = (int) ((this.getHeight() / 2 - smallBall.radius / 2 ) - Math.round((smallBall.radius + 20) * Math.sin(rads)));
		}
		else if(isRectangle) {
			if(rectangle.longueur>=MAXHEIGHT || rectangle.largueur>MAXWIDTH) {
				increment=false;
			}
			else if(rectangle.longueur<=MINHEIGHT || rectangle.largueur<=MINWIDTH) {
				increment=true;
			}
			
			if(increment) {
				rectangle.largueur=rectangle.largueur+VITESSEREDIMENTIONNEMENT;
				rectangle.longueur=rectangle.longueur+VITESSEREDIMENTIONNEMENT;
			}
			else if(!increment) {
				rectangle.largueur=rectangle.largueur-VITESSEREDIMENTIONNEMENT;
				rectangle.longueur=rectangle.longueur-VITESSEREDIMENTIONNEMENT;
			}
		}
		
		repaint();
	}
	
	public void circle(Graphics2D g2d)
    {	
		g2d.setColor(Color.red);
		/**
		 * creer un cercle dans le centre de la fenetre
		 */
		g2d.fill(new Ellipse2D.Double(getWidth()/2 - bigBall.x/2, getHeight()/2 - bigBall.y/2, bigBall.x, bigBall.y));
		
		/**
		 * creer un cercle a l'interieur d'un autre
		 */
		g2d.setColor(Color.white);
		
		g2d.fill(new Ellipse2D.Double(smallBall.x, smallBall.y, smallBall.radius, smallBall.radius));
    }
	
    public void rectangle(Graphics2D g2d, Rectangle rectangle, Color color)
    {
    	g2d.setColor(color);
    	/**
    	 * creer un rectangle dans le centre de la fenetre
    	 */
    	g2d.fill(new Rectangle2D.Double(getWidth()/2 - rectangle.longueur/2, getHeight()/2 - rectangle.largueur/2, rectangle.longueur, rectangle.largueur));
    }
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();	
	}

	public Timer getTimer() {
		return timer;
	}

}
