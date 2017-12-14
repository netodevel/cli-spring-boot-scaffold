package thymeleaf;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.netodevel.core.GeneratorConstants;
import br.com.netodevel.generators.views.thymeleaf.AbstractThymeleafGenerate;

/**
 * @author NetoDevel
 *
 */
public class AbstractThymeleafTest {

	private AbstractThymeleafGenerate abstractThymeleafGenerate;
	
	@Before
	public void setUp() {
		this.abstractThymeleafGenerate = new AbstractThymeleafGenerate();
	}
	
	@Test
	public void testGenerateThParameters() {
		String outputExpected = GeneratorConstants.INDENT_HTML + " <th>Name</th> \n"
				+ GeneratorConstants.INDENT_HTML + " <th>Email</th> \n"
				+ GeneratorConstants.INDENT_HTML + " <th>Action</th>";
		assertEquals(outputExpected, this.abstractThymeleafGenerate.generateThParameters("name:String email:String"));
	}
	
}
