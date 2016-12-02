package br.com.generate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import br.com.strategy.IGenerate;

public class PomGenerate implements IGenerate {

	@Override
	public void generate(String... params) {
		String BASE_DIR = params[0];
		String NAME_PROJECT = params[1];
		String DATABASE = params[2];
		
		PrintWriter writer = null;
		try {
			File file = new File(BASE_DIR + "/pom.xml");
			file.getParentFile().mkdirs();
			writer = new PrintWriter(file, "UTF-8");
			writer.println("<project xmlns='http://maven.apache.org/POM/4.0.0' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation='http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd'>");
			writer.println("	<modelVersion>4.0.0</modelVersion>");
			writer.println("  	<groupId>" + NAME_PROJECT + "</groupId>");
			writer.println("	<artifactId>" + NAME_PROJECT + "</artifactId>");
			writer.println("	<version>0.0.1-SNAPSHOT</version>");
			writer.println("	<properties>");
			writer.println("		<kotlin.version>" + DependencyVersion.KOTLIN_VERSION + "</kotlin.version>");
			writer.println("	</properties>");
			writer.println("	<parent>");
			writer.println("		<groupId>org.springframework.boot</groupId>");
			writer.println("		<artifactId>spring-boot-starter-parent</artifactId>");
			writer.println("		<version>" + DependencyVersion.SPRING_BOOT_VERSION + "</version>");
			writer.println("	</parent>");
			writer.println("	<dependencies>");
			writer.println("		<dependency>");
			writer.println("			<groupId>org.springframework.boot</groupId>");
			writer.println("			<artifactId>spring-boot-starter-web</artifactId>");
			writer.println("		</dependency>");
			writer.println("		<dependency>");
			writer.println("			<groupId>org.springframework.boot</groupId>");
			writer.println("			<artifactId>spring-boot-starter-data-jpa</artifactId>");
			writer.println("		</dependency>");
			writer.println("		<dependency>");
			writer.println("			<groupId>org.springframework.boot</groupId>");
			writer.println("			<artifactId>spring-boot-starter-test</artifactId>");
			writer.println("			<scope>test</scope>");
			writer.println("		</dependency>");
			writer.println("		<dependency>");
			writer.println("			<groupId>com.github.rest-driver</groupId>");
			writer.println("			<artifactId>rest-client-driver</artifactId>");
			writer.println("			<version>2.0.0</version>");
			writer.println("		</dependency>");
			writer.println("		<dependency>");
			writer.println("			<groupId>com.github.rest-driver</groupId>");
			writer.println("			<artifactId>rest-server-driver</artifactId>");
			writer.println("			<version>2.0.0</version>");
			writer.println("			<scope>test</scope>");
			writer.println("		</dependency>");
			if(DatabaseConfiguration.MYSQL.equals(DATABASE)){
				writer.println("		<dependency>");
				writer.println("			<groupId>mysql</groupId>");
				writer.println("			<artifactId>mysql-connector-java</artifactId>");
				writer.println("		</dependency>");
			} else if(DatabaseConfiguration.POSTGRES.equals(DATABASE)){
				writer.println("		<dependency>");
				writer.println("			<groupId>org.postgresql</groupId>");
				writer.println("			<artifactId>postgresql</artifactId>");
				writer.println("			<version>9.1-901-1.jdbc4</version>");
				writer.println("		</dependency>");
			}
			writer.println("		<dependency>");
			writer.println("			<groupId>com.fasterxml.jackson.module</groupId>");
			writer.println("			<artifactId>jackson-module-kotlin</artifactId>");
			writer.println("		</dependency>");
			writer.println("	</dependencies>");
			writer.println("");
			writer.println("	<repositories>");
			writer.println("		<repository>");
			writer.println("			<id>jaysonminard-kohesive</id>");
			writer.println("			<url>http://dl.bintray.com/jaysonminard/kohesive</url>");
			writer.println("		</repository>");
			writer.println("	</repositories>");
			writer.println("");
			writer.println("</project>");
			writer.close();
			System.out.println("create pom.xml");
		} catch (FileNotFoundException e) {
		} catch (UnsupportedEncodingException e) {
		}
	}

	@Override
	public void imports(PrintWriter print, String[] namesClass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String generateParams(String params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateFile(String nameFile) {
		// TODO Auto-generated method stub
		return false;
	}

}
