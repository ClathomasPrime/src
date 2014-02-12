/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;

/**
 *
 * @author jamesthomas
 */
public class Sum extends InfixOperation{

	public Sum(Operation argL, Operation argR) {
		super(argL, argR);
	}

	public Sum(String argL, String argR) throws ParseException {
		super(argL, argR);
	}

	@Override
	public double value(Point p) {
		return L.value(p) + R.value(p);
	}
	
}
