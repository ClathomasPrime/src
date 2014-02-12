/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;


public class Power extends InfixOperation {
	
	public Power(Operation argL, Operation argR) {
		super(argL, argR);
	}

	public Power(String argL, String argR) throws ParseException {
		super(argL, argR);
	}

	@Override
	public double value(Point p) {
		return Math.pow( L.value(p), R.value(p) );
	}	
}
