package com.healthsignz.training.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.healthsignz.training.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends ListFragment {

    public interface TransferOneToTwo {
        void sendOneToTwo(String data);
    }

    String[] num = new String[5];
    //Communicator communicator;
    static ListFragment instance;

    public OneFragment() {
        // Required empty public constructor
    }

    public static ListFragment getInstance() {
        return instance = new ListFragment();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       // communicator = (Communicator) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }


    public void changeData(String countValue) {
        for(int i = 0; i < 5; i++) {
            num[i] = countValue;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_expandable_list_item_1, num);
        setListAdapter(adapter);
    }
}
