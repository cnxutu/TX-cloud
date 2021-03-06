///*
// * Copyright 2013-2018 the original author or authors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      https://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.example.springbootdemo.sentinel.config;
//
//import com.alibaba.cloud.circuitbreaker.sentinel.SentinelCircuitBreakerFactory;
//import com.alibaba.cloud.circuitbreaker.sentinel.SentinelConfigBuilder;
//import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
//import com.alibaba.csp.sentinel.datasource.Converter;
//import com.alibaba.csp.sentinel.slots.block.RuleConstant;
//import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
//import com.example.springbootdemo.sentinel.util.ExceptionUtil;
//import org.springframework.cloud.client.circuitbreaker.Customizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.Collections;
//
///**
// * @author yuhuangbin
// */
//@Configuration
//@EnableWebMvc
//public class WebMvcConfiguration implements WebMvcConfigurer {
//
//	@Bean
//	@SentinelRestTemplate(blockHandler = "handleException",
//			blockHandlerClass = ExceptionUtil.class)
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
//
//	@Bean
//	public RestTemplate restTemplate2() {
//		return new RestTemplate();
//	}
//
//	@Bean
//	public Converter myConverter() {
//		return new JsonFlowRuleListConverter();
//	}
//
//	@Bean
//	public Customizer<SentinelCircuitBreakerFactory> defaultConfig() {
//		return factory -> {
//			factory.configureDefault(
//					id -> new SentinelConfigBuilder().resourceName(id)
//							.rules(Collections.singletonList(new DegradeRule(id)
//									.setGrade(RuleConstant.DEGRADE_GRADE_RT).setCount(100)
//									.setTimeWindow(10)))
//							.build());
//		};
//	}
//
//
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/errorPage").setViewName("errorPage");
//	}
//
//}
