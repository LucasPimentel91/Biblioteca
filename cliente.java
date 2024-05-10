package projeto_tomorrow;

public class cliente {
	String nome;
	String dataNascimento;
	String sexo;
	String telefone;
	String CPF;
	String cidade, estado, bairro, rua;
	int num_logra;	
	
	public void listarNome(cliente[] cliente, int quanti) {
		for(int i=0;i<quanti;i++) {
			System.out.println(cliente[i].nome);
		}
	}
}
