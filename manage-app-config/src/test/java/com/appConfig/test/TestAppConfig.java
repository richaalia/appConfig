package com.appConfig.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.appConfig.Service.ConfigService;
import com.appConfig.model.AppConfig;
import com.appConfig.model.AppConfigIdentity;
import com.appConfig.springappConfig.AppConfigController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AppConfigController.class, secure = false)
public class TestAppConfig {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ConfigService configService;
	AppConfigIdentity appIdentity = new AppConfigIdentity("123","123");
	
	AppConfig appConfig = new AppConfig(appIdentity,"datase:dev","sa","tofu","abc.com");
	
	
	String exampleAppConfigJson = "{\"appCode\":\"123\",\"version\":\"123\",\"dbURL\":\"datase:dev\",\"dbUserName\":\"sa\",\"dbPassword\":\"tofu\",\"appURL\":\"abc.com\"}";
	String successString = "true";

	// studentService.addCourse to respond back with mockCourse
	@Test
	public void testCreateAppConfig() throws Exception {
		
		
			when(configService.addAppConfigForVersion(Mockito.any(AppConfig.class), exampleAppConfigJson, exampleAppConfigJson)).thenReturn("success");
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/appCode1/config/version1")
					.accept(MediaType.APPLICATION_JSON).content(successString)
					.contentType(MediaType.APPLICATION_JSON);
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			MockHttpServletResponse response = result.getResponse();

			assertEquals(HttpStatus.CREATED.value(), response.getStatus());

			assertEquals("http://localhost/api/appCode1/config/version1",
					response.getHeader(HttpHeaders.LOCATION));

	}

}
