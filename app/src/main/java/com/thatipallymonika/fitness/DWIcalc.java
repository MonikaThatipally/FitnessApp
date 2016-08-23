package com.thatipallymonika.fitness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DWIcalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dwicalc);
        TextView tv=(TextView)findViewById(R.id.tid);
        Button bt=(Button)findViewById(R.id.bid);

    }
    public void buttonClicked(View view){
        EditText tv2=(EditText) findViewById(R.id.tid2);
        EditText et=(EditText)findViewById(R.id.eid);

        String ets=et.getText().toString();
        double par = Double.parseDouble(ets);

        double kg=par*2.2;
        double water = kg*0.5;
        double lit=water*0.0296;

        float sea = (float) Math.round(lit * 100) / 100;

        String resultstring=String.valueOf(sea);

        String nstr="your recomended daily water intake is"+resultstring+" litres";
        tv2.setText(nstr);

    }
}
