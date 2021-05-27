package com.example.project2_mikhsangumanof;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

public class SecondActivity extends Activity implements AdapterView.OnItemSelectedListener {

    CheckBox cbJava, cbPHP, cbPerl, cbPhy, cbRub, cbC;
    Spinner spSkills;
    Button btnProses;
    String []jobSkil={"Basic","Intermade","Advance"};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        cbJava = findViewById(R.id.cbJava);
        cbPHP = findViewById(R.id.cbPHP);
        cbPerl = findViewById(R.id.cbPerl);
        cbPhy = findViewById(R.id.cbPhy);
        cbRub = findViewById(R.id.cbRub);
        cbC = findViewById(R.id.cbC);

        spSkills = findViewById(R.id.spSkills);
        spSkills.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, jobSkil);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSkills.setAdapter(aa);

        btnProses = findViewById(R.id.btnProses);
        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gaji();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),jobSkil[position],Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void gaji() {
        int total=0;
        StringBuilder sb = new StringBuilder();

        sb.append("Total Gaji Karyawan");
        if(cbJava.isChecked()){
            sb.append("\nGaji Programmer Java\t: Rp.5.000.000,-");
            total+=5000000;
        }
        if(cbPHP.isChecked()){
            sb.append("\nGaji Programmer PHP\t: Rp.5.000.000,-");
            total+=5000000;
        }
        if(cbPerl.isChecked()){
            sb.append("\nGaji Programmer Perl\t: Rp.5.000.000,-");
            total+=5000000;
        }
        if(cbPhy.isChecked()){
            sb.append("\nGaji Programmer Phyton\t: Rp.5.000.000,-");
            total+=5000000;
        }
        if(cbRub.isChecked()){
            sb.append("\nGaji Programmer Ruby\t: Rp.5.000.000,-");
            total+=5000000;
        }
        if(cbC.isChecked()){
            sb.append("\nGaji Programmer C\t: Rp.5.000.000,-");
            total+=5000000;
        }
        Toast.makeText(getApplicationContext(), "Total Gaji : "+total,Toast.LENGTH_LONG).show();
    }
}