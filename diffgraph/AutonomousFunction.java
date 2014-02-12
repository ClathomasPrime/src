/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;

/**
 *
 * @author jamesthomas
 */
public class AutonomousFunction extends Function{
	
	public AutonomousFunction(Operation oper){
		super(oper);
	}
	public AutonomousFunction(String input) throws ParseException{
		super(input);
	}
}
