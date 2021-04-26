package com.example.eva1_volumen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     Button btnCalc;
     EditText edtRad;
     TextView txtAng;
     SeekBar skbrAng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalc = findViewById(R.id.btnCalc);
        edtRad = findViewById(R.id.edtRad);
        edtRad.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    hideKeyboard(v);
                }
            }
        });
        txtAng = findViewById(R.id.txtAng);

        skbrAng = findViewById(R.id.skbrAng);
        //Punto inicial
        skbrAng.setProgress(0);
        //Punto final
        skbrAng.setMax(360);
        skbrAng.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            //Para cuando cambias el valor en el seekbar
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtAng.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void onClickCalc(View v){
            double vol;
            double rad;
            int ang;
            ang = Integer.parseInt(txtAng.getText().toString());
            rad = Double.parseDouble(edtRad.getText().toString());
            vol = (2*(ang * Math.pow(rad,3))/3);

            Toast.makeText(this, "El volumen es de: " + vol, Toast.LENGTH_SHORT).show();
    }

}