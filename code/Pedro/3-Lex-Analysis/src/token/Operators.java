package token;

import java.util.Arrays;
import java.util.List;

/**
* @author Pedro Miguel Lagüera Cabrera
* Email: laguerapedro@gmail.com
* Mar 16, 2017
* Operators.java
*/
public class Operators {
	
	private List<String> operators;			/* Contains all available operators */
	
	public Operators(){
		operators = Arrays.asList(	"=", "+", "-", "*", "/", "%",
										"++", "--", "!", "==", "!=", ">", ">=", "<", "<=", "&&", "||",
										"~", "<<", ">>", ">>>", "&", "^", "|",
										"+=", "-=", "*=", "/=", "%=", "<<=", ">>=", "&=", "^=", "|=", "===");
	}
	
	/** @return true if  @param word is inside oparators */
	public boolean contains(String word){
		return operators.contains(word);
	}

}
