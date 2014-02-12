/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;


public class Ln extends PrefixOperation {

	public Ln( Operation op ){
		super(op);
	}
	
	public Ln( String arg)
		throws ParseException{
		super(arg);
	}
	@Override
	public double value(Point p) {
		return Math.log( argument.value(p) );
	}
	
}
