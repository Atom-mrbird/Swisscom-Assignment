package com.spring.microservices.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservices.vo.StaticFilteringVO;

import io.swagger.annotations.ApiResponse;

@RestController
public class StaticFilteringController {

	@ApiResponse(message = "Ataberk", code = 200)
	@GetMapping("/filtering")
	public List<StaticFilteringVO> getFilteringVO() {
		return Arrays.asList(new StaticFilteringVO("Ataberk", "Yakar"), new StaticFilteringVO("Peter", "Parker"),
				new StaticFilteringVO("Steve", "Rogers"), new StaticFilteringVO("John", "Wick"));

	}
}
