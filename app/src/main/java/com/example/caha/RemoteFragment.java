package com.example.caha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RemoteFragment extends Fragment {

    private IRManager irManager; // Declare IRManager variable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remote, container, false);

        irManager = new IRManager(); // Instantiate IRManager properly

        ImageView upArrow = view.findViewById(R.id.upArrow);
        ImageView downArrow = view.findViewById(R.id.downArrow);
        ImageView leftArrow = view.findViewById(R.id.leftArrow);
        ImageView rightArrow = view.findViewById(R.id.rightArrow);
        ImageView powerButton = view.findViewById(R.id.powerImage);
        ImageView volumeUp = view.findViewById(R.id.volumeUpImage);
        ImageView volumeDown = view.findViewById(R.id.volumeDownImage);
        ImageView volumeMute = view.findViewById(R.id.muteImage);
        ImageView ok = view.findViewById(R.id.OkImage);

        // Set onClickListeners for each button
        upArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performUpAction();
            }
        });

        downArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performDownAction();
            }
        });

        leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLeftAction();
            }
        });

        rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRightAction();
            }
        });

        powerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                performPowerAction();
            }
        });

        volumeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                performVolumeUpAction();
            }
        });

        volumeDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                performVolumeDownAction();
            }
        });

        volumeMute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performMuteAction();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSelectAction();
            }
        });

        return view;
    }


    // Functions to perform actions for each button click

    private void performUpAction() {
        if (irManager != null) {
            int upSignal = irManager.getUpScrollSignal(); // Replace with actual method to get up scroll signal
            irManager.sendIRSignal(upSignal); // Send IR signal for scrolling up
            showToast("Up Arrow Clicked");
        }
    }

    private void performDownAction() {
        if (irManager != null) {
            int downSignal = irManager.getDownScrollSignal(); // Replace with actual method to get down scroll signal
            irManager.sendIRSignal(downSignal); // Send IR signal for scrolling down
            showToast("Down Arrow Clicked");
        }
    }

    private void performLeftAction() {
        if (irManager != null) {
            int leftSignal = irManager.getLeftScrollSignal(); // Replace with actual method to get left scroll signal
            irManager.sendIRSignal(leftSignal); // Send IR signal for scrolling left
            showToast("Left Arrow Clicked");
        }
    }

    private void performRightAction() {
        if (irManager != null) {
            int rightSignal = irManager.getRightScrollSignal(); // Replace with actual method to get right scroll signal
            irManager.sendIRSignal(rightSignal); // Send IR signal for scrolling right
            showToast("Right Arrow Clicked");
        }
    }

    private void performPowerAction() {
        if (irManager != null) {
            int powerSignal = irManager.getPowerSignal(); // Replace with actual method to get power signal
            irManager.sendIRSignal(powerSignal); // Send IR signal to turn on the TV
            showToast("Power Button Clicked");
        }
    }

    private void performVolumeUpAction() {
        if (irManager != null) {
            int volumeUpSignal = irManager.getVolumeUpSignal(); // Replace with actual method to get volume up signal
            irManager.sendIRSignal(volumeUpSignal); // Send IR signal for volume up
            showToast("Volume Up Clicked");
        }
    }

    private void performVolumeDownAction() {
        if (irManager != null) {
            int volumeDownSignal = irManager.getVolumeDownSignal(); // Replace with actual method to get volume down signal
            irManager.sendIRSignal(volumeDownSignal); // Send IR signal for volume down
            showToast("Volume Down Clicked");
        }
    }

    private void performMuteAction() {
        if (irManager != null) {
            int muteSignal = irManager.getMuteSignal(); // Replace with actual method to get mute signal
            irManager.sendIRSignal(muteSignal); // Send IR signal for mute
            showToast("Mute Clicked");
        }
    }

    private void performSelectAction() {
        if (irManager != null) {
            int selectSignal = irManager.getSelectSignal(); // Replace with actual method to get mute signal
            irManager.sendIRSignal(selectSignal); // Send IR signal for mute
            showToast("Select Clicked");
        }
    }

    // Method to show Toast message
    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    // IRManager class with placeholder methods
    private class IRManager {
        // Placeholder methods for IR signals
        public int getUpScrollSignal() {
            return 0;
        }

        public int getDownScrollSignal() {
            return 0;
        }

        public int getLeftScrollSignal() {
            return 0;
        }

        public int getRightScrollSignal() {
            return 0;
        }

        public int getPowerSignal() {
            return 0;
        }

        public int getVolumeUpSignal() {
            return 0;
        }

        public int getVolumeDownSignal() {
            return 0;
        }

        public int getMuteSignal() {
            return 0;
        }

        public int getSelectSignal(){ return 0; }

        public void sendIRSignal(int signal) {
            // Code to send IR signal

        }
    }
}
