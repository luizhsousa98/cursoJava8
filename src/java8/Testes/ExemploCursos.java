package java8.Testes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import br.com.curso.Curso;

public class ExemploCursos {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();

		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		cursos.sort(Comparator.comparing(Curso::getAluno));

		cursos.forEach(curso -> System.out.println(curso.getNome()));

		System.out.println();
		System.out.println("------Atuando com streams-----------");

		cursos.stream().filter(c -> c.getAluno() >= 100)//
				.forEach(c -> System.out.println(c.getNome()));

		System.out.println();
		System.out.println("Quantidade de alunos com mais de cem");
		// Retorna a quantidade de alunos maior que cem
		cursos.stream().filter(c -> c.getAluno() >= 100).map(Curso::getAluno)//
				.forEach(System.out::println);
		
		System.out.println();
		System.out.println("Os cursos que tem mais de 100 alunos eu realizo uma soma do total de alunos dos cursos.");
		int sum = cursos.stream().filter(c -> c.getAluno() >= 100)//
				.mapToInt(Curso::getAluno).sum();
		
		System.out.println(sum);
		
		//stream fluxo de objetos
		//findany me oferece qualquer um, o primeiro que achar
		//Optional me ajuda a trabalhar com nulos
		Optional<Curso> optionalCurso = cursos.stream().filter(c -> c.getAluno() >= 100) //
		.findAny();
		//Me devolvendo um curso
		Curso curso = optionalCurso.orElse(null);
		
		System.out.println(curso.getNome());
		
		//Se existir esse cursos me retorna o nome senão me retorna vazio
		optionalCurso.ifPresent(consumer -> System.out.println(consumer.getNome()));
	}
}
