package br.com.curso;

public class Curso {

	private String nome;
	private int aluno;

	public Curso(final String nome, final int aluno) {
		this.aluno = aluno;
		this.nome = nome;
	}

	public int getAluno() {
		return aluno;
	}

	public String getNome() {
		return nome;
	}
}