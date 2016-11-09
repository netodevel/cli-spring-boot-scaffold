package br.com.generate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class MainGenerate implements IGenerate {
	
	@Override
	public void generate(String... params) {
		String BASE_DIR = params[0];
		if (validateFile("MainApplication.java")) {
			PrintWriter writer = null;
			try {
				File file = new File(BASE_DIR + "\\src\\main\\java\\br\\com\\scaffold\\MainApplication.java");
				file.getParentFile().mkdirs();
				writer = new PrintWriter(file, "UTF-8");
				imports(writer, params);
				writer.println("");
				writer.println("@SpringBootApplication");
				writer.println("public class MainApplication { ");
				writer.println("");
				writer.println("	public static void main(String[] args) {");
				writer.println("		SpringApplication.run(ApplicationDemo.class, args);");
				writer.println("	}");
				writer.println("");
				writer.println("	@Bean");
				writer.println("	public ObjectMapper objectMapper() {");
				writer.println("		ObjectMapper mapper = new ObjectMapper();");
				writer.println("		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);");
				writer.println("		mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);");
				writer.println("		return mapper;");
				writer.println("	}");
				writer.println("}");
				writer.close();
				System.out.println("invoke spring-boot");
				System.out.println("create src/main/java/br/com/scaffold/MainApplication.java");
			} catch (FileNotFoundException e) {
			} catch (UnsupportedEncodingException e) {
			}
		}
	}

	@Override
	public void imports(PrintWriter print, String[] namesClass) {
		print.println("package br.com.scaffold;");
		print.println("import org.springframework.boot.SpringApplication;");
		print.println("import org.springframework.boot.autoconfigure.SpringBootApplication;");
		print.println("import org.springframework.context.annotation.Bean;");
		print.println("import com.fasterxml.jackson.databind.DeserializationFeature;");
		print.println("import com.fasterxml.jackson.databind.MapperFeature;");
		print.println("import com.fasterxml.jackson.databind.ObjectMapper;");
	}

	@Override
	public String generateParams(String params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateFile(String nameFile) {
		return true;
	}

}
