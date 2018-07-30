package com.appConfig.springappConfig;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
//import javax.ws.rs.core.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.appConfig.Service.ConfigService;
import com.appConfig.model.AppConfig;

@RestController
@RequestMapping("/api")
public class AppConfigController {
	@Autowired
	private final ConfigService configService;

	public AppConfigController(final ConfigService configService) {
		this.configService = configService;
	}

	@RequestMapping(value = "/{appCode}/config/{version}", method = RequestMethod.GET)
	@ResponseBody
	public List<AppConfig> getAppConfigForVersion(@PathVariable String appCode, @PathVariable String version) {

		return configService.getAppConfigForVersion(appCode, version);

	}

	@RequestMapping(value = "/{appCode}/config", method = RequestMethod.GET)
	@ResponseBody
	public List getAppConfigForApp(@PathVariable String appCode) {

		return configService.getAppConfigForApp(appCode);

	}

	// ------------ Create a app config ------------
	//	Using a put method as it would update or insert. POST would keep on inserting new records. So as per the requirements using Put
	
	@RequestMapping(value = "/{appCode}/config/{version}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> addAppConfigForVersion(@RequestBody AppConfig appConfig, @PathVariable String appCode,
			@PathVariable String version) {
		if (appConfig == null)
			return ResponseEntity.noContent().build();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{appCode}").buildAndExpand(appConfig.getAppConfigIdentity().getAppCode()).toUri();
		configService.addAppConfigForVersion(appConfig, appCode, version);
		return ResponseEntity.created(location).build();

	}
}
