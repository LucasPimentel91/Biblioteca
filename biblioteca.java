package projeto_tomorrow;

import java.util.ArrayList;
import java.util.Scanner;

public class biblioteca {
	
	public static void cabecalho() {
		System.out.println("--------------------------");
		System.out.println("--------------------------");
		System.out.println("\tBIBLIOTECA");
		System.out.println("--------------------------");
		System.out.println("--------------------------");
		System.out.println("1. Cadastrar Cliente");
		System.out.println("2. Cadastrar Livro");
		System.out.println("3. Cadastrar Seção");
		System.out.println("4. Listar");
		System.out.println("--------------------------");
	}
	
	public static void cadastroCliente() {
		Scanner texto = new Scanner(System.in);
		cliente primeiro = new cliente();
		System.out.println("Digite o nome: ");
		primeiro.nome = texto.nextLine();
		System.out.println("Digite a data de nascimento (dd/mm/aaaa): ");
		primeiro.dataNascimento = texto.nextLine();
		System.out.println("Digite o sexo (m- masculino/f- feminino)");
		primeiro.sexo = texto.nextLine();
		System.out.println("Digite o telefone de contato:");
		System.out.println("OBS: (DDD)9xxxx-xxxx");
		primeiro.telefone = texto.nextLine();
		System.out.println("Digite o CPF (sem pontos e hífen): ");
		primeiro.CPF = texto.nextLine();
		
		texto.close();
	}


	public static void cadastrarLivro(){
		Livro livro = new Livro();
		livro.setTitulo(livro.cadastrarAtributos("titulo"));
		livro.setAutor(livro.cadastrarAtributos("autor"));
		livro.setNumPaginas(livro.cadastrarAtributoNumericos("Número de páginas"));
		livro.setId(livro.cadastrarAtributoNumericos("Id do livro"));

	}

	public static void main(String[] args) {
		cabecalho();
		cadastrarLivro();

	}

}
