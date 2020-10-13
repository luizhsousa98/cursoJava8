package java8.Testes;

import java.util.Arrays;
import java.util.List;

public class TestandoLambdas {
	/**
	 * Lambdas só funcionam com suas interfaces funcionais ex: comparator,
	 * consumer..., devem conter somente 1 implementacao abstrata
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> palavras = Arrays.asList("Aprendendo lambdas Java 8", "Curso Java 8 Alura", "Caelum");

		// Interface comparator, imprimindo pelo tamanho
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		// Interface consumer
		palavras.forEach(imprimindoValor -> System.out.println(imprimindoValor));

		System.out.println(palavras);
		
		//Executando runnable
		new Thread(() -> System.out.println("Executando um Runnable")).start();
	}

}
