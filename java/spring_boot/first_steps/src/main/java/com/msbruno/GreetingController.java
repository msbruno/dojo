package com.msbruno;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@RequestMapping("/greet")
	public Greeting greeting(
			@RequestParam(name="name", defaultValue = "World") String name) {
		return new Greeting(0, name);
	}
}
