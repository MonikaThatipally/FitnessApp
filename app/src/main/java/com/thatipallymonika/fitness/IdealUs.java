package com.thatipallymonika.fitness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class IdealUs extends AppCompatActivity {



    private RadioGroup rg;
    private int selectedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideal_us);
        Button bt=(Button)findViewById(R.id.bid);

        final EditText et=(EditText)findViewById(R.id.editText6);
        final  EditText et2=(EditText)findViewById(R.id.editText7);
        final  EditText et8=(EditText)findViewById(R.id.editText8);
        final  EditText et9=(EditText)findViewById(R.id.editText9);



        rg=(RadioGroup)findViewById(R.id.radiosex);

        bt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        try {

                            final String ets = et.getText().toString();
                            double ag = Double.parseDouble(ets);


                            String et2s = et2.getText().toString();
                            double hgt = Double.parseDouble(et2s);

                            String et8s = et8.getText().toString();
                            double inc = Double.parseDouble(et8s);

                            selectedId = rg.getCheckedRadioButtonId();
                            RadioButton maleref = (RadioButton) findViewById(selectedId);


                            double male = 56.2 + 1.41*inc;
                            double female=52 + 0.01*inc;

                            String nstr="your ideal body weight is"+male;
                            String fstr="your ideal body weight is"+female;

                            if(selectedId==R.id.radiomale ){

                                et9.setText(String.format( "your ideal body weight is: %f", male) );
                            }else if(selectedId==R.id.radiofemale ) {

                                et9.setText(String.format( "your ideal body weight is: %f", female) );
                            }



                        }
                        catch (NumberFormatException e)
                        {
                            Toast.makeText(IdealUs.this,"Please input the values",Toast.LENGTH_LONG).show();
                        }



                    }
                }
        );
    }
}