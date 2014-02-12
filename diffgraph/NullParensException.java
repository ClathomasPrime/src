/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;

/**
 *
 * @author jamesthomas
 */
public class NullParensException extends Exception {

	/**
	 * Creates a new instance of
	 * <code>NullParensException</code> without detail message.
	 */
	public NullParensException() {
	}

	/**
	 * Constructs an instance of
	 * <code>NullParensException</code> with the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public NullParensException(String msg) {
		super(msg);
	}
}
