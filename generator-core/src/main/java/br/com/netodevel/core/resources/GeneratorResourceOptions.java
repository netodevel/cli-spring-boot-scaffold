package br.com.netodevel.core.resources;

import br.com.netodevel.helpers.TextHelper;

/**
 * @author NetoDevel
 */
public class GeneratorResourceOptions {

	private String database;
	private String databaseName;
	private String orm;
	private String server;
	private String packageName;
	private String userDatabase;
	private String passwordDatabase;

	public GeneratorResourceOptions setDatabase(String database) {
		this.database = database;
		return this;
	}
	
	public GeneratorResourceOptions setOrm(String orm) {
		this.orm = orm;
		return this;
	}
	
	public GeneratorResourceOptions setServer(String server) {
		this.server = server;
		return this;
	}
	
	public GeneratorResourceOptions setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
		return this;
	}

	public String getOrm(String defValue) {
		if (TextHelper.isTextNull(this.orm)) {
			return defValue;
		} else {
			return this.orm;
		}
	}
	
	public String getDatabase() {
		return database;
	}

	public String getOrm() {
		return orm;
	}

	public String getServer() {
		return server;
	}

	public String getPackageName() {
		return packageName;
	}

	public GeneratorResourceOptions setPackageName(String packageName) {
		this.packageName = packageName;
		return this;
	}

	public String getUserDatabase(String defValue) {
		if (TextHelper.isTextNull(this.userDatabase)) {
			return defValue;
		} else {
			return this.userDatabase;
		}
	}
	
	public String getUserDatabase() {
		return userDatabase;
	}

	public GeneratorResourceOptions setUserDatabase(String userDatabase) {
		this.userDatabase = userDatabase;
		return this;
	}

	public String getPasswordDatabase(String defValue) {
		if (TextHelper.isTextNull(this.passwordDatabase)) {
			return defValue;
		} else {
			return this.passwordDatabase;
		}
	}
	
	public String getPasswordDatabase() {
		return passwordDatabase;
	}

	public GeneratorResourceOptions setPasswordDatabase(String passwordDatabase) {
		this.passwordDatabase = passwordDatabase;
		return this;
	}

	public String getDatabaseName() {
		return databaseName;
	}
	
}
