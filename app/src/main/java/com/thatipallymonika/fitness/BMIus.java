package com.thatipallymonika.fitness;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BMIus extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_us);

        Button tbt=(Button)findViewById(R.id.tabbutton);
        Button tbtm=(Button)findViewById(R.id.button2m);
        final EditText tet=(EditText)findViewById(R.id.tabeditText);
        final  EditText tet2=(EditText)findViewById(R.id.tabeditText2feet);
        final EditText tetnew=(EditText)findViewById(R.id.tabeditText2inch);
        final EditText tet3=(EditText)findViewById(R.id.tabeditText3);
        tbtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tet.getText().clear();
                tet2.getText().clear();
                tetnew.getText().clear();
                tet3.getText().clear();

            }
        });

        tbt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            String tets = tet.getText().toString();
                            double twgt = Double.parseDouble(tets);

                            String tet2s = tet2.getText().toString();
                            double thgt = Double.parseDouble(tet2s);

                            String tetnews = tetnew.getText().toString();
                            double tnew = Double.parseDouble(tetnews);

                            if(twgt <= 450 && thgt<=7 && tnew<=12) {


                                double height = ((thgt * 12) + tnew) * ((thgt * 12) + tnew);
                                double bminew = (twgt / height) * 703;
                                float p = (float) Math.round(bminew * 100) / 100;

                                if (bminew >= 30) {
                                    tet3.setText("Your BMI is " + p + "\n You are in Obese Category");
                                } else if (bminew >= 25) {
                                    tet3.setText("Your BMI is " + p + "\n You are in Overweight Category");
                                } else if (bminew >= 18.5) {
                                    tet3.setText("Your BMI is " + p + "\n You are in Normal Weight Category");
                                } else {
                                    tet3.setText("Your BMI is " + p + "\n You are in Under Weight Category");
                                }
                            } else {
                                Toast.makeText(BMIus.this,"Please input the corect values",Toast.LENGTH_LONG).show();

                            }
                            }

                        catch (NumberFormatException e){
                            Toast.makeText(BMIus.this,"Please input the values",Toast.LENGTH_LONG).show();
                        }
                    }}
        );
    }
}
