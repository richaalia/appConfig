package com.appConfig.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.appConfig.model.AppConfig;


@Transactional
public interface ConfigRepository extends CrudRepository<AppConfig,String>{
	
	List<AppConfig> findBydbURLAndAppURL
	(String dbURL,String appURL);

}
