package com.funney.funney_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.funney.funney_android.data.Transaction;

import org.w3c.dom.Text;

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
        TextView partition = (TextView) convertView.findViewById(R.id.partition);
        LinearLayout partitionLayout = (LinearLayout) convertView.findViewById(R.id.partition_layout);

        timestamp.setText(transaction.getTimestamp());
        if (transaction.getTimestamp().equals("10")) {
            img.setImageResource(R.drawable.transaction_history_icon_out);
        } else {
            img.setImageResource(R.drawable.transaction_history_icon_in);
        }
        value.setText(transaction.toString());
        name.setText(transaction.getName());

        // 仕切り(partition)
        if (transaction.getValue() % 10 == 0 && transaction.getValue() != 0) {
            partitionLayout.setVisibility(View.VISIBLE);
            partition.setText(String.valueOf(transaction.getValue()));
        } else {
            partitionLayout.setVisibility(View.GONE);
        }

        return convertView;
    }
}
