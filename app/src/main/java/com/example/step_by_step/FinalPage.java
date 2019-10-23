package com.example.step_by_step;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FinalPage extends Fragment {


    public FinalPage() {
        // Required empty public constructor
    }

TextView textView;
    FinalPageArgs finalPageArgs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        finalPageArgs = FinalPageArgs.fromBundle(getArguments());


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_final_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = (TextView)view.findViewById(R.id.finalPage);

        textView.setText(finalPageArgs.getTitleofFragment());
    }
}
