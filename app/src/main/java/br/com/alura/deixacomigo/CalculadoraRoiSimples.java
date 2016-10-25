package br.com.alura.deixacomigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;

import br.com.alura.deixacomigo.Utilidades.Conversor;

public class CalculadoraRoiSimples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_roi_simples);

        Button botaoCalcular = (Button)findViewById(R.id.calc_roi_simples_button_calcular);
        botaoCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Double roiSimples = ObtemRoiSimples();

                String mensagemResultado = ObtemMensagemResultado(roiSimples);

                TextView resultadoUsuario = (TextView)findViewById(R.id.calc_roi_simples_print_resultado);
                resultadoUsuario.setText(mensagemResultado);
                resultadoUsuario.setVisibility(View.VISIBLE);
            }
        });

    }

    private String ObtemMensagemResultado(Double roiSimples) {
        String roiFormatado = roiSimples.toString().replace('.','@');
        String casasAntesEDepoisDaVirgula[];
        casasAntesEDepoisDaVirgula = roiFormatado.split("@");
        int inteiroAntesDaVigurla = Integer.parseInt(casasAntesEDepoisDaVirgula[0]);
        int inteiroDepoisDaVirgula = Integer.parseInt(casasAntesEDepoisDaVirgula[1]);
        boolean temValorValidoDepoisDaVirgula = inteiroDepoisDaVirgula != 0;

        String mensagemResultado;
        if(temValorValidoDepoisDaVirgula){
            mensagemResultado = String.format("O retorno obtido foi de %1$.1f%% do valor investido", roiSimples);
        }
        else{
            mensagemResultado = String.format("O retorno obtido foi de %1$d%% do valor investido", inteiroAntesDaVigurla);
        }

        return mensagemResultado;
    }

    private Double ObtemRoiSimples() {
        EditText campoValorInvestido = (EditText)findViewById(R.id.calc_roi_simples_edit_text_valor_investido);
        String valorInvestidoParaFormatar = campoValorInvestido.getText().toString();

        EditText campoValorRetornado = (EditText)findViewById(R.id.calc_roi_simples_edit_text_valor_retorno);
        String valorDeRetornoParaFormatar = campoValorRetornado.getText().toString();

        Double valorInvestido = Conversor.ConverteStringParaDouble(valorInvestidoParaFormatar);
        Double valorDeRetorno = Conversor.ConverteStringParaDouble(valorDeRetornoParaFormatar);

        Double resultado;
        resultado = (valorDeRetorno - valorInvestido) / valorInvestido;

        return resultado * 100;
    }
}
