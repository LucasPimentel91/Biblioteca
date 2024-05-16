package projeto_tomorrow.ClassesCadastro.livro;

import java.util.ArrayList;
import java.util.Scanner;

public class Livro extends LivrosSecao {
    private String titulo;
    private String autor;
    private int numPaginas;
    private int id;

    public String setTitulo(String titulo){
        return this.titulo = titulo;
    }

    public String setAutor(String autor){
        return this.autor = autor;
    }

    public int setNumPaginas(int numPaginas){
        return this.numPaginas = numPaginas;
    }

    public int setId(int idDoLivro){
        return id;
    }

    @Override
    public void setSecao(ArrayList<String> arr){

        Scanner get = new Scanner(System.in);
        System.out.println("A qual seção pertence este livro: ");
        String nomeSecao = get.next();

        if(validarSecao(arr, nomeSecao) == true){
            this.secao = nomeSecao;
        } else{
            System.out.println("Seção não existe!!!");
            System.out.println("Seções disponíveis: ");
            for(String secao : arr){
                System.out.println(secao);
            }
        }
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public int getNumPaginas(){
        return numPaginas;
    }

    public int getId(){
        return id;
    }

    public String getSecao(){
        return secao;
    }

    public String cadastrarAtributos(String atributo){
        Scanner get = new Scanner(System.in);
        System.out.print(atributo + " do livro: ");
        String atributoNome = get.nextLine();
        return atributoNome;
    }

    public int cadastrarAtributoNumericos(String atributo){
        Scanner get = new Scanner(System.in);
        System.out.print(atributo + " do livro: ");
        int atributoNome = Integer.parseInt(get.nextLine());
        return atributoNome;
    }
}