package br.com.netodevel.core;

/**
 * @author NetoDevel
 *
 */
public class Attribute {

	public String name;
	public String type;

	public Attribute(){
	}

	public Attribute(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}