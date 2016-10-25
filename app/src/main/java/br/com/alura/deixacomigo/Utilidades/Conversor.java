package br.com.alura.deixacomigo.Utilidades;

/**
 * Created by Everton on 24/10/2016.
 */

public class Conversor {

    public static Double ConverteStringParaDouble(String valorParaConverter) {
        Double valorConvertido;
        if(valorParaConverter == null || valorParaConverter.isEmpty()){
            valorConvertido = 0.0;
        }
        else{
            valorConvertido = Double.parseDouble(valorParaConverter);
        }

        return valorConvertido;
    }

    public static int ConverteStringParaInt(String valorParaConverter){
        int valorConvertido;
        if(valorParaConverter == null || valorParaConverter.isEmpty()){
            valorConvertido = 0;
        }
        else{
            valorConvertido = Integer.parseInt(valorParaConverter);
        }

        return valorConvertido;
    }
}
