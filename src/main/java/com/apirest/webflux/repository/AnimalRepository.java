package com.apirest.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.apirest.webflux.document.Animal;

public interface AnimalRepository extends ReactiveMongoRepository<Animal, String> {

}