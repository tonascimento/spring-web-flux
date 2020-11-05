package com.apirest.webflux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.webflux.document.Animal;
import com.apirest.webflux.repository.AnimalRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AnimalServiceImpl implements IService<Animal> {

	@Autowired
	AnimalRepository animalRepository;
	
	
	@Override
	public Flux<Animal> findAll() {
		return animalRepository.findAll();
	}

	@Override
	public Mono<Animal> findById(String id) {
		return animalRepository.findById(id);
	}

	@Override
	public Mono<Animal> save(Animal animal) {
		return animalRepository.save(animal);
	}
}