package com.example.login.controller;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.login.bean.User;

@Controller
public class LoginController {

	private Map<String, User> users = new HashMap<String, User>();

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private LoadBalancerClient loadbalancerclient;

	@Value("${pivotal.adminservice.name}")
	protected String adminService;

	@Value("${pivotal.employeeservice.name}")
	protected String employeeService;
	
	/**
	 * 
	 */
	public LoginController() {
		users.put("user1", new User("user1", "user1"));
		users.put("user2", new User("user2", "user2"));
		users.put("user3", new User("user3", "user3"));
		users.put("user4", new User("user4", "user4"));
		users.put("user5", new User("user5", "user5"));
		users.put("user6", new User("user5", "user6"));
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response) {

		System.out.println(">>>>");

		if (request == null) {
			return "Sorry";
		}

		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String role = request.getParameter("select_role");

		System.out.println(">>>>" + userid);
		if ((userid == null) || (password == null) || (role == null) || (userid == "") || (password == "")
				|| (role == "")) {
			return "Sorry";
		}
		System.out.println(">>>>" + 123);
		User loggedInUser = users.get(userid);
		request.getSession().setAttribute("userid", loggedInUser.getName());
		if (loggedInUser.getPassword().equals(password)) {
			if ("user".equals(role)) {
				// Call employee login service
				List<ServiceInstance> instances = discoveryClient.getInstances(employeeService);
				if (instances != null) {
					if(instances.size() > 0) {
						URI uri = instances.get(0).getUri();
						System.out.println("User Credentials:" + uri.toString()+"/assessment");
						try {
							response.sendRedirect(uri.toString()+"/assessment");
						} catch (IOException e) {
							e.printStackTrace();
						}

					}else {
						System.out.println("instance size is "+instances.size());
						return "Sorry";
					}
				} else {
					System.out.println("instance is null");
					return "Sorry";
				}
			} else {
				// Using Ribbon
				ServiceInstance instance = loadbalancerclient.choose(adminService);
				if (instance != null) {
					URI uri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
					System.out.println("Admin Credentials:" + uri.toString()+"/assessments");
					try {
						response.sendRedirect(uri.toString()+"/assessments");
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("instance is null");
					return "Sorry";
				}


				return "";

			}
		} else {
			return "Register";
		}

		return "Sorry";

	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}
}
