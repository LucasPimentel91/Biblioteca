package projeto_tomorrow;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Autenticacao.ValidaCPF;
import ClassesCadastro.Cliente.cliente;
import ClassesCadastro.livro.Livro;
import ClassesCadastro.livro.LivrosSecao;

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

    public static int actionsLocalizar(){
        Scanner get = new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.println("Localizar por: ");
        System.out.println("0. Sair");
        System.out.println("1. Nome:");
        System.out.println("2. Seção:");
        System.out.println("3. Autor:");
        System.out.println("--------------------------");
        return get.nextInt();
    }

    public static void cadastroCliente() {
        Scanner texto = new Scanner(System.in);
        cliente cliente = new cliente();

        // Cadastrar nome:
        boolean chave_nome = false;
    do {
        System.out.println("Digite o nome: ");
        cliente.nome = texto.nextLine();

        if (cliente.nome.matches("[a-zA-Z]")) {
            chave_nome = true;
        } else {
            System.out.println("Erro. O nome deve conter apenas letras. Por favor, digite novamente.");
        }
    } while (!chave_nome);


        // CADASTRAR DATA DE NASCIMENTO:
        /*boolean chave_data = false;
        do {
            System.out.println("Digite a data de nascimento (dd/mm/aaaa): ");
            cliente.dataNascimento = texto.nextLine();
    
            if (validaData(cliente.dataNascimento) && dataMenorQueHoje(cliente.dataNascimento) <= 0) {
                chave_data = true;
            } else {
                System.out.println("Erro, data de nascimento invalida. Por favor, insira novamente.\n");
            }
    
        } while (chave_data == false);
    */
        //CADASTRAR SEXO:
        boolean chave_sexo = false;
        do {
            System.out.println("Digite o sexo (m- masculino/f- feminino)");
            cliente.sexo = texto.nextLine();
    
            if (cliente.sexo == "f" || cliente.sexo == "m") {
                chave_sexo = true;
            } else {
                System.out.println("Erro. Por favor, digite novamente.");
            }
    
        } while (chave_sexo == false);
    
        // CADASTRAR TELEFONE:
boolean chave_tele;
do {
    chave_tele = true;
    System.out.println("Digite o telefone de contato:");
    System.out.println("OBS: (DDD)9xxxx-xxxx");
    cliente.telefone = texto.nextLine();
    Pattern pattern1 = Pattern.compile("^[(][0-9]{3}[)]9[0-9]{4}-[0-9]{4}$");
    Matcher matcher1 = pattern1.matcher(cliente.telefone);
    if (!matcher1.find())
        chave_tele= false;

} while (!chave_tele);

        // CADASTRAR CPF:
        boolean chave_CPF = false;
        do{ 
        ValidaCPF cpf = new ValidaCPF();
        System.out.println("Digite o CPF (sem pontos e hífen): ");
        String dado = texto.nextLine();
        if(cpf.validoCPF(dado) == true){
            cliente.CPF = dado;
            chave_CPF = true;
        }else{
            System.out.println("CPF inválido! Tente novamente.");

        }
    }while(chave_CPF = false);
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

    private static void localizarLivroNome(){
        Scanner get = new Scanner(System.in);
        System.out.println("Digite o nome do livro");
        String nome = get.nextLine().toLowerCase();
        for(Livro livro: salvaLivros){
            String titulo = livro.getTitulo().toLowerCase();
            if (nome.equals(titulo)){
                System.out.println("-".repeat(40));
                System.out.println("Livro: "+ livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Seção: " + livro.getSecao());
                System.out.println("-".repeat(40));
            }
        }
    }

    private static void localizarLivroSecao(){
        Scanner get = new Scanner(System.in);
        System.out.println("Digite o nome da seção do livro");
        String nome = get.nextLine().toLowerCase();
        for(Livro livro: salvaLivros){
            String titulo = livro.getSecao().toLowerCase();
            if (nome.equals(titulo)){
                System.out.println("-".repeat(40));
                System.out.println("Livro: "+ livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Seção: " + livro.getSecao());
                System.out.println("-".repeat(40));
            }
        }
    }

    private static void localizarLivroAutor(){
        Scanner get = new Scanner(System.in);
        System.out.println("Digite o nome do autor do livro");
        String nome = get.nextLine().toLowerCase();
        for(Livro livro: salvaLivros){
            String autor = livro.getAutor().toLowerCase();
            if (nome.equals(autor)){
                System.out.println("-".repeat(40));
                System.out.println("Livro: "+ livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Seção: " + livro.getSecao());
                System.out.println("-".repeat(40));
                System.out.println("-".repeat(40));
            }
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
                    cadastroCliente();
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
            }else if(resposta == 3){
                int rsp = actionsLocalizar();
                if(rsp == 1){
                    localizarLivroNome();
                } else if(rsp == 2){
                    localizarLivroSecao();
                } else if(rsp == 3){
                    localizarLivroAutor();
                } else if(rsp == 0){
                    cabecalho();
                }
    }
    }
}}
