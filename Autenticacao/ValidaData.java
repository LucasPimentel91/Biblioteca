package projeto_tomorrow.Autenticacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidaData {
    public static boolean validaData(String data) {
        try {
            //neste caso meu formatador irá trabalhar com o formato "dd/MM/yyyy"
            //o "M" dessa String é maiusculo porque "m" minusculo se n me engano é minutos
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        /*a mágica desse método acontece aqui, pois o setLenient() é usado para setar, quando eu seto para "false" estou dizendo
       que não aceito datas falsas como 31/02/2016*/
            sdf.setLenient(false);
            //aqui eu tento converter a String em um objeto do tipo date, se funcionar
            //sua data é valida
            sdf.parse(data);
            //se nada deu errado retorna true
            return true;
        } catch (ParseException ex) {
        /*se algum passo dentro do "try" der errado quer dizer que sua data é falsa, então,
   retorna falso*/
            return false;
        }
    }public static boolean dataMenorQueHoje(String data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //Aqui eu converto uma data em LocalDate e digo que quero no formato do DateTimeFormatter
        //que criei acima
        LocalDate dataVerificada = LocalDate.parse(data, dtf);
        LocalDate hoje = LocalDate.now(); //pega a data de hoje
        //Se dataVerificada comparada com hoje é menor ou igual a zero então retorna verdadeiro,
        //quando a data1 é menor isso retorna -1, quando é maior retorna 1, e quando é igual retorna 0
        //por isso eu comparei com <=0 abaixo
        return dataVerificada.compareTo(hoje) <= 0;
    }

}


