package net.androidbootcamp.mrfixit20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.androidbootcamp.mrfixit20.database.DBHelper;
import net.androidbootcamp.mrfixit20.model.Users;

public class RegistrationActivity extends AppCompatActivity {
    DBHelper db;
    EditText fNameText;
    EditText lNameText;
    EditText emailText;
    EditText passwordText;
    Button registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        db = new DBHelper(this);

        fNameText = (EditText)findViewById(R.id.firstNameInput);
        lNameText = (EditText)findViewById(R.id.lastNameInput);
        emailText = (EditText)findViewById(R.id.emailInput);
        passwordText = (EditText)findViewById(R.id.passwordInput);
        registerButton = (Button)findViewById(R.id.registrationButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()) {
                    if(!db.isEmailExists(emailText.getText().toString().trim())) {
                        Toast.makeText(RegistrationActivity.this, "successful", Toast.LENGTH_LONG).show();
                        db.insertUser(new Users(fNameText.getText().toString().trim(), lNameText.getText().toString().trim(),
                                emailText.getText().toString().trim(), passwordText.getText().toString().trim()));
                        finish();
                    }
                    else {
                        Toast.makeText(RegistrationActivity.this, "Email Exists", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        final TextView loginText = findViewById(R.id.loginText);
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logIntent = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(logIntent);
            }
        });

    }

    public boolean validate() {
        boolean valid = true;

        String firstName = fNameText.getText().toString();
        String lastName = lNameText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (firstName.isEmpty()) {
            fNameText.setError("enter first name");
            valid = false;
        }
        else {
            fNameText.setError(null);
        }

        if (lastName.isEmpty()) {
            lNameText.setError("enter last name");
            valid = false;
        }
        else {
            lNameText.setError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("enter a valid email address");
            valid = false;
        }
        else {
            emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        }
        else {
            passwordText.setError(null);
        }

        return valid;
    }
}
