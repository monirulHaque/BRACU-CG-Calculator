package com.monirul.bracucgemulator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private double n1 = 0, n2 = 0, n3 = 0, n4 = 0, n5 = 0;
    private static String[] gpas = { "0.0", "4.0", "3.7", "3.3", "3.0", "2.7", "2.3", "2.0", "1.7", "1.3", "1.0", "0.7", "0.3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin1 = findViewById(R.id.spinner);
        spin1.setOnItemSelectedListener(this);

        Spinner spin2 = findViewById(R.id.spinner2);
        spin2.setOnItemSelectedListener(this);

        Spinner spin3 = findViewById(R.id.spinner3);
        spin3.setOnItemSelectedListener(this);

        Spinner spin4 = findViewById(R.id.spinner4);
        spin4.setOnItemSelectedListener(this);

        Spinner spin5 = findViewById(R.id.spinner5);
        spin5.setOnItemSelectedListener(this);

        List<String> wordList = Arrays.asList(gpas);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,wordList);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(aa);
        spin2.setAdapter(aa);
        spin3.setAdapter(aa);
        spin4.setAdapter(aa);
        spin5.setAdapter(aa);


    }


    public void butt(View view) {
//        Toast.makeText(getApplicationContext(),("" +n1) , Toast.LENGTH_LONG).show();
        double ccgpa, ccredits, c1, c2, c3, c4, c5, cgpa, credits;

        ccgpa = Double.parseDouble(((EditText)findViewById(R.id.ccgpa)).getText().toString());
        ccredits = Double.parseDouble(((EditText)findViewById(R.id.ccredits)).getText().toString());
        credits = ccredits;

        c1 = Double.parseDouble(((EditText)findViewById(R.id.credit1)).getText().toString());
        c2 = Double.parseDouble(((EditText)findViewById(R.id.credit2)).getText().toString());
        c3 = Double.parseDouble(((EditText)findViewById(R.id.credit3)).getText().toString());
        c4 = Double.parseDouble(((EditText)findViewById(R.id.credit4)).getText().toString());
        c5 = Double.parseDouble(((EditText)findViewById(R.id.credit5)).getText().toString());

        credits += (c1 + c2 + c3 + c4 + c5);

        cgpa = ((ccgpa*ccredits) + (n1*c1) + (n2*c2) + (n3*c3) + (n4*c4) + (n5*c5))/credits;
        //Toast.makeText(getApplicationContext(),("" +cgpa) , Toast.LENGTH_LONG).show();

//        Intent nextpage = new Intent(this, Result.class);
//        nextpage.putExtra("cg", ("" + cgpa));
//        nextpage.putExtra("credit", ("" + credits));
//        startActivity(nextpage);

        TextView tv = findViewById(R.id.textView6);
        String s = String.format("Estimated cgpa: %.2f\n\nTotal Credits: %.1f",cgpa,credits);
        tv.setText(s);

        Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
        tv.setTypeface(boldTypeface);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinner:
                // do stuffs with you spinner 1
                n1 = Double.parseDouble(parent.getItemAtPosition(position).toString());
                break;
            case R.id.spinner2:
                // do stuffs with you spinner 1
                n2 = Double.parseDouble(parent.getItemAtPosition(position).toString());
                break;
            case R.id.spinner3:
                // do stuffs with you spinner 1
                n3 = Double.parseDouble(parent.getItemAtPosition(position).toString());
                break;
            case R.id.spinner4:
                // do stuffs with you spinner 1
                n4 = Double.parseDouble(parent.getItemAtPosition(position).toString());
                break;
            case R.id.spinner5:
                // do stuffs with you spinner 1
                n5 = Double.parseDouble(parent.getItemAtPosition(position).toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

