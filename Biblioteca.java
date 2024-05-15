package projeto_tomorrow;

import projeto_tomorrow.ClassesCadastro.livro.Livro;
import projeto_tomorrow.ClassesCadastro.Cliente.cliente;
import projeto_tomorrow.ClassesCadastro.livro.LivrosSecao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Biblioteca {
    static ArrayList<String> secoes = new ArrayList<String>(Arrays.asList("Romance", "Didático"));
    static ArrayList<Livro> salvaLivros = new ArrayList<>();// array para salvar as seções dos livros
    static ArrayList<cliente> salvaCliente = new ArrayList<>();
    private static int MAX = 3;


    public static int cabecalho() {
        Scanner get = new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println("\tBIBLIOTECA");
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println("0. Sair");
        System.out.println("1. Cadastros");
        System.out.println("2. Listagens");
        System.out.println("3. Localizar");
        System.out.println("--------------------------");
        return get.nextInt();
    }
    public static int actionsCadastros(){
        Scanner get = new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println(" ".repeat(5)+"0. Sair");
        System.out.println(" ".repeat(5)+"1. Cadastrar Cliente");
        System.out.println(" ".repeat(5)+"2. Cadastrar Livro");
        System.out.println("--------------------------");
        return get.nextInt();
    }
    public static int actionsListagem(){
        Scanner get = new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println("\tBIBLIOTECA");
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println(" ".repeat(5)+"0. Sair");
        System.out.println(" ".repeat(5)+"1. Listar livros livros cadastrados");
        System.out.println(" ".repeat(5)+"2. Listar seções Cadastradas");
        System.out.println("--------------------------");
        return get.nextInt();
    }

    public static void cadastroCliente(cliente[] cliente, int qtdCliente) {
        Scanner texto = new Scanner(System.in);
        cliente cliente = new cliente();
        System.out.println("Digite o nome: ");
        cliente.nome = texto.nextLine();
        System.out.println("Digite a data de nascimento (dd/mm/aaaa): ");
        cliente.dataNascimento = texto.nextLine();
        System.out.println("Digite o sexo (m- masculino/f- feminino)");
        cliente.sexo = texto.nextLine();
        System.out.println("Digite o telefone de contato:");
        System.out.println("OBS: (DDD)9xxxx-xxxx");
        cliente.telefone = texto.nextLine();
        System.out.println("Digite o CPF (sem pontos e hífen): ");
        cliente.CPF = texto.nextLine();
        salvaCliente.add(cliente);
        texto.close();
    }

    public static void listarClientes(ArrayList<cliente> arr){
        for(cliente cliente:arr){
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCPF());
            System.out.println("Telefone de contato: " + cliente.getTelefone());
            System.out.println("-".repeat(40));
        }
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

    private static void endereco(cliente cliente, Livro livro, LivrosSecao secao){

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
                int rsp= actionsCadastros();
                if(rsp == 0){
                    cabecalho();
                } else if (rsp == 1){
                    cadastroCliente(cliente, qtdCliente);
                } else if(rsp == 2){
                    cadastrarLivro();
                }
        } else if(resposta == 2){
                int rsp= actionsListagem();
                if(rsp == 0){
                    cabecalho();
                } else if (rsp == 1){
                    listarLivros(salvaLivros);
                } else if(rsp == 2){
                    listarSecoes(secoes);
                }
            }
    }
    }
}
