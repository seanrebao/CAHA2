package com.example.caha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText emailEditText, passwordEditText;
    TextView createNewAccount;


    // Hardcoded email and password for demonstration purposes
    private static final String VALID_EMAIL = "ABC";
    private static final String VALID_PASSWORD = "ABC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        emailEditText = findViewById(R.id.inputEmail);
        passwordEditText = findViewById(R.id.inputPassword);
        createNewAccount = findViewById(R.id.createNewAccount);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredEmail = emailEditText.getText().toString().trim();
                String enteredPassword = passwordEditText.getText().toString().trim();

                if (enteredEmail.equals(VALID_EMAIL) && enteredPassword.equals(VALID_PASSWORD)) {
                    // Successful login, navigate to HomePageActivity
                    startActivity(new Intent(MainActivity.this, HomePageActivity.class));
                } else {
                    // Invalid login, show a toast message
                    Toast.makeText(MainActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        createNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });


        // Add the Enter key functionality to simulate button click
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE ||
                        (keyEvent != null && keyEvent.getAction() == KeyEvent.ACTION_DOWN && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    // Perform login button click action
                    btnLogin.performClick();
                    return true;
                }
                return false;
            }
        });

    }
}
