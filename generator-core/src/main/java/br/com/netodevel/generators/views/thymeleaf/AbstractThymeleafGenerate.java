package br.com.netodevel.generators.views.thymeleaf;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cglib.beans.BeanCopier.Generator;
import org.springframework.util.StringUtils;

import br.com.netodevel.core.Attribute;
import br.com.netodevel.core.GeneratorConstants;
import br.com.netodevel.core.ReadScaffoldInfo;
import br.com.netodevel.helpers.ParametersHelper;

/**
 * @author NetoDevel
 */
public class AbstractThymeleafGenerate extends ReadScaffoldInfo {
	
	public String generateThParameters(String parameters) {
		String [] params = ParametersHelper.extractParameter(parameters);
		List<String> listParameters = ParametersHelper.convertToList(params);
		
		String result = listParameters.stream()
					  .map(this::generateTh)
					  .collect(Collectors.joining());
		
		String thAction = GeneratorConstants.INDENT_HTML + " <th>Action</th>";
		return result + thAction;
	}
	
	/**
	 * Code Result:
	 *   <th> Name </th>
	 * @param param
	 * @return
	 */
	public String generateTh(String param) {
		String[] paramSplit = param.split(":");
		String name = StringUtils.capitalize(paramSplit[0]);

		String code = GeneratorConstants.INDENT_HTML + " <th>" + name + "</th> \n";
		return code;
	}
	
	public String generateTdParameters(String className, String parameters) {
		String [] params = ParametersHelper.extractParameter(parameters);
		List<String> listParameters = ParametersHelper.convertToList(params);

		String result = listParameters.stream()
				  .map(param -> generateTd(className, param))
				  .collect(Collectors.joining());
		
		return result + generateTdLinks(className);
	}
	
	/**
	 * Code Result:
	 * 	 <td th:text="${user.name}"></td> 
	 * @param className
	 * @param parameters
	 * @return
	 */
	public static String generateTd(String className, String parameters) {
		Attribute attribute = ParametersHelper.extractNameAndType(parameters);
		String code = GeneratorConstants.INDENT_HTML + " <td th:text=\"${" + className.toLowerCase() + "." + attribute.getName() + "}\"></td> \n";
		return code;
	}
	
	/**
	 * Code Result:
	 * 	<td>
	 * 		 <a th:href="@{/users/{id}(id = ${user.id})}">Show</a> 
     *		 <a th:href="@{/users/{id}/edit(id = ${user.id})}">Edit</a> 
     *		 <a href="#">Destroy</a> 
     *	</td>
	 * @param className
	 * @return
	 */
	public static String generateTdLinks(String className) {
		String code = GeneratorConstants.INDENT_HTML + " <td>\n"
							+ GeneratorConstants.INDENT_HTML + "\t  <a th:href=\"@{/"+ className.toLowerCase() + "s/{id}(id = " + "${" + className.toLowerCase() + ".id}" + ")}\">Show</a> \n"
							+ GeneratorConstants.INDENT_HTML + "\t  <a th:href=\"@{/"+ className.toLowerCase() + "s/{id}/edit(id = " + "${" + className.toLowerCase() + ".id}" + ")}\">Edit</a> \n"
							+ GeneratorConstants.INDENT_HTML + "\t  <a href=\"#\">Destroy</a> \n"
							+ GeneratorConstants.INDENT_HTML + " </td>";
		return code;
	}
	
	public static String generateInputParameters(String parameters) {
		String [] params = ParametersHelper.extractParameter(parameters);
		List<String> listParameters = ParametersHelper.convertToList(params);

		return listParameters.stream()
				  .map(p -> genereateInput(p))
				  .collect(Collectors.joining());
	}
	
	/**
	 * Result code:
		<div class="form-group"> 
		 <label for="name">Name</label>  
		 <input id="name" name="name" type="text" class="form-control" th:field="*{name}" />  
		</div> 
	 * @param param
	 * @return
	 */
	public static String genereateInput(String param) {
		Attribute attribute = ParametersHelper.extractNameAndType(param);
		String code = "\t\t\t <div class=\"form-group\"> \n" +
					  "\t\t\t   <label for=\""+ attribute.getName() +"\">"+ StringUtils.capitalize(attribute.getName()) +"</label>  \n" +
				  	  "\t\t\t   <input id=\""+ attribute.getName() +"\" name=\"" + attribute.getName() + "\" type=\"text\" class=\"form-control\" th:field=\"*{"+ attribute.getName() +"}\" />  \n" +
					  "\t\t\t </div> \n";
		return code;
	}

	
	public static String generateShowParameters(String className, String parameters) {
		String [] params = ParametersHelper.extractParameter(parameters);
		List<String> listParameters = ParametersHelper.convertToList(params);

		String result = listParameters.stream()
				  .map(param -> generateShow(className, param))
				  .collect(Collectors.joining());
		return result;
	}
	
	/**
	 * Code Result:
	 	<div class="form-group"> 
		 <label for="name">Name</label>  
		 <span th:text="${user.name}"></span> 
		</div> 
	 * @param className
	 * @param param
	 * @return
	 */
	public static String generateShow(String className, String param) {
		Attribute attribute = ParametersHelper.extractNameAndType(param);
		String code = GeneratorConstants.INDENT_HTML_SHOW + "<div class=\"form-group\"> \n" +
				  		GeneratorConstants.INDENT_HTML_SHOW + "\t <label for=\""+ attribute.getName() +"\">"+ StringUtils.capitalize(attribute.getName()) +"</label>  \n" +
					  	GeneratorConstants.INDENT_HTML_SHOW + "\t <span th:text=\"${" + className.toLowerCase() + "." + attribute.getName() + "}\"></span> \n" +
					  	GeneratorConstants.INDENT_HTML_SHOW + "</div> \n";
		return code;
	}
	
}