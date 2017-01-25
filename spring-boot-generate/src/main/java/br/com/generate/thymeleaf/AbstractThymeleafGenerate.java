package br.com.generate.thymeleaf;

import br.com.generate.ReadScaffoldInfo;


/**
 * @author NetoDevel
 */
public abstract class AbstractThymeleafGenerate extends ReadScaffoldInfo {

	public String generateThParameters(String parameters) {
		String [] params = parameters.split(" ");
		String thParameters = "";
		
		for (int i = 0; i < params.length; i++) {
			String [] nameAndType = params[i].split(":");
			thParameters += "<th>" + nameAndType[0] + "</th> \n";
		}

		thParameters += "<th>Action</th>";
		return thParameters;
	}
	
	public String generateTdParameters(String className, String parameters) {
		String [] params = parameters.split(" ");
		String tdParameters = "";
		for (int i = 0; i < params.length; i++) {
			String [] nameAndType = params[i].split(":");
			tdParameters += "<td th:text=\"${" + className.toLowerCase() + "." + nameAndType[0] + "}\"></td> \n";
		}
		tdParameters += "<td><a th:href=\"@{/"+ className.toLowerCase() + "s/" + "${" + className.toLowerCase() + ".id}" + "/update}\">update</a></td>";
		return tdParameters;
	}

	public String generateInputParameters(String parameters) {
		String inputParameters = "";
		String [] params = parameters.split(" ");
		for (int i = 0; i < params.length; i++) {
			String [] nameAndType = params[i].split(":");
			
			inputParameters += "<div class=\"form-group\"> \n";
			inputParameters += "	<label for=\""+ nameAndType[0] +"\">"+ nameAndType[0] +"</label>  \n";
			inputParameters += "	<input id=\""+ nameAndType[0] +"\" name=\"" + nameAndType[0] + "\" type=\"text\" class=\"form-control\" th:field=\"*{"+ nameAndType[0] +"}\" />  \n";
			inputParameters += "</div> \n";
			inputParameters += " \n";
		}
		
		return inputParameters;
	}
	
	
}
