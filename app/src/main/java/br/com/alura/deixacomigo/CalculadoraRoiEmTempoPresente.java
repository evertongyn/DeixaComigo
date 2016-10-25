package br.com.alura.deixacomigo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.alura.deixacomigo.Utilidades.Conversor;

import static java.lang.System.lineSeparator;

public class CalculadoraRoiEmTempoPresente extends AppCompatActivity {

    private final Double TAXA_JUROS_MENSAL = 0.01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_roi_em_tempo_presente);

        Button botaoCalcular = (Button)findViewById(R.id.calc_roi_tempo_button_calcular);
        botaoCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Double valorInvestidoTempoPresente = ObtemValorInvestidoTempoPresente();

                EditText campoValorInvestimento = (EditText)findViewById(R.id.calc_roi_tempo_edit_text_valor_investido);
                String valorInvestimentoParaFormatar = campoValorInvestimento.getText().toString();
                Double valorInvestimento = Conversor.ConverteStringParaDouble(valorInvestimentoParaFormatar);

                String mensagemResultadoUsuario = ObtemMensagemFormatadaUsuario(valorInvestimento, valorInvestidoTempoPresente);

                TextView resultadoUsuario = (TextView)findViewById(R.id.calc_roi_tempo_print_resultado);
                resultadoUsuario.setText(mensagemResultadoUsuario);
                resultadoUsuario.setVisibility(View.VISIBLE);
            }
        });
    }

    private String ObtemMensagemFormatadaUsuario(Double valorInvestimento, Double valorInvestidoTempoPresente) {
        Double diferencaInvestimento = valorInvestidoTempoPresente - valorInvestimento;
        StringBuilder mensagemResultadoUsuario = new StringBuilder();
        String resultadoFormatado = String.format("Investimento: R$%1$.2f", valorInvestimento);
        mensagemResultadoUsuario.append(resultadoFormatado);
        mensagemResultadoUsuario.append("\n");

        resultadoFormatado = String.format("Investimento tempo presente: R$%1$.2f", valorInvestidoTempoPresente);
        mensagemResultadoUsuario.append(resultadoFormatado);
        mensagemResultadoUsuario.append("\n");

        if(diferencaInvestimento > 0){
            Double porcentagemDiferenca = (diferencaInvestimento * 100) / valorInvestimento;

            resultadoFormatado = String.format("O valor do investimento é %1$.1f%% MELHOR", porcentagemDiferenca);
        }
        else if(diferencaInvestimento < 0){
            Double diferencaPositiva = diferencaInvestimento * -1;
            Double porcentagemDiferenca = (diferencaPositiva * 100) / valorInvestimento;

            resultadoFormatado = String.format("O valor do investimento é %1$.1f%% PIOR", porcentagemDiferenca);
        }

        mensagemResultadoUsuario.append(resultadoFormatado);
        resultadoFormatado = " se considerado com o investimento trazido para tempo presente.";
        mensagemResultadoUsuario.append(resultadoFormatado);
        mensagemResultadoUsuario.append("\n");
        resultadoFormatado = "Obs: Foi considerada uma taxa de juros igual a 1% ao mês.";
        mensagemResultadoUsuario.append(resultadoFormatado);

        return mensagemResultadoUsuario.toString();
    }

    private Double ObtemValorInvestidoTempoPresente() {
        EditText campoValorRetorno = (EditText)findViewById(R.id.calc_roi_tempo_edit_text_valor_retorno);
        String valorRetornoParaFormatar = campoValorRetorno.getText().toString();

        EditText campoQuantidadeMesesRetorno = (EditText)findViewById(R.id.calc_roi_tempo_edit_text_qntd_meses);
        String valorQuantidadeMesesRetornoParaFormatar = campoQuantidadeMesesRetorno.getText().toString();

        Double valorRetorno = Conversor.ConverteStringParaDouble(valorRetornoParaFormatar);
        Double valorQuantidadeMesesRetorno = Conversor.ConverteStringParaDouble(valorQuantidadeMesesRetornoParaFormatar);

        Double resultadoTempoPresente = valorRetorno / (Math.pow((1 + TAXA_JUROS_MENSAL), valorQuantidadeMesesRetorno));

        return resultadoTempoPresente;
    }
}
