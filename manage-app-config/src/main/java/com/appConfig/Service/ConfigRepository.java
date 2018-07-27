package com.appConfig.Service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appConfig.model.AppConfig;


@Repository
public interface ConfigRepository extends CrudRepository<AppConfig,String>{
	
	List<AppConfig> findBydbURLAndAppURL
	(String dbURL,String appURL);

}
