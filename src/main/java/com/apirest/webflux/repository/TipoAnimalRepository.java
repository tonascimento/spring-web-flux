package com.apirest.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.apirest.webflux.document.TipoAnimal;

public interface TipoAnimalRepository extends ReactiveMongoRepository<TipoAnimal, String> {

}