package com.funney.funney_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.funney.funney_android.data.Transaction;

import java.util.List;

/**
 * Created by keita on 2017/10/21.
 */

public class FeaturedAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Transaction> transactions;

    public FeaturedAdapter(Context context, List<Transaction> objects) {
        this.inflater = LayoutInflater.from(context);
        this.transactions = objects;
    }

    @Override
    public int getCount() {
        return this.transactions.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Transaction transaction = this.transactions.get(position);
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.view_featured, null);
        }
        TextView title = (TextView) convertView.findViewById(R.id.featured_title);
        ImageView img = (ImageView) convertView.findViewById(R.id.featured_img);
        TextView description = (TextView) convertView.findViewById(R.id.featured_description);

        title.setText("超すげえ取引");
        description.setText("マジやばい取引だった");


        return convertView;
    }
}
