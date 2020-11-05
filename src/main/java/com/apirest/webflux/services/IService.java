package com.apirest.webflux.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IService<T> {

	Flux<T> findAll();
	Mono<T> findById(String id);
	Mono<T> save(T entyti);
		
}