/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;

/**
 *
 * @author jamesthomas
 */
public class ParseException extends Exception {

	/**
	 * Creates a new instance of
	 * <code>ParseException</code> without detail message.
	 */
	public ParseException() {
	}

	/**
	 * Constructs an instance of
	 * <code>ParseException</code> with the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public ParseException(String msg) {
		super(msg);
	}
}
