package com.example.step_by_step;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    Button nextButton;
    Button finalButton;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        nextButton =view.findViewById(R.id.nextbutton);
        finalButton =view.findViewById(R.id.finalbutton);

        nextButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_nextPage,null));

        finalButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_finalPage,null));

    }
}
