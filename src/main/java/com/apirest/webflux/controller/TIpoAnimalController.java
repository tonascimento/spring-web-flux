package com.apirest.webflux.controller;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.webflux.document.TipoAnimal;
import com.apirest.webflux.services.IService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class TIpoAnimalController {

	@Autowired
	IService<TipoAnimal> tipoAnimalService;
	
	
	@GetMapping(value = "/tipoAnimal")
	public Flux<TipoAnimal> getTipoAnimal(){
		return tipoAnimalService.findAll();
	}
	
	@GetMapping(value = "/tipoAnimal/{id}")
	public Mono<TipoAnimal> findById(@PathVariable String id){
		return tipoAnimalService.findById(id);
	}
	
	@PostMapping(value = "/tipoAnimal")
	public Mono<TipoAnimal> save(@RequestBody TipoAnimal tipoAnimal){
		return tipoAnimalService.save(tipoAnimal);
	}
	
	@GetMapping(value="/tipoAnimal/events", produces = TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, TipoAnimal>> getTipoAnimalByEvents(){
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
		Flux<TipoAnimal> events = tipoAnimalService.findAll();
		System.out.println("Passou evento aqui!!");
		return Flux.zip(interval, events);
	}
}