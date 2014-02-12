/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;

import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author jamesthomas
 */
public class EquationList extends JPanel{
	
	private LinkedList<EquationField> list = new LinkedList<EquationField>();
	private int counter = 1;
	
	private Scale scale = new Scale(-1,-1,1,1);
	
	public EquationList(){
		setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );
		
		ActionListener graphListener = new ActionListener(){
			@Override
			public void actionPerformed( ActionEvent e){
				update();
			}
		};
		JButton graphButton = new JButton("graph");
		graphButton.addActionListener(graphListener);
		add( graphButton );
		
		EquationField eq1 = new EquationField(1);
		add( eq1);
		list.add(eq1);
		
		setSize( this.getPreferredSize() );
	}
	
	private void update(){
		for( EquationField ef : list){
			ef.update();
		}
	}
	
	private void updateNumbering(){
		int i = 1;
		for( EquationField e : list ){
			e.setNumberTo( i++ );
		}
	}
	
	public void paintTo( Graphics2D g){
		scale.drawAxis(g);
		for( EquationField eq : list ){
			eq.drawTo( g);
		}
	}
	
	public class EquationField extends JPanel {
		
		private JTextField equationText;
		private JLabel numberLabel;
		
		private SlopeField slopeField;
		
		public EquationField(int number){
			this.setLayout( new BoxLayout(this, BoxLayout.X_AXIS) );
			
			numberLabel = new JLabel( Integer.toString(number) );
			add( numberLabel );
			
			equationText = new JTextField( 10);
			add( equationText );
			
			RemoveListener removeListener = new RemoveListener( this );
			JButton removeButton = new JButton("X");
			removeButton.addActionListener(removeListener);
			add( removeButton );
			
			setMaximumSize( this.getPreferredSize() );
		}
		
		public void update(){
			try {
				System.out.println("updating field");
				slopeField = new SlopeField( equationText.getText() );
				
				DiffGraph.window.board.repaint();
			} catch( ParseException er ){
				System.out.println("Code to alert user of error");
			}
		}
		
		public void drawTo( Graphics2D g){
			try {
				slopeField.draw( g , scale);
			} catch (NullPointerException ex){
				
			}
		}
		
		public void setNumberTo( int i){
			numberLabel.setText( Integer.toString(i) );
		}
		
		private class RemoveListener implements ActionListener{
			
			private EquationField equationField;
			
			public RemoveListener(EquationField e){
				super();
				equationField = e;
			}
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("should remove field");
				list.remove( equationField );
			}
			
		}
		
	}
}
