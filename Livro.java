package projeto_tomorrow;
import java.util.Scanner;

public class Livro {
    private String titulo;
    private String autor;
    private int numPaginas;

    public void cadastrarLivro(){
        Scanner get = new Scanner(System.in);

        System.out.print("Título do livro: ");
        this.titulo = get.next();

        System.out.print("Nome do Autor: ");
        this.autor = get.next();

        System.out.println("Qual o número de páginas");
        this.numPaginas = get.nextInt();
    }

    public String titulo(){
       return this.titulo;
    }

    public String autor(){
        return this.autor;
    }

    public int numPaginas(){
        return this.numPaginas;
    }


}
