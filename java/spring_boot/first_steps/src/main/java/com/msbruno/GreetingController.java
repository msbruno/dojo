package com.msbruno;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private String message = "Hello, %s";
	private AtomicLong idGenerator = new AtomicLong();

	@RequestMapping("/greet")
	public Greeting greeting(
			@RequestParam(name="name", defaultValue = "World") String name) {
		String messageResult = String.format(message, name);
		return new Greeting(idGenerator.getAndIncrement(), messageResult);
	}
}
