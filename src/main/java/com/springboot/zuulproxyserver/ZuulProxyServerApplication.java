package com.springboot.zuulproxyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.springboot.zuulproxyserver.filters.ErrorFilter;
import com.springboot.zuulproxyserver.filters.PostFilter;
import com.springboot.zuulproxyserver.filters.PreFilter;
import com.springboot.zuulproxyserver.filters.RouteFilter;

@SpringBootApplication(scanBasePackages= {"com.bean","com.springboot"})
@EnableZuulProxy
@EnableEurekaClient
public class ZuulProxyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulProxyServerApplication.class, args);
	}
	
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

}
