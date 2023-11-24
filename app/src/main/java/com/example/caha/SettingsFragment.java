package com.example.caha;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    Button logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        logout = view.findViewById(R.id.logout);

        // Set OnClickListener for the logout button
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform logout actions here
                // For example: Clear user sessions, navigate to login screen, etc.
                performLogout();
            }
        });

        return view;
    }

    // Method to handle logout functionality
    private void performLogout() {
        // Implement your logout logic here
        // For example, you can clear user sessions, navigate to the login screen, etc.
        // Example: Redirecting to the login screen (Assuming LoginActivity is your login screen)
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        getActivity().finish(); // Finish the current activity
    }
}
