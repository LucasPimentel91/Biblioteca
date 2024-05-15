package projeto_tomorrow.Cliente;

public class Cliente {
	String nome;
	String dataNascimento;
	String sexo;
	String telefone;
	String CPF;
	String cidade, estado, bairro, rua;
	int num_logra;	
	
	public void listarNome(Cliente[] cliente, int quanti) {
		for(int i=0;i<quanti;i++) {
			System.out.println(cliente[i].nome);
		}
	}
}
