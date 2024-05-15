package projeto_tomorrow;

import Validacoes.ValidaCPF;

import projeto_tomorrow.ClassesCadastro.Livro.Livro;
import projeto_tomorrow.ClassesCadastro.Cliente.cliente;
import projeto_tomorrow.ClassesCadastro.Livro.LivrosSecao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class biblioteca {
    static ArrayList<String> secoes = new ArrayList<>(); // array para salvar as seções dos livros

    private static int MAX = 3;


    public static int cabecalho() {
        Scanner get = new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println("\tBIBLIOTECA");
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println("0. Sair");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Cadastrar Livro");
        System.out.println("3. Cadastrar Seção");
        System.out.println("4. Listar");
        System.out.println("--------------------------");
        return get.nextInt();
    }

    public static void cadastroCliente(cliente[] cliente, int qtdCliente) {
        Scanner texto = new Scanner(System.in);
        cliente[qtdCliente] = new cliente();

        boolean chave_nome = false;
        do{
            System.out.println("Digite o nome: ");
            System.out.println("OBS: o nome não deve conter sinais de acentuação.");
            cliente[qtdCliente].nome = texto.nextLine();

            if(cliente.nome.matches("[a-zA-Z]")){
                chave_nome = true;
            }
            else{
                System.out.println("Erro. O nome deve conter apenas letras. Por favor, digite novamente.");
            }
        }while(chave_nome == false);

        /*System.out.println("Digite a data de nascimento (dd/mm/aaaa): ");
        cliente.dataNascimento = texto.nextLine();*/

        boolean chave_sexo = false;
        do{
            System.out.println("Digite o sexo (m- masculino/f- feminino)");
            cliente.sexo = texto.nextLine();

            if(cliente.sexo == "f" || cliente.sexo == "m" ){
                chave_sexo = true;
            }
            else{
                System.out.println("Erro. Por favor, digite novamente.");
            }

        }while(chave_sexo == false);

       /* System.out.println("Digite o telefone de contato:");
        System.out.println("OBS: (DDD)9xxxx-xxxx");
        cliente.telefone = texto.nextLine();*/

    boolean chave_CPF = false;
    do{
        System.out.println("Digite o CPF (sem pontos e hífen): ");
        cliente.CPF = texto.nextLine();

        if (validoCPF.isCPF(cliente.CPF) == true){
            chave_CPF = true;
        }
        else{
            System.out.printf("Erro, CPF invalido. Por favor, insira novamente.\n")
        }


    }while(chave_CPF == false);
    texto.close();

    public static void cadastrarLivro(){
        Livro livro = new Livro();
        livro.setTitulo(livro.cadastrarAtributos("titulo"));
        livro.setAutor(livro.cadastrarAtributos("autor"));
        livro.setNumPaginas(livro.cadastrarAtributoNumericos("Número de páginas"));
        livro.setId(livro.cadastrarAtributoNumericos("Id do livro"));
        livro.setSecao(secoes);
    }
    public static void cadastrarSecao(){
        LivrosSecao secao = new LivrosSecao();
        secao.setSecao(secoes);
    }

    public static void main(String[] args) {
        int num;
        int qtdCliente = 0;
        cliente cliente[]=new cliente[MAX];
        Scanner ler = new Scanner(System.in);
        while(true){
            int resposta = cabecalho(); //pega o valor retornado pelo método e executa o mesmo.
            if(resposta == 0){
                break;
            } else if(resposta == 1){
                cadastroCliente(cliente, qtdCliente);
            } else if(resposta ==  2){
                cadastrarLivro();
            } else if(resposta == 3){
                cadastrarSecao();
            } else{
                return;
            }
        }
    }
}
