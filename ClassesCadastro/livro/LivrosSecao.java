package Biblioteca.ClassesCadastro.livro;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class LivrosSecao {
    protected String secao;


    public void setSecao(ArrayList<String> arr){

        Scanner get = new Scanner(System.in);
        System.out.println("Qual o nome da seção: ");
        String nomeSecao = get.next().trim();

        if(validarSecao(arr, nomeSecao)){
            System.out.println("Seção já cadastrada!!!");
            return;
        } else{
            arr.add(nomeSecao);
            this.secao = nomeSecao;
        }

    }

    public boolean validarSecao(ArrayList<String> arr, String nomeSecao){
        boolean condicao = false;
        for (String s : arr) {
            if (Objects.equals(s.trim().toLowerCase(), nomeSecao.trim().toLowerCase())) {
                condicao = true;
                break;
            }
        }
        return condicao;
    }
}
