package com.appConfig.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appConfig.model.AppConfig;

@Service
public class ConfigService {
	
	@Autowired
	private ConfigRepository configRepository;

	public void addAppConfigForVersion(AppConfig appConfig) {
		
		 configRepository.save(appConfig);
		
	}

	public List getAppConfigForApp(String appCode) {
		List configurations = new ArrayList<>();
		//configRepository.find;
		
		return null;
	}

	public AppConfig getAppConfigForVersion(String appCode, String version) {
		return null;
		
	}
}
