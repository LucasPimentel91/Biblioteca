package projeto_tomorrow;

import projeto_tomorrow.ClassesCadastro.livro.Livro;
import projeto_tomorrow.ClassesCadastro.Cliente.cliente;
import projeto_tomorrow.ClassesCadastro.livro.LivrosSecao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class biblioteca {
    static ArrayList<String> secoes = new ArrayList<String>(Arrays.asList("Romance", "Didático"));
    static ArrayList<Livro> salvaLivros = new ArrayList<>();// array para salvar as seções dos livros
    static ArrayList<cliente> salvaCliente = new ArrayList<>();// array para salvar os clientes

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
        System.out.println("4. Listar livros livros cadastrados");
        System.out.println("5. Listar seções Cadastradas");
        System.out.println("--------------------------");
        return get.nextInt();
    }

    public static void cadastroCliente(cliente[] cliente, int qtdCliente) {
        Scanner texto = new Scanner(System.in);
        cliente cliente = new cliente();
        System.out.println("Digite o nome: ");
        cliente[qtdCliente].nome = texto.nextLine();
        System.out.println("Digite a data de nascimento (dd/mm/aaaa): ");
        cliente[qtdCliente].dataNascimento = texto.nextLine();
        System.out.println("Digite o sexo (m- masculino/f- feminino)");
        cliente[qtdCliente].sexo = texto.nextLine();
        System.out.println("Digite o telefone de contato:");
        System.out.println("OBS: (DDD)9xxxx-xxxx");
        cliente[qtdCliente].telefone = texto.nextLine();
        System.out.println("Digite o CPF (sem pontos e hífen): ");
        cliente[qtdCliente].CPF = texto.nextLine();
        salvaCliente.add(cliente);

        texto.close();
    }

    public static void cadastrarLivro(){
        Livro livro = new Livro();
        livro.setTitulo(livro.cadastrarAtributos("titulo"));
        livro.setAutor(livro.cadastrarAtributos("autor"));
        livro.setNumPaginas(livro.cadastrarAtributoNumericos("Número de páginas"));
        livro.setId(livro.cadastrarAtributoNumericos("Id do livro"));
        livro.setSecao(secoes);
        salvaLivros.add(livro);
    }
    public static void cadastrarSecao(){
        LivrosSecao secao = new LivrosSecao();
        secao.setSecao(secoes);
    }
    private static void listarLivros(ArrayList<Livro> arr) {
        for(Livro livro:arr){
            System.out.println("Livro: "+ livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Seção: " + livro.getSecao());
            System.out.println("-".repeat(40));
        }
    }
    private static void listarSecoes(ArrayList<String> arr){
        for(String secao: secoes){
            System.out.println(secao);
        }
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
            } else if(resposta == 4){
                listarLivros(salvaLivros);
            } else if(resposta == 5){
                listarSecoes(secoes);
            }
        }
    }
}
