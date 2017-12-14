package br.com.netodevel.helpers;

/**
 * @author NetoDevel
 */
public class TextHelper {

	public static boolean isTextNull(String value) {
		if (value == null || value.equals("")) {
			return true;
		} else {
			return false;
		}
	}
	
}
