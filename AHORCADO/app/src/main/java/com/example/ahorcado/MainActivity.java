package com.example.ahorcado;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtVwWord, txtVwTrs, txtVwLett;
    EditText edtTxtWord;
    Button btnOk, btnNew;
    RadioGroup rdGrpDiff;
    CheckBox chkBxXT;

    StringBuilder sHint;
    String sPalabra, sLetra;
    String[] aSpalabras= {"perro", "planeta", "armario", "pantalonera", "computadora", "pescado", "android", "caballo", "bateria", "actividad"};
    int iTrs;
    boolean bXtTream;

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        txtVwWord = findViewById(R.id.txtVwWord);
        txtVwTrs = findViewById(R.id.txtVwTrs);
        txtVwLett = findViewById(R.id.txtVwLett);
        edtTxtWord = findViewById(R.id.edtTxtWord);
        btnOk = findViewById(R.id.btnOk);
        btnNew = findViewById(R.id.btnNew);
        rdGrpDiff = findViewById(R.id.rdGrpDiff);
        chkBxXT = findViewById(R.id.chkBxXT);

        btnOk.setOnClickListener(this);
        btnNew.setOnClickListener(this);

        setDifficulty();
        genPalabra();
    }

    public void genPalabra(){
        sPalabra = aSpalabras[random.nextInt(10)];
        sHint = new StringBuilder();
        for (int i = 0; i < sPalabra.length(); i++){
            sHint.append("_ ");
        }
        txtVwWord.setText(sHint);
        txtVwLett.setText(" " + sPalabra.length());
    }

    public void setDifficulty(){
        switch (rdGrpDiff.getCheckedRadioButtonId()){
            case R.id.rdBtnDif:
                iTrs = 2;
                break;
            case R.id.rdBtnMed:
                iTrs = 4;
                break;
            case R.id.rdBtnFac:
                iTrs = 6;
                break;
        }
        bXtTream = chkBxXT.isChecked();
        txtVwTrs.setText(" " + iTrs);
    }

    public void checkChar(){
        boolean bWrong = true;
        for (int i = 0; i < sPalabra.length(); i++){
            if (sLetra.charAt(0) == sPalabra.charAt(i)){
                sHint.setCharAt(i + i, sLetra.charAt(0));
                txtVwWord.setText(sHint);
                bWrong = false;
                checkWin();
            }
        }
        if (bWrong){
            iTrs--;
            txtVwTrs.setText(" " + iTrs);
            if (iTrs == 0){
                btnOk.setEnabled(false);
                showCuadroDialogo(R.drawable.perdedor, "HAS PERDIDO!!");
            }
        }
    }

    public void checkWin(){
        String sWordSpace = txtVwWord.getText().toString();
        String sWordCheck = "";
        for (int i = 0; i < sWordSpace.length(); i++){
            if (sWordSpace.charAt(i) != ' '){
                sWordCheck = sWordCheck + sWordSpace.charAt(i);
            }
        }
        if (sWordCheck.equals(sPalabra)){
            showCuadroDialogo(R.drawable.ganador, "HAS GANADO!!");
            txtVwWord.setText(sPalabra);
            btnOk.setEnabled(false );
        }
    }

    public void showCuadroDialogo(int iIdImg, String sTxtEnd){
        Dialog dlgCuadroDialogo = new Dialog(this);
        dlgCuadroDialogo.setContentView(R.layout.cuadro_dialogo);

        ImageView imgVwEnd;
        TextView txtVwEnd;
        Button btnClose;

        imgVwEnd = dlgCuadroDialogo.findViewById(R.id.imgVwEnd);
        txtVwEnd = dlgCuadroDialogo.findViewById(R.id.txtVwEnd);
        btnClose = dlgCuadroDialogo.findViewById(R.id.btnClose);

        imgVwEnd.setImageResource(iIdImg);
        txtVwEnd.setText(sTxtEnd);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlgCuadroDialogo.dismiss();
            }
        });
        dlgCuadroDialogo.show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnOk) {
            sLetra = edtTxtWord.getText().toString().toLowerCase();
            edtTxtWord.setText("");
            if (sLetra.length() == 1){
                if (bXtTream){
                    checkChar();
                } else {
                    if (sLetra.equals("a") || sLetra.equals("e") || sLetra.equals("i") || sLetra.equals("o") || sLetra.equals("u") ){
                        for (int i = 0; i < sPalabra.length(); i++){
                            if (sLetra.charAt(0) == sPalabra.charAt(i)){
                                sHint.setCharAt(i + i, sLetra.charAt(0));
                                txtVwWord.setText(sHint);
                                checkWin();
                            }
                        }
                    } else {
                        checkChar();
                    }
                }
            } else {
                if (sLetra.equals(sPalabra)){
                    txtVwWord.setText(sPalabra);
                    btnOk.setEnabled(false);
                    showCuadroDialogo(R.drawable.ganador, "HAS GANADO!!");
                } else {
                    btnOk.setEnabled(false);
                    iTrs = 0;
                    txtVwTrs.setText(" " + iTrs);
                    showCuadroDialogo(R.drawable.perdedor, "HAS PERDIDO!!");
                }
            }
        } else if (v.getId() == R.id.btnNew) {
            genPalabra();
            setDifficulty();
            btnOk.setEnabled(true);
        }
    }
}