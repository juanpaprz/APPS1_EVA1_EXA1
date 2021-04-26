package com.example.eva1_exa1_acredita_noacredita;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar skAcredita, skCalificacion;
    TextView numAcredita, numCalificacion, txtAcre;
    int i, j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skAcredita = findViewById(R.id.skAcredita);
        skCalificacion = findViewById(R.id.skCalificacion);
        numAcredita = findViewById(R.id.txtPuntosSeek);
        numCalificacion = findViewById(R.id.txtCalificacionSeek);
        txtAcre = findViewById(R.id.txtAcreditado);

        skAcredita.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numAcredita.setText("" + progress);
                i = progress;
                if(j>=i){
                    txtAcre.setText("ACREDITA!!");
                }else{
                    txtAcre.setText("NO ACREDITA!!");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        skCalificacion.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numCalificacion.setText("" + progress);
                j = progress;
                if(j>=i){
                    txtAcre.setText("ACREDITA!!");
                }else{
                    txtAcre.setText("NO ACREDITA!!");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}