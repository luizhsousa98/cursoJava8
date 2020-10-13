package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {

		List<String> array = new ArrayList<String>();

		array.add("Alura online");
		array.add("Editora casa do codigo");
		array.add("caelum");

		// Ordenando as listas de forma alfab�tica
		// Comparator da um crit�rio de ordena��o
		Comparator<String> comparador = new CompadorPorTamanho();
		Collections.sort(array, comparador);

		System.out.println(array);
		// A pr�pria list no java 8 j� tem os m�todos status na interface da list mesmo
		array.sort(comparador);

		System.out.println(array);
		// foreach recebe um consumidor de Strings
		array.forEach(action -> System.out.println(action));

		// Iterable m�e das collections ele � default
		/**
		 * M�todos default imprime novos m�todos em uma interface n�o � igual a um
		 * abstract ele � igual uma interface Consumer intera todos os elementos em uma cole��o
		 */
		Consumer<String> consumidor = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
				
			}
		};
	}

}

/**
 * Consumer intera todos os elementos em uma cole��o
 * 
 * @author lhsousa
 *
 */
class ImprimeNaLinha implements Consumer<String> {

	// Dada uma String ele imprime uma String
	@Override
	public void accept(String s) {
		System.out.println(s);

	}

}

class CompadorPorTamanho implements Comparator<String> {

	/**
	 * Criterio de tamanhos por String, a que tiver maiores caracteres
	 */
	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length()) {
			return -1;
		}
		if (s1.length() > s2.length()) {
			return 1;
		}
		return 0;
	}

}
