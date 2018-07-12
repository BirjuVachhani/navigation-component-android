package com.birjuvachhani.navigationcomponentdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

public class DemoFragment extends Fragment {

    private Button btnNavigationToDestination;
    private Button btnNavigationWithAction;
    private Button btnDeepLink;
    private Button btnBottomBarNavigation;
    private Button btnSafeArguments;

    public DemoFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        btnBottomBarNavigation = view.findViewById(R.id.btnBottomBarNavigation);
        btnDeepLink = view.findViewById(R.id.btnDeepLinking);
        btnNavigationToDestination = view.findViewById(R.id.btnNavigationUsingDestination);
        btnNavigationWithAction = view.findViewById(R.id.btnNavigationWithAction);
        btnSafeArguments = view.findViewById(R.id.btnPassArguments);

        btnNavigationToDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.sampleFragmentOne, null);
            }
        });

        btnNavigationWithAction.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_to_sampleFragmentOne));

        btnBottomBarNavigation.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_navDemoFrag_to_bottomNavigationActivity));
        btnSafeArguments.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_navDemoFrag_to_safeArgumentsFragment));

        btnDeepLink.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_navDemoFrag_to_deepLinkFragment));
        return view;
    }
}
