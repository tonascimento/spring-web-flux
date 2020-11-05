package com.apirest.webflux.controller;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.webflux.document.Playlist;
import com.apirest.webflux.services.IService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class PlaylistController {

	@Autowired
	IService<Playlist> playlistService;
	
	
	@GetMapping(value = "/playlist")
	public Flux<Playlist> getPlaylist(){
		return playlistService.findAll();
	}
	
	@GetMapping(value = "/playlist/{id}")
	public Mono<Playlist> findById(@PathVariable String id){
		return playlistService.findById(id);
	}
	
	@PostMapping(value = "/playlist")
	public Mono<Playlist> save(@RequestBody Playlist playlist){
		return playlistService.save(playlist);
	}
	
	@GetMapping(value="/playlist/events", produces = TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Playlist>> getPlayListByEvents(){
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
		Flux<Playlist> events = playlistService.findAll();
		System.out.println("Passou evento aqui!!");
		return Flux.zip(interval, events);
	}
	
	
	
}