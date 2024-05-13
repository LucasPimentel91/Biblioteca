package projeto_tomorrow;

import java.util.Scanner;

public class Livro {
    private String titulo;
    private String autor;
    private int numPaginas;
    private int id;


    public String setTitulo(){
        return this.titulo = cadastrarAtributos("Titulo");
    }

    public String setAutor(){
        return this.autor = cadastrarAtributos("Autor");
    }

    public int setNumPaginas(){
        return this.numPaginas = cadastrarAtributoNumericos("Número de páginas");
    }

    public int setId(){
        return this.id = cadastrarAtributoNumericos("Id");
    }

    public void mostrarLivroCadastrado(){
        System.out.println("-".repeat(40));
        System.out.println("-".repeat(10)+" Livro cadastrado " + "-".repeat(10));
        System.out.println("Autor: "+autor);
        System.out.println("Título: "+titulo);
        System.out.println("Número de páginas: "+numPaginas);
        System.out.println("ID: "+id);
    }


   private String cadastrarAtributos(String atributo){
        Scanner get = new Scanner(System.in);
        System.out.print(atributo + " do livro: ");
        String atributoNome = get.nextLine();
        return atributoNome;
    }
    private int cadastrarAtributoNumericos(String atributo){
        Scanner get = new Scanner(System.in);
        System.out.print(atributo + " do livro: ");
        int atributoNome = Integer.parseInt(get.nextLine());
        return atributoNome;
    }
}