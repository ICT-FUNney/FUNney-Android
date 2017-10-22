package com.funney.funney_android;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.funney.funney_android.data.Transaction;

import java.util.ArrayList;


/**
 * Created by keita on 2017/10/20.
 */

public class TransactionHistoryFragment extends Fragment {

    private String orrange = "#F3A033";
    private String white = "#FFFFFF";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.transaction_history, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();

        ListView list = (ListView)getActivity().findViewById(R.id.transacsion_history_list);
        ArrayList<Transaction> trlist = new ArrayList<Transaction>();
        for(int i=0;i<30;i++){
            String str = String.valueOf(i);
            trlist.add(new Transaction(str,str,i));
        }
        HistoryAdapter adapter = new HistoryAdapter(getContext(),trlist);
        list.setAdapter(adapter);

    }
}
