package token;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pedro Miguel Lagüera Cabrera
 * Email: laguerapedro@gmail.com
 * Mar 16, 2017
 * Keywords.java
 */
public class Keywords {	
	
	private Map<String, String> keywordMap; /* Map containing each keyword (key) and its code (value) */
	
	public Keywords(){
		List<String> keywordArray = Arrays.asList(	"abstract", "continue", "for", 			"new", 			"switch",
													"assert", 	"default", 	"goto", 		"package", 		"synchronized",
													"boolean", 	"do", 		"if", 			"private", 		"this",
													"break", 	"double", 	"implements", 	"protected",	"throw",
													"byte", 	"else", 	"import", 		"public", 		"throws",
													"case", 	"enum", 	"instanceof",	"return", 		"transient",
													"catch", 	"extends", 	"int", 			"short", 		"try",
													"char", 	"final", 	"interface", 	"static", 		"void",
													"class", 	"finally", 	"long", 		"strictfp", 	"volatile",
													"const", 	"float", 	"native", 		"super", 		"while");
		keywordMap = new HashMap<String, String>();
		for(String i : keywordArray)
			keywordMap.put(i, "KW" + i.toUpperCase());
	}
	
	/** @return true if  @param word is inside keywordMap */
	public boolean contains(String word){
		return keywordMap.containsKey(word);
	}
	
	/** @return keyword code for @param word */
	public String get(String word){
		return keywordMap.get(word);
	}
		
}
