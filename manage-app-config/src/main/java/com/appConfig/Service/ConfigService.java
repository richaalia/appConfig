package com.appConfig.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appConfig.model.AppConfig;
import com.appConfig.model.AppConfigIdentity;

@Service
public class ConfigService {
	
	@Autowired
	private ConfigRepository configRepository;

	public String addAppConfigForVersion(AppConfig appConfig, String appCode, String version) {
		try {
			
		
		if(appConfig!=null && appCode!=null && version!=null ) {
		AppConfigIdentity appConfigIdentity = new AppConfigIdentity(version,appCode);
		appConfig.setAppConfigIdentity(appConfigIdentity);
		appConfig = configRepository.save(appConfig);
		}
		return "success";
		}catch (Exception e) {
			
			System.out.println("The exception"+e);
			
			return "failed";
		}
		
		
	}

	public List<AppConfig> getAppConfigForApp(String appCode) {
		
		
		
		return configRepository.findByAppConfigIdentityAppCode(appCode);
		 
	}

	public List<AppConfig> getAppConfigForVersion(String appCode, String version) {
		AppConfigIdentity appConfigIdentity = new AppConfigIdentity(version,appCode);
		return configRepository.findByAppConfigIdentity(appConfigIdentity);
		 
		
	}
}
