package com.thatipallymonika.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class Tab1Fragment extends Fragment {

    String Calc[]={"BMI","Ideal Weight","Daily Calorie Intake","Daily Water Inatke"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.tab1_view, container, false);

       // ListAdapter moniadapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Calc);
        ListAdapter moniadapter= new com.thatipallymonika.fitness.Custom(getActivity().getApplicationContext(), Calc);
        ListView lv=(ListView)V.findViewById(R.id.lid);
        lv.setAdapter(moniadapter);
        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String temp=String.valueOf(adapterView.getItemAtPosition(i));
                        // Toast.makeText(MainActivity.this,temp,Toast.LENGTH_SHORT).show();

                      if (i == 0) {

                            Intent myIntent = new Intent(getActivity().getApplicationContext(), BMImetric.class);
                            startActivityForResult(myIntent, 0);



                        }
                        if (i == 1) {

                            Intent myIntent2 = new Intent(getActivity().getApplicationContext(), Idealweight.class);
                            startActivityForResult(myIntent2, 0);
                        }
                       if (i == 2) {
                           Intent myIntent3 = new Intent(getActivity().getApplicationContext(), DCIcalc.class);
                           startActivityForResult(myIntent3, 0);

                        }
                        if (i == 3) {

                            Intent myIntent4 = new Intent(getActivity().getApplicationContext(), DWIcalc.class);
                            startActivityForResult(myIntent4, 0);
                        }


                    }
                }
        );

        return V;
    }
}