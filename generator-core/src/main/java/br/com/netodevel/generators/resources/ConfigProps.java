package br.com.netodevel.generators.resources;

/**
 * @author NetoDevel
 */
public class ConfigProps {

	public static final String JPA_CONFIG= ""
			+ "spring.jpa.hibernate.naming.strategy=org.hibernate.cfg.ImprovedNamingStrategy\n"
			+ "spring.jpa.openInView=true\n"
			+ "spring.jpa.show-sql=false\n"
			+ "spring.jpa.hibernate.ddl-auto=create-drop\n";

	public static final String TOMCAT_CONFIG= ""
			+ "spring.datasource.tomcat.test-on-borrow=true\n"
			+ "spring.datasource.tomcat.validation-query=SELECT 1\n"
			+ "spring.datasource.sql-script-encoding=UTF-8\n";
	
}
