package br.com.alura.deixacomigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoRoiSimples = (Button)findViewById(R.id.button_main_roi_simples);
        botaoRoiSimples.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intentVaiParaCalculadoraRoiSimples = new Intent(MainActivity.this, CalculadoraRoiSimples.class);
                startActivity(intentVaiParaCalculadoraRoiSimples);
            }
        });

        Button botaoRoiTempo = (Button)findViewById(R.id.button_main_roi_tempo);
        botaoRoiTempo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intentVaiParaCalculadoraRoiTempo = new Intent(MainActivity.this, CalculadoraRoiEmTempoPresente.class);
                startActivity(intentVaiParaCalculadoraRoiTempo);
            }
        });

    }
}
