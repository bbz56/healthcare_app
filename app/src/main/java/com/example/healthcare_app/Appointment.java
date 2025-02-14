package com.example.healthcare_app;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Appointment extends AppCompatActivity {

    private DatePicker datePicker;
    private Spinner timeSlotSpinner;
    private EditText patientNameInput, patientAgeInput, patientPhoneInput, patientEmailInput, symptomsInput;
    private CheckBox emergencyCheckbox;
    private Button bookAppointmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        initializeViews();
        setupTimeSlotSpinner();
        setupListeners();
    }

    private void initializeViews() {
        datePicker = findViewById(R.id.datePicker);
        timeSlotSpinner = findViewById(R.id.timeSlotSpinner);
        patientNameInput = findViewById(R.id.patientNameInput);
        patientAgeInput = findViewById(R.id.patientAgeInput);
        patientPhoneInput = findViewById(R.id.patientPhoneInput);
        patientEmailInput = findViewById(R.id.patientEmailInput);
        symptomsInput = findViewById(R.id.symptomsInput);
        emergencyCheckbox = findViewById(R.id.emergencyCheckbox);
        bookAppointmentButton = findViewById(R.id.bookAppointmentButton);

        Calendar today = Calendar.getInstance();
        datePicker.setMinDate(today.getTimeInMillis());
    }

    private void setupTimeSlotSpinner() {
        ArrayList<String> timeSlots = new ArrayList<>(Arrays.asList(
                "09:00 AM", "09:30 AM", "10:00 AM", "10:30 AM",
                "11:00 AM", "11:30 AM", "02:00 PM", "02:30 PM",
                "03:00 PM", "03:30 PM", "04:00 PM", "04:30 PM"
        ));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                timeSlots
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSlotSpinner.setAdapter(adapter);
    }

    private void setupListeners() {
        bookAppointmentButton.setOnClickListener(v -> {
            if (validateInput()) {
                bookAppointment();
            }
        });
    }

    private boolean validateInput() {
        if (patientNameInput.getText().toString().trim().isEmpty()) {
            patientNameInput.setError("Name is required");
            return false;
        }
        if (patientAgeInput.getText().toString().trim().isEmpty()) {
            patientAgeInput.setError("Age is required");
            return false;
        }
        if (patientPhoneInput.getText().toString().trim().length() < 10) {
            patientPhoneInput.setError("Valid phone number is required");
            return false;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(patientEmailInput.getText().toString().trim()).matches()) {
            patientEmailInput.setError("Valid email is required");
            return false;
        }
        if (symptomsInput.getText().toString().trim().isEmpty()) {
            symptomsInput.setError("Please describe your symptoms");
            return false;
        }
        return true;
    }

    private void bookAppointment() {
        String date = String.format("%d-%d-%d",
                datePicker.getYear(),
                datePicker.getMonth() + 1,
                datePicker.getDayOfMonth()
        );
        String time = timeSlotSpinner.getSelectedItem().toString();
        String name = patientNameInput.getText().toString().trim();
        String age = patientAgeInput.getText().toString().trim();
        String phone = patientPhoneInput.getText().toString().trim();
        String email = patientEmailInput.getText().toString().trim();
        String symptoms = symptomsInput.getText().toString().trim();
        boolean isEmergency = emergencyCheckbox.isChecked();

        String message = String.format(
                "Appointment Details:\n\n" +
                        "Date: %s\n" +
                        "Time: %s\n" +
                        "Patient: %s\n" +
                        "Age: %s\n" +
                        "Phone: %s\n" +
                        "Email: %s\n" +
                        "Symptoms: %s\n" +
                        "Emergency: %s",
                date, time, name, age, phone, email, symptoms, isEmergency ? "Yes" : "No"
        );

        Toast.makeText(this, "Appointment booked successfully!", Toast.LENGTH_LONG).show();
        resetForm();
    }

    private void resetForm() {
        patientNameInput.setText("");
        patientAgeInput.setText("");
        patientPhoneInput.setText("");
        patientEmailInput.setText("");
        symptomsInput.setText("");
        emergencyCheckbox.setChecked(false);
    }
}
