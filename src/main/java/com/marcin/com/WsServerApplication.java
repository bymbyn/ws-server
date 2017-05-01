package com.marcin.com;

import javax.xml.ws.Endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcin.service.UserServiceImpl;

@SpringBootApplication
public class WsServerApplication implements CommandLineRunner {

	@Value("${service.port}")
	private String servicePort;

	@Override
	public void run(String... args) throws Exception {
		Endpoint.publish("http://localhost:" + servicePort + "/service/user", new UserServiceImpl());

	}

	public static void main(String[] args) {
		SpringApplication.run(WsServerApplication.class, args);
	}
}
