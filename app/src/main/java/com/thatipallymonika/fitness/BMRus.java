package com.thatipallymonika.fitness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class BMRus extends AppCompatActivity {

    double male;
    double ag;
    private EditText et;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
    private RadioGroup rg;
    private int selectedId;
    double female;
    private Spinner spinner1;
    private  double sed;
    private  double la;
    private  double ma;
    private  double va;
    private  double ea;
    private  double fsed;
    private  double fla;
    private  double fma;
    private  double fva;
    private  double fea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmrus);
        Button bt=(Button)findViewById(R.id.button);
        et=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText3);
        et4=(EditText)findViewById(R.id.editText4);
        et5=(EditText)findViewById(R.id.editText5);
        rg=(RadioGroup)findViewById(R.id.radiosex);
        addListenerOnSpinnerItemSelection();

        Button btrbb=(Button)findViewById(R.id.buttonbb);

        btrbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.getText().clear();
                et2.getText().clear();
                et3.getText().clear();
                et4.getText().clear();
                et5.getText().clear();

            }
        });


        bt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        try {

                            String ets = et.getText().toString();
                            double wgt = Double.parseDouble(ets);


                            String et2s = et2.getText().toString();
                            double hgt = Double.parseDouble(et2s);

                            String et5s = et5.getText().toString();
                            double hgtin = Double.parseDouble(et5s);



                            String et3str = et3.getText().toString();
                            // double out = Double.parseDouble(et3str);

                            String et4str= et4.getText().toString();
                            ag = Double.parseDouble(et4str);

                            selectedId = rg.getCheckedRadioButtonId();
                            RadioButton maleref = (RadioButton) findViewById(selectedId);

                            String spintext= spinner1.getSelectedItem().toString();


                            male=66 + ( 6.23 * wgt ) + ( 12.7 *((hgt * 12) + hgtin) ) - ( 6.8 *ag );



                            female =   655 + ( 4.35 *wgt ) + ( 4.7 * ((hgt * 12) + hgtin) ) - ( 4.7 *ag);


                            sed=male*1.2;
                            float ssed = (float) Math.round(sed * 100) / 100;

                            la=male*1.375;
                            float sla = (float) Math.round(sed * 100) / 100;

                            ma=male*1.55;
                            float sma= (float) Math.round(sed * 100) / 100;

                            va=male*1.725;
                            float sva = (float) Math.round(sed * 100) / 100;

                            ea=male*1.9;
                            float sea = (float) Math.round(sed * 100) / 100;

                            fsed=female*1.2;
                            float sfsed = (float) Math.round(sed * 100) / 100;
                            fla=female*1.375;
                            float sfla = (float) Math.round(sed * 100) / 100;
                            fma=female*1.55;
                            float sfma = (float) Math.round(sed * 100) / 100;
                            fva=female*1.725;
                            float sfva = (float) Math.round(sed * 100) / 100;
                            fea=female*1.9;
                            float sfea = (float) Math.round(sed * 100) / 100;

                            if(selectedId==R.id.radiomale && spintext.equals("Sedentary")){

                                et3.setText(String.format( "your daily recommended calorie intake is: %f", ssed) );

                            }else if(selectedId==R.id.radiomale && spintext.equals("Lightly Active")){

                                et3.setText(String.format( "your daily recommended calorie intake  is: %f", sla) );

                            }
                            else if(selectedId==R.id.radiomale && spintext.equals("Moderatetely Active")){

                                et3.setText(String.format( "your daily recommended calorie intake is: %f", sma) );

                            }
                            else if(selectedId==R.id.radiomale && spintext.equals("Very Active")){

                                et3.setText(String.format( "your daily recommended calorie intake is: %f", sva) );

                            }
                            else if(selectedId==R.id.radiomale && spintext.equals("Extra Active")){

                                et3.setText(String.format( "your daily recommended calorie intake is: %f", sea) );

                            }
                            else if(selectedId==R.id.radiofemale && spintext.equals("Sedentary")){

                                et3.setText(String.format( "your daily recommended calorie intake is: %f", sfsed) );

                            }else if(selectedId==R.id.radiofemale && spintext.equals("Lightly Active")){

                                et3.setText(String.format( "your daily recommended calorie intake is: %f", sfla) );

                            }
                            else if(selectedId==R.id.radiofemale && spintext.equals("Moderatetely Active")){

                                et3.setText(String.format( "your daily recommended calorie intake is: %f", sfma) );

                            }
                            else if(selectedId==R.id.radiofemale && spintext.equals("Very Active")){

                                et3.setText(String.format( "your daily recommended calorie intake is: %f", sfva) );

                            }
                            else if(selectedId==R.id.radiofemale && spintext.equals("Extra Active")){

                                et3.setText(String.format( "your daily recommended calorie intake is: %f", sfea) );

                            }
                            else
                            {
                                Toast.makeText(BMRus.this,"Please input values",Toast.LENGTH_LONG).show();
                            }




                        }catch (NumberFormatException e){
                            Toast.makeText(BMRus.this,"Please input the values",Toast.LENGTH_LONG).show();
                        }
                    }}
        );


    }
    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
