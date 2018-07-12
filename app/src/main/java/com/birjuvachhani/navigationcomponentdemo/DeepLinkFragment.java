package com.birjuvachhani.navigationcomponentdemo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.navigation.Navigation;

public class DeepLinkFragment extends android.support.v4.app.Fragment {

    private EditText etName;
    private Button btnCreateDeepLinkNotification;

    public DeepLinkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deep_link, container, false);
        etName = view.findViewById(R.id.etName);
        btnCreateDeepLinkNotification = view.findViewById(R.id.btnCreateDeepLinkNotification);
        etName.requestFocus();
        etName.setActivated(true);
        etName.setPressed(true);

        btnCreateDeepLinkNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                if (TextUtils.isEmpty(name)) return;
                createNotification(view, name);
            }
        });
        return view;
    }

    private void createNotification(View view, String name) {
        Bundle args = new Bundle();
        args.putString("name", name);
        PendingIntent deepLink = Navigation.findNavController(view).createDeepLink()
                .setDestination(R.id.welcomeFragment)
                .setArguments(args)
                .setGraph(R.navigation.navigation_drawer)
                .createPendingIntent();
        NotificationManager manager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            manager.createNotificationChannel(new NotificationChannel(
                    "deep_link", "Deep Links", NotificationManager.IMPORTANCE_HIGH));
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                getContext(), "deep_link")
                .setContentTitle("Navigation Demo")
                .setContentText("Deep link to Welcome Screen")
                .setSmallIcon(R.drawable.ic_bookmark_black_24dp)
                .setContentIntent(deepLink)
                .setAutoCancel(true);
        manager.notify(0, builder.build());
    }
}
