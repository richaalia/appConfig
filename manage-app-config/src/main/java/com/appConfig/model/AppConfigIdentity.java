package com.appConfig.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;	


@Embeddable
public class AppConfigIdentity implements Serializable{
	
	@NotNull
	private String version;
	@NotNull
	private String appCode;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getAppCode() {
		return appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	public AppConfigIdentity() {
		
		}
	public AppConfigIdentity(String version, String appCode) {
		
		this.version = version;
		this.appCode = appCode;
	}
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        AppConfigIdentity that = (AppConfigIdentity) o;

	        if (!appCode.equals(that.appCode)) return false;
	        return version.equals(that.version);
	    }

	    @Override
	    public int hashCode() {
	        int result = appCode.hashCode();
	        result = 31 * result + version.hashCode();
	        return result;
	    }
	
	

}
