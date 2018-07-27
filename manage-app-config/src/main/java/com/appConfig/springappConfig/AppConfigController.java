package com.appConfig.springappConfig;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
//import javax.ws.rs.core.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.appConfig.Service.ConfigService;
import com.appConfig.model.AppConfig;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/api")
public class AppConfigController {
	@Autowired
	private final ConfigService configService;
	
	 public AppConfigController(final ConfigService configService) {
	        this.configService = configService;
	    }
	
	@RequestMapping(value ="/{appCode}/config/{version}", method=RequestMethod.GET)
	@ResponseBody
	public AppConfig getAppConfigForVersion(@PathVariable String appCode,@PathVariable String version) {
		
		return configService.getAppConfigForVersion(appCode,version);
		
		//return "The processing is now complete. It took "+String.valueOf(duration)+" secs";
	}
	@RequestMapping(value ="/{appCode}/config", method=RequestMethod.GET)
	@ResponseBody
	public List getAppConfigForApp(@PathVariable String appCode) {
		
		 return configService.getAppConfigForApp(appCode);
		
		
	}
	// ------------ Create a app config ------------
		@RequestMapping(value = "/{appCode}/config/{version}", method = RequestMethod.POST)
		public void addAppConfigForVersion(@RequestBody AppConfig appConfig) {
			configService.addAppConfigForVersion(appConfig);
			
		}
}
