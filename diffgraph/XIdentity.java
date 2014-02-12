/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;

/**
 *
 * @author jamesthomas
 */
public class XIdentity extends Operation{
	public XIdentity(){
		
	}

	@Override
	public double value(Point p) {
		return p.getX();
	}
}
