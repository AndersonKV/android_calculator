package com.example.calculatorgorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editValue;
    private TextView textPorcentagem;
    private TextView gorjetaTotal;
    private TextView textTotal;
    private TextView inputTotal;
    private SeekBar seekBarGorjeta;
    private double porcentagem = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValue = findViewById(R.id.editValue);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        gorjetaTotal = findViewById(R.id.gorjetaTotal);
        textTotal = findViewById(R.id.textTotal);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);
        inputTotal = findViewById(R.id.inputTotal);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem) + " %");
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void calcular() {
        String valorRecuperado = editValue.getText().toString();

        if (valorRecuperado == null || valorRecuperado.equals("")) {

            Context context = getApplicationContext();
            CharSequence text = "primeiro digite um valor";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            double valorDigitado = Double.parseDouble(valorRecuperado);
            double gorjeta = valorDigitado * (porcentagem / 100);
            double total = gorjeta + valorDigitado;

            gorjetaTotal.setText("R$ " + Math.round(gorjeta));
            inputTotal.setText("R$: " + total);
        }
    }


}