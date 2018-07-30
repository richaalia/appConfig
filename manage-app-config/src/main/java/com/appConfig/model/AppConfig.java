package com.appConfig.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app_config")
public class AppConfig {
	
	/*Creating just one table to store the app config for test purpose, but in real life it would be a good idea to 
	store app code and version in a separate table and maintain the properties in a different table. In a nut shell this table is not normalised.
	I am Using composite primary key here which is app code and version */
	
	@EmbeddedId
    private AppConfigIdentity appConfigIdentity;
	
	
	public AppConfigIdentity getAppConfigIdentity() {
		return appConfigIdentity;
	}





	public void setAppConfigIdentity(AppConfigIdentity appConfigIdentity) {
		this.appConfigIdentity = appConfigIdentity;
	}





	public AppConfig() {

	}

	
	


	public AppConfig(AppConfigIdentity appConfigIdentity, String dbURL, String dbUserName, String dbPassword,
			String appURL) {
		super();
		this.appConfigIdentity = appConfigIdentity;
		this.dbURL = dbURL;
		this.dbUserName = dbUserName;
		this.dbPassword = dbPassword;
		this.appURL = appURL;
	}
	/*
	 * //For the test I am creating just one table. But ideal situation would be
	 * //normalised tables with Appinfo in one table and the details in another
	 */
	@Column(name = "db_url")
	String dbURL;
	@Column(name = "db_usrNm")
	String dbUserName;
	@Column(name = "db_pwd")
	String dbPassword;
	@Column(name = "app_url")
	String appURL;

	

	public String getDbURL() {
		return dbURL;
	}

	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}

	public String getDbUserName() {
		return dbUserName;
	}

	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getAppURL() {
		return appURL;
	}

	public void setAppURL(String appURL) {
		this.appURL = appURL;
	}

	@Override
	public String toString() {
		return "AppConfig [dbURL=" + dbURL + ", " +  ", dbUserName="
				+ dbUserName + ", dbPassword=" + dbPassword + ", appURL=" + appURL + "]";
	}

}
