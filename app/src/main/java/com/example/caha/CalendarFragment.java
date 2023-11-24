package com.example.caha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CalendarFragment extends Fragment {

    private CalendarView calendarView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        calendarView = view.findViewById(R.id.calendarView);

        // Set a listener to handle date selection
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(year, month, dayOfMonth);

                // Process the click action for the selected date
                handleDayClick(selectedDate);
            }
        });

        return view;
    }

    private void handleDayClick(Calendar selectedDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String selectedDateString = dateFormat.format(selectedDate.getTime());

        // Here you can perform actions when a day is clicked
        Toast.makeText(requireContext(), selectedDateString, Toast.LENGTH_SHORT).show();
        // Add your logic here for the action to be taken on date click
        // For example, start a new activity or perform some specific task based on the selected date


    }
    public interface OnDateSelectedListener {
        void onDateSelected(String selectedDate);
    }
}
