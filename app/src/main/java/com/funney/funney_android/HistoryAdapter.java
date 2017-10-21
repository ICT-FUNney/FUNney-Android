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

public class HistoryAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Transaction> transactions;

    public HistoryAdapter(Context context, List<Transaction> objects) {
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
            convertView = this.inflater.inflate(R.layout.view_history, null);
        }
        TextView timestamp = (TextView) convertView.findViewById(R.id.history_date);
        TextView name = (TextView) convertView.findViewById(R.id.history_name);
        ImageView img = (ImageView) convertView.findViewById(R.id.history_image);
        TextView value = (TextView) convertView.findViewById(R.id.history_value);

        // TODO 仕切りの作成

        timestamp.setText(transaction.getTimestamp());
        img.setImageResource(R.drawable.transaction_history_icon_out);
        value.setText(transaction.getValue());
        name.setText(transaction.getName());

        return convertView;
    }
}
