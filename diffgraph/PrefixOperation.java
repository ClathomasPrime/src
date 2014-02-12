/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;

/**
 *
 * @author jamesthomas
 */
public abstract class PrefixOperation extends Operation {
	
	protected Operation argument;
	
	public PrefixOperation( Operation op ){
		argument = op;
	}
	
	public PrefixOperation( String arg) 
			throws ParseException{
		argument = Operation.parseInput(arg);
	}
	
	public static Operation getPrefixOperation( String prefix, String argument ) 
			throws ParseException, NullParensException{ 
			//this may need some work for error checking
		if( "".equals(prefix) ){
			throw new NullParensException();
			
		} else if ("sin".equals(prefix)){
			return new Sin(argument);
			
		} else if ("cos".equals(prefix)){
			return new Cos(argument);
			
		} else if ("tan".equals(prefix)){
			return new Tan(argument);
			
		} else if ("ln".equals(prefix)){
			return new Ln(argument);
		}
		throw new ParseException("Unrecognized, but possibly present prefix");
	}
	
}
