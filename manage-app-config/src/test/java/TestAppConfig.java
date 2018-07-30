import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.appConfig.model.AppConfig;
import com.appConfig.model.AppConfigIdentity;
import com.appConfig.springappConfig.SpringBootAppConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootAppConfig.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestAppConfig {
	
	HttpHeaders headers = new HttpHeaders();
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();
	@Test
	public void addAppConfig() {
		
		AppConfigIdentity appConfigIdentity = new AppConfigIdentity("123","123");
		
		AppConfig appConfig = new AppConfig(appConfigIdentity,"dev:database","sa","pwd","abc.com");
		
		HttpEntity<AppConfig> entity = new HttpEntity<AppConfig>(appConfig, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/123/config/123"),
				HttpMethod.POST, entity, String.class);
		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		assertTrue(actual.contains("/students/Student1/courses/"));

		
	}
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
