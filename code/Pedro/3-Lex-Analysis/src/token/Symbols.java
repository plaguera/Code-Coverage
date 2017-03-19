package token;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pedro Miguel Lagüera Cabrera
 * Email: laguerapedro@gmail.com
 * Mar 16, 2017
 * Symbols.java
 */
public class Symbols {	
	
	private Map<String, String> symbolMap;			/* Map containing each symbol (key) and its code (value) */
	
	public Symbols(){
		symbolMap = new HashMap<String, String>();
		symbolMap.put("(", "OPAR");
		symbolMap.put(")", "CPAR");
		symbolMap.put("[", "OBRACKET");
		symbolMap.put("]", "CBRACKET");
		symbolMap.put(",", "COMMA");
		symbolMap.put(".", "DOT");
		symbolMap.put(";", "SEMICOLON");
		symbolMap.put(":", "COLON");
		symbolMap.put("{", "OBRACE");
		symbolMap.put("}", "CBRACE");
		
	}
	
	/** @return true if  @param word is inside sybolMap */
	public boolean contains(String word){
		return symbolMap.containsKey(word);
	}
	
	/** @return symbol code for @param word */
	public String get(String word){
		return symbolMap.get(word);
	}
		
}
