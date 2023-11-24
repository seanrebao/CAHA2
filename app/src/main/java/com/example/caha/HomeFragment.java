package com.example.caha;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import java.util.Calendar;
import java.util.Locale;

public class HomeFragment extends Fragment {

    ToggleButton[] toggleButtons = new ToggleButton[8];
    TextView[] selectedTimeTextViews = new TextView[8];
    private final boolean[] previousToggleState = new boolean[8];
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switchON;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switchOFF;
    private Spinner spinnerOptions;
    private TextView displayTextView1;
    private TextView displayTextView2;
    private TextView displayTextView3;
    private TextView displayTextView4;
    private TextView displayTextView5;
    private TextView displayTextView6;
    private TextView displayTextView7;
    private TextView displayTextView8;

    private String[] switchInputs = new String[8];

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        for (int i = 0; i < 8; i++) {
            outState.putBoolean("toggleButtonState" + i, toggleButtons[i].isChecked());
            outState.putString("selectedTimeText" + i, selectedTimeTextViews[i].getText().toString());
        }
    }

    @SuppressLint({"DiscouragedApi", "MissingInflatedId"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        spinnerOptions = view.findViewById(R.id.spinnerOptions);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.options_array, R.layout.spinner_item_layout); // Using the custom layout for the spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptions.setAdapter(adapter);

        spinnerOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
                if (selectedItem.equals("Switch 1")) {
                    showEditTextDialog(0);
                }
                if (selectedItem.equals("Switch 2")) {
                    showEditTextDialog(1);
                }
                if (selectedItem.equals("Switch 3")) {
                    showEditTextDialog(2);
                }
                if (selectedItem.equals("Switch 4")) {
                    showEditTextDialog(3);
                }
                if (selectedItem.equals("Switch 5")) {
                    showEditTextDialog(4);
                }
                if (selectedItem.equals("Switch 6")) {
                    showEditTextDialog(5);
                }
                if (selectedItem.equals("Switch 7")) {
                    showEditTextDialog(6);
                }
                if (selectedItem.equals("Switch 8")) {
                    showEditTextDialog(7);
                }
                // Add other cases for different options if needed
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Implement logic if nothing is selected
            }
        });


        for (int i = 0; i < 8; i++) {
            toggleButtons[i] = view.findViewById(getResources().getIdentifier("toggleButton" + (i + 1), "id", requireActivity().getPackageName()));
            selectedTimeTextViews[i] = view.findViewById(getResources().getIdentifier("selectedTimeTextView" + (i + 1), "id", requireActivity().getPackageName()));

            // Apply the custom background drawable to each ToggleButton
            toggleButtons[i].setBackgroundResource(R.drawable.custom_toggle_button);

            // Set up OnCheckedChangeListener for each ToggleButton
            setupToggleButton(toggleButtons[i], selectedTimeTextViews[i]);
        }

        switchON = view.findViewById(R.id.switchON);
        switchOFF = view.findViewById(R.id.switchOFF);

        switchOFF.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                switchON.setChecked(false);
                for (ToggleButton toggleButton : toggleButtons) {
                    toggleButton.setChecked(false);
                }
            }
        });

        switchON.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                switchOFF.setChecked(false);
                for (ToggleButton toggleButton : toggleButtons) {
                    toggleButton.setChecked(true);
                }
            }
        });

        switchOFF.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked && checkToggleButtonsOn()) {
                showConfirmationDialog();
            } else {
                turnOffAllToggleButtons();
            }
        });

        displayTextView1 = view.findViewById(R.id.displayTextView1);
        displayTextView2 = view.findViewById(R.id.displayTextView2);
        displayTextView3 = view.findViewById(R.id.displayTextView3);
        displayTextView4 = view.findViewById(R.id.displayTextView4);
        displayTextView5 = view.findViewById(R.id.displayTextView5);
        displayTextView6 = view.findViewById(R.id.displayTextView6);
        displayTextView7 = view.findViewById(R.id.displayTextView7);
        displayTextView8 = view.findViewById(R.id.displayTextView8);

        return view;
    }

    private void showEditTextDialog(final int switchIndex) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Enter a name of the Switch");

        // Set up the input
        final EditText input = new EditText(requireContext());
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String userInput = input.getText().toString();
                switchInputs[switchIndex] = userInput; // Store the input for the corresponding switch
                updateTextView(switchIndex, userInput); // Update the corresponding TextView
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void updateTextView(int switchIndex, String newText) {
        switch (switchIndex) {
            case 0:
                displayTextView1.setText(newText);
                break;
            case 1:
                displayTextView2.setText(newText);
                break;
            case 2:
                displayTextView3.setText(newText);
                break;
            case 3:
                displayTextView4.setText(newText);
                break;
            case 4:
                displayTextView5.setText(newText);
                break;
            case 5:
                displayTextView6.setText(newText);
                break;
            case 6:
                displayTextView7.setText(newText);
                break;
            case 7:
                displayTextView8.setText(newText);
                break;
            default:
                break;
        }
    }

    private boolean checkToggleButtonsOn() {
        for (int i = 0; i < toggleButtons.length; i++) {
            if (toggleButtons[i].isChecked()) {
                previousToggleState[i] = true;
                return true;
            }
        }
        return false;
    }

    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage("Are you sure you want to turn off all the switches? There switch's are still on.");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            turnOffAllToggleButtons();
            switchON.setChecked(false); // Switch off "Switch On All" button
        });
        builder.setNegativeButton("No", (dialog, which) -> {
            switchOFF.setChecked(false); // Uncheck the "Switch Off All" button
            for (int i = 0; i < toggleButtons.length; i++) {
                toggleButtons[i].setChecked(previousToggleState[i]); // Revert the toggle buttons to their previous state
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void turnOffAllToggleButtons() {
        for (int i = 0; i < toggleButtons.length; i++) {
            previousToggleState[i] = toggleButtons[i].isChecked();
            toggleButtons[i].setChecked(false);
        }
    }


    private void showSelectedTimeText(TextView selectedTimeTextView) {
        selectedTimeTextView.setVisibility(View.VISIBLE);
    }

    private void showPopupMenu(View view, TextView textView) {
        PopupMenu popupMenu = new PopupMenu(requireContext(), view);
        popupMenu.getMenuInflater().inflate(R.menu.time_menu, popupMenu.getMenu());

        // Set a click listener for the menu item
        popupMenu.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.set_time) {
                // Launch a TimePickerDialog to select a time
                showTimePickerDialog(textView);
                return true;
            } else {
                return false;
            }
        });

        popupMenu.show();
    }

    private void showTimePickerDialog(final TextView textView) {
        // Get the current time
        Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int currentMinute = calendar.get(Calendar.MINUTE);

        // Create a TimePickerDialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                requireContext(),
                (view, hourOfDay, minute) -> {
                    // Automatically turn on the corresponding toggle button when setting time
                    for (int i = 0; i < selectedTimeTextViews.length; i++) {
                        if (textView == selectedTimeTextViews[i]) {
                            toggleButtons[i].setChecked(true);
                            displaySelectedTime(hourOfDay, minute, textView);
                            textView.setVisibility(View.VISIBLE);
                        }
                    }
                },
                currentHour,
                currentMinute,
                false // Set to false for a 12-hour format time picker
        );
        // Show the TimePickerDialog
        timePickerDialog.show();
    }

    private void displaySelectedTime(int hourOfDay, int minute, TextView textView) {
        String amPm;

        if (hourOfDay >= 12) {
            amPm = "PM";
            if (hourOfDay > 12) {
                hourOfDay -= 12; // Convert to 12-hour format
            }
        } else {
            amPm = "AM";
            if (hourOfDay == 0) {
                hourOfDay = 12; // Midnight (12:00 AM)
            }
        }

        // Update the TextView with the selected time
        textView.setText(String.format(Locale.getDefault(), "%02d:%02d %s", hourOfDay, minute, amPm));
        textView.setVisibility(View.VISIBLE);
    }

    // Add this method to clear the selected time when a ToggleButton is unchecked
    private void hideSelectedTimeText(TextView textView) {
        textView.setText("");
        textView.setVisibility(View.GONE);
    }

    // Add this method to set up a ToggleButton and its associated time TextView
    private void setupToggleButton(final ToggleButton button, final TextView textView) {
        button.setOnLongClickListener(v -> {
            showPopupMenu(button, textView);
            if (isToggleButtonChecked()) {
                showSelectedTimeText(textView);
            }
            return true; // Consume the long click event
        });

        button.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (!isChecked) {
                // If the ToggleButton is unchecked, clear the selected time
                hideSelectedTimeText(textView);
            }
        });
    }

    private boolean isToggleButtonChecked() {
        return false;
    }

}
