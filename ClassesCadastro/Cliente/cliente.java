package projeto_tomorrow.ClassesCadastro.Cliente;

public class cliente {
	public String nome;
	public String dataNascimento;
	public String sexo;
	public String telefone;
	public String CPF;

	public void cadastrarCliente(String nome, String data, String sexo, String fone, String cpf){
		this.nome = nome;
		this.dataNascimento = data;
		this.sexo = sexo;
		this.telefone = fone;
		this.CPF=cpf;

	}

	public void listarNome(cliente[] cliente, int quanti) {
		for(int i=0;i<quanti;i++) {
			System.out.println(cliente[i].nome);
		}
	}
}
