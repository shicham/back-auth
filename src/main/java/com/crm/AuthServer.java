package com.crm;

import com.crm.commun.configs.ServerApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthServer  extends ServerApplication{

	public static void main(String[] args) {
		SpringApplication.run(AuthServer.class, args);
	}

}
