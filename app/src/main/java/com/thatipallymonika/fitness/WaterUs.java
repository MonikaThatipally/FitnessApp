package com.thatipallymonika.fitness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WaterUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_us);
        TextView tv=(TextView)findViewById(R.id.tid);
        Button bt=(Button)findViewById(R.id.bid);

    }
    public void buttonClicked(View view){

        try {
            TextView tv2 = (TextView) findViewById(R.id.tid2);
            EditText et = (EditText) findViewById(R.id.eid);

            String ets = et.getText().toString();
            double par = Double.parseDouble(ets);

            double water = par * 0.5;
            double lit = water * 0.0296;
            if (par <= 450) {
                float sea = (float) Math.round(lit * 100) / 100;

                String resultstring = String.valueOf(sea);

                String nstr = "your recomended daily water intake is" + resultstring + " litres";
                tv2.setText(nstr);
            } else {
                Toast.makeText(WaterUs.this, "Please input the corect weight", Toast.LENGTH_LONG).show();

            }
        }catch (Exception e)
        {
            Toast.makeText(WaterUs.this,"Please input the values",Toast.LENGTH_LONG).show();
        }
    }
}
