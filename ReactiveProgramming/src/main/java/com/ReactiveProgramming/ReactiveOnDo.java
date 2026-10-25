package com.ReactiveProgramming;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

public class ReactiveOnDo {
	
	private Flux<Integer> testDoFunction() {
		
		Flux<Integer> flux= Flux.range(1, 10);
		
		return flux.doOnEach(signal -> System.out.println(signal));
		
	}
	
private Flux<Integer> testDoFunction2() {
		
		Flux<Integer> flux= Flux.range(1, 10);
		
		return flux.doOnEach(signal ->{
				if (signal.getType() == SignalType.ON_COMPLETE) {
					System.out.println("Process is done");
				}else {
					System.out.println(signal.getType());
				}
			}
		);
		
	}
	
	
	public static void main(String[] args) {
		ReactiveOnDo reactiveOnDo= new ReactiveOnDo();
		
		reactiveOnDo.testDoFunction().subscribe();
		
		reactiveOnDo.testDoFunction2().subscribe();
		
	}

}
