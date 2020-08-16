package com.github.adetiamarhadi.springcloudconfigclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RefreshScope
public class SpringCloudConfigClientApplication {

	@Autowired
	ConfigClientAppConfiguration properties;

	@Value("${some.other.property}")
	String someOtherProperty;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientApplication.class, args);
	}

	@GetMapping
	public String printConfig() {

		StringBuilder sb = new StringBuilder();
		sb.append(properties.getProperty());
		sb.append(" || ");
		sb.append(someOtherProperty);

		return sb.toString();
	}

}
