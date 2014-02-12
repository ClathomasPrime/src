/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;


public class Tan extends PrefixOperation {

	public Tan( Operation op ){
		super(op);
	}
	
	public Tan( String arg)
		throws ParseException{
		super(arg);
	}
	@Override
	public double value(Point p) {
		return Math.tan( argument.value(p) );
	}
	
	
}
