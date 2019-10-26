package com.example.step_by_step;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeepLinkFragment extends Fragment {


    public DeepLinkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView receivedArg = view.findViewById(R.id.title);
        Button navigeteButton= view.findViewById(R.id.send_notif);
        final EditText editText =view.findViewById(R.id.notifET);

        navigeteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();

                bundle.putString("notif",editText.getText().toString());
               PendingIntent nav =  NavHostFragment.findNavController(getParentFragment()).createDeepLink()
                                     .setDestination(R.id.blankFragment)
                                      .setArguments(bundle)
                                       .createPendingIntent();



                NotificationManager notificationManager = (NotificationManager)getContext().getSystemService(Context.NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    notificationManager.createNotificationChannel(new NotificationChannel("nav", "Deeplinks", NotificationManager.IMPORTANCE_HIGH));

                }
                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getContext(),"nav")
                        .setSmallIcon(R.drawable.ic_home_black_24dp)
                        .setContentIntent(nav)
                        .setContentTitle("Step By Step")
                        .setContentText("You have A new Message");

                notificationManager.notify(0,notificationBuilder.build());

            }
        });



//        DeepLinkFragmentArgs deepLinkFragmentArgs =DeepLinkFragmentArgs.fromBundle(getArguments());
//
//
//
//        receivedArg.setText(deepLinkFragmentArgs.getNotif());

        receivedArg.setText(getArguments().getString("notif"));



    }
}
