package com.wanted.onepeople.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：Spring Boot Admin Client
 *
 * @author xiyouquedongxing
 * @Date 2020-08-03
 */
@RestController
public class IndexController {
	@GetMapping(value = {"", "/"})
	public String index() {
		return "This is a Spring Boot Admin Client.";
	}
}
