package com.example.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.example.login.configuration.LoginConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "login-service", configuration = LoginConfiguration.class)
public class LoginService1Application {

	public static void main(String[] args) {
		SpringApplication.run(LoginService1Application.class, args);
	}

}
