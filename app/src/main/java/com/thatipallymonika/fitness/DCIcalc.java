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
import android.widget.TextView;
import android.widget.Toast;

public class DCIcalc extends AppCompatActivity {
    double male;
    double ag;
    private EditText et;
    private EditText et2;
    private TextView et3;
    private EditText et4;
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
        setContentView(R.layout.activity_dcicalc);

        Button bt=(Button)findViewById(R.id.button);
        et=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(TextView)findViewById(R.id.editText3);
        et4=(EditText)findViewById(R.id.editText4);
        rg=(RadioGroup)findViewById(R.id.radiosex);
        addListenerOnSpinnerItemSelection();

        Button btrb=(Button)findViewById(R.id.buttonb);

        btrb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.getText().clear();
                et2.getText().clear();
                et3.setText("");
                et4.getText().clear();

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

                            String et3str = et3.getText().toString();
                            // double out = Double.parseDouble(et3str);

                            String et4str= et4.getText().toString();
                            ag = Double.parseDouble(et4str);

                            selectedId = rg.getCheckedRadioButtonId();
                            RadioButton maleref = (RadioButton) findViewById(selectedId);

                            String spintext= spinner1.getSelectedItem().toString();

                            if(wgt<=200 && hgt<=215 && ag<110){
                            male=66 + ( 13.7 *wgt) + ( 5 *hgt) - ( 6.8 *ag );

                            female =   655 + (9.6 * wgt) + (1.8 * hgt) - (4.7 * ag);

                            sed=male*1.2;
                            float ssed = (float) Math.round(sed * 100) / 100;

                            la=male*1.375;
                            float sla = (float) Math.round(la * 100) / 100;

                            ma=male*1.55;
                           float sma= (float) Math.round(ma * 100) / 100;

                            va=male*1.725;
                            float sva = (float) Math.round(va * 100) / 100;

                            ea=male*1.9;
                            float sea = (float) Math.round(ea * 100) / 100;

                            fsed=female*1.2;
                            float sfsed = (float) Math.round(fsed * 100) / 100;
                            fla=female*1.375;
                            float sfla = (float) Math.round(fla * 100) / 100;
                            fma=female*1.55;
                            float sfma = (float) Math.round(fma * 100) / 100;
                            fva=female*1.725;
                            float sfva = (float) Math.round(fva * 100) / 100;
                            fea=female*1.9;
                            float sfea = (float) Math.round(fea * 100) / 100;

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
                                Toast.makeText(DCIcalc.this,"Please select the Activity level",Toast.LENGTH_LONG).show();
                            }
                            }else {
                                Toast.makeText(DCIcalc.this,"Please input the correct values",Toast.LENGTH_LONG).show();
                            }



                        }catch (NumberFormatException e){
                            Toast.makeText(DCIcalc.this,"Please input the values",Toast.LENGTH_LONG).show();
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
