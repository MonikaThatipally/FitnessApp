package com.thatipallymonika.fitness;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class BMImetric extends Activity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_metric);

        Button bt=(Button)findViewById(R.id.button);
        Button btr=(Button)findViewById(R.id.button2);
        final EditText et=(EditText)findViewById(R.id.editText);
        final  EditText et2=(EditText)findViewById(R.id.editText2);
        final TextView et3=(TextView) findViewById(R.id.editText3);

    btr.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            et.getText().clear();
            et2.getText().clear();
            et3.setText("");

        }
    });


    bt.setOnClickListener(
            new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            try {

                final String ets = et.getText().toString();
                double wgt = Double.parseDouble(ets);


                String et2s = et2.getText().toString();
                double hgt = Double.parseDouble(et2s);

                if(wgt<=200 && hgt<=215){




                double bmi = (wgt / ((hgt * hgt) / 10000));
                float k = (float) Math.round(bmi * 100) / 100;

                if (bmi >= 30) {
                    et3.setText("Your BMI is "+k+"\nYou are in Obese Category");
                } else if (bmi >= 25) {
                    et3.setText("Your BMI is "+k+"\n You are in Overweight Category");
                } else if (bmi >= 18.5) {
                    et3.setText("Your BMI is "+k+"\n You are in Normal Weight Category");
                } else {
                    et3.setText("Your BMI is "+k+"\n You are in Under Weight Category");
                }
                }else {
                    Toast.makeText(BMImetric.this,"Please input the correct values",Toast.LENGTH_LONG).show();
                }
            }
            catch (NumberFormatException e)
            {
                Toast.makeText(BMImetric.this,"Please input the values",Toast.LENGTH_LONG).show();
            }



        }
    }
    );
    }
}