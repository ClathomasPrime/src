/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;


/**
 *
 * @author jamesthomas
 */
public abstract class InfixOperation extends Operation {

	protected Operation L;
	protected Operation R;
	
	public InfixOperation( Operation argL, Operation argR ){
		L = argL;
		R = argR;
	}
	
	public InfixOperation( String argL, String argR) 
			throws ParseException{
		L = Operation.parseInput(argL);
		R = Operation.parseInput(argR);
	}
	
	public static Operation getInfixOperation(String op, String argL, String argR)
			throws ParseException {
		
		if( "+".equals(op) ){
			return new Sum(argL, argR);
			
		} else if ("-".equals(op)){
			return new Difference(argL, argR);
			
		} else if ("*".equals(op)){
			return new Product(argL, argR);
			
		} else if ("/".equals(op)){
			return new Quotient(argL, argR);
			
		} else if ("^".equals(op)){
			return new Power(argL, argR);
		} else {
			throw new ParseException("THIS SHOULD NEVER HAPPEN, "
					+ "Strange error in getInfixOperation");
		}
	}
	
}
