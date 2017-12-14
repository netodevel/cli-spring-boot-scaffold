package br.com.netodevel.generators.java.model;

import static br.com.netodevel.helpers.ParametersHelper.extractNameAndType;
import static br.com.netodevel.helpers.ParametersHelper.extractParametersList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import br.com.netodevel.core.Attribute;
import br.com.netodevel.core.GeneratorConstants;


/**
 * @author NetoDevel
 * @author IvanMarreta
 */
public class ModelGenerateUtils {

	public static String generateImports(String parameters) {
		List<String> parametersList = extractParametersList(parameters);
		
		return parametersList.stream()
				.map(ModelGenerateUtils::getTypeParam)
				.collect(Collectors.joining("\n"));
	}

	public static String generateGettersAndSetters(String parameters) {
		List<String> parametersList = extractParametersList(parameters);
		
		return parametersList.stream()
				.map(ModelGenerateUtils::generateGetterAndSetters)
				.collect(Collectors.joining());
	}
	
	public static String generateParams(String params) {
		List<String> parametersList = extractParametersList(params);
			
		return parametersList.stream()
				.map(ModelGenerateUtils::generateAttribute)
				.collect(Collectors.joining(GeneratorConstants.BREAK_LINE));
	}
	
	public static String generateGetterAndSetters(String param) {
		Attribute attribute = extractNameAndType(param);

		String setter = buildSetter(attribute.getName(), attribute.getType());
		String getter = buildGetter(attribute.getName(), attribute.getType());
		
		return setter + getter;
	}

	public static String getTypeParam(String param) {
		Attribute attribute = extractNameAndType(param);
		return VariableTypeImport.valueOf(attribute.getType().toUpperCase()).path();
	}

	private static String buildGetter(String name, String type) {
		String attribute = StringUtils.capitalize(name);

		String code = "\n\t public " + type + " get" + attribute + "() {\n" 
				      + "\t\t return this." + name + ";\n"
				      + "\t }\n";
		return code;
	}

	private static String buildSetter(String name, String type) {
		String attribute = StringUtils.capitalize(name);

		String code = "\n\t public void set" + attribute + "(" + type + " " + name + ") {\n"
					  + "\t\t this." + name + " = " + name + ";\n"
					  + "\t }\n";
		return code;
	}
	
	public static String generateAttribute(String param) {
		Attribute attributeObj = extractNameAndType(param);

		String column = buildColumn(attributeObj.getName());
		String attribute = buildAttribute(attributeObj.getName(), attributeObj.getType());
		
		String result = column + attribute;
		return result;
	}

	private static String buildAttribute(String name, String type) {
		String code = "\t private " + type + GeneratorConstants.SPACE + name + ";\n";
		return code;
	}

	private static String buildColumn(String name) {
		String code = "\t @column(name=\"" + name + "\")\n";
		return code;
	}
	
	public static void main(String[] args) {
		System.out.println(ModelGenerateUtils.generateGetterAndSetters("name:String idade:Integer date:Date"));
	}
	
}