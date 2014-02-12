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
public class SlopeField {
	
	Function func;
	
	public SlopeField( String textInput) 
			throws ParseException{
		func = new Function( textInput );
	}
	
	public void draw( Graphics2D g, Scale s){
		int numPoints = 10;
		for( int i=0; i<numPoints; i++){
			for( int j=0; j<numPoints; j++){
				drawSlope( g, s.new Converter( numPoints, 
											   new Point(i,j) ) );
			}
		}
	}
	private void drawSlope(Graphics2D g, Scale.Converter con ){
		Point p = con.toPoint();
		double m = func.value( p );
		double dx = 4/Math.sqrt(1+ m*m);
		double dy= Math.sqrt( 1-dx*dx );
		
		Point px = con.toPixels();
		
		Line2D.Double line = new Line2D.Double( px.getX()-con.deltaXScale(dx), px.getY()-con.deltaYScale(dy),
				px.getX()+con.deltaXScale(dx), px.getY()+con.deltaYScale(dy) );
		
		g.draw( line );
		
	}
}
