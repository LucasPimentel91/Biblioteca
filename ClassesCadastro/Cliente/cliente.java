package projeto_tomorrow.ClassesCadastro.Cliente;

public class cliente {
	public String nome;
	public String dataNascimento;
	public String sexo;
	public String telefone;
	public String CPF;
	public String cidade, estado, bairro, rua;
	int num_logra;	
	
	public void listarNome(cliente[] cliente, int quanti) {
		for(int i=0;i<quanti;i++) {
			System.out.println(cliente[i].nome);
		}
	}
}
