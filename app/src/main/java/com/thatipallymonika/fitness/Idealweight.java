package com.thatipallymonika.fitness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Idealweight extends AppCompatActivity {

    private RadioGroup rg;
    private int selectedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idealweight);
        Button bt=(Button)findViewById(R.id.bid);
        Button btr=(Button)findViewById(R.id.reid);

        final EditText et=(EditText)findViewById(R.id.editText6);
        final  EditText et8=(EditText)findViewById(R.id.editText8);
        final TextView et9=(TextView) findViewById(R.id.editText9);

        btr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.getText().clear();
                et8.getText().clear();
                et9.setText("");

            }
        });




        rg=(RadioGroup)findViewById(R.id.radiosex);

        bt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        try {

                            final String ets = et.getText().toString();
                            double ag = Double.parseDouble(ets);


                            String et8s = et8.getText().toString();
                            double inc = Double.parseDouble(et8s);

                            selectedId = rg.getCheckedRadioButtonId();
                            RadioButton maleref = (RadioButton) findViewById(selectedId);

                            if (ag < 110 && inc<=215) {


                                double male = (inc) - 104;
                                double female = (inc) - 105;


                                if (selectedId == R.id.radiomale) {

                                    et9.setText(String.format("your ideal body weight is: %f", male));
                                } else if (selectedId == R.id.radiofemale) {

                                    et9.setText(String.format("your ideal body weight is: %f", female));
                                }


                            }else {
                                Toast.makeText(Idealweight.this,"Please input the correct values",Toast.LENGTH_LONG).show();
                            }
                        }
                            catch(NumberFormatException e)
                            {
                                Toast.makeText(Idealweight.this, "Please input the values", Toast.LENGTH_LONG).show();
                            }



                    }
                }
        );
    }
}