/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;


public class Product extends InfixOperation {
	
	public Product(Operation argL, Operation argR) {
		super(argL, argR);
	}

	public Product(String argL, String argR) throws ParseException {
		super(argL, argR);
	}
	
	@Override
	public double value(Point p) {
		return L.value(p) * R.value(p);
	}

}
