package com.security.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldControllerTest {

	@Autowired
	private MockMvc mvc;
	
	private String jwtToken;
	
	@Before
	public void init() {
		this.jwtToken = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ5b3VuZXNzIiwiZXhwIjoxNTc4ODUwOTI2LCJpYXQiOjE1Nzg4MzI5MjZ9.TaLPKR70z_x1MmWzTyNI8I0L3jBwte-p5m3SVZ4BPEADXpU3t3z4jfGirkBJnVIlKDcVh6PUMzrdjOMmrpuvGA";
	}

	@Test
	public void helloWorldTest() throws Exception {
		this.mvc.perform(get("/hello").header("Authorization" , jwtToken))
				.andExpect(status().isOk()).andDo(print());
	}

}
