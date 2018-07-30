package com.appConfig.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.appConfig.model.AppConfig;
import com.appConfig.model.AppConfigIdentity;


@Transactional
public interface ConfigRepository extends CrudRepository<AppConfig,AppConfigIdentity>{
	
	//Retrieve the AppConfig by appcode and version
	List<AppConfig> findByAppConfigIdentity(AppConfigIdentity appConfigIdentity);
	
	//Retrieve the AppConfig by appcode 
	List<AppConfig> findByAppConfigIdentityAppCode(String appCode);

}
