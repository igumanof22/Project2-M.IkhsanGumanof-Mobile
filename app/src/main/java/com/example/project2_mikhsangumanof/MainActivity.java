package com.example.project2_mikhsangumanof;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    EditText editKode, editNama, editHarga, editJumlah;
    TextView txtCek;
    Button btnSubmit, btnNext;
    RadioButton rbKg, rbKodi, rbSachet, rbLusin;
    RadioGroup rgJenis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editKode = findViewById(R.id.editKode);
        editNama = findViewById(R.id.editNama);
        editHarga = findViewById(R.id.editHarga);
        editJumlah = findViewById(R.id.editJum);
        rgJenis = findViewById(R.id.rgJenis);
        rbKg = findViewById(R.id.rbKg);
        rbKodi = findViewById(R.id.rbKodi);
        rbSachet = findViewById(R.id.rbSachet);
        rbLusin = findViewById(R.id.rbLusin);
        btnSubmit = findViewById(R.id.btnSub);
        btnNext = findViewById(R.id.btnNext);
        txtCek = findViewById(R.id.txtCek);

        btnSubmit.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btnSub:
                proses();
            break;

            case R.id.btnNext:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            break;
        }
    }

    private void proses() {
        double jum, harga, bayar, pajak, diskon = 0, hasil;
        String kode, nama, jenis = null, metode[] = {"Cash on Delivery","Credit Card", "ATM"};


        kode = editKode.getText().toString();
        nama = editNama.getText().toString();

        harga = Double.parseDouble(String.valueOf(editHarga.getText()));
        jum = Double.parseDouble(String.valueOf(editJumlah.getText()));

        if(rbKg.isChecked()){
            jenis = rbKg.getText().toString();
        }
        else if(rbKodi.isChecked()){
            jenis = rbKodi.getText().toString();
        }
        else if(rbSachet.isChecked()){
            jenis = rbSachet.getText().toString();
        }
        else if(rbLusin.isChecked()){
            jenis = rbLusin.getText().toString();
        }

        bayar = harga*jum;
        pajak = bayar*0.05;

        if (jum > 10){
            diskon = bayar*0.1;
        }
        else{
            diskon = 0;
        }

        hasil = (bayar+pajak)-diskon;

        txtCek.setText("TRANSAKSI PEMBELIAN : " +
                "\nKode Barang     : "+kode+
                "\nNama Barang     : "+nama+
                "\nJenis Satuan    : "+jenis+
                "\nHarga Satuan    : "+String.valueOf(harga)+
                "\nJumlah Beli     : "+String.valueOf(jum)+
                "\nPajak           : 5%  -> "+String.valueOf(pajak)+
                "\nDiskon          : 10% -> "+String.valueOf(diskon)+
                "\nTotal           : "+String.valueOf(hasil));
    }
}


