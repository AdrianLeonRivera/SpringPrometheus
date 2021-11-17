package com.bootcamp.actuatorprometheus.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class TestController {

	private Counter contador;

	public TestController(MeterRegistry registro) {
		this.contador = Counter.builder("invocaciones.hello").description("Invocaciones totales").register(registro);
	}
	
	@GetMapping(path = "/helloWorld")
	public String helloWord()
	{
		contador.increment();
		return "Hello World";
	}
	
}
