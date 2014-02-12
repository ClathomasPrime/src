/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

/**
 *
 * @author jamesthomas
 */
public class Board extends JPanel{
	
	public Board(){
		addMouseListener ( new ClickListener() );
	}
	
	@Override 
	public void paintComponent( Graphics g){
		Graphics2D g2 = (Graphics2D) g ;
		
		g2.draw( new Ellipse2D.Double(10,00,100,100));
		
		DiffGraph.window.equations.paintTo( g2 );
	}
	
	private class ClickListener implements MouseListener{
		
		private MouseEvent clickDown;
		
		@Override
		public void mouseClicked(MouseEvent me) {
			System.out.println("clicked");
			clickDown = me;
		}
		@Override
		public void mousePressed(MouseEvent me) {
			
		}
		@Override
		public void mouseReleased(MouseEvent me) {
			try {
				double x0 = clickDown.getX();
				double y0 = clickDown.getY();
				System.out.println(me.getX()-x0);
				System.out.println("   " + (me.getY()-y0) );
			} catch ( NullPointerException ex ){
				
			}
		}
		@Override
		public void mouseEntered(MouseEvent me) {
			
		}
		@Override
		public void mouseExited(MouseEvent me) {
			
		}
	}
	
}
