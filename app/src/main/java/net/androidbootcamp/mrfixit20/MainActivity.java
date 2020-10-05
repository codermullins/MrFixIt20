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

public class MainActivity extends AppCompatActivity {
    DBHelper db;
    EditText emailText;
    EditText passwordText;
    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this);

        emailText = (EditText)findViewById(R.id.emailEditText);
        passwordText = (EditText)findViewById(R.id.passwordEditText);
        loginButton = (Button)findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    String Email = emailText.getText().toString();
                    String Password = passwordText.getText().toString();

                    if (db.Validate(emailText.getText().toString().trim(),passwordText.getText().toString().trim())) {
                        Toast.makeText(MainActivity.this, "Successfully Logged in!", Toast.LENGTH_LONG).show();
                        Intent appListIntent = new Intent(MainActivity.this, ListActivity.class);
                        startActivity(appListIntent);

                    }
                    else {
                        Toast.makeText(MainActivity.this, "Failed to log in, please try again", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });


        final TextView regText = findViewById(R.id.registerText);
        regText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(regIntent);
            }
        });
    }

    public boolean validate() {
        boolean valid = true;

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

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
