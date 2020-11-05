package com.apirest.webflux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.webflux.document.TipoAnimal;
import com.apirest.webflux.repository.TipoAnimalRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TipoAnimalServiceImpl implements IService<TipoAnimal> {

	@Autowired
	TipoAnimalRepository tipoAnimalRepository;
	
	
	@Override
	public Flux<TipoAnimal> findAll() {
		return tipoAnimalRepository.findAll();
	}

	@Override
	public Mono<TipoAnimal> findById(String id) {
		return tipoAnimalRepository.findById(id);
	}

	@Override
	public Mono<TipoAnimal> save(TipoAnimal tipoAnimal) {
		return tipoAnimalRepository.save(tipoAnimal);
	}
}