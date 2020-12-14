package com.example.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editKwanza = findViewById(R.id.edit_value);
        this.mViewHolder.txtDolar = findViewById(R.id.txt_dolar);
        this.mViewHolder.txtEuro = findViewById(R.id.txt_euro);
        this.mViewHolder.btnConvert = findViewById(R.id.btnConverter);

        this.mViewHolder.btnConvert.setOnClickListener(this);

        this.clearValues();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnConverter){
            String valueToConvert = this.mViewHolder.editKwanza.getText().toString();

            if ("".equals(valueToConvert)) {
                Toast.makeText(this, R.string.informe_valor, Toast.LENGTH_LONG).show();
            } else {
                Double input = Double.parseDouble(valueToConvert);

                Double dolar = input / (665.11);
                this.mViewHolder.txtDolar.setText(String.format("% .2f", dolar).toString());

                Double euro = input / (790.32);
                this.mViewHolder.txtEuro.setText(String.format("% .2f", euro).toString());
            }
        }
    }

    private void clearValues(){
        this.mViewHolder.txtDolar.setText("");
        this.mViewHolder.txtEuro.setText("");
    }

    private static class ViewHolder {
        EditText editKwanza;
        TextView txtDolar;
        TextView txtEuro;
        Button btnConvert;
    }
}