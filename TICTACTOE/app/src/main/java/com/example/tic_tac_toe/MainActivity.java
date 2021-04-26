package com.example.tic_tac_toe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    Button btnGame, btnGame1, btnGame2, btnGame3, btnGame4, btnGame5, btnGame6, btnGame7, btnGame8, btnGame9;
    TextView txtVwWinner;
    boolean bTurnoX = true;
    int aIWin[] = {0, 0, 0, 0, 0, 0, 0, 0}, iClicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnGame1 = findViewById(R.id.btnGame1);
        btnGame2 = findViewById(R.id.btnGame2);
        btnGame3 = findViewById(R.id.btnGame3);
        btnGame4 = findViewById(R.id.btnGame4);
        btnGame5 = findViewById(R.id.btnGame5);
        btnGame6 = findViewById(R.id.btnGame6);
        btnGame7 = findViewById(R.id.btnGame7);
        btnGame8 = findViewById(R.id.btnGame8);
        btnGame9 = findViewById(R.id.btnGame9);
        txtVwWinner = findViewById(R.id.txtVwWinner);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("btnGame1", btnGame1.getText().toString());
        outState.putString("btnGame2", btnGame2.getText().toString());
        outState.putString("btnGame3", btnGame3.getText().toString());
        outState.putString("btnGame4", btnGame4.getText().toString());
        outState.putString("btnGame5", btnGame5.getText().toString());
        outState.putString("btnGame6", btnGame6.getText().toString());
        outState.putString("btnGame7", btnGame7.getText().toString());
        outState.putString("btnGame8", btnGame8.getText().toString());
        outState.putString("btnGame9", btnGame9.getText().toString());
        outState.putString("txtVwWinner", txtVwWinner.getText().toString());
        outState.putBoolean("btnState1", btnGame1.isEnabled());
        outState.putBoolean("btnState2", btnGame2.isEnabled());
        outState.putBoolean("btnState3", btnGame3.isEnabled());
        outState.putBoolean("btnState4", btnGame4.isEnabled());
        outState.putBoolean("btnState5", btnGame5.isEnabled());
        outState.putBoolean("btnState6", btnGame6.isEnabled());
        outState.putBoolean("btnState7", btnGame7.isEnabled());
        outState.putBoolean("btnState8", btnGame8.isEnabled());
        outState.putBoolean("btnState9", btnGame9.isEnabled());
        outState.putBoolean("bTurnoX", bTurnoX);
        outState.putInt("iClicks", iClicks);
        outState.putIntArray("aIWin", aIWin);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        btnGame1.setText(savedInstanceState.getString("btnGame1"));
        btnGame2.setText(savedInstanceState.getString("btnGame2"));
        btnGame3.setText(savedInstanceState.getString("btnGame3"));
        btnGame4.setText(savedInstanceState.getString("btnGame4"));
        btnGame5.setText(savedInstanceState.getString("btnGame5"));
        btnGame6.setText(savedInstanceState.getString("btnGame6"));
        btnGame7.setText(savedInstanceState.getString("btnGame7"));
        btnGame8.setText(savedInstanceState.getString("btnGame8"));
        btnGame9.setText(savedInstanceState.getString("btnGame9"));
        txtVwWinner.setText(savedInstanceState.getString("txtVwWinner"));
        btnGame1.setEnabled(savedInstanceState.getBoolean("btnState1"));
        btnGame2.setEnabled(savedInstanceState.getBoolean("btnState2"));
        btnGame3.setEnabled(savedInstanceState.getBoolean("btnState3"));
        btnGame4.setEnabled(savedInstanceState.getBoolean("btnState4"));
        btnGame5.setEnabled(savedInstanceState.getBoolean("btnState5"));
        btnGame6.setEnabled(savedInstanceState.getBoolean("btnState6"));
        btnGame7.setEnabled(savedInstanceState.getBoolean("btnState7"));
        btnGame8.setEnabled(savedInstanceState.getBoolean("btnState8"));
        btnGame9.setEnabled(savedInstanceState.getBoolean("btnState9"));
        bTurnoX = savedInstanceState.getBoolean("bTurnoX");
        iClicks = savedInstanceState.getInt("iClicks");
        aIWin = savedInstanceState.getIntArray("aIWin");
    }

    public void onClick(View v) {
        btnGame = findViewById(v.getId());
        if (bTurnoX) {
            btnGame.setText("X");
            bTurnoX = false;
            btnGame.setEnabled(false);
            iClicks++;
            markX(v, iClicks);
        } else {
            btnGame.setText("O");
            bTurnoX = true;
            btnGame.setEnabled(false);
            iClicks++;
            markO(v, iClicks);
        }
    }

    public void onClickReset(View v){
        for (int i = 0; i < 8; i++){
            aIWin[i] = 0;
        }
        iClicks = 0;
        txtVwWinner.setText("");
        btnGame1.setText("-");
        btnGame2.setText("-");
        btnGame3.setText("-");
        btnGame4.setText("-");
        btnGame5.setText("-");
        btnGame6.setText("-");
        btnGame7.setText("-");
        btnGame8.setText("-");
        btnGame9.setText("-");
        bTurnoX = true;
        setAllEnabled(true);
    }

    public void markX(View v, int iClicks){
        switch (v.getId()) {
            case R.id.btnGame1:
                aIWin[0]++;
                aIWin[3]++;
                aIWin[6]++;
                break;
            case R.id.btnGame2:
                aIWin[0]++;
                aIWin[4]++;
                break;
            case R.id.btnGame3:
                aIWin[0]++;
                aIWin[5]++;
                aIWin[7]++;
                break;
            case R.id.btnGame4:
                aIWin[1]++;
                aIWin[3]++;
                break;
            case R.id.btnGame5:
                aIWin[1]++;
                aIWin[4]++;
                aIWin[6]++;
                aIWin[7]++;
                break;
            case R.id.btnGame6:
                aIWin[1]++;
                aIWin[5]++;
                break;
            case R.id.btnGame7:
                aIWin[2]++;
                aIWin[3]++;
                aIWin[7]++;
                break;
            case R.id.btnGame8:
                aIWin[2]++;
                aIWin[4]++;
                break;
            case R.id.btnGame9:
                aIWin[2]++;
                aIWin[5]++;
                aIWin[6]++;
                break;
        }
        for (int i = 0; i < 8; i++){
            if(aIWin[i] == 3){
                txtVwWinner.setText("Gana X");
                new AlertDialog.Builder(this)
                        .setTitle("¡Ganador!")
                        .setMessage("El ganador es X")
                        .setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                }).show();
                setAllEnabled(false);
                iClicks = 0;
            }
        }
        if (iClicks == 9) {
            txtVwWinner.setText("Empate");
            new AlertDialog.Builder(this)
                    .setTitle("Empate")
                    .setMessage("Ha habido un empate")
                    .setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).show();
            setAllEnabled(false);
        }
    }

    public void markO(View v, int iClicks){
        switch (v.getId()) {
            case R.id.btnGame1:
                aIWin[0]--;
                aIWin[3]--;
                aIWin[6]--;
                break;
            case R.id.btnGame2:
                aIWin[0]--;
                aIWin[4]--;
                break;
            case R.id.btnGame3:
                aIWin[0]--;
                aIWin[5]--;
                aIWin[7]--;
                break;
            case R.id.btnGame4:
                aIWin[1]--;
                aIWin[3]--;
                break;
            case R.id.btnGame5:
                aIWin[1]--;
                aIWin[4]--;
                aIWin[6]--;
                aIWin[7]--;
                break;
            case R.id.btnGame6:
                aIWin[1]--;
                aIWin[5]--;
                break;
            case R.id.btnGame7:
                aIWin[2]--;
                aIWin[3]--;
                aIWin[7]--;
                break;
            case R.id.btnGame8:
                aIWin[2]--;
                aIWin[4]--;
                break;
            case R.id.btnGame9:
                aIWin[2]--;
                aIWin[5]--;
                aIWin[6]--;
                break;
        }
        for (int i = 0; i < 8; i++){
            if(aIWin[i] == -3){
                txtVwWinner.setText("Gana O");
                new AlertDialog.Builder(this)
                        .setTitle("¡Ganador!")
                        .setMessage("El ganador es O")
                        .setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                }).show();
                setAllEnabled(false);
                iClicks = 0;
            }
        }
        if (iClicks == 9) {
            txtVwWinner.setText("Empate");
            new AlertDialog.Builder(this)
                    .setTitle("Empate")
                    .setMessage("Ha habido un empate")
                    .setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).show();
            setAllEnabled(false);
        }
    }

    public void setAllEnabled(boolean enabled){
        btnGame1.setEnabled(enabled);
        btnGame2.setEnabled(enabled);
        btnGame3.setEnabled(enabled);
        btnGame4.setEnabled(enabled);
        btnGame5.setEnabled(enabled);
        btnGame6.setEnabled(enabled);
        btnGame7.setEnabled(enabled);
        btnGame8.setEnabled(enabled);
        btnGame9.setEnabled(enabled);
    }

}