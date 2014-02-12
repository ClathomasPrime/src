/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;


public class Quotient extends InfixOperation {

	public Quotient(Operation argL, Operation argR) {
		super(argL, argR);
	}

	public Quotient(String argL, String argR) throws ParseException {
		super(argL, argR);
	}

	@Override
	public double value(Point p) {
		return L.value(p) / R.value(p);
	}	
}
