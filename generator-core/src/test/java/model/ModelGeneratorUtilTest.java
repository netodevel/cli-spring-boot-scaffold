package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.netodevel.generators.java.model.ModelGenerateUtils;

public class ModelGeneratorUtilTest {
	
	@Test
	public void testGetTypeParam() {
		String param = "name:String";
		assertEquals("import java.lang.String;", ModelGenerateUtils.getTypeParam(param));
	}

	@Test
	public void testGenerateImports() {
		String parameters = "name:String idade:Integer data:Date";
		String valueExpected = "import java.lang.String;\n" 
							 + "import java.lang.Integer;\n"
							 + "import java.util.Date;";
		assertEquals(valueExpected, ModelGenerateUtils.generateImports(parameters));
	}
	
	@Test
	public void testGenerateGettersAndSetters() {
		String setter = "\n\t public void setName(String name) {\n"
				  + "\t\t this.name = name;\n"
				  + "\t }\n";
		
		String getter = "\n\t public String getName() {\n" 
			      + "\t\t return this.name;\n"
			      + "\t }\n";
		
		String valueExpected = setter + getter;
		assertEquals(valueExpected, ModelGenerateUtils.generateGettersAndSetters("name:String"));
	}
	
	@Test
	public void testGenerateParams() {
		String column = "\t @column(name=\"name\")\n";
		String attribute = "\t private String name;\n";
		
		String valueExpected = column + attribute;
		assertEquals(valueExpected, ModelGenerateUtils.generateParams("name:String"));

	}
	
}
