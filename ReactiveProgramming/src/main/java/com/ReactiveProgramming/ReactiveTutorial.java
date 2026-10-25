package com.ReactiveProgramming;

import java.util.Locale;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
1. subscribe request first!
2. send request 
3. return own data.
 */
public class ReactiveTutorial {
	
	private Mono<String> testMono() {
		
		return Mono.just("Hello") // just don't accept null justOrEmpty() or empty
				.log(); // optional method for log
		
	}
	
	private Flux<String> testFlux() {
		return Flux.just("Hello", "Deepak", "How", "are you?").log();
	}
	
	private Flux<String> testMap() {
		Flux<String> flux= Flux.just("one", "two", "three"); // data
		
		
		return flux.map(data -> data.toUpperCase(Locale.ROOT));
	}
	
	private Flux<String> testFlatMap() {
		
		Flux<String> flux= Flux.just("one", "two", "three"); // data
		
		
		return flux.flatMap(data -> Mono.just(data.toUpperCase())); // just case for complex buisness case.
		
	}
	
	public static void main(String[] args) {
		ReactiveTutorial reactiveTutorial= new ReactiveTutorial();
		
		//reactiveTutorial.testMono(); // lazy. subscribe needed.
		
		reactiveTutorial.testMono().subscribe(
				data->System.out.println("Here is the Data: "+data)
				);
		
		
		reactiveTutorial.testFlux().subscribe(data->System.err.println(data));
		
		reactiveTutorial.testMap().subscribe(System.out::println);
		
		reactiveTutorial.testFlatMap().subscribe(System.err::println);
		
	}

}
