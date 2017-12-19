package com.flipzon.ecom;

import com.flipzon.ecom.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlipzonApplicationTests {

	@Test
	public void addUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/users";
        User user = new User();
        user.setName("Agni");
        user.setEmailId("agni@mail.com");
        HttpEntity<User> requestEntity = new HttpEntity<User>(user,headers);
        URI uri = restTemplate.postForLocation(url,requestEntity);
	}

}
