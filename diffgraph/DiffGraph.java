/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author jamesthomas
 */
public class DiffGraph extends JFrame{
	
	public static DiffGraph window;
	
	public Board board;
	public EquationList equations;
	public Bounds bounds;
	
	public DiffGraph(){
		this.setSize(700,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Deriver and Grapher");
		
		this.setVisible(true);
		
		this.setLayout( new BorderLayout(10,10) );
		
		board = new Board();
		this.add( board, BorderLayout.CENTER);
		
		equations = new EquationList();
		this.add( equations, BorderLayout.WEST);
		
		//bounds = new Bounds();
		//this.add( bounds);
		
		this.setVisible(true);
		
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
		window = new DiffGraph();
		
		/*String str = "(12+234";
		String prefix = str.substring( 0,str.indexOf("(") );
		String bulk = str.substring( str.indexOf("(")+1, -1 );
		System.out.println(prefix);
		System.out.println(bulk);*/
		
		try {
			Operation oper = Operation.parseInput("ln(x*y^2+2-x/y)");
			double a = oper.value(new Point(1,5) );
			System.out.println(a);
		} catch (ParseException fail){
			System.out.println("parse exception reached the top");
			//System.out.println( fail.getStackTrace().toString() );
			fail.printStackTrace(System.out);
		}
	}
}
