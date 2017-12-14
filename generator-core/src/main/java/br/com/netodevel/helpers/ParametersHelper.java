package br.com.netodevel.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.netodevel.core.Attribute;
import br.com.netodevel.core.GeneratorConstants;

/**
 * @author NetoDevel
 * @author IvanMarreta
 */
public class ParametersHelper {

	public static List<String> extractParametersList(String parameters) {
		String[] separator = ParametersHelper.extractParameter(parameters);
		return ParametersHelper.convertToList(separator);
	}
	
	public static String[] extractParameter(String parameters) {
		String[] separator = parameters.split(GeneratorConstants.SPACE);
		return separator;
	}
	
	public static List<String> convertToList(String[] parameters) {
		return new ArrayList<String>(Arrays.asList(parameters));
	}
	
	public static Attribute extractNameAndType(String param) {
		String [] nameAndType = param.split(":");
		return new Attribute(nameAndType[0], nameAndType[1]);
	}
	
}
