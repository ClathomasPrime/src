/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;

/**
 *
 * @author jamesthomas
 */
public class YIdentity extends Operation{
	public YIdentity(){
		
	}

	@Override
	public double value(Point p) {
		return p.getY();
	}
}
