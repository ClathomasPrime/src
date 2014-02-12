/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
 *
 * @author jamesthomas
 */
public class Scale {
	
	private static final double boardWidth = 400;
	private static final double boardHeight = 400;
	
	private double minX;
	private double minY;
	
	private double scaleX;//These are in pixels/unit
	private double scaleY;
	
	public Scale( Point min, Point max) 
			throws BadBoundsExcpetion {
		if( min.getX()>=max.getX() || min.getY()>=max.getY() ){
			throw new BadBoundsExcpetion();
		}
		minX = min.getX();
		minY = min.getY();
		scaleX = boardWidth / (max.getX() - minX);
		scaleY = boardHeight / (max.getY() - minY);
	}
	public Scale( double minX, double minY, double scaleX, double scaleY){
		this.minX = minX;
		this.minY = minY;
		this.scaleX = scaleX;
		this.scaleY = scaleY;
	}
	public static class BadBoundsExcpetion extends Exception {
		public BadBoundsExcpetion() {
			
		}
		public BadBoundsExcpetion(String msg) {
			super(msg);
		}
	}
	
	public void drawAxis(Graphics2D g){
		Point minX = scale( new Point( 0, this.minY ) );
		Line2D.Double xAxis = new Line2D.Double( minX.getX(), minX.getY(), 
				minX.getX(), minX.getX() + boardHeight );
		Point minY = scale( new Point( this.minX , 0 ) );
		Line2D.Double yAxis = new Line2D.Double( minY.getX(), minY.getY(), 
				minY.getX(), minY.getX() + boardWidth );
		
		g.draw(yAxis);
		g.draw(xAxis);
		
	}
	
	/**
	 * Converts from number point to pixel point
	 * @param p
	 * @return 
	 */
	public Point scale( Point p){
		double xPx = (p.getX()-minX)*scaleX;
		double yPx = boardHeight - ( (p.getY()-minY)*scaleY ) ;
		return new Point( xPx, yPx);
	}
	
	/**
	 * Converts from pixel point to number point
	 * @param p
	 * @return 
	 */
	public Point antiScale( Point p){
		double xU = p.getX()/scaleX + minX;
		double yU = ( boardHeight - p.getY() )/scaleY + minY;
		return new Point( xU, yU);
	}
	
	public class Converter {
		
		private int numPoints;
		private Point point;
		
		public Converter( int num, Point point){
			numPoints = num;
			this.point = point;
		}
		
		public Point toPoint(){
			double x = point.getX();
			double y = point.getY();
			return antiScale( toPixels() );
		}
		public Point toPixels(){
			return new Point(boardWidth/(0.5+numPoints)*point.getX(), 
							boardHeight/(0.5+numPoints)*point.getY() );
		}
		public double dXToPixels( double dx){
			return boardWidth/(0.5+numPoints)*point.getX() + dx*scaleX;
		}
		public double length(){
			return 0.9* antiScale(new Point(boardWidth, boardHeight)).getX() / numPoints;
		}
		
		public double deltaXScale(double dx ){
			return scaleX*dx;
		}
		public double deltaYScale(double dy ){
			return scaleY*dy;
		}
	}
}
