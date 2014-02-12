/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diffgraph;

/**
 *
 * @author jamesthomas
 */
public abstract class Operation {
	
	/**public Operation(){
		//Actually, this shouldn't do anything at all...
	}*/
	
	public abstract double value( Point p );
	
	static Operation parseInput( String input ) 
			throws ParseException {
		
		String s = input.replaceAll("\\s+","").toLowerCase();
		
		if( "x".equals(s) ){
			return new XIdentity();
		} else if( "y".equals(s) ){
			return new YIdentity();
		}
		
		try{
			double v = Double.parseDouble(s);
			return new Number(v);
		} catch( NumberFormatException er){
			
		}
		
		/*
		 * Presidence table:
		 *		+   0
		 *		-   1
		 *		*	2
		 *		/	3
		 *		^	4
		 * parenLevel starts at 0 and increases with (, decreases with )
		 * maxPres starts at infinity and goes to minimum found
		 */
		int parenLevel = 0;
		int minPres = Integer.MAX_VALUE;
		int currentBreak = -1;
		int firstParenIndex = -1;
		boolean hasEncounteredParen = false;
		for( int i=0; i<input.length(); i++ ){
			char c = input.charAt(i);
			switch( c ){
				case '(':
					parenLevel++;
					if( ! hasEncounteredParen){
						firstParenIndex = i;
						hasEncounteredParen = true;
					}
					break;
				case ')':
					parenLevel++;
					break;
				default: 
					if( parenLevel==0 ){
						try {
							int currentPres = getPresidence( c );
							if ( currentPres<=minPres ){ //SET CURRENT AS NEW BREAKPOINT
								currentBreak = i;
								minPres = currentPres;
							}
						} catch ( NotInfix ex ){
							//well.... idk just skip it. In legal input, it should either be
								//at the begining or a number or identity
						}
					}
					break;
			}
		}
		if( currentBreak == -1){ //No breakpoint found -> prefix, null parens, or invalid
			try {
				
				Operation op = PrefixOperation.getPrefixOperation(
						s.substring(0,firstParenIndex),
						s.substring(firstParenIndex+1,s.length()-1));
					//either returns succesfully, catch NullParens, or throws ParseError up stack
				if(')'!=input.charAt(input.length()-1) ){ //this bit of error checking needs some work
					throw new ParseException();
				}
				return op;
				//return op;
			} catch( NullParensException ex){
				return parseInput( input.substring(1,input.length()-1) );
			}
		} else { //Infix operation found
			return InfixOperation.getInfixOperation(
					s.substring(currentBreak,currentBreak+1), 
					s.substring(0,currentBreak), 
					s.substring(currentBreak+1) );
		}
		
		//throw new ParseException("I didn't catagorize it as anything...");
		//return new Sum();
	}
	
	private static int getPresidence(char inf) 
			throws NotInfix{
		/*
		 * Presidence table:
		 *		+   0
		 *		-   1
		 *		*	2
		 *		/	3
		 *		^	4
		 */
		switch( inf ){
			case '+' :
				return 0;
			case '-' :
				return 1;
			case '*' :
				return 2;
			case '/' :
				return 3;
			case '^' :
				return 4;
			default:
				throw new NotInfix( inf );
		}
	}
	
	private static class NotInfix extends Exception{
		public NotInfix( char c ){
			//System.out.println(c);
		}
	}
}
