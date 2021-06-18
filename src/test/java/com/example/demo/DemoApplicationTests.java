package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() throws Exception {

		//test add users
		String user1 = "{\"username\":\"username1\",\"password\":\"pasSw0rd\"," +
				"\"email\":\"user1@reply.com\",\"dateOfBirth\":\"2003-04-02\"}";
		mvc.perform(post("/users").content(user1)
				.contentType("application/json"))
				.andExpect(status().isCreated());

		String user2 = "{\"username\":\"username2\",\"password\":\"pasSw0rd\"," +
				"\"email\":\"user2@reply.com\",\"dateOfBirth\":\"2007-04-02\"}";
		mvc.perform(post("/users").content(user2)
				.contentType("application/json"))
				.andExpect(status().isForbidden());

		String user3 = "{\"username\":\"username3\",\"password\":\"pasSw0rd\"," +
				"\"email\":\"user3@reply.com\",\"dateOfBirth\":\"2003-04-02\"," +
				"\"creditCardNo\":\"1234\"}";
		mvc.perform(post("/users").content(user3)
				.contentType("application/json"))
				.andExpect(status().isBadRequest());

		String user4 = "{\"username\":\"username4\",\"password\":\"pasSw0rd\"," +
				"\"email\":\"user4@reply.com\",\"dateOfBirth\":\"2003-04-02\"," +
				"\"creditCardNo\":\"1234567890123456\"}";
		mvc.perform(post("/users").content(user4)
				.contentType("application/json"))
				.andExpect(status().isCreated());

		//test duplicate users
		mvc.perform(post("/users").content(user4)
				.contentType("application/json"))
				.andExpect(status().isConflict());

		//test get users
		mvc.perform(get("/users"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)));

		mvc.perform(get("/users").param("withCreditCard","Yes"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].username", is("username4")));

		//test make payments
		String payment1 = "{\"creditCardNo\":\"1234567890123454\",\"amount\":\"100\"}";
		mvc.perform(post("/payments").content(payment1)
				.contentType("application/json"))
				.andExpect(status().isNotFound());

		String payment2 = "{\"creditCardNo\":\"1234567890123456\",\"amount\":\"100\"}";
		mvc.perform(post("/payments").content(payment2)
				.contentType("application/json"))
				.andExpect(status().isCreated());
	}
}
