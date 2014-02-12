/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;

/**
 *
 * @author jamesthomas
 */
public class Number extends Operation{
	
	private double value;
	
	public Number(double val){
		value = val;
	}
	
	@Override
	public double value(Point p) {
		return value;
	}
	
}
