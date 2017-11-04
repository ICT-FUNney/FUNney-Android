package com.funney.funney_android.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.funney.funney_android.R;
import com.funney.funney_android.data.Transaction;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by keita on 2017/10/21.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Transaction> transactions;

    public HistoryAdapter(Context context, List<Transaction> objects) {
        this.inflater = LayoutInflater.from(context);
        this.transactions = objects;
    }



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView timestamp;
        TextView name;
        ImageView img;
        TextView value;
        TextView partition;

        ViewHolder(View v) {
            super(v);
             timestamp = (TextView) v.findViewById(R.id.history_date);
             name = (TextView) v.findViewById(R.id.history_name);
             img = (ImageView) v.findViewById(R.id.history_image);
             value = (TextView) v.findViewById(R.id.history_value);
             partition = (TextView) v.findViewById(R.id.partition);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    HistoryAdapter(List<Transaction> transactions) {
        this.transactions = transactions;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_history, parent, false);

        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.timestamp.setText(transactions.get(position).getTimestamp());
        holder.name.setText(transactions.get(position).getName());
        //holder.img.setImageResource(iEmails.get(position));
        holder.value.setText(transactions.get(position).valueString());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return transactions.size();
    }

    //@Override
    //public View getView(int position, View convertView, ViewGroup parent) {
    //    Transaction transaction = this.transactions.get(position);
    //    if (convertView == null) {
    //        convertView = this.inflater.inflate(R.layout.view_history, null);
    //    }
    //    TextView timestamp = (TextView) convertView.findViewById(R.id.history_date);
    //    TextView name = (TextView) convertView.findViewById(R.id.history_name);
    //    ImageView img = (ImageView) convertView.findViewById(R.id.history_image);
    //    TextView value = (TextView) convertView.findViewById(R.id.history_value);
    //    TextView partition = (TextView) convertView.findViewById(R.id.partition);
//
    //    LinearLayout partitionLayout = (LinearLayout) convertView.findViewById(R.id.partition_layout);
//
//
    //    timestamp.setText(transaction.getTimestamp());
    //    if (transaction.getTimestamp().equals("10")) {
    //        img.setImageResource(R.drawable.transaction_history_icon_out);
    //    } else {
    //        img.setImageResource(R.drawable.transaction_history_icon_in);
    //    }
    //    value.setText(transaction.toString());
    //    name.setText(transaction.getName());
//
    //    // 仕切り(partition)
    //    if (transaction.getValue() % 10 == 0 && transaction.getValue() != 0) {
    //        partitionLayout.setVisibility(View.VISIBLE);
    //        partition.setText(String.valueOf(transaction.getValue()));
    //    } else {
    //        partitionLayout.setVisibility(View.GONE);
    //    }
//
    //    return convertView;
    //}
}
