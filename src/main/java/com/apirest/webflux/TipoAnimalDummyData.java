package com.apirest.webflux;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.apirest.webflux.document.RacaAnimal;
import com.apirest.webflux.document.TipoAnimal;
import com.apirest.webflux.repository.TipoAnimalRepository;

import reactor.core.publisher.Flux;

@Component
public class TipoAnimalDummyData implements CommandLineRunner {

	private final TipoAnimalRepository tipoAnimalRepository;

	TipoAnimalDummyData(TipoAnimalRepository tipoAnimalRepository) {
		super();
		this.tipoAnimalRepository = tipoAnimalRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		List<RacaAnimal> cachorro = new ArrayList<RacaAnimal>();

		for (String animal : listaDeRacas()) {
			cachorro.add(new RacaAnimal(UUID.randomUUID().toString(), animal));
		}

		tipoAnimalRepository.deleteAll()
				.thenMany(
						Flux.just("Cachorro").map(nome -> new TipoAnimal(UUID.randomUUID().toString(), nome, cachorro))
								.flatMap(tipoAnimalRepository::save))
				.subscribe(System.out::println);
	}

	private List<String> listaDeRacas() {
		return List.of("Akita", "Basset hound", "Beagle", "Bichon frisé", "Boiadeiro australiano", "Border collie",
				"Boston terrier", "Boxer", "Buldogue francês", "Buldogue inglês", "Bull terrier", "Cane corso",
				"Cavalier king charles spaniel", "Chihuahua", "Chow chow", "Cocker spaniel inglês", "Dachshund",
				"Dálmata", "Doberman", "Dogo argentino", "Dogue alemão", "Fila brasileiro", "Golden retriever",
				"Husky siberiano", "Jack russell terrier", "Labrador retriever", "Lhasa apso", "Lulu da pomerânia",
				"Maltês", "Mastiff inglês", "Mastim tibetano", "Pastor alemão", "Pastor australiano",
				"Pastor de Shetland", "Pequinês", "Pinscher", "Pit bull", "Poodle", "Pug", "Rottweiler", "Schnauzer",
				"Shar-pei", "Shiba", "Shih tzu", "Staffordshire bull terrier", "Weimaraner", "Yorkshire", "Vira Lata");
	}
}