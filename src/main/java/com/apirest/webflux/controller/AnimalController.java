package com.apirest.webflux.controller;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.webflux.document.Animal;
import com.apirest.webflux.services.IService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class AnimalController {

	@Autowired
	IService<Animal> animalService;
	
	
	@GetMapping(value = "/animal")
	public Flux<Animal> getTipoAnimal(){
		return animalService.findAll();
	}
	
	@GetMapping(value = "/animal/{id}")
	public Mono<Animal> findById(@PathVariable String id){
		return animalService.findById(id);
	}
	
	@PostMapping(value = "/animal")
	public Mono<Animal> save(@RequestBody Animal animal){
		return animalService.save(animal);
	}
	
	@GetMapping(value="/animal/events", produces = TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Animal>> getAnimalByEvents(){
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
		Flux<Animal> events = animalService.findAll();
		System.out.println("Passou evento aqui!!");
		return Flux.zip(interval, events);
	}
}