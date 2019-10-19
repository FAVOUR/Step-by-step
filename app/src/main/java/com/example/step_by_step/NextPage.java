package com.example.step_by_step;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NextPage extends Fragment {


    public NextPage() {
        // Required empty public constructor
    }
    NextPageArgs nextPageArgs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if ( (nextPageArgs.fromBundle(getArguments()) != null)){
            nextPageArgs = NextPageArgs.fromBundle(getArguments());

        }


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        TextView textView = (TextView)view.findViewById(R.id.next);

        textView.setText(nextPageArgs.getYeah());
    }
}
