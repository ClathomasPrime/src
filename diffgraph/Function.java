/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;

/**
 *
 * @author jamesthomas
 */
public class Function {
	
	private Operation func;
	
	public Function( Operation oper ){
		func = oper;
	}
	public Function( String input ) 
			throws ParseException {
		func = Operation.parseInput( input );
	}
	public double value( Point p){
		return func.value(p);
	}
}
