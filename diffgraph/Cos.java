/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;

public class Cos extends PrefixOperation {
	
	public Cos( Operation op ){
		super(op);
	}
	
	public Cos( String arg)
		throws ParseException{
		super(arg);
	}
	@Override
	public double value(Point p) {
		return Math.cos( argument.value(p) );
	}
	
}
