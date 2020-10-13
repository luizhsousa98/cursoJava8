package java8.Testes;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import br.com.curso.Curso;

public class TestesAula4 {

	public static void main(String[] args) {

		List<Curso> cursos = new ArrayList<Curso>();

		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		cursos.sort(Comparator.comparing(Curso::getAluno));

		cursos.forEach(curso -> System.out.println(curso.getNome()));

		// Filtrando cursos com mais de 50 alunos

		cursos.stream().filter(c -> c.getAluno() > 50)//
				.forEach(c -> System.out.println(c.getAluno()));

		cursos.stream().map(Curso::getNome);

		System.out.println(cursos);

		cursos.stream()//
				.filter(c -> c.getAluno() > 50)//
				.map(Curso::getAluno) //
				.forEach(System.out::println);

		OptionalDouble media = cursos.stream().filter(c -> c.getAluno() >= 100).//
				mapToInt(Curso::getAluno).average();

		System.out.println(media);
		cursos.stream().filter(c -> c.getAluno() >= 100)//
				.findAny().ifPresent(c -> System.out.println(c.getNome()));

		System.out.println("Nova coleção");
		// Antiga lista aponta para nova lista coletada
		cursos = cursos.stream().collect(Collectors.toList());

		/**
		 * Trazendo o nome do curso e a quantidade de alunos, utilizar parallelStream
		 * para elementos grandes de listas
		 */
		cursos.stream().filter(c -> c.getAluno() >= 100).collect(Collectors.toMap(c -> c.getNome(), c -> c.getAluno()))
				.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos."));
	}

}
