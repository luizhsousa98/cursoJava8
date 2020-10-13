package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenandoStringsComLambdas {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();

		palavras.add("Alura cursos online");
		palavras.add("Editora casa do c�digo");
		palavras.add("Caelum");

		// O integer j� realiza uma compara��o de tamanho
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		// Recebendo interface funciona fazendo compara��o menor
		// J� ordena pelo tamanho da String esse comparing ele j� � static
		palavras.sort(Comparator.comparing(s -> s.length()));
		
		//Forma mais simples mais tipado ele invoca o length da String
		palavras.sort(Comparator.comparing(String::length));

		// Passando o �nico m�todo da interface cosumer diretamente
		palavras.forEach(s -> {
			System.out.println(s);
		});
		
		//� a mesma coisa ele imprime os valores das palavras, 
		palavras.forEach(System.out::println);

		System.out.println(palavras);

	}

}
