/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;


public class Sin extends PrefixOperation {
	
	public Sin( Operation op ){
		super(op);
	}
	
	public Sin( String arg)
		throws ParseException{
		super(arg);
	}
	@Override
	public double value(Point p) {
		return Math.sin( argument.value(p) );
	}
	
}
