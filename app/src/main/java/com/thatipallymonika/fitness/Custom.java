package com.thatipallymonika.fitness;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class Custom extends ArrayAdapter<String> {
    Custom(Context context, String[] foods) {
        super(context, R.layout.custom ,foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater buckysInflater = LayoutInflater.from(getContext());
        View customView = buckysInflater.inflate(R.layout.custom, parent, false);

        String singleFoodItem = getItem(position);
        TextView buckysText = (TextView) customView.findViewById(R.id.tvvid);
        ImageView buckysImage = (ImageView) customView.findViewById(R.id.imageid);

        buckysText.setText(singleFoodItem);
        buckysImage.setImageResource(R.drawable.weight);
        return customView;
    }
}
