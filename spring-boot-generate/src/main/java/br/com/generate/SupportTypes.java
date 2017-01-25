package br.com.generate;

import java.util.Arrays;
import java.util.List;


/**
 * @author NetoDevel
 */
public class SupportTypes {

	public List<String> typesSupported = Arrays.asList("String", "Double", "Float", "Long", "Integer", "Short", "Byte", "Char", "Boolean", "Object", "BigDecimal", "Date");
	
	public boolean validate(String parameters, String layer) {
		if (layer.equals(Layers.MODEL)) {
			String[] separator = parameters.split(" ");
			for (int i = 0; i < separator.length; i++) {
				String [] nameAndType = separator[i].split(":");
				if (!typesSupported.contains(nameAndType[1].trim())) {
					System.out.println("Error: type " + nameAndType[1] + " not supported.");
					return false;
				}
			}
		}
		return true;
	}
}
