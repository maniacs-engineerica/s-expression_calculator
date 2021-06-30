package calculator;

public class Utils {

	public static boolean isInteger(String aString) {
		if (aString == null) {
	        return false;
	    }
	    try {
	        Integer.parseInt(aString);
	    } catch (NumberFormatException e) {
	        return false;
	    }
	    return true;
	}
	
}
