package projeto_tomorrow.ClassesCadastro.Cliente;

import java.util.ArrayList;

public class cliente {
	public String nome;
	public String dataNascimento;
	public String sexo;
	public String telefone;
	public String CPF;
	static ArrayList<String> LivroEmprestado = new ArrayList<>();


	public void cadastrarCliente(String nome, String data, String sexo, String fone, String cpf){
		this.nome = nome;
		this.dataNascimento = data;
		this.sexo = sexo;
		this.telefone = fone;
		this.CPF=cpf;
	}

	/*public void emprestar(ArrayList<String> LivroEmprestado){
		LivroEmprestado.add(String);
	}*/

	public String getNome(){
		return nome;
	}

	public String getCPF(){
		return CPF;
	}

	public String getTelefone(){
		return telefone;
	}

}
