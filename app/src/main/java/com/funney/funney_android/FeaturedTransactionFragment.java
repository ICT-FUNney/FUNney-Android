package com.funney.funney_android;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
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

public class FeaturedTransactionFragment extends Fragment {

    private String orrange = "#F3A033";
    private String white = "#FFFFFF";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.featured_transaction, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        //注目の取引ボタンをオレンジにする
        Button featuredButton = (Button) getActivity().findViewById(R.id.featured_transaction_button);
        featuredButton.setBackgroundResource(R.drawable.featured_button);
        featuredButton.setTextColor(Color.parseColor(white));

        //取引履歴ボタンを白くする
        Button historyButton = (Button) getActivity().findViewById(R.id.transaction_history_button);
        historyButton.setBackgroundResource(R.drawable.history_button_white);
        historyButton.setTextColor(Color.parseColor(orrange));

        ListView list = (ListView) getActivity().findViewById(R.id.featured_transaction_list);
        ArrayList<Transaction> trlist = new ArrayList<Transaction>();
        for (int i = 0; i < 5; i++) {
            String str = String.valueOf(i);
            trlist.add(new Transaction(str, str, i));
        }
        FeaturedAdapter adapter = new FeaturedAdapter(getContext(), trlist);
        list.setAdapter(adapter);

    }
}
