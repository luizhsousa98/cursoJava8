package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenandoStringsComLambdas {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();

		palavras.add("Alura cursos online");
		palavras.add("Editora casa do código");
		palavras.add("Caelum");

		// O integer já realiza uma comparação de tamanho
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		// Recebendo interface funciona fazendo comparação menor
		// Já ordena pelo tamanho da String esse comparing ele já é static
		palavras.sort(Comparator.comparing(s -> s.length()));
		
		//Forma mais simples mais tipado ele invoca o length da String
		palavras.sort(Comparator.comparing(String::length));

		// Passando o único método da interface cosumer diretamente
		palavras.forEach(s -> {
			System.out.println(s);
		});
		
		//É a mesma coisa ele imprime os valores das palavras, 
		palavras.forEach(System.out::println);

		System.out.println(palavras);

	}

}
